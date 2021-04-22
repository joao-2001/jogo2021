package jogoteste;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Jogo extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3705333409666900155L;
	
	private GerenciadorDeEntidades gerenciador;
	private Thread thread;
	private boolean running = false;
	
	public Jogo(){
		gerenciador = new GerenciadorDeEntidades();
		
		this.addKeyListener(new KeyInput(gerenciador));

		new Janela(640, 480, "oi mae to no pc", this);
		
		Jogador jogador1 = new Jogador(100, 100, 50, 50, ID.Jogador);

		gerenciador.addEntidade(jogador1);
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		 long lastTime = System.nanoTime();
		 double amountOfTicks = 60.0;
		 double ns = 1000000000 / amountOfTicks;
		 double delta = 0;
		 long timer = System.currentTimeMillis();
		 int frames = 0;
		 while(running) {
			 long now = System.nanoTime();
			 delta += (now - lastTime) / ns;
			 lastTime = now;
			 while(delta >= 1) {
				 tick();
				 delta--;
			 }
			 if (running)
				 render();
			 frames++;
			 
			 if(System.currentTimeMillis() - timer > 1000) {
				 timer += 1000;
				 System.out.println("FPS: " + frames);
				 frames = 0;
			 }
		 }
		 stop();
	}
	
	private void tick() {
		gerenciador.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 600);
		
		
		gerenciador.render(g);
		
		
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		new Jogo();
	}

}