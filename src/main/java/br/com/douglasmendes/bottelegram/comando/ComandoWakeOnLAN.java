package br.com.douglasmendes.bottelegram.comando;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;

import org.apache.commons.net.util.SubnetUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.douglasmendes.bottelegram.comando.dto.DesktopLAN;
import br.com.douglasmendes.bottelegram.comando.dto.KeyServer;
import br.com.douglasmendes.bottelegram.dhcppagina.DHCPLeasesKeyserver;

public class ComandoWakeOnLAN {
	public static final int PORT = 8080;
	public static final String MASCARA_PADRAO_COPEL_NET = "255.255.240.0";	
	public static final String MASCARA_BARRA_PADRAO_COPEL_NET = "/20";

	private DesktopLAN localizarDesktopXML(String pat) {
		DesktopLAN pc = null;
		List<DesktopLAN> listaDesktopsLAN = carregarListaDesktopXML();
		for (int i = 0; i < listaDesktopsLAN.size(); i++) {
			if (pat.equalsIgnoreCase(listaDesktopsLAN.get(i).getPat())) {
				pc = listaDesktopsLAN.get(i);
				break;
			}
		}
		return pc;
	}

	private List<DesktopLAN> carregarDadosArqXML(Reader fonte) {
		XStream stream = new XStream(new DomDriver());
		stream.alias("desktop", DesktopLAN.class);
		return (List<DesktopLAN>) stream.fromXML(fonte);
	}

	private List<DesktopLAN> carregarListaDesktopXML() {
		List<DesktopLAN> listaDesktopsLAN = null;
		try {
			FileReader reader = new FileReader(new java.io.File("desktopslan.xml"));
			listaDesktopsLAN = carregarDadosArqXML(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaDesktopsLAN;
	}

	public static void main(String[] args) {
		ComandoWakeOnLAN ligar = new ComandoWakeOnLAN();
//		ligar.ligarDesktop("L00000221");
		ligar.ligarDesktop("Douglas-PC");

	}

	private DesktopLAN localizarDesktopKEYServer(String patrimonio) {
		DHCPLeasesKeyserver keyServer = new DHCPLeasesKeyserver();
		List<KeyServer> listaLinha = keyServer.processar();
		DesktopLAN desktop = new DesktopLAN();
		for (KeyServer key : listaLinha) {
			if (key.getPatrimonio().equalsIgnoreCase(patrimonio)) {
				SubnetUtils utils = new SubnetUtils(key.getIpv4()+MASCARA_BARRA_PADRAO_COPEL_NET);
				desktop.setBroadcastlan(utils.getInfo().getBroadcastAddress());
				desktop.setMac(key.getMacAddress());
				desktop.setPat(patrimonio);
			}
			System.out.println("keyServer: " + keyServer);
			System.out.println("desktop: " + desktop);
		}
		return desktop;
	}
	public void ligarDesktop(String desktop) {
		DesktopLAN computador = localizarDesktopKEYServer(desktop);
//		System.out.println("Usage: java WakeOnLan <broadcast-ip> <mac-address>");
//		System.out.println("Example: java WakeOnLan 192.168.0.255 00:0D:61:08:22:4A");
//		System.out.println("Example: java WakeOnLan 192.168.0.255 00-0D-61-08-22-4A");

		String ipStr = computador.getBroadcastlan();
		String macStr = computador.getMac();
		System.out.println("MAC: " + macStr);
		System.out.println("IP: " + ipStr);

		try {
			byte[] macBytes = getMacBytes(macStr);
			byte[] bytes = new byte[6 + 16 * macBytes.length];
			for (int i = 0; i < 6; i++) {
				bytes[i] = (byte) 0xff;
			}
			for (int i = 6; i < bytes.length; i += macBytes.length) {
				System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
			}

			InetAddress address = InetAddress.getByName(ipStr);
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, PORT);
			DatagramSocket socket = new DatagramSocket();
			socket.send(packet);
			socket.close();

			System.out.println("Wake-on-LAN packet sent.");
		} catch (Exception e) {
			System.out.println("Failed to send Wake-on-LAN packet: + e");
			System.exit(1);
		}

	}

	private static byte[] getMacBytes(String macStr) throws IllegalArgumentException {
		byte[] bytes = new byte[6];
		String[] hex = macStr.split("(\\:|\\-)");
		if (hex.length != 6) {
			throw new IllegalArgumentException("Invalid MAC address.");
		}
		try {
			for (int i = 0; i < 6; i++) {
				bytes[i] = (byte) Integer.parseInt(hex[i], 16);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid hex digit in MAC address.");
		}
		return bytes;
	}
}
