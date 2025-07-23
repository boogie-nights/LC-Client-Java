package jagex2.config;

import deob.*;
import jagex2.client.Client;
import jagex2.dash3d.AnimFrame;
import jagex2.dash3d.Model;
import jagex2.datastruct.LruCache;
import jagex2.io.Jagfile;
import jagex2.io.Packet;

public class NpcType {
   @ObfuscatedName("SLDUQHOR.a")
   public int a = -1;
   @ObfuscatedName("SLDUQHOR.c")
   public boolean c = true;
   @ObfuscatedName("SLDUQHOR.d")
   public int d = 932;
   @ObfuscatedName("SLDUQHOR.g")
   public int g = -1;
   @ObfuscatedName("SLDUQHOR.h")
   public long h = -1L;
   @ObfuscatedName("SLDUQHOR.j")
   public int j = 128;
   @ObfuscatedName("SLDUQHOR.k")
   public boolean k = true;
   @ObfuscatedName("SLDUQHOR.l")
   public int l = 128;
   @ObfuscatedName("SLDUQHOR.m")
   public int m = -1;
   @ObfuscatedName("SLDUQHOR.p")
   public boolean p = true;
   @ObfuscatedName("SLDUQHOR.q")
   public int q = -1;
   @ObfuscatedName("SLDUQHOR.r")
   public int r = -1;
   @ObfuscatedName("SLDUQHOR.s")
   public int visLevel = -1;
   @ObfuscatedName("SLDUQHOR.t")
   public int t = 7;
   @ObfuscatedName("SLDUQHOR.u")
   public int u = -1;
   @ObfuscatedName("SLDUQHOR.v")
   public byte v = 1;
   @ObfuscatedName("SLDUQHOR.w")
   public int w = -1;
   @ObfuscatedName("SLDUQHOR.x")
   public boolean x = false;
   @ObfuscatedName("SLDUQHOR.y")
   public int y = -1;
   @ObfuscatedName("SLDUQHOR.A")
   public boolean A = false;
   @ObfuscatedName("SLDUQHOR.B")
   public int B = -1;
   @ObfuscatedName("SLDUQHOR.E")
   public int E = 32;
   @ObfuscatedName("SLDUQHOR.F")
   public String F = "null";
   @ObfuscatedName("SLDUQHOR.H")
   public int H = -1;
   @ObfuscatedName("SLDUQHOR.M")
   public int M = -1;
   @ObfuscatedName("SLDUQHOR.P")
   public boolean P = false;
   @ObfuscatedName("SLDUQHOR.o")
   public static LruCache o = new LruCache(30);
   @ObfuscatedName("SLDUQHOR.G")
   public static byte G = 6;
   @ObfuscatedName("SLDUQHOR.C")
   public static int C;
   @ObfuscatedName("SLDUQHOR.L")
   public int L;
   @ObfuscatedName("SLDUQHOR.O")
   public static int O;
   @ObfuscatedName("SLDUQHOR.Q")
   public int Q;
   @ObfuscatedName("SLDUQHOR.K")
   public static Packet K;
   @ObfuscatedName("SLDUQHOR.i")
   public static Client i;
   @ObfuscatedName("SLDUQHOR.N")
   public byte[] N;
   @ObfuscatedName("SLDUQHOR.D")
   public static int[] D;
   @ObfuscatedName("SLDUQHOR.J")
   public int[] J;
   @ObfuscatedName("SLDUQHOR.b")
   public int[] b;
   @ObfuscatedName("SLDUQHOR.e")
   public int[] e;
   @ObfuscatedName("SLDUQHOR.f")
   public int[] f;
   @ObfuscatedName("SLDUQHOR.n")
   public int[] n;
   @ObfuscatedName("SLDUQHOR.I")
   public static NpcType[] I;
   @ObfuscatedName("SLDUQHOR.z")
   public String[] z;

