package jagex2.config;

import deob.*;
import jagex2.client.Client;
import jagex2.dash3d.AnimFrame;
import jagex2.dash3d.Model;
import jagex2.datastruct.JString;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Pix24;
import jagex2.graphics.PixFont;
import jagex2.io.Jagfile;
import jagex2.io.Packet;

public class Component {
   @ObfuscatedName("EWIXBTLV.ib")
   public int ib = -68;
   @ObfuscatedName("EWIXBTLV.jb")
   public boolean jb = true;
   @ObfuscatedName("EWIXBTLV.K")
   public static int K = -1;
   @ObfuscatedName("EWIXBTLV.T")
   public static int T = -1;
   @ObfuscatedName("EWIXBTLV.cb")
   public static LruCache cb = new LruCache(30, -572);
   @ObfuscatedName("EWIXBTLV.nb")
   public static int nb = -291;
   @ObfuscatedName("EWIXBTLV.pb")
   public static int pb = -1;
   @ObfuscatedName("EWIXBTLV.qb")
   public static boolean qb = true;
   @ObfuscatedName("EWIXBTLV.rb")
   public static int rb = 373;
   @ObfuscatedName("EWIXBTLV.k")
   public byte k;
   @ObfuscatedName("EWIXBTLV.A")
   public int A;
   @ObfuscatedName("EWIXBTLV.Bb")
   public int Bb;
   @ObfuscatedName("EWIXBTLV.C")
   public int C;
   @ObfuscatedName("EWIXBTLV.E")
   public int E;
   @ObfuscatedName("EWIXBTLV.F")
   public int F;
   @ObfuscatedName("EWIXBTLV.G")
   public int G;
   @ObfuscatedName("EWIXBTLV.H")
   public static int H;
   @ObfuscatedName("EWIXBTLV.I")
   public int I;
   @ObfuscatedName("EWIXBTLV.M")
   public int M;
   @ObfuscatedName("EWIXBTLV.P")
   public int P;
   @ObfuscatedName("EWIXBTLV.Q")
   public int Q;
   @ObfuscatedName("EWIXBTLV.R")
   public int R;
   @ObfuscatedName("EWIXBTLV.S")
   public int S;
   @ObfuscatedName("EWIXBTLV.X")
   public int X;
   @ObfuscatedName("EWIXBTLV.Y")
   public int Y;
   @ObfuscatedName("EWIXBTLV.Z")
   public int Z;
   @ObfuscatedName("EWIXBTLV.a")
   public static int a;
   @ObfuscatedName("EWIXBTLV.bb")
   public int bb;
   @ObfuscatedName("EWIXBTLV.eb")
   public int eb;
   @ObfuscatedName("EWIXBTLV.f")
   public int f;
   @ObfuscatedName("EWIXBTLV.fb")
   public int fb;
   @ObfuscatedName("EWIXBTLV.i")
   public int i;
   @ObfuscatedName("EWIXBTLV.m")
   public int m;
   @ObfuscatedName("EWIXBTLV.p")
   public int p;
   @ObfuscatedName("EWIXBTLV.q")
   public int q;
   @ObfuscatedName("EWIXBTLV.r")
   public int r;
   @ObfuscatedName("EWIXBTLV.s")
   public int s;
   @ObfuscatedName("EWIXBTLV.sb")
   public static int sb;
   @ObfuscatedName("EWIXBTLV.v")
   public int v;
   @ObfuscatedName("EWIXBTLV.vb")
   public int vb;
   @ObfuscatedName("EWIXBTLV.wb")
   public int wb;
   @ObfuscatedName("EWIXBTLV.xb")
   public int xb;
   @ObfuscatedName("EWIXBTLV.yb")
   public int yb;
   @ObfuscatedName("EWIXBTLV.z")
   public int z;
   @ObfuscatedName("EWIXBTLV.zb")
   public int zb;
   @ObfuscatedName("EWIXBTLV.e")
   public static Jagfile e;
   @ObfuscatedName("EWIXBTLV.J")
   public Pix24 J;
   @ObfuscatedName("EWIXBTLV.c")
   public Pix24 c;
   @ObfuscatedName("EWIXBTLV.B")
   public PixFont B;
   @ObfuscatedName("EWIXBTLV.O")
   public static LruCache O;
   @ObfuscatedName("EWIXBTLV.N")
   public String N;
   @ObfuscatedName("EWIXBTLV.b")
   public String b;
   @ObfuscatedName("EWIXBTLV.gb")
   public String gb;
   @ObfuscatedName("EWIXBTLV.tb")
   public String tb;
   @ObfuscatedName("EWIXBTLV.u")
   public String u;
   @ObfuscatedName("EWIXBTLV.Ab")
   public boolean Ab;
   @ObfuscatedName("EWIXBTLV.D")
   public boolean D;
   @ObfuscatedName("EWIXBTLV.L")
   public boolean L;
   @ObfuscatedName("EWIXBTLV.V")
   public static boolean V;
   @ObfuscatedName("EWIXBTLV.h")
   public boolean h;
   @ObfuscatedName("EWIXBTLV.j")
   public boolean j;
   @ObfuscatedName("EWIXBTLV.kb")
   public boolean kb;
   @ObfuscatedName("EWIXBTLV.mb")
   public boolean mb;
   @ObfuscatedName("EWIXBTLV.t")
   public boolean t;
   @ObfuscatedName("EWIXBTLV.x")
   public boolean x;
   @ObfuscatedName("EWIXBTLV.U")
   public int[] U;
   @ObfuscatedName("EWIXBTLV.W")
   public int[] W;
   @ObfuscatedName("EWIXBTLV.d")
   public int[] d;
   @ObfuscatedName("EWIXBTLV.hb")
   public int[] hb;
   @ObfuscatedName("EWIXBTLV.l")
   public int[] l;
   @ObfuscatedName("EWIXBTLV.lb")
   public int[] lb;
   @ObfuscatedName("EWIXBTLV.o")
   public int[] o;
   @ObfuscatedName("EWIXBTLV.ob")
   public int[] ob;
   @ObfuscatedName("EWIXBTLV.w")
   public int[] w;
   @ObfuscatedName("EWIXBTLV.db")
   public Pix24[] db;
   @ObfuscatedName("EWIXBTLV.g")
   public static Component[] g;
   @ObfuscatedName("EWIXBTLV.n")
   public static PixFont[] n;
   @ObfuscatedName("EWIXBTLV.ab")
   public String[] ab;
   @ObfuscatedName("EWIXBTLV.ub")
   public static byte[][] ub;
   @ObfuscatedName("EWIXBTLV.y")
   public int[][] y;

