package jagex2.config;

import jagex2.io.Jagfile;
import deob.ObfuscatedName;
import jagex2.io.Packet;

public class VarbitType {
   @ObfuscatedName("ZQTIEXZH.h")
   public boolean h = false;
   @ObfuscatedName("ZQTIEXZH.i")
   public int i = -1;
   @ObfuscatedName("ZQTIEXZH.k")
   public boolean k = true;
   @ObfuscatedName("ZQTIEXZH.a")
   public int a;
   @ObfuscatedName("ZQTIEXZH.b")
   public static int b;
   @ObfuscatedName("ZQTIEXZH.e")
   public int e;
   @ObfuscatedName("ZQTIEXZH.f")
   public int f;
   @ObfuscatedName("ZQTIEXZH.g")
   public int g;
   @ObfuscatedName("ZQTIEXZH.j")
   public int j;
   @ObfuscatedName("ZQTIEXZH.d")
   public String d;
   @ObfuscatedName("ZQTIEXZH.c")
   public static VarbitType[] c;

   @ObfuscatedName("ZQTIEXZH.a(LATJMVOZR;I)V")
   public static void unpack(Jagfile arg0, int arg1) {
      Packet var2 = new Packet(arg0.read("varbit.dat", (byte[])null));
      if (arg1 == 36135) {
         b = var2.g2();
         if (c == null) {
            c = new VarbitType[b];
         }

         for(int var3 = 0; var3 < b; ++var3) {
            if (c[var3] == null) {
               c[var3] = new VarbitType();
            }

            c[var3].a(-954, var3, var2);
            if (c[var3].h) {
               VarpType.b[c[var3].e].n = true;
            }
         }

         if (var2.data.length != var2.pos) {
            System.out.println("varbit load mismatch");
         }
      }
   }

   @ObfuscatedName("ZQTIEXZH.a(IILMFMVIYHT;)V")
   public void a(int arg0, int arg1, Packet arg2) {
      if (arg0 >= 0) {
         this.a = -151;
      }

      while(true) {
         int var4 = arg2.g1();
         if (var4 == 0) {
            return;
         }

         if (var4 == 1) {
            this.e = arg2.g2();
            this.f = arg2.g1();
            this.g = arg2.g1();
         } else if (var4 == 10) {
            this.d = arg2.gjstr();
         } else if (var4 == 2) {
            this.h = true;
         } else if (var4 == 3) {
            this.i = arg2.g4();
         } else if (var4 == 4) {
            this.j = arg2.g4();
         } else if (var4 == 5) {
            this.k = false;
         } else {
            System.out.println("Error unrecognised config code: " + var4);
         }
      }
   }
}
