package org.sebsy.grasps.services;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;

import java.time.LocalDateTime;

public interface ReservationFactory {

    Reservation creerReservation(LocalDateTime dateReservation, int nbPlaces, Client client, double total);
}
