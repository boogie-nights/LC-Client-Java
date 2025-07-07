package jagex2.io;

import deob.ObfuscatedName;
import jagex2.datastruct.Linkable;

public class BZip2 {
   @ObfuscatedName("QGXYZPKP.a")
   public static BZip2State a = new BZip2State();

   @ObfuscatedName("QGXYZPKP.a([BI[BII)I")
   public static int decompress(byte[] arg0, int arg1, byte[] arg2, int arg3, int arg4) {
      BZip2State var5 = a;
      synchronized(a){}

      Throwable var10000;
      boolean var10001;
      int var7;
      try {
         a.j = arg2;
         a.k = arg4;
         a.o = arg0;
         a.p = 0;
         a.l = arg3;
         a.q = arg1;
         a.x = 0;
         a.w = 0;
         a.m = 0;
         a.n = 0;
         a.r = 0;
         a.s = 0;
         a.z = 0;
         b(a);
         int var6 = arg1 - a.q;
         var7 = var6;
      } catch (Throwable var14) {
         var10000 = var14;
         var10001 = false;
         throw var10000;
      }

      try {

         return var7;
      } catch (Throwable var13) {
         var10000 = var13;
         var10001 = false;
         throw var10000;
      }
   }

   @ObfuscatedName("QGXYZPKP.a(LANEJWQAX;)V")
   public static void a(BZip2State arg0) {
      byte var1 = arg0.t;
      int var2 = arg0.u;
      int var3 = arg0.E;
      int var4 = arg0.C;
      int[] var5 = BZip2State.H;
      int var6 = arg0.B;
      byte[] var7 = arg0.o;
      int var8 = arg0.p;
      int var9 = arg0.q;
      int var10 = var9;
      int var11 = arg0.V + 1;

      label67:
      while(true) {
         if (var2 > 0) {
            while(true) {
               if (var9 == 0) {
                  break label67;
               }

               if (var2 == 1) {
                  if (var9 == 0) {
                     var2 = 1;
                     break label67;
                  }

                  var7[var8] = var1;
                  ++var8;
                  --var9;
                  break;
               }

               var7[var8] = var1;
               --var2;
               ++var8;
               --var9;
            }
         }

         boolean var12 = true;

         while(var12) {
            var12 = false;
            if (var3 == var11) {
               var2 = 0;
               break label67;
            }

            var1 = (byte)var4;
            int var13 = var5[var6];
            byte var14 = (byte)(var13 & 255);
            var6 = var13 >> 8;
            ++var3;
            if (var4 != var14) {
               var4 = var14;
               if (var9 == 0) {
                  var2 = 1;
                  break label67;
               }

               var7[var8] = var1;
               ++var8;
               --var9;
               var12 = true;
            } else if (var3 == var11) {
               if (var9 == 0) {
                  var2 = 1;
                  break label67;
               }

               var7[var8] = var1;
               ++var8;
               --var9;
               var12 = true;
            }
         }

         var2 = 2;
         int var15 = var5[var6];
         byte var16 = (byte)(var15 & 255);
         var6 = var15 >> 8;
         ++var3;
         if (var3 != var11) {
            if (var4 != var16) {
               var4 = var16;
            } else {
               var2 = 3;
               int var17 = var5[var6];
               byte var18 = (byte)(var17 & 255);
               var6 = var17 >> 8;
               ++var3;
               if (var3 != var11) {
                  if (var4 != var18) {
                     var4 = var18;
                  } else {
                     int var19 = var5[var6];
                     byte var20 = (byte)(var19 & 255);
                     int var21 = var19 >> 8;
                     ++var3;
                     var2 = (var20 & 255) + 4;
                     int var22 = var5[var21];
                     var4 = (byte)(var22 & 255);
                     var6 = var22 >> 8;
                     ++var3;
                  }
               }
            }
         }
      }

      int var23 = arg0.r;
      arg0.r += var10 - var9;
      if (arg0.r < var23) {
         ++arg0.s;
      }

      arg0.t = var1;
      arg0.u = var2;
      arg0.E = var3;
      arg0.C = var4;
      BZip2State.H = var5;
      arg0.B = var6;
      arg0.o = var7;
      arg0.p = var8;
      arg0.q = var9;
   }

