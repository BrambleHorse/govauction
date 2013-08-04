package com.govauction.console;

import com.govauction.model.Lot;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.govauction.model.LotOrder;
import com.govauction.model.LotOwner;
import com.govauction.model.Participant;
import com.govauction.service.LotOrderService;
import com.govauction.service.LotOwnerService;
import com.govauction.service.LotService;
import com.govauction.service.ParticipantService;
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
        LotService lotService = (LotService)context.getBean("lotService");
        LotOrderService lotOrderService = (LotOrderService) context.getBean("lotOrderService");
        LotOwnerService lotOwnerService = (LotOwnerService) context.getBean("lotOwnerService");
        ParticipantService participantService = (ParticipantService) context.getBean("participantService");


//        testLot1.setDescription("Test lot1 description");
//        testLot1.setLotDate(new Date(new java.util.Date().getTime()));
//        LotOwner testOwner1 = new LotOwner();
//        testOwner1.setLotOwnerName("Test owner 1 name");
//        LotOrder testOrder1 = new LotOrder();
//        Participant testParticipant1 = new Participant();
//        testParticipant1.setParticipantName("Test participant 1 name");
//        lotService.createLot(testLot1);
//        lotOwnerService.createLotOwner(testOwner1);
//        lotOrderService.createLotOrder(testOrder1);
//        participantService.createParticipant(testParticipant1);
//        LotService lotService = (LotService) context.getBean("lotService");
//        Lot test = lotService.getLotByDescription("Test lot description2");
//        if(test != null) System.out.println("Success: " + test.getDescription());
//        List<Lot> test2 = new ArrayList();
//        test2 =(List<Lot>) lotService.getAllLots();
//        for(Lot t : test2) {
//            System.out.println("Success: " + t.getDescription());
//        }





    }

}
