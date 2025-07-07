package jagex2.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;

import deob.ObfuscatedName;
import jagex2.client.Client;
import jagex2.datastruct.DoublyLinkList;
import jagex2.datastruct.LinkList;

public class OnDemand extends OnDemandProvider implements Runnable {
   @ObfuscatedName("ZPGPWCCV.e")
   public byte[][] e = new byte[4][];
   @ObfuscatedName("ZPGPWCCV.f")
   public boolean f = false;
   @ObfuscatedName("ZPGPWCCV.g")
   public boolean g = true;
   @ObfuscatedName("ZPGPWCCV.h")
   public LinkList h = new LinkList();
   @ObfuscatedName("ZPGPWCCV.l")
   public int[][] l = new int[4][];
   @ObfuscatedName("ZPGPWCCV.o")
   public String o = "";
   @ObfuscatedName("ZPGPWCCV.s")
   public LinkList s = new LinkList();
   @ObfuscatedName("ZPGPWCCV.t")
   public boolean t = false;
   @ObfuscatedName("ZPGPWCCV.v")
   public CRC32 v = new CRC32();
   @ObfuscatedName("ZPGPWCCV.x")
   public boolean x = false;
   @ObfuscatedName("ZPGPWCCV.y")
   public LinkList y = new LinkList();
   @ObfuscatedName("ZPGPWCCV.z")
   public LinkList z = new LinkList();
   @ObfuscatedName("ZPGPWCCV.A")
   public byte[] A = new byte[65000];
   @ObfuscatedName("ZPGPWCCV.F")
   public byte[] F = new byte[500];
   @ObfuscatedName("ZPGPWCCV.I")
   public int I = 591;
   @ObfuscatedName("ZPGPWCCV.K")
   public DoublyLinkList K = new DoublyLinkList(true);
   @ObfuscatedName("ZPGPWCCV.M")
   public byte M = 6;
   @ObfuscatedName("ZPGPWCCV.P")
   public LinkList P = new LinkList();
   @ObfuscatedName("ZPGPWCCV.S")
   public int[][] S = new int[4][];
   @ObfuscatedName("ZPGPWCCV.V")
   public boolean V = false;
   @ObfuscatedName("ZPGPWCCV.C")
   public int C;
   @ObfuscatedName("ZPGPWCCV.D")
   public int D;
   @ObfuscatedName("ZPGPWCCV.E")
   public int E;
   @ObfuscatedName("ZPGPWCCV.J")
   public int J;
   @ObfuscatedName("ZPGPWCCV.Q")
   public int Q;
   @ObfuscatedName("ZPGPWCCV.U")
   public int U;
   @ObfuscatedName("ZPGPWCCV.b")
   public int b;
   @ObfuscatedName("ZPGPWCCV.i")
   public int i;
   @ObfuscatedName("ZPGPWCCV.j")
   public int j;
   @ObfuscatedName("ZPGPWCCV.k")
   public int k;
   @ObfuscatedName("ZPGPWCCV.m")
   public int m;
   @ObfuscatedName("ZPGPWCCV.p")
   public int p;
   @ObfuscatedName("ZPGPWCCV.r")
   public int r;
   @ObfuscatedName("ZPGPWCCV.u")
   public int u;
   @ObfuscatedName("ZPGPWCCV.T")
   public long T;
   @ObfuscatedName("ZPGPWCCV.N")
   public OnDemandRequest N;
   @ObfuscatedName("ZPGPWCCV.O")
   public Client O;
   @ObfuscatedName("ZPGPWCCV.L")
   public InputStream L;
   @ObfuscatedName("ZPGPWCCV.q")
   public OutputStream q;
   @ObfuscatedName("ZPGPWCCV.w")
   public Socket w;
   @ObfuscatedName("ZPGPWCCV.c")
   public byte[] c;
   @ObfuscatedName("ZPGPWCCV.B")
   public int[] B;
   @ObfuscatedName("ZPGPWCCV.G")
   public int[] G;
   @ObfuscatedName("ZPGPWCCV.H")
   public int[] H;
   @ObfuscatedName("ZPGPWCCV.R")
   public int[] R;
   @ObfuscatedName("ZPGPWCCV.d")
   public int[] d;
   @ObfuscatedName("ZPGPWCCV.n")
   public int[] n;

