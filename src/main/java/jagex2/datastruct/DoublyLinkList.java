package jagex2.datastruct;

import deob.ObfuscatedName;

public class DoublyLinkList {
   @ObfuscatedName("CZYJUOKA.a")
   public boolean a = true;
   @ObfuscatedName("CZYJUOKA.b")
   public DoublyLinkable b = new DoublyLinkable();
   @ObfuscatedName("CZYJUOKA.c")
   public DoublyLinkable c;

   public DoublyLinkList(boolean arg0) {
      this.b.e = this.b;
      this.b.f = this.b;
      if (!arg0) {
         for(int var2 = 1; var2 > 0; ++var2) {
         }

      }
   }

   @ObfuscatedName("CZYJUOKA.a(LDPPNUUMQ;)V")
   public void a(DoublyLinkable arg0) {
      if (arg0.f != null) {
         arg0.b();
      }

      arg0.f = this.b.f;
      arg0.e = this.b;
      arg0.f.e = arg0;
      arg0.e.f = arg0;
   }

   @ObfuscatedName("CZYJUOKA.a()LDPPNUUMQ;")
   public DoublyLinkable a() {
      DoublyLinkable var1 = this.b.e;
      if (this.b == var1) {
         return null;
      } else {
         var1.b();
         return var1;
      }
   }

   @ObfuscatedName("CZYJUOKA.b()LDPPNUUMQ;")
   public DoublyLinkable b() {
      DoublyLinkable var1 = this.b.e;
      if (this.b == var1) {
         this.c = null;
         return null;
      } else {
         this.c = var1.e;
         return var1;
      }
   }

   @ObfuscatedName("CZYJUOKA.a(I)LDPPNUUMQ;")
   public DoublyLinkable a(int arg0) {
      DoublyLinkable var2 = this.c;
      if (this.b == var2) {
         this.c = null;
         return null;
      } else {
         this.c = var2.e;
         if (arg0 < 1 || arg0 > 1) {
            this.a = !this.a;
         }

         return var2;
      }
   }

   @ObfuscatedName("CZYJUOKA.c()I")
   public int c() {
      int var1 = 0;

      for(DoublyLinkable var2 = this.b.e; this.b != var2; var2 = var2.e) {
         ++var1;
      }

      return var1;
   }
}
