package com.govauction.dao;

import com.govauction.model.LotOwner;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 03.08.13
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public interface LotOwnerDao {
    public void createLotOwner(LotOwner lotOwner);
    public void deleteLotOwner(LotOwner lotOwner);
    public LotOwner getLotOwnerByName(String name);

}
