package com.govauction.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 */

@Entity
@Table(name="participants")
public class Participant implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Integer participantId;


    @Column(name = "participant_name")
    private String participantName;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "participant")
    private List<LotOrder> orders;


    public List<LotOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<LotOrder> orders) {
        this.orders = orders;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }
}
