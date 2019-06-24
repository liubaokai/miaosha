package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.PromoDOMapper;
import com.miaoshaproject.dataobject.PromoDO;
import com.miaoshaproject.service.PromoService;
import com.miaoshaproject.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by lbk on 2019/6/22,11:27
 */
@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoDOMapper promoDOMapper;



    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        PromoDO promoDO = promoDOMapper.selectByItemId(itemId);
        PromoModel promoModel = convertFromDataObject(promoDO);
        if(promoModel == null) {
            return null;
        }


        //判断秒杀活动的当前状态
        DateTime now = new DateTime();
        if(promoModel.getStartDate().isAfterNow()){
            promoModel.setStatus(1);
        } else if(promoModel.getEndDate().isBeforeNow()) {
            promoModel.setStatus(3);
        } else {
            promoModel.setStatus(2);
        }
        return promoModel;
    }

    private PromoModel convertFromDataObject(PromoDO promoDO){
        if(promoDO == null) {
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO,promoModel);
//        System.out.println(promoModel.getPromoItemPrice());
//        这个地方没转换 老师没讲 但是我自己手动找出来了 厉害啊  都会自己找bug了
        promoModel.setPromoItemPrice(new BigDecimal(promoDO.getPromoItemPrice()));
//        System.out.println(promoModel.getPromoItemPrice());

        promoModel.setStartDate(new DateTime(promoDO.getStartDate()));

        promoModel.setEndDate(new DateTime(promoDO.getEndDate()));

        return promoModel;
    }



}
