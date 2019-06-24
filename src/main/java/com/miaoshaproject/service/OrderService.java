package com.miaoshaproject.service;

import com.miaoshaproject.error.BussinessException;
import com.miaoshaproject.service.model.OrderModel;

/**
 * Created by lbk on 2019/6/21,16:47
 */
public interface OrderService {
    OrderModel createOrder(Integer userId, Integer itemId, Integer promoId,Integer amount) throws BussinessException;
}
