package com.ahzx.baohanapi.controller;


import com.ahzx.baohanapi.common.result.R;
import com.ahzx.baohanapi.entity.Guarantee;
import com.ahzx.baohanapi.service.GuaranteeService;
import com.ahzx.baohanapi.vo.GuaranteeVo;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 保函表 前端控制器
 * </p>
 *
 *  3申请结果通知
 *  4审核结果通知
 *  5出函通知
 *
 * 8退保申请
 * 9退保通知
 * 10理赔申请
 * 11理赔通知
 * @author ahzx
 * @since 2022-06-23
 */
@RestController
@RequestMapping("api/anhui_credit_investigation/insurance")
@Slf4j
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;

    /**
     * 3
     * 用户在中鑫中科平台申请成功后，
     * 需将用户申请信息同步省综合服务平台
     * @return
     */
    @PostMapping("application_result")
    public R applicationResult(@RequestBody GuaranteeVo guaranteeVo){
        Guarantee guarantee = new Guarantee();
        BeanUtils.copyProperties(guaranteeVo,guarantee);

        String orderNo = guarantee.getOrderNo();
        UpdateWrapper<Guarantee> guaranteeUpdateWrapper = new UpdateWrapper<>();
        guaranteeUpdateWrapper.eq("order_no", orderNo);
        boolean result = false;
        try {
            result = guaranteeService.saveOrUpdate(guarantee,guaranteeUpdateWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result) {
            return R.ok().message("同步成功");
        } else {
            return R.error().message("同步失败");
        }
    }

    /**
     * 4
     * 金融机构把审核结果通知中鑫中科之后，
     * 中鑫中科将审核结果同步给省综合服务平台
     */
    @PostMapping("audit_result")
    public R auditResult(@RequestBody GuaranteeVo guaranteeVo){
        Guarantee guarantee = new Guarantee();
        BeanUtils.copyProperties(guaranteeVo,guarantee);

        String orderNo = guarantee.getOrderNo();
        UpdateWrapper<Guarantee> guaranteeUpdateWrapper = new UpdateWrapper<>();
        guaranteeUpdateWrapper.eq("order_no", orderNo);
        boolean result = false;
        try {
            result = guaranteeService.saveOrUpdate(guarantee,guaranteeUpdateWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result) {
            return R.ok().message("同步成功");
        } else {
            return R.error().message("同步失败");
        }
    }


    /**
     * 5
     * 金融机构把保函给中鑫中科之后，
     * 中鑫中科将数据回传给省综合服务平台
     */
    @PostMapping("letter_notificate")
    public R letterNotificate(@RequestBody GuaranteeVo guaranteeVo) {

        Guarantee guarantee = new Guarantee();
        BeanUtils.copyProperties(guaranteeVo, guarantee);
        String orderNo = guarantee.getOrderNo();
        UpdateWrapper<Guarantee> guaranteeUpdateWrapper = new UpdateWrapper<>();
        guaranteeUpdateWrapper.eq("order_no", orderNo);
        boolean result = false;
        try {
            result = guaranteeService.saveOrUpdate(guarantee,guaranteeUpdateWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result) {
            return R.ok().message("同步成功");
        } else {
            return R.error().message("同步失败");
        }
    }

    /**
     * 8
     * 省综合服务平台向中鑫中科发起退保申请
     */
    @PostMapping("end_guarantee_application")
    public R endGuaranteeApplication(@RequestBody GuaranteeVo guaranteeVo) {
        Guarantee guarantee = new Guarantee();
        BeanUtils.copyProperties(guaranteeVo, guarantee);
        boolean result = guaranteeService.save(guarantee);
        if (result) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }
    }

    /**
     * 9
     * 中鑫中科向省综合服务平台同步退保结果信息
     */
    @PostMapping("end_guarantee_inform")
    public R endGuaranteeInform(@RequestBody GuaranteeVo guaranteeVo) {
        Guarantee guarantee = new Guarantee();
        BeanUtils.copyProperties(guaranteeVo, guarantee);

        String orderNo = guarantee.getOrderNo();
        String guaranteeNo = guarantee.getGuaranteeNo();
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("order_no", orderNo);
        updateWrapper.eq("guarantee_no", guaranteeNo);


        boolean update = false;
        try {
            update = guaranteeService.update(guarantee,updateWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (update) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }
    }

    /**
     * 10
     * 省综合服务平台向中鑫中科发起理赔申请
     */
    @PostMapping("claim_application")
    public R claimApplication(@RequestBody GuaranteeVo guaranteeVo) {
        Guarantee guarantee = new Guarantee();
        BeanUtils.copyProperties(guaranteeVo, guarantee);
        boolean result = guaranteeService.save(guarantee);
        if (result) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }
    }

    /**
     * 11
     * 中鑫中科向省综合服务平台同步理赔结果信息
     */
    @PostMapping("claim_inform")
    public R claimInform(@RequestBody GuaranteeVo guaranteeVo) {
        Guarantee guarantee = new Guarantee();
        BeanUtils.copyProperties(guaranteeVo, guarantee);

        String orderNo = guarantee.getOrderNo();
        String guaranteeNo = guarantee.getGuaranteeNo();
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("order_no", orderNo);
        updateWrapper.eq("guarantee_no", guaranteeNo);


        boolean update = false;
        try {
            update = guaranteeService.update(guarantee,updateWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (update) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }
    }

}

