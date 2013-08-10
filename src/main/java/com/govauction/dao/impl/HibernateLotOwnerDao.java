package com.govauction.dao.impl;

import com.govauction.dao.LotOwnerDao;
import com.govauction.model.LotOwner;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 03.08.13
 * Time: 22:54
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class HibernateLotOwnerDao implements LotOwnerDao {
    @Autowired
    HibernateTemplate ht;
    @Transactional
    @Override
    public void createLotOwner(LotOwner lotOwner) {
        ht.saveOrUpdate(lotOwner);
    }
    @Transactional
    @Override
    public void deleteLotOwner(LotOwner lotOwner) {
        ht.delete(lotOwner);
    }
    @Transactional
    @Override
    public LotOwner getLotOwnerById(Integer id) {
      return ht.get(LotOwner.class,id);
    }
}
