package com.potato.JournalApp.controller;
import com.potato.JournalApp.entity.JournalEntry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<List<JournalEntry>> getAll() {
    List<JournalEntry>journalEntry = JournalEntryService.getAll();
    if(journalEntry != null && !journalEntry.equals("")){
        return new ResponseEntity<>(journalEntry, HttpStatus.OK); 
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@PostMapping
public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry1){
    if(entry1 != null && !entry1.equals("")){
    try{
    entry1.setDate(LocalDateTime.now());
    JournalEntryService.saveEntry(entry1);
    
    return new ResponseEntity<>(entry1, HttpStatus.CREATED);
    }
    catch(Exception e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }}
    else{
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
    }

}
@GetMapping("id/{myid}")
public ResponseEntity<JournalEntry> getmyentriesusingid(@PathVariable ObjectId myid){
   Optional<JournalEntry> journalEntry=JournalEntryService.findbyId(myid);
   if(journalEntry.isPresent()){
    return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
   }else{
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }


}
@DeleteMapping("id/{myid}")
public ResponseEntity<?> deletemyentriesusingid(@PathVariable ObjectId myid){
   JournalEntryService.deletebyId(myid);
   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   
}
@PutMapping("id/{myid}")
public ResponseEntity<JournalEntry> editentry(@PathVariable ObjectId myid, @RequestBody JournalEntry newentry1){
    
    JournalEntry oldentry = JournalEntryService.findbyId(myid).orElse(null);
    if(oldentry != null){
        oldentry.setTitle(newentry1.getTitle() != null && !newentry1.getTitle().equals("") ? newentry1.getTitle() : oldentry.getTitle());
        oldentry.setContent(newentry1.getContent() != null && !newentry1.getContent().equals("") ? newentry1.getContent() : oldentry.getContent());
        JournalEntryService.saveEntry(oldentry);
         return new ResponseEntity<>(oldentry, HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
}