package super_market.repository;

import org.springframework.data.repository.CrudRepository;

import super_market.models.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer>{
    
}
