package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.graphics.Pix2D;
import jagex2.graphics.Pix3D;
import jagex2.io.OnDemandProvider;
import jagex2.io.Packet;

public class Model extends ModelSource {
	@ObfuscatedName("LZYQDKJV.m")
	public int m = 932;
	@ObfuscatedName("LZYQDKJV.n")
	public int n = 426;
	@ObfuscatedName("LZYQDKJV.o")
	public boolean o = false;
	@ObfuscatedName("LZYQDKJV.p")
	public boolean p = true;
	@ObfuscatedName("LZYQDKJV.q")
	public int q = -252;
	@ObfuscatedName("LZYQDKJV.r")
	public boolean r = false;
	@ObfuscatedName("LZYQDKJV.eb")
	public boolean picking = false;
	@ObfuscatedName("LZYQDKJV.y")
	public int y;
	@ObfuscatedName("LZYQDKJV.C")
	public int C;
	@ObfuscatedName("LZYQDKJV.O")
	public int O;
	@ObfuscatedName("LZYQDKJV.z")
	public int[] z;
	@ObfuscatedName("LZYQDKJV.A")
	public int[] A;
	@ObfuscatedName("LZYQDKJV.B")
	public int[] B;
	@ObfuscatedName("LZYQDKJV.D")
	public int[] D;
	@ObfuscatedName("LZYQDKJV.E")
	public int[] E;
	@ObfuscatedName("LZYQDKJV.F")
	public int[] F;
	@ObfuscatedName("LZYQDKJV.P")
	public int[] P;
	@ObfuscatedName("LZYQDKJV.Q")
	public int[] Q;
	@ObfuscatedName("LZYQDKJV.R")
	public int[] R;
	@ObfuscatedName("LZYQDKJV.ab")
	public int[] ab;
	@ObfuscatedName("LZYQDKJV.J")
	public int[] J;
	@ObfuscatedName("LZYQDKJV.K")
	public int[] K;
	@ObfuscatedName("LZYQDKJV.N")
	public int N;
	@ObfuscatedName("LZYQDKJV.L")
	public int[] L;
	@ObfuscatedName("LZYQDKJV.bb")
	public int[] bb;
	@ObfuscatedName("LZYQDKJV.M")
	public int[] faceColour;
	@ObfuscatedName("LZYQDKJV.G")
	public int[] G;
	@ObfuscatedName("LZYQDKJV.H")
	public int[] H;
	@ObfuscatedName("LZYQDKJV.I")
	public int[] I;
	@ObfuscatedName("LZYQDKJV.fb")
	public VertexNormal[] fb;
	@ObfuscatedName("LZYQDKJV.W")
	public int W;
	@ObfuscatedName("LZYQDKJV.V")
	public int V;
	@ObfuscatedName("LZYQDKJV.Y")
	public int Y;
	@ObfuscatedName("LZYQDKJV.X")
	public int X;
	@ObfuscatedName("LZYQDKJV.T")
	public int T;
	@ObfuscatedName("LZYQDKJV.U")
	public int U;
	@ObfuscatedName("LZYQDKJV.S")
	public int S;
	@ObfuscatedName("LZYQDKJV.t")
	public static Model t = new Model(852);
	@ObfuscatedName("LZYQDKJV.u")
	public static int[] u = new int[2000];
	@ObfuscatedName("LZYQDKJV.v")
	public static int[] v = new int[2000];
	@ObfuscatedName("LZYQDKJV.w")
	public static int[] w = new int[2000];
	@ObfuscatedName("LZYQDKJV.x")
	public static int[] x = new int[2000];
	@ObfuscatedName("LZYQDKJV.ib")
	public static boolean[] ib = new boolean[4096];
	@ObfuscatedName("LZYQDKJV.jb")
	public static boolean[] jb = new boolean[4096];
	@ObfuscatedName("LZYQDKJV.kb")
	public static int[] kb = new int[4096];
	@ObfuscatedName("LZYQDKJV.lb")
	public static int[] lb = new int[4096];
	@ObfuscatedName("LZYQDKJV.mb")
	public static int[] mb = new int[4096];
	@ObfuscatedName("LZYQDKJV.nb")
	public static int[] nb = new int[4096];
	@ObfuscatedName("LZYQDKJV.ob")
	public static int[] ob = new int[4096];
	@ObfuscatedName("LZYQDKJV.pb")
	public static int[] pb = new int[4096];
	@ObfuscatedName("LZYQDKJV.qb")
	public static int[] qb = new int[1500];
	@ObfuscatedName("LZYQDKJV.rb")
	public static int[][] rb = new int[1500][512];
	@ObfuscatedName("LZYQDKJV.sb")
	public static int[] sb = new int[12];
	@ObfuscatedName("LZYQDKJV.tb")
	public static int[][] tb = new int[12][2000];
	@ObfuscatedName("LZYQDKJV.ub")
	public static int[] ub = new int[2000];
	@ObfuscatedName("LZYQDKJV.vb")
	public static int[] vb = new int[2000];
	@ObfuscatedName("LZYQDKJV.wb")
	public static int[] wb = new int[12];
	@ObfuscatedName("LZYQDKJV.xb")
	public static int[] xb = new int[10];
	@ObfuscatedName("LZYQDKJV.yb")
	public static int[] yb = new int[10];
	@ObfuscatedName("LZYQDKJV.zb")
	public static int[] zb = new int[10];
	@ObfuscatedName("LZYQDKJV.Hb")
	public static int[] pickedBitsets = new int[1000];
	@ObfuscatedName("LZYQDKJV.Ib")
	public static int[] Ib = Pix3D.sinTable;
	@ObfuscatedName("LZYQDKJV.Jb")
	public static int[] Jb = Pix3D.cosTable;
	@ObfuscatedName("LZYQDKJV.Kb")
	public static int[] Kb = Pix3D.U;
	@ObfuscatedName("LZYQDKJV.Lb")
	public static int[] Lb = Pix3D.H;
	@ObfuscatedName("LZYQDKJV.Ab")
	public static int Ab;
	@ObfuscatedName("LZYQDKJV.Bb")
	public static int Bb;
	@ObfuscatedName("LZYQDKJV.Cb")
	public static int Cb;
	@ObfuscatedName("LZYQDKJV.Eb")
	public static int Eb;
	@ObfuscatedName("LZYQDKJV.Fb")
	public static int Fb;
	@ObfuscatedName("LZYQDKJV.Gb")
	public static int Gb;
	@ObfuscatedName("LZYQDKJV.Z")
	public int Z;
	@ObfuscatedName("LZYQDKJV.s")
	public static int s;
	@ObfuscatedName("LZYQDKJV.hb")
	public static OnDemandProvider hb;
	@ObfuscatedName("LZYQDKJV.Db")
	public static boolean Db;
	@ObfuscatedName("LZYQDKJV.gb")
	public static Metadata[] gb;
	@ObfuscatedName("LZYQDKJV.cb")
	public int[][] cb;
	@ObfuscatedName("LZYQDKJV.db")
	public int[][] db;

	@ObfuscatedName("LZYQDKJV.a(Z)V")
	public static void a(boolean arg0) {
		gb = null;
		ib = null;
		jb = null;
		kb = null;
		lb = null;
		mb = null;
		nb = null;
		ob = null;
		pb = null;
		qb = null;
		rb = null;
		sb = null;
		tb = null;
		ub = null;
		vb = null;
		wb = null;
		Ib = null;
		Jb = null;
		Kb = null;
		if (!arg0) {
			Lb = null;
		}
	}

	@ObfuscatedName("LZYQDKJV.a(ILQUWTPUDC;)V")
	public static void a(int arg0, OnDemandProvider arg1) {
		gb = new Metadata[arg0];
		hb = arg1;
	}

