package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.io.Packet;

public class AnimBase {
   @ObfuscatedName("VPIFXIOD.a")
   public int a;
   @ObfuscatedName("VPIFXIOD.b")
   public int[] b;
   @ObfuscatedName("VPIFXIOD.c")
   public int[][] c;

   public AnimBase(Packet arg0, int arg1) {
      this.a = arg0.g1();
      if (arg1 != 0) {
         throw new NullPointerException();
      } else {
         this.b = new int[this.a];
         this.c = new int[this.a][];

         for(int var3 = 0; var3 < this.a; ++var3) {
            this.b[var3] = arg0.g1();
         }

         for(int var4 = 0; var4 < this.a; ++var4) {
            int var5 = arg0.g1();
            this.c[var4] = new int[var5];

            for(int var6 = 0; var6 < var5; ++var6) {
               this.c[var4][var6] = arg0.g1();
            }
         }

      }
   }
}
