package desktopApp.core.service;

public class IdadeNaoPermitidaException extends Exception{
	private static final long serialVersionUID = 1149241039409861914L;
	
	public IdadeNaoPermitidaException(String msg) {
		super(msg);
	}
	public IdadeNaoPermitidaException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
