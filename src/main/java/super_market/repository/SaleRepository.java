package super_market.repository;

import org.springframework.data.repository.CrudRepository;

import super_market.models.Sale;

public interface SaleRepository extends CrudRepository<Sale, Integer>{
    
}
