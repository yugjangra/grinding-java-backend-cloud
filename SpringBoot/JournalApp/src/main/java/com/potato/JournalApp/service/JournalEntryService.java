package com.potato.JournalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.potato.JournalApp.entity.*;
import com.potato.JournalApp.repository.JournalEntryRepo;

@Component
public class JournalEntryService {
    // controller --> service --> repository
    @Autowired
    public JournalEntryRepo JournalEntryRepo;

    public void saveEntry (JournalEntry JournalEntry){
        JournalEntryRepo.save(JournalEntry);

    }
}
