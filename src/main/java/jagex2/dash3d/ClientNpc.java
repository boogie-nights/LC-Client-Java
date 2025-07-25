package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.NpcType;
import jagex2.config.SeqType;
import jagex2.config.SpotAnimType;

public class ClientNpc extends ClientEntity {
   @ObfuscatedName("RGHBDSIJ.qb")
   public boolean qb = true;
   @ObfuscatedName("RGHBDSIJ.rb")
   public NpcType type;

   @ObfuscatedName("RGHBDSIJ.b(B)LLZYQDKJV;")
   public final Model b(byte arg0) {
      if (super.primarySeqId >= 0 && super.primarySeqDelay == 0) {
         int var2 = SeqType.types[super.primarySeqId].frames[super.fb];
         int var3 = -1;
         if (super.u >= 0 && super.u != super.readyanim) {
            var3 = SeqType.types[super.u].frames[super.v];
         }

         return this.type.getModel(var2, var3, SeqType.types[super.primarySeqId].j);
      } else {
         int var4 = -1;
         if (arg0 != 122) {
            this.qb = !this.qb;
         }

         if (super.u >= 0) {
            var4 = SeqType.types[super.u].frames[super.v];
         }

         return this.type.getModel(var4, -1, (int[])null);
      }
   }

   @ObfuscatedName("RGHBDSIJ.a(B)LLZYQDKJV;")
   public final Model a(byte arg0) {
      if (arg0 != 3) {
         throw new NullPointerException();
      } else {
         boolean var2 = false;
         if (this.type == null) {
            return null;
         } else {
            Model var3 = this.b((byte)122);
            if (var3 == null) {
               return null;
            } else {
               super.A = var3.minY;
               if (super.spotAnimId != -1 && super.spotanimFrame != -1) {
                  SpotAnimType var4 = SpotAnimType.e[super.spotAnimId];
                  Model var5 = var4.a();
                  if (var5 != null) {
                     int var6 = var4.i.frames[super.spotanimFrame];
                     Model var7 = new Model(false, false, true, var5, AnimFrame.a(this.qb, var6));
                     var7.translate(0, 0, false, -super.spotanimHeight);
                     var7.createLabelReferences();
                     var7.applyTransform(var6);
                     var7.labelFaces = null;
                     var7.labelVertices = null;
                     if (var4.l != 128 || var4.m != 128) {
                        var7.scale(var4.m, var4.l, 9, var4.l);
                     }

                     var7.calculateNormals(var4.o + 64, var4.p + 850, -30, -50, -30, true);
                     Model[] var8 = new Model[]{var3, var7};
                     var3 = new Model(2, true, 0, var8);
                  }
               }

               if (this.type.size == 1) {
                  var3.picking = true;
               }

               return var3;
            }
         }
      }
   }

   @ObfuscatedName("RGHBDSIJ.b(I)Z")
   public final boolean isVisible() {
         return this.type != null;
   }
}
