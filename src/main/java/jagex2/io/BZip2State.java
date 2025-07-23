package jagex2.io;

import deob.ObfuscatedName;

public class BZip2State {
	@ObfuscatedName("ANEJWQAX.a")
	public static final int MTFA_SIZE = 4096;

	@ObfuscatedName("ANEJWQAX.b")
	public static final int MTFL_SIZE = 16;

	@ObfuscatedName("ANEJWQAX.c")
	public static final int BZ_MAX_ALPHA_SIZE = 258;

	@ObfuscatedName("ANEJWQAX.d")
	public static final int BZ_MAX_CODE_LEN = 23;

	@ObfuscatedName("ANEJWQAX.e")
	public static final int field768 = 1;

	@ObfuscatedName("ANEJWQAX.f")
	public static final int BZ_N_GROUPS = 6;

	@ObfuscatedName("ANEJWQAX.g")
	public static final int BZ_G_SIZE = 50;

	@ObfuscatedName("ANEJWQAX.h")
	public static final int field771 = 4;

	@ObfuscatedName("ANEJWQAX.i")
	public static final int BZ_MAX_SELECTORS = (2 + (900000 / BZ_G_SIZE)); // 18002

	public static final int BZ_RUNA = 0;
	public static final int BZ_RUNB = 1;

	@ObfuscatedName("ANEJWQAX.D")
	public int[] unzftab = new int[256];

	@ObfuscatedName("ANEJWQAX.F")
	public int[] cftab = new int[257];

	@ObfuscatedName("ANEJWQAX.G")
	public int[] G = new int[257];

	@ObfuscatedName("ANEJWQAX.J")
	public boolean[] inUse = new boolean[256];

	@ObfuscatedName("ANEJWQAX.K")
	public boolean[] inUse16 = new boolean[16];

	@ObfuscatedName("ANEJWQAX.L")
	public byte[] seqToUnseq = new byte[256];

	@ObfuscatedName("ANEJWQAX.M")
	public byte[] mtfa = new byte[4096];

	@ObfuscatedName("ANEJWQAX.N")
	public int[] mtfbase = new int[16];

	@ObfuscatedName("ANEJWQAX.O")
	public byte[] selector = new byte[18002];

	@ObfuscatedName("ANEJWQAX.P")
	public byte[] selectorMtf = new byte[18002];

	@ObfuscatedName("ANEJWQAX.Q")
	public byte[][] len = new byte[6][258];

	@ObfuscatedName("ANEJWQAX.R")
	public int[][] limit = new int[6][258];

	@ObfuscatedName("ANEJWQAX.S")
	public int[][] base = new int[6][258];

	@ObfuscatedName("ANEJWQAX.T")
	public int[][] perm = new int[6][258];

	@ObfuscatedName("ANEJWQAX.U")
	public int[] minLens = new int[6];

	@ObfuscatedName("ANEJWQAX.t")
	public byte state_out_ch;

	@ObfuscatedName("ANEJWQAX.A")
	public int origPtr;

	@ObfuscatedName("ANEJWQAX.B")
	public int tPos;

	@ObfuscatedName("ANEJWQAX.C")
	public int k0;

	@ObfuscatedName("ANEJWQAX.E")
	public int c_nblock_used;

	@ObfuscatedName("ANEJWQAX.I")
	public int nInUse;

	@ObfuscatedName("ANEJWQAX.V")
	public int save_nblock;

	@ObfuscatedName("ANEJWQAX.k")
	public int next_in;

	@ObfuscatedName("ANEJWQAX.l")
	public int avail_in;

	@ObfuscatedName("ANEJWQAX.m")
	public int total_in_lo32;

	@ObfuscatedName("ANEJWQAX.n")
	public int total_in_hi32;

	@ObfuscatedName("ANEJWQAX.p")
	public int next_out;

	@ObfuscatedName("ANEJWQAX.q")
	public int avail_out;

	@ObfuscatedName("ANEJWQAX.r")
	public int total_out_lo32;

	@ObfuscatedName("ANEJWQAX.s")
	public int total_out_hi32;

	@ObfuscatedName("ANEJWQAX.u")
	public int state_out_len;

	@ObfuscatedName("ANEJWQAX.w")
	public int bsBuff;

	@ObfuscatedName("ANEJWQAX.x")
	public int bsLive;

	@ObfuscatedName("ANEJWQAX.y")
	public int blockSize100k;

	@ObfuscatedName("ANEJWQAX.z")
	public int currBlockNo;

	@ObfuscatedName("ANEJWQAX.v")
	public boolean blockRandomized;

	@ObfuscatedName("ANEJWQAX.j")
	public byte[] stream;

	@ObfuscatedName("ANEJWQAX.o")
	public byte[] decompressed;

	@ObfuscatedName("ANEJWQAX.H")
	public static int[] tt;
}
