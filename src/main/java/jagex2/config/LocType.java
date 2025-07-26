package jagex2.config;

import deob.*;
import jagex2.client.Client;
import jagex2.dash3d.AnimFrame;
import jagex2.dash3d.Model;
import jagex2.datastruct.LruCache;
import jagex2.io.Jagfile;
import jagex2.io.OnDemand;
import jagex2.io.Packet;

public class LocType {
	@ObfuscatedName("YMYTDPVW.k")
	public int k = -992;
	@ObfuscatedName("YMYTDPVW.p")
	public int id = -1;
	@ObfuscatedName("YMYTDPVW.q")
	public boolean q = true;
	@ObfuscatedName("YMYTDPVW.s")
	public String name = "null";
	@ObfuscatedName("YMYTDPVW.C")
	public boolean C = true;
	@ObfuscatedName("YMYTDPVW.J")
	public byte J = -113;
	@ObfuscatedName("YMYTDPVW.e")
	public static LruCache modelCacheDynamic = new LruCache(40);
	@ObfuscatedName("YMYTDPVW.n")
	public static Model[] n = new Model[4];
	@ObfuscatedName("YMYTDPVW.v")
	public static LruCache modelCacheStatic = new LruCache(500);
	@ObfuscatedName("YMYTDPVW.Q")
	public static byte Q = 6;
	@ObfuscatedName("YMYTDPVW.A")
	public byte ambient;
	@ObfuscatedName("YMYTDPVW.D")
	public byte contrast;
	@ObfuscatedName("YMYTDPVW.B")
	public int offsety;
	@ObfuscatedName("YMYTDPVW.E")
	public int E;
	@ObfuscatedName("YMYTDPVW.K")
	public int raiseobject;
	@ObfuscatedName("YMYTDPVW.L")
	public int mapscene;
	@ObfuscatedName("YMYTDPVW.M")
	public int resizez;
	@ObfuscatedName("YMYTDPVW.R")
	public int width;
	@ObfuscatedName("YMYTDPVW.S")
	public int wallwidth;
	@ObfuscatedName("YMYTDPVW.T")
	public int anim;
	@ObfuscatedName("YMYTDPVW.W")
	public int mapfunction;
	@ObfuscatedName("YMYTDPVW.Y")
	public static int count;
	@ObfuscatedName("YMYTDPVW.c")
	public int resizey;
	@ObfuscatedName("YMYTDPVW.d")
	public int offsetx;
	@ObfuscatedName("YMYTDPVW.g")
	public int forceapproach;
	@ObfuscatedName("YMYTDPVW.i")
	public int offsetz;
	@ObfuscatedName("YMYTDPVW.r")
	public int length;
	@ObfuscatedName("YMYTDPVW.t")
	public static int cachepos;
	@ObfuscatedName("YMYTDPVW.u")
	public int multivarbit;
	@ObfuscatedName("YMYTDPVW.w")
	public int resizex;
	@ObfuscatedName("YMYTDPVW.x")
	public int multivarp;
	@ObfuscatedName("YMYTDPVW.j")
	public static Packet data;
	@ObfuscatedName("YMYTDPVW.m")
	public static Client client;
	@ObfuscatedName("YMYTDPVW.H")
	public boolean breakroutefinding;
	@ObfuscatedName("YMYTDPVW.N")
	public boolean occlude;
	@ObfuscatedName("YMYTDPVW.O")
	public boolean mirror;
	@ObfuscatedName("YMYTDPVW.U")
	public boolean sharelight;
	@ObfuscatedName("YMYTDPVW.X")
	public boolean shadow;
	@ObfuscatedName("YMYTDPVW.Z")
	public boolean blockrange;
	@ObfuscatedName("YMYTDPVW.ab")
	public boolean blockwalk;
	@ObfuscatedName("YMYTDPVW.b")
	public boolean active;
	@ObfuscatedName("YMYTDPVW.h")
	public boolean forcedecor;
	@ObfuscatedName("YMYTDPVW.l")
	public boolean hillskew;
	@ObfuscatedName("YMYTDPVW.o")
	public static boolean lowMemory;
	@ObfuscatedName("YMYTDPVW.z")
	public byte[] desc;
	@ObfuscatedName("YMYTDPVW.F")
	public int[] shapes;
	@ObfuscatedName("YMYTDPVW.I")
	public int[] recol_d;
	@ObfuscatedName("YMYTDPVW.P")
	public int[] recol_s;
	@ObfuscatedName("YMYTDPVW.V")
	public int[] multiloc;
	@ObfuscatedName("YMYTDPVW.a")
	public static int[] idx;
	@ObfuscatedName("YMYTDPVW.f")
	public int[] models;
	@ObfuscatedName("YMYTDPVW.y")
	public static LocType[] cache;
	@ObfuscatedName("YMYTDPVW.G")
	public String[] op;

