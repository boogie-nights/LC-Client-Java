package jagex2.dash3d;

import deob.ObfuscatedName;

public class WorldRegion {
   @ObfuscatedName("RKBCLNKC.b")
   public static boolean b = true;
   @ObfuscatedName("RKBCLNKC.c")
   public static boolean c = true;
   @ObfuscatedName("RKBCLNKC.a")
   public static int a;

   @ObfuscatedName("RKBCLNKC.a(BIII)I")
   public static int a(byte arg0, int arg1, int arg2, int arg3) {
      if (arg0 == 7) {
         boolean var4 = false;
      } else {
         a = 486;
      }

      int var5 = arg1 & 3;
      if (var5 == 0) {
         return arg2;
      } else if (var5 == 1) {
         return arg3;
      } else {
         return var5 == 2 ? 7 - arg2 : 7 - arg3;
      }
   }

   @ObfuscatedName("RKBCLNKC.a(IIIB)I")
   public static int a(int arg0, int arg1, int arg2, byte arg3) {
      if (arg3 == 5) {
         boolean var4 = false;
      }

      int var5 = arg2 & 3;
      if (var5 == 0) {
         return arg0;
      } else if (var5 == 1) {
         return 7 - arg1;
      } else {
         return var5 == 2 ? 7 - arg0 : arg1;
      }
   }

   @ObfuscatedName("RKBCLNKC.a(IIIIBII)I")
   public static int a(int arg0, int arg1, int arg2, int arg3, byte arg4, int arg5, int arg6) {
      if (arg4 != -117) {
         c = !c;
      }

      if ((arg2 & 1) == 1) {
         int var7 = arg5;
         arg5 = arg1;
         arg1 = var7;
      }

      int var8 = arg0 & 3;
      if (var8 == 0) {
         return arg3;
      } else if (var8 == 1) {
         return arg6;
      } else {
         return var8 == 2 ? 7 - arg3 - (arg5 - 1) : 7 - arg6 - (arg1 - 1);
      }
   }

   @ObfuscatedName("RKBCLNKC.a(IIIIIII)I")
   public static int a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
      if (arg2 <= 0) {
         a = -50;
      }

      if ((arg6 & 1) == 1) {
         int var7 = arg0;
         arg0 = arg5;
         arg5 = var7;
      }

      int var8 = arg1 & 3;
      if (var8 == 0) {
         return arg4;
      } else if (var8 == 1) {
         return 7 - arg3 - (arg0 - 1);
      } else {
         return var8 == 2 ? 7 - arg4 - (arg5 - 1) : arg3;
      }
   }
}
