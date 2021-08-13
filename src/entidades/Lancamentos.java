package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import enums.TipoLancamento;

public class Lancamentos {

	private int id;
	private String descricao;
	private double valor;
	private Date data;
	private int categoria;
	private TipoLancamento tipoLancamento;


	public Lancamentos(int id, String descricao, double valor, int categoria,
			TipoLancamento tipoLancamento) {

		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = new Date();
		this.categoria = categoria;
		this.tipoLancamento = tipoLancamento;
	}


	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public int getCategoria() {
		return categoria;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	@Override
	public String toString() {
		

		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String stringDate = DateFor.format(data);

		return stringDate + " - "+ descricao + "  R$" + valor + " | " + categoria ;
	}







}
