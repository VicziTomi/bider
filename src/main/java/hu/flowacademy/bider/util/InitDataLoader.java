package hu.flowacademy.bider.util;

import hu.flowacademy.bider.domain.Bid;
import hu.flowacademy.bider.domain.Product;
import hu.flowacademy.bider.repository.BidRepository;
import hu.flowacademy.bider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class InitDataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BidRepository bidRepository;

    @Override
    public void run(String... args) throws Exception {

/*
        Product p1 = new Product("USB lavalamp", "kacat", 2990, LocalDate.of(19, Month.MAY, 27), LocalDate.of(19, 6, 27));
        Product p2 = new Product("Rdr2", "games", 15990, LocalDate.of(19, Month.MAY, 25), LocalDate.of(19, Month.JUNE, 10));

        productRepository.save(p1);
        productRepository.save(p2);

        Bid b1 = new Bid(16500, "Kell aza Rdr2", LocalDate.of(19, Month.MAY, 27), p2);
        Bid b2 = new Bid(17000, "Nekem is kell!", LocalDate.of(19, Month.MAY, 28), p2);

        bidRepository.save(b1);
        bidRepository.save(b2);


 */
    }
}
