import java.time.LocalDate;
import java.util.List;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private LocalDate dataFundacao;
	
	// Construtor
	
	public ClientePJ(String nome, String endereco, List<Veiculo> listaVeiculos, String cnpj, LocalDate dataFundacao) {
		super(nome, endereco, listaVeiculos);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}
	
	// Gets and Sets
	
	public String getCnpj() {
		return cnpj;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	// Metodos para validar o cnpj de um cliente
	
	public boolean validarCnpj()
	{
		// Remove os caracteres nao numericos do Cnpj
		String regex  = "\\D";
		String numerosCnpj = cnpj.replaceAll(regex, "");
		
		// Verifica se o Cnpj tem 14 digitos. Se nao tiver retorna false
		if (numerosCnpj.length() != 14)
			return false;
		
		// Verifica se todos os digitos sao iguais. Se forem, retorna false
		
		boolean todosDigitosIguais = true;
		for (int i = 0; i < 10; i++ ) {
			// Procura digito diferente
			if (numerosCnpj.charAt(i) != numerosCnpj.charAt(i + 1)) {
				todosDigitosIguais = false;		
				break;
			}	
		}
		if (todosDigitosIguais == true) {
			return false;
		}

		// Calcula o primeiro digito verificador do cnpj
		int soma = 0;
		int multiplicador1[] = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		for (int i = 0; i < 12; i++) {
			int peso = (numerosCnpj.charAt(i) - 48) * multiplicador1[i];
			soma += peso;
		}
		int resto = soma % 11;
		int primeiroVerificador;
		
		if (resto < 2) 
			primeiroVerificador = 0;
		else
			primeiroVerificador = 11 - resto;
		
		// Calcula o segundo digito verificador do cnpj
		
		soma = 0;
		int multiplicador2[] = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		for (int i = 0; i < 13; i++) {
			int peso = (numerosCnpj.charAt(i) - 48) * multiplicador2[i];
			soma += peso;
		}
		resto = soma % 11;
		int segundoVerificador;
		
		if (resto < 2) 
			segundoVerificador = 0;
		else 
			segundoVerificador = 11 - resto;
		
		// Verifica se os digitos verificadores sao iguais aos digitos verificadores do cnpj
			
		if ((primeiroVerificador == (numerosCnpj.charAt(9) - 48)) && (segundoVerificador == (numerosCnpj.charAt(10) - 48))) 
			return true;
		else
			return false;
	}

	// toString
	@Override
	public String toString() {
		return super.toString() + "ClientePJ [cnpj=" + cnpj + ", dataFundacao=" + dataFundacao + "]";
	}	
}
