package com.banker.BankAPI.controller;

import com.banker.BankAPI.exception.ResourceNotFoundException;
import com.banker.BankAPI.model.Bank;
import com.banker.BankAPI.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {
    @Autowired
    private BankRepository bankRepository;

    @GetMapping
    public List<Bank> getAllBanks(){
        return this.bankRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bank getBankById(@PathVariable (value = "id") long bankId){
        return this.bankRepository.findById(bankId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found with id: " + bankId));
    }

    @GetMapping("/filter/{compensation}")
    public Bank getBankByName(@PathVariable (value = "compensation") String bankCompensation){
         List<Bank> list = this.bankRepository.findAll();

        for (Bank bank: list) {
            if (bank.getCompensationCode().equals(bankCompensation)){
                return bank;
            }
        }

         return null;
    }

    @PostMapping
    public Bank createBank(@RequestBody Bank bank){
        return this.bankRepository.save(bank);
    }

    @PutMapping("/{id}")
    public Bank updateBank(@RequestBody Bank bank, @PathVariable (value = "id") long bankId){
        Bank newBank = this.bankRepository.findById(bankId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found with id: " + bankId));

        newBank.setCompensationCode(bank.getCompensationCode());
        newBank.setName(bank.getName());

        return this.bankRepository.save(newBank);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bank> deleteBank(@PathVariable (value = "id") long bankId){
        Bank newBank = this.bankRepository.findById(bankId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found with id: " + bankId));
        this.bankRepository.delete((newBank));
        return ResponseEntity.ok().build();
    }

}
