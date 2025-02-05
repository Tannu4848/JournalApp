package com.journalproject.journalApp.repository;

import com.journalproject.journalApp.Entity.JournalEntry;
import com.journalproject.journalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

   User findByUserName(String userName);


}




