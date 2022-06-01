package com.engeto.lekce12.repository;

import com.engeto.lekce12.entity.UcitelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// repository definuje databazi
public interface UcitelRepository extends CrudRepository<UcitelEntity,Long>{
    // Optional ..wraper, ktery pomuze s tím pokud je to null
    public Optional<UcitelEntity> findFirstByJmeno(String jmeno);
}