	@ObfuscatedName("LZYQDKJV.a([BIB)V")
	public static void unpack(byte[] arg0, int arg1, byte arg2) {
		if (arg2 == 7) {
			if (arg0 == null) {
				Metadata var3 = gb[arg1] = new Metadata();
				var3.b = 0;
				var3.c = 0;
				var3.d = 0;
			} else {
				Packet var4 = new Packet(arg0);
				var4.pos = arg0.length - 18;
				Metadata var5 = gb[arg1] = new Metadata();
				var5.a = arg0;
				var5.b = var4.g2();
				var5.c = var4.g2();
				var5.d = var4.g1();
				int var6 = var4.g1();
				int var7 = var4.g1();
				int var8 = var4.g1();
				int var9 = var4.g1();
				int var10 = var4.g1();
				int var11 = var4.g2();
				int var12 = var4.g2();
				int var13 = var4.g2();
				int var14 = var4.g2();
				byte var15 = 0;
				var5.e = var15;
				int var16 = var5.b + var15;
				var5.k = var16;
				int var17 = var5.c + var16;
				var5.n = var17;
				if (var7 == 255) {
					var17 += var5.c;
				} else {
					var5.n = -var7 - 1;
				}

				var5.p = var17;
				if (var9 == 1) {
					var17 += var5.c;
				} else {
					var5.p = -1;
				}

				var5.m = var17;
				if (var6 == 1) {
					var17 += var5.c;
				} else {
					var5.m = -1;
				}

				var5.i = var17;
				if (var10 == 1) {
					var17 += var5.b;
				} else {
					var5.i = -1;
				}

				var5.o = var17;
				if (var8 == 1) {
					var17 += var5.c;
				} else {
					var5.o = -1;
				}

				var5.j = var17;
				int var18 = var14 + var17;
				var5.l = var18;
				int var19 = var5.c * 2 + var18;
				var5.q = var19;
				int var20 = var5.d * 6 + var19;
				var5.f = var20;
				int var21 = var11 + var20;
				var5.g = var21;
				int var22 = var12 + var21;
				var5.h = var22;
				int var10000 = var13 + var22;
			}
		}
	}

	@ObfuscatedName("LZYQDKJV.a(II)V")
	public static void a(int arg0, int arg1) {
		if (arg1 == 1) {
			gb[arg0] = null;
		}
	}

	@ObfuscatedName("LZYQDKJV.a(I)LLZYQDKJV;")
	public static Model tryGet(int arg0) {
		if (gb == null) {
			return null;
		} else {
			Metadata var1 = gb[arg0];
			if (var1 == null) {
				hb.requestModel(arg0);
				return null;
			} else {
				return new Model(arg0, -478);
			}
		}
	}

	@ObfuscatedName("LZYQDKJV.b(I)Z")
	public static boolean isReady(int arg0) {
		if (gb == null) {
			return false;
		} else {
			Metadata var1 = gb[arg0];
			if (var1 == null) {
				hb.requestModel(arg0);
				return false;
			} else {
				return true;
			}
		}
	}

	public Model(int arg0) {
		if (arg0 <= 0) {
			this.q = -110;
		}
	}

	public Model(int arg0, int arg1) {
		++s;
		Metadata var3 = gb[arg0];
		this.y = var3.b;
		this.C = var3.c;
		this.O = var3.d;
		this.z = new int[this.y];
		this.A = new int[this.y];
		this.B = new int[this.y];
		this.D = new int[this.C];
		this.E = new int[this.C];
		this.F = new int[this.C];
		this.P = new int[this.O];
		this.Q = new int[this.O];
		this.R = new int[this.O];
		if (var3.i >= 0) {
			this.ab = new int[this.y];
		}

		if (var3.m >= 0) {
			this.J = new int[this.C];
		}

		if (var3.n >= 0) {
			this.K = new int[this.C];
		} else {
			this.N = -var3.n - 1;
		}

		if (var3.o >= 0) {
			this.L = new int[this.C];
		}

		if (var3.p >= 0) {
			this.bb = new int[this.C];
		}

		this.faceColour = new int[this.C];
		Packet var4 = new Packet(var3.a);
		var4.pos = var3.e;
		Packet var5 = new Packet(var3.a);
		var5.pos = var3.f;
		Packet var6 = new Packet(var3.a);
		var6.pos = var3.g;
		if (arg1 >= 0) {
			this.r = !this.r;
		}

		Packet var7 = new Packet(var3.a);
		var7.pos = var3.h;
		Packet var8 = new Packet(var3.a);
		var8.pos = var3.i;
		int var9 = 0;
		int var10 = 0;
		int var11 = 0;

		for (int var12 = 0; var12 < this.y; ++var12) {
			int var13 = var4.g1();
			int var14 = 0;
			if ((var13 & 1) != 0) {
				var14 = var5.gsmart();
			}

			int var15 = 0;
			if ((var13 & 2) != 0) {
				var15 = var6.gsmart();
			}

			int var16 = 0;
			if ((var13 & 4) != 0) {
				var16 = var7.gsmart();
			}

			this.z[var12] = var9 + var14;
			this.A[var12] = var10 + var15;
			this.B[var12] = var11 + var16;
			var9 = this.z[var12];
			var10 = this.A[var12];
			var11 = this.B[var12];
			if (this.ab != null) {
				this.ab[var12] = var8.g1();
			}
		}

		var4.pos = var3.l;
		var5.pos = var3.m;
		var6.pos = var3.n;
		var7.pos = var3.o;
		var8.pos = var3.p;

		for (int var17 = 0; var17 < this.C; ++var17) {
			this.faceColour[var17] = var4.g2();
			if (this.J != null) {
				this.J[var17] = var5.g1();
			}

			if (this.K != null) {
				this.K[var17] = var6.g1();
			}

			if (this.L != null) {
				this.L[var17] = var7.g1();
			}

			if (this.bb != null) {
				this.bb[var17] = var8.g1();
			}
		}

		var4.pos = var3.j;
		var5.pos = var3.k;
		int var18 = 0;
		int var19 = 0;
		int var20 = 0;
		int var21 = 0;

		for (int var22 = 0; var22 < this.C; ++var22) {
			int var23 = var5.g1();
			if (var23 == 1) {
				var18 = var4.gsmart() + var21;
				var19 = var4.gsmart() + var18;
				var20 = var4.gsmart() + var19;
				var21 = var20;
				this.D[var22] = var18;
				this.E[var22] = var19;
				this.F[var22] = var20;
			}

			if (var23 == 2) {
				var18 = var18;
				var19 = var20;
				var20 = var4.gsmart() + var21;
				var21 = var20;
				this.D[var22] = var18;
				this.E[var22] = var19;
				this.F[var22] = var20;
			}

			if (var23 == 3) {
				var18 = var20;
				var19 = var19;
				var20 = var4.gsmart() + var21;
				var21 = var20;
				this.D[var22] = var18;
				this.E[var22] = var19;
				this.F[var22] = var20;
			}

			if (var23 == 4) {
				int var26 = var18;
				var18 = var19;
				var19 = var26;
				var20 = var4.gsmart() + var21;
				var21 = var20;
				this.D[var22] = var18;
				this.E[var22] = var26;
				this.F[var22] = var20;
			}
		}

		var4.pos = var3.q;

		for (int var27 = 0; var27 < this.O; ++var27) {
			this.P[var27] = var4.g2();
			this.Q[var27] = var4.g2();
			this.R[var27] = var4.g2();
		}

	}

	public Model(int arg0, Model[] arg1) {
		++s;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		boolean var7 = false;
		this.y = 0;
		this.C = 0;
		this.O = 0;
		this.N = -1;

		for (int var8 = 0; var8 < arg0; ++var8) {
			Model var9 = arg1[var8];
			if (var9 != null) {
				this.y += var9.y;
				this.C += var9.C;
				this.O += var9.O;
				var4 |= var9.J != null;
				if (var9.K != null) {
					var5 = true;
				} else {
					if (this.N == -1) {
						this.N = var9.N;
					}

					if (this.N != var9.N) {
						var5 = true;
					}
				}

				var6 |= var9.L != null;
				var7 |= var9.bb != null;
			}
		}

		this.z = new int[this.y];
		this.A = new int[this.y];
		this.B = new int[this.y];
		this.ab = new int[this.y];
		this.D = new int[this.C];
		this.E = new int[this.C];
		this.F = new int[this.C];
		this.P = new int[this.O];
		this.Q = new int[this.O];
		this.R = new int[this.O];

		if (var4) {
			this.J = new int[this.C];
		}

		if (var5) {
			this.K = new int[this.C];
		}

		if (var6) {
			this.L = new int[this.C];
		}

		if (var7) {
			this.bb = new int[this.C];
		}

		this.faceColour = new int[this.C];
		this.y = 0;
		this.C = 0;
		this.O = 0;
		int var10 = 0;

		for (int var11 = 0; var11 < arg0; ++var11) {
			Model var12 = arg1[var11];
			if (var12 != null) {
				for (int var13 = 0; var13 < var12.C; ++var13) {
					if (var4) {
						if (var12.J == null) {
							this.J[this.C] = 0;
						} else {
							int var14 = var12.J[var13];
							if ((var14 & 2) == 2) {
								var14 += var10 << 2;
							}

							this.J[this.C] = var14;
						}
					}

					if (var5) {
						if (var12.K == null) {
							this.K[this.C] = var12.N;
						} else {
							this.K[this.C] = var12.K[var13];
						}
					}

					if (var6) {
						if (var12.L == null) {
							this.L[this.C] = 0;
						} else {
							this.L[this.C] = var12.L[var13];
						}
					}

					if (var7 && var12.bb != null) {
						this.bb[this.C] = var12.bb[var13];
					}

					this.faceColour[this.C] = var12.faceColour[var13];
					this.D[this.C] = this.a(var12, var12.D[var13]);
					this.E[this.C] = this.a(var12, var12.E[var13]);
					this.F[this.C] = this.a(var12, var12.F[var13]);
					++this.C;
				}

				for (int var15 = 0; var15 < var12.O; ++var15) {
					this.P[this.O] = this.a(var12, var12.P[var15]);
					this.Q[this.O] = this.a(var12, var12.Q[var15]);
					this.R[this.O] = this.a(var12, var12.R[var15]);
					++this.O;
				}

				var10 += var12.O;
			}

		}
	}

