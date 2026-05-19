package org.sebsy.grasps;

import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.TypeReservationDao;
import org.sebsy.grasps.services.DateReservationParserImpl;
import org.sebsy.grasps.services.ReservationFactoryImpl;
import org.sebsy.grasps.services.ReservationServiceImpl;
import org.sebsy.grasps.services.TarifReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Controlleur qui prend en charge la gestion des réservations client
 */
@Controller
public class ReservationController {

    private ReservationServiceImpl reservationService;

    public ReservationController() {
        this(new ReservationServiceImpl(
                new ClientDao(),
                new TypeReservationDao(),
                new DateReservationParserImpl(),
                new TarifReservationServiceImpl(),
                new ReservationFactoryImpl()
        ));
    }

    @Autowired
    public ReservationController(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }

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
