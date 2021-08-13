package entidades;

public class Categoria {
	
	private int id;
	private String descricao;
	
	public Categoria(int id, String descricao) {

		this.id = id;
		this.descricao = descricao;
		
	}
	
	public Categoria() {

	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return  id + ")" + descricao ;
	}


}
