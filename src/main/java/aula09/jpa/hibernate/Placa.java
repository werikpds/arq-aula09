package aula09.jpa.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_placa")
public class Placa {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Column (nullable = false, length = 100)
	private String cidade;
	
	@OneToOne (mappedBy = "placa")
	@JoinColumn (name = "id_do_veiculo")
	private Veiculo veiculo;
	
	@OneToOne (mappedBy = "placa")
	@JoinColumn (name = "id_do_reboque")
	private Reboque reboque;
	
	// getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
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
	public String toString() {
		return "Placa [id=" + id + ", cidade=" + cidade + "]";
	}
	
	@Override
	public int hashCode () {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Placa other = (Placa) obj;
		if (id == null) {
			if (other.cidade != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
