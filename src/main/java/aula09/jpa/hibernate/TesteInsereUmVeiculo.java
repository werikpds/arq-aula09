package aula09.jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesteInsereUmVeiculo {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Veiculo v = new Veiculo();
		v.setMarca("Chevrolet");
		//v.setMarca("Fiat");
		v.setModelo("Corsa");
		//v.setModelo("Uno");
		v.setAnoFabricacao("2008");
		//v.setAnoFabricacao("1998");
		v.setCor("Prata");
		//v.setCor("Verde");
		manager.persist(v);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}