	public Model(int arg0, boolean arg1, int arg2, Model[] arg3) {
		++s;
		boolean var5 = false;
		boolean var6 = false;
		boolean var7 = false;
		boolean var8 = false;
		this.y = 0;
		this.C = 0;
		this.O = 0;
		this.N = -1;

		for (int var9 = 0; var9 < arg0; ++var9) {
			Model var10 = arg3[var9];
			if (var10 != null) {
				this.y += var10.y;
				this.C += var10.C;
				this.O += var10.O;
				var5 |= var10.J != null;
				if (var10.K != null) {
					var6 = true;
				} else {
					if (this.N == -1) {
						this.N = var10.N;
					}

					if (this.N != var10.N) {
						var6 = true;
					}
				}

				var7 |= var10.L != null;
				var8 |= var10.faceColour != null;
			}
		}

		this.z = new int[this.y];
		this.A = new int[this.y];
		this.B = new int[this.y];
		this.D = new int[this.C];
		this.E = new int[this.C];
		this.F = new int[this.C];
		this.G = new int[this.C];
		this.H = new int[this.C];
		this.I = new int[this.C];
		this.P = new int[this.O];
		this.Q = new int[this.O];
		this.R = new int[this.O];
		if (var5) {
			this.J = new int[this.C];
		}

		if (var6) {
			this.K = new int[this.C];
		}

		if (var7) {
			this.L = new int[this.C];
		}

		if (var8) {
			this.faceColour = new int[this.C];
		}

		this.y = 0;
		if (arg2 != 0) {
			throw new NullPointerException();
		} else {
			this.C = 0;
			this.O = 0;
			int var11 = 0;

			for (int var12 = 0; var12 < arg0; ++var12) {
				Model var13 = arg3[var12];
				if (var13 != null) {
					int var14 = this.y;

					for (int var15 = 0; var15 < var13.y; ++var15) {
						this.z[this.y] = var13.z[var15];
						this.A[this.y] = var13.A[var15];
						this.B[this.y] = var13.B[var15];
						++this.y;
					}

					for (int var16 = 0; var16 < var13.C; ++var16) {
						this.D[this.C] = var13.D[var16] + var14;
						this.E[this.C] = var13.E[var16] + var14;
						this.F[this.C] = var13.F[var16] + var14;
						this.G[this.C] = var13.G[var16];
						this.H[this.C] = var13.H[var16];
						this.I[this.C] = var13.I[var16];
						if (var5) {
							if (var13.J == null) {
								this.J[this.C] = 0;
							} else {
								int var17 = var13.J[var16];
								if ((var17 & 2) == 2) {
									var17 += var11 << 2;
								}

								this.J[this.C] = var17;
							}
						}

						if (var6) {
							if (var13.K == null) {
								this.K[this.C] = var13.N;
							} else {
								this.K[this.C] = var13.K[var16];
							}
						}

						if (var7) {
							if (var13.L == null) {
								this.L[this.C] = 0;
							} else {
								this.L[this.C] = var13.L[var16];
							}
						}

						if (var8 && var13.faceColour != null) {
							this.faceColour[this.C] = var13.faceColour[var16];
						}

						++this.C;
					}

					for (int var18 = 0; var18 < var13.O; ++var18) {
						this.P[this.O] = var13.P[var18] + var14;
						this.Q[this.O] = var13.Q[var18] + var14;
						this.R[this.O] = var13.R[var18] + var14;
						++this.O;
					}

					var11 += var13.O;
				}
			}

			this.c(this.m);
		}
	}

	public Model(boolean arg0, boolean arg1, boolean arg2, Model arg3, boolean arg4) {
		++s;
		this.y = arg3.y;
		this.C = arg3.C;
		this.O = arg3.O;
		if (arg1) {
			this.q = 498;
		}

		if (arg0) {
			this.z = arg3.z;
			this.A = arg3.A;
			this.B = arg3.B;
		} else {
			this.z = new int[this.y];
			this.A = new int[this.y];
			this.B = new int[this.y];

			for (int var6 = 0; var6 < this.y; ++var6) {
				this.z[var6] = arg3.z[var6];
				this.A[var6] = arg3.A[var6];
				this.B[var6] = arg3.B[var6];
			}
		}

		if (arg2) {
			this.faceColour = arg3.faceColour;
		} else {
			this.faceColour = new int[this.C];

			for (int var7 = 0; var7 < this.C; ++var7) {
				this.faceColour[var7] = arg3.faceColour[var7];
			}
		}

		if (arg4) {
			this.L = arg3.L;
		} else {
			this.L = new int[this.C];
			if (arg3.L == null) {
				for (int var8 = 0; var8 < this.C; ++var8) {
					this.L[var8] = 0;
				}
			} else {
				for (int var9 = 0; var9 < this.C; ++var9) {
					this.L[var9] = arg3.L[var9];
				}
			}
		}

		this.ab = arg3.ab;
		this.bb = arg3.bb;
		this.J = arg3.J;
		this.D = arg3.D;
		this.E = arg3.E;
		this.F = arg3.F;
		this.K = arg3.K;
		this.N = arg3.N;
		this.P = arg3.P;
		this.Q = arg3.Q;
		this.R = arg3.R;
	}

	public Model(boolean arg0, boolean arg1, int arg2, Model arg3) {
		++s;
		this.y = arg3.y;
		this.C = arg3.C;
		this.O = arg3.O;
		if (arg0) {
			this.A = new int[this.y];

			for (int var5 = 0; var5 < this.y; ++var5) {
				this.A[var5] = arg3.A[var5];
			}
		} else {
			this.A = arg3.A;
		}

		if (arg1) {
			this.G = new int[this.C];
			this.H = new int[this.C];
			this.I = new int[this.C];

			for (int var6 = 0; var6 < this.C; ++var6) {
				this.G[var6] = arg3.G[var6];
				this.H[var6] = arg3.H[var6];
				this.I[var6] = arg3.I[var6];
			}

			this.J = new int[this.C];
			if (arg3.J == null) {
				for (int var7 = 0; var7 < this.C; ++var7) {
					this.J[var7] = 0;
				}
			} else {
				for (int var8 = 0; var8 < this.C; ++var8) {
					this.J[var8] = arg3.J[var8];
				}
			}

			super.j = new VertexNormal[this.y];

			for (int var9 = 0; var9 < this.y; ++var9) {
				VertexNormal var10 = super.j[var9] = new VertexNormal();
				VertexNormal var11 = arg3.j[var9];
				var10.a = var11.a;
				var10.b = var11.b;
				var10.c = var11.c;
				var10.d = var11.d;
			}

			this.fb = arg3.fb;
		} else {
			this.G = arg3.G;
			this.H = arg3.H;
			this.I = arg3.I;
			this.J = arg3.J;
		}

		this.z = arg3.z;
		this.B = arg3.B;
		if (arg2 != 0) {
			this.o = !this.o;
		}

		this.faceColour = arg3.faceColour;
		this.L = arg3.L;
		this.K = arg3.K;
		this.N = arg3.N;
		this.D = arg3.D;
		this.E = arg3.E;
		this.F = arg3.F;
		this.P = arg3.P;
		this.Q = arg3.Q;
		this.R = arg3.R;
		super.k = arg3.k;
		this.W = arg3.W;
		this.V = arg3.V;
		this.Y = arg3.Y;
		this.X = arg3.X;
		this.T = arg3.T;
		this.U = arg3.U;
		this.S = arg3.S;
	}

