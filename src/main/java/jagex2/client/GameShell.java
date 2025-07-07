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
   public int g = 20;
   @ObfuscatedName("JWWAIQPI.h")
   public int h = 1;
   @ObfuscatedName("JWWAIQPI.i")
   public long[] i = new long[10];
   @ObfuscatedName("JWWAIQPI.k")
   public boolean k = false;
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
   public int j;
   @ObfuscatedName("JWWAIQPI.l")
   public int l;
   @ObfuscatedName("JWWAIQPI.m")
   public int m;
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
   public ViewBox q;
   @ObfuscatedName("JWWAIQPI.o")
   public PixMap o;
   @ObfuscatedName("JWWAIQPI.n")
   public Graphics n;

   @ObfuscatedName("JWWAIQPI.a(III)V")
   public final void a(int arg0, int arg1, int arg2) {
      this.l = arg2;
      this.m = arg1;
      this.q = new ViewBox(this.d, this.m, this, this.l);
      if (arg0 < 0) {
         this.n = this.d(-756).getGraphics();
         this.o = new PixMap(this.m, (byte)-12, this.d(-756), this.l);
         this.a(this, 1);
      }
   }

   @ObfuscatedName("JWWAIQPI.b(III)V")
   public final void b(int arg0, int arg1, int arg2) {
      this.l = arg0;
      if (arg2 == 2) {
         this.m = arg1;
         this.n = this.d(-756).getGraphics();
         this.o = new PixMap(this.m, (byte)-12, this.d(-756), this.l);
         this.a(this, 1);
      }
   }

   public void run() {
      this.d(-756).addMouseListener(this);
      this.d(-756).addMouseMotionListener(this);
      this.d(-756).addKeyListener(this);
      this.d(-756).addFocusListener(this);
      if (this.q != null) {
         this.q.addWindowListener(this);
      }

      this.a(0, true, "Loading...");
      this.a();
      int var1 = 0;
      int var2 = 256;
      int var3 = 1;
      int var4 = 0;
      int var5 = 0;

      for(int var6 = 0; var6 < 10; ++var6) {
         this.i[var6] = System.currentTimeMillis();
      }

      long var7 = System.currentTimeMillis();

      while(true) {
         long var11;
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

            int var9 = var2;
            int var10 = var3;
            var2 = 300;
            var3 = 1;
            var11 = System.currentTimeMillis();
            if (this.i[var1] == 0L) {
               var2 = var9;
               var3 = var10;
            } else if (var11 > this.i[var1]) {
               var2 = (int)((long)(this.g * 2560) / (var11 - this.i[var1]));
            }

            if (var2 < 25) {
               var2 = 25;
            }

            if (var2 > 256) {
               var2 = 256;
               var3 = (int)((long)this.g - (var11 - this.i[var1]) / 10L);
            }

            if (var3 > this.g) {
               var3 = this.g;
            }

            this.i[var1] = var11;
            var1 = (var1 + 1) % 10;
            if (var3 > 1) {
               for(int var13 = 0; var13 < 10; ++var13) {
                  if (this.i[var13] != 0L) {
                     this.i[var13] += (long)var3;
                  }
               }
            }

            if (var3 < this.h) {
               var3 = this.h;
            }

            try {
               Thread.sleep((long)var3);
            } catch (InterruptedException var16) {
               ++var5;
            }

            while(var4 < 256) {
               this.B = this.x;
               this.C = this.y;
               this.D = this.z;
               this.E = this.A;
               this.x = 0;
               this.a((byte)-111);
               this.H = this.I;
               var4 += var2;
            }

            var4 &= 255;
            if (this.g > 0) {
               this.j = var2 * 1000 / (this.g * 256);
            }

            this.c(818);
         } while(!this.k);

         System.out.println("ntime:" + var11);

         for(int var14 = 0; var14 < 10; ++var14) {
            int var15 = (var1 - var14 - 1 + 20) % 10;
            System.out.println("otim" + var15 + ":" + this.i[var15]);
         }

         System.out.println("fps:" + this.j + " ratio:" + var2 + " count:" + var4);
         System.out.println("del:" + var3 + " deltime:" + this.g + " mindel:" + this.h);
         System.out.println("intex:" + var5 + " opos:" + var1);
         this.k = false;
         var5 = 0;
      }
   }

   @ObfuscatedName("JWWAIQPI.a(Z)V")
   public final void a(boolean arg0) {
      this.f = -2;
      this.b((int)277);
      if (!arg0) {
         if (this.q != null) {
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

      this.g = 1000 / arg1;
   }

   public final void start() {
      if (this.f >= 0) {
         this.f = 0;
      }

   }

   public final void stop() {
      if (this.f >= 0) {
         this.f = 4000 / this.g;
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
      if (this.n == null) {
         this.n = arg0;
      }

      this.r = true;
      this.b((byte)-99);
   }

   public final void paint(Graphics arg0) {
      if (this.n == null) {
         this.n = arg0;
      }

      this.r = true;
      this.b((byte)-99);
   }

   public final void mousePressed(MouseEvent arg0) {
      int var2 = arg0.getX();
      int var3 = arg0.getY();
      if (this.q != null) {
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
      if (this.q != null) {
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
      if (this.q != null) {
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

      if (Linkable.d) {
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
      while(arg0 >= 0) {
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
      this.b((byte)-99);
   }

   public final void focusLost(FocusEvent arg0) {
      this.s = false;

      for(int var2 = 0; var2 < 128; ++var2) {
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
   public void a() {
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
   public java.awt.Component d(int arg0) {
      if (arg0 >= 0) {
         this.d = 329;
      }

      return this.q != null ? this.q : this;
   }

   @ObfuscatedName("JWWAIQPI.a(Ljava/lang/Runnable;I)V")
   public void a(Runnable arg0, int arg1) {
      Thread var3 = new Thread(arg0);
      var3.start();
      var3.setPriority(arg1);
   }

   @ObfuscatedName("JWWAIQPI.a(IZLjava/lang/String;)V")
   public void a(int arg0, boolean arg1, String arg2) {
      while(this.n == null) {
         this.n = this.d(-756).getGraphics();

         try {
            this.d(-756).repaint();
         } catch (Exception var10) {
         }

         try {
            Thread.sleep(1000L);
         } catch (Exception var9) {
         }
      }

      Font var4 = new Font("Helvetica", 1, 13);
      FontMetrics var5 = this.d(-756).getFontMetrics(var4);
      if (!arg1) {
         this.a = -145;
      }

      Font var6 = new Font("Helvetica", 0, 13);
      this.d(-756).getFontMetrics(var6);
      if (this.r) {
         this.n.setColor(Color.black);
         this.n.fillRect(0, 0, this.l, this.m);
         this.r = false;
      }

      Color var7 = new Color(140, 17, 17);
      int var8 = this.m / 2 - 18;
      this.n.setColor(var7);
      this.n.drawRect(this.l / 2 - 152, var8, 304, 34);
      this.n.fillRect(this.l / 2 - 150, var8 + 2, arg0 * 3, 30);
      this.n.setColor(Color.black);
      this.n.fillRect(arg0 * 3 + (this.l / 2 - 150), var8 + 2, 300 - arg0 * 3, 30);
      this.n.setFont(var4);
      this.n.setColor(Color.white);
      this.n.drawString(arg2, (this.l - var5.stringWidth(arg2)) / 2, var8 + 22);
   }
}
