package com.github.moinmarcell.backend.service;

import com.github.moinmarcell.backend.model.GuestbookEntry;
import com.github.moinmarcell.backend.repository.GuestbookEntryRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GuestBookEntryService {

    private final GuestbookEntryRepository guestbookEntryRepository;
    private final IdService idService;

    public GuestBookEntryService(GuestbookEntryRepository guestbookEntryRepository, IdService idService) {
        this.guestbookEntryRepository = guestbookEntryRepository;
        this.idService = idService;
    }

    public List<GuestbookEntry> getAllGuestbookEntries(){
        return new ArrayList<>(guestbookEntryRepository.getGuestbookEntries().values());
    }

    public GuestbookEntry addGuestbookEntry(GuestbookEntry guestbookEntryToAdd){
        return guestbookEntryRepository.addGuestbookEntry(new GuestbookEntry(
                idService.generateId(),
                guestbookEntryToAdd.title(),
                guestbookEntryToAdd.content(),
                ZonedDateTime.now(),
                guestbookEntryToAdd.author()
        ));
    }

    public GuestbookEntry updateGuestbookEntry(GuestbookEntry guestbookEntryToUpdate){
        return guestbookEntryRepository.updateGuestbookEntry(guestbookEntryToUpdate);
    }

}