   @ObfuscatedName("ZPGPWCCV.a(Z)V")
   public final void a(boolean arg0) {
      if (arg0) {
         this.J = 138;
      }

      try {
         int var2 = this.L.available();
         if (this.D == 0 && var2 >= 6) {
            this.f = true;

            for(int var3 = 0; var3 < 6; var3 += this.L.read(this.F, var3, 6 - var3)) {
            }

            int var4 = this.F[0] & 255;
            int var5 = ((this.F[1] & 255) << 8) + (this.F[2] & 255);
            int var6 = ((this.F[3] & 255) << 8) + (this.F[4] & 255);
            int var7 = this.F[5] & 255;
            this.N = null;

            for(OnDemandRequest var8 = (OnDemandRequest)this.P.b(); var8 != null; var8 = (OnDemandRequest)this.P.a(1)) {
               if (var8.h == var4 && var8.i == var5) {
                  this.N = var8;
               }

               if (this.N != null) {
                  var8.j = 0;
               }
            }

            if (this.N != null) {
               this.u = 0;
               if (var6 == 0) {
                  sign.Signlink.reporterror("Rej: " + var4 + "," + var5);
                  this.N.k = null;
                  if (this.N.l) {
                     LinkList var9 = this.y;
                     synchronized(this.y) {
                        this.y.a(this.N);
                     }
                  } else {
                     this.N.a();
                  }

                  this.N = null;
               } else {
                  if (this.N.k == null && var7 == 0) {
                     this.N.k = new byte[var6];
                  }

                  if (this.N.k == null && var7 != 0) {
                     throw new IOException("missing start of file");
                  }
               }
            }

            this.C = var7 * 500;
            this.D = 500;
            if (this.D > var6 - var7 * 500) {
               this.D = var6 - var7 * 500;
            }
         }

         if (this.D > 0 && var2 >= this.D) {
            this.f = true;
            byte[] var10 = this.F;
            int var11 = 0;
            if (this.N != null) {
               var10 = this.N.k;
               var11 = this.C;
            }

            for(int var12 = 0; var12 < this.D; var12 += this.L.read(var10, var11 + var12, this.D - var12)) {
            }

            if (this.D + this.C >= var10.length && this.N != null) {
               if (this.O.mi[0] != null) {
                  this.O.mi[this.N.h + 1].a(var10.length, true, var10, this.N.i);
               }

               if (!this.N.l && this.N.h == 3) {
                  this.N.l = true;
                  this.N.h = 93;
               }

               if (this.N.l) {
                  LinkList var13 = this.y;
                  synchronized(this.y) {
                     this.y.a(this.N);
                  }
               } else {
                  this.N.a();
               }
            }

            this.D = 0;
         }
      } catch (IOException var18) {
         try {
            this.w.close();
         } catch (Exception var15) {
         }

         this.w = null;
         this.L = null;
         this.q = null;
         this.D = 0;
      }
   }

   @ObfuscatedName("ZPGPWCCV.a(II)I")
   public final int a(int arg0, int arg1) {
      return arg1 < 0 ? this.c[arg0] & 255 : this.I;
   }

   @ObfuscatedName("ZPGPWCCV.a(I)V")
   public final void a(int arg0) {
      this.b(0, arg0);
   }

