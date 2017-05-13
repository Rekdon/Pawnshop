package rek.oop.dao.goods.interfaces;

import rek.oop.model.goods.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public interface IDaoGoods {
    ArrayList<Goods> readAll();
    List<Goods> getAll();
    Goods getGoods(int id);
    void createGoods(Goods goods);
    void updateGoods(Goods goods);
    void deleteGoods(int id);
    void showAll();
}
