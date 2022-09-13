package super_market.repository;

import org.springframework.data.repository.CrudRepository;

import super_market.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
    
}
