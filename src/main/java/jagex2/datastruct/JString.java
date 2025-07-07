package jagex2.datastruct;

import deob.ObfuscatedName;

public class JString {
   @ObfuscatedName("LJWIWXSK.a")
   public static int a = 236;
   @ObfuscatedName("LJWIWXSK.b")
   public static int b = -20714;
   @ObfuscatedName("LJWIWXSK.c")
   public static int c = 3;
   @ObfuscatedName("LJWIWXSK.d")
   public static int d = -68;
   @ObfuscatedName("LJWIWXSK.e")
   public static final char[] e = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

   @ObfuscatedName("LJWIWXSK.a(Ljava/lang/String;)J")
   public static long a(String arg0) {
      long var1 = 0L;

      for(int var3 = 0; var3 < arg0.length() && var3 < 12; ++var3) {
         char var4 = arg0.charAt(var3);
         var1 *= 37L;
         if (var4 >= 'A' && var4 <= 'Z') {
            var1 += (long)(var4 + 1 - 65);
         } else if (var4 >= 'a' && var4 <= 'z') {
            var1 += (long)(var4 + 1 - 97);
         } else if (var4 >= '0' && var4 <= '9') {
            var1 += (long)(var4 + 27 - 48);
         }
      }

      while(var1 % 37L == 0L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("LJWIWXSK.a(JI)Ljava/lang/String;")
   public static String a(long arg0, int arg1) {
      if (arg1 < 0 || arg1 > 0) {
         a = -187;
      }

      if (arg0 > 0L && arg0 < 6582952005840035281L) {
         if (arg0 % 37L == 0L) {
            return "invalid_name";
         } else {
            int var3 = 0;
            char[] var4 = new char[12];

            while(arg0 != 0L) {
               long var5 = arg0;
               arg0 /= 37L;
               var4[11 - var3++] = e[(int)(var5 - arg0 * 37L)];
            }

            return new String(var4, 12 - var3, var3);
         }
      } else {
         return "invalid_name";
      }
   }

   @ObfuscatedName("LJWIWXSK.a(ILjava/lang/String;)J")
   public static long a(int arg0, String arg1) {
      String var2 = arg1.toUpperCase();
      long var3 = 0L;
      int var5 = 11 / arg0;

      for(int var6 = 0; var6 < var2.length(); ++var6) {
         long var7 = var3 * 61L + (long)var2.charAt(var6) - 32L;
         var3 = var7 + (var7 >> 56) & 72057594037927935L;
      }

      return var3;
   }

   @ObfuscatedName("LJWIWXSK.a(II)Ljava/lang/String;")
   public static String a(int arg0, int arg1) {
      if (arg1 >= 0) {
         throw new NullPointerException();
      } else {
         return (arg0 >> 24 & 255) + "." + (arg0 >> 16 & 255) + "." + (arg0 >> 8 & 255) + "." + (arg0 & 255);
      }
   }

   @ObfuscatedName("LJWIWXSK.a(Ljava/lang/String;B)Ljava/lang/String;")
   public static String a(String arg0, byte arg1) {
      if (arg1 == 7) {
         boolean var2 = false;
      } else {
         d = 389;
      }

      if (arg0.length() > 0) {
         char[] var3 = arg0.toCharArray();

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4] == '_') {
               var3[var4] = ' ';
               if (var4 + 1 < var3.length && var3[var4 + 1] >= 'a' && var3[var4 + 1] <= 'z') {
                  var3[var4 + 1] = (char)(var3[var4 + 1] + 'A' - 97);
               }
            }
         }

         if (var3[0] >= 'a' && var3[0] <= 'z') {
            var3[0] = (char)(var3[0] + 'A' - 97);
         }

         return new String(var3);
      } else {
         return arg0;
      }
   }

   @ObfuscatedName("LJWIWXSK.b(ILjava/lang/String;)Ljava/lang/String;")
   public static String b(int arg0, String arg1) {
      StringBuffer var2 = new StringBuffer();
      if (arg0 != 2934) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

      for(int var4 = 0; var4 < arg1.length(); ++var4) {
         var2.append("*");
      }

      return var2.toString();
   }
}
