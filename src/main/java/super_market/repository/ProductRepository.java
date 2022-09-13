package super_market.repository;

import org.springframework.data.repository.CrudRepository;

import super_market.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
