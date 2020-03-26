package br.com.douglasmendes.bottelegram;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

//@ApplicationScoped
//	@PostConstruct
//@ManagedBean(name = "telegram"/* , eager = true */)

public class EscopoApplictCSCTimerTelegram implements Serializable {
	private int delay = 4000; // delay de 4 seg.
	private int interval = 4000; // intervalo de 4 seg.
//	private FluxoTelegram webTelegram = new FluxoTelegram();



	/*
	 * public void iniciarOuvinteTelegram() {
	 * System.out.println("Iniciando CSC BOT Telegram."); Timer timer = new Timer();
	 * timer.scheduleAtFixedRate(new TimerTask() { public void run() {
	 * EscopoApplictCSCTimerTelegram.this.webTelegram.iniciarChatBotTelegram(); } },
	 * this.delay, this.interval); }
	 */
	

	public static void main(String[] args) {
		new EscopoApplictCSCTimerTelegram().processar();
	}

	private void processar() {
//		iniciarOuvinteTelegram();
	}

	public EscopoApplictCSCTimerTelegram() {
		super();
	}

}
