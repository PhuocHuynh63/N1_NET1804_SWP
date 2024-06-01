package com.n3.mebe.repository;

import com.n3.mebe.entity.ProductSkus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductSkuRepository extends JpaRepository<ProductSkus,Integer> {
}
