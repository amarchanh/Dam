import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Actividad2_3 extends Applet implements ActionListener {

	class HiloContador extends Thread {

		public long contador;
		public void run() {
			while (true) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
				contador++;
			}
		}

		HiloContador(long contador) {
			this.contador = contador;
		}

		public long getContador() {
			return contador;
		}

	}// HiloContador

	private Font fuente;
	private Button b1, b2; // botones del Applet
	private HiloContador h1;
	private HiloContador h2;

	public void start() {
		h1 = new HiloContador(15);
		h1.start();
		h2 = new HiloContador(30);
		h2.start();
	}

	public void init() {
		setBackground(Color.yellow); // color de fondo
		add(b1 = new Button("Finalizado Hilo 1"));
		b1.addActionListener(this);
		add(b2 = new Button("Finalizado Hilo 2"));
		b2.addActionListener(this);
		fuente = new Font("Verdana", Font.BOLD, 26); // tipo letra
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 400);
		g.setFont(fuente); // fuente
		g.drawString(Long.toString((long)h1.getContador()), 80, 100);
		g.drawString(Long.toString((long)h2.getContador()), 80, 130);
	}

	// para controlar que se pulsan los botones
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) { // Pulso Iniciar contador o Continuar
			h1.stop();
		} else if (e.getSource() == b2) { // Pulso Parar contador
			h2.stop(); // para que finalice el while en el método run

		}
	}// actionPerfomed

	public void stop() {
		h1 = null;
		h2 = null;
	}

}
