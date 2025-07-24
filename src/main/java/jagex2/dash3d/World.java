package jagex2.dash3d;

import deob.*;
import jagex2.config.FloType;
import jagex2.config.LocType;
import jagex2.graphics.Pix3D;
import jagex2.io.OnDemand;
import jagex2.io.Packet;

public class World {
   @ObfuscatedName("CHEOPWNH.b")
   public byte b = 0;
   @ObfuscatedName("CHEOPWNH.c")
   public boolean c = true;
   @ObfuscatedName("CHEOPWNH.s")
   public byte s = 0;
   @ObfuscatedName("CHEOPWNH.t")
   public boolean t = true;
   @ObfuscatedName("CHEOPWNH.w")
   public int w = 20411;
   @ObfuscatedName("CHEOPWNH.C")
   public int C = 69;
   @ObfuscatedName("CHEOPWNH.n")
   public int n;
   @ObfuscatedName("CHEOPWNH.o")
   public int o;
   @ObfuscatedName("CHEOPWNH.l")
   public int[][][] l;
   @ObfuscatedName("CHEOPWNH.a")
   public byte[][][] a;
   @ObfuscatedName("CHEOPWNH.v")
   public byte[][][] v;
   @ObfuscatedName("CHEOPWNH.r")
   public byte[][][] r;
   @ObfuscatedName("CHEOPWNH.p")
   public byte[][][] p;
   @ObfuscatedName("CHEOPWNH.e")
   public byte[][][] e;
   @ObfuscatedName("CHEOPWNH.E")
   public int[][][] E;
   @ObfuscatedName("CHEOPWNH.A")
   public byte[][][] A;
   @ObfuscatedName("CHEOPWNH.B")
   public int[][] B;
   @ObfuscatedName("CHEOPWNH.g")
   public int[] g;
   @ObfuscatedName("CHEOPWNH.h")
   public int[] h;
   @ObfuscatedName("CHEOPWNH.i")
   public int[] i;
   @ObfuscatedName("CHEOPWNH.j")
   public int[] j;
   @ObfuscatedName("CHEOPWNH.k")
   public int[] k;
   @ObfuscatedName("CHEOPWNH.d")
   public static int d = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("CHEOPWNH.f")
   public static final int[] f = new int[]{0, -1, 0, 1};
   @ObfuscatedName("CHEOPWNH.m")
   public static int m = 99;
   @ObfuscatedName("CHEOPWNH.q")
   public static byte q = -80;
   @ObfuscatedName("CHEOPWNH.u")
   public static final int[] u = new int[]{1, 2, 4, 8};
   @ObfuscatedName("CHEOPWNH.x")
   public static final int[] x = new int[]{1, 0, -1, 0};
   @ObfuscatedName("CHEOPWNH.z")
   public static int z = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("CHEOPWNH.D")
   public static final int[] D = new int[]{16, 32, 64, 128};
   @ObfuscatedName("CHEOPWNH.F")
   public static boolean lowMemory = true;
   @ObfuscatedName("CHEOPWNH.y")
   public static int levelBuilt;

   @ObfuscatedName("CHEOPWNH.a(III)I")
   public static final int a(int arg0, int arg1, int arg2) {
      int var3 = arg0 / arg2;
      int var4 = arg0 & arg2 - 1;
      int var5 = arg1 / arg2;
      int var6 = arg1 & arg2 - 1;
      int var7 = c(var3, var5);
      int var8 = c(var3 + 1, var5);
      int var9 = c(var3, var5 + 1);
      int var10 = c(var3 + 1, var5 + 1);
      int var11 = b(var7, var8, var4, arg2);
      int var12 = b(var9, var10, var4, arg2);
      return b(var11, var12, var6, arg2);
   }

