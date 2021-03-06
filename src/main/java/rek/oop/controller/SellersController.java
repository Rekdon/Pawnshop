package rek.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rek.oop.model.goods.Goods;
import rek.oop.model.seller.Seller;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Rekdon on 20.05.2017.
 */
@RestController
public class SellersController {

    @Autowired
    private DaoSellerImpl service;


    @RequestMapping("/api/sellers")
    public ArrayList<Seller> goods() throws SQLException {
        return service.getAll();
    }
}
