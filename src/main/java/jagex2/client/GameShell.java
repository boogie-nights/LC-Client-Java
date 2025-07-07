package jagex2.client;

import deob.*;
import jagex2.datastruct.Linkable;
import jagex2.graphics.Pix24;
import jagex2.graphics.PixMap;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameShell extends Applet implements Runnable, MouseListener, MouseMotionListener, KeyListener, FocusListener, WindowListener {
	@ObfuscatedName("JWWAIQPI.a")
	public int a = 8;
	@ObfuscatedName("JWWAIQPI.b")
	public boolean b = false;
	@ObfuscatedName("JWWAIQPI.c")
	public boolean c = false;
	@ObfuscatedName("JWWAIQPI.d")
	public int d = 3;
	@ObfuscatedName("JWWAIQPI.g")
	public int deltaTime = 20;
	@ObfuscatedName("JWWAIQPI.h")
	public int mindel = 1;
	@ObfuscatedName("JWWAIQPI.i")
	public long[] otim = new long[10];
	@ObfuscatedName("JWWAIQPI.k")
	public boolean debug = false;
	@ObfuscatedName("JWWAIQPI.p")
	public Pix24[] p = new Pix24[6];
	@ObfuscatedName("JWWAIQPI.r")
	public boolean r = true;
	@ObfuscatedName("JWWAIQPI.s")
	public boolean s = true;
	@ObfuscatedName("JWWAIQPI.F")
	public int[] F = new int[128];
	@ObfuscatedName("JWWAIQPI.G")
	public int[] G = new int[128];
	@ObfuscatedName("JWWAIQPI.B")
	public int B;
	@ObfuscatedName("JWWAIQPI.C")
	public int C;
	@ObfuscatedName("JWWAIQPI.D")
	public int D;
	@ObfuscatedName("JWWAIQPI.H")
	public int H;
	@ObfuscatedName("JWWAIQPI.I")
	public int I;
	@ObfuscatedName("JWWAIQPI.J")
	public static int J;
	@ObfuscatedName("JWWAIQPI.e")
	public int e;
	@ObfuscatedName("JWWAIQPI.f")
	public int f;
	@ObfuscatedName("JWWAIQPI.j")
	public int fps;
	@ObfuscatedName("JWWAIQPI.l")
	public int screenWidth;
	@ObfuscatedName("JWWAIQPI.m")
	public int screenHeight;
	@ObfuscatedName("JWWAIQPI.t")
	public int t;
	@ObfuscatedName("JWWAIQPI.u")
	public int u;
	@ObfuscatedName("JWWAIQPI.v")
	public int v;
	@ObfuscatedName("JWWAIQPI.w")
	public int w;
	@ObfuscatedName("JWWAIQPI.x")
	public int x;
	@ObfuscatedName("JWWAIQPI.y")
	public int y;
	@ObfuscatedName("JWWAIQPI.z")
	public int z;
	@ObfuscatedName("JWWAIQPI.A")
	public long A;
	@ObfuscatedName("JWWAIQPI.E")
	public long E;
	@ObfuscatedName("JWWAIQPI.q")
	public ViewBox frame;
	@ObfuscatedName("JWWAIQPI.o")
	public PixMap drawArea;
	@ObfuscatedName("JWWAIQPI.n")
	public Graphics graphics;

	@ObfuscatedName("JWWAIQPI.a(III)V")
	public final void initApplication(int height, int width) {
		this.screenWidth = width;
		this.screenHeight = height;
		this.frame = new ViewBox(this.screenWidth, this.screenHeight, this);
		this.graphics = this.getBaseComponent().getGraphics();
		this.drawArea = new PixMap(this.screenWidth, this.screenHeight, this.getBaseComponent(), (byte) -12);
		this.startThread(this, 1);
	}

	@ObfuscatedName("JWWAIQPI.b(III)V")
	public final void initApplet(int width, int height) {
		this.screenWidth = width;
		this.screenHeight = height;
		this.graphics = this.getBaseComponent().getGraphics();
		this.drawArea = new PixMap(this.screenWidth, this.screenHeight, this.getBaseComponent(), (byte) -12);
		this.startThread(this, 1);
	}

	public void run() {
		this.getBaseComponent().addMouseListener(this);
		this.getBaseComponent().addMouseMotionListener(this);
		this.getBaseComponent().addKeyListener(this);
		this.getBaseComponent().addFocusListener(this);

		if (this.frame != null) {
			this.frame.addWindowListener(this);
		}

		this.drawProgress(0, true, "Loading...");
		this.load();

		int opos = 0;
		int ratio = 256;
		int delta = 1;
		int count = 0;
		int intex = 0;

		for (int i = 0; i < 10; ++i) {
			this.otim[i] = System.currentTimeMillis();
		}

		long var7 = System.currentTimeMillis();

		while (true) {
			long ntime;
			do {
				if (this.f < 0) {
					if (this.f == -1) {
						this.a(this.b);
					}

					return;
				}

				if (this.f > 0) {
					--this.f;
					if (this.f == 0) {
						this.a(this.b);
						return;
					}
				}

				int var9 = ratio;
				int var10 = delta;
				ratio = 300;
				delta = 1;
				ntime = System.currentTimeMillis();
				if (this.otim[opos] == 0L) {
					ratio = var9;
					delta = var10;
				} else if (ntime > this.otim[opos]) {
					ratio = (int) ((long) (this.deltaTime * 2560) / (ntime - this.otim[opos]));
				}

				if (ratio < 25) {
					ratio = 25;
				}

				if (ratio > 256) {
					ratio = 256;
					delta = (int) ((long) this.deltaTime - (ntime - this.otim[opos]) / 10L);
				}

				if (delta > this.deltaTime) {
					delta = this.deltaTime;
				}

				this.otim[opos] = ntime;
				opos = (opos + 1) % 10;
				if (delta > 1) {
					for (int var13 = 0; var13 < 10; ++var13) {
						if (this.otim[var13] != 0L) {
							this.otim[var13] += (long) delta;
						}
					}
				}

				if (delta < this.mindel) {
					delta = this.mindel;
				}

				try {
					Thread.sleep((long) delta);
				} catch (InterruptedException var16) {
					++intex;
				}

				while (count < 256) {
					this.B = this.x;
					this.C = this.y;
					this.D = this.z;
					this.E = this.A;
					this.x = 0;
					this.a((byte) -111);
					this.H = this.I;
					count += ratio;
				}

				count &= 255;
				if (this.deltaTime > 0) {
					this.fps = ratio * 1000 / (this.deltaTime * 256);
				}

				this.c(818);
			} while (!this.debug);

			System.out.println("ntime:" + ntime);

			for (int i = 0; i < 10; ++i) {
				int o = (opos - i - 1 + 20) % 10;
				System.out.println("otim" + o + ":" + this.otim[o]);
			}

			System.out.println("fps:" + this.fps + " ratio:" + ratio + " count:" + count);
			System.out.println("del:" + delta + " deltime:" + this.deltaTime + " mindel:" + this.mindel);
			System.out.println("intex:" + intex + " opos:" + opos);
			this.debug = false;
			intex = 0;
		}
	}

	@ObfuscatedName("JWWAIQPI.a(Z)V")
	public final void a(boolean arg0) {
		this.f = -2;
		this.b((int) 277);
		if (!arg0) {
			if (this.frame != null) {
				try {
					Thread.sleep(1000L);
				} catch (Exception var3) {
				}

				try {
					System.exit(0);
				} catch (Throwable var2) {
				}
			}
		}
	}

	@ObfuscatedName("JWWAIQPI.a(BI)V")
	public final void a(byte arg0, int arg1) {
		if (arg0 != 103) {
			this.a = 388;
		}

		this.deltaTime = 1000 / arg1;
	}

	public final void start() {
		if (this.f >= 0) {
			this.f = 0;
		}

	}

	public final void stop() {
		if (this.f >= 0) {
			this.f = 4000 / this.deltaTime;
		}

	}

	public final void destroy() {
		this.f = -1;

		try {
			Thread.sleep(10000L);
		} catch (Exception var1) {
		}

		if (this.f == -1) {
			this.a(this.b);
		}

	}

	public final void update(Graphics arg0) {
		if (this.graphics == null) {
			this.graphics = arg0;
		}

		this.r = true;
		this.b((byte) -99);
	}

	public final void paint(Graphics arg0) {
		if (this.graphics == null) {
			this.graphics = arg0;
		}

		this.r = true;
		this.b((byte) -99);
	}

	public final void mousePressed(MouseEvent arg0) {
		int var2 = arg0.getX();
		int var3 = arg0.getY();
		if (this.frame != null) {
			var2 -= 4;
			var3 -= 22;
		}

		this.t = 0;
		this.y = var2;
		this.z = var3;
		this.A = System.currentTimeMillis();
		if (arg0.isMetaDown()) {
			this.x = 2;
			this.u = 2;
		} else {
			this.x = 1;
			this.u = 1;
		}
	}

	public final void mouseReleased(MouseEvent arg0) {
		this.t = 0;
		this.u = 0;
	}

	public final void mouseClicked(MouseEvent arg0) {
	}

	public final void mouseEntered(MouseEvent arg0) {
	}

	public final void mouseExited(MouseEvent arg0) {
		this.t = 0;
		this.v = -1;
		this.w = -1;
	}

	public final void mouseDragged(MouseEvent arg0) {
		int var2 = arg0.getX();
		int var3 = arg0.getY();
		if (this.frame != null) {
			var2 -= 4;
			var3 -= 22;
		}

		this.t = 0;
		this.v = var2;
		this.w = var3;
	}

	public final void mouseMoved(MouseEvent arg0) {
		int var2 = arg0.getX();
		int var3 = arg0.getY();
		if (this.frame != null) {
			var2 -= 4;
			var3 -= 22;
		}

		this.t = 0;
		this.v = var2;
		this.w = var3;
	}

	public final void keyPressed(KeyEvent arg0) {
		this.t = 0;
		int var2 = arg0.getKeyCode();
		int var3 = arg0.getKeyChar();
		if (var3 < 30) {
			var3 = 0;
		}

		if (var2 == 37) {
			var3 = 1;
		}

		if (var2 == 39) {
			var3 = 2;
		}

		if (var2 == 38) {
			var3 = 3;
		}

		if (var2 == 40) {
			var3 = 4;
		}

		if (var2 == 17) {
			var3 = 5;
		}

		if (var2 == 8) {
			var3 = 8;
		}

		if (var2 == 127) {
			var3 = 8;
		}

		if (var2 == 9) {
			var3 = 9;
		}

		if (var2 == 10) {
			var3 = 10;
		}

		if (var2 >= 112 && var2 <= 123) {
			var3 = var2 + 1008 - 112;
		}

		if (var2 == 36) {
			var3 = 1000;
		}

		if (var2 == 35) {
			var3 = 1001;
		}

		if (var2 == 33) {
			var3 = 1002;
		}

		if (var2 == 34) {
			var3 = 1003;
		}

		if (var3 > 0 && var3 < 128) {
			this.F[var3] = 1;
		}

		if (var3 > 4) {
			this.G[this.I] = var3;
			this.I = this.I + 1 & 127;
		}

	}

	public final void keyReleased(KeyEvent arg0) {
		this.t = 0;
		int var2 = arg0.getKeyCode();
		char var3 = arg0.getKeyChar();
		if (var3 < 30) {
			var3 = 0;
		}

		if (var2 == 37) {
			var3 = 1;
		}

		if (var2 == 39) {
			var3 = 2;
		}

		if (var2 == 38) {
			var3 = 3;
		}

		if (var2 == 40) {
			var3 = 4;
		}

		if (var2 == 17) {
			var3 = 5;
		}

		if (var2 == 8) {
			var3 = '\b';
		}

		if (var2 == 127) {
			var3 = '\b';
		}

		if (var2 == 9) {
			var3 = '\t';
		}

		if (var2 == 10) {
			var3 = '\n';
		}

		if (var3 > 0 && var3 < 128) {
			this.F[var3] = 0;
		}

	}

	public final void keyTyped(KeyEvent arg0) {
	}

	@ObfuscatedName("JWWAIQPI.a(I)I")
	public final int a(int arg0) {
		while (arg0 >= 0) {
			this.e = -9;
		}

		int var2 = -1;
		if (this.I != this.H) {
			var2 = this.G[this.H];
			this.H = this.H + 1 & 127;
		}

		return var2;
	}

	public final void focusGained(FocusEvent arg0) {
		this.s = true;
		this.r = true;
		this.b((byte) -99);
	}

	public final void focusLost(FocusEvent arg0) {
		this.s = false;

		for (int var2 = 0; var2 < 128; ++var2) {
			this.F[var2] = 0;
		}

	}

	public final void windowActivated(WindowEvent arg0) {
	}

	public final void windowClosed(WindowEvent arg0) {
	}

	public final void windowClosing(WindowEvent arg0) {
		this.destroy();
	}

	public final void windowDeactivated(WindowEvent arg0) {
	}

	public final void windowDeiconified(WindowEvent arg0) {
	}

	public final void windowIconified(WindowEvent arg0) {
	}

	public final void windowOpened(WindowEvent arg0) {
	}

	@ObfuscatedName("JWWAIQPI.a()V")
	public void load() {
	}

	@ObfuscatedName("JWWAIQPI.a(B)V")
	public void a(byte arg0) {
		if (arg0 != -111) {
			this.e = -400;
		}
	}

	@ObfuscatedName("JWWAIQPI.b(I)V")
	public void b(int arg0) {
		int var2 = 41 / arg0;
	}

	@ObfuscatedName("JWWAIQPI.c(I)V")
	public void c(int arg0) {
		if (arg0 > 0) {
			;
		}
	}

	@ObfuscatedName("JWWAIQPI.b(B)V")
	public void b(byte arg0) {
		if (arg0 == -99) {
			;
		}
	}

	@ObfuscatedName("JWWAIQPI.d(I)Ljava/awt/Component;")
	public java.awt.Component getBaseComponent() {
		return this.frame != null ? this.frame : this;
	}

	@ObfuscatedName("JWWAIQPI.a(Ljava/lang/Runnable;I)V")
	public void startThread(Runnable thread, int priority) {
		Thread t = new Thread(thread);
		t.start();
		t.setPriority(priority);
	}

	@ObfuscatedName("JWWAIQPI.a(IZLjava/lang/String;)V")
	public void drawProgress(int arg0, boolean arg1, String arg2) {
		while (this.graphics == null) {
			this.graphics = this.getBaseComponent().getGraphics();

			try {
				this.getBaseComponent().repaint();
			} catch (Exception var10) {
			}

			try {
				Thread.sleep(1000L);
			} catch (Exception var9) {
			}
		}

		Font var4 = new Font("Helvetica", 1, 13);
		FontMetrics var5 = this.getBaseComponent().getFontMetrics(var4);
		if (!arg1) {
			this.a = -145;
		}

		Font var6 = new Font("Helvetica", 0, 13);
		this.getBaseComponent().getFontMetrics(var6);
		if (this.r) {
			this.graphics.setColor(Color.black);
			this.graphics.fillRect(0, 0, this.screenWidth, this.screenHeight);
			this.r = false;
		}

		Color var7 = new Color(140, 17, 17);
		int var8 = this.screenHeight / 2 - 18;
		this.graphics.setColor(var7);
		this.graphics.drawRect(this.screenWidth / 2 - 152, var8, 304, 34);
		this.graphics.fillRect(this.screenWidth / 2 - 150, var8 + 2, arg0 * 3, 30);
		this.graphics.setColor(Color.black);
		this.graphics.fillRect(arg0 * 3 + (this.screenWidth / 2 - 150), var8 + 2, 300 - arg0 * 3, 30);
		this.graphics.setFont(var4);
		this.graphics.setColor(Color.white);
		this.graphics.drawString(arg2, (this.screenWidth - var5.stringWidth(arg2)) / 2, var8 + 22);
	}
}
