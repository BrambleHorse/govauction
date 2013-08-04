package com.govauction.console;

import com.govauction.model.Lot;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.govauction.service.LotService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class is created to test backend part of the application
 *
 *
 *
 *
 */

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springConfiguration.xml"});
        LotService lotService = (LotService) context.getBean("lotService");
//        Lot test = lotService.getLotByDescription("Test lot description2");
//        if(test != null) System.out.println("Success: " + test.getDescription());
        List<Lot> test2 = new ArrayList();
        test2 =(List<Lot>) lotService.getAllLots();
        for(Lot t : test2) {
            System.out.println("Success: " + t.getDescription());
        }


    }

}
