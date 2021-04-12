package Premo.Service;

import java.util.List;

import Premo.Model.Product;

public interface ProductService {
    List < Product > getAllProducts();
    void saveProduct(Product product);
    Product getProductById(long id);
    void deleteProductById(long id);

}    
