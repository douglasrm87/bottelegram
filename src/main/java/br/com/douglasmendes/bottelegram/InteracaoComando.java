package br.com.douglasmendes.bottelegram;

public class InteracaoComando {
	private Long idUsuario;
	private String nomeUsuario;
	private int idComando;
	private String complementoComando;
	public Long getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public int getIdComando() {
		return this.idComando;
	}
	public void setIdComando(int idComando) {
		this.idComando = idComando;
	}
	public String getComplementoComando() {
		return this.complementoComando;
	}
	public void setComplementoComando(String complementoComando) {
		this.complementoComando = complementoComando;
	}
	public InteracaoComando(Long idUsuario, String nomeUsuario, int idComando, String complementoComando) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.idComando = idComando;
		this.complementoComando = complementoComando;
	}
	

}
