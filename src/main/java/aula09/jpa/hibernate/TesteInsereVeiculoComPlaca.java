package aula09.jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesteInsereVeiculoComPlaca {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Placa p = new Placa();
		p.setCidade("São Paulo");
		manager.persist(p);
		Veiculo v = new Veiculo();
		v.setMarca("Fiat");
		v.setModelo("Uno");
		v.setAnoFabricacao("1998");
		v.setCor("Verde");
		v.setPlaca(p);
		manager.persist(v);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}
