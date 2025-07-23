package jagex2.graphics;

import jagex2.io.Jagfile;
import deob.ObfuscatedName;
import jagex2.io.Packet;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;

public class Pix24 extends Pix2D {
   @ObfuscatedName("EPQDEJTO.w")
   public int w = -235;
   @ObfuscatedName("EPQDEJTO.x")
   public boolean x = true;
   @ObfuscatedName("EPQDEJTO.y")
   public byte y = 5;
   @ObfuscatedName("EPQDEJTO.z")
   public int z = -3539;
   @ObfuscatedName("EPQDEJTO.A")
   public int A = -766;
   @ObfuscatedName("EPQDEJTO.B")
   public int B = -766;
   @ObfuscatedName("EPQDEJTO.C")
   public int C = 1;
   @ObfuscatedName("EPQDEJTO.D")
   public boolean D = true;
   @ObfuscatedName("EPQDEJTO.E")
   public boolean E = false;
   @ObfuscatedName("EPQDEJTO.F")
   public boolean F = false;
   @ObfuscatedName("EPQDEJTO.G")
   public boolean G = true;
   @ObfuscatedName("EPQDEJTO.H")
   public int H = 3600;
   @ObfuscatedName("EPQDEJTO.I")
   public int[] I;
   @ObfuscatedName("EPQDEJTO.N")
   public int N;
   @ObfuscatedName("EPQDEJTO.J")
   public int J;
   @ObfuscatedName("EPQDEJTO.O")
   public int O;
   @ObfuscatedName("EPQDEJTO.K")
   public int K;
   @ObfuscatedName("EPQDEJTO.M")
   public int M;
   @ObfuscatedName("EPQDEJTO.L")
   public int L;

   public Pix24(int arg0, int arg1) {
      this.I = new int[arg0 * arg1];
      this.J = this.N = arg0;
      this.K = this.O = arg1;
      this.L = this.M = 0;
   }

   public Pix24(byte[] arg0, java.awt.Component arg1) {
      try {
         Image var3 = Toolkit.getDefaultToolkit().createImage(arg0);
         MediaTracker var4 = new MediaTracker(arg1);
         var4.addImage(var3, 0);
         var4.waitForAll();
         this.J = var3.getWidth(arg1);
         this.K = var3.getHeight(arg1);
         this.N = this.J;
         this.O = this.K;
         this.L = 0;
         this.M = 0;
         this.I = new int[this.K * this.J];
         PixelGrabber var5 = new PixelGrabber(var3, 0, 0, this.J, this.K, this.I, 0, this.J);
         var5.grabPixels();
      } catch (Exception var6) {
         System.out.println("Error converting jpg");
      }
   }

   public Pix24(Jagfile arg0, String arg1, int arg2) {
      Packet var4 = new Packet(arg0.read(arg1 + ".dat", (byte[])null));
      Packet var5 = new Packet(arg0.read("index.dat", (byte[])null));
      var5.pos = var4.g2();
      this.N = var5.g2();
      this.O = var5.g2();
      int var6 = var5.g1();
      int[] var7 = new int[var6];

      for(int var8 = 0; var8 < var6 - 1; ++var8) {
         var7[var8 + 1] = var5.g3();
         if (var7[var8 + 1] == 0) {
            var7[var8 + 1] = 1;
         }
      }

      for(int var9 = 0; var9 < arg2; ++var9) {
         var5.pos += 2;
         var4.pos += var5.g2() * var5.g2();
         ++var5.pos;
      }

      this.L = var5.g1();
      this.M = var5.g1();
      this.J = var5.g2();
      this.K = var5.g2();
      int var10 = var5.g1();
      int var11 = this.K * this.J;
      this.I = new int[var11];
      if (var10 == 0) {
         for(int var12 = 0; var12 < var11; ++var12) {
            this.I[var12] = var7[var4.g1()];
         }

      } else {
         if (var10 == 1) {
            for(int var13 = 0; var13 < this.J; ++var13) {
               for(int var14 = 0; var14 < this.K; ++var14) {
                  this.I[this.J * var14 + var13] = var7[var4.g1()];
               }
            }
         }

      }
   }

   @ObfuscatedName("EPQDEJTO.a(Z)V")
   public void a(boolean arg0) {
      if (!arg0) {
         Pix2D.bind(this.J, this.I, this.K);
      }
   }

