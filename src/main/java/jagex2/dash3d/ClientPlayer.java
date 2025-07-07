package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.client.Client;
import jagex2.config.*;
import jagex2.datastruct.JString;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;

public class ClientPlayer extends ClientEntity {
   @ObfuscatedName("ZGNGQRPJ.ub")
   public boolean ub = false;
   @ObfuscatedName("ZGNGQRPJ.vb")
   public int vb = -1;
   @ObfuscatedName("ZGNGQRPJ.wb")
   public long wb = -1L;
   @ObfuscatedName("ZGNGQRPJ.zb")
   public int[] zb = new int[12];
   @ObfuscatedName("ZGNGQRPJ.Db")
   public int Db = -1;
   @ObfuscatedName("ZGNGQRPJ.Fb")
   public boolean Fb = false;
   @ObfuscatedName("ZGNGQRPJ.Hb")
   public int[] Hb = new int[5];
   @ObfuscatedName("ZGNGQRPJ.Jb")
   public boolean Jb = true;
   @ObfuscatedName("ZGNGQRPJ.Kb")
   public boolean Kb = false;
   @ObfuscatedName("ZGNGQRPJ.Ob")
   public boolean Ob = false;
   @ObfuscatedName("ZGNGQRPJ.Tb")
   public int Tb = 932;
   @ObfuscatedName("ZGNGQRPJ.Ib")
   public static LruCache Ib = new LruCache(260, -572);
   @ObfuscatedName("ZGNGQRPJ.Ab")
   public int Ab;
   @ObfuscatedName("ZGNGQRPJ.Cb")
   public int Cb;
   @ObfuscatedName("ZGNGQRPJ.Gb")
   public int Gb;
   @ObfuscatedName("ZGNGQRPJ.Lb")
   public int Lb;
   @ObfuscatedName("ZGNGQRPJ.Mb")
   public int Mb;
   @ObfuscatedName("ZGNGQRPJ.Nb")
   public int Nb;
   @ObfuscatedName("ZGNGQRPJ.Pb")
   public int Pb;
   @ObfuscatedName("ZGNGQRPJ.Qb")
   public int Qb;
   @ObfuscatedName("ZGNGQRPJ.Rb")
   public int Rb;
   @ObfuscatedName("ZGNGQRPJ.Sb")
   public int Sb;
   @ObfuscatedName("ZGNGQRPJ.qb")
   public int qb;
   @ObfuscatedName("ZGNGQRPJ.rb")
   public int rb;
   @ObfuscatedName("ZGNGQRPJ.sb")
   public int sb;
   @ObfuscatedName("ZGNGQRPJ.xb")
   public int xb;
   @ObfuscatedName("ZGNGQRPJ.Bb")
   public long Bb;
   @ObfuscatedName("ZGNGQRPJ.tb")
   public Model tb;
   @ObfuscatedName("ZGNGQRPJ.Eb")
   public NpcType Eb;
   @ObfuscatedName("ZGNGQRPJ.yb")
   public String yb;

   @ObfuscatedName("ZGNGQRPJ.a(Z)LLZYQDKJV;")
   public final Model a(boolean arg0) {
      if (!this.Fb) {
         return null;
      } else if (this.Eb != null) {
         return this.Eb.a(858);
      } else {
         boolean var2 = false;

         for(int var3 = 0; var3 < 12; ++var3) {
            int var4 = this.zb[var3];
            if (var4 >= 256 && var4 < 512 && !IdkType.e[var4 - 256].b(-10584)) {
               var2 = true;
            }

            if (var4 >= 512 && !ObjType.a(var4 - 512).a((int)this.Cb, 0)) {
               var2 = true;
            }
         }

         if (var2) {
            return null;
         } else {
            Model[] var5 = new Model[12];
            int var6 = 0;

            for(int var7 = 0; var7 < 12; ++var7) {
               int var8 = this.zb[var7];
               if (var8 >= 256 && var8 < 512) {
                  Model var9 = IdkType.e[var8 - 256].a(this.ub);
                  if (var9 != null) {
                     var5[var6++] = var9;
                  }
               }

               if (var8 >= 512) {
                  Model var10 = ObjType.a(var8 - 512).a(true, this.Cb);
                  if (var10 != null) {
                     var5[var6++] = var10;
                  }
               }
            }

            Model var11 = new Model(var6, var5, (byte)-89);
            if (!arg0) {
               throw new NullPointerException();
            } else {
               for(int var12 = 0; var12 < 5; ++var12) {
                  if (this.Hb[var12] != 0) {
                     var11.c(Client.Zd[var12][0], Client.Zd[var12][this.Hb[var12]]);
                     if (var12 == 1) {
                        var11.c(Client.aj[0], Client.aj[this.Hb[var12]]);
                     }
                  }
               }

               return var11;
            }
         }
      }
   }

