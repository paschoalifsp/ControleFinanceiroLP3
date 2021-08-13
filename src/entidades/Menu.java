package entidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	public void exibirMenuPrincipal() {
		

		
		System.out.println("\n\nSelecione uma op��o: ");
		System.out.println("1) Adicionar conta banc�ria");
		System.out.println("2) Adicionar categoria ");
		System.out.println("3) Adicionar lan�amento ");
		System.out.println("4) Visualizar saldo");
		System.out.println("5) Visualizar lan�amentos");

	}
	
	public int selecionarOpcao() {
		Scanner sc = new Scanner(System.in);
		try 
		{
			int opcao = sc.nextInt();
			return opcao;
		}
		
		catch(InputMismatchException e)
		{
			System.out.println("Entrada inv�lida");
			return -1;
		}

	}
	
	public void exibirBanner(Usuario usuario) {
		
		System.out.println("\t\t***Sistema de controle financeiro***\n\n ");
		
		System.out.println("Ol�, " + usuario.getNome());
	

	}
	
}