   @ObfuscatedName("EPQDEJTO.a(IIII)V")
   public void tranlsate(int arg0, int arg1, int arg2, int arg3) {
      for(int var5 = 0; var5 < this.I.length; ++var5) {
         int var6 = this.I[var5];
         if (var6 != 0) {
            int var7 = var6 >> 16 & 255;
            int var8 = arg2 + var7;
            if (var8 < 1) {
               var8 = 1;
            } else if (var8 > 255) {
               var8 = 255;
            }

            int var9 = var6 >> 8 & 255;
            int var10 = arg1 + var9;
            if (var10 < 1) {
               var10 = 1;
            } else if (var10 > 255) {
               var10 = 255;
            }

            int var11 = var6 & 255;
            int var12 = arg0 + var11;
            if (var12 < 1) {
               var12 = 1;
            } else if (var12 > 255) {
               var12 = 255;
            }

            this.I[var5] = (var8 << 16) + (var10 << 8) + var12;
         }
      }

      if (this.w != arg3) {
         this.G = !this.G;
      }
   }

   @ObfuscatedName("EPQDEJTO.b(I)V")
   public void b(int arg0) {
      int[] var2 = new int[this.O * this.N];

      for(int var3 = 0; var3 < this.K; ++var3) {
         for(int var4 = 0; var4 < this.J; ++var4) {
            var2[(this.M + var3) * this.N + this.L + var4] = this.I[this.J * var3 + var4];
         }
      }

      this.I = var2;
      this.J = this.N;
      this.K = this.O;
      this.L = 0;
      this.M = 0;
      if (arg0 == 1790) {
         ;
      }
   }

   @ObfuscatedName("EPQDEJTO.a(III)V")
   public void blitOpaque(int arg0, int arg2) {
      int var4 = this.L + arg2;
      int var5 = this.M + arg0;
      int var6 = Pix2D.width2d * var5 + var4;
      int var7 = 0;
      int var8 = this.K;
      int var9 = this.J;
      int var10 = Pix2D.width2d - var9;
      int var11 = 0;
      if (var5 < Pix2D.top) {
         int var12 = Pix2D.top - var5;
         var8 -= var12;
         var5 = Pix2D.top;
         var7 += var9 * var12;
         var6 += Pix2D.width2d * var12;
      }

      if (var5 + var8 > Pix2D.bottom) {
         var8 -= var5 + var8 - Pix2D.bottom;
      }

      if (var4 < Pix2D.left) {
         int var13 = Pix2D.left - var4;
         var9 -= var13;
         var4 = Pix2D.left;
         var7 += var13;
         var6 += var13;
         var11 += var13;
         var10 += var13;
      }

      if (var4 + var9 > Pix2D.right) {
         int var14 = var4 + var9 - Pix2D.right;
         var9 -= var14;
         var11 += var14;
         var10 += var14;
      }

      if (var9 > 0 && var8 > 0) {
         this.a(var9, var10, var8, this.I, var7, var11, var6, (byte)-39, Pix2D.data);
      }
   }

   @ObfuscatedName("EPQDEJTO.a(III[IIIIB[I)V")
   public void a(int arg0, int arg1, int arg2, int[] arg3, int arg4, int arg5, int arg6, byte arg7, int[] arg8) {
      int var10 = -(arg0 >> 2);
      if (arg7 != -39) {
         this.H = 201;
      }

      int var11 = -(arg0 & 3);

      for(int var12 = -arg2; var12 < 0; ++var12) {
         for(int var13 = var10; var13 < 0; ++var13) {
            arg8[arg6++] = arg3[arg4++];
            arg8[arg6++] = arg3[arg4++];
            arg8[arg6++] = arg3[arg4++];
            arg8[arg6++] = arg3[arg4++];
         }

         for(int var14 = var11; var14 < 0; ++var14) {
            arg8[arg6++] = arg3[arg4++];
         }

         arg6 += arg1;
         arg4 += arg5;
      }

   }

   @ObfuscatedName("EPQDEJTO.b(III)V")
   public void b(int arg0, int arg1, int arg2) {
      int var4 = this.L + arg1;
      if (arg2 < 0) {
         int var5 = this.M + arg0;
         int var6 = Pix2D.width2d * var5 + var4;
         int var7 = 0;
         int var8 = this.K;
         int var9 = this.J;
         int var10 = Pix2D.width2d - var9;
         int var11 = 0;
         if (var5 < Pix2D.top) {
            int var12 = Pix2D.top - var5;
            var8 -= var12;
            var5 = Pix2D.top;
            var7 += var9 * var12;
            var6 += Pix2D.width2d * var12;
         }

         if (var5 + var8 > Pix2D.bottom) {
            var8 -= var5 + var8 - Pix2D.bottom;
         }

         if (var4 < Pix2D.left) {
            int var13 = Pix2D.left - var4;
            var9 -= var13;
            var4 = Pix2D.left;
            var7 += var13;
            var6 += var13;
            var11 += var13;
            var10 += var13;
         }

         if (var4 + var9 > Pix2D.right) {
            int var14 = var4 + var9 - Pix2D.right;
            var9 -= var14;
            var11 += var14;
            var10 += var14;
         }

         if (var9 > 0 && var8 > 0) {
            this.a(Pix2D.data, this.I, 0, var7, var6, var9, var8, var10, var11);
         }
      }
   }

