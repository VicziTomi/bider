package hu.flowacademy.bider.exception;

public class ProductDeleteError extends RuntimeException {
    public ProductDeleteError() {
        super("Can not delete product due to existing bid(s)");
    }
}
