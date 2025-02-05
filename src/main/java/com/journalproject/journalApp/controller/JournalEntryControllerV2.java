package com.journalproject.journalApp.controller;

import com.journalproject.journalApp.Entity.JournalEntry;
import com.journalproject.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

@Autowired
 private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){

        return journalEntryService.getAll();
         }


/*@PostMapping
public Boolean  create(@RequestBody JournalEntry myentry){

    myentry.setDate(LocalDateTime.now());
    journalEntryService.save(myentry);
    return true;
}*/

@PostMapping
public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myentry)
{
  try {
      myentry.setDate(LocalDateTime.now());
      journalEntryService.save(myentry);
      return new ResponseEntity<>( myentry,HttpStatus.CREATED);
  } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}




@GetMapping("id/{myId}")
public ResponseEntity<JournalEntry> getJournalById(@PathVariable ObjectId myId)
{
   // return  journalEntryService.findById(myId).orElse(null);
    Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);

    if(journalEntry.isPresent())
    {
        return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);

    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
