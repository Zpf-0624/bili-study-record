package com.tuyoo.bi.Test;

/**
 * @Author zhangpengfei
 * @Date 2023-07-17 19:17
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class MyCustomException extends Throwable {
    public MyCustomException(String something_went_wrong) {
        System.out.println(something_went_wrong);
    }
}
