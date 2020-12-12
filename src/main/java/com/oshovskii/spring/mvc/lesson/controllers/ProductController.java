package com.oshovskii.spring.mvc.lesson.controllers;

import com.oshovskii.spring.mvc.lesson.model.Product;
import com.oshovskii.spring.mvc.lesson.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "all_products";
    }

    @GetMapping("/remove/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/all";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/all";
    }

    @GetMapping("/findById")
    public String findProductById(Model model, @PathVariable Long id) {
        model.addAttribute("frontFindByIdProducts", productService.findById(id));
        return "find_Product_By_Id";
    }
}
