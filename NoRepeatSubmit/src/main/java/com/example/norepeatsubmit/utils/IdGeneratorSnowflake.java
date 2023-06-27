package com.example.norepeatsubmit.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author lichengcan
 * @Desc 雪花算法
 * @Date: 2022/12/5
 */
@Component
public class IdGeneratorSnowflake {

    private Logger log = LoggerFactory.getLogger(IdGeneratorSnowflake.class);

    /**
     * 第几号机房
     */
    private long workerId = 0;
    /**
     * 第几号机器
     */
    private long datacenterId = 1;
    private Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);

    /**
     * 构造后开始执行，加载初始化工作
     */
    @PostConstruct
    public void init() {
        try {
            //获取本机的ip地址编码
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId: " + workerId);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("当前机器的workerId获取失败 ----> " + e);
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized Long snowflakeId() {
        return snowflake.nextId();
    }

}
