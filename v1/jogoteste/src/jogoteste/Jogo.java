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
	private Fase fase;
	private HUD hud;
	private Thread thread;
	private boolean running = false;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;

	
	public Jogo(){
		gerenciador = new GerenciadorDeEntidades();
		this.fase = new PrimeiraFase(gerenciador); 
		
		
		this.addMouseListener(new MouseInput(gerenciador));
		this.addKeyListener(new KeyInput(gerenciador));
		

		new Janela(WIDTH, HEIGHT, "oi mae to no pc", this);
		
		Jogador jogador1 = new Jogador(100, 100, 50, 50, gerenciador, ID.Jogador1);
		Jogador jogador2 = new Jogador(100, 100, 50, 50, gerenciador, ID.Jogador2);

		gerenciador.addEntidade(jogador1);
		gerenciador.addEntidade(jogador2);

		
		hud = new HUD();
		
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
	
	public void run() { //redefini��o do metodo run da interface runnable 
 		 this.requestFocus();
		 long lastTime = System.nanoTime();
		 double amountOfTicks = 60.0;
		 double ns = 1000000000 / amountOfTicks;
		 double delta = 0;
		 long timer = System.currentTimeMillis();
		 int frames = 0;
		 while(running) {	//loop pego da internet
			 long now = System.nanoTime();
			 delta += (now - lastTime) / ns;
			 lastTime = now;
			 while(delta >= 1) {
				 tick();
				 delta--;
			 }
			 if (running)
				 render();// na pratica o loop s� � usado para chamar os metodos tick e render
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
		this.fase.tick();
		
		if (HUD.VIDA == 0) {
			System.out.println("" + HUD.VIDA);
			stop();
			start();
		}
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
		hud.render(g);
		
		
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	public static void main(String args[]) {
		new Jogo();
	}

}