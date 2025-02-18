package com.sprintbook.repository;

import com.sprintbook.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerModel, UUID> {
}
