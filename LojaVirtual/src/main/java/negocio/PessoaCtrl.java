package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import beans.Endereco;
import beans.Pessoa;
import beans.Telefone;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private String filtro = "";
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private Endereco endereco;
	public List<Pessoa> lista = new ArrayList<>();

	@PostConstruct
	public void init(){
		this.pessoa = new Pessoa();
		this.endereco = new Endereco();
		this.pessoaDAO = new PessoaDAO();
		this.lista = pessoaDAO.list();
	}

	public String inserir() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(pessoa.getId() == null) {
			pessoaDAO.salvar(pessoa);
		 context.addMessage(null, new FacesMessage("Sucesso", "Inserido com sucesso"));
	 }else{
		 pessoaDAO.alterar(pessoa);
		context.addMessage(null, new FacesMessage("Sucesso", "Alterado com Sucesso"));
		 }
		return"pessoa";
	}

	public String actionInserir() {
		pessoa = new Pessoa();
		return "lista_pessoa";

	}

	/*
	 * public String actionExcluir() { PessoaDAO.excluir(pessoa); return
	 * "lista_pessoa"; }
	 */

	public String actionInserirFone() {
		// Telefone fone = new Telefone();
		// fone.setPessoa(pessoa);
		// pessoa.getFones().add(fone);
		// return "lista_pessoa";
		return "";
	}

	public String actionExcluirFone(Telefone fone) {
		// getPessoa().getFones().remove(fone);
		// FoneDAO.excluir(fone);
		return "lista_pessoa";

	}

	public void onRowSelect(SelectEvent event) {
		// FacesMessage msg = new FacesMessage("Forma de Pagamento Selecionada",
		// String.valueOf(((Pessoa) event.getObject()).getId()));
		// FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	// Geters and seters

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}
	
	public List<Pessoa> getLista() {
		this.lista = pessoaDAO.list();
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
