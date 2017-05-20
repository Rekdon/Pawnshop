package rek.oop.services.client.impls;

import com.google.gson.Gson;
import org.junit.Test;
import rek.oop.controller.DaoClientImpl;
import rek.oop.model.client.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Rekdon on 13.05.2017.
 */
public class ClientServiceImplTest {
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

    @Test
    public void maxSallary() throws Exception {
        ClientServiceImpl clientService = new ClientServiceImpl();
        DaoClientImpl daoClient = new DaoClientImpl();
        int max;
        max=daoClient.readAll().get(0).getSalary();
        for(int i=1;i<daoClient.readAll().size();i++)
        {
            if(max<=daoClient.readAll().get(i).getSalary())
            {
                max =  daoClient.readAll().get(i).getSalary();
            }
        }
        assertEquals(max,clientService.maxSallary(daoClient.readAll()));
    }

    @Test
    public void minSallary() throws Exception {
        ClientServiceImpl clientService = new ClientServiceImpl();
        DaoClientImpl daoClient = new DaoClientImpl();
        int min;
        min=daoClient.readAll().get(0).getSalary();
        for(int i=1;i<daoClient.readAll().size();i++)
        {
            if(min>daoClient.readAll().get(i).getSalary())
            {
                min = daoClient.readAll().get(i).getSalary();
            }
        }
        assertEquals(min,clientService.minSallary(daoClient.readAll()));
       // assertEquals(min,clientService.minSallary(daoClient.readAll()));
    }

    @Test
    public void numbersClient() throws Exception {
        ClientServiceImpl clientService = new ClientServiceImpl();
        DaoClientImpl daoClient = new DaoClientImpl();
        assertEquals(daoClient.readAll().size(),clientService.numbersClient(daoClient.readAll()));
    }

    @Test
    public void nameClientSallaryMore10000() throws Exception {
        String result="";
        ClientServiceImpl clientService = new ClientServiceImpl();
        DaoClientImpl daoClient = new DaoClientImpl();
        for (int i = 0; i < daoClient.readAll().size(); i++) {
            if (daoClient.readAll().get(i).getSalary()>10000)
            {
                result=daoClient.readAll().get(i).getFullname();
            }
        }
        assertEquals(result,clientService.nameClientSallaryMore10000(daoClient.readAll()));
    }

    @Test
    public void nameClientSallaryLess10000() throws Exception {
        String result="";
        ClientServiceImpl clientService = new ClientServiceImpl();
        DaoClientImpl daoClient = new DaoClientImpl();
        for (int i = 0; i < daoClient.readAll().size(); i++) {
            if (daoClient.readAll().get(i).getSalary()<10000)
            {
                result=daoClient.readAll().get(i).getFullname();
            }
        }
        assertEquals(result,clientService.nameClientSallaryLess10000(daoClient.readAll()));
    }

}