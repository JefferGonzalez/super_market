package super_market.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import super_market.models.Product;
import super_market.repository.ProductRepository;

@RestController()
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    ProductRepository data;

    @GetMapping
    public ArrayList<Product> getAll(){
        return (ArrayList<Product>) data.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> searchForId(@PathVariable("id") Integer id ){
        return data.findById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product  product){
        return data.save(product);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id ){
        data.deleteById(id);
    }
    
}
