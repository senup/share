package com.shareinfo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zxx
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("status" , 0);
		modelMap.put("errMsg", e.getMessage());
		return modelMap;
	}

}