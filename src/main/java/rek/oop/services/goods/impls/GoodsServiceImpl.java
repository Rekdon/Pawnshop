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
