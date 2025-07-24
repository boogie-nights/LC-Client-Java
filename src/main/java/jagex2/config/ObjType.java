package jagex2.config;

import deob.*;
import jagex2.dash3d.Model;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Pix24;
import jagex2.graphics.Pix2D;
import jagex2.graphics.Pix3D;
import jagex2.io.Jagfile;
import jagex2.io.Packet;

public class ObjType {
	@ObfuscatedName("GSCQQEUA.x")
	public boolean x = true;
	@ObfuscatedName("GSCQQEUA.z")
	public int z = -68;
	@ObfuscatedName("GSCQQEUA.L")
	public int L = -1;
	@ObfuscatedName("GSCQQEUA.W")
	public boolean W = true;
	@ObfuscatedName("GSCQQEUA.l")
	public static LruCache l = new LruCache(50);
	@ObfuscatedName("GSCQQEUA.s")
	public static boolean membersWorld = true;
	@ObfuscatedName("GSCQQEUA.u")
	public static LruCache iconCache = new LruCache(100);
	@ObfuscatedName("GSCQQEUA.v")
	public static byte v = 6;
	@ObfuscatedName("GSCQQEUA.y")
	public static boolean y = true;
	@ObfuscatedName("GSCQQEUA.ab")
	public byte ab;
	@ObfuscatedName("GSCQQEUA.e")
	public byte e;
	@ObfuscatedName("GSCQQEUA.A")
	public static int A;
	@ObfuscatedName("GSCQQEUA.B")
	public int B;
	@ObfuscatedName("GSCQQEUA.C")
	public int C;
	@ObfuscatedName("GSCQQEUA.D")
	public int D;
	@ObfuscatedName("GSCQQEUA.E")
	public int E;
	@ObfuscatedName("GSCQQEUA.F")
	public int F;
	@ObfuscatedName("GSCQQEUA.G")
	public int G;
	@ObfuscatedName("GSCQQEUA.H")
	public int xan2d;
	@ObfuscatedName("GSCQQEUA.I")
	public int I;
	@ObfuscatedName("GSCQQEUA.J")
	public int J;
	@ObfuscatedName("GSCQQEUA.K")
	public int K;
	@ObfuscatedName("GSCQQEUA.O")
	public int O;
	@ObfuscatedName("GSCQQEUA.P")
	public int P;
	@ObfuscatedName("GSCQQEUA.Q")
	public int Q;
	@ObfuscatedName("GSCQQEUA.R")
	public int zoom2d;
	@ObfuscatedName("GSCQQEUA.S")
	public int S;
	@ObfuscatedName("GSCQQEUA.U")
	public int U;
	@ObfuscatedName("GSCQQEUA.X")
	public int X;
	@ObfuscatedName("GSCQQEUA.a")
	public int a;
	@ObfuscatedName("GSCQQEUA.b")
	public int b;
	@ObfuscatedName("GSCQQEUA.f")
	public int f;
	@ObfuscatedName("GSCQQEUA.g")
	public int g;
	@ObfuscatedName("GSCQQEUA.h")
	public int certlink;
	@ObfuscatedName("GSCQQEUA.i")
	public int i;
	@ObfuscatedName("GSCQQEUA.j")
	public static int j;
	@ObfuscatedName("GSCQQEUA.n")
	public int n;
	@ObfuscatedName("GSCQQEUA.o")
	public int o;
	@ObfuscatedName("GSCQQEUA.r")
	public int certtemplate;
	@ObfuscatedName("GSCQQEUA.t")
	public int t;
	@ObfuscatedName("GSCQQEUA.V")
	public static Packet V;
	@ObfuscatedName("GSCQQEUA.d")
	public String d;
	@ObfuscatedName("GSCQQEUA.T")
	public boolean stackable;
	@ObfuscatedName("GSCQQEUA.Z")
	public boolean Z;
	@ObfuscatedName("GSCQQEUA.c")
	public byte[] c;
	@ObfuscatedName("GSCQQEUA.M")
	public int[] M;
	@ObfuscatedName("GSCQQEUA.N")
	public int[] countobj;
	@ObfuscatedName("GSCQQEUA.Y")
	public int[] countco;
	@ObfuscatedName("GSCQQEUA.p")
	public int[] p;
	@ObfuscatedName("GSCQQEUA.q")
	public static int[] q;
	@ObfuscatedName("GSCQQEUA.k")
	public static ObjType[] k;
	@ObfuscatedName("GSCQQEUA.m")
	public String[] m;
	@ObfuscatedName("GSCQQEUA.w")
	public String[] w;

