package br.com.douglasmendes.bottelegram;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ComandoVPNConectada {
	private List<VPNConectada> listaVPN = null;

	public ComandoVPNConectada() {
		super();
		carregarListaVPN();
	}

	public String localizarVPN(String matricula) {
		String vpn = null;
		for (int i = 0; i < this.listaVPN.size(); i++) {
			if (matricula.equalsIgnoreCase(this.listaVPN.get(i).getMatricula())) {
				vpn = this.listaVPN.get(i).getVpn();
				break;
			}
		}
		return vpn;
	}

	private List<VPNConectada> carregarDadosArqXML(Reader fonte) {
		XStream stream = new XStream(new DomDriver());
		stream.alias("vpnconectada", VPNConectada.class);
		return (List<VPNConectada>) stream.fromXML(fonte);
	}

	private void carregarListaVPN() {
		try {
			FileReader reader = new FileReader(new java.io.File("vpnconectada.xml"));
			this.listaVPN = carregarDadosArqXML(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ComandoVPNConectada().processar();
	}

	private void processar() {
		carregarListaVPN();
		System.out.println(localizarVPN("c049463"));
	}
}