   @ObfuscatedName("CHEOPWNH.a(IIIB)I")
   public int a(int arg0, int arg1, int arg2, byte arg3) {
      if (this.s == arg3) {
         boolean var5 = false;
         if ((this.a[arg1][arg2][arg0] & 8) != 0) {
            return 0;
         } else {
            return arg1 > 0 && (this.a[1][arg2][arg0] & 2) != 0 ? arg1 - 1 : arg1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("CHEOPWNH.a(IIIILXRENONSA;IIIILKJCMXHNO;[[[I)V")
   public static final void a(int arg0, int arg1, int arg2, int arg3, CollisionMap arg4, int arg5, int arg6, int arg7, int arg8, World3D arg9, int[][][] arg10) {
      int var11 = arg10[arg1][arg6][arg3];
      int var12 = arg10[arg1][arg6 + 1][arg3];
      int var13 = arg10[arg1][arg6 + 1][arg3 + 1];
      int var14 = arg10[arg1][arg6][arg3 + 1];
      int var15 = var11 + var12 + var13 + var14 >> 2;
      LocType var16 = LocType.a(arg0);
      if (arg7 == 0) {
         int var17 = (arg0 << 14) + (arg3 << 7) + arg6 + 1073741824;
         if (!var16.b) {
            var17 += Integer.MIN_VALUE;
         }

         byte var18 = (byte)((arg5 << 6) + arg2);
         if (arg2 == 22) {
            ModelSource var19;
            if (var16.T == -1 && var16.V == null) {
               var19 = var16.a(22, arg5, var11, var12, var13, var14, -1);
            } else {
               var19 = new ClientLocAnim(var16.T, var13, var14, var12, 22, (byte)3, arg0, true, var11, arg5);
            }

            arg9.a(arg6, arg3, 669, var18, var17, var15, arg8, var19);
            if (var16.ab && var16.b) {
               arg4.a(8, (int)arg3, arg6);
            }

         } else if (arg2 != 10 && arg2 != 11) {
            if (arg2 >= 12) {
               ModelSource var24;
               if (var16.T == -1 && var16.V == null) {
                  var24 = var16.a(arg2, arg5, var11, var12, var13, var14, -1);
               } else {
                  var24 = new ClientLocAnim(var16.T, var13, var14, var12, arg2, (byte)3, arg0, true, var11, arg5);
               }

               arg9.a(arg8, 1, arg3, var24, var18, 0, arg6, -896, 1, var15, var17);
               if (var16.ab) {
                  arg4.a(arg3, arg5, var16.r, var16.R, var16.Z, arg6, (byte)52);
               }

            } else if (arg2 == 0) {
               ModelSource var25;
               if (var16.T == -1 && var16.V == null) {
                  var25 = var16.a(0, arg5, var11, var12, var13, var14, -1);
               } else {
                  var25 = new ClientLocAnim(var16.T, var13, var14, var12, 0, (byte)3, arg0, true, var11, arg5);
               }

               arg9.a(var15, 49878, 0, u[arg5], (ModelSource)null, arg6, var17, var18, arg3, var25, arg8);
               if (var16.ab) {
                  arg4.a(arg5, 37679, var16.Z, arg2, arg6, arg3);
               }

            } else if (arg2 == 1) {
               ModelSource var26;
               if (var16.T == -1 && var16.V == null) {
                  var26 = var16.a(1, arg5, var11, var12, var13, var14, -1);
               } else {
                  var26 = new ClientLocAnim(var16.T, var13, var14, var12, 1, (byte)3, arg0, true, var11, arg5);
               }

               arg9.a(var15, 49878, 0, D[arg5], (ModelSource)null, arg6, var17, var18, arg3, var26, arg8);
               if (var16.ab) {
                  arg4.a(arg5, 37679, var16.Z, arg2, arg6, arg3);
               }

            } else if (arg2 == 2) {
               int var27 = arg5 + 1 & 3;
               ModelSource var28;
               ModelSource var29;
               if (var16.T == -1 && var16.V == null) {
                  var28 = var16.a(2, arg5 + 4, var11, var12, var13, var14, -1);
                  var29 = var16.a(2, var27, var11, var12, var13, var14, -1);
               } else {
                  var28 = new ClientLocAnim(var16.T, var13, var14, var12, 2, (byte)3, arg0, true, var11, arg5 + 4);
                  var29 = new ClientLocAnim(var16.T, var13, var14, var12, 2, (byte)3, arg0, true, var11, var27);
               }

               arg9.a(var15, 49878, u[var27], u[arg5], var29, arg6, var17, var18, arg3, var28, arg8);
               if (var16.ab) {
                  arg4.a(arg5, 37679, var16.Z, arg2, arg6, arg3);
               }

            } else if (arg2 == 3) {
               ModelSource var30;
               if (var16.T == -1 && var16.V == null) {
                  var30 = var16.a(3, arg5, var11, var12, var13, var14, -1);
               } else {
                  var30 = new ClientLocAnim(var16.T, var13, var14, var12, 3, (byte)3, arg0, true, var11, arg5);
               }

               arg9.a(var15, 49878, 0, D[arg5], (ModelSource)null, arg6, var17, var18, arg3, var30, arg8);
               if (var16.ab) {
                  arg4.a(arg5, 37679, var16.Z, arg2, arg6, arg3);
               }

            } else if (arg2 == 9) {
               ModelSource var31;
               if (var16.T == -1 && var16.V == null) {
                  var31 = var16.a(arg2, arg5, var11, var12, var13, var14, -1);
               } else {
                  var31 = new ClientLocAnim(var16.T, var13, var14, var12, arg2, (byte)3, arg0, true, var11, arg5);
               }

               arg9.a(arg8, 1, arg3, var31, var18, 0, arg6, -896, 1, var15, var17);
               if (var16.ab) {
                  arg4.a(arg3, arg5, var16.r, var16.R, var16.Z, arg6, (byte)52);
               }

            } else {
               if (var16.l) {
                  if (arg5 == 1) {
                     int var32 = var14;
                     var14 = var13;
                     var13 = var12;
                     var12 = var11;
                     var11 = var32;
                  } else if (arg5 == 2) {
                     int var33 = var14;
                     var14 = var12;
                     var12 = var33;
                     int var34 = var13;
                     var13 = var11;
                     var11 = var34;
                  } else if (arg5 == 3) {
                     int var35 = var14;
                     var14 = var11;
                     var11 = var12;
                     var12 = var13;
                     var13 = var35;
                  }
               }

               if (arg2 == 4) {
                  ModelSource var36;
                  if (var16.T == -1 && var16.V == null) {
                     var36 = var16.a(4, 0, var11, var12, var13, var14, -1);
                  } else {
                     var36 = new ClientLocAnim(var16.T, var13, var14, var12, 4, (byte)3, arg0, true, var11, 0);
                  }

                  arg9.a(arg8, u[arg5], arg5 * 512, var17, var18, arg6, 0, arg3, 0, var15, var36, -930);
               } else if (arg2 == 5) {
                  int var37 = 16;
                  int var38 = arg9.b(arg8, arg6, arg3);
                  if (var38 > 0) {
                     var37 = LocType.a(var38 >> 14 & 32767).S;
                  }

                  ModelSource var39;
                  if (var16.T == -1 && var16.V == null) {
                     var39 = var16.a(4, 0, var11, var12, var13, var14, -1);
                  } else {
                     var39 = new ClientLocAnim(var16.T, var13, var14, var12, 4, (byte)3, arg0, true, var11, 0);
                  }

                  arg9.a(arg8, u[arg5], arg5 * 512, var17, var18, arg6, f[arg5] * var37, arg3, x[arg5] * var37, var15, var39, -930);
               } else if (arg2 == 6) {
                  ModelSource var40;
                  if (var16.T == -1 && var16.V == null) {
                     var40 = var16.a(4, 0, var11, var12, var13, var14, -1);
                  } else {
                     var40 = new ClientLocAnim(var16.T, var13, var14, var12, 4, (byte)3, arg0, true, var11, 0);
                  }

                  arg9.a(arg8, 256, arg5, var17, var18, arg6, 0, arg3, 0, var15, var40, -930);
               } else if (arg2 == 7) {
                  ModelSource var41;
                  if (var16.T == -1 && var16.V == null) {
                     var41 = var16.a(4, 0, var11, var12, var13, var14, -1);
                  } else {
                     var41 = new ClientLocAnim(var16.T, var13, var14, var12, 4, (byte)3, arg0, true, var11, 0);
                  }

                  arg9.a(arg8, 512, arg5, var17, var18, arg6, 0, arg3, 0, var15, var41, -930);
               } else if (arg2 == 8) {
                  ModelSource var42;
                  if (var16.T == -1 && var16.V == null) {
                     var42 = var16.a(4, 0, var11, var12, var13, var14, -1);
                  } else {
                     var42 = new ClientLocAnim(var16.T, var13, var14, var12, 4, (byte)3, arg0, true, var11, 0);
                  }

                  arg9.a(arg8, 768, arg5, var17, var18, arg6, 0, arg3, 0, var15, var42, -930);
               }
            }
         } else {
            ModelSource var20;
            if (var16.T == -1 && var16.V == null) {
               var20 = var16.a(10, arg5, var11, var12, var13, var14, -1);
            } else {
               var20 = new ClientLocAnim(var16.T, var13, var14, var12, 10, (byte)3, arg0, true, var11, arg5);
            }

            if (var20 != null) {
               int var21 = 0;
               if (arg2 == 11) {
                  var21 += 256;
               }

               int var22;
               int var23;
               if (arg5 != 1 && arg5 != 3) {
                  var22 = var16.R;
                  var23 = var16.r;
               } else {
                  var22 = var16.r;
                  var23 = var16.R;
               }

               arg9.a(arg8, var22, arg3, var20, var18, var21, arg6, -896, var23, var15, var17);
            }

            if (var16.ab) {
               arg4.a(arg3, arg5, var16.r, var16.R, var16.Z, arg6, (byte)52);
            }

         }
      }
   }

   @ObfuscatedName("CHEOPWNH.a(IIII)V")
   public final void a(int arg0, int arg1, int arg2, int arg3) {
      if (this.w == arg0) {
         for(int var5 = 0; var5 < 8; ++var5) {
            for(int var6 = 0; var6 < 8; ++var6) {
               this.l[arg1][arg3 + var5][arg2 + var6] = 0;
            }
         }

         if (arg3 > 0) {
            for(int var7 = 1; var7 < 8; ++var7) {
               this.l[arg1][arg3][arg2 + var7] = this.l[arg1][arg3 - 1][arg2 + var7];
            }
         }

         if (arg2 > 0) {
            for(int var8 = 1; var8 < 8; ++var8) {
               this.l[arg1][arg3 + var8][arg2] = this.l[arg1][arg3 + var8][arg2 - 1];
            }
         }

         if (arg3 > 0 && this.l[arg1][arg3 - 1][arg2] != 0) {
            this.l[arg1][arg3][arg2] = this.l[arg1][arg3 - 1][arg2];
         } else if (arg2 > 0 && this.l[arg1][arg3][arg2 - 1] != 0) {
            this.l[arg1][arg3][arg2] = this.l[arg1][arg3][arg2 - 1];
         } else if (arg3 > 0 && arg2 > 0 && this.l[arg1][arg3 - 1][arg2 - 1] != 0) {
            this.l[arg1][arg3][arg2] = this.l[arg1][arg3 - 1][arg2 - 1];
         }
      }
   }

   @ObfuscatedName("CHEOPWNH.a([LXRENONSA;ILKJCMXHNO;)V")
   public final void a(CollisionMap[] arg0, int arg1, World3D arg2) {
      for(int var4 = 0; var4 < 4; ++var4) {
         for(int var5 = 0; var5 < 104; ++var5) {
            for(int var6 = 0; var6 < 104; ++var6) {
               if ((this.a[var4][var5][var6] & 1) == 1) {
                  int var7 = var4;
                  if ((this.a[1][var5][var6] & 2) == 2) {
                     var7 = var4 - 1;
                  }

                  if (var7 >= 0) {
                     arg0[var7].a(8, (int)var6, var5);
                  }
               }
            }
         }
      }

      d += (int)(Math.random() * 5.0D) - 2;
      if (d < -8) {
         d = -8;
      }

      if (d > 8) {
         d = 8;
      }

      z += (int)(Math.random() * 5.0D) - 2;
      if (z < -16) {
         z = -16;
      }

      if (z > 16) {
         z = 16;
      }

      for(int var8 = 0; var8 < 4; ++var8) {
         byte[][] var9 = this.A[var8];
         byte var10 = 96;
         short var11 = 768;
         byte var12 = -50;
         byte var13 = -10;
         byte var14 = -50;
         int var15 = (int)Math.sqrt((double)(var14 * var14 + var12 * var12 + var13 * var13));
         int var16 = var11 * var15 >> 8;

         for(int var17 = 1; var17 < this.o - 1; ++var17) {
            for(int var18 = 1; var18 < this.n - 1; ++var18) {
               int var19 = this.l[var8][var18 + 1][var17] - this.l[var8][var18 - 1][var17];
               int var20 = this.l[var8][var18][var17 + 1] - this.l[var8][var18][var17 - 1];
               int var21 = (int)Math.sqrt((double)(var20 * var20 + var19 * var19 + 65536));
               int var22 = (var19 << 8) / var21;
               int var23 = 65536 / var21;
               int var24 = (var20 << 8) / var21;
               int var25 = (var14 * var24 + var12 * var22 + var13 * var23) / var16 + var10;
               int var26 = (var9[var18][var17] >> 1) + (var9[var18][var17 + 1] >> 3) + (var9[var18][var17 - 1] >> 2) + (var9[var18 - 1][var17] >> 2) + (var9[var18 + 1][var17] >> 3);
               this.B[var18][var17] = var25 - var26;
            }
         }

         for(int var27 = 0; var27 < this.o; ++var27) {
            this.g[var27] = 0;
            this.h[var27] = 0;
            this.i[var27] = 0;
            this.j[var27] = 0;
            this.k[var27] = 0;
         }

         for(int var28 = -5; var28 < this.n + 5; ++var28) {
            for(int var29 = 0; var29 < this.o; ++var29) {
               int var30 = var28 + 5;
               int var10002;
               if (var30 >= 0 && var30 < this.n) {
                  int var31 = this.v[var8][var30][var29] & 255;
                  if (var31 > 0) {
                     FloType var32 = FloType.e[var31 - 1];
                     this.g[var29] += var32.n;
                     this.h[var29] += var32.l;
                     this.i[var29] += var32.m;
                     this.j[var29] += var32.o;
                     var10002 = this.k[var29]++;
                  }
               }

               int var33 = var28 - 5;
               if (var33 >= 0 && var33 < this.n) {
                  int var34 = this.v[var8][var33][var29] & 255;
                  if (var34 > 0) {
                     FloType var35 = FloType.e[var34 - 1];
                     this.g[var29] -= var35.n;
                     this.h[var29] -= var35.l;
                     this.i[var29] -= var35.m;
                     this.j[var29] -= var35.o;
                     var10002 = this.k[var29]--;
                  }
               }
            }

            if (var28 >= 1 && var28 < this.n - 1) {
               int var36 = 0;
               int var37 = 0;
               int var38 = 0;
               int var39 = 0;
               int var40 = 0;

               for(int var41 = -5; var41 < this.o + 5; ++var41) {
                  int var42 = var41 + 5;
                  if (var42 >= 0 && var42 < this.o) {
                     var36 += this.g[var42];
                     var37 += this.h[var42];
                     var38 += this.i[var42];
                     var39 += this.j[var42];
                     var40 += this.k[var42];
                  }

                  int var43 = var41 - 5;
                  if (var43 >= 0 && var43 < this.o) {
                     var36 -= this.g[var43];
                     var37 -= this.h[var43];
                     var38 -= this.i[var43];
                     var39 -= this.j[var43];
                     var40 -= this.k[var43];
                  }

                  if (var41 >= 1 && var41 < this.o - 1 && (!lowMemory || (this.a[0][var28][var41] & 2) != 0 || (this.a[var8][var28][var41] & 16) == 0 && this.a(var41, var8, var28, (byte)0) == levelBuilt)) {
                     if (var8 < m) {
                        m = var8;
                     }

                     int var44 = this.v[var8][var28][var41] & 255;
                     int var45 = this.r[var8][var28][var41] & 255;
                     if (var44 > 0 || var45 > 0) {
                        int var46 = this.l[var8][var28][var41];
                        int var47 = this.l[var8][var28 + 1][var41];
                        int var48 = this.l[var8][var28 + 1][var41 + 1];
                        int var49 = this.l[var8][var28][var41 + 1];
                        int var50 = this.B[var28][var41];
                        int var51 = this.B[var28 + 1][var41];
                        int var52 = this.B[var28 + 1][var41 + 1];
                        int var53 = this.B[var28][var41 + 1];
                        int var54 = -1;
                        int var55 = -1;
                        if (var44 > 0) {
                           int var56 = var36 * 256 / var39;
                           int var57 = var37 / var40;
                           int var58 = var38 / var40;
                           var54 = this.b(var56, var57, var58);
                           int var59 = d + var56 & 255;
                           int var60 = z + var58;
                           if (var60 < 0) {
                              var60 = 0;
                           } else if (var60 > 255) {
                              var60 = 255;
                           }

                           var55 = this.b(var59, var57, var60);
                        }

                        if (var8 > 0) {
                           boolean var61 = true;
                           if (var44 == 0 && this.p[var8][var28][var41] != 0) {
                              var61 = false;
                           }

                           if (var45 > 0 && !FloType.e[var45 - 1].j) {
                              var61 = false;
                           }

                           if (var61 && var46 == var47 && var46 == var48 && var46 == var49) {
                              this.E[var8][var28][var41] |= 2340;
                           }
                        }

                        int var62 = 0;
                        if (var54 != -1) {
                           var62 = Pix3D.U[a(var55, 96)];
                        }

                        if (var45 == 0) {
                           arg2.a(var8, var28, var41, 0, 0, -1, var46, var47, var48, var49, a(var54, var50), a(var54, var51), a(var54, var52), a(var54, var53), 0, 0, 0, 0, var62, 0);
                        } else {
                           int var63 = this.p[var8][var28][var41] + 1;
                           byte var64 = this.e[var8][var28][var41];
                           FloType var65 = FloType.e[var45 - 1];
                           int var66 = var65.h;
                           int var67;
                           int var68;
                           if (var66 >= 0) {
                              var67 = Pix3D.a((int)var66, 0);
                              var68 = -1;
                           } else if (var65.g == 16711935) {
                              var68 = -2;
                              var66 = -1;
                              var67 = Pix3D.U[this.d(var65.p, 96)];
                           } else {
                              var68 = this.b(var65.k, var65.l, var65.m);
                              var67 = Pix3D.U[this.d(var65.p, 96)];
                           }

                           arg2.a(var8, var28, var41, var63, var64, var66, var46, var47, var48, var49, a(var54, var50), a(var54, var51), a(var54, var52), a(var54, var53), this.d(var68, var50), this.d(var68, var51), this.d(var68, var52), this.d(var68, var53), var62, var67);
                        }
                     }
                  }
               }
            }
         }

         for(int var69 = 1; var69 < this.o - 1; ++var69) {
            for(int var70 = 1; var70 < this.n - 1; ++var70) {
               arg2.a(var8, var70, var69, this.a(var69, var8, var70, (byte)0));
            }
         }
      }

      arg2.a((byte)2, (int)-10, -50, -50);

      for(int var71 = 0; var71 < this.n; ++var71) {
         for(int var72 = 0; var72 < this.o; ++var72) {
            if ((this.a[1][var71][var72] & 2) == 2) {
               arg2.a(true, var71, var72);
            }
         }
      }

      if (arg1 <= 0) {
         this.w = 313;
      }

      int var73 = 1;
      int var74 = 2;
      int var75 = 4;

      for(int var76 = 0; var76 < 4; ++var76) {
         if (var76 > 0) {
            var73 <<= 3;
            var74 <<= 3;
            var75 <<= 3;
         }

         for(int var77 = 0; var77 <= var76; ++var77) {
            for(int var78 = 0; var78 <= this.o; ++var78) {
               for(int var79 = 0; var79 <= this.n; ++var79) {
                  if ((this.E[var77][var79][var78] & var73) != 0) {
                     int var80 = var78;
                     int var81 = var78;
                     int var82 = var77;
                     int var83 = var77;

                     while(var80 > 0 && (this.E[var77][var79][var80 - 1] & var73) != 0) {
                        --var80;
                     }

                     while(var81 < this.o && (this.E[var77][var79][var81 + 1] & var73) != 0) {
                        ++var81;
                     }

                     label329:
                     while(var82 > 0) {
                        for(int var84 = var80; var84 <= var81; ++var84) {
                           if ((this.E[var82 - 1][var79][var84] & var73) == 0) {
                              break label329;
                           }
                        }

                        --var82;
                     }

                     label318:
                     while(var83 < var76) {
                        for(int var85 = var80; var85 <= var81; ++var85) {
                           if ((this.E[var83 + 1][var79][var85] & var73) == 0) {
                              break label318;
                           }
                        }

                        ++var83;
                     }

                     int var86 = (var83 + 1 - var82) * (var81 - var80 + 1);
                     if (var86 >= 8) {
                        short var87 = 240;
                        int var88 = this.l[var83][var79][var80] - var87;
                        int var89 = this.l[var82][var79][var80];
                        World3D.a(-8967, var79 * 128, var89, var79 * 128, var81 * 128 + 128, var76, var80 * 128, var88, 1);

                        for(int var90 = var82; var90 <= var83; ++var90) {
                           for(int var91 = var80; var91 <= var81; ++var91) {
                              this.E[var90][var79][var91] &= ~var73;
                           }
                        }
                     }
                  }

                  if ((this.E[var77][var79][var78] & var74) != 0) {
                     int var92 = var79;
                     int var93 = var79;
                     int var94 = var77;
                     int var95 = var77;

                     while(var92 > 0 && (this.E[var77][var92 - 1][var78] & var74) != 0) {
                        --var92;
                     }

                     while(var93 < this.n && (this.E[var77][var93 + 1][var78] & var74) != 0) {
                        ++var93;
                     }

                     label382:
                     while(var94 > 0) {
                        for(int var96 = var92; var96 <= var93; ++var96) {
                           if ((this.E[var94 - 1][var96][var78] & var74) == 0) {
                              break label382;
                           }
                        }

                        --var94;
                     }

                     label371:
                     while(var95 < var76) {
                        for(int var97 = var92; var97 <= var93; ++var97) {
                           if ((this.E[var95 + 1][var97][var78] & var74) == 0) {
                              break label371;
                           }
                        }

                        ++var95;
                     }

                     int var98 = (var95 + 1 - var94) * (var93 - var92 + 1);
                     if (var98 >= 8) {
                        short var99 = 240;
                        int var100 = this.l[var95][var92][var78] - var99;
                        int var101 = this.l[var94][var92][var78];
                        World3D.a(-8967, var92 * 128, var101, var93 * 128 + 128, var78 * 128, var76, var78 * 128, var100, 2);

                        for(int var102 = var94; var102 <= var95; ++var102) {
                           for(int var103 = var92; var103 <= var93; ++var103) {
                              this.E[var102][var103][var78] &= ~var74;
                           }
                        }
                     }
                  }

                  if ((this.E[var77][var79][var78] & var75) != 0) {
                     int var104 = var79;
                     int var105 = var79;
                     int var106 = var78;
                     int var107 = var78;

                     while(var106 > 0 && (this.E[var77][var79][var106 - 1] & var75) != 0) {
                        --var106;
                     }

                     while(var107 < this.o && (this.E[var77][var79][var107 + 1] & var75) != 0) {
                        ++var107;
                     }

                     label435:
                     while(var104 > 0) {
                        for(int var108 = var106; var108 <= var107; ++var108) {
                           if ((this.E[var77][var104 - 1][var108] & var75) == 0) {
                              break label435;
                           }
                        }

                        --var104;
                     }

                     label424:
                     while(var105 < this.n) {
                        for(int var109 = var106; var109 <= var107; ++var109) {
                           if ((this.E[var77][var105 + 1][var109] & var75) == 0) {
                              break label424;
                           }
                        }

                        ++var105;
                     }

                     if ((var105 - var104 + 1) * (var107 - var106 + 1) >= 4) {
                        int var110 = this.l[var77][var104][var106];
                        World3D.a(-8967, var104 * 128, var110, var105 * 128 + 128, var107 * 128 + 128, var76, var106 * 128, var110, 4);

                        for(int var111 = var104; var111 <= var105; ++var111) {
                           for(int var112 = var106; var112 <= var107; ++var112) {
                              this.E[var77][var111][var112] &= ~var75;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("CHEOPWNH.a(IIZ[BIII[LXRENONSA;II)V")
   public final void a(int arg0, int arg1, boolean arg2, byte[] arg3, int arg4, int arg5, int arg6, CollisionMap[] arg7, int arg8, int arg9) {
      if (arg2) {
         this.C = 476;
      }

      for(int var11 = 0; var11 < 8; ++var11) {
         for(int var12 = 0; var12 < 8; ++var12) {
            if (arg6 + var11 > 0 && arg6 + var11 < 103 && arg8 + var12 > 0 && arg8 + var12 < 103) {
               arg7[arg4].j[arg6 + var11][arg8 + var12] &= -16777217;
            }
         }
      }

      Packet var13 = new Packet(arg3);

      for(int var14 = 0; var14 < 4; ++var14) {
         for(int var15 = 0; var15 < 64; ++var15) {
            for(int var16 = 0; var16 < 64; ++var16) {
               if (arg5 == var14 && var15 >= arg9 && var15 < arg9 + 8 && var16 >= arg1 && var16 < arg1 + 8) {
                  this.a(0, (byte)-61, 0, var13, arg0, arg6 + WorldRegion.a((byte)7, arg0, var15 & 7, (int)(var16 & 7)), arg4, arg8 + WorldRegion.a((int)(var16 & 7), var15 & 7, arg0, (byte)5));
               } else {
                  this.a(0, (byte)-61, 0, var13, 0, -1, 0, -1);
               }
            }
         }
      }

   }

   @ObfuscatedName("CHEOPWNH.a(LZPGPWCCV;LMFMVIYHT;B)V")
   public static final void prefetchLocs(OnDemand arg0, Packet arg1, byte arg2) {
      if (arg2 == -3) {
         int var3 = -1;

         while(true) {
            int var4 = arg1.gsmarts();
            if (var4 == 0) {
               return;
            }

            var3 += var4;
            LocType var5 = LocType.a(var3);
            var5.a(arg0, -747);

            while(true) {
               int var6 = arg1.gsmarts();
               if (var6 == 0) {
                  break;
               }

               arg1.g1();
            }
         }
      }
   }

   @ObfuscatedName("CHEOPWNH.a(IBI)Z")
   public static final boolean a(int arg0, byte arg1, int arg2) {
      LocType var3 = LocType.a(arg2);
      if (q != arg1) {
         for(int var4 = 1; var4 > 0; ++var4) {
         }
      }

      if (arg0 == 11) {
         arg0 = 10;
      }

      if (arg0 >= 5 && arg0 <= 8) {
         arg0 = 4;
      }

      return var3.a(26261, arg0);
   }

   @ObfuscatedName("CHEOPWNH.a(II)I")
   public static final int a(int arg0, int arg1) {
      if (arg0 == -1) {
         return 12345678;
      } else {
         int var2 = (arg0 & 127) * arg1 / 128;
         if (var2 < 2) {
            var2 = 2;
         } else if (var2 > 126) {
            var2 = 126;
         }

         return (arg0 & 65408) + var2;
      }
   }

   @ObfuscatedName("CHEOPWNH.a(I[LXRENONSA;LKJCMXHNO;Z[BIIIIII)V")
   public final void a(int arg0, CollisionMap[] arg1, World3D arg2, boolean arg3, byte[] arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
      Packet var12 = new Packet(arg4);
      if (!arg3) {
         int var13 = -1;

         while(true) {
            int var14 = var12.gsmarts();
            if (var14 == 0) {
               return;
            }

            var13 += var14;
            int var15 = 0;

            while(true) {
               int var16 = var12.gsmarts();
               if (var16 == 0) {
                  break;
               }

               var15 += var16 - 1;
               int var17 = var15 & 63;
               int var18 = var15 >> 6 & 63;
               int var19 = var15 >> 12;
               int var20 = var12.g1();
               int var21 = var20 >> 2;
               int var22 = var20 & 3;
               if (arg10 == var19 && var18 >= arg7 && var18 < arg7 + 8 && var17 >= arg9 && var17 < arg9 + 8) {
                  LocType var23 = LocType.a(var13);
                  int var24 = arg8 + WorldRegion.a(arg6, var23.r, var22, var18 & 7, (byte)-117, var23.R, var17 & 7);
                  int var25 = arg5 + WorldRegion.a(var23.R, arg6, 671, var18 & 7, (int)(var17 & 7), var23.r, var22);
                  if (var24 > 0 && var25 > 0 && var24 < 103 && var25 < 103) {
                     int var26 = arg0;
                     if ((this.a[1][var24][var25] & 2) == 2) {
                        var26 = arg0 - 1;
                     }

                     CollisionMap var27 = null;
                     if (var26 >= 0) {
                        var27 = arg1[var26];
                     }

                     this.a(arg2, var27, var25, arg0, var24, this.b, arg6 + var22 & 3, var21, var13);
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("CHEOPWNH.a(LKJCMXHNO;LXRENONSA;IIIBIII)V")
   public final void a(World3D arg0, CollisionMap arg1, int arg2, int arg3, int arg4, byte arg5, int arg6, int arg7, int arg8) {
      if (lowMemory && (this.a[0][arg4][arg2] & 2) == 0) {
         if ((this.a[arg3][arg4][arg2] & 16) != 0) {
            return;
         }

         if (this.a(arg2, arg3, arg4, (byte)0) != levelBuilt) {
            return;
         }
      }

      if (arg3 < m) {
         m = arg3;
      }

      int var10 = this.l[arg3][arg4][arg2];
      int var11 = this.l[arg3][arg4 + 1][arg2];
      int var12 = this.l[arg3][arg4 + 1][arg2 + 1];
      int var13 = this.l[arg3][arg4][arg2 + 1];
      int var14 = var10 + var11 + var12 + var13 >> 2;
      LocType var15 = LocType.a(arg8);
      int var16 = (arg8 << 14) + (arg2 << 7) + arg4 + 1073741824;
      if (arg5 != 0) {
         this.t = !this.t;
      }

      if (!var15.b) {
         var16 += Integer.MIN_VALUE;
      }

      byte var17 = (byte)((arg6 << 6) + arg7);
      if (arg7 == 22) {
         if (!lowMemory || var15.b || var15.h) {
            ModelSource var18;
            if (var15.T == -1 && var15.V == null) {
               var18 = var15.a(22, arg6, var10, var11, var12, var13, -1);
            } else {
               var18 = new ClientLocAnim(var15.T, var12, var13, var11, 22, (byte)3, arg8, true, var10, arg6);
            }

            arg0.a(arg4, arg2, 669, var17, var16, var14, arg3, var18);
            if (var15.ab && var15.b && arg1 != null) {
               arg1.a(8, (int)arg2, arg4);
            }

         }
      } else if (arg7 != 10 && arg7 != 11) {
         if (arg7 >= 12) {
            ModelSource var27;
            if (var15.T == -1 && var15.V == null) {
               var27 = var15.a(arg7, arg6, var10, var11, var12, var13, -1);
            } else {
               var27 = new ClientLocAnim(var15.T, var12, var13, var11, arg7, (byte)3, arg8, true, var10, arg6);
            }

            arg0.a(arg3, 1, arg2, var27, var17, 0, arg4, -896, 1, var14, var16);
            if (arg7 >= 12 && arg7 <= 17 && arg7 != 13 && arg3 > 0) {
               this.E[arg3][arg4][arg2] |= 2340;
            }

            if (var15.ab && arg1 != null) {
               arg1.a(arg2, arg6, var15.r, var15.R, var15.Z, arg4, (byte)52);
            }

         } else if (arg7 == 0) {
            ModelSource var28;
            if (var15.T == -1 && var15.V == null) {
               var28 = var15.a(0, arg6, var10, var11, var12, var13, -1);
            } else {
               var28 = new ClientLocAnim(var15.T, var12, var13, var11, 0, (byte)3, arg8, true, var10, arg6);
            }

            arg0.a(var14, 49878, 0, u[arg6], (ModelSource)null, arg4, var16, var17, arg2, var28, arg3);
            if (arg6 == 0) {
               if (var15.X) {
                  this.A[arg3][arg4][arg2] = 50;
                  this.A[arg3][arg4][arg2 + 1] = 50;
               }

               if (var15.N) {
                  this.E[arg3][arg4][arg2] |= 585;
               }
            } else if (arg6 == 1) {
               if (var15.X) {
                  this.A[arg3][arg4][arg2 + 1] = 50;
                  this.A[arg3][arg4 + 1][arg2 + 1] = 50;
               }

               if (var15.N) {
                  this.E[arg3][arg4][arg2 + 1] |= 1170;
               }
            } else if (arg6 == 2) {
               if (var15.X) {
                  this.A[arg3][arg4 + 1][arg2] = 50;
                  this.A[arg3][arg4 + 1][arg2 + 1] = 50;
               }

               if (var15.N) {
                  this.E[arg3][arg4 + 1][arg2] |= 585;
               }
            } else if (arg6 == 3) {
               if (var15.X) {
                  this.A[arg3][arg4][arg2] = 50;
                  this.A[arg3][arg4 + 1][arg2] = 50;
               }

               if (var15.N) {
                  this.E[arg3][arg4][arg2] |= 1170;
               }
            }

            if (var15.ab && arg1 != null) {
               arg1.a(arg6, 37679, var15.Z, arg7, arg4, arg2);
            }

            if (var15.S != 16) {
               arg0.a(arg2, var15.S, arg3, arg4, 0);
            }

         } else if (arg7 == 1) {
            ModelSource var29;
            if (var15.T == -1 && var15.V == null) {
               var29 = var15.a(1, arg6, var10, var11, var12, var13, -1);
            } else {
               var29 = new ClientLocAnim(var15.T, var12, var13, var11, 1, (byte)3, arg8, true, var10, arg6);
            }

            arg0.a(var14, 49878, 0, D[arg6], (ModelSource)null, arg4, var16, var17, arg2, var29, arg3);
            if (var15.X) {
               if (arg6 == 0) {
                  this.A[arg3][arg4][arg2 + 1] = 50;
               } else if (arg6 == 1) {
                  this.A[arg3][arg4 + 1][arg2 + 1] = 50;
               } else if (arg6 == 2) {
                  this.A[arg3][arg4 + 1][arg2] = 50;
               } else if (arg6 == 3) {
                  this.A[arg3][arg4][arg2] = 50;
               }
            }

            if (var15.ab && arg1 != null) {
               arg1.a(arg6, 37679, var15.Z, arg7, arg4, arg2);
            }

         } else if (arg7 == 2) {
            int var30 = arg6 + 1 & 3;
            ModelSource var31;
            ModelSource var32;
            if (var15.T == -1 && var15.V == null) {
               var31 = var15.a(2, arg6 + 4, var10, var11, var12, var13, -1);
               var32 = var15.a(2, var30, var10, var11, var12, var13, -1);
            } else {
               var31 = new ClientLocAnim(var15.T, var12, var13, var11, 2, (byte)3, arg8, true, var10, arg6 + 4);
               var32 = new ClientLocAnim(var15.T, var12, var13, var11, 2, (byte)3, arg8, true, var10, var30);
            }

            arg0.a(var14, 49878, u[var30], u[arg6], var32, arg4, var16, var17, arg2, var31, arg3);
            if (var15.N) {
               if (arg6 == 0) {
                  this.E[arg3][arg4][arg2] |= 585;
                  this.E[arg3][arg4][arg2 + 1] |= 1170;
               } else if (arg6 == 1) {
                  this.E[arg3][arg4][arg2 + 1] |= 1170;
                  this.E[arg3][arg4 + 1][arg2] |= 585;
               } else if (arg6 == 2) {
                  this.E[arg3][arg4 + 1][arg2] |= 585;
                  this.E[arg3][arg4][arg2] |= 1170;
               } else if (arg6 == 3) {
                  this.E[arg3][arg4][arg2] |= 1170;
                  this.E[arg3][arg4][arg2] |= 585;
               }
            }

            if (var15.ab && arg1 != null) {
               arg1.a(arg6, 37679, var15.Z, arg7, arg4, arg2);
            }

            if (var15.S != 16) {
               arg0.a(arg2, var15.S, arg3, arg4, 0);
            }

         } else if (arg7 == 3) {
            ModelSource var33;
            if (var15.T == -1 && var15.V == null) {
               var33 = var15.a(3, arg6, var10, var11, var12, var13, -1);
            } else {
               var33 = new ClientLocAnim(var15.T, var12, var13, var11, 3, (byte)3, arg8, true, var10, arg6);
            }

            arg0.a(var14, 49878, 0, D[arg6], (ModelSource)null, arg4, var16, var17, arg2, var33, arg3);
            if (var15.X) {
               if (arg6 == 0) {
                  this.A[arg3][arg4][arg2 + 1] = 50;
               } else if (arg6 == 1) {
                  this.A[arg3][arg4 + 1][arg2 + 1] = 50;
               } else if (arg6 == 2) {
                  this.A[arg3][arg4 + 1][arg2] = 50;
               } else if (arg6 == 3) {
                  this.A[arg3][arg4][arg2] = 50;
               }
            }

            if (var15.ab && arg1 != null) {
               arg1.a(arg6, 37679, var15.Z, arg7, arg4, arg2);
            }

         } else if (arg7 == 9) {
            ModelSource var34;
            if (var15.T == -1 && var15.V == null) {
               var34 = var15.a(arg7, arg6, var10, var11, var12, var13, -1);
            } else {
               var34 = new ClientLocAnim(var15.T, var12, var13, var11, arg7, (byte)3, arg8, true, var10, arg6);
            }

            arg0.a(arg3, 1, arg2, var34, var17, 0, arg4, -896, 1, var14, var16);
            if (var15.ab && arg1 != null) {
               arg1.a(arg2, arg6, var15.r, var15.R, var15.Z, arg4, (byte)52);
            }

         } else {
            if (var15.l) {
               if (arg6 == 1) {
                  int var35 = var13;
                  var13 = var12;
                  var12 = var11;
                  var11 = var10;
                  var10 = var35;
               } else if (arg6 == 2) {
                  int var36 = var13;
                  var13 = var11;
                  var11 = var36;
                  int var37 = var12;
                  var12 = var10;
                  var10 = var37;
               } else if (arg6 == 3) {
                  int var38 = var13;
                  var13 = var10;
                  var10 = var11;
                  var11 = var12;
                  var12 = var38;
               }
            }

            if (arg7 == 4) {
               ModelSource var39;
               if (var15.T == -1 && var15.V == null) {
                  var39 = var15.a(4, 0, var10, var11, var12, var13, -1);
               } else {
                  var39 = new ClientLocAnim(var15.T, var12, var13, var11, 4, (byte)3, arg8, true, var10, 0);
               }

               arg0.a(arg3, u[arg6], arg6 * 512, var16, var17, arg4, 0, arg2, 0, var14, var39, -930);
            } else if (arg7 == 5) {
               int var40 = 16;
               int var41 = arg0.b(arg3, arg4, arg2);
               if (var41 > 0) {
                  var40 = LocType.a(var41 >> 14 & 32767).S;
               }

               ModelSource var42;
               if (var15.T == -1 && var15.V == null) {
                  var42 = var15.a(4, 0, var10, var11, var12, var13, -1);
               } else {
                  var42 = new ClientLocAnim(var15.T, var12, var13, var11, 4, (byte)3, arg8, true, var10, 0);
               }

               arg0.a(arg3, u[arg6], arg6 * 512, var16, var17, arg4, f[arg6] * var40, arg2, x[arg6] * var40, var14, var42, -930);
            } else if (arg7 == 6) {
               ModelSource var43;
               if (var15.T == -1 && var15.V == null) {
                  var43 = var15.a(4, 0, var10, var11, var12, var13, -1);
               } else {
                  var43 = new ClientLocAnim(var15.T, var12, var13, var11, 4, (byte)3, arg8, true, var10, 0);
               }

               arg0.a(arg3, 256, arg6, var16, var17, arg4, 0, arg2, 0, var14, var43, -930);
            } else if (arg7 == 7) {
               ModelSource var44;
               if (var15.T == -1 && var15.V == null) {
                  var44 = var15.a(4, 0, var10, var11, var12, var13, -1);
               } else {
                  var44 = new ClientLocAnim(var15.T, var12, var13, var11, 4, (byte)3, arg8, true, var10, 0);
               }

               arg0.a(arg3, 512, arg6, var16, var17, arg4, 0, arg2, 0, var14, var44, -930);
            } else if (arg7 == 8) {
               ModelSource var45;
               if (var15.T == -1 && var15.V == null) {
                  var45 = var15.a(4, 0, var10, var11, var12, var13, -1);
               } else {
                  var45 = new ClientLocAnim(var15.T, var12, var13, var11, 4, (byte)3, arg8, true, var10, 0);
               }

               arg0.a(arg3, 768, arg6, var16, var17, arg4, 0, arg2, 0, var14, var45, -930);
            }
         }
      } else {
         ModelSource var19;
         if (var15.T == -1 && var15.V == null) {
            var19 = var15.a(10, arg6, var10, var11, var12, var13, -1);
         } else {
            var19 = new ClientLocAnim(var15.T, var12, var13, var11, 10, (byte)3, arg8, true, var10, arg6);
         }

         if (var19 != null) {
            int var20 = 0;
            if (arg7 == 11) {
               var20 += 256;
            }

            int var21;
            int var22;
            if (arg6 != 1 && arg6 != 3) {
               var21 = var15.R;
               var22 = var15.r;
            } else {
               var21 = var15.r;
               var22 = var15.R;
            }

            if (arg0.a(arg3, var21, arg2, var19, var17, var20, arg4, -896, var22, var14, var16) && var15.X) {
               Model var23;
               if (var19 instanceof Model) {
                  var23 = (Model)var19;
               } else {
                  var23 = var15.a(10, arg6, var10, var11, var12, var13, -1);
               }

               if (var23 != null) {
                  for(int var24 = 0; var24 <= var21; ++var24) {
                     for(int var25 = 0; var25 <= var22; ++var25) {
                        int var26 = var23.V / 4;
                        if (var26 > 30) {
                           var26 = 30;
                        }

                        if (var26 > this.A[arg3][arg4 + var24][arg2 + var25]) {
                           this.A[arg3][arg4 + var24][arg2 + var25] = (byte)var26;
                        }
                     }
                  }
               }
            }
         }

         if (var15.ab && arg1 != null) {
            arg1.a(arg2, arg6, var15.r, var15.R, var15.Z, arg4, (byte)52);
         }

      }
   }

   @ObfuscatedName("CHEOPWNH.a(IZII[BI[LXRENONSA;)V")
   public final void a(int arg0, boolean arg1, int arg2, int arg3, byte[] arg4, int arg5, CollisionMap[] arg6) {
      if (arg1) {
         this.C = -379;
      }

      for(int var8 = 0; var8 < 4; ++var8) {
         for(int var9 = 0; var9 < 64; ++var9) {
            for(int var10 = 0; var10 < 64; ++var10) {
               if (arg3 + var9 > 0 && arg3 + var9 < 103 && arg0 + var10 > 0 && arg0 + var10 < 103) {
                  arg6[var8].j[arg3 + var9][arg0 + var10] &= -16777217;
               }
            }
         }
      }

      Packet var11 = new Packet(arg4);

      for(int var12 = 0; var12 < 4; ++var12) {
         for(int var13 = 0; var13 < 64; ++var13) {
            for(int var14 = 0; var14 < 64; ++var14) {
               this.a(arg5, (byte)-61, arg2, var11, 0, arg3 + var13, var12, arg0 + var14);
            }
         }
      }

   }

   public World(int[][][] arg0, int arg1, byte[][][] arg2, int arg3, int arg4) {
      m = 99;
      this.n = arg4;
      this.o = arg3;
      this.l = arg0;
      this.a = arg2;
      this.v = new byte[4][this.n][this.o];
      this.r = new byte[4][this.n][this.o];
      this.p = new byte[4][this.n][this.o];
      this.e = new byte[4][this.n][this.o];
      this.E = new int[4][this.n + 1][this.o + 1];
      this.A = new byte[4][this.n + 1][this.o + 1];
      this.B = new int[this.n + 1][this.o + 1];
      this.g = new int[this.o];
      this.h = new int[this.o];
      this.i = new int[this.o];
      this.j = new int[this.o];
      this.k = new int[this.o];
      if (arg1 != 14290) {
         throw new NullPointerException();
      }
   }

   @ObfuscatedName("CHEOPWNH.b(II)I")
   public static final int b(int arg0, int arg1) {
      int var2 = arg1 * 57 + arg0;
      int var3 = var2 << 13 ^ var2;
      int var4 = (var3 * var3 * 15731 + 789221) * var3 + 1376312589 & Integer.MAX_VALUE;
      return var4 >> 19 & 255;
   }

   @ObfuscatedName("CHEOPWNH.b(IIII)I")
   public static final int b(int arg0, int arg1, int arg2, int arg3) {
      int var4 = 65536 - Pix3D.cosTable[arg2 * 1024 / arg3] >> 1;
      return ((65536 - var4) * arg0 >> 16) + (arg1 * var4 >> 16);
   }

   @ObfuscatedName("CHEOPWNH.b(III)I")
   public final int b(int arg0, int arg1, int arg2) {
      if (arg2 > 179) {
         arg1 /= 2;
      }

      if (arg2 > 192) {
         arg1 /= 2;
      }

      if (arg2 > 217) {
         arg1 /= 2;
      }

      if (arg2 > 243) {
         arg1 /= 2;
      }

      return arg2 / 2 + (arg0 / 4 << 10) + (arg1 / 32 << 7);
   }

   @ObfuscatedName("CHEOPWNH.c(II)I")
   public static final int c(int arg0, int arg1) {
      int var2 = b(arg0 - 1, arg1 - 1) + b(arg0 + 1, arg1 - 1) + b(arg0 - 1, arg1 + 1) + b(arg0 + 1, arg1 + 1);
      int var3 = b(arg0 - 1, arg1) + b(arg0 + 1, arg1) + b(arg0, arg1 - 1) + b(arg0, arg1 + 1);
      int var4 = b(arg0, arg1);
      return var4 / 4 + var2 / 16 + var3 / 8;
   }

   @ObfuscatedName("CHEOPWNH.a(I[LXRENONSA;IILKJCMXHNO;[B)V")
   public final void a(int arg0, CollisionMap[] arg1, int arg2, int arg3, World3D arg4, byte[] arg5) {
      if (arg3 < 0) {
         Packet var7 = new Packet(arg5);
         int var8 = -1;

         while(true) {
            int var9 = var7.gsmarts();
            if (var9 == 0) {
               return;
            }

            var8 += var9;
            int var10 = 0;

            while(true) {
               int var11 = var7.gsmarts();
               if (var11 == 0) {
                  break;
               }

               var10 += var11 - 1;
               int var12 = var10 & 63;
               int var13 = var10 >> 6 & 63;
               int var14 = var10 >> 12;
               int var15 = var7.g1();
               int var16 = var15 >> 2;
               int var17 = var15 & 3;
               int var18 = arg2 + var13;
               int var19 = arg0 + var12;
               if (var18 > 0 && var19 > 0 && var18 < 103 && var19 < 103) {
                  int var20 = var14;
                  if ((this.a[1][var18][var19] & 2) == 2) {
                     var20 = var14 - 1;
                  }

                  CollisionMap var21 = null;
                  if (var20 >= 0) {
                     var21 = arg1[var20];
                  }

                  this.a(arg4, var21, var19, var14, var18, this.b, var17, var16, var8);
               }
            }
         }
      }
   }

   @ObfuscatedName("CHEOPWNH.a(IIIII)V")
   public final void a(int arg0, int arg1, int arg2, int arg3, int arg4) {
      if (arg3 < 0) {
         for(int var6 = arg1; var6 <= arg1 + arg2; ++var6) {
            for(int var7 = arg0; var7 <= arg0 + arg4; ++var7) {
               if (var7 >= 0 && var7 < this.n && var6 >= 0 && var6 < this.o) {
                  this.A[0][var7][var6] = 127;
                  if (arg0 == var7 && var7 > 0) {
                     this.l[0][var7][var6] = this.l[0][var7 - 1][var6];
                  }

                  if (arg0 + arg4 == var7 && var7 < this.n - 1) {
                     this.l[0][var7][var6] = this.l[0][var7 + 1][var6];
                  }

                  if (arg1 == var6 && var6 > 0) {
                     this.l[0][var7][var6] = this.l[0][var7][var6 - 1];
                  }

                  if (arg1 + arg2 == var6 && var6 < this.o - 1) {
                     this.l[0][var7][var6] = this.l[0][var7][var6 + 1];
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("CHEOPWNH.a(II[BI)Z")
   public static final boolean locsAreReady(int arg0, int arg1, byte[] arg2, int arg3) {
      boolean var4 = true;
      Packet var5 = new Packet(arg2);
      if (arg3 != 24515) {
         throw new NullPointerException();
      } else {
         int var6 = -1;

         label54:
         while(true) {
            int var7 = var5.gsmarts();
            if (var7 == 0) {
               return var4;
            }

            var6 += var7;
            int var8 = 0;
            boolean var9 = false;

            while(true) {
               while(!var9) {
                  int var11 = var5.gsmarts();
                  if (var11 == 0) {
                     continue label54;
                  }

                  var8 += var11 - 1;
                  int var12 = var8 & 63;
                  int var13 = var8 >> 6 & 63;
                  int var14 = var5.g1() >> 2;
                  int var15 = arg0 + var13;
                  int var16 = arg1 + var12;
                  if (var15 > 0 && var16 > 0 && var15 < 103 && var16 < 103) {
                     LocType var17 = LocType.a(var6);
                     if (var14 != 22 || !lowMemory || var17.b || var17.h) {
                        var4 &= var17.c(-321);
                        var9 = true;
                     }
                  }
               }

               int var10 = var5.gsmarts();
               if (var10 == 0) {
                  break;
               }

               var5.g1();
            }
         }
      }
   }

   @ObfuscatedName("CHEOPWNH.d(II)I")
   public final int d(int arg0, int arg1) {
      if (arg0 == -2) {
         return 12345678;
      } else if (arg0 == -1) {
         if (arg1 < 0) {
            arg1 = 0;
         } else if (arg1 > 127) {
            arg1 = 127;
         }

         return 127 - arg1;
      } else {
         int var4 = (arg0 & 127) * arg1 / 128;
         if (var4 < 2) {
            var4 = 2;
         } else if (var4 > 126) {
            var4 = 126;
         }

         return (arg0 & 65408) + var4;
      }
   }

   @ObfuscatedName("CHEOPWNH.a(IBILMFMVIYHT;IIII)V")
   public final void a(int arg0, byte arg1, int arg2, Packet arg3, int arg4, int arg5, int arg6, int arg7) {
      if (arg1 != -61) {
         this.c = !this.c;
      }

      if (arg5 >= 0 && arg5 < 104 && arg7 >= 0 && arg7 < 104) {
         this.a[arg6][arg5][arg7] = 0;

         while(true) {
            int var9 = arg3.g1();
            if (var9 == 0) {
               if (arg6 == 0) {
                  this.l[0][arg5][arg7] = -e(arg5 + 932731 + arg0, arg7 + 556238 + arg2) * 8;
                  return;
               } else {
                  this.l[arg6][arg5][arg7] = this.l[arg6 - 1][arg5][arg7] - 240;
                  return;
               }
            }

            if (var9 == 1) {
               int var10 = arg3.g1();
               if (var10 == 1) {
                  var10 = 0;
               }

               if (arg6 == 0) {
                  this.l[0][arg5][arg7] = -var10 * 8;
                  return;
               }

               this.l[arg6][arg5][arg7] = this.l[arg6 - 1][arg5][arg7] - var10 * 8;
               return;
            }

            if (var9 <= 49) {
               this.r[arg6][arg5][arg7] = arg3.g1b();
               this.p[arg6][arg5][arg7] = (byte)((var9 - 2) / 4);
               this.e[arg6][arg5][arg7] = (byte)(var9 - 2 + arg4 & 3);
            } else if (var9 <= 81) {
               this.a[arg6][arg5][arg7] = (byte)(var9 - 49);
            } else {
               this.v[arg6][arg5][arg7] = (byte)(var9 - 81);
            }
         }
      } else {
         while(true) {
            int var11 = arg3.g1();
            if (var11 == 0) {
               return;
            }

            if (var11 == 1) {
               arg3.g1();
               return;
            }

            if (var11 <= 49) {
               arg3.g1();
            }
         }
      }
   }

   @ObfuscatedName("CHEOPWNH.e(II)I")
   public static final int e(int arg0, int arg1) {
      int var2 = a(arg0 + 45365, (int)(arg1 + 91923), 4) - 128 + (a(arg0 + 10294, (int)(arg1 + 37821), 2) - 128 >> 1) + (a(arg0, (int)arg1, 1) - 128 >> 2);
      int var3 = (int)((double)var2 * 0.3D) + 35;
      if (var3 < 10) {
         var3 = 10;
      } else if (var3 > 60) {
         var3 = 60;
      }

      return var3;
   }
}
