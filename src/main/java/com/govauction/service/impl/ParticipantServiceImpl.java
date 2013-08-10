package com.govauction.service.impl;

import com.govauction.dao.ParticipantDao;
import com.govauction.model.Participant;
import com.govauction.service.ParticipantService;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 03.08.13
 * Time: 22:39
 * To change this template use File | Settings | File Templates.
 */
public class ParticipantServiceImpl implements ParticipantService {
    ParticipantDao participantDao;

    public void setParticipantDao(ParticipantDao participantDao) {
        this.participantDao = participantDao;
    }

    @Override
    public void createParticipant(Participant participant) {
        participantDao.createParticipant(participant);
    }

    @Override
    public void deleteParticipant(Participant participant) {
        participantDao.deleteParticipant(participant);
    }

    @Override
    public Participant getParticipantById(Integer id) {
        return participantDao.getParticipantById(id);
    }
}
