import java.util.Scanner;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MyHilo extends Applet implements Runnable, ActionListener {
	private Font fuente;
	private Button b1, b2, b3, b4, b5, b6; // botones del Applet
	MyHilo h1;
	MyHilo h2;
	private int contador = 0;
	public boolean finHilo = false;
	String nombreHilo;
	long tiempoDormido;
	private SolicitaSuspender suspender = new SolicitaSuspender();
	
	MyHilo(String nombreHilo, long tiempoDormido){
		this.nombreHilo = nombreHilo;
		this.tiempoDormido = tiempoDormido;
	}
	
	
	public int getContador() {
		return this.contador;
	}
	// petición de SUSPENDER HILO
	public void Suspende() {
		suspender.set(true);
	}
	// petición de CONTINUAR
	public void Reanuda() {
		suspender.set(false);
	}
	
	public void run() {
		try {
			while(!finHilo) {
				suspender.esperandoParaReanudar(); //comprobar
				contador++;
				Thread.sleep(tiempoDormido);
			}
			repaint();
		}
		catch(InterruptedException exception) {
			exception.printStackTrace();
		}
	}
	
	public void start() {
		h1 = new MyHilo("HILO 1", 300);
		h2 = new MyHilo("HILO 2", 600);
	}
	
	public void init() {
		setBackground(Color.yellow); // color de fondo
		add(b1 = new Button("Comenzar Proceso"));
		b1.addActionListener(this);
		add(b2 = new Button("Reanudar"));
		b2.addActionListener(this);
		add(b2 = new Button("Suspender"));
		b3.addActionListener(this);
		add(b2 = new Button("Reanudar"));
		b4.addActionListener(this);
		add(b2 = new Button("Suspender"));
		b5.addActionListener(this);
		add(b2 = new Button("Finalizar Proceso"));
		b6.addActionListener(this);
		fuente = new Font("Verdana", Font.BOLD, 26); // tipo letra
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 400);
		g.setFont(fuente); // fuente
		if(h1.getContador() != 0 && h2.getContador() != 0) {
			g.drawString(Long.toString((long)h1.getContador()), 20, 150);
			g.drawString(Long.toString((long)h2.getContador()), 80, 150);			
		}
		g.drawString(Long.toString((long)h1.getContador()), 20, 170);
		g.drawString(Long.toString((long)h1.getContador()), 80, 170);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			h1.start();
			h2.start();
			b1.setEnabled(false);
		}
		else if (e.getSource() == b2) {
			h1.Reanuda();
		}
		else if (e.getSource() == b3) {
			h1.Suspende();
		}
		else if (e.getSource() == b4) {
			h2.Reanuda();
		}
		else if (e.getSource() == b5) {
			h2.Suspende();
		}
		else if (e.getSource() == b6) {
			h1.finHilo = true;
			h2.finHilo = true;
		}
	}// actionPerfomed
}
