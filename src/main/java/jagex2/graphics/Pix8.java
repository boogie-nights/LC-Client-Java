package jagex2.graphics;

import jagex2.io.Jagfile;
import deob.ObfuscatedName;
import jagex2.io.Packet;

public class Pix8 extends Pix2D {
   @ObfuscatedName("WRRBQEHV.w")
   public int w = 3;
   @ObfuscatedName("WRRBQEHV.x")
   public boolean x = true;
   @ObfuscatedName("WRRBQEHV.z")
   public int z = -235;
   @ObfuscatedName("WRRBQEHV.A")
   public byte A = 5;
   @ObfuscatedName("WRRBQEHV.B")
   public int B = -3539;
   @ObfuscatedName("WRRBQEHV.C")
   public boolean C = true;
   @ObfuscatedName("WRRBQEHV.J")
   public int J;
   @ObfuscatedName("WRRBQEHV.K")
   public int K;
   @ObfuscatedName("WRRBQEHV.E")
   public int[] E;
   @ObfuscatedName("WRRBQEHV.H")
   public int H;
   @ObfuscatedName("WRRBQEHV.I")
   public int I;
   @ObfuscatedName("WRRBQEHV.F")
   public int F;
   @ObfuscatedName("WRRBQEHV.G")
   public int G;
   @ObfuscatedName("WRRBQEHV.D")
   public byte[] D;
   @ObfuscatedName("WRRBQEHV.y")
   public int y;

   public Pix8(Jagfile arg0, String arg1, int arg2) {
      Packet var4 = new Packet(arg0.a(arg1 + ".dat", (byte[])null));
      Packet var5 = new Packet(arg0.a("index.dat", (byte[])null));
      var5.pos = var4.g2();
      this.J = var5.g2();
      this.K = var5.g2();
      int var6 = var5.g1();
      this.E = new int[var6];

      for(int var7 = 0; var7 < var6 - 1; ++var7) {
         this.E[var7 + 1] = var5.g3();
      }

      for(int var8 = 0; var8 < arg2; ++var8) {
         var5.pos += 2;
         var4.pos += var5.g2() * var5.g2();
         ++var5.pos;
      }

      this.H = var5.g1();
      this.I = var5.g1();
      this.F = var5.g2();
      this.G = var5.g2();
      int var9 = var5.g1();
      int var10 = this.G * this.F;
      this.D = new byte[var10];
      if (var9 == 0) {
         for(int var11 = 0; var11 < var10; ++var11) {
            this.D[var11] = var4.g1b();
         }

      } else {
         if (var9 == 1) {
            for(int var12 = 0; var12 < this.F; ++var12) {
               for(int var13 = 0; var13 < this.G; ++var13) {
                  this.D[this.F * var13 + var12] = var4.g1b();
               }
            }
         }

         if (d) {
         }

      }
   }

   @ObfuscatedName("WRRBQEHV.b(I)V")
   public void b(int arg0) {
      this.J /= 2;
      this.K /= 2;
      byte[] var2 = new byte[this.K * this.J];
      int var3 = 0;
      if (arg0 == 0) {
         for(int var4 = 0; var4 < this.G; ++var4) {
            for(int var5 = 0; var5 < this.F; ++var5) {
               var2[(this.H + var5 >> 1) + (this.I + var4 >> 1) * this.J] = this.D[var3++];
            }
         }

         this.D = var2;
         this.F = this.J;
         this.G = this.K;
         this.H = 0;
         this.I = 0;
      }
   }

   @ObfuscatedName("WRRBQEHV.a(Z)V")
   public void a(boolean arg0) {
      if (this.J != this.F || this.K != this.G) {
         byte[] var2 = new byte[this.K * this.J];
         int var3 = 0;

         for(int var4 = 0; var4 < this.G; ++var4) {
            for(int var5 = 0; var5 < this.F; ++var5) {
               var2[(this.I + var4) * this.J + this.H + var5] = this.D[var3++];
            }
         }

         this.D = var2;
         this.F = this.J;
         if (arg0) {
            this.G = this.K;
            this.H = 0;
            this.I = 0;
         }
      }
   }

   @ObfuscatedName("WRRBQEHV.c(I)V")
   public void c(int arg0) {
      byte[] var2 = new byte[this.G * this.F];
      int var3 = 0;

      for(int var4 = 0; var4 < this.G; ++var4) {
         for(int var5 = this.F - 1; var5 >= 0; --var5) {
            var2[var3++] = this.D[this.F * var4 + var5];
         }
      }

      this.D = var2;
      if (arg0 == 0) {
         this.H = this.J - this.F - this.H;
      }
   }

