package rek.oop;

import rek.oop.controller.DaoCheckImpl;
import rek.oop.controller.DaoClientImpl;
import rek.oop.controller.DaoGoodsImpl;
import rek.oop.controller.DaoSellerImpl;
import rek.oop.services.check.impls.CheckServiceImpl;
import rek.oop.services.client.impls.ClientServiceImpl;
import rek.oop.services.goods.impls.GoodsServiceImpl;
import rek.oop.services.seller.impls.SellerServiceImpl;

import java.sql.*;

/**
 * Created by Rekdon on 27.03.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException {

      /*  ApplicationContext check = new ClassPathXmlApplicationContext("check-context.xml");
Створення програмного проекту по керуванню роботи ломбард
        Check check1 = (Check) check.getBean("Check0");
        Check check2 = (Check) check.getBean("Check1");
        Check check3 = (Check) check.getBean("Check2");
        Check check4 = (Check) check.getBean("Check3");
        Check check5 = (Check) check.getBean("Check4");
        Check check6 = (Check) check.getBean("Check5");
        Check check7 = (Check) check.getBean("Check6");
        Check check8 = (Check) check.getBean("Check7");
        Check check9 = (Check) check.getBean("Check8");
        Check check10 = (Check) check.getBean("Check9");


        ArrayList<Check> arrayList = new ArrayList<Check>();
        arrayList.add(check1);
        arrayList.add(check2);
        arrayList.add(check3);
        arrayList.add(check4);
        arrayList.add(check5);
        arrayList.add(check6);
        arrayList.add(check7);
        arrayList.add(check8);
        arrayList.add(check9);
        arrayList.add(check10);

        for (int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        } */

