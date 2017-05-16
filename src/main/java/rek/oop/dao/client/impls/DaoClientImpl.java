package rek.oop.dao.client.impls;

import rek.oop.dao.client.interfaces.IDaoClient;
import rek.oop.model.check.Check;
import rek.oop.model.client.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public class DaoClientImpl implements IDaoClient {

    public ArrayList<Client> clients = new ArrayList<Client>();

    public ArrayList<Client> getChecks() {
        return clients;
    }

    public void setChecks(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public DaoClientImpl(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public DaoClientImpl() throws SQLException {
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
            clients.add(client);
        }
        co.close();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    @Override
    public ArrayList<Client> readAll()  {
            return this.clients;
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
