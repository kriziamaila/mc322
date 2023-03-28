import java.util.Random;

public class Sinistro {
	
	private int id;
	private String data;
	private String endereco;
	
	// Getters e setters 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	// Geracao de IDs
	
	public int geraID() {
		Random random = new Random();
		int rand = 0;
		while (true){
		    rand = random.nextInt(10000);
		    if(rand !=0) {
		    	return rand;
		    }
		}
	}
	
	

}