	@ObfuscatedName("LZYQDKJV.a(ZLLZYQDKJV;I)V")
	public void a(boolean arg0, Model arg1, int arg2) {
		this.y = arg1.y;
		this.C = arg1.C;
		this.O = arg1.O;
		if (u.length < this.y) {
			u = new int[this.y + 100];
			v = new int[this.y + 100];
			w = new int[this.y + 100];
		}

		this.z = u;
		this.A = v;
		if (arg2 == 1244) {
			this.B = w;

			for (int var4 = 0; var4 < this.y; ++var4) {
				this.z[var4] = arg1.z[var4];
				this.A[var4] = arg1.A[var4];
				this.B[var4] = arg1.B[var4];
			}

			if (arg0) {
				this.L = arg1.L;
			} else {
				if (x.length < this.C) {
					x = new int[this.C + 100];
				}

				this.L = x;
				if (arg1.L == null) {
					for (int var5 = 0; var5 < this.C; ++var5) {
						this.L[var5] = 0;
					}
				} else {
					for (int var6 = 0; var6 < this.C; ++var6) {
						this.L[var6] = arg1.L[var6];
					}
				}
			}

			this.J = arg1.J;
			this.faceColour = arg1.faceColour;
			this.K = arg1.K;
			this.N = arg1.N;
			this.db = arg1.db;
			this.cb = arg1.cb;
			this.D = arg1.D;
			this.E = arg1.E;
			this.F = arg1.F;
			this.G = arg1.G;
			this.H = arg1.H;
			this.I = arg1.I;
			this.P = arg1.P;
			this.Q = arg1.Q;
			this.R = arg1.R;
		}
	}

	@ObfuscatedName("LZYQDKJV.a(LLZYQDKJV;I)I")
	public final int a(Model arg0, int arg1) {
		int var3 = -1;
		int var4 = arg0.z[arg1];
		int var5 = arg0.A[arg1];
		int var6 = arg0.B[arg1];

		for (int var7 = 0; var7 < this.y; ++var7) {
			if (this.z[var7] == var4 && this.A[var7] == var5 && this.B[var7] == var6) {
				var3 = var7;
				break;
			}
		}

		if (var3 == -1) {
			this.z[this.y] = var4;
			this.A[this.y] = var5;
			this.B[this.y] = var6;
			if (arg0.ab != null) {
				this.ab[this.y] = arg0.ab[arg1];
			}

			var3 = this.y++;
		}

		return var3;
	}

	@ObfuscatedName("LZYQDKJV.c(I)V")
	public void c(int arg0) {
		super.k = 0;
		this.V = 0;
		this.W = 0;

		for (int var2 = 0; var2 < this.y; ++var2) {
			int var3 = this.z[var2];
			int var4 = this.A[var2];
			int var5 = this.B[var2];
			if (-var4 > super.k) {
				super.k = -var4;
			}

			if (var4 > this.W) {
				this.W = var4;
			}

			int var6 = var3 * var3 + var5 * var5;
			if (var6 > this.V) {
				this.V = var6;
			}
		}

		this.V = (int) (Math.sqrt((double) this.V) + 0.99D);
		this.Y = (int) (Math.sqrt((double) (super.k * super.k + this.V * this.V)) + 0.99D);
		int var7 = 64 / arg0;
		this.X = this.Y + (int) (Math.sqrt((double) (this.W * this.W + this.V * this.V)) + 0.99D);
	}

	@ObfuscatedName("LZYQDKJV.d(I)V")
	public void d(int arg0) {
		super.k = 0;
		if (arg0 == 6) {
			this.W = 0;

			for (int var2 = 0; var2 < this.y; ++var2) {
				int var3 = this.A[var2];
				if (-var3 > super.k) {
					super.k = -var3;
				}

				if (var3 > this.W) {
					this.W = var3;
				}
			}

			this.Y = (int) (Math.sqrt((double) (super.k * super.k + this.V * this.V)) + 0.99D);
			this.X = this.Y + (int) (Math.sqrt((double) (this.W * this.W + this.V * this.V)) + 0.99D);
		}
	}

	@ObfuscatedName("LZYQDKJV.e(I)V")
	public void e(int arg0) {
		super.k = 0;
		this.V = 0;
		this.W = 0;
		int var2 = 32767;
		int var3 = -32767;
		int var4 = -32767;
		int var5 = 32767;

		for (int var6 = 0; var6 < this.y; ++var6) {
			int var7 = this.z[var6];
			int var8 = this.A[var6];
			int var9 = this.B[var6];
			if (var7 < var2) {
				var2 = var7;
			}

			if (var7 > var3) {
				var3 = var7;
			}

			if (var9 < var5) {
				var5 = var9;
			}

			if (var9 > var4) {
				var4 = var9;
			}

			if (-var8 > super.k) {
				super.k = -var8;
			}

			if (var8 > this.W) {
				this.W = var8;
			}

			int var10 = var7 * var7 + var9 * var9;
			if (var10 > this.V) {
				this.V = var10;
			}
		}

		this.V = (int) Math.sqrt((double) this.V);
		this.Y = (int) Math.sqrt((double) (super.k * super.k + this.V * this.V));
		this.X = this.Y + (int) Math.sqrt((double) (this.W * this.W + this.V * this.V));
		this.T = (var2 << 16) + (var3 & 65535);
		if (arg0 <= 0) {
			this.n = 50;
		}

		this.U = (var4 << 16) + (var5 & 65535);
	}

	@ObfuscatedName("LZYQDKJV.f(I)V")
	public void createLabelReferences(int arg0) {
		if (arg0 == 7) {
			int var10002;
			if (this.ab != null) {
				int[] var2 = new int[256];
				int var3 = 0;

				for (int var4 = 0; var4 < this.y; ++var4) {
					int var5 = this.ab[var4];
					var10002 = var2[var5]++;
					if (var5 > var3) {
						var3 = var5;
					}
				}

				this.cb = new int[var3 + 1][];

				for (int var6 = 0; var6 <= var3; ++var6) {
					this.cb[var6] = new int[var2[var6]];
					var2[var6] = 0;
				}

				int var7 = 0;

				while (var7 < this.y) {
					int var8 = this.ab[var7];
					this.cb[var8][var2[var8]++] = var7++;
				}

				this.ab = null;
			}

			if (this.bb != null) {
				int[] var9 = new int[256];
				int var10 = 0;

				for (int var11 = 0; var11 < this.C; ++var11) {
					int var12 = this.bb[var11];
					var10002 = var9[var12]++;
					if (var12 > var10) {
						var10 = var12;
					}
				}

				this.db = new int[var10 + 1][];

				for (int var13 = 0; var13 <= var10; ++var13) {
					this.db[var13] = new int[var9[var13]];
					var9[var13] = 0;
				}

				int var14 = 0;

				while (var14 < this.C) {
					int var15 = this.bb[var14];
					this.db[var15][var9[var15]++] = var14++;
				}

				this.bb = null;
			}
		}
	}

	@ObfuscatedName("LZYQDKJV.a(IB)V")
	public void applyTransform(int arg0, byte arg1) {
		if (this.cb != null) {
			if (arg0 != -1) {
				AnimFrame var3 = AnimFrame.b(arg0);
				if (var3 != null) {
					AnimBase var4 = var3.e;
					if (arg1 == 6) {
						boolean var5 = false;
						Ab = 0;
						Bb = 0;
						Cb = 0;

						for (int var6 = 0; var6 < var3.f; ++var6) {
							int var7 = var3.g[var6];
							this.a(var4.b[var7], var4.c[var7], var3.h[var6], var3.i[var6], var3.j[var6]);
						}

					}
				}
			}
		}
	}

	@ObfuscatedName("LZYQDKJV.a(III[I)V")
	public void a(int arg0, int arg1, int arg2, int[] arg3) {
		if (arg2 != -1) {
			if (arg3 != null && arg0 != -1) {
				AnimFrame var5 = AnimFrame.b(arg2);
				if (var5 != null) {
					AnimFrame var6 = AnimFrame.b(arg0);
					if (var6 == null) {
						this.applyTransform(arg2, (byte) 6);
					} else {
						AnimBase var7 = var5.e;
						Ab = 0;
						if (arg1 != 0) {
							this.r = !this.r;
						}

						Bb = 0;
						Cb = 0;
						byte var8 = 0;
						int var16 = var8 + 1;
						int var9 = arg3[var8];

						for (int var10 = 0; var10 < var5.f; ++var10) {
							int var11 = var5.g[var10];

							while (var11 > var9) {
								var9 = arg3[var16++];
							}

							if (var9 != var11 || var7.b[var11] == 0) {
								this.a(var7.b[var11], var7.c[var11], var5.h[var10], var5.i[var10], var5.j[var10]);
							}
						}

						Ab = 0;
						Bb = 0;
						Cb = 0;
						byte var12 = 0;
						int var17 = var12 + 1;
						int var13 = arg3[var12];

						for (int var14 = 0; var14 < var6.f; ++var14) {
							int var15 = var6.g[var14];

							while (var15 > var13) {
								var13 = arg3[var17++];
							}

							if (var13 == var15 || var7.b[var15] == 0) {
								this.a(var7.b[var15], var7.c[var15], var6.h[var14], var6.i[var14], var6.j[var14]);
							}
						}

					}
				}
			} else {
				this.applyTransform(arg2, (byte) 6);
			}
		}
	}

