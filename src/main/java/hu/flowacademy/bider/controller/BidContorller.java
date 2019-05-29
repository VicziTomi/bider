package hu.flowacademy.bider.controller;

import hu.flowacademy.bider.domain.Bid;
import hu.flowacademy.bider.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bid")
public class BidContorller {

    @Autowired
    private BidService bidService;

    @PostMapping("/add")
    public ResponseEntity<Bid> add(@RequestBody Bid bid) {
        return ResponseEntity.ok(bidService.addBid(bid));
    }

    @GetMapping("/bid/{id}")
    public ResponseEntity<Bid> get(@PathVariable Long id) {
        return ResponseEntity.ok(bidService.getBid(id));
    }

    @GetMapping("/allbids")
    public ResponseEntity<List<Bid>> getAll() {
        return ResponseEntity.ok(bidService.getAllBids());
    }

    @PutMapping("/modify")
    public ResponseEntity<Bid> mod(@RequestBody Bid bid) {
        return ResponseEntity.ok(bidService.modBid(bid));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        bidService.delBid(id);
    }

    @PostMapping("/place/{id}")
    public ResponseEntity<Bid> makeBidToProduct(@PathVariable Long id, @RequestBody Bid bid) {
        return ResponseEntity.ok(bidService.makeBidToProduct(id, bid));
    }

    @GetMapping("/ordered/{productId}")
    public  ResponseEntity<List<Bid>> listBidsinOrder(@PathVariable Long productId) {
        return ResponseEntity.ok(bidService.listBidsinOrder(productId));
    }
}
