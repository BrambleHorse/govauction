package com.govauction.dao;

import com.govauction.model.Lot;
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
public class HibernateLotDao implements LotDao {
    @Autowired
    SessionFactory sFactory;
    @Override
    public void createLot(Lot lot) {
       sFactory.getCurrentSession().saveOrUpdate(lot);
    }

    @Override
    public void deleteLot(Lot lot) {
       sFactory.getCurrentSession().delete(lot);
    }

    @Override
    public Lot getLotByDescription(String name) {
        Query query =  sFactory.getCurrentSession().createQuery("from Lot r where r.description = ?");
        query.setParameter(0, name);
        return (Lot) query.uniqueResult();
    }

    @Override
    public List<Lot> getAllLots() {
        List result = new ArrayList();
        Query query =  sFactory.getCurrentSession().createQuery("from Lot");
        result = (List<Lot>) query.list();
        return result;
    }
}