	@ObfuscatedName("YMYTDPVW.a(I)LYMYTDPVW;")
	public static final LocType get(int id) {
		for (int i = 0; i < 20; ++i) {
			if (cache[i].id == id) {
				return cache[i];
			}
		}

		cachepos = (cachepos + 1) % 20;

		LocType loc = cache[cachepos];
		data.pos = idx[id];
		loc.id = id;
		loc.reset();
		loc.decode(data);
		return loc;
	}

	@ObfuscatedName("YMYTDPVW.b(I)LYMYTDPVW;")
	public final LocType getMulitLoc(int arg0) {
		int varb = -1;
		if (this.multivarbit != -1) {
			VarbitType varbit = VarbitType.types[this.multivarbit];
			int basevar = varbit.basevar;
			int startbit = varbit.startbit;
			int endbit = varbit.endbit;
			int value = Client.BITMASK[endbit - startbit];
			varb = client.varps[basevar] >> startbit & value;
		} else if (this.multivarp != -1) {
			varb = client.varps[this.multivarp];
		}

		return varb >= 0 && varb < this.multiloc.length && this.multiloc[varb] != -1 ? get(this.multiloc[varb]) : null;
	}

	@ObfuscatedName("YMYTDPVW.a(LZPGPWCCV;I)V")
	public final void prefetch(OnDemand od) {
		if (this.models == null) {
			return;
		}

		for (int i = 0; i < this.models.length; ++i) {
			od.prefetch(0, this.models[i] & 65535);
		}
	}

	@ObfuscatedName("YMYTDPVW.a(LATJMVOZR;)V")
	public static final void unpack(Jagfile config) {
		data = new Packet(config.read("loc.dat", null));
		Packet temp = new Packet(config.read("loc.idx", null));

		count = temp.g2();
		idx = new int[count];

		int pos = 2;
		for (int i = 0; i < count; ++i) {
			idx[i] = pos;
			pos += temp.g2();
		}

		cache = new LocType[20];
		for (int i = 0; i < 20; ++i) {
			cache[i] = new LocType();
		}
	}

	@ObfuscatedName("YMYTDPVW.a(IIII)LLZYQDKJV;")
	public final Model getModel(int angle, int transformId, int arg2, int arg3) {
		Model model = null;
		long key;
		if (this.shapes == null) {
			if (arg3 != 10) {
				return null;
			}

			key = ((long) (transformId + 1) << 32) + (long) ((this.id << 6) + angle);
			Model var8 = (Model) modelCacheDynamic.get(key);
			if (var8 != null) {
				return var8;
			}

			if (this.models == null) {
				return null;
			}

			boolean var9 = this.mirror ^ angle > 3;
			int var10 = this.models.length;

			for (int var11 = 0; var11 < var10; ++var11) {
				int var12 = this.models[var11];
				if (var9) {
					var12 += 65536;
				}

				model = (Model) modelCacheStatic.get((long) var12);
				if (model == null) {
					model = Model.tryGet(var12 & 65535);
					if (model == null) {
						return null;
					}

					if (var9) {
						model.g(0);
					}

					modelCacheStatic.put(model, (long) var12);
				}

				if (var10 > 1) {
					n[var11] = model;
				}
			}

			if (var10 > 1) {
				model = new Model(var10, n);
			}
		} else {
			int var13 = -1;

			for (int var14 = 0; var14 < this.shapes.length; ++var14) {
				if (this.shapes[var14] == arg3) {
					var13 = var14;
					break;
				}
			}

			if (var13 == -1) {
				return null;
			}

			key = ((long) (transformId + 1) << 32) + (long) ((this.id << 6) + (var13 << 3) + angle);
			Model var15 = (Model) modelCacheDynamic.get(key);
			if (var15 != null) {
				return var15;
			}

			int var16 = this.models[var13];
			boolean flip = this.mirror ^ angle > 3;
			if (flip) {
				var16 += 65536;
			}

			model = (Model) modelCacheStatic.get((long) var16);
			if (model == null) {
				model = Model.tryGet(var16 & 65535);
				if (model == null) {
					return null;
				}

				if (flip) {
					model.g(0);
				}

				modelCacheStatic.put(model, (long) var16);
			}
		}

		boolean scaled;
		if (this.resizex == 128 && this.resizey == 128 && this.resizez == 128) {
			scaled = false;
		} else {
			scaled = true;
		}

		boolean translated;
		if (this.offsetx == 0 && this.offsety == 0 && this.offsetz == 0) {
			translated = false;
		} else {
			translated = true;
		}

		Model modified = new Model(angle == 0 && transformId == -1 && !scaled && !translated, false, this.recol_s == null, model, AnimFrame.a(this.q, transformId));
		if (transformId != -1) {
			modified.createLabelReferences();
			modified.applyTransform(transformId);
			modified.labelFaces = null;
			modified.labelVertices = null;
		}

		while (angle-- > 0) {
			modified.rotateY90(true);
		}

		if (this.recol_s != null) {
			for (int i = 0; i < this.recol_s.length; ++i) {
				modified.recolour(this.recol_s[i], this.recol_d[i]);
			}
		}

		if (scaled) {
			modified.scale(this.resizey, this.resizez, 9, this.resizex);
		}

		if (translated) {
			modified.translate(this.offsetx, this.offsetz, false, this.offsety);
		}

		modified.calculateNormals(this.ambient + 64, this.contrast * 5 + 768, -50, -10, -50, !this.sharelight);
		if (this.raiseobject == 1) {
			modified.objRaise = modified.minY;
		}

		modelCacheDynamic.put(modified, key);
		return modified;
	}

