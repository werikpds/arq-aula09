package aula09.jpa.hibernate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesteInserirVeiculoReboqueAluguel {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Placa p1 = new Placa();
		p1.setCidade("Milão");
		Placa p2 = new Placa();
		p2.setCidade("Madri");
		manager.persist(p1);
		manager.persist(p2);
		Veiculo v = new Veiculo();
		v.setMarca("Lamborghini");
		v.setModelo("Gallardo");
		v.setAnoFabricacao("2018");
		v.setCor("Amarelo");
		v.setPlaca(p2);
		manager.persist(v);
		Reboque r = new Reboque();
		r.setPlaca(p1);
		manager.persist(r);
		Aluguel a = new Aluguel();		
		a.setDataAluguel(new Date());
		System.out.println (TimeZone.getDefault());
		a.setVeiculo(v);
		a.setReboque(r);
		manager.persist(a);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}
