package hu.flowacademy.bider.exception;


public class ProductNotExistException extends RuntimeException {
    public ProductNotExistException() {
        super("Product does not exist!");
    }
}
