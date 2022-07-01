package com.ahzx.baohanapi.service.impl;

import com.ahzx.baohanapi.entity.Product;
import com.ahzx.baohanapi.mapper.ProductMapper;
import com.ahzx.baohanapi.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品表 服务实现类
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
