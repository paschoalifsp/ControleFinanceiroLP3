package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exceptions.ListaVaziaException;

public class Usuario {

	private int id;
	private String nome;
	private String email;
	private String password;
	private List<Conta> contas = new ArrayList<>();
	private List<Categoria> categorias = new ArrayList();

	public Usuario(int id, String nome, String email, String password) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;

	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}
	
	public void adicionarCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}
	
	public void adicionarLancamento(int numeroConta, Lancamentos lancamento){

		for (Conta conta: this.contas) {
			if (conta.getId() == numeroConta)
				conta.adicionaLancamento(lancamento);
		}

	}
	
	public void verSaldo(int idConta) {

		this.contas.stream().filter(x -> x.getId() == idConta).forEach(x -> System.out.println( "Saldo: R$" + x.getSaldo()));
	}
	
	public void verlancamentos() {
		for (Conta conta: this.contas) {
			System.out.println("Lançamentos conta " + conta.getTipo().toString().toLowerCase() + " Numero" + conta.getNumero() );
			conta.visualizarlancamentos();
		}
	}

	public void mostrarContas() {

		this.contas.stream().forEach(conta -> System.out.println(conta.toString()));
	}

	public void mostrarCategoria() {
		
		if(this.categorias.isEmpty())
			throw new ListaVaziaException();
		else
		this.categorias.stream().forEach(categoria -> System.out.println(categoria.toString()));
	}

	public Optional<Conta> buscarContaporId(int idConta) {

		Conta resultado = null;
		for (Conta conta: this.contas) {
			if (conta.getId() == idConta)
				resultado = conta;	
		}

		return Optional.ofNullable(resultado);
	}

	public Optional<Conta> buscarContaporNumero(String numeroConta) {
		Conta resultado = null;
		for (Conta conta: this.contas) {
			if (conta.getNumero().contains(numeroConta))
				resultado = conta;	
		}

		return Optional.ofNullable(resultado);
	}



}
