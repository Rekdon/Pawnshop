package rek.oop.dao.seller.impls;

import rek.oop.dao.seller.interfaces.IDaoSeller;
import rek.oop.model.goods.Goods;
import rek.oop.model.seller.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public class DaoSellerImpl implements IDaoSeller {

    ArrayList <Seller> sellers = new ArrayList<Seller>();

    public DaoSellerImpl() throws SQLException {
            Connection co = DriverManager.getConnection("jdbc:sqlite:PawnShop.db");
            Statement statement = co.createStatement();
            String query = "SELECT * FROM Sellers";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("fullname");
                int sallary = rs.getInt("sallary");
                int workExperience = rs.getInt("workExperience");
                Seller seller = new Seller(id, fullname, sallary, workExperience);
                sellers.add(seller);
            }
            co.close();

    }

    public DaoSellerImpl(ArrayList<Seller> sellers) {
        this.sellers = sellers;
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(ArrayList<Seller> sellers) {
        this.sellers = sellers;
    }

    @Override
    public ArrayList<Seller> readAll() {
       return this.sellers;
    }

    public List<Seller> getAll() {
        return sellers;
    }

    public Seller getSeller(int id) {
        Seller result = null;
        for (Seller seller: sellers) {
            if (seller.getId() == id){
                result = new Seller();
            }
        }
        return result;
    }

    public void createSeller(Seller seller) {
       sellers.add(seller);
    }

    public void updateSeller(Seller seller) {
        Seller updateSeller = null;
        for (Seller seller1 : sellers) {
            if (seller1.getId() == seller.getId()) {
                updateSeller = seller1;
                break;
            }
        }
        updateSeller = seller;
    }

    public void deleteSeller(int id) {
        int i = 0;
        boolean is = false;
        for (Seller seller : sellers) {
            if (seller.getId() == id) {
                is = true;
                break;
            }
            i++;
        }
        if (is){sellers.remove(i);}
    }

    public void showAll() {
      for(Seller seller : sellers)
      {
          System.out.println(seller.toString());
      }
    }
}
