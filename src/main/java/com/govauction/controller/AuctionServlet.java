package com.govauction.controller;
import com.govauction.dao.LotDao;
import com.govauction.model.Lot;
import com.govauction.service.LotService;
import com.govauction.service.LotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 02.08.13
 * Time: 23:46
 * To change this template use File | Settings | File Templates.
 */
public class AuctionServlet extends HttpServlet {

    private LotService lotService;



    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        List<Lot> allLots = new ArrayList<Lot>();
//        allLots   =     (List<Lot>)lotService.getAllLots();
//        req.setAttribute("allLots",allLots);

        WebApplicationContext context = ContextLoaderListener.getCurrentWebApplicationContext();
        lotService = (LotService) context.getBean("lotService");
        req.setAttribute("test",lotService.indicateLotDao());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/index.jsp");
        rd.forward(req, res);
    }
}
