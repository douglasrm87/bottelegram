package br.com.bottelegram.comando;

import com.copel.scs.SCSAPI;

public class ComandoLogin {
	public static void main(String[] args) {
		SCSAPI login = SCSAPI.getInstance();
		login.getAplicativos();
		login.autentica("c049463", "");
	}

}
