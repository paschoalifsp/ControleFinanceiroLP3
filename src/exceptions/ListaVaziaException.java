package exceptions;

public class ListaVaziaException extends RuntimeException {
	public ListaVaziaException(){
		super("Sem registros");
		}

}
