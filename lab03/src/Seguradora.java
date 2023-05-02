import java.util.ArrayList;
import java.util.List;


public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Sinistro> listaSinistros;
	private List<Cliente> listaClientes;
	
	// Construtor

	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		listaSinistros = new ArrayList<>();
		listaClientes = new ArrayList<>();
	}	

	// Getters e setters 
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public List<Sinistro> getListaSinistros() {
		return listaSinistros;
	}


	public void setListaSinistros(List<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}


	public List<Cliente> getlistaClientes() {
		return listaClientes;
	}


	public void setlistaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
	// Cadastrar cliente: cliente cadastrado com sucesso retorna True.

	public boolean cadastrarCliente(Cliente cliente) {
		if (listaClientes.isEmpty()) {
			listaClientes.add(cliente);
			if (cliente instanceof ClientePF)
				System.out.println("Cliente PF cadastrado com sucesso.");
			else
				System.out.println("Cliente PJ cadastrado com sucesso.");
			
			return true;
		}
		for (int i = 0; i < listaClientes.size(); i++)
		{
			if ((listaClientes.get(i) instanceof ClientePF) && (cliente instanceof ClientePF)) 
			{
				ClientePF pfLista = (ClientePF) listaClientes.get(i);
				ClientePF pfParametro = (ClientePF) cliente;
				if (pfLista.getCpf().equals(pfParametro.getCpf())) {
					System.out.println("Cliente PF ja cadastrado anteriormente");
					return false;	
				}		
			}
			else if ((listaClientes.get(i) instanceof ClientePJ) && (cliente instanceof ClientePJ))
			{
				ClientePJ pjLista = (ClientePJ) listaClientes.get(i);
				ClientePJ pjParametro = (ClientePJ) cliente;
				if (pjLista.getCnpj().equals(pjParametro.getCnpj())) 
				{
					System.out.println("Cliente PJ ja cadastrado anteriormente");
					return false;
				}	
			}
			
		}
		listaClientes.add(cliente);
		if (cliente instanceof ClientePF)
			System.out.println("Cliente PF cadastrado com sucesso.");
		else
			System.out.println("Cliente PJ cadastrado com sucesso.");
		return true;
	}
	
	// Remover cliente (remove todos os sinistros associados a esse cliente)
	
	public boolean removerCliente(String cliente) 
	{
		String regex  = "\\D";
		cliente = cliente.replaceAll(regex, "");
		for (int i = 0; i < listaClientes.size(); i++) {
			if ((listaClientes.get(i) instanceof ClientePF) && (cliente.length() == 11)) 
			{
				ClientePF pfLista = (ClientePF) listaClientes.get(i);
				if (pfLista.getCpf().equals(cliente)) {
					System.out.println("Cliente PF removido com sucesso.");
					listaClientes.remove(i);
					for (int j = 0; j < listaSinistros.size(); j++) {
						if (listaSinistros.get(j).getCliente()  instanceof ClientePF) {
							ClientePF pfSinistro = (ClientePF) listaSinistros.get(j).getCliente();
							if (pfSinistro.getCpf().equals(cliente)) {
								listaSinistros.remove(j);
							}
						}
					}
					return true;
				}	
			}
			else if ((listaClientes.get(i) instanceof ClientePJ) && (cliente.length() > 11))
			{
				ClientePJ pjLista = (ClientePJ) listaClientes.get(i);
				if (pjLista.getCnpj().equals(cliente)) {
					listaClientes.remove(i);
					System.out.println("Cliente PJ removido com sucesso.");
					for (int j = 0; j < listaSinistros.size(); j++) {
						if (listaSinistros.get(j).getCliente()  instanceof ClientePJ) {
							ClientePJ pjSinistro = (ClientePJ) listaSinistros.get(j).getCliente();
							if (pjSinistro.getCnpj().equals(cliente)) {
								listaSinistros.remove(j);
							}
						}
					}
					return true;
				}				
			}
		}
		System.out.println("Cliente inexistente para remocao");
		return false;
	}
	
	// Listar clientes
	
	public void listarClientes() {
		System.out.println(listaClientes);
		
	}
	
	// Gerar sinistro 
	public boolean gerarSinistro(Sinistro sinistro)
	{
		if (listaClientes.isEmpty()) {
			System.out.println("Cliente Sinistro inexiste nessa seguradora");
			return false;
		}
		
		for (int i = 0; i < listaClientes.size(); i++)
		{
			if ((listaClientes.get(i) instanceof ClientePF) && (sinistro.getCliente() instanceof ClientePF)) 
			{
				ClientePF pfLista = (ClientePF) listaClientes.get(i);
				ClientePF pfParametro = (ClientePF) sinistro.getCliente();
				if (pfLista.getCpf().equals(pfParametro.getCpf())) 
				{
					System.out.println("Cliente Sinistro PF pertence à seguradora");
					for (int j = 0; j < listaClientes.get(i).getListaVeiculos().size(); j++)
					{
						if (listaClientes.get(i).getListaVeiculos().get(j).getPlaca().equals(sinistro.getVeiculo().getPlaca())) {
							System.out.println("Veiculo de Cliente Sinistro PF pertence à seguradora");
							listaSinistros.add(sinistro);
							return true;
						}
					}
				}	
			}		
			else if ((listaClientes.get(i) instanceof ClientePJ) && (sinistro.getCliente() instanceof ClientePJ))
			{
				ClientePJ pjLista = (ClientePJ) listaClientes.get(i);
				ClientePJ pjParametro = (ClientePJ) sinistro.getCliente();
				if (pjLista.getCnpj().equals(pjParametro.getCnpj())) 
				{
					System.out.println("Cliente Sinistro PJ pertence à seguradora");
					for (int j = 0; j < listaClientes.get(i).getListaVeiculos().size(); j++) 
					{
						if (listaClientes.get(i).getListaVeiculos().get(j).getPlaca().equals(sinistro.getVeiculo().getPlaca()))
						{
							System.out.println("Veiculo de Cliente Sinistro PJ pertence à seguradora");
							listaSinistros.add(sinistro);
							return true;							
						}
					}
				}
			}
		}
		return false;
	}
	
	// Visualizar sinistro
	public boolean visualizarSinistro() {
		System.out.println(listaSinistros);
		return true;
	}
	
	public void listarSinistros() {
		System.out.println(listaSinistros);
	}

	//@Override
	public String toString() {
		return "Seguradora [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ ", listaSinistros=" + listaSinistros + ", listaClientes=" + listaClientes + "]";
	}
	

}
