package com.govauction.dao;

import com.govauction.model.LotOrder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * Date: 03.08.13
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public interface LotOrderDao {
    public void createLotOrder(LotOrder lotOrder);
    public void deleteLotOrder(LotOrder lotOrder);
    public LotOrder getLotOrderById(Integer id);
    public List<LotOrder> getAllLotOrders();
}
