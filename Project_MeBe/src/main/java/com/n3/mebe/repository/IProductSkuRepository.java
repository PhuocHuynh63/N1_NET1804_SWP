package com.n3.mebe.repository;

import com.n3.mebe.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductSkuRepository extends JpaRepository<Inventory,Integer> {
}
