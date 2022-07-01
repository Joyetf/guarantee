package com.ahzx.baohanapi.entity;

import com.ahzx.baohanapi.baseModel.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 发票表
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Invoice对象", description="发票表")
public class Invoice extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "中鑫中科订单号")
    private String orderNo;

    @ApiModelProperty(value = "保函编号")
    private String guarantee;

    @ApiModelProperty(value = "发票下载地址，专票可不传")
    private String invoiceUrl;

    @ApiModelProperty(value = "发票代码")
    private String invoiceCode;

    @ApiModelProperty(value = "发票号码")
    private String invoiceNo;

    @ApiModelProperty(value = "是否申请成功 1：审核通过 0：审核不通过")
    private Boolean applyStatus;

    @ApiModelProperty(value = "投保人名称")
    private String applicantName;

    @ApiModelProperty(value = "投保人统一社会信用代码")
    private String applicantCode;

    @ApiModelProperty(value = "开票金额，格式：数字格式字符串")
    private String amount;

    @ApiModelProperty(value = "0：普票；1：专票")
    private Boolean type;

    @ApiModelProperty(value = "公司地址，专票时必填")
    private String address;

    @ApiModelProperty(value = "公司电话，专票时必填")
    private String phone;

    @ApiModelProperty(value = "开户行，专票时必填")
    private String bank;

    @ApiModelProperty(value = "账号，专票时必填")
    private String account;

    @ApiModelProperty(value = "接收电子发票的email")
    private String email;

    @ApiModelProperty(value = "联系电话（收件人联系电话，专票时必填）")
    private String contactMobile;

    @ApiModelProperty(value = "收件人姓名，专票时必填")
    private String contactName;

    @ApiModelProperty(value = "收件人地址，专票时必填")
    private String contactAddress;


}
