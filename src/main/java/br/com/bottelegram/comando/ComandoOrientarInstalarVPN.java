package br.com.bottelegram.comando;

import br.com.bottelegram.comando.dto.Email;
import br.com.bottelegram.email.ServicoDadorRH;
import br.com.bottelegram.email.ServicoEnvioEmail;

public class ComandoOrientarInstalarVPN extends UsoEmail{
	private static final String ASSUNTO = "Orientação para instalar VPN para Home Office";
	private static final String CORPO1 = "https://www.sw401.com/projetos?gclid=EAIaIQobChMI6p35wdS_6AIVhRGRCh2VJw_EEAAYASAAEgIgKfD_BwE";
	private static final String CORPO2 = "https://canaltech.com.br/internet/o-que-e-vpn-23748/";

	public static void main(String[] args) {
		new ComandoOrientarInstalarVPN().enviarManualUsuario(REMETENDETE);
	}

	public String enviarManualUsuario(String matricula) {
		try {
			ServicoDadorRH dadosRH = new ServicoDadorRH();
			String destino = dadosRH.recuperarEmailByMatricula(matricula);
			Email email = new Email(CC, REMETENDETE, ASSUNTO, destino,
					CORPO0 + "<br><br>" + CORPO1 + "<br><br>" + CORPO2);
			ServicoEnvioEmail servEmail = new ServicoEnvioEmail();
			servEmail.enviarEmailComCopia(email);
			return destino;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
