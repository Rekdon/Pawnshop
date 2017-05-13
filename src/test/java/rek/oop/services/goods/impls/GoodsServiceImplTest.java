package rek.oop.services.goods.impls;

import com.google.gson.Gson;
import org.junit.Test;
import rek.oop.dao.client.impls.DaoClientImpl;
import rek.oop.dao.goods.impls.DaoGoodsImpl;
import rek.oop.model.goods.Goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rekdon on 13.05.2017.
 */
public class GoodsServiceImplTest {
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

    @Test
    public void maxPrice() throws Exception {
        DaoGoodsImpl goods = new DaoGoodsImpl();
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        int max;
        max = goods.readAll().get(0).getFirstPrice();
        for(int i = 0;i<goods.readAll().size();i++)
        {
            if(max<goods.readAll().get(i).getFirstPrice())
            {
                max=goods.readAll().get(i).getFirstPrice();
            }
        }
       assertEquals(max,goodsService.maxPrice(goods.readAll()));
    }

    @Test
    public void minPrice() throws Exception {
        DaoGoodsImpl goods = new DaoGoodsImpl();
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        int min;
        min = goods.readAll().get(0).getFirstPrice();
        for(int i = 0;i<goods.readAll().size();i++)
        {
            if(min>goods.readAll().get(i).getFirstPrice())
            {
                min=goods.readAll().get(i).getFirstPrice();
            }
        }
        assertEquals(min,goodsService.minPrice(goods.readAll()));
    }

    @Test
    public void numberOfGoods() throws Exception {
        DaoGoodsImpl goods = new DaoGoodsImpl();
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        assertEquals(goods.readAll().size(),goodsService.numberOfGoods(goods.readAll()));
    }

    @Test
    public void sumGoods() throws Exception {
        DaoGoodsImpl goods = new DaoGoodsImpl();
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        int sum=0;
        for(int i=0;i<goods.readAll().size();i++)
        {
            sum+=goods.readAll().get(i).getFirstPrice();
        }
       assertEquals(sum,goodsService.sumGoods(goods.readAll()));
    }

    @Test
    public void nameGoodsPriceMore10000() throws Exception {
        DaoGoodsImpl goods = new DaoGoodsImpl();
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        String result="";
        for (int i = 0; i < goods.readAll().size(); i++) {
            if (goods.readAll().get(i).getFirstPrice()<=10000)
            {
                result=goods.readAll().get(i).getNameGoods();
            }
        }
        assertEquals(result,goodsService.nameGoodsPriceMore10000(goods.readAll()));
    }

}