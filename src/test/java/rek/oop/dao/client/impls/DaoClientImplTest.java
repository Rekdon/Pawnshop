package rek.oop.dao.client.impls;

import com.google.gson.Gson;
import org.junit.Test;
import rek.oop.controller.DaoCheckImpl;
import rek.oop.controller.DaoClientImpl;
import rek.oop.model.check.Check;
import rek.oop.model.client.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Rekdon on 15.05.2017.
 */
public class DaoClientImplTest {

    @Test
    public void getAll() throws Exception {
        DaoClientImpl daoCheck = new DaoClientImpl();
        int count = daoCheck.readAll().size();
        assertEquals(daoCheck.getAll().size(), count);
    }

    @Test
    public void getClient() throws Exception {
        DaoClientImpl daoClient = new DaoClientImpl();
        Client result = null;
        for (Client client : daoClient.readAll()) {
            if (client.getId() == 2) {
                result = new Client();
            }
        }
        Gson gson = new Gson();
        String str1 = gson.toJson(result);
        String str2 = gson.toJson(daoClient.getClient(2));
        assertEquals(str1,str2);

    }

    @Test
    public void createClient() throws Exception {
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Client> clients2 = new ArrayList<>();
        Client check = new Client();
        Client check2 = new Client();
        DaoClientImpl daocheck = new DaoClientImpl();
        clients=daocheck.readAll();
        clients.add(check);

        daocheck.createClient(check2);
        daocheck.getAll();
        clients2=daocheck.getAll();

        clients.add(check);

        daocheck.createClient(check2);
        assertEquals(clients2.size(),clients.size());
    }

    @Test
    public void deleteClient() throws Exception {
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Client> clients2 = new ArrayList<>();
        Client client = new Client();
        Client client2 = new Client();
        DaoClientImpl daoclient = new DaoClientImpl();
        clients=daoclient.readAll();
        clients.remove(daoclient.readAll().size()-1);

        clients2=daoclient.getAll();
        daoclient.deleteClient(clients2.size());


        clients.add(client);

        daoclient.createClient(client2);
        assertEquals(clients2.size(),clients.size());
    }

    @Test
    public void readAll() throws Exception {
        ArrayList<Client> clientArrayList = new ArrayList<>();
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

        DaoClientImpl client = new DaoClientImpl();
        Gson gson = new Gson();
        String str1=gson.toJson(clientArrayList);
        String str2=gson.toJson(client.readAll());

        assertEquals(str1,str2);

    }
}