package org.sebsy.grasps.services;

import java.time.LocalDateTime;

public interface DateReservationParser {

    LocalDateTime parse(String dateReservation);
}
