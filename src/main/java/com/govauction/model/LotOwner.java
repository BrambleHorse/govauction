package com.govauction.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 */

@Entity
@Table(name="owners")
public class LotOwner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Integer lotOwnerId;

    @Column(name = "owner_name")
    private String lotOwnerName;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "lotOwner")
    private List<Lot> lots;


    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }

    public Integer getLotOwnerId() {
        return lotOwnerId;
    }

    public void setLotOwnerId(Integer lotOwnerId) {
        this.lotOwnerId = lotOwnerId;
    }

    public String getLotOwnerName() {
        return lotOwnerName;
    }

    public void setLotOwnerName(String lotOwnerName) {
        this.lotOwnerName = lotOwnerName;
    }
}
