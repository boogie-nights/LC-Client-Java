package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.io.Packet;

public class SoundTone {
   @ObfuscatedName("DXRZIVAQ.a")
   public byte a = 6;
   @ObfuscatedName("DXRZIVAQ.b")
   public int b = 8;
   @ObfuscatedName("DXRZIVAQ.k")
   public int[] k = new int[5];
   @ObfuscatedName("DXRZIVAQ.l")
   public int[] l = new int[5];
   @ObfuscatedName("DXRZIVAQ.m")
   public int[] m = new int[5];
   @ObfuscatedName("DXRZIVAQ.o")
   public int o = 100;
   @ObfuscatedName("DXRZIVAQ.r")
   public int r = 500;
   @ObfuscatedName("DXRZIVAQ.w")
   public static int[] w = new int[5];
   @ObfuscatedName("DXRZIVAQ.x")
   public static int[] x = new int[5];
   @ObfuscatedName("DXRZIVAQ.y")
   public static int[] y = new int[5];
   @ObfuscatedName("DXRZIVAQ.z")
   public static int[] z = new int[5];
   @ObfuscatedName("DXRZIVAQ.A")
   public static int[] A = new int[5];
   @ObfuscatedName("DXRZIVAQ.n")
   public int n;
   @ObfuscatedName("DXRZIVAQ.s")
   public int s;
   @ObfuscatedName("DXRZIVAQ.c")
   public SoundEnvelope c;
   @ObfuscatedName("DXRZIVAQ.d")
   public SoundEnvelope d;
   @ObfuscatedName("DXRZIVAQ.e")
   public SoundEnvelope e;
   @ObfuscatedName("DXRZIVAQ.f")
   public SoundEnvelope f;
   @ObfuscatedName("DXRZIVAQ.g")
   public SoundEnvelope g;
   @ObfuscatedName("DXRZIVAQ.h")
   public SoundEnvelope h;
   @ObfuscatedName("DXRZIVAQ.i")
   public SoundEnvelope i;
   @ObfuscatedName("DXRZIVAQ.j")
   public SoundEnvelope j;
   @ObfuscatedName("DXRZIVAQ.q")
   public SoundEnvelope q;
   @ObfuscatedName("DXRZIVAQ.p")
   public SoundFilter p;
   @ObfuscatedName("DXRZIVAQ.t")
   public static int[] t;
   @ObfuscatedName("DXRZIVAQ.u")
   public static int[] u;
   @ObfuscatedName("DXRZIVAQ.v")
   public static int[] v;

