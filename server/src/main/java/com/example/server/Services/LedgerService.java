package com.example.server.Services;

import com.example.server.Models.Ledger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LedgerService {

    private final List<Ledger> ledgerList = new ArrayList<>();

    public List<Ledger> getAllLedgers() {
        return ledgerList;
    }

    public Ledger getLedgerById(int id) {
        Optional<Ledger> optionalLedger = ledgerList.stream()
                .filter(ledger -> ledger.getId() == id)
                .findFirst();
        return optionalLedger.orElse(null);
    }

    public Ledger createLedger(Ledger ledger) {
        int nextId = ledgerList.isEmpty() ? 1 : ledgerList.get(ledgerList.size() - 1).getId() + 1;
        ledger.setId(nextId);
        ledgerList.add(ledger);
        return ledger;
    }

    public Ledger updateLedger(int id, Ledger updatedLedger) {
        for (int i = 0; i < ledgerList.size(); i++) {
            if (ledgerList.get(i).getId() == id) {
                updatedLedger.setId(id);
                ledgerList.set(i, updatedLedger);
                return updatedLedger;
            }
        }
        return null; // Ledger with the given ID not found
    }

    public void deleteLedger(int id) {
        ledgerList.removeIf(ledger -> ledger.getId() == id);
    }
}
