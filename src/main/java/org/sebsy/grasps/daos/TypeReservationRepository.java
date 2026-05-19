package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.TypeReservation;

public interface TypeReservationRepository {

    TypeReservation extraireTypeReservation(String type);
}
