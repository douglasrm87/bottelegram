package br.com.douglasmendes.bottelegram;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.douglasmendes.bottelegram.util.Util;
import java.util.Timer;
import java.util.TimerTask;

@ApplicationScoped
@ManagedBean(name = "botTelegram", eager = true)
public class EscopoApplictCSCTimerTelegram {
	int delay = 4000; // delay de 4 seg.
	int interval = 4000; // intervalo de 4 seg.

	public String mensagemTeste;
	
	private IniciaWEBTelegram webTelegram = new IniciaWEBTelegram();
	@PostConstruct
	public void timeout() {

		Util.addLoggerInfo("Iniciando CSC BOT Telegram.");
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				EscopoApplictCSCTimerTelegram.this.webTelegram.iniciarChatBotTelegram();
			}
		}, this.delay, this.interval);
	}
	public String getMensagemTeste() {
		return this.mensagemTeste;
	}
	public void setMensagemTeste(String mensagemTeste) {
		this.mensagemTeste = mensagemTeste;
	}

	public void metodoTeste() {
		System.out.println("Teste página");
	}
}
