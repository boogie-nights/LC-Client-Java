package jagex2.config;

import deob.*;
import jagex2.dash3d.Model;
import jagex2.datastruct.LruCache;
import jagex2.io.Jagfile;
import jagex2.io.Packet;

public class SpotAnimType {
   @ObfuscatedName("MNZYLKNY.c")
   public int c = -214;
   @ObfuscatedName("MNZYLKNY.h")
   public int h = -1;
   @ObfuscatedName("MNZYLKNY.j")
   public int[] j = new int[6];
   @ObfuscatedName("MNZYLKNY.k")
   public int[] k = new int[6];
   @ObfuscatedName("MNZYLKNY.l")
   public int l = 128;
   @ObfuscatedName("MNZYLKNY.m")
   public int m = 128;
   @ObfuscatedName("MNZYLKNY.a")
   public static byte a = 6;
   @ObfuscatedName("MNZYLKNY.b")
   public static boolean b = true;
   @ObfuscatedName("MNZYLKNY.q")
   public static LruCache q = new LruCache(30, -572);
   @ObfuscatedName("MNZYLKNY.d")
   public static int d;
   @ObfuscatedName("MNZYLKNY.f")
   public int f;
   @ObfuscatedName("MNZYLKNY.g")
   public int g;
   @ObfuscatedName("MNZYLKNY.n")
   public int n;
   @ObfuscatedName("MNZYLKNY.o")
   public int o;
   @ObfuscatedName("MNZYLKNY.p")
   public int p;
   @ObfuscatedName("MNZYLKNY.i")
   public SeqType i;
   @ObfuscatedName("MNZYLKNY.e")
   public static SpotAnimType[] e;

   @ObfuscatedName("MNZYLKNY.a(LATJMVOZR;I)V")
   public static void a(Jagfile arg0, int arg1) {
      Packet var2 = new Packet(arg0.read("spotanim.dat", (byte[])null));
      d = var2.g2();
      if (arg1 != 36135) {
         b = !b;
      }

      if (e == null) {
         e = new SpotAnimType[d];
      }

      for(int var3 = 0; var3 < d; ++var3) {
         if (e[var3] == null) {
            e[var3] = new SpotAnimType();
         }

         e[var3].f = var3;
         e[var3].a(a, var2);
      }

   }

   @ObfuscatedName("MNZYLKNY.a(BLMFMVIYHT;)V")
   public void a(byte arg0, Packet arg1) {
      if (arg0 == 6) {
         boolean var3 = false;
      } else {
         this.c = 458;
      }

      while(true) {
         while(true) {
            int var4 = arg1.g1();
            if (var4 == 0) {
               return;
            }

            if (var4 == 1) {
               this.g = arg1.g2();
            } else if (var4 == 2) {
               this.h = arg1.g2();
               if (SeqType.d != null) {
                  this.i = SeqType.d[this.h];
               }
            } else if (var4 == 4) {
               this.l = arg1.g2();
            } else if (var4 == 5) {
               this.m = arg1.g2();
            } else if (var4 == 6) {
               this.n = arg1.g2();
            } else if (var4 == 7) {
               this.o = arg1.g1();
            } else if (var4 == 8) {
               this.p = arg1.g1();
            } else if (var4 >= 40 && var4 < 50) {
               this.j[var4 - 40] = arg1.g2();
            } else if (var4 >= 50 && var4 < 60) {
               this.k[var4 - 50] = arg1.g2();
            } else {
               System.out.println("Error unrecognised spotanim config code: " + var4);
            }
         }
      }
   }

   @ObfuscatedName("MNZYLKNY.a()LLZYQDKJV;")
   public Model a() {
      Model var1 = (Model)q.get((long)this.f);
      if (var1 != null) {
         return var1;
      } else {
         Model var2 = Model.a(this.g);
         if (var2 == null) {
            return null;
         } else {
            for(int var3 = 0; var3 < 6; ++var3) {
               if (this.j[0] != 0) {
                  var2.c(this.j[var3], this.k[var3]);
               }
            }

            q.put(var2, (long)this.f);
            return var2;
         }
      }
   }
}
