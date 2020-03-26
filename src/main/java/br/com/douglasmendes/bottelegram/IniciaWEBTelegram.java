package br.com.douglasmendes.bottelegram;

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

public class IniciaWEBTelegram {
	private static final String TOKEN_TELEGRAM_PUBLICADOR = "1015053732:AAHWzTrMTCCSEmjoFELpVT8XYcbOQH6dvB4";

	public void iniciarChatBotTelegram() {

		TelegramBot bot = new TelegramBot(TOKEN_TELEGRAM_PUBLICADOR);
		GetUpdatesResponse updatesResponse;
		SendResponse sendResponse;
		BaseResponse baseResponse;

		int m = 0;

		// executa comando no Telegram para obter as mensagens pendentes a partir de um
		// off-set (limite inicial)
		updatesResponse = bot.execute(new GetUpdates().limit(100).offset(m));

		// lista de mensagens
		List<Update> updates = updatesResponse.updates();

		// análise de cada ação da mensagem
		if (updates != null) {
			for (Update update : updates) {
				// atualização do off-set
				m = update.updateId() + 1;

				System.out.println("Recebendo mensagem:" + update.message().text());

				// envio de "Escrevendo" antes de enviar a resposta
				baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
				// verificação de ação de chat foi enviada com sucesso
				System.out.println("Resposta de Chat Action Enviada?" + baseResponse.isOk());

				// envio da mensagem de resposta
				sendResponse = bot.execute(
						new SendMessage(update.message().chat().id(), "ChatBOT CSCPR Em construção - teste01.."));
				// verificação de mensagem enviada com sucesso
				System.out.println("Mensagem Enviada?" + sendResponse.isOk());

			}
		}
	}
}
