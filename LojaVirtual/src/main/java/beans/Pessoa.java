package beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome", length = 60, nullable = true)
	private String nome;
	
	@Column(name = "cpf", length = 14)
	private String cpf;
	
	@Column(name = "rg", length = 20)
	private String rg;
	
	@Column(name = "data_nascimento", length = 20)
	private Date dataNascimento;
	
	@Embedded
	private Endereco endereco;
	
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Telefone> telefones;
}
