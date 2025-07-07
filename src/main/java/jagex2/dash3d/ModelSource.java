package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;

public class ModelSource extends DoublyLinkable {
   @ObfuscatedName("ZOXDNIET.i")
   public boolean i = true;
   @ObfuscatedName("ZOXDNIET.k")
   public int k = 1000;
   @ObfuscatedName("ZOXDNIET.h")
   public static byte h = 3;
   @ObfuscatedName("ZOXDNIET.l")
   public static boolean l;
   @ObfuscatedName("ZOXDNIET.j")
   public VertexNormal[] j;

   @ObfuscatedName("ZOXDNIET.a(IIIIIIIII)V")
   public void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
      Model var10 = this.a(h);
      if (var10 != null) {
         this.k = var10.k;
         var10.a(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
      }

   }

   @ObfuscatedName("ZOXDNIET.a(B)LLZYQDKJV;")
   public Model a(byte arg0) {
      if (arg0 != 3) {
         this.i = !this.i;
      }

      return null;
   }
}
