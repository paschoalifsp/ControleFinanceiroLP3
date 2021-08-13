package entidades;


import java.lang.reflect.*;

public class Reflexao {
	public Reflexao(){

	}

	public void listaTiposConta() {
		try {
			Class cl = Class.forName("enums.TipoConta");
			Field[] fi = cl.getDeclaredFields();

			for (int i = 0; i < fi.length - 1; i++) {
				System.out.println((i+1) + ")" +fi[i].getName());
			}

		}
		catch (Throwable e) {
			System.err.print(e);
		}
	}
	
	public void listaTiposLancamento() {
		try {
			Class cl = Class.forName("enums.TipoLancamento");
			Field[] fi = cl.getDeclaredFields();

			for (int i = 0; i < fi.length - 1; i++) {
				System.out.println((i+1) + ")" +fi[i].getName());
			}

		}
		catch (Throwable e) {
			System.err.print(e);
		}
	}

}
