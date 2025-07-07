package jagex2.wordenc;

import deob.ObfuscatedName;
import jagex2.datastruct.Linkable;
import jagex2.io.Jagfile;
import jagex2.io.Packet;

public class WordFilter {
   @ObfuscatedName("WXKKTWFB.a")
   public static int a = 3;
   @ObfuscatedName("WXKKTWFB.c")
   public static int c = -761;
   @ObfuscatedName("WXKKTWFB.f")
   public static int f = -48545;
   @ObfuscatedName("WXKKTWFB.h")
   public static byte h = -113;
   @ObfuscatedName("WXKKTWFB.i")
   public static int i = 3;
   @ObfuscatedName("WXKKTWFB.j")
   public static int j = -939;
   @ObfuscatedName("WXKKTWFB.l")
   public static boolean l = true;
   @ObfuscatedName("WXKKTWFB.s")
   public static final String[] s = new String[]{"cook", "cook's", "cooks", "seeks", "sheet", "woop", "woops", "faq", "noob", "noobs"};
   @ObfuscatedName("WXKKTWFB.b")
   public static int b;
   @ObfuscatedName("WXKKTWFB.g")
   public static int g;
   @ObfuscatedName("WXKKTWFB.d")
   public static boolean d;
   @ObfuscatedName("WXKKTWFB.e")
   public static boolean e;
   @ObfuscatedName("WXKKTWFB.k")
   public static boolean k;
   @ObfuscatedName("WXKKTWFB.t")
   public static boolean t;
   @ObfuscatedName("WXKKTWFB.m")
   public static int[] m;
   @ObfuscatedName("WXKKTWFB.r")
   public static int[] r;
   @ObfuscatedName("WXKKTWFB.n")
   public static char[][] n;
   @ObfuscatedName("WXKKTWFB.p")
   public static char[][] p;
   @ObfuscatedName("WXKKTWFB.q")
   public static char[][] q;
   @ObfuscatedName("WXKKTWFB.o")
   public static byte[][][] o;

   @ObfuscatedName("WXKKTWFB.a(LATJMVOZR;)V")
   public static final void a(Jagfile arg0) {
      Packet var1 = new Packet(arg0.a("fragmentsenc.txt", (byte[])null));
      Packet var2 = new Packet(arg0.a("badenc.txt", (byte[])null));
      Packet var3 = new Packet(arg0.a("domainenc.txt", (byte[])null));
      Packet var4 = new Packet(arg0.a("tldlist.txt", (byte[])null));
      a(var1, var2, var3, var4);
      if (Linkable.d) {
      }

   }

   @ObfuscatedName("WXKKTWFB.a(LMFMVIYHT;LMFMVIYHT;LMFMVIYHT;LMFMVIYHT;)V")
   public static final void a(Packet arg0, Packet arg1, Packet arg2, Packet arg3) {
      a(true, arg1);
      a((int)20529, (Packet)arg2);
      b((Packet)arg0, (int)21901);
      a((Packet)arg3, (int)-7305);
   }

   @ObfuscatedName("WXKKTWFB.a(LMFMVIYHT;I)V")
   public static final void a(Packet arg0, int arg1) {
      int var2 = arg0.g4();
      q = new char[var2][];
      r = new int[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         r[var3] = arg0.g1();
         char[] var4 = new char[arg0.g1()];

         for(int var5 = 0; var5 < var4.length; ++var5) {
            var4[var5] = (char)arg0.g1();
         }

         q[var3] = var4;
      }

      if (arg1 != -7305) {
         e = !e;
      }
   }

   @ObfuscatedName("WXKKTWFB.a(ZLMFMVIYHT;)V")
   public static final void a(boolean arg0, Packet arg1) {
      if (arg0) {
         int var2 = arg1.g4();
         n = new char[var2][];
         o = new byte[var2][][];
         a(34541, arg1, n, o);
      }
   }

   @ObfuscatedName("WXKKTWFB.a(ILMFMVIYHT;)V")
   public static final void a(int arg0, Packet arg1) {
      int var2 = arg1.g4();
      p = new char[var2][];
      a(arg1, p, -37125);
      if (arg0 != 20529) {
         b = 311;
      }
   }

   @ObfuscatedName("WXKKTWFB.b(LMFMVIYHT;I)V")
   public static final void b(Packet arg0, int arg1) {
      if (arg1 == 21901) {
         m = new int[arg0.g4()];

         for(int var2 = 0; var2 < m.length; ++var2) {
            m[var2] = arg0.e();
         }

      }
   }

