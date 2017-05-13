package rek.oop.services.check.interfaces;

import rek.oop.model.check.Check;
import rek.oop.model.seller.Seller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */
public interface ICheckService {
    List<Check> getAll();
    double sumAll(ArrayList<Check> checks);
    String BestSallaryOfDay(ArrayList<Check> checks);
    int idBigMoney(ArrayList<Check> checks);
    double salaryRichestClient(ArrayList<Check> checks);
    String infoOfBestClient(ArrayList<Check> checks);

     ArrayList<Check> readAll();
    Check getCheck(int id);
    void createCheck(Check check);
    void updateCheck(Check check);
    void deleteCheck(int id);
    void showAll();
}
