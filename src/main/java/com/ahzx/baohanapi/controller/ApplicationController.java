package com.ahzx.baohanapi.controller;

import com.ahzx.baohanapi.common.result.R;
import com.ahzx.baohanapi.entity.Application;
import com.ahzx.baohanapi.entity.query.ApplicationQuery;
import com.ahzx.baohanapi.service.ApplicationService;
import com.ahzx.baohanapi.vo.ApplicationVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 投保申请表 前端控制器
 * </p>
 *  省综合服务平台向中鑫中科发起投保申请，中鑫中科接收申请数据并返回相应跳转地址链接
 * @author ahzx
 * @since 2022-06-23
 */
@RestController
@RequestMapping("api/anhui_credit_investigation/insurance")
@Slf4j
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    /**
     * 2
     * 省综合服务平台向中鑫中科发起投保申请，中鑫中科接收申请数据并返回相应跳转地址链接
     * @param applicationVo
     * @return
     */
    @PostMapping("apply")
    public R saveApplication(@RequestBody ApplicationVo applicationVo){
        Application application = new Application();
        BeanUtils.copyProperties(applicationVo,application);
        boolean result = applicationService.save(application);
        log.info("result结果:{}",result);
        if (result) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }
    }

}

