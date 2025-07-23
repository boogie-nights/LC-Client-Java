package jagex2.config;

import jagex2.io.Jagfile;
import deob.ObfuscatedName;
import jagex2.io.Packet;

public class VarpType {
	@ObfuscatedName("WEUDDWZB.h")
	public boolean code3 = false;
	@ObfuscatedName("WEUDDWZB.i")
	public boolean code4 = true;
	@ObfuscatedName("WEUDDWZB.k")
	public boolean code6 = false;
	@ObfuscatedName("WEUDDWZB.n")
	public boolean code11 = false;
	@ObfuscatedName("WEUDDWZB.o")
	public int code12 = -1;
	@ObfuscatedName("WEUDDWZB.p")
	public boolean code14 = true;
	@ObfuscatedName("WEUDDWZB.a")
	public static int count;
	@ObfuscatedName("WEUDDWZB.c")
	public static int code3count;
	@ObfuscatedName("WEUDDWZB.f")
	public int code1;
	@ObfuscatedName("WEUDDWZB.g")
	public int code2;
	@ObfuscatedName("WEUDDWZB.j")
	public int clientcode;
	@ObfuscatedName("WEUDDWZB.l")
	public int code7;
	@ObfuscatedName("WEUDDWZB.m")
	public int code8;
	@ObfuscatedName("WEUDDWZB.e")
	public String e;
	@ObfuscatedName("WEUDDWZB.d")
	public static int[] code3s;
	@ObfuscatedName("WEUDDWZB.b")
	public static VarpType[] types;

	@ObfuscatedName("WEUDDWZB.a(LATJMVOZR;I)V")
	public static void unpack(Jagfile config) {
		Packet dat = new Packet(config.read("varp.dat", null));

		code3count = 0;
		count = dat.g2();

		if (types == null) {
			types = new VarpType[count];
		}

		if (code3s == null) {
			code3s = new int[count];
		}

		for (int i = 0; i < count; ++i) {
			if (types[i] == null) {
				types[i] = new VarpType();
			}

			types[i].decode(dat, i);
		}

		if (dat.data.length != dat.pos) {
			System.out.println("varptype load mismatch");
		}
	}

	@ObfuscatedName("WEUDDWZB.a(IILMFMVIYHT;)V")
	public void decode(Packet buf, int id) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			if (code == 1) {
				this.code1 = buf.g1();
			} else if (code == 2) {
				this.code2 = buf.g1();
			} else if (code == 3) {
				this.code3 = true;
				code3s[code3count++] = id;
			} else if (code == 4) {
				this.code4 = false;
			} else if (code == 5) {
				this.clientcode = buf.g2();
			} else if (code == 6) {
				this.code6 = true;
			} else if (code == 7) {
				this.code7 = buf.g4();
			} else if (code == 8) {
				this.code8 = 1;
				this.code11 = true;
			} else if (code == 10) {
				this.e = buf.gjstr();
			} else if (code == 11) {
				this.code11 = true;
			} else if (code == 12) {
				this.code12 = buf.g4();
			} else if (code == 13) {
				this.code8 = 2;
				this.code11 = true;
			} else if (code == 14) {
				this.code14 = false;
			} else {
				System.out.println("Error unrecognised config code: " + code);
			}
		}
	}
}