   @ObfuscatedName("SLDUQHOR.a(BLMFMVIYHT;)V")
   public final void a(byte arg0, Packet arg1) {
      if (arg0 != 6) {
         throw new NullPointerException();
      } else {
         boolean var3 = false;

         while(true) {
            while(true) {
               int var4 = arg1.g1();
               if (var4 == 0) {
                  return;
               }

               if (var4 == 1) {
                  int var5 = arg1.g1();
                  this.f = new int[var5];

                  for(int var6 = 0; var6 < var5; ++var6) {
                     this.f[var6] = arg1.g2();
                  }
               } else if (var4 == 2) {
                  this.F = arg1.gjstr();
               } else if (var4 == 3) {
                  this.N = arg1.gjstrraw();
               } else if (var4 == 12) {
                  this.v = arg1.g1b();
               } else if (var4 == 13) {
                  this.a = arg1.g2();
               } else if (var4 == 14) {
                  this.y = arg1.g2();
               } else if (var4 == 17) {
                  this.y = arg1.g2();
                  this.w = arg1.g2();
                  this.u = arg1.g2();
                  this.m = arg1.g2();
               } else if (var4 >= 30 && var4 < 40) {
                  if (this.z == null) {
                     this.z = new String[5];
                  }

                  this.z[var4 - 30] = arg1.gjstr();
                  if (this.z[var4 - 30].equalsIgnoreCase("hidden")) {
                     this.z[var4 - 30] = null;
                  }
               } else if (var4 == 40) {
                  int var7 = arg1.g1();
                  this.n = new int[var7];
                  this.J = new int[var7];

                  for(int var8 = 0; var8 < var7; ++var8) {
                     this.n[var8] = arg1.g2();
                     this.J[var8] = arg1.g2();
                  }
               } else if (var4 == 60) {
                  int var9 = arg1.g1();
                  this.e = new int[var9];

                  for(int var10 = 0; var10 < var9; ++var10) {
                     this.e[var10] = arg1.g2();
                  }
               } else if (var4 == 90) {
                  this.B = arg1.g2();
               } else if (var4 == 91) {
                  this.g = arg1.g2();
               } else if (var4 == 92) {
                  this.q = arg1.g2();
               } else if (var4 == 93) {
                  this.p = false;
               } else if (var4 == 95) {
                  this.visLevel = arg1.g2();
               } else if (var4 == 97) {
                  this.l = arg1.g2();
               } else if (var4 == 98) {
                  this.j = arg1.g2();
               } else if (var4 == 99) {
                  this.x = true;
               } else if (var4 == 100) {
                  this.Q = arg1.g1b();
               } else if (var4 == 101) {
                  this.L = arg1.g1b() * 5;
               } else if (var4 == 102) {
                  this.r = arg1.g2();
               } else if (var4 == 103) {
                  this.E = arg1.g2();
               } else if (var4 == 106) {
                  this.H = arg1.g2();
                  if (this.H == 65535) {
                     this.H = -1;
                  }

                  this.M = arg1.g2();
                  if (this.M == 65535) {
                     this.M = -1;
                  }

                  int var11 = arg1.g1();
                  this.b = new int[var11 + 1];

                  for(int var12 = 0; var12 <= var11; ++var12) {
                     this.b[var12] = arg1.g2();
                     if (this.b[var12] == 65535) {
                        this.b[var12] = -1;
                     }
                  }
               } else if (var4 == 107) {
                  this.k = false;
               }
            }
         }
      }
   }

   @ObfuscatedName("SLDUQHOR.a(Z)V")
   public static final void a(boolean arg0) {
      o = null;
      D = null;
      I = null;
      K = null;
      if (arg0) {
         for(int var1 = 1; var1 > 0; ++var1) {
         }

      }
   }

