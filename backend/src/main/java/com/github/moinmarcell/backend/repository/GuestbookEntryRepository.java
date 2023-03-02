package com.github.moinmarcell.backend.repository;

import com.github.moinmarcell.backend.model.GuestbookEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestbookEntryRepository extends MongoRepository<GuestbookEntry, String> {
}
