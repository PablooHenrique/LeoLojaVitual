package persistencia;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Telefone;

public class FoneDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void excluir(Telefone fone) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(fone);
		t.commit();
		sessao.close();
	}
}
