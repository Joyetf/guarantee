package com.ahzx.baohanapi.common.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum OrderStatusEnum {

    EXAMINING(200,"审核中"),
    EXAMINEFAIL(220,"审核失败"),
    WAITINGPAY(300,"待支付（审核通过）"),
    PAYSTATUSABNORMAL(320,"支付状态异常"),
    SENTLETTER(400,"已出函"),
    SURRENDEREXAMINING(600,"退保审核中"),
    SURRENDERDONE(610,"已退保"),
    SURRENDERFAIL(620,"退保失败"),
    CLAIMSACCEPTED(700,"理赔已受理"),
    CLAIMSSUCCESS(710,"理赔成功"),
    CLAIMSFAIL(720,"理赔失败")
    ;

    private Integer code;
    private String orderStatus;

    OrderStatusEnum(Integer code, String orderStatus) {
        this.code = code;
        this.orderStatus = orderStatus;
    }

}
