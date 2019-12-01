package aula09.jpa.hibernate;
/*
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

public class TesteInsereVeiculoComPlacaReboqueComPlaca {
	public static void main (String [] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Placa p1 = new Placa();
		p1.setCidade("Belo Horizonte");
		Placa p2 = new Placa();
		p2.setCidade("São Caetano");
		Placa p3 = new Placa();
		p3.setCidade("Osasco");
		Placa p4 = new Placa();
		p4.setCidade("Vitória");
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
		manager.persist(p4);
		List<Reboque> reboques = new ArrayList<>();
		Reboque r1 = new Reboque();
		r1.setPlaca(p2);
		Reboque r2 = new Reboque();
		r2.setPlaca(p3);
		reboques.add(r1);
		reboques.add(r2);
		manager.persist(r1);
		manager.persist(r2);
		Veiculo v1 = new Veiculo();
		v1.setMarca("Toyota");
		v1.setModelo("Corolla");
		v1.setAnoFabricacao("2019");
		v1.setCor("Preto");
		v1.setPlaca(p1);
		v1.setReboques(reboques);
		Veiculo v2 = new Veiculo();
		v2.setMarca("Renault");
		v2.setModelo("Clio");
		v2.setAnoFabricacao("2000");
		v2.setCor("Azul");
		v2.setPlaca(p4);
		v2.setReboques(reboques);
		List<Veiculo> veiculos = new ArrayList<>();
		veiculos.add(v1);
		veiculos.add(v2);
		r1.setVeiculos(veiculos);
		r2.setVeiculos(veiculos);
		manager.persist(r1);
		manager.persist(r2);
		manager.persist(v1);
		manager.persist(v2);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}
}
*/