public class CadastroPonto {
	 private String nome;
	 private String destino;
	 private int custo;
	 
	 public CadastroPonto() {

	 }
	 
	 
	 public CadastroPonto(String nome, String destino, int custo) {
			this.nome = nome;
			this.destino = destino;
			this.custo = custo;
	 }
	 
	 
	public int getCusto() {
		return custo;
	}
	public String getDestino() {
		return destino;
	}
	public String getNome() {
		return nome;
	}
	public void setCusto(int custo) {
		this.custo = custo;		
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	 
	
}
