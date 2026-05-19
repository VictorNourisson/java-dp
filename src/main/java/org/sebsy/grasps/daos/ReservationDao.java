package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class ReservationDao implements ReservationRepository {

    @Override
    public Reservation creerReservation(LocalDateTime dateReservation, int nbPlaces, Client client, double total) {
        Reservation reservation = new Reservation(dateReservation);
        reservation.setNbPlaces(nbPlaces);
        reservation.setClient(client);
        reservation.setTotal(total);
        client.getReservations().add(reservation);
        return reservation;
    }
}
