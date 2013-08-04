package com.govauction.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 */

@Entity
@Table(name="lots")
public class Lot extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lot_id")
    private Long lotId;

    @Column(name = "description")
    private String description;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private LotOwner lotOnwer;

    @Column(name = "lot_date")
    private Date lotDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "lot")
    private List<LotOrder> lotOrders;

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LotOwner getLotOnwer() {
        return lotOnwer;
    }

    public void setLotOnwer(LotOwner lotOnwer) {
        this.lotOnwer = lotOnwer;
    }

    public Date getLotDate() {
        return lotDate;
    }

    public void setLotDate(Date lotDate) {
        this.lotDate = lotDate;
    }

    public List<LotOrder> getLotOrders() {
        return lotOrders;
    }

    public void setLotOrders(List<LotOrder> lotOrders) {
        this.lotOrders = lotOrders;
    }
}