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

import super_market.models.Brand;
import super_market.repository.BrandRepository;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    BrandRepository data;

    @GetMapping
    public ArrayList<Brand> getAll(){
        return (ArrayList<Brand>) data.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Brand> searchForId(@PathVariable("id") Integer id ){
        return data.findById(id);
    }

    @PostMapping
    public Brand save(@RequestBody Brand brand){
        return data.save(brand);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id ){
        data.deleteById(id);
    }

}
