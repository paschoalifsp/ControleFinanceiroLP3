package exceptions;

public class NaoEncontradoException extends RuntimeException{
	public NaoEncontradoException(){
		super();
		System.out.println("N�o foi encontrado registros que correspondem o valor informado");
		}

}
