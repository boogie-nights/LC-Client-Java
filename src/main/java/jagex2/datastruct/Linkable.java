package jagex2.datastruct;

import deob.ObfuscatedName;

public class Linkable {
   @ObfuscatedName("ZUOIJLRD.a")
   public long a;
   @ObfuscatedName("ZUOIJLRD.b")
   public Linkable b;
   @ObfuscatedName("ZUOIJLRD.c")
   public Linkable c;
   @ObfuscatedName("ZUOIJLRD.d")
   public static boolean d;

   @ObfuscatedName("ZUOIJLRD.a()V")
   public void a() {
      if (this.c != null) {
         this.c.b = this.b;
         this.b.c = this.c;
         this.b = null;
         this.c = null;
      }
   }
}
