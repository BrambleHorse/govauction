package com.govauction.service;

import com.govauction.model.LotOwner;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 03.08.13
 * Time: 22:27
 * To change this template use File | Settings | File Templates.
 */
public interface LotOwnerService {
    public void createLotOwner(LotOwner lotOwner);
    public void deleteLotOwner(LotOwner lotOwner);
    public LotOwner getLotOwnerById(Integer id);
}
