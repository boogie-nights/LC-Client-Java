package jagex2.graphics;

import jagex2.io.Jagfile;
import deob.ObfuscatedName;
import jagex2.io.Packet;

import java.util.Random;

public class PixFont extends Pix2D {
   @ObfuscatedName("JDPYRDAS.w")
   public boolean w = true;
   @ObfuscatedName("JDPYRDAS.x")
   public boolean x = true;
   @ObfuscatedName("JDPYRDAS.y")
   public int y = 3;
   @ObfuscatedName("JDPYRDAS.z")
   public int z = 3;
   @ObfuscatedName("JDPYRDAS.A")
   public byte[][] A = new byte[256][];
   @ObfuscatedName("JDPYRDAS.B")
   public int[] B = new int[256];
   @ObfuscatedName("JDPYRDAS.C")
   public int[] C = new int[256];
   @ObfuscatedName("JDPYRDAS.D")
   public int[] D = new int[256];
   @ObfuscatedName("JDPYRDAS.E")
   public int[] E = new int[256];
   @ObfuscatedName("JDPYRDAS.F")
   public int[] F = new int[256];
   @ObfuscatedName("JDPYRDAS.H")
   public Random H = new Random();
   @ObfuscatedName("JDPYRDAS.I")
   public boolean I = false;
   @ObfuscatedName("JDPYRDAS.G")
   public int G;

   public PixFont(boolean arg0, Jagfile arg1, int arg2, String arg3) {
      Packet var5 = new Packet(arg1.read(arg3 + ".dat", (byte[])null));
      Packet var6 = new Packet(arg1.read("index.dat", (byte[])null));
      boolean var7 = true;
      var6.pos = var5.g2() + 4;

      while(arg2 >= 0) {
         this.w = !this.w;
      }

      int var8 = var6.g1();
      if (var8 > 0) {
         var6.pos += (var8 - 1) * 3;
      }

      for(int var9 = 0; var9 < 256; ++var9) {
         this.D[var9] = var6.g1();
         this.E[var9] = var6.g1();
         int var11 = this.B[var9] = var6.g2();
         int var12 = this.C[var9] = var6.g2();
         int var13 = var6.g1();
         int var14 = var11 * var12;
         this.A[var9] = new byte[var14];
         if (var13 == 0) {
            for(int var15 = 0; var15 < var14; ++var15) {
               this.A[var9][var15] = var5.g1b();
            }
         } else if (var13 == 1) {
            for(int var16 = 0; var16 < var11; ++var16) {
               for(int var17 = 0; var17 < var12; ++var17) {
                  this.A[var9][var11 * var17 + var16] = var5.g1b();
               }
            }
         }

         if (var12 > this.G && var9 < 128) {
            this.G = var12;
         }

         this.D[var9] = 1;
         this.F[var9] = var11 + 2;
         int var18 = 0;

         for(int var19 = var12 / 7; var19 < var12; ++var19) {
            var18 += this.A[var9][var11 * var19];
         }

         int var10002;
         if (var18 <= var12 / 7) {
            var10002 = this.F[var9]--;
            this.D[var9] = 0;
         }

         int var20 = 0;

         for(int var21 = var12 / 7; var21 < var12; ++var21) {
            var20 += this.A[var9][var11 * var21 + (var11 - 1)];
         }

         if (var20 <= var12 / 7) {
            var10002 = this.F[var9]--;
         }
      }

      if (arg0) {
         this.F[32] = this.F[73];
      } else {
         this.F[32] = this.F[105];
      }
   }

   @ObfuscatedName("JDPYRDAS.a(ZLjava/lang/String;III)V")
   public void a(boolean arg0, String arg1, int arg2, int arg3, int arg4) {
      this.b(2245, arg3 - this.a(arg1, (byte)-53), arg2, arg4, arg1);
      if (arg0) {
         ;
      }
   }

   @ObfuscatedName("JDPYRDAS.a(IIIILjava/lang/String;)V")
   public void a(int arg0, int arg1, int arg2, int arg3, String arg4) {
      this.b(2245, arg0 - this.a(arg4, (byte)-53) / 2, arg3, arg2, arg4);
      int var6 = 21 / arg1;
   }

   @ObfuscatedName("JDPYRDAS.a(ZIIIILjava/lang/String;)V")
   public void a(boolean arg0, int arg1, int arg2, int arg3, int arg4, String arg5) {
      if (arg1 >= this.y && arg1 <= this.y) {
         this.a(arg2, arg4 - this.a((byte)35, arg5) / 2, arg3, arg0, arg5, -39629);
      }
   }