   @ObfuscatedName("ZPGPWCCV.b(I)V")
   public final void b(int arg0) {
      if (arg0 == 0) {
         while(this.j == 0) {
            if (this.k >= 10 || this.i == 0) {
               return;
            }

            LinkList var2 = this.z;
            OnDemandRequest var3;
            synchronized(this.z) {
               var3 = (OnDemandRequest)this.z.pop();
            }

            while(var3 != null) {
               if (this.e[var3.h][var3.i] != 0) {
                  this.e[var3.h][var3.i] = 0;
                  this.P.a(var3);
                  this.a(this.m, var3);
                  this.f = true;
                  if (this.b < this.r) {
                     ++this.b;
                  }

                  this.o = "Loading extra files - " + this.b * 100 / this.r + "%";
                  ++this.k;
                  if (this.k == 10) {
                     return;
                  }
               }

               LinkList var4 = this.z;
               synchronized(this.z) {
                  var3 = (OnDemandRequest)this.z.pop();
               }
            }

            for(int var5 = 0; var5 < 4; ++var5) {
               byte[] var6 = this.e[var5];
               int var7 = var6.length;

               for(int var8 = 0; var8 < var7; ++var8) {
                  if (var6[var8] == this.i) {
                     var6[var8] = 0;
                     OnDemandRequest var9 = new OnDemandRequest();
                     var9.h = var5;
                     var9.i = var8;
                     var9.l = false;
                     this.P.a(var9);
                     this.a(this.m, var9);
                     this.f = true;
                     if (this.b < this.r) {
                        ++this.b;
                     }

                     this.o = "Loading extra files - " + this.b * 100 / this.r + "%";
                     ++this.k;
                     if (this.k == 10) {
                        return;
                     }
                  }
               }
            }

            --this.i;
         }

      }
   }

   @ObfuscatedName("ZPGPWCCV.a(IIBI)V")
   public final void a(int arg0, int arg1, byte arg2, int arg3) {
      if (arg0 < 0) {
         if (this.O.mi[0] != null) {
            if (this.S[arg1][arg3] != 0) {
               byte[] var5 = this.O.mi[arg1 + 1].a(this.M, arg3);
               if (!this.a(var5, 764, this.S[arg1][arg3], this.l[arg1][arg3])) {
                  this.e[arg1][arg3] = arg2;
                  if (arg2 > this.i) {
                     this.i = arg2;
                  }

                  ++this.r;
               }
            }
         }
      }
   }

   @ObfuscatedName("ZPGPWCCV.a(IZ)Z")
   public final boolean a(int arg0, boolean arg1) {
      if (!arg1) {
         throw new NullPointerException();
      } else {
         return this.H[arg0] == 1;
      }
   }

   @ObfuscatedName("ZPGPWCCV.b(II)V")
   public final void b(int arg0, int arg1) {
      if (arg0 >= 0 && arg0 <= this.S.length && arg1 >= 0 && arg1 <= this.S[arg0].length) {
         if (this.S[arg0][arg1] != 0) {
            DoublyLinkList var3 = this.K;
            synchronized(this.K) {
               for(OnDemandRequest var4 = (OnDemandRequest)this.K.b(); var4 != null; var4 = (OnDemandRequest)this.K.a(1)) {
                  if (var4.h == arg0 && var4.i == arg1) {
                     return;
                  }
               }

               OnDemandRequest var5 = new OnDemandRequest();
               var5.h = arg0;
               var5.i = arg1;
               var5.l = true;
               LinkList var6 = this.h;
               synchronized(this.h) {
                  this.h.a(var5);
               }

               this.K.a(var5);
            }
         }
      }
   }

   @ObfuscatedName("ZPGPWCCV.a()LQSLIGKQQ;")
   public final OnDemandRequest a() {
      LinkList var1 = this.y;
      OnDemandRequest var2;
      synchronized(this.y) {
         var2 = (OnDemandRequest)this.y.pop();
      }

      if (var2 == null) {
         return null;
      } else {
         DoublyLinkList var3 = this.K;
         synchronized(this.K) {
            var2.b();
         }

         if (var2.k == null) {
            return var2;
         } else {
            int var4 = 0;

            try {
               GZIPInputStream var5 = new GZIPInputStream(new ByteArrayInputStream(var2.k));

               while(true) {
                  if (this.A.length == var4) {
                     throw new RuntimeException("buffer overflow!");
                  }

                  int var6 = var5.read(this.A, var4, this.A.length - var4);
                  if (var6 == -1) {
                     break;
                  }

                  var4 += var6;
               }
            } catch (IOException var10) {
               throw new RuntimeException("error unzipping");
            }

            var2.k = new byte[var4];

            for(int var7 = 0; var7 < var4; ++var7) {
               var2.k[var7] = this.A[var7];
            }

            return var2;
         }
      }
   }

