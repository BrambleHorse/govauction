package com.govauction.dao.impl;

import com.govauction.dao.ParticipantDao;
import com.govauction.model.Participant;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 03.08.13
 * Time: 22:55
 * To change this template use File | Settings | File Templates.
 */
public class HibernateParticipantDao implements ParticipantDao {
    @Autowired
    HibernateTemplate ht;
    @Override
    public void createParticipant(Participant participant) {
       ht.saveOrUpdate(participant);
    }

    @Override
    public void deleteParticipant(Participant participant) {
       ht.delete(participant);
    }

    @Override
    public Participant getParticipantById(Integer id) {
        return ht.get(Participant.class,id);
    }
}
