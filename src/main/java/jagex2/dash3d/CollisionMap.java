package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.datastruct.Linkable;

public class CollisionMap {
   @ObfuscatedName("XRENONSA.a")
   public boolean a = false;
   @ObfuscatedName("XRENONSA.b")
   public int b = -766;
   @ObfuscatedName("XRENONSA.c")
   public boolean c = true;
   @ObfuscatedName("XRENONSA.d")
   public int d = 3;
   @ObfuscatedName("XRENONSA.e")
   public boolean e = true;
   @ObfuscatedName("XRENONSA.f")
   public int f = 0;
   @ObfuscatedName("XRENONSA.g")
   public int g;
   @ObfuscatedName("XRENONSA.h")
   public int h;
   @ObfuscatedName("XRENONSA.i")
   public int i;
   @ObfuscatedName("XRENONSA.j")
   public int[][] j;

   public CollisionMap(int arg0, int arg1, int arg2) {
      if (arg1 != 0) {
         throw new NullPointerException();
      } else {
         this.g = 0;
         this.h = arg2;
         this.i = arg0;
         this.j = new int[this.h][this.i];
         this.a();
         if (Linkable.d) {
         }

      }
   }

   @ObfuscatedName("XRENONSA.a()V")
   public void a() {
      for(int var1 = 0; var1 < this.h; ++var1) {
         for(int var2 = 0; var2 < this.i; ++var2) {
            if (var1 != 0 && var2 != 0 && this.h - 1 != var1 && this.i - 1 != var2) {
               this.j[var1][var2] = 16777216;
            } else {
               this.j[var1][var2] = 16777215;
            }
         }
      }

   }

