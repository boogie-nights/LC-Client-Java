package jagex2.dash3d;

import deob.*;
import jagex2.datastruct.LinkList;
import jagex2.graphics.Pix2D;
import jagex2.graphics.Pix3D;

public class World3D {
   @ObfuscatedName("KJCMXHNO.b")
   public int b = -203;
   @ObfuscatedName("KJCMXHNO.c")
   public boolean c = true;
   @ObfuscatedName("KJCMXHNO.d")
   public boolean d = false;
   @ObfuscatedName("KJCMXHNO.g")
   public int g = 2;
   @ObfuscatedName("KJCMXHNO.h")
   public int h = -766;
   @ObfuscatedName("KJCMXHNO.i")
   public boolean i = true;
   @ObfuscatedName("KJCMXHNO.j")
   public boolean j = true;
   @ObfuscatedName("KJCMXHNO.k")
   public boolean k = false;
   @ObfuscatedName("KJCMXHNO.l")
   public int l = -68;
   @ObfuscatedName("KJCMXHNO.u")
   public Loc[] u = new Loc[5000];
   @ObfuscatedName("KJCMXHNO.kb")
   public int[] kb = new int[10000];
   @ObfuscatedName("KJCMXHNO.lb")
   public int[] lb = new int[10000];
   @ObfuscatedName("KJCMXHNO.nb")
   public int[][] nb = new int[][]{new int[16], {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
   @ObfuscatedName("KJCMXHNO.ob")
   public int[][] ob = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
   @ObfuscatedName("KJCMXHNO.n")
   public int n;
   @ObfuscatedName("KJCMXHNO.o")
   public int o;
   @ObfuscatedName("KJCMXHNO.p")
   public int p;
   @ObfuscatedName("KJCMXHNO.r")
   public Square[][][] r;
   @ObfuscatedName("KJCMXHNO.v")
   public int[][][] v;
   @ObfuscatedName("KJCMXHNO.q")
   public int[][][] q;
   @ObfuscatedName("KJCMXHNO.m")
   public static boolean m = true;
   @ObfuscatedName("KJCMXHNO.M")
   public static Loc[] M = new Loc[100];
   @ObfuscatedName("KJCMXHNO.N")
   public static final int[] N = new int[]{53, -53, -53, 53};
   @ObfuscatedName("KJCMXHNO.O")
   public static final int[] O = new int[]{-53, -53, 53, 53};
   @ObfuscatedName("KJCMXHNO.P")
   public static final int[] P = new int[]{-45, 45, 45, -45};
   @ObfuscatedName("KJCMXHNO.Q")
   public static final int[] Q = new int[]{45, 45, -45, -45};
   @ObfuscatedName("KJCMXHNO.U")
   public static int U = -1;
   @ObfuscatedName("KJCMXHNO.V")
   public static int V = -1;
   @ObfuscatedName("KJCMXHNO.W")
   public static int W = 4;
   @ObfuscatedName("KJCMXHNO.X")
   public static int[] X = new int[W];
   @ObfuscatedName("KJCMXHNO.Y")
   public static Occlude[][] Y = new Occlude[W][500];
   @ObfuscatedName("KJCMXHNO.ab")
   public static Occlude[] ab = new Occlude[500];
   @ObfuscatedName("KJCMXHNO.bb")
   public static LinkList bb = new LinkList();
   @ObfuscatedName("KJCMXHNO.cb")
   public static final int[] cb = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
   @ObfuscatedName("KJCMXHNO.db")
   public static final int[] db = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
   @ObfuscatedName("KJCMXHNO.eb")
   public static final int[] eb = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
   @ObfuscatedName("KJCMXHNO.fb")
   public static final int[] fb = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
   @ObfuscatedName("KJCMXHNO.gb")
   public static final int[] gb = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
   @ObfuscatedName("KJCMXHNO.hb")
   public static final int[] hb = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
   @ObfuscatedName("KJCMXHNO.ib")
   public static final int[] ib = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
   @ObfuscatedName("KJCMXHNO.jb")
   public static final int[] jb = new int[]{41, 39248, 41, 4643, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 43086, 41, 41, 41, 41, 41, 41, 41, 8602, 41, 28992, 41, 41, 41, 41, 41, 5056, 41, 41, 41, 7079, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 3131, 41, 41, 41};
   @ObfuscatedName("KJCMXHNO.pb")
   public static boolean[][][][] pb = new boolean[8][32][51][51];
   @ObfuscatedName("KJCMXHNO.A")
   public static int A;
   @ObfuscatedName("KJCMXHNO.B")
   public static int B;
   @ObfuscatedName("KJCMXHNO.C")
   public static int C;
   @ObfuscatedName("KJCMXHNO.D")
   public static int D;
   @ObfuscatedName("KJCMXHNO.E")
   public static int E;
   @ObfuscatedName("KJCMXHNO.F")
   public static int F;
   @ObfuscatedName("KJCMXHNO.G")
   public static int G;
   @ObfuscatedName("KJCMXHNO.H")
   public static int H;
   @ObfuscatedName("KJCMXHNO.I")
   public static int I;
   @ObfuscatedName("KJCMXHNO.J")
   public static int J;
   @ObfuscatedName("KJCMXHNO.K")
   public static int K;
   @ObfuscatedName("KJCMXHNO.L")
   public static int L;
   @ObfuscatedName("KJCMXHNO.S")
   public static int S;
   @ObfuscatedName("KJCMXHNO.T")
   public static int T;
   @ObfuscatedName("KJCMXHNO.Z")
   public static int Z;
   @ObfuscatedName("KJCMXHNO.e")
   public int e;
   @ObfuscatedName("KJCMXHNO.f")
   public static int f;
   @ObfuscatedName("KJCMXHNO.mb")
   public int mb;
   @ObfuscatedName("KJCMXHNO.rb")
   public static int rb;
   @ObfuscatedName("KJCMXHNO.s")
   public int s;
   @ObfuscatedName("KJCMXHNO.sb")
   public static int sb;
   @ObfuscatedName("KJCMXHNO.t")
   public int t;
   @ObfuscatedName("KJCMXHNO.tb")
   public static int tb;
   @ObfuscatedName("KJCMXHNO.ub")
   public static int ub;
   @ObfuscatedName("KJCMXHNO.vb")
   public static int vb;
   @ObfuscatedName("KJCMXHNO.w")
   public static int w;
   @ObfuscatedName("KJCMXHNO.wb")
   public static int wb;
   @ObfuscatedName("KJCMXHNO.x")
   public static int x;
   @ObfuscatedName("KJCMXHNO.y")
   public static int y;
   @ObfuscatedName("KJCMXHNO.z")
   public static int z;
   @ObfuscatedName("KJCMXHNO.R")
   public static boolean R;
   @ObfuscatedName("KJCMXHNO.a")
   public static boolean a;
   @ObfuscatedName("KJCMXHNO.qb")
   public static boolean[][] qb;

   public World3D(int[][][] arg0, int arg1, int arg2, int arg3, byte arg4) {
      this.n = arg2;
      this.o = arg3;
      this.p = arg1;
      this.r = new Square[arg2][arg3][arg1];
      this.v = new int[arg2][arg3 + 1][arg1 + 1];
      this.q = arg0;
      if (arg4 == 5) {
         boolean var6 = false;
      } else {
         this.h = 272;
      }

      this.a((byte)7);
   }

   @ObfuscatedName("KJCMXHNO.a(Z)V")
   public static void a(boolean arg0) {
      M = null;
      X = null;
      Y = null;
      bb = null;
      pb = null;
      if (!arg0) {
         qb = null;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(B)V")
   public void a(byte arg0) {
      for(int var2 = 0; var2 < this.n; ++var2) {
         for(int var3 = 0; var3 < this.o; ++var3) {
            for(int var4 = 0; var4 < this.p; ++var4) {
               this.r[var2][var3][var4] = null;
            }
         }
      }

      if (arg0 != 7) {
         for(int var5 = 1; var5 > 0; ++var5) {
         }
      }

      for(int var6 = 0; var6 < W; ++var6) {
         for(int var7 = 0; var7 < X[var6]; ++var7) {
            Y[var6][var7] = null;
         }

         X[var6] = 0;
      }

      for(int var8 = 0; var8 < this.t; ++var8) {
         this.u[var8] = null;
      }

      this.t = 0;

      for(int var9 = 0; var9 < M.length; ++var9) {
         M[var9] = null;
      }

   }

   @ObfuscatedName("KJCMXHNO.a(IZ)V")
   public void a(int arg0, boolean arg1) {
      if (!arg1) {
         this.j = !this.j;
      }

      this.s = arg0;

      for(int var3 = 0; var3 < this.o; ++var3) {
         for(int var4 = 0; var4 < this.p; ++var4) {
            if (this.r[arg0][var3][var4] == null) {
               this.r[arg0][var3][var4] = new Square(arg0, var3, var4);
            }
         }
      }

   }

   @ObfuscatedName("KJCMXHNO.a(ZII)V")
   public void a(boolean arg0, int arg1, int arg2) {
      Square var4 = this.r[0][arg1][arg2];

      for(int var5 = 0; var5 < 3; ++var5) {
         Square var6 = this.r[var5][arg1][arg2] = this.r[var5 + 1][arg1][arg2];
         if (var6 != null) {
            --var6.f;

            for(int var7 = 0; var7 < var6.p; ++var7) {
               Loc var8 = var6.q[var7];
               if ((var8.m >> 29 & 3) == 2 && var8.g == arg1 && var8.i == arg2) {
                  --var8.a;
               }
            }
         }
      }

      if (this.r[0][arg1][arg2] == null) {
         this.r[0][arg1][arg2] = new Square(0, arg1, arg2);
      }

      this.r[0][arg1][arg2].B = var4;
      if (!arg0) {
         for(int var9 = 1; var9 > 0; ++var9) {
         }
      }

      this.r[3][arg1][arg2] = null;
   }

   @ObfuscatedName("KJCMXHNO.a(IIIIIIIII)V")
   public static void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
      Occlude var9 = new Occlude();
      if (arg0 != -8967) {
         for(int var10 = 1; var10 > 0; ++var10) {
         }
      }

      var9.a = arg1 / 128;
      var9.b = arg3 / 128;
      var9.c = arg6 / 128;
      var9.d = arg4 / 128;
      var9.e = arg8;
      var9.f = arg1;
      var9.g = arg3;
      var9.h = arg6;
      var9.i = arg4;
      var9.j = arg7;
      var9.k = arg2;
      Y[arg5][X[arg5]++] = var9;
   }

   @ObfuscatedName("KJCMXHNO.a(IIII)V")
   public void a(int arg0, int arg1, int arg2, int arg3) {
      Square var5 = this.r[arg0][arg1][arg2];
      if (var5 != null) {
         this.r[arg0][arg1][arg2].t = arg3;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIIIIIIIIIIIIIIIIIII)V")
   public void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19) {
      if (arg3 == 0) {
         QuickGround var21 = new QuickGround(arg10, arg11, arg12, arg13, -1, arg18, false);

         for(int var22 = arg0; var22 >= 0; --var22) {
            if (this.r[var22][arg1][arg2] == null) {
               this.r[var22][arg1][arg2] = new Square(var22, arg1, arg2);
            }
         }

         this.r[arg0][arg1][arg2].j = var21;
      } else if (arg3 != 1) {
         Ground var25 = new Ground(arg9, arg14, arg8, arg6, arg1, arg12, arg13, arg19, arg11, arg16, 0, arg10, arg3, arg7, arg17, arg5, arg18, arg15, arg2, arg4);

         for(int var26 = arg0; var26 >= 0; --var26) {
            if (this.r[var26][arg1][arg2] == null) {
               this.r[var26][arg1][arg2] = new Square(var26, arg1, arg2);
            }
         }

         this.r[arg0][arg1][arg2].k = var25;
      } else {
         QuickGround var23 = new QuickGround(arg14, arg15, arg16, arg17, arg5, arg19, arg6 == arg7 && arg6 == arg8 && arg6 == arg9);

         for(int var24 = arg0; var24 >= 0; --var24) {
            if (this.r[var24][arg1][arg2] == null) {
               this.r[var24][arg1][arg2] = new Square(var24, arg1, arg2);
            }
         }

         this.r[arg0][arg1][arg2].j = var23;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIIBIIILZOXDNIET;)V")
   public void a(int arg0, int arg1, int arg2, byte arg3, int arg4, int arg5, int arg6, ModelSource arg7) {
      if (arg2 > 0) {
         if (arg7 != null) {
            GroundDecor var9 = new GroundDecor();
            var9.d = arg7;
            var9.b = arg0 * 128 + 64;
            var9.c = arg1 * 128 + 64;
            var9.a = arg5;
            var9.e = arg4;
            var9.f = arg3;
            if (this.r[arg6][arg0][arg1] == null) {
               this.r[arg6][arg0][arg1] = new Square(arg6, arg0, arg1);
            }

            this.r[arg6][arg0][arg1].n = var9;
         }
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IILZOXDNIET;LZOXDNIET;ILZOXDNIET;III)V")
   public void a(int arg0, int arg1, ModelSource arg2, ModelSource arg3, int arg4, ModelSource arg5, int arg6, int arg7, int arg8) {
      GroundObject var10 = new GroundObject();
      var10.d = arg2;
      var10.b = arg8 * 128 + 64;
      var10.c = arg7 * 128 + 64;
      var10.a = arg0;
      var10.g = arg4;
      var10.e = arg3;
      var10.f = arg5;
      if (arg6 < 2 || arg6 > 2) {
         this.i = !this.i;
      }

      int var11 = 0;
      Square var12 = this.r[arg1][arg8][arg7];
      if (var12 != null) {
         for(int var13 = 0; var13 < var12.p; ++var13) {
            if (var12.q[var13].e instanceof Model) {
               int var14 = ((Model)var12.q[var13].e).Z;
               if (var14 > var11) {
                  var11 = var14;
               }
            }
         }
      }

      var10.h = var11;
      if (this.r[arg1][arg8][arg7] == null) {
         this.r[arg1][arg8][arg7] = new Square(arg1, arg8, arg7);
      }

      this.r[arg1][arg8][arg7].o = var10;
   }

   @ObfuscatedName("KJCMXHNO.a(IIIILZOXDNIET;IIBILZOXDNIET;I)V")
   public void a(int arg0, int arg1, int arg2, int arg3, ModelSource arg4, int arg5, int arg6, byte arg7, int arg8, ModelSource arg9, int arg10) {
      if (arg9 != null || arg4 != null) {
         Wall var12 = new Wall();
         var12.h = arg6;
         var12.i = arg7;
         var12.b = arg5 * 128 + 64;
         var12.c = arg8 * 128 + 64;
         var12.a = arg0;
         if (arg1 != 49878) {
            for(int var13 = 1; var13 > 0; ++var13) {
            }
         }

         var12.f = arg9;
         var12.g = arg4;
         var12.d = arg3;
         var12.e = arg2;

         for(int var14 = arg10; var14 >= 0; --var14) {
            if (this.r[var14][arg5][arg8] == null) {
               this.r[var14][arg5][arg8] = new Square(var14, arg5, arg8);
            }
         }

         this.r[arg10][arg5][arg8].l = var12;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIIIBIIIIILZOXDNIET;I)V")
   public void a(int arg0, int arg1, int arg2, int arg3, byte arg4, int arg5, int arg6, int arg7, int arg8, int arg9, ModelSource arg10, int arg11) {
      if (arg10 != null) {
         Decor var13 = new Decor();
         var13.g = arg3;
         var13.h = arg4;
         var13.b = arg5 * 128 + 64 + arg8;
         var13.c = arg7 * 128 + 64 + arg6;
         if (arg11 >= 0) {
            this.h = 308;
         }

         var13.a = arg9;
         var13.f = arg10;
         var13.d = arg1;
         var13.e = arg2;

         for(int var14 = arg0; var14 >= 0; --var14) {
            if (this.r[var14][arg5][arg7] == null) {
               this.r[var14][arg5][arg7] = new Square(var14, arg5, arg7);
            }
         }

         this.r[arg0][arg5][arg7].m = var13;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIILZOXDNIET;BIIIIII)Z")
   public boolean a(int arg0, int arg1, int arg2, ModelSource arg3, byte arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
      if (arg7 < 0) {
         if (arg3 == null) {
            return true;
         } else {
            int var12 = arg1 * 64 + arg6 * 128;
            int var13 = arg2 * 128 + arg8 * 64;
            return this.a(arg0, arg6, arg2, arg1, arg8, var12, var13, arg9, arg3, arg5, false, arg10, arg4);
         }
      } else {
         throw new NullPointerException();
      }
   }

   @ObfuscatedName("KJCMXHNO.a(ILZOXDNIET;IIZIIIII)Z")
   public boolean a(int arg0, ModelSource arg1, int arg2, int arg3, boolean arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
      if (arg1 == null) {
         return true;
      } else {
         int var11 = arg2 - arg7;
         int var12 = arg8 - arg7;
         int var13 = arg2 + arg7;
         int var14 = arg7 + arg8;
         if (arg4) {
            if (arg9 > 640 && arg9 < 1408) {
               var14 += 128;
            }

            if (arg9 > 1152 && arg9 < 1920) {
               var13 += 128;
            }

            if (arg9 > 1664 || arg9 < 384) {
               var12 -= 128;
            }

            if (arg9 > 128 && arg9 < 896) {
               var11 -= 128;
            }
         }

         int var15 = var11 / 128;
         if (arg5 != 0) {
            this.l = 368;
         }

         int var16 = var12 / 128;
         int var17 = var13 / 128;
         int var18 = var14 / 128;
         return this.a(arg6, var15, var16, var17 - var15 + 1, var18 - var16 + 1, arg2, arg8, arg3, arg1, arg9, true, arg0, (byte)0);
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIIILZOXDNIET;IIIIIIII)Z")
   public boolean a(int arg0, int arg1, int arg2, int arg3, ModelSource arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12) {
      if (arg3 < 7 || arg3 > 7) {
         this.k = !this.k;
      }

      return arg4 == null ? true : this.a(arg11, arg5, arg1, arg10 - arg5 + 1, arg7 - arg1 + 1, arg8, arg6, arg0, arg4, arg9, true, arg12, (byte)0);
   }

   @ObfuscatedName("KJCMXHNO.a(IIIIIIIILZOXDNIET;IZIB)Z")
   public boolean a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, ModelSource arg8, int arg9, boolean arg10, int arg11, byte arg12) {
      for(int var14 = arg1; var14 < arg1 + arg3; ++var14) {
         for(int var15 = arg2; var15 < arg2 + arg4; ++var15) {
            if (var14 < 0 || var15 < 0 || var14 >= this.o || var15 >= this.p) {
               return false;
            }

            Square var16 = this.r[arg0][var14][var15];
            if (var16 != null && var16.p >= 5) {
               return false;
            }
         }
      }

      Loc var17 = new Loc();
      var17.m = arg11;
      var17.n = arg12;
      var17.a = arg0;
      var17.c = arg5;
      var17.d = arg6;
      var17.b = arg7;
      var17.e = arg8;
      var17.f = arg9;
      var17.g = arg1;
      var17.i = arg2;
      var17.h = arg1 + arg3 - 1;
      var17.j = arg2 + arg4 - 1;

      for(int var18 = arg1; var18 < arg1 + arg3; ++var18) {
         for(int var19 = arg2; var19 < arg2 + arg4; ++var19) {
            int var20 = 0;
            if (var18 > arg1) {
               ++var20;
            }

            if (var18 < arg1 + arg3 - 1) {
               var20 += 4;
            }

            if (var19 > arg2) {
               var20 += 8;
            }

            if (var19 < arg2 + arg4 - 1) {
               var20 += 2;
            }

            for(int var21 = arg0; var21 >= 0; --var21) {
               if (this.r[var21][var18][var19] == null) {
                  this.r[var21][var18][var19] = new Square(var21, var18, var19);
               }
            }

            Square var22 = this.r[arg0][var18][var19];
            var22.q[var22.p] = var17;
            var22.r[var22.p] = var20;
            var22.s |= var20;
            ++var22.p;
         }
      }

      if (arg10) {
         this.u[this.t++] = var17;
      }

      return true;
   }

   @ObfuscatedName("KJCMXHNO.a(I)V")
   public void a(int arg0) {
      int var2 = 16 / arg0;

      for(int var3 = 0; var3 < this.t; ++var3) {
         Loc var4 = this.u[var3];
         this.a(var4, 0);
         this.u[var3] = null;
      }

      this.t = 0;
   }

   @ObfuscatedName("KJCMXHNO.a(LBHOSVTIT;I)V")
   public void a(Loc arg0, int arg1) {
      for(int var3 = arg0.g; var3 <= arg0.h; ++var3) {
         for(int var4 = arg0.i; var4 <= arg0.j; ++var4) {
            Square var5 = this.r[arg0.a][var3][var4];
            if (var5 != null) {
               for(int var6 = 0; var6 < var5.p; ++var6) {
                  if (var5.q[var6] == arg0) {
                     --var5.p;

                     for(int var7 = var6; var7 < var5.p; ++var7) {
                        var5.q[var7] = var5.q[var7 + 1];
                        var5.r[var7] = var5.r[var7 + 1];
                     }

                     var5.q[var5.p] = null;
                     break;
                  }
               }

               var5.s = 0;

               for(int var8 = 0; var8 < var5.p; ++var8) {
                  var5.s |= var5.r[var8];
               }
            }
         }
      }

      if (arg1 != 0) {
         this.e = -317;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIIII)V")
   public void a(int arg0, int arg1, int arg2, int arg3, int arg4) {
      Square var6 = this.r[arg2][arg3][arg0];
      if (var6 != null) {
         Decor var7 = var6.m;
         if (var7 != null) {
            int var8 = arg3 * 128 + 64;
            int var9 = arg0 * 128 + 64;
            if (arg4 == 0) {
               var7.b = (var7.b - var8) * arg1 / 16 + var8;
               var7.c = (var7.c - var9) * arg1 / 16 + var9;
            }
         }
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIIZ)V")
   public void a(int arg0, int arg1, int arg2, boolean arg3) {
      Square var5 = this.r[arg1][arg2][arg0];
      if (var5 != null) {
         var5.l = null;
         if (!arg3) {
            this.b = -232;
         }
      }
   }

   @ObfuscatedName("KJCMXHNO.a(ZIII)V")
   public void a(boolean arg0, int arg1, int arg2, int arg3) {
      Square var5 = this.r[arg3][arg1][arg2];
      if (!arg0) {
         if (var5 != null) {
            var5.m = null;
         }
      }
   }

   @ObfuscatedName("KJCMXHNO.b(IIII)V")
   public void b(int arg0, int arg1, int arg2, int arg3) {
      if (arg2 < 0) {
         Square var5 = this.r[arg1][arg3][arg0];
         if (var5 != null) {
            for(int var6 = 0; var6 < var5.p; ++var6) {
               Loc var7 = var5.q[var6];
               if ((var7.m >> 29 & 3) == 2 && var7.g == arg3 && var7.i == arg0) {
                  this.a(var7, 0);
                  return;
               }
            }

         }
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIZI)V")
   public void a(int arg0, int arg1, boolean arg2, int arg3) {
      Square var5 = this.r[arg3][arg0][arg1];
      if (var5 != null) {
         var5.n = null;
         if (!arg2) {
            for(int var6 = 1; var6 > 0; ++var6) {
            }

         }
      }
   }

   @ObfuscatedName("KJCMXHNO.a(III)V")
   public void a(int arg0, int arg1, int arg2) {
      Square var4 = this.r[arg0][arg1][arg2];
      if (var4 != null) {
         var4.o = null;
      }
   }

   @ObfuscatedName("KJCMXHNO.c(IIII)LWQXKHZYN;")
   public Wall c(int arg0, int arg1, int arg2, int arg3) {
      Square var5 = this.r[arg0][arg2][arg3];
      if (arg1 != 17734) {
         throw new NullPointerException();
      } else {
         return var5 == null ? null : var5.l;
      }
   }

   @ObfuscatedName("KJCMXHNO.b(IIIZ)LSEMZHDXN;")
   public Decor b(int arg0, int arg1, int arg2, boolean arg3) {
      Square var5 = this.r[arg0][arg2][arg1];
      if (arg3) {
         throw new NullPointerException();
      } else {
         return var5 == null ? null : var5.m;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IBII)LBHOSVTIT;")
   public Loc a(int arg0, byte arg1, int arg2, int arg3) {
      if (arg1 != 32) {
         for(int var5 = 1; var5 > 0; ++var5) {
         }
      }

      Square var6 = this.r[arg3][arg0][arg2];
      if (var6 == null) {
         return null;
      } else {
         for(int var7 = 0; var7 < var6.p; ++var7) {
            Loc var8 = var6.q[var7];
            if ((var8.m >> 29 & 3) == 2 && var8.g == arg0 && var8.i == arg2) {
               return var8;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("KJCMXHNO.d(IIII)LMOLUZZPG;")
   public GroundDecor d(int arg0, int arg1, int arg2, int arg3) {
      if (arg2 != 0) {
         throw new NullPointerException();
      } else {
         Square var5 = this.r[arg0][arg3][arg1];
         return var5 != null && var5.n != null ? var5.n : null;
      }
   }

   @ObfuscatedName("KJCMXHNO.b(III)I")
   public int b(int arg0, int arg1, int arg2) {
      Square var4 = this.r[arg0][arg1][arg2];
      return var4 != null && var4.l != null ? var4.l.h : 0;
   }

   @ObfuscatedName("KJCMXHNO.b(IBII)I")
   public int b(int arg0, byte arg1, int arg2, int arg3) {
      if (arg1 != 4) {
         this.k = !this.k;
      }

      Square var5 = this.r[arg2][arg0][arg3];
      return var5 != null && var5.m != null ? var5.m.g : 0;
   }

   @ObfuscatedName("KJCMXHNO.c(III)I")
   public int c(int arg0, int arg1, int arg2) {
      Square var4 = this.r[arg0][arg1][arg2];
      if (var4 == null) {
         return 0;
      } else {
         for(int var5 = 0; var5 < var4.p; ++var5) {
            Loc var6 = var4.q[var5];
            if ((var6.m >> 29 & 3) == 2 && var6.g == arg1 && var6.i == arg2) {
               return var6.m;
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("KJCMXHNO.d(III)I")
   public int d(int arg0, int arg1, int arg2) {
      Square var4 = this.r[arg0][arg1][arg2];
      return var4 != null && var4.n != null ? var4.n.e : 0;
   }

   @ObfuscatedName("KJCMXHNO.e(IIII)I")
   public int e(int arg0, int arg1, int arg2, int arg3) {
      Square var5 = this.r[arg0][arg1][arg2];
      if (var5 == null) {
         return -1;
      } else if (var5.l != null && var5.l.h == arg3) {
         return var5.l.i & 255;
      } else if (var5.m != null && var5.m.g == arg3) {
         return var5.m.h & 255;
      } else if (var5.n != null && var5.n.e == arg3) {
         return var5.n.f & 255;
      } else {
         for(int var6 = 0; var6 < var5.p; ++var6) {
            if (var5.q[var6].m == arg3) {
               return var5.q[var6].n & 255;
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(BIII)V")
   public void a(byte arg0, int arg1, int arg2, int arg3) {
      for(int var5 = 0; var5 < this.n; ++var5) {
         for(int var6 = 0; var6 < this.o; ++var6) {
            for(int var7 = 0; var7 < this.p; ++var7) {
               Square var8 = this.r[var5][var6][var7];
               if (var8 != null) {
                  Wall var9 = var8.l;
                  if (var9 != null && var9.f != null && var9.f.j != null) {
                     this.a(var7, var5, 0, 1, (Model)var9.f, var6, 1);
                     if (var9.g != null && var9.g.j != null) {
                        this.a(var7, var5, 0, 1, (Model)var9.g, var6, 1);
                        this.a((Model)var9.f, (Model)var9.g, 0, 0, 0, false);
                        ((Model)var9.g).b(arg1, arg2, 0, arg3);
                     }

                     ((Model)var9.f).b(arg1, arg2, 0, arg3);
                  }

                  for(int var10 = 0; var10 < var8.p; ++var10) {
                     Loc var11 = var8.q[var10];
                     if (var11 != null && var11.e != null && var11.e.j != null) {
                        this.a(var7, var5, 0, var11.h - var11.g + 1, (Model)var11.e, var6, var11.j - var11.i + 1);
                        ((Model)var11.e).b(arg1, arg2, 0, arg3);
                     }
                  }

                  GroundDecor var12 = var8.n;
                  if (var12 != null && var12.d.j != null) {
                     this.a(var6, (Model)var12.d, var7, var5, 0);
                     ((Model)var12.d).b(arg1, arg2, 0, arg3);
                  }
               }
            }
         }
      }

      if (arg0 == 2) {
         boolean var13 = false;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(ILLZYQDKJV;III)V")
   public void a(int arg0, Model arg1, int arg2, int arg3, int arg4) {
      if (arg4 == 0) {
         if (arg0 < this.o) {
            Square var6 = this.r[arg3][arg0 + 1][arg2];
            if (var6 != null && var6.n != null && var6.n.d.j != null) {
               this.a(arg1, (Model)var6.n.d, 128, 0, 0, true);
            }
         }

         if (arg2 < this.o) {
            Square var7 = this.r[arg3][arg0][arg2 + 1];
            if (var7 != null && var7.n != null && var7.n.d.j != null) {
               this.a(arg1, (Model)var7.n.d, 0, 0, 128, true);
            }
         }

         if (arg0 < this.o && arg2 < this.p) {
            Square var8 = this.r[arg3][arg0 + 1][arg2 + 1];
            if (var8 != null && var8.n != null && var8.n.d.j != null) {
               this.a(arg1, (Model)var8.n.d, 128, 0, 128, true);
            }
         }

         if (arg0 < this.o && arg2 > 0) {
            Square var9 = this.r[arg3][arg0 + 1][arg2 - 1];
            if (var9 != null && var9.n != null && var9.n.d.j != null) {
               this.a(arg1, (Model)var9.n.d, 128, 0, -128, true);
               return;
            }
         }

      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIIILLZYQDKJV;II)V")
   public void a(int arg0, int arg1, int arg2, int arg3, Model arg4, int arg5, int arg6) {
      boolean var8 = true;
      int var9 = arg5;
      int var10 = arg3 + arg5;
      int var11 = arg0 - 1;
      int var12 = arg0 + arg6;

      for(int var13 = arg1; var13 <= arg1 + 1; ++var13) {
         if (this.n != var13) {
            for(int var14 = var9; var14 <= var10; ++var14) {
               if (var14 >= 0 && var14 < this.o) {
                  for(int var15 = var11; var15 <= var12; ++var15) {
                     if (var15 >= 0 && var15 < this.p && (!var8 || var14 >= var10 || var15 >= var12 || var15 < arg0 && arg5 != var14)) {
                        Square var16 = this.r[var13][var14][var15];
                        if (var16 != null) {
                           int var17 = (this.q[var13][var14 + 1][var15] + this.q[var13][var14][var15] + this.q[var13][var14][var15 + 1] + this.q[var13][var14 + 1][var15 + 1]) / 4 - (this.q[arg1][arg5 + 1][arg0] + this.q[arg1][arg5][arg0] + this.q[arg1][arg5][arg0 + 1] + this.q[arg1][arg5 + 1][arg0 + 1]) / 4;
                           Wall var18 = var16.l;
                           if (var18 != null && var18.f != null && var18.f.j != null) {
                              this.a(arg4, (Model)var18.f, (1 - arg3) * 64 + (var14 - arg5) * 128, var17, (var15 - arg0) * 128 + (1 - arg6) * 64, var8);
                           }

                           if (var18 != null && var18.g != null && var18.g.j != null) {
                              this.a(arg4, (Model)var18.g, (1 - arg3) * 64 + (var14 - arg5) * 128, var17, (var15 - arg0) * 128 + (1 - arg6) * 64, var8);
                           }

                           for(int var19 = 0; var19 < var16.p; ++var19) {
                              Loc var20 = var16.q[var19];
                              if (var20 != null && var20.e != null && var20.e.j != null) {
                                 int var21 = var20.h - var20.g + 1;
                                 int var22 = var20.j - var20.i + 1;
                                 this.a(arg4, (Model)var20.e, (var20.g - arg5) * 128 + (var21 - arg3) * 64, var17, (var20.i - arg0) * 128 + (var22 - arg6) * 64, var8);
                              }
                           }
                        }
                     }
                  }
               }
            }

            --var9;
            var8 = false;
         }
      }

      if (arg2 == 0) {
         ;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(LLZYQDKJV;LLZYQDKJV;IIIZ)V")
   public void a(Model arg0, Model arg1, int arg2, int arg3, int arg4, boolean arg5) {
      ++this.mb;
      int var7 = 0;
      int[] var8 = arg1.z;
      int var9 = arg1.y;
      int var10 = arg1.T >> 16;
      int var11 = arg1.T << 16 >> 16;
      int var12 = arg1.U >> 16;
      int var13 = arg1.U << 16 >> 16;

      for(int var14 = 0; var14 < arg0.y; ++var14) {
         VertexNormal var15 = arg0.j[var14];
         VertexNormal var16 = arg0.fb[var14];
         if (var16.d != 0) {
            int var17 = arg0.A[var14] - arg3;
            if (var17 <= arg1.W) {
               int var18 = arg0.z[var14] - arg2;
               if (var18 >= var10 && var18 <= var11) {
                  int var19 = arg0.B[var14] - arg4;
                  if (var19 >= var13 && var19 <= var12) {
                     for(int var20 = 0; var20 < var9; ++var20) {
                        VertexNormal var21 = arg1.j[var20];
                        VertexNormal var22 = arg1.fb[var20];
                        if (var8[var20] == var18 && arg1.B[var20] == var19 && arg1.A[var20] == var17 && var22.d != 0) {
                           var15.a += var22.a;
                           var15.b += var22.b;
                           var15.c += var22.c;
                           var15.d += var22.d;
                           var21.a += var16.a;
                           var21.b += var16.b;
                           var21.c += var16.c;
                           var21.d += var16.d;
                           ++var7;
                           this.kb[var14] = this.mb;
                           this.lb[var20] = this.mb;
                        }
                     }
                  }
               }
            }
         }
      }

      if (var7 >= 3 && arg5) {
         for(int var23 = 0; var23 < arg0.C; ++var23) {
            if (this.kb[arg0.D[var23]] == this.mb && this.kb[arg0.E[var23]] == this.mb && this.kb[arg0.F[var23]] == this.mb) {
               arg0.J[var23] = -1;
            }
         }

         for(int var24 = 0; var24 < arg1.C; ++var24) {
            if (this.lb[arg1.D[var24]] == this.mb && this.lb[arg1.E[var24]] == this.mb && this.lb[arg1.F[var24]] == this.mb) {
               arg1.J[var24] = -1;
            }
         }

      }
   }

   @ObfuscatedName("KJCMXHNO.a([IIIIII)V")
   public void a(int[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
      Square var7 = this.r[arg3][arg4][arg5];
      if (var7 != null) {
         QuickGround var8 = var7.j;
         if (var8 == null) {
            Ground var11 = var7.k;
            if (var11 != null) {
               int var12 = var11.m;
               int var13 = var11.n;
               int var14 = var11.o;
               int var15 = var11.p;
               int[] var16 = this.nb[var12];
               int[] var17 = this.ob[var13];
               int var18 = 0;
               if (var14 != 0) {
                  for(int var19 = 0; var19 < 4; ++var19) {
                     arg0[arg1] = var16[var17[var18++]] == 0 ? var14 : var15;
                     arg0[arg1 + 1] = var16[var17[var18++]] == 0 ? var14 : var15;
                     arg0[arg1 + 2] = var16[var17[var18++]] == 0 ? var14 : var15;
                     arg0[arg1 + 3] = var16[var17[var18++]] == 0 ? var14 : var15;
                     arg1 += arg2;
                  }

               } else {
                  for(int var20 = 0; var20 < 4; ++var20) {
                     if (var16[var17[var18++]] != 0) {
                        arg0[arg1] = var15;
                     }

                     if (var16[var17[var18++]] != 0) {
                        arg0[arg1 + 1] = var15;
                     }

                     if (var16[var17[var18++]] != 0) {
                        arg0[arg1 + 2] = var15;
                     }

                     if (var16[var17[var18++]] != 0) {
                        arg0[arg1 + 3] = var15;
                     }

                     arg1 += arg2;
                  }

               }
            }
         } else {
            int var9 = var8.g;
            if (var9 != 0) {
               for(int var10 = 0; var10 < 4; ++var10) {
                  arg0[arg1] = var9;
                  arg0[arg1 + 1] = var9;
                  arg0[arg1 + 2] = var9;
                  arg0[arg1 + 3] = var9;
                  arg1 += arg2;
               }

            }
         }
      }
   }

   @ObfuscatedName("KJCMXHNO.a(II[IIII)V")
   public static void a(int arg0, int arg1, int[] arg2, int arg3, int arg4, int arg5) {
      tb = 0;
      ub = 0;
      vb = arg5;
      wb = arg0;
      rb = arg5 / 2;
      sb = arg0 / 2;
      boolean[][][][] var6 = new boolean[9][32][53][53];

      for(int var7 = 128; var7 <= 384; var7 += 32) {
         for(int var8 = 0; var8 < 2048; var8 += 64) {
            I = Model.Ib[var7];
            J = Model.Jb[var7];
            K = Model.Ib[var8];
            L = Model.Jb[var8];
            int var9 = (var7 - 128) / 32;
            int var10 = var8 / 64;

            for(int var11 = -26; var11 <= 26; ++var11) {
               for(int var12 = -26; var12 <= 26; ++var12) {
                  int var13 = var11 * 128;
                  int var14 = var12 * 128;
                  boolean var15 = false;

                  for(int var16 = -arg4; var16 <= arg3; var16 += 128) {
                     if (f(var14, var13, f, arg2[var9] + var16)) {
                        var15 = true;
                        break;
                     }
                  }

                  var6[var9][var10][var11 + 25 + 1][var12 + 25 + 1] = var15;
               }
            }
         }
      }

      for(int var17 = 0; var17 < 8; ++var17) {
         for(int var18 = 0; var18 < 32; ++var18) {
            for(int var19 = -25; var19 < 25; ++var19) {
               for(int var20 = -25; var20 < 25; ++var20) {
                  boolean var21 = false;

                  label80:
                  for(int var22 = -1; var22 <= 1; ++var22) {
                     for(int var23 = -1; var23 <= 1; ++var23) {
                        if (var6[var17][var18][var19 + var22 + 25 + 1][var20 + var23 + 25 + 1]) {
                           var21 = true;
                           break label80;
                        }

                        if (var6[var17][(var18 + 1) % 31][var19 + var22 + 25 + 1][var20 + var23 + 25 + 1]) {
                           var21 = true;
                           break label80;
                        }

                        if (var6[var17 + 1][var18][var19 + var22 + 25 + 1][var20 + var23 + 25 + 1]) {
                           var21 = true;
                           break label80;
                        }

                        if (var6[var17 + 1][(var18 + 1) % 31][var19 + var22 + 25 + 1][var20 + var23 + 25 + 1]) {
                           var21 = true;
                           break label80;
                        }
                     }
                  }

                  pb[var17][var18][var19 + 25][var20 + 25] = var21;
               }
            }
         }
      }

      if (arg1 == 22845) {
         ;
      }
   }

   @ObfuscatedName("KJCMXHNO.f(IIII)Z")
   public static boolean f(int arg0, int arg1, int arg2, int arg3) {
      int var4 = L * arg1 + K * arg0 >> 16;
      int var5 = L * arg0 - K * arg1 >> 16;
      if (arg2 != 0) {
         a = !a;
      }

      int var6 = J * var5 + I * arg3 >> 16;
      int var7 = J * arg3 - I * var5 >> 16;
      if (var6 >= 50 && var6 <= 3500) {
         int var8 = (var4 << 9) / var6 + rb;
         int var9 = (var7 << 9) / var6 + sb;
         return var8 >= tb && var8 <= vb && var9 >= ub && var9 <= wb;
      } else {
         return false;
      }
   }

   @ObfuscatedName("KJCMXHNO.e(III)V")
   public void e(int arg0, int arg1, int arg2) {
      R = true;
      S = arg1;
      T = arg2;
      U = -1;
      if (arg0 == 0) {
         V = -1;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIIIIII)V")
   public void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
      if (arg0 < 0) {
         arg0 = 0;
      } else if (arg0 >= this.o * 128) {
         arg0 = this.o * 128 - 1;
      }

      if (arg4 < 0) {
         arg4 = 0;
      } else if (arg4 >= this.p * 128) {
         arg4 = this.p * 128 - 1;
      }

      ++y;
      I = Model.Ib[arg6];
      J = Model.Jb[arg6];
      K = Model.Ib[arg5];
      L = Model.Jb[arg5];
      qb = pb[(arg6 - 128) / 32][arg5 / 64];
      F = arg0;
      G = arg3;
      H = arg4;
      D = arg0 / 128;
      E = arg4 / 128;
      x = arg1;
      z = D - 25;
      if (arg2 == 0) {
         if (z < 0) {
            z = 0;
         }

         B = E - 25;
         if (B < 0) {
            B = 0;
         }

         A = D + 25;
         if (A > this.o) {
            A = this.o;
         }

         C = E + 25;
         if (C > this.p) {
            C = this.p;
         }

         this.b(this.g);
         w = 0;

         for(int var8 = this.s; var8 < this.n; ++var8) {
            Square[][] var9 = this.r[var8];

            for(int var10 = z; var10 < A; ++var10) {
               for(int var11 = B; var11 < C; ++var11) {
                  Square var12 = var9[var10][var11];
                  if (var12 != null) {
                     if (var12.t > arg1 || !qb[var10 - D + 25][var11 - E + 25] && this.q[var8][var10][var11] - arg3 < 2000) {
                        var12.u = false;
                        var12.v = false;
                        var12.x = 0;
                     } else {
                        var12.u = true;
                        var12.v = true;
                        if (var12.p > 0) {
                           var12.w = true;
                        } else {
                           var12.w = false;
                        }

                        ++w;
                     }
                  }
               }
            }
         }

         for(int var13 = this.s; var13 < this.n; ++var13) {
            Square[][] var14 = this.r[var13];

            for(int var15 = -25; var15 <= 0; ++var15) {
               int var16 = D + var15;
               int var17 = D - var15;
               if (var16 >= z || var17 < A) {
                  for(int var18 = -25; var18 <= 0; ++var18) {
                     int var19 = E + var18;
                     int var20 = E - var18;
                     if (var16 >= z) {
                        if (var19 >= B) {
                           Square var21 = var14[var16][var19];
                           if (var21 != null && var21.u) {
                              this.a(var21, true);
                           }
                        }

                        if (var20 < C) {
                           Square var22 = var14[var16][var20];
                           if (var22 != null && var22.u) {
                              this.a(var22, true);
                           }
                        }
                     }

                     if (var17 < A) {
                        if (var19 >= B) {
                           Square var23 = var14[var17][var19];
                           if (var23 != null && var23.u) {
                              this.a(var23, true);
                           }
                        }

                        if (var20 < C) {
                           Square var24 = var14[var17][var20];
                           if (var24 != null && var24.u) {
                              this.a(var24, true);
                           }
                        }
                     }

                     if (w == 0) {
                        R = false;
                        return;
                     }
                  }
               }
            }
         }

         for(int var25 = this.s; var25 < this.n; ++var25) {
            Square[][] var26 = this.r[var25];

            for(int var27 = -25; var27 <= 0; ++var27) {
               int var28 = D + var27;
               int var29 = D - var27;
               if (var28 >= z || var29 < A) {
                  for(int var30 = -25; var30 <= 0; ++var30) {
                     int var31 = E + var30;
                     int var32 = E - var30;
                     if (var28 >= z) {
                        if (var31 >= B) {
                           Square var33 = var26[var28][var31];
                           if (var33 != null && var33.u) {
                              this.a(var33, false);
                           }
                        }

                        if (var32 < C) {
                           Square var34 = var26[var28][var32];
                           if (var34 != null && var34.u) {
                              this.a(var34, false);
                           }
                        }
                     }

                     if (var29 < A) {
                        if (var31 >= B) {
                           Square var35 = var26[var29][var31];
                           if (var35 != null && var35.u) {
                              this.a(var35, false);
                           }
                        }

                        if (var32 < C) {
                           Square var36 = var26[var29][var32];
                           if (var36 != null && var36.u) {
                              this.a(var36, false);
                           }
                        }
                     }

                     if (w == 0) {
                        R = false;
                        return;
                     }
                  }
               }
            }
         }

         R = false;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(LRIEEXHOP;Z)V")
   public void a(Square arg0, boolean arg1) {
      bb.push(arg0);

      while(true) {
         Square var3;
         int var4;
         int var5;
         int var6;
         int var7;
         Square[][] var8;
         Square var70;
         do {
            Square var69;
            do {
               Square var68;
               do {
                  Square var67;
                  do {
                     do {
                        do {
                           while(true) {
                              while(true) {
                                 do {
                                    var3 = (Square)bb.pop();
                                    if (var3 == null) {
                                       return;
                                    }
                                 } while(!var3.v);

                                 var4 = var3.g;
                                 var5 = var3.h;
                                 var6 = var3.f;
                                 var7 = var3.i;
                                 var8 = this.r[var6];
                                 if (!var3.u) {
                                    break;
                                 }

                                 if (arg1) {
                                    if (var6 > 0) {
                                       Square var9 = this.r[var6 - 1][var4][var5];
                                       if (var9 != null && var9.v) {
                                          continue;
                                       }
                                    }

                                    if (var4 <= D && var4 > z) {
                                       Square var10 = var8[var4 - 1][var5];
                                       if (var10 != null && var10.v && (var10.u || (var3.s & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (var4 >= D && var4 < A - 1) {
                                       Square var11 = var8[var4 + 1][var5];
                                       if (var11 != null && var11.v && (var11.u || (var3.s & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (var5 <= E && var5 > B) {
                                       Square var12 = var8[var4][var5 - 1];
                                       if (var12 != null && var12.v && (var12.u || (var3.s & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (var5 >= E && var5 < C - 1) {
                                       Square var13 = var8[var4][var5 + 1];
                                       if (var13 != null && var13.v && (var13.u || (var3.s & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    arg1 = true;
                                 }

                                 var3.u = false;
                                 if (var3.B != null) {
                                    Square var14 = var3.B;
                                    if (var14.j != null) {
                                       if (!this.g(0, var4, var5)) {
                                          this.a(var14.j, 0, I, J, K, L, var4, var5);
                                       }
                                    } else if (var14.k != null && !this.g(0, var4, var5)) {
                                       this.a(J, L, var14.k, I, var5, var4, K, (byte)3);
                                    }

                                    Wall var15 = var14.l;
                                    if (var15 != null) {
                                       var15.f.a(0, I, J, K, L, var15.b - F, var15.a - G, var15.c - H, var15.h);
                                    }

                                    for(int var16 = 0; var16 < var14.p; ++var16) {
                                       Loc var17 = var14.q[var16];
                                       if (var17 != null) {
                                          var17.e.a(var17.f, I, J, K, L, var17.c - F, var17.b - G, var17.d - H, var17.m);
                                       }
                                    }
                                 }

                                 boolean var18 = false;
                                 if (var3.j != null) {
                                    if (!this.g(var7, var4, var5)) {
                                       var18 = true;
                                       this.a(var3.j, var7, I, J, K, L, var4, var5);
                                    }
                                 } else if (var3.k != null && !this.g(var7, var4, var5)) {
                                    var18 = true;
                                    this.a(J, L, var3.k, I, var5, var4, K, (byte)3);
                                 }

                                 int var19 = 0;
                                 int var20 = 0;
                                 Wall var21 = var3.l;
                                 Decor var22 = var3.m;
                                 if (var21 != null || var22 != null) {
                                    if (D == var4) {
                                       ++var19;
                                    } else if (D < var4) {
                                       var19 += 2;
                                    }

                                    if (E == var5) {
                                       var19 += 3;
                                    } else if (E > var5) {
                                       var19 += 6;
                                    }

                                    var20 = cb[var19];
                                    var3.A = eb[var19];
                                 }

                                 if (var21 != null) {
                                    if ((var21.d & db[var19]) != 0) {
                                       if (var21.d == 16) {
                                          var3.x = 3;
                                          var3.y = fb[var19];
                                          var3.z = 3 - var3.y;
                                       } else if (var21.d == 32) {
                                          var3.x = 6;
                                          var3.y = gb[var19];
                                          var3.z = 6 - var3.y;
                                       } else if (var21.d == 64) {
                                          var3.x = 12;
                                          var3.y = hb[var19];
                                          var3.z = 12 - var3.y;
                                       } else {
                                          var3.x = 9;
                                          var3.y = ib[var19];
                                          var3.z = 9 - var3.y;
                                       }
                                    } else {
                                       var3.x = 0;
                                    }

                                    if ((var21.d & var20) != 0 && !this.g(var7, var4, var5, var21.d)) {
                                       var21.f.a(0, I, J, K, L, var21.b - F, var21.a - G, var21.c - H, var21.h);
                                    }

                                    if ((var21.e & var20) != 0 && !this.g(var7, var4, var5, var21.e)) {
                                       var21.g.a(0, I, J, K, L, var21.b - F, var21.a - G, var21.c - H, var21.h);
                                    }
                                 }

                                 if (var22 != null && !this.h(var7, var4, var5, var22.f.k)) {
                                    if ((var22.d & var20) != 0) {
                                       var22.f.a(var22.e, I, J, K, L, var22.b - F, var22.a - G, var22.c - H, var22.g);
                                    } else if ((var22.d & 768) != 0) {
                                       int var23 = var22.b - F;
                                       int var24 = var22.a - G;
                                       int var25 = var22.c - H;
                                       int var26 = var22.e;
                                       int var27;
                                       if (var26 != 1 && var26 != 2) {
                                          var27 = var23;
                                       } else {
                                          var27 = -var23;
                                       }

                                       int var28;
                                       if (var26 != 2 && var26 != 3) {
                                          var28 = var25;
                                       } else {
                                          var28 = -var25;
                                       }

                                       if ((var22.d & 256) != 0 && var28 < var27) {
                                          int var29 = N[var26] + var23;
                                          int var30 = O[var26] + var25;
                                          var22.f.a(var26 * 512 + 256, I, J, K, L, var29, var24, var30, var22.g);
                                       }

                                       if ((var22.d & 512) != 0 && var28 > var27) {
                                          int var31 = P[var26] + var23;
                                          int var32 = Q[var26] + var25;
                                          var22.f.a(var26 * 512 + 1280 & 2047, I, J, K, L, var31, var24, var32, var22.g);
                                       }
                                    }
                                 }

                                 if (var18) {
                                    GroundDecor var33 = var3.n;
                                    if (var33 != null) {
                                       var33.d.a(0, I, J, K, L, var33.b - F, var33.a - G, var33.c - H, var33.e);
                                    }

                                    GroundObject var34 = var3.o;
                                    if (var34 != null && var34.h == 0) {
                                       if (var34.e != null) {
                                          var34.e.a(0, I, J, K, L, var34.b - F, var34.a - G, var34.c - H, var34.g);
                                       }

                                       if (var34.f != null) {
                                          var34.f.a(0, I, J, K, L, var34.b - F, var34.a - G, var34.c - H, var34.g);
                                       }

                                       if (var34.d != null) {
                                          var34.d.a(0, I, J, K, L, var34.b - F, var34.a - G, var34.c - H, var34.g);
                                       }
                                    }
                                 }

                                 int var35 = var3.s;
                                 if (var35 != 0) {
                                    if (var4 < D && (var35 & 4) != 0) {
                                       Square var36 = var8[var4 + 1][var5];
                                       if (var36 != null && var36.v) {
                                          bb.push(var36);
                                       }
                                    }

                                    if (var5 < E && (var35 & 2) != 0) {
                                       Square var37 = var8[var4][var5 + 1];
                                       if (var37 != null && var37.v) {
                                          bb.push(var37);
                                       }
                                    }

                                    if (var4 > D && (var35 & 1) != 0) {
                                       Square var38 = var8[var4 - 1][var5];
                                       if (var38 != null && var38.v) {
                                          bb.push(var38);
                                       }
                                    }

                                    if (var5 > E && (var35 & 8) != 0) {
                                       Square var39 = var8[var4][var5 - 1];
                                       if (var39 != null && var39.v) {
                                          bb.push(var39);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if (var3.x != 0) {
                                 boolean var40 = true;

                                 for(int var41 = 0; var41 < var3.p; ++var41) {
                                    if (y != var3.q[var41].l && (var3.r[var41] & var3.x) == var3.y) {
                                       var40 = false;
                                       break;
                                    }
                                 }

                                 if (var40) {
                                    Wall var42 = var3.l;
                                    if (!this.g(var7, var4, var5, var42.d)) {
                                       var42.f.a(0, I, J, K, L, var42.b - F, var42.a - G, var42.c - H, var42.h);
                                    }

                                    var3.x = 0;
                                 }
                              }

                              if (!var3.w) {
                                 break;
                              }

                              try {
                                 int var43 = var3.p;
                                 var3.w = false;
                                 int var44 = 0;

                                 label559:
                                 for(int var45 = 0; var45 < var43; ++var45) {
                                    Loc var46 = var3.q[var45];
                                    if (y != var46.l) {
                                       for(int var47 = var46.g; var47 <= var46.h; ++var47) {
                                          for(int var48 = var46.i; var48 <= var46.j; ++var48) {
                                             Square var49 = var8[var47][var48];
                                             if (var49.u) {
                                                var3.w = true;
                                                continue label559;
                                             }

                                             if (var49.x != 0) {
                                                int var50 = 0;
                                                if (var47 > var46.g) {
                                                   ++var50;
                                                }

                                                if (var47 < var46.h) {
                                                   var50 += 4;
                                                }

                                                if (var48 > var46.i) {
                                                   var50 += 8;
                                                }

                                                if (var48 < var46.j) {
                                                   var50 += 2;
                                                }

                                                if ((var50 & var49.x) == var3.z) {
                                                   var3.w = true;
                                                   continue label559;
                                                }
                                             }
                                          }
                                       }

                                       M[var44++] = var46;
                                       int var51 = D - var46.g;
                                       int var52 = var46.h - D;
                                       if (var52 > var51) {
                                          var51 = var52;
                                       }

                                       int var53 = E - var46.i;
                                       int var54 = var46.j - E;
                                       if (var54 > var53) {
                                          var46.k = var51 + var54;
                                       } else {
                                          var46.k = var51 + var53;
                                       }
                                    }
                                 }

                                 while(var44 > 0) {
                                    int var55 = -50;
                                    int var56 = -1;

                                    for(int var57 = 0; var57 < var44; ++var57) {
                                       Loc var58 = M[var57];
                                       if (y != var58.l) {
                                          if (var58.k > var55) {
                                             var55 = var58.k;
                                             var56 = var57;
                                          } else if (var58.k == var55) {
                                             int var59 = var58.c - F;
                                             int var60 = var58.d - H;
                                             int var61 = M[var56].c - F;
                                             int var62 = M[var56].d - H;
                                             if (var59 * var59 + var60 * var60 > var61 * var61 + var62 * var62) {
                                                var56 = var57;
                                             }
                                          }
                                       }
                                    }

                                    if (var56 == -1) {
                                       break;
                                    }

                                    Loc var63 = M[var56];
                                    var63.l = y;
                                    if (!this.a(var7, var63.g, var63.h, var63.i, var63.j, var63.e.k)) {
                                       var63.e.a(var63.f, I, J, K, L, var63.c - F, var63.b - G, var63.d - H, var63.m);
                                    }

                                    for(int var64 = var63.g; var64 <= var63.h; ++var64) {
                                       for(int var65 = var63.i; var65 <= var63.j; ++var65) {
                                          Square var66 = var8[var64][var65];
                                          if (var66.x != 0) {
                                             bb.push(var66);
                                          } else if ((var4 != var64 || var5 != var65) && var66.v) {
                                             bb.push(var66);
                                          }
                                       }
                                    }
                                 }

                                 if (!var3.w) {
                                    break;
                                 }
                              } catch (Exception var89) {
                                 var3.w = false;
                                 break;
                              }
                           }
                        } while(!var3.v);
                     } while(var3.x != 0);

                     if (var4 > D || var4 <= z) {
                        break;
                     }

                     var67 = var8[var4 - 1][var5];
                  } while(var67 != null && var67.v);

                  if (var4 < D || var4 >= A - 1) {
                     break;
                  }

                  var68 = var8[var4 + 1][var5];
               } while(var68 != null && var68.v);

               if (var5 > E || var5 <= B) {
                  break;
               }

               var69 = var8[var4][var5 - 1];
            } while(var69 != null && var69.v);

            if (var5 < E || var5 >= C - 1) {
               break;
            }

            var70 = var8[var4][var5 + 1];
         } while(var70 != null && var70.v);

         var3.v = false;
         --w;
         GroundObject var71 = var3.o;
         if (var71 != null && var71.h != 0) {
            if (var71.e != null) {
               var71.e.a(0, I, J, K, L, var71.b - F, var71.a - G - var71.h, var71.c - H, var71.g);
            }

            if (var71.f != null) {
               var71.f.a(0, I, J, K, L, var71.b - F, var71.a - G - var71.h, var71.c - H, var71.g);
            }

            if (var71.d != null) {
               var71.d.a(0, I, J, K, L, var71.b - F, var71.a - G - var71.h, var71.c - H, var71.g);
            }
         }

         if (var3.A != 0) {
            Decor var72 = var3.m;
            if (var72 != null && !this.h(var7, var4, var5, var72.f.k)) {
               if ((var72.d & var3.A) != 0) {
                  var72.f.a(var72.e, I, J, K, L, var72.b - F, var72.a - G, var72.c - H, var72.g);
               } else if ((var72.d & 768) != 0) {
                  int var73 = var72.b - F;
                  int var74 = var72.a - G;
                  int var75 = var72.c - H;
                  int var76 = var72.e;
                  int var77;
                  if (var76 != 1 && var76 != 2) {
                     var77 = var73;
                  } else {
                     var77 = -var73;
                  }

                  int var78;
                  if (var76 != 2 && var76 != 3) {
                     var78 = var75;
                  } else {
                     var78 = -var75;
                  }

                  if ((var72.d & 256) != 0 && var78 >= var77) {
                     int var79 = N[var76] + var73;
                     int var80 = O[var76] + var75;
                     var72.f.a(var76 * 512 + 256, I, J, K, L, var79, var74, var80, var72.g);
                  }

                  if ((var72.d & 512) != 0 && var78 <= var77) {
                     int var81 = P[var76] + var73;
                     int var82 = Q[var76] + var75;
                     var72.f.a(var76 * 512 + 1280 & 2047, I, J, K, L, var81, var74, var82, var72.g);
                  }
               }
            }

            Wall var83 = var3.l;
            if (var83 != null) {
               if ((var83.e & var3.A) != 0 && !this.g(var7, var4, var5, var83.e)) {
                  var83.g.a(0, I, J, K, L, var83.b - F, var83.a - G, var83.c - H, var83.h);
               }

               if ((var83.d & var3.A) != 0 && !this.g(var7, var4, var5, var83.d)) {
                  var83.f.a(0, I, J, K, L, var83.b - F, var83.a - G, var83.c - H, var83.h);
               }
            }
         }

         if (var6 < this.n - 1) {
            Square var84 = this.r[var6 + 1][var4][var5];
            if (var84 != null && var84.v) {
               bb.push(var84);
            }
         }

         if (var4 < D) {
            Square var85 = var8[var4 + 1][var5];
            if (var85 != null && var85.v) {
               bb.push(var85);
            }
         }

         if (var5 < E) {
            Square var86 = var8[var4][var5 + 1];
            if (var86 != null && var86.v) {
               bb.push(var86);
            }
         }

         if (var4 > D) {
            Square var87 = var8[var4 - 1][var5];
            if (var87 != null && var87.v) {
               bb.push(var87);
            }
         }

         if (var5 > E) {
            Square var88 = var8[var4][var5 - 1];
            if (var88 != null && var88.v) {
               bb.push(var88);
            }
         }
      }
   }

   @ObfuscatedName("KJCMXHNO.a(LAYYYSATX;IIIIIII)V")
   public void a(QuickGround arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
      int var9;
      int var10 = var9 = (arg6 << 7) - F;
      int var11;
      int var12 = var11 = (arg7 << 7) - H;
      int var13;
      int var14 = var13 = var10 + 128;
      int var15;
      int var16 = var15 = var12 + 128;
      int var17 = this.q[arg1][arg6][arg7] - G;
      int var18 = this.q[arg1][arg6 + 1][arg7] - G;
      int var19 = this.q[arg1][arg6 + 1][arg7 + 1] - G;
      int var20 = this.q[arg1][arg6][arg7 + 1] - G;
      int var21 = arg4 * var12 + arg5 * var10 >> 16;
      int var22 = arg5 * var12 - arg4 * var10 >> 16;
      int var24 = arg3 * var17 - arg2 * var22 >> 16;
      int var25 = arg2 * var17 + arg3 * var22 >> 16;
      if (var25 >= 50) {
         int var27 = arg4 * var11 + arg5 * var14 >> 16;
         int var28 = arg5 * var11 - arg4 * var14 >> 16;
         int var30 = arg3 * var18 - arg2 * var28 >> 16;
         int var31 = arg2 * var18 + arg3 * var28 >> 16;
         if (var31 >= 50) {
            int var33 = arg4 * var16 + arg5 * var13 >> 16;
            int var34 = arg5 * var16 - arg4 * var13 >> 16;
            int var36 = arg3 * var19 - arg2 * var34 >> 16;
            int var37 = arg2 * var19 + arg3 * var34 >> 16;
            if (var37 >= 50) {
               int var39 = arg4 * var15 + arg5 * var9 >> 16;
               int var40 = arg5 * var15 - arg4 * var9 >> 16;
               int var42 = arg3 * var20 - arg2 * var40 >> 16;
               int var43 = arg2 * var20 + arg3 * var40 >> 16;
               if (var43 >= 50) {
                  int var45 = (var21 << 9) / var25 + Pix3D.E;
                  int var46 = (var24 << 9) / var25 + Pix3D.F;
                  int var47 = (var27 << 9) / var31 + Pix3D.E;
                  int var48 = (var30 << 9) / var31 + Pix3D.F;
                  int var49 = (var33 << 9) / var37 + Pix3D.E;
                  int var50 = (var36 << 9) / var37 + Pix3D.F;
                  int var51 = (var39 << 9) / var43 + Pix3D.E;
                  int var52 = (var42 << 9) / var43 + Pix3D.F;
                  Pix3D.D = 0;
                  if ((var48 - var52) * (var49 - var51) - (var47 - var51) * (var50 - var52) > 0) {
                     Pix3D.A = false;
                     if (var49 < 0 || var51 < 0 || var47 < 0 || var49 > Pix2D.safeWidth || var51 > Pix2D.safeWidth || var47 > Pix2D.safeWidth) {
                        Pix3D.A = true;
                     }

                     if (R && this.a(S, T, var50, var52, var48, var49, var51, var47)) {
                        U = arg6;
                        V = arg7;
                     }

                     if (arg0.e == -1) {
                        if (arg0.c != 12345678) {
                           Pix3D.a(var50, var52, var48, var49, var51, var47, arg0.c, arg0.d, arg0.b);
                        }
                     } else if (!m) {
                        if (arg0.f) {
                           Pix3D.a(var50, var52, var48, var49, var51, var47, arg0.c, arg0.d, arg0.b, var21, var27, var39, var24, var30, var42, var25, var31, var43, arg0.e);
                        } else {
                           Pix3D.a(var50, var52, var48, var49, var51, var47, arg0.c, arg0.d, arg0.b, var33, var39, var27, var36, var42, var30, var37, var43, var31, arg0.e);
                        }
                     } else {
                        int var53 = jb[arg0.e];
                        Pix3D.a(var50, var52, var48, var49, var51, var47, this.f(arg0.c, var53, 0), this.f(arg0.d, var53, 0), this.f(arg0.b, var53, 0));
                     }
                  }

                  if ((var45 - var47) * (var52 - var48) - (var46 - var48) * (var51 - var47) > 0) {
                     Pix3D.A = false;
                     if (var45 < 0 || var47 < 0 || var51 < 0 || var45 > Pix2D.safeWidth || var47 > Pix2D.safeWidth || var51 > Pix2D.safeWidth) {
                        Pix3D.A = true;
                     }

                     if (R && this.a(S, T, var46, var48, var52, var45, var47, var51)) {
                        U = arg6;
                        V = arg7;
                     }

                     if (arg0.e == -1) {
                        if (arg0.a != 12345678) {
                           Pix3D.a(var46, var48, var52, var45, var47, var51, arg0.a, arg0.b, arg0.d);
                           return;
                        }
                     } else {
                        if (!m) {
                           Pix3D.a(var46, var48, var52, var45, var47, var51, arg0.a, arg0.b, arg0.d, var21, var27, var39, var24, var30, var42, var25, var31, var43, arg0.e);
                           return;
                        }

                        int var54 = jb[arg0.e];
                        Pix3D.a(var46, var48, var52, var45, var47, var51, this.f(arg0.a, var54, 0), this.f(arg0.b, var54, 0), this.f(arg0.d, var54, 0));
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IILJQCVNYYR;IIIIB)V")
   public void a(int arg0, int arg1, Ground arg2, int arg3, int arg4, int arg5, int arg6, byte arg7) {
      int var9 = arg2.b.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         int var11 = arg2.b[var10] - F;
         int var12 = arg2.c[var10] - G;
         int var13 = arg2.d[var10] - H;
         int var14 = arg1 * var11 + arg6 * var13 >> 16;
         int var15 = arg1 * var13 - arg6 * var11 >> 16;
         int var17 = arg0 * var12 - arg3 * var15 >> 16;
         int var18 = arg0 * var15 + arg3 * var12 >> 16;
         if (var18 < 50) {
            return;
         }

         if (arg2.k != null) {
            Ground.s[var10] = var14;
            Ground.t[var10] = var17;
            Ground.u[var10] = var18;
         }

         Ground.q[var10] = (var14 << 9) / var18 + Pix3D.E;
         Ground.r[var10] = (var17 << 9) / var18 + Pix3D.F;
      }

      Pix3D.D = 0;
      int var20 = arg2.h.length;
      if (arg7 == 3) {
         for(int var21 = 0; var21 < var20; ++var21) {
            int var22 = arg2.h[var21];
            int var23 = arg2.i[var21];
            int var24 = arg2.j[var21];
            int var25 = Ground.q[var22];
            int var26 = Ground.q[var23];
            int var27 = Ground.q[var24];
            int var28 = Ground.r[var22];
            int var29 = Ground.r[var23];
            int var30 = Ground.r[var24];
            if ((var25 - var26) * (var30 - var29) - (var27 - var26) * (var28 - var29) > 0) {
               Pix3D.A = false;
               if (var25 < 0 || var26 < 0 || var27 < 0 || var25 > Pix2D.safeWidth || var26 > Pix2D.safeWidth || var27 > Pix2D.safeWidth) {
                  Pix3D.A = true;
               }

               if (R && this.a(S, T, var28, var29, var30, var25, var26, var27)) {
                  U = arg5;
                  V = arg4;
               }

               if (arg2.k != null && arg2.k[var21] != -1) {
                  if (!m) {
                     if (arg2.l) {
                        Pix3D.a(var28, var29, var30, var25, var26, var27, arg2.e[var21], arg2.f[var21], arg2.g[var21], Ground.s[0], Ground.s[1], Ground.s[3], Ground.t[0], Ground.t[1], Ground.t[3], Ground.u[0], Ground.u[1], Ground.u[3], arg2.k[var21]);
                     } else {
                        Pix3D.a(var28, var29, var30, var25, var26, var27, arg2.e[var21], arg2.f[var21], arg2.g[var21], Ground.s[var22], Ground.s[var23], Ground.s[var24], Ground.t[var22], Ground.t[var23], Ground.t[var24], Ground.u[var22], Ground.u[var23], Ground.u[var24], arg2.k[var21]);
                     }
                  } else {
                     int var31 = jb[arg2.k[var21]];
                     Pix3D.a(var28, var29, var30, var25, var26, var27, this.f(arg2.e[var21], var31, 0), this.f(arg2.f[var21], var31, 0), this.f(arg2.g[var21], var31, 0));
                  }
               } else if (arg2.e[var21] != 12345678) {
                  Pix3D.a(var28, var29, var30, var25, var26, var27, arg2.e[var21], arg2.f[var21], arg2.g[var21]);
               }
            }
         }

      }
   }

   @ObfuscatedName("KJCMXHNO.f(III)I")
   public int f(int arg0, int arg1, int arg2) {
      int var4 = 127 - arg0;
      if (arg2 != 0) {
         return this.e;
      } else {
         int var5 = (arg1 & 127) * var4 / 160;
         if (var5 < 2) {
            var5 = 2;
         } else if (var5 > 126) {
            var5 = 126;
         }

         return (arg1 & 65408) + var5;
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIIIIIII)Z")
   public boolean a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
      if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4) {
         return false;
      } else if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
         return false;
      } else if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7) {
         return false;
      } else if (arg0 > arg5 && arg0 > arg6 && arg0 > arg7) {
         return false;
      } else {
         int var9 = (arg1 - arg2) * (arg6 - arg5) - (arg0 - arg5) * (arg3 - arg2);
         int var10 = (arg1 - arg4) * (arg5 - arg7) - (arg0 - arg7) * (arg2 - arg4);
         int var11 = (arg1 - arg3) * (arg7 - arg6) - (arg0 - arg6) * (arg4 - arg3);
         return var9 * var11 > 0 && var10 * var11 > 0;
      }
   }

   @ObfuscatedName("KJCMXHNO.b(I)V")
   public void b(int arg0) {
      int var2 = X[x];
      Occlude[] var3 = Y[x];
      if (arg0 < 2 || arg0 > 2) {
         this.c = !this.c;
      }

      Z = 0;

      for(int var4 = 0; var4 < var2; ++var4) {
         Occlude var5 = var3[var4];
         if (var5.e == 1) {
            int var6 = var5.a - D + 25;
            if (var6 >= 0 && var6 <= 50) {
               int var7 = var5.c - E + 25;
               if (var7 < 0) {
                  var7 = 0;
               }

               int var8 = var5.d - E + 25;
               if (var8 > 50) {
                  var8 = 50;
               }

               boolean var9 = false;

               while(var7 <= var8) {
                  if (qb[var6][var7++]) {
                     var9 = true;
                     break;
                  }
               }

               if (var9) {
                  int var10 = F - var5.f;
                  if (var10 > 32) {
                     var5.l = 1;
                  } else {
                     if (var10 >= -32) {
                        continue;
                     }

                     var5.l = 2;
                     var10 = -var10;
                  }

                  var5.o = (var5.h - H << 8) / var10;
                  var5.p = (var5.i - H << 8) / var10;
                  var5.q = (var5.j - G << 8) / var10;
                  var5.r = (var5.k - G << 8) / var10;
                  ab[Z++] = var5;
               }
            }
         } else if (var5.e == 2) {
            int var11 = var5.c - E + 25;
            if (var11 >= 0 && var11 <= 50) {
               int var12 = var5.a - D + 25;
               if (var12 < 0) {
                  var12 = 0;
               }

               int var13 = var5.b - D + 25;
               if (var13 > 50) {
                  var13 = 50;
               }

               boolean var14 = false;

               while(var12 <= var13) {
                  if (qb[var12++][var11]) {
                     var14 = true;
                     break;
                  }
               }

               if (var14) {
                  int var15 = H - var5.h;
                  if (var15 > 32) {
                     var5.l = 3;
                  } else {
                     if (var15 >= -32) {
                        continue;
                     }

                     var5.l = 4;
                     var15 = -var15;
                  }

                  var5.m = (var5.f - F << 8) / var15;
                  var5.n = (var5.g - F << 8) / var15;
                  var5.q = (var5.j - G << 8) / var15;
                  var5.r = (var5.k - G << 8) / var15;
                  ab[Z++] = var5;
               }
            }
         } else if (var5.e == 4) {
            int var16 = var5.j - G;
            if (var16 > 128) {
               int var17 = var5.c - E + 25;
               if (var17 < 0) {
                  var17 = 0;
               }

               int var18 = var5.d - E + 25;
               if (var18 > 50) {
                  var18 = 50;
               }

               if (var17 <= var18) {
                  int var19 = var5.a - D + 25;
                  if (var19 < 0) {
                     var19 = 0;
                  }

                  int var20 = var5.b - D + 25;
                  if (var20 > 50) {
                     var20 = 50;
                  }

                  boolean var21 = false;

                  label150:
                  for(int var22 = var19; var22 <= var20; ++var22) {
                     for(int var23 = var17; var23 <= var18; ++var23) {
                        if (qb[var22][var23]) {
                           var21 = true;
                           break label150;
                        }
                     }
                  }

                  if (var21) {
                     var5.l = 5;
                     var5.m = (var5.f - F << 8) / var16;
                     var5.n = (var5.g - F << 8) / var16;
                     var5.o = (var5.h - H << 8) / var16;
                     var5.p = (var5.i - H << 8) / var16;
                     ab[Z++] = var5;
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("KJCMXHNO.g(III)Z")
   public boolean g(int arg0, int arg1, int arg2) {
      int var4 = this.v[arg0][arg1][arg2];
      if (-y == var4) {
         return false;
      } else if (y == var4) {
         return true;
      } else {
         int var5 = arg1 << 7;
         int var6 = arg2 << 7;
         if (this.h(var5 + 1, this.q[arg0][arg1][arg2], var6 + 1) && this.h(var5 + 128 - 1, this.q[arg0][arg1 + 1][arg2], var6 + 1) && this.h(var5 + 128 - 1, this.q[arg0][arg1 + 1][arg2 + 1], var6 + 128 - 1) && this.h(var5 + 1, this.q[arg0][arg1][arg2 + 1], var6 + 128 - 1)) {
            this.v[arg0][arg1][arg2] = y;
            return true;
         } else {
            this.v[arg0][arg1][arg2] = -y;
            return false;
         }
      }
   }

   @ObfuscatedName("KJCMXHNO.g(IIII)Z")
   public boolean g(int arg0, int arg1, int arg2, int arg3) {
      if (!this.g(arg0, arg1, arg2)) {
         return false;
      } else {
         int var5 = arg1 << 7;
         int var6 = arg2 << 7;
         int var7 = this.q[arg0][arg1][arg2] - 1;
         int var8 = var7 - 120;
         int var9 = var7 - 230;
         int var10 = var7 - 238;
         if (arg3 < 16) {
            if (arg3 == 1) {
               if (var5 > F) {
                  if (!this.h(var5, var7, var6)) {
                     return false;
                  }

                  if (!this.h(var5, var7, var6 + 128)) {
                     return false;
                  }
               }

               if (arg0 > 0) {
                  if (!this.h(var5, var8, var6)) {
                     return false;
                  }

                  if (!this.h(var5, var8, var6 + 128)) {
                     return false;
                  }
               }

               if (!this.h(var5, var9, var6)) {
                  return false;
               }

               if (!this.h(var5, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if (arg3 == 2) {
               if (var6 < H) {
                  if (!this.h(var5, var7, var6 + 128)) {
                     return false;
                  }

                  if (!this.h(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if (arg0 > 0) {
                  if (!this.h(var5, var8, var6 + 128)) {
                     return false;
                  }

                  if (!this.h(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if (!this.h(var5, var9, var6 + 128)) {
                  return false;
               }

               if (!this.h(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if (arg3 == 4) {
               if (var5 < F) {
                  if (!this.h(var5 + 128, var7, var6)) {
                     return false;
                  }

                  if (!this.h(var5 + 128, var7, var6 + 128)) {
                     return false;
                  }
               }

               if (arg0 > 0) {
                  if (!this.h(var5 + 128, var8, var6)) {
                     return false;
                  }

                  if (!this.h(var5 + 128, var8, var6 + 128)) {
                     return false;
                  }
               }

               if (!this.h(var5 + 128, var9, var6)) {
                  return false;
               }

               if (!this.h(var5 + 128, var9, var6 + 128)) {
                  return false;
               }

               return true;
            }

            if (arg3 == 8) {
               if (var6 > H) {
                  if (!this.h(var5, var7, var6)) {
                     return false;
                  }

                  if (!this.h(var5 + 128, var7, var6)) {
                     return false;
                  }
               }

               if (arg0 > 0) {
                  if (!this.h(var5, var8, var6)) {
                     return false;
                  }

                  if (!this.h(var5 + 128, var8, var6)) {
                     return false;
                  }
               }

               if (!this.h(var5, var9, var6)) {
                  return false;
               }

               if (!this.h(var5 + 128, var9, var6)) {
                  return false;
               }

               return true;
            }
         }

         if (!this.h(var5 + 64, var10, var6 + 64)) {
            return false;
         } else if (arg3 == 16) {
            return this.h(var5, var9, var6 + 128);
         } else if (arg3 == 32) {
            return this.h(var5 + 128, var9, var6 + 128);
         } else if (arg3 == 64) {
            return this.h(var5 + 128, var9, var6);
         } else if (arg3 == 128) {
            return this.h(var5, var9, var6);
         } else {
            System.out.println("Warning unsupported wall type");
            return true;
         }
      }
   }

   @ObfuscatedName("KJCMXHNO.h(IIII)Z")
   public boolean h(int arg0, int arg1, int arg2, int arg3) {
      if (!this.g(arg0, arg1, arg2)) {
         return false;
      } else {
         int var5 = arg1 << 7;
         int var6 = arg2 << 7;
         return this.h(var5 + 1, this.q[arg0][arg1][arg2] - arg3, var6 + 1) && this.h(var5 + 128 - 1, this.q[arg0][arg1 + 1][arg2] - arg3, var6 + 1) && this.h(var5 + 128 - 1, this.q[arg0][arg1 + 1][arg2 + 1] - arg3, var6 + 128 - 1) && this.h(var5 + 1, this.q[arg0][arg1][arg2 + 1] - arg3, var6 + 128 - 1);
      }
   }

   @ObfuscatedName("KJCMXHNO.a(IIIIII)Z")
   public boolean a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
      if (arg1 == arg2 && arg3 == arg4) {
         if (!this.g(arg0, arg1, arg3)) {
            return false;
         } else {
            int var7 = arg1 << 7;
            int var8 = arg3 << 7;
            return this.h(var7 + 1, this.q[arg0][arg1][arg3] - arg5, var8 + 1) && this.h(var7 + 128 - 1, this.q[arg0][arg1 + 1][arg3] - arg5, var8 + 1) && this.h(var7 + 128 - 1, this.q[arg0][arg1 + 1][arg3 + 1] - arg5, var8 + 128 - 1) && this.h(var7 + 1, this.q[arg0][arg1][arg3 + 1] - arg5, var8 + 128 - 1);
         }
      } else {
         for(int var9 = arg1; var9 <= arg2; ++var9) {
            for(int var10 = arg3; var10 <= arg4; ++var10) {
               if (this.v[arg0][var9][var10] == -y) {
                  return false;
               }
            }
         }

         int var11 = (arg1 << 7) + 1;
         int var12 = (arg3 << 7) + 2;
         int var13 = this.q[arg0][arg1][arg3] - arg5;
         if (!this.h(var11, var13, var12)) {
            return false;
         } else {
            int var14 = (arg2 << 7) - 1;
            if (!this.h(var14, var13, var12)) {
               return false;
            } else {
               int var15 = (arg4 << 7) - 1;
               if (!this.h(var11, var13, var15)) {
                  return false;
               } else if (!this.h(var14, var13, var15)) {
                  return false;
               } else {
                  return true;
               }
            }
         }
      }
   }

   @ObfuscatedName("KJCMXHNO.h(III)Z")
   public boolean h(int arg0, int arg1, int arg2) {
      for(int var4 = 0; var4 < Z; ++var4) {
         Occlude var5 = ab[var4];
         if (var5.l == 1) {
            int var6 = var5.f - arg0;
            if (var6 > 0) {
               int var7 = (var5.o * var6 >> 8) + var5.h;
               int var8 = (var5.p * var6 >> 8) + var5.i;
               int var9 = (var5.q * var6 >> 8) + var5.j;
               int var10 = (var5.r * var6 >> 8) + var5.k;
               if (arg2 >= var7 && arg2 <= var8 && arg1 >= var9 && arg1 <= var10) {
                  return true;
               }
            }
         } else if (var5.l == 2) {
            int var11 = arg0 - var5.f;
            if (var11 > 0) {
               int var12 = (var5.o * var11 >> 8) + var5.h;
               int var13 = (var5.p * var11 >> 8) + var5.i;
               int var14 = (var5.q * var11 >> 8) + var5.j;
               int var15 = (var5.r * var11 >> 8) + var5.k;
               if (arg2 >= var12 && arg2 <= var13 && arg1 >= var14 && arg1 <= var15) {
                  return true;
               }
            }
         } else if (var5.l == 3) {
            int var16 = var5.h - arg2;
            if (var16 > 0) {
               int var17 = (var5.m * var16 >> 8) + var5.f;
               int var18 = (var5.n * var16 >> 8) + var5.g;
               int var19 = (var5.q * var16 >> 8) + var5.j;
               int var20 = (var5.r * var16 >> 8) + var5.k;
               if (arg0 >= var17 && arg0 <= var18 && arg1 >= var19 && arg1 <= var20) {
                  return true;
               }
            }
         } else if (var5.l == 4) {
            int var21 = arg2 - var5.h;
            if (var21 > 0) {
               int var22 = (var5.m * var21 >> 8) + var5.f;
               int var23 = (var5.n * var21 >> 8) + var5.g;
               int var24 = (var5.q * var21 >> 8) + var5.j;
               int var25 = (var5.r * var21 >> 8) + var5.k;
               if (arg0 >= var22 && arg0 <= var23 && arg1 >= var24 && arg1 <= var25) {
                  return true;
               }
            }
         } else if (var5.l == 5) {
            int var26 = arg1 - var5.j;
            if (var26 > 0) {
               int var27 = (var5.m * var26 >> 8) + var5.f;
               int var28 = (var5.n * var26 >> 8) + var5.g;
               int var29 = (var5.o * var26 >> 8) + var5.h;
               int var30 = (var5.p * var26 >> 8) + var5.i;
               if (arg0 >= var27 && arg0 <= var28 && arg2 >= var29 && arg2 <= var30) {
                  return true;
               }
            }
         }
      }

      return false;
   }
}
