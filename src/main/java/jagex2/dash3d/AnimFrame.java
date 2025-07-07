package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.io.Packet;

public class AnimFrame {
   @ObfuscatedName("JULFQTYK.a")
   public static int a = 217;
   @ObfuscatedName("JULFQTYK.d")
   public int d;
   @ObfuscatedName("JULFQTYK.f")
   public int f;
   @ObfuscatedName("JULFQTYK.e")
   public AnimBase e;
   @ObfuscatedName("JULFQTYK.b")
   public static boolean b;
   @ObfuscatedName("JULFQTYK.g")
   public int[] g;
   @ObfuscatedName("JULFQTYK.h")
   public int[] h;
   @ObfuscatedName("JULFQTYK.i")
   public int[] i;
   @ObfuscatedName("JULFQTYK.j")
   public int[] j;
   @ObfuscatedName("JULFQTYK.c")
   public static AnimFrame[] c;
   @ObfuscatedName("JULFQTYK.k")
   public static boolean[] k;

   @ObfuscatedName("JULFQTYK.a(I)V")
   public static void a(int arg0) {
      c = new AnimFrame[arg0 + 1];
      k = new boolean[arg0 + 1];

      for(int var1 = 0; var1 < arg0 + 1; ++var1) {
         k[var1] = true;
      }

   }

   @ObfuscatedName("JULFQTYK.a([BZ)V")
   public static void a(byte[] arg0, boolean arg1) {
      Packet var2 = new Packet(arg0);
      var2.pos = arg0.length - 8;
      int var3 = var2.e();
      int var4 = var2.e();
      int var5 = var2.e();
      if (arg1) {
         int var6 = var2.e();
         byte var7 = 0;
         Packet var8 = new Packet(arg0);
         var8.pos = var7;
         int var9 = var3 + 2 + var7;
         Packet var10 = new Packet(arg0);
         var10.pos = var9;
         int var11 = var4 + var9;
         Packet var12 = new Packet(arg0);
         var12.pos = var11;
         int var13 = var5 + var11;
         Packet var14 = new Packet(arg0);
         var14.pos = var13;
         int var15 = var6 + var13;
         Packet var16 = new Packet(arg0);
         var16.pos = var15;
         AnimBase var17 = new AnimBase(var16, 0);
         int var18 = var8.e();
         int[] var19 = new int[500];
         int[] var20 = new int[500];
         int[] var21 = new int[500];
         int[] var22 = new int[500];

         for(int var23 = 0; var23 < var18; ++var23) {
            int var24 = var8.e();
            AnimFrame var25 = c[var24] = new AnimFrame();
            var25.d = var14.g1();
            var25.e = var17;
            int var26 = var8.g1();
            int var27 = -1;
            int var28 = 0;

            for(int var29 = 0; var29 < var26; ++var29) {
               int var30 = var10.g1();
               if (var30 > 0) {
                  if (var17.b[var29] != 0) {
                     for(int var31 = var29 - 1; var31 > var27; --var31) {
                        if (var17.b[var31] == 0) {
                           var19[var28] = var31;
                           var20[var28] = 0;
                           var21[var28] = 0;
                           var22[var28] = 0;
                           ++var28;
                           break;
                        }
                     }
                  }

                  var19[var28] = var29;
                  short var32 = 0;
                  if (var17.b[var29] == 3) {
                     var32 = 128;
                  }

                  if ((var30 & 1) != 0) {
                     var20[var28] = var12.gsmart();
                  } else {
                     var20[var28] = var32;
                  }

                  if ((var30 & 2) != 0) {
                     var21[var28] = var12.gsmart();
                  } else {
                     var21[var28] = var32;
                  }

                  if ((var30 & 4) != 0) {
                     var22[var28] = var12.gsmart();
                  } else {
                     var22[var28] = var32;
                  }

                  var27 = var29;
                  ++var28;
                  if (var17.b[var29] == 5) {
                     k[var24] = false;
                  }
               }
            }

            var25.f = var28;
            var25.g = new int[var28];
            var25.h = new int[var28];
            var25.i = new int[var28];
            var25.j = new int[var28];

            for(int var33 = 0; var33 < var28; ++var33) {
               var25.g[var33] = var19[var33];
               var25.h[var33] = var20[var33];
               var25.i[var33] = var21[var33];
               var25.j[var33] = var22[var33];
            }
         }

      }
   }

   @ObfuscatedName("JULFQTYK.a(Z)V")
   public static void a(boolean arg0) {
      if (arg0) {
         a = 189;
      }

      c = null;
   }

   @ObfuscatedName("JULFQTYK.b(I)LJULFQTYK;")
   public static AnimFrame b(int arg0) {
      return c == null ? null : c[arg0];
   }

   @ObfuscatedName("JULFQTYK.a(ZI)Z")
   public static boolean a(boolean arg0, int arg1) {
      if (!arg0) {
         b = !b;
      }

      return arg1 == -1;
   }
}
