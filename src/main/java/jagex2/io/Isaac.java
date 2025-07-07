package jagex2.io;

import deob.ObfuscatedName;

public class Isaac {
   @ObfuscatedName("KRGHNEZN.c")
   public int[] c = new int[256];
   @ObfuscatedName("KRGHNEZN.b")
   public int[] b = new int[256];
   @ObfuscatedName("KRGHNEZN.a")
   public int a;
   @ObfuscatedName("KRGHNEZN.d")
   public int d;
   @ObfuscatedName("KRGHNEZN.e")
   public int e;
   @ObfuscatedName("KRGHNEZN.f")
   public int f;

   public Isaac(int arg0, int[] arg1) {
      for(int var3 = 0; var3 < arg1.length; ++var3) {
         this.b[var3] = arg1[var3];
      }

      if (arg0 >= 0) {
         throw new NullPointerException();
      } else {
         this.c();
      }
   }

   @ObfuscatedName("KRGHNEZN.a()I")
   public final int nextInt() {
      if (this.a-- == 0) {
         this.b();
         this.a = 255;
      }

      return this.b[this.a];
   }

   @ObfuscatedName("KRGHNEZN.b()V")
   public final void b() {
      this.e += ++this.f;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.c[var1];
         if ((var1 & 3) == 0) {
            this.d ^= this.d << 13;
         } else if ((var1 & 3) == 1) {
            this.d ^= this.d >>> 6;
         } else if ((var1 & 3) == 2) {
            this.d ^= this.d << 2;
         } else if ((var1 & 3) == 3) {
            this.d ^= this.d >>> 16;
         }

         this.d += this.c[var1 + 128 & 255];
         int var3;
         this.c[var1] = var3 = this.c[(var2 & 1020) >> 2] + this.d + this.e;
         this.b[var1] = this.e = this.c[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("KRGHNEZN.c()V")
   public final void c() {
      int var1 = -1640531527;
      int var2 = -1640531527;
      int var3 = -1640531527;
      int var4 = -1640531527;
      int var5 = -1640531527;
      int var6 = -1640531527;
      int var7 = -1640531527;
      int var8 = -1640531527;

      for(int var9 = 0; var9 < 4; ++var9) {
         int var10 = var8 ^ var7 << 11;
         int var11 = var5 + var10;
         int var12 = var6 + var7;
         int var13 = var12 ^ var6 >>> 2;
         int var14 = var4 + var13;
         int var15 = var6 + var11;
         int var16 = var15 ^ var11 << 8;
         int var17 = var3 + var16;
         int var18 = var11 + var14;
         var5 = var18 ^ var14 >>> 16;
         int var19 = var2 + var5;
         int var20 = var14 + var17;
         var4 = var20 ^ var17 << 10;
         int var21 = var1 + var4;
         int var22 = var17 + var19;
         var3 = var22 ^ var19 >>> 4;
         int var23 = var3 + var10;
         int var24 = var19 + var21;
         var2 = var24 ^ var21 << 8;
         var7 = var2 + var13;
         int var25 = var21 + var23;
         var1 = var25 ^ var23 >>> 9;
         var6 = var1 + var16;
         var8 = var7 + var23;
      }

      for(int var26 = 0; var26 < 256; var26 += 8) {
         int var27 = this.b[var26] + var8;
         int var28 = this.b[var26 + 1] + var7;
         int var29 = this.b[var26 + 2] + var6;
         int var30 = this.b[var26 + 3] + var5;
         int var31 = this.b[var26 + 4] + var4;
         int var32 = this.b[var26 + 5] + var3;
         int var33 = this.b[var26 + 6] + var2;
         int var34 = this.b[var26 + 7] + var1;
         int var35 = var27 ^ var28 << 11;
         int var36 = var30 + var35;
         int var37 = var28 + var29;
         int var38 = var37 ^ var29 >>> 2;
         int var39 = var31 + var38;
         int var40 = var29 + var36;
         int var41 = var40 ^ var36 << 8;
         int var42 = var32 + var41;
         int var43 = var36 + var39;
         var5 = var43 ^ var39 >>> 16;
         int var44 = var5 + var33;
         int var45 = var39 + var42;
         var4 = var45 ^ var42 << 10;
         int var46 = var4 + var34;
         int var47 = var42 + var44;
         var3 = var47 ^ var44 >>> 4;
         int var48 = var3 + var35;
         int var49 = var44 + var46;
         var2 = var49 ^ var46 << 8;
         var7 = var2 + var38;
         int var50 = var46 + var48;
         var1 = var50 ^ var48 >>> 9;
         var6 = var1 + var41;
         var8 = var7 + var48;
         this.c[var26] = var8;
         this.c[var26 + 1] = var7;
         this.c[var26 + 2] = var6;
         this.c[var26 + 3] = var5;
         this.c[var26 + 4] = var4;
         this.c[var26 + 5] = var3;
         this.c[var26 + 6] = var2;
         this.c[var26 + 7] = var1;
      }

      for(int var51 = 0; var51 < 256; var51 += 8) {
         int var52 = this.c[var51] + var8;
         int var53 = this.c[var51 + 1] + var7;
         int var54 = this.c[var51 + 2] + var6;
         int var55 = this.c[var51 + 3] + var5;
         int var56 = this.c[var51 + 4] + var4;
         int var57 = this.c[var51 + 5] + var3;
         int var58 = this.c[var51 + 6] + var2;
         int var59 = this.c[var51 + 7] + var1;
         int var60 = var52 ^ var53 << 11;
         int var61 = var55 + var60;
         int var62 = var53 + var54;
         int var63 = var62 ^ var54 >>> 2;
         int var64 = var56 + var63;
         int var65 = var54 + var61;
         int var66 = var65 ^ var61 << 8;
         int var67 = var57 + var66;
         int var68 = var61 + var64;
         var5 = var68 ^ var64 >>> 16;
         int var69 = var5 + var58;
         int var70 = var64 + var67;
         var4 = var70 ^ var67 << 10;
         int var71 = var4 + var59;
         int var72 = var67 + var69;
         var3 = var72 ^ var69 >>> 4;
         int var73 = var3 + var60;
         int var74 = var69 + var71;
         var2 = var74 ^ var71 << 8;
         var7 = var2 + var63;
         int var75 = var71 + var73;
         var1 = var75 ^ var73 >>> 9;
         var6 = var1 + var66;
         var8 = var7 + var73;
         this.c[var51] = var8;
         this.c[var51 + 1] = var7;
         this.c[var51 + 2] = var6;
         this.c[var51 + 3] = var5;
         this.c[var51 + 4] = var4;
         this.c[var51 + 5] = var3;
         this.c[var51 + 6] = var2;
         this.c[var51 + 7] = var1;
      }

      this.b();
      this.a = 256;
   }
}
