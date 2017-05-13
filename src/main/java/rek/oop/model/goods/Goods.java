package rek.oop.model.goods;

import rek.oop.model.client.Client;
import rek.oop.model.seller.Seller;

/**
 * Created by Rekdon on 27.03.2017.
 */
public class Goods {
    private int id;
    private int codeGoods;
    private String nameGoods;
    private int firstPrice;
    private String goodsDescription;

    public Goods() {
    }

    public Goods(int id, int codeGoods, String nameGoods, int firstPrice, String goodsDescription) {
        this.id = id;
        this.codeGoods = codeGoods;
        this.nameGoods = nameGoods;
        this.firstPrice = firstPrice;
        this.goodsDescription = goodsDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodeGoods() {
        return codeGoods;
    }

    public void setCodeGoods(int codeGoods) {
        this.codeGoods = codeGoods;
    }

    public String getNameGoods() {
        return nameGoods;
    }

    public void setNameGoods(String nameGoods) {
        this.nameGoods = nameGoods;
    }

    public int getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(int firstPrice) {
        this.firstPrice = firstPrice;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", codeGoods=" + codeGoods +
                ", nameGoods='" + nameGoods + '\'' +
                ", firstPrice=" + firstPrice +
                ", goodsDescription='" + goodsDescription + '\'' +
                '}';
    }
    public double sum(int firstPrice)
    {
        double allSum = (firstPrice/2) - (firstPrice*0.2);
        return allSum;
    }
}
