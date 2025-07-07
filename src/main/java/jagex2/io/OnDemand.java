package jagex2.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;

import deob.ObfuscatedName;
import jagex2.client.Client;
import jagex2.client.sign.Signlink;
import jagex2.datastruct.DoublyLinkList;
import jagex2.datastruct.LinkList;

public class OnDemand extends OnDemandProvider implements Runnable {

	@ObfuscatedName("ZPGPWCCV.e")
	public byte[][] priorities = new byte[4][];

	@ObfuscatedName("ZPGPWCCV.f")
	public boolean active = false;

	@ObfuscatedName("ZPGPWCCV.g")
	public boolean running = true;

	@ObfuscatedName("ZPGPWCCV.h")
	public LinkList queue = new LinkList();

	@ObfuscatedName("ZPGPWCCV.l")
	public int[][] crcs = new int[4][];

	@ObfuscatedName("ZPGPWCCV.o")
	public String message = "";

	@ObfuscatedName("ZPGPWCCV.s")
	public LinkList s = new LinkList();

	@ObfuscatedName("ZPGPWCCV.t")
	public boolean t = false;

	@ObfuscatedName("ZPGPWCCV.v")
	public CRC32 crc32 = new CRC32();

	@ObfuscatedName("ZPGPWCCV.x")
	public boolean x = false;

	@ObfuscatedName("ZPGPWCCV.y")
	public LinkList completed = new LinkList();

	@ObfuscatedName("ZPGPWCCV.z")
	public LinkList z = new LinkList();

	@ObfuscatedName("ZPGPWCCV.A")
	public byte[] data = new byte[65000];

	@ObfuscatedName("ZPGPWCCV.F")
	public byte[] buf = new byte[500];

	@ObfuscatedName("ZPGPWCCV.I")
	public int I = 591;

	@ObfuscatedName("ZPGPWCCV.K")
	public DoublyLinkList requests = new DoublyLinkList(true);

	@ObfuscatedName("ZPGPWCCV.M")
	public byte M = 6;

	@ObfuscatedName("ZPGPWCCV.P")
	public LinkList pending = new LinkList();

	@ObfuscatedName("ZPGPWCCV.S")
	public int[][] versions = new int[4][];

	@ObfuscatedName("ZPGPWCCV.V")
	public boolean V = false;

	@ObfuscatedName("ZPGPWCCV.C")
	public int partOffet;

	@ObfuscatedName("ZPGPWCCV.D")
	public int partAvailable;

	@ObfuscatedName("ZPGPWCCV.E")
	public int E;

	@ObfuscatedName("ZPGPWCCV.J")
	public int J;

	@ObfuscatedName("ZPGPWCCV.Q")
	public int heartBeatCycle;

	@ObfuscatedName("ZPGPWCCV.U")
	public int U;

	@ObfuscatedName("ZPGPWCCV.b")
	public int b;

	@ObfuscatedName("ZPGPWCCV.i")
	public int topPriority;

	@ObfuscatedName("ZPGPWCCV.j")
	public int importantCount;

	@ObfuscatedName("ZPGPWCCV.k")
	public int k;

	@ObfuscatedName("ZPGPWCCV.m")
	public int m;

	@ObfuscatedName("ZPGPWCCV.p")
	public int cycle;

	@ObfuscatedName("ZPGPWCCV.r")
	public int r;

	@ObfuscatedName("ZPGPWCCV.u")
	public int waitCycles;

	@ObfuscatedName("ZPGPWCCV.T")
	public long T;

	@ObfuscatedName("ZPGPWCCV.N")
	public OnDemandRequest current;

	@ObfuscatedName("ZPGPWCCV.O")
	public Client app;

	@ObfuscatedName("ZPGPWCCV.c")
	public byte[] models;

	@ObfuscatedName("ZPGPWCCV.B")
	public int[] mapLand;

	@ObfuscatedName("ZPGPWCCV.G")
	public int[] mapLoc;

	@ObfuscatedName("ZPGPWCCV.H")
	public int[] midiIndex;