   @ObfuscatedName("EWIXBTLV.a(ILjava/lang/String;I)LEPQDEJTO;")
   public static Pix24 a(int arg0, String arg1, int arg2) {
      long var3 = (JString.hashCode(arg1) << 8) + (long)arg0;
      if (arg2 <= 0) {
         nb = -317;
      }

      Pix24 var5 = (Pix24)O.get(var3);
      if (var5 != null) {
         return var5;
      } else if (e == null) {
         return null;
      } else {
         try {
            Pix24 var6 = new Pix24(e, arg1, arg0);
            O.put(var6, var3);
            return var6;
         } catch (Exception var7) {
            return null;
         }
      }
   }

   @ObfuscatedName("EWIXBTLV.a(I)LEWIXBTLV;")
   public static Component a(int arg0) {
      if (g[arg0] == null) {
         Packet var1 = new Packet(ub[arg0]);
         int var2 = var1.g2();
         g[arg0] = a(var2, (Packet)var1, 10896, arg0);
      }

      return g[arg0];
   }

   @ObfuscatedName("EWIXBTLV.a(III)V")
   public void a(int arg0, int arg1, int arg2) {
      int var4 = this.hb[arg2];
      this.hb[arg2] = this.hb[arg0];
      this.hb[arg0] = var4;
      int var5 = this.o[arg2];
      this.o[arg2] = this.o[arg0];
      if (arg1 < 0) {
         this.o[arg0] = var5;
      }
   }

