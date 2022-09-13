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

import super_market.models.Category;
import super_market.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    CategoryRepository data;

    @GetMapping
    public ArrayList<Category> getAll(){
        return (ArrayList<Category>) data.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Category> searchForId(@PathVariable("id") Integer id ){
        return data.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category){
        return data.save(category);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id ){
        data.deleteById(id);
    }
}
