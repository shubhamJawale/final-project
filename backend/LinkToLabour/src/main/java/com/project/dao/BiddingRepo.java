package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pojos.Bidding;

public interface BiddingRepo extends JpaRepository<Bidding, Integer> {

}
