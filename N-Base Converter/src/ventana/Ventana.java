package ventana;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Panel panel;
	private static final Ventana instance=new Ventana();
	
	private Ventana() {
		this.setVentana();
	}
	private void setVentana() {
		
		this.setTitle("The N-base converter");
		this.setSize(250, 200);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		panel=new Panel();
		this.add(panel);
	}

	public static Ventana getInstance() {
		return instance;
	}
}
