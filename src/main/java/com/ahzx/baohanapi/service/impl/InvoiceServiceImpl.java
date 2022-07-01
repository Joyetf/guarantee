package com.ahzx.baohanapi.service.impl;

import com.ahzx.baohanapi.common.result.R;
import com.ahzx.baohanapi.entity.Invoice;
import com.ahzx.baohanapi.mapper.InvoiceMapper;
import com.ahzx.baohanapi.service.InvoiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发票表 服务实现类
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService {
}
