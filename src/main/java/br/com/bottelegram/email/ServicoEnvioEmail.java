package br.com.bottelegram.email;

import com.copel.mail.SendMail;

import br.com.bottelegram.comando.dto.Email;

public class ServicoEnvioEmail {

	private static final String ASSUNTO_AUSENTE = "Assunto: Ausente";
	private static final String UTF_8 = "utf-8";
	private static final String HEADER = "text/html; charset=utf-8";
	private static String host = "smtp.copel.nt";

	public void enviarEmail(Email email) {

		try {
			SendMail sm = new SendMail();
			sm.setHost(host);

			sm.setFrom(email.getRemetente());
			sm.setBody(email.getCorpo());
			sm.setSubject(email.getAssunto());
			sm.setTo(email.getDestinatario());
			sm.setContentType(HEADER);
			if (email.getAssunto() != null) {
				sm.setSubject(new String(email.getAssunto().getBytes(UTF_8), UTF_8));
			} else {
				sm.setSubject(new String(ASSUNTO_AUSENTE));
			}
			sm.enviar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enviarEmailComCopia(Email email) {
		try {
			SendMail sm = new SendMail();
			sm.setHost(host);

			sm.setFrom(email.getRemetente());
			sm.setBody(email.getCorpo());
			sm.setSubject(email.getAssunto());
			sm.setTo(email.getDestinatario());
			sm.setCC(email.getCopiaParaDestinatario());
			sm.setContentType(HEADER);
			sm.setSubject(new String(email.getAssunto().getBytes(UTF_8), UTF_8));
			sm.enviar();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enviarEmailAnexo(String remetente, String assunto, String destinatario, String corpo, String arquivo) {
		try {
			SendMail sm = new SendMail();
			sm.setHost(host);
			sm.addAttachment(arquivo);

			sm.setFrom(remetente);
			sm.setBody(corpo);
			sm.setSubject(assunto);
			sm.setTo(destinatario);
			sm.setContentType(HEADER);
			sm.setSubject(new String(assunto.getBytes(UTF_8), UTF_8));
			sm.enviar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
