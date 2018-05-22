package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import beans.Pessoa;
import beans.Telefone;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = -6898332734920770502L;
	private Pessoa pessoa;
	private String filtro = "";
	private PessoaDAO pessoaDAO;
	public List<Pessoa> lista = new ArrayList<>();

	public String inserir() {
		getPessoaDAO().salvar(pessoa);
		getPessoa();
		return "pessoa";
	}

	public String actionGravar() {
		FacesContext context = FacesContext.getCurrentInstance();
		// if (pessoa.getId() == 0) {
		// PessoaDAO.inserir(pessoa);
		// context.addMessage(null, new FacesMessage("Sucesso", "Inserido com
		// sucesso"));
		// } else {
		// PessoaDAO.alterar(pessoa);
		// context.addMessage(null, new FacesMessage("Sucesso", "Alterado com
		// Sucesso"));
		// }
		return "lista_pessoa";
	}

	public String actionInserir() {
		pessoa = new Pessoa();
		return "lista_pessoa";

	}

	/*public String actionExcluir() {
		PessoaDAO.excluir(pessoa);
		return "lista_pessoa";
	}*/

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
		if(pessoa == null) {
			setPessoa(new Pessoa());
		}
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
		if(pessoaDAO == null) {
			setPessoaDAO(new PessoaDAO());
		}
		return pessoaDAO;
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	public List<Pessoa> getLista() {
		return lista;
	}

	public void setLista(List<Pessoa> lista) {
		this.lista = lista;
	}

}