	@ObfuscatedName("YMYTDPVW.c(I)Z")
	public final boolean modelsAreReady() {
		if (this.models == null) {
			return true;
		}

		boolean ready = true;
		for (int i = 0; i < this.models.length; ++i) {
			ready &= Model.isReady(this.models[i] & 65535);
		}

		return ready;
	}

	@ObfuscatedName("YMYTDPVW.a()V")
	public final void reset() {
		this.models = null;
		this.shapes = null;
		this.name = "null";
		this.desc = null;
		this.recol_s = null;
		this.recol_d = null;
		this.width = 1;
		this.length = 1;
		this.blockwalk = true;
		this.blockrange = true;
		this.active = false;
		this.hillskew = false;
		this.sharelight = false;
		this.occlude = false;
		this.anim = -1;
		this.wallwidth = 16;
		this.ambient = 0;
		this.contrast = 0;
		this.op = null;
		this.mapfunction = -1;
		this.mapscene = -1;
		this.mirror = false;
		this.shadow = true;
		this.resizex = 128;
		this.resizey = 128;
		this.resizez = 128;
		this.forceapproach = 0;
		this.offsetx = 0;
		this.offsety = 0;
		this.offsetz = 0;
		this.forcedecor = false;
		this.breakroutefinding = false;
		this.raiseobject = -1;
		this.multivarbit = -1;
		this.multivarp = -1;
		this.multiloc = null;
	}