   @ObfuscatedName("SLDUQHOR.a(I)LLZYQDKJV;")
   public final Model getHeadModel(int arg0) {
      if (arg0 <= 0) {
         for(int var2 = 1; var2 > 0; ++var2) {
         }
      }

      if (this.b != null) {
         NpcType var3 = this.b(false);
         return var3 == null ? null : var3.getHeadModel(858);
      } else if (this.e == null) {
         return null;
      } else {
         boolean var4 = false;

         for(int var5 = 0; var5 < this.e.length; ++var5) {
            if (!Model.b(this.e[var5])) {
               var4 = true;
            }
         }

         if (var4) {
            return null;
         } else {
            Model[] var6 = new Model[this.e.length];

            for(int var7 = 0; var7 < this.e.length; ++var7) {
               var6[var7] = Model.a(this.e[var7]);
            }

            Model var8;
            if (var6.length == 1) {
               var8 = var6[0];
            } else {
               var8 = new Model(var6.length, var6, (byte)-89);
            }

            if (this.n != null) {
               for(int var9 = 0; var9 < this.n.length; ++var9) {
                  var8.recolour(this.n[var9], this.J[var9]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("SLDUQHOR.b(I)Z")
   public boolean b(int arg0) {
      while(arg0 >= 0) {
         this.P = !this.P;
      }

      if (this.b == null) {
         return true;
      } else {
         int var2 = -1;
         if (this.H != -1) {
            VarbitType var3 = VarbitType.c[this.H];
            int var4 = var3.e;
            int var5 = var3.f;
            int var6 = var3.g;
            int var7 = Client.Yh[var6 - var5];
            var2 = i.varps[var4] >> var5 & var7;
         } else if (this.M != -1) {
            var2 = i.varps[this.M];
         }

         if (var2 >= 0 && var2 < this.b.length && this.b[var2] != -1) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("SLDUQHOR.a(LATJMVOZR;)V")
   public static final void unpack(Jagfile arg0) {
      K = new Packet(arg0.read("npc.dat", (byte[])null));
      Packet var1 = new Packet(arg0.read("npc.idx", (byte[])null));
      C = var1.g2();
      D = new int[C];
      int var2 = 2;

      for(int var3 = 0; var3 < C; ++var3) {
         D[var3] = var2;
         var2 += var1.g2();
      }

      I = new NpcType[20];

      for(int var4 = 0; var4 < 20; ++var4) {
         I[var4] = new NpcType();
      }

   }

   @ObfuscatedName("SLDUQHOR.a(III[I)LLZYQDKJV;")
   public final Model a(int arg0, int arg1, int arg2, int[] arg3) {
      if (this.b != null) {
         NpcType var5 = this.b(false);
         return var5 == null ? null : var5.a(arg0, arg1, 0, arg3);
      } else {
         Model var6 = (Model)o.get(this.h);
         if (var6 == null) {
            boolean var7 = false;

            for(int var8 = 0; var8 < this.f.length; ++var8) {
               if (!Model.b(this.f[var8])) {
                  var7 = true;
               }
            }

            if (var7) {
               return null;
            }

            Model[] var9 = new Model[this.f.length];

            for(int var10 = 0; var10 < this.f.length; ++var10) {
               var9[var10] = Model.a(this.f[var10]);
            }

            if (var9.length == 1) {
               var6 = var9[0];
            } else {
               var6 = new Model(var9.length, var9, (byte)-89);
            }

            if (this.n != null) {
               for(int var11 = 0; var11 < this.n.length; ++var11) {
                  var6.recolour(this.n[var11], this.J[var11]);
               }
            }

            var6.createLabelReferences(7);
            var6.calculateNormals(this.Q + 64, this.L + 850, -30, -50, -30, true);
            o.put(var6, this.h);
         }

         Model var12 = Model.t;
         if (arg2 != 0) {
            this.A = !this.A;
         }

         var12.a(AnimFrame.a(this.c, arg0) & AnimFrame.a(this.c, arg1), var6, 1244);
         if (arg0 != -1 && arg1 != -1) {
            var12.a(arg1, 0, arg0, arg3);
         } else if (arg0 != -1) {
            var12.applyTransform(arg0, (byte)6);
         }

         if (this.l != 128 || this.j != 128) {
            var12.a(this.j, this.l, 9, this.l);
         }

         var12.c(this.d);
         var12.db = null;
         var12.cb = null;
         if (this.v == 1) {
            var12.eb = true;
         }

         return var12;
      }
   }

   @ObfuscatedName("SLDUQHOR.b(Z)LSLDUQHOR;")
   public final NpcType b(boolean arg0) {
      if (arg0) {
         this.t = -212;
      }

      int var2 = -1;
      if (this.H != -1) {
         VarbitType var3 = VarbitType.c[this.H];
         int var4 = var3.e;
         int var5 = var3.f;
         int var6 = var3.g;
         int var7 = Client.Yh[var6 - var5];
         var2 = i.varps[var4] >> var5 & var7;
      } else if (this.M != -1) {
         var2 = i.varps[this.M];
      }

      return var2 >= 0 && var2 < this.b.length && this.b[var2] != -1 ? get(this.b[var2]) : null;
   }

   @ObfuscatedName("SLDUQHOR.c(I)LSLDUQHOR;")
   public static final NpcType get(int arg0) {
      for(int var1 = 0; var1 < 20; ++var1) {
         if ((long)arg0 == I[var1].h) {
            return I[var1];
         }
      }

      O = (O + 1) % 20;
      NpcType var2 = I[O] = new NpcType();
      K.pos = D[arg0];
      var2.h = (long)arg0;
      var2.a(G, K);
      return var2;
   }
}
