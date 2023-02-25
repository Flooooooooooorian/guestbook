package com.github.moinmarcell.backend.repository;

import com.github.moinmarcell.backend.model.GuestbookEntry;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class GuestbookEntryRepository {

    private final Map<String, GuestbookEntry> guestbookEntries;

    public GuestbookEntryRepository(Map<String, GuestbookEntry> guestbookEntries) {
        this.guestbookEntries = guestbookEntries;
    }

    public Map<String, GuestbookEntry> getGuestbookEntries() {
        return guestbookEntries;
    }

    public GuestbookEntry addGuestbookEntry(GuestbookEntry guestbookEntryToAdd){
        guestbookEntries.put(guestbookEntryToAdd.id(), guestbookEntryToAdd);
        return guestbookEntries.get(guestbookEntryToAdd.id());
    }

    public GuestbookEntry updateGuestbookEntry(GuestbookEntry guestbookEntryToUpdate){
        guestbookEntries.replace(guestbookEntryToUpdate.id(), guestbookEntryToUpdate);
        return guestbookEntries.get(guestbookEntryToUpdate.id());
    }
}
