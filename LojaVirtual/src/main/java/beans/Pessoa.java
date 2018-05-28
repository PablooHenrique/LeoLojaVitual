package beans;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 60, nullable = true)
	private String nome;
	
	@Column(name = "cpf", length = 14)
	private String cpf;
	
	@Column(name = "rg", length = 20)
	private String rg;
	
	@Column(name = "data_nascimento", length = 20)
	private Date dataNascimento;
	
	@Column(name = "email", length = 20)
	private String email;
	
	@Column(name = "senha", length = 45)
	private String senha;
	
	@Embedded
	private Endereco endereco;

	public Pessoa() {
		if (this.getEndereco() == null) {
			setEndereco(new Endereco());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
