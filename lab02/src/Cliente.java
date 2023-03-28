
public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	// Getters e setters 
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "Cliente [getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getDataNascimento()="
				+ getDataNascimento() + ", getIdade()=" + getIdade() + ", getEndereco()=" + getEndereco()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	// Metodos para validar o cpf de um cliente
	
	public boolean validarCPF() {
		// Remove os caracteres nao numericos do CPF
		String regex  = "\\D";
		cpf = cpf.replaceAll(regex, "");
		
		// Verifica se o CPF tem 11 digitos. Se nao tiver retorna false
		if (cpf.length() != 11)
			return false;
		
		// Verifica se todos os digitos sao iguais. Se forem, retorna false

		boolean digitosIguais = true;
		for (int i = 0; i < 10; i++ ) {
			if (cpf.charAt(i) != cpf.charAt(i + 1))
				digitosIguais = false;			
		}
		if (digitosIguais == true) {
			return false;
		}
		// Calcula o primeiro digito verificador do cpf
		int soma = 0;
		for (int i = 10; i > 1; i--) {
			int peso = (cpf.charAt(10 - i) - 48) * i;
			soma += peso;
		}
		int resto = soma % 11;
		int primeiroVerificador;
		
		if (resto == 0 || resto == 1) {
			primeiroVerificador = 0;
		}
		else {
			primeiroVerificador = 11 - resto;
		}
		
		// Calcula o segundo digito verificador do cpf
		
		soma = 0;
		for (int i = 10; i > 1; i--) {
			int peso = (cpf.charAt(11 - i) - 48) * i;
			soma += peso;
		}
		resto = soma % 11;
		int segundoVerificador;
		
		if (resto == 0 || resto == 1) {
			segundoVerificador = 0;
		}
		else {
			segundoVerificador = 11 - resto;
		}
		
		// Verifica se os digitos verificadores sao iguais aos digitos verificadores do cpf
		
		if ((primeiroVerificador == (cpf.charAt(9) - 48)) && (segundoVerificador == (cpf.charAt(10) - 48))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
