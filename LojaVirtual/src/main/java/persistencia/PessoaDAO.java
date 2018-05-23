package persistencia;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Pessoa;

public class PessoaDAO {

	
	/*public static void inserir(Pessoa pessoa) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(pessoa);
		t.commit();
		sessao.close();
	}*/
	
	public void salvar(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(pessoa);
		t.commit();
		sessao.close();
	}
	
	public void alterar(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(pessoa);
		t.commit();
		sessao.close();
	}
	
	/*public static void excluir(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(pessoa);
		t.commit();
		sessao.close();
	}*/
	
	/*public static List<Pessoa> listagem(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Pessoa order by pes_nome");
			
		}
		else {
			consulta = sessao.createQuery("from Pessoa where pes_nome like :parametro order by pes_nome");
			consulta.setString("parametro", "%" + filtro + "%");	
		}
		List lista = consulta.list();
		sessao.close();
		return lista;
	}*/
	
	public List<Pessoa> list() {
		List<Pessoa> result = null;
		try {
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			Query query = sessao.createQuery("FROM Pessoa");
			result = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
