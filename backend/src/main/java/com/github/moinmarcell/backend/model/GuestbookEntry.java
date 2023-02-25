package com.github.moinmarcell.backend.model;

import java.time.ZonedDateTime;

public record GuestbookEntry(
        String id,
        String title,
        String content,
        ZonedDateTime dateTime,
        String author
) {
}
