package exceptions;

public class ChamadoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ChamadoException (String msg) {
		super(msg);
	}
}
