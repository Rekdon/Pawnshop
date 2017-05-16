package rek.oop.services.client.interfaces;

import rek.oop.model.client.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public interface IClientService {
    ArrayList<Client> readAll() throws SQLException;
    List<Client> getAll();
    int maxSallary(ArrayList<Client> client);
    int minSallary(ArrayList<Client> client) throws IndexOutOfBoundsException;
    int numbersClient(ArrayList<Client> client);
    String nameClientSallaryMore10000(ArrayList<Client> client);
    String nameClientSallaryLess10000(ArrayList<Client> client);
    Client getClient(int id);
    void createClient(Client client);
    void updateClient(Client client);
    void deleteClient(int id);
    void showAll();
}
