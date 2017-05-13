package rek.oop.services.goods.impls;

import rek.oop.dao.goods.interfaces.IDaoGoods;
import rek.oop.model.goods.Goods;
import rek.oop.services.goods.interfaces.IGoodsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public class GoodsServiceImpl implements IGoodsService {

    IDaoGoods daoGoods;

    public GoodsServiceImpl() {
    }

    public GoodsServiceImpl(IDaoGoods daoGoods) {
        this.daoGoods = daoGoods;
    }

    public IDaoGoods getDaoGoods() {
        return daoGoods;
    }

    public void setDaoGoods(IDaoGoods daoGoods) {
        this.daoGoods = daoGoods;
    }

    @Override
    public ArrayList<Goods> readAll() {
        return daoGoods.readAll();
    }

    @Override
    public int maxPrice(ArrayList<Goods> goodses) {
        int max;
        max = goodses.get(0).getFirstPrice();
        for(int i = 0;i<goodses.size();i++)
        {
            if(max<goodses.get(i).getFirstPrice())
            {
                max=goodses.get(i).getFirstPrice();
            }
        }
        return max;
    }

    @Override
    public int minPrice(ArrayList<Goods> goodses) {
        int min;
        min = goodses.get(0).getFirstPrice();
        for(int i = 0;i<goodses.size();i++)
        {
            if(min>goodses.get(i).getFirstPrice())
            {
                min=goodses.get(i).getFirstPrice();
            }
        }
        return min;
    }

    @Override
    public int numberOfGoods(ArrayList<Goods> goodses) {
        return goodses.size();
    }

    @Override
    public int sumGoods(ArrayList<Goods> goodses) {
        int sum=0;
        for(int i=0;i<goodses.size();i++)
        {
            sum+=goodses.get(i).getFirstPrice();
        }
        return sum;
    }

    @Override
    public String nameGoodsPriceMore10000(ArrayList<Goods> goodses) {
        String result="";
        for (int i = 0; i < goodses.size(); i++) {
            if (goodses.get(i).getFirstPrice()<=10000)
            {
                result=goodses.get(i).getNameGoods();
            }
        }
        return result;
    }

    public List<Goods> getAll() {
        return daoGoods.getAll();
    }

    public Goods getGoods(int id) {
        return daoGoods.getGoods(id);
    }

    public void createGoods(Goods goods) {
       daoGoods.createGoods(goods);
    }

    public void updateGoods(Goods goods) {
       daoGoods.updateGoods(goods);
    }

    public void deleteGoods(int id) {
       daoGoods.deleteGoods(id);
    }

    public void showAll() {
      daoGoods.showAll();
    }
}