	@ObfuscatedName("ZPGPWCCV.R")
	public int[] animIndex;

	@ObfuscatedName("ZPGPWCCV.d")
	public int[] mapMembers;

	@ObfuscatedName("ZPGPWCCV.n")
	public int[] mapIndex;

	@ObfuscatedName("ZPGPWCCV.L")
	public InputStream in;

	@ObfuscatedName("ZPGPWCCV.q")
	public OutputStream out;

	@ObfuscatedName("ZPGPWCCV.w")
	public Socket socket;

	@ObfuscatedName("ZPGPWCCV.a(LATJMVOZR;Lclient;)V")
	public final void unpack(Jagfile versionlist, Client c) {
		String[] version = new String[]{"model_version", "anim_version", "midi_version", "map_version"};

		for (int i = 0; i < 4; ++i) {
			byte[] data = versionlist.read(version[i], null);
			int count = data.length / 2;
			Packet buf = new Packet(data);

			this.versions[i] = new int[count];
			this.priorities[i] = new byte[count];

			for (int j = 0; j < count; j++) {
				this.versions[i][j] = buf.g2();
			}
		}

		String[] crc = new String[]{"model_crc", "anim_crc", "midi_crc", "map_crc"};

		for (int i = 0; i < 4; ++i) {
			byte[] data = versionlist.read(crc[i], null);
			int count = data.length / 4;
			Packet buf = new Packet(data);

			this.crcs[i] = new int[count];

			for (int j = 0; j < count; ++j) {
				this.crcs[i][j] = buf.g4();
			}
		}

		byte[] data = versionlist.read("model_index", null);
		int count = this.versions[0].length;

		this.models = new byte[count];

		for (int i = 0; i < count; ++i) {
			if (i < data.length) {
				this.models[i] = data[i];
			} else {
				this.models[i] = 0;
			}
		}

		data = versionlist.read("map_index", null);
		Packet buf = new Packet(data);
		count = data.length / 7;

		this.mapIndex = new int[count];
		this.mapLand = new int[count];
		this.mapLoc = new int[count];
		this.mapMembers = new int[count];

		for (int i = 0; i < count; i++) {
			this.mapIndex[i] = buf.g2();
			this.mapLand[i] = buf.g2();
			this.mapLoc[i] = buf.g2();
			this.mapMembers[i] = buf.g1();
		}

		data = versionlist.read("anim_index", null);
		buf = new Packet(data);
		count = data.length / 2;

		this.animIndex = new int[count];

		for (int i = 0; i < count; i++) {
			this.animIndex[i] = buf.g2();
		}

		data = versionlist.read("midi_index", null);
		buf = new Packet(data);
		count = data.length;

		this.midiIndex = new int[count];

		for (int i = 0; i < count; ++i) {
			this.midiIndex[i] = buf.g1();
		}

		this.app = c;
		this.running = true;
		this.app.startThread(this, 2);
	}

	@ObfuscatedName("ZPGPWCCV.c()V")
	public final void stop() {
		this.running = false;
	}

	@ObfuscatedName("ZPGPWCCV.c(II)I")
	public final int getFileCount(int archive) {
		return this.versions[archive].length;
	}

