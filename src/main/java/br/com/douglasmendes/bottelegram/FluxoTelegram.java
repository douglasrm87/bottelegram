package br.com.douglasmendes.bottelegram;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

//https://web.telegram.org/#/im?p=@cscpr_bot
public class FluxoTelegram {
	private static final String TOKEN_TELEGRAM_PUBLICADOR = "1015053732:AAHWzTrMTCCSEmjoFELpVT8XYcbOQH6dvB4";
	TelegramBot botTelegram = new TelegramBot(TOKEN_TELEGRAM_PUBLICADOR);
	int offSetAtributo = 0;

	public void iniciarChatBotTelegram() {
		GetUpdatesResponse updatesResponse;
		SendResponse sendResponse;
		BaseResponse baseResponse;
//		SCSAPI.getInstance().autentica("c049463", "");

		// executa comando no Telegram para obter as mensagens pendentes a partir de um
		// off-set (limite inicial)
		updatesResponse = this.botTelegram.execute(new GetUpdates().limit(100).offset(this.offSetAtributo));

		// lista de mensagens
		List<Update> updates = updatesResponse.updates();

		// análise de cada ação da mensagem
		if (updates != null) {
			for (Update update : updates) {
				Long idUsuario = update.message().chat().id();
				String nomeUsuario = update.message().chat().firstName();
				String mensagem = update.message().text();

				boolean retComando = validarComandoRecebido(update.message());
				int idComando = 0;
				InteracaoComando usuarioExistente = null;
				usuarioExistente = EscopoApplictCSCTimerTelegram.mapaClienteComando.get(idUsuario);
				if (retComando) {
					idComando = Integer.parseInt(mensagem);
					if (usuarioExistente == null) {
						EscopoApplictCSCTimerTelegram.mapaClienteComando.put(idUsuario,
								new InteracaoComando(idUsuario, nomeUsuario, idComando, null));
					} else {
						usuarioExistente.setIdComando(idComando);
					}
				} else {
					if (usuarioExistente != null) {
						usuarioExistente.setComplementoComando(update.message().text());
						idComando = usuarioExistente.getIdComando();
					}
				}
				// atualização do off-set
				this.offSetAtributo = update.updateId() + 1;

				System.out.println("Recebendo mensagem:" + /* update.message().text() */mensagem);
				System.out.println("Nome usuario Telegram:" + /* update.message().chat().firstName() */nomeUsuario);

				// envio de "Escrevendo" antes de enviar a resposta
				baseResponse = this.botTelegram.execute(
						new SendChatAction(/* update.message().chat().id() */idUsuario, ChatAction.typing.name()));

				// verificação de ação de chat foi enviada com sucesso
				System.out.println("Resposta de Chat Action Enviada?" + baseResponse.isOk());

				// envio da mensagem de resposta
				String msgRetornadaCliente = "";
				if (usuarioExistente != null) {
					msgRetornadaCliente = processarComandoGeral(idComando, nomeUsuario,
							usuarioExistente.getComplementoComando());
				} else {
					msgRetornadaCliente = processarComandoGeral(idComando, nomeUsuario, null);
				}
				sendResponse = this.botTelegram.execute(new SendMessage(idUsuario, msgRetornadaCliente));
				// verificação de mensagem enviada com sucesso
				System.out.println("Mensagem Enviada?" + sendResponse.isOk());
			}
		}
	}

	private boolean validarComandoRecebido(Message msgTelegram) {
		try {
			Integer.parseInt(msgTelegram.text());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private String processarComandoGeral(int idComando, String nomeUsuario, String complemento) {
		ComandoTelegram obj = new ComandoTelegram();
		return obj.processarComando(idComando, nomeUsuario, complemento);

	}
}
/*
 * Update{ update_id=911210077, message=Message{message_id=134,
 * from=User{id=1070005610, is_bot=false, first_name='Douglas',
 * last_name='Mendes', username='null', language_code='pt-br',
 * can_join_groups=null, can_read_all_group_messages=null,
 * supports_inline_queries=null}, date=1585323454, chat=Chat{id=1070005610,
 * type=Private, first_name='Douglas', last_name='Mendes', username='null',
 * title='null', all_members_are_administrators=null, photo=null,
 * description='null', invite_link='null', pinned_message=null,
 * permissions=null, slow_mode_delay=null, sticker_set_name='null',
 * can_set_sticker_set=null}, forward_from=null, forward_from_chat=null,
 * forward_from_message_id=null, forward_signature='null',
 * forward_sender_name='null', forward_date=null, reply_to_message=null,
 * edit_date=null, media_group_id='null', author_signature='null', text='Teste',
 * entities=null, caption_entities=null, audio=null, document=null,
 * animation=null, game=null, photo=null, sticker=null, video=null, voice=null,
 * video_note=null, caption='null', contact=null, location=null, venue=null,
 * poll=null, new_chat_members=null, left_chat_member=null,
 * new_chat_title='null', new_chat_photo=null, delete_chat_photo=null,
 * group_chat_created=null, supergroup_chat_created=null,
 * channel_chat_created=null, migrate_to_chat_id=null,
 * migrate_from_chat_id=null, pinned_message=null, invoice=null,
 * successful_payment=null, connected_website='null', passport_data=null,
 * reply_markup=null}, edited_message=null, channel_post=null,
 * edited_channel_post=null, inline_query=null, chosen_inline_result=null,
 * callback_query=null, shipping_query=null, pre_checkout_query=null, poll=null,
 * poll_answer=null}
 */