   @ObfuscatedName("WXKKTWFB.a(ILMFMVIYHT;[[C[[[B)V")
   public static final void a(int arg0, Packet arg1, char[][] arg2, byte[][][] arg3) {
      for(int var4 = 0; var4 < arg2.length; ++var4) {
         char[] var5 = new char[arg1.g1()];

         for(int var6 = 0; var6 < var5.length; ++var6) {
            var5[var6] = (char)arg1.g1();
         }

         arg2[var4] = var5;
         byte[][] var7 = new byte[arg1.g1()][2];

         for(int var8 = 0; var8 < var7.length; ++var8) {
            var7[var8][0] = (byte)arg1.g1();
            var7[var8][1] = (byte)arg1.g1();
         }

         if (var7.length > 0) {
            arg3[var4] = var7;
         }
      }

      if (arg0 == 34541) {
         ;
      }
   }

   @ObfuscatedName("WXKKTWFB.a(LMFMVIYHT;[[CI)V")
   public static final void a(Packet arg0, char[][] arg1, int arg2) {
      if (arg2 != -37125) {
         a = 218;
      }

      for(int var3 = 0; var3 < arg1.length; ++var3) {
         char[] var4 = new char[arg0.g1()];

         for(int var5 = 0; var5 < var4.length; ++var5) {
            var4[var5] = (char)arg0.g1();
         }

         arg1[var3] = var4;
      }

   }

   @ObfuscatedName("WXKKTWFB.a([CB)V")
   public static final void a(char[] arg0, byte arg1) {
      int var2 = 0;

      for(int var3 = 0; var3 < arg0.length; ++var3) {
         if (a((char)arg0[var3], (int)0)) {
            arg0[var2] = arg0[var3];
         } else {
            arg0[var2] = ' ';
         }

         if (var2 == 0 || arg0[var2] != ' ' || arg0[var2 - 1] != ' ') {
            ++var2;
         }
      }

      for(int var4 = var2; var4 < arg0.length; ++var4) {
         arg0[var4] = ' ';
      }

      if (arg1 == 6) {
         ;
      }
   }

   @ObfuscatedName("WXKKTWFB.a(CI)Z")
   public static final boolean a(char arg0, int arg1) {
      if (arg1 != 0) {
         throw new NullPointerException();
      } else {
         return arg0 >= ' ' && arg0 <= 127 || arg0 == ' ' || arg0 == '\n' || arg0 == '\t' || arg0 == 163 || arg0 == 8364;
      }
   }

