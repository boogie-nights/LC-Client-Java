package jagex2.io;

import deob.ObfuscatedName;
import jagex2.client.GameShell;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientStream implements Runnable {
   @ObfuscatedName("GXWEWMHV.b")
   public byte b = 2;
   @ObfuscatedName("GXWEWMHV.f")
   public boolean f = false;
   @ObfuscatedName("GXWEWMHV.k")
   public boolean k = false;
   @ObfuscatedName("GXWEWMHV.l")
   public boolean l = false;
   @ObfuscatedName("GXWEWMHV.g")
   public GameShell g;
   @ObfuscatedName("GXWEWMHV.e")
   public Socket e;
   @ObfuscatedName("GXWEWMHV.a")
   public int a;
   @ObfuscatedName("GXWEWMHV.c")
   public InputStream c;
   @ObfuscatedName("GXWEWMHV.d")
   public OutputStream d;
   @ObfuscatedName("GXWEWMHV.i")
   public int i;
   @ObfuscatedName("GXWEWMHV.j")
   public int j;
   @ObfuscatedName("GXWEWMHV.h")
   public byte[] h;

   public ClientStream(byte arg0, Socket arg1, GameShell arg2) throws IOException {
      this.g = arg2;
      this.e = arg1;
      if (this.b == arg0) {
         boolean var4 = false;
      } else {
         this.a = -5;
      }

      this.e.setSoTimeout(30000);
      this.e.setTcpNoDelay(true);
      this.c = this.e.getInputStream();
      this.d = this.e.getOutputStream();
   }

   @ObfuscatedName("GXWEWMHV.a()V")
   public void close() {
      this.f = true;

      try {
         if (this.c != null) {
            this.c.close();
         }

         if (this.d != null) {
            this.d.close();
         }

         if (this.e != null) {
            this.e.close();
         }
      } catch (IOException var3) {
         System.out.println("Error closing stream");
      }

      this.k = false;
      synchronized(this) {
         this.notify();
      }

      this.h = null;
   }

   @ObfuscatedName("GXWEWMHV.b()I")
   public int read() throws IOException {
      return this.f ? 0 : this.c.read();
   }

   @ObfuscatedName("GXWEWMHV.c()I")
   public int c() throws IOException {
      return this.f ? 0 : this.c.available();
   }

   @ObfuscatedName("GXWEWMHV.a([BII)V")
   public void read(byte[] arg0, int arg1, int arg2) throws IOException {
      if (!this.f) {
         while(arg2 > 0) {
            int var4 = this.c.read(arg0, arg1, arg2);
            if (var4 <= 0) {
               throw new IOException("EOF");
            }

            arg1 += var4;
            arg2 -= var4;
         }

      }
   }

   @ObfuscatedName("GXWEWMHV.a(III[B)V")
   public void write(int arg0, int arg1, int arg2, byte[] arg3) throws IOException {
      if (!this.f) {
         if (this.l) {
            this.l = false;
            throw new IOException("Error in writer thread");
         } else {
            if (this.h == null) {
               this.h = new byte[5000];
            }

            synchronized(this) {
               for(int var6 = 0; var6 < arg1; ++var6) {
                  this.h[this.j] = arg3[arg2 + var6];
                  this.j = (this.j + 1) % 5000;
                  if ((this.i + 4900) % 5000 == this.j) {
                     throw new IOException("buffer overflow");
                  }
               }

               if (!this.k) {
                  this.k = true;
                  this.g.startThread(this, 3);
               }

               this.notify();
            }

            if (arg0 == 0) {
               ;
            }
         }
      }
   }

   public void run() {
      while(this.k) {
         int var2;
         int var3;
         label54: {
            synchronized(this) {
               if (this.j == this.i) {
                  try {
                     this.wait();
                  } catch (InterruptedException var7) {
                  }
               }

               if (this.k) {
                  var2 = this.i;
                  if (this.j >= this.i) {
                     var3 = this.j - this.i;
                  } else {
                     var3 = 5000 - this.i;
                  }
                  break label54;
               }
            }

            return;
         }

         if (var3 > 0) {
            try {
               this.d.write(this.h, var2, var3);
            } catch (IOException var6) {
               this.l = true;
            }

            this.i = (this.i + var3) % 5000;

            try {
               if (this.j == this.i) {
                  this.d.flush();
               }
            } catch (IOException var5) {
               this.l = true;
            }
         }
      }

   }

   @ObfuscatedName("GXWEWMHV.a(Z)V")
   public void a(boolean arg0) {
      System.out.println("dummy:" + this.f);
      System.out.println("tcycl:" + this.i);
      System.out.println("tnum:" + this.j);
      System.out.println("writer:" + this.k);
      if (!arg0) {
         System.out.println("ioerror:" + this.l);

         try {
            System.out.println("available:" + this.c());
         } catch (IOException var2) {
         }
      }
   }
}
