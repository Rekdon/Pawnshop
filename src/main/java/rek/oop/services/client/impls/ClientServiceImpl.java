package rek.oop.services.client.impls;

import rek.oop.dao.client.interfaces.IDaoClient;
import rek.oop.model.client.Client;
import rek.oop.services.client.interfaces.IClientService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public class ClientServiceImpl implements IClientService {

    IDaoClient daoClient;

    public ClientServiceImpl() {
    }

    public ClientServiceImpl(IDaoClient daoClient) {
        this.daoClient = daoClient;
    }

    public IDaoClient getDaoClient() {
        return daoClient;
    }

    public void setDaoClient(IDaoClient daoClient) {
        this.daoClient = daoClient;
    }


    @Override
    public ArrayList<Client> readAll() {
        return daoClient.readAll();
    }

    public List<Client> getAll() {
        return daoClient.getAll();
    }

    public Client getClient(int id) {
        return daoClient.getClient(id);
    }

    public void createClient(Client client) {
        daoClient.createClient(client);
    }

    public void updateClient(Client client) {
        daoClient.updateClient(client);
    }

    public void deleteClient(int id) {
       daoClient.deleteClient(id);
    }

    public void showAll() {
       daoClient.showAll();
    }
}
