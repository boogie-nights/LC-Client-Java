package jagex2.wordenc;

import deob.ObfuscatedName;
import jagex2.io.Packet;

public class WordPack {
   @ObfuscatedName("QKAIVGGT.a")
   public static int a = 20411;
   @ObfuscatedName("QKAIVGGT.b")
   public static char[] b = new char[100];
   @ObfuscatedName("QKAIVGGT.c")
   public static Packet c = new Packet(new byte[100]);
   @ObfuscatedName("QKAIVGGT.d")
   public static char[] d = new char[]{' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u', 'm', 'w', 'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=', '£', '$', '%', '"', '[', ']'};

   @ObfuscatedName("QKAIVGGT.a(ILMFMVIYHT;I)Ljava/lang/String;")
   public static String a(int arg0, Packet arg1, int arg2) {
      int var3 = 0;
      int var4 = -1;

      for(int var5 = 0; var5 < arg2; ++var5) {
         int var6 = arg1.g1();
         int var7 = var6 >> 4 & 15;
         if (var4 == -1) {
            if (var7 < 13) {
               b[var3++] = d[var7];
            } else {
               var4 = var7;
            }
         } else {
            b[var3++] = d[(var4 << 4) + var7 - 195];
            var4 = -1;
         }

         int var8 = var6 & 15;
         if (var4 == -1) {
            if (var8 < 13) {
               b[var3++] = d[var8];
            } else {
               var4 = var8;
            }
         } else {
            b[var3++] = d[(var4 << 4) + var8 - 195];
            var4 = -1;
         }
      }

      boolean var9 = true;

      for(int var10 = 0; var10 < var3; ++var10) {
         char var11 = b[var10];
         if (var9 && var11 >= 'a' && var11 <= 'z') {
            b[var10] = (char)(b[var10] + -32);
            var9 = false;
         }

         if (var11 == '.' || var11 == '!' || var11 == '?') {
            var9 = true;
         }
      }

      if (arg0 != 0) {
         a = -409;
      }

      return new String(b, 0, var3);
   }

   @ObfuscatedName("QKAIVGGT.a(Ljava/lang/String;ILMFMVIYHT;)V")
   public static void a(String arg0, int arg1, Packet arg2) {
      if (arg0.length() > 80) {
         arg0 = arg0.substring(0, 80);
      }

      String var3 = arg0.toLowerCase();
      if (arg1 <= 0) {
         for(int var4 = 1; var4 > 0; ++var4) {
         }
      }

      int var5 = -1;

      for(int var6 = 0; var6 < var3.length(); ++var6) {
         char var7 = var3.charAt(var6);
         int var8 = 0;

         for(int var9 = 0; var9 < d.length; ++var9) {
            if (d[var9] == var7) {
               var8 = var9;
               break;
            }
         }

         if (var8 > 12) {
            var8 += 195;
         }

         if (var5 == -1) {
            if (var8 < 13) {
               var5 = var8;
            } else {
               arg2.p1(var8);
            }
         } else if (var8 < 13) {
            arg2.p1((var5 << 4) + var8);
            var5 = -1;
         } else {
            arg2.p1((var5 << 4) + (var8 >> 4));
            var5 = var8 & 15;
         }
      }

      if (var5 != -1) {
         arg2.p1(var5 << 4);
      }
   }

   @ObfuscatedName("QKAIVGGT.a(BLjava/lang/String;)Ljava/lang/String;")
   public static String a(byte arg0, String arg1) {
      c.pos = 0;
      a(arg1, 569, c);
      int var2 = c.pos;
      if (arg0 != 0) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

      c.pos = 0;
      return a(0, c, var2);
   }
}
