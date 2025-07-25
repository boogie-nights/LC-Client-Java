package jagex2.config;

import deob.*;
import jagex2.client.Client;
import jagex2.dash3d.AnimFrame;
import jagex2.dash3d.Model;
import jagex2.datastruct.JString;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Pix24;
import jagex2.graphics.PixFont;
import jagex2.io.Jagfile;
import jagex2.io.Packet;

public class Component {
	@ObfuscatedName("EWIXBTLV.ib")
	public int ib = -68;
	@ObfuscatedName("EWIXBTLV.jb")
	public boolean jb = true;
	@ObfuscatedName("EWIXBTLV.K")
	public static int K = -1;
	@ObfuscatedName("EWIXBTLV.T")
	public static int T = -1;
	@ObfuscatedName("EWIXBTLV.cb")
	public static LruCache modelCache = new LruCache(30);
	@ObfuscatedName("EWIXBTLV.nb")
	public static int nb = -291;
	@ObfuscatedName("EWIXBTLV.pb")
	public static int pb = -1;
	@ObfuscatedName("EWIXBTLV.qb")
	public static boolean qb = true;
	@ObfuscatedName("EWIXBTLV.rb")
	public static int rb = 373;
	@ObfuscatedName("EWIXBTLV.k")
	public byte alpha;
	@ObfuscatedName("EWIXBTLV.A")
	public int type;
	@ObfuscatedName("EWIXBTLV.Bb")
	public int buttonType;
	@ObfuscatedName("EWIXBTLV.C")
	public int width;
	@ObfuscatedName("EWIXBTLV.E")
	public int colour;
	@ObfuscatedName("EWIXBTLV.F")
	public int height;
	@ObfuscatedName("EWIXBTLV.G")
	public int clientCode;
	@ObfuscatedName("EWIXBTLV.H")
	public static int H;
	@ObfuscatedName("EWIXBTLV.I")
	public int marginY;
	@ObfuscatedName("EWIXBTLV.M")
	public int layer;
	@ObfuscatedName("EWIXBTLV.P")
	public int zoom;
	@ObfuscatedName("EWIXBTLV.Q")
	public int xan;
	@ObfuscatedName("EWIXBTLV.R")
	public int yan;
	@ObfuscatedName("EWIXBTLV.S")
	public int overlayer;
	@ObfuscatedName("EWIXBTLV.X")
	public int X;
	@ObfuscatedName("EWIXBTLV.Y")
	public int activeColour;
	@ObfuscatedName("EWIXBTLV.Z")
	public int overColour;
	@ObfuscatedName("EWIXBTLV.a")
	public static int a;
	@ObfuscatedName("EWIXBTLV.bb")
	public int marginX;
	@ObfuscatedName("EWIXBTLV.eb")
	public int activeModelType;
	@ObfuscatedName("EWIXBTLV.f")
	public int id;
	@ObfuscatedName("EWIXBTLV.fb")
	public int activeModel;
	@ObfuscatedName("EWIXBTLV.i")
	public int i;
	@ObfuscatedName("EWIXBTLV.m")
	public int targetMask;
	@ObfuscatedName("EWIXBTLV.p")
	public int p;
	@ObfuscatedName("EWIXBTLV.q")
	public int q;
	@ObfuscatedName("EWIXBTLV.r")
	public int r;
	@ObfuscatedName("EWIXBTLV.s")
	public int s;
	@ObfuscatedName("EWIXBTLV.sb")
	public static int sb;
	@ObfuscatedName("EWIXBTLV.v")
	public int scrollPosition;
	@ObfuscatedName("EWIXBTLV.vb")
	public int modelType;
	@ObfuscatedName("EWIXBTLV.wb")
	public int model;
	@ObfuscatedName("EWIXBTLV.xb")
	public int scroll;
	@ObfuscatedName("EWIXBTLV.yb")
	public int anim;
	@ObfuscatedName("EWIXBTLV.z")
	public int z;
	@ObfuscatedName("EWIXBTLV.zb")
	public int activeAnim;
	@ObfuscatedName("EWIXBTLV.e")
	public static Jagfile e;
	@ObfuscatedName("EWIXBTLV.J")
	public Pix24 activeGraphic;
	@ObfuscatedName("EWIXBTLV.c")
	public Pix24 graphic;
	@ObfuscatedName("EWIXBTLV.B")
	public PixFont font;
	@ObfuscatedName("EWIXBTLV.O")
	public static LruCache imageCache;
	@ObfuscatedName("EWIXBTLV.N")
	public String activeText;
	@ObfuscatedName("EWIXBTLV.b")
	public String targetText;
	@ObfuscatedName("EWIXBTLV.gb")
	public String option;
	@ObfuscatedName("EWIXBTLV.tb")
	public String targetVerb;
	@ObfuscatedName("EWIXBTLV.u")
	public String text;
	@ObfuscatedName("EWIXBTLV.Ab")
	public boolean usable;
	@ObfuscatedName("EWIXBTLV.D")
	public boolean fill;
	@ObfuscatedName("EWIXBTLV.L")
	public boolean shadowed;
	@ObfuscatedName("EWIXBTLV.V")
	public static boolean V;
	@ObfuscatedName("EWIXBTLV.h")
	public boolean h;
	@ObfuscatedName("EWIXBTLV.j")
	public boolean hide;
	@ObfuscatedName("EWIXBTLV.kb")
	public boolean center;
	@ObfuscatedName("EWIXBTLV.mb")
	public boolean draggable;
	@ObfuscatedName("EWIXBTLV.t")
	public boolean interactable;
	@ObfuscatedName("EWIXBTLV.x")
	public boolean x;
	@ObfuscatedName("EWIXBTLV.U")
	public int[] scriptOperand;
	@ObfuscatedName("EWIXBTLV.W")
	public int[] children;
	@ObfuscatedName("EWIXBTLV.d")
	public int[] invSlotOffsetY;
	@ObfuscatedName("EWIXBTLV.hb")
	public int[] invSlotObjId;
	@ObfuscatedName("EWIXBTLV.l")
	public int[] invSlotOffsetX;
	@ObfuscatedName("EWIXBTLV.lb")
	public int[] scriptComparator;
	@ObfuscatedName("EWIXBTLV.o")
	public int[] invSlotObjCount;
	@ObfuscatedName("EWIXBTLV.ob")
	public int[] childY;
	@ObfuscatedName("EWIXBTLV.w")
	public int[] childX;
	@ObfuscatedName("EWIXBTLV.db")
	public Pix24[] invSlotGraphic;
	@ObfuscatedName("EWIXBTLV.g")
	public static Component[] g;
	@ObfuscatedName("EWIXBTLV.n")
	public static PixFont[] fonts;
	@ObfuscatedName("EWIXBTLV.ab")
	public String[] iop;
	@ObfuscatedName("EWIXBTLV.ub")
	public static byte[][] ub;
	@ObfuscatedName("EWIXBTLV.y")
	public int[][] scripts;

