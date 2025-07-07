package jagex2.datastruct;

import deob.ObfuscatedName;

public class DoublyLinkable extends Linkable {
   @ObfuscatedName("DPPNUUMQ.g")
   public static int g;
   @ObfuscatedName("DPPNUUMQ.e")
   public DoublyLinkable e;
   @ObfuscatedName("DPPNUUMQ.f")
   public DoublyLinkable f;

   @ObfuscatedName("DPPNUUMQ.b()V")
   public void b() {
      if (this.f != null) {
         this.f.e = this.e;
         this.e.f = this.f;
         this.e = null;
         this.f = null;
      }
   }
}
