package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.client.Client;
import jagex2.config.LocType;
import jagex2.config.SeqType;
import jagex2.config.VarbitType;

public class ClientLocAnim extends ModelSource {
   @ObfuscatedName("NRPYRAWK.m")
   public boolean m = false;
   @ObfuscatedName("NRPYRAWK.s")
   public int s;
   @ObfuscatedName("NRPYRAWK.t")
   public int t;
   @ObfuscatedName("NRPYRAWK.u")
   public int u;
   @ObfuscatedName("NRPYRAWK.n")
   public int n;
   @ObfuscatedName("NRPYRAWK.o")
   public int o;
   @ObfuscatedName("NRPYRAWK.p")
   public int p;
   @ObfuscatedName("NRPYRAWK.q")
   public int q;
   @ObfuscatedName("NRPYRAWK.w")
   public SeqType w;
   @ObfuscatedName("NRPYRAWK.C")
   public int C;
   @ObfuscatedName("NRPYRAWK.B")
   public int B;
   @ObfuscatedName("NRPYRAWK.x")
   public int x;
   @ObfuscatedName("NRPYRAWK.y")
   public int y;
   @ObfuscatedName("NRPYRAWK.z")
   public int[] z;
   @ObfuscatedName("NRPYRAWK.r")
   public int r;
   @ObfuscatedName("NRPYRAWK.A")
   public int A;
   @ObfuscatedName("NRPYRAWK.v")
   public static Client v;

   @ObfuscatedName("NRPYRAWK.a(I)LYMYTDPVW;")
   public final LocType a(int arg0) {
      int var2 = -1;
      if (arg0 != 0) {
         this.A = 109;
      }

      if (this.x != -1) {
         VarbitType var3 = VarbitType.types[this.x];
         int var4 = var3.basevar;
         int var5 = var3.startbit;
         int var6 = var3.endbit;
         int var7 = Client.BITMASK[var6 - var5];
         var2 = v.varps[var4] >> var5 & var7;
      } else if (this.y != -1) {
         var2 = v.varps[this.y];
      }

      return var2 >= 0 && var2 < this.z.length && this.z[var2] != -1 ? LocType.get(this.z[var2]) : null;
   }

   public ClientLocAnim(int arg0, int arg1, int arg2, int arg3, int arg4, byte arg5, int arg6, boolean arg7, int arg8, int arg9) {
      this.s = arg6;
      this.t = arg4;
      this.u = arg9;
      this.n = arg8;
      this.o = arg3;
      this.p = arg1;
      this.q = arg2;
      if (arg0 != -1) {
         this.w = SeqType.types[arg0];
         this.C = 0;
         this.B = Client.loopCycle - 1;
         if (arg7 && this.w.i != -1) {
            this.C = (int)(Math.random() * (double)this.w.e);
            this.B -= (int)(Math.random() * (double)this.w.a(0, this.C));
         }
      }

      LocType var11 = LocType.get(this.s);
      this.x = var11.multivarbit;
      this.y = var11.multivarp;
      this.z = var11.multiloc;
      if (arg5 != 3) {
         this.r = -126;
      }
   }

   @ObfuscatedName("NRPYRAWK.a(B)LLZYQDKJV;")
   public final Model a(byte arg0) {
      if (arg0 != 3) {
         this.m = !this.m;
      }

      int var2 = -1;
      if (this.w != null) {
         int var3 = Client.loopCycle - this.B;
         if (var3 > 100 && this.w.i > 0) {
            var3 = 100;
         }

         label48: {
            do {
               do {
                  if (var3 <= this.w.a(0, this.C)) {
                     break label48;
                  }

                  var3 -= this.w.a(0, this.C);
                  ++this.C;
               } while(this.C < this.w.e);

               this.C -= this.w.i;
            } while(this.C >= 0 && this.C < this.w.e);

            this.w = null;
         }

         this.B = Client.loopCycle - var3;
         if (this.w != null) {
            var2 = this.w.frames[this.C];
         }
      }

      LocType var4;
      if (this.z != null) {
         var4 = this.a((int)0);
      } else {
         var4 = LocType.get(this.s);
      }

      return var4 == null ? null : var4.a(this.t, this.u, this.n, this.o, this.p, this.q, var2);
   }
}
