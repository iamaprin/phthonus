package io.vilya.phthonus.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * @author iamaprin
 * @time 2017年10月12日 下午9:52:14
 * not checked exception
 */
@SuppressWarnings("serial")
public class CheckedException extends RuntimeException {

	public CheckedException(String message) {
		super(message);
	}
	
	public CheckedException(String message, Throwable e) {
		super(message, e);
	}
	
	@Override
	public synchronized Throwable getCause() {
		return ExceptionUtils.getRootCause(super.getCause());
	}
}