   @ObfuscatedName("WXKKTWFB.a(BLjava/lang/String;)Ljava/lang/String;")
   public static final String a(byte arg0, String arg1) {
      long var2 = System.currentTimeMillis();
      char[] var4 = arg1.toCharArray();
      a((char[])var4, (byte)6);
      String var5 = (new String(var4)).trim();
      char[] var6 = var5.toLowerCase().toCharArray();
      String var7 = var5.toLowerCase();
      b((char[])var6, (int)0);
      a(var6, f);
      b(3, var6);
      if (arg0 != 0) {
         throw new NullPointerException();
      } else {
         c(3, var6);

         for(int var8 = 0; var8 < s.length; ++var8) {
            int var9 = -1;

            while((var9 = var7.indexOf(s[var8], var9 + 1)) != -1) {
               char[] var10 = s[var8].toCharArray();

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  var6[var9 + var11] = var10[var11];
               }
            }
         }

         a(0, var6, var5.toCharArray());
         a((int)1, (char[])var6);
         long var12 = System.currentTimeMillis();
         return (new String(var6)).trim();
      }
   }

   @ObfuscatedName("WXKKTWFB.a(I[C[C)V")
   public static final void a(int arg0, char[] arg1, char[] arg2) {
      for(int var3 = 0; var3 < arg2.length; ++var3) {
         if (arg1[var3] != '*' && b(-217, arg2[var3])) {
            arg1[var3] = arg2[var3];
         }
      }

      if (arg0 != 0) {
         a = 271;
      }
   }

   @ObfuscatedName("WXKKTWFB.a(I[C)V")
   public static final void a(int arg0, char[] arg1) {
      boolean var2 = true;

      for(int var3 = 0; var3 < arg1.length; ++var3) {
         char var4 = arg1[var3];
         if (a(true, var4)) {
            if (var2) {
               if (c(var4, k)) {
                  var2 = false;
               }
            } else if (b(-217, var4)) {
               arg1[var3] = (char)(var4 + 'a' - 65);
            }
         } else {
            var2 = true;
         }
      }

      if (arg0 == 1) {
         ;
      }
   }

   @ObfuscatedName("WXKKTWFB.a([CI)V")
   public static final void a(char[] arg0, int arg1) {
      for(int var2 = 0; var2 < 2; ++var2) {
         for(int var3 = n.length - 1; var3 >= 0; --var3) {
            a(o[var3], -939, n[var3], arg0);
         }
      }

      if (arg1 != -48545) {
         d = !d;
      }
   }

   @ObfuscatedName("WXKKTWFB.b(I[C)V")
   public static final void b(int arg0, char[] arg1) {
      char[] var2 = (char[])arg1.clone();
      char[] var3 = new char[]{'(', 'a', ')'};
      a((byte[][])null, -939, var3, var2);
      if (arg0 < 3 || arg0 > 3) {
         a = 382;
      }

      char[] var4 = (char[])arg1.clone();
      char[] var5 = new char[]{'d', 'o', 't'};
      a((byte[][])null, -939, var5, var4);

      for(int var6 = p.length - 1; var6 >= 0; --var6) {
         a(arg1, var4, var2, -65, p[var6]);
      }

   }

   @ObfuscatedName("WXKKTWFB.a([C[C[CI[C)V")
   public static final void a(char[] arg0, char[] arg1, char[] arg2, int arg3, char[] arg4) {
      if (arg3 < 0) {
         if (arg4.length <= arg0.length) {
            boolean var5 = true;

            int var9;
            for(int var6 = 0; var6 <= arg0.length - arg4.length; var6 += var9) {
               int var7 = var6;
               int var8 = 0;
               var9 = 1;

               label59:
               while(true) {
                  while(true) {
                     if (var7 >= arg0.length) {
                        break label59;
                     }

                     boolean var10 = false;
                     char var11 = arg0[var7];
                     char var12 = 0;
                     if (var7 + 1 < arg0.length) {
                        var12 = arg0[var7 + 1];
                     }

                     int var13;
                     if (var8 < arg4.length && (var13 = a(var11, (int)0, arg4[var8], (char)var12)) > 0) {
                        var7 += var13;
                        ++var8;
                     } else {
                        if (var8 == 0) {
                           break label59;
                        }

                        int var14;
                        if ((var14 = a(var11, (int)0, arg4[var8 - 1], (char)var12)) > 0) {
                           var7 += var14;
                           if (var8 == 1) {
                              ++var9;
                           }
                        } else {
                           if (var8 >= arg4.length || !a(var11, false)) {
                              break label59;
                           }

                           ++var7;
                        }
                     }
                  }
               }

               if (var8 >= arg4.length) {
                  boolean var15 = false;
                  int var16 = a(arg0, arg2, (byte)-72, var6);
                  int var17 = a(arg1, 0, var7 - 1, arg0);
                  if (var16 > 2 || var17 > 2) {
                     var15 = true;
                  }

                  if (var15) {
                     for(int var18 = var6; var18 < var7; ++var18) {
                        arg0[var18] = '*';
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("WXKKTWFB.a([C[CBI)I")
   public static final int a(char[] arg0, char[] arg1, byte arg2, int arg3) {
      if (arg3 == 0) {
         return 2;
      } else {
         for(int var4 = arg3 - 1; var4 >= 0 && a(arg0[var4], false); --var4) {
            if (arg0[var4] == '@') {
               return 3;
            }
         }

         int var5 = 0;

         for(int var6 = arg3 - 1; var6 >= 0 && a(arg1[var6], false); --var6) {
            if (arg1[var6] == '*') {
               ++var5;
            }
         }

         if (arg2 != -72) {
            return 3;
         } else if (var5 >= 3) {
            return 4;
         } else {
            return a(arg0[arg3 - 1], false) ? 1 : 0;
         }
      }
   }

   @ObfuscatedName("WXKKTWFB.a([CII[C)I")
   public static final int a(char[] arg0, int arg1, int arg2, char[] arg3) {
      if (arg2 + 1 == arg3.length) {
         return 2;
      } else {
         int var4 = arg2 + 1;

         while(true) {
            if (var4 < arg3.length && a(arg3[var4], false)) {
               if (arg3[var4] != '.' && arg3[var4] != ',') {
                  ++var4;
                  continue;
               }

               return 3;
            }

            int var5 = 0;
            if (arg1 != 0) {
               return f;
            }

            for(int var6 = arg2 + 1; var6 < arg3.length && a(arg0[var6], false); ++var6) {
               if (arg0[var6] == '*') {
                  ++var5;
               }
            }

            if (var5 >= 3) {
               return 4;
            }

            if (a(arg3[arg2 + 1], false)) {
               return 1;
            }

            return 0;
         }
      }
   }

   @ObfuscatedName("WXKKTWFB.b([CI)V")
   public static final void b(char[] arg0, int arg1) {
      char[] var2 = (char[])arg0.clone();
      char[] var3 = new char[]{'d', 'o', 't'};
      a((byte[][])null, -939, var3, var2);
      char[] var4 = (char[])arg0.clone();
      char[] var5 = new char[]{'s', 'l', 'a', 's', 'h'};
      if (arg1 != 0) {
         e = !e;
      }

      a((byte[][])null, -939, var5, var4);

      for(int var6 = 0; var6 < q.length; ++var6) {
         a(arg0, (byte)7, var2, r[var6], q[var6], var4);
      }

   }

   @ObfuscatedName("WXKKTWFB.a([CB[CI[C[C)V")
   public static final void a(char[] arg0, byte arg1, char[] arg2, int arg3, char[] arg4, char[] arg5) {
      if (arg4.length <= arg0.length) {
         boolean var6 = true;

         int var10;
         for(int var7 = 0; var7 <= arg0.length - arg4.length; var7 += var10) {
            int var8 = var7;
            int var9 = 0;
            var10 = 1;

            label121:
            while(true) {
               while(true) {
                  if (var8 >= arg0.length) {
                     break label121;
                  }

                  boolean var11 = false;
                  char var12 = arg0[var8];
                  char var13 = 0;
                  if (var8 + 1 < arg0.length) {
                     var13 = arg0[var8 + 1];
                  }

                  int var14;
                  if (var9 < arg4.length && (var14 = a(var12, (int)0, arg4[var9], (char)var13)) > 0) {
                     var8 += var14;
                     ++var9;
                  } else {
                     if (var9 == 0) {
                        break label121;
                     }

                     int var15;
                     if ((var15 = a(var12, (int)0, arg4[var9 - 1], (char)var13)) > 0) {
                        var8 += var15;
                        if (var9 == 1) {
                           ++var10;
                        }
                     } else {
                        if (var9 >= arg4.length || !a(var12, false)) {
                           break label121;
                        }

                        ++var8;
                     }
                  }
               }
            }

            if (var9 >= arg4.length) {
               boolean var16 = false;
               int var17 = a(arg2, var7, arg0, (byte)-113);
               int var18 = a(arg5, var8 - 1, arg0, (int)3);
               if (arg3 == 1 && var17 > 0 && var18 > 0) {
                  var16 = true;
               }

               if (arg3 == 2 && (var17 > 2 && var18 > 0 || var17 > 0 && var18 > 2)) {
                  var16 = true;
               }

               if (arg3 == 3 && var17 > 0 && var18 > 2) {
                  var16 = true;
               }

               boolean var10000;
               if (arg3 == 3 && var17 > 2 && var18 > 0) {
                  var10000 = true;
               } else {
                  var10000 = false;
               }

               if (var16) {
                  int var19 = var7;
                  int var20 = var8 - 1;
                  if (var17 > 2) {
                     if (var17 == 4) {
                        boolean var21 = false;

                        for(int var22 = var7 - 1; var22 >= 0; --var22) {
                           if (var21) {
                              if (arg2[var22] != '*') {
                                 break;
                              }

                              var19 = var22;
                           } else if (arg2[var22] == '*') {
                              var19 = var22;
                              var21 = true;
                           }
                        }
                     }

                     boolean var23 = false;

                     for(int var24 = var19 - 1; var24 >= 0; --var24) {
                        if (var23) {
                           if (a(arg0[var24], false)) {
                              break;
                           }

                           var19 = var24;
                        } else if (!a(arg0[var24], false)) {
                           var23 = true;
                           var19 = var24;
                        }
                     }
                  }

                  if (var18 > 2) {
                     if (var18 == 4) {
                        boolean var25 = false;

                        for(int var26 = var20 + 1; var26 < arg0.length; ++var26) {
                           if (var25) {
                              if (arg5[var26] != '*') {
                                 break;
                              }

                              var20 = var26;
                           } else if (arg5[var26] == '*') {
                              var20 = var26;
                              var25 = true;
                           }
                        }
                     }

                     boolean var27 = false;

                     for(int var28 = var20 + 1; var28 < arg0.length; ++var28) {
                        if (var27) {
                           if (a(arg0[var28], false)) {
                              break;
                           }

                           var20 = var28;
                        } else if (!a(arg0[var28], false)) {
                           var27 = true;
                           var20 = var28;
                        }
                     }
                  }

                  for(int var29 = var19; var29 <= var20; ++var29) {
                     arg0[var29] = '*';
                  }
               }
            }
         }

         if (arg1 == 7) {
            boolean var30 = false;
         }
      }
   }

   @ObfuscatedName("WXKKTWFB.a([CI[CB)I")
   public static final int a(char[] arg0, int arg1, char[] arg2, byte arg3) {
      if (h != arg3) {
         for(int var4 = 1; var4 > 0; ++var4) {
         }
      }

      if (arg1 == 0) {
         return 2;
      } else {
         int var5 = arg1 - 1;

         while(true) {
            if (var5 >= 0 && a(arg2[var5], false)) {
               if (arg2[var5] != ',' && arg2[var5] != '.') {
                  --var5;
                  continue;
               }

               return 3;
            }

            int var6 = 0;

            for(int var7 = arg1 - 1; var7 >= 0 && a(arg0[var7], false); --var7) {
               if (arg0[var7] == '*') {
                  ++var6;
               }
            }

            if (var6 >= 3) {
               return 4;
            }

            if (a(arg2[arg1 - 1], false)) {
               return 1;
            }

            return 0;
         }
      }
   }

   @ObfuscatedName("WXKKTWFB.a([CI[CI)I")
   public static final int a(char[] arg0, int arg1, char[] arg2, int arg3) {
      if (arg3 < i || arg3 > i) {
         for(int var4 = 1; var4 > 0; ++var4) {
         }
      }

      if (arg1 + 1 == arg2.length) {
         return 2;
      } else {
         int var5 = arg1 + 1;

         while(true) {
            if (var5 < arg2.length && a(arg2[var5], false)) {
               if (arg2[var5] != '\\' && arg2[var5] != '/') {
                  ++var5;
                  continue;
               }

               return 3;
            }

            int var6 = 0;

            for(int var7 = arg1 + 1; var7 < arg2.length && a(arg0[var7], false); ++var7) {
               if (arg0[var7] == '*') {
                  ++var6;
               }
            }

            if (var6 >= 5) {
               return 4;
            }

            if (a(arg2[arg1 + 1], false)) {
               return 1;
            }

            return 0;
         }
      }
   }

   @ObfuscatedName("WXKKTWFB.a([[BI[C[C)V")
   public static final void a(byte[][] arg0, int arg1, char[] arg2, char[] arg3) {
      if (arg1 < 0) {
         if (arg2.length <= arg3.length) {
            boolean var4 = true;

            int var9;
            for(int var5 = 0; var5 <= arg3.length - arg2.length; var5 += var9) {
               int var6 = var5;
               int var7 = 0;
               int var8 = 0;
               var9 = 1;
               boolean var10 = false;
               boolean var11 = false;
               boolean var12 = false;

               label167:
               while(true) {
                  while(true) {
                     if (var6 >= arg3.length || var11 && var12) {
                        break label167;
                     }

                     boolean var13 = false;
                     char var14 = arg3[var6];
                     char var15 = 0;
                     if (var6 + 1 < arg3.length) {
                        var15 = arg3[var6 + 1];
                     }

                     int var16;
                     if (var7 < arg2.length && (var16 = a(arg2[var7], (char)var14, var15, (int)7)) > 0) {
                        if (var16 == 1 && b(var14, false)) {
                           var11 = true;
                        }

                        if (var16 == 2 && (b(var14, false) || b(var15, false))) {
                           var11 = true;
                        }

                        var6 += var16;
                        ++var7;
                     } else {
                        if (var7 == 0) {
                           break label167;
                        }

                        int var17;
                        if ((var17 = a(arg2[var7 - 1], (char)var14, var15, (int)7)) > 0) {
                           var6 += var17;
                           if (var7 == 1) {
                              ++var9;
                           }
                        } else {
                           if (var7 >= arg2.length || !a((int)2, (char)var14)) {
                              break label167;
                           }

                           if (a(var14, false) && var14 != '\'') {
                              var10 = true;
                           }

                           if (b(var14, false)) {
                              var12 = true;
                           }

                           ++var6;
                           ++var8;
                           if (var8 * 100 / (var6 - var5) > 90) {
                              break label167;
                           }
                        }
                     }
                  }
               }

               if (var7 >= arg2.length && (!var11 || !var12)) {
                  boolean var18 = true;
                  if (!var10) {
                     char var19 = ' ';
                     if (var5 - 1 >= 0) {
                        var19 = arg3[var5 - 1];
                     }

                     char var20 = ' ';
                     if (var6 < arg3.length) {
                        var20 = arg3[var6];
                     }

                     byte var21 = a((char)var19, (byte)7);
                     byte var22 = a((char)var20, (byte)7);
                     if (arg0 != null && a(var22, arg0, var21, 4)) {
                        var18 = false;
                     }
                  } else {
                     boolean var23 = false;
                     boolean var24 = false;
                     if (var5 - 1 < 0 || a(arg3[var5 - 1], false) && arg3[var5 - 1] != '\'') {
                        var23 = true;
                     }

                     if (var6 >= arg3.length || a(arg3[var6], false) && arg3[var6] != '\'') {
                        var24 = true;
                     }

                     if (!var23 || !var24) {
                        boolean var25 = false;
                        int var26 = var5 - 2;
                        if (var23) {
                           var26 = var5;
                        }

                        while(!var25 && var26 < var6) {
                           if (var26 >= 0 && (!a(arg3[var26], false) || arg3[var26] == '\'')) {
                              char[] var27 = new char[3];

                              int var28;
                              for(var28 = 0; var28 < 3 && var26 + var28 < arg3.length && (!a(arg3[var26 + var28], false) || arg3[var26 + var28] == '\''); ++var28) {
                                 var27[var28] = arg3[var26 + var28];
                              }

                              boolean var29 = true;
                              if (var28 == 0) {
                                 var29 = false;
                              }

                              if (var28 < 3 && var26 - 1 >= 0 && (!a(arg3[var26 - 1], false) || arg3[var26 - 1] == '\'')) {
                                 var29 = false;
                              }

                              if (var29 && !c(var27, 463)) {
                                 var25 = true;
                              }
                           }

                           ++var26;
                        }

                        if (!var25) {
                           var18 = false;
                        }
                     }
                  }

                  if (var18) {
                     int var30 = 0;
                     int var31 = 0;
                     int var32 = -1;

                     for(int var33 = var5; var33 < var6; ++var33) {
                        if (b(arg3[var33], false)) {
                           ++var30;
                        } else if (a(true, arg3[var33])) {
                           ++var31;
                           var32 = var33;
                        }
                     }

                     if (var32 > -1) {
                        var30 -= var6 - 1 - var32;
                     }

                     if (var30 <= var31) {
                        for(int var34 = var5; var34 < var6; ++var34) {
                           arg3[var34] = '*';
                        }
                     } else {
                        var9 = 1;
                     }
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("WXKKTWFB.a(B[[BBI)Z")
   public static final boolean a(byte arg0, byte[][] arg1, byte arg2, int arg3) {
      int var4 = 0;
      if (arg3 >= 4 && arg3 <= 4) {
         if (arg1[var4][0] == arg2 && arg1[var4][1] == arg0) {
            return true;
         } else {
            int var5 = arg1.length - 1;
            if (arg1[var5][0] == arg2 && arg1[var5][1] == arg0) {
               return true;
            } else {
               do {
                  int var6 = (var4 + var5) / 2;
                  if (arg1[var6][0] == arg2 && arg1[var6][1] == arg0) {
                     return true;
                  }

                  if (arg2 >= arg1[var6][0] && (arg1[var6][0] != arg2 || arg0 >= arg1[var6][1])) {
                     var4 = var6;
                  } else {
                     var5 = var6;
                  }
               } while(var4 != var5 && var4 + 1 != var5);

               return false;
            }
         }
      } else {
         throw new NullPointerException();
      }
   }

   @ObfuscatedName("WXKKTWFB.a(CICC)I")
   public static final int a(char arg0, int arg1, char arg2, char arg3) {
      if (arg1 != 0) {
         return f;
      } else if (arg0 == arg2) {
         return 1;
      } else if (arg2 == 'o' && arg0 == '0') {
         return 1;
      } else if (arg2 == 'o' && arg0 == '(' && arg3 == ')') {
         return 2;
      } else if (arg2 != 'c' || arg0 != '(' && arg0 != '<' && arg0 != '[') {
         if (arg2 == 'e' && arg0 == 8364) {
            return 1;
         } else if (arg2 == 's' && arg0 == '$') {
            return 1;
         } else {
            return arg2 == 'l' && arg0 == 'i' ? 1 : 0;
         }
      } else {
         return 1;
      }
   }

   @ObfuscatedName("WXKKTWFB.a(CCCI)I")
   public static final int a(char arg0, char arg1, char arg2, int arg3) {
      if (arg3 != 7) {
         return a;
      } else if (arg0 == arg1) {
         return 1;
      } else {
         if (arg0 >= 'a' && arg0 <= 'm') {
            if (arg0 == 'a') {
               if (arg1 != '4' && arg1 != '@' && arg1 != '^') {
                  if (arg1 == '/' && arg2 == '\\') {
                     return 2;
                  }

                  return 0;
               }

               return 1;
            }

            if (arg0 == 'b') {
               if (arg1 != '6' && arg1 != '8') {
                  if ((arg1 != '1' || arg2 != '3') && (arg1 != 'i' || arg2 != '3')) {
                     return 0;
                  }

                  return 2;
               }

               return 1;
            }

            if (arg0 == 'c') {
               if (arg1 != '(' && arg1 != '<' && arg1 != '{' && arg1 != '[') {
                  return 0;
               }

               return 1;
            }

            if (arg0 == 'd') {
               if ((arg1 != '[' || arg2 != ')') && (arg1 != 'i' || arg2 != ')')) {
                  return 0;
               }

               return 2;
            }

            if (arg0 == 'e') {
               if (arg1 != '3' && arg1 != 8364) {
                  return 0;
               }

               return 1;
            }

            if (arg0 == 'f') {
               if (arg1 == 'p' && arg2 == 'h') {
                  return 2;
               }

               if (arg1 == 163) {
                  return 1;
               }

               return 0;
            }

            if (arg0 == 'g') {
               if (arg1 != '9' && arg1 != '6' && arg1 != 'q') {
                  return 0;
               }

               return 1;
            }

            if (arg0 == 'h') {
               if (arg1 == '#') {
                  return 1;
               }

               return 0;
            }

            if (arg0 == 'i') {
               if (arg1 != 'y' && arg1 != 'l' && arg1 != 'j' && arg1 != '1' && arg1 != '!' && arg1 != ':' && arg1 != ';' && arg1 != '|') {
                  return 0;
               }

               return 1;
            }

            if (arg0 == 'j') {
               return 0;
            }

            if (arg0 == 'k') {
               return 0;
            }

            if (arg0 == 'l') {
               if (arg1 != '1' && arg1 != '|' && arg1 != 'i') {
                  return 0;
               }

               return 1;
            }

            if (arg0 == 'm') {
               return 0;
            }
         }

         if (arg0 >= 'n' && arg0 <= 'z') {
            if (arg0 == 'n') {
               return 0;
            }

            if (arg0 == 'o') {
               if (arg1 != '0' && arg1 != '*') {
                  if ((arg1 != '(' || arg2 != ')') && (arg1 != '[' || arg2 != ']') && (arg1 != '{' || arg2 != '}') && (arg1 != '<' || arg2 != '>')) {
                     return 0;
                  }

                  return 2;
               }

               return 1;
            }

            if (arg0 == 'p') {
               return 0;
            }

            if (arg0 == 'q') {
               return 0;
            }

            if (arg0 == 'r') {
               return 0;
            }

            if (arg0 == 's') {
               if (arg1 != '5' && arg1 != 'z' && arg1 != '$' && arg1 != '2') {
                  return 0;
               }

               return 1;
            }

            if (arg0 == 't') {
               if (arg1 != '7' && arg1 != '+') {
                  return 0;
               }

               return 1;
            }

            if (arg0 == 'u') {
               if (arg1 == 'v') {
                  return 1;
               }

               if ((arg1 != '\\' || arg2 != '/') && (arg1 != '\\' || arg2 != '|') && (arg1 != '|' || arg2 != '/')) {
                  return 0;
               }

               return 2;
            }

            if (arg0 == 'v') {
               if ((arg1 != '\\' || arg2 != '/') && (arg1 != '\\' || arg2 != '|') && (arg1 != '|' || arg2 != '/')) {
                  return 0;
               }

               return 2;
            }

            if (arg0 == 'w') {
               if (arg1 == 'v' && arg2 == 'v') {
                  return 2;
               }

               return 0;
            }

            if (arg0 == 'x') {
               if ((arg1 != ')' || arg2 != '(') && (arg1 != '}' || arg2 != '{') && (arg1 != ']' || arg2 != '[') && (arg1 != '>' || arg2 != '<')) {
                  return 0;
               }

               return 2;
            }

            if (arg0 == 'y') {
               return 0;
            }

            if (arg0 == 'z') {
               return 0;
            }
         }

         if (arg0 >= '0' && arg0 <= '9') {
            if (arg0 != '0') {
               if (arg0 == '1') {
                  return arg1 == 'l' ? 1 : 0;
               } else {
                  return 0;
               }
            } else if (arg1 != 'o' && arg1 != 'O') {
               return (arg1 != '(' || arg2 != ')') && (arg1 != '{' || arg2 != '}') && (arg1 != '[' || arg2 != ']') ? 0 : 2;
            } else {
               return 1;
            }
         } else if (arg0 == ',') {
            return arg1 == '.' ? 1 : 0;
         } else if (arg0 == '.') {
            return arg1 == ',' ? 1 : 0;
         } else if (arg0 == '!') {
            return arg1 == 'i' ? 1 : 0;
         } else {
            return 0;
         }
      }
   }

   @ObfuscatedName("WXKKTWFB.a(CB)B")
   public static final byte a(char arg0, byte arg1) {
      if (arg1 != 7) {
         throw new NullPointerException();
      } else if (arg0 >= 'a' && arg0 <= 'z') {
         return (byte)(arg0 - 'a' + 1);
      } else if (arg0 == '\'') {
         return 28;
      } else {
         return arg0 >= '0' && arg0 <= '9' ? (byte)(arg0 - '0' + 29) : 27;
      }
   }

   @ObfuscatedName("WXKKTWFB.c(I[C)V")
   public static final void c(int arg0, char[] arg1) {
      boolean var2 = false;
      int var3 = 0;
      int var4 = 0;
      if (arg0 >= 3 && arg0 <= 3) {
         int var5 = 0;

         while(true) {
            do {
               int var8;
               if ((var8 = a(307, var3, arg1)) == -1) {
                  return;
               }

               boolean var6 = false;

               for(int var7 = var3; var7 >= 0 && var7 < var8 && !var6; ++var7) {
                  if (!a(arg1[var7], false) && !a((int)2, (char)arg1[var7])) {
                     var6 = true;
                  }
               }

               if (var6) {
                  var4 = 0;
               }

               if (var4 == 0) {
                  var5 = var8;
               }

               var3 = b(var8, 618, arg1);
               int var9 = 0;

               for(int var10 = var8; var10 < var3; ++var10) {
                  var9 = var9 * 10 + arg1[var10] - 48;
               }

               if (var9 <= 255 && var3 - var8 <= 8) {
                  ++var4;
               } else {
                  var4 = 0;
               }
            } while(var4 != 4);

            for(int var11 = var5; var11 < var3; ++var11) {
               arg1[var11] = '*';
            }

            var4 = 0;
         }
      }
   }

   @ObfuscatedName("WXKKTWFB.a(II[C)I")
   public static final int a(int arg0, int arg1, char[] arg2) {
      for(int var3 = arg1; var3 < arg2.length && var3 >= 0; ++var3) {
         if (arg2[var3] >= '0' && arg2[var3] <= '9') {
            return var3;
         }
      }

      if (arg0 <= 0) {
         d = !d;
      }

      return -1;
   }

   @ObfuscatedName("WXKKTWFB.b(II[C)I")
   public static final int b(int arg0, int arg1, char[] arg2) {
      if (arg1 <= 0) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

      int var4 = arg0;

      while(true) {
         if (var4 < arg2.length && var4 >= 0) {
            if (arg2[var4] >= '0' && arg2[var4] <= '9') {
               ++var4;
               continue;
            }

            return var4;
         }

         return arg2.length;
      }
   }

   @ObfuscatedName("WXKKTWFB.a(CZ)Z")
   public static final boolean a(char arg0, boolean arg1) {
      if (arg1) {
         throw new NullPointerException();
      } else {
         return !a(true, arg0) && !b(arg0, false);
      }
   }

   @ObfuscatedName("WXKKTWFB.a(IC)Z")
   public static final boolean a(int arg0, char arg1) {
      if (arg0 != 2) {
         e = !e;
      }

      if (arg1 >= 'a' && arg1 <= 'z') {
         return arg1 == 'v' || arg1 == 'x' || arg1 == 'j' || arg1 == 'q' || arg1 == 'z';
      } else {
         return true;
      }
   }

   @ObfuscatedName("WXKKTWFB.a(ZC)Z")
   public static final boolean a(boolean arg0, char arg1) {
      if (!arg0) {
         b = -367;
      }

      return arg1 >= 'a' && arg1 <= 'z' || arg1 >= 'A' && arg1 <= 'Z';
   }

   @ObfuscatedName("WXKKTWFB.b(CZ)Z")
   public static final boolean b(char arg0, boolean arg1) {
      if (arg1) {
         throw new NullPointerException();
      } else {
         return arg0 >= '0' && arg0 <= '9';
      }
   }

   @ObfuscatedName("WXKKTWFB.c(CZ)Z")
   public static final boolean c(char arg0, boolean arg1) {
      if (arg1) {
         throw new NullPointerException();
      } else {
         return arg0 >= 'a' && arg0 <= 'z';
      }
   }

   @ObfuscatedName("WXKKTWFB.b(IC)Z")
   public static final boolean b(int arg0, char arg1) {
      if (arg0 >= 0) {
         g = -483;
      }

      return arg1 >= 'A' && arg1 <= 'Z';
   }

   @ObfuscatedName("WXKKTWFB.c([CI)Z")
   public static final boolean c(char[] arg0, int arg1) {
      boolean var2 = true;

      for(int var3 = 0; var3 < arg0.length; ++var3) {
         if (!b(arg0[var3], false) && arg0[var3] != 0) {
            var2 = false;
         }
      }

      int var4 = 78 / arg1;
      if (var2) {
         return true;
      } else {
         int var5 = b((char[])arg0, (byte)5);
         int var6 = 0;
         int var7 = m.length - 1;
         if (m[var6] != var5 && m[var7] != var5) {
            do {
               int var8 = (var6 + var7) / 2;
               if (m[var8] == var5) {
                  return true;
               }

               if (var5 < m[var8]) {
                  var7 = var8;
               } else {
                  var6 = var8;
               }
            } while(var6 != var7 && var6 + 1 != var7);

            return false;
         } else {
            return true;
         }
      }
   }

   @ObfuscatedName("WXKKTWFB.b([CB)I")
   public static final int b(char[] arg0, byte arg1) {
      if (arg0.length > 6) {
         return 0;
      } else {
         int var2 = 0;
         if (arg1 != 5) {
            return 3;
         } else {
            boolean var3 = false;

            for(int var4 = 0; var4 < arg0.length; ++var4) {
               char var5 = arg0[arg0.length - var4 - 1];
               if (var5 >= 'a' && var5 <= 'z') {
                  var2 = var2 * 38 + var5 - 'a' + 1;
               } else if (var5 == '\'') {
                  var2 = var2 * 38 + 27;
               } else if (var5 >= '0' && var5 <= '9') {
                  var2 = var2 * 38 + var5 - '0' + 28;
               } else if (var5 != 0) {
                  return 0;
               }
            }

            return var2;
         }
      }
   }
}
