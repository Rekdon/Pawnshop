package rek.oop.model.check;

import rek.oop.model.client.Client;
import rek.oop.model.goods.Goods;
import rek.oop.model.seller.Seller;

/**
 * Created by Rekdon on 27.03.2017.
 */
public class Check {
    private int id;
    private Client client;
    private Seller seller;
    private Goods goods;

    public Check() {
    }



    public Check(int id, Client client, Seller seller, Goods goods) {
        this.id = id;
        this.client = client;
        this.seller = seller;
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", client=" + client +
                ", seller=" + seller +
                ", goods=" + goods +
                '}';
    }
}
