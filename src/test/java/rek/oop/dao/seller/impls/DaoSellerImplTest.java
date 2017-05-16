package rek.oop.dao.seller.impls;

import com.google.gson.Gson;
import org.junit.Test;
import rek.oop.model.seller.Seller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Rekdon on 15.05.2017.
 */
public class DaoSellerImplTest {
    @Test
    public void readAll() throws Exception {
        ArrayList<Seller> sellerArrayList = new ArrayList<>();

        Connection co = DriverManager.getConnection("jdbc:sqlite:PawnShop.db");
        Statement statement = co.createStatement();
        String query = "SELECT * FROM Sellers";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String fullname = rs.getString("fullname");
            int sallary = rs.getInt("sallary");
            int workExperience = rs.getInt("workExperience");
            Seller seller = new Seller(id, fullname, sallary, workExperience);
            sellerArrayList.add(seller);
        }
        DaoSellerImpl seller = new DaoSellerImpl();
        Gson gson = new Gson();
        String str1=gson.toJson(sellerArrayList);
        String str2=gson.toJson(seller.readAll());

        assertEquals(str1,str2);

    }

}