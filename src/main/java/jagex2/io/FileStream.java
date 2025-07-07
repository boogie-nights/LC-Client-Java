package jagex2.io;

import deob.ObfuscatedName;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileStream {
   @ObfuscatedName("KNWRHOKF.b")
   public boolean b = false;
   @ObfuscatedName("KNWRHOKF.c")
   public int c = 3;
   @ObfuscatedName("KNWRHOKF.h")
   public int h = 65000;
   @ObfuscatedName("KNWRHOKF.g")
   public int g;
   @ObfuscatedName("KNWRHOKF.e")
   public RandomAccessFile e;
   @ObfuscatedName("KNWRHOKF.f")
   public RandomAccessFile f;
   @ObfuscatedName("KNWRHOKF.d")
   public static byte[] d = new byte[520];
   @ObfuscatedName("KNWRHOKF.a")
   public int a;

   public FileStream(int arg0, int arg1, RandomAccessFile arg2, RandomAccessFile arg3, int arg4) {
      this.g = arg0;
      if (arg4 < 4 || arg4 > 4) {
         this.c = 148;
      }

      this.e = arg2;
      this.f = arg3;
      this.h = arg1;
   }

   @ObfuscatedName("KNWRHOKF.a(BI)[B")
   public synchronized byte[] a(byte arg0, int arg1) {
      if (arg0 == 6) {
         boolean var3 = false;
      } else {
         this.b = !this.b;
      }

      try {
         this.a(true, arg1 * 6, this.f);

         int var5;
         for(int var4 = 0; var4 < 6; var4 += var5) {
            var5 = this.f.read(d, var4, 6 - var4);
            if (var5 == -1) {
               return null;
            }
         }

         int var6 = (d[2] & 255) + ((d[0] & 255) << 16) + ((d[1] & 255) << 8);
         int var7 = (d[5] & 255) + ((d[3] & 255) << 16) + ((d[4] & 255) << 8);
         if (var6 >= 0 && var6 <= this.h) {
            if (var7 > 0 && (long)var7 <= this.e.length() / 520L) {
               byte[] var8 = new byte[var6];
               int var9 = 0;
               int var10 = 0;

               while(var9 < var6) {
                  if (var7 == 0) {
                     return null;
                  }

                  this.a(true, var7 * 520, this.e);
                  int var11 = 0;
                  int var12 = var6 - var9;
                  if (var12 > 512) {
                     var12 = 512;
                  }

                  while(var11 < var12 + 8) {
                     int var13 = this.e.read(d, var11, var12 + 8 - var11);
                     if (var13 == -1) {
                        return null;
                     }

                     var11 += var13;
                  }

                  int var14 = ((d[0] & 255) << 8) + (d[1] & 255);
                  int var15 = ((d[2] & 255) << 8) + (d[3] & 255);
                  int var16 = (d[6] & 255) + ((d[4] & 255) << 16) + ((d[5] & 255) << 8);
                  int var17 = d[7] & 255;
                  if (arg1 == var14 && var10 == var15 && this.g == var17) {
                     if (var16 >= 0 && (long)var16 <= this.e.length() / 520L) {
                        for(int var18 = 0; var18 < var12; ++var18) {
                           var8[var9++] = d[var18 + 8];
                        }

                        var7 = var16;
                        ++var10;
                        continue;
                     }

                     return null;
                  }

                  return null;
               }

               return var8;
            } else {
               return null;
            }
         } else {
            return null;
         }
      } catch (IOException var19) {
         return null;
      }
   }

   @ObfuscatedName("KNWRHOKF.a(IZ[BI)Z")
   public synchronized boolean a(int arg0, boolean arg1, byte[] arg2, int arg3) {
      if (!arg1) {
         for(int var5 = 1; var5 > 0; ++var5) {
         }
      }

      boolean var6 = this.a(arg2, this.a, arg3, true, arg0);
      if (!var6) {
         var6 = this.a(arg2, this.a, arg3, false, arg0);
      }

      return var6;
   }

   @ObfuscatedName("KNWRHOKF.a([BIIZI)Z")
   public synchronized boolean a(byte[] arg0, int arg1, int arg2, boolean arg3, int arg4) {
      if (arg1 != 0) {
         throw new NullPointerException();
      } else {
         try {
            int var8;
            if (!arg3) {
               var8 = (int)((this.e.length() + 519L) / 520L);
               if (var8 == 0) {
                  var8 = 1;
               }
            } else {
               this.a(true, arg2 * 6, this.f);

               int var7;
               for(int var6 = 0; var6 < 6; var6 += var7) {
                  var7 = this.f.read(d, var6, 6 - var6);
                  if (var7 == -1) {
                     return false;
                  }
               }

               var8 = (d[5] & 255) + ((d[3] & 255) << 16) + ((d[4] & 255) << 8);
               if (var8 <= 0 || (long)var8 > this.e.length() / 520L) {
                  return false;
               }
            }

            d[0] = (byte)(arg4 >> 16);
            d[1] = (byte)(arg4 >> 8);
            d[2] = (byte)arg4;
            d[3] = (byte)(var8 >> 16);
            d[4] = (byte)(var8 >> 8);
            d[5] = (byte)var8;
            this.a(true, arg2 * 6, this.f);
            this.f.write(d, 0, 6);
            int var9 = 0;
            int var10 = 0;

            while(var9 < arg4) {
               int var11 = 0;
               if (arg3) {
                  this.a(true, var8 * 520, this.e);

                  int var12;
                  int var13;
                  for(var12 = 0; var12 < 8; var12 += var13) {
                     var13 = this.e.read(d, var12, 8 - var12);
                     if (var13 == -1) {
                        break;
                     }
                  }

                  if (var12 == 8) {
                     label110: {
                        int var14 = ((d[0] & 255) << 8) + (d[1] & 255);
                        int var15 = ((d[2] & 255) << 8) + (d[3] & 255);
                        var11 = (d[6] & 255) + ((d[4] & 255) << 16) + ((d[5] & 255) << 8);
                        int var16 = d[7] & 255;
                        if (arg2 == var14 && var10 == var15 && this.g == var16) {
                           if (var11 >= 0 && (long)var11 <= this.e.length() / 520L) {
                              break label110;
                           }

                           return false;
                        }

                        return false;
                     }
                  }
               }

               if (var11 == 0) {
                  arg3 = false;
                  var11 = (int)((this.e.length() + 519L) / 520L);
                  if (var11 == 0) {
                     ++var11;
                  }

                  if (var8 == var11) {
                     ++var11;
                  }
               }

               if (arg4 - var9 <= 512) {
                  var11 = 0;
               }

               d[0] = (byte)(arg2 >> 8);
               d[1] = (byte)arg2;
               d[2] = (byte)(var10 >> 8);
               d[3] = (byte)var10;
               d[4] = (byte)(var11 >> 16);
               d[5] = (byte)(var11 >> 8);
               d[6] = (byte)var11;
               d[7] = (byte)this.g;
               this.a(true, var8 * 520, this.e);
               this.e.write(d, 0, 8);
               int var17 = arg4 - var9;
               if (var17 > 512) {
                  var17 = 512;
               }

               this.e.write(arg0, var9, var17);
               var9 += var17;
               var8 = var11;
               ++var10;
            }

            return true;
         } catch (IOException var18) {
            return false;
         }
      }
   }

   @ObfuscatedName("KNWRHOKF.a(ZILjava/io/RandomAccessFile;)V")
   public synchronized void a(boolean arg0, int arg1, RandomAccessFile arg2) throws IOException {
      if (arg0) {
         if (arg1 < 0 || arg1 > 62914560) {
            System.out.println("Badseek - pos:" + arg1 + " len:" + arg2.length());
            arg1 = 62914560;

            try {
               Thread.sleep(1000L);
            } catch (Exception var4) {
            }
         }

         arg2.seek((long)arg1);
      }
   }
}
