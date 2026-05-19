package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.Client;

public interface ClientRepository {

    Client extraireClient(String id);
}