   @ObfuscatedName("EPQDEJTO.a([I[IIIIIIII)V")
   public void a(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
      int var10 = -(arg5 >> 2);
      int var11 = -(arg5 & 3);

      for(int var12 = -arg6; var12 < 0; ++var12) {
         for(int var13 = var10; var13 < 0; ++var13) {
            int var14 = arg1[arg3++];
            if (var14 != 0) {
               arg0[arg4++] = var14;
            } else {
               ++arg4;
            }

            int var15 = arg1[arg3++];
            if (var15 != 0) {
               arg0[arg4++] = var15;
            } else {
               ++arg4;
            }

            int var16 = arg1[arg3++];
            if (var16 != 0) {
               arg0[arg4++] = var16;
            } else {
               ++arg4;
            }

            int var17 = arg1[arg3++];
            if (var17 != 0) {
               arg0[arg4++] = var17;
            } else {
               ++arg4;
            }
         }

         for(int var18 = var11; var18 < 0; ++var18) {
            int var19 = arg1[arg3++];
            if (var19 != 0) {
               arg0[arg4++] = var19;
            } else {
               ++arg4;
            }
         }

         arg4 += arg7;
         arg3 += arg8;
      }

   }

   @ObfuscatedName("EPQDEJTO.b(IIII)V")
   public void b(int arg0, int arg1, int arg2, int arg3) {
      int var5 = this.L + arg1;
      int var6 = this.M + arg2;
      int var7 = Pix2D.width2d * var6 + var5;
      int var8 = 0;
      if (arg0 == 0) {
         int var9 = this.K;
         int var10 = this.J;
         int var11 = Pix2D.width2d - var10;
         int var12 = 0;
         if (var6 < Pix2D.top) {
            int var13 = Pix2D.top - var6;
            var9 -= var13;
            var6 = Pix2D.top;
            var8 += var10 * var13;
            var7 += Pix2D.width2d * var13;
         }

         if (var6 + var9 > Pix2D.bottom) {
            var9 -= var6 + var9 - Pix2D.bottom;
         }

         if (var5 < Pix2D.left) {
            int var14 = Pix2D.left - var5;
            var10 -= var14;
            var5 = Pix2D.left;
            var8 += var14;
            var7 += var14;
            var12 += var14;
            var11 += var14;
         }

         if (var5 + var10 > Pix2D.right) {
            int var15 = var5 + var10 - Pix2D.right;
            var10 -= var15;
            var12 += var15;
            var11 += var15;
         }

         if (var10 > 0 && var9 > 0) {
            this.a(var10, var12, 0, var11, var8, this.A, arg3, var7, var9, Pix2D.data, this.I);
         }
      }
   }

