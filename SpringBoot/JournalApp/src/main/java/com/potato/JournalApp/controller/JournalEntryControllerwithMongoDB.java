package com.potato.JournalApp.controller;
import com.potato.JournalApp.entity.JournalEntry;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.potato.JournalApp.service.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerwithMongoDB {

@Autowired
public JournalEntryService JournalEntryService;

@GetMapping
public List<JournalEntry> getAll() {
    return JournalEntryService.getAll();
}

@PostMapping
public JournalEntry createEntry(@RequestBody JournalEntry entry1){
    entry1.setDate(LocalDateTime.now());
    JournalEntryService.saveEntry(entry1);
    return entry1;

}
@GetMapping("id/{myid}")
public JournalEntry getmyentriesusingid(@PathVariable ObjectId myid){
   return JournalEntryService.findbyId(myid).orElse(null);

}
@DeleteMapping("id/{myid}")
public Boolean deletemyentriesusingid(@PathVariable ObjectId myid){
   JournalEntryService.deletebyId(myid);
   return true;
   
}
@PutMapping("id/{myid}")
public JournalEntry editentry(@PathVariable ObjectId myid, @RequestBody JournalEntry newentry1){
    
    JournalEntry oldentry = JournalEntryService.findbyId(myid).orElse(null);
    if(oldentry != null){
        oldentry.setTitle(newentry1.getTitle() != null && !newentry1.getTitle().equals("") ? newentry1.getTitle() : oldentry.getTitle());
        oldentry.setContent(newentry1.getContent() != null && !newentry1.getContent().equals("") ? newentry1.getContent() : oldentry.getContent());
    }
    JournalEntryService.saveEntry(oldentry);
    return oldentry;
}
}