   public final void run() {
      try {
         while(this.g) {
            ++this.p;
            byte var1 = 20;
            if (this.i == 0 && this.O.mi[0] != null) {
               var1 = 50;
            }

            try {
               Thread.sleep((long)var1);
            } catch (Exception var9) {
            }

            this.f = true;

            for(int var2 = 0; var2 < 100 && this.f; ++var2) {
               this.f = false;
               this.b(true);
               this.c(0);
               if (this.j == 0 && var2 >= 5) {
                  break;
               }

               this.b(0);
               if (this.L != null) {
                  this.a(false);
               }
            }

            boolean var3 = false;

            for(OnDemandRequest var4 = (OnDemandRequest)this.P.b(); var4 != null; var4 = (OnDemandRequest)this.P.a(1)) {
               if (var4.l) {
                  var3 = true;
                  ++var4.j;
                  if (var4.j > 50) {
                     var4.j = 0;
                     this.a(this.m, var4);
                  }
               }
            }

            if (!var3) {
               for(OnDemandRequest var5 = (OnDemandRequest)this.P.b(); var5 != null; var5 = (OnDemandRequest)this.P.a(1)) {
                  var3 = true;
                  ++var5.j;
                  if (var5.j > 50) {
                     var5.j = 0;
                     this.a(this.m, var5);
                  }
               }
            }

            if (var3) {
               ++this.u;
               if (this.u > 750) {
                  try {
                     this.w.close();
                  } catch (Exception var8) {
                  }

                  this.w = null;
                  this.L = null;
                  this.q = null;
                  this.D = 0;
               }
            } else {
               this.u = 0;
               this.o = "";
            }

            if (this.O.zg && this.w != null && this.q != null && (this.i > 0 || this.O.mi[0] == null)) {
               ++this.Q;
               if (this.Q > 500) {
                  this.Q = 0;
                  this.F[0] = 0;
                  this.F[1] = 0;
                  this.F[2] = 0;
                  this.F[3] = 10;

                  try {
                     this.q.write(this.F, 0, 4);
                  } catch (IOException var7) {
                     this.u = 5000;
                  }
               }
            }
         }

      } catch (Exception var10) {
         sign.Signlink.reporterror("od_ex " + var10.getMessage());
      }
   }

   @ObfuscatedName("ZPGPWCCV.c(I)V")
   public final void c(int arg0) {
      this.j = 0;
      this.k = 0;
      if (arg0 == 0) {
         for(OnDemandRequest var2 = (OnDemandRequest)this.P.b(); var2 != null; var2 = (OnDemandRequest)this.P.a(1)) {
            if (var2.l) {
               ++this.j;
            } else {
               ++this.k;
            }
         }

         while(this.j < 10) {
            OnDemandRequest var3 = (OnDemandRequest)this.s.pop();
            if (var3 == null) {
               break;
            }

            if (this.e[var3.h][var3.i] != 0) {
               ++this.b;
            }

            this.e[var3.h][var3.i] = 0;
            this.P.a(var3);
            ++this.j;
            this.a(this.m, var3);
            this.f = true;
         }

      }
   }

