package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.ObjType;

public class ClientObj extends ModelSource {
   @ObfuscatedName("HRIUIFAV.m")
   public int m;
   @ObfuscatedName("HRIUIFAV.n")
   public int n;
   @ObfuscatedName("HRIUIFAV.o")
   public int o;

   @ObfuscatedName("HRIUIFAV.a(B)LLZYQDKJV;")
   public final Model a(byte arg0) {
      if (arg0 != 3) {
         this.n = -358;
      }

      ObjType var2 = ObjType.get(this.m);
      return var2.getModel(this.o);
   }
}
