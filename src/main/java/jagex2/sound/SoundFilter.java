package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.datastruct.Linkable;
import jagex2.io.Packet;

public class SoundFilter {
   @ObfuscatedName("SGFGLWZQ.b")
   public boolean b = true;
   @ObfuscatedName("SGFGLWZQ.c")
   public int[] c = new int[2];
   @ObfuscatedName("SGFGLWZQ.d")
   public int[][][] d = new int[2][2][4];
   @ObfuscatedName("SGFGLWZQ.e")
   public int[][][] e = new int[2][2][4];
   @ObfuscatedName("SGFGLWZQ.f")
   public int[] f = new int[2];
   @ObfuscatedName("SGFGLWZQ.g")
   public static float[][] g = new float[2][8];
   @ObfuscatedName("SGFGLWZQ.h")
   public static int[][] h = new int[2][8];
   @ObfuscatedName("SGFGLWZQ.i")
   public static float i;
   @ObfuscatedName("SGFGLWZQ.a")
   public int a;
   @ObfuscatedName("SGFGLWZQ.j")
   public static int j;

   @ObfuscatedName("SGFGLWZQ.a(IIFI)F")
   public float a(int arg0, int arg1, float arg2, int arg3) {
      float var5 = (float)(this.e[arg0][1][arg3] - this.e[arg0][0][arg3]) * arg2 + (float)this.e[arg0][0][arg3];
      float var6 = var5 * 0.0015258789F;
      int var7 = 34 / arg1;
      return 1.0F - (float)Math.pow(10.0D, (double)(-var6 / 20.0F));
   }

   @ObfuscatedName("SGFGLWZQ.a(FI)F")
   public float a(float arg0, int arg1) {
      float var3 = 32.703197F * (float)Math.pow(2.0D, (double)arg0);
      if (arg1 >= 0) {
         this.b = !this.b;
      }

      return var3 * 3.1415927F / 11025.0F;
   }

   @ObfuscatedName("SGFGLWZQ.a(IIIF)F")
   public float a(int arg0, int arg1, int arg2, float arg3) {
      if (arg1 != 0) {
         this.a = -370;
      }

      float var5 = (float)(this.d[arg2][1][arg0] - this.d[arg2][0][arg0]) * arg3 + (float)this.d[arg2][0][arg0];
      float var6 = var5 * 1.2207031E-4F;
      return this.a(var6, -335);
   }

   @ObfuscatedName("SGFGLWZQ.a(IZF)I")
   public int a(int arg0, boolean arg1, float arg2) {
      if (!arg1) {
         for(int var4 = 1; var4 > 0; ++var4) {
         }
      }

      if (arg0 == 0) {
         float var5 = (float)(this.f[1] - this.f[0]) * arg2 + (float)this.f[0];
         float var6 = var5 * 0.0030517578F;
         i = (float)Math.pow(0.1D, (double)(var6 / 20.0F));
         j = (int)(i * 65536.0F);
      }

      if (this.c[arg0] == 0) {
         return 0;
      } else {
         float var7 = this.a(arg0, 849, arg2, 0);
         g[arg0][0] = var7 * -2.0F * (float)Math.cos((double)this.a(0, 0, arg0, arg2));
         g[arg0][1] = var7 * var7;

         for(int var8 = 1; var8 < this.c[arg0]; ++var8) {
            float var9 = this.a(arg0, 849, arg2, var8);
            float var10 = var9 * -2.0F * (float)Math.cos((double)this.a(var8, 0, arg0, arg2));
            float var11 = var9 * var9;
            g[arg0][var8 * 2 + 1] = g[arg0][var8 * 2 - 1] * var11;
            g[arg0][var8 * 2] = g[arg0][var8 * 2 - 1] * var10 + g[arg0][var8 * 2 - 2] * var11;

            for(int var12 = var8 * 2 - 1; var12 >= 2; --var12) {
               g[arg0][var12] += g[arg0][var12 - 1] * var10 + g[arg0][var12 - 2] * var11;
            }

            g[arg0][1] += g[arg0][0] * var10 + var11;
            g[arg0][0] += var10;
         }

         if (arg0 == 0) {
            for(int var13 = 0; var13 < this.c[0] * 2; ++var13) {
               g[0][var13] *= i;
            }
         }

         for(int var14 = 0; var14 < this.c[arg0] * 2; ++var14) {
            h[arg0][var14] = (int)(g[arg0][var14] * 65536.0F);
         }

         return this.c[arg0] * 2;
      }
   }

   @ObfuscatedName("SGFGLWZQ.a(ILPFANSVWX;LMFMVIYHT;)V")
   public final void a(int arg0, SoundEnvelope arg1, Packet arg2) {
      int var4 = arg2.g1();
      this.c[0] = var4 >> 4;

      while(arg0 >= 0) {
         for(int var5 = 1; var5 > 0; ++var5) {
         }
      }

      this.c[1] = var4 & 15;
      if (var4 == 0) {
         this.f[0] = this.f[1] = 0;
         if (Linkable.d) {
         }

      } else {
         this.f[0] = arg2.e();
         this.f[1] = arg2.e();
         int var6 = arg2.g1();

         for(int var7 = 0; var7 < 2; ++var7) {
            for(int var8 = 0; var8 < this.c[var7]; ++var8) {
               this.d[var7][0][var8] = arg2.e();
               this.e[var7][0][var8] = arg2.e();
            }
         }

         for(int var9 = 0; var9 < 2; ++var9) {
            for(int var10 = 0; var10 < this.c[var9]; ++var10) {
               if ((var6 & 1 << var9 * 4 << var10) != 0) {
                  this.d[var9][1][var10] = arg2.e();
                  this.e[var9][1][var10] = arg2.e();
               } else {
                  this.d[var9][1][var10] = this.d[var9][0][var10];
                  this.e[var9][1][var10] = this.e[var9][0][var10];
               }
            }
         }

         if (var6 != 0 || this.f[1] != this.f[0]) {
            arg1.a(arg2, 0);
         }

      }
   }
}