	@ObfuscatedName("LZYQDKJV.a(I[IIII)V")
	public void a(int arg0, int[] arg1, int arg2, int arg3, int arg4) {
		int var6 = arg1.length;
		if (arg0 == 0) {
			int var7 = 0;
			Ab = 0;
			Bb = 0;
			Cb = 0;

			for (int var8 = 0; var8 < var6; ++var8) {
				int var9 = arg1[var8];
				if (var9 < this.cb.length) {
					int[] var10 = this.cb[var9];

					for (int var11 = 0; var11 < var10.length; ++var11) {
						int var12 = var10[var11];
						Ab += this.z[var12];
						Bb += this.A[var12];
						Cb += this.B[var12];
						++var7;
					}
				}
			}

			if (var7 > 0) {
				Ab = Ab / var7 + arg2;
				Bb = Bb / var7 + arg3;
				Cb = Cb / var7 + arg4;
			} else {
				Ab = arg2;
				Bb = arg3;
				Cb = arg4;
			}
		} else if (arg0 == 1) {
			for (int var13 = 0; var13 < var6; ++var13) {
				int var14 = arg1[var13];
				if (var14 < this.cb.length) {
					int[] var15 = this.cb[var14];

					for (int var16 = 0; var16 < var15.length; ++var16) {
						int var17 = var15[var16];
						this.z[var17] += arg2;
						this.A[var17] += arg3;
						this.B[var17] += arg4;
					}
				}
			}

		} else if (arg0 == 2) {
			for (int var18 = 0; var18 < var6; ++var18) {
				int var19 = arg1[var18];
				if (var19 < this.cb.length) {
					int[] var20 = this.cb[var19];

					for (int var21 = 0; var21 < var20.length; ++var21) {
						int var22 = var20[var21];
						this.z[var22] -= Ab;
						this.A[var22] -= Bb;
						this.B[var22] -= Cb;
						int var23 = (arg2 & 255) * 8;
						int var24 = (arg3 & 255) * 8;
						int var25 = (arg4 & 255) * 8;
						if (var25 != 0) {
							int var26 = Ib[var25];
							int var27 = Jb[var25];
							int var28 = this.z[var22] * var27 + this.A[var22] * var26 >> 16;
							this.A[var22] = this.A[var22] * var27 - this.z[var22] * var26 >> 16;
							this.z[var22] = var28;
						}

						if (var23 != 0) {
							int var29 = Ib[var23];
							int var30 = Jb[var23];
							int var31 = this.A[var22] * var30 - this.B[var22] * var29 >> 16;
							this.B[var22] = this.B[var22] * var30 + this.A[var22] * var29 >> 16;
							this.A[var22] = var31;
						}

						if (var24 != 0) {
							int var32 = Ib[var24];
							int var33 = Jb[var24];
							int var34 = this.z[var22] * var33 + this.B[var22] * var32 >> 16;
							this.B[var22] = this.B[var22] * var33 - this.z[var22] * var32 >> 16;
							this.z[var22] = var34;
						}

						this.z[var22] += Ab;
						this.A[var22] += Bb;
						this.B[var22] += Cb;
					}
				}
			}

		} else if (arg0 == 3) {
			for (int var35 = 0; var35 < var6; ++var35) {
				int var36 = arg1[var35];
				if (var36 < this.cb.length) {
					int[] var37 = this.cb[var36];

					for (int var38 = 0; var38 < var37.length; ++var38) {
						int var39 = var37[var38];
						this.z[var39] -= Ab;
						this.A[var39] -= Bb;
						this.B[var39] -= Cb;
						this.z[var39] = this.z[var39] * arg2 / 128;
						this.A[var39] = this.A[var39] * arg3 / 128;
						this.B[var39] = this.B[var39] * arg4 / 128;
						this.z[var39] += Ab;
						this.A[var39] += Bb;
						this.B[var39] += Cb;
					}
				}
			}

		} else if (arg0 == 5) {
			if (this.db != null && this.L != null) {
				for (int var40 = 0; var40 < var6; ++var40) {
					int var41 = arg1[var40];
					if (var41 < this.db.length) {
						int[] var42 = this.db[var41];

						for (int var43 = 0; var43 < var42.length; ++var43) {
							int var44 = var42[var43];
							this.L[var44] += arg2 * 8;
							if (this.L[var44] < 0) {
								this.L[var44] = 0;
							}

							if (this.L[var44] > 255) {
								this.L[var44] = 255;
							}
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("LZYQDKJV.b(Z)V")
	public void b(boolean arg0) {
		if (arg0) {
			for (int var2 = 0; var2 < this.y; ++var2) {
				int var3 = this.z[var2];
				this.z[var2] = this.B[var2];
				this.B[var2] = -var3;
			}

		}
	}

	@ObfuscatedName("LZYQDKJV.b(II)V")
	public void b(int arg0, int arg1) {
		int var3 = Ib[arg0];
		int var4 = Jb[arg0];

		for (int var5 = 0; var5 < this.y; ++var5) {
			int var6 = this.A[var5] * var4 - this.B[var5] * var3 >> 16;
			this.B[var5] = this.B[var5] * var4 + this.A[var5] * var3 >> 16;
			this.A[var5] = var6;
		}

		int var7 = 61 / arg1;
	}

	@ObfuscatedName("LZYQDKJV.a(IIZI)V")
	public void translate(int arg0, int arg1, boolean arg2, int arg3) {
		if (arg2) {
			this.m = -310;
		}

		for (int var5 = 0; var5 < this.y; ++var5) {
			this.z[var5] += arg0;
			this.A[var5] += arg3;
			this.B[var5] += arg1;
		}

	}

	@ObfuscatedName("LZYQDKJV.c(II)V")
	public void recolour(int arg0, int arg1) {
		for (int var3 = 0; var3 < this.C; ++var3) {
			if (this.faceColour[var3] == arg0) {
				this.faceColour[var3] = arg1;
			}
		}

	}

	@ObfuscatedName("LZYQDKJV.g(I)V")
	public void g(int arg0) {
		if (arg0 != 0) {
			for (int var2 = 1; var2 > 0; ++var2) {
			}
		}

		for (int var3 = 0; var3 < this.y; ++var3) {
			this.B[var3] = -this.B[var3];
		}

		for (int var4 = 0; var4 < this.C; ++var4) {
			int var5 = this.D[var4];
			this.D[var4] = this.F[var4];
			this.F[var4] = var5;
		}

	}

	@ObfuscatedName("LZYQDKJV.a(IIII)V")
	public void scale(int arg0, int arg1, int arg2, int arg3) {
		for (int var5 = 0; var5 < this.y; ++var5) {
			this.z[var5] = this.z[var5] * arg3 / 128;
			this.A[var5] = this.A[var5] * arg0 / 128;
			this.B[var5] = this.B[var5] * arg1 / 128;
		}

		if (arg2 != 9) {
			this.m = 322;
		}
	}

	@ObfuscatedName("LZYQDKJV.a(IIIIIZ)V")
	public final void calculateNormals(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) {
		int var7 = (int) Math.sqrt((double) (arg4 * arg4 + arg2 * arg2 + arg3 * arg3));
		int var8 = arg1 * var7 >> 8;
		if (this.G == null) {
			this.G = new int[this.C];
			this.H = new int[this.C];
			this.I = new int[this.C];
		}

		if (super.j == null) {
			super.j = new VertexNormal[this.y];

			for (int var9 = 0; var9 < this.y; ++var9) {
				super.j[var9] = new VertexNormal();
			}
		}

		for (int var10 = 0; var10 < this.C; ++var10) {
			int var11 = this.D[var10];
			int var12 = this.E[var10];
			int var13 = this.F[var10];
			int var14 = this.z[var12] - this.z[var11];
			int var15 = this.A[var12] - this.A[var11];
			int var16 = this.B[var12] - this.B[var11];
			int var17 = this.z[var13] - this.z[var11];
			int var18 = this.A[var13] - this.A[var11];
			int var19 = this.B[var13] - this.B[var11];
			int var20 = var15 * var19 - var16 * var18;
			int var21 = var16 * var17 - var14 * var19;

			int var22;
			for (var22 = var14 * var18 - var15 * var17; var20 > 8192 || var21 > 8192 || var22 > 8192 || var20 < -8192 || var21 < -8192 || var22 < -8192; var22 >>= 1) {
				var20 >>= 1;
				var21 >>= 1;
			}

			int var23 = (int) Math.sqrt((double) (var22 * var22 + var20 * var20 + var21 * var21));
			if (var23 <= 0) {
				var23 = 1;
			}

			int var24 = var20 * 256 / var23;
			int var25 = var21 * 256 / var23;
			int var26 = var22 * 256 / var23;
			if (this.J != null && (this.J[var10] & 1) != 0) {
				int var30 = (arg4 * var26 + arg2 * var24 + arg3 * var25) / (var8 / 2 + var8) + arg0;
				this.G[var10] = a(this.faceColour[var10], var30, this.J[var10]);
			} else {
				VertexNormal var27 = super.j[var11];
				var27.a += var24;
				var27.b += var25;
				var27.c += var26;
				++var27.d;
				VertexNormal var28 = super.j[var12];
				var28.a += var24;
				var28.b += var25;
				var28.c += var26;
				++var28.d;
				VertexNormal var29 = super.j[var13];
				var29.a += var24;
				var29.b += var25;
				var29.c += var26;
				++var29.d;
			}
		}

		if (arg5) {
			this.a(arg0, var8, arg2, arg3, arg4);
		} else {
			this.fb = new VertexNormal[this.y];

			for (int var31 = 0; var31 < this.y; ++var31) {
				VertexNormal var32 = super.j[var31];
				VertexNormal var33 = this.fb[var31] = new VertexNormal();
				var33.a = var32.a;
				var33.b = var32.b;
				var33.c = var32.c;
				var33.d = var32.d;
			}

			this.S = (arg0 << 16) + (var8 & 65535);
		}

		if (arg5) {
			this.c(this.m);
		} else {
			this.e(426);
		}
	}

	@ObfuscatedName("LZYQDKJV.b(IIII)V")
	public final void b(int arg0, int arg1, int arg2, int arg3) {
		int var5 = this.S >> 16;
		int var6 = this.S << 16 >> 16;
		if (arg2 != 0) {
			for (int var7 = 1; var7 > 0; ++var7) {
			}
		}

		this.a(var5, var6, arg3, arg0, arg1);
	}

	@ObfuscatedName("LZYQDKJV.a(IIIII)V")
	public final void a(int arg0, int arg1, int arg2, int arg3, int arg4) {
		for (int var6 = 0; var6 < this.C; ++var6) {
			int var7 = this.D[var6];
			int var8 = this.E[var6];
			int var9 = this.F[var6];
			if (this.J == null) {
				int var10 = this.faceColour[var6];
				VertexNormal var11 = super.j[var7];
				int var12 = (var11.c * arg4 + var11.b * arg3 + var11.a * arg2) / (var11.d * arg1) + arg0;
				this.G[var6] = a(var10, var12, 0);
				VertexNormal var13 = super.j[var8];
				int var14 = (var13.c * arg4 + var13.b * arg3 + var13.a * arg2) / (var13.d * arg1) + arg0;
				this.H[var6] = a(var10, var14, 0);
				VertexNormal var15 = super.j[var9];
				int var16 = (var15.c * arg4 + var15.b * arg3 + var15.a * arg2) / (var15.d * arg1) + arg0;
				this.I[var6] = a(var10, var16, 0);
			} else if ((this.J[var6] & 1) == 0) {
				int var17 = this.faceColour[var6];
				int var18 = this.J[var6];
				VertexNormal var19 = super.j[var7];
				int var20 = (var19.c * arg4 + var19.b * arg3 + var19.a * arg2) / (var19.d * arg1) + arg0;
				this.G[var6] = a(var17, var20, var18);
				VertexNormal var21 = super.j[var8];
				int var22 = (var21.c * arg4 + var21.b * arg3 + var21.a * arg2) / (var21.d * arg1) + arg0;
				this.H[var6] = a(var17, var22, var18);
				VertexNormal var23 = super.j[var9];
				int var24 = (var23.c * arg4 + var23.b * arg3 + var23.a * arg2) / (var23.d * arg1) + arg0;
				this.I[var6] = a(var17, var24, var18);
			}
		}

		super.j = null;
		this.fb = null;
		this.ab = null;
		this.bb = null;
		if (this.J != null) {
			for (int var25 = 0; var25 < this.C; ++var25) {
				if ((this.J[var25] & 2) == 2) {
					return;
				}
			}
		}

		this.faceColour = null;
	}

	@ObfuscatedName("LZYQDKJV.a(III)I")
	public static final int a(int arg0, int arg1, int arg2) {
		if ((arg2 & 2) == 2) {
			if (arg1 < 0) {
				arg1 = 0;
			} else if (arg1 > 127) {
				arg1 = 127;
			}

			return 127 - arg1;
		} else {
			int var4 = (arg0 & 127) * arg1 >> 7;
			if (var4 < 2) {
				var4 = 2;
			} else if (var4 > 126) {
				var4 = 126;
			}

			return (arg0 & 65408) + var4;
		}
	}

	@ObfuscatedName("LZYQDKJV.a(IIIIIII)V")
	public final void drawSimple(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		int var8 = Pix3D.centerX;
		int var9 = Pix3D.centerY;
		int var10 = Ib[arg0];
		int var11 = Jb[arg0];
		int var12 = Ib[arg1];
		int var13 = Jb[arg1];
		int var14 = Ib[arg2];
		int var15 = Jb[arg2];
		int var16 = Ib[arg3];
		int var17 = Jb[arg3];
		int var18 = arg5 * var16 + arg6 * var17 >> 16;

		for (int var19 = 0; var19 < this.y; ++var19) {
			int var20 = this.z[var19];
			int var21 = this.A[var19];
			int var22 = this.B[var19];
			if (arg2 != 0) {
				int var23 = var14 * var21 + var15 * var20 >> 16;
				var21 = var15 * var21 - var14 * var20 >> 16;
				var20 = var23;
			}

			if (arg0 != 0) {
				int var24 = var11 * var21 - var10 * var22 >> 16;
				var22 = var10 * var21 + var11 * var22 >> 16;
				var21 = var24;
			}

			if (arg1 != 0) {
				int var25 = var12 * var22 + var13 * var20 >> 16;
				var22 = var13 * var22 - var12 * var20 >> 16;
				var20 = var25;
			}

			int var26 = arg4 + var20;
			int var27 = arg5 + var21;
			int var28 = arg6 + var22;
			int var29 = var17 * var27 - var16 * var28 >> 16;
			int var30 = var16 * var27 + var17 * var28 >> 16;
			mb[var19] = var30 - var18;
			kb[var19] = (var26 << 9) / var30 + var8;
			lb[var19] = (var29 << 9) / var30 + var9;
			if (this.O > 0) {
				nb[var19] = var26;
				ob[var19] = var29;
				pb[var19] = var30;
			}
		}

		try {
			this.a(false, false, 0);
		} catch (Exception var32) {
		}
	}

	@ObfuscatedName("LZYQDKJV.a(IIIIIIIII)V")
	public final void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		int var10 = arg4 * arg7 - arg3 * arg5 >> 16;
		int var11 = arg1 * arg6 + arg2 * var10 >> 16;
		int var12 = this.V * arg2 >> 16;
		int var13 = var11 + var12;
		if (var13 > 50 && var11 < 3500) {
			int var14 = arg3 * arg7 + arg4 * arg5 >> 16;
			int var15 = var14 - this.V << 9;
			if (var15 / var13 < Pix2D.centerX2d) {
				int var16 = this.V + var14 << 9;
				if (var16 / var13 > -Pix2D.centerX2d) {
					int var17 = arg2 * arg6 - arg1 * var10 >> 16;
					int var18 = this.V * arg1 >> 16;
					int var19 = var17 + var18 << 9;
					if (var19 / var13 > -Pix2D.centerY2d) {
						int var20 = (super.k * arg2 >> 16) + var18;
						int var21 = var17 - var20 << 9;
						if (var21 / var13 < Pix2D.centerY2d) {
							int var22 = (super.k * arg1 >> 16) + var12;
							boolean var23 = false;
							if (var11 - var22 <= 50) {
								var23 = true;
							}

							boolean var24 = false;
							if (arg8 > 0 && Db) {
								int var25 = var11 - var12;
								if (var25 <= 50) {
									var25 = 50;
								}

								int var26;
								int var27;
								if (var14 > 0) {
									var26 = var15 / var13;
									var27 = var16 / var25;
								} else {
									var27 = var16 / var13;
									var26 = var15 / var25;
								}

								int var28;
								int var29;
								if (var17 > 0) {
									var28 = var21 / var13;
									var29 = var19 / var25;
								} else {
									var29 = var19 / var13;
									var28 = var21 / var25;
								}

								int var30 = Eb - Pix3D.centerX;
								int var31 = Fb - Pix3D.centerY;
								if (var30 > var26 && var30 < var27 && var31 > var28 && var31 < var29) {
									if (this.picking) {
										pickedBitsets[Gb++] = arg8;
									} else {
										var24 = true;
									}
								}
							}

							int var32 = Pix3D.centerX;
							int var33 = Pix3D.centerY;
							int var34 = 0;
							int var35 = 0;
							if (arg0 != 0) {
								var34 = Ib[arg0];
								var35 = Jb[arg0];
							}

							for (int var36 = 0; var36 < this.y; ++var36) {
								int var37 = this.z[var36];
								int var38 = this.A[var36];
								int var39 = this.B[var36];
								if (arg0 != 0) {
									int var40 = var34 * var39 + var35 * var37 >> 16;
									var39 = var35 * var39 - var34 * var37 >> 16;
									var37 = var40;
								}

								int var41 = arg5 + var37;
								int var42 = arg6 + var38;
								int var43 = arg7 + var39;
								int var44 = arg3 * var43 + arg4 * var41 >> 16;
								int var45 = arg4 * var43 - arg3 * var41 >> 16;
								int var47 = arg2 * var42 - arg1 * var45 >> 16;
								int var48 = arg1 * var42 + arg2 * var45 >> 16;
								mb[var36] = var48 - var11;
								if (var48 >= 50) {
									kb[var36] = (var44 << 9) / var48 + var32;
									lb[var36] = (var47 << 9) / var48 + var33;
								} else {
									kb[var36] = -5000;
									var23 = true;
								}

								if (var23 || this.O > 0) {
									nb[var36] = var44;
									ob[var36] = var47;
									pb[var36] = var48;
								}
							}

							try {
								this.a(var23, var24, arg8);
							} catch (Exception var50) {
							}
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("LZYQDKJV.a(ZZI)V")
	public final void a(boolean arg0, boolean arg1, int arg2) {
		for (int var4 = 0; var4 < this.X; ++var4) {
			qb[var4] = 0;
		}

		for (int var5 = 0; var5 < this.C; ++var5) {
			if (this.J == null || this.J[var5] != -1) {
				int var6 = this.D[var5];
				int var7 = this.E[var5];
				int var8 = this.F[var5];
				int var9 = kb[var6];
				int var10 = kb[var7];
				int var11 = kb[var8];
				if (arg0 && (var9 == -5000 || var10 == -5000 || var11 == -5000)) {
					jb[var5] = true;
					int var12 = (mb[var6] + mb[var7] + mb[var8]) / 3 + this.Y;
					rb[var12][qb[var12]++] = var5;
				} else {
					if (arg1 && this.a(Eb, Fb, lb[var6], lb[var7], lb[var8], var9, var10, var11)) {
						pickedBitsets[Gb++] = arg2;
						arg1 = false;
					}

					if ((lb[var8] - lb[var7]) * (var9 - var10) - (lb[var6] - lb[var7]) * (var11 - var10) > 0) {
						jb[var5] = false;
						if (var9 >= 0 && var10 >= 0 && var11 >= 0 && var9 <= Pix2D.safeWidth && var10 <= Pix2D.safeWidth && var11 <= Pix2D.safeWidth) {
							ib[var5] = false;
						} else {
							ib[var5] = true;
						}

						int var13 = (mb[var6] + mb[var7] + mb[var8]) / 3 + this.Y;
						rb[var13][qb[var13]++] = var5;
					}
				}
			}
		}

		if (this.K == null) {
			for (int var14 = this.X - 1; var14 >= 0; --var14) {
				int var15 = qb[var14];
				if (var15 > 0) {
					int[] var16 = rb[var14];

					for (int var17 = 0; var17 < var15; ++var17) {
						this.h(var16[var17]);
					}
				}
			}

		} else {
			for (int var18 = 0; var18 < 12; ++var18) {
				sb[var18] = 0;
				wb[var18] = 0;
			}

			for (int var19 = this.X - 1; var19 >= 0; --var19) {
				int var20 = qb[var19];
				if (var20 > 0) {
					int[] var21 = rb[var19];

					for (int var22 = 0; var22 < var20; ++var22) {
						int var23 = var21[var22];
						int var24 = this.K[var23];
						int var25 = sb[var24]++;
						tb[var24][var25] = var23;
						if (var24 < 10) {
							wb[var24] += var19;
						} else if (var24 == 10) {
							ub[var25] = var19;
						} else {
							vb[var25] = var19;
						}
					}
				}
			}

			int var26 = 0;
			if (sb[1] > 0 || sb[2] > 0) {
				var26 = (wb[1] + wb[2]) / (sb[1] + sb[2]);
			}

			int var27 = 0;
			if (sb[3] > 0 || sb[4] > 0) {
				var27 = (wb[3] + wb[4]) / (sb[3] + sb[4]);
			}

			int var28 = 0;
			if (sb[6] > 0 || sb[8] > 0) {
				var28 = (wb[6] + wb[8]) / (sb[6] + sb[8]);
			}

			int var29 = 0;
			int var30 = sb[10];
			int[] var31 = tb[10];
			int[] var32 = ub;
			if (var29 == var30) {
				var29 = 0;
				var30 = sb[11];
				var31 = tb[11];
				var32 = vb;
			}

			int var33;
			if (var29 < var30) {
				var33 = var32[var29];
			} else {
				var33 = -1000;
			}

			for (int var34 = 0; var34 < 10; ++var34) {
				while (var34 == 0 && var33 > var26) {
					this.h(var31[var29++]);
					if (var29 == var30 && tb[11] != var31) {
						var29 = 0;
						var30 = sb[11];
						var31 = tb[11];
						var32 = vb;
					}

					if (var29 < var30) {
						var33 = var32[var29];
					} else {
						var33 = -1000;
					}
				}

				while (var34 == 3 && var33 > var27) {
					this.h(var31[var29++]);
					if (var29 == var30 && tb[11] != var31) {
						var29 = 0;
						var30 = sb[11];
						var31 = tb[11];
						var32 = vb;
					}

					if (var29 < var30) {
						var33 = var32[var29];
					} else {
						var33 = -1000;
					}
				}

				while (var34 == 5 && var33 > var28) {
					this.h(var31[var29++]);
					if (var29 == var30 && tb[11] != var31) {
						var29 = 0;
						var30 = sb[11];
						var31 = tb[11];
						var32 = vb;
					}

					if (var29 < var30) {
						var33 = var32[var29];
					} else {
						var33 = -1000;
					}
				}

				int var35 = sb[var34];
				int[] var36 = tb[var34];

				for (int var37 = 0; var37 < var35; ++var37) {
					this.h(var36[var37]);
				}
			}

			while (var33 != -1000) {
				this.h(var31[var29++]);
				if (var29 == var30 && tb[11] != var31) {
					var29 = 0;
					var31 = tb[11];
					var30 = sb[11];
					var32 = vb;
				}

				if (var29 < var30) {
					var33 = var32[var29];
				} else {
					var33 = -1000;
				}
			}

		}
	}

	@ObfuscatedName("LZYQDKJV.h(I)V")
	public final void h(int arg0) {
		if (jb[arg0]) {
			this.i(arg0);
		} else {
			int var2 = this.D[arg0];
			int var3 = this.E[arg0];
			int var4 = this.F[arg0];
			Pix3D.A = ib[arg0];
			if (this.L == null) {
				Pix3D.D = 0;
			} else {
				Pix3D.D = this.L[arg0];
			}

			int var5;
			if (this.J == null) {
				var5 = 0;
			} else {
				var5 = this.J[arg0] & 3;
			}

			if (var5 == 0) {
				Pix3D.a(lb[var2], lb[var3], lb[var4], kb[var2], kb[var3], kb[var4], this.G[arg0], this.H[arg0], this.I[arg0]);
			} else if (var5 == 1) {
				Pix3D.a(lb[var2], lb[var3], lb[var4], kb[var2], kb[var3], kb[var4], Kb[this.G[arg0]]);
			} else if (var5 == 2) {
				int var6 = this.J[arg0] >> 2;
				int var7 = this.P[var6];
				int var8 = this.Q[var6];
				int var9 = this.R[var6];
				Pix3D.a(lb[var2], lb[var3], lb[var4], kb[var2], kb[var3], kb[var4], this.G[arg0], this.H[arg0], this.I[arg0], nb[var7], nb[var8], nb[var9], ob[var7], ob[var8], ob[var9], pb[var7], pb[var8], pb[var9], this.faceColour[arg0]);
			} else {
				if (var5 == 3) {
					int var10 = this.J[arg0] >> 2;
					int var11 = this.P[var10];
					int var12 = this.Q[var10];
					int var13 = this.R[var10];
					Pix3D.a(lb[var2], lb[var3], lb[var4], kb[var2], kb[var3], kb[var4], this.G[arg0], this.G[arg0], this.G[arg0], nb[var11], nb[var12], nb[var13], ob[var11], ob[var12], ob[var13], pb[var11], pb[var12], pb[var13], this.faceColour[arg0]);
				}

			}
		}
	}

	@ObfuscatedName("LZYQDKJV.i(I)V")
	public final void i(int arg0) {
		int var2 = Pix3D.centerX;
		int var3 = Pix3D.centerY;
		int var4 = 0;
		int var5 = this.D[arg0];
		int var6 = this.E[arg0];
		int var7 = this.F[arg0];
		int var8 = pb[var5];
		int var9 = pb[var6];
		int var10 = pb[var7];
		if (var8 >= 50) {
			xb[var4] = kb[var5];
			yb[var4] = lb[var5];
			zb[var4++] = this.G[arg0];
		} else {
			int var11 = nb[var5];
			int var12 = ob[var5];
			int var13 = this.G[arg0];
			if (var10 >= 50) {
				int var14 = (50 - var8) * Lb[var10 - var8];
				xb[var4] = (((nb[var7] - var11) * var14 >> 16) + var11 << 9) / 50 + var2;
				yb[var4] = (((ob[var7] - var12) * var14 >> 16) + var12 << 9) / 50 + var3;
				zb[var4++] = ((this.I[arg0] - var13) * var14 >> 16) + var13;
			}

			if (var9 >= 50) {
				int var15 = (50 - var8) * Lb[var9 - var8];
				xb[var4] = (((nb[var6] - var11) * var15 >> 16) + var11 << 9) / 50 + var2;
				yb[var4] = (((ob[var6] - var12) * var15 >> 16) + var12 << 9) / 50 + var3;
				zb[var4++] = ((this.H[arg0] - var13) * var15 >> 16) + var13;
			}
		}

		if (var9 >= 50) {
			xb[var4] = kb[var6];
			yb[var4] = lb[var6];
			zb[var4++] = this.H[arg0];
		} else {
			int var16 = nb[var6];
			int var17 = ob[var6];
			int var18 = this.H[arg0];
			if (var8 >= 50) {
				int var19 = (50 - var9) * Lb[var8 - var9];
				xb[var4] = (((nb[var5] - var16) * var19 >> 16) + var16 << 9) / 50 + var2;
				yb[var4] = (((ob[var5] - var17) * var19 >> 16) + var17 << 9) / 50 + var3;
				zb[var4++] = ((this.G[arg0] - var18) * var19 >> 16) + var18;
			}

			if (var10 >= 50) {
				int var20 = (50 - var9) * Lb[var10 - var9];
				xb[var4] = (((nb[var7] - var16) * var20 >> 16) + var16 << 9) / 50 + var2;
				yb[var4] = (((ob[var7] - var17) * var20 >> 16) + var17 << 9) / 50 + var3;
				zb[var4++] = ((this.I[arg0] - var18) * var20 >> 16) + var18;
			}
		}

		if (var10 >= 50) {
			xb[var4] = kb[var7];
			yb[var4] = lb[var7];
			zb[var4++] = this.I[arg0];
		} else {
			int var21 = nb[var7];
			int var22 = ob[var7];
			int var23 = this.I[arg0];
			if (var9 >= 50) {
				int var24 = (50 - var10) * Lb[var9 - var10];
				xb[var4] = (((nb[var6] - var21) * var24 >> 16) + var21 << 9) / 50 + var2;
				yb[var4] = (((ob[var6] - var22) * var24 >> 16) + var22 << 9) / 50 + var3;
				zb[var4++] = ((this.H[arg0] - var23) * var24 >> 16) + var23;
			}

			if (var8 >= 50) {
				int var25 = (50 - var10) * Lb[var8 - var10];
				xb[var4] = (((nb[var5] - var21) * var25 >> 16) + var21 << 9) / 50 + var2;
				yb[var4] = (((ob[var5] - var22) * var25 >> 16) + var22 << 9) / 50 + var3;
				zb[var4++] = ((this.G[arg0] - var23) * var25 >> 16) + var23;
			}
		}

		int var26 = xb[0];
		int var27 = xb[1];
		int var28 = xb[2];
		int var29 = yb[0];
		int var30 = yb[1];
		int var31 = yb[2];
		if ((var26 - var27) * (var31 - var30) - (var28 - var27) * (var29 - var30) > 0) {
			Pix3D.A = false;
			if (var4 == 3) {
				if (var26 < 0 || var27 < 0 || var28 < 0 || var26 > Pix2D.safeWidth || var27 > Pix2D.safeWidth || var28 > Pix2D.safeWidth) {
					Pix3D.A = true;
				}

				int var32;
				if (this.J == null) {
					var32 = 0;
				} else {
					var32 = this.J[arg0] & 3;
				}

				if (var32 == 0) {
					Pix3D.a(var29, var30, var31, var26, var27, var28, zb[0], zb[1], zb[2]);
				} else if (var32 == 1) {
					Pix3D.a(var29, var30, var31, var26, var27, var28, Kb[this.G[arg0]]);
				} else if (var32 == 2) {
					int var33 = this.J[arg0] >> 2;
					int var34 = this.P[var33];
					int var35 = this.Q[var33];
					int var36 = this.R[var33];
					Pix3D.a(var29, var30, var31, var26, var27, var28, zb[0], zb[1], zb[2], nb[var34], nb[var35], nb[var36], ob[var34], ob[var35], ob[var36], pb[var34], pb[var35], pb[var36], this.faceColour[arg0]);
				} else if (var32 == 3) {
					int var37 = this.J[arg0] >> 2;
					int var38 = this.P[var37];
					int var39 = this.Q[var37];
					int var40 = this.R[var37];
					Pix3D.a(var29, var30, var31, var26, var27, var28, this.G[arg0], this.G[arg0], this.G[arg0], nb[var38], nb[var39], nb[var40], ob[var38], ob[var39], ob[var40], pb[var38], pb[var39], pb[var40], this.faceColour[arg0]);
				}
			}

			if (var4 == 4) {
				if (var26 < 0 || var27 < 0 || var28 < 0 || var26 > Pix2D.safeWidth || var27 > Pix2D.safeWidth || var28 > Pix2D.safeWidth || xb[3] < 0 || xb[3] > Pix2D.safeWidth) {
					Pix3D.A = true;
				}

				int var41;
				if (this.J == null) {
					var41 = 0;
				} else {
					var41 = this.J[arg0] & 3;
				}

				if (var41 == 0) {
					Pix3D.a(var29, var30, var31, var26, var27, var28, zb[0], zb[1], zb[2]);
					Pix3D.a(var29, var31, yb[3], var26, var28, xb[3], zb[0], zb[2], zb[3]);
					return;
				}

				if (var41 == 1) {
					int var42 = Kb[this.G[arg0]];
					Pix3D.a(var29, var30, var31, var26, var27, var28, var42);
					Pix3D.a(var29, var31, yb[3], var26, var28, xb[3], var42);
					return;
				}

				if (var41 == 2) {
					int var43 = this.J[arg0] >> 2;
					int var44 = this.P[var43];
					int var45 = this.Q[var43];
					int var46 = this.R[var43];
					Pix3D.a(var29, var30, var31, var26, var27, var28, zb[0], zb[1], zb[2], nb[var44], nb[var45], nb[var46], ob[var44], ob[var45], ob[var46], pb[var44], pb[var45], pb[var46], this.faceColour[arg0]);
					Pix3D.a(var29, var31, yb[3], var26, var28, xb[3], zb[0], zb[2], zb[3], nb[var44], nb[var45], nb[var46], ob[var44], ob[var45], ob[var46], pb[var44], pb[var45], pb[var46], this.faceColour[arg0]);
					return;
				}

				if (var41 == 3) {
					int var47 = this.J[arg0] >> 2;
					int var48 = this.P[var47];
					int var49 = this.Q[var47];
					int var50 = this.R[var47];
					Pix3D.a(var29, var30, var31, var26, var27, var28, this.G[arg0], this.G[arg0], this.G[arg0], nb[var48], nb[var49], nb[var50], ob[var48], ob[var49], ob[var50], pb[var48], pb[var49], pb[var50], this.faceColour[arg0]);
					Pix3D.a(var29, var31, yb[3], var26, var28, xb[3], this.G[arg0], this.G[arg0], this.G[arg0], nb[var48], nb[var49], nb[var50], ob[var48], ob[var49], ob[var50], pb[var48], pb[var49], pb[var50], this.faceColour[arg0]);
				}
			}
		}

	}

	@ObfuscatedName("LZYQDKJV.a(IIIIIIII)Z")
	public final boolean a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4) {
			return false;
		} else if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
			return false;
		} else if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7) {
			return false;
		} else {
			return arg0 <= arg5 || arg0 <= arg6 || arg0 <= arg7;
		}
	}
}
