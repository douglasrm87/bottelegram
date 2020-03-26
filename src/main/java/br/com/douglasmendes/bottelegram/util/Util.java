package br.com.douglasmendes.bottelegram.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.log4j.Logger;

public class Util {

	private static Logger logger = Logger.getLogger(Util.class);

	public static boolean isNullOrEmpty(String value) {
		return (value == null || value.equals(""));
	}

	public static boolean isNotNullOrEmpty(String value) {
		return !isNullOrEmpty(value);
	}

	public static String removerMascara(String campo) {
		if (null == campo)
			return "";
		return campo.replace(" ", "").replace(".", "").replace("/", "").replace("-", "").replace("(", "")
				.replace(")", "").replace("_", "");
	}

	public static void addLoggerError(Object message) {
		logger.error(message);
	}

	public static void addLoggerWarn(Object message) {
		logger.warn(message);
	}

	public static void addLoggerInfo(Object message) {
		logger.info(message);
	}

	public static String getUrlContents(String theUrl) {
		StringBuilder content = new StringBuilder();
		try {
			URL url = new URL(theUrl);
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	public static void addLoggerError(Class<?> classe, String metodo, String mensagem) {
		StringBuilder message = new StringBuilder();
		message.append("Classe: ").append(classe.getSimpleName());
		message.append(", Metodo: ").append(metodo);
		message.append(" - ").append(mensagem);
		logger.error(message.toString());
	}

	public static void addLoggerInfo(Class<?> classe, String metodo, String mensagem) {
		StringBuilder message = new StringBuilder();
		message.append("Classe: ").append(classe.getSimpleName());
		message.append(", Metodo: ").append(metodo);
		message.append(" - ").append(mensagem);
		logger.info(message.toString());
	}

	public static void addLoggerWarn(Class<?> classe, String metodo, String mensagem) {
		StringBuilder message = new StringBuilder();
		message.append("Classe: ").append(classe.getSimpleName());
		message.append(", Metodo: ").append(metodo);
		message.append(" - ").append(mensagem);
		logger.warn(message.toString());
	}

}
