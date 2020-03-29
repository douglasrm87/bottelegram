package br.com.douglasmendes.bottelegram;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.douglasmendes.bottelegram.comando.dto.GestaoAtendimento;
//http://localhost:8080/bottelegram/gestaocsc.jsf
@ViewScoped
@ManagedBean(name = "gestao")
public class GestaoAtendimentoCSC {
	private List<GestaoAtendimento> listaGestaoJSF = new ArrayList<>();

	public List<GestaoAtendimento> getListaGestaoJSF() {
		////	public static List<GestaoAtendimento> listaGestao = new ArrayList<>();
//		this.listaGestaoJSF = EscopoApplictCSCTimerTelegram.listaGestao;
		return this.listaGestaoJSF;
	}

	public void setListaGestaoJSF(List<GestaoAtendimento> listaGestaoJSF) {
		this.listaGestaoJSF = listaGestaoJSF;
	}

	public void testeGestao() {
		System.out.println("Teste Gestao");
	}
}
