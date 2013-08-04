package com.govauction.dao;

import com.govauction.model.Participant;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 03.08.13
 * Time: 22:55
 * To change this template use File | Settings | File Templates.
 */
public class HibernateParticipantDao implements ParticipantDao {
    @Autowired
    SessionFactory sFactory;
    @Override
    public void createParticipant(Participant participant) {
       sFactory.getCurrentSession().saveOrUpdate(participant);
    }

    @Override
    public void deleteParticipant(Participant participant) {
       sFactory.getCurrentSession().delete(participant);
    }

    @Override
    public Participant getParticipantByName(String name) {
        Query query =  sFactory.getCurrentSession().createQuery("from Participant r where r.participantName = ?");
        query.setParameter(0, name);
        return (Participant)query.uniqueResult();
    }
}
