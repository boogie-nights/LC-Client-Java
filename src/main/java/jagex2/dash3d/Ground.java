package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.datastruct.Linkable;

public class Ground {
   @ObfuscatedName("JQCVNYYR.l")
   public boolean l = true;
   @ObfuscatedName("JQCVNYYR.m")
   public int m;
   @ObfuscatedName("JQCVNYYR.n")
   public int n;
   @ObfuscatedName("JQCVNYYR.o")
   public int o;
   @ObfuscatedName("JQCVNYYR.p")
   public int p;
   @ObfuscatedName("JQCVNYYR.a")
   public int a;
   @ObfuscatedName("JQCVNYYR.b")
   public int[] b;
   @ObfuscatedName("JQCVNYYR.c")
   public int[] c;
   @ObfuscatedName("JQCVNYYR.d")
   public int[] d;
   @ObfuscatedName("JQCVNYYR.h")
   public int[] h;
   @ObfuscatedName("JQCVNYYR.i")
   public int[] i;
   @ObfuscatedName("JQCVNYYR.j")
   public int[] j;
   @ObfuscatedName("JQCVNYYR.e")
   public int[] e;
   @ObfuscatedName("JQCVNYYR.f")
   public int[] f;
   @ObfuscatedName("JQCVNYYR.g")
   public int[] g;
   @ObfuscatedName("JQCVNYYR.k")
   public int[] k;
   @ObfuscatedName("JQCVNYYR.q")
   public static int[] q = new int[6];
   @ObfuscatedName("JQCVNYYR.r")
   public static int[] r = new int[6];
   @ObfuscatedName("JQCVNYYR.s")
   public static int[] s = new int[6];
   @ObfuscatedName("JQCVNYYR.t")
   public static int[] t = new int[6];
   @ObfuscatedName("JQCVNYYR.u")
   public static int[] u = new int[6];
   @ObfuscatedName("JQCVNYYR.v")
   public static int[] v = new int[]{1, 0};
   @ObfuscatedName("JQCVNYYR.w")
   public static int[] w = new int[]{2, 1};
   @ObfuscatedName("JQCVNYYR.x")
   public static int[] x = new int[]{3, 3};
   @ObfuscatedName("JQCVNYYR.y")
   public static final int[][] y = new int[][]{{1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 2, 6}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 13, 14}};
   @ObfuscatedName("JQCVNYYR.z")
   public static final int[][] z = new int[][]{{0, 1, 2, 3, 0, 0, 1, 3}, {1, 1, 2, 3, 1, 0, 1, 3}, {0, 1, 2, 3, 1, 0, 1, 3}, {0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3}, {0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4}, {0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4}, {0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3}, {0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3}, {0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5}, {0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5}, {0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3}, {1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3}, {1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5}};

   public Ground(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19) {
      if (arg3 != arg13 || arg2 != arg3 || arg0 != arg3) {
         this.l = false;
      }

      this.m = arg12;
      this.n = arg19;
      this.o = arg16;
      this.p = arg7;
      short var21 = 128;
      int var22 = var21 / 2;
      int var23 = var21 / 4;
      int var24 = var21 * 3 / 4;
      if (arg10 >= this.a && arg10 <= this.a) {
         int[] var25 = y[arg12];
         int var26 = var25.length;
         this.b = new int[var26];
         this.c = new int[var26];
         this.d = new int[var26];
         int[] var27 = new int[var26];
         int[] var28 = new int[var26];
         int var29 = arg4 * var21;
         int var30 = arg18 * var21;

         for(int var31 = 0; var31 < var26; ++var31) {
            int var32 = var25[var31];
            if ((var32 & 1) == 0 && var32 <= 8) {
               var32 = (var32 - arg19 - arg19 - 1 & 7) + 1;
            }

            if (var32 > 8 && var32 <= 12) {
               var32 = (var32 - 9 - arg19 & 3) + 9;
            }

            if (var32 > 12 && var32 <= 16) {
               var32 = (var32 - 13 - arg19 & 3) + 13;
            }

            int var33;
            int var34;
            int var35;
            int var36;
            int var37;
            if (var32 == 1) {
               var33 = var29;
               var34 = var30;
               var35 = arg3;
               var36 = arg11;
               var37 = arg1;
            } else if (var32 == 2) {
               var33 = var22 + var29;
               var34 = var30;
               var35 = arg3 + arg13 >> 1;
               var36 = arg8 + arg11 >> 1;
               var37 = arg1 + arg17 >> 1;
            } else if (var32 == 3) {
               var33 = var21 + var29;
               var34 = var30;
               var35 = arg13;
               var36 = arg8;
               var37 = arg17;
            } else if (var32 == 4) {
               var33 = var21 + var29;
               var34 = var22 + var30;
               var35 = arg2 + arg13 >> 1;
               var36 = arg5 + arg8 >> 1;
               var37 = arg9 + arg17 >> 1;
            } else if (var32 == 5) {
               var33 = var21 + var29;
               var34 = var21 + var30;
               var35 = arg2;
               var36 = arg5;
               var37 = arg9;
            } else if (var32 == 6) {
               var33 = var22 + var29;
               var34 = var21 + var30;
               var35 = arg0 + arg2 >> 1;
               var36 = arg5 + arg6 >> 1;
               var37 = arg9 + arg14 >> 1;
            } else if (var32 == 7) {
               var33 = var29;
               var34 = var21 + var30;
               var35 = arg0;
               var36 = arg6;
               var37 = arg14;
            } else if (var32 == 8) {
               var33 = var29;
               var34 = var22 + var30;
               var35 = arg0 + arg3 >> 1;
               var36 = arg6 + arg11 >> 1;
               var37 = arg1 + arg14 >> 1;
            } else if (var32 == 9) {
               var33 = var22 + var29;
               var34 = var23 + var30;
               var35 = arg3 + arg13 >> 1;
               var36 = arg8 + arg11 >> 1;
               var37 = arg1 + arg17 >> 1;
            } else if (var32 == 10) {
               var33 = var24 + var29;
               var34 = var22 + var30;
               var35 = arg2 + arg13 >> 1;
               var36 = arg5 + arg8 >> 1;
               var37 = arg9 + arg17 >> 1;
            } else if (var32 == 11) {
               var33 = var22 + var29;
               var34 = var24 + var30;
               var35 = arg0 + arg2 >> 1;
               var36 = arg5 + arg6 >> 1;
               var37 = arg9 + arg14 >> 1;
            } else if (var32 == 12) {
               var33 = var23 + var29;
               var34 = var22 + var30;
               var35 = arg0 + arg3 >> 1;
               var36 = arg6 + arg11 >> 1;
               var37 = arg1 + arg14 >> 1;
            } else if (var32 == 13) {
               var33 = var23 + var29;
               var34 = var23 + var30;
               var35 = arg3;
               var36 = arg11;
               var37 = arg1;
            } else if (var32 == 14) {
               var33 = var24 + var29;
               var34 = var23 + var30;
               var35 = arg13;
               var36 = arg8;
               var37 = arg17;
            } else if (var32 == 15) {
               var33 = var24 + var29;
               var34 = var24 + var30;
               var35 = arg2;
               var36 = arg5;
               var37 = arg9;
            } else {
               var33 = var23 + var29;
               var34 = var24 + var30;
               var35 = arg0;
               var36 = arg6;
               var37 = arg14;
            }

            this.b[var31] = var33;
            this.c[var31] = var35;
            this.d[var31] = var34;
            var27[var31] = var36;
            var28[var31] = var37;
         }

         int[] var38 = z[arg12];
         int var39 = var38.length / 4;
         this.h = new int[var39];
         this.i = new int[var39];
         this.j = new int[var39];
         this.e = new int[var39];
         this.f = new int[var39];
         this.g = new int[var39];
         if (arg15 != -1) {
            this.k = new int[var39];
         }

         int var40 = 0;

         for(int var41 = 0; var41 < var39; ++var41) {
            int var42 = var38[var40];
            int var43 = var38[var40 + 1];
            int var44 = var38[var40 + 2];
            int var45 = var38[var40 + 3];
            var40 += 4;
            if (var43 < 4) {
               var43 = var43 - arg19 & 3;
            }

            if (var44 < 4) {
               var44 = var44 - arg19 & 3;
            }

            if (var45 < 4) {
               var45 = var45 - arg19 & 3;
            }

            this.h[var41] = var43;
            this.i[var41] = var44;
            this.j[var41] = var45;
            if (var42 == 0) {
               this.e[var41] = var27[var43];
               this.f[var41] = var27[var44];
               this.g[var41] = var27[var45];
               if (this.k != null) {
                  this.k[var41] = -1;
               }
            } else {
               this.e[var41] = var28[var43];
               this.f[var41] = var28[var44];
               this.g[var41] = var28[var45];
               if (this.k != null) {
                  this.k[var41] = arg15;
               }
            }
         }

         int var46 = arg3;
         int var47 = arg13;
         if (arg13 < arg3) {
            var46 = arg13;
         }

         if (arg13 > arg13) {
            var47 = arg13;
         }

         if (arg2 < var46) {
            var46 = arg2;
         }

         if (arg2 > var47) {
            var47 = arg2;
         }

         if (arg0 < var46) {
            var46 = arg0;
         }

         if (arg0 > var47) {
            var47 = arg0;
         }

         int var48 = var46 / 14;
         int var49 = var47 / 14;
         if (Linkable.d) {
         }

      } else {
         throw new NullPointerException();
      }
   }
}