	@ObfuscatedName("EWIXBTLV.a(ILjava/lang/String;I)LEPQDEJTO;")
	public static Pix24 getImage(int arg0, String arg1, int arg2) {
		long var3 = (JString.hashCode(arg1) << 8) + (long) arg0;
		if (arg2 <= 0) {
			nb = -317;
		}

		Pix24 var5 = (Pix24) imageCache.get(var3);
		if (var5 != null) {
			return var5;
		} else if (e == null) {
			return null;
		} else {
			try {
				Pix24 var6 = new Pix24(e, arg1, arg0);
				imageCache.put(var6, var3);
				return var6;
			} catch (Exception var7) {
				return null;
			}
		}
	}

	@ObfuscatedName("EWIXBTLV.a(I)LEWIXBTLV;")
	public static Component types(int arg0) {
		if (g[arg0] == null) {
			Packet var1 = new Packet(ub[arg0]);
			int var2 = var1.g2();
			g[arg0] = a(var2, (Packet) var1, 10896, arg0);
		}

		return g[arg0];
	}

	@ObfuscatedName("EWIXBTLV.a(III)V")
	public void swapObj(int src, int dst) {
		int tmp = this.invSlotObjId[src];
		this.invSlotObjId[src] = this.invSlotObjId[dst];
		this.invSlotObjId[dst] = tmp;

		int tmpCount = this.invSlotObjCount[src];
		this.invSlotObjCount[src] = this.invSlotObjCount[dst];
		this.invSlotObjCount[dst] = tmpCount;
	}

