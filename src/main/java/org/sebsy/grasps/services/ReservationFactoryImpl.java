package org.sebsy.grasps.services;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationFactoryImpl {

    public Reservation creerReservation(LocalDateTime dateReservation, int nbPlaces, Client client, double total) {
        Reservation reservation = new Reservation(dateReservation);
        reservation.setNbPlaces(nbPlaces);
        reservation.setClient(client);
        reservation.setTotal(total);
        return reservation;
    }
}
