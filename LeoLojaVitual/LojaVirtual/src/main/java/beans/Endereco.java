package beans;

import javax.persistence.Column;

public class Endereco {
	
	@Column(name = "rua", length = 60)
	private String rua;
	
	@Column(name = "bairro", length = 30)
	private String bairro;
	
	@Column(name = "cidade", length = 30)
	private String cidade;
	
	@Column(name = "uf", length = 2)
	private String uf;
	
	@Column(name = "cep")
	private int cep;
	
	@Column(name = "email", length = 40)
	private String email;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
