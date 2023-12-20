package com.example.server.Repositories;

import com.example.server.Models.Ledger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface LedgerRepository extends JpaRepository <Ledger, Integer>{
    Ledger findById(int id);
}
