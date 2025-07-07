package jagex2.config;

import deob.*;
import jagex2.client.Client;
import jagex2.dash3d.AnimFrame;
import jagex2.dash3d.Model;
import jagex2.datastruct.LruCache;
import jagex2.io.Jagfile;
import jagex2.io.OnDemand;
import jagex2.io.Packet;

public class LocType {
   @ObfuscatedName("YMYTDPVW.k")
   public int k = -992;
   @ObfuscatedName("YMYTDPVW.p")
   public int p = -1;
   @ObfuscatedName("YMYTDPVW.q")
   public boolean q = true;
   @ObfuscatedName("YMYTDPVW.s")
   public String s = "null";
   @ObfuscatedName("YMYTDPVW.C")
   public boolean C = true;
   @ObfuscatedName("YMYTDPVW.J")
   public byte J = -113;
   @ObfuscatedName("YMYTDPVW.e")
   public static LruCache e = new LruCache(40, -572);
   @ObfuscatedName("YMYTDPVW.n")
   public static Model[] n = new Model[4];
   @ObfuscatedName("YMYTDPVW.v")
   public static LruCache v = new LruCache(500, -572);
   @ObfuscatedName("YMYTDPVW.Q")
   public static byte Q = 6;
   @ObfuscatedName("YMYTDPVW.A")
   public byte A;
   @ObfuscatedName("YMYTDPVW.D")
   public byte D;
   @ObfuscatedName("YMYTDPVW.B")
   public int B;
   @ObfuscatedName("YMYTDPVW.E")
   public int E;
   @ObfuscatedName("YMYTDPVW.K")
   public int K;
   @ObfuscatedName("YMYTDPVW.L")
   public int L;
   @ObfuscatedName("YMYTDPVW.M")
   public int M;
   @ObfuscatedName("YMYTDPVW.R")
   public int R;
   @ObfuscatedName("YMYTDPVW.S")
   public int S;
   @ObfuscatedName("YMYTDPVW.T")
   public int T;
   @ObfuscatedName("YMYTDPVW.W")
   public int W;
   @ObfuscatedName("YMYTDPVW.Y")
   public static int Y;
   @ObfuscatedName("YMYTDPVW.c")
   public int c;
   @ObfuscatedName("YMYTDPVW.d")
   public int d;
   @ObfuscatedName("YMYTDPVW.g")
   public int g;
   @ObfuscatedName("YMYTDPVW.i")
   public int i;
   @ObfuscatedName("YMYTDPVW.r")
   public int r;
   @ObfuscatedName("YMYTDPVW.t")
   public static int t;
   @ObfuscatedName("YMYTDPVW.u")
   public int u;
   @ObfuscatedName("YMYTDPVW.w")
   public int w;
   @ObfuscatedName("YMYTDPVW.x")
   public int x;
   @ObfuscatedName("YMYTDPVW.j")
   public static Packet j;
   @ObfuscatedName("YMYTDPVW.m")
   public static Client m;
   @ObfuscatedName("YMYTDPVW.H")
   public boolean H;
   @ObfuscatedName("YMYTDPVW.N")
   public boolean N;
   @ObfuscatedName("YMYTDPVW.O")
   public boolean O;
   @ObfuscatedName("YMYTDPVW.U")
   public boolean U;
   @ObfuscatedName("YMYTDPVW.X")
   public boolean X;
   @ObfuscatedName("YMYTDPVW.Z")
   public boolean Z;
   @ObfuscatedName("YMYTDPVW.ab")
   public boolean ab;
   @ObfuscatedName("YMYTDPVW.b")
   public boolean b;
   @ObfuscatedName("YMYTDPVW.h")
   public boolean h;
   @ObfuscatedName("YMYTDPVW.l")
   public boolean l;
   @ObfuscatedName("YMYTDPVW.o")
   public static boolean o;
   @ObfuscatedName("YMYTDPVW.z")
   public byte[] z;
   @ObfuscatedName("YMYTDPVW.F")
   public int[] F;
   @ObfuscatedName("YMYTDPVW.I")
   public int[] I;
   @ObfuscatedName("YMYTDPVW.P")
   public int[] P;
   @ObfuscatedName("YMYTDPVW.V")
   public int[] V;
   @ObfuscatedName("YMYTDPVW.a")
   public static int[] a;
   @ObfuscatedName("YMYTDPVW.f")
   public int[] f;
   @ObfuscatedName("YMYTDPVW.y")
   public static LocType[] y;
   @ObfuscatedName("YMYTDPVW.G")
   public String[] G;