	@ObfuscatedName("ZPGPWCCV.a(Z)V")
	public final void read() {
		try {
			int available = this.in.available();

			if (this.partAvailable == 0 && available >= 6) {
				this.active = true;

				for (int off = 0; off < 6; off += this.in.read(this.buf, off, 6 - off)) {
				}

				int archive = this.buf[0] & 0xFF;
				int file = ((this.buf[1] & 0xFF) << 8) + (this.buf[2] & 0xFF);
				int size = ((this.buf[3] & 0xFF) << 8) + (this.buf[4] & 0xFF);
				int part = this.buf[5] & 0xFF;

				this.current = null;

				for (OnDemandRequest req = (OnDemandRequest) this.pending.head(); req != null; req = (OnDemandRequest) this.pending.next(1)) {
					if (req.archive == archive && req.file == file) {
						this.current = req;
					}

					if (this.current != null) {
						req.cycle = 0;
					}
				}

				if (this.current != null) {
					this.waitCycles = 0;

					if (size == 0) {
						Signlink.reporterror("Rej: " + archive + "," + file);

						this.current.data = null;

						if (this.current.urgent) {
							LinkList lock = this.completed;
							synchronized (lock) {
								this.completed.push(this.current);
							}
						} else {
							this.current.unlink();
						}

						this.current = null;
					} else {
						if (this.current.data == null && part == 0) {
							this.current.data = new byte[size];
						}

						if (this.current.data == null && part != 0) {
							throw new IOException("missing start of file");
						}
					}
				}

				this.partOffet = part * 500;
				this.partAvailable = 500;

				if (this.partAvailable > size - part * 500) {
					this.partAvailable = size - part * 500;
				}
			}

			if (this.partAvailable > 0 && available >= this.partAvailable) {
				this.active = true;

				byte[] dst = this.buf;
				int off = 0;

				if (this.current != null) {
					dst = this.current.data;
					off = this.partOffet;
				}

				for (int n = 0; n < this.partAvailable; n += this.in.read(dst, off + n, this.partAvailable - n)) {
				}

				if (this.partAvailable + this.partOffet >= dst.length && this.current != null) {
					if (this.app.fileStreams[0] != null) {
						this.app.fileStreams[this.current.archive + 1].a(dst.length, true, dst, this.current.file);
					}

					if (!this.current.urgent && this.current.archive == 3) {
						this.current.urgent = true;
						this.current.archive = 93;
					}

					if (this.current.urgent) {
						LinkList lock = this.completed;
						synchronized (lock) {
							this.completed.push(this.current);
						}
					} else {
						this.current.unlink();
					}
				}

				this.partAvailable = 0;
			}
		} catch (IOException ignore) {
			try {
				this.socket.close();
			} catch (Exception ignored) {
			}

			this.socket = null;
			this.in = null;
			this.out = null;
			this.partAvailable = 0;
		}
	}

	@ObfuscatedName("ZPGPWCCV.a(II)I")
	public final int a(int arg0, int arg1) {
		return arg1 < 0 ? this.models[arg0] & 255 : this.I;
	}

	@ObfuscatedName("ZPGPWCCV.a(I)V")
	public final void requestModel(int id) {
		this.request(0, id);
	}

	@ObfuscatedName("ZPGPWCCV.b(I)V")
	public final void b(int arg0) {
		if (arg0 == 0) {
			while (this.importantCount == 0) {
				if (this.k >= 10 || this.topPriority == 0) {
					return;
				}

				LinkList var2 = this.z;
				OnDemandRequest var3;
				synchronized (this.z) {
					var3 = (OnDemandRequest) this.z.pop();
				}

				while (var3 != null) {
					if (this.priorities[var3.archive][var3.file] != 0) {
						this.priorities[var3.archive][var3.file] = 0;
						this.pending.push(var3);
						this.send(this.m, var3);
						this.active = true;
						if (this.b < this.r) {
							++this.b;
						}

						this.message = "Loading extra files - " + this.b * 100 / this.r + "%";
						++this.k;
						if (this.k == 10) {
							return;
						}
					}

					LinkList var4 = this.z;
					synchronized (this.z) {
						var3 = (OnDemandRequest) this.z.pop();
					}
				}

				for (int var5 = 0; var5 < 4; ++var5) {
					byte[] var6 = this.priorities[var5];
					int var7 = var6.length;

					for (int var8 = 0; var8 < var7; ++var8) {
						if (var6[var8] == this.topPriority) {
							var6[var8] = 0;
							OnDemandRequest var9 = new OnDemandRequest();
							var9.archive = var5;
							var9.file = var8;
							var9.urgent = false;
							this.pending.push(var9);
							this.send(this.m, var9);
							this.active = true;
							if (this.b < this.r) {
								++this.b;
							}

							this.message = "Loading extra files - " + this.b * 100 / this.r + "%";
							++this.k;
							if (this.k == 10) {
								return;
							}
						}
					}
				}

				--this.topPriority;
			}

		}
	}

