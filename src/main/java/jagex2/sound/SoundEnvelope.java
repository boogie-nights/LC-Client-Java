package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.io.Packet;

public class SoundEnvelope {
   @ObfuscatedName("PFANSVWX.a")
   public boolean a = true;
   @ObfuscatedName("PFANSVWX.b")
   public int b;
   @ObfuscatedName("PFANSVWX.e")
   public int e;
   @ObfuscatedName("PFANSVWX.f")
   public int f;
   @ObfuscatedName("PFANSVWX.g")
   public int g;
   @ObfuscatedName("PFANSVWX.h")
   public int h;
   @ObfuscatedName("PFANSVWX.i")
   public int i;
   @ObfuscatedName("PFANSVWX.j")
   public int j;
   @ObfuscatedName("PFANSVWX.k")
   public int k;
   @ObfuscatedName("PFANSVWX.l")
   public int l;
   @ObfuscatedName("PFANSVWX.m")
   public static int m;
   @ObfuscatedName("PFANSVWX.c")
   public int[] c;
   @ObfuscatedName("PFANSVWX.d")
   public int[] d;

   @ObfuscatedName("PFANSVWX.a(BLMFMVIYHT;)V")
   public final void a(byte arg0, Packet arg1) {
      this.g = arg1.g1();
      if (arg0 == 6) {
         boolean var3 = false;
         this.e = arg1.g4();
         this.f = arg1.g4();
         this.a(arg1, 0);
      } else {
         throw new NullPointerException();
      }
   }

   @ObfuscatedName("PFANSVWX.a(LMFMVIYHT;I)V")
   public final void a(Packet arg0, int arg1) {
      this.b = arg0.g1();
      this.c = new int[this.b];
      this.d = new int[this.b];
      if (arg1 == 0) {
         for(int var3 = 0; var3 < this.b; ++var3) {
            this.c[var3] = arg0.g2();
            this.d[var3] = arg0.g2();
         }

      }
   }

   @ObfuscatedName("PFANSVWX.a(Z)V")
   public final void a(boolean arg0) {
      this.h = 0;
      this.i = 0;
      if (arg0) {
         this.j = 0;
         this.k = 0;
         this.l = 0;
      }
   }

   @ObfuscatedName("PFANSVWX.a(II)I")
   public final int a(int arg0, int arg1) {
      if (arg0 != 0) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

      if (this.l >= this.h) {
         this.k = this.d[this.i++] << 15;
         if (this.i >= this.b) {
            this.i = this.b - 1;
         }

         this.h = (int)((double)this.c[this.i] / 65536.0D * (double)arg1);
         if (this.h > this.l) {
            this.j = ((this.d[this.i] << 15) - this.k) / (this.h - this.l);
         }
      }

      this.k += this.j;
      ++this.l;
      return this.k - this.j >> 15;
   }
}