   @ObfuscatedName("DXRZIVAQ.a()V")
   public static final void a() {
      u = new int[32768];

      for(int var0 = 0; var0 < 32768; ++var0) {
         if (Math.random() > 0.5D) {
            u[var0] = 1;
         } else {
            u[var0] = -1;
         }
      }

      v = new int[32768];

      for(int var1 = 0; var1 < 32768; ++var1) {
         v[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
      }

      t = new int[220500];
   }

   @ObfuscatedName("DXRZIVAQ.a(II)[I")
   public final int[] a(int arg0, int arg1) {
      for(int var3 = 0; var3 < arg0; ++var3) {
         t[var3] = 0;
      }

      if (arg1 < 10) {
         return t;
      } else {
         double var4 = (double)arg0 / ((double)arg1 + 0.0D);
         this.c.a(true);
         this.d.a(true);
         int var6 = 0;
         int var7 = 0;
         int var8 = 0;
         if (this.e != null) {
            this.e.a(true);
            this.f.a(true);
            var6 = (int)((double)(this.e.f - this.e.e) * 32.768D / var4);
            var7 = (int)((double)this.e.e * 32.768D / var4);
         }

         int var9 = 0;
         int var10 = 0;
         int var11 = 0;
         if (this.g != null) {
            this.g.a(true);
            this.h.a(true);
            var9 = (int)((double)(this.g.f - this.g.e) * 32.768D / var4);
            var10 = (int)((double)this.g.e * 32.768D / var4);
         }

         for(int var12 = 0; var12 < 5; ++var12) {
            if (this.k[var12] != 0) {
               w[var12] = 0;
               x[var12] = (int)((double)this.m[var12] * var4);
               y[var12] = (this.k[var12] << 14) / 100;
               z[var12] = (int)((double)(this.c.f - this.c.e) * 32.768D * Math.pow(1.0057929410678534D, (double)this.l[var12]) / var4);
               A[var12] = (int)((double)this.c.e * 32.768D / var4);
            }
         }

         for(int var13 = 0; var13 < arg0; ++var13) {
            int var14 = this.c.a(0, arg0);
            int var15 = this.d.a(0, arg0);
            if (this.e != null) {
               int var16 = this.e.a(0, arg0);
               int var17 = this.f.a(0, arg0);
               var14 += this.a(-887, var8, this.e.g, var17) >> 1;
               var8 += (var6 * var16 >> 16) + var7;
            }

            if (this.g != null) {
               int var18 = this.g.a(0, arg0);
               int var19 = this.h.a(0, arg0);
               var15 = var15 * ((this.a(-887, var11, this.g.g, var19) >> 1) + 32768) >> 15;
               var11 += (var9 * var18 >> 16) + var10;
            }

            for(int var20 = 0; var20 < 5; ++var20) {
               if (this.k[var20] != 0) {
                  int var21 = x[var20] + var13;
                  if (var21 < arg0) {
                     t[var21] += this.a(-887, w[var20], this.c.g, y[var20] * var15 >> 15);
                     w[var20] += (z[var20] * var14 >> 16) + A[var20];
                  }
               }
            }
         }

         if (this.i != null) {
            this.i.a(true);
            this.j.a(true);
            int var22 = 0;
            boolean var23 = false;
            boolean var24 = true;

            for(int var25 = 0; var25 < arg0; ++var25) {
               int var26 = this.i.a(0, arg0);
               int var27 = this.j.a(0, arg0);
               int var28;
               if (var24) {
                  var28 = ((this.i.f - this.i.e) * var26 >> 8) + this.i.e;
               } else {
                  var28 = ((this.i.f - this.i.e) * var27 >> 8) + this.i.e;
               }

               var22 += 256;
               if (var22 >= var28) {
                  var22 = 0;
                  var24 = !var24;
               }

               if (var24) {
                  t[var25] = 0;
               }
            }
         }

         if (this.n > 0 && this.o > 0) {
            int var29 = (int)((double)this.n * var4);

            for(int var30 = var29; var30 < arg0; ++var30) {
               t[var30] += t[var30 - var29] * this.o / 100;
            }
         }

         if (this.p.c[0] > 0 || this.p.c[1] > 0) {
            this.q.a(true);
            int var31 = this.q.a(0, arg0 + 1);
            int var32 = this.p.a(0, true, (float)var31 / 65536.0F);
            int var33 = this.p.a(1, true, (float)var31 / 65536.0F);
            if (arg0 >= var32 + var33) {
               int var34 = 0;
               int var35 = var33;
               if (var33 > arg0 - var32) {
                  var35 = arg0 - var32;
               }

               while(var34 < var35) {
                  int var36 = (int)((long)t[var32 + var34] * (long)SoundFilter.j >> 16);

                  for(int var37 = 0; var37 < var32; ++var37) {
                     var36 += (int)((long)t[var32 + var34 - 1 - var37] * (long)SoundFilter.h[0][var37] >> 16);
                  }

                  for(int var38 = 0; var38 < var34; ++var38) {
                     var36 -= (int)((long)t[var34 - 1 - var38] * (long)SoundFilter.h[1][var38] >> 16);
                  }

                  t[var34] = var36;
                  var31 = this.q.a(0, arg0 + 1);
                  ++var34;
               }

               short var39 = 128;
               int var40 = var39;

               while(true) {
                  if (var40 > arg0 - var32) {
                     var40 = arg0 - var32;
                  }

                  while(var34 < var40) {
                     int var41 = (int)((long)t[var32 + var34] * (long)SoundFilter.j >> 16);

                     for(int var42 = 0; var42 < var32; ++var42) {
                        var41 += (int)((long)t[var32 + var34 - 1 - var42] * (long)SoundFilter.h[0][var42] >> 16);
                     }

                     for(int var43 = 0; var43 < var33; ++var43) {
                        var41 -= (int)((long)t[var34 - 1 - var43] * (long)SoundFilter.h[1][var43] >> 16);
                     }

                     t[var34] = var41;
                     var31 = this.q.a(0, arg0 + 1);
                     ++var34;
                  }

                  if (var34 >= arg0 - var32) {
                     while(var34 < arg0) {
                        int var44 = 0;

                        for(int var45 = var32 + var34 - arg0; var45 < var32; ++var45) {
                           var44 += (int)((long)t[var32 + var34 - 1 - var45] * (long)SoundFilter.h[0][var45] >> 16);
                        }

                        for(int var46 = 0; var46 < var33; ++var46) {
                           var44 -= (int)((long)t[var34 - 1 - var46] * (long)SoundFilter.h[1][var46] >> 16);
                        }

                        t[var34] = var44;
                        this.q.a(0, arg0 + 1);
                        ++var34;
                     }
                     break;
                  }

                  var32 = this.p.a(0, true, (float)var31 / 65536.0F);
                  var33 = this.p.a(1, true, (float)var31 / 65536.0F);
                  var40 += var39;
               }
            }
         }

         for(int var48 = 0; var48 < arg0; ++var48) {
            if (t[var48] < -32768) {
               t[var48] = -32768;
            }

            if (t[var48] > 32767) {
               t[var48] = 32767;
            }
         }

         return t;
      }
   }

   @ObfuscatedName("DXRZIVAQ.a(IIII)I")
   public final int a(int arg0, int arg1, int arg2, int arg3) {
      while(arg0 >= 0) {
         this.b = -409;
      }

      if (arg2 == 1) {
         if ((arg1 & 32767) < 16384) {
            return arg3;
         } else {
            return -arg3;
         }
      } else if (arg2 == 2) {
         return v[arg1 & 32767] * arg3 >> 14;
      } else if (arg2 == 3) {
         return ((arg1 & 32767) * arg3 >> 14) - arg3;
      } else if (arg2 == 4) {
         return u[arg1 / 2607 & 32767] * arg3;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("DXRZIVAQ.a(BLMFMVIYHT;)V")
   public final void a(byte arg0, Packet arg1) {
      this.c = new SoundEnvelope();
      this.c.a(this.a, arg1);
      this.d = new SoundEnvelope();
      this.d.a(this.a, arg1);
      int var3 = arg1.g1();
      if (var3 != 0) {
         --arg1.pos;
         this.e = new SoundEnvelope();
         this.e.a(this.a, arg1);
         this.f = new SoundEnvelope();
         this.f.a(this.a, arg1);
      }

      int var4 = arg1.g1();
      if (arg0 != 6) {
         for(int var5 = 1; var5 > 0; ++var5) {
         }
      }

      if (var4 != 0) {
         --arg1.pos;
         this.g = new SoundEnvelope();
         this.g.a(this.a, arg1);
         this.h = new SoundEnvelope();
         this.h.a(this.a, arg1);
      }

      int var6 = arg1.g1();
      if (var6 != 0) {
         --arg1.pos;
         this.i = new SoundEnvelope();
         this.i.a(this.a, arg1);
         this.j = new SoundEnvelope();
         this.j.a(this.a, arg1);
      }

      for(int var7 = 0; var7 < 10; ++var7) {
         int var8 = arg1.gsmarts();
         if (var8 == 0) {
            break;
         }

         this.k[var7] = var8;
         this.l[var7] = arg1.gsmart();
         this.m[var7] = arg1.gsmarts();
      }

      this.n = arg1.gsmarts();
      this.o = arg1.gsmarts();
      this.r = arg1.e();
      this.s = arg1.e();
      this.p = new SoundFilter();
      this.q = new SoundEnvelope();
      this.p.a(-954, this.q, arg1);
   }
}
