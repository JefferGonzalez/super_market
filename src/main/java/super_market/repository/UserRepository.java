package super_market.repository;

import org.springframework.data.repository.CrudRepository;

import super_market.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    
}
