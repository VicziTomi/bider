package hu.flowacademy.bider.exception;

public class BidClosedException extends RuntimeException {
    public BidClosedException() {
        super("Bid closed for this product!");
    }
}
