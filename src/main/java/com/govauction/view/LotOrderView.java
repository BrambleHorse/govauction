package com.govauction.view;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 12.08.13
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */
public class LotOrderView {
    private Integer lotOrderId;
    private String participantName;

    public LotOrderView(Integer lotOrderId, String participantName) {
        this.lotOrderId = lotOrderId;
        this.participantName = participantName;
    }

    public String getParticipantName() {
        return participantName;
    }

    private void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public Integer getLotOrderId() {
        return lotOrderId;
    }

    private void setLotOrderId(Integer lotOrderId) {
        this.lotOrderId = lotOrderId;
    }
}


