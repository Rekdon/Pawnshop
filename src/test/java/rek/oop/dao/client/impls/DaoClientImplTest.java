package rek.oop.dao.client.impls;

import com.google.gson.Gson;
import org.junit.Test;
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