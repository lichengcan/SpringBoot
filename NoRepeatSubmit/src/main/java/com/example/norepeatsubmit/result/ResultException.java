package com.example.norepeatsubmit.result;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: lichengcan
 * @date: 2023-06-27 21:37
 * @description 业务接口异常类
 **/
@Setter
@Getter
public class ResultException extends RuntimeException {

    /**
     * 业务接口异常错误码
     */
    private String code;

    public ResultException() {
        super();
    }

    public ResultException(ResultCodeInterface resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }

    public ResultException(ResultCodeInterface resultCode, Throwable cause) {
        super(resultCode.getMessage(), cause);
        this.code = resultCode.getCode();
    }

    public ResultException(String code, String message) {
        super(message);
        this.code = code;
    }

}
