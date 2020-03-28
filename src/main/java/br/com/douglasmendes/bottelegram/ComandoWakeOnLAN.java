package br.com.douglasmendes.bottelegram;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ComandoWakeOnLAN {
	public static final int PORT = 8080;
	private List<DesktopLAN> listaDesktopsLAN = null;

	public ComandoWakeOnLAN() {
		super();
		carregarListaDesktop();
	}

	private DesktopLAN localizarDesktop(String pat) {
		DesktopLAN pc = null;
		for (int i = 0; i < this.listaDesktopsLAN.size(); i++) {
			if (pat.equalsIgnoreCase(this.listaDesktopsLAN.get(i).getPat())) {
				pc = this.listaDesktopsLAN.get(i);
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

	private void carregarListaDesktop() {
		try {
			FileReader reader = new FileReader(new java.io.File("desktopslan.xml"));
			this.listaDesktopsLAN = carregarDadosArqXML(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ComandoWakeOnLAN ligar = new ComandoWakeOnLAN();
//		ligar.ligarDesktop("L00000221");
		ligar.ligarDesktop("Douglas-PC");

	}

	public void ligarDesktop(String desktop) {
		DesktopLAN computador = localizarDesktop(desktop);
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
