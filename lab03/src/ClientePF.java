import java.time.LocalDate;
import java.util.List;

public class ClientePF extends Cliente{
	private final String cpf;
	private String genero;
	private LocalDate dataLicenca;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;
	
	// Construtor
	
	public ClientePF(String nome, String endereco, List<Veiculo> listaVeiculos, String cpf, String genero,
			LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica) {
		super(nome, endereco, listaVeiculos);
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
	}
	
	// Getters e setters

	public String getCpf() {
		return cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(LocalDate dataLicenca) {
		this.dataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	// Metodos para validar o cpf de um cliente
	
	public boolean validarCPF() {
		// Remove os caracteres nao numericos do CPF
		String regex  = "\\D";
		String numerosCpf = cpf.replaceAll(regex, "");
		
		// Verifica se o CPF tem 11 digitos. Se nao tiver retorna false
		if (numerosCpf.length() != 11)
			return false;
		
		// Verifica se todos os digitos sao iguais. Se forem, retorna false

		boolean todosDigitosIguais = true;
		for (int i = 0; i < 10; i++ ) {
			// Procura digito diferente
			if (numerosCpf.charAt(i) != numerosCpf.charAt(i + 1)) {
				todosDigitosIguais = false;		
				break;
			}	
		}
		if (todosDigitosIguais == true) {
			return false;
		}
		// Calcula o primeiro digito verificador do cpf
		int soma = 0;
		for (int i = 10; i > 1; i--) {
			int peso = (numerosCpf.charAt(10 - i) - 48) * i;
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
			int peso = (numerosCpf.charAt(11 - i) - 48) * i;
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
		
		if ((primeiroVerificador == (numerosCpf.charAt(9) - 48)) && (segundoVerificador == (numerosCpf.charAt(10) - 48))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// toString()
	

	@Override
	public String toString() {
		return super.toString() + "ClientePF [cpf=" + cpf + ", genero=" + genero + ", dataLicenca=" + dataLicenca + ", educacao="
				+ educacao + ", dataNascimento=" + dataNascimento + ", classeEconomica=" + classeEconomica + "]";
	}

}
