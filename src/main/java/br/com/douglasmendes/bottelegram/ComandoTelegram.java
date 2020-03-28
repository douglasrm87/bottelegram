package br.com.douglasmendes.bottelegram;

import com.pengrad.telegrambot.model.Message;

public class ComandoTelegram {

	private static final String INFORMAR_O_IP_OU_PAT = "Informar o IP ou PAT";
	private static final String PING_4_N_1 = "ping -4 -n 1 ";
	private static final String FUNCOES = "\nFunções:\n";

	public final static String FORCE_POINT = "\nConectado na VPN ForcePoint.\n";
	public final static String LOGIN_RESULT = "\nAutorizado a usar o sistema.\n";

	public final static String AJUDA = "1 - Comandos disponivieis.\n";
	public final static String LOGIN = "2 - Informar matricula.\n";
	public final static String VPN_CONECTADA = "3 - VPN de Home Office.\n";
	public final static String PING_V4 = "4 - ping IP/PAT.\n";
	public final static String vetOpcoes[] = { FUNCOES, AJUDA, LOGIN, VPN_CONECTADA, PING_V4 };

	private String montarMensagemRetorno(Message msgTelegram) {
		StringBuilder msgRetorno = new StringBuilder();
		return msgRetorno.toString();
	}

	// A partir deste método para cada solicitação feita pelo usuário teremos um
	// retorno especifico.
	public String processarComando(int comandoTelegram, String nomeUsuario, String complementoComando) {
		StringBuilder msg = new StringBuilder();
		switch (comandoTelegram) {
		case 1:
			msg.append(iniciarTexto(nomeUsuario));
			break;
		case 2:
			msg.append(LOGIN_RESULT);
			break;

		case 3:
			msg.append(FORCE_POINT);
			break;

		case 4:
			if (complementoComando != null) {
				ComandoPing ping = new ComandoPing();
				// msg.append(ping.processar("ping -4 -n 1 L00000221"));
				msg.append(ping.processar(PING_4_N_1 + complementoComando));
			} else {
				msg.append(INFORMAR_O_IP_OU_PAT);
			}
			break;

		default:
			msg.append(iniciarTexto(nomeUsuario));
			break;
		}
		return msg.toString();

	}

	private String iniciarTexto(String nomeUsuario) {
		StringBuilder msg = new StringBuilder();
		msg.append("\nBom dia: " + nomeUsuario);
		for (int i = 0; i < vetOpcoes.length; i++) {
			msg.append(vetOpcoes[i]);
		}
		return msg.toString();
	}

}
