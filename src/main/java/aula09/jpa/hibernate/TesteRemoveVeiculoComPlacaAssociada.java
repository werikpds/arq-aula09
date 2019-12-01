package aula09.jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesteRemoveVeiculoComPlacaAssociada {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Veiculo v = manager.find(Veiculo.class, 1L);
		System.out.println("Veiculo" + v);
		manager.remove(v);
		System.out.println("Depois de remover" + v);
		transaction.commit();
		System.out.println("Depois de commitar" + v);
		manager.close();
		JPAUtil.close();
	}
}