   @ObfuscatedName("WRRBQEHV.b(B)V")
   public void b(byte arg0) {
      byte[] var2 = new byte[this.G * this.F];
      int var3 = 0;
      if (arg0 != 7) {
         this.C = !this.C;
      }

      for(int var4 = this.G - 1; var4 >= 0; --var4) {
         for(int var5 = 0; var5 < this.F; ++var5) {
            var2[var3++] = this.D[this.F * var4 + var5];
         }
      }

      this.D = var2;
      this.I = this.K - this.G - this.I;
   }

   @ObfuscatedName("WRRBQEHV.a(IIII)V")
   public void a(int arg0, int arg1, int arg2, int arg3) {
      for(int var5 = 0; var5 < this.E.length; ++var5) {
         int var6 = this.E[var5] >> 16 & 255;
         int var7 = arg2 + var6;
         if (var7 < 0) {
            var7 = 0;
         } else if (var7 > 255) {
            var7 = 255;
         }

         int var8 = this.E[var5] >> 8 & 255;
         int var9 = arg1 + var8;
         if (var9 < 0) {
            var9 = 0;
         } else if (var9 > 255) {
            var9 = 255;
         }

         int var10 = this.E[var5] & 255;
         int var11 = arg0 + var10;
         if (var11 < 0) {
            var11 = 0;
         } else if (var11 > 255) {
            var11 = 255;
         }

         this.E[var5] = (var7 << 16) + (var9 << 8) + var11;
      }

      if (this.z == arg3) {
         ;
      }
   }

   @ObfuscatedName("WRRBQEHV.a(III)V")
   public void a(int arg0, int arg1, int arg2) {
      int var4 = this.H + arg1;
      int var5 = this.I + arg0;

      while(arg2 >= 0) {
         for(int var6 = 1; var6 > 0; ++var6) {
         }
      }

      int var7 = Pix2D.m * var5 + var4;
      int var8 = 0;
      int var9 = this.G;
      int var10 = this.F;
      int var11 = Pix2D.m - var10;
      int var12 = 0;
      if (var5 < Pix2D.o) {
         int var13 = Pix2D.o - var5;
         var9 -= var13;
         var5 = Pix2D.o;
         var8 += var10 * var13;
         var7 += Pix2D.m * var13;
      }

      if (var5 + var9 > Pix2D.p) {
         var9 -= var5 + var9 - Pix2D.p;
      }

      if (var4 < Pix2D.q) {
         int var14 = Pix2D.q - var4;
         var10 -= var14;
         var4 = Pix2D.q;
         var8 += var14;
         var7 += var14;
         var12 += var14;
         var11 += var14;
      }

      if (var4 + var10 > Pix2D.r) {
         int var15 = var4 + var10 - Pix2D.r;
         var10 -= var15;
         var12 += var15;
         var11 += var15;
      }

      if (var10 > 0 && var9 > 0) {
         this.a(var8, Pix2D.l, this.D, var12, this.E, var9, var10, var7, false, var11);
      }
   }

   @ObfuscatedName("WRRBQEHV.a(I[I[BI[IIIIZI)V")
   public void a(int arg0, int[] arg1, byte[] arg2, int arg3, int[] arg4, int arg5, int arg6, int arg7, boolean arg8, int arg9) {
      int var11 = -(arg6 >> 2);
      int var12 = -(arg6 & 3);
      if (arg8) {
         this.y = 264;
      }

      for(int var13 = -arg5; var13 < 0; ++var13) {
         for(int var14 = var11; var14 < 0; ++var14) {
            byte var15 = arg2[arg0++];
            if (var15 != 0) {
               arg1[arg7++] = arg4[var15 & 255];
            } else {
               ++arg7;
            }

            byte var16 = arg2[arg0++];
            if (var16 != 0) {
               arg1[arg7++] = arg4[var16 & 255];
            } else {
               ++arg7;
            }

            byte var17 = arg2[arg0++];
            if (var17 != 0) {
               arg1[arg7++] = arg4[var17 & 255];
            } else {
               ++arg7;
            }

            byte var18 = arg2[arg0++];
            if (var18 != 0) {
               arg1[arg7++] = arg4[var18 & 255];
            } else {
               ++arg7;
            }
         }

         for(int var19 = var12; var19 < 0; ++var19) {
            byte var20 = arg2[arg0++];
            if (var20 != 0) {
               arg1[arg7++] = arg4[var20 & 255];
            } else {
               ++arg7;
            }
         }

         arg7 += arg9;
         arg0 += arg3;
      }

   }
}
