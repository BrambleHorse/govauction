package com.govauction.controller;


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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/admin.jsp");
        rd.forward(req, resp);
    }
}
