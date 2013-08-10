package com.govauction.dao.impl;

import com.govauction.dao.LotDao;
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
 *
 * Date: 03.08.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class HibernateLotDao implements LotDao {

    @Autowired
    HibernateTemplate ht;

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
    public Lot getLotById(Integer id) {
      return ht.get(Lot.class, id);
    }
    @Transactional
    @Override
    public List<Lot> getAllLots() {
      return ht.loadAll(Lot.class);
    }
}
