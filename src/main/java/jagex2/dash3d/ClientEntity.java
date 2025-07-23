package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.SeqType;

public abstract class ClientEntity extends ModelSource {
	@ObfuscatedName("LRUWCBNN.n")
	public int n = -89;
	@ObfuscatedName("LRUWCBNN.o")
	public int o = 100;
	@ObfuscatedName("LRUWCBNN.s")
	public int[] routeTileX = new int[10];
	@ObfuscatedName("LRUWCBNN.t")
	public int[] routeTileZ = new int[10];
	@ObfuscatedName("LRUWCBNN.u")
	public int u = -1;
	@ObfuscatedName("LRUWCBNN.x")
	public boolean[] routeRun = new boolean[10];
	@ObfuscatedName("LRUWCBNN.y")
	public boolean y = false;
	@ObfuscatedName("LRUWCBNN.A")
	public int A = 200;
	@ObfuscatedName("LRUWCBNN.B")
	public int B = -1000;
	@ObfuscatedName("LRUWCBNN.G")
	public int G = 32;
	@ObfuscatedName("LRUWCBNN.H")
	public int size = 1;
	@ObfuscatedName("LRUWCBNN.P")
	public int P = -1;
	@ObfuscatedName("LRUWCBNN.U")
	public int U = -1;
	@ObfuscatedName("LRUWCBNN.Z")
	public int Z = -1;
	@ObfuscatedName("LRUWCBNN.ab")
	public int ab = -1;
	@ObfuscatedName("LRUWCBNN.bb")
	public int bb = -1;
	@ObfuscatedName("LRUWCBNN.cb")
	public int cb = -1;
	@ObfuscatedName("LRUWCBNN.eb")
	public int primarySeqId = -1;
	@ObfuscatedName("LRUWCBNN.jb")
	public int jb = -1;
	@ObfuscatedName("LRUWCBNN.kb")
	public int[] damageValues = new int[4];
	@ObfuscatedName("LRUWCBNN.lb")
	public int[] damageTypes = new int[4];
	@ObfuscatedName("LRUWCBNN.mb")
	public int[] damageCycles = new int[4];
	@ObfuscatedName("LRUWCBNN.ob")
	public int readyanim = -1;
	@ObfuscatedName("LRUWCBNN.pb")
	public int pb = -1;
	@ObfuscatedName("LRUWCBNN.C")
	public int C;
	@ObfuscatedName("LRUWCBNN.D")
	public int D;
	@ObfuscatedName("LRUWCBNN.E")
	public int E;
	@ObfuscatedName("LRUWCBNN.F")
	public int F;
	@ObfuscatedName("LRUWCBNN.I")
	public int I;
	@ObfuscatedName("LRUWCBNN.J")
	public int J;
	@ObfuscatedName("LRUWCBNN.K")
	public int K;
	@ObfuscatedName("LRUWCBNN.L")
	public int L;
	@ObfuscatedName("LRUWCBNN.M")
	public int M;
	@ObfuscatedName("LRUWCBNN.N")
	public int N;
	@ObfuscatedName("LRUWCBNN.O")
	public int O;
	@ObfuscatedName("LRUWCBNN.Q")
	public int x;
	@ObfuscatedName("LRUWCBNN.R")
	public int z;
	@ObfuscatedName("LRUWCBNN.S")
	public int S;
	@ObfuscatedName("LRUWCBNN.T")
	public int preanimRouteLength;
	@ObfuscatedName("LRUWCBNN.V")
	public int V;
	@ObfuscatedName("LRUWCBNN.W")
	public int W;
	@ObfuscatedName("LRUWCBNN.X")
	public int justUnfortunateNamingNotX;
	@ObfuscatedName("LRUWCBNN.Y")
	public int Y;
	@ObfuscatedName("LRUWCBNN.db")
	public int seqDelayMove;
	@ObfuscatedName("LRUWCBNN.fb")
	public int fb;
	@ObfuscatedName("LRUWCBNN.gb")
	public int gb;
	@ObfuscatedName("LRUWCBNN.hb")
	public int hb;
	@ObfuscatedName("LRUWCBNN.ib")
	public int ib;
	@ObfuscatedName("LRUWCBNN.nb")
	public int routeLength;
	@ObfuscatedName("LRUWCBNN.p")
	public int p;
	@ObfuscatedName("LRUWCBNN.q")
	public int q;
	@ObfuscatedName("LRUWCBNN.r")
	public int r;
	@ObfuscatedName("LRUWCBNN.v")
	public int v;
	@ObfuscatedName("LRUWCBNN.w")
	public int w;
	@ObfuscatedName("LRUWCBNN.z")
	public int zz;
	@ObfuscatedName("LRUWCBNN.m")
	public String m;

