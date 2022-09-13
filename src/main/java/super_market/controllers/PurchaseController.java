package super_market.controllers;

import java.util.ArrayList;
import java.util.Date;
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
import super_market.models.Purchase;
import super_market.repository.ProductRepository;
import super_market.repository.PurchaseRepository;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    
    @Autowired
    PurchaseRepository data;
    @Autowired
    ProductRepository product_data;

    @GetMapping
    public ArrayList<Purchase> getAll(){
        return (ArrayList<Purchase>) data.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Purchase> searchForId(@PathVariable("id") Integer id ){
        return data.findById(id);
    }

    @PostMapping
    public Purchase save(@RequestBody Purchase purchase){
        Product product = purchase.getProduct();
        purchase.setDate(new Date());
        purchase.setValue(product.getPrice()*product.getQuantity());

        Optional<Product> tmp_product = product_data.findById(product.getId());
        if(tmp_product != null) {
            Product new_product = tmp_product.get();
            new_product.setQuantity(new_product.getQuantity()+product.getQuantity());
            product_data.save(new_product);
        }

        return data.save(purchase);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id ){
        data.deleteById(id);
    }
    
}
