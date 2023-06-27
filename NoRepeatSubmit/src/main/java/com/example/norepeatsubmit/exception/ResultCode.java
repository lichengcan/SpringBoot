package com.example.norepeatsubmit.exception;

import lombok.Getter;

/**
 * @author: lichengcan
 * @date: 2023-06-27 21:54
 * @description 状态码预设枚举类
 **/
@Getter
public enum ResultCode implements ResultCodeInterface {

    SUCCESS("00000", "请求成功"),
    USER_EXCEPTION("A0001", "用户端错误"),
    SYSTEM_EXCEPTION("B0001", "系统执行出错"),
    THIRD_PARTY_SERVICE_INVOKE_EXCEPTION("C0001", "调用第三方服务出错");

    private String code;

    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
