package jagex2.config;

import deob.*;
import jagex2.client.Client;
import jagex2.dash3d.AnimFrame;
import jagex2.dash3d.Model;
import jagex2.datastruct.LruCache;
import jagex2.io.Jagfile;
import jagex2.io.Packet;

public class NpcType {
	@ObfuscatedName("SLDUQHOR.a")
	public int readyanim = -1;
	@ObfuscatedName("SLDUQHOR.c")
	public boolean c = true;
	@ObfuscatedName("SLDUQHOR.d")
	public int d = 932;
	@ObfuscatedName("SLDUQHOR.g")
	public int g = -1;
	@ObfuscatedName("SLDUQHOR.h")
	public long id = -1L;
	@ObfuscatedName("SLDUQHOR.j")
	public int resizev = 128;
	@ObfuscatedName("SLDUQHOR.k")
	public boolean active = true;
	@ObfuscatedName("SLDUQHOR.l")
	public int resizeh = 128;
	@ObfuscatedName("SLDUQHOR.m")
	public int walkanim_l = -1;
	@ObfuscatedName("SLDUQHOR.p")
	public boolean minimap = true;
	@ObfuscatedName("SLDUQHOR.q")
	public int q = -1;
	@ObfuscatedName("SLDUQHOR.r")
	public int headicon = -1;
	@ObfuscatedName("SLDUQHOR.s")
	public int visLevel = -1;
	@ObfuscatedName("SLDUQHOR.t")
	public int t = 7;
	@ObfuscatedName("SLDUQHOR.u")
	public int walkanim_r = -1;
	@ObfuscatedName("SLDUQHOR.v")
	public byte size = 1;
	@ObfuscatedName("SLDUQHOR.w")
	public int walkanim_b = -1;
	@ObfuscatedName("SLDUQHOR.x")
	public boolean alwaysontop = false;
	@ObfuscatedName("SLDUQHOR.y")
	public int walkanim = -1;
	@ObfuscatedName("SLDUQHOR.A")
	public boolean A = false;
	@ObfuscatedName("SLDUQHOR.B")
	public int B = -1;
	@ObfuscatedName("SLDUQHOR.E")
	public int turnspeed = 32;
	@ObfuscatedName("SLDUQHOR.F")
	public String name = "null";
	@ObfuscatedName("SLDUQHOR.H")
	public int multivarbit = -1;
	@ObfuscatedName("SLDUQHOR.M")
	public int multivarp = -1;
	@ObfuscatedName("SLDUQHOR.P")
	public boolean P = false;
	@ObfuscatedName("SLDUQHOR.o")
	public static LruCache modelCache = new LruCache(30);
	@ObfuscatedName("SLDUQHOR.G")
	public static byte G = 6;
	@ObfuscatedName("SLDUQHOR.C")
	public static int count;
	@ObfuscatedName("SLDUQHOR.L")
	public int contrast;
	@ObfuscatedName("SLDUQHOR.O")
	public static int cachePos;
	@ObfuscatedName("SLDUQHOR.Q")
	public int ambient;
	@ObfuscatedName("SLDUQHOR.K")
	public static Packet data;
	@ObfuscatedName("SLDUQHOR.i")
	public static Client i;
	@ObfuscatedName("SLDUQHOR.N")
	public byte[] desc;
	@ObfuscatedName("SLDUQHOR.D")
	public static int[] idx;
	@ObfuscatedName("SLDUQHOR.J")
	public int[] recol_d;
	@ObfuscatedName("SLDUQHOR.b")
	public int[] multinpc;
	@ObfuscatedName("SLDUQHOR.e")
	public int[] heads;
	@ObfuscatedName("SLDUQHOR.f")
	public int[] models;
	@ObfuscatedName("SLDUQHOR.n")
	public int[] recol_s;
	@ObfuscatedName("SLDUQHOR.I")
	public static NpcType[] cache;
	@ObfuscatedName("SLDUQHOR.z")
	public String[] op;

