package super_market.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import super_market.models.Product;
import super_market.models.Sale;
import super_market.repository.ProductRepository;
import super_market.repository.SaleRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/sales")
public class SaleController {
    
    @Autowired
    SaleRepository data;
    @Autowired
    ProductRepository product_data;

    @GetMapping
    public ArrayList<Sale> getAll(){
        return (ArrayList<Sale>) data.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Sale> getMethodName(@PathVariable("id") Integer id) {
        return data.findById(id);
    }
    
    @PostMapping
    public Sale save(@RequestBody Sale sale){
        Product product = sale.getProduct();
        sale.setDate(new Date());
        sale.setValue(product.getPrice()*product.getQuantity());

        Optional<Product> tmp_product = product_data.findById(product.getId());
        if(tmp_product != null) {
            Product new_product = tmp_product.get();
            new_product.setQuantity(new_product.getQuantity()-product.getQuantity());
            product_data.save(new_product);
        }
        return data.save(sale);
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Integer id){
        data.deleteById(id);
    }

}
