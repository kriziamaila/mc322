
public class Main {

	public static void main(String[] args) {
		
		String nome = "Krizia";
		String telefone = "11965451515";
		String email = "k248086@dac.unicamp.br";
		String endereco = "Rua tal, numero tal"; 
		Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);
		Cliente cliente = new Cliente();
		Veiculo veiculo = new Veiculo();
		Sinistro sinistro = new Sinistro();

	}

}
