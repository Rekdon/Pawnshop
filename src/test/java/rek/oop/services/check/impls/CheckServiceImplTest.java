package rek.oop.services.check.impls;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import rek.oop.dao.check.impls.DaoCheckImpl;
import rek.oop.dao.client.impls.DaoClientImpl;
import rek.oop.dao.goods.impls.DaoGoodsImpl;
import rek.oop.dao.seller.impls.DaoSellerImpl;
import rek.oop.model.check.Check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Rekdon on 12.05.2017.
 */
public class CheckServiceImplTest {
    @Test
    public void sumAll() throws Exception {
      /*  double sum = 0;
        for (int i = 0; i < checks.size(); i++) {
            sum += checks.get(i).getGoods().sum(checks.get(i).getGoods().getFirstPrice());
        }
        return sum;*/

        DaoCheckImpl daoCheck = new DaoCheckImpl();
        CheckServiceImpl checkService = new CheckServiceImpl();

        double sum = 0;
        for (int i = 0; i < daoCheck.readAll().size(); i++) {
            sum += daoCheck.readAll().get(i).getGoods().sum(daoCheck.readAll().get(i).getGoods().getFirstPrice());
        }
        Assert.assertEquals(sum, checkService.sumAll(daoCheck.readAll()));
    }

    @Test
    public void bestSallaryOfDay() throws Exception {
        // checks.get(idBigMoney(checks) - 1).getSeller().getFullName()
        CheckServiceImpl checkService = new CheckServiceImpl();
        DaoCheckImpl daoCheck = new DaoCheckImpl();
        String result ="Продавець який віддав найбільшу заставу : " + daoCheck.readAll().get(checkService.idBigMoney(daoCheck.readAll())-1).getSeller().getFullName();
        assertEquals(result,checkService.BestSallaryOfDay(daoCheck.readAll()));
    }

    @Test
    public void idBigMoney() throws Exception {
        CheckServiceImpl checkService = new CheckServiceImpl();
        DaoCheckImpl daoCheck = new DaoCheckImpl();
        double max = daoCheck.readAll().get(0).getGoods().sum(daoCheck.readAll().get(0).getGoods().getFirstPrice());
        int idmax = 0;
        for (int i = 1; i <  daoCheck.readAll().size(); i++) {
            double sum =  daoCheck.readAll().get(i).getGoods().sum( daoCheck.readAll().get(i).getGoods().getFirstPrice());
            if (sum > max) {
                max = sum;
                idmax = i+1;
            }
        }
       assertEquals(idmax,checkService.idBigMoney(daoCheck.readAll()));
    }

  /*  @Test
    public void salaryRichestClient() throws Exception {

        /*
        double maxSallary = checks.get(0).getClient().getSalary();
        for(int i=0;i<checks.size();i++)
        {
            if(maxSallary<checks.get(i).getClient().getSalary())
            {
                maxSallary=checks.get(i).getClient().getSalary();
            }
        }
        return maxSallary;

        CheckServiceImpl checkService = new CheckServiceImpl();
        DaoCheckImpl daoCheck = new DaoCheckImpl();
        double maxSallary = daoCheck.readAll().get(0).getClient().getSalary();
        for(int i=0;i<daoCheck.readAll().size();i++)
        {
            if(maxSallary<daoCheck.readAll().get(i).getClient().getSalary())
            {
                maxSallary=daoCheck.readAll().get(i).getClient().getSalary();
            }
        }
        Assert.assertEquals(maxSallary,checkService.salaryRichestClient(daoCheck.readAll()));
    }
    */

    @Test
    public void infoOfBestClient() throws Exception {
        //String result=checks.get((idBigMoney(checks))-1).getClient().toString();
        CheckServiceImpl checkService = new CheckServiceImpl();
        DaoCheckImpl daoCheck = new DaoCheckImpl();
        String result =daoCheck.readAll().get(checkService.idBigMoney(daoCheck.readAll())-1).getClient().toString();
        assertEquals(result,checkService.infoOfBestClient(daoCheck.readAll()));
    }


    @Test
    public void readAll() throws Exception {
        ArrayList<Check> list = new ArrayList<>();
            Connection co = DriverManager.getConnection("jdbc:sqlite:PawnShop.db");
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
                list.add(check);
            }

        DaoCheckImpl checkDao = new DaoCheckImpl();
        Gson gson = new Gson();
        String str1=gson.toJson(list);
        String str2=gson.toJson(checkDao.readAll());

       // CheckServiceImpl checkService = new CheckServiceImpl();
        assertEquals(str1,str2);
    }
}