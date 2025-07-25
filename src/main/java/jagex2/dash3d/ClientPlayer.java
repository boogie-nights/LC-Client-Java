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
   public int[] appearance = new int[12];
   @ObfuscatedName("ZGNGQRPJ.Db")
   public int Db = -1;
   @ObfuscatedName("ZGNGQRPJ.Fb")
   public boolean Fb = false;
   @ObfuscatedName("ZGNGQRPJ.Hb")
   public int[] colour = new int[5];
   @ObfuscatedName("ZGNGQRPJ.Jb")
   public boolean Jb = true;
   @ObfuscatedName("ZGNGQRPJ.Kb")
   public boolean Kb = false;
   @ObfuscatedName("ZGNGQRPJ.Ob")
   public boolean Ob = false;
   @ObfuscatedName("ZGNGQRPJ.Tb")
   public int Tb = 932;
   @ObfuscatedName("ZGNGQRPJ.Ib")
   public static LruCache Ib = new LruCache(260);
   @ObfuscatedName("ZGNGQRPJ.Ab")
   public int vislevel;
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
   public String name;

   @ObfuscatedName("ZGNGQRPJ.a(Z)LLZYQDKJV;")
   public final Model getHeadModel(boolean arg0) {
      if (!this.Fb) {
         return null;
      } else if (this.Eb != null) {
         return this.Eb.getHeadModel();
      } else {
         boolean var2 = false;

         for(int var3 = 0; var3 < 12; ++var3) {
            int var4 = this.appearance[var3];
            if (var4 >= 256 && var4 < 512 && !IdkType.types[var4 - 256].b(-10584)) {
               var2 = true;
            }

            if (var4 >= 512 && !ObjType.get(var4 - 512).headModelIsReady((int)this.Cb)) {
               var2 = true;
            }
         }

         if (var2) {
            return null;
         } else {
            Model[] var5 = new Model[12];
            int var6 = 0;

            for(int var7 = 0; var7 < 12; ++var7) {
               int var8 = this.appearance[var7];
               if (var8 >= 256 && var8 < 512) {
                  Model var9 = IdkType.types[var8 - 256].a(this.ub);
                  if (var9 != null) {
                     var5[var6++] = var9;
                  }
               }

               if (var8 >= 512) {
                  Model var10 = ObjType.get(var8 - 512).getHeadModel(this.Cb);
                  if (var10 != null) {
                     var5[var6++] = var10;
                  }
               }
            }

            Model var11 = new Model(var6, var5);
            if (!arg0) {
               throw new NullPointerException();
            } else {
               for(int var12 = 0; var12 < 5; ++var12) {
                  if (this.colour[var12] != 0) {
                     var11.recolour(Client.DESIGN_BODY_COLOUR[var12][0], Client.DESIGN_BODY_COLOUR[var12][this.colour[var12]]);
                     if (var12 == 1) {
                        var11.recolour(Client.DESIGN_HAIR_COLOUR[0], Client.DESIGN_HAIR_COLOUR[this.colour[var12]]);
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
         if (super.primarySeqId >= 0 && super.primarySeqDelay == 0) {
            var2 = SeqType.types[super.primarySeqId].frames[super.fb];
         } else if (super.u >= 0) {
            var2 = SeqType.types[super.u].frames[super.v];
         }

         return this.Eb.getModel(var2, -1, (int[])null);
      } else {
         long var4 = this.Bb;
         int var6 = -1;
         int var7 = -1;
         int var8 = -1;
         int var9 = -1;
         if (arg0 != 122) {
            this.Ob = !this.Ob;
         }

         if (super.primarySeqId >= 0 && super.primarySeqDelay == 0) {
            SeqType var10 = SeqType.types[super.primarySeqId];
            var6 = var10.frames[super.fb];
            if (super.u >= 0 && super.u != super.readyanim) {
               var7 = SeqType.types[super.u].frames[super.v];
            }

            if (var10.m >= 0) {
               var8 = var10.m;
               var4 += (long)(var8 - this.appearance[5] << 8);
            }

            if (var10.n >= 0) {
               var9 = var10.n;
               var4 += (long)(var9 - this.appearance[3] << 16);
            }
         } else if (super.u >= 0) {
            var6 = SeqType.types[super.u].frames[super.v];
         }

         Model var11 = (Model)Ib.get(var4);
         if (var11 == null) {
            boolean var12 = false;

            for(int var13 = 0; var13 < 12; ++var13) {
               int var14 = this.appearance[var13];
               if (var9 >= 0 && var13 == 3) {
                  var14 = var9;
               }

               if (var8 >= 0 && var13 == 5) {
                  var14 = var8;
               }

               if (var14 >= 256 && var14 < 512 && !IdkType.types[var14 - 256].modelIsReady((int)256)) {
                  var12 = true;
               }

               if (var14 >= 512 && !ObjType.get(var14 - 512).wornModelIsReady(this.Cb)) {
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
               int var18 = this.appearance[var17];
               if (var9 >= 0 && var17 == 3) {
                  var18 = var9;
               }

               if (var8 >= 0 && var17 == 5) {
                  var18 = var8;
               }

               if (var18 >= 256 && var18 < 512) {
                  Model var19 = IdkType.types[var18 - 256].getModel((byte)2);
                  if (var19 != null) {
                     var15[var16++] = var19;
                  }
               }

               if (var18 >= 512) {
                  Model var20 = ObjType.get(var18 - 512).getWornModel((byte)-98, this.Cb);
                  if (var20 != null) {
                     var15[var16++] = var20;
                  }
               }
            }

            var11 = new Model(var16, var15);

            for(int var21 = 0; var21 < 5; ++var21) {
               if (this.colour[var21] != 0) {
                  var11.recolour(Client.DESIGN_BODY_COLOUR[var21][0], Client.DESIGN_BODY_COLOUR[var21][this.colour[var21]]);
                  if (var21 == 1) {
                     var11.recolour(Client.DESIGN_HAIR_COLOUR[0], Client.DESIGN_HAIR_COLOUR[this.colour[var21]]);
                  }
               }
            }

            var11.createLabelReferences();
            var11.calculateNormals(64, 850, -30, -50, -30, true);
            Ib.put(var11, var4);
            this.wb = var4;
         }

         if (this.Kb) {
            return var11;
         } else {
            Model var22 = Model.empty;
            var22.a(AnimFrame.a(this.Jb, var6) & AnimFrame.a(this.Jb, var7), var11, 1244);
            if (var6 != -1 && var7 != -1) {
               var22.applyTransforms(var6, var7, SeqType.types[super.primarySeqId].j);
            } else if (var6 != -1) {
               var22.applyTransform(var6);
            }

            var22.calculateBoundsCylinder();
            var22.labelFaces = null;
            var22.labelVertices = null;
            return var22;
         }
      }
   }

   @ObfuscatedName("ZGNGQRPJ.b(I)Z")
   public final boolean isVisible() {
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
            var2.picking = true;
            if (this.Kb) {
               return var2;
            } else {
               if (super.spotAnimId != -1 && super.spotanimFrame != -1) {
                  SpotAnimType var3 = SpotAnimType.e[super.spotAnimId];
                  Model var4 = var3.a();
                  if (var4 != null) {
                     Model var5 = new Model(false, false, true, var4, AnimFrame.a(this.Jb, super.spotanimFrame));
                     var5.translate(0, 0, false, -super.spotanimHeight);
                     var5.createLabelReferences();
                     var5.applyTransform(var3.i.frames[super.spotanimFrame]);
                     var5.labelFaces = null;
                     var5.labelVertices = null;
                     if (var3.l != 128 || var3.m != 128) {
                        var5.scale(var3.m, var3.l, 9, var3.l);
                     }

                     var5.calculateNormals(var3.o + 64, var3.p + 850, -30, -50, -30, true);
                     Model[] var6 = new Model[]{var2, var5};
                     var2 = new Model(2, true, 0, var6);
                  }
               }

               if (this.tb != null) {
                  if (Client.loopCycle >= this.Mb) {
                     this.tb = null;
                  }

                  if (Client.loopCycle >= this.Lb && Client.loopCycle < this.Mb) {
                     Model var7 = this.tb;
                     var7.translate(this.qb - super.x, this.sb - super.z, false, this.rb - this.xb);
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

                     var7.translate(super.x - this.qb, super.z - this.sb, false, this.xb - this.rb);
                  }
               }

               var2.picking = true;
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
   public final void read(Packet buf, int arg1) {
      buf.pos = 0;

	  this.Cb = buf.g1();
      this.Db = buf.g1b();
      this.vb = buf.g1b();

      this.Eb = null;
      this.Nb = 0;

      for(int i = 0; i < 12; ++i) {
         int part = buf.g1();
         if (part == 0) {
            this.appearance[i] = 0;
         } else {
            int var5 = buf.g1();
            this.appearance[i] = (part << 8) + var5;
            if (i == 0 && this.appearance[0] == 65535) {
               this.Eb = NpcType.get(buf.g2());
               break;
            }

            if (this.appearance[i] >= 512 && this.appearance[i] - 512 < ObjType.count) {
               int var6 = ObjType.get(this.appearance[i] - 512).team;
               if (var6 != 0) {
                  this.Nb = var6;
               }
            }
         }
      }

      for(int i = 0; i < 5; ++i) {
         int colour = buf.g1();
         if (colour < 0 || colour >= Client.DESIGN_BODY_COLOUR[i].length) {
            colour = 0;
         }

         this.colour[i] = colour;
      }

      super.readyanim = buf.g2();
      if (super.readyanim == 65535) {
         super.readyanim = -1;
      }

      super.pb = buf.g2();
      if (super.pb == 65535) {
         super.pb = -1;
      }

      super.Z = buf.g2();
      if (super.Z == 65535) {
         super.Z = -1;
      }

      super.ab = buf.g2();
      if (super.ab == 65535) {
         super.ab = -1;
      }

      super.bb = buf.g2();
      if (super.bb == 65535) {
         super.bb = -1;
      }

      super.cb = buf.g2();
      if (super.cb == 65535) {
         super.cb = -1;
      }

      super.jb = buf.g2();
      if (super.jb == 65535) {
         super.jb = -1;
      }

      this.name = JString.formatDisplayName(JString.fromBase37(buf.g8()));
      this.vislevel = buf.g1();
      this.Gb = buf.g2();
      this.Fb = true;
      this.Bb = 0L;
      int var9 = this.appearance[5];
      int var10 = this.appearance[9];

      if (arg1 == 0) {
         this.appearance[5] = var10;
         this.appearance[9] = var9;

         for(int var11 = 0; var11 < 12; ++var11) {
            this.Bb <<= 4;
            if (this.appearance[var11] >= 256) {
               this.Bb += (long)(this.appearance[var11] - 256);
            }
         }

         if (this.appearance[0] >= 256) {
            this.Bb += (long)(this.appearance[0] - 256 >> 4);
         }

         if (this.appearance[1] >= 256) {
            this.Bb += (long)(this.appearance[1] - 256 >> 8);
         }

         this.appearance[5] = var9;
         this.appearance[9] = var10;

         for(int var12 = 0; var12 < 5; ++var12) {
            this.Bb <<= 3;
            this.Bb += (long)this.colour[var12];
         }

         this.Bb <<= 1;
         this.Bb += (long)this.Cb;
      }
   }
}
