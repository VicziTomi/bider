package hu.flowacademy.bider.service;

import hu.flowacademy.bider.domain.Bid;
import hu.flowacademy.bider.domain.Product;
import hu.flowacademy.bider.exception.ProductDeleteError;
import hu.flowacademy.bider.exception.ProductNotExistException;
import hu.flowacademy.bider.repository.BidRepository;
import hu.flowacademy.bider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BidRepository bidRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(Long id) {
        return productRepository.getOne(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product modProduct(Product product) {
        if (productRepository.getOne(product.getId()) != null) {
            return productRepository.save(product);
        }
        throw new ProductNotExistException();
    }

    public void delProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void validDelete(Long id) {
        List<Bid> bids = bidRepository.findAllByProduct_id(id);
        if (bids.isEmpty()) {
            productRepository.deleteById(id);
        } else  {
            throw new ProductDeleteError();
        }
    }
}
