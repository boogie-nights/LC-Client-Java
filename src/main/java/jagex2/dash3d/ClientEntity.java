package jagex2.dash3d;

import deob.ObfuscatedName;

public abstract class ClientEntity extends ModelSource {
   @ObfuscatedName("LRUWCBNN.n")
   public int n = -89;
   @ObfuscatedName("LRUWCBNN.o")
   public int o = 100;
   @ObfuscatedName("LRUWCBNN.s")
   public int[] s = new int[10];
   @ObfuscatedName("LRUWCBNN.t")
   public int[] t = new int[10];
   @ObfuscatedName("LRUWCBNN.u")
   public int u = -1;
   @ObfuscatedName("LRUWCBNN.x")
   public boolean[] x = new boolean[10];
   @ObfuscatedName("LRUWCBNN.y")
   public boolean y = false;
   @ObfuscatedName("LRUWCBNN.A")
   public int A = 200;
   @ObfuscatedName("LRUWCBNN.B")
   public int B = -1000;
   @ObfuscatedName("LRUWCBNN.G")
   public int G = 32;
   @ObfuscatedName("LRUWCBNN.H")
   public int H = 1;
   @ObfuscatedName("LRUWCBNN.P")
   public int P = -1;
   @ObfuscatedName("LRUWCBNN.U")
   public int U = -1;
   @ObfuscatedName("LRUWCBNN.Z")
   public int Z = -1;
   @ObfuscatedName("LRUWCBNN.ab")
   public int ab = -1;
   @ObfuscatedName("LRUWCBNN.bb")
   public int bb = -1;
   @ObfuscatedName("LRUWCBNN.cb")
   public int cb = -1;
   @ObfuscatedName("LRUWCBNN.eb")
   public int eb = -1;
   @ObfuscatedName("LRUWCBNN.jb")
   public int jb = -1;
   @ObfuscatedName("LRUWCBNN.kb")
   public int[] kb = new int[4];
   @ObfuscatedName("LRUWCBNN.lb")
   public int[] lb = new int[4];
   @ObfuscatedName("LRUWCBNN.mb")
   public int[] mb = new int[4];
   @ObfuscatedName("LRUWCBNN.ob")
   public int ob = -1;
   @ObfuscatedName("LRUWCBNN.pb")
   public int pb = -1;
   @ObfuscatedName("LRUWCBNN.C")
   public int C;
   @ObfuscatedName("LRUWCBNN.D")
   public int D;
   @ObfuscatedName("LRUWCBNN.E")
   public int E;
   @ObfuscatedName("LRUWCBNN.F")
   public int F;
   @ObfuscatedName("LRUWCBNN.I")
   public int I;
   @ObfuscatedName("LRUWCBNN.J")
   public int J;
   @ObfuscatedName("LRUWCBNN.K")
   public int K;
   @ObfuscatedName("LRUWCBNN.L")
   public int L;
   @ObfuscatedName("LRUWCBNN.M")
   public int M;
   @ObfuscatedName("LRUWCBNN.N")
   public int N;
   @ObfuscatedName("LRUWCBNN.O")
   public int O;
   @ObfuscatedName("LRUWCBNN.Q")
   public int Q;
   @ObfuscatedName("LRUWCBNN.R")
   public int R;
   @ObfuscatedName("LRUWCBNN.S")
   public int S;
   @ObfuscatedName("LRUWCBNN.T")
   public int T;
   @ObfuscatedName("LRUWCBNN.V")
   public int V;
   @ObfuscatedName("LRUWCBNN.W")
   public int W;
   @ObfuscatedName("LRUWCBNN.X")
   public int X;
   @ObfuscatedName("LRUWCBNN.Y")
   public int Y;
   @ObfuscatedName("LRUWCBNN.db")
   public int db;
   @ObfuscatedName("LRUWCBNN.fb")
   public int fb;
   @ObfuscatedName("LRUWCBNN.gb")
   public int gb;
   @ObfuscatedName("LRUWCBNN.hb")
   public int hb;
   @ObfuscatedName("LRUWCBNN.ib")
   public int ib;
   @ObfuscatedName("LRUWCBNN.nb")
   public int nb;
   @ObfuscatedName("LRUWCBNN.p")
   public int p;
   @ObfuscatedName("LRUWCBNN.q")
   public int q;
   @ObfuscatedName("LRUWCBNN.r")
   public int r;
   @ObfuscatedName("LRUWCBNN.v")
   public int v;
   @ObfuscatedName("LRUWCBNN.w")
   public int w;
   @ObfuscatedName("LRUWCBNN.z")
   public int z;
   @ObfuscatedName("LRUWCBNN.m")
   public String m;

