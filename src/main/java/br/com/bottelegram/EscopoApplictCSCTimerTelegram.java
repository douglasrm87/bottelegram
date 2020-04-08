package br.com.bottelegram;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.bottelegram.comando.dto.GestaoAtendimento;
import br.com.bottelegram.comando.dto.InteracaoComando;
import br.com.bottelegram.comando.dto.VPNConectadaExcel;
import br.com.bottelegram.excel.PlanilhaExcelVPNConectada;

@ApplicationScoped
@ManagedBean(name = "telegram", eager = true)
public class EscopoApplictCSCTimerTelegram implements Serializable {

	private static final long serialVersionUID = 1L;
	private int delay = 4000; // delay de 4 seg.
	private int interval = 4000; // intervalo de 4 seg.
	private FluxoTelegram webTelegram = new FluxoTelegram();

	public static Map<Long, InteracaoComando> mapaClienteComando = new HashMap<>();
	public static List<GestaoAtendimento> listaGestao = new ArrayList<>();
	public static List<VPNConectadaExcel> listaExcelVPNs = null;

	@PostConstruct
	public void iniciarOuvinteTelegram() {
		System.out.println("***********************************");
		System.out.println("Iniciando CSC BOT Telegram.");
		System.out.println("***********************************");

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				EscopoApplictCSCTimerTelegram.this.webTelegram.iniciarChatBotTelegram();
			}
		}, this.delay, this.interval);
	}

	public static void main(String[] args) {
		new EscopoApplictCSCTimerTelegram().processar();
	}

	private void processar() {
		iniciarOuvinteTelegram();
	}

	public EscopoApplictCSCTimerTelegram() {
		super();
	}

}
