package com.govauction.service;

import com.govauction.model.Participant;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 03.08.13
 * Time: 22:27
 * To change this template use File | Settings | File Templates.
 */
public interface ParticipantService {
    public void createParticipant(Participant participant);
    public void deleteParticipant(Participant participant);
    public Participant getParticipantById(Integer id);
}
