package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.pojos.Contractor;
@Repository
public interface ContractorRepo extends JpaRepository<Contractor, Integer>{

}
