package rek.oop.dao.seller.impls;

import com.google.gson.Gson;
import org.junit.Test;
import rek.oop.controller.DaoGoodsImpl;
import rek.oop.controller.DaoSellerImpl;
import rek.oop.model.goods.Goods;
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
    public void getAll() throws Exception {
        DaoSellerImpl dao = new DaoSellerImpl();
        int count = dao.readAll().size();
        assertEquals(dao.getAll().size(), count);
    }

    @Test
    public void getGoods() throws Exception {
        DaoSellerImpl dao = new  DaoSellerImpl();
        Seller result = null;
        for (Seller seller : dao.readAll()) {
            if (seller.getId() == 2) {
                result = new Seller();
            }
        }
        Gson gson = new Gson();
        String str1 = gson.toJson(result);
        String str2 = gson.toJson(dao.getSeller(2));
        assertEquals(str1,str2);

    }

    @Test
    public void createGoods() throws Exception {
        ArrayList<Seller> sellers = new ArrayList<>();
        ArrayList<Seller> sellers2 = new ArrayList<>();
        Seller seller = new Seller();
        Seller seller2 = new Seller();
        DaoSellerImpl daoseller = new DaoSellerImpl();
        sellers=daoseller.readAll();
        sellers.add(seller);

        daoseller.createSeller(seller2);
        daoseller.getAll();
        sellers2=daoseller.getAll();

        sellers.add(seller);

        daoseller.createSeller(seller2);
        assertEquals(sellers2.size(),sellers.size());
    }


    @Test
    public void deleteGoods() throws Exception {
        ArrayList<Seller> sellers = new ArrayList<>();
        ArrayList<Seller> sellers2 = new ArrayList<>();
        Seller seller = new Seller();
        Seller seller2 = new Seller();
        DaoSellerImpl daoseller = new DaoSellerImpl();
        sellers=daoseller.readAll();
        sellers.remove(daoseller.readAll().size()-1);

        sellers2=daoseller.getAll();
        daoseller.deleteSeller(sellers2.size());


        sellers.add(seller);

        daoseller.createSeller(seller2);
        assertEquals(sellers2.size(),sellers.size());
    }

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