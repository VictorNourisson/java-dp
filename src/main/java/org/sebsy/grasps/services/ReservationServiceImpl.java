package org.sebsy.grasps.services;

import org.sebsy.grasps.Params;
import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.TypeReservationDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationServiceImpl {

    private ClientDao clientDao = new ClientDao();

    private TypeReservationDao typeReservationDao = new TypeReservationDao();

    private DateReservationParserImpl dateReservationParser = new DateReservationParserImpl();

    private TarifReservationServiceImpl tarifReservationService = new TarifReservationServiceImpl();

    private ReservationFactoryImpl reservationFactory = new ReservationFactoryImpl();

    public Reservation creerReservation(Params params) {
        Client client = clientDao.extraireClient(params.getIdentifiantClient());
        TypeReservation typeReservation = typeReservationDao.extraireTypeReservation(params.getTypeReservation());
        LocalDateTime dateReservation = dateReservationParser.parse(params.getDateReservation());
        double total = tarifReservationService.calculerTotal(typeReservation, client, params.getNbPlaces());

        Reservation reservation = reservationFactory.creerReservation(dateReservation, params.getNbPlaces(), client, total);
        client.getReservations().add(reservation);
        return reservation;
    }
}