   @ObfuscatedName("LRUWCBNN.a(I)V")
   public final void a(int arg0) {
      this.nb = 0;
      this.T = 0;
      if (arg0 >= 0) {
         ;
      }
   }

   @ObfuscatedName("LRUWCBNN.b(I)Z")
   public boolean b(int arg0) {
      if (arg0 != 0) {
         throw new NullPointerException();
      } else {
         return false;
      }
   }

   @ObfuscatedName("LRUWCBNN.a(ZII)V")
   public final void a(boolean arg0, int arg1, int arg2) {
      if (arg2 < 0) {
         int var4 = this.s[0];
         int var5 = this.t[0];
         if (arg1 == 0) {
            --var4;
            ++var5;
         }

         if (arg1 == 1) {
            ++var5;
         }

         if (arg1 == 2) {
            ++var4;
            ++var5;
         }

         if (arg1 == 3) {
            --var4;
         }

         if (arg1 == 4) {
            ++var4;
         }

         if (arg1 == 5) {
            --var4;
            --var5;
         }

         if (arg1 == 6) {
            --var5;
         }

         if (arg1 == 7) {
            ++var4;
            --var5;
         }

         if (this.eb != -1 && SeqType.d[this.eb].q == 1) {
            this.eb = -1;
         }

         if (this.nb < 9) {
            ++this.nb;
         }

         for(int var6 = this.nb; var6 > 0; --var6) {
            this.s[var6] = this.s[var6 - 1];
            this.t[var6] = this.t[var6 - 1];
            this.x[var6] = this.x[var6 - 1];
         }

         this.s[0] = var4;
         this.t[0] = var5;
         this.x[0] = arg0;
      }
   }

   @ObfuscatedName("LRUWCBNN.a(IZII)V")
   public final void a(int arg0, boolean arg1, int arg2, int arg3) {
      for(int var5 = 0; var5 < 4; ++var5) {
         if (this.mb[var5] <= arg0) {
            this.kb[var5] = arg2;
            this.lb[var5] = arg3;
            this.mb[var5] = arg0 + 70;
            return;
         }
      }

      if (arg1) {
         this.n = -52;
      }
   }

   @ObfuscatedName("LRUWCBNN.a(IBZI)V")
   public final void a(int arg0, byte arg1, boolean arg2, int arg3) {
      if (this.eb != -1 && SeqType.d[this.eb].q == 1) {
         this.eb = -1;
      }

      if (!arg2) {
         int var5 = arg3 - this.s[0];
         int var6 = arg0 - this.t[0];
         if (var5 >= -8 && var5 <= 8 && var6 >= -8 && var6 <= 8) {
            if (this.nb < 9) {
               ++this.nb;
            }

            for(int var7 = this.nb; var7 > 0; --var7) {
               this.s[var7] = this.s[var7 - 1];
               this.t[var7] = this.t[var7 - 1];
               this.x[var7] = this.x[var7 - 1];
            }

            this.s[0] = arg3;
            this.t[0] = arg0;
            this.x[0] = false;
            return;
         }
      }

      this.nb = 0;
      this.T = 0;
      this.db = 0;
      this.s[0] = arg3;
      this.t[0] = arg0;
      if (arg1 == 5) {
         boolean var8 = false;
      } else {
         for(int var9 = 1; var9 > 0; ++var9) {
         }
      }

      this.Q = this.s[0] * 128 + this.H * 64;
      this.R = this.t[0] * 128 + this.H * 64;
   }
}
