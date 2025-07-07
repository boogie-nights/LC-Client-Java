package jagex2.datastruct;

import deob.ObfuscatedName;

public class LinkList {
   @ObfuscatedName("BOHLFXVX.a")
   public int a = -48545;
   @ObfuscatedName("BOHLFXVX.c")
   public Linkable c = new Linkable();
   @ObfuscatedName("BOHLFXVX.b")
   public int b;
   @ObfuscatedName("BOHLFXVX.d")
   public Linkable d;

   public LinkList() {
      this.c.b = this.c;
      this.c.c = this.c;
   }

   @ObfuscatedName("BOHLFXVX.a(LZUOIJLRD;)V")
   public void a(Linkable arg0) {
      if (arg0.c != null) {
         arg0.a();
      }

      arg0.c = this.c.c;
      arg0.b = this.c;
      arg0.c.b = arg0;
      arg0.b.c = arg0;
   }

   @ObfuscatedName("BOHLFXVX.a(BLZUOIJLRD;)V")
   public void a(byte arg0, Linkable arg1) {
      if (arg0 != -57) {
         this.b = -23;
      }

      if (arg1.c != null) {
         arg1.a();
      }

      arg1.c = this.c;
      arg1.b = this.c.b;
      arg1.c.b = arg1;
      arg1.b.c = arg1;
   }

   @ObfuscatedName("BOHLFXVX.a()LZUOIJLRD;")
   public Linkable pop() {
      Linkable var1 = this.c.b;
      if (this.c == var1) {
         return null;
      } else {
         var1.a();
         return var1;
      }
   }

   @ObfuscatedName("BOHLFXVX.b()LZUOIJLRD;")
   public Linkable b() {
      Linkable var1 = this.c.b;
      if (this.c == var1) {
         this.d = null;
         return null;
      } else {
         this.d = var1.b;
         return var1;
      }
   }

   @ObfuscatedName("BOHLFXVX.a(Z)LZUOIJLRD;")
   public Linkable a(boolean arg0) {
      Linkable var2 = this.c.c;
      if (arg0) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

      if (this.c == var2) {
         this.d = null;
         return null;
      } else {
         this.d = var2.c;
         return var2;
      }
   }

   @ObfuscatedName("BOHLFXVX.a(I)LZUOIJLRD;")
   public Linkable a(int arg0) {
      Linkable var2 = this.d;
      if (this.c == var2) {
         this.d = null;
         return null;
      } else {
         this.d = var2.b;
         if (arg0 != 1) {
            throw new NullPointerException();
         } else {
            return var2;
         }
      }
   }

   @ObfuscatedName("BOHLFXVX.b(I)LZUOIJLRD;")
   public Linkable b(int arg0) {
      Linkable var2 = this.d;
      if (arg0 <= 0) {
         throw new NullPointerException();
      } else if (this.c == var2) {
         this.d = null;
         return null;
      } else {
         this.d = var2.c;
         return var2;
      }
   }

   @ObfuscatedName("BOHLFXVX.c()V")
   public void c() {
      if (this.c.b != this.c) {
         while(true) {
            Linkable var1 = this.c.b;
            if (this.c == var1) {
               return;
            }

            var1.a();
         }
      }
   }
}
