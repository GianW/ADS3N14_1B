public class CadastroParada {
	private String nomeOrigem;
	private String nomeDestino;
	private int Kms;
	private String Tipo;
	
	
	public CadastroParada() {
	}
	
	public CadastroParada(String nomeOrigem, String nomeDestino, int Kms, String Tipo) {
		this.nomeOrigem = nomeOrigem;
		this.nomeDestino = nomeDestino;
		this.Kms = Kms;
		this.Tipo = Tipo;
	}
	
	public int getKms() {
		return Kms;
	}
	public String getNomeDestino() {
		return nomeDestino;
	}
	public String getNomeOrigem() {
		return nomeOrigem;
	}
	public void setKms(int kms) {
		Kms = kms;
	}
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}
	public void setNomeOrigem(String nomeOrigem) {
		this.nomeOrigem = nomeOrigem;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getTipo() {
		return Tipo;
	}
}

