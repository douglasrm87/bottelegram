package br.com.douglasmendes.bottelegram.dhcppagina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//https://keyserver.copel.nt/lan/leases.php
public class DHCPLeasesKeyserver {

	public static void main(String[] args) {
		try {
			String url = "https://keyserver.copel.nt/lan/leases.php";

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			String inputLine = new String();
			do {
				if (responseCode == 200) {
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

					inputLine = br.readLine();
					System.out.println(inputLine);

				} else {
					System.out.println("erro " + responseCode);
				}
			} while (inputLine != null);
		} catch (IOException e) {
			System.out.println("Erro de leitura");
		}
	}
}
