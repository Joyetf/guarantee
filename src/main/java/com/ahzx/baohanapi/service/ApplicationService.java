package com.ahzx.baohanapi.service;

import com.ahzx.baohanapi.entity.Application;
import com.ahzx.baohanapi.entity.query.ApplicationQuery;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 投保申请表 服务类
 * </p>
 *
 * @author ahzx
 * @since 2022-06-23
 */
public interface ApplicationService extends IService<Application> {
    IPage<Application> selectPage(Long page, Long limit, ApplicationQuery applicationQuery);
}
