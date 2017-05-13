package rek.oop.services.check.impls;

import rek.oop.dao.check.impls.DaoCheckImpl;
import rek.oop.dao.check.interfaces.IDaoCheck;
import rek.oop.model.check.Check;
import rek.oop.services.check.interfaces.ICheckService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rekdon on 01.04.2017.
 */


public class CheckServiceImpl implements ICheckService {

    DaoCheckImpl daoCheck;


    public CheckServiceImpl() {
    }

    public DaoCheckImpl getDaoCheck() {
        return daoCheck;
    }

    public void setDaoCheck(DaoCheckImpl daoCheck) {
        this.daoCheck = daoCheck;
    }

    public CheckServiceImpl(DaoCheckImpl daoCheck) {
        this.daoCheck = daoCheck;
    }

    public List<Check> getAll() {
        return daoCheck.getAll();
    }

    @Override
    public double sumAll(ArrayList<Check> checks) {
        double sum = 0;
        for (int i = 0; i < checks.size(); i++) {
            sum += checks.get(i).getGoods().sum(checks.get(i).getGoods().getFirstPrice());
        }
        return sum;
    }

    @Override
    public String BestSallaryOfDay(ArrayList<Check> checks) {
        String result ="Продавець який віддав найбільшу заставу : " + checks.get(idBigMoney(checks) - 1).getSeller().getFullName();
        return  result;
    }

    @Override
    public int idBigMoney(ArrayList<Check> checks) {
        double max = checks.get(0).getGoods().sum(checks.get(0).getGoods().getFirstPrice());
        int idmax = 0;
        for (int i = 1; i < checks.size(); i++) {
            double sum = checks.get(i).getGoods().sum(checks.get(i).getGoods().getFirstPrice());
            if (sum > max) {
                max = sum;
                idmax = i;
            }
        }
        return idmax + 1;
    }

    @Override
    public double salaryRichestClient(ArrayList<Check> checks) {
        double maxSallary = checks.get(0).getClient().getSalary();
        for(int i=0;i<checks.size();i++)
        {
            if(maxSallary<checks.get(i).getClient().getSalary())
            {
                maxSallary=checks.get(i).getClient().getSalary();
            }
        }
        return maxSallary;
    }

    @Override
   public String infoOfBestClient(ArrayList<Check> checks) {
        String result=checks.get((idBigMoney(checks))-1).getClient().toString();
        return  result;
    }

    @Override
    public ArrayList<Check> readAll() {
        return daoCheck.readAll();
    }

    public Check getCheck(int id) {
        return daoCheck.getCheck(id);
    }

    public void createCheck(Check check) {
        daoCheck.createCheck(check);
    }

    public void updateCheck(Check check) {
        daoCheck.updateCheck(check);
    }

    public void deleteCheck(int id) {
        daoCheck.deleteCheck(id);
    }

    public void showAll() {
        daoCheck.showAll();
    }
}
