package rek.oop.dao.check.impls;

import com.google.gson.Gson;
import org.junit.Test;
import rek.oop.dao.client.impls.DaoClientImpl;
import rek.oop.dao.goods.impls.DaoGoodsImpl;
import rek.oop.dao.seller.impls.DaoSellerImpl;
import rek.oop.model.check.Check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Rekdon on 15.05.2017.
 */
public class DaoCheckImplTest {
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
        String str1=gson.toJson(list);
        String str2=gson.toJson(checkDao.readAll());

        // CheckServiceImpl checkService = new CheckServiceImpl();
        assertEquals(str1,str2);
    }
}