   @ObfuscatedName("JDPYRDAS.a(BLjava/lang/String;)I")
   public int a(byte arg0, String arg1) {
      if (arg1 == null) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < arg1.length(); ++var4) {
            if (arg1.charAt(var4) == '@' && var4 + 4 < arg1.length() && arg1.charAt(var4 + 4) == '@') {
               var4 += 4;
            } else {
               var3 += this.F[arg1.charAt(var4)];
            }
         }

         if (arg0 != 35) {
            for(int var5 = 1; var5 > 0; ++var5) {
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("JDPYRDAS.a(Ljava/lang/String;B)I")
   public int a(String arg0, byte arg1) {
      if (arg0 == null) {
         return 0;
      } else {
         int var3 = 0;
         if (arg1 != -53) {
            for(int var4 = 1; var4 > 0; ++var4) {
            }
         }

         for(int var5 = 0; var5 < arg0.length(); ++var5) {
            var3 += this.F[arg0.charAt(var5)];
         }

         return var3;
      }
   }

   @ObfuscatedName("JDPYRDAS.b(IIIILjava/lang/String;)V")
   public void b(int arg0, int arg1, int arg2, int arg3, String arg4) {
      if (arg0 != 2245) {
         for(int var6 = 1; var6 > 0; ++var6) {
         }
      }

      if (arg4 != null) {
         int var7 = arg3 - this.G;

         for(int var8 = 0; var8 < arg4.length(); ++var8) {
            char var9 = arg4.charAt(var8);
            if (var9 != ' ') {
               this.a(this.A[var9], this.D[var9] + arg1, this.E[var9] + var7, this.B[var9], this.C[var9], arg2);
            }

            arg1 += this.F[var9];
         }

      }
   }

   @ObfuscatedName("JDPYRDAS.a(IBILjava/lang/String;II)V")
   public void a(int arg0, byte arg1, int arg2, String arg3, int arg4, int arg5) {
      if (arg3 != null) {
         int var7 = arg4 - this.a(arg3, (byte)-53) / 2;
         if (arg1 == 4) {
            boolean var8 = false;
         } else {
            this.x = !this.x;
         }

         int var9 = arg0 - this.G;

         for(int var10 = 0; var10 < arg3.length(); ++var10) {
            char var11 = arg3.charAt(var10);
            if (var11 != ' ') {
               this.a(this.A[var11], this.D[var11] + var7, this.E[var11] + var9 + (int)(Math.sin((double)arg2 / 5.0D + (double)var10 / 2.0D) * 5.0D), this.B[var11], this.C[var11], arg5);
            }

            var7 += this.F[var11];
         }

      }
   }

   @ObfuscatedName("JDPYRDAS.a(IIBLjava/lang/String;II)V")
   public void a(int arg0, int arg1, byte arg2, String arg3, int arg4, int arg5) {
      if (arg3 != null) {
         int var7 = arg4 - this.a(arg3, (byte)-53) / 2;
         if (arg2 != 1) {
            for(int var8 = 1; var8 > 0; ++var8) {
            }
         }

         int var9 = arg0 - this.G;

         for(int var10 = 0; var10 < arg3.length(); ++var10) {
            char var11 = arg3.charAt(var10);
            if (var11 != ' ') {
               this.a(this.A[var11], this.D[var11] + var7 + (int)(Math.sin((double)arg5 / 5.0D + (double)var10 / 5.0D) * 5.0D), this.E[var11] + var9 + (int)(Math.sin((double)arg5 / 5.0D + (double)var10 / 3.0D) * 5.0D), this.B[var11], this.C[var11], arg1);
            }

            var7 += this.F[var11];
         }

      }
   }

   @ObfuscatedName("JDPYRDAS.a(ILjava/lang/String;IIIII)V")
   public void a(int arg0, String arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
      if (arg1 != null) {
         double var8 = 7.0D - (double)arg5 / 8.0D;

         while(arg0 >= 0) {
            for(int var10 = 1; var10 > 0; ++var10) {
            }
         }

         if (var8 < 0.0D) {
            var8 = 0.0D;
         }

         int var11 = arg3 - this.a(arg1, (byte)-53) / 2;
         int var12 = arg4 - this.G;

         for(int var13 = 0; var13 < arg1.length(); ++var13) {
            char var14 = arg1.charAt(var13);
            if (var14 != ' ') {
               this.a(this.A[var14], this.D[var14] + var11, this.E[var14] + var12 + (int)(Math.sin((double)var13 / 1.5D + (double)arg6) * var8), this.B[var14], this.C[var14], arg2);
            }

            var11 += this.F[var14];
         }

      }
   }

   @ObfuscatedName("JDPYRDAS.a(IIIZLjava/lang/String;I)V")
   public void a(int arg0, int arg1, int arg2, boolean arg3, String arg4, int arg5) {
      this.I = false;
      if (arg5 == -39629) {
         int var7 = arg1;
         if (arg4 != null) {
            int var8 = arg2 - this.G;

            for(int var9 = 0; var9 < arg4.length(); ++var9) {
               if (arg4.charAt(var9) == '@' && var9 + 4 < arg4.length() && arg4.charAt(var9 + 4) == '@') {
                  int var10 = this.a(this.z, arg4.substring(var9 + 1, var9 + 4));
                  if (var10 != -1) {
                     arg0 = var10;
                  }

                  var9 += 4;
               } else {
                  char var11 = arg4.charAt(var9);
                  if (var11 != ' ') {
                     if (arg3) {
                        this.a(this.A[var11], this.D[var11] + arg1 + 1, this.E[var11] + var8 + 1, this.B[var11], this.C[var11], 0);
                     }

                     this.a(this.A[var11], this.D[var11] + arg1, this.E[var11] + var8, this.B[var11], this.C[var11], arg0);
                  }

                  arg1 += this.F[var11];
               }
            }

            if (this.I) {
               Pix2D.b(var7, 8388608, (int)((double)this.G * 0.7D) + var8, arg1 - var7, true);
            }
         }
      }
   }

   @ObfuscatedName("JDPYRDAS.a(ZIIIILjava/lang/String;I)V")
   public void a(boolean arg0, int arg1, int arg2, int arg3, int arg4, String arg5, int arg6) {
      if (arg5 != null) {
         this.H.setSeed((long)arg1);
         int var8 = 192 + (this.H.nextInt() & 31);
         int var9 = arg4 - this.G;
         if (arg6 != 0) {
            this.z = 489;
         }

         for(int var10 = 0; var10 < arg5.length(); ++var10) {
            if (arg5.charAt(var10) == '@' && var10 + 4 < arg5.length() && arg5.charAt(var10 + 4) == '@') {
               int var11 = this.a(this.z, arg5.substring(var10 + 1, var10 + 4));
               if (var11 != -1) {
                  arg3 = var11;
               }

               var10 += 4;
            } else {
               char var12 = arg5.charAt(var10);
               if (var12 != ' ') {
                  if (arg0) {
                     this.a(this.D[var12] + arg2 + 1, true, 0, this.A[var12], this.E[var12] + var9 + 1, this.C[var12], this.B[var12], 192);
                  }

                  this.a(this.D[var12] + arg2, true, arg3, this.A[var12], this.E[var12] + var9, this.C[var12], this.B[var12], var8);
               }

               arg2 += this.F[var12];
               if ((this.H.nextInt() & 3) == 0) {
                  ++arg2;
               }
            }
         }

      }
   }

   @ObfuscatedName("JDPYRDAS.a(ILjava/lang/String;)I")
   public int a(int arg0, String arg1) {
      if (this.z != arg0) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

      if (arg1.equals("red")) {
         return 16711680;
      } else if (arg1.equals("gre")) {
         return 65280;
      } else if (arg1.equals("blu")) {
         return 255;
      } else if (arg1.equals("yel")) {
         return 16776960;
      } else if (arg1.equals("cya")) {
         return 65535;
      } else if (arg1.equals("mag")) {
         return 16711935;
      } else if (arg1.equals("whi")) {
         return 16777215;
      } else if (arg1.equals("bla")) {
         return 0;
      } else if (arg1.equals("lre")) {
         return 16748608;
      } else if (arg1.equals("dre")) {
         return 8388608;
      } else if (arg1.equals("dbl")) {
         return 128;
      } else if (arg1.equals("or1")) {
         return 16756736;
      } else if (arg1.equals("or2")) {
         return 16740352;
      } else if (arg1.equals("or3")) {
         return 16723968;
      } else if (arg1.equals("gr1")) {
         return 12648192;
      } else if (arg1.equals("gr2")) {
         return 8453888;
      } else if (arg1.equals("gr3")) {
         return 4259584;
      } else {
         if (arg1.equals("str")) {
            this.I = true;
         }

         if (arg1.equals("end")) {
            this.I = false;
         }

         return -1;
      }
   }

   @ObfuscatedName("JDPYRDAS.a([BIIIII)V")
   public void a(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
      int var7 = Pix2D.m * arg2 + arg1;
      int var8 = Pix2D.m - arg3;
      int var9 = 0;
      int var10 = 0;
      if (arg2 < Pix2D.o) {
         int var11 = Pix2D.o - arg2;
         arg4 -= var11;
         arg2 = Pix2D.o;
         var10 += arg3 * var11;
         var7 += Pix2D.m * var11;
      }

      if (arg2 + arg4 >= Pix2D.p) {
         arg4 -= arg2 + arg4 - Pix2D.p + 1;
      }

      if (arg1 < Pix2D.q) {
         int var12 = Pix2D.q - arg1;
         arg3 -= var12;
         arg1 = Pix2D.q;
         var10 += var12;
         var7 += var12;
         var9 += var12;
         var8 += var12;
      }

      if (arg1 + arg3 >= Pix2D.r) {
         int var13 = arg1 + arg3 - Pix2D.r + 1;
         arg3 -= var13;
         var9 += var13;
         var8 += var13;
      }

      if (arg3 > 0 && arg4 > 0) {
         this.a(Pix2D.l, arg0, arg5, var10, var7, arg3, arg4, var8, var9);
      }
   }

   @ObfuscatedName("JDPYRDAS.a([I[BIIIIIII)V")
   public void a(int[] arg0, byte[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
      int var10 = -(arg5 >> 2);
      int var11 = -(arg5 & 3);

      for(int var12 = -arg6; var12 < 0; ++var12) {
         for(int var13 = var10; var13 < 0; ++var13) {
            if (arg1[arg3++] != 0) {
               arg0[arg4++] = arg2;
            } else {
               ++arg4;
            }

            if (arg1[arg3++] != 0) {
               arg0[arg4++] = arg2;
            } else {
               ++arg4;
            }

            if (arg1[arg3++] != 0) {
               arg0[arg4++] = arg2;
            } else {
               ++arg4;
            }

            if (arg1[arg3++] != 0) {
               arg0[arg4++] = arg2;
            } else {
               ++arg4;
            }
         }

         for(int var14 = var11; var14 < 0; ++var14) {
            if (arg1[arg3++] != 0) {
               arg0[arg4++] = arg2;
            } else {
               ++arg4;
            }
         }

         arg4 += arg7;
         arg3 += arg8;
      }

   }

   @ObfuscatedName("JDPYRDAS.a(IZI[BIIII)V")
   public void a(int arg0, boolean arg1, int arg2, byte[] arg3, int arg4, int arg5, int arg6, int arg7) {
      int var9 = Pix2D.m * arg4 + arg0;
      int var10 = Pix2D.m - arg6;
      int var11 = 0;
      int var12 = 0;
      if (arg1) {
         if (arg4 < Pix2D.o) {
            int var13 = Pix2D.o - arg4;
            arg5 -= var13;
            arg4 = Pix2D.o;
            var12 += arg6 * var13;
            var9 += Pix2D.m * var13;
         }

         if (arg4 + arg5 >= Pix2D.p) {
            arg5 -= arg4 + arg5 - Pix2D.p + 1;
         }

         if (arg0 < Pix2D.q) {
            int var14 = Pix2D.q - arg0;
            arg6 -= var14;
            arg0 = Pix2D.q;
            var12 += var14;
            var9 += var14;
            var11 += var14;
            var10 += var14;
         }

         if (arg0 + arg6 >= Pix2D.r) {
            int var15 = arg0 + arg6 - Pix2D.r + 1;
            arg6 -= var15;
            var11 += var15;
            var10 += var15;
         }

         if (arg6 > 0 && arg5 > 0) {
            this.a(var12, var10, var11, var9, arg7, Pix2D.l, arg2, 2, arg5, arg6, arg3);
         }
      }
   }

   @ObfuscatedName("JDPYRDAS.a(IIIII[IIIII[B)V")
   public void a(int arg0, int arg1, int arg2, int arg3, int arg4, int[] arg5, int arg6, int arg7, int arg8, int arg9, byte[] arg10) {
      if (arg7 < 2 || arg7 > 2) {
         this.w = !this.w;
      }

      int var12 = ((arg6 & 16711935) * arg4 & -16711936) + ((arg6 & 65280) * arg4 & 16711680) >> 8;
      int var13 = 256 - arg4;

      for(int var14 = -arg8; var14 < 0; ++var14) {
         for(int var15 = -arg9; var15 < 0; ++var15) {
            if (arg10[arg0++] != 0) {
               int var16 = arg5[arg3];
               arg5[arg3++] = (((var16 & 16711935) * var13 & -16711936) + ((var16 & 65280) * var13 & 16711680) >> 8) + var12;
            } else {
               ++arg3;
            }
         }

         arg3 += arg1;
         arg0 += arg2;
      }

   }
}
