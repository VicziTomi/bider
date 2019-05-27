package hu.flowacademy.bider.service;

import hu.flowacademy.bider.domain.Bid;
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
        if (bidRepository.findById(id).isPresent()) {
            bidRepository.deleteById(id);
        }
        throw new BidNotExistException();
    }
}
