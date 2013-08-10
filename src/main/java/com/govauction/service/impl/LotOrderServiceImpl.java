package com.govauction.service.impl;

import com.govauction.dao.LotOrderDao;
import com.govauction.model.LotOrder;
import com.govauction.service.LotOrderService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
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
    public LotOrder getLotOrderById(Integer id) {
        return lotOrderDao.getLotOrderById(id);
    }

    @Override
    public List<LotOrder> getAllLotOrders() {
        return lotOrderDao.getAllLotOrders();
    }
}
