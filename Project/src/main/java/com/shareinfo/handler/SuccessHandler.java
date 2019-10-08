package com.shareinfo.handler;

import java.util.Map;

/**
 * @author zxx
 * @date 2019/5/18 9:02
 * @Effect ：对成功执行的命令就行统一的处理
 */
public class SuccessHandler {

    public static Map<String , Object> Successreturn(Map<String, Object> modelMap) {
        return modelMap;
    }

}
