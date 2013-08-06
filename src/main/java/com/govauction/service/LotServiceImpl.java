package com.govauction.service;

import com.govauction.dao.LotDao;
import com.govauction.model.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 03.08.13
 * Time: 22:37
 * To change this template use File | Settings | File Templates.
 */

public class LotServiceImpl implements LotService {

    LotDao lotDao;

    @Override
    public String indicateLotDao() {
       return lotDao.indicateDao();
    }

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
    public Lot getLotByDescription(String name) {
        return lotDao.getLotByDescription(name);
    }

    @Override
    public List<Lot> getAllLots() {
        return lotDao.getAllLots();
    }
}
