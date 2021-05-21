package jogoteste;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Janela extends Canvas {
	
	JFrame frame;
	
	private static final long serialVersionUID = 8573400398478581536L;

	public Janela(int largura, int altura, String titulo, Jogo jogo) {
		JFrame frame = new JFrame(titulo);
		
		frame.setPreferredSize(new Dimension(largura, altura));
		frame.setMaximumSize(new Dimension(largura, altura));
		frame.setMinimumSize(new Dimension(largura, altura));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jogo);
		frame.setVisible(true);
		jogo.start();
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