/*
        System.out.println("---------------------------------------------------------------------");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        CheckServiceImpl service_check = (CheckServiceImpl) context.getBean("service_check");
        service_check.showAll();
*/
/*
        ArrayList<Seller> listSeller = new ArrayList<>();
        ArrayList<Goods> listGoods = new ArrayList<>();
        ArrayList<Client> listClient = new ArrayList<>();
        ArrayList<Check> listCheck = new ArrayList<>();



        try {
            Connection co = DriverManager.getConnection("jdbc:sqlite:PawnShop.db");
            Statement statement = co.createStatement();
            String querySellers = "SELECT * FROM Sellers ";
            ResultSet rsSeller = statement.executeQuery(querySellers);
            while (rsSeller.next()) {
                int id = rsSeller.getInt("id");
                String fullname = rsSeller.getString("fullname");
                int sallary = rsSeller.getInt("sallary");
                int workExperience = rsSeller.getInt("workExperience");
                Seller seller = new Seller(id, fullname, sallary, workExperience);
                listSeller.add(seller);
                System.out.println(id + "." + fullname + " - " + sallary + " - " + workExperience);
            }
            rsSeller.close();
            statement.close();

            String queryGoods = "SELECT * FROM Goods";
            ResultSet rsGoods = statement.executeQuery(queryGoods);
            while (rsGoods.next()) {
                int id = rsGoods.getInt("id");
                int codeGoods = rsGoods.getInt("codeGoods");
                String nameGoods = rsGoods.getString("nameGoods");
                int firstPrice = rsGoods.getInt("firstPrice");
                String goodsDescriprion = rsGoods.getString("goodsDescription");
                Goods goods = new Goods(id, codeGoods, nameGoods, firstPrice, goodsDescriprion);
                listGoods.add(goods);
                System.out.println(id + "." + codeGoods + " - " + nameGoods + " - " + firstPrice + " - " + goodsDescriprion + " - " + goods);
            }
            String queryClient = "SELECT * FROM Client ";
            ResultSet rsClient = statement.executeQuery(queryClient);
            while (rsClient.next()) {
                int id = rsClient.getInt("id");
                int sallary = rsClient.getInt("sallary");
                String fullName = rsClient.getString("fullName");
                String dataOfBirth = rsClient.getString("dataOfBirth");
                String placeOfBirth = rsClient.getString("placeOfBirth");
                String sex = rsClient.getString("sex");
                int identificationCode = rsClient.getInt("identificationCode");
                Client client = new Client(id,sallary,fullName,dataOfBirth,placeOfBirth,sex,identificationCode);
                listClient.add(client);
                System.out.println(id + "." + sallary + " - " + fullName + " - " + dataOfBirth + " - " + placeOfBirth + " - " + sex + " - " + identificationCode);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("--------------------Seller--------------------");
        for (int i = 0; i < listSeller.size(); i++) {
            System.out.println(listSeller.get(i));
        }
        System.out.println("--------------------Goods--------------------");

        for (int i = 0; i < listGoods.size(); i++) {
            System.out.println(listGoods.get(i));
        }
        System.out.println("--------------------Client--------------------");
        for (int i = 0; i < listClient.size(); i++) {
            System.out.println(listClient.get(i));
        }



        Check check0 = new Check(1, listClient.get(0), listSeller.get(0), listGoods.get(0));
        Check check1 = new Check(1, listClient.get(1), listSeller.get(1), listGoods.get(1));
        Check check2 = new Check(1, listClient.get(2), listSeller.get(0), listGoods.get(2));
        Check check3 = new Check(1, listClient.get(3), listSeller.get(2), listGoods.get(3));
        Check check4 = new Check(1, listClient.get(4), listSeller.get(1), listGoods.get(4));
        Check check5 = new Check(1, listClient.get(5), listSeller.get(0), listGoods.get(5));
        Check check6 = new Check(1, listClient.get(6), listSeller.get(2), listGoods.get(6));
        Check check7 = new Check(1, listClient.get(7), listSeller.get(2), listGoods.get(7));
        Check check8 = new Check(1, listClient.get(8), listSeller.get(0), listGoods.get(8));
        Check check9 = new Check(1, listClient.get(9), listSeller.get(1), listGoods.get(9));
        listCheck.add(check0);
        listCheck.add(check1);
        listCheck.add(check2);
        listCheck.add(check3);
        listCheck.add(check4);
        listCheck.add(check5);
        listCheck.add(check6);
        listCheck.add(check7);
        listCheck.add(check8);
        listCheck.add(check9);

        System.out.println("=-=-=-=-=-=-=-=-=-=-");
        CheckServiceImpl checkService = new CheckServiceImpl(new DaoCheckImpl(listCheck));
        System.out.println(checkService.sumAll(listCheck));
        System.out.println(checkService.idBigMoney(listCheck));
        checkService.BestSallaryOfDay(listCheck);
        System.out.println(checkService.salaryRichestClient(listCheck));
        checkService.infoOfBestClient(listCheck);

        // listServiceCheck.add(checkService);
       // System.out.println(listServiceCheck);




        listCheck.add(check0);
        listCheck.add(check2);
        listCheck.add(check3);
        listCheck.add(check4);
        listCheck.add(check5);
        listCheck.add(check6);
        listCheck.add(check7);
        listCheck.add(check8);
        listCheck.add(check9);
*/
      //  System.out.println(listCheck.get(0).getGoods().sum(listCheck.get(0).getGoods().getFirstPrice()));
       // listCheck.get(0).d

        DaoGoodsImpl goodsDao = new DaoGoodsImpl();
        DaoClientImpl clientDao = new DaoClientImpl();
        DaoSellerImpl sellersDao = new DaoSellerImpl();
        DaoCheckImpl checkDao = new DaoCheckImpl();

        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        ClientServiceImpl clientService = new ClientServiceImpl();
        SellerServiceImpl sellerService = new SellerServiceImpl();
        CheckServiceImpl checkService = new CheckServiceImpl();

        System.out.println(checkDao.readAll());
        System.out.println(sellersDao.readAll());
        System.out.println(checkService.sumAll(checkDao.readAll()));
        System.out.println(clientService.minSallary(clientDao.readAll()));

/*
        ClientServiceImpl clientService = new ClientServiceImpl();
        System.out.println(clientService.maxSallary(clientDao.readAll()));
        System.out.println(clientService.minSallary(clientDao.readAll()));
        System.out.println(sellersDao.readAll());
        System.out.println(clientDao.readAll());
        System.out.println(goodsDao.readAll());
        System.out.println(checkDao.readAll());
        System.out.println(checkDao.read());


        CheckServiceImpl checkService = new CheckServiceImpl(new DaoCheckImpl(checkDao.readAll()));
        System.out.println(checkService.sumAll(checkDao.readAll()));
        System.out.println(checkService.idBigMoney(checkDao.readAll()));
        System.out.println(checkService.BestSallaryOfDay(checkDao.readAll()));
        System.out.println(checkService.salaryRichestClient(checkDao.readAll()));
        System.out.println(checkService.infoOfBestClient(checkDao.readAll()));
        System.out.println(checkService.readAll().get(0));*/

    }
}
