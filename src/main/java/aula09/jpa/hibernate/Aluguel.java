package aula09.jpa.hibernate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_aluguel")
public class Aluguel {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataAluguel;
	
	@ManyToOne
	private Veiculo veiculo;
	@ManyToOne
	private Reboque reboque;
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataAluguel() {
		return dataAluguel;
	}
	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Reboque getReboque() {
		return reboque;
	}
	public void setReboque(Reboque reboque) {
		this.reboque = reboque;
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
		Aluguel other = (Aluguel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
