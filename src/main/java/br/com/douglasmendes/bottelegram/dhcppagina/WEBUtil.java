package br.com.douglasmendes.bottelegram.dhcppagina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;

/*
			// faz o append dos dados lidos na saida (StringBuilder)
				String temp = new String(buffer);
				temp = temp.replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " ");
				saida.append(temp);
				saida.append("\n");
 */
public class WEBUtil {
	public static void main(String[] args) {

		// chama o método getURLData
//		System.out.println(getURLData("http://lia.dc.ufscar.br/david"));
		String res = getURLData("https://keyserver.copel.nt/lan/leases.php");
		StringReader reader = new StringReader(res);
		try {
			extractText (reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res);
 
	}

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
	
	// método estático para a obtenção dos dados de uma determinada url
	public static String getURLData( String url ) {
	    
	    // cria um StringBuilder para armazenar a saída
	    StringBuilder saida = new StringBuilder();
	    
	    try {
	        
	        // cria uma url com o endereço passado
	        URL u = new URL( url );
	        
	        // abre a conexão com a url criada
	        URLConnection uCon = u.openConnection();
	        
	        // obtém o input stream da conexão
	        InputStream in = uCon.getInputStream();
	        
	        // um buffer para a leitura dos dados obtidos no input stream
	        byte[] buffer = new byte[2048];
	        
	        
	        // tenta colocar dados dentro do buffer. enquanto existirem dados 
	        //(resultado da leitura diferentede -1), a execução continua
	        int cont = 0;
	        while ( in.read( buffer ) != -1 ) {
	            
	            // faz o append dos dados lidos na saida (StringBuilder)
	            saida.append( new String( buffer ) );
	            cont ++;
	            if (cont == 2) {
	            	break;
	            }
	            
	        }
	        
	        // fecha o input stream
	        in.close();            
	    
	        // tratamento de excessões...   
	    } catch ( MalformedURLException exc )  {
	        
	        saida.append( "ERRO: URL mal formada." );
	        exc.printStackTrace();
	        
	    } catch ( IOException exc ) {
	        
	        saida.append( "IOException" );
	        exc.printStackTrace();
	        
	    } catch ( SecurityException exc ) {
	        
	        saida.append( "ERRO: Não há permissão para conexão." );
	        exc.printStackTrace();
	        
	    } catch ( IllegalArgumentException exc ) {
	        
	        saida.append( "ERRO: O proxy é null ou de tipo incorreto." );
	        exc.printStackTrace();
	        
	    } catch ( UnsupportedOperationException exc ) {
	        
	        saida.append( "ERRO: A subclasse que implementa o protocolo não suporta este método." );
	        exc.printStackTrace();
	        
	    }
	    
	    // retorna o que existe na saída na forma de uma String
	    return saida.toString();
	    
	}
}