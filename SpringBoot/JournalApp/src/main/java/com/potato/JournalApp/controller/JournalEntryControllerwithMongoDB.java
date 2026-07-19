package com.potato.JournalApp.controller;
import com.potato.JournalApp.entity.JournalEntry;

import java.util.List;

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
    return null;
}

@PostMapping
public Boolean createEntry(@RequestBody JournalEntry entry1){
    JournalEntryService.saveEntry(entry1);
    return true;

}
@GetMapping("id/{myid}")
public JournalEntry getmyentriesusingid(@PathVariable Long myid){
    return null;

}
@DeleteMapping("id/{myid}")
public JournalEntry deletemyentriesusingid(@PathVariable Long myid){
   return null;
}
@PutMapping("id/{myid}")
public JournalEntry editentry(@PathVariable long myid, @RequestBody JournalEntry entry1){
    return null;
}
}