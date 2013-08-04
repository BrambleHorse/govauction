package com.govauction.dao;

import com.govauction.model.LotOrder;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 03.08.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class HibernateLotOrderDao implements LotOrderDao {
    @Autowired
    SessionFactory sFactory;
    @Override
    public void createLotOrder(LotOrder lotOrder) {
        sFactory.getCurrentSession().saveOrUpdate(lotOrder);
    }

    @Override
    public void deleteLotOrder(LotOrder lotOrder) {
        sFactory.getCurrentSession().delete(lotOrder);
    }

    @Override
    public LotOrder getLotOrder(String lotDescription, String participantName) {
        Query query =  sFactory.getCurrentSession().createQuery("from LotOrder r where r.lot.description = ? and r.participant.participantName = ?");
        query.setParameter(0, lotDescription);
        query.setParameter(1, participantName);
        return (LotOrder)query.uniqueResult();
    }

    @Override
    public List<LotOrder> getAllLotOrders() {
        List result = new ArrayList();
        Query query =  sFactory.getCurrentSession().createQuery("from LotOrder");
        result = (List<LotOrder>)query.list();
        return result;
    }
}
