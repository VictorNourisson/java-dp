package org.sebsy.grasps.services;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.TypeReservation;

public interface TarifReservationService {

    double calculerTotal(TypeReservation typeReservation, Client client, int nbPlaces);
}
