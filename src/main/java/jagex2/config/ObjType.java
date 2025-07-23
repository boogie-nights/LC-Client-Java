package jagex2.config;

import deob.*;
import jagex2.dash3d.Model;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Pix24;
import jagex2.graphics.Pix2D;
import jagex2.graphics.Pix3D;
import jagex2.io.Jagfile;
import jagex2.io.Packet;

public class ObjType {
   @ObfuscatedName("GSCQQEUA.x")
   public boolean x = true;
   @ObfuscatedName("GSCQQEUA.z")
   public int z = -68;
   @ObfuscatedName("GSCQQEUA.L")
   public int L = -1;
   @ObfuscatedName("GSCQQEUA.W")
   public boolean W = true;
   @ObfuscatedName("GSCQQEUA.l")
   public static LruCache l = new LruCache(50);
   @ObfuscatedName("GSCQQEUA.s")
   public static boolean membersWorld = true;
   @ObfuscatedName("GSCQQEUA.u")
   public static LruCache u = new LruCache(100);
   @ObfuscatedName("GSCQQEUA.v")
   public static byte v = 6;
   @ObfuscatedName("GSCQQEUA.y")
   public static boolean y = true;
   @ObfuscatedName("GSCQQEUA.ab")
   public byte ab;
   @ObfuscatedName("GSCQQEUA.e")
   public byte e;
   @ObfuscatedName("GSCQQEUA.A")
   public static int A;
   @ObfuscatedName("GSCQQEUA.B")
   public int B;
   @ObfuscatedName("GSCQQEUA.C")
   public int C;
   @ObfuscatedName("GSCQQEUA.D")
   public int D;
   @ObfuscatedName("GSCQQEUA.E")
   public int E;
   @ObfuscatedName("GSCQQEUA.F")
   public int F;
   @ObfuscatedName("GSCQQEUA.G")
   public int G;
   @ObfuscatedName("GSCQQEUA.H")
   public int H;
   @ObfuscatedName("GSCQQEUA.I")
   public int I;
   @ObfuscatedName("GSCQQEUA.J")
   public int J;
   @ObfuscatedName("GSCQQEUA.K")
   public int K;
   @ObfuscatedName("GSCQQEUA.O")
   public int O;
   @ObfuscatedName("GSCQQEUA.P")
   public int P;
   @ObfuscatedName("GSCQQEUA.Q")
   public int Q;
   @ObfuscatedName("GSCQQEUA.R")
   public int R;
   @ObfuscatedName("GSCQQEUA.S")
   public int S;
   @ObfuscatedName("GSCQQEUA.U")
   public int U;
   @ObfuscatedName("GSCQQEUA.X")
   public int X;
   @ObfuscatedName("GSCQQEUA.a")
   public int a;
   @ObfuscatedName("GSCQQEUA.b")
   public int b;
   @ObfuscatedName("GSCQQEUA.f")
   public int f;
   @ObfuscatedName("GSCQQEUA.g")
   public int g;
   @ObfuscatedName("GSCQQEUA.h")
   public int h;
   @ObfuscatedName("GSCQQEUA.i")
   public int i;
   @ObfuscatedName("GSCQQEUA.j")
   public static int j;
   @ObfuscatedName("GSCQQEUA.n")
   public int n;
   @ObfuscatedName("GSCQQEUA.o")
   public int o;
   @ObfuscatedName("GSCQQEUA.r")
   public int r;
   @ObfuscatedName("GSCQQEUA.t")
   public int t;
   @ObfuscatedName("GSCQQEUA.V")
   public static Packet V;
   @ObfuscatedName("GSCQQEUA.d")
   public String d;
   @ObfuscatedName("GSCQQEUA.T")
   public boolean T;
   @ObfuscatedName("GSCQQEUA.Z")
   public boolean Z;
   @ObfuscatedName("GSCQQEUA.c")
   public byte[] c;
   @ObfuscatedName("GSCQQEUA.M")
   public int[] M;
   @ObfuscatedName("GSCQQEUA.N")
   public int[] N;
   @ObfuscatedName("GSCQQEUA.Y")
   public int[] Y;
   @ObfuscatedName("GSCQQEUA.p")
   public int[] p;
   @ObfuscatedName("GSCQQEUA.q")
   public static int[] q;
   @ObfuscatedName("GSCQQEUA.k")
   public static ObjType[] k;
   @ObfuscatedName("GSCQQEUA.m")
   public String[] m;
   @ObfuscatedName("GSCQQEUA.w")
   public String[] w;