	@ObfuscatedName("GSCQQEUA.a(II)Z")
	public final boolean a(int arg0, int arg1) {
		int var3 = this.i;
		int var4 = this.J;
		if (arg1 != 0) {
			this.x = !this.x;
		}

		if (arg0 == 1) {
			var3 = this.X;
			var4 = this.K;
		}

		if (var3 == -1) {
			return true;
		} else {
			boolean var5 = true;
			if (!Model.b(var3)) {
				var5 = false;
			}

			if (var4 != -1 && !Model.b(var4)) {
				var5 = false;
			}

			return var5;
		}
	}

	@ObfuscatedName("GSCQQEUA.a(I)LGSCQQEUA;")
	public static final ObjType get(int arg0) {
		for (int var1 = 0; var1 < 10; ++var1) {
			if (k[var1].L == arg0) {
				return k[var1];
			}
		}

		A = (A + 1) % 10;
		ObjType var2 = k[A];
		V.pos = q[arg0];
		var2.L = arg0;
		var2.a();
		var2.a(v, V);
		if (var2.certtemplate != -1) {
			var2.b(0);
		}

		if (!membersWorld && var2.Z) {
			var2.d = "Members Object";
			var2.c = "Login to a members' server to use this object.".getBytes();
			var2.m = null;
			var2.w = null;
			var2.g = 0;
		}

		return var2;
	}

	@ObfuscatedName("GSCQQEUA.a(BI)LLZYQDKJV;")
	public final Model a(byte arg0, int arg1) {
		int var3 = this.B;
		int var4 = this.f;
		int var5 = this.S;
		if (arg1 == 1) {
			var3 = this.a;
			var4 = this.D;
			var5 = this.P;
		}

		if (var3 == -1) {
			return null;
		} else {
			Model var6 = Model.a(var3);
			if (arg0 != -98) {
				throw new NullPointerException();
			} else {
				if (var4 != -1) {
					if (var5 != -1) {
						Model var7 = Model.a(var4);
						Model var8 = Model.a(var5);
						Model[] var9 = new Model[]{var6, var7, var8};
						var6 = new Model(3, var9, (byte) -89);
					} else {
						Model var10 = Model.a(var4);
						Model[] var11 = new Model[]{var6, var10};
						var6 = new Model(2, var11, (byte) -89);
					}
				}

				if (arg1 == 0 && this.ab != 0) {
					var6.a(0, 0, false, this.ab);
				}

				if (arg1 == 1 && this.e != 0) {
					var6.a(0, 0, false, this.e);
				}

				if (this.M != null) {
					for (int var12 = 0; var12 < this.M.length; ++var12) {
						var6.recolour(this.M[var12], this.p[var12]);
					}
				}

				return var6;
			}
		}
	}

	@ObfuscatedName("GSCQQEUA.a(LATJMVOZR;)V")
	public static final void unpack(Jagfile arg0) {
		V = new Packet(arg0.read("obj.dat", (byte[]) null));
		Packet var1 = new Packet(arg0.read("obj.idx", (byte[]) null));
		j = var1.g2();
		q = new int[j];
		int var2 = 2;

		for (int var3 = 0; var3 < j; ++var3) {
			q[var3] = var2;
			var2 += var1.g2();
		}

		k = new ObjType[10];

		for (int var4 = 0; var4 < 10; ++var4) {
			k[var4] = new ObjType();
		}

	}

	@ObfuscatedName("GSCQQEUA.b(I)V")
	public void b(int arg0) {
		ObjType var2 = get(this.certtemplate);
		this.I = var2.I;
		this.zoom2d = var2.zoom2d;
		if (arg0 != 0) {
			for (int var3 = 1; var3 > 0; ++var3) {
			}
		}

		this.xan2d = var2.xan2d;
		this.E = var2.E;
		this.n = var2.n;
		this.b = var2.b;
		this.o = var2.o;
		this.M = var2.M;
		this.p = var2.p;
		ObjType var4 = get(this.certlink);
		this.d = var4.d;
		this.Z = var4.Z;
		this.t = var4.t;
		String var5 = "a";
		char var6 = var4.d.charAt(0);
		if (var6 == 'A' || var6 == 'E' || var6 == 'I' || var6 == 'O' || var6 == 'U') {
			var5 = "an";
		}

		this.c = ("Swap this note at any bank for " + var5 + " " + var4.d + ".").getBytes();
		this.stackable = true;
	}

