package hu.flowacademy.bider.exception;

public class BidAmountException extends RuntimeException {
    public BidAmountException() {
        super("Given amount is less then bid starter");
    }
}
