package net.zygzs.lzz.exception;

public class ApplicationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6271448818227274677L;
	/**
	 * The error code
	 */
	protected String errorCode;

	/**
	 * The parameter to replace the locale defaultMessage
	 */
	protected String[] params = new String[0];

	/**
	 * This defaultMessage has nothing to do with the i18n issue.
	 */
	protected String defaultMessage = null;

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public ApplicationException(String message) {
		super(message);
		this.defaultMessage = message;
	}

	/**
	 * Constructor
	 * 
	 * @param errorCode
	 * @param defaultMessage
	 */
	public ApplicationException(String errorCode, String message) {
		super("error code:" + errorCode + ", error message:" + message);
		this.errorCode = errorCode;
		this.defaultMessage = message;
	}

	/**
	 * 
	 * @param errorCode
	 * @param cause
	 */
	public ApplicationException(String errorCode, Throwable cause) {
		super("error code:" + errorCode + ", cause:" + cause);
		this.errorCode = errorCode;
	}

	/**
	 * 
	 * @param errorCode
	 * @param params
	 * @param cause
	 */
	public ApplicationException(String errorCode, String[] params, String message, Throwable cause) {
		super("error code:" + errorCode + ", error message:" + message + ", params:" + params + ", cause:" + cause);
		this.errorCode = errorCode;
		this.params = params;
		this.defaultMessage = message;
	}

	public ApplicationException(String errorCode, String[] params, String message) {
		super("error code:" + errorCode + ", error message:" + message + ", params:" + params);
		this.errorCode = errorCode;
		this.params = params;
		this.defaultMessage = message;
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String[] getParameters() {
		return params;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}
}