package com.example.testcontainerssimple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.testcontainerssimple.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}