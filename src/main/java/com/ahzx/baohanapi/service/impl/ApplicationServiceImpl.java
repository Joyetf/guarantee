package com.ahzx.baohanapi.service.impl;

import com.ahzx.baohanapi.entity.Application;
import com.ahzx.baohanapi.entity.query.ApplicationQuery;
import com.ahzx.baohanapi.mapper.ApplicationMapper;
import com.ahzx.baohanapi.service.ApplicationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 投保申请表 服务实现类
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

    /**
     *
     * @param page
     * @param limit
     * @param applicationQuery
     * @return
     */
    @Override
    public IPage<Application> selectPage(Long page, Long limit, ApplicationQuery applicationQuery) {
        Page<Application> pageParam = new Page<>(page, limit);

        QueryWrapper<Application> queryWrapper = new QueryWrapper<>();

        //排序字段
        queryWrapper.orderByAsc("productId");

        if (applicationQuery == null){
            return baseMapper.selectPage(pageParam, queryWrapper);
        }

        String companyName = applicationQuery.getCompanyName();
        String companyAddress = applicationQuery.getCompanyAddress();
        String companyCreditCode = applicationQuery.getCompanyCreditCode();
        String handlerMobile = applicationQuery.getHandlerMobile();
        String handlerName = applicationQuery.getHandlerName();
        String productId = applicationQuery.getProductId();

        if (!StringUtils.isEmpty(companyName)) {
            //左%会使索引失效
            queryWrapper.likeRight("companyName", companyName);
        }

        if (!StringUtils.isEmpty(companyAddress)) {
            queryWrapper.ge("companyAddress", companyAddress);
        }

        if (!StringUtils.isEmpty(companyCreditCode)) {
            queryWrapper.ge("companyCreditCode", companyCreditCode);
        }

        if (!StringUtils.isEmpty(handlerMobile)) {
            queryWrapper.ge("handlerMobile", handlerMobile);
        }

        if (!StringUtils.isEmpty(handlerName)) {
            queryWrapper.ge("handlerName", handlerName);
        }

        if (!StringUtils.isEmpty(productId)) {
            queryWrapper.ge("join_date", productId);
        }

        return baseMapper.selectPage(pageParam, queryWrapper);
    }
}
