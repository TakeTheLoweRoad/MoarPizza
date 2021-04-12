package Premo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Premo.Model.Product;
import Premo.Service.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
 

    // display list of products
    @GetMapping("/products")
    public String viewProductHomePage(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        // create model attribute to bind form data
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        // save product to database
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/showProductFormForUpdate/{productid}")
    public String showFormForUpdate(@PathVariable(value = "productid") long productid, Model model) {

        // get product from the service
        Product product = productService.getProductById(productid);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("product", product);
        return "update_product";
    }

    @GetMapping("/deleteProduct/{productid}")
    public String deleteProduct(@PathVariable(value = "productid") long productid) {

        // call delete product method 
        this.productService.deleteProductById(productid);
        return "redirect:/products";
    }
}
