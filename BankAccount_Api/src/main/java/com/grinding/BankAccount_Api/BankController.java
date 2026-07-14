package com.grinding.BankAccount_Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grinding.BankAccount_Api.BankAccount.SavingsAccount;

@RestController
public class BankController {
    SavingsAccount Account = new SavingsAccount(500.0);

    @GetMapping("/api/BANKING_SYSTEM")
    public String welcome() {
        return "Welcome to the Bank API! The server is successfully running.";
    }

    @GetMapping("/api/balance")
    public BankAccount getAccountDetails(){
        return Account;
    }

    @GetMapping("/api/deposit")
    public BankAccount bankdeposit(@RequestParam double amount){
        Account.deposit(amount);
        return Account;
    }

    @GetMapping("/api/withdraw")
    public BankAccount bankwiwthdraw(@RequestParam double amount){
        Account.withdraw(amount);
        return Account;
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleExceptions(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

