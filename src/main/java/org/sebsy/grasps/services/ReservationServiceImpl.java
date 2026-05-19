package org.sebsy.grasps.services;

import org.sebsy.grasps.Params;
import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.ClientRepository;
import org.sebsy.grasps.daos.TypeReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ClientRepository clientRepository;

    private TypeReservationRepository typeReservationRepository;

    private DateReservationParser dateReservationParser;

    private TarifReservationService tarifReservationService;

    private ReservationFactory reservationFactory;

    @Autowired
    public ReservationServiceImpl(ClientRepository clientRepository,
                                  TypeReservationRepository typeReservationRepository,
                                  DateReservationParser dateReservationParser,
                                  TarifReservationService tarifReservationService,
                                  ReservationFactory reservationFactory) {
        this.clientRepository = clientRepository;
        this.typeReservationRepository = typeReservationRepository;
        this.dateReservationParser = dateReservationParser;
        this.tarifReservationService = tarifReservationService;
        this.reservationFactory = reservationFactory;
    }

    @Override
    public Reservation creerReservation(Params params) {
        Client client = clientRepository.extraireClient(params.getIdentifiantClient());
        TypeReservation typeReservation = typeReservationRepository.extraireTypeReservation(params.getTypeReservation());
        LocalDateTime dateReservation = dateReservationParser.parse(params.getDateReservation());
        double total = tarifReservationService.calculerTotal(typeReservation, client, params.getNbPlaces());

        Reservation reservation = reservationFactory.creerReservation(dateReservation, params.getNbPlaces(), client, total);
        client.getReservations().add(reservation);
        return reservation;
    }
}
