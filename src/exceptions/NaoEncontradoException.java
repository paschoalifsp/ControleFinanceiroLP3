package exceptions;

public class NaoEncontradoException extends RuntimeException{
	public NaoEncontradoException(){
		super();
		System.out.println("Não foi encontrado registros que correspondem o valor informado");
		}

}
