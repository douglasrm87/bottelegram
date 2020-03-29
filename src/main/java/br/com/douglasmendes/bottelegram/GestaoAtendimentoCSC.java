package br.com.douglasmendes.bottelegram;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.douglasmendes.bottelegram.comando.dto.GestaoAtendimento;

@ViewScoped
@ManagedBean(name = "gestao")
public class GestaoAtendimentoCSC {
	private List<GestaoAtendimento> listaGestaoJSF = new ArrayList<>();

	public List<GestaoAtendimento> getListaGestaoJSF() {
		this.listaGestaoJSF = EscopoApplictCSCTimerTelegram.listaGestao;
		return this.listaGestaoJSF;
	}

	public void setListaGestaoJSF(List<GestaoAtendimento> listaGestaoJSF) {
		this.listaGestaoJSF = listaGestaoJSF;
	}

	public void testeGestao() {
		System.out.println("Teste Gestao");
	}
}
