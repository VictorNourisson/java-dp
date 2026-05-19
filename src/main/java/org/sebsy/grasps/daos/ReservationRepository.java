package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;

import java.time.LocalDateTime;

public interface ReservationRepository {

    Reservation creerReservation(LocalDateTime dateReservation, int nbPlaces, Client client, double total);
}
