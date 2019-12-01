package aula09.jpa.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_reboque")
public class Reboque {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@OneToOne (optional = false)
	@JoinColumn (name = "id_da_placa")
	private Placa placa;
	
	
	// SEM CLASSE ASSOCIATIVA
	/*
	@ManyToMany (mappedBy = "reboques")
	private List<Veiculo> veiculos;
	*/
	
	// COM CLASSE ASSOCIATIVA
	@OneToMany (mappedBy = "reboque")
	private List<Aluguel> alugueis;
	
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Placa getPlaca() {
		return placa;
	}

	public void setPlaca(Placa placa) {
		this.placa = placa;
	}
	
	/*
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	*/
	
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reboque other = (Reboque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