   @ObfuscatedName("XRENONSA.a(IIZIII)V")
   public void a(int arg0, int arg1, boolean arg2, int arg3, int arg4, int arg5) {
      int var7 = arg4 - this.f;
      if (arg1 == 37679) {
         int var8 = arg5 - this.g;
         if (arg3 == 0) {
            if (arg0 == 0) {
               this.b(var7, var8, 128);
               this.b(var7 - 1, var8, 8);
            }

            if (arg0 == 1) {
               this.b(var7, var8, 2);
               this.b(var7, var8 + 1, 32);
            }

            if (arg0 == 2) {
               this.b(var7, var8, 8);
               this.b(var7 + 1, var8, 128);
            }

            if (arg0 == 3) {
               this.b(var7, var8, 32);
               this.b(var7, var8 - 1, 2);
            }
         }

         if (arg3 == 1 || arg3 == 3) {
            if (arg0 == 0) {
               this.b(var7, var8, 1);
               this.b(var7 - 1, var8 + 1, 16);
            }

            if (arg0 == 1) {
               this.b(var7, var8, 4);
               this.b(var7 + 1, var8 + 1, 64);
            }

            if (arg0 == 2) {
               this.b(var7, var8, 16);
               this.b(var7 + 1, var8 - 1, 1);
            }

            if (arg0 == 3) {
               this.b(var7, var8, 64);
               this.b(var7 - 1, var8 - 1, 4);
            }
         }

         if (arg3 == 2) {
            if (arg0 == 0) {
               this.b(var7, var8, 130);
               this.b(var7 - 1, var8, 8);
               this.b(var7, var8 + 1, 32);
            }

            if (arg0 == 1) {
               this.b(var7, var8, 10);
               this.b(var7, var8 + 1, 32);
               this.b(var7 + 1, var8, 128);
            }

            if (arg0 == 2) {
               this.b(var7, var8, 40);
               this.b(var7 + 1, var8, 128);
               this.b(var7, var8 - 1, 2);
            }

            if (arg0 == 3) {
               this.b(var7, var8, 160);
               this.b(var7, var8 - 1, 2);
               this.b(var7 - 1, var8, 8);
            }
         }

         if (arg2) {
            if (arg3 == 0) {
               if (arg0 == 0) {
                  this.b(var7, var8, 65536);
                  this.b(var7 - 1, var8, 4096);
               }

               if (arg0 == 1) {
                  this.b(var7, var8, 1024);
                  this.b(var7, var8 + 1, 16384);
               }

               if (arg0 == 2) {
                  this.b(var7, var8, 4096);
                  this.b(var7 + 1, var8, 65536);
               }

               if (arg0 == 3) {
                  this.b(var7, var8, 16384);
                  this.b(var7, var8 - 1, 1024);
               }
            }

            if (arg3 == 1 || arg3 == 3) {
               if (arg0 == 0) {
                  this.b(var7, var8, 512);
                  this.b(var7 - 1, var8 + 1, 8192);
               }

               if (arg0 == 1) {
                  this.b(var7, var8, 2048);
                  this.b(var7 + 1, var8 + 1, 32768);
               }

               if (arg0 == 2) {
                  this.b(var7, var8, 8192);
                  this.b(var7 + 1, var8 - 1, 512);
               }

               if (arg0 == 3) {
                  this.b(var7, var8, 32768);
                  this.b(var7 - 1, var8 - 1, 2048);
               }
            }

            if (arg3 == 2) {
               if (arg0 == 0) {
                  this.b(var7, var8, 66560);
                  this.b(var7 - 1, var8, 4096);
                  this.b(var7, var8 + 1, 16384);
               }

               if (arg0 == 1) {
                  this.b(var7, var8, 5120);
                  this.b(var7, var8 + 1, 16384);
                  this.b(var7 + 1, var8, 65536);
               }

               if (arg0 == 2) {
                  this.b(var7, var8, 20480);
                  this.b(var7 + 1, var8, 65536);
                  this.b(var7, var8 - 1, 1024);
               }

               if (arg0 == 3) {
                  this.b(var7, var8, 81920);
                  this.b(var7, var8 - 1, 1024);
                  this.b(var7 - 1, var8, 4096);
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("XRENONSA.a(IIIIZIB)V")
   public void a(int arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5, byte arg6) {
      if (arg6 != 52) {
         this.b = -314;
      }

      int var8 = 256;
      if (arg4) {
         var8 += 131072;
      }

      int var9 = arg5 - this.f;
      int var10 = arg0 - this.g;
      if (arg1 == 1 || arg1 == 3) {
         int var11 = arg3;
         arg3 = arg2;
         arg2 = var11;
      }

      for(int var12 = var9; var12 < arg3 + var9; ++var12) {
         if (var12 >= 0 && var12 < this.h) {
            for(int var13 = var10; var13 < arg2 + var10; ++var13) {
               if (var13 >= 0 && var13 < this.i) {
                  this.b(var12, var13, var8);
               }
            }
         }
      }

   }

   @ObfuscatedName("XRENONSA.a(III)V")
   public void a(int arg0, int arg1, int arg2) {
      int var4 = arg2 - this.f;
      int var5 = arg1 - this.g;
      if (arg0 < 8 || arg0 > 8) {
         this.d = 84;
      }

      this.j[var4][var5] |= 2097152;
   }

   @ObfuscatedName("XRENONSA.b(III)V")
   public void b(int arg0, int arg1, int arg2) {
      this.j[arg0][arg1] |= arg2;
   }

   @ObfuscatedName("XRENONSA.a(IIIIIZ)V")
   public void a(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) {
      if (arg2 != 0) {
         this.c = !this.c;
      }

      int var7 = arg1 - this.f;
      int var8 = arg3 - this.g;
      if (arg4 == 0) {
         if (arg0 == 0) {
            this.a(var7, 128, (byte)17, var8);
            this.a(var7 - 1, 8, (byte)17, var8);
         }

         if (arg0 == 1) {
            this.a(var7, 2, (byte)17, var8);
            this.a(var7, 32, (byte)17, var8 + 1);
         }

         if (arg0 == 2) {
            this.a(var7, 8, (byte)17, var8);
            this.a(var7 + 1, 128, (byte)17, var8);
         }

         if (arg0 == 3) {
            this.a(var7, 32, (byte)17, var8);
            this.a(var7, 2, (byte)17, var8 - 1);
         }
      }

      if (arg4 == 1 || arg4 == 3) {
         if (arg0 == 0) {
            this.a(var7, 1, (byte)17, var8);
            this.a(var7 - 1, 16, (byte)17, var8 + 1);
         }

         if (arg0 == 1) {
            this.a(var7, 4, (byte)17, var8);
            this.a(var7 + 1, 64, (byte)17, var8 + 1);
         }

         if (arg0 == 2) {
            this.a(var7, 16, (byte)17, var8);
            this.a(var7 + 1, 1, (byte)17, var8 - 1);
         }

         if (arg0 == 3) {
            this.a(var7, 64, (byte)17, var8);
            this.a(var7 - 1, 4, (byte)17, var8 - 1);
         }
      }

      if (arg4 == 2) {
         if (arg0 == 0) {
            this.a(var7, 130, (byte)17, var8);
            this.a(var7 - 1, 8, (byte)17, var8);
            this.a(var7, 32, (byte)17, var8 + 1);
         }

         if (arg0 == 1) {
            this.a(var7, 10, (byte)17, var8);
            this.a(var7, 32, (byte)17, var8 + 1);
            this.a(var7 + 1, 128, (byte)17, var8);
         }

         if (arg0 == 2) {
            this.a(var7, 40, (byte)17, var8);
            this.a(var7 + 1, 128, (byte)17, var8);
            this.a(var7, 2, (byte)17, var8 - 1);
         }

         if (arg0 == 3) {
            this.a(var7, 160, (byte)17, var8);
            this.a(var7, 2, (byte)17, var8 - 1);
            this.a(var7 - 1, 8, (byte)17, var8);
         }
      }

      if (arg5) {
         if (arg4 == 0) {
            if (arg0 == 0) {
               this.a(var7, 65536, (byte)17, var8);
               this.a(var7 - 1, 4096, (byte)17, var8);
            }

            if (arg0 == 1) {
               this.a(var7, 1024, (byte)17, var8);
               this.a(var7, 16384, (byte)17, var8 + 1);
            }

            if (arg0 == 2) {
               this.a(var7, 4096, (byte)17, var8);
               this.a(var7 + 1, 65536, (byte)17, var8);
            }

            if (arg0 == 3) {
               this.a(var7, 16384, (byte)17, var8);
               this.a(var7, 1024, (byte)17, var8 - 1);
            }
         }

         if (arg4 == 1 || arg4 == 3) {
            if (arg0 == 0) {
               this.a(var7, 512, (byte)17, var8);
               this.a(var7 - 1, 8192, (byte)17, var8 + 1);
            }

            if (arg0 == 1) {
               this.a(var7, 2048, (byte)17, var8);
               this.a(var7 + 1, 32768, (byte)17, var8 + 1);
            }

            if (arg0 == 2) {
               this.a(var7, 8192, (byte)17, var8);
               this.a(var7 + 1, 512, (byte)17, var8 - 1);
            }

            if (arg0 == 3) {
               this.a(var7, 32768, (byte)17, var8);
               this.a(var7 - 1, 2048, (byte)17, var8 - 1);
            }
         }

         if (arg4 == 2) {
            if (arg0 == 0) {
               this.a(var7, 66560, (byte)17, var8);
               this.a(var7 - 1, 4096, (byte)17, var8);
               this.a(var7, 16384, (byte)17, var8 + 1);
            }

            if (arg0 == 1) {
               this.a(var7, 5120, (byte)17, var8);
               this.a(var7, 16384, (byte)17, var8 + 1);
               this.a(var7 + 1, 65536, (byte)17, var8);
            }

            if (arg0 == 2) {
               this.a(var7, 20480, (byte)17, var8);
               this.a(var7 + 1, 65536, (byte)17, var8);
               this.a(var7, 1024, (byte)17, var8 - 1);
            }

            if (arg0 == 3) {
               this.a(var7, 81920, (byte)17, var8);
               this.a(var7, 1024, (byte)17, var8 - 1);
               this.a(var7 - 1, 4096, (byte)17, var8);
               return;
            }
         }
      }

   }

   @ObfuscatedName("XRENONSA.a(IIIIIZI)V")
   public void a(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5, int arg6) {
      int var8 = 256;
      if (arg5) {
         var8 += 131072;
      }

      int var9 = arg2 - this.f;
      if (arg0 != 2) {
         this.c = !this.c;
      }

      int var10 = arg1 - this.g;
      if (arg3 == 1 || arg3 == 3) {
         int var11 = arg6;
         arg6 = arg4;
         arg4 = var11;
      }

      for(int var12 = var9; var12 < arg6 + var9; ++var12) {
         if (var12 >= 0 && var12 < this.h) {
            for(int var13 = var10; var13 < arg4 + var10; ++var13) {
               if (var13 >= 0 && var13 < this.i) {
                  this.a(var12, var8, (byte)17, var13);
               }
            }
         }
      }

   }

   @ObfuscatedName("XRENONSA.a(IIBI)V")
   public void a(int arg0, int arg1, byte arg2, int arg3) {
      this.j[arg0][arg3] &= 16777215 - arg1;
      if (arg2 == 17) {
         ;
      }
   }

   @ObfuscatedName("XRENONSA.a(IBI)V")
   public void a(int arg0, byte arg1, int arg2) {
      if (arg1 == -122) {
         int var4 = arg0 - this.f;
         int var5 = arg2 - this.g;
         this.j[var4][var5] &= 14680063;
      }
   }

   @ObfuscatedName("XRENONSA.a(IIIIIII)Z")
   public boolean a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
      if (arg0 == arg4 && arg2 == arg5) {
         return true;
      } else {
         int var8 = arg4 - this.f;
         if (arg1 != 0) {
            this.e = !this.e;
         }

         int var9 = arg5 - this.g;
         int var10 = arg0 - this.f;
         int var11 = arg2 - this.g;
         if (arg3 == 0) {
            if (arg6 == 0) {
               if (var10 - 1 == var8 && var9 == var11) {
                  return true;
               }

               if (var8 == var10 && var11 + 1 == var9 && (this.j[var8][var9] & 19398944) == 0) {
                  return true;
               }

               if (var8 == var10 && var11 - 1 == var9 && (this.j[var8][var9] & 19398914) == 0) {
                  return true;
               }
            } else if (arg6 == 1) {
               if (var8 == var10 && var11 + 1 == var9) {
                  return true;
               }

               if (var10 - 1 == var8 && var9 == var11 && (this.j[var8][var9] & 19398920) == 0) {
                  return true;
               }

               if (var10 + 1 == var8 && var9 == var11 && (this.j[var8][var9] & 19399040) == 0) {
                  return true;
               }
            } else if (arg6 == 2) {
               if (var10 + 1 == var8 && var9 == var11) {
                  return true;
               }

               if (var8 == var10 && var11 + 1 == var9 && (this.j[var8][var9] & 19398944) == 0) {
                  return true;
               }

               if (var8 == var10 && var11 - 1 == var9 && (this.j[var8][var9] & 19398914) == 0) {
                  return true;
               }
            } else if (arg6 == 3) {
               if (var8 == var10 && var11 - 1 == var9) {
                  return true;
               }

               if (var10 - 1 == var8 && var9 == var11 && (this.j[var8][var9] & 19398920) == 0) {
                  return true;
               }

               if (var10 + 1 == var8 && var9 == var11 && (this.j[var8][var9] & 19399040) == 0) {
                  return true;
               }
            }
         }

         if (arg3 == 2) {
            if (arg6 == 0) {
               if (var10 - 1 == var8 && var9 == var11) {
                  return true;
               }

               if (var8 == var10 && var11 + 1 == var9) {
                  return true;
               }

               if (var10 + 1 == var8 && var9 == var11 && (this.j[var8][var9] & 19399040) == 0) {
                  return true;
               }

               if (var8 == var10 && var11 - 1 == var9 && (this.j[var8][var9] & 19398914) == 0) {
                  return true;
               }
            } else if (arg6 == 1) {
               if (var10 - 1 == var8 && var9 == var11 && (this.j[var8][var9] & 19398920) == 0) {
                  return true;
               }

               if (var8 == var10 && var11 + 1 == var9) {
                  return true;
               }

               if (var10 + 1 == var8 && var9 == var11) {
                  return true;
               }

               if (var8 == var10 && var11 - 1 == var9 && (this.j[var8][var9] & 19398914) == 0) {
                  return true;
               }
            } else if (arg6 == 2) {
               if (var10 - 1 == var8 && var9 == var11 && (this.j[var8][var9] & 19398920) == 0) {
                  return true;
               }

               if (var8 == var10 && var11 + 1 == var9 && (this.j[var8][var9] & 19398944) == 0) {
                  return true;
               }

               if (var10 + 1 == var8 && var9 == var11) {
                  return true;
               }

               if (var8 == var10 && var11 - 1 == var9) {
                  return true;
               }
            } else if (arg6 == 3) {
               if (var10 - 1 == var8 && var9 == var11) {
                  return true;
               }

               if (var8 == var10 && var11 + 1 == var9 && (this.j[var8][var9] & 19398944) == 0) {
                  return true;
               }

               if (var10 + 1 == var8 && var9 == var11 && (this.j[var8][var9] & 19399040) == 0) {
                  return true;
               }

               if (var8 == var10 && var11 - 1 == var9) {
                  return true;
               }
            }
         }

         if (arg3 == 9) {
            if (var8 == var10 && var11 + 1 == var9 && (this.j[var8][var9] & 32) == 0) {
               return true;
            }

            if (var8 == var10 && var11 - 1 == var9 && (this.j[var8][var9] & 2) == 0) {
               return true;
            }

            if (var10 - 1 == var8 && var9 == var11 && (this.j[var8][var9] & 8) == 0) {
               return true;
            }

            if (var10 + 1 == var8 && var9 == var11 && (this.j[var8][var9] & 128) == 0) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("XRENONSA.b(IIIIIII)Z")
   public boolean b(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
      if (arg2 == arg3 && arg1 == arg6) {
         return true;
      } else {
         int var8 = arg3 - this.f;
         int var9 = arg1 - this.g;
         int var10 = arg2 - this.f;
         if (arg0 >= 0) {
            throw new NullPointerException();
         } else {
            int var11 = arg6 - this.g;
            if (arg5 == 6 || arg5 == 7) {
               if (arg5 == 7) {
                  arg4 = arg4 + 2 & 3;
               }

               if (arg4 == 0) {
                  if (var10 + 1 == var8 && var9 == var11 && (this.j[var8][var9] & 128) == 0) {
                     return true;
                  }

                  if (var8 == var10 && var11 - 1 == var9 && (this.j[var8][var9] & 2) == 0) {
                     return true;
                  }
               } else if (arg4 == 1) {
                  if (var10 - 1 == var8 && var9 == var11 && (this.j[var8][var9] & 8) == 0) {
                     return true;
                  }

                  if (var8 == var10 && var11 - 1 == var9 && (this.j[var8][var9] & 2) == 0) {
                     return true;
                  }
               } else if (arg4 == 2) {
                  if (var10 - 1 == var8 && var9 == var11 && (this.j[var8][var9] & 8) == 0) {
                     return true;
                  }

                  if (var8 == var10 && var11 + 1 == var9 && (this.j[var8][var9] & 32) == 0) {
                     return true;
                  }
               } else if (arg4 == 3) {
                  if (var10 + 1 == var8 && var9 == var11 && (this.j[var8][var9] & 128) == 0) {
                     return true;
                  }

                  if (var8 == var10 && var11 + 1 == var9 && (this.j[var8][var9] & 32) == 0) {
                     return true;
                  }
               }
            }

            if (arg5 == 8) {
               if (var8 == var10 && var11 + 1 == var9 && (this.j[var8][var9] & 32) == 0) {
                  return true;
               }

               if (var8 == var10 && var11 - 1 == var9 && (this.j[var8][var9] & 2) == 0) {
                  return true;
               }

               if (var10 - 1 == var8 && var9 == var11 && (this.j[var8][var9] & 8) == 0) {
                  return true;
               }

               if (var10 + 1 == var8 && var9 == var11 && (this.j[var8][var9] & 128) == 0) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   @ObfuscatedName("XRENONSA.a(IIZIIIII)Z")
   public boolean a(int arg0, int arg1, boolean arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
      int var9 = arg0 + arg3 - 1;
      int var10 = arg5 + arg6 - 1;
      if (!arg2) {
         this.b = 238;
      }

      if (arg1 >= arg3 && arg1 <= var9 && arg7 >= arg6 && arg7 <= var10) {
         return true;
      } else if (arg3 - 1 == arg1 && arg7 >= arg6 && arg7 <= var10 && (this.j[arg1 - this.f][arg7 - this.g] & 8) == 0 && (arg4 & 8) == 0) {
         return true;
      } else if (var9 + 1 == arg1 && arg7 >= arg6 && arg7 <= var10 && (this.j[arg1 - this.f][arg7 - this.g] & 128) == 0 && (arg4 & 2) == 0) {
         return true;
      } else if (arg6 - 1 == arg7 && arg1 >= arg3 && arg1 <= var9 && (this.j[arg1 - this.f][arg7 - this.g] & 2) == 0 && (arg4 & 4) == 0) {
         return true;
      } else {
         return var10 + 1 == arg7 && arg1 >= arg3 && arg1 <= var9 && (this.j[arg1 - this.f][arg7 - this.g] & 32) == 0 && (arg4 & 1) == 0;
      }
   }
}
