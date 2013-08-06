package com.govauction.dao;

import com.govauction.model.Lot;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 03.08.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class HibernateLotDao implements LotDao {

    @Autowired
    HibernateTemplate ht;

    public String indicateDao() {
        return "I am Hibernate lot dao";
    }

    @Transactional
    @Override
    public void createLot(Lot lot) {
       ht.saveOrUpdate(lot);
    }

    @Override
    public void deleteLot(Lot lot) {
       ht.delete(lot);
    }
    @Transactional
    @Override
    public Lot getLotByDescription(String description) {
       return null;
    }
    @Transactional
    @Override
    public List<Lot> getAllLots() {
      return (List<Lot>)ht.loadAll(Lot.class);
    }
}
