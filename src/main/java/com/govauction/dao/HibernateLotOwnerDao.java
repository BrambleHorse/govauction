package com.govauction.dao;

import com.govauction.model.LotOwner;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 03.08.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
public class HibernateLotOwnerDao implements LotOwnerDao {
    @Autowired
    SessionFactory sFactory;
    @Override
    public void createLotOwner(LotOwner lotOwner) {
        sFactory.getCurrentSession().saveOrUpdate(lotOwner);
    }

    @Override
    public void deleteLotOwner(LotOwner lotOwner) {
        sFactory.getCurrentSession().delete(lotOwner);
    }

    @Override
    public LotOwner getLotOwnerByName(String name) {
        Query query =  sFactory.getCurrentSession().createQuery("from LotOwner r where r.lotOwnerName = ?");
        query.setParameter(0, name);
        return (LotOwner)query.uniqueResult();
    }
}
