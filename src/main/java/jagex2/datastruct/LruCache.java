package jagex2.datastruct;

import deob.ObfuscatedName;

public class LruCache {
   @ObfuscatedName("RHNYLZZL.a")
   public int a = 256;
   @ObfuscatedName("RHNYLZZL.d")
   public DoublyLinkable d = new DoublyLinkable();
   @ObfuscatedName("RHNYLZZL.h")
   public DoublyLinkList h = new DoublyLinkList(true);
   @ObfuscatedName("RHNYLZZL.e")
   public int e;
   @ObfuscatedName("RHNYLZZL.f")
   public int f;
   @ObfuscatedName("RHNYLZZL.g")
   public HashTable g;
   @ObfuscatedName("RHNYLZZL.b")
   public int b;
   @ObfuscatedName("RHNYLZZL.c")
   public int c;

   public LruCache(int arg0, int arg1) {
      this.e = arg0;
      if (arg1 >= 0) {
         this.a = 433;
      }

      this.f = arg0;
      this.g = new HashTable((byte)0, 1024);
   }

   @ObfuscatedName("RHNYLZZL.a(J)LDPPNUUMQ;")
   public DoublyLinkable a(long arg0) {
      DoublyLinkable var3 = (DoublyLinkable)this.g.a(arg0);
      if (var3 != null) {
         this.h.push(var3);
         ++this.c;
      } else {
         ++this.b;
      }

      return var3;
   }

   @ObfuscatedName("RHNYLZZL.a(LDPPNUUMQ;JI)V")
   public void a(DoublyLinkable arg0, long arg1, int arg2) {
      if (arg2 != 5) {
         this.a = 150;
      }

      if (this.f == 0) {
         DoublyLinkable var5 = this.h.a();
         var5.unlink();
         var5.unlink2();
         if (this.d == var5) {
            DoublyLinkable var6 = this.h.a();
            var6.unlink();
            var6.unlink2();
         }
      } else {
         --this.f;
      }

      this.g.a(6, arg0, arg1);
      this.h.push(arg0);
      if (Linkable.d) {
      }

   }

   @ObfuscatedName("RHNYLZZL.a()V")
   public void a() {
      while(true) {
         DoublyLinkable var1 = this.h.a();
         if (var1 == null) {
            this.f = this.e;
            return;
         }

         var1.unlink();
         var1.unlink2();
      }
   }
}