	@ObfuscatedName("EWIXBTLV.a(II)LLZYQDKJV;")
	public Model loadModel(int type, int id) {
		ObjType obj = null;
		if (type == 4) {
			obj = ObjType.get(id);
			sb += obj.ambient;
			H += obj.contrast;
		}

		Model model = (Model) modelCache.get((type << 16) + id);
		if (model != null) {
			return model;
		}

		if (type == 1) {
			model = Model.tryGet(id);
		}

		if (type == 2) {
			model = NpcType.get(id).getHeadModel(858);
		}

		if (type == 3) {
			model = Client.localPlayer.getHeadModel(true);
		}

		if (type == 4) {
			model = obj.getInvModel(this.ib, 50);
		}

		if (type == 5) {
			model = null;
		}

		if (model != null) {
			modelCache.put(model, (long) ((type << 16) + id));
		}

		return model;
	}

	@ObfuscatedName("EWIXBTLV.a(ILMFMVIYHT;II)LEWIXBTLV;")
	public static Component a(int layer, Packet data, int arg2, int id) {
		Component com = new Component();
		com.id = id;
		com.layer = layer;
		com.type = data.g1();
		com.buttonType = data.g1();
		com.clientCode = data.g2();
		com.height = data.g2();
		com.width = data.g2();
		com.alpha = (byte) data.g1();

		com.overlayer = data.g1();
		if (com.overlayer != 0) {
			com.overlayer = (com.overlayer - 1 << 8) + data.g1();
		} else {
			com.overlayer = -1;
		}

		if (com.clientCode == 600) {
			K = layer;
		}

		if (com.clientCode == 650) {
			T = layer;
		}

		if (com.clientCode == 655) {
			pb = layer;
		}

		int comparatorCount = data.g1();
		if (comparatorCount > 0) {
			com.scriptComparator = new int[comparatorCount];
			com.scriptOperand = new int[comparatorCount];

			for (int i = 0; i < comparatorCount; ++i) {
				com.scriptComparator[i] = data.g1();
				com.scriptOperand[i] = data.g2();
			}
		}

		int scriptCount = data.g1();
		if (scriptCount > 0) {
			com.scripts = new int[scriptCount][];

			for (int i = 0; i < scriptCount; ++i) {
				int opcodeCount = data.g2();
				com.scripts[i] = new int[opcodeCount];

				for (int j = 0; j < opcodeCount; ++j) {
					com.scripts[i][j] = data.g2();
				}
			}
		}

		if (com.type == 0) {
			com.scroll = data.g2();
			com.hide = data.g1() == 1;

			int childCount = data.g2();
			com.children = new int[childCount];
			com.childX = new int[childCount];
			com.childY = new int[childCount];

			for (int i = 0; i < childCount; ++i) {
				com.children[i] = data.g2();
				com.childX[i] = data.gb2();
				com.childY[i] = data.gb2();
			}
		}

		if (com.type == 1) {
			com.p = data.g2();
			com.x = data.g1() == 1;
		}

		if (com.type == 2) {
			com.invSlotObjId = new int[com.height * com.width];
			com.invSlotObjCount = new int[com.height * com.width];

			com.draggable = data.g1() == 1;
			com.interactable = data.g1() == 1;
			com.usable = data.g1() == 1;
			com.h = data.g1() == 1;
			com.marginX = data.g1();
			com.marginY = data.g1();

			com.invSlotOffsetX = new int[20];
			com.invSlotOffsetY = new int[20];
			com.invSlotGraphic = new Pix24[20];

			for (int i = 0; i < 20; ++i) {
				int hasGraphic = data.g1();
				if (hasGraphic == 1) {
					com.invSlotOffsetX[i] = data.gb2();
					com.invSlotOffsetY[i] = data.gb2();

					String graphic = data.gjstr();
					if (graphic.length() > 0) {
						int var16 = graphic.lastIndexOf(",");
						com.invSlotGraphic[i] = getImage(Integer.parseInt(graphic.substring(var16 + 1)), graphic.substring(0, var16), 373);
					}
				}
			}

			com.iop = new String[5];
			for (int i = 0; i < 5; ++i) {
				com.iop[i] = data.gjstr();
				if (com.iop[i].length() == 0) {
					com.iop[i] = null;
				}
			}
		}

		if (com.type == 3) {
			com.fill = data.g1() == 1;
		}

		if (com.type == 4 || com.type == 1) {
			com.center = data.g1() == 1;
			int font = data.g1();
			if (fonts != null) {
				com.font = fonts[font];
			}
			com.shadowed = data.g1() == 1;
		}

		if (com.type == 4) {
			com.text = data.gjstr();
			com.activeText = data.gjstr();
		}

		if (com.type == 1 || com.type == 3 || com.type == 4) {
			com.colour = data.g4();
		}

		if (com.type == 3 || com.type == 4) {
			com.activeColour = data.g4();
			com.overColour = data.g4();
			com.q = data.g4();
		}

		if (com.type == 5) {
			String graphic = data.gjstr();
			if (graphic.length() > 0) {
				int spriteIndex = graphic.lastIndexOf(",");
				com.graphic = getImage(Integer.parseInt(graphic.substring(spriteIndex + 1)), graphic.substring(0, spriteIndex), 373);
			}

			String activeGraphic = data.gjstr();
			if (activeGraphic.length() > 0) {
				int spriteIndex = activeGraphic.lastIndexOf(",");
				com.activeGraphic = getImage(Integer.parseInt(activeGraphic.substring(spriteIndex + 1)), activeGraphic.substring(0, spriteIndex), 373);
			}
		}

		if (com.type == 6) {
			int model = data.g1();
			if (model != 0) {
				com.modelType = 1;
				com.model = (model - 1 << 8) + data.g1();
			}

			int activeModel = data.g1();
			if (activeModel != 0) {
				com.activeModelType = 1;
				com.activeModel = (activeModel - 1 << 8) + data.g1();
			}

			int anim = data.g1();
			if (anim != 0) {
				com.anim = (anim - 1 << 8) + data.g1();
			} else {
				com.anim = -1;
			}

			int activeAnim = data.g1();
			if (activeAnim != 0) {
				com.activeAnim = (activeAnim - 1 << 8) + data.g1();
			} else {
				com.activeAnim = -1;
			}

			com.zoom = data.g2();
			com.xan = data.g2();
			com.yan = data.g2();
		}

		if (com.type == 7) {
			com.invSlotObjId = new int[com.height * com.width];
			com.invSlotObjCount = new int[com.height * com.width];

			com.center = data.g1() == 1;
			int font = data.g1();
			if (fonts != null) {
				com.font = fonts[font];
			}

			com.shadowed = data.g1() == 1;
			com.colour = data.g4();
			com.marginX = data.gb2();
			com.marginY = data.gb2();
			com.interactable = data.g1() == 1;

			com.iop = new String[5];
			for (int i = 0; i < 5; ++i) {
				com.iop[i] = data.gjstr();
				if (com.iop[i].length() == 0) {
					com.iop[i] = null;
				}
			}
		}

		if (com.type == 8) {
			com.text = data.gjstr();
		}

		if (com.buttonType == 2 || com.type == 2) {
			com.targetVerb = data.gjstr();
			com.targetText = data.gjstr();
			com.targetMask = data.g2();
		}

		if (com.buttonType == 1 || com.buttonType == 4 || com.buttonType == 5 || com.buttonType == 6) {
			com.option = data.gjstr();

			if (com.option.length() == 0) {
				if (com.buttonType == 1) {
					com.option = "Ok";
				}

				if (com.buttonType == 4) {
					com.option = "Select";
				}

				if (com.buttonType == 5) {
					com.option = "Select";
				}

				if (com.buttonType == 6) {
					com.option = "Continue";
				}
			}
		}

		return com;
	}

