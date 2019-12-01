package aula09.jpa.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;


public class TesteRemovePlacaComVeiculoAssociado {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Placa p = manager.find(Placa.class, 1L);
		Veiculo v = manager.find(Veiculo.class, 1L);
		System.out.println(p + "\n" + v);
		if (p == null) {
			System.out.println("\nNão há placa\n");
		}
		else if (p.getId() == v.getId()) {
			String res = "Há um Veículo associado à Placa e deve ser excluído para prosseguir. Digite 1 para excluir ambos ou outro valor para não excluir nada:";
			int a = Integer.parseInt(JOptionPane.showInputDialog(res));
			if (a == 1) {
				manager.remove(v);
				manager.remove(p);
				System.out.println("\nDepois de remover:" + p + "\n" + v + "\n");
				transaction.commit();
				System.out.println("\nDepois de commitar: " + p + "\n" + v + "\n");
				JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
			} else {
				System.out.println("\nRemoção cancelada\n");
			}
		}
		manager.close();
		JPAUtil.close();
		System.out.println(p + "\n" + v);
	}
}
