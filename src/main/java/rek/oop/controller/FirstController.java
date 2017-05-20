package rek.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rek.oop.model.goods.Goods;
import rek.oop.model.seller.Seller;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Rekdon on 12.04.2017.
 */

@RestController
public class FirstController {

    @Autowired
    private DaoGoodsImpl service;


    @RequestMapping("/api/goods")
    public ArrayList<Goods> goods() throws SQLException {
        return service.getAll();
    }


    //http://localhost:8080/titular


    @RequestMapping("/titular")
    public String titular(){

        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\n" +
                "    <head>\n" +
                "        <meta charset=\"utf-8\">\n" +
                "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "        <title>Титульна сторінка</title>\n" +
                "        <link rel=\"stylesheet\" href=\"main.css\">\n" +
                "       \n" +
                "    </head>\n" +
                "    <style>\n" +
                "        div {\n" +
                "             margin: auto;\n" +
                "    width: 1000px;\t\n" +
                "    height: 1000px; \n" +
                "    background: white; \n" +
                "    outline: 2px solid #000;\n" +
                "    border: 3px solid #fff; \n" +
                "    border-radius: 10px; \n" +
                "   }\n" +
                "             fst { \n" +
                "              align-items: right;\n" +
                "              font-size: 1; \n" +
                "              font-family: Verdana, Arial, Helvetica, sans-serif; \n" +
                "              color: black;\n" +
                "              font-weight: bolder;\n" +
                "              }\n" +
                "             dbl\n" +
                "            {\n" +
                "              font-size: 90; \n" +
                "              font-family:  Arial, sans-serif; \n" +
                "              color: black;\n" +
                "            }\n" +
                "              dbl1\n" +
                "            {\n" +
                "                padding-right: 13%;\n" +
                "              font-size: 90; \n" +
                "              font-family:  Arial, sans-serif; \n" +
                "              color: black;\n" +
                "            }\n" +
                "              dbl2\n" +
                "            {\n" +
                "       font: bold italic 110% serif; "+
                "              font-size: 140; \n" +
                "              font-family: Verdana, Arial, Helvetica, sans-serif; \n" +
                "              font-weight: bolder;\n" +
                "             \n" +
                "            }\n" +
                "            stnd\n" +
                "            {\n" +
                "                font-size: 100; \n" +
                "                font-family: Verdana, Arial, Helvetica, sans-serif; \n" +
                "                font-weight: bolder;\n" +
                "            }\n" +
                "            tit\n" +
                "            {\n" +
                "                 font-size: 40px; \n" +
                "                font-family: Verdana, Arial, Helvetica, sans-serif; \n" +
                "                font-weight: bolder;\n" +
                "                color: black;\n" +
                "            }\n" +
                "            std\n" +
                "            {\n" +
                "              padding-left: 600px;\n" +
                "              font-size: 90; \n" +
                "              font-family: Verdana, Arial, Helvetica, sans-serif; \n" +
                "              font-weight: bolder;\n" +
                "            }\n" +
                "            com\n" +
                "            {\n" +
                "              padding-left: 500px;\n" +
                "              font-size: 90; \n" +
                "              font-family: Verdana, Arial, Helvetica, sans-serif; \n" +
                "              color: black;\n" +
                "            }\n" +
                "             com2\n" +
                "            {\n" +
                "              padding-left: 628px;\n" +
                "              font-size: 90; \n" +
                "              font-family: Verdana, Arial, Helvetica, sans-serif; \n" +
                "              color: black;\n" +
                "            }\n" +
                "        com3\n" +
                "            {\n" +
                "              padding-left: 640px;\n" +
                "              font-size: 15px; \n" +
                "              font-family: Verdana, Arial, Helvetica, sans-serif; \n" +
                "              color: black;\n" +
                "            }\n" +
                "        com4\n" +
                "            {\n" +
                "              padding-left: 740px;\n" +
                "              font-size: 50; \n" +
                "              font-family: Verdana, Arial, Helvetica, sans-serif; \n" +
                "              color: black;\n" +
                "            }\n" +
                "            jr\n" +
                "            {\n" +
                "               font-family: Verdana, Arial, Helvetica, sans-serif; \n" +
                "              color: black;\n" +
                "              font-weight: bolder;\n" +
                "            }\n" +
                "        </style>\n" +
                "    <body>\n" +
                "         <div>\n" +
                "\t\t<p align = \"right\">\n" +
                "\t\t<fst>\n" +
                "              Форма № Н-6.01\n" +
                "        </fst>\n" +
                "        </p>\n" +
                "\t\t\n" +
                "\t\t<p align = \"right\">\n" +
                "            <dbl1>ЗАТВЕРДЖЕНО</dbl1><br/>\n" +
                "           <dbl> Наказ Міністерства освіти і науки<br/>\n" +
                "            29 березня 2012 року № 384<br/>\n" +
                "            </dbl>\n" +
                "\t\t<p/> \n" +
                "    <br/>\n" +
                "    <br/>\n" +
                "\t\t<p align = \"center\">\n" +
                "            <stnd> \n" +
                "            Інститут фізико-технічних та комп’ютерних наук<br/>\n" +
                "            Відділ комп’ютерних технологій<br/>\n" +
                "            Кафедра програмного забезпечення комп’ютерних систем<br/>\n" +
                "            </stnd>\n" +
                "\t\t</p> \n" +
                "    <br/> \n" +
                "    <br/>\t\n" +
                "<p align = \"center\"><dbl2>КУРСОВИЙ ПРОЕКТ З ДИСЦИПЛІНИ : </dbl2></p>\n" +
                "<p align = \"center\"><dbl2> \"ОБ'ЄКТНО ОРІЄНТОВАНЕ ПРОГРАМУВАННЯ\"</dbl2></p>\n" +
                "<p align = \"center\"><dbl2>на тему : </dbl2></p>\n" +
                "<p align = \"center\"><tit>Створення програмного проекту по керуванню роботи ломбарду </tit></p>\n" +
                "    <br/>\n" +
                "    <br/>\n" +
                "        \n" +
                "    <std align = \"right\">\n" +
                "        Студента 2 курсу 243 групи <br/>\n" +
                "        <std>Напряму підготовки </std><br/>\n" +
                "        <std>«Програмна інженерія» </std><br/>\n" +
                "        <std>Ганкевича В.В. </std><br/>\n" +
                "    <std/>\n" +
                "    <br/>\n" +
                "        <std> Керівник </std><br/>\n" +
                "        <std> Прохоров Г.В. </std><br/>\n" +
                "    <br/> \n" +
                "    <br/>\n" +
                "    <br/>\n" +
                "        <com><jr> Члени комісії _______ ________________ </jr></com><br/>\n" +
                "            <com3>(підпис)         (прізвище та ініціали) </com3>\n" +
                "            <br/>    \n" +
                "        <com2> ________ __________________ </com2>\n" +
                "             <com3>(підпис)         (прізвище та ініціали) </com3>\n" +
                "            <br/>   \n" +
                "        <com2> ________ __________________ </com2>\n" +
                "             <com3>(підпис)         (прізвище та ініціали) </com3>\n" +
                "    <br/>\n" +
                "    <br/>\n" +
                "    <br/>\n" +
                "        <p align = \"center\"><dbl2> Чернівці - 2017 </dbl2></p>\n" +
                "          <div/>\n" +
                "    <body/>\n" +
                "<html/>\n";
    }

}