package com.ahzx.baohanapi.common.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ProductTypeEnum {

    CONTACTPERFOTMANCE(01,"合同履约"),
    PROJECTQUALITY(02,"工程质量"),
    PROJECTPAYMENT(03,"工程支付"),
    PROJECTBIDDING(04,"工建投标"),
    WORKSWAGES(05,"农民工工资")
    ;

    private String productName;
    private Integer code;

    ProductTypeEnum(Integer code, String productName) {
        this.productName = productName;
        this.code = code;
    }

}
