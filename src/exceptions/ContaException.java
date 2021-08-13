package exceptions;

public class ContaException extends RuntimeException{
	public ContaException(){
		super("Ja existe uma conta com este número");
		}

}
