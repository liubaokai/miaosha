package com.miaoshaproject.service.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by lbk on 2019/6/22,11:06
 */
public class PromoModel {
    private Integer id;

    //秒杀活动状态，1表示还未开始，2表示进行中，3表示已结束
    private Integer status;


    private String promoName;
    private DateTime startDate;
    private DateTime endDate;

    private Integer itemId;
    //秒杀获得的商品价格

    private BigDecimal promoItemPrice;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPromoItemPrice() {
        return promoItemPrice;
    }

    public void setPromoItemPrice(BigDecimal promoItemPrice) {
        this.promoItemPrice = promoItemPrice;
    }
}
