package rek.oop.dao.check.interfaces;

import rek.oop.model.check.Check;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public interface IDaoCheck {
    ArrayList<Check> readAll();
    String read() throws SQLException ;
    List<Check> getAll();
    Check getCheck(int id);
    void createCheck(Check check);
    void updateCheck(Check check);
    void deleteCheck(int id);
    void showAll();
}
