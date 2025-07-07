package jagex2.client;

import deob.ObfuscatedName;

public class MouseTracking implements Runnable {
   @ObfuscatedName("BORSVOPG.a")
   public boolean a = true;
   @ObfuscatedName("BORSVOPG.b")
   public int[] b = new int[500];
   @ObfuscatedName("BORSVOPG.c")
   public Object c = new Object();
   @ObfuscatedName("BORSVOPG.e")
   public int e = 8;
   @ObfuscatedName("BORSVOPG.g")
   public int[] g = new int[500];
   @ObfuscatedName("BORSVOPG.d")
   public Client d;
   @ObfuscatedName("BORSVOPG.f")
   public int f;

   public MouseTracking(Client arg0, byte arg1) {
      if (arg1 != -116) {
         this.e = 294;
      }

      this.d = arg0;
   }

   public void run() {
      while(this.a) {
         Object var1 = this.c;
         synchronized(this.c) {
            if (this.f < 500) {
               this.g[this.f] = this.d.v;
               this.b[this.f] = this.d.w;
               ++this.f;
            }
         }

         try {
            Thread.sleep(50L);
         } catch (Exception var2) {
         }
      }

   }
}
