package com.govauction.controller;


import com.govauction.model.Lot;
import com.govauction.service.LotOrderService;
import com.govauction.service.LotOwnerService;
import com.govauction.service.LotService;
import com.govauction.service.ParticipantService;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 02.08.13
 * Time: 23:47
 * To change this template use File | Settings | File Templates.
 */
public class AuctionAdminServlet extends HttpServlet {
    private WebApplicationContext context;
    private LotService lotService;
    private LotOrderService lotOrderService;
    private LotOwnerService lotOwnerService;
    private ParticipantService participantService;

    @Override
    public void init() throws ServletException {
        context = ContextLoaderListener.getCurrentWebApplicationContext();
        lotService = (LotService) context.getBean("lotService");
        lotOrderService = (LotOrderService) context.getBean("lotOrderService");
        lotOwnerService = (LotOwnerService) context.getBean("lotOwnerService");
        participantService = (ParticipantService) context.getBean("participantService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        String action = req.getParameter("action");
        if("lots".equals(mode)) {
            if("create".equals(action)) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/createLot.jsp");
                rd.forward(req,resp);
                return;
            }
            if("edit".equals(action)) {

            }
            if("delete".equals(action)){
                Integer id = Integer.parseInt(req.getParameter("lot"));
                Lot toDelete = lotService.getLotById(id);
                if(toDelete != null) {
                    lotService.deleteLot(toDelete);
                }
                String redirectUrl = new String(req.getContextPath()+"admin?mode=lots");
                resp.sendRedirect(redirectUrl);
                return;
            }
          adminLotsPageAction(req,resp);
          return;
        }
        if("orders".equals(mode)) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/orders.jsp");
            rd.forward(req,resp);
            return;

        }
        if("owners".equals(mode)) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/owners.jsp");
            rd.forward(req,resp);
            return;
        }
        if("participants".equals(mode)) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/participants.jsp");
            rd.forward(req,resp);
            return;
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/index.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/index.jsp");
        rd.forward(req, resp);
    }
    private void adminLotsPageAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException {
        req.setAttribute("allLots", lotService.getAllLots());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin/lots.jsp");
        rd.forward(req,resp);
    }

}
