package br.com.douglasmendes.bottelegram.comando;

import java.io.IOException;
import java.util.Scanner;

public class ComandoPing {
	public static void main(String[] args) {
		new ComandoPing().processar("ping -4 -n 1 L00000221");
	}

	public String processar(String comando) {
		StringBuilder resposta = new StringBuilder();
		try {
			Scanner pingar = new Scanner(Runtime.getRuntime().exec(comando).getInputStream());
			String respPing = "";
			while (pingar.hasNextLine()) {
				respPing = pingar.nextLine();
				if (respPing.contains("tempo")) {
					resposta.append(respPing + "\n");
				}
			}
			pingar.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		System.out.println("Resultado Ping: " + resposta);
		return resposta.toString();

	}
}