   @ObfuscatedName("YMYTDPVW.a(I)LYMYTDPVW;")
   public static final LocType a(int arg0) {
      for(int var1 = 0; var1 < 20; ++var1) {
         if (y[var1].p == arg0) {
            return y[var1];
         }
      }

      t = (t + 1) % 20;
      LocType var2 = y[t];
      j.pos = a[arg0];
      var2.p = arg0;
      var2.a();
      var2.a(Q, j);
      return var2;
   }

   @ObfuscatedName("YMYTDPVW.b(I)LYMYTDPVW;")
   public final LocType b(int arg0) {
      if (arg0 != 0) {
         this.E = 445;
      }

      int var2 = -1;
      if (this.u != -1) {
         VarbitType var3 = VarbitType.c[this.u];
         int var4 = var3.e;
         int var5 = var3.f;
         int var6 = var3.g;
         int var7 = Client.Yh[var6 - var5];
         var2 = m.Ee[var4] >> var5 & var7;
      } else if (this.x != -1) {
         var2 = m.Ee[this.x];
      }

      return var2 >= 0 && var2 < this.V.length && this.V[var2] != -1 ? a(this.V[var2]) : null;
   }

   @ObfuscatedName("YMYTDPVW.a(LZPGPWCCV;I)V")
   public final void a(OnDemand arg0, int arg1) {
      if (this.f != null) {
         for(int var3 = 0; var3 < this.f.length; ++var3) {
            arg0.a(this.f[var3] & 65535, 0, this.J);
         }

         if (arg1 >= 0) {
            for(int var4 = 1; var4 > 0; ++var4) {
            }

         }
      }
   }

   @ObfuscatedName("YMYTDPVW.a(LATJMVOZR;)V")
   public static final void a(Jagfile arg0) {
      j = new Packet(arg0.read("loc.dat", (byte[])null));
      Packet var1 = new Packet(arg0.read("loc.idx", (byte[])null));
      Y = var1.g2();
      a = new int[Y];
      int var2 = 2;

      for(int var3 = 0; var3 < Y; ++var3) {
         a[var3] = var2;
         var2 += var1.g2();
      }

      y = new LocType[20];

      for(int var4 = 0; var4 < 20; ++var4) {
         y[var4] = new LocType();
      }

   }

   @ObfuscatedName("YMYTDPVW.a(IIII)LLZYQDKJV;")
   public final Model a(int arg0, int arg1, int arg2, int arg3) {
      Model var5 = null;
      long var6;
      if (this.F == null) {
         if (arg3 != 10) {
            return null;
         }

         var6 = ((long)(arg1 + 1) << 32) + (long)((this.p << 6) + arg0);
         Model var8 = (Model)e.a(var6);
         if (var8 != null) {
            return var8;
         }

         if (this.f == null) {
            return null;
         }

         boolean var9 = this.O ^ arg0 > 3;
         int var10 = this.f.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            int var12 = this.f[var11];
            if (var9) {
               var12 += 65536;
            }

            var5 = (Model)v.a((long)var12);
            if (var5 == null) {
               var5 = Model.a(var12 & 65535);
               if (var5 == null) {
                  return null;
               }

               if (var9) {
                  var5.g(0);
               }

               v.a(var5, (long)var12, 5);
            }

            if (var10 > 1) {
               n[var11] = var5;
            }
         }

         if (var10 > 1) {
            var5 = new Model(var10, n, (byte)-89);
         }
      } else {
         int var13 = -1;

         for(int var14 = 0; var14 < this.F.length; ++var14) {
            if (this.F[var14] == arg3) {
               var13 = var14;
               break;
            }
         }

         if (var13 == -1) {
            return null;
         }

         var6 = ((long)(arg1 + 1) << 32) + (long)((this.p << 6) + (var13 << 3) + arg0);
         Model var15 = (Model)e.a(var6);
         if (var15 != null) {
            return var15;
         }

         int var16 = this.f[var13];
         boolean var17 = this.O ^ arg0 > 3;
         if (var17) {
            var16 += 65536;
         }

         var5 = (Model)v.a((long)var16);
         if (var5 == null) {
            var5 = Model.a(var16 & 65535);
            if (var5 == null) {
               return null;
            }

            if (var17) {
               var5.g(0);
            }

            v.a(var5, (long)var16, 5);
         }
      }

      boolean var18;
      if (this.w == 128 && this.c == 128 && this.M == 128) {
         var18 = false;
      } else {
         var18 = true;
      }

      boolean var19;
      if (this.d == 0 && this.B == 0 && this.i == 0) {
         var19 = false;
      } else {
         var19 = true;
      }