	@ObfuscatedName("GSCQQEUA.b(II)Z")
	public final boolean b(int arg0, int arg1) {
		while (arg0 >= 0) {
		}

		int var3 = this.B;
		int var4 = this.f;
		int var5 = this.S;
		if (arg1 == 1) {
			var3 = this.a;
			var4 = this.D;
			var5 = this.P;
		}

		if (var3 == -1) {
			return true;
		} else {
			boolean var6 = true;
			if (!Model.b(var3)) {
				var6 = false;
			}

			if (var4 != -1 && !Model.b(var4)) {
				var6 = false;
			}

			if (var5 != -1 && !Model.b(var5)) {
				var6 = false;
			}

			return var6;
		}
	}

	@ObfuscatedName("GSCQQEUA.c(II)LLZYQDKJV;")
	public final Model getInvModel(int arg0, int arg1) {
		if (this.countobj != null && arg1 > 1) {
			int var3 = -1;

			for (int var4 = 0; var4 < 10; ++var4) {
				if (arg1 >= this.countco[var4] && this.countco[var4] != 0) {
					var3 = this.countobj[var4];
				}
			}

			if (var3 != -1) {
				return get(var3).getInvModel(this.z, 1);
			}
		}

		Model var5 = Model.a(this.I);

		while (arg0 >= 0) {
			this.x = !this.x;
		}

		if (var5 == null) {
			return null;
		} else {
			if (this.M != null) {
				for (int var6 = 0; var6 < this.M.length; ++var6) {
					var5.recolour(this.M[var6], this.p[var6]);
				}
			}

			return var5;
		}
	}

	@ObfuscatedName("GSCQQEUA.a(BLMFMVIYHT;)V")
	public final void a(byte arg0, Packet arg1) {
		if (arg0 != 6) {
			this.x = !this.x;
		}

		while (true) {
			while (true) {
				int var3 = arg1.g1();
				if (var3 == 0) {
					return;
				}

				if (var3 == 1) {
					this.I = arg1.g2();
				} else if (var3 == 2) {
					this.d = arg1.gjstr();
				} else if (var3 == 3) {
					this.c = arg1.gjstrraw();
				} else if (var3 == 4) {
					this.zoom2d = arg1.g2();
				} else if (var3 == 5) {
					this.xan2d = arg1.g2();
				} else if (var3 == 6) {
					this.E = arg1.g2();
				} else if (var3 == 7) {
					this.b = arg1.g2();
					if (this.b > 32767) {
						this.b -= 65536;
					}
				} else if (var3 == 8) {
					this.o = arg1.g2();
					if (this.o > 32767) {
						this.o -= 65536;
					}
				} else if (var3 == 10) {
					this.U = arg1.g2();
				} else if (var3 == 11) {
					this.stackable = true;
				} else if (var3 == 12) {
					this.t = arg1.g4();
				} else if (var3 == 16) {
					this.Z = true;
				} else if (var3 == 23) {
					this.B = arg1.g2();
					this.ab = arg1.g1b();
				} else if (var3 == 24) {
					this.f = arg1.g2();
				} else if (var3 == 25) {
					this.a = arg1.g2();
					this.e = arg1.g1b();
				} else if (var3 == 26) {
					this.D = arg1.g2();
				} else if (var3 >= 30 && var3 < 35) {
					if (this.m == null) {
						this.m = new String[5];
					}

					this.m[var3 - 30] = arg1.gjstr();
					if (this.m[var3 - 30].equalsIgnoreCase("hidden")) {
						this.m[var3 - 30] = null;
					}
				} else if (var3 >= 35 && var3 < 40) {
					if (this.w == null) {
						this.w = new String[5];
					}

					this.w[var3 - 35] = arg1.gjstr();
				} else if (var3 == 40) {
					int var4 = arg1.g1();
					this.M = new int[var4];
					this.p = new int[var4];

					for (int var5 = 0; var5 < var4; ++var5) {
						this.M[var5] = arg1.g2();
						this.p[var5] = arg1.g2();
					}
				} else if (var3 == 78) {
					this.S = arg1.g2();
				} else if (var3 == 79) {
					this.P = arg1.g2();
				} else if (var3 == 90) {
					this.i = arg1.g2();
				} else if (var3 == 91) {
					this.X = arg1.g2();
				} else if (var3 == 92) {
					this.J = arg1.g2();
				} else if (var3 == 93) {
					this.K = arg1.g2();
				} else if (var3 == 95) {
					this.n = arg1.g2();
				} else if (var3 == 97) {
					this.certlink = arg1.g2();
				} else if (var3 == 98) {
					this.certtemplate = arg1.g2();
				} else if (var3 >= 100 && var3 < 110) {
					if (this.countobj == null) {
						this.countobj = new int[10];
						this.countco = new int[10];
					}

					this.countobj[var3 - 100] = arg1.g2();
					this.countco[var3 - 100] = arg1.g2();
				} else if (var3 == 110) {
					this.O = arg1.g2();
				} else if (var3 == 111) {
					this.F = arg1.g2();
				} else if (var3 == 112) {
					this.Q = arg1.g2();
				} else if (var3 == 113) {
					this.C = arg1.g1b();
				} else if (var3 == 114) {
					this.G = arg1.g1b() * 5;
				} else if (var3 == 115) {
					this.g = arg1.g1();
				}
			}
		}
	}

