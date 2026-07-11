package com.grinding.BankAccount_Api;
    
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @GetMapping("/api/welcome")
    public String welcome() {
        return "Welcome to the Grinding Bank API! The server is successfully running.";
    }
}

