package aula09.jpa.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesteInsereDoisVeiculosComPlacaUmaPessoa {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Pessoa p = new Pessoa();
		p.setNome("Rafael Silva Sanches");
		p.setRg("12345678-9");
		Placa pl1 = new Placa();
		pl1.setCidade("São Paulo");
		Placa pl2 = new Placa();
		pl2.setCidade("Rio de Janeiro");
		manager.persist(pl1);
		manager.persist(pl2);
		List<Veiculo> veiculos = new ArrayList<>();
		Veiculo v1 = new Veiculo();
		v1.setMarca("Chevrolet");
		v1.setModelo("Corsa");
		v1.setAnoFabricacao("2008");
		v1.setCor("Prata");
		v1.setPlaca(pl1);
		v1.setPessoa(p);
		Veiculo v2 = new Veiculo();
		v2.setMarca("Volkswagen");
		v2.setModelo("Gol");
		v2.setAnoFabricacao("2018");
		v2.setCor("Vermelho");
		v2.setPlaca(pl2);
		v2.setPessoa(p);
		veiculos.add(v1);
		veiculos.add(v2);
		p.setVeiculos(veiculos);
		manager.persist(p);
		manager.persist(v1);
		manager.persist(v2);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}