   @ObfuscatedName("EPQDEJTO.a(IIIIIIIII[I[I)V")
   public void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int[] arg9, int[] arg10) {
      int var12 = 256 - arg6;

      for(int var13 = -arg8; var13 < 0; ++var13) {
         for(int var14 = -arg0; var14 < 0; ++var14) {
            int var15 = arg10[arg4++];
            if (var15 != 0) {
               int var16 = arg9[arg7];
               arg9[arg7++] = ((var15 & 16711935) * arg6 + (var16 & 16711935) * var12 & -16711936) + ((var15 & 65280) * arg6 + (var16 & 65280) * var12 & 16711680) >> 8;
            } else {
               ++arg7;
            }
         }

         arg7 += arg3;
         arg4 += arg1;
      }

      if (arg5 >= 0) {
         this.x = !this.x;
      }
   }

   @ObfuscatedName("EPQDEJTO.a(IIIII[IIII[II)V")
   public void a(int arg0, int arg1, int arg2, int arg3, int arg4, int[] arg5, int arg6, int arg7, int arg8, int[] arg9, int arg10) {
      int var12 = 36 / arg1;

      try {
         int var13 = -arg4 / 2;
         int var14 = -arg2 / 2;
         int var15 = (int)(Math.sin((double)arg7 / 326.11D) * 65536.0D);
         int var16 = (int)(Math.cos((double)arg7 / 326.11D) * 65536.0D);
         int var17 = arg8 * var15 >> 8;
         int var18 = arg8 * var16 >> 8;
         int var19 = (arg3 << 16) + var13 * var18 + var14 * var17;
         int var20 = (arg10 << 16) + (var14 * var18 - var13 * var17);
         int var21 = Pix2D.width2d * arg0 + arg6;

         for(int var22 = 0; var22 < arg2; ++var22) {
            int var23 = arg9[var22];
            int var24 = var21 + var23;
            int var25 = var18 * var23 + var19;
            int var26 = var20 - var17 * var23;

            for(int var27 = -arg5[var22]; var27 < 0; ++var27) {
               Pix2D.data[var24++] = this.I[(var25 >> 16) + (var26 >> 16) * this.J];
               var25 += var18;
               var26 -= var17;
            }

            var19 += var17;
            var20 += var18;
            var21 += Pix2D.width2d;
         }

      } catch (Exception var28) {
      }
   }

   @ObfuscatedName("EPQDEJTO.a(IIIIIIIDI)V")
   public void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, double arg7, int arg8) {
      if (arg5 == -30658) {
         try {
            int var11 = -arg6 / 2;
            int var12 = -arg4 / 2;
            int var13 = (int)(Math.sin(arg7) * 65536.0D);
            int var14 = (int)(Math.cos(arg7) * 65536.0D);
            int var15 = arg0 * var13 >> 8;
            int var16 = arg0 * var14 >> 8;
            int var17 = (arg1 << 16) + var11 * var16 + var12 * var15;
            int var18 = (arg3 << 16) + (var12 * var16 - var11 * var15);
            int var19 = Pix2D.width2d * arg8 + arg2;

            for(int var20 = 0; var20 < arg4; ++var20) {
               int var21 = var19;
               int var22 = var17;
               int var23 = var18;

               for(int var24 = -arg6; var24 < 0; ++var24) {
                  int var25 = this.I[(var22 >> 16) + (var23 >> 16) * this.J];
                  if (var25 != 0) {
                     Pix2D.data[var21++] = var25;
                  } else {
                     ++var21;
                  }

                  var22 += var16;
                  var23 -= var15;
               }

               var17 += var15;
               var18 += var16;
               var19 += Pix2D.width2d;
            }

         } catch (Exception var26) {
         }
      }
   }

   @ObfuscatedName("EPQDEJTO.a(LWRRBQEHV;III)V")
   public void a(Pix8 arg0, int arg1, int arg2, int arg3) {
      if (arg2 == -49993) {
         int var5 = this.L + arg3;
         int var6 = this.M + arg1;
         int var7 = Pix2D.width2d * var6 + var5;
         int var8 = 0;
         int var9 = this.K;
         int var10 = this.J;
         int var11 = Pix2D.width2d - var10;
         int var12 = 0;
         if (var6 < Pix2D.top) {
            int var13 = Pix2D.top - var6;
            var9 -= var13;
            var6 = Pix2D.top;
            var8 += var10 * var13;
            var7 += Pix2D.width2d * var13;
         }

         if (var6 + var9 > Pix2D.bottom) {
            var9 -= var6 + var9 - Pix2D.bottom;
         }

         if (var5 < Pix2D.left) {
            int var14 = Pix2D.left - var5;
            var10 -= var14;
            var5 = Pix2D.left;
            var8 += var14;
            var7 += var14;
            var12 += var14;
            var11 += var14;
         }

         if (var5 + var10 > Pix2D.right) {
            int var15 = var5 + var10 - Pix2D.right;
            var10 -= var15;
            var12 += var15;
            var11 += var15;
         }

         if (var10 > 0 && var9 > 0) {
            this.a(var7, var11, this.I, var10, Pix2D.data, arg0.pixels, 40303, var9, var8, 0, var12);
         }
      }
   }

   @ObfuscatedName("EPQDEJTO.a(II[II[I[BIIIII)V")
   public void a(int arg0, int arg1, int[] arg2, int arg3, int[] arg4, byte[] arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
      int var12 = -(arg3 >> 2);
      if (arg6 != 40303) {
         this.F = !this.F;
      }

      int var13 = -(arg3 & 3);

      for(int var14 = -arg7; var14 < 0; ++var14) {
         for(int var15 = var12; var15 < 0; ++var15) {
            int var16 = arg2[arg8++];
            if (var16 != 0 && arg5[arg0] == 0) {
               arg4[arg0++] = var16;
            } else {
               ++arg0;
            }

            int var17 = arg2[arg8++];
            if (var17 != 0 && arg5[arg0] == 0) {
               arg4[arg0++] = var17;
            } else {
               ++arg0;
            }

            int var18 = arg2[arg8++];
            if (var18 != 0 && arg5[arg0] == 0) {
               arg4[arg0++] = var18;
            } else {
               ++arg0;
            }

            int var19 = arg2[arg8++];
            if (var19 != 0 && arg5[arg0] == 0) {
               arg4[arg0++] = var19;
            } else {
               ++arg0;
            }
         }

         for(int var20 = var13; var20 < 0; ++var20) {
            int var21 = arg2[arg8++];
            if (var21 != 0 && arg5[arg0] == 0) {
               arg4[arg0++] = var21;
            } else {
               ++arg0;
            }
         }

         arg0 += arg1;
         arg8 += arg10;
      }

   }
}
