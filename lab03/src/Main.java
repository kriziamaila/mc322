import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{		
		// Instancia uma seguradora
		Seguradora seguradora1 = new Seguradora("SafeCare","11 22967572", "safecare@gmail.com", "Rua Tal, 22");
		visualizaDados(seguradora1);
		
		// CADASTRA CLIENTE PF.
	
		List<Veiculo> listaVeiculos1 = new ArrayList<>();
		Veiculo veiculo1 = new Veiculo("COE2529", "fiat", "uno", 1995);
		listaVeiculos1.add(veiculo1);
		// O cliente eh cadastrado na seguradora apenas se o CPF for valido e se o CPF ainda nao foi cadastrado anteriormente.
		
		String cpf = "386.926.858-10"; // Testar com o cpf 386.926.858-00 (caso em que o cliente nao sera cadastrado)
		ClientePF clientePf1 = null;
		
		if (ClientePF.validarCPF(cpf) == true) {
			clientePf1 = new ClientePF("Krizia Maila", "Rua Joaquim Novaes 170", listaVeiculos1, cpf, "feminino", LocalDate.parse("2021-07-08"), "ensino superior incompleto", LocalDate.parse("1994-04-22"), "media");
			seguradora1.cadastrarCliente(clientePf1);
		}
		
		System.out.println(seguradora1);
		
		// CADASTRA CLIENTE PJ
		
		List<Veiculo> listaVeiculos2 = new ArrayList<>();
		Veiculo veiculo2 = new Veiculo("EZG9836", "hyundai", "i30", 2014);
		listaVeiculos2.add(veiculo2);
		// O cliente eh cadastrado na seguradora apenas se o CNPJ for valido e se o CNPJ ainda nao foi cadastrado anteriormente.

		String cnpj = "36.834.324/0001-72"; // Testar com o cnpj 36.834.324/0001-70 (caso em que o cliente nao sera cadastrado)
		ClientePJ clientePj1 = null;
		
		if (ClientePJ.validarCnpj(cnpj) == true) {
			clientePj1 = new ClientePJ("RentCar", "Avenida Dr Guilherme 601", listaVeiculos2, cnpj, LocalDate.parse("1992-10-08"));
			seguradora1.cadastrarCliente(clientePj1);
		}
		
		System.out.println(seguradora1);	
		
		// GERA SINISTRO DE CLIENTE PF
		
		if (clientePj1 != null) {
			Sinistro sinistro = new Sinistro("01/05/2023", "Av. Reboucas, 102", seguradora1, veiculo1, clientePf1);
			seguradora1.gerarSinistro(sinistro);
		}
		
		System.out.println(seguradora1);
		
		
		// Remove cliente PF cadastrado
		
		if(seguradora1.removerCliente(cpf))		
			System.out.println(seguradora1);
		
		// Remove cliente PJ cadastrado
		
		if(seguradora1.removerCliente(cnpj))
			System.out.println(seguradora1);
		
		seguradora1.visualizarSinistro();
		seguradora1.listarClientes();
		
	}
		
	public static void visualizaDados(Seguradora seguradora) 
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("MENU Seguradora\n1- Nome\n2- Telefone\n3- Endereço\n4- E-mail\nEscolha a informacao que deseja visualizar:");
		int opcao = sc.nextInt();
		switch (opcao) {
		
		case 1:
			System.out.println(seguradora.getNome());
			break;
		case 2:
			System.out.println(seguradora.getTelefone());
			break;
		case 3:
			System.out.println(seguradora.getEndereco());
			break;
		case 4:
			System.out.println(seguradora.getEmail());
			break;
		default:
			System.out.println("Opcao invalida");
			break;
		}
		sc.close();
	}
}
		
		
		
//	ClientePF clientePf2 = new ClientePF("Krizia Maila", "Rua Joaquim Novaes 170", listaVeiculos, "386..926.858-00", "feminino", dataLicenca1, "ensino superior incompleto", dataNascimento1, "media");
//		
//		if (seguradora1.cadastrarCliente(clientePf2) == false) {
//			System.out.println("Cliente ja cadastrado anteriormente.");
//		}
//		else
//			System.out.println("Cliente cadastrado com sucesso.");
		
		
//		List<Cliente> listaCliente = new ArrayList<>();
//		
//
//		// Cadastrar cliente
//		
//		System.out.println("Nome: ");
//		String nome = sc.nextLine();
//		System.out.println("Endereco: ");
//		String endereco = sc.nextLine();
//		System.out.println("Quantidade de veiculos: ");
//		int qtdVeiculos = sc.nextInt();
//		
//		List<Veiculo> listaVeiculos = new ArrayList<>();
//		
//		for (int i = 0; i < qtdVeiculos; i++) {
//			System.out.println("Veiculo #" + (i + 1) + ":");
//			System.out.println("Placa: ");
//			String placa = sc.next();
//			System.out.println("Marca: ");
//			String marca = sc.next();
//			System.out.println("Modelo: ");
//			String modelo = sc.next();
//			System.out.println("Ano de fabricacao: ");
//			int anoFabricacao = sc.nextInt();
//			
//			Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
//			listaVeiculos.add(veiculo);
//		}
//
//		// Cadastrar cliente PF
//		
//		System.out.println("CPF: ");
//		String cpf = sc.next();
//		System.out.println("Genero: ");
//		String genero = sc.next();
//		System.out.println("Data licenca (dd/mm/aaaa): ");
//		LocalDate dataLicenca = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("Educacao: ");
//		sc.nextLine();
//		String educacao = sc.nextLine();
//		System.out.println("Data de nascimento (dd/mm/aaaa): ");
//		LocalDate dataNascimento = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		System.out.println("Classe economica: ");
//		String classeEconomica = sc.next(); 
//			
//			
//		ClientePF x = new ClientePF(nome, endereco, listaVeiculos, cpf, genero,dataLicenca,educacao, dataNascimento, classeEconomica);
//		listaCliente.add(x);
//		if (x.validarCPF() == true) {
//			System.out.println("CPF válido");
//		}
//		else {
//			System.out.println("CPF INVÁLIDO");
//		}
//
//		System.out.println(x);
//		
//		// OU Cadastrar cliente PJ
//		System.out.println("CNPJ");
//		String cnpj = sc.next();
//		System.out.println("Data de fundacao (dd/mm/aaaa): ");
//		LocalDate dataFundacao = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		
//		ClientePJ y = new ClientePJ(nome, endereco, listaVeiculos, cnpj, dataFundacao);
//		listaCliente.add(y);
//		if (y.validarCnpj() == true) {
//			System.out.println("CNPJ válido");
//		}
//		else {
//			System.out.println("CNPJ INVÁLIDO");
//		}
//			
//		System.out.println(y);
//
//	
//		// Remover Cliente
//		listaCliente.remove(x);
//		
//		Seguradora seguradora1 = new Seguradora();
//	
//		
//		Sinistro sinistro = new Sinistro(1, "22/04/2001", "rua tal num tal", seguradora1, x.getListaVeiculos().get(0), x);
//		List<Sinistro> listaSinistro = new ArrayList<>();
//		listaSinistro.add(sinistro);
//		Seguradora seguradora2 = new Seguradora("SafeCare", "112586-9785", "safecare@gmail.com", "Rua tal n 12", listaSinistro, listaCliente);
//		visualizaDados(seguradora2);
//		System.out.println(seguradora2);
	