package br.com.bottelegram.comando;

import br.com.bottelegram.comando.dto.Email;
import br.com.bottelegram.email.ServicoDadorRH;
import br.com.bottelegram.email.ServicoEnvioEmail;

public class ComandoOrientarContaAdministrador extends UsoEmail{
	private static final String ASSUNTO = "Orientação para tornar uma conta de usuário para administrador.";
	private static final String CORPO1 = "https://support.microsoft.com/pt-br/help/4026923/windows-10-create-a-local-user-or-administrator-account";

	public static void main(String[] args) {
		new ComandoOrientarContaAdministrador().enviarManualUsuario(REMETENDETE);
	}

	public String enviarManualUsuario(String matricula) {
		try {
			ServicoDadorRH dadosRH = new ServicoDadorRH();
			String destino = dadosRH.recuperarEmailByMatricula(matricula);
			Email email = new Email(CC, REMETENDETE, ASSUNTO, destino,
					CORPO0 + "<br><br>" + CORPO1 + "<br><br>");
			ServicoEnvioEmail servEmail = new ServicoEnvioEmail();
			servEmail.enviarEmailComCopia(email);
			return destino;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