	@ObfuscatedName("LRUWCBNN.b(I)Z")
	public boolean isVisible() {
		return false;
	}

	@ObfuscatedName("LRUWCBNN.a(IBZI)V")
	public final void move(boolean teleport, int x, int z) {
		if (this.primarySeqId != -1 && SeqType.types[this.primarySeqId].postanim_mode == 1) {
			this.primarySeqId = -1;
		}

		if (!teleport) {
			int dx = x - this.routeTileX[0];
			int dz = z - this.routeTileZ[0];
			if (dx >= -8 && dx <= 8 && dz >= -8 && dz <= 8) {
				if (this.routeLength < 9) {
					this.routeLength++;
				}

				for (int i = this.routeLength; i > 0; --i) {
					this.routeTileX[i] = this.routeTileX[i - 1];
					this.routeTileZ[i] = this.routeTileZ[i - 1];
					this.routeRun[i] = this.routeRun[i - 1];
				}

				this.routeTileX[0] = x;
				this.routeTileZ[0] = z;
				this.routeRun[0] = false;
				return;
			}
		}

		this.routeLength = 0;
		this.preanimRouteLength = 0;
		this.seqDelayMove = 0;
		this.routeTileX[0] = x;
		this.routeTileZ[0] = z;
		this.x = this.routeTileX[0] * 128 + this.size * 64;
		this.z = this.routeTileZ[0] * 128 + this.size * 64;
	}

	@ObfuscatedName("LRUWCBNN.a(ZII)V")
	public final void step(boolean running, int direction) {
		int nextX = this.routeTileX[0];
		int nextZ = this.routeTileZ[0];

		if (direction == 0) {
			nextX--;
			nextZ++;
		}else if (direction == 1) {
			nextZ++;
		} else if (direction == 2) {
			nextX++;
			nextZ++;
		} else if (direction == 3) {
			nextX--;
		} else if (direction == 4) {
			nextX++;
		} else if (direction == 5) {
			nextX--;
			nextZ--;
		} else if (direction == 6) {
			nextZ--;
		} else if (direction == 7) {
			nextX++;
			nextZ--;
		}

		if (this.primarySeqId != -1 && SeqType.types[this.primarySeqId].postanim_mode == 1) {
			this.primarySeqId = -1;
		}

		if (this.routeLength < 9) {
			this.routeLength++;
		}

		for (int i = this.routeLength; i > 0; --i) {
			this.routeTileX[i] = this.routeTileX[i - 1];
			this.routeTileZ[i] = this.routeTileZ[i - 1];
			this.routeRun[i] = this.routeRun[i - 1];
		}
		this.routeTileX[0] = nextX;
		this.routeTileZ[0] = nextZ;
		this.routeRun[0] = running;
	}

	@ObfuscatedName("LRUWCBNN.a(I)V")
	public final void clearRoute() {
		this.routeLength = 0;
		this.preanimRouteLength = 0;
	}


	@ObfuscatedName("LRUWCBNN.a(IZII)V")
	public final void hit(int damage, int damageType, int loopCycle) {
		for (int i = 0; i < 4; ++i) {
			if (this.damageCycles[i] <= loopCycle) {
				this.damageValues[i] = damage;
				this.damageTypes[i] = damageType;
				this.damageCycles[i] = loopCycle + 70;
				return;
			}
		}
	}
}
