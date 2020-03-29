package br.com.douglasmendes.bottelegram.comando;

import br.com.douglasmendes.bottelegram.comando.dto.Email;
import br.com.douglasmendes.bottelegram.email.ServicoDadorRH;
import br.com.douglasmendes.bottelegram.email.ServicoEnvioEmail;

public class ComandoAntiVirus extends UsoEmail{
	private static final String ASSUNTO = "Orientação para instalar Anti Vírus.";
	private static final String CORPO1 = "https://help.kaspersky.com/KSC/11/pt-BR/166765.htm";


	public static void main(String[] args) {
		new ComandoAntiVirus().enviarManualUsuario(REMETENDETE);
	}

	public String enviarManualUsuario(String matricula) {
		try {
			ServicoDadorRH dadosRH = new ServicoDadorRH();
			String destino = dadosRH.recuperarEmailByMatricula(matricula);
			Email email = new Email(CC, REMETENDETE, ASSUNTO, destino,
					CORPO0 + "<br><br>" + CORPO1 + "<br><br>" );
			ServicoEnvioEmail servEmail = new ServicoEnvioEmail();
			servEmail.enviarEmailComCopia(email);
			return destino;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