   @ObfuscatedName("ZGNGQRPJ.b(B)LLZYQDKJV;")
   public final Model b(byte arg0) {
      if (this.Eb != null) {
         int var2 = -1;
         if (super.eb >= 0 && super.hb == 0) {
            var2 = SeqType.d[super.eb].f[super.fb];
         } else if (super.u >= 0) {
            var2 = SeqType.d[super.u].f[super.v];
         }

         return this.Eb.a(var2, -1, 0, (int[])null);
      } else {
         long var4 = this.Bb;
         int var6 = -1;
         int var7 = -1;
         int var8 = -1;
         int var9 = -1;
         if (arg0 != 122) {
            this.Ob = !this.Ob;
         }

         if (super.eb >= 0 && super.hb == 0) {
            SeqType var10 = SeqType.d[super.eb];
            var6 = var10.f[super.fb];
            if (super.u >= 0 && super.u != super.ob) {
               var7 = SeqType.d[super.u].f[super.v];
            }

            if (var10.m >= 0) {
               var8 = var10.m;
               var4 += (long)(var8 - this.zb[5] << 8);
            }

            if (var10.n >= 0) {
               var9 = var10.n;
               var4 += (long)(var9 - this.zb[3] << 16);
            }
         } else if (super.u >= 0) {
            var6 = SeqType.d[super.u].f[super.v];
         }

         Model var11 = (Model)Ib.get(var4);
         if (var11 == null) {
            boolean var12 = false;

            for(int var13 = 0; var13 < 12; ++var13) {
               int var14 = this.zb[var13];
               if (var9 >= 0 && var13 == 3) {
                  var14 = var9;
               }

               if (var8 >= 0 && var13 == 5) {
                  var14 = var8;
               }

               if (var14 >= 256 && var14 < 512 && !IdkType.e[var14 - 256].a((int)256)) {
                  var12 = true;
               }

               if (var14 >= 512 && !ObjType.a(var14 - 512).b(-861, this.Cb)) {
                  var12 = true;
               }
            }

            if (var12) {
               if (this.wb != -1L) {
                  var11 = (Model)Ib.get(this.wb);
               }

               if (var11 == null) {
                  return null;
               }
            }
         }

         if (var11 == null) {
            Model[] var15 = new Model[12];
            int var16 = 0;

            for(int var17 = 0; var17 < 12; ++var17) {
               int var18 = this.zb[var17];
               if (var9 >= 0 && var17 == 3) {
                  var18 = var9;
               }

               if (var8 >= 0 && var17 == 5) {
                  var18 = var8;
               }

               if (var18 >= 256 && var18 < 512) {
                  Model var19 = IdkType.e[var18 - 256].a((byte)2);
                  if (var19 != null) {
                     var15[var16++] = var19;
                  }
               }

               if (var18 >= 512) {
                  Model var20 = ObjType.a(var18 - 512).a((byte)-98, this.Cb);
                  if (var20 != null) {
                     var15[var16++] = var20;
                  }
               }
            }

            var11 = new Model(var16, var15, (byte)-89);

            for(int var21 = 0; var21 < 5; ++var21) {
               if (this.Hb[var21] != 0) {
                  var11.c(Client.Zd[var21][0], Client.Zd[var21][this.Hb[var21]]);
                  if (var21 == 1) {
                     var11.c(Client.aj[0], Client.aj[this.Hb[var21]]);
                  }
               }
            }

            var11.f(7);
            var11.a(64, 850, -30, -50, -30, true);
            Ib.put(var11, var4);
            this.wb = var4;
         }

         if (this.Kb) {
            return var11;
         } else {
            Model var22 = Model.t;
            var22.a(AnimFrame.a(this.Jb, var6) & AnimFrame.a(this.Jb, var7), var11, 1244);
            if (var6 != -1 && var7 != -1) {
               var22.a(var7, 0, var6, SeqType.d[super.eb].j);
            } else if (var6 != -1) {
               var22.a(var6, (byte)6);
            }

            var22.c(this.Tb);
            var22.db = null;
            var22.cb = null;
            return var22;
         }
      }
   }

   @ObfuscatedName("ZGNGQRPJ.b(I)Z")
   public final boolean b(int arg0) {
      if (arg0 != 0) {
         for(int var2 = 1; var2 > 0; ++var2) {
         }
      }

      return this.Fb;
   }

