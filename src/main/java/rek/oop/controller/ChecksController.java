package rek.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rek.oop.model.check.Check;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Rekdon on 20.05.2017.
 */
@RestController
public class ChecksController {
    @Autowired
    private DaoCheckImpl service;


    @RequestMapping("/api/checks")
    public ArrayList<Check> goods() throws SQLException {
        return service.getAll();
    }
}
