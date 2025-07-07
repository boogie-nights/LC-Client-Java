package jagex2.datastruct;

import deob.ObfuscatedName;

public class HashTable {
   @ObfuscatedName("JLFXAIRK.a")
   public boolean a = true;
   @ObfuscatedName("JLFXAIRK.b")
   public boolean b = true;
   @ObfuscatedName("JLFXAIRK.c")
   public int c;
   @ObfuscatedName("JLFXAIRK.d")
   public Linkable[] d;

   public HashTable(byte arg0, int arg1) {
      this.c = arg1;
      this.d = new Linkable[arg1];

      for(int var3 = 0; var3 < arg1; ++var3) {
         Linkable var4 = this.d[var3] = new Linkable();
         var4.b = var4;
         var4.c = var4;
      }

      if (arg0 != 0) {
         for(int var5 = 1; var5 > 0; ++var5) {
         }

      }
   }

   @ObfuscatedName("JLFXAIRK.a(J)LZUOIJLRD;")
   public Linkable a(long arg0) {
      Linkable var3 = this.d[(int)(arg0 & (long)(this.c - 1))];

      for(Linkable var4 = var3.b; var3 != var4; var4 = var4.b) {
         if (var4.a == arg0) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("JLFXAIRK.a(ILZUOIJLRD;J)V")
   public void a(int arg0, Linkable arg1, long arg2) {
      if (arg1.c != null) {
         arg1.unlink();
      }

      Linkable var5 = this.d[(int)(arg2 & (long)(this.c - 1))];
      if (arg0 == 6) {
         arg1.c = var5.c;
         arg1.b = var5;
         arg1.c.b = arg1;
         arg1.b.c = arg1;
         arg1.a = arg2;
      }
   }
}
