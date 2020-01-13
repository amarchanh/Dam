import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class contadorapplet2_3 extends Applet implements ActionListener {

	private Thread h1;
	private Thread h2;
	long CONTADOR1 = 300;
	long CONTADOR2 = 200;
	private boolean parar;
	private boolean parar1;
	private boolean parar2;
	private Font fuente;
	private Button b1, b2;

	public class hilocontador extends Thread {
		private long conta1;

		public hilocontador(contadorapplet2_3 contadorapplet2_3, long conta1) {
			this.conta1 = conta1;
		}

		public void getcontador() {
			System.out.println(CONTADOR1);
			System.out.println(CONTADOR2);
		}

		public void run() {
			parar = false;
			parar1 = false;
			parar2 = false;
			while (!parar) {
				repaint();
				if (!parar1)
					CONTADOR1++;
				else {
					// h1.stop(); OJO
				}
				if (!parar2)
					CONTADOR2++;
				else {
					// h2.stop(); OJO
				}
				getcontador();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (parar1 && parar2)
					parar = true; // para salir del while
			} // while hilo1
		}
	}

	public void start() {
		// iniciar los hilos
		hilocontador h1 = new hilocontador(this, CONTADOR1);
		h1.start();
		hilocontador h2 = new hilocontador(this, CONTADOR2);
		h2.start();
	}

	public void init() {
		setBackground(Color.yellow);
		add(b1 = new Button("Finalizar Hilo 1"));
		b1.addActionListener(this);
		add(b2 = new Button("Finalizar Hilo 2"));
		b2.addActionListener(this);
		fuente = new Font("Verdana", Font.BOLD, 26);
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 400);
		g.setFont(fuente); // fuente
		if (!parar1)
			CONTADOR1--; // En cada vuelta del while lo incrementa dos veces
		if (!parar2)
			CONTADOR2--; // En cada vuelta del while lo incrementa dos veces
		g.drawString("Hilo 1:", 0, 100);
		g.drawString(Long.toString((long) CONTADOR1), 100, 100);
		g.drawString("Hilo 2:", 0, 140);
		g.drawString(Long.toString((long) CONTADOR2), 100, 140);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) // Pulso Finalizar Hilo2
		{
			b1.setLabel("Finalizado Hilo 1");
			parar1 = true;
		}
		if (e.getSource() == b2) // Pulso Finalizar Hilo2
		{
			b2.setLabel("Finalizado Hilo 2");
			parar2 = true;
		}
	}// actionPerformed

	public void stop() {
		h1 = null;
		h2 = null;
	}
}
