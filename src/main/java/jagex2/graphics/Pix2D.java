package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;

public class Pix2D extends DoublyLinkable {
   @ObfuscatedName("LFYNQWSZ.j")
   public static boolean j = true;
   @ObfuscatedName("LFYNQWSZ.k")
   public static int k = -291;
   @ObfuscatedName("LFYNQWSZ.h")
   public static int h;
   @ObfuscatedName("LFYNQWSZ.m")
   public static int m;
   @ObfuscatedName("LFYNQWSZ.n")
   public static int n;
   @ObfuscatedName("LFYNQWSZ.o")
   public static int o;
   @ObfuscatedName("LFYNQWSZ.p")
   public static int p;
   @ObfuscatedName("LFYNQWSZ.q")
   public static int q;
   @ObfuscatedName("LFYNQWSZ.r")
   public static int r;
   @ObfuscatedName("LFYNQWSZ.s")
   public static int s;
   @ObfuscatedName("LFYNQWSZ.t")
   public static int t;
   @ObfuscatedName("LFYNQWSZ.u")
   public static int u;
   @ObfuscatedName("LFYNQWSZ.i")
   public static boolean i;
   @ObfuscatedName("LFYNQWSZ.v")
   public static boolean v;
   @ObfuscatedName("LFYNQWSZ.l")
   public static int[] l;

   @ObfuscatedName("LFYNQWSZ.a(ZII[I)V")
   public static void a(boolean arg0, int arg1, int arg2, int[] arg3) {
      if (!arg0) {
         k = -394;
      }

      l = arg3;
      m = arg1;
      n = arg2;
      a(0, 0, arg2, arg1, true);
   }

   @ObfuscatedName("LFYNQWSZ.a(B)V")
   public static void a(byte arg0) {
      q = 0;
      o = 0;
      r = m;
      p = n;
      s = r - 1;
      if (arg0 != 82) {
         k = -258;
      }

      t = r / 2;
   }

   @ObfuscatedName("LFYNQWSZ.a(IIIIZ)V")
   public static void a(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
      if (arg1 < 0) {
         arg1 = 0;
      }

      if (arg0 < 0) {
         arg0 = 0;
      }

      if (arg3 > m) {
         arg3 = m;
      }

      if (arg2 > n) {
         arg2 = n;
      }

      q = arg1;
      o = arg0;
      r = arg3;
      p = arg2;
      if (arg4) {
         s = r - 1;
         t = r / 2;
         u = p / 2;
      }
   }

   @ObfuscatedName("LFYNQWSZ.a(I)V")
   public static void a(int arg0) {
      int var1 = n * m;
      if (arg0 != 4) {
         i = !i;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         l[var2] = 0;
      }

   }

   @ObfuscatedName("LFYNQWSZ.a(ZIIIIII)V")
   public static void a(boolean arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
      if (arg6 < q) {
         arg3 -= q - arg6;
         arg6 = q;
      }

      if (arg2 < o) {
         arg4 -= o - arg2;
         arg2 = o;
      }

      if (arg3 + arg6 > r) {
         arg3 = r - arg6;
      }

      if (arg2 + arg4 > p) {
         arg4 = p - arg2;
      }

      int var7 = 256 - arg5;
      int var8 = (arg1 >> 16 & 255) * arg5;
      int var9 = (arg1 >> 8 & 255) * arg5;
      int var10 = (arg1 & 255) * arg5;
      if (arg0) {
         i = !i;
      }

      int var11 = m - arg3;
      int var12 = m * arg2 + arg6;

      for(int var13 = 0; var13 < arg4; ++var13) {
         for(int var14 = -arg3; var14 < 0; ++var14) {
            int var15 = (l[var12] >> 16 & 255) * var7;
            int var16 = (l[var12] >> 8 & 255) * var7;
            int var17 = (l[var12] & 255) * var7;
            int var18 = (var10 + var17 >> 8) + (var8 + var15 >> 8 << 16) + (var9 + var16 >> 8 << 8);
            l[var12++] = var18;
         }

         var12 += var11;
      }

   }

   @ObfuscatedName("LFYNQWSZ.a(IIIBII)V")
   public static void a(int arg0, int arg1, int arg2, byte arg3, int arg4, int arg5) {
      if (arg5 < q) {
         arg4 -= q - arg5;
         arg5 = q;
      }

      if (arg1 < o) {
         arg0 -= o - arg1;
         arg1 = o;
      }

      if (arg4 + arg5 > r) {
         arg4 = r - arg5;
      }

      if (arg0 + arg1 > p) {
         arg0 = p - arg1;
      }

      int var6 = m - arg4;
      int var7 = m * arg1 + arg5;

      for(int var8 = -arg0; var8 < 0; ++var8) {
         for(int var9 = -arg4; var9 < 0; ++var9) {
            l[var7++] = arg2;
         }

         var7 += var6;
      }

      if (arg3 == -24) {
         ;
      }
   }

