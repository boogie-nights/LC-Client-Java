package jagex2.io;

import deob.ObfuscatedName;

public class Jagfile {

	@ObfuscatedName("ATJMVOZR.c")
	public byte[] data;

	@ObfuscatedName("ATJMVOZR.d")
	public int fileCount;

	@ObfuscatedName("ATJMVOZR.e")
	public int[] fileHash;

	@ObfuscatedName("ATJMVOZR.f")
	public int[] fileUnpackedSize;

	@ObfuscatedName("ATJMVOZR.g")
	public int[] filePackedSize;

	@ObfuscatedName("ATJMVOZR.h")
	public int[] fileOffset;

	@ObfuscatedName("ATJMVOZR.i")
	public boolean unpacked;

	public Jagfile(byte[] src) {
		this.unpack(src);
	}

	@ObfuscatedName("ATJMVOZR.a(I[B)V")
	public void unpack(byte[] src) {
		Packet data = new Packet(src);
		int unpackedSize = data.g3();
		int packedSize = data.g3();

		if (unpackedSize == packedSize) {
			this.data = src;
			this.unpacked = false;
		} else {
			byte[] temp = new byte[unpackedSize];
			BZip2.decompress(temp, unpackedSize, src, packedSize, 6);
			this.data = temp;

			data = new Packet(this.data);
			this.unpacked = true;
		}

		this.fileCount = data.g2();
		this.fileHash = new int[this.fileCount];
		this.fileUnpackedSize = new int[this.fileCount];
		this.filePackedSize = new int[this.fileCount];
		this.fileOffset = new int[this.fileCount];

		int pos = this.fileCount * 10 + data.pos;
		for (int i = 0; i < this.fileCount; ++i) {
			this.fileHash[i] = data.g4();
			this.fileUnpackedSize[i] = data.g3();
			this.filePackedSize[i] = data.g3();
			this.fileOffset[i] = pos;
			pos += this.filePackedSize[i];
		}
	}

	@ObfuscatedName("ATJMVOZR.a(Ljava/lang/String;[B)[B")
	public byte[] read(String name, byte[] dst) {
		int hash = 0;
		String upper = name.toUpperCase();

		for (int i = 0; i < upper.length(); ++i) {
			hash = hash * 61 + upper.charAt(i) - 32;
		}

		for (int i = 0; i < this.fileCount; ++i) {
			if (this.fileHash[i] == hash) {
				if (dst == null) {
					dst = new byte[this.fileUnpackedSize[i]];
				}

				if (this.unpacked) {
					for (int j = 0; j < this.fileUnpackedSize[i]; ++j) {
						dst[j] = this.data[this.fileOffset[i] + j];
					}
				} else {
					BZip2.decompress(dst, this.fileUnpackedSize[i], this.data, this.filePackedSize[i], this.fileOffset[i]);
				}

				return dst;
			}
		}

		return null;
	}
}
