package io.vilya.phthonus.exception;

/**
 * @author iamaprin
 * @time 2017年10月29日 下午1:25:58
 */
@SuppressWarnings("serial")
public class DAOException extends CheckedException {
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Throwable e) {
		super(message, e);
	}

}
