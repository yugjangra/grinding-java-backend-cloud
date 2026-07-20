package com.potato.JournalApp.controller;
import com.potato.JournalApp.entity.JournalEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {
    private Map<String, JournalEntry> journalentries = new HashMap<>();

@GetMapping
public List<JournalEntry> getAll() {
    return new ArrayList<>(journalentries.values());
}

@PostMapping
public String createEntry(@RequestBody JournalEntry entry1){
    journalentries.get(entry1); 
    return "got it";

}
@GetMapping("id/{myid}")
public JournalEntry getmyentriesusingid(@PathVariable Long myid){
    return journalentries.get(myid);

}
@DeleteMapping("id/{myid}")
public JournalEntry deletemyentriesusingid(@PathVariable Long myid){
   return journalentries.remove(myid);
}
@PutMapping("id/{myid}")
public JournalEntry editentry(@PathVariable String myid, @RequestBody JournalEntry entry1){
    return journalentries.put(myid, entry1);
}
}