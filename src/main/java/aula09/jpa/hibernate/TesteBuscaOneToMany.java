package aula09.jpa.hibernate;

import javax.persistence.EntityManager;

public class TesteBuscaOneToMany {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		Pessoa p = manager.find(Pessoa.class, 3L);
		System.out.println("\n" + p.getNome() + p.getVeiculos() + "\n");
		manager.close();
		JPAUtil.close();
	}

}
