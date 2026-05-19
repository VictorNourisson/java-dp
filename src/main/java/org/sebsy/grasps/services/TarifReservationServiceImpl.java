package org.sebsy.grasps.services;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.TypeReservation;
import org.springframework.stereotype.Service;

@Service
public class TarifReservationServiceImpl implements TarifReservationService {

    @Override
    public double calculerTotal(TypeReservation typeReservation, Client client, int nbPlaces) {
        double total = typeReservation.getMontant() * nbPlaces;
        if (client.isPremium()) {
            return total * (1 - typeReservation.getReductionPourcent() / 100.0);
        }
        return total;
    }
}
