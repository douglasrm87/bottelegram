package br.com.douglasmendes.bottelegram;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean(name = "telegram", eager = true)
public class EscopoApplictCSCTimerTelegram implements Serializable {
	private int delay = 4000; // delay de 4 seg.
	private int interval = 4000; // intervalo de 4 seg.
	private FluxoTelegram webTelegram = new FluxoTelegram();

	@PostConstruct
	public void iniciarOuvinteTelegram() {
		System.out.println("Iniciando CSC BOT Telegram.");
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
