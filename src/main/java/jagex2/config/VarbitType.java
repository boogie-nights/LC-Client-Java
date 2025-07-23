package jagex2.config;

import jagex2.io.Jagfile;
import deob.ObfuscatedName;
import jagex2.io.Packet;

public class VarbitType {
	@ObfuscatedName("ZQTIEXZH.h")
	public boolean h = false;
	@ObfuscatedName("ZQTIEXZH.i")
	public int i = -1;
	@ObfuscatedName("ZQTIEXZH.k")
	public boolean k = true;
	@ObfuscatedName("ZQTIEXZH.a")
	public int a;
	@ObfuscatedName("ZQTIEXZH.b")
	public static int b;
	@ObfuscatedName("ZQTIEXZH.e")
	public int e;
	@ObfuscatedName("ZQTIEXZH.f")
	public int f;
	@ObfuscatedName("ZQTIEXZH.g")
	public int g;
	@ObfuscatedName("ZQTIEXZH.j")
	public int j;
	@ObfuscatedName("ZQTIEXZH.d")
	public String d;
	@ObfuscatedName("ZQTIEXZH.c")
	public static VarbitType[] c;

	@ObfuscatedName("ZQTIEXZH.a(LATJMVOZR;I)V")
	public static void unpack(Jagfile config) {
		Packet dat = new Packet(config.read("varbit.dat", null));

		b = dat.g2();
		if (c == null) {
			c = new VarbitType[b];
		}

		for (int var3 = 0; var3 < b; ++var3) {
			if (c[var3] == null) {
				c[var3] = new VarbitType();
			}

			c[var3].decode(dat, var3);
			if (c[var3].h) {
				VarpType.types[c[var3].e].code11 = true;
			}
		}

		if (dat.data.length != dat.pos) {
			System.out.println("varbit load mismatch");
		}
	}

	@ObfuscatedName("ZQTIEXZH.a(IILMFMVIYHT;)V")
	public void decode(Packet buf, int arg1) {
		while (true) {
			int var4 = buf.g1();
			if (var4 == 0) {
				return;
			}

			if (var4 == 1) {
				this.e = buf.g2();
				this.f = buf.g1();
				this.g = buf.g1();
			} else if (var4 == 10) {
				this.d = buf.gjstr();
			} else if (var4 == 2) {
				this.h = true;
			} else if (var4 == 3) {
				this.i = buf.g4();
			} else if (var4 == 4) {
				this.j = buf.g4();
			} else if (var4 == 5) {
				this.k = false;
			} else {
				System.out.println("Error unrecognised config code: " + var4);
			}
		}
	}
}
