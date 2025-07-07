package jagex2.config;

import jagex2.io.Jagfile;
import deob.ObfuscatedName;
import jagex2.io.Packet;

public class FloType {
   @ObfuscatedName("FZFOSJCE.c")
   public boolean c = true;
   @ObfuscatedName("FZFOSJCE.h")
   public int h = -1;
   @ObfuscatedName("FZFOSJCE.i")
   public boolean i = false;
   @ObfuscatedName("FZFOSJCE.j")
   public boolean j = true;
   @ObfuscatedName("FZFOSJCE.a")
   public static byte a = 6;
   @ObfuscatedName("FZFOSJCE.b")
   public int b;
   @ObfuscatedName("FZFOSJCE.d")
   public static int d;
   @ObfuscatedName("FZFOSJCE.g")
   public int g;
   @ObfuscatedName("FZFOSJCE.k")
   public int k;
   @ObfuscatedName("FZFOSJCE.l")
   public int l;
   @ObfuscatedName("FZFOSJCE.m")
   public int m;
   @ObfuscatedName("FZFOSJCE.n")
   public int n;
   @ObfuscatedName("FZFOSJCE.o")
   public int o;
   @ObfuscatedName("FZFOSJCE.p")
   public int p;
   @ObfuscatedName("FZFOSJCE.f")
   public String f;
   @ObfuscatedName("FZFOSJCE.e")
   public static FloType[] e;

   @ObfuscatedName("FZFOSJCE.a(LATJMVOZR;I)V")
   public static void a(Jagfile arg0, int arg1) {
      if (arg1 == 36135) {
         Packet var2 = new Packet(arg0.read("flo.dat", (byte[])null));
         d = var2.g2();
         if (e == null) {
            e = new FloType[d];
         }

         for(int var3 = 0; var3 < d; ++var3) {
            if (e[var3] == null) {
               e[var3] = new FloType();
            }

            e[var3].a(a, var2);
         }

      }
   }

   @ObfuscatedName("FZFOSJCE.a(BLMFMVIYHT;)V")
   public void a(byte arg0, Packet arg1) {
      if (arg0 == 6) {
         boolean var3 = false;
      } else {
         for(int var4 = 1; var4 > 0; ++var4) {
         }
      }

      while(true) {
         int var5 = arg1.g1();
         if (var5 == 0) {
            return;
         }

         if (var5 == 1) {
            this.g = arg1.g3();
            this.a(true, this.g);
         } else if (var5 == 2) {
            this.h = arg1.g1();
         } else if (var5 == 3) {
            this.i = true;
         } else if (var5 == 5) {
            this.j = false;
         } else if (var5 == 6) {
            this.f = arg1.gjstr();
         } else if (var5 == 7) {
            int var6 = this.k;
            int var7 = this.l;
            int var8 = this.m;
            int var9 = this.n;
            int var10 = arg1.g3();
            this.a(true, var10);
            this.k = var6;
            this.l = var7;
            this.m = var8;
            this.n = var9;
            this.o = var9;
         } else {
            System.out.println("Error unrecognised config code: " + var5);
         }
      }
   }

   @ObfuscatedName("FZFOSJCE.a(ZI)V")
   public void a(boolean arg0, int arg1) {
      if (arg1 == 16711935) {
         arg1 = 0;
      }

      double var3 = (double)(arg1 >> 16 & 255) / 256.0D;
      double var5 = (double)(arg1 >> 8 & 255) / 256.0D;
      double var7 = (double)(arg1 & 255) / 256.0D;
      double var9 = var3;
      if (var5 < var3) {
         var9 = var5;
      }

      if (var7 < var9) {
         var9 = var7;
      }

      double var11 = var3;
      if (var5 > var3) {
         var11 = var5;
      }

      if (var7 > var11) {
         var11 = var7;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      double var17 = (var9 + var11) / 2.0D;
      if (var9 != var11) {
         if (var17 < 0.5D) {
            var15 = (var11 - var9) / (var9 + var11);
         }

         if (var17 >= 0.5D) {
            var15 = (var11 - var9) / (2.0D - var11 - var9);
         }

         if (var3 == var11) {
            var13 = (var5 - var7) / (var11 - var9);
         } else if (var5 == var11) {
            var13 = (var7 - var3) / (var11 - var9) + 2.0D;
         } else if (var7 == var11) {
            var13 = (var3 - var5) / (var11 - var9) + 4.0D;
         }
      }

      double var19 = var13 / 6.0D;
      this.k = (int)(var19 * 256.0D);
      this.l = (int)(var15 * 256.0D);
      this.m = (int)(var17 * 256.0D);
      if (!arg0) {
         this.b = -244;
      }

      if (this.l < 0) {
         this.l = 0;
      } else if (this.l > 255) {
         this.l = 255;
      }

      if (this.m < 0) {
         this.m = 0;
      } else if (this.m > 255) {
         this.m = 255;
      }

      if (var17 > 0.5D) {
         this.o = (int)((1.0D - var17) * var15 * 512.0D);
      } else {
         this.o = (int)(var15 * var17 * 512.0D);
      }

      if (this.o < 1) {
         this.o = 1;
      }

      this.n = (int)((double)this.o * var19);
      int var21 = this.k + (int)(Math.random() * 16.0D) - 8;
      if (var21 < 0) {
         var21 = 0;
      } else if (var21 > 255) {
         var21 = 255;
      }

      int var22 = this.l + (int)(Math.random() * 48.0D) - 24;
      if (var22 < 0) {
         var22 = 0;
      } else if (var22 > 255) {
         var22 = 255;
      }

      int var23 = this.m + (int)(Math.random() * 48.0D) - 24;
      if (var23 < 0) {
         var23 = 0;
      } else if (var23 > 255) {
         var23 = 255;
      }

      this.p = this.a(var21, var22, var23);
   }

   @ObfuscatedName("FZFOSJCE.a(III)I")
   public final int a(int arg0, int arg1, int arg2) {
      if (arg2 > 179) {
         arg1 /= 2;
      }

      if (arg2 > 192) {
         arg1 /= 2;
      }

      if (arg2 > 217) {
         arg1 /= 2;
      }

      if (arg2 > 243) {
         arg1 /= 2;
      }

      return arg2 / 2 + (arg0 / 4 << 10) + (arg1 / 32 << 7);
   }
}
