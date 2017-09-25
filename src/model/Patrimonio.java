package model;


public class Patrimonio {
	
	private int codigo;
	private String situacao;
	private String responsavel;
	private String setor;
	private String local;
	private String material;
	private String marca;
	private String modelo;
	private String data;
	
	/*public Patrimonio(int codigo, int situacao, String responsavel, String setor, String local, String material,
			String marca, String modelo) {
		super();
		this.codigo = codigo;
		this.situacao = situacao;
		this.responsavel = responsavel;
		this.setor = setor;
		this.local = local;
		this.material = material;
		this.marca = marca;
		this.modelo = modelo;
	} */

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
	
	
	
}
