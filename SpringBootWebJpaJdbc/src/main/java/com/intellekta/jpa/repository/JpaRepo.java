package com.intellekta.jpa.repository;

import com.intellekta.jpa.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jpa")
public interface JpaRepo extends JpaRepository<SalesEntity, Long> {

//    @Query(nativeQuery = true, value = "")
//    Optional<SalesEntity> findByPrice(Integer price);
}