	@ObfuscatedName("EWIXBTLV.a(I[LJDPYRDAS;LATJMVOZR;LATJMVOZR;)V")
	public static void unpack(Jagfile interfaces, Jagfile arg3, PixFont[] fonts, int arg0) {
		imageCache = new LruCache(50000);
		e = arg3;
		Component.fonts = fonts;
		int layer = -1;

		Packet data = new Packet(interfaces.read("data", null));
		int total = data.g2();
		g = new Component[total];
		ub = new byte[total][];

		while (data.pos < data.data.length) {
			int id = data.g2();
			if (id == 65535) {
				layer = data.g2();
				id = data.g2();
			}

			int var8 = data.pos;
			Component com = a(layer, (Packet) data, 10896, id);
			byte[] var10 = ub[com.id] = new byte[data.pos - var8 + 2];

			for (int i = var8; i < data.pos; ++i) {
				var10[i - var8 + 2] = data.data[i];
			}

			var10[0] = (byte) (layer >> 8);
			var10[1] = (byte) layer;
		}

		e = null;
	}

	@ObfuscatedName("EWIXBTLV.a(ZI)V")
	public static void a(boolean arg0, int arg1) {
		if (arg1 != -1) {
			for (int var2 = 0; var2 < g.length; ++var2) {
				if (g[var2] != null && g[var2].layer == arg1 && g[var2].type != 2) {
					g[var2] = null;
				}
			}
		}
	}