	@ObfuscatedName("GSCQQEUA.a(ZI)LLZYQDKJV;")
	public final Model a(boolean arg0, int arg1) {
		if (!arg0) {
			this.W = !this.W;
		}

		int var3 = this.i;
		int var4 = this.J;
		if (arg1 == 1) {
			var3 = this.X;
			var4 = this.K;
		}

		if (var3 == -1) {
			return null;
		} else {
			Model var5 = Model.a(var3);
			if (var4 != -1) {
				Model var6 = Model.a(var4);
				Model[] var7 = new Model[]{var5, var6};
				var5 = new Model(2, var7, (byte) -89);
			}

			if (this.M != null) {
				for (int var8 = 0; var8 < this.M.length; ++var8) {
					var5.recolour(this.M[var8], this.p[var8]);
				}
			}

			return var5;
		}
	}

	@ObfuscatedName("GSCQQEUA.c(I)LLZYQDKJV;")
	public final Model getModel(int arg0) {
		if (this.countobj != null && arg0 > 1) {
			int var2 = -1;

			for (int var3 = 0; var3 < 10; ++var3) {
				if (arg0 >= this.countco[var3] && this.countco[var3] != 0) {
					var2 = this.countobj[var3];
				}
			}

			if (var2 != -1) {
				return get(var2).getModel(1);
			}
		}

		Model var4 = (Model) l.get((long) this.L);
		if (var4 != null) {
			return var4;
		} else {
			Model var5 = Model.a(this.I);
			if (var5 == null) {
				return null;
			} else {
				if (this.O != 128 || this.F != 128 || this.Q != 128) {
					var5.a(this.F, this.Q, 9, this.O);
				}

				if (this.M != null) {
					for (int var6 = 0; var6 < this.M.length; ++var6) {
						var5.recolour(this.M[var6], this.p[var6]);
					}
				}

				var5.calculateNormals(this.C + 64, this.G + 768, -50, -10, -50, true);
				var5.eb = true;
				l.put(var5, (long) this.L);
				return var5;
			}
		}
	}

