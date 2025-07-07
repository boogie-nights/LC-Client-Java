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
      this.c.next = this.c;
      this.c.prev = this.c;
   }

   @ObfuscatedName("BOHLFXVX.a(LZUOIJLRD;)V")
   public void push(Linkable arg0) {
      if (arg0.prev != null) {
         arg0.unlink();
      }

      arg0.prev = this.c.prev;
      arg0.next = this.c;
      arg0.prev.next = arg0;
      arg0.next.prev = arg0;
   }

   @ObfuscatedName("BOHLFXVX.a(BLZUOIJLRD;)V")
   public void a(byte arg0, Linkable arg1) {
      if (arg0 != -57) {
         this.b = -23;
      }

      if (arg1.prev != null) {
         arg1.unlink();
      }

      arg1.prev = this.c;
      arg1.next = this.c.next;
      arg1.prev.next = arg1;
      arg1.next.prev = arg1;
   }

   @ObfuscatedName("BOHLFXVX.a()LZUOIJLRD;")
   public Linkable pop() {
      Linkable var1 = this.c.next;
      if (this.c == var1) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   @ObfuscatedName("BOHLFXVX.b()LZUOIJLRD;")
   public Linkable head() {
      Linkable var1 = this.c.next;
      if (this.c == var1) {
         this.d = null;
         return null;
      } else {
         this.d = var1.next;
         return var1;
      }
   }

   @ObfuscatedName("BOHLFXVX.a(Z)LZUOIJLRD;")
   public Linkable a(boolean arg0) {
      Linkable var2 = this.c.prev;
      if (arg0) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

      if (this.c == var2) {
         this.d = null;
         return null;
      } else {
         this.d = var2.prev;
         return var2;
      }
   }

   @ObfuscatedName("BOHLFXVX.a(I)LZUOIJLRD;")
   public Linkable next(int arg0) {
      Linkable var2 = this.d;
      if (this.c == var2) {
         this.d = null;
         return null;
      } else {
         this.d = var2.next;
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
         this.d = var2.prev;
         return var2;
      }
   }

   @ObfuscatedName("BOHLFXVX.c()V")
   public void clear() {
      if (this.c.next != this.c) {
         while(true) {
            Linkable var1 = this.c.next;
            if (this.c == var1) {
               return;
            }

            var1.unlink();
         }
      }
   }
}
