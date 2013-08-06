package com.govauction.dao;

import com.govauction.model.Lot;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 03.08.13
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public interface LotDao {
    public void createLot(Lot lot);
    public void deleteLot(Lot lot);
    public Lot getLotByDescription(String name);
    public List<Lot> getAllLots();
    public String indicateDao();
}
