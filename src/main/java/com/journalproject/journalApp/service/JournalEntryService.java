package com.journalproject.journalApp.service;

import com.journalproject.journalApp.Entity.JournalEntry;
import com.journalproject.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {


    @Autowired
    JournalEntryRepository journalEntryRepository;

    //for Creating
    public void save(JournalEntry journalEntry)
    {

        journalEntryRepository.save(journalEntry);
    }

// for fetching all
    public List<JournalEntry> getAll()
    {

      return   journalEntryRepository.findAll();

    }

// for fetching by id
    public Optional<JournalEntry> findById(ObjectId id)
    {

       return journalEntryRepository.findById(id);

    }

    // for deleting

    public void delete(ObjectId id)
    {
        journalEntryRepository.deleteById(id);

    }


}
