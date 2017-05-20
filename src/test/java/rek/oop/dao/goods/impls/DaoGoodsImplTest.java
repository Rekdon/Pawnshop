package rek.oop.dao.goods.impls;

import com.google.gson.Gson;
import org.junit.Test;
import rek.oop.controller.DaoClientImpl;
import rek.oop.controller.DaoGoodsImpl;
import rek.oop.model.check.Check;
import rek.oop.model.client.Client;
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
    public void getAll() throws Exception {
        DaoGoodsImpl dao = new DaoGoodsImpl();
        int count = dao.readAll().size();
        assertEquals(dao.getAll().size(), count);
    }

    @Test
    public void getGoods() throws Exception {
        DaoGoodsImpl dao = new DaoGoodsImpl();
        Goods result = null;
        for (Goods goods : dao.readAll()) {
            if (goods.getId() == 2) {
                result = new Goods();
            }
        }
        Gson gson = new Gson();
        String str1 = gson.toJson(result);
        String str2 = gson.toJson(dao.getGoods(2));
        assertEquals(str1,str2);

    }

    @Test
    public void createGoods() throws Exception {
        ArrayList<Goods> goodses = new ArrayList<>();
        ArrayList<Goods> goodses2 = new ArrayList<>();
        Goods goods = new Goods();
        Goods goods2 = new Goods();
        DaoGoodsImpl daogoods = new DaoGoodsImpl();
        goodses=daogoods.readAll();
        goodses.add(goods);

        daogoods.createGoods(goods2);
        daogoods.getAll();
        goodses2=daogoods.getAll();

        goodses.add(goods);

        daogoods.createGoods(goods2);
        assertEquals(goodses2.size(),goodses.size());
    }


    @Test
    public void deleteGoods() throws Exception {
        ArrayList<Goods> goodses = new ArrayList<>();
        ArrayList<Goods> goodses2 = new ArrayList<>();
        Goods goods = new Goods();
        Goods goods2 = new Goods();
        DaoGoodsImpl daogoods = new DaoGoodsImpl();
        goodses=daogoods.readAll();
        goodses.remove(daogoods.readAll().size()-1);

        goodses2=daogoods.getAll();
        daogoods.deleteGoods(goodses2.size());


        goodses.add(goods);

        daogoods.createGoods(goods2);
        assertEquals(goodses2.size(),goodses.size());
    }

    @Test
    public void readAll() throws Exception {
        ArrayList<Goods> goodsArrayLists = new ArrayList<>();
        Connection co = DriverManager.getConnection("jdbc:sqlite:PawnShop.db");
        Statement statement = co.createStatement();
        String query =  " SELECT * FROM Goods";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
             int id = rs.getInt ("id");
            int codeGoods = rs.getInt("codeGoods");
            String nameGoods = rs.getString("nameGoods");
            int firstPrice = rs.getInt("firstPrice");
            String goodsDescriprion = rs.getString("goodsDescription");
            Goods goods = new Goods(id, codeGoods, nameGoods, firstPrice, goodsDescriprion);
            goodsArrayLists.add(goods);
        }
        DaoGoodsImpl goods = new DaoGoodsImpl();
        Gson gson = new Gson();
        String str1=gson.toJson(goodsArrayLists);
        String str2=gson.toJson(goods.readAll());

        assertEquals(str1,str2);
    }

}