package rek.oop.dao.goods.impls;

import com.google.gson.Gson;
import org.junit.Test;
import rek.oop.controller.DaoGoodsImpl;
import rek.oop.model.goods.Goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Rekdon on 15.05.2017.
 */
public class DaoGoodsImplTest {
    @Test
    public void readAll() throws Exception {
        ArrayList<Goods> goodsArrayList = new ArrayList<>();
        Connection co = DriverManager.getConnection("jdbc:sqlite:PawnShop.db");
        Statement statement = co.createStatement();
        String query = "SELECT * FROM Goods";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            int id = rs.getInt("id");
            int codeGoods = rs.getInt("codeGoods");
            String nameGoods = rs.getString("nameGoods");
            int firstPrice = rs.getInt("firstPrice");
            String goodsDescriprion = rs.getString("goodsDescription");
            Goods goods = new Goods(id, codeGoods, nameGoods, firstPrice, goodsDescriprion);
            goodsArrayList.add(goods);
        }
        DaoGoodsImpl goods = new DaoGoodsImpl();
        Gson gson = new Gson();
        String str1=gson.toJson(goodsArrayList);
        String str2=gson.toJson(goods.readAll());

        assertEquals(str1,str2);
    }

}