	@ObfuscatedName("ZPGPWCCV.a(IIBI)V")
	public final void a(int arg0, int arg1, byte arg2, int arg3) {
		if (arg0 < 0) {
			if (this.app.fileStreams[0] != null) {
				if (this.versions[arg1][arg3] != 0) {
					byte[] var5 = this.app.fileStreams[arg1 + 1].a(this.M, arg3);
					if (!this.a(var5, 764, this.versions[arg1][arg3], this.crcs[arg1][arg3])) {
						this.priorities[arg1][arg3] = arg2;
						if (arg2 > this.topPriority) {
							this.topPriority = arg2;
						}

						++this.r;
					}
				}
			}
		}
	}

	@ObfuscatedName("ZPGPWCCV.a(IZ)Z")
	public final boolean shouldPrefectMidi(int id) {
		return this.midiIndex[id] == 1;
	}

	@ObfuscatedName("ZPGPWCCV.b(II)V")
	public final void request(int archive, int file) {
		if (archive < 0 || archive > this.versions.length || file < 0 || file > this.versions[archive].length || this.versions[archive][file] == 0) {
			return;
		}

		DoublyLinkList lock = this.requests;
		synchronized (lock) {
			for (OnDemandRequest req = (OnDemandRequest) this.requests.b(); req != null; req = (OnDemandRequest) this.requests.a(1)) {
				if (req.archive == archive && req.file == file) {
					return;
				}
			}

			OnDemandRequest req = new OnDemandRequest();
			req.archive = archive;
			req.file = file;
			req.urgent = true;

			LinkList lock2 = this.queue;
			synchronized (lock2) {
				this.queue.push(req);
			}

			this.requests.push(req);
		}
	}

	@ObfuscatedName("ZPGPWCCV.a()LQSLIGKQQ;")
	public final OnDemandRequest cycle() {
		LinkList lock = this.completed;

		OnDemandRequest req;
		synchronized (lock) {
			req = (OnDemandRequest) this.completed.pop();
		}

		if (req == null) {
			return null;
		}

		DoublyLinkList lock2 = this.requests;
		synchronized (lock2) {
			req.unlink2();
		}

		if (req.data == null) {
			return req;
		}

		int pos = 0;
		try {
			GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(req.data));

			while (true) {
				if (this.data.length == pos) {
					throw new RuntimeException("buffer overflow!");
				}

				int n = gzip.read(this.data, pos, this.data.length - pos);
				if (n == -1) {
					break;
				}

				pos += n;
			}
		} catch (IOException ignore) {
			throw new RuntimeException("error unzipping");
		}

