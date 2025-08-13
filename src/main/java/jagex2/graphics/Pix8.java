package jagex2.graphics;

import jagex2.io.Jagfile;
import deob.ObfuscatedName;
import jagex2.io.Packet;

public class Pix8 extends Pix2D {
	@ObfuscatedName("WRRBQEHV.w")
	public int w = 3;
	@ObfuscatedName("WRRBQEHV.x")
	public boolean x = true;
	@ObfuscatedName("WRRBQEHV.z")
	public int z = -235;
	@ObfuscatedName("WRRBQEHV.A")
	public byte A = 5;
	@ObfuscatedName("WRRBQEHV.B")
	public int B = -3539;
	@ObfuscatedName("WRRBQEHV.C")
	public boolean C = true;
	@ObfuscatedName("WRRBQEHV.J")
	public int cropW;
	@ObfuscatedName("WRRBQEHV.K")
	public int cropH;
	@ObfuscatedName("WRRBQEHV.E")
	public int[] palette;
	@ObfuscatedName("WRRBQEHV.H")
	public int cropX;
	@ObfuscatedName("WRRBQEHV.I")
	public int cropY;
	@ObfuscatedName("WRRBQEHV.F")
	public int width;
	@ObfuscatedName("WRRBQEHV.G")
	public int height;
	@ObfuscatedName("WRRBQEHV.D")
	public byte[] pixels;
	@ObfuscatedName("WRRBQEHV.y")
	public int y;

	public Pix8(Jagfile jag, String name, int sprite) {
		Packet dat = new Packet(jag.read(name + ".dat", (byte[]) null));
		Packet idx = new Packet(jag.read("index.dat", (byte[]) null));

		idx.pos = dat.g2();
		this.cropW = idx.g2();
		this.cropH = idx.g2();

		int paletteCount = idx.g1();
		this.palette = new int[paletteCount];

		for (int i = 0; i < paletteCount - 1; ++i) {
			this.palette[i + 1] = idx.g3();
		}

		for (int i = 0; i < sprite; ++i) {
			idx.pos += 2;
			dat.pos += idx.g2() * idx.g2();
			idx.pos++;
		}

		this.cropX = idx.g1();
		this.cropY = idx.g1();
		this.width = idx.g2();
		this.height = idx.g2();

		int pixelOrder = idx.g1();
		int pixels = this.height * this.width;
		this.pixels = new byte[pixels];

		if (pixelOrder == 0) {
			for (int i = 0; i < pixels; ++i) {
				this.pixels[i] = dat.g1b();
			}
		} else {
			if (pixelOrder == 1) {
				for (int x = 0; x < this.width; ++x) {
					for (int y = 0; y < this.height; ++y) {
						this.pixels[this.width * y + x] = dat.g1b();
					}
				}
			}
		}
	}

