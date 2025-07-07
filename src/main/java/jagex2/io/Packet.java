package jagex2.io;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LinkList;

import java.math.BigInteger;

public class Packet extends DoublyLinkable {

	@ObfuscatedName("MFMVIYHT.z")
	public byte[] data;

	@ObfuscatedName("MFMVIYHT.A")
	public int pos;

	@ObfuscatedName("MFMVIYHT.B")
	public int bitPos;

	@ObfuscatedName("MFMVIYHT.C")
	public static int[] crcTable = new int[256];

	static {
		for (int b = 0; b < 256; ++b) {
			int remainder = b;

			for (int bit = 0; bit < 8; ++bit) {
				if ((remainder & 0x1) == 1) {
					remainder = remainder >>> 1 ^ 0xEDB88320;
				} else {
					remainder >>>= 0x1;
				}
			}

			crcTable[b] = remainder;
		}

		cacheMin = new LinkList();
		cacheMid = new LinkList();
		cacheMax = new LinkList();
		L = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
	}

	@ObfuscatedName("MFMVIYHT.D")
	public static final int[] bitmask = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };

	@ObfuscatedName("MFMVIYHT.h")
	public boolean h = false;

	@ObfuscatedName("MFMVIYHT.i")
	public int i = 8;

	@ObfuscatedName("MFMVIYHT.j")
	public boolean j = false;

	@ObfuscatedName("MFMVIYHT.k")
	public boolean k = true;

	@ObfuscatedName("MFMVIYHT.l")
	public byte l = 5;

	@ObfuscatedName("MFMVIYHT.m")
	public int m = -29290;

	@ObfuscatedName("MFMVIYHT.n")
	public boolean n = false;

	@ObfuscatedName("MFMVIYHT.o")
	public int o = 217;

	@ObfuscatedName("MFMVIYHT.p")
	public int p = 236;

	@ObfuscatedName("MFMVIYHT.q")
	public boolean q = false;

	@ObfuscatedName("MFMVIYHT.t")
	public byte t = 17;

	@ObfuscatedName("MFMVIYHT.u")
	public byte u = 89;

	@ObfuscatedName("MFMVIYHT.v")
	public byte v = -16;

	@ObfuscatedName("MFMVIYHT.w")
	public boolean w = false;

	@ObfuscatedName("MFMVIYHT.y")
	public int y = 1;


	@ObfuscatedName("MFMVIYHT.x")
	public static boolean x = true;





	@ObfuscatedName("MFMVIYHT.I")
	public static LinkList cacheMin;

	@ObfuscatedName("MFMVIYHT.J")
	public static LinkList cacheMid;

	@ObfuscatedName("MFMVIYHT.K")
	public static LinkList cacheMax;

	@ObfuscatedName("MFMVIYHT.L")
	public static char[] L;



	@ObfuscatedName("MFMVIYHT.F")
	public static int cacheMinCount;

	@ObfuscatedName("MFMVIYHT.G")
	public static int G;

	@ObfuscatedName("MFMVIYHT.H")
	public static int cacheMaxCount;

	@ObfuscatedName("MFMVIYHT.r")
	public int r;

	@ObfuscatedName("MFMVIYHT.s")
	public int s;

	@ObfuscatedName("MFMVIYHT.E")
	public Isaac random;

	@ObfuscatedName("MFMVIYHT.M")
	public static boolean M;

	@ObfuscatedName("MFMVIYHT.a(BI)LMFMVIYHT;")
	public static Packet alloc(int size) {
		LinkList sync = cacheMid;
		synchronized (sync) {
			Packet buf = null;

			if (size == 0 && cacheMinCount > 0) {
				--cacheMinCount;
				buf = (Packet) cacheMin.pop();
			} else if (size == 1 && G > 0) {
				--G;
				buf = (Packet) cacheMid.pop();
			} else if (size == 2 && cacheMaxCount > 0) {
				--cacheMaxCount;
				buf = (Packet) cacheMax.pop();
			}

			if (buf != null) {
				buf.pos = 0;
				Packet var4 = buf;
				return var4;
			}
		}

		Packet buf = new Packet();

		buf.pos = 0;
		if (size == 0) {
			buf.data = new byte[100];
		} else if (size == 1) {
			buf.data = new byte[5000];
		} else {
			buf.data = new byte[30000];
		}

		return buf;
	}

	public Packet() {
	}

	public Packet(byte[] src) {
		this.data = src;
		this.pos = 0;
	}

	@ObfuscatedName("MFMVIYHT.b(BI)V")
	public void pIsaac(int ptype) {
		this.data[this.pos++] = (byte) (ptype + this.random.nextInt());
	}

	@ObfuscatedName("MFMVIYHT.a(I)V")
	public void p1(int arg0) {
		this.data[this.pos++] = (byte) arg0;
	}

	@ObfuscatedName("MFMVIYHT.b(I)V")
	public void b(int arg0) {
		this.data[this.pos++] = (byte) (arg0 >> 8);
		this.data[this.pos++] = (byte) arg0;
	}

	@ObfuscatedName("MFMVIYHT.a(IZ)V")
	public void a(int arg0, boolean arg1) {
		this.data[this.pos++] = (byte) arg0;
		if (!arg1) {
			this.data[this.pos++] = (byte) (arg0 >> 8);
		}
	}

	@ObfuscatedName("MFMVIYHT.c(I)V")
	public void c(int arg0) {
		this.data[this.pos++] = (byte) (arg0 >> 16);
		this.data[this.pos++] = (byte) (arg0 >> 8);
		this.data[this.pos++] = (byte) arg0;
	}

	@ObfuscatedName("MFMVIYHT.d(I)V")
	public void d(int arg0) {
		this.data[this.pos++] = (byte) (arg0 >> 24);
		this.data[this.pos++] = (byte) (arg0 >> 16);
		this.data[this.pos++] = (byte) (arg0 >> 8);
		this.data[this.pos++] = (byte) arg0;
	}

	@ObfuscatedName("MFMVIYHT.b(IZ)V")
	public void b(int arg0, boolean arg1) {
		this.data[this.pos++] = (byte) arg0;
		this.data[this.pos++] = (byte) (arg0 >> 8);
		if (arg1) {
			this.i = 306;
		}

		this.data[this.pos++] = (byte) (arg0 >> 16);
		this.data[this.pos++] = (byte) (arg0 >> 24);
	}

	@ObfuscatedName("MFMVIYHT.a(JZ)V")
	public void a(long n) {
		this.data[this.pos++] = (byte) ((int) (n >> 56));
		this.data[this.pos++] = (byte) ((int) (n >> 48));
		this.data[this.pos++] = (byte) ((int) (n >> 40));
		this.data[this.pos++] = (byte) ((int) (n >> 32));
		this.data[this.pos++] = (byte) ((int) (n >> 24));
		this.data[this.pos++] = (byte) ((int) (n >> 16));
		this.data[this.pos++] = (byte) ((int) (n >> 8));
		this.data[this.pos++] = (byte) ((int) n);
	}

	@ObfuscatedName("MFMVIYHT.a(Ljava/lang/String;)V")
	public void pjstr(String s) {
		s.getBytes(0, s.length(), this.data, this.pos);
		this.pos += s.length();
		this.data[this.pos++] = 10;
	}

	@ObfuscatedName("MFMVIYHT.a([BIII)V")
	public void pdata(byte[] arg0, int arg1, int arg2, int arg3) {
		if (arg1 != 0) {
			x = !x;
		}

		for (int var5 = arg3; var5 < arg2 + arg3; ++var5) {
			this.data[this.pos++] = arg0[var5];
		}

	}

	@ObfuscatedName("MFMVIYHT.a(II)V")
	public void a(int arg0, int arg1) {
		this.data[this.pos - arg0 - 1] = (byte) arg0;
		if (arg1 == 0) {
			;
		}
	}

	@ObfuscatedName("MFMVIYHT.c()I")
	public int g1() {
		return this.data[this.pos++] & 0xFF;
	}

	@ObfuscatedName("MFMVIYHT.d()B")
	public byte d() {
		return this.data[this.pos++];
	}

	@ObfuscatedName("MFMVIYHT.e()I")
	public int e() {
		this.pos += 2;
		return ((this.data[this.pos - 2] & 255) << 8) + (this.data[this.pos - 1] & 255);
	}

	@ObfuscatedName("MFMVIYHT.f()I")
	public int f() {
		this.pos += 2;
		int var1 = ((this.data[this.pos - 2] & 255) << 8) + (this.data[this.pos - 1] & 255);
		if (var1 > 32767) {
			var1 -= 65536;
		}

		return var1;
	}

	@ObfuscatedName("MFMVIYHT.g()I")
	public int g3() {
		this.pos += 3;
		return (this.data[this.pos - 1] & 0xFF) + ((this.data[this.pos - 3] & 0xFF) << 16) + ((this.data[this.pos - 2] & 0xFF) << 8);
	}

	@ObfuscatedName("MFMVIYHT.h()I")
	public int g4() {
		this.pos += 4;
		return (this.data[this.pos - 1] & 0xFF) + ((this.data[this.pos - 2] & 0xFF) << 8) + ((this.data[this.pos - 4] & 0xFF) << 24) + ((this.data[this.pos - 3] & 0xFF) << 16);
	}

	@ObfuscatedName("MFMVIYHT.e(I)J")
	public long g8() {
		long high = (long) this.g4() & 0xFFFFFFFFL;
		long low = (long) this.g4() & 0xFFFFFFFFL;
		return (high << 32) + low;
	}

	@ObfuscatedName("MFMVIYHT.i()Ljava/lang/String;")
	public String gjstr() {
		int start = this.pos;
		while (this.data[this.pos++] != 10) {
		}
		return new String(this.data, start, this.pos - start - 1);
	}

	@ObfuscatedName("MFMVIYHT.f(I)[B")
	public byte[] gjstrraw() {
		int start = this.pos;
		while (this.data[this.pos++] != 10) {
		}
		byte[] data = new byte[this.pos - start - 1];
		for (int i = start; i < this.pos - 1; ++i) {
			data[i - start] = this.data[i];
		}
		return data;
	}

	@ObfuscatedName("MFMVIYHT.a(III[B)V")
	public void gdata(int arg0, int arg1, int arg2, byte[] arg3) {
		if (arg2 >= 0) {
			this.k = !this.k;
		}

		for (int var5 = arg1; var5 < arg0 + arg1; ++var5) {
			arg3[var5] = this.data[this.pos++];
		}

	}

	@ObfuscatedName("MFMVIYHT.a(B)V")
	public void bits() {
		this.bitPos = this.pos * 8;
	}

	@ObfuscatedName("MFMVIYHT.b(II)I")
	public int gBit(int n) {
		int bytePos = this.bitPos >> 3;
		int remainingBits = 8 - (this.bitPos & 7);

		int value = 0;
		this.bitPos += n;

		while (n > remainingBits) {
			value += (this.data[bytePos++] & bitmask[remainingBits]) << n - remainingBits;
			n -= remainingBits;
			remainingBits = 8;
		}

		if (n == remainingBits) {
			value = (this.data[bytePos] & bitmask[remainingBits]) + value;
		} else {
			value = (this.data[bytePos] >> remainingBits - n & bitmask[n]) + value;
		}

		return value;
	}

	@ObfuscatedName("MFMVIYHT.g(I)V")
	public void bytes() {
		this.pos = (this.bitPos + 7) / 8;
	}

	@ObfuscatedName("MFMVIYHT.j()I")
	public int gsmart() {
		int n = this.data[this.pos] & 0xFF;
		return n < 128 ? this.g1() - 64 : this.e() - 49152;
	}

	@ObfuscatedName("MFMVIYHT.k()I")
	public int gsmarts() {
		int n = this.data[this.pos] & 0xFF;
		return n < 128 ? this.g1() : this.e() - 32768;
	}

	@ObfuscatedName("MFMVIYHT.a(ILjava/math/BigInteger;Ljava/math/BigInteger;)V")
	public void rsaenc(BigInteger exp, BigInteger mod) {
		int length = this.pos;
		this.pos = 0;

		byte[] temp = new byte[length];
		this.gdata(length, 0, -21, temp);
		BigInteger bigRaw = new BigInteger(temp);
		BigInteger bigEnc = bigRaw.modPow(exp, mod);
		byte[] rawEnc = bigEnc.toByteArray();

		this.pos = 0;
		this.p1(rawEnc.length);
		this.pdata(rawEnc, 0, rawEnc.length, 0);
	}

	@ObfuscatedName("MFMVIYHT.a(ZI)V")
	public void a(boolean arg0, int arg1) {
		this.data[this.pos++] = (byte) (arg1 + 128);
		if (arg0) {
			for (int var3 = 1; var3 > 0; ++var3) {
			}

		}
	}

	@ObfuscatedName("MFMVIYHT.c(BI)V")
	public void c(byte arg0, int arg1) {
		if (arg0 == 0) {
			boolean var3 = false;
		} else {
			for (int var4 = 1; var4 > 0; ++var4) {
			}
		}

		this.data[this.pos++] = (byte) (-arg1);
	}

	@ObfuscatedName("MFMVIYHT.c(II)V")
	public void c(int arg0, int arg1) {
		if (arg1 == 1) {
			this.data[this.pos++] = (byte) (128 - arg0);
		}
	}

	@ObfuscatedName("MFMVIYHT.h(I)I")
	public int h(int arg0) {
		return this.r != arg0 ? this.o : this.data[this.pos++] - 128 & 255;
	}

	@ObfuscatedName("MFMVIYHT.i(I)I")
	public int i(int arg0) {
		return arg0 != -34545 ? this.i : -this.data[this.pos++] & 255;
	}

	@ObfuscatedName("MFMVIYHT.j(I)I")
	public int j(int arg0) {
		int var2 = 77 / arg0;
		return 128 - this.data[this.pos++] & 255;
	}

	@ObfuscatedName("MFMVIYHT.k(I)B")
	public byte k(int arg0) {
		if (arg0 != 0) {
			for (int var2 = 1; var2 > 0; ++var2) {
			}
		}

		return (byte) (this.data[this.pos++] - 128);
	}

	@ObfuscatedName("MFMVIYHT.l(I)B")
	public byte l(int arg0) {
		if (arg0 != 0) {
			this.y = 54;
		}

		return (byte) (-this.data[this.pos++]);
	}

	@ObfuscatedName("MFMVIYHT.m(I)B")
	public byte m(int arg0) {
		if (arg0 != 43428) {
			for (int var2 = 1; var2 > 0; ++var2) {
			}
		}

		return (byte) (128 - this.data[this.pos++]);
	}

	@ObfuscatedName("MFMVIYHT.d(II)V")
	public void d(int arg0, int arg1) {
		this.data[this.pos++] = (byte) arg1;
		this.data[this.pos++] = (byte) (arg1 >> 8);
		if (arg0 != 0) {
			this.s = 403;
		}
	}

	@ObfuscatedName("MFMVIYHT.e(II)V")
	public void e(int arg0, int arg1) {
		this.data[this.pos++] = (byte) (arg0 >> 8);
		this.data[this.pos++] = (byte) (arg0 + 128);
		if (arg1 == 0) {
			;
		}
	}

	@ObfuscatedName("MFMVIYHT.f(II)V")
	public void f(int arg0, int arg1) {
		if (arg0 < 3 || arg0 > 3) {
			this.h = !this.h;
		}

		this.data[this.pos++] = (byte) (arg1 + 128);
		this.data[this.pos++] = (byte) (arg1 >> 8);
	}

	@ObfuscatedName("MFMVIYHT.n(I)I")
	public int n(int arg0) {
		this.pos += 2;
		return arg0 >= 0 ? 3 : ((this.data[this.pos - 1] & 255) << 8) + (this.data[this.pos - 2] & 255);
	}

	@ObfuscatedName("MFMVIYHT.b(B)I")
	public int b(byte arg0) {
		this.pos += 2;
		return arg0 != 9 ? this.s : ((this.data[this.pos - 2] & 255) << 8) + (this.data[this.pos - 1] - 128 & 255);
	}

	@ObfuscatedName("MFMVIYHT.o(I)I")
	public int o(int arg0) {
		this.pos += 2;
		if (arg0 >= 0) {
			this.s = 68;
		}

		return ((this.data[this.pos - 1] & 255) << 8) + (this.data[this.pos - 2] - 128 & 255);
	}

	@ObfuscatedName("MFMVIYHT.p(I)I")
	public int p(int arg0) {
		this.pos += 2;
		int var2 = ((this.data[this.pos - 1] & 255) << 8) + (this.data[this.pos - 2] & 255);

		while (arg0 >= 0) {
			for (int var3 = 1; var3 > 0; ++var3) {
			}
		}

		if (var2 > 32767) {
			var2 -= 65536;
		}

		return var2;
	}

	@ObfuscatedName("MFMVIYHT.c(B)I")
	public int c(byte arg0) {
		this.pos += 2;
		if (this.t != arg0) {
			this.n = !this.n;
		}

		int var2 = ((this.data[this.pos - 2] & 255) << 8) + (this.data[this.pos - 1] - 128 & 255);
		if (var2 > 32767) {
			var2 -= 65536;
		}

		return var2;
	}

	@ObfuscatedName("MFMVIYHT.q(I)I")
	public int q(int arg0) {
		this.pos += 3;
		return arg0 >= 0 ? 1 : (this.data[this.pos - 1] & 255) + ((this.data[this.pos - 2] & 255) << 16) + ((this.data[this.pos - 3] & 255) << 8);
	}

	@ObfuscatedName("MFMVIYHT.r(I)I")
	public int r(int arg0) {
		if (arg0 <= 0) {
			this.s = -453;
		}

		this.pos += 4;
		return (this.data[this.pos - 4] & 255) + ((this.data[this.pos - 3] & 255) << 8) + ((this.data[this.pos - 1] & 255) << 24) + ((this.data[this.pos - 2] & 255) << 16);
	}

	@ObfuscatedName("MFMVIYHT.s(I)I")
	public int s(int arg0) {
		if (arg0 < 3 || arg0 > 3) {
			this.s = -258;
		}

		this.pos += 4;
		return (this.data[this.pos - 3] & 255) + ((this.data[this.pos - 4] & 255) << 8) + ((this.data[this.pos - 2] & 255) << 24) + ((this.data[this.pos - 1] & 255) << 16);
	}

	@ObfuscatedName("MFMVIYHT.a(Z)I")
	public int a(boolean arg0) {
		this.pos += 4;
		if (!arg0) {
			for (int var2 = 1; var2 > 0; ++var2) {
			}
		}

		return (this.data[this.pos - 2] & 255) + ((this.data[this.pos - 1] & 255) << 8) + ((this.data[this.pos - 3] & 255) << 24) + ((this.data[this.pos - 4] & 255) << 16);
	}

	@ObfuscatedName("MFMVIYHT.a(B[BII)V")
	public void a(byte arg0, byte[] arg1, int arg2, int arg3) {
		if (arg0 == -73) {
			for (int var5 = arg2 + arg3 - 1; var5 >= arg3; --var5) {
				arg1[var5] = this.data[this.pos++];
			}

		}
	}

	@ObfuscatedName("MFMVIYHT.b([BIII)V")
	public void b(byte[] arg0, int arg1, int arg2, int arg3) {
		if (arg2 != 0) {
			this.k = !this.k;
		}

		for (int var5 = arg3; var5 < arg1 + arg3; ++var5) {
			arg0[var5] = (byte) (this.data[this.pos++] - 128);
		}

	}


}
