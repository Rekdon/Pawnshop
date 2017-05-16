package rek.oop.services.client.impls;

import rek.oop.dao.client.interfaces.IDaoClient;
import rek.oop.model.client.Client;
import rek.oop.services.client.interfaces.IClientService;

import java.sql.SQLException;
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
    public ArrayList<Client> readAll() throws SQLException {
        return daoClient.readAll();
    }

    public List<Client> getAll() {
        return daoClient.getAll();
    }

    @Override
    public int maxSallary(ArrayList<Client> client) {
        int max;
        max=client.get(0).getSalary();
        for(int i=1;i<client.size();i++)
        {
            if(max<=client.get(i).getSalary())
            {
             max = client.get(i).getSalary();
            }
        }
        return max;
    }

    @Override
    public int minSallary(ArrayList<Client> client) {
        int min;
        min=client.get(0).getSalary();
        for(int i=1;i<client.size();i++)
        {
            if(min>client.get(i).getSalary())
            {
                min = client.get(i).getSalary();
            }
        }
        return min;
    }

    @Override
    public int numbersClient(ArrayList<Client> client) {
        return client.size();
    }

    @Override
    public String nameClientSallaryMore10000(ArrayList<Client> client) {
        String result="";
        for (int i = 0; i < client.size(); i++) {
            if (client.get(i).getSalary()>10000)
            {
                result=client.get(i).getFullname();
            }
        }
        return result;
    }

    @Override
    public String nameClientSallaryLess10000(ArrayList<Client> client) {
        String result="";
        for (int i = 0; i < client.size(); i++) {
            if (client.get(i).getSalary()<=10000)
            {
                result=client.get(i).getFullname();
            }
        }
        return result;
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