	@ObfuscatedName("GSCQQEUA.a(BIII)LEPQDEJTO;")
	public static final Pix24 getIcon(int id, int count, int outlineRgb) {
		if (outlineRgb == 0) {
			Pix24 icon = (Pix24) iconCache.get(id);

			if (icon != null && icon.height != count && icon.height != -1) {
				icon.unlink();
				icon = null;
			}

			if (icon != null) {
				return icon;
			}
		}

		ObjType obj = get(id);
		if (obj.countobj == null) {
			count = -1;
		}

		if (count > 1) {
			int countObj = -1;

			for (int i = 0; i < 10; ++i) {
				if (count >= obj.countco[i] && obj.countco[i] != 0) {
					countObj = obj.countobj[i];
				}
			}

			if (countObj != -1) {
				obj = get(countObj);
			}
		}

		Model model = obj.getModel(1);
		if (model == null) {
			return null;
		}

		Pix24 linkedIcon = null;
		if (obj.certtemplate != -1) {
			linkedIcon = getIcon(obj.certlink, 10, -1);
			if (linkedIcon == null) {
				return null;
			}
		}

		Pix24 icon = new Pix24(32, 32);
		int _cx = Pix3D.centerX;
		int _cy = Pix3D.centerY;
		int[] _loff = Pix3D.lineOffset;
		int[] _data = Pix2D.data;
		int _w = Pix2D.width2d;
		int _h = Pix2D.height2d;
		int _l = Pix2D.left;
		int _r = Pix2D.right;
		int _t = Pix2D.top;
		int _b = Pix2D.bottom;

		Pix3D.jagged = false;
		Pix2D.bind(32, icon.pixels, 32);
		Pix2D.fillRect(0, 32, 32, 0, 0);
		Pix3D.init2D((int) 568);

		int zoom = obj.zoom2d;
		if (outlineRgb == -1) {
			zoom = (int) ((double) zoom * 1.5D);
		}

		if (outlineRgb > 0) {
			zoom = (int) ((double) zoom * 1.04D);
		}

		int sinPitch = Pix3D.sinTable[obj.xan2d] * zoom >> 16;
		int cosPitch = Pix3D.cosTable[obj.xan2d] * zoom >> 16;

		model.drawSimple(0, obj.E, obj.n, obj.xan2d, obj.b, model.k / 2 + sinPitch + obj.o, obj.o + cosPitch);

		for (int x = 31; x >= 0; --x) {
			for (int y = 31; y >= 0; --y) {
				if (icon.pixels[y * 32 + x] == 0) {
					if (x > 0 && icon.pixels[y * 32 + (x - 1)] > 1) {
						icon.pixels[y * 32 + x] = 1;
					} else if (y > 0 && icon.pixels[(y - 1) * 32 + x] > 1) {
						icon.pixels[y * 32 + x] = 1;
					} else if (x < 31 && icon.pixels[y * 32 + x + 1] > 1) {
						icon.pixels[y * 32 + x] = 1;
					} else if (y < 31 && icon.pixels[(y + 1) * 32 + x] > 1) {
						icon.pixels[y * 32 + x] = 1;
					}
				}
			}
		}

		if (outlineRgb > 0) {
			for (int x = 31; x >= 0; --x) {
				for (int y = 31; y >= 0; --y) {
					if (icon.pixels[y * 32 + x] == 0) {
						if (x > 0 && icon.pixels[y * 32 + (x - 1)] == 1) {
							icon.pixels[y * 32 + x] = outlineRgb;
						} else if (y > 0 && icon.pixels[(y - 1) * 32 + x] == 1) {
							icon.pixels[y * 32 + x] = outlineRgb;
						} else if (x < 31 && icon.pixels[y * 32 + x + 1] == 1) {
							icon.pixels[y * 32 + x] = outlineRgb;
						} else if (y < 31 && icon.pixels[(y + 1) * 32 + x] == 1) {
							icon.pixels[y * 32 + x] = outlineRgb;
						}
					}
				}
			}
		} else if (outlineRgb == 0) {
			for (int x = 31; x >= 0; --x) {
				for (int y = 31; y >= 0; --y) {
					if (icon.pixels[y * 32 + x] == 0 && x > 0 && y > 0 && icon.pixels[(y - 1) * 32 + (x - 1)] > 0) {
						icon.pixels[y * 32 + x] = 3153952;
					}
				}
			}
		}

		if (obj.certtemplate != -1) {
			int w = linkedIcon.width;
			int h = linkedIcon.height;
			linkedIcon.width = 32;
			linkedIcon.height = 32;
			linkedIcon.b(0, 0, -488);
			linkedIcon.width = w;
			linkedIcon.height = h;
		}

		if (outlineRgb == 0) {
			iconCache.put(icon, id);
		}

		Pix2D.bind(_w, _data, _h);
		Pix2D.setBounds(_r, _b, _t, _l);
		Pix3D.centerX = _cx;
		Pix3D.centerY = _cy;
		Pix3D.lineOffset = _loff;
		Pix3D.jagged = true;
		if (obj.stackable) {
			icon.width = 33;
		} else {
			icon.width = 32;
		}

		icon.height = count;
		return icon;
	}

	@ObfuscatedName("GSCQQEUA.a(Z)V")
	public static final void a(boolean arg0) {
		l = null;
		if (arg0) {
			for (int var1 = 1; var1 > 0; ++var1) {
			}
		}

		iconCache = null;
		q = null;
		k = null;
		V = null;
	}

	@ObfuscatedName("GSCQQEUA.a()V")
	public final void a() {
		this.I = 0;
		this.d = null;
		this.c = null;
		this.M = null;
		this.p = null;
		this.zoom2d = 2000;
		this.xan2d = 0;
		this.E = 0;
		this.n = 0;
		this.b = 0;
		this.o = 0;
		this.U = -1;
		this.stackable = false;
		this.t = 1;
		this.Z = false;
		this.m = null;
		this.w = null;
		this.B = -1;
		this.f = -1;
		this.ab = 0;
		this.a = -1;
		this.D = -1;
		this.e = 0;
		this.S = -1;
		this.P = -1;
		this.i = -1;
		this.J = -1;
		this.X = -1;
		this.K = -1;
		this.countobj = null;
		this.countco = null;
		this.certlink = -1;
		this.certtemplate = -1;
		this.O = 128;
		this.F = 128;
		this.Q = 128;
		this.C = 0;
		this.G = 0;
		this.g = 0;
	}
}
