package com.oshovskii.spring.mvc.lesson.repositories;

import com.oshovskii.spring.mvc.lesson.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepository {
    private List<Product> products;



  /*  public List<Product> getProducts1() {
        return products;
    }*/

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, 1010, "american bobtail cat"));
        products.add(new Product(2L, 7020, "british shorthair cat"));
        products.add(new Product(3L, 3030, "persian cat"));
        products.add(new Product(4L, 4040, "norwegian forest cat"));
        products.add(new Product(5L, 5550, "savannah cat"));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }


    public void save(Product product) {
        if (product.getId() < 0 || product.getCost() < 0) {
            throw new IllegalArgumentException("bad product");
        }
        products.add(product);
    }

    public void deleteById(Long id) {
        products.removeIf(b -> b.getId().equals(id));
    }

    public Product findById(Long id) {
        for (Product product : getAllProducts()) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