   @ObfuscatedName("QGXYZPKP.b(LANEJWQAX;)V")
   public static void b(BZip2State arg0) {
      boolean var1 = false;
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      boolean var10 = false;
      boolean var11 = false;
      boolean var12 = false;
      boolean var13 = false;
      boolean var14 = false;
      boolean var15 = false;
      boolean var16 = false;
      boolean var17 = false;
      boolean var18 = false;
      boolean var19 = false;
      int var20 = 0;
      int[] var21 = null;
      int[] var22 = null;
      int[] var23 = null;
      arg0.y = 1;
      if (BZip2State.H == null) {
         BZip2State.H = new int[arg0.y * 100000];
      }

      boolean var24 = true;

      while(true) {
         while(var24) {
            byte var25 = c(arg0);
            if (var25 == 23) {
               return;
            }

            byte var26 = c(arg0);
            byte var27 = c(arg0);
            byte var28 = c(arg0);
            byte var29 = c(arg0);
            byte var30 = c(arg0);
            ++arg0.z;
            byte var31 = c(arg0);
            byte var32 = c(arg0);
            byte var33 = c(arg0);
            byte var34 = c(arg0);
            byte var35 = d(arg0);
            if (var35 != 0) {
               arg0.v = true;
            } else {
               arg0.v = false;
            }

            if (arg0.v) {
               System.out.println("PANIC! RANDOMISED BLOCK!");
            }

            arg0.A = 0;
            byte var36 = c(arg0);
            arg0.A = arg0.A << 8 | var36 & 255;
            byte var37 = c(arg0);
            arg0.A = arg0.A << 8 | var37 & 255;
            byte var38 = c(arg0);
            arg0.A = arg0.A << 8 | var38 & 255;

            for(int var39 = 0; var39 < 16; ++var39) {
               byte var40 = d(arg0);
               if (var40 == 1) {
                  arg0.K[var39] = true;
               } else {
                  arg0.K[var39] = false;
               }
            }

            for(int var41 = 0; var41 < 256; ++var41) {
               arg0.J[var41] = false;
            }

            for(int var42 = 0; var42 < 16; ++var42) {
               if (arg0.K[var42]) {
                  for(int var43 = 0; var43 < 16; ++var43) {
                     byte var44 = d(arg0);
                     if (var44 == 1) {
                        arg0.J[var42 * 16 + var43] = true;
                     }
                  }
               }
            }

            e(arg0);
            int var45 = arg0.I + 2;
            int var46 = a(3, arg0);
            int var47 = a(15, arg0);

            for(int var48 = 0; var48 < var47; ++var48) {
               int var49 = 0;

               while(true) {
                  byte var50 = d(arg0);
                  if (var50 == 0) {
                     arg0.P[var48] = (byte)var49;
                     break;
                  }

                  ++var49;
               }
            }

            byte[] var51 = new byte[6];
            byte var52 = 0;

            while(var52 < var46) {
               var51[var52] = var52++;
            }

            for(int var53 = 0; var53 < var47; ++var53) {
               byte var54 = arg0.P[var53];
               byte var55 = var51[var54];

               while(var54 > 0) {
                  var51[var54] = var51[var54 - 1];
                  --var54;
               }

               var51[0] = var55;
               arg0.O[var53] = var55;
            }

            for(int var56 = 0; var56 < var46; ++var56) {
               int var57 = a(5, arg0);

               for(int var58 = 0; var58 < var45; ++var58) {
                  while(true) {
                     byte var59 = d(arg0);
                     if (var59 == 0) {
                        arg0.Q[var56][var58] = (byte)var57;
                        break;
                     }

                     byte var60 = d(arg0);
                     if (var60 == 0) {
                        ++var57;
                     } else {
                        --var57;
                     }
                  }
               }
            }

            for(int var61 = 0; var61 < var46; ++var61) {
               byte var62 = 32;
               byte var63 = 0;

               for(int var64 = 0; var64 < var45; ++var64) {
                  if (arg0.Q[var61][var64] > var63) {
                     var63 = arg0.Q[var61][var64];
                  }

                  if (arg0.Q[var61][var64] < var62) {
                     var62 = arg0.Q[var61][var64];
                  }
               }

               a(arg0.R[var61], arg0.S[var61], arg0.T[var61], arg0.Q[var61], var62, var63, var45);
               arg0.U[var61] = var62;
            }

            int var65 = arg0.I + 1;
            int var66 = arg0.y * 100000;
            int var67 = -1;
            byte var68 = 0;

            for(int var69 = 0; var69 <= 255; ++var69) {
               arg0.D[var69] = 0;
            }

            int var70 = 4095;

            for(int var71 = 15; var71 >= 0; --var71) {
               for(int var72 = 15; var72 >= 0; --var72) {
                  arg0.M[var70] = (byte)(var71 * 16 + var72);
                  --var70;
               }

               arg0.N[var71] = var70 + 1;
            }

            int var73 = 0;
            if (var68 == 0) {
               ++var67;
               var68 = 50;
               byte var74 = arg0.O[var67];
               var20 = arg0.U[var74];
               var21 = arg0.R[var74];
               var23 = arg0.T[var74];
               var22 = arg0.S[var74];
            }

            int var104 = var68 - 1;
            int var75 = var20;

            int var76;
            byte var77;
            for(var76 = a(var20, arg0); var76 > var21[var75]; var76 = var76 << 1 | var77) {
               ++var75;
               var77 = d(arg0);
            }

            int var78 = var23[var76 - var22[var75]];

            while(true) {
               while(var65 != var78) {
                  if (var78 != 0 && var78 != 1) {
                     int var86 = var78 - 1;
                     byte var88;
                     if (var86 < 16) {
                        int var87 = arg0.N[0];
                        var88 = arg0.M[var86 + var87];

                        while(var86 > 3) {
                           int var89 = var86 + var87;
                           arg0.M[var89] = arg0.M[var89 - 1];
                           arg0.M[var89 - 1] = arg0.M[var89 - 2];
                           arg0.M[var89 - 2] = arg0.M[var89 - 3];
                           arg0.M[var89 - 3] = arg0.M[var89 - 4];
                           var86 -= 4;
                        }

                        while(var86 > 0) {
                           arg0.M[var86 + var87] = arg0.M[var86 + var87 - 1];
                           --var86;
                        }

                        arg0.M[var87] = var88;
                     } else {
                        int var90 = var86 / 16;
                        int var91 = var86 % 16;
                        int var92 = arg0.N[var90] + var91;
                        var88 = arg0.M[var92];

                        while(var92 > arg0.N[var90]) {
                           arg0.M[var92] = arg0.M[var92 - 1];
                           --var92;
                        }

                        int var10002 = arg0.N[var90]++;

                        while(var90 > 0) {
                           var10002 = arg0.N[var90]--;
                           arg0.M[arg0.N[var90]] = arg0.M[arg0.N[var90 - 1] + 16 - 1];
                           --var90;
                        }

                        var10002 = arg0.N[0]--;
                        arg0.M[arg0.N[0]] = var88;
                        if (arg0.N[0] == 0) {
                           int var93 = 4095;

                           for(int var94 = 15; var94 >= 0; --var94) {
                              for(int var95 = 15; var95 >= 0; --var95) {
                                 arg0.M[var93] = arg0.M[arg0.N[var94] + var95];
                                 --var93;
                              }

                              arg0.N[var94] = var93 + 1;
                           }
                        }
                     }

                     ++arg0.D[arg0.L[var88 & 255] & 255];
                     BZip2State.H[var73] = arg0.L[var88 & 255] & 255;
                     ++var73;
                     if (var104 == 0) {
                        ++var67;
                        var104 = 50;
                        byte var96 = arg0.O[var67];
                        var20 = arg0.U[var96];
                        var21 = arg0.R[var96];
                        var23 = arg0.T[var96];
                        var22 = arg0.S[var96];
                     }

                     --var104;
                     int var97 = var20;

                     int var98;
                     byte var99;
                     for(var98 = a(var20, arg0); var98 > var21[var97]; var98 = var98 << 1 | var99) {
                        ++var97;
                        var99 = d(arg0);
                     }

                     var78 = var23[var98 - var22[var97]];
                  } else {
                     int var79 = -1;
                     int var80 = 1;

                     do {
                        if (var78 == 0) {
                           var79 += var80;
                        } else if (var78 == 1) {
                           var79 += var80 * 2;
                        }

                        var80 *= 2;
                        if (var104 == 0) {
                           ++var67;
                           var104 = 50;
                           byte var81 = arg0.O[var67];
                           var20 = arg0.U[var81];
                           var21 = arg0.R[var81];
                           var23 = arg0.T[var81];
                           var22 = arg0.S[var81];
                        }

                        --var104;
                        int var82 = var20;

                        int var83;
                        byte var84;
                        for(var83 = a(var20, arg0); var83 > var21[var82]; var83 = var83 << 1 | var84) {
                           ++var82;
                           var84 = d(arg0);
                        }

                        var78 = var23[var83 - var22[var82]];
                     } while(var78 == 0 || var78 == 1);

                     ++var79;
                     byte var85 = arg0.L[arg0.M[arg0.N[0]] & 255];
                     arg0.D[var85 & 255] += var79;

                     while(var79 > 0) {
                        BZip2State.H[var73] = var85 & 255;
                        ++var73;
                        --var79;
                     }
                  }
               }

               arg0.u = 0;
               arg0.t = 0;
               arg0.F[0] = 0;

               for(int var100 = 1; var100 <= 256; ++var100) {
                  arg0.F[var100] = arg0.D[var100 - 1];
               }

               for(int var101 = 1; var101 <= 256; ++var101) {
                  arg0.F[var101] += arg0.F[var101 - 1];
               }

               for(int var102 = 0; var102 < var73; ++var102) {
                  byte var103 = (byte)(BZip2State.H[var102] & 255);
                  BZip2State.H[arg0.F[var103 & 255]] |= var102 << 8;
                  ++arg0.F[var103 & 255];
               }

               arg0.B = BZip2State.H[arg0.A] >> 8;
               arg0.E = 0;
               arg0.B = BZip2State.H[arg0.B];
               arg0.C = (byte)(arg0.B & 255);
               arg0.B >>= 8;
               ++arg0.E;
               arg0.V = var73;
               a(arg0);
               if (arg0.V + 1 == arg0.E && arg0.u == 0) {
                  var24 = true;
                  break;
               }

               var24 = false;
               break;
            }
         }

         return;
      }
   }