   @ObfuscatedName("EWIXBTLV.a(II)LLZYQDKJV;")
   public Model a(int arg0, int arg1) {
      ObjType var3 = null;
      if (arg0 == 4) {
         var3 = ObjType.a(arg1);
         sb += var3.C;
         H += var3.G;
      }

      Model var4 = (Model)cb.get((long)((arg0 << 16) + arg1));
      if (var4 != null) {
         return var4;
      } else {
         if (arg0 == 1) {
            var4 = Model.a(arg1);
         }

         if (arg0 == 2) {
            var4 = NpcType.c(arg1).a(858);
         }

         if (arg0 == 3) {
            var4 = Client.dh.a(true);
         }

         if (arg0 == 4) {
            var4 = var3.c(this.ib, 50);
         }

         if (arg0 == 5) {
            var4 = null;
         }

         if (var4 != null) {
            cb.put(var4, (long)((arg0 << 16) + arg1));
         }

         return var4;
      }
   }

   @ObfuscatedName("EWIXBTLV.a(ILMFMVIYHT;II)LEWIXBTLV;")
   public static Component a(int arg0, Packet arg1, int arg2, int arg3) {
      Component var4 = new Component();
      var4.f = arg3;
      var4.M = arg0;
      var4.A = arg1.g1();
      var4.Bb = arg1.g1();
      var4.G = arg1.g2();
      var4.F = arg1.g2();
      var4.C = arg1.g2();
      if (arg2 != 10896) {
         qb = !qb;
      }

      var4.k = (byte)arg1.g1();
      var4.S = arg1.g1();
      if (var4.S != 0) {
         var4.S = (var4.S - 1 << 8) + arg1.g1();
      } else {
         var4.S = -1;
      }

      if (var4.G == 600) {
         K = arg0;
      }

      if (var4.G == 650) {
         T = arg0;
      }

      if (var4.G == 655) {
         pb = arg0;
      }

      int var5 = arg1.g1();
      if (var5 > 0) {
         var4.lb = new int[var5];
         var4.U = new int[var5];

         for(int var6 = 0; var6 < var5; ++var6) {
            var4.lb[var6] = arg1.g1();
            var4.U[var6] = arg1.g2();
         }
      }

      int var7 = arg1.g1();
      if (var7 > 0) {
         var4.y = new int[var7][];

         for(int var8 = 0; var8 < var7; ++var8) {
            int var9 = arg1.g2();
            var4.y[var8] = new int[var9];

            for(int var10 = 0; var10 < var9; ++var10) {
               var4.y[var8][var10] = arg1.g2();
            }
         }
      }

      if (var4.A == 0) {
         var4.xb = arg1.g2();
         var4.j = arg1.g1() == 1;
         int var11 = arg1.g2();
         var4.W = new int[var11];
         var4.w = new int[var11];
         var4.ob = new int[var11];

         for(int var12 = 0; var12 < var11; ++var12) {
            var4.W[var12] = arg1.g2();
            var4.w[var12] = arg1.gb2();
            var4.ob[var12] = arg1.gb2();
         }
      }

      if (var4.A == 1) {
         var4.p = arg1.g2();
         var4.x = arg1.g1() == 1;
      }

      if (var4.A == 2) {
         var4.hb = new int[var4.F * var4.C];
         var4.o = new int[var4.F * var4.C];
         var4.mb = arg1.g1() == 1;
         var4.t = arg1.g1() == 1;
         var4.Ab = arg1.g1() == 1;
         var4.h = arg1.g1() == 1;
         var4.bb = arg1.g1();
         var4.I = arg1.g1();
         var4.l = new int[20];
         var4.d = new int[20];
         var4.db = new Pix24[20];

         for(int var13 = 0; var13 < 20; ++var13) {
            int var14 = arg1.g1();
            if (var14 == 1) {
               var4.l[var13] = arg1.gb2();
               var4.d[var13] = arg1.gb2();
               String var15 = arg1.gjstr();
               if (var15.length() > 0) {
                  int var16 = var15.lastIndexOf(",");
                  var4.db[var13] = a(Integer.parseInt(var15.substring(var16 + 1)), var15.substring(0, var16), 373);
               }
            }
         }

         var4.ab = new String[5];

         for(int var17 = 0; var17 < 5; ++var17) {
            var4.ab[var17] = arg1.gjstr();
            if (var4.ab[var17].length() == 0) {
               var4.ab[var17] = null;
            }
         }
      }

      if (var4.A == 3) {
         var4.D = arg1.g1() == 1;
      }

      if (var4.A == 4 || var4.A == 1) {
         var4.kb = arg1.g1() == 1;
         int var18 = arg1.g1();
         if (n != null) {
            var4.B = n[var18];
         }

         var4.L = arg1.g1() == 1;
      }

      if (var4.A == 4) {
         var4.u = arg1.gjstr();
         var4.N = arg1.gjstr();
      }

      if (var4.A == 1 || var4.A == 3 || var4.A == 4) {
         var4.E = arg1.g4();
      }

      if (var4.A == 3 || var4.A == 4) {
         var4.Y = arg1.g4();
         var4.Z = arg1.g4();
         var4.q = arg1.g4();
      }

      if (var4.A == 5) {
         String var19 = arg1.gjstr();
         if (var19.length() > 0) {
            int var20 = var19.lastIndexOf(",");
            var4.c = a(Integer.parseInt(var19.substring(var20 + 1)), var19.substring(0, var20), 373);
         }

         String var21 = arg1.gjstr();
         if (var21.length() > 0) {
            int var22 = var21.lastIndexOf(",");
            var4.J = a(Integer.parseInt(var21.substring(var22 + 1)), var21.substring(0, var22), 373);
         }
      }

      if (var4.A == 6) {
         int var23 = arg1.g1();
         if (var23 != 0) {
            var4.vb = 1;
            var4.wb = (var23 - 1 << 8) + arg1.g1();
         }

         int var24 = arg1.g1();
         if (var24 != 0) {
            var4.eb = 1;
            var4.fb = (var24 - 1 << 8) + arg1.g1();
         }

         int var25 = arg1.g1();
         if (var25 != 0) {
            var4.yb = (var25 - 1 << 8) + arg1.g1();
         } else {
            var4.yb = -1;
         }

         int var26 = arg1.g1();
         if (var26 != 0) {
            var4.zb = (var26 - 1 << 8) + arg1.g1();
         } else {
            var4.zb = -1;
         }

         var4.P = arg1.g2();
         var4.Q = arg1.g2();
         var4.R = arg1.g2();
      }

      if (var4.A == 7) {
         var4.hb = new int[var4.F * var4.C];
         var4.o = new int[var4.F * var4.C];
         var4.kb = arg1.g1() == 1;
         int var27 = arg1.g1();
         if (n != null) {
            var4.B = n[var27];
         }

         var4.L = arg1.g1() == 1;
         var4.E = arg1.g4();
         var4.bb = arg1.gb2();
         var4.I = arg1.gb2();
         var4.t = arg1.g1() == 1;
         var4.ab = new String[5];

         for(int var28 = 0; var28 < 5; ++var28) {
            var4.ab[var28] = arg1.gjstr();
            if (var4.ab[var28].length() == 0) {
               var4.ab[var28] = null;
            }
         }
      }

      if (var4.A == 8) {
         var4.u = arg1.gjstr();
      }

      if (var4.Bb == 2 || var4.A == 2) {
         var4.tb = arg1.gjstr();
         var4.b = arg1.gjstr();
         var4.m = arg1.g2();
      }

      if (var4.Bb == 1 || var4.Bb == 4 || var4.Bb == 5 || var4.Bb == 6) {
         var4.gb = arg1.gjstr();
         if (var4.gb.length() == 0) {
            if (var4.Bb == 1) {
               var4.gb = "Ok";
            }

            if (var4.Bb == 4) {
               var4.gb = "Select";
            }

            if (var4.Bb == 5) {
               var4.gb = "Select";
            }

            if (var4.Bb == 6) {
               var4.gb = "Continue";
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("EWIXBTLV.a(I[LJDPYRDAS;LATJMVOZR;LATJMVOZR;)V")
   public static void a(int arg0, PixFont[] arg1, Jagfile arg2, Jagfile arg3) {
      O = new LruCache(50000, -572);
      e = arg3;
      n = arg1;
      int var4 = -1;
      Packet var5 = new Packet(arg2.read("data", (byte[])null));
      int var6 = var5.g2();
      g = new Component[var6];
      ub = new byte[var6][];

      while(var5.pos < var5.data.length) {
         int var7 = var5.g2();
         if (var7 == 65535) {
            var4 = var5.g2();
            var7 = var5.g2();
         }

         int var8 = var5.pos;
         Component var9 = a(var4, (Packet)var5, 10896, var7);
         byte[] var10 = ub[var9.f] = new byte[var5.pos - var8 + 2];

         for(int var11 = var8; var11 < var5.pos; ++var11) {
            var10[var11 - var8 + 2] = var5.data[var11];
         }

         var10[0] = (byte)(var4 >> 8);
         var10[1] = (byte)var4;
      }

      e = null;
      if (arg0 >= 0) {
         a = 391;
      }
   }

   @ObfuscatedName("EWIXBTLV.a(ZI)V")
   public static void a(boolean arg0, int arg1) {
      if (!arg0) {
         V = !V;
      }

      if (arg1 != -1) {
         for(int var2 = 0; var2 < g.length; ++var2) {
            if (g[var2] != null && g[var2].M == arg1 && g[var2].A != 2) {
               g[var2] = null;
            }
         }

      }
   }

   @ObfuscatedName("EWIXBTLV.a(ILLZYQDKJV;II)V")
   public static void a(int arg0, Model arg1, int arg2, int arg3) {
      cb.clear();
      if (arg3 != 6) {
         for(int var4 = 1; var4 > 0; ++var4) {
         }
      }

      if (arg1 != null && arg0 != 4) {
         cb.put(arg1, (long)((arg0 << 16) + arg2));
      }
   }

   @ObfuscatedName("EWIXBTLV.a(Z)V")
   public static void a(boolean arg0) {
      g = null;
      e = null;
      if (arg0) {
         V = !V;
      }

      O = null;
      n = null;
      ub = null;
   }

   @ObfuscatedName("EWIXBTLV.a(IIIZ)LLZYQDKJV;")
   public Model a(int arg0, int arg1, int arg2, boolean arg3) {
      sb = 64;
      H = 768;
      Model var5;
      if (arg3) {
         var5 = this.a(this.eb, this.fb);
      } else {
         var5 = this.a(this.vb, this.wb);
      }

      if (var5 == null) {
         return null;
      } else if (arg0 == -1 && arg1 == -1 && var5.M == null) {
         return var5;
      } else {
         Model var6 = new Model(false, false, true, var5, AnimFrame.a(this.jb, arg0) & AnimFrame.a(this.jb, arg1));
         if (arg2 != 0) {
            this.jb = !this.jb;
         }

         if (arg0 != -1 || arg1 != -1) {
            var6.f(7);
         }

         if (arg0 != -1) {
            var6.a(arg0, (byte)6);
         }

         if (arg1 != -1) {
            var6.a(arg1, (byte)6);
         }

         var6.a(sb, H, -50, -10, -50, true);
         return var6;
      }
   }
}
