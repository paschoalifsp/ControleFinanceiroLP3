package controleFinanceiro;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entidades.Categoria;
import entidades.Conta;
import entidades.Lancamentos;
import entidades.Menu;
import entidades.Reflexao;
import entidades.Usuario;
import enums.TipoConta;
import enums.TipoLancamento;
import exceptions.ContaException;
import exceptions.ListaVaziaException;
import exceptions.NaoEncontradoException;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Menu mn = new Menu();
		Reflexao rf = new Reflexao();

		int idConta = 0;
		int idCategoria = 0;
		int idLancamento = 0;
		int opcao = 0;

		Usuario usuario1 = new Usuario(1, "Patricia", "p.santospaschoal@gmail.com", "123456");

		mn.exibirBanner(usuario1);

		do {
			mn.exibirMenuPrincipal();
			try
			{
				opcao = mn.selecionarOpcao();
			}
			
			catch(InputMismatchException e)
			{
				System.out.println("Entrada inválida");	
			}
			
			
			switch (opcao) {
			case 1:
				try 
				{
					System.out.println("Nome da conta");
					String nomeConta = sc.nextLine();
					
					System.out.println("Numero da conta");
					String numeroConta = sc.nextLine();

					System.out.println("Tipo da conta");
					rf.listaTiposConta();

					int tipoConta = sc.nextInt();
					sc.nextLine();

					if(usuario1.buscarContaporNumero(numeroConta).isPresent())
					{
						throw new ContaException();
					}
					else 
					{
						Conta conta = new Conta(idConta++, nomeConta, numeroConta, tipoConta == 1 ? TipoConta.CORRENTE : TipoConta.POUPANCA, usuario1.getId());
						usuario1.adicionarConta(conta);
						
					}
				}
				catch(InputMismatchException e)
				{
					System.out.println("Entrada inválida");
				}
				catch(RuntimeException e)
				{
					System.out.println(e.getMessage());	
				}

				break;

			case 2:

				System.out.println("Nome da categoria");
				String nomeCategoria = sc.nextLine();
				Categoria categoria = new Categoria (idCategoria++, nomeCategoria);
				usuario1.adicionarCategoria(categoria);
				break;

			case 3:
				try {
					System.out.println("Descrição");
					String descricaoLancamento = sc.nextLine();

					System.out.println("Valor");
					double valor = sc.nextDouble();
					usuario1.mostrarCategoria();

					System.out.println("Escolha a categoria");
					int cat = sc.nextInt();		
					sc.nextLine();

					System.out.println("Tipo Lançamento");
					rf.listaTiposLancamento();

					int tipoLancamento = sc.nextInt();
					sc.nextLine();

					Lancamentos lancamento = new Lancamentos(idLancamento++, descricaoLancamento, valor, cat, tipoLancamento == 1 ? TipoLancamento.RECEITA : TipoLancamento.GASTO );

					System.out.println("Indique a conta: ");
					usuario1.mostrarContas();

					int contaLancamento =sc.nextInt();

					if(usuario1.buscarContaporId(contaLancamento).isPresent()) {
						usuario1.adicionarLancamento(contaLancamento, lancamento);
					}

					else {
						throw new NaoEncontradoException();
					}

				}

				catch(InputMismatchException e){
					System.out.println("Entrada inválida");
				}
				catch(RuntimeException e){
					System.out.println(e.getMessage());	
				}
				break;

			case 4: 

				try {
					System.out.println("Indique a conta");
					usuario1.mostrarContas();
					idConta =sc.nextInt();
					usuario1.verSaldo(idConta);

				}
				catch(InputMismatchException e){
					System.out.println("Entrada inválida");
				}

				break;
			case 5:
				usuario1.verlancamentos();
				break;
				
			case 0:
				System.out.println("Até mais !!");
				break;
				
			default:
				System.out.println("Opção Inválida");
				break;

			}

		}while (opcao != 0);

	}

}
