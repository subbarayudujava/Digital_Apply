package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.CustomerApplication;

@Repository
public interface CustomerApplicationRepository extends JpaRepository<CustomerApplication, Long> {

}
