package br.com.douglasmendes.bottelegram;

import com.pengrad.telegrambot.model.Message;

public class ComandoTelegram {

	private static final String FUNCOES = "\nFunções:\n";
	public final static String AJUDA = "1 - Comandos disponivieis.\n";
	public final static String LOGIN = "2 - Informar matricula.\n";
	public final static String VPN_CONECTADA = "3 - VPN de Home Office.\n";
	public final static String PING_V4 = "4 - ping IP/PAT.\n";
	public final static String FORCE_POINT = "\nConectado na VPN ForcePoint.\n";
	public final static String LOGIN_RESULT = "\nAutorizado a usar o sistema.\n";

	private String montarMensagemRetorno(Message msgTelegram) {
		StringBuilder msgRetorno = new StringBuilder();
		return msgRetorno.toString();
	}

	// A partir deste método para cada solicitação feita pelo usuário teremos um retorno especifico.
	public String processarComando(int comandoTelegram, String msgTelegram) {
		StringBuilder msg = new StringBuilder();
		switch (comandoTelegram) {
		case 1:
			msg.append(iniciarTexto(msgTelegram));
			break;
		case 2:
			msg.append(LOGIN_RESULT);
			break;
			
		case 3:
			msg.append(FORCE_POINT);
			break;

		case 4:
			ComandoPing ping = new ComandoPing();
			msg.append(ping.processar("ping -4 -n 1 L00000221"));
			break;

		default:
			msg.append(iniciarTexto(msgTelegram));
			break;
		}
		return msg.toString();

	}

	private String iniciarTexto(String msgTelegram) {
		StringBuilder msg = new StringBuilder();
		msg.append("\nBom dia: " + msgTelegram);
		msg.append(FUNCOES);
		msg.append(AJUDA);
		msg.append(LOGIN);
		msg.append(VPN_CONECTADA);
		return msg.toString();
	}

}
