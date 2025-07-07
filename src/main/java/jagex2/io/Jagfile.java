package jagex2.io;

import deob.ObfuscatedName;

public class Jagfile {
   @ObfuscatedName("ATJMVOZR.a")
   public int a = -766;
   @ObfuscatedName("ATJMVOZR.b")
   public boolean b = true;
   @ObfuscatedName("ATJMVOZR.d")
   public int d;
   @ObfuscatedName("ATJMVOZR.i")
   public boolean i;
   @ObfuscatedName("ATJMVOZR.c")
   public byte[] c;
   @ObfuscatedName("ATJMVOZR.e")
   public int[] e;
   @ObfuscatedName("ATJMVOZR.f")
   public int[] f;
   @ObfuscatedName("ATJMVOZR.g")
   public int[] g;
   @ObfuscatedName("ATJMVOZR.h")
   public int[] h;

   public Jagfile(byte[] arg0, int arg1) {
      this.a(0, arg0);
      if (arg1 < 3 || arg1 > 3) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

   }

   @ObfuscatedName("ATJMVOZR.a(I[B)V")
   public void a(int arg0, byte[] arg1) {
      Packet var3 = new Packet(arg1);
      int var4 = var3.g3();
      int var5 = var3.g3();
      if (var4 != var5) {
         byte[] var6 = new byte[var4];
         BZip2.a(var6, var4, arg1, var5, 6);
         this.c = var6;
         var3 = new Packet(this.c);
         this.i = true;
      } else {
         this.c = arg1;
         this.i = false;
      }

      this.d = var3.e();
      this.e = new int[this.d];
      this.f = new int[this.d];
      this.g = new int[this.d];
      if (arg0 == 0) {
         this.h = new int[this.d];
         int var7 = this.d * 10 + var3.pos;

         for(int var8 = 0; var8 < this.d; ++var8) {
            this.e[var8] = var3.g4();
            this.f[var8] = var3.g3();
            this.g[var8] = var3.g3();
            this.h[var8] = var7;
            var7 += this.g[var8];
         }

      }
   }

   @ObfuscatedName("ATJMVOZR.a(Ljava/lang/String;[B)[B")
   public byte[] a(String arg0, byte[] arg1) {
      int var3 = 0;
      String var4 = arg0.toUpperCase();

      for(int var5 = 0; var5 < var4.length(); ++var5) {
         var3 = var3 * 61 + var4.charAt(var5) - 32;
      }

      for(int var6 = 0; var6 < this.d; ++var6) {
         if (this.e[var6] == var3) {
            if (arg1 == null) {
               arg1 = new byte[this.f[var6]];
            }

            if (!this.i) {
               BZip2.a(arg1, this.f[var6], this.c, this.g[var6], this.h[var6]);
            } else {
               for(int var7 = 0; var7 < this.f[var6]; ++var7) {
                  arg1[var7] = this.c[this.h[var6] + var7];
               }
            }

            return arg1;
         }
      }

      return null;
   }
}
