package com.govauction.service.impl;

import com.govauction.dao.LotDao;
import com.govauction.model.Lot;
import com.govauction.service.LotService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 03.08.13
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */

public class LotServiceImpl implements LotService {

    LotDao lotDao;

    public void setLotDao(LotDao lotDao) {
        this.lotDao = lotDao;
    }

    @Override
    public void createLot(Lot lot) {
        lotDao.createLot(lot);
    }

    @Override
    public void deleteLot(Lot lot) {
        lotDao.deleteLot(lot);
    }

    @Override
    public Lot getLotById(Integer id) {
        return lotDao.getLotById(id);
    }

    @Override
    public List<Lot> getAllLots() {
        return lotDao.getAllLots();
    }
}