   @ObfuscatedName("QGXYZPKP.c(LANEJWQAX;)B")
   public static byte c(BZip2State arg0) {
      return (byte)a(8, arg0);
   }

   @ObfuscatedName("QGXYZPKP.d(LANEJWQAX;)B")
   public static byte d(BZip2State arg0) {
      return (byte)a(1, arg0);
   }

   @ObfuscatedName("QGXYZPKP.a(ILANEJWQAX;)I")
   public static int a(int arg0, BZip2State arg1) {
      while(arg1.x < arg0) {
         arg1.w = arg1.w << 8 | arg1.j[arg1.k] & 255;
         arg1.x += 8;
         ++arg1.k;
         --arg1.l;
         ++arg1.m;
         if (arg1.m == 0) {
            ++arg1.n;
         }
      }

      int var2 = arg1.w >> arg1.x - arg0 & (1 << arg0) - 1;
      arg1.x -= arg0;
      return var2;
   }

   @ObfuscatedName("QGXYZPKP.e(LANEJWQAX;)V")
   public static void e(BZip2State arg0) {
      arg0.I = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if (arg0.J[var1]) {
            arg0.L[arg0.I] = (byte)var1;
            ++arg0.I;
         }
      }

   }

   @ObfuscatedName("QGXYZPKP.a([I[I[I[BIII)V")
   public static void a(int[] arg0, int[] arg1, int[] arg2, byte[] arg3, int arg4, int arg5, int arg6) {
      int var7 = 0;

      for(int var8 = arg4; var8 <= arg5; ++var8) {
         for(int var9 = 0; var9 < arg6; ++var9) {
            if (arg3[var9] == var8) {
               arg2[var7] = var9;
               ++var7;
            }
         }
      }

      for(int var10 = 0; var10 < 23; ++var10) {
         arg1[var10] = 0;
      }

      for(int var11 = 0; var11 < arg6; ++var11) {
         ++arg1[arg3[var11] + 1];
      }

      for(int var12 = 1; var12 < 23; ++var12) {
         arg1[var12] += arg1[var12 - 1];
      }

      for(int var13 = 0; var13 < 23; ++var13) {
         arg0[var13] = 0;
      }

      int var14 = 0;

      for(int var15 = arg4; var15 <= arg5; ++var15) {
         int var16 = arg1[var15 + 1] - arg1[var15] + var14;
         arg0[var15] = var16 - 1;
         var14 = var16 << 1;
      }

      for(int var17 = arg4 + 1; var17 <= arg5; ++var17) {
         arg1[var17] = (arg0[var17 - 1] + 1 << 1) - arg1[var17];
      }

   }
}
