package rek.oop.dao.seller.interfaces;

import rek.oop.model.seller.Seller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public interface IDaoSeller {
    public ArrayList<Seller> readAll();
    List<Seller> getAll();
    Seller getSeller(int id);
    void createSeller(Seller seller);
    void updateSeller(Seller seller);
    void deleteSeller(int id);
    void showAll();
}
