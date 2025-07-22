package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.SpotAnimType;

public class MapSpotAnim extends ModelSource {
   @ObfuscatedName("WHUAOHZM.q")
   public boolean q = true;
   @ObfuscatedName("WHUAOHZM.r")
   public boolean r = false;
   @ObfuscatedName("WHUAOHZM.u")
   public SpotAnimType u;
   @ObfuscatedName("WHUAOHZM.m")
   public int m;
   @ObfuscatedName("WHUAOHZM.n")
   public int n;
   @ObfuscatedName("WHUAOHZM.o")
   public int o;
   @ObfuscatedName("WHUAOHZM.p")
   public int p;
   @ObfuscatedName("WHUAOHZM.v")
   public int v;
   @ObfuscatedName("WHUAOHZM.s")
   public int s;
   @ObfuscatedName("WHUAOHZM.t")
   public int t;

   @ObfuscatedName("WHUAOHZM.a(BI)V")
   public final void a(byte arg0, int arg1) {
      this.t += arg1;
      if (arg0 == 1) {
         boolean var3 = false;

         while(true) {
            do {
               do {
                  if (this.t <= this.u.i.a(0, this.s)) {
                     return;
                  }

                  this.t -= this.u.i.a(0, this.s);
                  ++this.s;
               } while(this.s < this.u.i.e);
            } while(this.s >= 0 && this.s < this.u.i.e);

            this.s = 0;
            this.r = true;
         }
      }
   }

   public MapSpotAnim(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
      this.u = SpotAnimType.e[arg4];
      this.m = arg1;
      this.n = arg0;
      this.o = arg6;
      if (arg7 != 10709) {
         for(int var9 = 1; var9 > 0; ++var9) {
         }
      }

      this.p = arg2;
      this.v = arg3 + arg5;
      this.r = false;
   }

   @ObfuscatedName("WHUAOHZM.a(B)LLZYQDKJV;")
   public final Model a(byte arg0) {
      if (arg0 != 3) {
         throw new NullPointerException();
      } else {
         Model var2 = this.u.a();
         if (var2 == null) {
            return null;
         } else {
            int var3 = this.u.i.frames[this.s];
            Model var4 = new Model(false, false, true, var2, AnimFrame.a(this.q, var3));
            if (!this.r) {
               var4.createLabelReferences(7);
               var4.applyTransform(var3, (byte)6);
               var4.db = null;
               var4.cb = null;
            }

            if (this.u.l != 128 || this.u.m != 128) {
               var4.a(this.u.m, this.u.l, 9, this.u.l);
            }

            if (this.u.n != 0) {
               if (this.u.n == 90) {
                  var4.b(true);
               }

               if (this.u.n == 180) {
                  var4.b(true);
                  var4.b(true);
               }

               if (this.u.n == 270) {
                  var4.b(true);
                  var4.b(true);
                  var4.b(true);
               }
            }

            var4.calculateNormals(this.u.o + 64, this.u.p + 850, -30, -50, -30, true);
            return var4;
         }
      }
   }
}
