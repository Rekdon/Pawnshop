package rek.oop.dao.client.impls;

import rek.oop.dao.client.interfaces.IDaoClient;
import rek.oop.model.check.Check;
import rek.oop.model.client.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public class DaoClientImpl implements IDaoClient {

    public List<Client> clients = new ArrayList<Client>();

    public List<Client> getChecks() {
        return clients;
    }

    public void setChecks(List<Client> clients) {
        this.clients = clients;
    }

    public DaoClientImpl(List<Client> clients) {
        this.clients = clients;
    }

    public DaoClientImpl() {
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public ArrayList<Client> readAll() {
        ArrayList<Client> clientArrayList = new ArrayList<>();
        try {
            Connection co = DriverManager.getConnection("jdbc:sqlite:PawnShop.db");
            Statement statement = co.createStatement();
            String query = "SELECT * FROM Client";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                int sallary = rs.getInt("sallary");
                String fullName = rs.getString("fullName");
                String dataOfBirth = rs.getString("dataOfBirth");
                String placeOfBirth = rs.getString("placeOfBirth");
                String sex = rs.getString("sex");
                int identificationCode = rs.getInt("identificationCode");
                Client client = new Client(id,sallary,fullName,dataOfBirth,placeOfBirth,sex,identificationCode);
                clientArrayList.add(client);
            }
           // co.close();
         //   statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clientArrayList;
    }

    public List<Client> getAll() {
        return clients;
    }

    public Client getClient(int id) {
        Client result = null;
        for (Client client: clients) {
            if (client.getId() == id){
                result = new Client();
            }
        }
        return result;
    }

    public void createClient(Client client) {
        clients.add(client);
    }

    public void updateClient(Client client) {
        Client updateClient = null;
        for (Client client1 : clients) {
            if (client1.getId() == client.getId()) {
                updateClient = client1;
                break;
            }
        }
        updateClient = client;
    }

    public void deleteClient(int id) {
        int i = 0;
        boolean is = false;
        for (Client client : clients) {
            if (client.getId() == id) {
                is = true;
                break;
            }
            i++;
        }
        if (is){clients.remove(i);}
    }

    public void showAll() {
        for (Client client: clients) {
            System.out.println(client.toString());
        }
    }
}