	@ObfuscatedName("WRRBQEHV.b(I)V")
	public void shrink() {
		this.cropW /= 2;
		this.cropH /= 2;

		byte[] pixels = new byte[this.cropH * this.cropW];
		int offSet = 0;
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				pixels[(this.cropX + x >> 1) + (this.cropY + y >> 1) * this.cropW] = this.pixels[offSet++];
			}
		}

		this.pixels = pixels;
		this.width = this.cropW;
		this.height = this.cropH;
		this.cropX = 0;
		this.cropY = 0;
	}

	@ObfuscatedName("WRRBQEHV.a(Z)V")
	public void a(boolean arg0) {
		if (this.cropW != this.width || this.cropH != this.height) {
			byte[] var2 = new byte[this.cropH * this.cropW];
			int var3 = 0;

			for (int var4 = 0; var4 < this.height; ++var4) {
				for (int var5 = 0; var5 < this.width; ++var5) {
					var2[(this.cropY + var4) * this.cropW + this.cropX + var5] = this.pixels[var3++];
				}
			}

			this.pixels = var2;
			this.width = this.cropW;
			if (arg0) {
				this.height = this.cropH;
				this.cropX = 0;
				this.cropY = 0;
			}
		}
	}

	@ObfuscatedName("WRRBQEHV.c(I)V")
	public void flipHorizontally() {
		byte[] var2 = new byte[this.height * this.width];
		int var3 = 0;

		for (int var4 = 0; var4 < this.height; ++var4) {
			for (int var5 = this.width - 1; var5 >= 0; --var5) {
				var2[var3++] = this.pixels[this.width * var4 + var5];
			}
		}

		this.pixels = var2;
		this.cropX = this.cropW - this.width - this.cropX;
	}

	@ObfuscatedName("WRRBQEHV.b(B)V")
	public void flipVertically() {
		byte[] var2 = new byte[this.height * this.width];
		int var3 = 0;

		for (int var4 = this.height - 1; var4 >= 0; --var4) {
			for (int var5 = 0; var5 < this.width; ++var5) {
				var2[var3++] = this.pixels[this.width * var4 + var5];
			}
		}

		this.pixels = var2;
		this.cropY = this.cropH - this.height - this.cropY;
	}

	@ObfuscatedName("WRRBQEHV.a(IIII)V")
	public void translate(int arg0, int arg1, int arg2, int arg3) {
		for (int var5 = 0; var5 < this.palette.length; ++var5) {
			int var6 = this.palette[var5] >> 16 & 255;
			int var7 = arg2 + var6;
			if (var7 < 0) {
				var7 = 0;
			} else if (var7 > 255) {
				var7 = 255;
			}

			int var8 = this.palette[var5] >> 8 & 255;
			int var9 = arg1 + var8;
			if (var9 < 0) {
				var9 = 0;
			} else if (var9 > 255) {
				var9 = 255;
			}

			int var10 = this.palette[var5] & 255;
			int var11 = arg0 + var10;
			if (var11 < 0) {
				var11 = 0;
			} else if (var11 > 255) {
				var11 = 255;
			}

			this.palette[var5] = (var7 << 16) + (var9 << 8) + var11;
		}

		if (this.z == arg3) {
			;
		}
	}

	@ObfuscatedName("WRRBQEHV.a(III)V")
	public void plotSprite(int arg0, int arg1, int arg2) {
		int var4 = this.cropX + arg1;
		int var5 = this.cropY + arg0;

		while (arg2 >= 0) {
			for (int var6 = 1; var6 > 0; ++var6) {
			}
		}

		int var7 = Pix2D.width2d * var5 + var4;
		int var8 = 0;
		int var9 = this.height;
		int var10 = this.width;
		int var11 = Pix2D.width2d - var10;
		int var12 = 0;
		if (var5 < Pix2D.top) {
			int var13 = Pix2D.top - var5;
			var9 -= var13;
			var5 = Pix2D.top;
			var8 += var10 * var13;
			var7 += Pix2D.width2d * var13;
		}

		if (var5 + var9 > Pix2D.bottom) {
			var9 -= var5 + var9 - Pix2D.bottom;
		}

		if (var4 < Pix2D.left) {
			int var14 = Pix2D.left - var4;
			var10 -= var14;
			var4 = Pix2D.left;
			var8 += var14;
			var7 += var14;
			var12 += var14;
			var11 += var14;
		}

		if (var4 + var10 > Pix2D.right) {
			int var15 = var4 + var10 - Pix2D.right;
			var10 -= var15;
			var12 += var15;
			var11 += var15;
		}

		if (var10 > 0 && var9 > 0) {
			this.a(var8, Pix2D.data, this.pixels, var12, this.palette, var9, var10, var7, false, var11);
		}
	}

	@ObfuscatedName("WRRBQEHV.a(I[I[BI[IIIIZI)V")
	public void a(int arg0, int[] arg1, byte[] arg2, int arg3, int[] arg4, int arg5, int arg6, int arg7, boolean arg8, int arg9) {
		int var11 = -(arg6 >> 2);
		int var12 = -(arg6 & 3);
		if (arg8) {
			this.y = 264;
		}

		for (int var13 = -arg5; var13 < 0; ++var13) {
			for (int var14 = var11; var14 < 0; ++var14) {
				byte var15 = arg2[arg0++];
				if (var15 != 0) {
					arg1[arg7++] = arg4[var15 & 255];
				} else {
					++arg7;
				}

				byte var16 = arg2[arg0++];
				if (var16 != 0) {
					arg1[arg7++] = arg4[var16 & 255];
				} else {
					++arg7;
				}

				byte var17 = arg2[arg0++];
				if (var17 != 0) {
					arg1[arg7++] = arg4[var17 & 255];
				} else {
					++arg7;
				}

				byte var18 = arg2[arg0++];
				if (var18 != 0) {
					arg1[arg7++] = arg4[var18 & 255];
				} else {
					++arg7;
				}
			}

			for (int var19 = var12; var19 < 0; ++var19) {
				byte var20 = arg2[arg0++];
				if (var20 != 0) {
					arg1[arg7++] = arg4[var20 & 255];
				} else {
					++arg7;
				}
			}

			arg7 += arg9;
			arg0 += arg3;
		}

	}
}
