package io.vilya.phthonus.config.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import io.vilya.phthonus.exception.RestException;
import io.vilya.phthonus.resolver.response.impl.ResponseResloverManager;
import io.vilya.common.rest.RestResponse;
import io.vilya.common.rest.ResultCode;
import io.vilya.phthonus.exception.CheckedException;

/**
 * @author iamaprin
 * @time 2017年10月12日 下午10:05:38
 */
@ControllerAdvice("io.vilya.phthonus")
public class RootControllerAdvice implements ResponseBodyAdvice<Object> {

	private static final Logger LOGGER = LoggerFactory.getLogger(RootControllerAdvice.class);
	
	@Autowired
	private ResponseResloverManager responseResloverManager;
	
	@ExceptionHandler(RestException.class)
	public ResponseEntity<RestResponse> handleCheckedException(RestException ex) {
		logException(ex);
		RestResponse body = new RestResponse()
				.setCode(ex.getCode())
				.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
	
	@ExceptionHandler(CheckedException.class)
	public ResponseEntity<RestResponse> handleCheckedException(CheckedException ex) {
		logException(ex);
		RestResponse body = new RestResponse()
				.setCode(ResultCode.FAIL)
				.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RestResponse> handleException(Exception ex) {
		logException(ex);
		RestResponse body = new RestResponse()
				.setCode(ResultCode.FAIL)
				.setMessage("接口访问失败");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
	}
	
	private static void logException(Throwable e) {
		LOGGER.error(StringUtils.EMPTY, e);
	}

	
	//	--------------------------------------------------------------------------------------------------------------

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		return responseResloverManager.resolve(body);
	}
	
	
	
	
	
	
	
}
