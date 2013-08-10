package com.govauction.dao.impl;

import com.govauction.dao.LotOrderDao;
import com.govauction.model.LotOrder;
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
public class HibernateLotOrderDao implements LotOrderDao {
    @Autowired
    HibernateTemplate ht;
    @Transactional
    @Override
    public void createLotOrder(LotOrder lotOrder) {
        ht.saveOrUpdate(lotOrder);
    }
    @Transactional
    @Override
    public void deleteLotOrder(LotOrder lotOrder) {
       ht.delete(lotOrder);
    }
    @Transactional
    @Override
    public LotOrder getLotOrderById(Integer id) {
       return ht.get(LotOrder.class, id);
    }
    @Transactional
    @Override
    public List<LotOrder> getAllLotOrders() {
         return ht.loadAll(LotOrder.class);
    }
}
