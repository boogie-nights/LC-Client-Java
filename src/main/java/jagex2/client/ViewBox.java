package jagex2.client;

import deob.ObfuscatedName;

import java.awt.Frame;
import java.awt.Graphics;

public class ViewBox extends Frame {
   @ObfuscatedName("IEJCKZCR.a")
   public GameShell a;

   public ViewBox(int arg0, int arg1, GameShell arg2, int arg3) {
      this.a = arg2;
      this.setTitle("Jagex");
      this.setResizable(false);
      this.show();
      if (arg0 != 3) {
         throw new NullPointerException();
      } else {
         this.toFront();
         this.resize(arg3 + 8, arg1 + 28);
      }
   }

   public Graphics getGraphics() {
      Graphics var1 = super.getGraphics();
      var1.translate(4, 24);
      return var1;
   }

   public final void update(Graphics arg0) {
      this.a.update(arg0);
   }

   public final void paint(Graphics arg0) {
      this.a.paint(arg0);
   }
}
