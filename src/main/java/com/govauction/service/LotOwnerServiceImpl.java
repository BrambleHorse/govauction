package com.govauction.service;

import com.govauction.dao.LotOwnerDao;
import com.govauction.model.LotOwner;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 03.08.13
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
public class LotOwnerServiceImpl implements LotOwnerService {
    LotOwnerDao lotOwnerDao;

    public void setLotOwnerDao(LotOwnerDao lotOwnerDao) {
        this.lotOwnerDao = lotOwnerDao;
    }

    @Override
    public void createLotOwner(LotOwner lotOwner) {
         lotOwnerDao.createLotOwner(lotOwner);
    }

    @Override
    public void deleteLotOwner(LotOwner lotOwner) {
        lotOwnerDao.deleteLotOwner(lotOwner);
    }

    @Override
    public LotOwner getLotOwnerByName(String name) {
        return lotOwnerDao.getLotOwnerByName(name);
    }
}
