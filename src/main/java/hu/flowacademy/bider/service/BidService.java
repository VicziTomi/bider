package hu.flowacademy.bider.service;

import hu.flowacademy.bider.domain.Bid;
import hu.flowacademy.bider.domain.Product;
import hu.flowacademy.bider.exception.BidAmountException;
import hu.flowacademy.bider.exception.BidClosedException;
import hu.flowacademy.bider.exception.BidNotExistException;
import hu.flowacademy.bider.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired ProductService productService;

    public Bid addBid(Bid bid) {
        return bidRepository.save(bid);
    }

    public Bid getBid(Long id) {
        return bidRepository.getOne(id);
    }

    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    public Bid modBid(Bid bid) {
        if (bidRepository.getOne(bid.getId()) != null) {
            return bidRepository.save(bid);
        }
        throw new BidNotExistException();
    }

    public void delBid(Long id) {
        bidRepository.deleteById(id);
    }

    public Bid makeBidToProduct(Long productId, Bid bid) {
        Product product = productService.getProduct(productId);
        bid.setProduct(product);
        if (product.getBidEnd().isBefore(bid.getBidDate())) {
            throw new BidClosedException();
        }
        if (product.getMinPrice() > bid.getBidPrice()) {
            throw new BidAmountException();
        }
        return bidRepository.save(bid);
    }

    public List<Bid> listBidsinOrder(Long productId) {
        return bidRepository.findAllByProduct_idOrderByBidPrice(productId);
    }
}
