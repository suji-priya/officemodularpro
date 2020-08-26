package com.acloudzyn.officemodularpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acloudzyn.officemodularpro.model.Manager;
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
