package com.briup.apps.cms.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

@RestControllerAdvice
public class CustomerExceptionHandler {
	@ExceptionHandler(value= Exception.class)
	public <E> Message handler(Exception exception) {
		exception.printStackTrace();
		return MessageUtil.error(exception.getMessage());
	}

}
