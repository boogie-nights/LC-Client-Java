package jagex2.graphics;

import deob.ObfuscatedName;

import java.awt.*;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Hashtable;

public class PixMap implements ImageProducer, ImageObserver {
   @ObfuscatedName("ISZGOOMR.a")
   public boolean a = true;
   @ObfuscatedName("ISZGOOMR.c")
   public int c;
   @ObfuscatedName("ISZGOOMR.d")
   public int d;
   @ObfuscatedName("ISZGOOMR.b")
   public int[] b;
   @ObfuscatedName("ISZGOOMR.e")
   public ColorModel e;
   @ObfuscatedName("ISZGOOMR.g")
   public Image g;
   @ObfuscatedName("ISZGOOMR.f")
   public ImageConsumer f;

   public PixMap(int arg3, int arg0, Component arg2, byte arg1) {
      this.c = arg3;
      this.d = arg0;
      this.b = new int[arg0 * arg3];
      this.e = new DirectColorModel(32, 16711680, 65280, 255);
      this.g = arg2.createImage(this);
      this.a();
      arg2.prepareImage(this.g, this);
      this.a();
      arg2.prepareImage(this.g, this);
      if (arg1 != -12) {
         throw new NullPointerException();
      } else {
         this.a();
         arg2.prepareImage(this.g, this);
         this.a(false);
      }
   }

   @ObfuscatedName("ISZGOOMR.a(Z)V")
   public void a(boolean arg0) {
      if (arg0) {
         for(int var2 = 1; var2 > 0; ++var2) {
         }
      }

      Pix2D.bind(this.c, this.b, this.d);
   }

   @ObfuscatedName("ISZGOOMR.a(IILjava/awt/Graphics;Z)V")
   public void a(int arg0, int arg1, Graphics arg2, boolean arg3) {
      if (!arg3) {
         this.a();
         arg2.drawImage(this.g, arg1, arg0, this);
      }
   }

   public synchronized void addConsumer(ImageConsumer arg0) {
      this.f = arg0;
      arg0.setDimensions(this.c, this.d);
      arg0.setProperties((Hashtable)null);
      arg0.setColorModel(this.e);
      arg0.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer arg0) {
      return this.f == arg0;
   }

   public synchronized void removeConsumer(ImageConsumer arg0) {
      if (this.f == arg0) {
         this.f = null;
      }

   }

   public void startProduction(ImageConsumer arg0) {
      this.addConsumer(arg0);
   }

   public void requestTopDownLeftRightResend(ImageConsumer arg0) {
      System.out.println("TDLR");
   }

   @ObfuscatedName("ISZGOOMR.a()V")
   public synchronized void a() {
      if (this.f != null) {
         this.f.setPixels(0, 0, this.c, this.d, this.e, this.b, 0, this.c);
         this.f.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
      return true;
   }
}
