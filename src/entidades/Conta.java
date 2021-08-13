package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import enums.TipoConta;
import enums.TipoLancamento;

public class Conta {

	private int id;
	private String nome;
	private String numero;
	private TipoConta tipo;
	private int idUsuario;
	private double saldo;
	private List<Lancamentos> lancamentos = new ArrayList<>();
	
	

	public Conta(int id, String nome, String numero, TipoConta tipo, int idUsuario) {

		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.tipo = tipo;
		this.idUsuario = idUsuario;
	}


	public int getId() {
		return id;
	}

	public String getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void adicionaLancamento(Lancamentos lancamento) {
		lancamentos.add(lancamento);
		Thread t1 = new Thread(() -> atualizarSaldo());
		t1.start();
		
	}
	
	public void excluiLancamento(Lancamentos lancamento) {
		lancamentos.remove(lancamento);
	}
	
	public void atualizarSaldo() {
		
		Double resultadoReceita = this.lancamentos.stream()
				.filter(x -> x.getTipoLancamento()
						.equals(TipoLancamento.RECEITA))
				.mapToDouble(Lancamentos::getValor)
				.reduce(0, Double::sum);
		Double resultadoGasto = this.lancamentos.stream()
				.filter(x -> x.getTipoLancamento()
						.equals(TipoLancamento.GASTO))
				.mapToDouble(Lancamentos::getValor)
				.reduce(0, Double::sum);
		
		this.saldo = resultadoReceita - resultadoGasto;
				
	}
	
	public void visualizarlancamentos() {
		this.lancamentos.stream().forEach(lancamento -> System.out.println(lancamento.toString()));
	}
	
	@Override
	public String toString() {
		return   id + ") conta " + tipo.toString().toLowerCase() + " " + nome + " numero " + numero;
	}
	
	
}