package com.journalproject.journalApp.controller;

import com.journalproject.journalApp.Entity.JournalEntry;
import com.journalproject.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

@Autowired
 private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){

        return journalEntryService.getAll();
         }


@PostMapping
public Boolean  create(@RequestBody JournalEntry myentry){

    myentry.setDate(LocalDateTime.now());
    journalEntryService.save(myentry);
    return true;
}



@GetMapping("id/{myId}")
public JournalEntry getJournalById(@PathVariable ObjectId myId)
{
    return  journalEntryService.findById(myId).orElse(null);


}

@DeleteMapping("id/{myId}")
public boolean deleteJournalById(@PathVariable ObjectId myId)
{
    journalEntryService.delete(myId);
    return true;
}

@PutMapping("id/{myId}")
public JournalEntry updateJournalById(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry )
{
    JournalEntry old = journalEntryService.findById(myId).orElse(null);

    if (old != null)
    {
        old.setName(myEntry.getName()!=null && !myEntry.getName().equals("") ? myEntry.getName() : old.getName());

    }


    journalEntryService.save(old);


    return old;

}

}
