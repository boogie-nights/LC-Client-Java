package jagex2.config;

import jagex2.io.Jagfile;
import jagex2.dash3d.Model;
import deob.ObfuscatedName;
import jagex2.io.Packet;

public class IdkType {
   @ObfuscatedName("ZGOJZVHR.b")
   public int b = -766;
   @ObfuscatedName("ZGOJZVHR.c")
   public int c = 256;
   @ObfuscatedName("ZGOJZVHR.f")
   public int f = -1;
   @ObfuscatedName("ZGOJZVHR.h")
   public int[] h = new int[6];
   @ObfuscatedName("ZGOJZVHR.i")
   public int[] i = new int[6];
   @ObfuscatedName("ZGOJZVHR.j")
   public int[] j = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("ZGOJZVHR.k")
   public boolean k = false;
   @ObfuscatedName("ZGOJZVHR.a")
   public static byte a = 6;
   @ObfuscatedName("ZGOJZVHR.d")
   public static int d;
   @ObfuscatedName("ZGOJZVHR.g")
   public int[] g;
   @ObfuscatedName("ZGOJZVHR.e")
   public static IdkType[] e;

   @ObfuscatedName("ZGOJZVHR.a(LATJMVOZR;I)V")
   public static void a(Jagfile arg0, int arg1) {
      Packet var2 = new Packet(arg0.a("idk.dat", (byte[])null));
      d = var2.e();
      if (e == null) {
         e = new IdkType[d];
      }

      for(int var3 = 0; var3 < d; ++var3) {
         if (e[var3] == null) {
            e[var3] = new IdkType();
         }

         e[var3].a(a, var2);
      }

      if (arg1 == 36135) {
         ;
      }
   }

   @ObfuscatedName("ZGOJZVHR.a(BLMFMVIYHT;)V")
   public void a(byte arg0, Packet arg1) {
      if (arg0 != 6) {
         throw new NullPointerException();
      } else {
         boolean var3 = false;

         while(true) {
            while(true) {
               int var4 = arg1.g1();
               if (var4 == 0) {
                  return;
               }

               if (var4 == 1) {
                  this.f = arg1.g1();
               } else if (var4 == 2) {
                  int var5 = arg1.g1();
                  this.g = new int[var5];

                  for(int var6 = 0; var6 < var5; ++var6) {
                     this.g[var6] = arg1.e();
                  }
               } else if (var4 == 3) {
                  this.k = true;
               } else if (var4 >= 40 && var4 < 50) {
                  this.h[var4 - 40] = arg1.e();
               } else if (var4 >= 50 && var4 < 60) {
                  this.i[var4 - 50] = arg1.e();
               } else if (var4 >= 60 && var4 < 70) {
                  this.j[var4 - 60] = arg1.e();
               } else {
                  System.out.println("Error unrecognised config code: " + var4);
               }
            }
         }
      }
   }

   @ObfuscatedName("ZGOJZVHR.a(I)Z")
   public boolean a(int arg0) {
      if (this.g == null) {
         return true;
      } else {
         boolean var2 = true;
         int var3 = 89 / arg0;

         for(int var4 = 0; var4 < this.g.length; ++var4) {
            if (!Model.b(this.g[var4])) {
               var2 = false;
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("ZGOJZVHR.a(B)LLZYQDKJV;")
   public Model a(byte arg0) {
      if (this.g == null) {
         return null;
      } else {
         Model[] var2 = new Model[this.g.length];

         for(int var3 = 0; var3 < this.g.length; ++var3) {
            var2[var3] = Model.a(this.g[var3]);
         }

         Model var4;
         if (var2.length == 1) {
            var4 = var2[0];
         } else {
            var4 = new Model(var2.length, var2, (byte)-89);
         }

         for(int var5 = 0; var5 < 6 && this.h[var5] != 0; ++var5) {
            var4.c(this.h[var5], this.i[var5]);
         }

         if (arg0 != 2) {
            throw new NullPointerException();
         } else {
            return var4;
         }
      }
   }

   @ObfuscatedName("ZGOJZVHR.b(I)Z")
   public boolean b(int arg0) {
      if (arg0 != -10584) {
         throw new NullPointerException();
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < 5; ++var3) {
            if (this.j[var3] != -1 && !Model.b(this.j[var3])) {
               var2 = false;
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("ZGOJZVHR.a(Z)LLZYQDKJV;")
   public Model a(boolean arg0) {
      Model[] var2 = new Model[5];
      if (arg0) {
         this.b = -298;
      }

      int var3 = 0;

      for(int var4 = 0; var4 < 5; ++var4) {
         if (this.j[var4] != -1) {
            var2[var3++] = Model.a(this.j[var4]);
         }
      }

      Model var5 = new Model(var3, var2, (byte)-89);

      for(int var6 = 0; var6 < 6 && this.h[var6] != 0; ++var6) {
         var5.c(this.h[var6], this.i[var6]);
      }

      return var5;
   }
}
