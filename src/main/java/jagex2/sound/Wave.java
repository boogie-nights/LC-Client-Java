package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.io.Packet;

public class Wave {
   @ObfuscatedName("UDNCEGOL.b")
   public int b = -573;
   @ObfuscatedName("UDNCEGOL.c")
   public int c = -252;
   @ObfuscatedName("UDNCEGOL.i")
   public SoundTone[] i = new SoundTone[10];
   @ObfuscatedName("UDNCEGOL.a")
   public static byte a = 6;
   @ObfuscatedName("UDNCEGOL.d")
   public static boolean d = true;
   @ObfuscatedName("UDNCEGOL.e")
   public static Wave[] e = new Wave[5000];
   @ObfuscatedName("UDNCEGOL.f")
   public static int[] f = new int[5000];
   @ObfuscatedName("UDNCEGOL.j")
   public int j;
   @ObfuscatedName("UDNCEGOL.k")
   public int k;
   @ObfuscatedName("UDNCEGOL.h")
   public static Packet h;
   @ObfuscatedName("UDNCEGOL.g")
   public static byte[] g;

   public Wave(int arg0) {
      if (arg0 >= 0) {
         throw new NullPointerException();
      }
   }

   @ObfuscatedName("UDNCEGOL.a(LMFMVIYHT;I)V")
   public static final void unpack(Packet arg0, int arg1) {
      if (arg1 == 36135) {
         g = new byte[441000];
         h = new Packet(g);
         SoundTone.a();

         while(true) {
            int var2 = arg0.g2();
            if (var2 == 65535) {
               return;
            }

            e[var2] = new Wave(-524);
            e[var2].a(a, arg0);
            f[var2] = e[var2].a(0);
         }
      }
   }

   @ObfuscatedName("UDNCEGOL.a(IBI)LMFMVIYHT;")
   public static final Packet a(int arg0, byte arg1, int arg2) {
      if (arg1 != 6) {
         d = !d;
      }

      if (e[arg2] != null) {
         Wave var3 = e[arg2];
         return var3.a(-573, arg0);
      } else {
         return null;
      }
   }

   @ObfuscatedName("UDNCEGOL.a(BLMFMVIYHT;)V")
   public final void a(byte arg0, Packet arg1) {
      for(int var3 = 0; var3 < 10; ++var3) {
         int var4 = arg1.g1();
         if (var4 != 0) {
            --arg1.pos;
            this.i[var3] = new SoundTone();
            this.i[var3].a(a, arg1);
         }
      }

      this.j = arg1.g2();
      this.k = arg1.g2();
      if (arg0 == 6) {
         boolean var5 = false;
      } else {
         this.c = 64;
      }
   }

   @ObfuscatedName("UDNCEGOL.a(I)I")
   public final int a(int arg0) {
      int var2 = 9999999;

      for(int var3 = 0; var3 < 10; ++var3) {
         if (this.i[var3] != null && this.i[var3].s / 20 < var2) {
            var2 = this.i[var3].s / 20;
         }
      }

      if (this.j < this.k && this.j / 20 < var2) {
         var2 = this.j / 20;
      }

      if (var2 != 9999999 && var2 != 0) {
         for(int var4 = 0; var4 < 10; ++var4) {
            if (this.i[var4] != null) {
               this.i[var4].s -= var2 * 20;
            }
         }

         if (arg0 != 0) {
            d = !d;
         }

         if (this.j < this.k) {
            this.j -= var2 * 20;
            this.k -= var2 * 20;
         }

         return var2;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("UDNCEGOL.a(II)LMFMVIYHT;")
   public final Packet a(int arg0, int arg1) {
      int var3 = this.b(arg1);
      h.pos = 0;
      h.p4(1380533830);
      h.ip4(var3 + 36);
      h.p4(1463899717);
      h.p4(1718449184);
      if (arg0 >= 0) {
         throw new NullPointerException();
      } else {
         h.ip4(16);
         h.ip2(1);
         h.ip2(1);
         h.ip4(22050);
         h.ip4(22050);
         h.ip2(1);
         h.ip2(8);
         h.p4(1684108385);
         h.ip4(var3);
         h.pos += var3;
         return h;
      }
   }

   @ObfuscatedName("UDNCEGOL.b(I)I")
   public final int b(int arg0) {
      int var2 = 0;

      for(int var3 = 0; var3 < 10; ++var3) {
         if (this.i[var3] != null && this.i[var3].s + this.i[var3].r > var2) {
            var2 = this.i[var3].s + this.i[var3].r;
         }
      }

      if (var2 == 0) {
         return 0;
      } else {
         int var4 = var2 * 22050 / 1000;
         int var5 = this.j * 22050 / 1000;
         int var6 = this.k * 22050 / 1000;
         if (var5 < 0 || var5 > var4 || var6 < 0 || var6 > var4 || var5 >= var6) {
            arg0 = 0;
         }

         int var7 = (arg0 - 1) * (var6 - var5) + var4;

         for(int var8 = 44; var8 < var7 + 44; ++var8) {
            g[var8] = -128;
         }

         for(int var9 = 0; var9 < 10; ++var9) {
            if (this.i[var9] != null) {
               int var10 = this.i[var9].r * 22050 / 1000;
               int var11 = this.i[var9].s * 22050 / 1000;
               int[] var12 = this.i[var9].a(var10, this.i[var9].r);

               for(int var13 = 0; var13 < var10; ++var13) {
                  int var14 = (var12[var13] >> 8) + (g[var11 + var13 + 44] & 255);
                  if ((var14 & -256) != 0) {
                     var14 = ~(var14 >> 31);
                  }

                  g[var11 + var13 + 44] = (byte)var14;
               }
            }
         }

         if (arg0 > 1) {
            var5 += 44;
            var6 += 44;
            var4 += 44;
            var7 += 44;
            int var15 = var7 - var4;

            for(int var16 = var4 - 1; var16 >= var6; --var16) {
               g[var15 + var16] = g[var16];
            }

            for(int var17 = 1; var17 < arg0; ++var17) {
               int var18 = (var6 - var5) * var17;

               for(int var19 = var5; var19 < var6; ++var19) {
                  g[var18 + var19] = g[var19];
               }
            }

            var7 -= 44;
         }

         return var7;
      }
   }
}
