package rek.oop.services.goods.interfaces;

import rek.oop.model.client.Client;
import rek.oop.model.goods.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public interface IGoodsService {
    ArrayList<Goods> readAll();
    int maxPrice(ArrayList<Goods> goodses);
    int minPrice(ArrayList<Goods> goodses);
    int numberOfGoods(ArrayList<Goods> goodses);
    int sumGoods(ArrayList<Goods> goodses);
    String nameGoodsPriceMore10000(ArrayList<Goods> goodses);
    List<Goods> getAll();
    Goods getGoods(int id);
    void createGoods(Goods goods);
    void updateGoods(Goods goods);
    void deleteGoods(int id);
    void showAll();
}