		req.data = new byte[pos];
		for (int i = 0; i < pos; ++i) {
			req.data[i] = this.data[i];
		}
		return req;
	}

	public final void run() {
		try {
			while (this.running) {
				this.cycle++;

				byte del = 20;
				if (this.topPriority == 0 && this.app.fileStreams[0] != null) {
					del = 50;
				}

				try {
					Thread.sleep(del);
				} catch (Exception ignore) {
				}

				this.active = true;

				for (int i = 0; i < 100 && this.active; ++i) {
					this.active = false;

					this.b(true);
					this.c(0);

					if (this.importantCount == 0 && i >= 5) {
						break;
					}

					this.b(0);

					if (this.in != null) {
						this.read();
					}
				}

				boolean loading = false;

				for (OnDemandRequest req = (OnDemandRequest) this.pending.head(); req != null; req = (OnDemandRequest) this.pending.next(1)) {
					if (req.urgent) {
						loading = true;
						req.cycle++;

						if (req.cycle > 50) {
							req.cycle = 0;
							this.send(this.m, req);
						}
					}
				}

				if (!loading) {
					for (OnDemandRequest req = (OnDemandRequest) this.pending.head(); req != null; req = (OnDemandRequest) this.pending.next(1)) {
						loading = true;
						req.cycle++;

						if (req.cycle > 50) {
							req.cycle = 0;
							this.send(this.m, req);
						}
					}
				}

				if (loading) {
					++this.waitCycles;
					if (this.waitCycles > 750) {
						try {
							this.socket.close();
						} catch (Exception var8) {
						}

						this.socket = null;
						this.in = null;
						this.out = null;
						this.partAvailable = 0;
					}
				} else {
					this.waitCycles = 0;
					this.message = "";
				}

				if (this.app.ingame && this.socket != null && this.out != null && (this.topPriority > 0 || this.app.fileStreams[0] == null)) {
					this.heartBeatCycle++;

					if (this.heartBeatCycle > 500) {
						this.heartBeatCycle = 0;
						this.buf[0] = 0;
						this.buf[1] = 0;
						this.buf[2] = 0;
						this.buf[3] = 10;

						try {
							this.out.write(this.buf, 0, 4);
						} catch (IOException ignore) {
							this.waitCycles = 5000;
						}
					}
				}
			}

		} catch (Exception ex) {
			Signlink.reporterror("od_ex " + ex.getMessage());
		}
	}

	@ObfuscatedName("ZPGPWCCV.c(I)V")
	public final void c(int arg0) {
		this.importantCount = 0;
		this.k = 0;
		if (arg0 == 0) {
			for (OnDemandRequest var2 = (OnDemandRequest) this.pending.head(); var2 != null; var2 = (OnDemandRequest) this.pending.next(1)) {
				if (var2.urgent) {
					++this.importantCount;
				} else {
					++this.k;
				}
			}

			while (this.importantCount < 10) {
				OnDemandRequest var3 = (OnDemandRequest) this.s.pop();
				if (var3 == null) {
					break;
				}

				if (this.priorities[var3.archive][var3.file] != 0) {
					++this.b;
				}

				this.priorities[var3.archive][var3.file] = 0;
				this.pending.push(var3);
				++this.importantCount;
				this.send(this.m, var3);
				this.active = true;
			}

		}
	}

	@ObfuscatedName("ZPGPWCCV.a(ZB)V")
	public final void a(boolean arg0, byte arg1) {
		if (arg1 != 109) {
			this.t = !this.t;
		}

		int var3 = this.mapIndex.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			if (arg0 || this.mapMembers[var4] != 0) {
				this.a(-44, 3, (byte) 2, this.mapLoc[var4]);
				this.a(-44, 3, (byte) 2, this.mapLand[var4]);
			}
		}

	}

	@ObfuscatedName("ZPGPWCCV.b()I")
	public final int b() {
		DoublyLinkList var1 = this.requests;
		synchronized (this.requests) {
		}

		int var2;
		try {
			var2 = this.requests.c();
		} catch (Throwable var5) {
			throw var5;
		}

		return var2;
	}

	@ObfuscatedName("ZPGPWCCV.b(IZ)Z")
	public final boolean b(int arg0, boolean arg1) {
		for (int var3 = 0; var3 < this.mapIndex.length; ++var3) {
			if (this.mapLoc[var3] == arg0) {
				return true;
			}
		}

		if (arg1) {
			this.E = -405;
		}

		return false;
	}

	@ObfuscatedName("ZPGPWCCV.a(B)V")
	public final void a(byte arg0) {
		LinkList var2 = this.z;
		synchronized (this.z) {
			this.z.c();
		}

		if (arg0 != -125) {
			this.t = !this.t;
		}
	}

	@ObfuscatedName("ZPGPWCCV.a(IIB)V")
	public final void a(int arg0, int arg1, byte arg2) {
		if (this.app.fileStreams[0] != null) {
			if (this.versions[arg1][arg0] != 0) {
				if (this.priorities[arg1][arg0] != 0) {
					if (this.topPriority != 0) {
						OnDemandRequest var4 = new OnDemandRequest();
						if (arg2 != -113) {
							this.I = 244;
						}

						var4.archive = arg1;
						var4.file = arg0;
						var4.urgent = false;
						LinkList var5 = this.z;
						synchronized (this.z) {
							this.z.push(var4);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("ZPGPWCCV.b(Z)V")
	public final void b(boolean arg0) {
		LinkList var2 = this.queue;
		OnDemandRequest var3;
		synchronized (this.queue) {
			var3 = (OnDemandRequest) this.queue.pop();
		}

		if (!arg0) {
			for (int var4 = 1; var4 > 0; ++var4) {
			}
		}

		while (var3 != null) {
			this.active = true;
			byte[] var5 = null;
			if (this.app.fileStreams[0] != null) {
				var5 = this.app.fileStreams[var3.archive + 1].a(this.M, var3.file);
			}

			if (!this.a(var5, 764, this.versions[var3.archive][var3.file], this.crcs[var3.archive][var3.file])) {
				var5 = null;
			}

			LinkList var6 = this.queue;
			synchronized (this.queue) {
				if (var5 == null) {
					this.s.push(var3);
				} else {
					var3.data = var5;
					LinkList var7 = this.completed;
					synchronized (this.completed) {
						this.completed.push(var3);
					}
				}

				var3 = (OnDemandRequest) this.queue.pop();
			}
		}

	}

	@ObfuscatedName("ZPGPWCCV.a([BIII)Z")
	public final boolean a(byte[] arg0, int arg1, int arg2, int arg3) {
		int var5 = 22 / arg1;
		if (arg0 != null && arg0.length >= 2) {
			int var6 = arg0.length - 2;
			int var7 = ((arg0[var6] & 255) << 8) + (arg0[var6 + 1] & 255);
			this.crc32.reset();
			this.crc32.update(arg0, 0, var6);
			int var8 = (int) this.crc32.getValue();
			if (arg2 != var7) {
				return false;
			} else {
				return arg3 == var8;
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("ZPGPWCCV.a(ILQSLIGKQQ;)V")
	public final void send(int arg0, OnDemandRequest arg1) {
		if (arg0 == 0) {
			try {
				if (this.socket == null) {
					long var3 = System.currentTimeMillis();
					if (var3 - this.T < 4000L) {
						return;
					}

					this.T = var3;
					this.socket = this.app.g(Client.tc + 43594);
					this.in = this.socket.getInputStream();
					this.out = this.socket.getOutputStream();
					this.out.write(15);

					for (int var5 = 0; var5 < 8; ++var5) {
						this.in.read();
					}

					this.waitCycles = 0;
				}

				this.buf[0] = (byte) arg1.archive;
				this.buf[1] = (byte) (arg1.file >> 8);
				this.buf[2] = (byte) arg1.file;
				if (arg1.urgent) {
					this.buf[3] = 2;
				} else if (!this.app.ingame) {
					this.buf[3] = 1;
				} else {
					this.buf[3] = 0;
				}

				this.out.write(this.buf, 0, 4);
				this.heartBeatCycle = 0;
				this.U = -10000;
			} catch (IOException var8) {
				try {
					this.socket.close();
				} catch (Exception var7) {
				}

				this.socket = null;
				this.in = null;
				this.out = null;
				this.partAvailable = 0;
				++this.U;
			}
		}
	}

	@ObfuscatedName("ZPGPWCCV.d(I)I")
	public final int d(int arg0) {
		int var2 = 0 / arg0;
		return this.animIndex.length;
	}

	@ObfuscatedName("ZPGPWCCV.a(IIII)I")
	public final int getMapFile(int arg0, int arg1, int arg2, int arg3) {
		if (arg0 != 0) {
			return 1;
		} else {
			int var5 = (arg1 << 8) + arg2;

			for (int var6 = 0; var6 < this.mapIndex.length; ++var6) {
				if (this.mapIndex[var6] == var5) {
					if (arg3 == 0) {
						return this.mapLand[var6];
					}

					return this.mapLoc[var6];
				}
			}
			return -1;
		}
	}
}
