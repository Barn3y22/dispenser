package com.example.Dispenser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.Dispenser.model.Denoms;

//Repository for Denoms

@Repository
public interface DispenserRepository extends JpaRepository<Denoms, Long> {

}