   @ObfuscatedName("ZGNGQRPJ.a(B)LLZYQDKJV;")
   public final Model a(byte arg0) {
      if (!this.Fb) {
         return null;
      } else {
         Model var2 = this.b((byte)122);
         if (var2 == null) {
            return null;
         } else {
            super.A = var2.k;
            var2.eb = true;
            if (this.Kb) {
               return var2;
            } else {
               if (super.U != -1 && super.V != -1) {
                  SpotAnimType var3 = SpotAnimType.e[super.U];
                  Model var4 = var3.a();
                  if (var4 != null) {
                     Model var5 = new Model(false, false, true, var4, AnimFrame.a(this.Jb, super.V));
                     var5.a(0, 0, false, -super.Y);
                     var5.f(7);
                     var5.a(var3.i.f[super.V], (byte)6);
                     var5.db = null;
                     var5.cb = null;
                     if (var3.l != 128 || var3.m != 128) {
                        var5.a(var3.m, var3.l, 9, var3.l);
                     }

                     var5.a(var3.o + 64, var3.p + 850, -30, -50, -30, true);
                     Model[] var6 = new Model[]{var2, var5};
                     var2 = new Model(2, true, 0, var6);
                  }
               }

               if (this.tb != null) {
                  if (Client.fk >= this.Mb) {
                     this.tb = null;
                  }

                  if (Client.fk >= this.Lb && Client.fk < this.Mb) {
                     Model var7 = this.tb;
                     var7.a(this.qb - super.Q, this.sb - super.R, false, this.rb - this.xb);
                     if (super.q == 512) {
                        var7.b(true);
                        var7.b(true);
                        var7.b(true);
                     } else if (super.q == 1024) {
                        var7.b(true);
                        var7.b(true);
                     } else if (super.q == 1536) {
                        var7.b(true);
                     }

                     Model[] var8 = new Model[]{var2, var7};
                     var2 = new Model(2, true, 0, var8);
                     if (super.q == 512) {
                        var7.b(true);
                     } else if (super.q == 1024) {
                        var7.b(true);
                        var7.b(true);
                     } else if (super.q == 1536) {
                        var7.b(true);
                        var7.b(true);
                        var7.b(true);
                     }

                     var7.a(super.Q - this.qb, super.R - this.sb, false, this.xb - this.rb);
                  }
               }

               var2.eb = true;
               if (arg0 == 3) {
                  boolean var9 = false;
               } else {
                  this.Ob = !this.Ob;
               }

               return var2;
            }
         }
      }
   }

   @ObfuscatedName("ZGNGQRPJ.a(LMFMVIYHT;I)V")
   public final void a(Packet arg0, int arg1) {
      arg0.pos = 0;
      this.Cb = arg0.g1();
      this.Db = arg0.g1b();
      this.vb = arg0.g1b();
      this.Eb = null;
      this.Nb = 0;

      for(int var3 = 0; var3 < 12; ++var3) {
         int var4 = arg0.g1();
         if (var4 == 0) {
            this.zb[var3] = 0;
         } else {
            int var5 = arg0.g1();
            this.zb[var3] = (var4 << 8) + var5;
            if (var3 == 0 && this.zb[0] == 65535) {
               this.Eb = NpcType.c(arg0.g2());
               break;
            }

            if (this.zb[var3] >= 512 && this.zb[var3] - 512 < ObjType.j) {
               int var6 = ObjType.a(this.zb[var3] - 512).g;
               if (var6 != 0) {
                  this.Nb = var6;
               }
            }
         }
      }

      for(int var7 = 0; var7 < 5; ++var7) {
         int var8 = arg0.g1();
         if (var8 < 0 || var8 >= Client.Zd[var7].length) {
            var8 = 0;
         }

         this.Hb[var7] = var8;
      }

      super.ob = arg0.g2();
      if (super.ob == 65535) {
         super.ob = -1;
      }

      super.pb = arg0.g2();
      if (super.pb == 65535) {
         super.pb = -1;
      }

      super.Z = arg0.g2();
      if (super.Z == 65535) {
         super.Z = -1;
      }

      super.ab = arg0.g2();
      if (super.ab == 65535) {
         super.ab = -1;
      }

      super.bb = arg0.g2();
      if (super.bb == 65535) {
         super.bb = -1;
      }

      super.cb = arg0.g2();
      if (super.cb == 65535) {
         super.cb = -1;
      }

      super.jb = arg0.g2();
      if (super.jb == 65535) {
         super.jb = -1;
      }

      this.yb = JString.a(JString.a(arg0.g8(), 0), (byte)7);
      this.Ab = arg0.g1();
      this.Gb = arg0.g2();
      this.Fb = true;
      this.Bb = 0L;
      int var9 = this.zb[5];
      int var10 = this.zb[9];
      if (arg1 == 0) {
         this.zb[5] = var10;
         this.zb[9] = var9;

         for(int var11 = 0; var11 < 12; ++var11) {
            this.Bb <<= 4;
            if (this.zb[var11] >= 256) {
               this.Bb += (long)(this.zb[var11] - 256);
            }
         }

         if (this.zb[0] >= 256) {
            this.Bb += (long)(this.zb[0] - 256 >> 4);
         }

         if (this.zb[1] >= 256) {
            this.Bb += (long)(this.zb[1] - 256 >> 8);
         }

         this.zb[5] = var9;
         this.zb[9] = var10;

         for(int var12 = 0; var12 < 5; ++var12) {
            this.Bb <<= 3;
            this.Bb += (long)this.Hb[var12];
         }

         this.Bb <<= 1;
         this.Bb += (long)this.Cb;
      }
   }
}
