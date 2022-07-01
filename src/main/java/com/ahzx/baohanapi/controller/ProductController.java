package com.ahzx.baohanapi.controller;


import com.ahzx.baohanapi.common.result.R;
import com.ahzx.baohanapi.entity.Product;
import com.ahzx.baohanapi.service.ProductService;
import com.ahzx.baohanapi.vo.ProductVo;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 产品表 前端控制器
 * </p>
 *
 *  1同步产品接口
 *
 * @author ahzx
 * @since 2022-06-23
 */
@Api(tags="同步产品接口")
@Slf4j
@RestController
@RequestMapping("api/anhui_credit_investigation/insurance")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 1
     *  省综合金融服务平台上架金融机构产品信息时，省综合服务平台请求中鑫中科接口同步金融产品数据信息
     *  中鑫中科上架产品信息时，中鑫中科请求省综合金融服务平台接口同步金融机构产品数据信息
     */
    @PostMapping("add_product")
    @ApiOperation("同步产品")
    public R addProduct(@RequestBody ProductVo productVo){
        Product product = new Product();
        BeanUtils.copyProperties(productVo,product);

        String productId = product.getProductId();
        UpdateWrapper<Product> productUpdateWrapper = new UpdateWrapper<>();
        productUpdateWrapper.eq("product_id", productId);

        boolean b = productService.saveOrUpdate(product,productUpdateWrapper);
//        todo:产品图片的存储[base64]
        log.info("result结果:{}",b);
        if (b) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }
    }

}

