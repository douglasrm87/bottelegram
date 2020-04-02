package br.com.douglasmendes.bottelegram.dhcppagina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;

public class HTMLUtil {
	public static String extractText(Reader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(reader);
		List <String> listaLinha = new ArrayList<String>();
		
		String line;
		while ((line = br.readLine()) != null) {
			listaLinha.add(line);
		}
		for (int i = 0; i < listaLinha.size(); i++) {
			System.out.println(Jsoup.parse(listaLinha.get(i)).text());
		}
		String textOnly = Jsoup.parse(sb.toString()).text();
		return textOnly;
	}

	public final static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("dnslan.html");
		System.out.println(HTMLUtil.extractText(reader));
		reader.close();
	}
}