   @ObfuscatedName("LFYNQWSZ.a(IIIIII)V")
   public static void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
      b(arg4, arg3, arg1, arg5, true);
      b(arg4, arg3, arg1 + arg2 - 1, arg5, true);
      if (arg0 != 0) {
         h = -278;
      }

      a(arg4, arg3, arg2, false, arg1);
      a(arg4 + arg5 - 1, arg3, arg2, false, arg1);
   }

   @ObfuscatedName("LFYNQWSZ.a(IIIIIIB)V")
   public static void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, byte arg6) {
      if (arg6 == -113) {
         b(arg4, arg0, arg1, 1388, arg5, arg2);
         b(arg3 + arg4 - 1, arg0, arg1, 1388, arg5, arg2);
         if (arg3 >= 3) {
            c(0, arg4 + 1, arg0, arg2, arg3 - 2, arg5);
            c(0, arg4 + 1, arg0 + arg1 - 1, arg2, arg3 - 2, arg5);
         }
      }
   }

   @ObfuscatedName("LFYNQWSZ.b(IIIIZ)V")
   public static void b(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
      if (arg2 >= o && arg2 < p) {
         if (arg0 < q) {
            arg3 -= q - arg0;
            arg0 = q;
         }

         if (arg0 + arg3 > r) {
            arg3 = r - arg0;
         }

         int var5 = m * arg2 + arg0;
         if (!arg4) {
            for(int var6 = 1; var6 > 0; ++var6) {
            }
         }

         for(int var7 = 0; var7 < arg3; ++var7) {
            l[var5 + var7] = arg1;
         }

      }
   }

   @ObfuscatedName("LFYNQWSZ.b(IIIIII)V")
   public static void b(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
      if (arg0 >= o && arg0 < p) {
         if (arg1 < q) {
            arg2 -= q - arg1;
            arg1 = q;
         }

         if (arg1 + arg2 > r) {
            arg2 = r - arg1;
         }

         int var6 = 256 - arg4;
         int var7 = (arg5 >> 16 & 255) * arg4;
         int var8 = (arg5 >> 8 & 255) * arg4;
         int var9 = (arg5 & 255) * arg4;
         int var10 = m * arg0 + arg1;

         for(int var11 = 0; var11 < arg2; ++var11) {
            int var12 = (l[var10] >> 16 & 255) * var6;
            int var13 = (l[var10] >> 8 & 255) * var6;
            int var14 = (l[var10] & 255) * var6;
            int var15 = (var9 + var14 >> 8) + (var7 + var12 >> 8 << 16) + (var8 + var13 >> 8 << 8);
            l[var10++] = var15;
         }

         if (arg3 != 1388) {
            h = -36;
         }
      }
   }

   @ObfuscatedName("LFYNQWSZ.a(IIIZI)V")
   public static void a(int arg0, int arg1, int arg2, boolean arg3, int arg4) {
      if (!arg3) {
         if (arg0 >= q && arg0 < r) {
            if (arg4 < o) {
               arg2 -= o - arg4;
               arg4 = o;
            }

            if (arg2 + arg4 > p) {
               arg2 = p - arg4;
            }

            int var5 = m * arg4 + arg0;

            for(int var6 = 0; var6 < arg2; ++var6) {
               l[m * var6 + var5] = arg1;
            }

         }
      }
   }

   @ObfuscatedName("LFYNQWSZ.c(IIIIII)V")
   public static void c(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
      if (arg2 >= q && arg2 < r) {
         if (arg1 < o) {
            arg4 -= o - arg1;
            arg1 = o;
         }

         if (arg1 + arg4 > p) {
            arg4 = p - arg1;
         }

         int var6 = 256 - arg5;
         int var7 = (arg3 >> 16 & 255) * arg5;
         int var8 = (arg3 >> 8 & 255) * arg5;
         int var9 = (arg3 & 255) * arg5;
         if (arg0 != 0) {
            for(int var10 = 1; var10 > 0; ++var10) {
            }
         }

         int var11 = m * arg1 + arg2;

         for(int var12 = 0; var12 < arg4; ++var12) {
            int var13 = (l[var11] >> 16 & 255) * var6;
            int var14 = (l[var11] >> 8 & 255) * var6;
            int var15 = (l[var11] & 255) * var6;
            int var16 = (var9 + var15 >> 8) + (var7 + var13 >> 8 << 16) + (var8 + var14 >> 8 << 8);
            l[var11] = var16;
            var11 += m;
         }

      }
   }
}
