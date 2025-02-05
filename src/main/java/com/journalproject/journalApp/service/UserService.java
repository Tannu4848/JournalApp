package com.journalproject.journalApp.service;

import com.journalproject.journalApp.Entity.JournalEntry;
import com.journalproject.journalApp.Entity.User;
import com.journalproject.journalApp.repository.JournalEntryRepository;
import com.journalproject.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    //for Creating
    public void save(User user) {
        userRepository.save(user);
    }

    // for fetching all
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // for fetching by id
    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);

    }

    // for deleting by Id

    public void delete(ObjectId id) {
        userRepository.deleteById(id);

    }

public User findByUserName( String userName)
{

    return userRepository.findByUserName(userName);

}


}
