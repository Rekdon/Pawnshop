package rek.oop.services.seller.impls;

import rek.oop.dao.seller.interfaces.IDaoSeller;
import rek.oop.model.seller.Seller;
import rek.oop.services.seller.interfaces.ISellerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public class SellerServiceImpl implements ISellerService {

    IDaoSeller daoSeller;

    public SellerServiceImpl() {
    }

    public SellerServiceImpl(IDaoSeller daoSeller) {
        this.daoSeller = daoSeller;
    }

    @Override
    public ArrayList<Seller> readAll() {
        return daoSeller.readAll();
    }

    public List<Seller> getAll() {
        return daoSeller.getAll();
    }

    public Seller getSeller(int id) {
        return daoSeller.getSeller(id);
    }

    public void createSeller(Seller seller) {
       daoSeller.createSeller(seller);
    }

    public void updateSeller(Seller seller) {
       daoSeller.updateSeller(seller);
    }

    public void deleteSeller(int id) {
       daoSeller.deleteSeller(id);
    }

    public void showAll() {
       daoSeller.showAll();
    }
}
