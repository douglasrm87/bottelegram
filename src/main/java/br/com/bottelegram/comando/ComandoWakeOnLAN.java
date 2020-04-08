package br.com.bottelegram.comando;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import br.com.bottelegram.comando.dto.DesktopLAN;

public class ComandoWakeOnLAN extends ComandoRede {
	public static final int PORT = 8080;
	public static final String MASCARA_PADRAO_COPEL_NET = "255.255.240.0";

	public static void main(String[] args) {
		ComandoWakeOnLAN ligar = new ComandoWakeOnLAN();
//		ligar.ligarDesktop("L00000221");
//		ligar.ligarDesktop("Douglas-PC");
		System.out.println(ligar.ligarDesktop("P010631"));

	}

	public String ligarDesktop(String desktop) {
		DesktopLAN computador = localizarDesktopKEYServer(desktop);
		StringBuilder resposta = new StringBuilder();
		if (computador != null) {
			String ipStr = computador.getBroadcastlan();
			String macStr = computador.getMac();
//			System.out.println("MAC: " + macStr);
//			System.out.println("IP: " + ipStr);

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
//				System.out.println("Wake-on-LAN packet sent.");
				resposta.append("Comando WOL enviado ao desktop:" + desktop);
				return resposta.toString();
			} catch (Exception e) {
				System.out.println("Failed to send Wake-on-LAN packet: + e");
				System.exit(1);
			}
		}
		resposta.append(PATRIMONIO_NAO_LOCALIZADO + desktop);
		return resposta.toString();

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
