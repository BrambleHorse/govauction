package com.govauction.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */

@Entity
@Table(name="lot_orders")
public class LotOrder implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer lotOrderId;

    @ManyToOne(cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id")
    private Lot lot;


    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Integer getLotOrderId() {
        return lotOrderId;
    }

    public void setLotOrderId(Integer lotOrderId) {
        this.lotOrderId = lotOrderId;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
