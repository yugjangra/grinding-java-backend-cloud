package com.potato.JournalApp.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.potato.JournalApp.entity.*;
import com.potato.JournalApp.repository.JournalEntryRepo;

@Component
public class JournalEntryService {
    // controller --> service --> repository
    @Autowired
    public JournalEntryRepo JournalEntryRepo;

    
    public void saveEntry(JournalEntry JournalEntry){
        JournalEntryRepo.save(JournalEntry);
    }

    public List<JournalEntry> getAll(){
        return JournalEntryRepo.findAll();
    }
    
    public Optional<JournalEntry> findbyId(ObjectId Id){
        return JournalEntryRepo.findById(Id);
    }

    public void deletebyId(ObjectId Id){
         JournalEntryRepo.deleteById(Id);
    }

}