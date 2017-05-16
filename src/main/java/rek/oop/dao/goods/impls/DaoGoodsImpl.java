package rek.oop.dao.goods.impls;

import rek.oop.dao.goods.interfaces.IDaoGoods;
import rek.oop.model.client.Client;
import rek.oop.model.goods.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public class DaoGoodsImpl implements IDaoGoods {

    ArrayList<Goods> goodses = new ArrayList<Goods>();

    public DaoGoodsImpl() throws SQLException {
            Connection co = DriverManager.getConnection("jdbc:sqlite:PawnShop.db");
            Statement statement = co.createStatement();
            String query = "SELECT * FROM Goods";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                int codeGoods = rs.getInt("codeGoods");
                String nameGoods = rs.getString("nameGoods");
                int firstPrice = rs.getInt("firstPrice");
                String goodsDescriprion = rs.getString("goodsDescription");
                Goods goods = new Goods(id, codeGoods, nameGoods, firstPrice, goodsDescriprion);
                goodses.add(goods);
            }
            co.close();
    }

    public DaoGoodsImpl(ArrayList<Goods> goodses) {
        this.goodses = goodses;
    }

    public ArrayList<Goods> getGoodses() {
        return goodses;
    }

    public void setGoodses(ArrayList<Goods> goodses) {
        this.goodses = goodses;
    }

    @Override
    public ArrayList<Goods> readAll() {

        return this.goodses;
    }

    public List<Goods> getAll() {
        return goodses;
    }

    public Goods getGoods(int id) {
        Goods result = null;
        for (Goods goods: goodses) {
            if (goods.getId() == id){
                result = new Goods();
            }
        }
        return result;
    }

    public void createGoods(Goods goods) {
       goodses.add(goods);
    }

    public void updateGoods(Goods goods) {
        Goods updateGoods = null;
        for ( Goods goods1 : goodses) {
            if (goods1.getId() == goods.getId()) {
                updateGoods = goods1;
                break;
            }
        }
        updateGoods = goods;
    }

    public void deleteGoods(int id) {
        int i = 0;
        boolean is = false;
        for (Goods goods : goodses) {
            if (goods.getId() == id) {
                is = true;
                break;
            }
            i++;
        }
        if (is){goodses.remove(i);}
    }

    public void showAll() {
       for(Goods goods:goodses)
       {
           System.out.println(goods.toString());
       }
    }
}
