package aula09.jpa.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_veiculo")
public class Veiculo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Column (nullable = false, length = 100)
	private String marca;
	@Column (nullable = false, length = 100)
	private String modelo;
	@Column (nullable = false, length = 4)
	private String anoFabricacao;
	@Column (nullable = false, length = 20)
	private String cor;
	
	@OneToOne (optional = false)
	@JoinColumn (name = "id_da_placa")
	private Placa placa;
	
	@ManyToOne
	private Pessoa pessoa;
	
	//SEM CLASSE ASSOCIATIVA
	/*
	@ManyToMany
	@JoinTable (name = "tb_reboque_veiculo",
				joinColumns = @JoinColumn (name = "id_veiculo"),
				inverseJoinColumns = @JoinColumn (name = "id_reboque"))
	private List<Reboque> reboques;
	*/
	
	// COM CLASSE ASSOCIATIVA
	@OneToMany (mappedBy = "veiculo")
	private List<Aluguel> alugueis;
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public Placa getPlaca() {
		return placa;
	}
	public void setPlaca(Placa placa) {
		this.placa = placa;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	/*
	public List<Reboque> getReboques() {
		return reboques;
	}
	public void setReboques(List<Reboque> reboques) {
		this.reboques = reboques;
	}
	*/
	
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}
	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", anoFabricacao=" + anoFabricacao
				+ ", cor=" + cor + ", placa=" + placa + "]";
	}
	
	@Override
	public int hashCode() {
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
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}

}
