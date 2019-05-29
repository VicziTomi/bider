package hu.flowacademy.bider.repository;

import hu.flowacademy.bider.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {

    List<Bid> findAllByProduct_id(Long id);

    List<Bid> findAllByProduct_idOrderByBidPrice(Long id);

}
