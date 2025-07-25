package jagex2.config;

import jagex2.dash3d.AnimFrame;
import jagex2.io.Jagfile;
import deob.ObfuscatedName;
import jagex2.io.Packet;

public class SeqType {
   @ObfuscatedName("FHWCLIAS.b")
   public boolean b = false;
   @ObfuscatedName("FHWCLIAS.i")
   public int i = -1;
   @ObfuscatedName("FHWCLIAS.k")
   public boolean k = false;
   @ObfuscatedName("FHWCLIAS.l")
   public int priority = 5;
   @ObfuscatedName("FHWCLIAS.m")
   public int m = -1;
   @ObfuscatedName("FHWCLIAS.n")
   public int n = -1;
   @ObfuscatedName("FHWCLIAS.o")
   public int o = 99;
   @ObfuscatedName("FHWCLIAS.p")
   public int p = -1;
   @ObfuscatedName("FHWCLIAS.q")
   public int postanim_mode = -1;
   @ObfuscatedName("FHWCLIAS.r")
   public int restart_mode = 2;
   @ObfuscatedName("FHWCLIAS.a")
   public static byte a = 6;
   @ObfuscatedName("FHWCLIAS.c")
   public static int c;
   @ObfuscatedName("FHWCLIAS.e")
   public int e;
   @ObfuscatedName("FHWCLIAS.s")
   public int s;
   @ObfuscatedName("FHWCLIAS.t")
   public static int t;
   @ObfuscatedName("FHWCLIAS.f")
   public int[] frames;
   @ObfuscatedName("FHWCLIAS.g")
   public int[] g;
   @ObfuscatedName("FHWCLIAS.h")
   public int[] h;
   @ObfuscatedName("FHWCLIAS.j")
   public int[] j;
   @ObfuscatedName("FHWCLIAS.d")
   public static SeqType[] types;

   @ObfuscatedName("FHWCLIAS.a(LATJMVOZR;I)V")
   public static void unpack(Jagfile arg0, int arg1) {
      Packet var2 = new Packet(arg0.read("seq.dat", (byte[])null));
      c = var2.g2();
      if (types == null) {
         types = new SeqType[c];
      }

      for(int var3 = 0; var3 < c; ++var3) {
         if (types[var3] == null) {
            types[var3] = new SeqType();
         }

         types[var3].a(a, var2);
      }

      if (arg1 == 36135) {
         ;
      }
   }

   @ObfuscatedName("FHWCLIAS.a(II)I")
   public int a(int arg0, int arg1) {
      int var3 = this.h[arg1];
      if (arg0 != 0) {
         return 1;
      } else {
         if (var3 == 0) {
            AnimFrame var4 = AnimFrame.b(this.frames[arg1]);
            if (var4 != null) {
               var3 = this.h[arg1] = var4.d;
            }
         }

         if (var3 == 0) {
            var3 = 1;
         }

         return var3;
      }
   }

   @ObfuscatedName("FHWCLIAS.a(BLMFMVIYHT;)V")
   public void a(byte arg0, Packet arg1) {
      if (arg0 == 6) {
         boolean var3 = false;
      } else {
         this.b = !this.b;
      }

      while(true) {
         while(true) {
            int var4 = arg1.g1();
            if (var4 == 0) {
               if (this.e == 0) {
                  this.e = 1;
                  this.frames = new int[1];
                  this.frames[0] = -1;
                  this.g = new int[1];
                  this.g[0] = -1;
                  this.h = new int[1];
                  this.h[0] = -1;
               }

               if (this.p == -1) {
                  if (this.j != null) {
                     this.p = 2;
                  } else {
                     this.p = 0;
                  }
               }

               if (this.postanim_mode == -1) {
                  if (this.j != null) {
                     this.postanim_mode = 2;
                     return;
                  }

                  this.postanim_mode = 0;
                  return;
               }

               return;
            }

            if (var4 == 1) {
               this.e = arg1.g1();
               this.frames = new int[this.e];
               this.g = new int[this.e];
               this.h = new int[this.e];

               for(int var5 = 0; var5 < this.e; ++var5) {
                  this.frames[var5] = arg1.g2();
                  this.g[var5] = arg1.g2();
                  if (this.g[var5] == 65535) {
                     this.g[var5] = -1;
                  }

                  this.h[var5] = arg1.g2();
               }
            } else if (var4 == 2) {
               this.i = arg1.g2();
            } else if (var4 != 3) {
               if (var4 == 4) {
                  this.k = true;
               } else if (var4 == 5) {
                  this.priority = arg1.g1();
               } else if (var4 == 6) {
                  this.m = arg1.g2();
               } else if (var4 == 7) {
                  this.n = arg1.g2();
               } else if (var4 == 8) {
                  this.o = arg1.g1();
               } else if (var4 == 9) {
                  this.p = arg1.g1();
               } else if (var4 == 10) {
                  this.postanim_mode = arg1.g1();
               } else if (var4 == 11) {
                  this.restart_mode = arg1.g1();
               } else if (var4 == 12) {
                  this.s = arg1.g4();
               } else {
                  System.out.println("Error unrecognised seq config code: " + var4);
               }
            } else {
               int var6 = arg1.g1();
               this.j = new int[var6 + 1];

               for(int var7 = 0; var7 < var6; ++var7) {
                  this.j[var7] = arg1.g1();
               }

               this.j[var6] = 9999999;
            }
         }
      }
   }
}