      Model var20 = new Model(arg0 == 0 && arg1 == -1 && !var18 && !var19, false, this.P == null, var5, AnimFrame.a(this.q, arg1));
      if (arg2 != 0) {
         this.k = 487;
      }

      if (arg1 != -1) {
         var20.f(7);
         var20.a(arg1, (byte)6);
         var20.db = null;
         var20.cb = null;
      }

      while(arg0-- > 0) {
         var20.b(true);
      }

      if (this.P != null) {
         for(int var21 = 0; var21 < this.P.length; ++var21) {
            var20.c(this.P[var21], this.I[var21]);
         }
      }

      if (var18) {
         var20.a(this.c, this.M, 9, this.w);
      }

      if (var19) {
         var20.a(this.d, this.i, false, this.B);
      }

      var20.a(this.A + 64, this.D * 5 + 768, -50, -10, -50, !this.U);
      if (this.K == 1) {
         var20.Z = var20.k;
      }

      e.a(var20, var6, 5);
      return var20;
   }

   @ObfuscatedName("YMYTDPVW.c(I)Z")
   public final boolean c(int arg0) {
      if (this.f == null) {
         return true;
      } else {
         boolean var2 = true;

         while(arg0 >= 0) {
            this.k = 347;
         }

         for(int var3 = 0; var3 < this.f.length; ++var3) {
            var2 &= Model.b(this.f[var3] & 65535);
         }

         return var2;
      }
   }

   @ObfuscatedName("YMYTDPVW.a()V")
   public final void a() {
      this.f = null;
      this.F = null;
      this.s = "null";
      this.z = null;
      this.P = null;
      this.I = null;
      this.R = 1;
      this.r = 1;
      this.ab = true;
      this.Z = true;
      this.b = false;
      this.l = false;
      this.U = false;
      this.N = false;
      this.T = -1;
      this.S = 16;
      this.A = 0;
      this.D = 0;
      this.G = null;
      this.W = -1;
      this.L = -1;
      this.O = false;
      this.X = true;
      this.w = 128;
      this.c = 128;
      this.M = 128;
      this.g = 0;
      this.d = 0;
      this.B = 0;
      this.i = 0;
      this.h = false;
      this.H = false;
      this.K = -1;
      this.u = -1;
      this.x = -1;
      this.V = null;
   }

   @ObfuscatedName("YMYTDPVW.a(BLMFMVIYHT;)V")
   public final void a(byte arg0, Packet arg1) {
      int var3 = -1;
      if (arg0 != 6) {
         throw new NullPointerException();
      } else {
         while(true) {
            while(true) {
               int var5;
               do {
                  while(true) {
                     int var4 = arg1.g1();
                     if (var4 == 0) {
                        if (var3 == -1) {
                           this.b = false;
                           if (this.f != null && (this.F == null || this.F[0] == 10)) {
                              this.b = true;
                           }

                           if (this.G != null) {
                              this.b = true;
                           }
                        }

                        if (this.H) {
                           this.ab = false;
                           this.Z = false;
                        }

                        if (this.K == -1) {
                           this.K = this.ab ? 1 : 0;
                           return;
                        }

                        return;
                     }

                     if (var4 == 1) {
                        var5 = arg1.g1();
                        break;
                     }

                     if (var4 == 2) {
                        this.s = arg1.gjstr();
                     } else if (var4 == 3) {
                        this.z = arg1.gjstrraw();
                     } else if (var4 == 5) {
                        int var7 = arg1.g1();
                        if (var7 > 0) {
                           if (this.f != null && !o) {
                              arg1.pos += var7 * 2;
                           } else {
                              this.F = null;
                              this.f = new int[var7];

                              for(int var8 = 0; var8 < var7; ++var8) {
                                 this.f[var8] = arg1.g2();
                              }
                           }
                        }
                     } else if (var4 == 14) {
                        this.R = arg1.g1();
                     } else if (var4 == 15) {
                        this.r = arg1.g1();
                     } else if (var4 == 17) {
                        this.ab = false;
                     } else if (var4 == 18) {
                        this.Z = false;
                     } else if (var4 == 19) {
                        var3 = arg1.g1();
                        if (var3 == 1) {
                           this.b = true;
                        }
                     } else if (var4 == 21) {
                        this.l = true;
                     } else if (var4 == 22) {
                        this.U = true;
                     } else if (var4 == 23) {
                        this.N = true;
                     } else if (var4 == 24) {
                        this.T = arg1.g2();
                        if (this.T == 65535) {
                           this.T = -1;
                        }
                     } else if (var4 == 28) {
                        this.S = arg1.g1();
                     } else if (var4 == 29) {
                        this.A = arg1.g1b();
                     } else if (var4 == 39) {
                        this.D = arg1.g1b();
                     } else if (var4 >= 30 && var4 < 39) {
                        if (this.G == null) {
                           this.G = new String[5];
                        }

                        this.G[var4 - 30] = arg1.gjstr();
                        if (this.G[var4 - 30].equalsIgnoreCase("hidden")) {
                           this.G[var4 - 30] = null;
                        }
                     } else if (var4 == 40) {
                        int var9 = arg1.g1();
                        this.P = new int[var9];
                        this.I = new int[var9];

                        for(int var10 = 0; var10 < var9; ++var10) {
                           this.P[var10] = arg1.g2();
                           this.I[var10] = arg1.g2();
                        }
                     } else if (var4 == 60) {
                        this.W = arg1.g2();
                     } else if (var4 == 62) {
                        this.O = true;
                     } else if (var4 == 64) {
                        this.X = false;
                     } else if (var4 == 65) {
                        this.w = arg1.g2();
                     } else if (var4 == 66) {
                        this.c = arg1.g2();
                     } else if (var4 == 67) {
                        this.M = arg1.g2();
                     } else if (var4 == 68) {
                        this.L = arg1.g2();
                     } else if (var4 == 69) {
                        this.g = arg1.g1();
                     } else if (var4 == 70) {
                        this.d = arg1.gb2();
                     } else if (var4 == 71) {
                        this.B = arg1.gb2();
                     } else if (var4 == 72) {
                        this.i = arg1.gb2();
                     } else if (var4 == 73) {
                        this.h = true;
                     } else if (var4 == 74) {
                        this.H = true;
                     } else if (var4 == 75) {
                        this.K = arg1.g1();
                     } else if (var4 == 77) {
                        this.u = arg1.g2();
                        if (this.u == 65535) {
                           this.u = -1;
                        }

                        this.x = arg1.g2();
                        if (this.x == 65535) {
                           this.x = -1;
                        }

                        int var11 = arg1.g1();
                        this.V = new int[var11 + 1];

                        for(int var12 = 0; var12 <= var11; ++var12) {
                           this.V[var12] = arg1.g2();
                           if (this.V[var12] == 65535) {
                              this.V[var12] = -1;
                           }
                        }
                     }
                  }
               } while(var5 <= 0);

               if (this.f != null && !o) {
                  arg1.pos += var5 * 3;
               } else {
                  this.F = new int[var5];
                  this.f = new int[var5];

                  for(int var6 = 0; var6 < var5; ++var6) {
                     this.f[var6] = arg1.g2();
                     this.F[var6] = arg1.g1();
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("YMYTDPVW.a(IIIIIII)LLZYQDKJV;")
   public final Model a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
      Model var8 = this.a(arg1, arg6, 0, arg0);
      if (var8 == null) {
         return null;
      } else {
         if (this.l || this.U) {
            var8 = new Model(this.l, this.U, 0, var8);
         }

         if (this.l) {
            int var9 = (arg2 + arg3 + arg4 + arg5) / 4;

            for(int var10 = 0; var10 < var8.y; ++var10) {
               int var11 = var8.z[var10];
               int var12 = var8.B[var10];
               int var13 = (arg3 - arg2) * (var11 + 64) / 128 + arg2;
               int var14 = (arg4 - arg5) * (var11 + 64) / 128 + arg5;
               int var15 = (var14 - var13) * (var12 + 64) / 128 + var13;
               var8.A[var10] += var15 - var9;
            }

            var8.d(6);
         }

         return var8;
      }
   }

   @ObfuscatedName("YMYTDPVW.a(II)Z")
   public final boolean a(int arg0, int arg1) {
      if (arg0 != 26261) {
         this.C = !this.C;
      }

      if (this.F == null) {
         if (this.f == null) {
            return true;
         } else if (arg1 != 10) {
            return true;
         } else {
            boolean var3 = true;

            for(int var4 = 0; var4 < this.f.length; ++var4) {
               var3 &= Model.b(this.f[var4] & 65535);
            }

            return var3;
         }
      } else {
         for(int var5 = 0; var5 < this.F.length; ++var5) {
            if (this.F[var5] == arg1) {
               return Model.b(this.f[var5] & 65535);
            }
         }

         return true;
      }
   }

   @ObfuscatedName("YMYTDPVW.a(Z)V")
   public static final void a(boolean arg0) {
      v = null;
      e = null;
      a = null;
      if (arg0) {
         for(int var1 = 1; var1 > 0; ++var1) {
         }
      }

      y = null;
      j = null;
   }
}
