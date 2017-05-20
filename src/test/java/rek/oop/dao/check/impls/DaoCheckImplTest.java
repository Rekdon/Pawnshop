package rek.oop.dao.check.impls;

import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import rek.oop.controller.DaoCheckImpl;
import rek.oop.controller.DaoClientImpl;
import rek.oop.controller.DaoGoodsImpl;
import rek.oop.controller.DaoSellerImpl;
import rek.oop.model.check.Check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rekdon on 15.05.2017.
 */
public class DaoCheckImplTest {
    @Autowired
    public ArrayList<Check> checks = new ArrayList<Check>();

    @Test
    public void getAll() throws Exception {
        DaoCheckImpl daoCheck = new DaoCheckImpl();
        int count = daoCheck.readAll().size();
        assertEquals(daoCheck.getAll().size(), count);
    }

    @Test
    public void getCheck() throws Exception {
        DaoCheckImpl daoCheck = new DaoCheckImpl();
        Check result = null;
        for (Check check : daoCheck.readAll()) {
            if (check.getId() == 2) {
                result = new Check();
            }
        }
        Gson gson = new Gson();
        String str1 = gson.toJson(result);
        String str2 = gson.toJson(daoCheck.getCheck(2));
        assertEquals(str1,str2);

    }

    @Test
    public void createCheck() throws Exception {
        ArrayList<Check> checks = new ArrayList<>();
        ArrayList<Check> checks2 = new ArrayList<>();
        Check check = new Check();
        Check check2 = new Check();
        DaoCheckImpl daocheck = new DaoCheckImpl();
        checks=daocheck.readAll();
        checks.add(check);

        daocheck.createCheck(check2);
        daocheck.getAll();
        checks2=daocheck.getAll();

        checks.add(check);

        daocheck.createCheck(check2);
        assertEquals(checks2.size(),checks.size());
    }

  /*  @Test
    public void updateCheck() throws Exception {
        Check check = new Check();
        DaoCheckImpl daoCheck = new DaoCheckImpl();
        Check updateCheck = null;
        for (Check check1 : daoCheck.readAll()) {
            if (check1.getId() == 3) {
                updateCheck = check1;
                break;
            }
        }
        updateCheck = check;
        assertEquals(check,daoCheck.updateCheck(check));
    }*/

    @Test
    public void deleteCheck() throws Exception {
        ArrayList<Check> checks = new ArrayList<>();
        ArrayList<Check> checks2 = new ArrayList<>();
        Check check = new Check();
        Check check2 = new Check();
        DaoCheckImpl daocheck = new DaoCheckImpl();
        checks=daocheck.readAll();
        checks.remove(daocheck.readAll().size()-1);

        checks2=daocheck.getAll();
        daocheck.deleteCheck(checks2.size());


        checks.add(check);

        daocheck.createCheck(check2);
        assertEquals(checks2.size(),checks.size());
    }

 /*   @Test
    public void showAll() throws Exception {
        DaoCheckImpl daoCheck = new DaoCheckImpl();
        String result="";
        for (Check check : daoCheck.readAll()) {
            result+=check.toString();
        }
        String result2 = daoCheck.showAll();
        assertEquals(daoCheck.showAll(),result);
    }*/

    @Test
    public void readAll() throws Exception {
        ArrayList<Check> list = new ArrayList<>();
        Connection co = DriverManager.getConnection("jdbc:sqlite:PawnShop.db");
        Statement statement = co.createStatement();
        String query = "SELECT * FROM Checks";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            int client_id = rs.getInt("client_id");
            int seller_id = rs.getInt("seller_id");
            int goods_id = rs.getInt("goods_id");
            DaoGoodsImpl goodsDao = new DaoGoodsImpl();
            DaoClientImpl clientDao = new DaoClientImpl();
            DaoSellerImpl sellersDao = new DaoSellerImpl();
            Check check = new Check(id, clientDao.readAll().get(client_id - 1), sellersDao.readAll().get(seller_id - 1), goodsDao.readAll().get(goods_id - 1));
            list.add(check);
        }

        DaoCheckImpl checkDao = new DaoCheckImpl();
        Gson gson = new Gson();
        String str1 = gson.toJson(list);
        String str2 = gson.toJson(checkDao.readAll());

        assertEquals(str1, str2);
    }
}