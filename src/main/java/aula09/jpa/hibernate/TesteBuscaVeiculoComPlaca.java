package aula09.jpa.hibernate;

import javax.persistence.EntityManager;

public class TesteBuscaVeiculoComPlaca {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		Veiculo v = manager.find(Veiculo.class, 1L);
		//System.out.println("\n" + v + "\n");
		System.out.println("\n" + v.getPlaca().getVeiculo() + "\n");
		manager.close();
		JPAUtil.close();
	}

}
