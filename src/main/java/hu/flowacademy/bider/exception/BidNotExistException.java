package hu.flowacademy.bider.exception;

public class BidNotExistException extends RuntimeException {
    public BidNotExistException() {
        super("Bid does not exists!");
    }
}
