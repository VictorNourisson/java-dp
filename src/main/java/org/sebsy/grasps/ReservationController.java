package org.sebsy.grasps;

import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.services.ReservationServiceImpl;
import org.springframework.stereotype.Controller;

/**
 * Controlleur qui prend en charge la gestion des réservations client
 */
@Controller
public class ReservationController {

    private ReservationServiceImpl reservationService = new ReservationServiceImpl();

    /**
     * Méthode qui créée une réservation pour un client à partir des informations transmises
     *
     * @param params contient toutes les infos permettant de créer une réservation
     * @return Reservation
     */
    public Reservation creerReservation(Params params) {
        return reservationService.creerReservation(params);
    }
}
