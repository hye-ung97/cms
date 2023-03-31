package com.example.cms.user.domain.repository;

import com.example.cms.user.domain.model.Customer;
import com.example.cms.user.domain.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByIdAndEmail(Long id, String email);
    Optional<Seller> findByEmail(String email);
    Optional<Seller> findByEmailAndPasswordAndVerifyIsTrue(String email, String password);



}
