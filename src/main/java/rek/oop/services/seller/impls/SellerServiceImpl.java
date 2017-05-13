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

    @Override
    public int maxSallary(ArrayList<Seller> sellers) {
        int max=sellers.get(0).getSallary();
        for (int i=1;i<sellers.size();i++)
        {
            if(max<sellers.get(i).getSallary())
            {
                max=sellers.get(i).getSallary();
            }
        }
        return max;
    }

    @Override
    public int minSallary(ArrayList<Seller> sellers) {
        int min=sellers.get(0).getSallary();
        for (int i=1;i<sellers.size();i++)
        {
            if(min>sellers.get(i).getSallary())
            {
                min=sellers.get(i).getSallary();
            }
        }
        return min;
    }

    @Override
    public int numberOfSellers(ArrayList<Seller> sellers) {
        return sellers.size();
    }

    @Override
    public int maxWorkExperience(ArrayList<Seller> sellers) {
        int max=sellers.get(0).getWorkExperience();
        for(int i = 0;i<sellers.size();i++)
        {
            if(max<sellers.get(i).getWorkExperience())
            {
                max = sellers.get(i).getWorkExperience();
            }
        }
        return max;
    }

    @Override
    public int minWorkExperience(ArrayList<Seller> sellers) {
        int min=sellers.get(0).getWorkExperience();
        for(int i = 0;i<sellers.size();i++)
        {
            if(min>sellers.get(i).getWorkExperience())
            {
                min = sellers.get(i).getWorkExperience();
            }
        }
        return min;
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
