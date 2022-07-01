package com.ahzx.baohanapi.common.util;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.digest.DigestUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.time.format.SignStyle;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Component
@Slf4j
public class SignUtils {

    private static String appId;

    private static String accessKeyId;

    private static String keySecret;

    @Value("${sign.appId}")
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Value("${sign.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    @Value("${sign.keySecret}")
    public void setKeySecret(String keySecret) {
        this.keySecret = keySecret;
    }

    public static Map<String,Object> createSign(Map<String, Object> params) {
        SignUtils signUtils = new SignUtils();
        String timestamp = signUtils.getTimestamp();
        String uuid = UUID.randomUUID().toString().trim().replace("-", "");
        params.put("appId", appId);
        params.put("timestamp",timestamp);
        params.put("accessKeyId", accessKeyId);
        params.put("uuid", uuid);
        StringBuilder sb = new StringBuilder();

        //将参数以参数名的字典升序排序
        Map<String, Object> sortParams = new TreeMap<>(params);
        for (Map.Entry<String, Object> entry : sortParams.entrySet()) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            if (!StringUtils.isEmpty(value)) {
                sb.append("&").append(key).append("=").append(value);
            }
        }
        String baseString = sb.toString().replaceFirst("&", "");
        String signStr = keySecret + "&" + "baseString=" + baseString;

        // 报文签名使用国密消息摘要算法（SM3）
        String signature = SmUtil.sm3(signStr).toUpperCase();

        params.put("sign", signature);
        return params;
    }

    public String getTimestamp() {
        // 生成时间戳
        Long timestampLong = System.currentTimeMillis();

        String timestampStr = String.valueOf(timestampLong);

        return timestampStr;
    }

}
