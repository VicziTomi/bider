package hu.flowacademy.bider.controller;

import hu.flowacademy.bider.domain.Product;
import hu.flowacademy.bider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/allproducts")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("/modify")
    public ResponseEntity<Product> mod(@RequestBody Product product) {
        return ResponseEntity.ok(productService.modProduct(product));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delProduct(id);
    }

    @DeleteMapping("valid-delete/{id}")
    public void validDelete(@PathVariable Long id) {
        productService.validDelete(id);
    }

}
