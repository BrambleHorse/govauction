package com.govauction.service.impl;

import com.govauction.dao.LotOwnerDao;
import com.govauction.model.LotOwner;
import com.govauction.service.LotOwnerService;

/**
 * Created with IntelliJ IDEA.
 *
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
    public LotOwner getLotOwnerById(Integer id) {
        return lotOwnerDao.getLotOwnerById(id);
    }
}
