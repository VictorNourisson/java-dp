package org.sebsy.grasps.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateReservationParserImpl {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public LocalDateTime parse(String dateReservation) {
        return LocalDateTime.parse(dateReservation, formatter);
    }
}
