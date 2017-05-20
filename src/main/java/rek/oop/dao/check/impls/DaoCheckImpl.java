package rek.oop.dao.check.impls;

import org.springframework.stereotype.Service;
import rek.oop.dao.check.interfaces.IDaoCheck;
import rek.oop.controller.DaoClientImpl;
import rek.oop.controller.DaoGoodsImpl;
import rek.oop.controller.DaoSellerImpl;
import rek.oop.model.check.Check;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Rekdon on 01.04.2017.
 */
@Service
public class DaoCheckImpl implements IDaoCheck {

    public ArrayList<Check> checks = new ArrayList<Check>();

    public ArrayList<Check> getChecks() {
        return checks;
    }

    public void setChecks(ArrayList<Check> checks) {
        this.checks = checks;
    }

    public DaoCheckImpl() throws SQLException {
        Connection co = null;
        co = DriverManager.getConnection("jdbc:sqlite:PawnShop.db");
        Statement statement = co.createStatement();
        String query = "SELECT * FROM Checks";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            int client_id = rs.getInt("client_id");
            int seller_id = rs.getInt("seller_id");
            int goods_id = rs.getInt("goods_id");
            DaoGoodsImpl goodsDao = new DaoGoodsImpl();
            DaoClientImpl clientDao = new DaoClientImpl();
            DaoSellerImpl sellersDao = new DaoSellerImpl();
            Check check = new Check(id, clientDao.readAll().get(client_id - 1), sellersDao.readAll().get(seller_id - 1), goodsDao.readAll().get(goods_id - 1));
            this.checks.add(check);
        }
        co.close();

    }

    public DaoCheckImpl(ArrayList<Check> checks) {
        this.checks = checks;
    }


    @Override
    public ArrayList<Check> readAll() {
        return this.checks;
    }


    public ArrayList<Check> getAll() {
            return checks;
    }

    public Check getCheck(int id) {
        Check result = null;
        for (Check check : checks) {
            if (check.getId() == id) {
                result = new Check();
            }
        }
        return result;
    }

    public void createCheck(Check check) {
        checks.add(check);
    }

    public void updateCheck(Check check) {
        Check updateCheck = null;
        for (Check check1 : checks) {
            if (check1.getId() == check.getId()) {
                updateCheck = check1;
                break;
            }
        }
        updateCheck = check;
    }

    public void deleteCheck(int id) {
        int i = 0;
        boolean is = false;
        for (Check check : checks) {
            if (check.getId() == id) {
                is = true;
                break;
            }
            i++;
        }
        if (is) {
            checks.remove(i);
        }
    }

    public void showAll() {
        for (Check check : checks) {
            System.out.println(check.toString());
        }
    }
}
