package com.govauction.service;

import com.govauction.dao.LotOrderDao;
import com.govauction.model.LotOrder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 03.08.13
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 */
public class LotOrderServiceImpl implements LotOrderService {
    LotOrderDao lotOrderDao;

    public void setLotOrderDao(LotOrderDao lotOrderDao) {
        this.lotOrderDao = lotOrderDao;
    }

    @Override
    public void createLotOrder(LotOrder lotOrder) {
        lotOrderDao.createLotOrder(lotOrder);
    }

    @Override
    public void deleteLotOrder(LotOrder lotOrder) {
        lotOrderDao.deleteLotOrder(lotOrder);
    }

    @Override
    public LotOrder getLotOrder(String lotDescription, String participantName) {
       return lotOrderDao.getLotOrder(lotDescription,participantName);
    }

    @Override
    public List<LotOrder> getAllLotOrders() {
        return lotOrderDao.getAllLotOrders();
    }
}