	@ObfuscatedName("YMYTDPVW.a(BLMFMVIYHT;)V")
	public final void decode(Packet buf) {
		int active = -1;

		while (true) {

			int code = buf.g1();
			if (code == 0) {
				if (active == -1) {
					this.active = false;
					if (this.models != null && (this.shapes == null || this.shapes[0] == 10)) {
						this.active = true;
					}

					if (this.op != null) {
						this.active = true;
					}
				}

				if (this.breakroutefinding) {
					this.blockwalk = false;
					this.blockrange = false;
				}

				if (this.raiseobject == -1) {
					this.raiseobject = this.blockwalk ? 1 : 0;
					return;
				}

				return;
			}

			if (code == 1) {
				int count = buf.g1();
				if (this.models != null && !lowMemory) {
					buf.pos += count * 3;
				} else {
					this.shapes = new int[count];
					this.models = new int[count];

					for (int i = 0; i < count; ++i) {
						this.models[i] = buf.g2();
						this.shapes[i] = buf.g1();
					}
				}
			}

			if (code == 2) {
				this.name = buf.gjstr();
			} else if (code == 3) {
				this.desc = buf.gjstrraw();
			} else if (code == 5) {
				int count = buf.g1();
				if (count > 0) {
					if (this.models != null && !lowMemory) {
						buf.pos += count * 2;
					} else {
						this.shapes = null;
						this.models = new int[count];

						for (int i = 0; i < count; ++i) {
							this.models[i] = buf.g2();
						}
					}
				}
			} else if (code == 14) {
				this.width = buf.g1();
			} else if (code == 15) {
				this.length = buf.g1();
			} else if (code == 17) {
				this.blockwalk = false;
			} else if (code == 18) {
				this.blockrange = false;
			} else if (code == 19) {
				active = buf.g1();
				if (active == 1) {
					this.active = true;
				}
			} else if (code == 21) {
				this.hillskew = true;
			} else if (code == 22) {
				this.sharelight = true;
			} else if (code == 23) {
				this.occlude = true;
			} else if (code == 24) {
				this.anim = buf.g2();
				if (this.anim == 65535) {
					this.anim = -1;
				}
			} else if (code == 28) {
				this.wallwidth = buf.g1();
			} else if (code == 29) {
				this.ambient = buf.g1b();
			} else if (code == 39) {
				this.contrast = buf.g1b();
			} else if (code >= 30 && code < 39) {
				if (this.op == null) {
					this.op = new String[5];
				}

				this.op[code - 30] = buf.gjstr();
				if (this.op[code - 30].equalsIgnoreCase("hidden")) {
					this.op[code - 30] = null;
				}
			} else if (code == 40) {
				int count = buf.g1();
				this.recol_s = new int[count];
				this.recol_d = new int[count];

				for (int i = 0; i < count; ++i) {
					this.recol_s[i] = buf.g2();
					this.recol_d[i] = buf.g2();
				}
			} else if (code == 60) {
				this.mapfunction = buf.g2();
			} else if (code == 62) {
				this.mirror = true;
			} else if (code == 64) {
				this.shadow = false;
			} else if (code == 65) {
				this.resizex = buf.g2();
			} else if (code == 66) {
				this.resizey = buf.g2();
			} else if (code == 67) {
				this.resizez = buf.g2();
			} else if (code == 68) {
				this.mapscene = buf.g2();
			} else if (code == 69) {
				this.forceapproach = buf.g1();
			} else if (code == 70) {
				this.offsetx = buf.gb2();
			} else if (code == 71) {
				this.offsety = buf.gb2();
			} else if (code == 72) {
				this.offsetz = buf.gb2();
			} else if (code == 73) {
				this.forcedecor = true;
			} else if (code == 74) {
				this.breakroutefinding = true;
			} else if (code == 75) {
				this.raiseobject = buf.g1();
			} else if (code == 77) {
				this.multivarbit = buf.g2();
				if (this.multivarbit == 65535) {
					this.multivarbit = -1;
				}

				this.multivarp = buf.g2();
				if (this.multivarp == 65535) {
					this.multivarp = -1;
				}

				int count = buf.g1();
				this.multiloc = new int[count + 1];
				for (int i = 0; i <= count; ++i) {
					this.multiloc[i] = buf.g2();
					if (this.multiloc[i] == 65535) {
						this.multiloc[i] = -1;
					}
				}
			}
		}
	}

	@ObfuscatedName("YMYTDPVW.a(IIIIIII)LLZYQDKJV;")
	public final Model a(int arg0, int arg1, int heightmapSW, int heightmapSE, int heightmapNE, int heightmapNW, int arg6) {
		Model model = this.getModel(arg1, arg6, 0, arg0);
		if (model == null) {
			return null;
		}

		if (this.hillskew || this.sharelight) {
			model = new Model(this.hillskew, this.sharelight, 0, model);
		}

		if (this.hillskew) {
			int groundY = (heightmapSW + heightmapSE + heightmapNE + heightmapNW) / 4;

			for (int i = 0; i < model.vertexCount; ++i) {
				int x = model.vertexX[i];
				int z = model.vertexZ[i];

				int heightS = (heightmapSE - heightmapSW) * (x + 64) / 128 + heightmapSW;
				int heightN = (heightmapNE - heightmapNW) * (x + 64) / 128 + heightmapNW;
				int y = (heightN - heightS) * (z + 64) / 128 + heightS;

				model.vertexY[i] += y - groundY;
			}

			model.calculateBoundsY(6);
		}

		return model;
	}

	@ObfuscatedName("YMYTDPVW.a(II)Z")
	public final boolean a(int arg0, int arg1) {
		if (this.shapes == null) {
			if (this.models == null) {
				return true;
			} else if (arg1 != 10) {
				return true;
			} else {

				boolean var3 = true;
				for (int i = 0; i < this.models.length; ++i) {
					var3 &= Model.isReady(this.models[i] & 65535);
				}

				return var3;
			}
		} else {
			for (int i = 0; i < this.shapes.length; ++i) {
				if (this.shapes[i] == arg1) {
					return Model.isReady(this.models[i] & 65535);
				}
			}

			return true;
		}
	}

	@ObfuscatedName("YMYTDPVW.a(Z)V")
	public static final void unload(boolean arg0) {
		modelCacheStatic = null;
		modelCacheDynamic = null;
		idx = null;
		cache = null;
		data = null;
	}
}
