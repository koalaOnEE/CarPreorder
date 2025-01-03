package com.bmw;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PreorderRepository extends JpaRepository<Preorder, Integer> {
    List<Preorder> findByCustomerEmail(String customerEmail);   // Fetch all preorders for a specific customer email
}