   @ObfuscatedName("ZPGPWCCV.a(ZB)V")
   public final void a(boolean arg0, byte arg1) {
      if (arg1 != 109) {
         this.t = !this.t;
      }

      int var3 = this.n.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         if (arg0 || this.d[var4] != 0) {
            this.a(-44, 3, (byte)2, this.G[var4]);
            this.a(-44, 3, (byte)2, this.B[var4]);
         }
      }

   }

   @ObfuscatedName("ZPGPWCCV.b()I")
   public final int b() {
      DoublyLinkList var1 = this.K;
      synchronized(this.K){}

      int var2;
      try {
         var2 = this.K.c();
      } catch (Throwable var5) {
         throw var5;
      }

      return var2;
   }

   @ObfuscatedName("ZPGPWCCV.b(IZ)Z")
   public final boolean b(int arg0, boolean arg1) {
      for(int var3 = 0; var3 < this.n.length; ++var3) {
         if (this.G[var3] == arg0) {
            return true;
         }
      }

      if (arg1) {
         this.E = -405;
      }

      return false;
   }

   @ObfuscatedName("ZPGPWCCV.a(LATJMVOZR;Lclient;)V")
   public final void a(Jagfile arg0, Client arg1) {
      String[] var3 = new String[]{"model_version", "anim_version", "midi_version", "map_version"};

      for(int var4 = 0; var4 < 4; ++var4) {
         byte[] var5 = arg0.a(var3[var4], (byte[])null);
         int var6 = var5.length / 2;
         Packet var7 = new Packet(var5);
         this.S[var4] = new int[var6];
         this.e[var4] = new byte[var6];

         for(int var8 = 0; var8 < var6; ++var8) {
            this.S[var4][var8] = var7.g2();
         }
      }

      String[] var9 = new String[]{"model_crc", "anim_crc", "midi_crc", "map_crc"};

      for(int var10 = 0; var10 < 4; ++var10) {
         byte[] var11 = arg0.a(var9[var10], (byte[])null);
         int var12 = var11.length / 4;
         Packet var13 = new Packet(var11);
         this.l[var10] = new int[var12];

         for(int var14 = 0; var14 < var12; ++var14) {
            this.l[var10][var14] = var13.g4();
         }
      }

      byte[] var15 = arg0.a("model_index", (byte[])null);
      int var16 = this.S[0].length;
      this.c = new byte[var16];

      for(int var17 = 0; var17 < var16; ++var17) {
         if (var17 < var15.length) {
            this.c[var17] = var15[var17];
         } else {
            this.c[var17] = 0;
         }
      }

      byte[] var18 = arg0.a("map_index", (byte[])null);
      Packet var19 = new Packet(var18);
      int var20 = var18.length / 7;
      this.n = new int[var20];
      this.B = new int[var20];
      this.G = new int[var20];
      this.d = new int[var20];

      for(int var21 = 0; var21 < var20; ++var21) {
         this.n[var21] = var19.g2();
         this.B[var21] = var19.g2();
         this.G[var21] = var19.g2();
         this.d[var21] = var19.g1();
      }

      byte[] var22 = arg0.a("anim_index", (byte[])null);
      Packet var23 = new Packet(var22);
      int var24 = var22.length / 2;
      this.R = new int[var24];

      for(int var25 = 0; var25 < var24; ++var25) {
         this.R[var25] = var23.g2();
      }

      byte[] var26 = arg0.a("midi_index", (byte[])null);
      Packet var27 = new Packet(var26);
      int var28 = var26.length;
      this.H = new int[var28];

      for(int var29 = 0; var29 < var28; ++var29) {
         this.H[var29] = var27.g1();
      }

      this.O = arg1;
      this.g = true;
      this.O.a((Runnable)this, 2);
   }

   @ObfuscatedName("ZPGPWCCV.a(B)V")
   public final void a(byte arg0) {
      LinkList var2 = this.z;
      synchronized(this.z) {
         this.z.c();
      }

      if (arg0 != -125) {
         this.t = !this.t;
      }
   }

   @ObfuscatedName("ZPGPWCCV.a(IIB)V")
   public final void a(int arg0, int arg1, byte arg2) {
      if (this.O.mi[0] != null) {
         if (this.S[arg1][arg0] != 0) {
            if (this.e[arg1][arg0] != 0) {
               if (this.i != 0) {
                  OnDemandRequest var4 = new OnDemandRequest();
                  if (arg2 != -113) {
                     this.I = 244;
                  }

                  var4.h = arg1;
                  var4.i = arg0;
                  var4.l = false;
                  LinkList var5 = this.z;
                  synchronized(this.z) {
                     this.z.a(var4);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ZPGPWCCV.b(Z)V")
   public final void b(boolean arg0) {
      LinkList var2 = this.h;
      OnDemandRequest var3;
      synchronized(this.h) {
         var3 = (OnDemandRequest)this.h.pop();
      }

      if (!arg0) {
         for(int var4 = 1; var4 > 0; ++var4) {
         }
      }

      while(var3 != null) {
         this.f = true;
         byte[] var5 = null;
         if (this.O.mi[0] != null) {
            var5 = this.O.mi[var3.h + 1].a(this.M, var3.i);
         }

         if (!this.a(var5, 764, this.S[var3.h][var3.i], this.l[var3.h][var3.i])) {
            var5 = null;
         }

         LinkList var6 = this.h;
         synchronized(this.h) {
            if (var5 == null) {
               this.s.a(var3);
            } else {
               var3.k = var5;
               LinkList var7 = this.y;
               synchronized(this.y) {
                  this.y.a(var3);
               }
            }

            var3 = (OnDemandRequest)this.h.pop();
         }
      }

   }

   @ObfuscatedName("ZPGPWCCV.c()V")
   public final void c() {
      this.g = false;
   }

   @ObfuscatedName("ZPGPWCCV.c(II)I")
   public final int c(int arg0, int arg1) {
      if (arg1 != -31140) {
         this.V = !this.V;
      }

      return this.S[arg0].length;
   }

   @ObfuscatedName("ZPGPWCCV.a([BIII)Z")
   public final boolean a(byte[] arg0, int arg1, int arg2, int arg3) {
      int var5 = 22 / arg1;
      if (arg0 != null && arg0.length >= 2) {
         int var6 = arg0.length - 2;
         int var7 = ((arg0[var6] & 255) << 8) + (arg0[var6 + 1] & 255);
         this.v.reset();
         this.v.update(arg0, 0, var6);
         int var8 = (int)this.v.getValue();
         if (arg2 != var7) {
            return false;
         } else {
            return arg3 == var8;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("ZPGPWCCV.a(ILQSLIGKQQ;)V")
   public final void a(int arg0, OnDemandRequest arg1) {
      if (arg0 == 0) {
         try {
            if (this.w == null) {
               long var3 = System.currentTimeMillis();
               if (var3 - this.T < 4000L) {
                  return;
               }

               this.T = var3;
               this.w = this.O.g(Client.tc + 43594);
               this.L = this.w.getInputStream();
               this.q = this.w.getOutputStream();
               this.q.write(15);

               for(int var5 = 0; var5 < 8; ++var5) {
                  this.L.read();
               }

               this.u = 0;
            }

            this.F[0] = (byte)arg1.h;
            this.F[1] = (byte)(arg1.i >> 8);
            this.F[2] = (byte)arg1.i;
            if (arg1.l) {
               this.F[3] = 2;
            } else if (!this.O.zg) {
               this.F[3] = 1;
            } else {
               this.F[3] = 0;
            }

            this.q.write(this.F, 0, 4);
            this.Q = 0;
            this.U = -10000;
         } catch (IOException var8) {
            try {
               this.w.close();
            } catch (Exception var7) {
            }

            this.w = null;
            this.L = null;
            this.q = null;
            this.D = 0;
            ++this.U;
         }
      }
   }

   @ObfuscatedName("ZPGPWCCV.d(I)I")
   public final int d(int arg0) {
      int var2 = 0 / arg0;
      return this.R.length;
   }

   @ObfuscatedName("ZPGPWCCV.a(IIII)I")
   public final int a(int arg0, int arg1, int arg2, int arg3) {
      if (arg0 != 0) {
         return 1;
      } else {
         int var5 = (arg1 << 8) + arg2;

         for(int var6 = 0; var6 < this.n.length; ++var6) {
            if (this.n[var6] == var5) {
               if (arg3 == 0) {
                  return this.B[var6];
               }

               return this.G[var6];
            }
         }

         return -1;
      }
   }
}
