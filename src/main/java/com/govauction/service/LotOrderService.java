package com.govauction.service;

import com.govauction.model.LotOrder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bramblehorse
 * Date: 03.08.13
 * Time: 22:27
 * To change this template use File | Settings | File Templates.
 */
public interface LotOrderService {
    public void createLotOrder(LotOrder lotOrder);
    public void deleteLotOrder(LotOrder lotOrder);
    public LotOrder getLotOrder(String lotDescription, String participantName);
    public List<LotOrder> getAllLotOrders();
}
