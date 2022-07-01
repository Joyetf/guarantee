package com.ahzx.baohanapi.controller;


import com.ahzx.baohanapi.common.result.R;
import com.ahzx.baohanapi.entity.Invoice;
import com.ahzx.baohanapi.service.InvoiceService;
import com.ahzx.baohanapi.vo.InvoiceVo;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 发票表 前端控制器
 * </p>
 * 6发票申请
 * 7发票开具通知
 *
 * @author ahzx
 * @since 2022-06-23
 */
@RestController
@RequestMapping("api/anhui_credit_investigation/insurance")
@Slf4j
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    /**
     * 6
     * 省综合服务平台向中鑫中科发起发票申请
     */
    @PostMapping("invoice")
    public R saveInvoice(@RequestBody InvoiceVo invoiceVo) {

        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceVo, invoice);
        boolean result = invoiceService.save(invoice);
        log.info("result结果:{}", result);
        if (result) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }

    }

    /**
     * 7
     * 中鑫中科向省综合服务平台同步发票结果信息
     */
    @PostMapping("inform_invoice")
    public R informInvoiceResult(@RequestBody InvoiceVo invoiceVo) {

        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceVo, invoice);

        String orderNo = invoice.getOrderNo();
        String guarantee = invoice.getGuarantee();
        UpdateWrapper updateWrapper = new UpdateWrapper();

        updateWrapper.eq("order_no",orderNo);
        updateWrapper.eq("guarantee", guarantee);

        boolean update = false;
        try {
            update = invoiceService.update(invoice,updateWrapper);
        } catch (Exception e) {
            return R.error().message(e.getMessage());
        }

        if (update) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }

    }

}

