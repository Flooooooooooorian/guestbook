package com.github.moinmarcell.backend.controller;

import com.github.moinmarcell.backend.model.GuestbookEntry;
import com.github.moinmarcell.backend.service.GuestBookEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guestbook-entries")
public class GuestbookEntryController {

    GuestBookEntryService service;

    public GuestbookEntryController(GuestBookEntryService service) {
        this.service = service;
    }

    @GetMapping
    public List<GuestbookEntry> allGuestbookEntries(){
        return service.getAllGuestbookEntries();
    }

    @PostMapping
    public GuestbookEntry addEntry(@RequestBody GuestbookEntry guestbookEntryToAdd){
        return service.addGuestbookEntry(guestbookEntryToAdd);
    }

    @PutMapping("/{id}")
    public GuestbookEntry updateEntry(@PathVariable String id, @RequestBody GuestbookEntry guestbookEntryToUpdate){
        return service.updateGuestbookEntry(guestbookEntryToUpdate);
    }
}
