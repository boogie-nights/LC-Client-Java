package jagex2.config;

import jagex2.io.Jagfile;
import deob.ObfuscatedName;
import jagex2.io.Packet;

public class VarpType {
   @ObfuscatedName("WEUDDWZB.h")
   public boolean h = false;
   @ObfuscatedName("WEUDDWZB.i")
   public boolean i = true;
   @ObfuscatedName("WEUDDWZB.k")
   public boolean k = false;
   @ObfuscatedName("WEUDDWZB.n")
   public boolean n = false;
   @ObfuscatedName("WEUDDWZB.o")
   public int o = -1;
   @ObfuscatedName("WEUDDWZB.p")
   public boolean p = true;
   @ObfuscatedName("WEUDDWZB.a")
   public static int a;
   @ObfuscatedName("WEUDDWZB.c")
   public static int c;
   @ObfuscatedName("WEUDDWZB.f")
   public int f;
   @ObfuscatedName("WEUDDWZB.g")
   public int g;
   @ObfuscatedName("WEUDDWZB.j")
   public int j;
   @ObfuscatedName("WEUDDWZB.l")
   public int l;
   @ObfuscatedName("WEUDDWZB.m")
   public int m;
   @ObfuscatedName("WEUDDWZB.e")
   public String e;
   @ObfuscatedName("WEUDDWZB.d")
   public static int[] d;
   @ObfuscatedName("WEUDDWZB.b")
   public static VarpType[] b;

   @ObfuscatedName("WEUDDWZB.a(LATJMVOZR;I)V")
   public static void a(Jagfile arg0, int arg1) {
      Packet var2 = new Packet(arg0.a("varp.dat", (byte[])null));
      if (arg1 == 36135) {
         c = 0;
         a = var2.e();
         if (b == null) {
            b = new VarpType[a];
         }

         if (d == null) {
            d = new int[a];
         }

         for(int var3 = 0; var3 < a; ++var3) {
            if (b[var3] == null) {
               b[var3] = new VarpType();
            }

            b[var3].a(-954, var3, var2);
         }

         if (var2.data.length != var2.pos) {
            System.out.println("varptype load mismatch");
         }
      }
   }

   @ObfuscatedName("WEUDDWZB.a(IILMFMVIYHT;)V")
   public void a(int arg0, int arg1, Packet arg2) {
      if (arg0 < 0) {
         while(true) {
            int var4 = arg2.g1();
            if (var4 == 0) {
               return;
            }

            if (var4 == 1) {
               this.f = arg2.g1();
            } else if (var4 == 2) {
               this.g = arg2.g1();
            } else if (var4 == 3) {
               this.h = true;
               d[c++] = arg1;
            } else if (var4 == 4) {
               this.i = false;
            } else if (var4 == 5) {
               this.j = arg2.e();
            } else if (var4 == 6) {
               this.k = true;
            } else if (var4 == 7) {
               this.l = arg2.g4();
            } else if (var4 == 8) {
               this.m = 1;
               this.n = true;
            } else if (var4 == 10) {
               this.e = arg2.gjstr();
            } else if (var4 == 11) {
               this.n = true;
            } else if (var4 == 12) {
               this.o = arg2.g4();
            } else if (var4 == 13) {
               this.m = 2;
               this.n = true;
            } else if (var4 == 14) {
               this.p = false;
            } else {
               System.out.println("Error unrecognised config code: " + var4);
            }
         }
      }
   }
}