   @ObfuscatedName("GSCQQEUA.a(II)Z")
   public final boolean a(int arg0, int arg1) {
      int var3 = this.i;
      int var4 = this.J;
      if (arg1 != 0) {
         this.x = !this.x;
      }

      if (arg0 == 1) {
         var3 = this.X;
         var4 = this.K;
      }

      if (var3 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if (!Model.b(var3)) {
            var5 = false;
         }

         if (var4 != -1 && !Model.b(var4)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("GSCQQEUA.a(I)LGSCQQEUA;")
   public static final ObjType get(int arg0) {
      for(int var1 = 0; var1 < 10; ++var1) {
         if (k[var1].L == arg0) {
            return k[var1];
         }
      }

      A = (A + 1) % 10;
      ObjType var2 = k[A];
      V.pos = q[arg0];
      var2.L = arg0;
      var2.a();
      var2.a(v, V);
      if (var2.r != -1) {
         var2.b(0);
      }

      if (!membersWorld && var2.Z) {
         var2.d = "Members Object";
         var2.c = "Login to a members' server to use this object.".getBytes();
         var2.m = null;
         var2.w = null;
         var2.g = 0;
      }

      return var2;
   }

   @ObfuscatedName("GSCQQEUA.a(BI)LLZYQDKJV;")
   public final Model a(byte arg0, int arg1) {
      int var3 = this.B;
      int var4 = this.f;
      int var5 = this.S;
      if (arg1 == 1) {
         var3 = this.a;
         var4 = this.D;
         var5 = this.P;
      }

      if (var3 == -1) {
         return null;
      } else {
         Model var6 = Model.a(var3);
         if (arg0 != -98) {
            throw new NullPointerException();
         } else {
            if (var4 != -1) {
               if (var5 != -1) {
                  Model var7 = Model.a(var4);
                  Model var8 = Model.a(var5);
                  Model[] var9 = new Model[]{var6, var7, var8};
                  var6 = new Model(3, var9, (byte)-89);
               } else {
                  Model var10 = Model.a(var4);
                  Model[] var11 = new Model[]{var6, var10};
                  var6 = new Model(2, var11, (byte)-89);
               }
            }

            if (arg1 == 0 && this.ab != 0) {
               var6.a(0, 0, false, this.ab);
            }

            if (arg1 == 1 && this.e != 0) {
               var6.a(0, 0, false, this.e);
            }

            if (this.M != null) {
               for(int var12 = 0; var12 < this.M.length; ++var12) {
                  var6.recolour(this.M[var12], this.p[var12]);
               }
            }

            return var6;
         }
      }
   }

   @ObfuscatedName("GSCQQEUA.a(LATJMVOZR;)V")
   public static final void unpack(Jagfile arg0) {
      V = new Packet(arg0.read("obj.dat", (byte[])null));
      Packet var1 = new Packet(arg0.read("obj.idx", (byte[])null));
      j = var1.g2();
      q = new int[j];
      int var2 = 2;

      for(int var3 = 0; var3 < j; ++var3) {
         q[var3] = var2;
         var2 += var1.g2();
      }

      k = new ObjType[10];

      for(int var4 = 0; var4 < 10; ++var4) {
         k[var4] = new ObjType();
      }

   }

   @ObfuscatedName("GSCQQEUA.b(I)V")
   public void b(int arg0) {
      ObjType var2 = get(this.r);
      this.I = var2.I;
      this.R = var2.R;
      if (arg0 != 0) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

      this.H = var2.H;
      this.E = var2.E;
      this.n = var2.n;
      this.b = var2.b;
      this.o = var2.o;
      this.M = var2.M;
      this.p = var2.p;
      ObjType var4 = get(this.h);
      this.d = var4.d;
      this.Z = var4.Z;
      this.t = var4.t;
      String var5 = "a";
      char var6 = var4.d.charAt(0);
      if (var6 == 'A' || var6 == 'E' || var6 == 'I' || var6 == 'O' || var6 == 'U') {
         var5 = "an";
      }

      this.c = ("Swap this note at any bank for " + var5 + " " + var4.d + ".").getBytes();
      this.T = true;
   }

   @ObfuscatedName("GSCQQEUA.b(II)Z")
   public final boolean b(int arg0, int arg1) {
      while(arg0 >= 0) {
      }

      int var3 = this.B;
      int var4 = this.f;
      int var5 = this.S;
      if (arg1 == 1) {
         var3 = this.a;
         var4 = this.D;
         var5 = this.P;
      }

      if (var3 == -1) {
         return true;
      } else {
         boolean var6 = true;
         if (!Model.b(var3)) {
            var6 = false;
         }

         if (var4 != -1 && !Model.b(var4)) {
            var6 = false;
         }

         if (var5 != -1 && !Model.b(var5)) {
            var6 = false;
         }

         return var6;
      }
   }

   @ObfuscatedName("GSCQQEUA.c(II)LLZYQDKJV;")
   public final Model getInvModel(int arg0, int arg1) {
      if (this.N != null && arg1 > 1) {
         int var3 = -1;

         for(int var4 = 0; var4 < 10; ++var4) {
            if (arg1 >= this.Y[var4] && this.Y[var4] != 0) {
               var3 = this.N[var4];
            }
         }

         if (var3 != -1) {
            return get(var3).getInvModel(this.z, 1);
         }
      }

      Model var5 = Model.a(this.I);

      while(arg0 >= 0) {
         this.x = !this.x;
      }

      if (var5 == null) {
         return null;
      } else {
         if (this.M != null) {
            for(int var6 = 0; var6 < this.M.length; ++var6) {
               var5.recolour(this.M[var6], this.p[var6]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("GSCQQEUA.a(BLMFMVIYHT;)V")
   public final void a(byte arg0, Packet arg1) {
      if (arg0 != 6) {
         this.x = !this.x;
      }

      while(true) {
         while(true) {
            int var3 = arg1.g1();
            if (var3 == 0) {
               return;
            }

            if (var3 == 1) {
               this.I = arg1.g2();
            } else if (var3 == 2) {
               this.d = arg1.gjstr();
            } else if (var3 == 3) {
               this.c = arg1.gjstrraw();
            } else if (var3 == 4) {
               this.R = arg1.g2();
            } else if (var3 == 5) {
               this.H = arg1.g2();
            } else if (var3 == 6) {
               this.E = arg1.g2();
            } else if (var3 == 7) {
               this.b = arg1.g2();
               if (this.b > 32767) {
                  this.b -= 65536;
               }
            } else if (var3 == 8) {
               this.o = arg1.g2();
               if (this.o > 32767) {
                  this.o -= 65536;
               }
            } else if (var3 == 10) {
               this.U = arg1.g2();
            } else if (var3 == 11) {
               this.T = true;
            } else if (var3 == 12) {
               this.t = arg1.g4();
            } else if (var3 == 16) {
               this.Z = true;
            } else if (var3 == 23) {
               this.B = arg1.g2();
               this.ab = arg1.g1b();
            } else if (var3 == 24) {
               this.f = arg1.g2();
            } else if (var3 == 25) {
               this.a = arg1.g2();
               this.e = arg1.g1b();
            } else if (var3 == 26) {
               this.D = arg1.g2();
            } else if (var3 >= 30 && var3 < 35) {
               if (this.m == null) {
                  this.m = new String[5];
               }

               this.m[var3 - 30] = arg1.gjstr();
               if (this.m[var3 - 30].equalsIgnoreCase("hidden")) {
                  this.m[var3 - 30] = null;
               }
            } else if (var3 >= 35 && var3 < 40) {
               if (this.w == null) {
                  this.w = new String[5];
               }

               this.w[var3 - 35] = arg1.gjstr();
            } else if (var3 == 40) {
               int var4 = arg1.g1();
               this.M = new int[var4];
               this.p = new int[var4];

               for(int var5 = 0; var5 < var4; ++var5) {
                  this.M[var5] = arg1.g2();
                  this.p[var5] = arg1.g2();
               }
            } else if (var3 == 78) {
               this.S = arg1.g2();
            } else if (var3 == 79) {
               this.P = arg1.g2();
            } else if (var3 == 90) {
               this.i = arg1.g2();
            } else if (var3 == 91) {
               this.X = arg1.g2();
            } else if (var3 == 92) {
               this.J = arg1.g2();
            } else if (var3 == 93) {
               this.K = arg1.g2();
            } else if (var3 == 95) {
               this.n = arg1.g2();
            } else if (var3 == 97) {
               this.h = arg1.g2();
            } else if (var3 == 98) {
               this.r = arg1.g2();
            } else if (var3 >= 100 && var3 < 110) {
               if (this.N == null) {
                  this.N = new int[10];
                  this.Y = new int[10];
               }

               this.N[var3 - 100] = arg1.g2();
               this.Y[var3 - 100] = arg1.g2();
            } else if (var3 == 110) {
               this.O = arg1.g2();
            } else if (var3 == 111) {
               this.F = arg1.g2();
            } else if (var3 == 112) {
               this.Q = arg1.g2();
            } else if (var3 == 113) {
               this.C = arg1.g1b();
            } else if (var3 == 114) {
               this.G = arg1.g1b() * 5;
            } else if (var3 == 115) {
               this.g = arg1.g1();
            }
         }
      }
   }

   @ObfuscatedName("GSCQQEUA.a(ZI)LLZYQDKJV;")
   public final Model a(boolean arg0, int arg1) {
      if (!arg0) {
         this.W = !this.W;
      }

      int var3 = this.i;
      int var4 = this.J;
      if (arg1 == 1) {
         var3 = this.X;
         var4 = this.K;
      }

      if (var3 == -1) {
         return null;
      } else {
         Model var5 = Model.a(var3);
         if (var4 != -1) {
            Model var6 = Model.a(var4);
            Model[] var7 = new Model[]{var5, var6};
            var5 = new Model(2, var7, (byte)-89);
         }

         if (this.M != null) {
            for(int var8 = 0; var8 < this.M.length; ++var8) {
               var5.recolour(this.M[var8], this.p[var8]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("GSCQQEUA.c(I)LLZYQDKJV;")
   public final Model c(int arg0) {
      if (this.N != null && arg0 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if (arg0 >= this.Y[var3] && this.Y[var3] != 0) {
               var2 = this.N[var3];
            }
         }

         if (var2 != -1) {
            return get(var2).c(1);
         }
      }

      Model var4 = (Model)l.get((long)this.L);
      if (var4 != null) {
         return var4;
      } else {
         Model var5 = Model.a(this.I);
         if (var5 == null) {
            return null;
         } else {
            if (this.O != 128 || this.F != 128 || this.Q != 128) {
               var5.a(this.F, this.Q, 9, this.O);
            }

            if (this.M != null) {
               for(int var6 = 0; var6 < this.M.length; ++var6) {
                  var5.recolour(this.M[var6], this.p[var6]);
               }
            }

            var5.calculateNormals(this.C + 64, this.G + 768, -50, -10, -50, true);
            var5.eb = true;
            l.put(var5, (long)this.L);
            return var5;
         }
      }
   }

   @ObfuscatedName("GSCQQEUA.a(BIII)LEPQDEJTO;")
   public static final Pix24 a(byte arg0, int arg1, int arg2, int arg3) {
      if (arg1 == 0) {
         Pix24 var4 = (Pix24)u.get((long)arg3);
         if (var4 != null && var4.O != arg2 && var4.O != -1) {
            var4.unlink();
            var4 = null;
         }

         if (var4 != null) {
            return var4;
         }
      }

      ObjType var5 = get(arg3);
      if (var5.N == null) {
         arg2 = -1;
      }

      if (arg2 > 1) {
         int var6 = -1;

         for(int var7 = 0; var7 < 10; ++var7) {
            if (arg2 >= var5.Y[var7] && var5.Y[var7] != 0) {
               var6 = var5.N[var7];
            }
         }

         if (var6 != -1) {
            var5 = get(var6);
         }
      }

      Model var8 = var5.c(1);
      if (var8 == null) {
         return null;
      } else {
         Pix24 var9 = null;
         if (var5.r != -1) {
            var9 = a((byte)-33, -1, 10, var5.h);
            if (var9 == null) {
               return null;
            }
         }

         Pix24 var10 = new Pix24(32, 32);
         int var11 = Pix3D.E;
         int var12 = Pix3D.F;
         int[] var13 = Pix3D.lineOffset;
         int[] var14 = Pix2D.data;
         int var15 = Pix2D.width2d;
         int var16 = Pix2D.height2d;
         int var17 = Pix2D.left;
         int var18 = Pix2D.right;
         int var19 = Pix2D.top;
         int var20 = Pix2D.bottom;
         Pix3D.C = false;
         Pix2D.bind(32, var10.I, 32);
         Pix2D.fillRect(0, 32, 32, 0, 0);
         Pix3D.b((int)568);
         int var21 = var5.R;
         if (arg1 == -1) {
            var21 = (int)((double)var21 * 1.5D);
         }

         if (arg1 > 0) {
            var21 = (int)((double)var21 * 1.04D);
         }

         int var22 = Pix3D.sinTable[var5.H] * var21 >> 16;
         int var23 = Pix3D.J[var5.H] * var21 >> 16;
         var8.a(0, var5.E, var5.n, var5.H, var5.b, var8.k / 2 + var22 + var5.o, var5.o + var23);

         for(int var24 = 31; var24 >= 0; --var24) {
            for(int var25 = 31; var25 >= 0; --var25) {
               if (var10.I[var25 * 32 + var24] == 0) {
                  if (var24 > 0 && var10.I[var25 * 32 + (var24 - 1)] > 1) {
                     var10.I[var25 * 32 + var24] = 1;
                  } else if (var25 > 0 && var10.I[(var25 - 1) * 32 + var24] > 1) {
                     var10.I[var25 * 32 + var24] = 1;
                  } else if (var24 < 31 && var10.I[var25 * 32 + var24 + 1] > 1) {
                     var10.I[var25 * 32 + var24] = 1;
                  } else if (var25 < 31 && var10.I[(var25 + 1) * 32 + var24] > 1) {
                     var10.I[var25 * 32 + var24] = 1;
                  }
               }
            }
         }

         if (arg1 > 0) {
            for(int var26 = 31; var26 >= 0; --var26) {
               for(int var27 = 31; var27 >= 0; --var27) {
                  if (var10.I[var27 * 32 + var26] == 0) {
                     if (var26 > 0 && var10.I[var27 * 32 + (var26 - 1)] == 1) {
                        var10.I[var27 * 32 + var26] = arg1;
                     } else if (var27 > 0 && var10.I[(var27 - 1) * 32 + var26] == 1) {
                        var10.I[var27 * 32 + var26] = arg1;
                     } else if (var26 < 31 && var10.I[var27 * 32 + var26 + 1] == 1) {
                        var10.I[var27 * 32 + var26] = arg1;
                     } else if (var27 < 31 && var10.I[(var27 + 1) * 32 + var26] == 1) {
                        var10.I[var27 * 32 + var26] = arg1;
                     }
                  }
               }
            }
         } else if (arg1 == 0) {
            for(int var28 = 31; var28 >= 0; --var28) {
               for(int var29 = 31; var29 >= 0; --var29) {
                  if (var10.I[var29 * 32 + var28] == 0 && var28 > 0 && var29 > 0 && var10.I[(var29 - 1) * 32 + (var28 - 1)] > 0) {
                     var10.I[var29 * 32 + var28] = 3153952;
                  }
               }
            }
         }

         if (var5.r != -1) {
            int var30 = var9.N;
            int var31 = var9.O;
            var9.N = 32;
            var9.O = 32;
            var9.b(0, 0, -488);
            var9.N = var30;
            var9.O = var31;
         }

         if (arg1 == 0) {
            u.put(var10, (long)arg3);
         }

         Pix2D.bind(var15, var14, var16);
         Pix2D.setBounds(var18, var20, var19, var17);
         Pix3D.E = var11;
         Pix3D.F = var12;
         Pix3D.lineOffset = var13;
         Pix3D.C = true;
         if (var5.T) {
            var10.N = 33;
         } else {
            var10.N = 32;
         }

         var10.O = arg2;
         if (arg0 != -33) {
            throw new NullPointerException();
         } else {
            return var10;
         }
      }
   }

   @ObfuscatedName("GSCQQEUA.a(Z)V")
   public static final void a(boolean arg0) {
      l = null;
      if (arg0) {
         for(int var1 = 1; var1 > 0; ++var1) {
         }
      }

      u = null;
      q = null;
      k = null;
      V = null;
   }

   @ObfuscatedName("GSCQQEUA.a()V")
   public final void a() {
      this.I = 0;
      this.d = null;
      this.c = null;
      this.M = null;
      this.p = null;
      this.R = 2000;
      this.H = 0;
      this.E = 0;
      this.n = 0;
      this.b = 0;
      this.o = 0;
      this.U = -1;
      this.T = false;
      this.t = 1;
      this.Z = false;
      this.m = null;
      this.w = null;
      this.B = -1;
      this.f = -1;
      this.ab = 0;
      this.a = -1;
      this.D = -1;
      this.e = 0;
      this.S = -1;
      this.P = -1;
      this.i = -1;
      this.J = -1;
      this.X = -1;
      this.K = -1;
      this.N = null;
      this.Y = null;
      this.h = -1;
      this.r = -1;
      this.O = 128;
      this.F = 128;
      this.Q = 128;
      this.C = 0;
      this.G = 0;
      this.g = 0;
   }
}
