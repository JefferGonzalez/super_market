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

import super_market.models.User;
import super_market.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserRepository data;

    @GetMapping
    public ArrayList<User> getAll(){
        return (ArrayList<User>) data.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> searchForId(@PathVariable("id") Integer id){
        return data.findById(id);
    }

    @PostMapping
    public User save(@RequestBody User user){
        return data.save(user);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Integer id){
        data.deleteById(id);
    }
    
}
