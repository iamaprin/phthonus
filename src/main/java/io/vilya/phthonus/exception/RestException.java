package io.vilya.phthonus.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * @author iamaprin
 * @time 2017年10月14日 下午3:13:01
 */
@SuppressWarnings("serial")
public class RestException extends CheckedException {
	
	private final int code;
	
	public RestException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public RestException(int code, String message, Throwable e) {
		super(message, e);
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	@Override
	public synchronized Throwable getCause() {
		return ExceptionUtils.getRootCause(super.getCause());
	}
	
}
