package rek.oop.dao.client.interfaces;

import rek.oop.model.check.Check;
import rek.oop.model.client.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public interface IDaoClient {
    ArrayList<Client> readAll();
    List<Client> getAll();
    Client getClient(int id);
    void createClient(Client client);
    void updateClient(Client client);
    void deleteClient(int id);
    void showAll();
}
