package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.SpotAnimType;

public class ClientProj extends ModelSource {
   @ObfuscatedName("KFJRVZCI.u")
   public boolean u = false;
   @ObfuscatedName("KFJRVZCI.x")
   public byte x = -41;
   @ObfuscatedName("KFJRVZCI.G")
   public boolean G = true;
   @ObfuscatedName("KFJRVZCI.I")
   public boolean I = false;
   @ObfuscatedName("KFJRVZCI.m")
   public SpotAnimType m;
   @ObfuscatedName("KFJRVZCI.n")
   public int n;
   @ObfuscatedName("KFJRVZCI.J")
   public int J;
   @ObfuscatedName("KFJRVZCI.K")
   public int K;
   @ObfuscatedName("KFJRVZCI.L")
   public int L;
   @ObfuscatedName("KFJRVZCI.y")
   public int y;
   @ObfuscatedName("KFJRVZCI.z")
   public int z;
   @ObfuscatedName("KFJRVZCI.r")
   public int r;
   @ObfuscatedName("KFJRVZCI.s")
   public int s;
   @ObfuscatedName("KFJRVZCI.t")
   public int t;
   @ObfuscatedName("KFJRVZCI.M")
   public int M;
   @ObfuscatedName("KFJRVZCI.C")
   public double C;
   @ObfuscatedName("KFJRVZCI.D")
   public double D;
   @ObfuscatedName("KFJRVZCI.E")
   public double E;
   @ObfuscatedName("KFJRVZCI.F")
   public double F;
   @ObfuscatedName("KFJRVZCI.H")
   public double H;
   @ObfuscatedName("KFJRVZCI.o")
   public double o;
   @ObfuscatedName("KFJRVZCI.p")
   public double p;
   @ObfuscatedName("KFJRVZCI.q")
   public double q;
   @ObfuscatedName("KFJRVZCI.A")
   public int A;
   @ObfuscatedName("KFJRVZCI.B")
   public int B;
   @ObfuscatedName("KFJRVZCI.v")
   public int v;
   @ObfuscatedName("KFJRVZCI.w")
   public int w;

   @ObfuscatedName("KFJRVZCI.a(IIIII)V")
   public final void a(int arg0, int arg1, int arg2, int arg3, int arg4) {
      if (!this.I) {
         double var6 = (double)(arg0 - this.J);
         double var8 = (double)(arg1 - this.K);
         double var10 = Math.sqrt(var6 * var6 + var8 * var8);
         this.o = (double)this.s * var6 / var10 + (double)this.J;
         this.p = (double)this.s * var8 / var10 + (double)this.K;
         this.q = (double)this.L;
      }

      double var12 = (double)(this.z + 1 - arg3);
      this.C = ((double)arg0 - this.o) / var12;
      this.D = ((double)arg1 - this.p) / var12;
      if (arg4 == 0) {
         this.E = Math.sqrt(this.D * this.D + this.C * this.C);
         if (!this.I) {
            this.F = -this.E * Math.tan((double)this.r * 0.02454369D);
         }

         this.H = ((double)arg2 - this.q - this.F * var12) * 2.0D / (var12 * var12);
      }
   }

   @ObfuscatedName("KFJRVZCI.a(IZ)V")
   public final void a(int arg0, boolean arg1) {
      this.I = true;
      this.o += (double)arg0 * this.C;
      if (arg1) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

      this.p += (double)arg0 * this.D;
      this.q += this.H * 0.5D * (double)arg0 * (double)arg0 + (double)arg0 * this.F;
      this.F += (double)arg0 * this.H;
      this.v = (int)(Math.atan2(this.C, this.D) * 325.949D) + 1024 & 2047;
      this.w = (int)(Math.atan2(this.F, this.E) * 325.949D) & 2047;
      if (this.m.i != null) {
         this.B += arg0;

         while(this.B > this.m.i.a(0, this.A)) {
            this.B -= this.m.i.a(0, this.A);
            ++this.A;
            if (this.A >= this.m.i.e) {
               this.A = 0;
            }
         }

      }
   }

   @ObfuscatedName("KFJRVZCI.a(B)LLZYQDKJV;")
   public final Model a(byte arg0) {
      Model var2 = this.m.a();
      if (var2 == null) {
         return null;
      } else {
         int var3 = -1;
         if (this.m.i != null) {
            var3 = this.m.i.f[this.A];
         }

         Model var4 = new Model(false, false, true, var2, AnimFrame.a(this.G, var3));
         if (var3 != -1) {
            var4.createLabelReferences(7);
            var4.applyTransform(var3, (byte)6);
            var4.db = null;
            var4.cb = null;
         }

         if (this.m.l != 128 || this.m.m != 128) {
            var4.a(this.m.m, this.m.l, 9, this.m.l);
         }

         var4.b(this.w, 341);
         var4.calculateNormals(this.m.o + 64, this.m.p + 850, -30, -50, -30, true);
         if (arg0 == 3) {
            boolean var5 = false;
         } else {
            this.u = !this.u;
         }

         return var4;
      }
   }

   public ClientProj(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, byte arg8, int arg9, int arg10, int arg11) {
      this.m = SpotAnimType.e[arg4];
      this.n = arg0;
      this.J = arg10;
      this.K = arg3;
      this.L = arg9;
      this.y = arg11;
      this.z = arg5;
      if (this.x != arg8) {
         throw new NullPointerException();
      } else {
         this.r = arg6;
         this.s = arg2;
         this.t = arg7;
         this.M = arg1;
         this.I = false;
      }
   }
}
