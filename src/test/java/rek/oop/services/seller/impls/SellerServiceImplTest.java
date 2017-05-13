package rek.oop.services.seller.impls;

import com.google.gson.Gson;
import org.junit.Test;
import rek.oop.dao.goods.impls.DaoGoodsImpl;
import rek.oop.dao.seller.impls.DaoSellerImpl;
import rek.oop.model.seller.Seller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Rekdon on 13.05.2017.
 */
public class SellerServiceImplTest {
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

    @Test
    public void maxSallary() throws Exception {
        DaoSellerImpl seller = new DaoSellerImpl();
        SellerServiceImpl sellerService = new SellerServiceImpl();
        int max=seller.readAll().get(0).getSallary();
        for (int i=1;i<seller.readAll().size();i++)
        {
            if(max<seller.readAll().get(i).getSallary())
            {
                max=seller.readAll().get(i).getSallary();
            }
        }
        assertEquals(max,sellerService.maxSallary(seller.readAll()));
    }

    @Test
    public void minSallary() throws Exception {
        DaoSellerImpl seller = new DaoSellerImpl();
        SellerServiceImpl sellerService = new SellerServiceImpl();
        int min=seller.readAll().get(0).getSallary();
        for (int i=1;i<seller.readAll().size();i++)
        {
            if(min>seller.readAll().get(i).getSallary())
            {
                min=seller.readAll().get(i).getSallary();
            }
        }
        assertEquals(min,sellerService.minSallary(seller.readAll()));
    }

    @Test
    public void numberOfSellers() throws Exception {
        DaoSellerImpl seller = new DaoSellerImpl();
        SellerServiceImpl sellerService = new SellerServiceImpl();
        assertEquals(seller.readAll().size(),sellerService.numberOfSellers(seller.readAll()));
    }

    @Test
    public void maxWorkExperience() throws Exception {
        DaoSellerImpl seller = new DaoSellerImpl();
        SellerServiceImpl sellerService = new SellerServiceImpl();
        int max=seller.readAll().get(0).getWorkExperience();
        for(int i = 0;i<seller.readAll().size();i++)
        {
            if(max<seller.readAll().get(i).getWorkExperience())
            {
                max = seller.readAll().get(i).getWorkExperience();
            }
        }
        assertEquals(max,sellerService.maxWorkExperience(seller.readAll()));
    }

    @Test
    public void minWorkExperience() throws Exception {
        DaoSellerImpl seller = new DaoSellerImpl();
        SellerServiceImpl sellerService = new SellerServiceImpl();
        int min=seller.readAll().get(0).getWorkExperience();
        for(int i = 0;i<seller.readAll().size();i++)
        {
            if(min>seller.readAll().get(i).getWorkExperience())
            {
                min = seller.readAll().get(i).getWorkExperience();
            }
        }
        assertEquals(min,sellerService.minWorkExperience(seller.readAll()));
    }

}