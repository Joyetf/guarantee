package com.ahzx.baohanapi.entity;

import com.ahzx.baohanapi.baseModel.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>
 * 保函表
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Guarantee对象", description="保函表")
public class Guarantee extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "省综合服务平台产品id标识")
    private String productId;

    @ApiModelProperty(value = "中鑫中科订单号")
    private String orderNo;

    @ApiModelProperty(value = "企业名称")
    private String companyName;

    @ApiModelProperty(value = "项目名称")
    private String projectName;

    @ApiModelProperty(value = "项目属地行政区域代码")
    private String projectArea;

    @ApiModelProperty(value = "金融产品类型")
    private String projectType;

    @ApiModelProperty(value = "金融机构名称")
    private String institutionName;

    @ApiModelProperty(value = "保证金金额")
    private String bond;

    @ApiModelProperty(value = "费用")
    private String premium;

    @ApiModelProperty(value = "费率")
    private String rate;

    @ApiModelProperty(value = "投保时间，格式:yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date insureTime;

    @ApiModelProperty(value = "保函时效（月）")
    private String effectiveTime;

    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

    @ApiModelProperty(value = "原因")
    private String reason;

    @ApiModelProperty(value = "保函编号")
    private String guaranteeNo;

    @ApiModelProperty(value = "保函文件下载地址")
    private String guaranteeUrl;

    @ApiModelProperty(value = "保函文件的base64码")
    private String guaranteeFile;

    @ApiModelProperty(value = "出函时间，格式:yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date issueTime;

    @ApiModelProperty(value = "退保结果通知时间，格式:yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date surrenderTime;

    @ApiModelProperty(value = "理赔申请人")
    private String claimsApplicant;

    @ApiModelProperty(value = "收款账号")
    private String payerAccount;

    @ApiModelProperty(value = "赔付金额")
    private String payerAmount;

    @ApiModelProperty(value = "理赔文件列表")
    private String fileList;

    @ApiModelProperty(value = "理赔联系人")
    private String applyUserName;

    @ApiModelProperty(value = "理赔联系人电话")
    private String applyUserPhone;

    @ApiModelProperty(value = "理赔结果通知时间，格式:yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GTM-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date claimsTime;


}
