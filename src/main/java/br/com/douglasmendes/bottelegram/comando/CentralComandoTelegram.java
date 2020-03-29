package br.com.douglasmendes.bottelegram.comando;

import java.util.Calendar;
import java.util.Date;

import com.pengrad.telegrambot.model.Message;

import br.com.douglasmendes.bottelegram.EscopoApplictCSCTimerTelegram;
import br.com.douglasmendes.bottelegram.comando.dto.GestaoAtendimento;

public class CentralComandoTelegram {

	private static final String BOM_DIA = "\nBom dia: ";
	private static final String BOA_TARDE = "\nBoa tarde: ";
	private static final String BOA_NOITE = "\nBoa noite: ";
	private static final String EMAIL_NÃO_ENVIADO_ENTRAR_EM_CONTATO_COM_O_SERVICE_DESK = "Email não enviado. Entrar em contato com o Service Desk.";
	private static final String EMAIL_ENVIADO_COM_SUCESSO_PARA = "Email enviado com sucesso para: ";
	private static final String INFORMAR_O_IP_OU_PAT = "Informar o IP ou PAT";
	private static final String INFORMAR_MATRICULA = "Informar a sua matricula (c0xxxxx)";
	private static final String PING_4_N_1 = "ping -4 -n 1 ";
	private static final String FUNCOES = "\nFunções:\n";

	public final static String FORCE_POINT = "\nConectado na VPN ForcePoint.\n";
	public final static String LOGIN_RESULT = "\nAutorizado a usar o sistema.\n";

	public final static String AJUDA = "1 - Comandos disponivieis.\n";
	public final static String LOGIN = "2 - Informar matricula.\n";
	public final static String VPN_CONECTADA = "3 - VPN de Home Office.\n";
	public final static String PING_V4 = "4 - ping IP/PAT.\n";
	public final static String LIGAR_PC = "5 - Ligar PC.\n";
	public final static String INSTALAR_VPN = "6 - Instalar VPN.\n";
	public final static String SENHA_ADM = "7 - Senha Administrador.\n";
	public final static String ANTI_VIRUS = "8 - Instalar Anti Virus.\n";
	public final static String vetOpcoes[] = { FUNCOES, AJUDA, LOGIN, VPN_CONECTADA, PING_V4, LIGAR_PC, INSTALAR_VPN,
			SENHA_ADM, ANTI_VIRUS };

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
			if (complementoComando != null) {
				ComandoVPNConectada comVPN = new ComandoVPNConectada();
				msg.append(comVPN.localizarVPN(complementoComando));
				EscopoApplictCSCTimerTelegram.listaGestao
						.add(new GestaoAtendimento(complementoComando, null, VPN_CONECTADA, new Date()));
			} else {
				msg.append(INFORMAR_MATRICULA);
			}
			break;
		case 4:
			if (complementoComando != null) {
				ComandoPing ping = new ComandoPing();
				msg.append(ping.processar(PING_4_N_1 + complementoComando));
				EscopoApplictCSCTimerTelegram.listaGestao
						.add(new GestaoAtendimento(complementoComando, null, PING_V4, new Date()));
			} else {
				msg.append(INFORMAR_O_IP_OU_PAT);
			}
			break;
		case 5:
			if (complementoComando != null) {
				ComandoWakeOnLAN ligar = new ComandoWakeOnLAN();
				ligar.ligarDesktop(complementoComando);
				EscopoApplictCSCTimerTelegram.listaGestao
						.add(new GestaoAtendimento(null, complementoComando, PING_V4, new Date()));
			} else {
				msg.append(INFORMAR_O_IP_OU_PAT);
			}
			break;

		case 6:
			if (complementoComando != null) {
				ComandoOrientarInstalarVPN comandoOrientacaoVPN = new ComandoOrientarInstalarVPN();
				String ret = comandoOrientacaoVPN.enviarManualUsuario(complementoComando);
				if (ret != null) {
					msg.append(EMAIL_ENVIADO_COM_SUCESSO_PARA + ret);
				} else {
					msg.append(EMAIL_NÃO_ENVIADO_ENTRAR_EM_CONTATO_COM_O_SERVICE_DESK);
				}
				EscopoApplictCSCTimerTelegram.listaGestao
						.add(new GestaoAtendimento(complementoComando, null, INSTALAR_VPN, new Date()));
			} else {
				msg.append(INFORMAR_MATRICULA);
			}
			break;
		case 7:
			if (complementoComando != null) {
				ComandoOrientarContaAdministrador comandoContaAdm = new ComandoOrientarContaAdministrador();
				String ret = comandoContaAdm.enviarManualUsuario(complementoComando);
				if (ret != null) {
					msg.append(EMAIL_ENVIADO_COM_SUCESSO_PARA + ret);
				} else {
					msg.append(EMAIL_NÃO_ENVIADO_ENTRAR_EM_CONTATO_COM_O_SERVICE_DESK);
				}
				EscopoApplictCSCTimerTelegram.listaGestao
						.add(new GestaoAtendimento(complementoComando, null, SENHA_ADM, new Date()));

			} else {
				msg.append(INFORMAR_MATRICULA);
			}
			break;

		case 8:
			if (complementoComando != null) {
				ComandoAntiVirus comandoAntiVirus = new ComandoAntiVirus();
				String ret = comandoAntiVirus.enviarManualUsuario(complementoComando);
				if (ret != null) {
					msg.append(EMAIL_ENVIADO_COM_SUCESSO_PARA + ret);
				} else {
					msg.append(EMAIL_NÃO_ENVIADO_ENTRAR_EM_CONTATO_COM_O_SERVICE_DESK);
				}
				EscopoApplictCSCTimerTelegram.listaGestao
						.add(new GestaoAtendimento(complementoComando, null, ANTI_VIRUS, new Date()));

			} else {
				msg.append(INFORMAR_MATRICULA);
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
		msg.append(saudacao() + nomeUsuario);
		for (int i = 0; i < vetOpcoes.length; i++) {
			msg.append(vetOpcoes[i]);
		}
		return msg.toString();
	}

	private String saudacao() {
		Calendar cal = Calendar.getInstance();
		int hora = cal.get(Calendar.HOUR_OF_DAY);
		if (hora >= 0 && hora <= 12) {
			return BOM_DIA;
		} else {
			if (hora > 12 && hora <= 18) {
				return BOA_TARDE;
			}
			return BOA_NOITE;
		}
	}

}
