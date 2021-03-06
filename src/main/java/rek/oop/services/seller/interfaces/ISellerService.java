package rek.oop.services.seller.interfaces;

import rek.oop.model.seller.Seller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public interface ISellerService {
    public ArrayList<Seller> readAll();
    int maxSallary(ArrayList<Seller> sellers);
    int minSallary(ArrayList<Seller> sellers);
    int numberOfSellers(ArrayList<Seller> sellers);
    int maxWorkExperience(ArrayList<Seller> sellers);
    int minWorkExperience(ArrayList<Seller> sellers);
    List<Seller> getAll();
    Seller getSeller(int id);
    void createSeller(Seller seller);
    void updateSeller(Seller seller);
    void deleteSeller(int id);
    void showAll();
}