	@ObfuscatedName("EWIXBTLV.a(ILLZYQDKJV;II)V")
	public static void cacheModel(Model model, int id, int type) {
		modelCache.clear();

		if (model != null && type != 4) {
			modelCache.put(model, (type << 16) + id);
		}
	}

	@ObfuscatedName("EWIXBTLV.a(Z)V")
	public static void clear() {
		g = null;
		e = null;
		imageCache = null;
		fonts = null;
		ub = null;
	}

	@ObfuscatedName("EWIXBTLV.a(IIIZ)LLZYQDKJV;")
	public Model getModel(int primaryTransformId, int secondaryTransformId, int arg2, boolean active) {
		sb = 64;
		H = 768;
		Model model;
		if (active) {
			model = this.loadModel(this.activeModelType, this.activeModel);
		} else {
			model = this.loadModel(this.modelType, this.model);
		}

		if (model == null) {
			return null;
		} else if (primaryTransformId == -1 && secondaryTransformId == -1 && model.faceColour == null) {
			return model;
		} else {
			model = new Model(false, false, true, model, AnimFrame.a(this.jb, primaryTransformId) & AnimFrame.a(this.jb, secondaryTransformId));

			if (primaryTransformId != -1 || secondaryTransformId != -1) {
				model.createLabelReferences(7);
			}

			if (primaryTransformId != -1) {
				model.applyTransform(primaryTransformId, (byte) 6);
			}

			if (secondaryTransformId != -1) {
				model.applyTransform(secondaryTransformId, (byte) 6);
			}

			model.calculateNormals(sb, H, -50, -10, -50, true);
			return model;
		}
	}
}
