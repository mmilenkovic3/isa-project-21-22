package com.example.isa212.Repositories;

import com.example.isa212.Model.DeleteAccountRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeleteAccountRequestRepository extends JpaRepository<DeleteAccountRequest, Integer> {
    List<DeleteAccountRequest> findAll();

}