	@ObfuscatedName("SLDUQHOR.a(LATJMVOZR;)V")
	public static final void unpack(Jagfile config) {
		data = new Packet(config.read("npc.dat", null));
		Packet temp = new Packet(config.read("npc.idx", null));

		count = temp.g2();
		idx = new int[count];

		int pos = 2;
		for (int i = 0; i < count; ++i) {
			idx[i] = pos;
			pos += temp.g2();
		}

		cache = new NpcType[20];
		for (int i = 0; i < 20; ++i) {
			cache[i] = new NpcType();
		}
	}

	@ObfuscatedName("SLDUQHOR.a(Z)V")
	public static final void unload(boolean arg0) {
		modelCache = null;
		idx = null;
		cache = null;
		data = null;
	}

	@ObfuscatedName("SLDUQHOR.c(I)LSLDUQHOR;")
	public static final NpcType get(int id) {
		for (int i = 0; i < 20; ++i) {
			if ((long) id == cache[i].id) {
				return cache[i];
			}
		}

		cachePos = (cachePos + 1) % 20;

		NpcType npc = cache[cachePos] = new NpcType();
		data.pos = idx[id];
		npc.id = id;
		npc.decode(G, data);
		return npc;
	}

	@ObfuscatedName("SLDUQHOR.a(BLMFMVIYHT;)V")
	public final void decode(byte arg0, Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			if (code == 1) {
				int count = buf.g1();
				this.models = new int[count];

				for (int i = 0; i < count; ++i) {
					this.models[i] = buf.g2();
				}
			} else if (code == 2) {
				this.name = buf.gjstr();
			} else if (code == 3) {
				this.desc = buf.gjstrraw();
			} else if (code == 12) {
				this.size = buf.g1b();
			} else if (code == 13) {
				this.readyanim = buf.g2();
			} else if (code == 14) {
				this.walkanim = buf.g2();
			} else if (code == 17) {
				this.walkanim = buf.g2();
				this.walkanim_b = buf.g2();
				this.walkanim_r = buf.g2();
				this.walkanim_l = buf.g2();
			} else if (code >= 30 && code < 40) {
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
				int count = buf.g1();
				this.heads = new int[count];

				for (int i = 0; i < count; ++i) {
					this.heads[i] = buf.g2();
				}
			} else if (code == 90) {
				this.B = buf.g2();
			} else if (code == 91) {
				this.g = buf.g2();
			} else if (code == 92) {
				this.q = buf.g2();
			} else if (code == 93) {
				this.minimap = false;
			} else if (code == 95) {
				this.visLevel = buf.g2();
			} else if (code == 97) {
				this.resizeh = buf.g2();
			} else if (code == 98) {
				this.resizev = buf.g2();
			} else if (code == 99) {
				this.alwaysontop = true;
			} else if (code == 100) {
				this.ambient = buf.g1b();
			} else if (code == 101) {
				this.contrast = buf.g1b() * 5;
			} else if (code == 102) {
				this.headicon = buf.g2();
			} else if (code == 103) {
				this.turnspeed = buf.g2();
			} else if (code == 106) {
				this.multivarbit = buf.g2();
				if (this.multivarbit == 65535) {
					this.multivarbit = -1;
				}

				this.multivarp = buf.g2();
				if (this.multivarp == 65535) {
					this.multivarp = -1;
				}

				int count = buf.g1();
				this.multinpc = new int[count + 1];

				for (int i = 0; i <= count; ++i) {
					this.multinpc[i] = buf.g2();
					if (this.multinpc[i] == 65535) {
						this.multinpc[i] = -1;
					}
				}
			} else if (code == 107) {
				this.active = false;
			}
		}
	}

	@ObfuscatedName("SLDUQHOR.a(III[I)LLZYQDKJV;")
	public final Model getModel(int primaryTransformId, int secondaryTransformId, int[] seqMask) {
		if (this.multinpc != null) {
			NpcType npc = this.getMultiNpc();
			return npc == null ? null : npc.getModel(primaryTransformId, secondaryTransformId, seqMask);
		}

		Model model = (Model) modelCache.get(this.id);
		if (model == null) {
			boolean ready = false;
			for (int i = 0; i < this.models.length; ++i) {
				if (!Model.isReady(this.models[i])) {
					ready = true;
				}
			}

			if (ready) {
				return null;
			}

			Model[] models = new Model[this.models.length];
			for (int i = 0; i < this.models.length; ++i) {
				models[i] = Model.tryGet(this.models[i]);
			}

			if (models.length == 1) {
				model = models[0];
			} else {
				model = new Model(models.length, models);
			}

			if (this.recol_s != null) {
				for (int var11 = 0; var11 < this.recol_s.length; ++var11) {
					model.recolour(this.recol_s[var11], this.recol_d[var11]);
				}
			}

			model.createLabelReferences();
			model.calculateNormals(this.ambient + 64, this.contrast + 850, -30, -50, -30, true);
			modelCache.put(model, this.id);
		}

		Model tmp = Model.empty;
		tmp.a(AnimFrame.a(this.c, primaryTransformId) & AnimFrame.a(this.c, secondaryTransformId), model, 1244);

		if (primaryTransformId != -1 && secondaryTransformId != -1) {
			tmp.applyTransforms(primaryTransformId, secondaryTransformId, seqMask);
		} else if (primaryTransformId != -1) {
			tmp.applyTransform(primaryTransformId);
		}

		if (this.resizeh != 128 || this.resizev != 128) {
			tmp.scale(this.resizev, this.resizeh, 9, this.resizeh);
		}

		tmp.calculateBoundsCylinder();
		tmp.labelFaces = null;
		tmp.labelVertices = null;

		if (this.size == 1) {
			tmp.picking = true;
		}

		return tmp;
	}

	@ObfuscatedName("SLDUQHOR.a(I)LLZYQDKJV;")
	public final Model getHeadModel() {
		if (this.multinpc != null) {
			NpcType npc = this.getMultiNpc();
			return npc == null ? null : npc.getHeadModel();
		}

		if (this.heads == null) {
			return null;
		}

		boolean exists = false;
		for (int i = 0; i < this.heads.length; ++i) {
			if (!Model.isReady(this.heads[i])) {
				exists = true;
			}
		}

		if (exists) {
			return null;
		}

		Model[] models = new Model[this.heads.length];
		for (int i = 0; i < this.heads.length; ++i) {
			models[i] = Model.tryGet(this.heads[i]);
		}

		Model model;
		if (models.length == 1) {
			model = models[0];
		} else {
			model = new Model(models.length, models);
		}

		if (this.recol_s != null) {
			for (int i = 0; i < this.recol_s.length; ++i) {
				model.recolour(this.recol_s[i], this.recol_d[i]);
			}
		}

		return model;
	}

	@ObfuscatedName("SLDUQHOR.b(Z)LSLDUQHOR;")
	public final NpcType getMultiNpc() {
		int value = -1;
		if (this.multivarbit != -1) {
			VarbitType varbit = VarbitType.c[this.multivarbit];
			int var4 = varbit.e;
			int var5 = varbit.f;
			int var6 = varbit.g;
			int var7 = Client.Yh[var6 - var5];
			value = i.varps[var4] >> var5 & var7;
		} else if (this.multivarp != -1) {
			value = i.varps[this.multivarp];
		}

		return value >= 0 && value < this.multinpc.length && this.multinpc[value] != -1 ? get(this.multinpc[value]) : null;
	}

	@ObfuscatedName("SLDUQHOR.b(I)Z")
	public boolean isNotMulti() {
		if (this.multinpc == null) {
			return true;
		}

		int value = -1;
		if (this.multivarbit != -1) {
			VarbitType var3 = VarbitType.c[this.multivarbit];
			int var4 = var3.e;
			int var5 = var3.f;
			int var6 = var3.g;
			int var7 = Client.Yh[var6 - var5];
			value = i.varps[var4] >> var5 & var7;
		} else if (this.multivarp != -1) {
			value = i.varps[this.multivarp];
		}

		return value >= 0 && value < this.multinpc.length && this.multinpc[value] != -1;
	}
}
