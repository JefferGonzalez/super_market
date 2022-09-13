package super_market.repository;

import org.springframework.data.repository.CrudRepository;

import super_market.models.Brand;

public interface BrandRepository extends CrudRepository<Brand, Integer>{
    
}
