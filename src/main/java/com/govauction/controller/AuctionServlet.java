package com.govauction.controller;
import com.govauction.model.Lot;
import com.govauction.model.LotOrder;
import com.govauction.model.LotOwner;
import com.govauction.model.Participant;
import com.govauction.service.*;
import com.govauction.view.LotOrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 02.08.13
 * Time: 23:46
 * To change this template use File | Settings | File Templates.
 */
public class AuctionServlet extends HttpServlet {
    //uncomment to use services without autowired annotation
   private WebApplicationContext context;
   private LotService lotService;
   private LotOrderService lotOrderService;
   private LotOwnerService lotOwnerService;
   private ParticipantService participantService;

    @Override
    public void init() throws ServletException {
        //uncomment to use services without autowired annotation
        context = ContextLoaderListener.getCurrentWebApplicationContext();
        lotService = (LotService) context.getBean("lotService");
        lotOrderService = (LotOrderService) context.getBean("lotOrderService");
        lotOwnerService = (LotOwnerService) context.getBean("lotOwnerService");
        participantService = (ParticipantService) context.getBean("participantService");
//
        // uncomment insertMockValues method and hibernate.hbm2ddl.auto=create in db-config.xml
        // to fill the database with mock values. You can also use script.sql in /resources instead.
        //insertMockValues();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lotId = req.getParameter("lot");

        if(lotId != null && !lotId.isEmpty()) {
           lotPageAction(req,resp,lotId);
        }  else {
           indexPageAction(req,resp);
        }

    }
    private void indexPageAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setAttribute("allLots",lotService.getAllLots());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/index.jsp");
        rd.forward(req, resp);
    }
    private void lotPageAction(HttpServletRequest req, HttpServletResponse resp, String lotId)
            throws ServletException, IOException {
        Lot lot = lotService.getLotById(Integer.parseInt(lotId));
        LotOwner owner = lot.getLotOwner();
        List<LotOrder>tempOrders = lot.getLotOrders();
        List<LotOrderView>orders = new ArrayList<LotOrderView>();
        for(LotOrder o : tempOrders) {
            orders.add(new LotOrderView(o.getLotOrderId(),o.getParticipant().getParticipantName()));

        }
        req.setAttribute("lot", lot);
        req.setAttribute("owner", owner);
        req.setAttribute("orders", orders);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/lot.jsp");
        rd.forward(req, resp);
    }
    //This method fills the database with mock values to test the application
//    private void insertMockValues() {
//        Lot testLot1 = new Lot();
//        Lot testLot2 = new Lot();
//        Lot testLot3 = new Lot();
//        LotOwner testLotOwner1 = new LotOwner();
//        LotOwner testLotOwner2 = new LotOwner();
//        LotOwner testLotOwner3 = new LotOwner();
//        LotOrder testLotOrder1 = new LotOrder();
//        LotOrder testLotOrder2 = new LotOrder();
//        LotOrder testLotOrder3 = new LotOrder();
//        Participant testParticipant1 = new Participant();
//        Participant testParticipant2 = new Participant();
//        Participant testParticipant3 = new Participant();
//        testLot1.setDescription("This is description of testLot1");
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, 2013);
//        calendar.set(Calendar.MONTH, 6);
//        calendar.set(Calendar.DAY_OF_MONTH, 11);
//        testLot1.setLotDate(calendar.getTime());
//        testLot2.setDescription("This is description of testLot2");
//        calendar.set(Calendar.YEAR, 2013);
//        calendar.set(Calendar.MONTH, 7);
//        calendar.set(Calendar.DAY_OF_MONTH, 18);
//        testLot2.setLotDate(calendar.getTime());
//        testLot3.setDescription("This is description of testLot3");
//        calendar.set(Calendar.YEAR, 2013);
//        calendar.set(Calendar.MONTH, 8);
//        calendar.set(Calendar.DAY_OF_MONTH, 7);
//        testLot3.setLotDate(calendar.getTime());
//        testLotOwner1.setLotOwnerName("This is testLotOwner1 name");
//        testLotOwner2.setLotOwnerName("This is testLotOwner2 name");
//        testLotOwner3.setLotOwnerName("This is testLotOwner3 name");
//        testParticipant1.setParticipantName("This is testParticipant1 name");
//        testParticipant2.setParticipantName("This is testParticipant2 name");
//        testParticipant3.setParticipantName("This is testParticipant3 name");
//        testLot1.setLotOwner(testLotOwner1);
//        List<LotOrder> ordersList1 = new ArrayList<LotOrder>();
//        ordersList1.add(testLotOrder1);
//        ordersList1.add(testLotOrder2);
//        testLot1.setLotOrders(ordersList1);
//        testLot2.setLotOwner(testLotOwner2);
//        List<LotOrder> ordersList2 = new ArrayList<LotOrder>();
//        ordersList2.add(testLotOrder3);
//        testLot2.setLotOrders(ordersList2);
//        testLot3.setLotOwner(testLotOwner3);
//        List<LotOrder> ordersList3 = new ArrayList<LotOrder>();
//        ordersList3.add(testLotOrder2);
//        ordersList3.add(testLotOrder3);
//        testLot3.setLotOrders(ordersList3);
//        List<Lot> lotList1 = new ArrayList<Lot>();
//        lotList1.add(testLot1);
//        testLotOwner1.setLots(lotList1);
//        List<Lot> lotList2 = new ArrayList<Lot>();
//        lotList1.add(testLot2);
//        testLotOwner2.setLots(lotList2);
//        List<Lot> lotList3 = new ArrayList<Lot>();
//        lotList1.add(testLot3);
//        testLotOwner3.setLots(lotList3);
//        testLotOrder1.setLot(testLot1);
//        testLotOrder2.setLot(testLot1);
//        testLotOrder2.setLot(testLot3);
//        testLotOrder3.setLot(testLot2);
//        testLotOrder3.setLot(testLot3);
//        testLotOrder1.setParticipant(testParticipant1);
//        testLotOrder2.setParticipant(testParticipant2);
//        testLotOrder3.setParticipant(testParticipant3);
//        List<LotOrder> pordersList1 = new ArrayList<LotOrder>();
//        pordersList1.add(testLotOrder1);
//        testParticipant1.setOrders(pordersList1);
//        List<LotOrder> pordersList2 = new ArrayList<LotOrder>();
//        pordersList2.add(testLotOrder2);
//        testParticipant1.setOrders(pordersList1);
//        List<LotOrder> pordersList3 = new ArrayList<LotOrder>();
//        pordersList3.add(testLotOrder2);
//        testParticipant1.setOrders(pordersList3);
//        lotService.createLot(testLot1);
//        lotService.createLot(testLot2);
//        lotService.createLot(testLot3);
//        lotOrderService.createLotOrder(testLotOrder1);
//        lotOrderService.createLotOrder(testLotOrder2);
//        lotOrderService.createLotOrder(testLotOrder3);
//        lotOwnerService.createLotOwner(testLotOwner1);
//        lotOwnerService.createLotOwner(testLotOwner2);
//        lotOwnerService.createLotOwner(testLotOwner3);
//        participantService.createParticipant(testParticipant1);
//        participantService.createParticipant(testParticipant2);
//        participantService.createParticipant(testParticipant3);
//    }
}
