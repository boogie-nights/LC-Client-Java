package jagex2.client;

import java.applet.AppletContext;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;

import deob.*;
import jagex2.config.VarbitType;
import jagex2.dash3d.*;
import jagex2.datastruct.JString;
import jagex2.datastruct.LinkList;
import jagex2.datastruct.Linkable;
import jagex2.graphics.*;
import jagex2.io.*;
import jagex2.sound.Wave;
import jagex2.wordenc.WordFilter;
import jagex2.wordenc.WordPack;

public class Client extends GameShell {
   @ObfuscatedName("client.K")
   public int[] K = new int[9];
   @ObfuscatedName("client.M")
   public String M = "";
   @ObfuscatedName("client.P")
   public int[] P = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
   @ObfuscatedName("client.Q")
   public int[] Q = new int[Stats.a];
   @ObfuscatedName("client.W")
   public String[] W = new String[200];
   @ObfuscatedName("client.Z")
   public int[] Z = new int[5];
   @ObfuscatedName("client.bb")
   public int bb = 2;
   @ObfuscatedName("client.ib")
   public String ib = "";
   @ObfuscatedName("client.kb")
   public String[] kb = new String[100];
   @ObfuscatedName("client.lb")
   public int[] lb = new int[100];
   @ObfuscatedName("client.nb")
   public boolean nb = false;
   @ObfuscatedName("client.Ab")
   public int[][][] Ab = new int[4][13][13];
   @ObfuscatedName("client.Gb")
   public int[][] Gb = new int[104][104];
   @ObfuscatedName("client.Hb")
   public int[][] Hb = new int[104][104];
   @ObfuscatedName("client.Nb")
   public boolean Nb = false;
   @ObfuscatedName("client.Pb")
   public int Pb = -992;
   @ObfuscatedName("client.Rb")
   public Pix24[] Rb = new Pix24[8];
   @ObfuscatedName("client.Sb")
   public int Sb = 559;
   @ObfuscatedName("client.Tb")
   public byte Tb = 6;
   @ObfuscatedName("client.Vb")
   public boolean Vb = false;
   @ObfuscatedName("client.Wb")
   public byte Wb = -123;
   @ObfuscatedName("client.mc")
   public int mc = 2;
   @ObfuscatedName("client.nc")
   public boolean nc = true;
   @ObfuscatedName("client.oc")
   public boolean oc = true;
   @ObfuscatedName("client.pc")
   public int[] pc = new int[151];
   @ObfuscatedName("client.qc")
   public int qc = 8;
   @ObfuscatedName("client.wc")
   public boolean[] wc = new boolean[5];
   @ObfuscatedName("client.xc")
   public int xc = -188;
   @ObfuscatedName("client.yc")
   public Packet yc = Packet.alloc(1);
   @ObfuscatedName("client.Ac")
   public int Ac = 2301979;
   @ObfuscatedName("client.Bc")
   public int Bc = -1;
   @ObfuscatedName("client.Cc")
   public int Cc = -1;
   @ObfuscatedName("client.Dc")
   public boolean Dc = true;
   @ObfuscatedName("client.Ec")
   public int Ec = -1;
   @ObfuscatedName("client.Fc")
   public byte Fc = -113;
   @ObfuscatedName("client.Gc")
   public String Gc = "";
   @ObfuscatedName("client.Hc")
   public int Hc = -214;
   @ObfuscatedName("client.Jc")
   public int Jc = 50;
   @ObfuscatedName("client.Kc")
   public int[] Kc = new int[this.Jc];
   @ObfuscatedName("client.Lc")
   public int[] Lc = new int[this.Jc];
   @ObfuscatedName("client.Mc")
   public int[] Mc = new int[this.Jc];
   @ObfuscatedName("client.Nc")
   public int[] Nc = new int[this.Jc];
   @ObfuscatedName("client.Oc")
   public int[] Oc = new int[this.Jc];
   @ObfuscatedName("client.Pc")
   public int[] Pc = new int[this.Jc];
   @ObfuscatedName("client.Qc")
   public int[] Qc = new int[this.Jc];
   @ObfuscatedName("client.Rc")
   public String[] Rc = new String[this.Jc];
   @ObfuscatedName("client.Sc")
   public String Sc = "";
   @ObfuscatedName("client.Tc")
   public boolean Tc = false;
   @ObfuscatedName("client.Wc")
   public boolean Wc = false;
   @ObfuscatedName("client.Xc")
   public Pix24[] Xc = new Pix24[32];
   @ObfuscatedName("client.Zc")
   public byte Zc = 1;
   @ObfuscatedName("client.ad")
   public String ad = "";
   @ObfuscatedName("client.bd")
   public String bd = "";
   @ObfuscatedName("client.cd")
   public boolean cd = true;
   @ObfuscatedName("client.dd")
   public int dd = -1;
   @ObfuscatedName("client.ed")
   public int ed = -1;
   @ObfuscatedName("client.hd")
   public Packet hd = Packet.alloc(1);
   @ObfuscatedName("client.ld")
   public int ld = 2048;
   @ObfuscatedName("client.md")
   public int md = 2047;
   @ObfuscatedName("client.nd")
   public ClientPlayer[] nd = new ClientPlayer[this.ld];
   @ObfuscatedName("client.pd")
   public int[] pd = new int[this.ld];
   @ObfuscatedName("client.rd")
   public int[] rd = new int[this.ld];
   @ObfuscatedName("client.sd")
   public Packet[] sd = new Packet[this.ld];
   @ObfuscatedName("client.td")
   public Pix8[] td = new Pix8[13];
   @ObfuscatedName("client.wd")
   public int[] wd = new int[500];
   @ObfuscatedName("client.xd")
   public int[] xd = new int[500];
   @ObfuscatedName("client.yd")
   public int[] yd = new int[500];
   @ObfuscatedName("client.zd")
   public int[] zd = new int[500];
   @ObfuscatedName("client.Fd")
   public int Fd = -1;
   @ObfuscatedName("client.Id")
   public int[] Id = new int[5];
   @ObfuscatedName("client.Wd")
   public int[] Wd = new int[2000];
   @ObfuscatedName("client.be")
   public int be = 2;
   @ObfuscatedName("client.fe")
   public boolean fe = false;
   @ObfuscatedName("client.he")
   public boolean he = false;
   @ObfuscatedName("client.ke")
   public int[] ke = new int[151];
   @ObfuscatedName("client.re")
   public String re = "";
   @ObfuscatedName("client.te")
   public boolean te = false;
   @ObfuscatedName("client.ue")
   public int[] ue = new int[Stats.a];
   @ObfuscatedName("client.we")
   public Pix24[] we = new Pix24[100];
   @ObfuscatedName("client.xe")
   public final int[] xe = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
   @ObfuscatedName("client.ye")
   public boolean ye = false;
   @ObfuscatedName("client.De")
   public boolean De = true;
   @ObfuscatedName("client.Ee")
   public int[] Ee = new int[2000];
   @ObfuscatedName("client.Le")
   public boolean Le = false;
   @ObfuscatedName("client.Qe")
   public int Qe = 69;
   @ObfuscatedName("client.Se")
   public int Se = -1;
   @ObfuscatedName("client.Te")
   public int[] Te = new int[Stats.a];
   @ObfuscatedName("client.Ue")
   public int Ue = 2;
   @ObfuscatedName("client.Ve")
   public int Ve = 3;
   @ObfuscatedName("client.ef")
   public boolean ef = false;
   @ObfuscatedName("client.ff")
   public byte ff = 1;
   @ObfuscatedName("client.gf")
   public boolean gf = false;
   @ObfuscatedName("client.jf")
   public String[] jf = new String[5];
   @ObfuscatedName("client.kf")
   public boolean[] kf = new boolean[5];
   @ObfuscatedName("client.mf")
   public int mf = 20411;
   @ObfuscatedName("client.nf")
   public long[] nf = new long[100];
   @ObfuscatedName("client.of")
   public boolean of = false;
   @ObfuscatedName("client.rf")
   public int[] rf = new int[1000];
   @ObfuscatedName("client.sf")
   public int[] sf = new int[1000];
   @ObfuscatedName("client.tf")
   public Pix24[] tf = new Pix24[32];
   @ObfuscatedName("client.uf")
   public int uf = 5063219;
   @ObfuscatedName("client.vf")
   public int[] vf = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("client.Cf")
   public CRC32 Cf = new CRC32();
   @ObfuscatedName("client.Df")
   public int Df = -1;
   @ObfuscatedName("client.Ef")
   public int[] Ef = new int[50];
   @ObfuscatedName("client.Gf")
   public String Gf = "";
   @ObfuscatedName("client.Hf")
   public String Hf = "";
   @ObfuscatedName("client.Lf")
   public boolean Lf = false;
   @ObfuscatedName("client.Mf")
   public boolean Mf = false;
   @ObfuscatedName("client.Nf")
   public int[] Nf = new int[5];
   @ObfuscatedName("client.Sf")
   public String Sf = "";
   @ObfuscatedName("client.Tf")
   public int[] Tf = new int[5];
   @ObfuscatedName("client.Vf")
   public int Vf = 78;
   @ObfuscatedName("client.hg")
   public int hg = -30658;
   @ObfuscatedName("client.lg")
   public int[] lg = new int[4000];
   @ObfuscatedName("client.mg")
   public int[] mg = new int[4000];
   @ObfuscatedName("client.pg")
   public boolean pg = false;
   @ObfuscatedName("client.sg")
   public long[] sg = new long[200];
   @ObfuscatedName("client.tg")
   public Packet tg = new Packet(new byte[5000]);
   @ObfuscatedName("client.ug")
   public ClientNpc[] ug = new ClientNpc[16384];
   @ObfuscatedName("client.wg")
   public int[] wg = new int[16384];
   @ObfuscatedName("client.xg")
   public int xg = 7759444;
   @ObfuscatedName("client.yg")
   public boolean yg = false;
   @ObfuscatedName("client.zg")
   public boolean zg = false;
   @ObfuscatedName("client.Cg")
   public int Cg = -110;
   @ObfuscatedName("client.Eg")
   public Pix8[] Eg = new Pix8[2];
   @ObfuscatedName("client.Fg")
   public byte Fg = -80;
   @ObfuscatedName("client.Gg")
   public boolean Gg = true;
   @ObfuscatedName("client.Hg")
   public int[] Hg = new int[5];
   @ObfuscatedName("client.Pg")
   public Pix8[] Pg = new Pix8[100];
   @ObfuscatedName("client.Qg")
   public int Qg = -916;
   @ObfuscatedName("client.Rg")
   public boolean Rg = false;
   @ObfuscatedName("client.Xg")
   public byte Xg = 97;
   @ObfuscatedName("client.Zg")
   public boolean Zg = false;
   @ObfuscatedName("client.ch")
   public int[] ch = new int[256];
   @ObfuscatedName("client.fh")
   public int fh = -1;
   @ObfuscatedName("client.lh")
   public int lh = -89;
   @ObfuscatedName("client.oh")
   public int oh = 300;
   @ObfuscatedName("client.qh")
   public int[] qh = new int[33];
   @ObfuscatedName("client.rh")
   public boolean rh = false;
   @ObfuscatedName("client.sh")
   public Pix24[] sh = new Pix24[20];
   @ObfuscatedName("client.uh")
   public String[] uh = new String[500];
   @ObfuscatedName("client.yh")
   public Packet yh = Packet.alloc(1);
   @ObfuscatedName("client.zh")
   public int[][] zh = new int[104][104];
   @ObfuscatedName("client.Bh")
   public int Bh = -1;
   @ObfuscatedName("client.Th")
   public boolean Th = false;
   @ObfuscatedName("client.Uh")
   public LinkList Uh = new LinkList();
   @ObfuscatedName("client.Vh")
   public boolean Vh = false;
   @ObfuscatedName("client.Wh")
   public boolean Wh = false;
   @ObfuscatedName("client.Xh")
   public int Xh = -1;
   @ObfuscatedName("client.mi")
   public FileStream[] mi = new FileStream[5];
   @ObfuscatedName("client.pi")
   public int pi = -1;
   @ObfuscatedName("client.si")
   public int si = 1;
   @ObfuscatedName("client.ui")
   public int ui = 326;
   @ObfuscatedName("client.xi")
   public boolean xi = false;
   @ObfuscatedName("client.yi")
   public boolean yi = false;
   @ObfuscatedName("client.Bi")
   public volatile boolean Bi = false;
   @ObfuscatedName("client.Di")
   public byte[] Di = new byte[16384];
   @ObfuscatedName("client.Hi")
   public Component Hi = new Component();
   @ObfuscatedName("client.Ji")
   public int Ji = 128;
   @ObfuscatedName("client.Oi")
   public int Oi = 1;
   @ObfuscatedName("client.Pi")
   public final int Pi = 100;
   @ObfuscatedName("client.Qi")
   public int[] Qi = new int[100];
   @ObfuscatedName("client.Ri")
   public int[] Ri = new int[50];
   @ObfuscatedName("client.Si")
   public CollisionMap[] Si = new CollisionMap[4];
   @ObfuscatedName("client.Ti")
   public LinkList Ti = new LinkList();
   @ObfuscatedName("client.Xi")
   public boolean Xi = false;
   @ObfuscatedName("client.Yi")
   public boolean Yi = true;
   @ObfuscatedName("client.Zi")
   public int[] Zi = new int[200];
   @ObfuscatedName("client.dj")
   public boolean dj = true;
   @ObfuscatedName("client.ej")
   public int ej = -1;
   @ObfuscatedName("client.gj")
   public boolean gj = true;
   @ObfuscatedName("client.hj")
   public boolean hj = true;
   @ObfuscatedName("client.ij")
   public int ij = -1;
   @ObfuscatedName("client.jj")
   public boolean jj = false;
   @ObfuscatedName("client.kj")
   public Pix24[] kj = new Pix24[1000];
   @ObfuscatedName("client.lj")
   public int lj = -1;
   @ObfuscatedName("client.nj")
   public int nj = -939;
   @ObfuscatedName("client.oj")
   public LinkList oj = new LinkList();
   @ObfuscatedName("client.pj")
   public boolean pj = false;
   @ObfuscatedName("client.rj")
   public int rj = 3;
   @ObfuscatedName("client.sj")
   public int[] sj = new int[33];
   @ObfuscatedName("client.tj")
   public int tj = 3353893;
   @ObfuscatedName("client.uj")
   public Pix24[] uj = new Pix24[32];
   @ObfuscatedName("client.wj")
   public int[] wj = new int[]{17, 24, 34, 40};
   @ObfuscatedName("client.Bj")
   public int[] Bj = new int[1000];
   @ObfuscatedName("client.Cj")
   public int[] Cj = new int[100];
   @ObfuscatedName("client.Dj")
   public String[] Dj = new String[100];
   @ObfuscatedName("client.Ej")
   public String[] Ej = new String[100];
   @ObfuscatedName("client.Hj")
   public boolean Hj = true;
   @ObfuscatedName("client.Uj")
   public volatile boolean Uj = false;
   @ObfuscatedName("client.Xj")
   public byte Xj = -58;
   @ObfuscatedName("client.Yj")
   public int Yj = 416;
   @ObfuscatedName("client.ak")
   public volatile boolean ak = false;
   @ObfuscatedName("client.bk")
   public int[] bk = new int[50];
   @ObfuscatedName("client.dk")
   public LinkList[][][] dk = new LinkList[4][104][104];
   @ObfuscatedName("client.gk")
   public int[] gk = new int[7];
   @ObfuscatedName("client.hk")
   public int hk = -1;
   @ObfuscatedName("client.ik")
   public int ik = 409;
   @ObfuscatedName("client.N")
   public static BigInteger N = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");
   @ObfuscatedName("client.sc")
   public static int sc = 10;
   @ObfuscatedName("client.uc")
   public static boolean uc = true;
   @ObfuscatedName("client.Vc")
   public static int[] Vc = new int[99];
   @ObfuscatedName("client.gd")
   public static boolean gd;
   @ObfuscatedName("client.Yd")
   public static String Yd;
   @ObfuscatedName("client.Zd")
   public static final int[][] Zd;
   @ObfuscatedName("client.qe")
   public static int qe;
   @ObfuscatedName("client.Ah")
   public static boolean Ah;
   @ObfuscatedName("client.Yh")
   public static int[] Yh;
   @ObfuscatedName("client.Ai")
   public static boolean Ai;
   @ObfuscatedName("client.aj")
   public static final int[] aj;
   @ObfuscatedName("client.Wj")
   public static BigInteger Wj;
   @ObfuscatedName("client.Ae")
   public int Ae;
   @ObfuscatedName("client.Ag")
   public int Ag;
   @ObfuscatedName("client.Aj")
   public int Aj;
   @ObfuscatedName("client.Bf")
   public int Bf;
   @ObfuscatedName("client.Bg")
   public static int Bg;
   @ObfuscatedName("client.Ci")
   public int Ci;
   @ObfuscatedName("client.Ei")
   public int Ei;
   @ObfuscatedName("client.Fe")
   public int Fe;
   @ObfuscatedName("client.Ff")
   public int Ff;
   @ObfuscatedName("client.Fj")
   public int Fj;
   @ObfuscatedName("client.Gd")
   public int Gd;
   @ObfuscatedName("client.Ge")
   public int Ge;
   @ObfuscatedName("client.Gj")
   public int Gj;
   @ObfuscatedName("client.Hd")
   public int Hd;
   @ObfuscatedName("client.He")
   public int He;
   @ObfuscatedName("client.Hh")
   public int Hh;
   @ObfuscatedName("client.Ib")
   public int Ib;
   @ObfuscatedName("client.Ic")
   public int Ic;
   @ObfuscatedName("client.Ie")
   public int Ie;
   @ObfuscatedName("client.If")
   public int If;
   @ObfuscatedName("client.Ig")
   public int Ig;
   @ObfuscatedName("client.Ij")
   public int Ij;
   @ObfuscatedName("client.Jd")
   public int Jd;
   @ObfuscatedName("client.Je")
   public int Je;
   @ObfuscatedName("client.Jg")
   public int Jg;
   @ObfuscatedName("client.Jj")
   public int Jj;
   @ObfuscatedName("client.Kb")
   public int Kb;
   @ObfuscatedName("client.Kd")
   public int Kd;
   @ObfuscatedName("client.Ke")
   public int Ke;
   @ObfuscatedName("client.Kg")
   public int Kg;
   @ObfuscatedName("client.Ki")
   public int Ki;
   @ObfuscatedName("client.Kj")
   public int Kj;
   @ObfuscatedName("client.Lb")
   public int Lb;
   @ObfuscatedName("client.Ld")
   public int Ld;
   @ObfuscatedName("client.Lg")
   public int Lg;
   @ObfuscatedName("client.Li")
   public int Li;
   @ObfuscatedName("client.Lj")
   public int Lj;
   @ObfuscatedName("client.Md")
   public int Md;
   @ObfuscatedName("client.Me")
   public int Me;
   @ObfuscatedName("client.Mi")
   public int Mi;
   @ObfuscatedName("client.Mj")
   public int Mj;
   @ObfuscatedName("client.Nd")
   public int Nd;
   @ObfuscatedName("client.Ne")
   public int Ne;
   @ObfuscatedName("client.Ng")
   public int Ng;
   @ObfuscatedName("client.Ni")
   public int Ni;
   @ObfuscatedName("client.Nj")
   public int Nj;
   @ObfuscatedName("client.O")
   public static int O;
   @ObfuscatedName("client.Ob")
   public int Ob;
   @ObfuscatedName("client.Od")
   public int Od;
   @ObfuscatedName("client.Oe")
   public static int Oe;
   @ObfuscatedName("client.Of")
   public static int Of;
   @ObfuscatedName("client.Og")
   public int Og;
   @ObfuscatedName("client.Oj")
   public int Oj;
   @ObfuscatedName("client.Pd")
   public int Pd;
   @ObfuscatedName("client.Pe")
   public int Pe;
   @ObfuscatedName("client.Pf")
   public int Pf;
   @ObfuscatedName("client.Pj")
   public static int Pj;
   @ObfuscatedName("client.Qb")
   public static int Qb;
   @ObfuscatedName("client.R")
   public int R;
   @ObfuscatedName("client.Re")
   public static int Re;
   @ObfuscatedName("client.S")
   public int S;
   @ObfuscatedName("client.Sh")
   public int Sh;
   @ObfuscatedName("client.T")
   public int T;
   @ObfuscatedName("client.U")
   public int U;
   @ObfuscatedName("client.Uc")
   public int Uc;
   @ObfuscatedName("client.Uf")
   public int Uf;
   @ObfuscatedName("client.Ui")
   public int Ui;
   @ObfuscatedName("client.V")
   public int V;
   @ObfuscatedName("client.Vd")
   public int Vd;
   @ObfuscatedName("client.Vi")
   public int Vi;
   @ObfuscatedName("client.Vj")
   public int Vj;
   @ObfuscatedName("client.We")
   public int We;
   @ObfuscatedName("client.Wg")
   public static int Wg;
   @ObfuscatedName("client.Wi")
   public int Wi;
   @ObfuscatedName("client.X")
   public int X;
   @ObfuscatedName("client.Xd")
   public int Xd;
   @ObfuscatedName("client.Y")
   public int Y;
   @ObfuscatedName("client.Yb")
   public int Yb;
   @ObfuscatedName("client.Yc")
   public int Yc;
   @ObfuscatedName("client.Yg")
   public static int Yg;
   @ObfuscatedName("client.Zb")
   public int Zb;
   @ObfuscatedName("client.Zf")
   public int Zf;
   @ObfuscatedName("client.Zh")
   public int Zh;
   @ObfuscatedName("client.Zj")
   public int Zj;
   @ObfuscatedName("client.ab")
   public int ab;
   @ObfuscatedName("client.ac")
   public int ac;
   @ObfuscatedName("client.ae")
   public int ae;
   @ObfuscatedName("client.ag")
   public int ag;
   @ObfuscatedName("client.ai")
   public int ai;
   @ObfuscatedName("client.bg")
   public int bg;
   @ObfuscatedName("client.bh")
   public static int bh;
   @ObfuscatedName("client.bi")
   public int bi;
   @ObfuscatedName("client.bj")
   public int bj;
   @ObfuscatedName("client.cb")
   public int cb;
   @ObfuscatedName("client.ce")
   public int ce;
   @ObfuscatedName("client.cf")
   public int cf;
   @ObfuscatedName("client.cg")
   public int cg;
   @ObfuscatedName("client.ci")
   public int ci;
   @ObfuscatedName("client.cj")
   public int cj;
   @ObfuscatedName("client.ck")
   public int ck;
   @ObfuscatedName("client.de")
   public int de;
   @ObfuscatedName("client.df")
   public int df;
   @ObfuscatedName("client.dg")
   public int dg;
   @ObfuscatedName("client.di")
   public int di;
   @ObfuscatedName("client.ee")
   public static int ee;
   @ObfuscatedName("client.eh")
   public static int eh;
   @ObfuscatedName("client.ei")
   public int ei;
   @ObfuscatedName("client.ek")
   public int ek;
   @ObfuscatedName("client.fi")
   public int fi;
   @ObfuscatedName("client.fj")
   public int fj;
   @ObfuscatedName("client.fk")
   public static int fk;
   @ObfuscatedName("client.gb")
   public int gb;
   @ObfuscatedName("client.ge")
   public int ge;
   @ObfuscatedName("client.gg")
   public int gg;
   @ObfuscatedName("client.gh")
   public int gh;
   @ObfuscatedName("client.gi")
   public int gi;
   @ObfuscatedName("client.hb")
   public int hb;
   @ObfuscatedName("client.hf")
   public int hf;
   @ObfuscatedName("client.hh")
   public int hh;
   @ObfuscatedName("client.hi")
   public int hi;
   @ObfuscatedName("client.ig")
   public int ig;
   @ObfuscatedName("client.ih")
   public int ih;
   @ObfuscatedName("client.jb")
   public int jb;
   @ObfuscatedName("client.jg")
   public int jg;
   @ObfuscatedName("client.jh")
   public int jh;
   @ObfuscatedName("client.ji")
   public int ji;
   @ObfuscatedName("client.jk")
   public int jk;
   @ObfuscatedName("client.kc")
   public int kc;
   @ObfuscatedName("client.ki")
   public int ki;
   @ObfuscatedName("client.kk")
   public int kk;
   @ObfuscatedName("client.lc")
   public int lc;
   @ObfuscatedName("client.le")
   public int le;
   @ObfuscatedName("client.lf")
   public int lf;
   @ObfuscatedName("client.li")
   public int li;
   @ObfuscatedName("client.lk")
   public int lk;
   @ObfuscatedName("client.mb")
   public int mb;
   @ObfuscatedName("client.me")
   public int me;
   @ObfuscatedName("client.mj")
   public int mj;
   @ObfuscatedName("client.mk")
   public int mk;
   @ObfuscatedName("client.ne")
   public int ne;
   @ObfuscatedName("client.nk")
   public static int nk;
   @ObfuscatedName("client.ob")
   public int ob;
   @ObfuscatedName("client.od")
   public int od;
   @ObfuscatedName("client.oe")
   public int oe;
   @ObfuscatedName("client.og")
   public int og;
   @ObfuscatedName("client.oi")
   public static int oi;
   @ObfuscatedName("client.pf")
   public int pf;
   @ObfuscatedName("client.ph")
   public int ph;
   @ObfuscatedName("client.qb")
   public int qb;
   @ObfuscatedName("client.qd")
   public int qd;
   @ObfuscatedName("client.qf")
   public int qf;
   @ObfuscatedName("client.qg")
   public int qg;
   @ObfuscatedName("client.qj")
   public int qj;
   @ObfuscatedName("client.rb")
   public int rb;
   @ObfuscatedName("client.rc")
   public int rc;
   @ObfuscatedName("client.rg")
   public int rg;
   @ObfuscatedName("client.ri")
   public int ri;
   @ObfuscatedName("client.sb")
   public int sb;
   @ObfuscatedName("client.tb")
   public int tb;
   @ObfuscatedName("client.tc")
   public static int tc;
   @ObfuscatedName("client.th")
   public int th;
   @ObfuscatedName("client.ti")
   public static int ti;
   @ObfuscatedName("client.ub")
   public int ub;
   @ObfuscatedName("client.ud")
   public int ud;
   @ObfuscatedName("client.vb")
   public int vb;
   @ObfuscatedName("client.vd")
   public static int vd;
   @ObfuscatedName("client.ve")
   public int ve;
   @ObfuscatedName("client.vg")
   public int vg;
   @ObfuscatedName("client.vi")
   public static int vi;
   @ObfuscatedName("client.vj")
   public int vj;
   @ObfuscatedName("client.wb")
   public int wb;
   @ObfuscatedName("client.wf")
   public static int wf;
   @ObfuscatedName("client.wi")
   public int wi;
   @ObfuscatedName("client.xb")
   public int xb;
   @ObfuscatedName("client.xf")
   public int xf;
   @ObfuscatedName("client.yb")
   public int yb;
   @ObfuscatedName("client.zb")
   public int zb;
   @ObfuscatedName("client.ze")
   public int ze;
   @ObfuscatedName("client.zi")
   public int zi;
   @ObfuscatedName("client.Dg")
   public long Dg;
   @ObfuscatedName("client.Ii")
   public long Ii;
   @ObfuscatedName("client.Xb")
   public long Xb;
   @ObfuscatedName("client.ni")
   public long ni;
   @ObfuscatedName("client.zc")
   public long zc;
   @ObfuscatedName("client.Jb")
   public Jagfile Jb;
   @ObfuscatedName("client.Gi")
   public MouseTracking Gi;
   @ObfuscatedName("client.Af")
   public Pix24 Af;
   @ObfuscatedName("client.Be")
   public Pix24 Be;
   @ObfuscatedName("client.Ce")
   public Pix24 Ce;
   @ObfuscatedName("client.Ch")
   public Pix24 Ch;
   @ObfuscatedName("client.Dh")
   public Pix24 Dh;
   @ObfuscatedName("client.Eh")
   public Pix24 Eh;
   @ObfuscatedName("client.Fh")
   public Pix24 Fh;
   @ObfuscatedName("client.Fi")
   public Pix24 Fi;
   @ObfuscatedName("client.Gh")
   public Pix24 Gh;
   @ObfuscatedName("client.Qf")
   public Pix24 Qf;
   @ObfuscatedName("client.Rf")
   public Pix24 Rf;
   @ObfuscatedName("client.eg")
   public Pix24 eg;
   @ObfuscatedName("client.ie")
   public Pix24 ie;
   @ObfuscatedName("client.je")
   public Pix24 je;
   @ObfuscatedName("client.kg")
   public Pix24 kg;
   @ObfuscatedName("client.pe")
   public ClientStream pe;
   @ObfuscatedName("client.Ih")
   public PixMap Ih;
   @ObfuscatedName("client.Jh")
   public PixMap Jh;
   @ObfuscatedName("client.Kh")
   public PixMap Kh;
   @ObfuscatedName("client.Lh")
   public PixMap Lh;
   @ObfuscatedName("client.Mh")
   public PixMap Mh;
   @ObfuscatedName("client.Nh")
   public PixMap Nh;
   @ObfuscatedName("client.Oh")
   public PixMap Oh;
   @ObfuscatedName("client.Ph")
   public PixMap Ph;
   @ObfuscatedName("client.Qh")
   public PixMap Qh;
   @ObfuscatedName("client.Sg")
   public PixMap Sg;
   @ObfuscatedName("client.Tg")
   public PixMap Tg;
   @ObfuscatedName("client.Ug")
   public PixMap Ug;
   @ObfuscatedName("client.Vg")
   public PixMap Vg;
   @ObfuscatedName("client.Wf")
   public PixMap Wf;
   @ObfuscatedName("client.Xf")
   public PixMap Xf;
   @ObfuscatedName("client.Yf")
   public PixMap Yf;
   @ObfuscatedName("client.bc")
   public PixMap bc;
   @ObfuscatedName("client.cc")
   public PixMap cc;
   @ObfuscatedName("client.dc")
   public PixMap dc;
   @ObfuscatedName("client.ec")
   public PixMap ec;
   @ObfuscatedName("client.fc")
   public PixMap fc;
   @ObfuscatedName("client.gc")
   public PixMap gc;
   @ObfuscatedName("client.hc")
   public PixMap hc;
   @ObfuscatedName("client.ic")
   public PixMap ic;
   @ObfuscatedName("client.jc")
   public PixMap jc;
   @ObfuscatedName("client.Ye")
   public PixFont Ye;
   @ObfuscatedName("client.Ze")
   public PixFont Ze;
   @ObfuscatedName("client.af")
   public PixFont af;
   @ObfuscatedName("client.bf")
   public PixFont bf;
   @ObfuscatedName("client.ah")
   public World3D ah;
   @ObfuscatedName("client.Ub")
   public Isaac Ub;
   @ObfuscatedName("client.Ad")
   public Pix8 Ad;
   @ObfuscatedName("client.Bb")
   public Pix8 Bb;
   @ObfuscatedName("client.Bd")
   public Pix8 Bd;
   @ObfuscatedName("client.Cb")
   public Pix8 Cb;
   @ObfuscatedName("client.Cd")
   public Pix8 Cd;
   @ObfuscatedName("client.Db")
   public Pix8 Db;
   @ObfuscatedName("client.Dd")
   public Pix8 Dd;
   @ObfuscatedName("client.Eb")
   public Pix8 Eb;
   @ObfuscatedName("client.Ed")
   public Pix8 Ed;
   @ObfuscatedName("client.Fb")
   public Pix8 Fb;
   @ObfuscatedName("client.Jf")
   public Pix8 Jf;
   @ObfuscatedName("client.Kf")
   public Pix8 Kf;
   @ObfuscatedName("client.id")
   public Pix8 id;
   @ObfuscatedName("client.jd")
   public Pix8 jd;
   @ObfuscatedName("client.kd")
   public Pix8 kd;
   @ObfuscatedName("client.vh")
   public Pix8 vh;
   @ObfuscatedName("client.wh")
   public Pix8 wh;
   @ObfuscatedName("client.xh")
   public Pix8 xh;
   @ObfuscatedName("client.yj")
   public Pix8 yj;
   @ObfuscatedName("client.zj")
   public Pix8 zj;
   @ObfuscatedName("client.dh")
   public static ClientPlayer dh;
   @ObfuscatedName("client.xj")
   public OnDemand xj;
   @ObfuscatedName("client.Mg")
   public String Mg;
   @ObfuscatedName("client.Xe")
   public String Xe;
   @ObfuscatedName("client.kh")
   public String kh;
   @ObfuscatedName("client.se")
   public String se;
   @ObfuscatedName("client.ii")
   public Socket ii;
   @ObfuscatedName("client.Qd")
   public static boolean Qd;
   @ObfuscatedName("client.Rh")
   public static boolean Rh;
   @ObfuscatedName("client.fd")
   public static boolean fd;
   @ObfuscatedName("client.pb")
   public static boolean pb;
   @ObfuscatedName("client.vc")
   public static boolean vc;
   @ObfuscatedName("client.Qj")
   public int[] Qj;
   @ObfuscatedName("client.Rd")
   public int[] Rd;
   @ObfuscatedName("client.Rj")
   public int[] Rj;
   @ObfuscatedName("client.Sd")
   public int[] Sd;
   @ObfuscatedName("client.Sj")
   public int[] Sj;
   @ObfuscatedName("client.Td")
   public int[] Td;
   @ObfuscatedName("client.Tj")
   public int[] Tj;
   @ObfuscatedName("client.Ud")
   public int[] Ud;
   @ObfuscatedName("client.db")
   public int[] db;
   @ObfuscatedName("client.eb")
   public int[] eb;
   @ObfuscatedName("client.fb")
   public int[] fb;
   @ObfuscatedName("client.mh")
   public int[] mh;
   @ObfuscatedName("client.nh")
   public int[] nh;
   @ObfuscatedName("client.yf")
   public int[] yf;
   @ObfuscatedName("client.zf")
   public int[] zf;
   @ObfuscatedName("client.fg")
   public Pix8[] fg;
   @ObfuscatedName("client.L")
   public byte[][] L;
   @ObfuscatedName("client.qi")
   public byte[][] qi;
   @ObfuscatedName("client.ng")
   public byte[][][] ng;
   @ObfuscatedName("client.Mb")
   public int[][][] Mb;

   @ObfuscatedName("client.a(Ljava/lang/String;I)V")
   public final void a(String arg0, int arg1) {
      if (arg0 != null && arg0.length() != 0) {
         String var3 = arg0;
         String[] var4 = new String[100];
         int var5 = 0;

         while(true) {
            int var6 = var3.indexOf(" ");
            if (var6 == -1) {
               String var8 = var3.trim();
               if (var8.length() > 0) {
                  var4[var5++] = var8.toLowerCase();
               }

               this.jb = 0;
               if (arg1 != 2) {
                  this.cd = !this.cd;
               }

               label55:
               for(int var9 = 0; var9 < ObjType.j; ++var9) {
                  ObjType var10 = ObjType.a(var9);
                  if (var10.r == -1 && var10.d != null) {
                     String var11 = var10.d.toLowerCase();

                     for(int var12 = 0; var12 < var5; ++var12) {
                        if (var11.indexOf(var4[var12]) == -1) {
                           continue label55;
                        }
                     }

                     this.kb[this.jb] = var11;
                     this.lb[this.jb] = var9;
                     ++this.jb;
                     if (this.jb >= this.kb.length) {
                        return;
                     }
                  }
               }

               return;
            }

            String var7 = var3.substring(0, var6).trim();
            if (var7.length() > 0) {
               var4[var5++] = var7.toLowerCase();
            }

            var3 = var3.substring(var6 + 1);
         }
      } else {
         this.jb = 0;
      }
   }

   @ObfuscatedName("client.b(Z)V")
   public final void b(boolean arg0) {
      this.hd.pIsaac(110);
      if (arg0) {
         this.dk = null;
      }

      if (this.Df != -1) {
         this.a(Ah, this.Df);
         this.Df = -1;
         this.rh = true;
         this.xi = false;
         this.Tc = true;
      }

      if (this.Fd != -1) {
         this.a(Ah, this.Fd);
         this.Fd = -1;
         this.yi = true;
         this.xi = false;
      }

      if (this.Se != -1) {
         this.a(Ah, this.Se);
         this.Se = -1;
         this.Le = true;
      }

      if (this.dd != -1) {
         this.a(Ah, this.dd);
         this.dd = -1;
      }

      if (this.fh != -1) {
         this.a(Ah, this.fh);
         this.fh = -1;
      }
   }

   @ObfuscatedName("client.a(IBLMFMVIYHT;)V")
   public final void a(int arg0, byte arg1, Packet arg2) {
      while(true) {
         if (arg2.bitPos + 10 < arg0 * 8) {
            int var4 = arg2.gBit(11);
            if (var4 != 2047) {
               if (this.nd[var4] == null) {
                  this.nd[var4] = new ClientPlayer();
                  if (this.sd[var4] != null) {
                     this.nd[var4].a(this.sd[var4], 0);
                  }
               }

               this.pd[this.od++] = var4;
               ClientPlayer var5 = this.nd[var4];
               var5.r = fk;
               int var6 = arg2.gBit(5);
               if (var6 > 15) {
                  var6 -= 32;
               }

               int var7 = arg2.gBit(1);
               if (var7 == 1) {
                  this.rd[this.qd++] = var4;
               }

               int var8 = arg2.gBit(1);
               int var9 = arg2.gBit(5);
               if (var9 > 15) {
                  var9 -= 32;
               }

               var5.a(dh.t[0] + var9, (byte)5, var8 == 1, dh.s[0] + var6);
               continue;
            }
         }

         arg2.bytes();
         if (arg1 == 6) {
            boolean var10 = false;
            return;
         }

         this.rb = -1;
         return;
      }
   }

   public static final void main(String[] arg0) {
      try {
         System.out.println("RS2 user client - release #" + 377);
         if (arg0.length != 5) {
            System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
         } else {
            sc = Integer.parseInt(arg0[0]);
            tc = Integer.parseInt(arg0[1]);
            if (arg0[2].equals("lowmem")) {
               l(true);
            } else {
               if (!arg0[2].equals("highmem")) {
                  System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
                  return;
               }

               d(true);
            }

            if (arg0[3].equals("free")) {
               uc = false;
            } else {
               if (!arg0[3].equals("members")) {
                  System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
                  return;
               }

               uc = true;
            }

            sign.Signlink.storeid = Integer.parseInt(arg0[4]);
            sign.Signlink.startpriv(InetAddress.getLocalHost());
            Client var1 = new Client();
            var1.a(qe, 503, 765);
         }
      } catch (Exception var3) {
      }
   }

   @ObfuscatedName("client.c(B)V")
   public final void c(byte arg0) {
      this.ak = true;
      if (arg0 == 4) {
         boolean var2 = false;
      } else {
         this.dk = null;
      }

      try {
         long var3 = System.currentTimeMillis();
         int var5 = 0;
         int var6 = 20;

         while(this.Bi) {
            ++this.Pf;
            this.i((byte)1);
            this.i((byte)1);
            this.y(47);
            ++var5;
            if (var5 > 10) {
               long var7 = System.currentTimeMillis();
               int var9 = (int)(var7 - var3) / 10 - var6;
               var6 = 40 - var9;
               if (var6 < 5) {
                  var6 = 5;
               }

               var5 = 0;
               var3 = var7;
            }

            try {
               Thread.sleep((long)var6);
            } catch (Exception var10) {
            }
         }
      } catch (Exception var11) {
      }

      this.ak = false;
   }

   @ObfuscatedName("client.d(B)V")
   public final void d(byte arg0) {
      if (arg0 == 3) {
         for(LocChange var2 = (LocChange)this.Ti.b(); var2 != null; var2 = (LocChange)this.Ti.a(1)) {
            if (var2.k == -1) {
               var2.p = 0;
               this.a((byte)-61, var2);
            } else {
               var2.a();
            }
         }

      }
   }

   @ObfuscatedName("client.a(Ljava/lang/String;)V")
   public final void a(String arg0) {
      System.out.println(arg0);

      try {
         this.getAppletContext().showDocument(new URL(this.getCodeBase(), "loaderror_" + arg0 + ".html"));
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      while(true) {
         while(true) {
            try {
               Thread.sleep(1000L);
            } catch (Exception var4) {
            }
         }
      }
   }

   @ObfuscatedName("client.a(II)Ljava/lang/String;")
   public static final String a(int arg0, int arg1) {
      if (arg1 >= 0) {
         throw new NullPointerException();
      } else if (arg0 < 100000) {
         return String.valueOf(arg0);
      } else {
         return arg0 < 10000000 ? arg0 / 1000 + "K" : arg0 / 1000000 + "M";
      }
   }

   @ObfuscatedName("client.b(I)V")
   public final void b(int arg0) {
      this.nd = null;
      this.pd = null;
      this.rd = null;
      this.sd = null;
      this.Bj = null;
      this.bc = null;
      this.cc = null;
      this.dc = null;
      this.ec = null;
      this.Bb = null;
      this.Cb = null;
      this.Db = null;
      this.Eb = null;
      this.Fb = null;
      this.Ad = null;
      this.Bd = null;
      this.Cd = null;
      this.Dd = null;
      this.Ed = null;
      this.W = null;
      this.sg = null;
      this.Zi = null;
      this.Wf = null;
      this.Xf = null;
      this.Yf = null;
      this.Ee = null;
      this.db = null;
      this.L = null;
      this.qi = null;
      this.eb = null;
      this.fb = null;
      this.Nh = null;
      this.Oh = null;
      this.Ph = null;
      this.Qh = null;
      this.Gb = null;
      this.zh = null;
      this.lg = null;
      this.mg = null;
      this.Ch = null;
      this.Dh = null;
      this.Eh = null;
      this.Fh = null;
      this.Gh = null;
      if (this.Gi != null) {
         this.Gi.a = false;
      }

      this.Gi = null;
      this.id = null;
      this.jd = null;
      this.kd = null;
      this.fc = null;
      this.gc = null;
      this.hc = null;
      this.ic = null;
      this.jc = null;
      this.Mb = null;
      this.ng = null;
      this.ah = null;
      this.Si = null;
      this.kg = null;
      this.Lh = null;
      this.Mh = null;
      this.Ih = null;
      this.Jh = null;
      this.Kh = null;
      this.eg = null;
      this.sh = null;
      this.uj = null;
      this.tf = null;
      this.Xc = null;
      this.Rb = null;
      this.g(false);
      this.hd = null;
      this.yc = null;
      this.yh = null;
      this.Sg = null;
      this.Tg = null;
      this.Ug = null;
      this.Vg = null;
      this.vh = null;
      this.wh = null;
      this.xh = null;

      try {
         if (this.pe != null) {
            this.pe.a();
         }
      } catch (Exception var3) {
      }

      this.pe = null;
      this.rf = null;
      this.sf = null;
      this.kj = null;
      this.ug = null;
      this.wg = null;
      this.Di = null;
      this.tg = null;
      this.Pg = null;
      this.we = null;
      this.Hb = null;
      this.td = null;
      this.oj = null;
      this.Uh = null;
      this.Af = null;
      if (this.xj != null) {
         this.xj.c();
      }

      this.xj = null;
      this.wd = null;
      this.xd = null;
      this.yd = null;
      this.zd = null;
      this.uh = null;
      this.dk = null;
      int var2 = 96 / arg0;
      this.Ti = null;
      this.H(28614);
      LocType.a(false);
      NpcType.a(false);
      ObjType.a(false);
      Component.a(false);
      FloType.e = null;
      IdkType.e = null;
      UnkType.b = null;
      SeqType.d = null;
      SpotAnimType.e = null;
      SpotAnimType.q = null;
      VarpType.b = null;
      super.o = null;
      ClientPlayer.Ib = null;
      Pix3D.a(false);
      World3D.a(false);
      Model.a(false);
      AnimFrame.a(false);
      System.gc();
   }

   @ObfuscatedName("client.c(Z)V")
   public final void c(boolean arg0) {
      if (!arg0) {
         if (super.B == 1) {
            if (super.C >= 539 && super.C <= 573 && super.D >= 169 && super.D < 205 && this.vf[0] != -1) {
               this.rh = true;
               this.rj = 0;
               this.Tc = true;
            }

            if (super.C >= 569 && super.C <= 599 && super.D >= 168 && super.D < 205 && this.vf[1] != -1) {
               this.rh = true;
               this.rj = 1;
               this.Tc = true;
            }

            if (super.C >= 597 && super.C <= 627 && super.D >= 168 && super.D < 205 && this.vf[2] != -1) {
               this.rh = true;
               this.rj = 2;
               this.Tc = true;
            }

            if (super.C >= 625 && super.C <= 669 && super.D >= 168 && super.D < 203 && this.vf[3] != -1) {
               this.rh = true;
               this.rj = 3;
               this.Tc = true;
            }

            if (super.C >= 666 && super.C <= 696 && super.D >= 168 && super.D < 205 && this.vf[4] != -1) {
               this.rh = true;
               this.rj = 4;
               this.Tc = true;
            }

            if (super.C >= 694 && super.C <= 724 && super.D >= 168 && super.D < 205 && this.vf[5] != -1) {
               this.rh = true;
               this.rj = 5;
               this.Tc = true;
            }

            if (super.C >= 722 && super.C <= 756 && super.D >= 169 && super.D < 205 && this.vf[6] != -1) {
               this.rh = true;
               this.rj = 6;
               this.Tc = true;
            }

            if (super.C >= 540 && super.C <= 574 && super.D >= 466 && super.D < 502 && this.vf[7] != -1) {
               this.rh = true;
               this.rj = 7;
               this.Tc = true;
            }

            if (super.C >= 572 && super.C <= 602 && super.D >= 466 && super.D < 503 && this.vf[8] != -1) {
               this.rh = true;
               this.rj = 8;
               this.Tc = true;
            }

            if (super.C >= 599 && super.C <= 629 && super.D >= 466 && super.D < 503 && this.vf[9] != -1) {
               this.rh = true;
               this.rj = 9;
               this.Tc = true;
            }

            if (super.C >= 627 && super.C <= 671 && super.D >= 467 && super.D < 502 && this.vf[10] != -1) {
               this.rh = true;
               this.rj = 10;
               this.Tc = true;
            }

            if (super.C >= 669 && super.C <= 699 && super.D >= 466 && super.D < 503 && this.vf[11] != -1) {
               this.rh = true;
               this.rj = 11;
               this.Tc = true;
            }

            if (super.C >= 696 && super.C <= 726 && super.D >= 466 && super.D < 503 && this.vf[12] != -1) {
               this.rh = true;
               this.rj = 12;
               this.Tc = true;
            }

            if (super.C >= 724 && super.C <= 758 && super.D >= 466 && super.D < 502 && this.vf[13] != -1) {
               this.rh = true;
               this.rj = 13;
               this.Tc = true;
               return;
            }
         }

      }
   }

   @ObfuscatedName("client.e(I)V")
   public final void e(int arg0) {
      int var2 = 61 / arg0;

      try {
         int var3 = dh.Q + this.ab;
         int var4 = dh.R + this.ae;
         if (this.Ui - var3 < -500 || this.Ui - var3 > 500 || this.Vi - var4 < -500 || this.Vi - var4 > 500) {
            this.Ui = var3;
            this.Vi = var4;
         }

         if (this.Ui != var3) {
            this.Ui += (var3 - this.Ui) / 16;
         }

         if (this.Vi != var4) {
            this.Vi += (var4 - this.Vi) / 16;
         }

         if (super.F[1] == 1) {
            this.Li += (-24 - this.Li) / 2;
         } else if (super.F[2] == 1) {
            this.Li += (24 - this.Li) / 2;
         } else {
            this.Li /= 2;
         }

         if (super.F[3] == 1) {
            this.Mi += (12 - this.Mi) / 2;
         } else if (super.F[4] == 1) {
            this.Mi += (-12 - this.Mi) / 2;
         } else {
            this.Mi /= 2;
         }

         this.Ki = this.Li / 2 + this.Ki & 2047;
         this.Ji += this.Mi / 2;
         if (this.Ji < 128) {
            this.Ji = 128;
         }

         if (this.Ji > 383) {
            this.Ji = 383;
         }

         int var5 = this.Ui >> 7;
         int var6 = this.Vi >> 7;
         int var7 = this.a(this.Vi, this.Ui, (byte)9, this.Ff);
         int var8 = 0;
         if (var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
            for(int var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
               for(int var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
                  int var11 = this.Ff;
                  if (var11 < 3 && (this.ng[1][var9][var10] & 2) == 2) {
                     ++var11;
                  }

                  int var12 = var7 - this.Mb[var11][var9][var10];
                  if (var12 > var8) {
                     var8 = var12;
                  }
               }
            }
         }

         int var13 = var8 * 192;
         if (var13 > 98048) {
            var13 = 98048;
         }

         if (var13 < 32768) {
            var13 = 32768;
         }

         if (var13 > this.vj) {
            this.vj += (var13 - this.vj) / 24;
         } else if (var13 < this.vj) {
            this.vj += (var13 - this.vj) / 80;
         }
      } catch (Exception var14) {
         sign.Signlink.reporterror("glfc_ex " + dh.Q + "," + dh.R + "," + this.Ui + "," + this.Vi + "," + this.Kb + "," + this.Lb + "," + this.Fe + "," + this.Ge);
         throw new RuntimeException("eek");
      }
   }

   @ObfuscatedName("client.a(LEWIXBTLV;I)Z")
   public final boolean a(Component arg0, int arg1) {
      int var3 = 98 / arg1;
      int var4 = arg0.G;
      if ((var4 < 1 || var4 > 200) && (var4 < 701 || var4 > 900)) {
         if (var4 >= 401 && var4 <= 500) {
            this.uh[this.th] = "Remove @whi@" + arg0.u;
            this.yd[this.th] = 859;
            ++this.th;
            return true;
         } else {
            return false;
         }
      } else {
         if (var4 >= 801) {
            var4 -= 701;
         } else if (var4 >= 701) {
            var4 -= 601;
         } else if (var4 >= 101) {
            var4 -= 101;
         } else {
            --var4;
         }

         this.uh[this.th] = "Remove @whi@" + this.W[var4];
         this.yd[this.th] = 775;
         ++this.th;
         this.uh[this.th] = "Message @whi@" + this.W[var4];
         this.yd[this.th] = 984;
         ++this.th;
         return true;
      }
   }

   @ObfuscatedName("client.a(Z[BI)V")
   public final void a(boolean arg0, byte[] arg1, int arg2) {
      if (this.Yi) {
         sign.Signlink.midifade = arg0 ? 1 : 0;
         sign.Signlink.midisave(arg1, arg1.length);
         int var4 = 71 / arg2;
      }
   }

   @ObfuscatedName("client.f(I)V")
   public final void f(int arg0) {
      if (arg0 != 0) {
         this.hd.p1((int)186);
      }

      this.jj = true;

      for(int var2 = 0; var2 < 7; ++var2) {
         this.gk[var2] = -1;

         for(int var3 = 0; var3 < IdkType.d; ++var3) {
            if (!IdkType.e[var3].k && IdkType.e[var3].f == var2 + (this.Gg ? 0 : 7)) {
               this.gk[var2] = var3;
               break;
            }
         }
      }

   }

   @ObfuscatedName("client.b(II)V")
   public final void b(int arg0, int arg1) {
      LinkList var3 = this.dk[this.Ff][arg0][arg1];
      if (var3 == null) {
         this.ah.a(this.Ff, arg0, arg1);
      } else {
         int var4 = -99999999;
         ClientObj var5 = null;

         for(ClientObj var6 = (ClientObj)var3.b(); var6 != null; var6 = (ClientObj)var3.a(1)) {
            ObjType var7 = ObjType.a(var6.m);
            int var8 = var7.t;
            if (var7.T) {
               var8 = (var6.o + 1) * var8;
            }

            if (var8 > var4) {
               var4 = var8;
               var5 = var6;
            }
         }

         var3.a((byte)-57, var5);
         ClientObj var9 = null;
         ClientObj var10 = null;

         for(ClientObj var11 = (ClientObj)var3.b(); var11 != null; var11 = (ClientObj)var3.a(1)) {
            if (var5.m != var11.m && var9 == null) {
               var9 = var11;
            }

            if (var5.m != var11.m && var9.m != var11.m && var10 == null) {
               var10 = var11;
            }
         }

         int var12 = (arg1 << 7) + arg0 + 1610612736;
         this.ah.a(this.a(arg1 * 128 + 64, arg0 * 128 + 64, (byte)9, this.Ff), this.Ff, var5, var9, var12, var10, 2, arg1, arg0);
      }
   }

   @ObfuscatedName("client.d(Z)V")
   public static final void d(boolean arg0) {
      World3D.m = false;
      Pix3D.z = false;
      vc = false;
      World.F = false;
      if (!arg0) {
         qe = 143;
      }

      LocType.o = false;
   }

   @ObfuscatedName("client.e(B)V")
   public final void e(byte arg0) {
      if (this.We > 1) {
         --this.We;
      }

      if (this.ub > 0) {
         --this.ub;
      }

      for(int var2 = 0; var2 < 5 && this.h((int)21389); ++var2) {
      }

      if (this.zg) {
         Object var3 = this.Gi.c;
         synchronized(this.Gi.c) {
            if (!fd) {
               this.Gi.f = 0;
            } else if (super.B != 0 || this.Gi.f >= 40) {
               this.hd.pIsaac(171);
               this.hd.p1((int)0);
               int var4 = this.hd.pos;
               int var5 = 0;

               for(int var6 = 0; var6 < this.Gi.f && var4 - this.hd.pos < 240; ++var6) {
                  ++var5;
                  int var7 = this.Gi.b[var6];
                  if (var7 < 0) {
                     var7 = 0;
                  } else if (var7 > 502) {
                     var7 = 502;
                  }

                  int var8 = this.Gi.g[var6];
                  if (var8 < 0) {
                     var8 = 0;
                  } else if (var8 > 764) {
                     var8 = 764;
                  }

                  int var9 = var7 * 765 + var8;
                  if (this.Gi.b[var6] == -1 && this.Gi.g[var6] == -1) {
                     var8 = -1;
                     var7 = -1;
                     var9 = 524287;
                  }

                  if (this.ce == var8 && this.de == var7) {
                     if (this.Fj < 2047) {
                        ++this.Fj;
                     }
                  } else {
                     int var10 = var8 - this.ce;
                     this.ce = var8;
                     int var11 = var7 - this.de;
                     this.de = var7;
                     if (this.Fj < 8 && var10 >= -32 && var10 <= 31 && var11 >= -32 && var11 <= 31) {
                        var10 += 32;
                        var11 += 32;
                        this.hd.p2((this.Fj << 12) + (var10 << 6) + var11);
                        this.Fj = 0;
                     } else if (this.Fj < 8) {
                        this.hd.p3((this.Fj << 19) + 8388608 + var9);
                        this.Fj = 0;
                     } else {
                        this.hd.p4((this.Fj << 19) + -1073741824 + var9);
                        this.Fj = 0;
                     }
                  }
               }

               this.hd.psize1((int)(this.hd.pos - var4));
               if (var5 >= this.Gi.f) {
                  this.Gi.f = 0;
               } else {
                  this.Gi.f -= var5;

                  for(int var12 = 0; var12 < this.Gi.f; ++var12) {
                     this.Gi.g[var12] = this.Gi.g[var5 + var12];
                     this.Gi.b[var12] = this.Gi.b[var5 + var12];
                  }
               }
            }
         }

         if (super.B != 0) {
            long var13 = (super.E - this.Xb) / 50L;
            if (var13 > 4095L) {
               var13 = 4095L;
            }

            this.Xb = super.E;
            int var15 = super.D;
            if (var15 < 0) {
               var15 = 0;
            } else if (var15 > 502) {
               var15 = 502;
            }

            int var16 = super.C;
            if (var16 < 0) {
               var16 = 0;
            } else if (var16 > 764) {
               var16 = 764;
            }

            int var17 = var15 * 765 + var16;
            byte var18 = 0;
            if (super.B == 2) {
               var18 = 1;
            }

            int var19 = (int)var13;
            this.hd.pIsaac(19);
            this.hd.p4((var18 << 19) + (var19 << 20) + var17);
         }

         if (this.Wi > 0) {
            --this.Wi;
         }

         if (super.F[1] == 1 || super.F[2] == 1 || super.F[3] == 1 || super.F[4] == 1) {
            this.Xi = true;
         }

         if (this.Xi && this.Wi <= 0) {
            this.Wi = 20;
            this.Xi = false;
            this.hd.pIsaac(140);
            this.hd.d(0, this.Ji);
            this.hd.d(0, this.Ki);
         }

         if (super.s && !this.hj) {
            this.hj = true;
            this.hd.pIsaac(187);
            this.hd.p1((int)1);
         }

         if (!super.s && this.hj) {
            this.hj = false;
            this.hd.pIsaac(187);
            this.hd.p1((int)0);
         }

         this.l((byte)-40);
         this.i((int)16220);
         this.M(-23763);
         ++this.sb;
         if (this.sb > 750) {
            this.m((int)1);
         }

         this.z(0);
         this.o(-37214);
         this.u(0);
         ++this.Uc;
         if (this.oe != 0) {
            this.ne += 20;
            if (this.ne >= 400) {
               this.oe = 0;
            }
         }

         if (this.mk != 0) {
            ++this.jk;
            if (this.jk >= 15) {
               if (this.mk == 2) {
                  this.rh = true;
               }

               if (this.mk == 3) {
                  this.yi = true;
               }

               this.mk = 0;
            }
         }

         if (this.bg != 0) {
            ++this.bj;
            if (super.v > this.cg + 5 || super.v < this.cg - 5 || super.w > this.dg + 5 || super.w < this.dg - 5) {
               this.Rg = true;
            }

            if (super.u == 0) {
               if (this.bg == 2) {
                  this.rh = true;
               }

               if (this.bg == 3) {
                  this.yi = true;
               }

               this.bg = 0;
               if (this.Rg && this.bj >= 5) {
                  this.df = -1;
                  this.w(-521);
                  if (this.df == this.Zf && this.cf != this.ag) {
                     Component var20 = Component.a(this.Zf);
                     byte var21 = 0;
                     if (this.Yc == 1 && var20.G == 206) {
                        var21 = 1;
                     }

                     if (var20.hb[this.cf] <= 0) {
                        var21 = 0;
                     }

                     if (var20.h) {
                        int var22 = this.ag;
                        int var23 = this.cf;
                        var20.hb[var23] = var20.hb[var22];
                        var20.o[var23] = var20.o[var22];
                        var20.hb[var22] = -1;
                        var20.o[var22] = 0;
                     } else if (var21 == 1) {
                        int var24 = this.ag;
                        int var25 = this.cf;

                        while(var24 != var25) {
                           if (var24 > var25) {
                              var20.a(var24 - 1, -291, var24);
                              --var24;
                           } else if (var24 < var25) {
                              var20.a(var24 + 1, -291, var24);
                              ++var24;
                           }
                        }
                     } else {
                        var20.a(this.cf, -291, this.ag);
                     }

                     this.hd.pIsaac(123);
                     this.hd.f(3, this.cf);
                     this.hd.a(false, var21);
                     this.hd.e(this.Zf, 0);
                     this.hd.d(0, this.ag);
                  }
               } else if ((this.Gj == 1 || this.b(this.th - 1, this.Xg)) && this.th > 2) {
                  this.B(811);
               } else if (this.th > 0) {
                  this.h(this.th - 1, 8);
               }

               this.jk = 10;
               super.B = 0;
            }
         }

         if (World3D.U != -1) {
            int var26 = World3D.U;
            int var27 = World3D.V;
            boolean var28 = this.a(true, false, var27, dh.t[0], 0, 0, 0, 0, var26, 0, 0, dh.s[0]);
            World3D.U = -1;
            if (var28) {
               this.le = super.C;
               this.me = super.D;
               this.oe = 1;
               this.ne = 0;
            }
         }

         if (super.B == 1 && this.Xe != null) {
            this.Xe = null;
            this.yi = true;
            super.B = 0;
         }

         this.l((int)0);
         if (this.Se == -1) {
            this.m((byte)4);
            this.c(false);
            this.f(true);
         }

         if (super.u == 1 || super.B == 1) {
            ++this.If;
         }

         if (this.qj == 0 && this.Je == 0 && this.rg == 0) {
            if (this.Ob > 0) {
               --this.Ob;
            }
         } else if (this.Ob < 100) {
            ++this.Ob;
            if (this.Ob == 100) {
               if (this.qj != 0) {
                  this.yi = true;
               }

               if (this.Je != 0) {
                  this.rh = true;
               }
            }
         }

         if (this.lf == 2) {
            this.e((int)409);
         }

         if (this.lf == 2 && this.Vh) {
            this.e(this.cd);
         }

         for(int var29 = 0; var29 < 5; ++var29) {
            int var10002 = this.Hg[var29]++;
         }

         this.f((byte)2);
         ++super.t;
         if (super.t > 4500) {
            this.ub = 250;
            super.t -= 500;
            this.hd.pIsaac(202);
         }

         ++this.gg;
         if (this.gg > 500) {
            this.gg = 0;
            int var30 = (int)(Math.random() * 8.0D);
            if ((var30 & 1) == 1) {
               this.ab += this.bb;
            }

            if ((var30 & 2) == 2) {
               this.ae += this.be;
            }

            if ((var30 & 4) == 4) {
               this.Ni += this.Oi;
            }
         }

         if (this.ab < -50) {
            this.bb = 2;
         }

         if (this.ab > 50) {
            this.bb = -2;
         }

         if (this.ae < -55) {
            this.be = 2;
         }

         if (this.ae > 55) {
            this.be = -2;
         }

         if (this.Ni < -40) {
            this.Oi = 1;
         }

         if (this.Ni > 40) {
            this.Oi = -1;
         }

         ++this.Ke;
         if (this.Ke > 500) {
            this.Ke = 0;
            int var31 = (int)(Math.random() * 8.0D);
            if ((var31 & 1) == 1) {
               this.lc += this.mc;
            }

            if ((var31 & 2) == 2) {
               this.ri += this.si;
            }
         }

         if (this.lc < -60) {
            this.mc = 2;
         }

         if (this.lc > 60) {
            this.mc = -2;
         }

         if (this.ri < -20) {
            this.si = 1;
         }

         if (this.ri > 10) {
            this.si = -1;
         }

         ++this.tb;
         if (arg0 != 4) {
            this.rb = this.yh.g1();
         }

         if (this.tb > 50) {
            this.hd.pIsaac(40);
         }

         try {
            if (this.pe != null && this.hd.pos > 0) {
               this.pe.a(0, this.hd.pos, 0, this.hd.data);
               this.hd.pos = 0;
               this.tb = 0;
            }
         } catch (IOException var33) {
            this.m((int)1);
         } catch (Exception var34) {
            this.n(true);
         }
      }
   }

   @ObfuscatedName("client.e(Z)V")
   public final void e(boolean arg0) {
      int var2 = this.vb * 128 + 64;
      int var3 = this.wb * 128 + 64;
      int var4 = this.a(var3, var2, (byte)9, this.Ff) - this.xb;
      if (this.ai < var2) {
         this.ai += (var2 - this.ai) * this.zb / 1000 + this.yb;
         if (this.ai > var2) {
            this.ai = var2;
         }
      }

      if (this.ai > var2) {
         this.ai -= (this.ai - var2) * this.zb / 1000 + this.yb;
         if (this.ai < var2) {
            this.ai = var2;
         }
      }

      if (this.bi < var4) {
         this.bi += (var4 - this.bi) * this.zb / 1000 + this.yb;
         if (this.bi > var4) {
            this.bi = var4;
         }
      }

      if (this.bi > var4) {
         this.bi -= (this.bi - var4) * this.zb / 1000 + this.yb;
         if (this.bi < var4) {
            this.bi = var4;
         }
      }

      if (this.ci < var3) {
         this.ci += (var3 - this.ci) * this.zb / 1000 + this.yb;
         if (this.ci > var3) {
            this.ci = var3;
         }
      }

      if (this.ci > var3) {
         this.ci -= (this.ci - var3) * this.zb / 1000 + this.yb;
         if (this.ci < var3) {
            this.ci = var3;
         }
      }

      int var5 = this.Kd * 128 + 64;
      int var6 = this.Ld * 128 + 64;
      int var7 = this.a(var6, var5, (byte)9, this.Ff) - this.Md;
      int var8 = var5 - this.ai;
      int var9 = var7 - this.bi;
      int var10 = var6 - this.ci;
      int var11 = (int)Math.sqrt((double)(var8 * var8 + var10 * var10));
      int var12 = (int)(Math.atan2((double)var9, (double)var11) * 325.949D) & 2047;
      if (!arg0) {
         for(int var13 = 1; var13 > 0; ++var13) {
         }
      }

      int var14 = (int)(Math.atan2((double)var8, (double)var10) * -325.949D) & 2047;
      if (var12 < 128) {
         var12 = 128;
      }

      if (var12 > 383) {
         var12 = 383;
      }

      if (this.di < var12) {
         this.di += (var12 - this.di) * this.Od / 1000 + this.Nd;
         if (this.di > var12) {
            this.di = var12;
         }
      }

      if (this.di > var12) {
         this.di -= (this.di - var12) * this.Od / 1000 + this.Nd;
         if (this.di < var12) {
            this.di = var12;
         }
      }

      int var15 = var14 - this.ei;
      if (var15 > 1024) {
         var15 -= 2048;
      }

      if (var15 < -1024) {
         var15 += 2048;
      }

      if (var15 > 0) {
         this.ei += this.Od * var15 / 1000 + this.Nd;
         this.ei &= 2047;
      }

      if (var15 < 0) {
         this.ei -= -var15 * this.Od / 1000 + this.Nd;
         this.ei &= 2047;
      }

      int var16 = var14 - this.ei;
      if (var16 > 1024) {
         var16 -= 2048;
      }

      if (var16 < -1024) {
         var16 += 2048;
      }

      if (var16 < 0 && var15 > 0 || var16 > 0 && var15 < 0) {
         this.ei = var14;
      }
   }

   @ObfuscatedName("client.f(B)V")
   public final void f(byte arg0) {
      if (arg0 == 2) {
         boolean var2 = false;

         while(true) {
            int var3;
            do {
               while(true) {
                  var3 = this.a((int)-983);
                  if (var3 == -1) {
                     return;
                  }

                  if (this.fh != -1 && this.pi == this.fh) {
                     if (var3 == 8 && this.M.length() > 0) {
                        this.M = this.M.substring(0, this.M.length() - 1);
                     }
                     break;
                  }

                  if (this.nb) {
                     if (var3 >= 32 && var3 <= 122 && this.re.length() < 80) {
                        this.re = this.re + (char)var3;
                        this.yi = true;
                     }

                     if (var3 == 8 && this.re.length() > 0) {
                        this.re = this.re.substring(0, this.re.length() - 1);
                        this.yi = true;
                     }

                     if (var3 == 13 || var3 == 10) {
                        this.nb = false;
                        this.yi = true;
                        if (this.fi == 1) {
                           long var4 = JString.a(this.re);
                           this.b(var4, -45229);
                        }

                        if (this.fi == 2 && this.gb > 0) {
                           long var6 = JString.a(this.re);
                           this.a(var6, 0);
                        }

                        if (this.fi == 3 && this.re.length() > 0) {
                           this.hd.pIsaac(227);
                           this.hd.p1((int)0);
                           int var8 = this.hd.pos;
                           this.hd.p8(this.Dg);
                           WordPack.a(this.re, 569, this.hd);
                           this.hd.psize1((int)(this.hd.pos - var8));
                           this.re = WordPack.a((byte)0, this.re);
                           this.re = WordFilter.a((byte)0, (String)this.re);
                           this.a(JString.a(JString.a(this.Dg, 0), (byte)7), (byte)-123, this.re, 6);
                           if (this.Ib == 2) {
                              this.Ib = 1;
                              this.Wh = true;
                              this.hd.pIsaac(176);
                              this.hd.p1(this.Xd);
                              this.hd.p1(this.Ib);
                              this.hd.p1(this.li);
                           }
                        }

                        if (this.fi == 4 && this.cb < 100) {
                           long var9 = JString.a(this.re);
                           this.a(this.Qg, var9);
                        }

                        if (this.fi == 5 && this.cb > 0) {
                           long var11 = JString.a(this.re);
                           this.b(325, var11);
                        }
                     }
                  } else if (this.Ci == 1) {
                     if (var3 >= 48 && var3 <= 57 && this.Sc.length() < 10) {
                        this.Sc = this.Sc + (char)var3;
                        this.yi = true;
                     }

                     if (var3 == 8 && this.Sc.length() > 0) {
                        this.Sc = this.Sc.substring(0, this.Sc.length() - 1);
                        this.yi = true;
                     }

                     if (var3 == 13 || var3 == 10) {
                        if (this.Sc.length() > 0) {
                           int var13 = 0;

                           try {
                              var13 = Integer.parseInt(this.Sc);
                           } catch (Exception var23) {
                           }

                           this.hd.pIsaac(75);
                           this.hd.p4(var13);
                        }

                        this.Ci = 0;
                        this.yi = true;
                     }
                  } else if (this.Ci == 2) {
                     if (var3 >= 32 && var3 <= 122 && this.Sc.length() < 12) {
                        this.Sc = this.Sc + (char)var3;
                        this.yi = true;
                     }

                     if (var3 == 8 && this.Sc.length() > 0) {
                        this.Sc = this.Sc.substring(0, this.Sc.length() - 1);
                        this.yi = true;
                     }

                     if (var3 == 13 || var3 == 10) {
                        if (this.Sc.length() > 0) {
                           this.hd.pIsaac(206);
                           this.hd.p8(JString.a(this.Sc));
                        }

                        this.Ci = 0;
                        this.yi = true;
                     }
                  } else if (this.Ci == 3) {
                     if (var3 >= 32 && var3 <= 122 && this.Sc.length() < 40) {
                        this.Sc = this.Sc + (char)var3;
                        this.yi = true;
                     }

                     if (var3 == 8 && this.Sc.length() > 0) {
                        this.Sc = this.Sc.substring(0, this.Sc.length() - 1);
                        this.yi = true;
                     }
                  } else if (this.Fd == -1 && this.Se == -1) {
                     if (var3 >= 32 && var3 <= 122 && this.Sf.length() < 80) {
                        this.Sf = this.Sf + (char)var3;
                        this.yi = true;
                     }

                     if (var3 == 8 && this.Sf.length() > 0) {
                        this.Sf = this.Sf.substring(0, this.Sf.length() - 1);
                        this.yi = true;
                     }

                     if ((var3 == 13 || var3 == 10) && this.Sf.length() > 0) {
                        if (this.ob == 2) {
                           if (this.Sf.equals("::clientdrop")) {
                              this.m((int)1);
                           }

                           if (this.Sf.equals("::lag")) {
                              this.q(false);
                           }

                           if (this.Sf.equals("::prefetchmusic")) {
                              for(int var14 = 0; var14 < this.xj.c(2, -31140); ++var14) {
                                 this.xj.a(-44, 2, (byte)1, var14);
                              }
                           }

                           if (this.Sf.equals("::fpson")) {
                              pb = true;
                           }

                           if (this.Sf.equals("::fpsoff")) {
                              pb = false;
                           }

                           if (this.Sf.equals("::noclip")) {
                              for(int var15 = 0; var15 < 4; ++var15) {
                                 for(int var16 = 1; var16 < 103; ++var16) {
                                    for(int var17 = 1; var17 < 103; ++var17) {
                                       this.Si[var15].j[var16][var17] = 0;
                                    }
                                 }
                              }
                           }
                        }

                        if (this.Sf.startsWith("::")) {
                           this.hd.pIsaac(56);
                           this.hd.p1(this.Sf.length() - 1);
                           this.hd.pjstr(this.Sf.substring(2));
                        } else {
                           String var18 = this.Sf.toLowerCase();
                           byte var19 = 0;
                           if (var18.startsWith("yellow:")) {
                              var19 = 0;
                              this.Sf = this.Sf.substring(7);
                           } else if (var18.startsWith("red:")) {
                              var19 = 1;
                              this.Sf = this.Sf.substring(4);
                           } else if (var18.startsWith("green:")) {
                              var19 = 2;
                              this.Sf = this.Sf.substring(6);
                           } else if (var18.startsWith("cyan:")) {
                              var19 = 3;
                              this.Sf = this.Sf.substring(5);
                           } else if (var18.startsWith("purple:")) {
                              var19 = 4;
                              this.Sf = this.Sf.substring(7);
                           } else if (var18.startsWith("white:")) {
                              var19 = 5;
                              this.Sf = this.Sf.substring(6);
                           } else if (var18.startsWith("flash1:")) {
                              var19 = 6;
                              this.Sf = this.Sf.substring(7);
                           } else if (var18.startsWith("flash2:")) {
                              var19 = 7;
                              this.Sf = this.Sf.substring(7);
                           } else if (var18.startsWith("flash3:")) {
                              var19 = 8;
                              this.Sf = this.Sf.substring(7);
                           } else if (var18.startsWith("glow1:")) {
                              var19 = 9;
                              this.Sf = this.Sf.substring(6);
                           } else if (var18.startsWith("glow2:")) {
                              var19 = 10;
                              this.Sf = this.Sf.substring(6);
                           } else if (var18.startsWith("glow3:")) {
                              var19 = 11;
                              this.Sf = this.Sf.substring(6);
                           }

                           String var20 = this.Sf.toLowerCase();
                           byte var21 = 0;
                           if (var20.startsWith("wave:")) {
                              var21 = 1;
                              this.Sf = this.Sf.substring(5);
                           } else if (var20.startsWith("wave2:")) {
                              var21 = 2;
                              this.Sf = this.Sf.substring(6);
                           } else if (var20.startsWith("shake:")) {
                              var21 = 3;
                              this.Sf = this.Sf.substring(6);
                           } else if (var20.startsWith("scroll:")) {
                              var21 = 4;
                              this.Sf = this.Sf.substring(7);
                           } else if (var20.startsWith("slide:")) {
                              var21 = 5;
                              this.Sf = this.Sf.substring(6);
                           }

                           this.hd.pIsaac(49);
                           this.hd.p1((int)0);
                           int var22 = this.hd.pos;
                           this.hd.c((byte)0, var19);
                           this.hd.a(false, var21);
                           this.tg.pos = 0;
                           WordPack.a(this.Sf, 569, this.tg);
                           this.hd.pdata(this.tg.data, 0, this.tg.pos, 0);
                           this.hd.psize1((int)(this.hd.pos - var22));
                           this.Sf = WordPack.a((byte)0, this.Sf);
                           this.Sf = WordFilter.a((byte)0, (String)this.Sf);
                           dh.m = this.Sf;
                           dh.p = var19;
                           dh.z = var21;
                           dh.o = 150;
                           if (this.ob == 2) {
                              this.a("@cr2@" + dh.yb, (byte)-123, dh.m, 2);
                           } else if (this.ob == 1) {
                              this.a("@cr1@" + dh.yb, (byte)-123, dh.m, 2);
                           } else {
                              this.a(dh.yb, (byte)-123, dh.m, 2);
                           }

                           if (this.Xd == 2) {
                              this.Xd = 3;
                              this.Wh = true;
                              this.hd.pIsaac(176);
                              this.hd.p1(this.Xd);
                              this.hd.p1(this.Ib);
                              this.hd.p1(this.li);
                           }
                        }

                        this.Sf = "";
                        this.yi = true;
                     }
                  }
               }
            } while((var3 < 97 || var3 > 122) && (var3 < 65 || var3 > 90) && (var3 < 48 || var3 > 57) && var3 != 32);

            if (this.M.length() < 12) {
               this.M = this.M + (char)var3;
            }
         }
      }
   }

   @ObfuscatedName("client.b(Ljava/lang/String;)Ljava/io/DataInputStream;")
   public final DataInputStream b(String arg0) throws IOException {
      if (!this.Vb) {
         return sign.Signlink.mainapp != null ? sign.Signlink.openurl(arg0) : new DataInputStream((new URL(this.getCodeBase(), arg0)).openStream());
      } else {
         if (this.ii != null) {
            try {
               this.ii.close();
            } catch (Exception var4) {
            }

            this.ii = null;
         }

         this.ii = this.g(43595);
         this.ii.setSoTimeout(10000);
         InputStream var2 = this.ii.getInputStream();
         OutputStream var3 = this.ii.getOutputStream();
         var3.write(("JAGGRAB /" + arg0 + "\n\n").getBytes());
         return new DataInputStream(var2);
      }
   }

   @ObfuscatedName("client.g(I)Ljava/net/Socket;")
   public final Socket g(int arg0) throws IOException {
      return sign.Signlink.mainapp != null ? sign.Signlink.opensocket(arg0) : new Socket(InetAddress.getByName(this.getCodeBase().getHost()), arg0);
   }

   @ObfuscatedName("client.h(I)Z")
   public final boolean h(int arg0) {
      if (arg0 != 21389) {
         for(int var2 = 1; var2 > 0; ++var2) {
         }
      }

      if (this.pe == null) {
         return false;
      } else {
         try {
            int var3 = this.pe.c();
            if (var3 == 0) {
               return false;
            }

            if (this.rb == -1) {
               this.pe.a(this.yh.data, 0, 1);
               this.rb = this.yh.data[0] & 255;
               if (this.Ub != null) {
                  this.rb = this.rb - this.Ub.nextInt() & 255;
               }

               this.qb = Protocol.SERVERPROT_LENGTH[this.rb];
               --var3;
            }

            if (this.qb == -1) {
               if (var3 <= 0) {
                  return false;
               }

               this.pe.a(this.yh.data, 0, 1);
               this.qb = this.yh.data[0] & 255;
               --var3;
            }

            if (this.qb == -2) {
               if (var3 <= 1) {
                  return false;
               }

               this.pe.a(this.yh.data, 0, 2);
               this.yh.pos = 0;
               this.qb = this.yh.g2();
               var3 -= 2;
            }

            if (var3 < this.qb) {
               return false;
            }

            this.yh.pos = 0;
            this.pe.a(this.yh.data, 0, this.qb);
            this.sb = 0;
            this.ac = this.Zb;
            this.Zb = this.Yb;
            this.Yb = this.rb;
            if (this.rb == 166) {
               int var4 = this.yh.p(-63);
               int var5 = this.yh.p(-63);
               int var6 = this.yh.g2();
               Component var7 = Component.a(var6);
               var7.s = var5;
               var7.X = var4;
               this.rb = -1;
               return true;
            }

            if (this.rb == 186) {
               int var8 = this.yh.b((byte)9);
               int var9 = this.yh.o(-600);
               int var10 = this.yh.b((byte)9);
               int var11 = this.yh.n(-125);
               Component.a(var9).Q = var8;
               Component.a(var9).R = var11;
               Component.a(var9).P = var10;
               this.rb = -1;
               return true;
            }

            if (this.rb == 216) {
               int var12 = this.yh.o(-600);
               int var13 = this.yh.o(-600);
               Component.a(var13).vb = 1;
               Component.a(var13).wb = var12;
               this.rb = -1;
               return true;
            }

            if (this.rb == 26) {
               int var14 = this.yh.g2();
               int var15 = this.yh.g1();
               int var16 = this.yh.g2();
               if (var16 == 65535) {
                  if (this.Ae < 50) {
                     this.Ef[this.Ae] = (short)var14;
                     this.bk[this.Ae] = var15;
                     this.Ri[this.Ae] = 0;
                     ++this.Ae;
                  }
               } else if (this.Hj && !vc && this.Ae < 50) {
                  this.Ef[this.Ae] = var14;
                  this.bk[this.Ae] = var15;
                  this.Ri[this.Ae] = Wave.f[var14] + var16;
                  ++this.Ae;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 182) {
               int var17 = this.yh.b((byte)9);
               byte var18 = this.yh.m(43428);
               this.Wd[var17] = var18;
               if (this.Ee[var17] != var18) {
                  this.Ee[var17] = var18;
                  this.f(0, var17);
                  this.rh = true;
                  if (this.Bh != -1) {
                     this.yi = true;
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 13) {
               for(int var19 = 0; var19 < this.nd.length; ++var19) {
                  if (this.nd[var19] != null) {
                     this.nd[var19].eb = -1;
                  }
               }

               for(int var20 = 0; var20 < this.ug.length; ++var20) {
                  if (this.ug[var20] != null) {
                     this.ug[var20].eb = -1;
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 156) {
               this.Pe = this.yh.g1();
               this.rb = -1;
               return true;
            }

            if (this.rb == 162) {
               int var21 = this.yh.b((byte)9);
               int var22 = this.yh.n(-125);
               Component.a(var22).vb = 2;
               Component.a(var22).wb = var21;
               this.rb = -1;
               return true;
            }

            if (this.rb == 109) {
               int var23 = this.yh.g2();
               this.b((byte)36, (int)var23);
               if (this.Df != -1) {
                  this.a(Ah, this.Df);
                  this.Df = -1;
                  this.rh = true;
                  this.Tc = true;
               }

               if (this.Se != -1) {
                  this.a(Ah, this.Se);
                  this.Se = -1;
                  this.Le = true;
               }

               if (this.dd != -1) {
                  this.a(Ah, this.dd);
                  this.dd = -1;
               }

               if (this.fh != -1) {
                  this.a(Ah, this.fh);
                  this.fh = -1;
               }

               if (this.Fd != var23) {
                  this.a(Ah, this.Fd);
                  this.Fd = var23;
               }

               this.xi = false;
               this.yi = true;
               this.rb = -1;
               return true;
            }

            if (this.rb == 220) {
               int var24 = this.yh.o(-600);
               if (var24 == 65535) {
                  var24 = -1;
               }

               if (this.hk != var24 && this.Yi && !vc && this.qg == 0) {
                  this.cj = var24;
                  this.dj = true;
                  this.xj.b(2, this.cj);
               }

               this.hk = var24;
               this.rb = -1;
               return true;
            }

            if (this.rb == 249) {
               int var25 = this.yh.n(-125);
               int var26 = this.yh.q(-737);
               if (this.Yi && !vc) {
                  this.cj = var25;
                  this.dj = false;
                  this.xj.b(2, this.cj);
                  this.qg = var26;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 158) {
               int var27 = this.yh.p(-63);
               if (this.Bh != var27) {
                  this.a(Ah, this.Bh);
                  this.Bh = var27;
               }

               this.yi = true;
               this.rb = -1;
               return true;
            }

            if (this.rb == 218) {
               int var28 = this.yh.g2();
               int var29 = this.yh.b((byte)9);
               int var30 = var29 >> 10 & 31;
               int var31 = var29 >> 5 & 31;
               int var32 = var29 & 31;
               Component.a(var28).E = (var32 << 3) + (var30 << 19) + (var31 << 11);
               this.rb = -1;
               return true;
            }

            if (this.rb == 157) {
               int var33 = this.yh.i(-34545);
               String var34 = this.yh.gjstr();
               int var35 = this.yh.g1();
               if (var33 >= 1 && var33 <= 5) {
                  if (var34.equalsIgnoreCase("null")) {
                     var34 = null;
                  }

                  this.jf[var33 - 1] = var34;
                  this.kf[var33 - 1] = var35 == 0;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 6) {
               this.nb = false;
               this.Ci = 2;
               this.Sc = "";
               this.yi = true;
               this.rb = -1;
               return true;
            }

            if (this.rb == 201) {
               this.Xd = this.yh.g1();
               this.Ib = this.yh.g1();
               this.li = this.yh.g1();
               this.Wh = true;
               this.yi = true;
               this.rb = -1;
               return true;
            }

            if (this.rb == 199) {
               this.Hh = this.yh.g1();
               if (this.Hh == 1) {
                  this.ki = this.yh.g2();
               }

               if (this.Hh >= 2 && this.Hh <= 6) {
                  if (this.Hh == 2) {
                     this.U = 64;
                     this.V = 64;
                  }

                  if (this.Hh == 3) {
                     this.U = 0;
                     this.V = 64;
                  }

                  if (this.Hh == 4) {
                     this.U = 128;
                     this.V = 64;
                  }

                  if (this.Hh == 5) {
                     this.U = 64;
                     this.V = 0;
                  }

                  if (this.Hh == 6) {
                     this.U = 64;
                     this.V = 128;
                  }

                  this.Hh = 2;
                  this.R = this.yh.g2();
                  this.S = this.yh.g2();
                  this.T = this.yh.g1();
               }

               if (this.Hh == 10) {
                  this.Ng = this.yh.g2();
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 167) {
               this.Vh = true;
               this.Kd = this.yh.g1();
               this.Ld = this.yh.g1();
               this.Md = this.yh.g2();
               this.Nd = this.yh.g1();
               this.Od = this.yh.g1();
               if (this.Od >= 100) {
                  int var36 = this.Kd * 128 + 64;
                  int var37 = this.Ld * 128 + 64;
                  int var38 = this.a(var37, var36, (byte)9, this.Ff) - this.Md;
                  int var39 = var36 - this.ai;
                  int var40 = var38 - this.bi;
                  int var41 = var37 - this.ci;
                  int var42 = (int)Math.sqrt((double)(var39 * var39 + var41 * var41));
                  this.di = (int)(Math.atan2((double)var40, (double)var42) * 325.949D) & 2047;
                  this.ei = (int)(Math.atan2((double)var39, (double)var41) * -325.949D) & 2047;
                  if (this.di < 128) {
                     this.di = 128;
                  }

                  if (this.di > 383) {
                     this.di = 383;
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 5) {
               this.n(true);
               this.rb = -1;
               return false;
            }

            if (this.rb == 115) {
               int var43 = this.yh.a(true);
               int var44 = this.yh.n(-125);
               this.Wd[var44] = var43;
               if (this.Ee[var44] != var43) {
                  this.Ee[var44] = var43;
                  this.f(0, var44);
                  this.rh = true;
                  if (this.Bh != -1) {
                     this.yi = true;
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 29) {
               if (this.Df != -1) {
                  this.a(Ah, this.Df);
                  this.Df = -1;
                  this.rh = true;
                  this.Tc = true;
               }

               if (this.Fd != -1) {
                  this.a(Ah, this.Fd);
                  this.Fd = -1;
                  this.yi = true;
               }

               if (this.Se != -1) {
                  this.a(Ah, this.Se);
                  this.Se = -1;
                  this.Le = true;
               }

               if (this.dd != -1) {
                  this.a(Ah, this.dd);
                  this.dd = -1;
               }

               if (this.fh != -1) {
                  this.a(Ah, this.fh);
                  this.fh = -1;
               }

               if (this.Ci != 0) {
                  this.Ci = 0;
                  this.yi = true;
               }

               this.xi = false;
               this.rb = -1;
               return true;
            }

            if (this.rb == 76) {
               this.xf = this.yh.n(-125);
               this.pf = this.yh.o(-600);
               this.yh.g2();
               this.Sh = this.yh.g2();
               this.gh = this.yh.n(-125);
               this.fj = this.yh.b((byte)9);
               this.Zh = this.yh.b((byte)9);
               this.Jd = this.yh.g2();
               this.zi = this.yh.r(935);
               this.ze = this.yh.o(-600);
               this.yh.h(0);
               sign.Signlink.dnslookup(JString.a(this.zi, -826));
               this.rb = -1;
               return true;
            }

            if (this.rb == 63) {
               String var45 = this.yh.gjstr();
               if (var45.endsWith(":tradereq:")) {
                  String var46 = var45.substring(0, var45.indexOf(":"));
                  long var47 = JString.a(var46);
                  boolean var49 = false;

                  for(int var50 = 0; var50 < this.cb; ++var50) {
                     if (this.nf[var50] == var47) {
                        var49 = true;
                        break;
                     }
                  }

                  if (!var49 && this.Ei == 0) {
                     this.a(var46, (byte)-123, "wishes to trade with you.", 4);
                  }
               } else if (var45.endsWith(":duelreq:")) {
                  String var51 = var45.substring(0, var45.indexOf(":"));
                  long var52 = JString.a(var51);
                  boolean var54 = false;

                  for(int var55 = 0; var55 < this.cb; ++var55) {
                     if (this.nf[var55] == var52) {
                        var54 = true;
                        break;
                     }
                  }

                  if (!var54 && this.Ei == 0) {
                     this.a(var51, (byte)-123, "wishes to duel with you.", 8);
                  }
               } else if (!var45.endsWith(":chalreq:")) {
                  this.a("", (byte)-123, var45, 0);
               } else {
                  String var56 = var45.substring(0, var45.indexOf(":"));
                  long var57 = JString.a(var56);
                  boolean var59 = false;

                  for(int var60 = 0; var60 < this.cb; ++var60) {
                     if (this.nf[var60] == var57) {
                        var59 = true;
                        break;
                     }
                  }

                  if (!var59 && this.Ei == 0) {
                     String var61 = var45.substring(var45.indexOf(":") + 1, var45.length() - 9);
                     this.a(var56, (byte)-123, var61, 8);
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 50) {
               int var62 = this.yh.gb2();
               if (var62 >= 0) {
                  this.b((byte)36, (int)var62);
               }

               if (this.lj != var62) {
                  this.a(Ah, this.lj);
                  this.lj = var62;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 82) {
               boolean var63 = this.yh.g1() == 1;
               int var64 = this.yh.g2();
               Component.a(var64).j = var63;
               this.rb = -1;
               return true;
            }

            if (this.rb == 174) {
               if (this.rj == 12) {
                  this.rh = true;
               }

               this.ve = this.yh.gb2();
               this.rb = -1;
               return true;
            }

            if (this.rb == 233) {
               this.Zj = this.yh.g1();
               this.rb = -1;
               return true;
            }

            if (this.rb == 61) {
               this.ig = 0;
               this.rb = -1;
               return true;
            }

            if (this.rb == 128) {
               int var65 = this.yh.b((byte)9);
               int var66 = this.yh.o(-600);
               if (this.Fd != -1) {
                  this.a(Ah, this.Fd);
                  this.Fd = -1;
                  this.yi = true;
               }

               if (this.Se != -1) {
                  this.a(Ah, this.Se);
                  this.Se = -1;
                  this.Le = true;
               }

               if (this.dd != -1) {
                  this.a(Ah, this.dd);
                  this.dd = -1;
               }

               if (this.fh != var65) {
                  this.a(Ah, this.fh);
                  this.fh = var65;
               }

               if (this.Df != var66) {
                  this.a(Ah, this.Df);
                  this.Df = var66;
               }

               if (this.Ci != 0) {
                  this.Ci = 0;
                  this.yi = true;
               }

               this.rh = true;
               this.Tc = true;
               this.xi = false;
               this.rb = -1;
               return true;
            }

            if (this.rb == 67) {
               int var67 = this.yh.g1();
               int var68 = this.yh.g1();
               int var69 = this.yh.g1();
               int var70 = this.yh.g1();
               this.wc[var67] = true;
               this.Tf[var67] = var68;
               this.Z[var67] = var69;
               this.Id[var67] = var70;
               this.Hg[var67] = 0;
               this.rb = -1;
               return true;
            }

            if (this.rb == 134) {
               this.rh = true;
               int var71 = this.yh.g2();
               Component var72 = Component.a(var71);

               while(this.yh.pos < this.qb) {
                  int var73 = this.yh.gsmarts();
                  int var74 = this.yh.g2();
                  int var75 = this.yh.g1();
                  if (var75 == 255) {
                     var75 = this.yh.g4();
                  }

                  if (var73 >= 0 && var73 < var72.hb.length) {
                     var72.hb[var73] = var74;
                     var72.o[var73] = var75;
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 78) {
               long var76 = this.yh.g8();
               int var78 = this.yh.g1();
               String var79 = JString.a(JString.a(var76, 0), (byte)7);

               for(int var80 = 0; var80 < this.gb; ++var80) {
                  if (this.sg[var80] == var76) {
                     if (this.Zi[var80] != var78) {
                        this.Zi[var80] = var78;
                        this.rh = true;
                        if (var78 > 0) {
                           this.a("", (byte)-123, var79 + " has logged in.", 5);
                        }

                        if (var78 == 0) {
                           this.a("", (byte)-123, var79 + " has logged out.", 5);
                        }
                     }

                     var79 = null;
                     break;
                  }
               }

               if (var79 != null && this.gb < 200) {
                  this.sg[this.gb] = var76;
                  this.W[this.gb] = var79;
                  this.Zi[this.gb] = var78;
                  ++this.gb;
                  this.rh = true;
               }

               boolean var81 = false;

               while(!var81) {
                  var81 = true;

                  for(int var82 = 0; var82 < this.gb - 1; ++var82) {
                     if (this.Zi[var82] != sc && this.Zi[var82 + 1] == sc || this.Zi[var82] == 0 && this.Zi[var82 + 1] != 0) {
                        int var83 = this.Zi[var82];
                        this.Zi[var82] = this.Zi[var82 + 1];
                        this.Zi[var82 + 1] = var83;
                        String var84 = this.W[var82];
                        this.W[var82] = this.W[var82 + 1];
                        this.W[var82 + 1] = var84;
                        long var85 = this.sg[var82];
                        this.sg[var82] = this.sg[var82 + 1];
                        this.sg[var82 + 1] = var85;
                        this.rh = true;
                        var81 = false;
                     }
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 58) {
               this.nb = false;
               this.Ci = 1;
               this.Sc = "";
               this.yi = true;
               this.rb = -1;
               return true;
            }

            if (this.rb == 252) {
               this.rj = this.yh.i(-34545);
               this.rh = true;
               this.Tc = true;
               this.rb = -1;
               return true;
            }

            if (this.rb == 40) {
               this.Hd = this.yh.j(this.ui);
               this.Gd = this.yh.i(-34545);

               for(int var87 = this.Gd; var87 < this.Gd + 8; ++var87) {
                  for(int var88 = this.Hd; var88 < this.Hd + 8; ++var88) {
                     if (this.dk[this.Ff][var87][var88] != null) {
                        this.dk[this.Ff][var87][var88] = null;
                        this.b(var87, var88);
                     }
                  }
               }

               for(LocChange var89 = (LocChange)this.Ti.b(); var89 != null; var89 = (LocChange)this.Ti.a(1)) {
                  if (var89.n >= this.Gd && var89.n < this.Gd + 8 && var89.o >= this.Hd && var89.o < this.Hd + 8 && this.Ff == var89.l) {
                     var89.k = 0;
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 255) {
               int var90 = this.yh.o(-600);
               Component.a(var90).vb = 3;
               if (dh.Eb == null) {
                  Component.a(var90).wb = (dh.zb[11] << 5) + (dh.zb[8] << 10) + (dh.zb[0] << 15) + (dh.Hb[0] << 25) + (dh.Hb[4] << 20) + dh.zb[1];
               } else {
                  Component.a(var90).wb = (int)(dh.Eb.h + 305419896L);
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 135) {
               long var91 = this.yh.g8();
               int var93 = this.yh.g4();
               int var94 = this.yh.g1();
               boolean var95 = false;

               for(int var96 = 0; var96 < 100; ++var96) {
                  if (this.Qi[var96] == var93) {
                     var95 = true;
                     break;
                  }
               }

               if (var94 <= 1) {
                  for(int var97 = 0; var97 < this.cb; ++var97) {
                     if (this.nf[var97] == var91) {
                        var95 = true;
                        break;
                     }
                  }
               }

               if (!var95 && this.Ei == 0) {
                  try {
                     this.Qi[this.Og] = var93;
                     this.Og = (this.Og + 1) % 100;
                     String var98 = WordPack.a(0, this.yh, this.qb - 13);
                     if (var94 != 3) {
                        var98 = WordFilter.a((byte)0, (String)var98);
                     }

                     if (var94 != 2 && var94 != 3) {
                        if (var94 == 1) {
                           this.a("@cr1@" + JString.a(JString.a(var91, 0), (byte)7), (byte)-123, var98, 7);
                        } else {
                           this.a(JString.a(JString.a(var91, 0), (byte)7), (byte)-123, var98, 3);
                        }
                     } else {
                        this.a("@cr2@" + JString.a(JString.a(var91, 0), (byte)7), (byte)-123, var98, 7);
                     }
                  } catch (Exception var191) {
                     sign.Signlink.reporterror("cde1");
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 183) {
               this.Gd = this.yh.g1();
               this.Hd = this.yh.h(0);

               while(this.yh.pos < this.qb) {
                  int var100 = this.yh.g1();
                  this.b(this.yh, 0, var100);
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 159) {
               int var101 = this.yh.o(-600);
               this.b((byte)36, (int)var101);
               if (this.Df != -1) {
                  this.a(Ah, this.Df);
                  this.Df = -1;
                  this.rh = true;
                  this.Tc = true;
               }

               if (this.Fd != -1) {
                  this.a(Ah, this.Fd);
                  this.Fd = -1;
                  this.yi = true;
               }

               if (this.Se != -1) {
                  this.a(Ah, this.Se);
                  this.Se = -1;
                  this.Le = true;
               }

               if (this.dd != -1) {
                  this.a(Ah, this.dd);
                  this.dd = -1;
               }

               if (this.fh != var101) {
                  this.a(Ah, this.fh);
                  this.fh = var101;
               }

               if (this.Ci != 0) {
                  this.Ci = 0;
                  this.yi = true;
               }

               this.xi = false;
               this.rb = -1;
               return true;
            }

            if (this.rb == 246) {
               int var102 = this.yh.o(-600);
               this.b((byte)36, (int)var102);
               if (this.Fd != -1) {
                  this.a(Ah, this.Fd);
                  this.Fd = -1;
                  this.yi = true;
               }

               if (this.Se != -1) {
                  this.a(Ah, this.Se);
                  this.Se = -1;
                  this.Le = true;
               }

               if (this.dd != -1) {
                  this.a(Ah, this.dd);
                  this.dd = -1;
               }

               if (this.fh != -1) {
                  this.a(Ah, this.fh);
                  this.fh = -1;
               }

               if (this.Df != var102) {
                  this.a(Ah, this.Df);
                  this.Df = var102;
               }

               if (this.Ci != 0) {
                  this.Ci = 0;
                  this.yi = true;
               }

               this.rh = true;
               this.Tc = true;
               this.xi = false;
               this.rb = -1;
               return true;
            }

            if (this.rb == 49) {
               this.rh = true;
               int var103 = this.yh.i(-34545);
               int var104 = this.yh.g1();
               int var105 = this.yh.g4();
               this.Q[var103] = var105;
               this.ue[var103] = var104;
               this.Te[var103] = 1;

               for(int var106 = 0; var106 < 98; ++var106) {
                  if (var105 >= Vc[var106]) {
                     this.Te[var103] = var106 + 2;
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 206) {
               this.rh = true;
               int var107 = this.yh.g2();
               Component var108 = Component.a(var107);
               int var109 = this.yh.g2();

               for(int var110 = 0; var110 < var109; ++var110) {
                  var108.hb[var110] = this.yh.o(-600);
                  int var111 = this.yh.i(-34545);
                  if (var111 == 255) {
                     var111 = this.yh.r(935);
                  }

                  var108.o[var110] = var111;
               }

               for(int var112 = var109; var112 < var108.hb.length; ++var112) {
                  var108.hb[var112] = 0;
                  var108.o[var112] = 0;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 222 || this.rb == 53) {
               int var113 = this.Kb;
               int var114 = this.Lb;
               if (this.rb == 222) {
                  var114 = this.yh.g2();
                  var113 = this.yh.o(-600);
                  this.Zg = false;
               }

               if (this.rb == 53) {
                  var113 = this.yh.b((byte)9);
                  this.yh.bits();
                  int var115 = 0;

                  while(true) {
                     if (var115 >= 4) {
                        this.yh.bytes();
                        var114 = this.yh.b((byte)9);
                        this.Zg = true;
                        break;
                     }

                     for(int var116 = 0; var116 < 13; ++var116) {
                        for(int var117 = 0; var117 < 13; ++var117) {
                           int var118 = this.yh.gBit(1);
                           if (var118 == 1) {
                              this.Ab[var115][var116][var117] = this.yh.gBit(26);
                           } else {
                              this.Ab[var115][var116][var117] = -1;
                           }
                        }
                     }

                     ++var115;
                  }
               }

               if (this.Kb == var113 && this.Lb == var114 && this.lf == 2) {
                  this.rb = -1;
                  return true;
               }

               this.Kb = var113;
               this.Lb = var114;
               this.Fe = (this.Kb - 6) * 8;
               this.Ge = (this.Lb - 6) * 8;
               this.gf = false;
               if ((this.Kb / 8 == 48 || this.Kb / 8 == 49) && this.Lb / 8 == 48) {
                  this.gf = true;
               }

               if (this.Kb / 8 == 48 && this.Lb / 8 == 148) {
                  this.gf = true;
               }

               this.lf = 1;
               this.ni = System.currentTimeMillis();
               this.a(-332, (String)null, "Loading - please wait.");
               if (this.rb == 222) {
                  int var119 = 0;
                  int var120 = (this.Kb - 6) / 8;

                  label1207:
                  while(true) {
                     if (var120 > (this.Kb + 6) / 8) {
                        this.L = new byte[var119][];
                        this.qi = new byte[var119][];
                        this.db = new int[var119];
                        this.eb = new int[var119];
                        this.fb = new int[var119];
                        int var122 = 0;
                        int var123 = (this.Kb - 6) / 8;

                        while(true) {
                           if (var123 > (this.Kb + 6) / 8) {
                              break label1207;
                           }

                           for(int var124 = (this.Lb - 6) / 8; var124 <= (this.Lb + 6) / 8; ++var124) {
                              this.db[var122] = (var123 << 8) + var124;
                              if (this.gf && (var124 == 49 || var124 == 149 || var124 == 147 || var123 == 50 || var123 == 49 && var124 == 47)) {
                                 this.eb[var122] = -1;
                                 this.fb[var122] = -1;
                                 ++var122;
                              } else {
                                 int var125 = this.eb[var122] = this.xj.a(0, var123, (int)var124, 0);
                                 if (var125 != -1) {
                                    this.xj.b(3, var125);
                                 }

                                 int var126 = this.fb[var122] = this.xj.a(0, var123, (int)var124, 1);
                                 if (var126 != -1) {
                                    this.xj.b(3, var126);
                                 }

                                 ++var122;
                              }
                           }

                           ++var123;
                        }
                     }

                     for(int var121 = (this.Lb - 6) / 8; var121 <= (this.Lb + 6) / 8; ++var121) {
                        ++var119;
                     }

                     ++var120;
                  }
               }

               if (this.rb == 53) {
                  int var127 = 0;
                  int[] var128 = new int[676];
                  int var129 = 0;

                  label1168:
                  while(true) {
                     if (var129 >= 4) {
                        this.L = new byte[var127][];
                        this.qi = new byte[var127][];
                        this.db = new int[var127];
                        this.eb = new int[var127];
                        this.fb = new int[var127];
                        int var137 = 0;

                        while(true) {
                           if (var137 >= var127) {
                              break label1168;
                           }

                           int var138 = this.db[var137] = var128[var137];
                           int var139 = var138 >> 8 & 255;
                           int var140 = var138 & 255;
                           int var141 = this.eb[var137] = this.xj.a(0, var139, (int)var140, 0);
                           if (var141 != -1) {
                              this.xj.b(3, var141);
                           }

                           int var142 = this.fb[var137] = this.xj.a(0, var139, (int)var140, 1);
                           if (var142 != -1) {
                              this.xj.b(3, var142);
                           }

                           ++var137;
                        }
                     }

                     for(int var130 = 0; var130 < 13; ++var130) {
                        for(int var131 = 0; var131 < 13; ++var131) {
                           int var132 = this.Ab[var129][var130][var131];
                           if (var132 != -1) {
                              int var133 = var132 >> 14 & 1023;
                              int var134 = var132 >> 3 & 2047;
                              int var135 = (var133 / 8 << 8) + var134 / 8;

                              for(int var136 = 0; var136 < var127; ++var136) {
                                 if (var128[var136] == var135) {
                                    var135 = -1;
                                    break;
                                 }
                              }

                              if (var135 != -1) {
                                 var128[var127++] = var135;
                              }
                           }
                        }
                     }

                     ++var129;
                  }
               }

               int var143 = this.Fe - this.He;
               int var144 = this.Ge - this.Ie;
               this.He = this.Fe;
               this.Ie = this.Ge;

               for(int var145 = 0; var145 < 16384; ++var145) {
                  ClientNpc var146 = this.ug[var145];
                  if (var146 != null) {
                     for(int var147 = 0; var147 < 10; ++var147) {
                        var146.s[var147] -= var143;
                        var146.t[var147] -= var144;
                     }

                     var146.Q -= var143 * 128;
                     var146.R -= var144 * 128;
                  }
               }

               for(int var148 = 0; var148 < this.ld; ++var148) {
                  ClientPlayer var149 = this.nd[var148];
                  if (var149 != null) {
                     for(int var150 = 0; var150 < 10; ++var150) {
                        var149.s[var150] -= var143;
                        var149.t[var150] -= var144;
                     }

                     var149.Q -= var143 * 128;
                     var149.R -= var144 * 128;
                  }
               }

               this.Th = true;
               byte var151 = 0;
               byte var152 = 104;
               byte var153 = 1;
               if (var143 < 0) {
                  var151 = 103;
                  var152 = -1;
                  var153 = -1;
               }

               byte var154 = 0;
               byte var155 = 104;
               byte var156 = 1;
               if (var144 < 0) {
                  var154 = 103;
                  var155 = -1;
                  var156 = -1;
               }

               for(int var157 = var151; var152 != var157; var157 += var153) {
                  for(int var158 = var154; var155 != var158; var158 += var156) {
                     int var159 = var143 + var157;
                     int var160 = var144 + var158;

                     for(int var161 = 0; var161 < 4; ++var161) {
                        if (var159 >= 0 && var160 >= 0 && var159 < 104 && var160 < 104) {
                           this.dk[var161][var157][var158] = this.dk[var161][var159][var160];
                        } else {
                           this.dk[var161][var157][var158] = null;
                        }
                     }
                  }
               }

               for(LocChange var162 = (LocChange)this.Ti.b(); var162 != null; var162 = (LocChange)this.Ti.a(1)) {
                  var162.n -= var143;
                  var162.o -= var144;
                  if (var162.n < 0 || var162.o < 0 || var162.n >= 104 || var162.o >= 104) {
                     var162.a();
                  }
               }

               if (this.ig != 0) {
                  this.ig -= var143;
                  this.jg -= var144;
               }

               this.Vh = false;
               this.rb = -1;
               return true;
            }

            if (this.rb == 190) {
               this.We = this.yh.n(-125) * 30;
               this.rb = -1;
               return true;
            }

            if (this.rb == 41 || this.rb == 121 || this.rb == 203 || this.rb == 106 || this.rb == 59 || this.rb == 181 || this.rb == 208 || this.rb == 107 || this.rb == 142 || this.rb == 88 || this.rb == 152) {
               this.b(this.yh, 0, this.rb);
               this.rb = -1;
               return true;
            }

            if (this.rb == 125) {
               if (this.rj == 12) {
                  this.rh = true;
               }

               this.ek = this.yh.g1();
               this.rb = -1;
               return true;
            }

            if (this.rb == 21) {
               int var163 = this.yh.g2();
               int var164 = this.yh.n(-125);
               int var165 = this.yh.o(-600);
               if (var164 == 65535) {
                  Component.a(var165).vb = 0;
                  this.rb = -1;
                  return true;
               }

               ObjType var166 = ObjType.a(var164);
               Component.a(var165).vb = 4;
               Component.a(var165).wb = var164;
               Component.a(var165).Q = var166.H;
               Component.a(var165).R = var166.E;
               Component.a(var165).P = var166.R * 100 / var163;
               this.rb = -1;
               return true;
            }

            if (this.rb == 3) {
               this.Vh = true;
               this.vb = this.yh.g1();
               this.wb = this.yh.g1();
               this.xb = this.yh.g2();
               this.yb = this.yh.g1();
               this.zb = this.yh.g1();
               if (this.zb >= 100) {
                  this.ai = this.vb * 128 + 64;
                  this.ci = this.wb * 128 + 64;
                  this.bi = this.a(this.ci, this.ai, (byte)9, this.Ff) - this.xb;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 2) {
               int var167 = this.yh.o(-600);
               int var168 = this.yh.c((byte)17);
               Component var169 = Component.a(var167);
               if (var169.yb != var168 || var168 == -1) {
                  var169.yb = var168;
                  var169.z = 0;
                  var169.r = 0;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 71) {
               this.a(this.yh, this.De, this.qb);
               this.rb = -1;
               return true;
            }

            if (this.rb == 226) {
               this.cb = this.qb / 8;

               for(int var170 = 0; var170 < this.cb; ++var170) {
                  this.nf[var170] = this.yh.g8();
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 10) {
               int var171 = this.yh.j(this.ui);
               int var172 = this.yh.b((byte)9);
               if (var172 == 65535) {
                  var172 = -1;
               }

               if (this.vf[var171] != var172) {
                  this.a(Ah, this.vf[var171]);
                  this.vf[var171] = var172;
               }

               this.rh = true;
               this.Tc = true;
               this.rb = -1;
               return true;
            }

            if (this.rb == 219) {
               int var173 = this.yh.n(-125);
               Component var174 = Component.a(var173);

               for(int var175 = 0; var175 < var174.hb.length; ++var175) {
                  var174.hb[var175] = -1;
                  var174.hb[var175] = 0;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 238) {
               this.Xh = this.yh.g1();
               if (this.rj == this.Xh) {
                  if (this.Xh == 3) {
                     this.rj = 1;
                  } else {
                     this.rj = 3;
                  }

                  this.rh = true;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 148) {
               this.Vh = false;

               for(int var176 = 0; var176 < 5; ++var176) {
                  this.wc[var176] = false;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 126) {
               this.hf = this.yh.g1();
               this.ed = this.yh.n(-125);
               this.rb = -1;
               return true;
            }

            if (this.rb == 75) {
               this.Gd = this.yh.i(-34545);
               this.Hd = this.yh.h(0);
               this.rb = -1;
               return true;
            }

            if (this.rb == 253) {
               int var177 = this.yh.n(-125);
               int var178 = this.yh.b((byte)9);
               this.b((byte)36, (int)var178);
               if (var177 != -1) {
                  this.b((byte)36, (int)var177);
               }

               if (this.fh != -1) {
                  this.a(Ah, this.fh);
                  this.fh = -1;
               }

               if (this.Df != -1) {
                  this.a(Ah, this.Df);
                  this.Df = -1;
               }

               if (this.Fd != -1) {
                  this.a(Ah, this.Fd);
                  this.Fd = -1;
               }

               if (this.Se != var178) {
                  this.a(Ah, this.Se);
                  this.Se = var178;
               }

               if (this.dd != var178) {
                  this.a(Ah, this.dd);
                  this.dd = var177;
               }

               this.Ci = 0;
               this.xi = false;
               this.rb = -1;
               return true;
            }

            if (this.rb == 251) {
               this.hb = this.yh.g1();
               this.rh = true;
               this.rb = -1;
               return true;
            }

            if (this.rb == 18) {
               int var179 = this.yh.g2();
               int var180 = this.yh.b((byte)9);
               int var181 = this.yh.n(-125);
               Component.a(var180).i = (var179 << 16) + var181;
               this.rb = -1;
               return true;
            }

            if (this.rb == 90) {
               this.a(this.qb, (int)69, (Packet)this.yh);
               this.Th = false;
               this.rb = -1;
               return true;
            }

            if (this.rb == 113) {
               for(int var182 = 0; var182 < this.Ee.length; ++var182) {
                  if (this.Wd[var182] != this.Ee[var182]) {
                     this.Ee[var182] = this.Wd[var182];
                     this.f(0, var182);
                     this.rh = true;
                  }
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 232) {
               int var183 = this.yh.o(-600);
               String var184 = this.yh.gjstr();
               Component.a(var183).u = var184;
               int var10001 = this.vf[this.rj];
               if (Component.a(var183).M == var10001) {
                  this.rh = true;
               }

               this.rb = -1;
               return true;
            }

            if (this.rb == 200) {
               int var185 = this.yh.g2();
               int var186 = this.yh.o(-600);
               Component var187 = Component.a(var185);
               if (var187 != null && var187.A == 0) {
                  if (var186 < 0) {
                     var186 = 0;
                  }

                  if (var186 > var187.xb - var187.C) {
                     var186 = var187.xb - var187.C;
                  }

                  var187.v = var186;
               }

               this.rb = -1;
               return true;
            }

            sign.Signlink.reporterror("T1 - " + this.rb + "," + this.qb + " - " + this.Zb + "," + this.ac);
            this.n(true);
         } catch (IOException var192) {
            this.m((int)1);
         } catch (Exception var193) {
            String var189 = "T2 - " + this.rb + "," + this.Zb + "," + this.ac + " - " + this.qb + "," + (dh.s[0] + this.Fe) + "," + (dh.t[0] + this.Ge) + " - ";

            for(int var190 = 0; var190 < this.qb && var190 < 50; ++var190) {
               var189 = var189 + this.yh.data[var190] + ",";
            }

            sign.Signlink.reporterror(var189);
            this.n(true);
         }

         return true;
      }
   }

   @ObfuscatedName("client.g(B)V")
   public final void g(byte arg0) {
      if (this.th >= 2 || this.Ig != 0 || this.hh != 0) {
         if (arg0 == -79) {
            String var2;
            if (this.Ig == 1 && this.th < 2) {
               var2 = "Use " + this.Mg + " with...";
            } else if (this.hh == 1 && this.th < 2) {
               var2 = this.kh + "...";
            } else {
               var2 = this.uh[this.th - 1];
            }

            if (this.th > 2) {
               var2 = var2 + "@whi@ / " + (this.th - 2) + " more options";
            }

            this.af.a(true, fk / 1000, 4, 16777215, 15, var2, 0);
         }
      }
   }

   @ObfuscatedName("client.a(ZZIIIIIIIIII)Z")
   public final boolean a(boolean arg0, boolean arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
      byte var13 = 104;
      byte var14 = 104;

      for(int var15 = 0; var15 < var13; ++var15) {
         for(int var16 = 0; var16 < var14; ++var16) {
            this.Gb[var15][var16] = 0;
            this.zh[var15][var16] = 99999999;
         }
      }

      int var17 = arg11;
      int var18 = arg3;
      this.Gb[arg11][arg3] = 99;
      this.zh[arg11][arg3] = 0;
      byte var19 = 0;
      int var20 = 0;
      this.lg[var19] = arg11;
      int var40 = var19 + 1;
      this.mg[var19] = arg3;
      boolean var21 = false;
      int var22 = this.lg.length;
      int[][] var23 = this.Si[this.Ff].j;

      while(var40 != var20) {
         var17 = this.lg[var20];
         var18 = this.mg[var20];
         var20 = (var20 + 1) % var22;
         if (arg8 == var17 && arg2 == var18) {
            var21 = true;
            break;
         }

         if (arg7 != 0) {
            if ((arg7 < 5 || arg7 == 10) && this.Si[this.Ff].a(arg8, 0, arg2, arg7 - 1, var17, var18, arg10)) {
               var21 = true;
               break;
            }

            if (arg7 < 10 && this.Si[this.Ff].b(-37, var18, arg8, var17, arg10, arg7 - 1, arg2)) {
               var21 = true;
               break;
            }
         }

         if (arg4 != 0 && arg5 != 0 && this.Si[this.Ff].a(arg4, var17, true, arg8, arg9, arg5, arg2, var18)) {
            var21 = true;
            break;
         }

         int var24 = this.zh[var17][var18] + 1;
         if (var17 > 0 && this.Gb[var17 - 1][var18] == 0 && (var23[var17 - 1][var18] & 19398920) == 0) {
            this.lg[var40] = var17 - 1;
            this.mg[var40] = var18;
            var40 = (var40 + 1) % var22;
            this.Gb[var17 - 1][var18] = 2;
            this.zh[var17 - 1][var18] = var24;
         }

         if (var17 < var13 - 1 && this.Gb[var17 + 1][var18] == 0 && (var23[var17 + 1][var18] & 19399040) == 0) {
            this.lg[var40] = var17 + 1;
            this.mg[var40] = var18;
            var40 = (var40 + 1) % var22;
            this.Gb[var17 + 1][var18] = 8;
            this.zh[var17 + 1][var18] = var24;
         }

         if (var18 > 0 && this.Gb[var17][var18 - 1] == 0 && (var23[var17][var18 - 1] & 19398914) == 0) {
            this.lg[var40] = var17;
            this.mg[var40] = var18 - 1;
            var40 = (var40 + 1) % var22;
            this.Gb[var17][var18 - 1] = 1;
            this.zh[var17][var18 - 1] = var24;
         }

         if (var18 < var14 - 1 && this.Gb[var17][var18 + 1] == 0 && (var23[var17][var18 + 1] & 19398944) == 0) {
            this.lg[var40] = var17;
            this.mg[var40] = var18 + 1;
            var40 = (var40 + 1) % var22;
            this.Gb[var17][var18 + 1] = 4;
            this.zh[var17][var18 + 1] = var24;
         }

         if (var17 > 0 && var18 > 0 && this.Gb[var17 - 1][var18 - 1] == 0 && (var23[var17 - 1][var18 - 1] & 19398926) == 0 && (var23[var17 - 1][var18] & 19398920) == 0 && (var23[var17][var18 - 1] & 19398914) == 0) {
            this.lg[var40] = var17 - 1;
            this.mg[var40] = var18 - 1;
            var40 = (var40 + 1) % var22;
            this.Gb[var17 - 1][var18 - 1] = 3;
            this.zh[var17 - 1][var18 - 1] = var24;
         }

         if (var17 < var13 - 1 && var18 > 0 && this.Gb[var17 + 1][var18 - 1] == 0 && (var23[var17 + 1][var18 - 1] & 19399043) == 0 && (var23[var17 + 1][var18] & 19399040) == 0 && (var23[var17][var18 - 1] & 19398914) == 0) {
            this.lg[var40] = var17 + 1;
            this.mg[var40] = var18 - 1;
            var40 = (var40 + 1) % var22;
            this.Gb[var17 + 1][var18 - 1] = 9;
            this.zh[var17 + 1][var18 - 1] = var24;
         }

         if (var17 > 0 && var18 < var14 - 1 && this.Gb[var17 - 1][var18 + 1] == 0 && (var23[var17 - 1][var18 + 1] & 19398968) == 0 && (var23[var17 - 1][var18] & 19398920) == 0 && (var23[var17][var18 + 1] & 19398944) == 0) {
            this.lg[var40] = var17 - 1;
            this.mg[var40] = var18 + 1;
            var40 = (var40 + 1) % var22;
            this.Gb[var17 - 1][var18 + 1] = 6;
            this.zh[var17 - 1][var18 + 1] = var24;
         }

         if (var17 < var13 - 1 && var18 < var14 - 1 && this.Gb[var17 + 1][var18 + 1] == 0 && (var23[var17 + 1][var18 + 1] & 19399136) == 0 && (var23[var17 + 1][var18] & 19399040) == 0 && (var23[var17][var18 + 1] & 19398944) == 0) {
            this.lg[var40] = var17 + 1;
            this.mg[var40] = var18 + 1;
            var40 = (var40 + 1) % var22;
            this.Gb[var17 + 1][var18 + 1] = 12;
            this.zh[var17 + 1][var18 + 1] = var24;
         }
      }

      this.og = 0;
      if (!var21) {
         if (!arg0) {
            return false;
         }

         int var25 = 1000;
         int var26 = 100;
         byte var27 = 10;

         for(int var28 = arg8 - var27; var28 <= arg8 + var27; ++var28) {
            for(int var29 = arg2 - var27; var29 <= arg2 + var27; ++var29) {
               if (var28 >= 0 && var29 >= 0 && var28 < 104 && var29 < 104 && this.zh[var28][var29] < 100) {
                  int var30 = 0;
                  if (var28 < arg8) {
                     var30 = arg8 - var28;
                  } else if (var28 > arg4 + arg8 - 1) {
                     var30 = var28 - (arg4 + arg8 - 1);
                  }

                  int var31 = 0;
                  if (var29 < arg2) {
                     var31 = arg2 - var29;
                  } else if (var29 > arg2 + arg5 - 1) {
                     var31 = var29 - (arg2 + arg5 - 1);
                  }

                  int var32 = var30 * var30 + var31 * var31;
                  if (var32 < var25 || var25 == var32 && this.zh[var28][var29] < var26) {
                     var25 = var32;
                     var26 = this.zh[var28][var29];
                     var17 = var28;
                     var18 = var29;
                  }
               }
            }
         }

         if (var25 == 1000) {
            return false;
         }

         if (arg11 == var17 && arg3 == var18) {
            return false;
         }

         this.og = 1;
      }

      byte var33 = 0;
      if (arg1) {
         this.a();
      }

      this.lg[var33] = var17;
      int var41 = var33 + 1;
      this.mg[var33] = var18;
      int var34;
      int var35 = var34 = this.Gb[var17][var18];

      while(arg11 != var17 || arg3 != var18) {
         if (var34 != var35) {
            var34 = var35;
            this.lg[var41] = var17;
            this.mg[var41++] = var18;
         }

         if ((var35 & 2) != 0) {
            ++var17;
         } else if ((var35 & 8) != 0) {
            --var17;
         }

         if ((var35 & 1) != 0) {
            ++var18;
         } else if ((var35 & 4) != 0) {
            --var18;
         }

         var35 = this.Gb[var17][var18];
      }

      if (var41 <= 0) {
         if (arg6 == 1) {
            return false;
         } else {
            return true;
         }
      } else {
         int var36 = var41;
         if (var41 > 25) {
            var36 = 25;
         }

         --var41;
         int var37 = this.lg[var41];
         int var38 = this.mg[var41];
         if (arg6 == 0) {
            this.hd.pIsaac(28);
            this.hd.p1(var36 + var36 + 3);
         }

         if (arg6 == 1) {
            this.hd.pIsaac(213);
            this.hd.p1(var36 + var36 + 3 + 14);
         }

         if (arg6 == 2) {
            this.hd.pIsaac(247);
            this.hd.p1(var36 + var36 + 3);
         }

         this.hd.f(3, this.Fe + var37);
         this.hd.p1(super.F[5] == 1 ? 1 : 0);
         this.hd.f(3, this.Ge + var38);
         this.ig = this.lg[0];
         this.jg = this.mg[0];

         for(int var39 = 1; var39 < var36; ++var39) {
            --var41;
            this.hd.p1(this.lg[var41] - var37);
            this.hd.c((int)(this.mg[var41] - var38), 1);
         }

         return true;
      }
   }

   @ObfuscatedName("client.i(I)V")
   public final void i(int arg0) {
      if (arg0 != 16220) {
         this.ik = 458;
      }

      if (this.lf == 2) {
         for(LocChange var2 = (LocChange)this.Ti.b(); var2 != null; var2 = (LocChange)this.Ti.a(1)) {
            if (var2.k > 0) {
               --var2.k;
            }

            if (var2.k == 0) {
               if (var2.h < 0 || World.a(var2.j, this.Fg, var2.h)) {
                  this.a(var2.i, var2.n, var2.h, var2.o, var2.l, var2.j, (byte)1, var2.m);
                  var2.a();
               }
            } else {
               if (var2.p > 0) {
                  --var2.p;
               }

               if (var2.p == 0 && var2.n >= 1 && var2.o >= 1 && var2.n <= 102 && var2.o <= 102 && (var2.e < 0 || World.a(var2.g, this.Fg, var2.e))) {
                  this.a(var2.f, var2.n, var2.e, var2.o, var2.l, var2.g, (byte)1, var2.m);
                  var2.p = -1;
                  if (var2.h == var2.e && var2.h == -1) {
                     var2.a();
                  } else if (var2.h == var2.e && var2.i == var2.f && var2.j == var2.g) {
                     var2.a();
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("client.j(I)Ljava/lang/String;")
   public final String j(int arg0) {
      if (arg0 != -42588) {
         this.rb = this.yh.g1();
      }

      if (sign.Signlink.mainapp != null) {
         return sign.Signlink.mainapp.getDocumentBase().getHost().toLowerCase();
      } else {
         return super.q != null ? "runescape.com" : super.getDocumentBase().getHost().toLowerCase();
      }
   }

   @ObfuscatedName("client.a(IIILZGNGQRPJ;I)V")
   public final void a(int arg0, int arg1, int arg2, ClientPlayer arg3, int arg4) {
      if (dh != arg3) {
         if (this.th < 400) {
            if (arg4 != 0) {
               gd = !gd;
            }

            String var6;
            if (arg3.Gb == 0) {
               var6 = arg3.yb + c(arg3.Ab, dh.Ab, 736) + " (level-" + arg3.Ab + ")";
            } else {
               var6 = arg3.yb + " (skill-" + arg3.Gb + ")";
            }

            if (this.Ig == 1) {
               this.uh[this.th] = "Use " + this.Mg + " with @whi@" + var6;
               this.yd[this.th] = 596;
               this.zd[this.th] = arg0;
               this.wd[this.th] = arg2;
               this.xd[this.th] = arg1;
               ++this.th;
            } else if (this.hh == 1) {
               if ((this.jh & 8) == 8) {
                  this.uh[this.th] = this.kh + " @whi@" + var6;
                  this.yd[this.th] = 918;
                  this.zd[this.th] = arg0;
                  this.wd[this.th] = arg2;
                  this.xd[this.th] = arg1;
                  ++this.th;
               }
            } else {
               for(int var7 = 4; var7 >= 0; --var7) {
                  if (this.jf[var7] != null) {
                     this.uh[this.th] = this.jf[var7] + " @whi@" + var6;
                     short var8 = 0;
                     if (this.jf[var7].equalsIgnoreCase("attack")) {
                        if (arg3.Ab > dh.Ab) {
                           var8 = 2000;
                        }

                        if (dh.Nb != 0 && arg3.Nb != 0) {
                           if (dh.Nb == arg3.Nb) {
                              var8 = 2000;
                           } else {
                              var8 = 0;
                           }
                        }
                     } else if (this.kf[var7]) {
                        var8 = 2000;
                     }

                     if (var7 == 0) {
                        this.yd[this.th] = var8 + 200;
                     }

                     if (var7 == 1) {
                        this.yd[this.th] = var8 + 493;
                     }

                     if (var7 == 2) {
                        this.yd[this.th] = var8 + 408;
                     }

                     if (var7 == 3) {
                        this.yd[this.th] = var8 + 677;
                     }

                     if (var7 == 4) {
                        this.yd[this.th] = var8 + 876;
                     }

                     this.zd[this.th] = arg0;
                     this.wd[this.th] = arg2;
                     this.xd[this.th] = arg1;
                     ++this.th;
                  }
               }
            }

            for(int var9 = 0; var9 < this.th; ++var9) {
               if (this.yd[var9] == 14) {
                  this.uh[var9] = "Walk here @whi@" + var6;
                  return;
               }
            }

         }
      }
   }

   @ObfuscatedName("client.f(Z)V")
   public final void f(boolean arg0) {
      if (!arg0) {
         this.dk = null;
      }

      if (super.B == 1) {
         if (super.C >= 6 && super.C <= 106 && super.D >= 467 && super.D <= 499) {
            this.Xd = (this.Xd + 1) % 4;
            this.Wh = true;
            this.yi = true;
            this.hd.pIsaac(176);
            this.hd.p1(this.Xd);
            this.hd.p1(this.Ib);
            this.hd.p1(this.li);
         }

         if (super.C >= 135 && super.C <= 235 && super.D >= 467 && super.D <= 499) {
            this.Ib = (this.Ib + 1) % 3;
            this.Wh = true;
            this.yi = true;
            this.hd.pIsaac(176);
            this.hd.p1(this.Xd);
            this.hd.p1(this.Ib);
            this.hd.p1(this.li);
         }

         if (super.C >= 273 && super.C <= 373 && super.D >= 467 && super.D <= 499) {
            this.li = (this.li + 1) % 3;
            this.Wh = true;
            this.yi = true;
            this.hd.pIsaac(176);
            this.hd.p1(this.Xd);
            this.hd.p1(this.Ib);
            this.hd.p1(this.li);
         }

         if (super.C >= 412 && super.C <= 512 && super.D >= 467 && super.D <= 499) {
            if (this.fh == -1) {
               this.b(false);
               this.M = "";
               this.Mf = false;
               this.pi = this.fh = Component.K;
            } else {
               this.a("", (byte)-123, "Please close the interface you have open before using 'report abuse'", 0);
            }
         }

         ++Wg;
         if (Wg > 161) {
            Wg = 0;
            this.hd.pIsaac(22);
            this.hd.p2(38304);
            return;
         }
      }

   }

   @ObfuscatedName("client.a(ILMFMVIYHT;I)V")
   public final void a(int arg0, Packet arg1, int arg2) {
      for(int var4 = 0; var4 < this.qd; ++var4) {
         int var5 = this.rd[var4];
         ClientPlayer var6 = this.nd[var5];
         int var7 = arg1.g1();
         if ((var7 & 32) != 0) {
            var7 += arg1.g1() << 8;
         }

         this.a(2, var5, var6, var7, arg1);
      }

      int var8 = 70 / arg0;
   }

   @ObfuscatedName("client.a(IZLMFMVIYHT;)V")
   public final void a(int arg0, boolean arg1, Packet arg2) {
      arg2.bits();
      int var4 = arg2.gBit(1);
      if (var4 != 0) {
         int var5 = arg2.gBit(2);
         this.zg &= arg1;
         if (var5 == 0) {
            this.rd[this.qd++] = this.md;
         } else if (var5 == 1) {
            int var6 = arg2.gBit(3);
            dh.a(false, var6, -808);
            int var7 = arg2.gBit(1);
            if (var7 == 1) {
               this.rd[this.qd++] = this.md;
            }

         } else if (var5 == 2) {
            int var8 = arg2.gBit(3);
            dh.a(true, var8, -808);
            int var9 = arg2.gBit(3);
            dh.a(true, var9, -808);
            int var10 = arg2.gBit(1);
            if (var10 == 1) {
               this.rd[this.qd++] = this.md;
            }

         } else if (var5 == 3) {
            int var11 = arg2.gBit(1);
            this.Ff = arg2.gBit(2);
            int var12 = arg2.gBit(7);
            int var13 = arg2.gBit(7);
            int var14 = arg2.gBit(1);
            if (var14 == 1) {
               this.rd[this.qd++] = this.md;
            }

            dh.a(var12, (byte)5, var11 == 1, var13);
         }
      }
   }

   @ObfuscatedName("client.a(IILEWIXBTLV;BIIIII)V")
   public final void a(int arg0, int arg1, Component arg2, byte arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
      if (this.pg) {
         this.Jj = 32;
      } else {
         this.Jj = 0;
      }

      this.pg = false;
      if (arg3 != 102) {
         for(int var10 = 1; var10 > 0; ++var10) {
         }
      }

      if (arg6 >= arg8 && arg6 < arg8 + 16 && arg4 >= arg1 && arg4 < arg1 + 16) {
         arg2.v -= this.If * 4;
         if (arg5 == 1) {
            this.rh = true;
         }

         if (arg5 == 2 || arg5 == 3) {
            this.yi = true;
         }

      } else if (arg6 >= arg8 && arg6 < arg8 + 16 && arg4 >= arg1 + arg7 - 16 && arg4 < arg1 + arg7) {
         arg2.v += this.If * 4;
         if (arg5 == 1) {
            this.rh = true;
         }

         if (arg5 == 2 || arg5 == 3) {
            this.yi = true;
         }

      } else if (arg6 >= arg8 - this.Jj && arg6 < arg8 + 16 + this.Jj && arg4 >= arg1 + 16 && arg4 < arg1 + arg7 - 16 && this.If > 0) {
         int var11 = (arg7 - 32) * arg7 / arg0;
         if (var11 < 8) {
            var11 = 8;
         }

         int var12 = arg4 - arg1 - 16 - var11 / 2;
         int var13 = arg7 - 32 - var11;
         arg2.v = (arg0 - arg7) * var12 / var13;
         if (arg5 == 1) {
            this.rh = true;
         }

         if (arg5 == 2 || arg5 == 3) {
            this.yi = true;
         }

         this.pg = true;
      }
   }

   @ObfuscatedName("client.h(B)V")
   public final void h(byte arg0) {
      if (this.Ig == 0 && this.hh == 0) {
         this.uh[this.th] = "Walk here";
         this.yd[this.th] = 14;
         this.wd[this.th] = super.v;
         this.xd[this.th] = super.w;
         ++this.th;
      }

      int var2 = -1;
      if (arg0 != 7) {
         this.rb = -1;
      }

      for(int var3 = 0; var3 < Model.Gb; ++var3) {
         int var4 = Model.Hb[var3];
         int var5 = var4 & 127;
         int var6 = var4 >> 7 & 127;
         int var7 = var4 >> 29 & 3;
         int var8 = var4 >> 14 & 32767;
         if (var2 != var4) {
            var2 = var4;
            if (var7 == 2 && this.ah.e(this.Ff, var5, var6, var4) >= 0) {
               LocType var9 = LocType.a(var8);
               if (var9.V != null) {
                  var9 = var9.b(0);
               }

               if (var9 == null) {
                  continue;
               }

               if (this.Ig == 1) {
                  this.uh[this.th] = "Use " + this.Mg + " with @cya@" + var9.s;
                  this.yd[this.th] = 467;
                  this.zd[this.th] = var4;
                  this.wd[this.th] = var5;
                  this.xd[this.th] = var6;
                  ++this.th;
               } else if (this.hh == 1) {
                  if ((this.jh & 4) == 4) {
                     this.uh[this.th] = this.kh + " @cya@" + var9.s;
                     this.yd[this.th] = 376;
                     this.zd[this.th] = var4;
                     this.wd[this.th] = var5;
                     this.xd[this.th] = var6;
                     ++this.th;
                  }
               } else {
                  if (var9.G != null) {
                     for(int var10 = 4; var10 >= 0; --var10) {
                        if (var9.G[var10] != null) {
                           this.uh[this.th] = var9.G[var10] + " @cya@" + var9.s;
                           if (var10 == 0) {
                              this.yd[this.th] = 35;
                           }

                           if (var10 == 1) {
                              this.yd[this.th] = 389;
                           }

                           if (var10 == 2) {
                              this.yd[this.th] = 888;
                           }

                           if (var10 == 3) {
                              this.yd[this.th] = 892;
                           }

                           if (var10 == 4) {
                              this.yd[this.th] = 1280;
                           }

                           this.zd[this.th] = var4;
                           this.wd[this.th] = var5;
                           this.xd[this.th] = var6;
                           ++this.th;
                        }
                     }
                  }

                  this.uh[this.th] = "Examine @cya@" + var9.s;
                  this.yd[this.th] = 1412;
                  this.zd[this.th] = var9.p << 14;
                  this.wd[this.th] = var5;
                  this.xd[this.th] = var6;
                  ++this.th;
               }
            }

            if (var7 == 1) {
               ClientNpc var11 = this.ug[var8];
               if (var11.rb.v == 1 && (var11.Q & 127) == 64 && (var11.R & 127) == 64) {
                  for(int var12 = 0; var12 < this.vg; ++var12) {
                     ClientNpc var13 = this.ug[this.wg[var12]];
                     if (var13 != null && var11 != var13 && var13.rb.v == 1 && var11.Q == var13.Q && var11.R == var13.R) {
                        this.a(var13.rb, var6, var5, this.wg[var12], (byte)-76);
                     }
                  }

                  for(int var14 = 0; var14 < this.od; ++var14) {
                     ClientPlayer var15 = this.nd[this.pd[var14]];
                     if (var15 != null && var11.Q == var15.Q && var11.R == var15.R) {
                        this.a(this.pd[var14], var6, var5, var15, 0);
                     }
                  }
               }

               this.a(var11.rb, var6, var5, var8, (byte)-76);
            }

            if (var7 == 0) {
               ClientPlayer var16 = this.nd[var8];
               if ((var16.Q & 127) == 64 && (var16.R & 127) == 64) {
                  for(int var17 = 0; var17 < this.vg; ++var17) {
                     ClientNpc var18 = this.ug[this.wg[var17]];
                     if (var18 != null && var18.rb.v == 1 && var16.Q == var18.Q && var16.R == var18.R) {
                        this.a(var18.rb, var6, var5, this.wg[var17], (byte)-76);
                     }
                  }

                  for(int var19 = 0; var19 < this.od; ++var19) {
                     ClientPlayer var20 = this.nd[this.pd[var19]];
                     if (var20 != null && var16 != var20 && var16.Q == var20.Q && var16.R == var20.R) {
                        this.a(this.pd[var19], var6, var5, var20, 0);
                     }
                  }
               }

               this.a(var8, var6, var5, var16, 0);
            }

            if (var7 == 3) {
               LinkList var21 = this.dk[this.Ff][var5][var6];
               if (var21 != null) {
                  for(ClientObj var22 = (ClientObj)var21.a(false); var22 != null; var22 = (ClientObj)var21.b(173)) {
                     ObjType var23 = ObjType.a(var22.m);
                     if (this.Ig == 1) {
                        this.uh[this.th] = "Use " + this.Mg + " with @lre@" + var23.d;
                        this.yd[this.th] = 100;
                        this.zd[this.th] = var22.m;
                        this.wd[this.th] = var5;
                        this.xd[this.th] = var6;
                        ++this.th;
                     } else if (this.hh == 1) {
                        if ((this.jh & 1) == 1) {
                           this.uh[this.th] = this.kh + " @lre@" + var23.d;
                           this.yd[this.th] = 199;
                           this.zd[this.th] = var22.m;
                           this.wd[this.th] = var5;
                           this.xd[this.th] = var6;
                           ++this.th;
                        }
                     } else {
                        for(int var24 = 4; var24 >= 0; --var24) {
                           if (var23.m != null && var23.m[var24] != null) {
                              this.uh[this.th] = var23.m[var24] + " @lre@" + var23.d;
                              if (var24 == 0) {
                                 this.yd[this.th] = 68;
                              }

                              if (var24 == 1) {
                                 this.yd[this.th] = 26;
                              }

                              if (var24 == 2) {
                                 this.yd[this.th] = 684;
                              }

                              if (var24 == 3) {
                                 this.yd[this.th] = 930;
                              }

                              if (var24 == 4) {
                                 this.yd[this.th] = 270;
                              }

                              this.zd[this.th] = var22.m;
                              this.wd[this.th] = var5;
                              this.xd[this.th] = var6;
                              ++this.th;
                           } else if (var24 == 2) {
                              this.uh[this.th] = "Take @lre@" + var23.d;
                              this.yd[this.th] = 684;
                              this.zd[this.th] = var22.m;
                              this.wd[this.th] = var5;
                              this.xd[this.th] = var6;
                              ++this.th;
                           }
                        }

                        this.uh[this.th] = "Examine @lre@" + var23.d;
                        this.yd[this.th] = 1564;
                        this.zd[this.th] = var22.m;
                        this.wd[this.th] = var5;
                        this.xd[this.th] = var6;
                        ++this.th;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("client.a(ZI)V")
   public final void a(boolean arg0, int arg1) {
      if (arg0) {
         Component.a(Ah, arg1);
      }
   }

   @ObfuscatedName("client.a(IIIIIIBI)V")
   public final void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, byte arg6, int arg7) {
      if (this.ff != arg6) {
         this.lh = -380;
      }

      if (arg1 >= 1 && arg3 >= 1 && arg1 <= 102 && arg3 <= 102) {
         if (vc && this.Ff != arg4) {
            return;
         }

         int var9 = 0;
         boolean var10 = true;
         boolean var11 = false;
         boolean var12 = false;
         if (arg7 == 0) {
            var9 = this.ah.b(arg4, arg1, arg3);
         }

         if (arg7 == 1) {
            var9 = this.ah.b(arg1, (byte)4, arg4, arg3);
         }

         if (arg7 == 2) {
            var9 = this.ah.c(arg4, arg1, arg3);
         }

         if (arg7 == 3) {
            var9 = this.ah.d(arg4, arg1, arg3);
         }

         if (var9 != 0) {
            int var13 = this.ah.e(arg4, arg1, arg3, var9);
            int var14 = var9 >> 14 & 32767;
            int var15 = var13 & 31;
            int var16 = var13 >> 6;
            if (arg7 == 0) {
               this.ah.a(arg3, arg4, arg1, true);
               LocType var17 = LocType.a(var14);
               if (var17.ab) {
                  this.Si[arg4].a(var16, arg1, 0, arg3, var15, var17.Z);
               }
            }

            if (arg7 == 1) {
               this.ah.a(false, arg1, arg3, arg4);
            }

            if (arg7 == 2) {
               this.ah.b(arg3, (int)arg4, -779, arg1);
               LocType var18 = LocType.a(var14);
               if (var18.R + arg1 > 103 || var18.R + arg3 > 103 || var18.r + arg1 > 103 || var18.r + arg3 > 103) {
                  return;
               }

               if (var18.ab) {
                  this.Si[arg4].a(this.Ue, arg3, arg1, var16, var18.r, var18.Z, var18.R);
               }
            }

            if (arg7 == 3) {
               this.ah.a(arg1, arg3, true, arg4);
               LocType var19 = LocType.a(var14);
               if (var19.ab && var19.b) {
                  this.Si[arg4].a(arg1, (byte)-122, arg3);
               }
            }
         }

         if (arg2 >= 0) {
            int var20 = arg4;
            if (arg4 < 3 && (this.ng[1][arg1][arg3] & 2) == 2) {
               var20 = arg4 + 1;
            }

            World.a(arg2, var20, arg5, arg3, this.Si[arg4], arg0, arg1, 0, arg4, this.ah, this.Mb);
            return;
         }
      }

   }

   @ObfuscatedName("client.b(IBLMFMVIYHT;)V")
   public final void b(int arg0, byte arg1, Packet arg2) {
      arg2.bits();
      int var4 = arg2.gBit(8);
      if (this.Xj != arg1) {
         this.nj = -460;
      }

      if (var4 < this.vg) {
         for(int var5 = var4; var5 < this.vg; ++var5) {
            this.Bj[this.Aj++] = this.wg[var5];
         }
      }

      if (var4 > this.vg) {
         sign.Signlink.reporterror(this.Gf + " Too many npcs");
         throw new RuntimeException("eek");
      } else {
         this.vg = 0;

         for(int var6 = 0; var6 < var4; ++var6) {
            int var7 = this.wg[var6];
            ClientNpc var8 = this.ug[var7];
            int var9 = arg2.gBit(1);
            if (var9 == 0) {
               this.wg[this.vg++] = var7;
               var8.r = fk;
            } else {
               int var10 = arg2.gBit(2);
               if (var10 == 0) {
                  this.wg[this.vg++] = var7;
                  var8.r = fk;
                  this.rd[this.qd++] = var7;
               } else if (var10 == 1) {
                  this.wg[this.vg++] = var7;
                  var8.r = fk;
                  int var11 = arg2.gBit(3);
                  var8.a(false, var11, -808);
                  int var12 = arg2.gBit(1);
                  if (var12 == 1) {
                     this.rd[this.qd++] = var7;
                  }
               } else if (var10 == 2) {
                  this.wg[this.vg++] = var7;
                  var8.r = fk;
                  int var13 = arg2.gBit(3);
                  var8.a(true, var13, -808);
                  int var14 = arg2.gBit(3);
                  var8.a(true, var14, -808);
                  int var15 = arg2.gBit(1);
                  if (var15 == 1) {
                     this.rd[this.qd++] = var7;
                  }
               } else if (var10 == 3) {
                  this.Bj[this.Aj++] = var7;
               }
            }
         }

      }
   }

   @ObfuscatedName("client.a(Ljava/lang/String;BLjava/lang/String;I)V")
   public final void a(String arg0, byte arg1, String arg2, int arg3) {
      if (arg3 == 0 && this.Bh != -1) {
         this.Xe = arg2;
         super.B = 0;
      }

      if (this.Fd == -1) {
         this.yi = true;
      }

      for(int var5 = 99; var5 > 0; --var5) {
         this.Cj[var5] = this.Cj[var5 - 1];
         this.Dj[var5] = this.Dj[var5 - 1];
         this.Ej[var5] = this.Ej[var5 - 1];
      }

      if (this.Wb != arg1) {
         this.Cg = this.Ub.nextInt();
      }

      this.Cj[0] = arg3;
      this.Dj[0] = arg0;
      this.Ej[0] = arg2;
   }

   @ObfuscatedName("client.a(LMFMVIYHT;ZI)V")
   public final void a(Packet arg0, boolean arg1, int arg2) {
      this.zg &= arg1;
      this.Aj = 0;
      this.qd = 0;
      this.b(arg2, (byte)-58, arg0);
      this.a(arg0, arg2, false);
      this.a(arg0, arg2, 838);

      for(int var4 = 0; var4 < this.Aj; ++var4) {
         int var5 = this.Bj[var4];
         if (fk != this.ug[var5].r) {
            this.ug[var5].rb = null;
            this.ug[var5] = null;
         }
      }

      if (arg0.pos != arg2) {
         sign.Signlink.reporterror(this.Gf + " size mismatch in getnpcpos - pos:" + arg0.pos + " psize:" + arg2);
         throw new RuntimeException("eek");
      } else {
         for(int var6 = 0; var6 < this.vg; ++var6) {
            if (this.ug[this.wg[var6]] == null) {
               sign.Signlink.reporterror(this.Gf + " null entry in npc list - pos:" + var6 + " size:" + this.vg);
               throw new RuntimeException("eek");
            }
         }

      }
   }

   @ObfuscatedName("client.k(I)V")
   public final void k(int arg0) {
      LocType.v.a();
      LocType.e.a();
      if (arg0 <= 0) {
         for(int var2 = 1; var2 > 0; ++var2) {
         }
      }

      NpcType.o.a();
      ObjType.l.a();
      ObjType.u.a();
      ClientPlayer.Ib.a();
      SpotAnimType.q.a();
   }

   @ObfuscatedName("client.g(Z)V")
   public final void g(boolean arg0) {
      sign.Signlink.midiplay = false;
      if (arg0) {
         this.hg = 466;
      }

      sign.Signlink.midifade = 0;
      sign.Signlink.midi = "stop";
   }

   @ObfuscatedName("client.h(Z)V")
   public final void h(boolean arg0) {
      ClientProj var2 = (ClientProj)this.oj.b();
      if (arg0) {
         this.ik = 153;
      }

      while(var2 != null) {
         if (this.Ff == var2.n && fk <= var2.z) {
            if (fk >= var2.y) {
               if (var2.t > 0) {
                  ClientNpc var3 = this.ug[var2.t - 1];
                  if (var3 != null && var3.Q >= 0 && var3.Q < 13312 && var3.R >= 0 && var3.R < 13312) {
                     var2.a(var3.Q, var3.R, this.a(var3.R, var3.Q, (byte)9, var2.n) - var2.M, fk, 0);
                  }
               }

               if (var2.t < 0) {
                  int var4 = -var2.t - 1;
                  ClientPlayer var5;
                  if (this.ed == var4) {
                     var5 = dh;
                  } else {
                     var5 = this.nd[var4];
                  }

                  if (var5 != null && var5.Q >= 0 && var5.Q < 13312 && var5.R >= 0 && var5.R < 13312) {
                     var2.a(var5.Q, var5.R, this.a(var5.R, var5.Q, (byte)9, var2.n) - var2.M, fk, 0);
                  }
               }

               var2.a(this.Uc, false);
               this.ah.a(-1, var2, (int)var2.o, (int)var2.q, false, 0, this.Ff, 60, (int)var2.p, var2.v);
            }
         } else {
            var2.a();
         }

         var2 = (ClientProj)this.oj.a(1);
      }

      ++eh;
      if (eh > 51) {
         eh = 0;
         this.hd.pIsaac(248);
      }
   }

   @ObfuscatedName("client.i(Z)V")
   public final void i(boolean arg0) {
      this.yj = new Pix8(this.Jb, "titlebox", 0);
      this.zj = new Pix8(this.Jb, "titlebutton", 0);
      this.fg = new Pix8[12];
      if (arg0) {
         this.a();
      }

      for(int var2 = 0; var2 < 12; ++var2) {
         this.fg[var2] = new Pix8(this.Jb, "runes", var2);
      }

      this.ie = new Pix24(128, 265);
      this.je = new Pix24(128, 265);

      for(int var3 = 0; var3 < 33920; ++var3) {
         this.ie.I[var3] = this.Lh.b[var3];
      }

      for(int var4 = 0; var4 < 33920; ++var4) {
         this.je.I[var4] = this.Mh.b[var4];
      }

      this.Rj = new int[256];

      for(int var5 = 0; var5 < 64; ++var5) {
         this.Rj[var5] = var5 * 262144;
      }

      for(int var6 = 0; var6 < 64; ++var6) {
         this.Rj[var6 + 64] = var6 * 1024 + 16711680;
      }

      for(int var7 = 0; var7 < 64; ++var7) {
         this.Rj[var7 + 128] = var7 * 4 + 16776960;
      }

      for(int var8 = 0; var8 < 64; ++var8) {
         this.Rj[var8 + 192] = 16777215;
      }

      this.Sj = new int[256];

      for(int var9 = 0; var9 < 64; ++var9) {
         this.Sj[var9] = var9 * 1024;
      }

      for(int var10 = 0; var10 < 64; ++var10) {
         this.Sj[var10 + 64] = var10 * 4 + 65280;
      }

      for(int var11 = 0; var11 < 64; ++var11) {
         this.Sj[var11 + 128] = var11 * 262144 + 65535;
      }

      for(int var12 = 0; var12 < 64; ++var12) {
         this.Sj[var12 + 192] = 16777215;
      }

      this.Tj = new int[256];

      for(int var13 = 0; var13 < 64; ++var13) {
         this.Tj[var13] = var13 * 4;
      }

      for(int var14 = 0; var14 < 64; ++var14) {
         this.Tj[var14 + 64] = var14 * 262144 + 255;
      }

      for(int var15 = 0; var15 < 64; ++var15) {
         this.Tj[var15 + 128] = var15 * 1024 + 16711935;
      }

      for(int var16 = 0; var16 < 64; ++var16) {
         this.Tj[var16 + 192] = 16777215;
      }

      this.Qj = new int[256];
      this.mh = new int[32768];
      this.nh = new int[32768];
      this.a((Pix8)null, 0);
      this.yf = new int[32768];
      this.zf = new int[32768];
      this.a(10, true, (String)"Connecting to fileserver");
      if (!this.Bi) {
         this.Uj = true;
         this.Bi = true;
         this.a((Runnable)this, 2);
      }
   }

   @ObfuscatedName("client.a(JI)V")
   public final void a(long arg0, int arg1) {
      if (arg0 != 0L) {
         for(int var4 = 0; var4 < this.gb; ++var4) {
            if (this.sg[var4] == arg0) {
               --this.gb;
               this.rh = true;

               for(int var5 = var4; var5 < this.gb; ++var5) {
                  this.W[var5] = this.W[var5 + 1];
                  this.Zi[var5] = this.Zi[var5 + 1];
                  this.sg[var5] = this.sg[var5 + 1];
               }

               this.hd.pIsaac(141);
               this.hd.p8(arg0);
               break;
            }
         }

         this.qb += arg1;
      }
   }

   @ObfuscatedName("client.l(I)V")
   public final void l(int arg0) {
      if (this.bg == 0) {
         int var2 = super.B;
         if (arg0 != 0) {
            this.rb = this.yh.g1();
         }

         if (this.hh == 1 && super.C >= 516 && super.D >= 160 && super.C <= 765 && super.D <= 205) {
            var2 = 0;
         }

         if (this.ef) {
            if (var2 != 1) {
               int var3 = super.v;
               int var4 = super.w;
               if (this.Kj == 0) {
                  var3 -= 4;
                  var4 -= 4;
               }

               if (this.Kj == 1) {
                  var3 -= 553;
                  var4 -= 205;
               }

               if (this.Kj == 2) {
                  var3 -= 17;
                  var4 -= 357;
               }

               if (var3 < this.Lj - 10 || var3 > this.Nj + this.Lj + 10 || var4 < this.Mj - 10 || var4 > this.Oj + this.Mj + 10) {
                  this.ef = false;
                  if (this.Kj == 1) {
                     this.rh = true;
                  }

                  if (this.Kj == 2) {
                     this.yi = true;
                  }
               }
            }

            if (var2 == 1) {
               int var5 = this.Lj;
               int var6 = this.Mj;
               int var7 = this.Nj;
               int var8 = super.C;
               int var9 = super.D;
               if (this.Kj == 0) {
                  var8 -= 4;
                  var9 -= 4;
               }

               if (this.Kj == 1) {
                  var8 -= 553;
                  var9 -= 205;
               }

               if (this.Kj == 2) {
                  var8 -= 17;
                  var9 -= 357;
               }

               int var10 = -1;

               for(int var11 = 0; var11 < this.th; ++var11) {
                  int var12 = (this.th - 1 - var11) * 15 + var6 + 31;
                  if (var8 > var5 && var8 < var5 + var7 && var9 > var12 - 13 && var9 < var12 + 3) {
                     var10 = var11;
                  }
               }

               if (var10 != -1) {
                  this.h(var10, 8);
               }

               this.ef = false;
               if (this.Kj == 1) {
                  this.rh = true;
               }

               if (this.Kj == 2) {
                  this.yi = true;
                  return;
               }
            }
         } else {
            if (var2 == 1 && this.th > 0) {
               int var13 = this.yd[this.th - 1];
               if (var13 == 9 || var13 == 225 || var13 == 444 || var13 == 564 || var13 == 894 || var13 == 961 || var13 == 399 || var13 == 324 || var13 == 227 || var13 == 891 || var13 == 52 || var13 == 1094) {
                  int var14 = this.wd[this.th - 1];
                  int var15 = this.xd[this.th - 1];
                  Component var16 = Component.a(var15);
                  if (var16.mb || var16.h) {
                     this.Rg = false;
                     this.bj = 0;
                     this.Zf = var15;
                     this.ag = var14;
                     this.bg = 2;
                     this.cg = super.C;
                     this.dg = super.D;
                     if (Component.a(var15).M == this.fh) {
                        this.bg = 1;
                     }

                     if (Component.a(var15).M == this.Fd) {
                        this.bg = 3;
                     }

                     return;
                  }
               }
            }

            if (var2 == 1 && (this.Gj == 1 || this.b(this.th - 1, this.Xg)) && this.th > 2) {
               var2 = 2;
            }

            if (var2 == 1 && this.th > 0) {
               this.h(this.th - 1, 8);
            }

            if (var2 != 2 || this.th <= 0) {
               return;
            }

            this.B(811);
         }

      }
   }

   @ObfuscatedName("client.a(ILEPQDEJTO;II)V")
   public final void a(int arg0, Pix24 arg1, int arg2, int arg3) {
      int var5 = arg0 * arg0 + arg3 * arg3;

      while(arg2 >= 0) {
         this.rb = -1;
      }

      if (var5 > 4225 && var5 < 90000) {
         int var6 = this.lc + this.Ki & 2047;
         int var7 = Model.Ib[var6];
         int var8 = Model.Jb[var6];
         int var9 = var7 * 256 / (this.ri + 256);
         int var10 = var8 * 256 / (this.ri + 256);
         int var11 = arg0 * var9 + arg3 * var10 >> 16;
         int var12 = arg0 * var10 - arg3 * var9 >> 16;
         double var13 = Math.atan2((double)var11, (double)var12);
         int var15 = (int)(Math.sin(var13) * 63.0D);
         int var16 = (int)(Math.cos(var13) * 57.0D);
         this.Fi.a(256, 15, var15 + 94 + 4 - 10, 15, 20, this.hg, 20, var13, 83 - var16 - 20);
      } else {
         this.a(arg0, true, arg1, arg3);
      }
   }

   @ObfuscatedName("client.a(ZIIIII)V")
   public final void a(boolean arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
      this.Jf.a(arg5, arg2, -488);
      this.Kf.a(arg3 + arg5 - 16, arg2, -488);
      Pix2D.a(arg3 - 32, arg5 + 16, this.Ac, (byte)-24, 16, arg2);
      int var7 = (arg3 - 32) * arg3 / arg4;
      if (var7 < 8) {
         var7 = 8;
      }

      int var8 = (arg3 - 32 - var7) * arg1 / (arg4 - arg3);
      Pix2D.a(var7, arg5 + 16 + var8, this.uf, (byte)-24, 16, arg2);
      Pix2D.a(arg2, this.xg, var7, false, arg5 + 16 + var8);
      Pix2D.a(arg2 + 1, this.xg, var7, false, arg5 + 16 + var8);
      if (!arg0) {
         this.qc = -136;
      }

      Pix2D.b(arg2, this.xg, arg5 + 16 + var8, 16, true);
      Pix2D.b(arg2, this.xg, arg5 + 17 + var8, 16, true);
      Pix2D.a(arg2 + 15, this.tj, var7, false, arg5 + 16 + var8);
      Pix2D.a(arg2 + 14, this.tj, var7 - 1, false, arg5 + 17 + var8);
      Pix2D.b(arg2, this.tj, arg5 + 15 + var8 + var7, 16, true);
      Pix2D.b(arg2 + 1, this.tj, arg5 + 14 + var8 + var7, 15, true);
   }

   @ObfuscatedName("client.a(IZ)V")
   public final void a(int arg0, boolean arg1) {
      int var3 = 26 / arg0;

      for(int var4 = 0; var4 < this.vg; ++var4) {
         ClientNpc var5 = this.ug[this.wg[var4]];
         int var6 = (this.wg[var4] << 14) + 536870912;
         if (var5 != null && var5.b((int)0) && var5.rb.x == arg1 && var5.rb.b(-993)) {
            int var7 = var5.Q >> 7;
            int var8 = var5.R >> 7;
            if (var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if (var5.H == 1 && (var5.Q & 127) == 64 && (var5.R & 127) == 64) {
                  if (this.Hb[var7][var8] == this.Ag) {
                     continue;
                  }

                  this.Hb[var7][var8] = this.Ag;
               }

               if (!var5.rb.k) {
                  var6 += Integer.MIN_VALUE;
               }

               this.ah.a(var6, var5, var5.Q, this.a(var5.R, var5.Q, (byte)9, this.Ff), var5.y, 0, this.Ff, (var5.H - 1) * 64 + 60, var5.R, var5.S);
            }
         }
      }

   }

   @ObfuscatedName("client.c(II)V")
   public final void c(int arg0, int arg1) {
      sign.Signlink.wavevol = arg1;
      if (arg0 <= 0) {
         this.Qe = 57;
      }
   }

   @ObfuscatedName("client.m(I)V")
   public final void m(int arg0) {
      if (this.ub > 0) {
         this.n(true);
      } else {
         this.a(-332, "Please wait - attempting to reestablish", "Connection lost");
         this.Pe = 0;
         if (arg0 != 1) {
            Ai = true;
         }

         this.ig = 0;
         ClientStream var2 = this.pe;
         this.zg = false;
         this.X = 0;
         this.a(this.Gf, this.Hf, true);
         if (!this.zg) {
            this.n(true);
         }

         try {
            var2.a();
         } catch (Exception var3) {
         }
      }
   }

   @ObfuscatedName("client.a(ILEWIXBTLV;)Z")
   public final boolean a(int arg0, Component arg1) {
      int var3 = arg1.G;
      if (arg0 <= 0) {
         this.rb = -1;
      }

      if (this.hb == 2) {
         if (var3 == 201) {
            this.yi = true;
            this.Ci = 0;
            this.nb = true;
            this.re = "";
            this.fi = 1;
            this.Gc = "Enter name of friend to add to list";
         }

         if (var3 == 202) {
            this.yi = true;
            this.Ci = 0;
            this.nb = true;
            this.re = "";
            this.fi = 2;
            this.Gc = "Enter name of friend to delete from list";
         }
      }

      if (var3 == 205) {
         this.ub = 250;
         return true;
      } else {
         if (var3 == 501) {
            this.yi = true;
            this.Ci = 0;
            this.nb = true;
            this.re = "";
            this.fi = 4;
            this.Gc = "Enter name of player to add to list";
         }

         if (var3 == 502) {
            this.yi = true;
            this.Ci = 0;
            this.nb = true;
            this.re = "";
            this.fi = 5;
            this.Gc = "Enter name of player to delete from list";
         }

         if (var3 >= 300 && var3 <= 313) {
            int var4 = (var3 - 300) / 2;
            int var5 = var3 & 1;
            int var6 = this.gk[var4];
            if (var6 != -1) {
               while(true) {
                  if (var5 == 0) {
                     --var6;
                     if (var6 < 0) {
                        var6 = IdkType.d - 1;
                     }
                  }

                  if (var5 == 1) {
                     ++var6;
                     if (var6 >= IdkType.d) {
                        var6 = 0;
                     }
                  }

                  if (!IdkType.e[var6].k && IdkType.e[var6].f == var4 + (this.Gg ? 0 : 7)) {
                     this.gk[var4] = var6;
                     this.jj = true;
                     break;
                  }
               }
            }
         }

         if (var3 >= 314 && var3 <= 323) {
            int var7 = (var3 - 314) / 2;
            int var8 = var3 & 1;
            int var9 = this.Nf[var7];
            if (var8 == 0) {
               --var9;
               if (var9 < 0) {
                  var9 = Zd[var7].length - 1;
               }
            }

            if (var8 == 1) {
               ++var9;
               if (var9 >= Zd[var7].length) {
                  var9 = 0;
               }
            }

            this.Nf[var7] = var9;
            this.jj = true;
         }

         if (var3 == 324 && !this.Gg) {
            this.Gg = true;
            this.f(this.ge);
         }

         if (var3 == 325 && this.Gg) {
            this.Gg = false;
            this.f(this.ge);
         }

         if (var3 != 326) {
            if (var3 == 620) {
               this.Mf = !this.Mf;
            }

            if (var3 >= 601 && var3 <= 613) {
               this.b(false);
               if (this.M.length() > 0) {
                  this.hd.pIsaac(184);
                  this.hd.p8(JString.a(this.M));
                  this.hd.p1(var3 - 601);
                  this.hd.p1(this.Mf ? 1 : 0);
               }
            }

            return false;
         } else {
            this.hd.pIsaac(163);
            this.hd.p1(this.Gg ? 0 : 1);

            for(int var10 = 0; var10 < 7; ++var10) {
               this.hd.p1(this.gk[var10]);
            }

            for(int var11 = 0; var11 < 5; ++var11) {
               this.hd.p1(this.Nf[var11]);
            }

            return true;
         }
      }
   }

   @ObfuscatedName("client.a(IILjava/lang/String;IILjava/lang/String;)LATJMVOZR;")
   public final Jagfile a(int arg0, int arg1, String arg2, int arg3, int arg4, String arg5) {
      byte[] var7 = null;
      int var8 = 5;

      try {
         if (this.mi[0] != null) {
            var7 = this.mi[0].a(this.Tb, arg4);
         }
      } catch (Exception var30) {
      }

      if (var7 != null) {
         this.Cf.reset();
         this.Cf.update(var7);
         int var9 = (int)this.Cf.getValue();
         if (arg1 != var9) {
            var7 = null;
         }
      }

      if (var7 != null) {
         return new Jagfile(var7);
      } else {
         int var11 = 0;
         if (arg0 != 14076) {
            this.nj = -343;
         }

         while(var7 == null) {
            String var12 = "Unknown error";
            this.a(arg3, true, "Requesting " + arg5);
            Object var13 = null;

            try {
               int var14 = 0;
               DataInputStream var15 = this.b(arg2 + arg1);
               byte[] var16 = new byte[6];
               var15.readFully(var16, 0, 6);
               Packet var17 = new Packet(var16);
               var17.pos = 3;
               int var18 = var17.g3() + 6;
               int var19 = 6;
               var7 = new byte[var18];

               for(int var20 = 0; var20 < 6; ++var20) {
                  var7[var20] = var16[var20];
               }

               while(var19 < var18) {
                  int var21 = var18 - var19;
                  if (var21 > 1000) {
                     var21 = 1000;
                  }

                  int var22 = var15.read(var7, var19, var21);
                  if (var22 < 0) {
                     (new StringBuffer("Length error: ")).append(var19).append("/").append(var18).toString();
                     throw new IOException("EOF");
                  }

                  var19 += var22;
                  int var23 = var19 * 100 / var18;
                  if (var14 != var23) {
                     this.a(arg3, true, "Loading " + arg5 + " - " + var23 + "%");
                  }

                  var14 = var23;
               }

               var15.close();

               try {
                  if (this.mi[0] != null) {
                     this.mi[0].a(var7.length, true, var7, arg4);
                  }
               } catch (Exception var29) {
                  this.mi[0] = null;
               }

               if (var7 != null) {
                  this.Cf.reset();
                  this.Cf.update(var7);
                  int var24 = (int)this.Cf.getValue();
                  if (arg1 != var24) {
                     var7 = null;
                     ++var11;
                     var12 = "Checksum error: " + var24;
                  }
               }
            } catch (IOException var31) {
               if (var12.equals("Unknown error")) {
                  var12 = "Connection error";
               }

               var7 = null;
            } catch (NullPointerException var32) {
               var12 = "Null error";
               var7 = null;
               if (!sign.Signlink.reporterror) {
                  return null;
               }
            } catch (ArrayIndexOutOfBoundsException var33) {
               var12 = "Bounds error";
               var7 = null;
               if (!sign.Signlink.reporterror) {
                  return null;
               }
            } catch (Exception var34) {
               var12 = "Unexpected error";
               var7 = null;
               if (!sign.Signlink.reporterror) {
                  return null;
               }
            }

            if (var7 == null) {
               for(int var26 = var8; var26 > 0; --var26) {
                  if (var11 >= 3) {
                     this.a(arg3, true, "Game updated - please reload page");
                     var26 = 10;
                  } else {
                     this.a(arg3, true, var12 + " - Retrying in " + var26);
                  }

                  try {
                     Thread.sleep(1000L);
                  } catch (Exception var28) {
                  }
               }

               var8 *= 2;
               if (var8 > 60) {
                  var8 = 60;
               }

               this.Vb = !this.Vb;
            }
         }

         return new Jagfile(var7);
      }
   }

   @ObfuscatedName("client.b(B)V")
   public final void b(byte arg0) {
      this.Le = true;
      if (arg0 == -99) {
         ;
      }
   }

   @ObfuscatedName("client.a(LMFMVIYHT;II)V")
   public final void a(Packet arg0, int arg1, int arg2) {
      int var4 = 24 / arg2;

      for(int var5 = 0; var5 < this.qd; ++var5) {
         int var6 = this.rd[var5];
         ClientNpc var7 = this.ug[var6];
         int var8 = arg0.g1();
         if ((var8 & 1) != 0) {
            var7.rb = NpcType.c(arg0.b((byte)9));
            var7.H = var7.rb.v;
            var7.G = var7.rb.E;
            var7.Z = var7.rb.y;
            var7.ab = var7.rb.w;
            var7.bb = var7.rb.u;
            var7.cb = var7.rb.m;
            var7.ob = var7.rb.a;
         }

         if ((var8 & 64) != 0) {
            var7.P = arg0.n(-125);
            if (var7.P == 65535) {
               var7.P = -1;
            }
         }

         if ((var8 & 128) != 0) {
            int var9 = arg0.h(0);
            int var10 = arg0.h(0);
            var7.a(fk, false, var9, var10);
            var7.B = fk + 300;
            var7.C = arg0.g1();
            var7.D = arg0.j(this.ui);
         }

         if ((var8 & 4) != 0) {
            var7.U = arg0.g2();
            int var11 = arg0.s(3);
            var7.Y = var11 >> 16;
            var7.X = (var11 & 65535) + fk;
            var7.V = 0;
            var7.W = 0;
            if (var7.X > fk) {
               var7.V = -1;
            }

            if (var7.U == 65535) {
               var7.U = -1;
            }
         }

         if ((var8 & 32) != 0) {
            var7.m = arg0.gjstr();
            var7.o = 100;
         }

         if ((var8 & 8) != 0) {
            var7.E = arg0.o(-600);
            var7.F = arg0.n(-125);
         }

         if ((var8 & 2) != 0) {
            int var12 = arg0.g2();
            if (var12 == 65535) {
               var12 = -1;
            }

            int var13 = arg0.j(this.ui);
            if (var7.eb == var12 && var12 != -1) {
               int var14 = SeqType.d[var12].r;
               if (var14 == 1) {
                  var7.fb = 0;
                  var7.gb = 0;
                  var7.hb = var13;
                  var7.ib = 0;
               }

               if (var14 == 2) {
                  var7.ib = 0;
               }
            } else if (var12 == -1 || var7.eb == -1 || SeqType.d[var12].l >= SeqType.d[var7.eb].l) {
               var7.eb = var12;
               var7.fb = 0;
               var7.gb = 0;
               var7.hb = var13;
               var7.ib = 0;
               var7.T = var7.nb;
            }
         }

         if ((var8 & 16) != 0) {
            int var15 = arg0.j(this.ui);
            int var16 = arg0.j(this.ui);
            var7.a(fk, false, var15, var16);
            var7.B = fk + 300;
            var7.C = arg0.g1();
            var7.D = arg0.i(-34545);
         }
      }

   }

   @ObfuscatedName("client.a(IILZGNGQRPJ;ILMFMVIYHT;)V")
   public final void a(int arg0, int arg1, ClientPlayer arg2, int arg3, Packet arg4) {
      if (arg0 != 2) {
         for(int var6 = 1; var6 > 0; ++var6) {
         }
      }

      if ((arg3 & 8) != 0) {
         int var7 = arg4.g2();
         if (var7 == 65535) {
            var7 = -1;
         }

         int var8 = arg4.j(this.ui);
         if (arg2.eb == var7 && var7 != -1) {
            int var9 = SeqType.d[var7].r;
            if (var9 == 1) {
               arg2.fb = 0;
               arg2.gb = 0;
               arg2.hb = var8;
               arg2.ib = 0;
            }

            if (var9 == 2) {
               arg2.ib = 0;
            }
         } else if (var7 == -1 || arg2.eb == -1 || SeqType.d[var7].l >= SeqType.d[arg2.eb].l) {
            arg2.eb = var7;
            arg2.fb = 0;
            arg2.gb = 0;
            arg2.hb = var8;
            arg2.ib = 0;
            arg2.T = arg2.nb;
         }
      }

      if ((arg3 & 16) != 0) {
         arg2.m = arg4.gjstr();
         if (arg2.m.charAt(0) == '~') {
            arg2.m = arg2.m.substring(1);
            this.a(arg2.yb, (byte)-123, arg2.m, 2);
         } else if (dh == arg2) {
            this.a(arg2.yb, (byte)-123, arg2.m, 2);
         }

         arg2.p = 0;
         arg2.z = 0;
         arg2.o = 150;
      }

      if ((arg3 & 256) != 0) {
         arg2.I = arg4.h(0);
         arg2.K = arg4.i(-34545);
         arg2.J = arg4.j(this.ui);
         arg2.L = arg4.g1();
         arg2.M = arg4.g2() + fk;
         arg2.N = arg4.b((byte)9) + fk;
         arg2.O = arg4.g1();
         arg2.a(-56);
      }

      if ((arg3 & 1) != 0) {
         arg2.P = arg4.b((byte)9);
         if (arg2.P == 65535) {
            arg2.P = -1;
         }
      }

      if ((arg3 & 2) != 0) {
         arg2.E = arg4.g2();
         arg2.F = arg4.g2();
      }

      if ((arg3 & 512) != 0) {
         arg2.U = arg4.b((byte)9);
         int var10 = arg4.s(3);
         arg2.Y = var10 >> 16;
         arg2.X = (var10 & 65535) + fk;
         arg2.V = 0;
         arg2.W = 0;
         if (arg2.X > fk) {
            arg2.V = -1;
         }

         if (arg2.U == 65535) {
            arg2.U = -1;
         }
      }

      if ((arg3 & 4) != 0) {
         int var11 = arg4.g1();
         byte[] var12 = new byte[var11];
         Packet var13 = new Packet(var12);
         arg4.a((byte)-73, var12, var11, 0);
         this.sd[arg1] = var13;
         arg2.a(var13, 0);
      }

      if ((arg3 & 1024) != 0) {
         int var14 = arg4.h(0);
         int var15 = arg4.j(this.ui);
         arg2.a(fk, false, var14, var15);
         arg2.B = fk + 300;
         arg2.C = arg4.i(-34545);
         arg2.D = arg4.g1();
      }

      if ((arg3 & 64) != 0) {
         int var16 = arg4.g2();
         int var17 = arg4.i(-34545);
         int var18 = arg4.h(0);
         int var19 = arg4.pos;
         if (arg2.yb != null && arg2.Fb) {
            long var20 = JString.a(arg2.yb);
            boolean var22 = false;
            if (var17 <= 1) {
               for(int var23 = 0; var23 < this.cb; ++var23) {
                  if (this.nf[var23] == var20) {
                     var22 = true;
                     break;
                  }
               }
            }

            if (!var22 && this.Ei == 0) {
               try {
                  this.tg.pos = 0;
                  arg4.b(this.tg.data, var18, 0, 0);
                  this.tg.pos = 0;
                  String var24 = WordPack.a(0, this.tg, var18);
                  String var25 = WordFilter.a((byte)0, (String)var24);
                  arg2.m = var25;
                  arg2.p = var16 >> 8;
                  arg2.z = var16 & 255;
                  arg2.o = 150;
                  if (var17 != 2 && var17 != 3) {
                     if (var17 == 1) {
                        this.a("@cr1@" + arg2.yb, (byte)-123, var25, 1);
                     } else {
                        this.a(arg2.yb, (byte)-123, var25, 2);
                     }
                  } else {
                     this.a("@cr2@" + arg2.yb, (byte)-123, var25, 1);
                  }
               } catch (Exception var29) {
                  sign.Signlink.reporterror("cde2");
               }
            }
         }

         arg4.pos = var18 + var19;
      }

      if ((arg3 & 128) != 0) {
         int var27 = arg4.j(this.ui);
         int var28 = arg4.i(-34545);
         arg2.a(fk, false, var27, var28);
         arg2.B = fk + 300;
         arg2.C = arg4.j(this.ui);
         arg2.D = arg4.g1();
      }
   }

   @ObfuscatedName("client.n(I)V")
   public final void n(int arg0) {
      if (this.Ih == null) {
         super.o = null;
         this.Vg = null;
         this.Tg = null;
         this.Sg = null;
         this.Ug = null;
         this.Wf = null;
         this.Xf = null;
         this.Yf = null;
         if (arg0 < 0) {
            this.Lh = new PixMap(265, (byte)-12, this.d((int)-756), 128);
            Pix2D.a((int)4);
            this.Mh = new PixMap(265, (byte)-12, this.d((int)-756), 128);
            Pix2D.a((int)4);
            this.Ih = new PixMap(171, (byte)-12, this.d((int)-756), 509);
            Pix2D.a((int)4);
            this.Jh = new PixMap(132, (byte)-12, this.d((int)-756), 360);
            Pix2D.a((int)4);
            this.Kh = new PixMap(200, (byte)-12, this.d((int)-756), 360);
            Pix2D.a((int)4);
            this.Nh = new PixMap(238, (byte)-12, this.d((int)-756), 202);
            Pix2D.a((int)4);
            this.Oh = new PixMap(238, (byte)-12, this.d((int)-756), 203);
            Pix2D.a((int)4);
            this.Ph = new PixMap(94, (byte)-12, this.d((int)-756), 74);
            Pix2D.a((int)4);
            this.Qh = new PixMap(94, (byte)-12, this.d((int)-756), 75);
            Pix2D.a((int)4);
            if (this.Jb != null) {
               this.r(Rh);
               this.i(false);
            }

            this.Le = true;
         }
      }
   }

   @ObfuscatedName("client.a()V")
   public final void a() {
      this.a(20, true, (String)"Starting up");
      if (sign.Signlink.sunjava) {
         super.h = 5;
      }

      if (Qd) {
         this.he = true;
      } else {
         Qd = true;
         boolean var1 = false;
         String var2 = this.j(-42588);
         if (var2.endsWith("jagex.com")) {
            var1 = true;
         }

         if (var2.endsWith("runescape.com")) {
            var1 = true;
         }

         if (var2.endsWith("192.168.1.2")) {
            var1 = true;
         }

         if (var2.endsWith("192.168.1.231")) {
            var1 = true;
         }

         if (var2.endsWith("192.168.1.229")) {
            var1 = true;
         }

         if (var2.endsWith("192.168.1.228")) {
            var1 = true;
         }

         if (var2.endsWith("192.168.1.227")) {
            var1 = true;
         }

         if (var2.endsWith("192.168.1.226")) {
            var1 = true;
         }

         if (var2.endsWith("192.168.1.224")) {
            var1 = true;
         }

         if (var2.endsWith("192.168.1.223")) {
            var1 = true;
         }

         if (var2.endsWith("192.168.1.221")) {
            var1 = true;
         }

         if (var2.endsWith("127.0.0.1")) {
            var1 = true;
         }

         if (!var1) {
            this.Lf = true;
         } else {
            if (sign.Signlink.cache_dat != null) {
               for(int var3 = 0; var3 < 5; ++var3) {
                  this.mi[var3] = new FileStream(var3 + 1, 600000, sign.Signlink.cache_dat, sign.Signlink.cache_idx[var3], 4);
               }
            }

            try {
               this.k(false);
               this.Jb = this.a(14076, this.K[1], "title", 25, 1, "title screen");
               this.Ye = new PixFont(false, this.Jb, -914, "p11_full");
               this.Ze = new PixFont(false, this.Jb, -914, "p12_full");
               this.af = new PixFont(false, this.Jb, -914, "b12_full");
               this.bf = new PixFont(true, this.Jb, -914, "q8_full");
               this.r(Rh);
               this.i(false);
               Jagfile var4 = this.a(14076, this.K[2], "config", 30, 2, "config");
               Jagfile var5 = this.a(14076, this.K[3], "interface", 35, 3, "interface");
               Jagfile var6 = this.a(14076, this.K[4], "media", 40, 4, "2d graphics");
               Jagfile var7 = this.a(14076, this.K[6], "textures", 45, 6, "textures");
               Jagfile var8 = this.a(14076, this.K[7], "wordenc", 50, 7, "chat system");
               Jagfile var9 = this.a(14076, this.K[8], "sounds", 55, 8, "sound effects");
               this.ng = new byte[4][104][104];
               this.Mb = new int[4][105][105];
               this.ah = new World3D(this.Mb, 104, 4, 104, (byte)5);

               for(int var10 = 0; var10 < 4; ++var10) {
                  this.Si[var10] = new CollisionMap(104, 0, 104);
               }

               this.kg = new Pix24(512, 512);
               Jagfile var11 = this.a(14076, this.K[5], "versionlist", 60, 5, "update list");
               this.a(60, true, (String)"Connecting to update server");
               this.xj = new OnDemand();
               this.xj.a(var11, this);
               AnimFrame.a(this.xj.d(553));
               Model.a(this.xj.c(0, -31140), this.xj);
               if (!vc) {
                  this.cj = 0;
                  this.dj = true;
                  this.xj.b(2, this.cj);

                  while(this.xj.b() > 0) {
                     this.j(false);

                     try {
                        Thread.sleep(100L);
                     } catch (Exception var74) {
                     }

                     if (this.xj.U > 3) {
                        this.a("ondemand");
                        return;
                     }
                  }
               }

               this.a(65, true, (String)"Requesting animations");
               int var12 = this.xj.c(1, -31140);

               for(int var13 = 0; var13 < var12; ++var13) {
                  this.xj.b(1, var13);
               }

               while(this.xj.b() > 0) {
                  int var14 = var12 - this.xj.b();
                  if (var14 > 0) {
                     this.a(65, true, (String)("Loading animations - " + var14 * 100 / var12 + "%"));
                  }

                  this.j(false);

                  try {
                     Thread.sleep(100L);
                  } catch (Exception var73) {
                  }

                  if (this.xj.U > 3) {
                     this.a("ondemand");
                     return;
                  }
               }

               this.a(70, true, (String)"Requesting models");
               int var15 = this.xj.c(0, -31140);

               for(int var16 = 0; var16 < var15; ++var16) {
                  int var17 = this.xj.a(var16, -493);
                  if ((var17 & 1) != 0) {
                     this.xj.b(0, var16);
                  }
               }

               int var18 = this.xj.b();

               while(this.xj.b() > 0) {
                  int var19 = var18 - this.xj.b();
                  if (var19 > 0) {
                     this.a(70, true, (String)("Loading models - " + var19 * 100 / var18 + "%"));
                  }

                  this.j(false);

                  try {
                     Thread.sleep(100L);
                  } catch (Exception var72) {
                  }
               }

               if (this.mi[0] != null) {
                  this.a(75, true, (String)"Requesting maps");
                  this.xj.b(3, this.xj.a(0, 47, (int)48, 0));
                  this.xj.b(3, this.xj.a(0, 47, (int)48, 1));
                  this.xj.b(3, this.xj.a(0, 48, (int)48, 0));
                  this.xj.b(3, this.xj.a(0, 48, (int)48, 1));
                  this.xj.b(3, this.xj.a(0, 49, (int)48, 0));
                  this.xj.b(3, this.xj.a(0, 49, (int)48, 1));
                  this.xj.b(3, this.xj.a(0, 47, (int)47, 0));
                  this.xj.b(3, this.xj.a(0, 47, (int)47, 1));
                  this.xj.b(3, this.xj.a(0, 48, (int)47, 0));
                  this.xj.b(3, this.xj.a(0, 48, (int)47, 1));
                  this.xj.b(3, this.xj.a(0, 48, (int)148, 0));
                  this.xj.b(3, this.xj.a(0, 48, (int)148, 1));
                  int var20 = this.xj.b();

                  while(this.xj.b() > 0) {
                     int var21 = var20 - this.xj.b();
                     if (var21 > 0) {
                        this.a(75, true, (String)("Loading maps - " + var21 * 100 / var20 + "%"));
                     }

                     this.j(false);

                     try {
                        Thread.sleep(100L);
                     } catch (Exception var71) {
                     }
                  }
               }

               int var22 = this.xj.c(0, -31140);

               for(int var23 = 0; var23 < var22; ++var23) {
                  int var24 = this.xj.a(var23, -493);
                  byte var25 = 0;
                  if ((var24 & 8) != 0) {
                     var25 = 10;
                  } else if ((var24 & 32) != 0) {
                     var25 = 9;
                  } else if ((var24 & 16) != 0) {
                     var25 = 8;
                  } else if ((var24 & 64) != 0) {
                     var25 = 7;
                  } else if ((var24 & 128) != 0) {
                     var25 = 6;
                  } else if ((var24 & 2) != 0) {
                     var25 = 5;
                  } else if ((var24 & 4) != 0) {
                     var25 = 4;
                  }

                  if ((var24 & 1) != 0) {
                     var25 = 3;
                  }

                  if (var25 != 0) {
                     this.xj.a(-44, 0, (byte)var25, var23);
                  }
               }

               this.xj.a(uc, (byte)109);
               if (!vc) {
                  int var26 = this.xj.c(2, -31140);

                  for(int var27 = 1; var27 < var26; ++var27) {
                     if (this.xj.a(var27, gd)) {
                        this.xj.a(-44, 2, (byte)1, var27);
                     }
                  }
               }

               int var28 = this.xj.c(0, -31140);

               for(int var29 = 0; var29 < var28; ++var29) {
                  int var30 = this.xj.a(var29, -493);
                  if (var30 == 0 && this.xj.r < 200) {
                     this.xj.a(-44, 0, (byte)1, var29);
                  }
               }

               this.a(80, true, (String)"Unpacking media");
               this.vh = new Pix8(var6, "invback", 0);
               this.xh = new Pix8(var6, "chatback", 0);
               this.wh = new Pix8(var6, "mapback", 0);
               this.id = new Pix8(var6, "backbase1", 0);
               this.jd = new Pix8(var6, "backbase2", 0);
               this.kd = new Pix8(var6, "backhmid1", 0);

               for(int var31 = 0; var31 < 13; ++var31) {
                  this.td[var31] = new Pix8(var6, "sideicons", var31);
               }

               this.eg = new Pix24(var6, "compass", 0);
               this.Fi = new Pix24(var6, "mapedge", 0);
               this.Fi.b(1790);

               for(int var32 = 0; var32 < 72; ++var32) {
                  this.Pg[var32] = new Pix8(var6, "mapscene", var32);
               }

               for(int var33 = 0; var33 < 70; ++var33) {
                  this.we[var33] = new Pix24(var6, "mapfunction", var33);
               }

               for(int var34 = 0; var34 < 5; ++var34) {
                  this.sh[var34] = new Pix24(var6, "hitmarks", var34);
               }

               for(int var35 = 0; var35 < 6; ++var35) {
                  this.uj[var35] = new Pix24(var6, "headicons_pk", var35);
               }

               for(int var36 = 0; var36 < 9; ++var36) {
                  this.tf[var36] = new Pix24(var6, "headicons_prayer", var36);
               }

               for(int var37 = 0; var37 < 6; ++var37) {
                  this.Xc[var37] = new Pix24(var6, "headicons_hint", var37);
               }

               this.Af = new Pix24(var6, "overlay_multiway", 0);
               this.Be = new Pix24(var6, "mapmarker", 0);
               this.Ce = new Pix24(var6, "mapmarker", 1);

               for(int var38 = 0; var38 < 8; ++var38) {
                  this.Rb[var38] = new Pix24(var6, "cross", var38);
               }

               this.Ch = new Pix24(var6, "mapdots", 0);
               this.Dh = new Pix24(var6, "mapdots", 1);
               this.Eh = new Pix24(var6, "mapdots", 2);
               this.Fh = new Pix24(var6, "mapdots", 3);
               this.Gh = new Pix24(var6, "mapdots", 4);
               this.Jf = new Pix8(var6, "scrollbar", 0);
               this.Kf = new Pix8(var6, "scrollbar", 1);
               this.Bb = new Pix8(var6, "redstone1", 0);
               this.Cb = new Pix8(var6, "redstone2", 0);
               this.Db = new Pix8(var6, "redstone3", 0);
               this.Eb = new Pix8(var6, "redstone1", 0);
               this.Eb.c(0);
               this.Fb = new Pix8(var6, "redstone2", 0);
               this.Fb.c(0);
               this.Ad = new Pix8(var6, "redstone1", 0);
               this.Ad.b((byte)7);
               this.Bd = new Pix8(var6, "redstone2", 0);
               this.Bd.b((byte)7);
               this.Cd = new Pix8(var6, "redstone3", 0);
               this.Cd.b((byte)7);
               this.Dd = new Pix8(var6, "redstone1", 0);
               this.Dd.c(0);
               this.Dd.b((byte)7);
               this.Ed = new Pix8(var6, "redstone2", 0);
               this.Ed.c(0);
               this.Ed.b((byte)7);

               for(int var39 = 0; var39 < 2; ++var39) {
                  this.Eg[var39] = new Pix8(var6, "mod_icons", var39);
               }

               Pix24 var40 = new Pix24(var6, "backleft1", 0);
               this.bc = new PixMap(var40.K, (byte)-12, this.d((int)-756), var40.J);
               var40.a(0, -192, 0);
               Pix24 var41 = new Pix24(var6, "backleft2", 0);
               this.cc = new PixMap(var41.K, (byte)-12, this.d((int)-756), var41.J);
               var41.a(0, -192, 0);
               Pix24 var42 = new Pix24(var6, "backright1", 0);
               this.dc = new PixMap(var42.K, (byte)-12, this.d((int)-756), var42.J);
               var42.a(0, -192, 0);
               Pix24 var43 = new Pix24(var6, "backright2", 0);
               this.ec = new PixMap(var43.K, (byte)-12, this.d((int)-756), var43.J);
               var43.a(0, -192, 0);
               Pix24 var44 = new Pix24(var6, "backtop1", 0);
               this.fc = new PixMap(var44.K, (byte)-12, this.d((int)-756), var44.J);
               var44.a(0, -192, 0);
               Pix24 var45 = new Pix24(var6, "backvmid1", 0);
               this.gc = new PixMap(var45.K, (byte)-12, this.d((int)-756), var45.J);
               var45.a(0, -192, 0);
               Pix24 var46 = new Pix24(var6, "backvmid2", 0);
               this.hc = new PixMap(var46.K, (byte)-12, this.d((int)-756), var46.J);
               var46.a(0, -192, 0);
               Pix24 var47 = new Pix24(var6, "backvmid3", 0);
               this.ic = new PixMap(var47.K, (byte)-12, this.d((int)-756), var47.J);
               var47.a(0, -192, 0);
               Pix24 var48 = new Pix24(var6, "backhmid2", 0);
               this.jc = new PixMap(var48.K, (byte)-12, this.d((int)-756), var48.J);
               var48.a(0, -192, 0);
               int var49 = (int)(Math.random() * 21.0D) - 10;
               int var50 = (int)(Math.random() * 21.0D) - 10;
               int var51 = (int)(Math.random() * 21.0D) - 10;
               int var52 = (int)(Math.random() * 41.0D) - 20;

               for(int var53 = 0; var53 < 100; ++var53) {
                  if (this.we[var53] != null) {
                     this.we[var53].a(var51 + var52, var50 + var52, var49 + var52, -235);
                  }

                  if (this.Pg[var53] != null) {
                     this.Pg[var53].a(var51 + var52, var50 + var52, var49 + var52, -235);
                  }
               }

               this.a(83, true, (String)"Unpacking textures");
               Pix3D.a(var7, -17551);
               Pix3D.a(0.8D, (byte)6);
               Pix3D.a((byte)7, 20);
               this.a(86, true, (String)"Unpacking config");
               SeqType.a(var4, 36135);
               LocType.a(var4);
               FloType.a(var4, 36135);
               ObjType.a(var4);
               NpcType.a(var4);
               IdkType.a(var4, 36135);
               SpotAnimType.a(var4, 36135);
               VarpType.a(var4, 36135);
               VarbitType.a(var4, 36135);
               ObjType.s = uc;
               if (!vc) {
                  this.a(90, true, (String)"Unpacking sounds");
                  byte[] var54 = var9.read("sounds.dat", (byte[])null);
                  Packet var55 = new Packet(var54);
                  Wave.a(var55, 36135);
               }

               this.a(95, true, (String)"Unpacking interfaces");
               PixFont[] var56 = new PixFont[]{this.Ye, this.Ze, this.af, this.bf};
               Component.a(-845, var56, var5, var6);
               this.a(100, true, (String)"Preparing game engine");

               for(int var57 = 0; var57 < 33; ++var57) {
                  int var58 = 999;
                  int var59 = 0;

                  for(int var60 = 0; var60 < 34; ++var60) {
                     if (this.wh.D[this.wh.F * var57 + var60] == 0) {
                        if (var58 == 999) {
                           var58 = var60;
                        }
                     } else if (var58 != 999) {
                        var59 = var60;
                        break;
                     }
                  }

                  this.qh[var57] = var58;
                  this.sj[var57] = var59 - var58;
               }

               for(int var61 = 5; var61 < 156; ++var61) {
                  int var62 = 999;
                  int var63 = 0;

                  for(int var64 = 25; var64 < 172; ++var64) {
                     if (this.wh.D[this.wh.F * var61 + var64] == 0 && (var64 > 34 || var61 > 34)) {
                        if (var62 == 999) {
                           var62 = var64;
                        }
                     } else if (var62 != 999) {
                        var63 = var64;
                        break;
                     }
                  }

                  this.ke[var61 - 5] = var62 - 25;
                  this.pc[var61 - 5] = var63 - var62;
               }

               Pix3D.a(503, 7, 765);
               this.Ud = Pix3D.K;
               Pix3D.a(96, 7, 479);
               this.Rd = Pix3D.K;
               Pix3D.a(261, 7, 190);
               this.Sd = Pix3D.K;
               Pix3D.a(334, 7, 512);
               this.Td = Pix3D.K;
               int[] var65 = new int[9];

               for(int var66 = 0; var66 < 9; ++var66) {
                  int var67 = var66 * 32 + 128 + 15;
                  int var68 = var67 * 3 + 600;
                  int var69 = Pix3D.I[var67];
                  var65[var66] = var68 * var69 >> 16;
               }

               World3D.a(334, 22845, var65, 800, 500, 512);
               WordFilter.a(var8);
               this.Gi = new MouseTracking(this, (byte)-116);
               this.a((Runnable)this.Gi, 10);
               ClientLocAnim.v = this;
               LocType.m = this;
               NpcType.i = this;
            } catch (Exception var75) {
               sign.Signlink.reporterror("loaderror " + this.se + " " + this.ck);
               this.pj = true;
            }
         }
      }
   }

   @ObfuscatedName("client.d(II)V")
   public final void d(int arg0, int arg1) {
      if (arg1 < 0) {
         if (!vc) {
            for(int var3 = 0; var3 < this.wj.length; ++var3) {
               int var4 = this.wj[var3];
               if (Pix3D.S[var4] >= arg0) {
                  Pix8 var5 = Pix3D.M[var4];
                  int var6 = var5.G * var5.F - 1;
                  int var7 = this.Uc * var5.F * 2;
                  byte[] var8 = var5.D;
                  byte[] var9 = this.Di;

                  for(int var10 = 0; var10 <= var6; ++var10) {
                     var9[var10] = var8[var10 - var7 & var6];
                  }

                  var5.D = var9;
                  this.Di = var8;
                  Pix3D.b(var4, 9);
               }
            }

         }
      }
   }

   @ObfuscatedName("client.a(ILEWIXBTLV;IIIIII)V")
   public final void a(int arg0, Component arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
      if (arg6 == 23658) {
         if (arg1.A == 0 && arg1.W != null && !arg1.j) {
            if (arg5 >= arg4 && arg7 >= arg0 && arg5 <= arg1.F + arg4 && arg7 <= arg1.C + arg0) {
               int var9 = arg1.W.length;

               for(int var10 = 0; var10 < var9; ++var10) {
                  int var11 = arg1.w[var10] + arg4;
                  int var12 = arg1.ob[var10] + arg0 - arg3;
                  Component var13 = Component.a(arg1.W[var10]);
                  int var14 = var13.s + var11;
                  int var15 = var13.X + var12;
                  if ((var13.S >= 0 || var13.Z != 0) && arg5 >= var14 && arg7 >= var15 && arg5 < var13.F + var14 && arg7 < var13.C + var15) {
                     if (var13.S >= 0) {
                        this.kc = var13.S;
                     } else {
                        this.kc = var13.f;
                     }
                  }

                  if (var13.A == 8 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.F + var14 && arg7 < var13.C + var15) {
                     this.Vj = var13.f;
                  }

                  if (var13.A == 0) {
                     this.a(var15, var13, arg2, var13.v, var14, arg5, 23658, arg7);
                     if (var13.xb > var13.C) {
                        this.a(var13.xb, var15, var13, (byte)102, arg7, arg2, arg5, var13.C, var13.F + var14);
                     }
                  } else {
                     if (var13.Bb == 1 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.F + var14 && arg7 < var13.C + var15) {
                        boolean var16 = false;
                        if (var13.G != 0) {
                           var16 = this.a((Component)var13, 8);
                        }

                        if (!var16) {
                           this.uh[this.th] = var13.gb;
                           this.yd[this.th] = 352;
                           this.xd[this.th] = var13.f;
                           ++this.th;
                        }
                     }

                     if (var13.Bb == 2 && this.hh == 0 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.F + var14 && arg7 < var13.C + var15) {
                        String var17 = var13.tb;
                        if (var17.indexOf(" ") != -1) {
                           var17 = var17.substring(0, var17.indexOf(" "));
                        }

                        this.uh[this.th] = var17 + " @gre@" + var13.b;
                        this.yd[this.th] = 70;
                        this.xd[this.th] = var13.f;
                        ++this.th;
                     }

                     if (var13.Bb == 3 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.F + var14 && arg7 < var13.C + var15) {
                        this.uh[this.th] = "Close";
                        if (arg2 == 3) {
                           this.yd[this.th] = 55;
                        } else {
                           this.yd[this.th] = 639;
                        }

                        this.xd[this.th] = var13.f;
                        ++this.th;
                     }

                     if (var13.Bb == 4 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.F + var14 && arg7 < var13.C + var15) {
                        this.uh[this.th] = var13.gb;
                        this.yd[this.th] = 890;
                        this.xd[this.th] = var13.f;
                        ++this.th;
                     }

                     if (var13.Bb == 5 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.F + var14 && arg7 < var13.C + var15) {
                        this.uh[this.th] = var13.gb;
                        this.yd[this.th] = 518;
                        this.xd[this.th] = var13.f;
                        ++this.th;
                     }

                     if (var13.Bb == 6 && !this.xi && arg5 >= var14 && arg7 >= var15 && arg5 < var13.F + var14 && arg7 < var13.C + var15) {
                        this.uh[this.th] = var13.gb;
                        this.yd[this.th] = 575;
                        this.xd[this.th] = var13.f;
                        ++this.th;
                     }

                     if (var13.A == 2) {
                        int var18 = 0;

                        for(int var19 = 0; var19 < var13.C; ++var19) {
                           for(int var20 = 0; var20 < var13.F; ++var20) {
                              int var21 = (var13.bb + 32) * var20 + var14;
                              int var22 = (var13.I + 32) * var19 + var15;
                              if (var18 < 20) {
                                 var21 += var13.l[var18];
                                 var22 += var13.d[var18];
                              }

                              if (arg5 >= var21 && arg7 >= var22 && arg5 < var21 + 32 && arg7 < var22 + 32) {
                                 this.cf = var18;
                                 this.df = var13.f;
                                 if (var13.hb[var18] > 0) {
                                    ObjType var23 = ObjType.a(var13.hb[var18] - 1);
                                    if (this.Ig == 1 && var13.t) {
                                       if (this.Kg != var13.f || this.Jg != var18) {
                                          this.uh[this.th] = "Use " + this.Mg + " with @lre@" + var23.d;
                                          this.yd[this.th] = 903;
                                          this.zd[this.th] = var23.L;
                                          this.wd[this.th] = var18;
                                          this.xd[this.th] = var13.f;
                                          ++this.th;
                                       }
                                    } else if (this.hh == 1 && var13.t) {
                                       if ((this.jh & 16) == 16) {
                                          this.uh[this.th] = this.kh + " @lre@" + var23.d;
                                          this.yd[this.th] = 361;
                                          this.zd[this.th] = var23.L;
                                          this.wd[this.th] = var18;
                                          this.xd[this.th] = var13.f;
                                          ++this.th;
                                       }
                                    } else {
                                       if (var13.t) {
                                          for(int var24 = 4; var24 >= 3; --var24) {
                                             if (var23.w != null && var23.w[var24] != null) {
                                                this.uh[this.th] = var23.w[var24] + " @lre@" + var23.d;
                                                if (var24 == 3) {
                                                   this.yd[this.th] = 227;
                                                }

                                                if (var24 == 4) {
                                                   this.yd[this.th] = 891;
                                                }

                                                this.zd[this.th] = var23.L;
                                                this.wd[this.th] = var18;
                                                this.xd[this.th] = var13.f;
                                                ++this.th;
                                             } else if (var24 == 4) {
                                                this.uh[this.th] = "Drop @lre@" + var23.d;
                                                this.yd[this.th] = 891;
                                                this.zd[this.th] = var23.L;
                                                this.wd[this.th] = var18;
                                                this.xd[this.th] = var13.f;
                                                ++this.th;
                                             }
                                          }
                                       }

                                       if (var13.Ab) {
                                          this.uh[this.th] = "Use @lre@" + var23.d;
                                          this.yd[this.th] = 52;
                                          this.zd[this.th] = var23.L;
                                          this.wd[this.th] = var18;
                                          this.xd[this.th] = var13.f;
                                          ++this.th;
                                       }

                                       if (var13.t && var23.w != null) {
                                          for(int var25 = 2; var25 >= 0; --var25) {
                                             if (var23.w[var25] != null) {
                                                this.uh[this.th] = var23.w[var25] + " @lre@" + var23.d;
                                                if (var25 == 0) {
                                                   this.yd[this.th] = 961;
                                                }

                                                if (var25 == 1) {
                                                   this.yd[this.th] = 399;
                                                }

                                                if (var25 == 2) {
                                                   this.yd[this.th] = 324;
                                                }

                                                this.zd[this.th] = var23.L;
                                                this.wd[this.th] = var18;
                                                this.xd[this.th] = var13.f;
                                                ++this.th;
                                             }
                                          }
                                       }

                                       if (var13.ab != null) {
                                          for(int var26 = 4; var26 >= 0; --var26) {
                                             if (var13.ab[var26] != null) {
                                                this.uh[this.th] = var13.ab[var26] + " @lre@" + var23.d;
                                                if (var26 == 0) {
                                                   this.yd[this.th] = 9;
                                                }

                                                if (var26 == 1) {
                                                   this.yd[this.th] = 225;
                                                }

                                                if (var26 == 2) {
                                                   this.yd[this.th] = 444;
                                                }

                                                if (var26 == 3) {
                                                   this.yd[this.th] = 564;
                                                }

                                                if (var26 == 4) {
                                                   this.yd[this.th] = 894;
                                                }

                                                this.zd[this.th] = var23.L;
                                                this.wd[this.th] = var18;
                                                this.xd[this.th] = var13.f;
                                                ++this.th;
                                             }
                                          }
                                       }

                                       this.uh[this.th] = "Examine @lre@" + var23.d;
                                       this.yd[this.th] = 1094;
                                       this.zd[this.th] = var23.L;
                                       this.wd[this.th] = var18;
                                       this.xd[this.th] = var13.f;
                                       ++this.th;
                                    }
                                 }
                              }

                              ++var18;
                           }
                        }
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("client.o(I)V")
   public final void o(int arg0) {
      for(int var2 = 0; var2 < this.vg; ++var2) {
         int var3 = this.wg[var2];
         ClientNpc var4 = this.ug[var3];
         if (var4 != null) {
            this.a(var4.rb.v, (byte)-97, (ClientEntity)var4);
         }
      }

      if (arg0 != -37214) {
         this.hd.p1((int)41);
      }
   }

   @ObfuscatedName("client.a(IBLLRUWCBNN;)V")
   public final void a(int arg0, byte arg1, ClientEntity arg2) {
      if (arg2.Q < 128 || arg2.R < 128 || arg2.Q >= 13184 || arg2.R >= 13184) {
         arg2.eb = -1;
         arg2.U = -1;
         arg2.M = 0;
         arg2.N = 0;
         arg2.Q = arg2.s[0] * 128 + arg2.H * 64;
         arg2.R = arg2.t[0] * 128 + arg2.H * 64;
         arg2.a(-56);
      }

      if (dh == arg2 && (arg2.Q < 1536 || arg2.R < 1536 || arg2.Q >= 11776 || arg2.R >= 11776)) {
         arg2.eb = -1;
         arg2.U = -1;
         arg2.M = 0;
         arg2.N = 0;
         arg2.Q = arg2.s[0] * 128 + arg2.H * 64;
         arg2.R = arg2.t[0] * 128 + arg2.H * 64;
         arg2.a(-56);
      }

      if (arg2.M > fk) {
         this.a(arg2, true);
      } else if (arg2.N >= fk) {
         this.a((ClientEntity)arg2, -31135);
      } else {
         this.b((ClientEntity)arg2, 0);
      }

      this.a((byte)8, (ClientEntity)arg2);
      this.c(arg2, -136);
      if (arg1 == -97) {
         ;
      }
   }

   @ObfuscatedName("client.a(LLRUWCBNN;Z)V")
   public final void a(ClientEntity arg0, boolean arg1) {
      if (!arg1) {
         gd = !gd;
      }

      int var3 = arg0.M - fk;
      int var4 = arg0.I * 128 + arg0.H * 64;
      int var5 = arg0.K * 128 + arg0.H * 64;
      arg0.Q += (var4 - arg0.Q) / var3;
      arg0.R += (var5 - arg0.R) / var3;
      arg0.db = 0;
      if (arg0.O == 0) {
         arg0.q = 1024;
      }

      if (arg0.O == 1) {
         arg0.q = 1536;
      }

      if (arg0.O == 2) {
         arg0.q = 0;
      }

      if (arg0.O == 3) {
         arg0.q = 512;
      }
   }

   @ObfuscatedName("client.a(LLRUWCBNN;I)V")
   public final void a(ClientEntity arg0, int arg1) {
      if (fk == arg0.N || arg0.eb == -1 || arg0.hb != 0 || arg0.gb + 1 > SeqType.d[arg0.eb].a(0, arg0.fb)) {
         int var3 = arg0.N - arg0.M;
         int var4 = fk - arg0.M;
         int var5 = arg0.I * 128 + arg0.H * 64;
         int var6 = arg0.K * 128 + arg0.H * 64;
         int var7 = arg0.J * 128 + arg0.H * 64;
         int var8 = arg0.L * 128 + arg0.H * 64;
         arg0.Q = ((var3 - var4) * var5 + var4 * var7) / var3;
         arg0.R = ((var3 - var4) * var6 + var4 * var8) / var3;
      }

      arg0.db = 0;
      if (arg0.O == 0) {
         arg0.q = 1024;
      }

      if (arg0.O == 1) {
         arg0.q = 1536;
      }

      if (arg0.O == 2) {
         arg0.q = 0;
      }

      if (arg0.O == 3) {
         arg0.q = 512;
      }

      arg0.S = arg0.q;
      if (arg1 == -31135) {
         ;
      }
   }

   @ObfuscatedName("client.b(LLRUWCBNN;I)V")
   public final void b(ClientEntity arg0, int arg1) {
      arg0.u = arg0.ob;
      if (arg0.nb == 0) {
         arg0.db = 0;
      } else {
         if (arg0.eb != -1 && arg0.hb == 0) {
            SeqType var3 = SeqType.d[arg0.eb];
            if (arg0.T > 0 && var3.p == 0) {
               ++arg0.db;
               return;
            }

            if (arg0.T <= 0 && var3.q == 0) {
               ++arg0.db;
               return;
            }
         }

         int var4 = arg0.Q;
         int var5 = arg0.R;
         int var6 = arg0.s[arg0.nb - 1] * 128 + arg0.H * 64;
         int var7 = arg0.t[arg0.nb - 1] * 128 + arg0.H * 64;
         if (var6 - var4 <= 256 && var6 - var4 >= -256 && var7 - var5 <= 256 && var7 - var5 >= -256) {
            if (var4 < var6) {
               if (var5 < var7) {
                  arg0.q = 1280;
               } else if (var5 > var7) {
                  arg0.q = 1792;
               } else {
                  arg0.q = 1536;
               }
            } else if (var4 > var6) {
               if (var5 < var7) {
                  arg0.q = 768;
               } else if (var5 > var7) {
                  arg0.q = 256;
               } else {
                  arg0.q = 512;
               }
            } else if (var5 < var7) {
               arg0.q = 1024;
            } else {
               arg0.q = 0;
            }

            int var8 = arg0.q - arg0.S & 2047;
            if (var8 > 1024) {
               var8 -= 2048;
            }

            int var9 = arg0.ab;
            if (arg1 != 0) {
               this.hd.p1((int)34);
            }

            if (var8 >= -256 && var8 <= 256) {
               var9 = arg0.Z;
            } else if (var8 >= 256 && var8 < 768) {
               var9 = arg0.cb;
            } else if (var8 >= -768 && var8 <= -256) {
               var9 = arg0.bb;
            }

            if (var9 == -1) {
               var9 = arg0.Z;
            }

            arg0.u = var9;
            int var10 = 4;
            if (arg0.q != arg0.S && arg0.P == -1 && arg0.G != 0) {
               var10 = 2;
            }

            if (arg0.nb > 2) {
               var10 = 6;
            }

            if (arg0.nb > 3) {
               var10 = 8;
            }

            if (arg0.db > 0 && arg0.nb > 1) {
               var10 = 8;
               --arg0.db;
            }

            if (arg0.x[arg0.nb - 1]) {
               var10 <<= 1;
            }

            if (var10 >= 8 && arg0.u == arg0.Z && arg0.jb != -1) {
               arg0.u = arg0.jb;
            }

            if (var4 < var6) {
               arg0.Q += var10;
               if (arg0.Q > var6) {
                  arg0.Q = var6;
               }
            } else if (var4 > var6) {
               arg0.Q -= var10;
               if (arg0.Q < var6) {
                  arg0.Q = var6;
               }
            }

            if (var5 < var7) {
               arg0.R += var10;
               if (arg0.R > var7) {
                  arg0.R = var7;
               }
            } else if (var5 > var7) {
               arg0.R -= var10;
               if (arg0.R < var7) {
                  arg0.R = var7;
               }
            }

            if (arg0.Q == var6 && arg0.R == var7) {
               --arg0.nb;
               if (arg0.T > 0) {
                  --arg0.T;
                  return;
               }
            }

         } else {
            arg0.Q = var6;
            arg0.R = var7;
         }
      }
   }

   @ObfuscatedName("client.a(BLLRUWCBNN;)V")
   public final void a(byte arg0, ClientEntity arg1) {
      if (arg0 != 8) {
         this.xc = this.Ub.nextInt();
      }

      if (arg1.G != 0) {
         if (arg1.P != -1 && arg1.P < 32768) {
            ClientNpc var3 = this.ug[arg1.P];
            if (var3 != null) {
               int var4 = arg1.Q - var3.Q;
               int var5 = arg1.R - var3.R;
               if (var4 != 0 || var5 != 0) {
                  arg1.q = (int)(Math.atan2((double)var4, (double)var5) * 325.949D) & 2047;
               }
            }
         }

         if (arg1.P >= 32768) {
            int var6 = arg1.P - 32768;
            if (this.ed == var6) {
               var6 = this.md;
            }

            ClientPlayer var7 = this.nd[var6];
            if (var7 != null) {
               int var8 = arg1.Q - var7.Q;
               int var9 = arg1.R - var7.R;
               if (var8 != 0 || var9 != 0) {
                  arg1.q = (int)(Math.atan2((double)var8, (double)var9) * 325.949D) & 2047;
               }
            }
         }

         if ((arg1.E != 0 || arg1.F != 0) && (arg1.nb == 0 || arg1.db > 0)) {
            int var10 = arg1.Q - (arg1.E - this.Fe - this.Fe) * 64;
            int var11 = arg1.R - (arg1.F - this.Ge - this.Ge) * 64;
            if (var10 != 0 || var11 != 0) {
               arg1.q = (int)(Math.atan2((double)var10, (double)var11) * 325.949D) & 2047;
            }

            arg1.E = 0;
            arg1.F = 0;
         }

         int var12 = arg1.q - arg1.S & 2047;
         if (var12 != 0) {
            if (var12 >= arg1.G && var12 <= 2048 - arg1.G) {
               if (var12 > 1024) {
                  arg1.S -= arg1.G;
               } else {
                  arg1.S += arg1.G;
               }
            } else {
               arg1.S = arg1.q;
            }

            arg1.S &= 2047;
            if (arg1.u == arg1.ob && arg1.q != arg1.S) {
               if (arg1.pb != -1) {
                  arg1.u = arg1.pb;
                  return;
               }

               arg1.u = arg1.Z;
               return;
            }
         }

      }
   }

   @ObfuscatedName("client.c(LLRUWCBNN;I)V")
   public final void c(ClientEntity arg0, int arg1) {
      while(arg1 >= 0) {
         this.ik = this.Ub.nextInt();
      }

      arg0.y = false;
      if (arg0.u != -1) {
         SeqType var3 = SeqType.d[arg0.u];
         ++arg0.w;
         if (arg0.v < var3.e && arg0.w > var3.a(0, arg0.v)) {
            arg0.w = 1;
            ++arg0.v;
         }

         if (arg0.v >= var3.e) {
            arg0.w = 1;
            arg0.v = 0;
         }
      }

      if (arg0.U != -1 && fk >= arg0.X) {
         if (arg0.V < 0) {
            arg0.V = 0;
         }

         SeqType var4 = SpotAnimType.e[arg0.U].i;
         ++arg0.W;
         if (arg0.V < var4.e && arg0.W > var4.a(0, arg0.V)) {
            arg0.W = 1;
            ++arg0.V;
         }

         if (arg0.V >= var4.e && (arg0.V < 0 || arg0.V >= var4.e)) {
            arg0.U = -1;
         }
      }

      if (arg0.eb != -1 && arg0.hb <= 1) {
         SeqType var5 = SeqType.d[arg0.eb];
         if (var5.p == 1 && arg0.T > 0 && arg0.M <= fk && arg0.N < fk) {
            arg0.hb = 1;
            return;
         }
      }

      if (arg0.eb != -1 && arg0.hb == 0) {
         SeqType var6 = SeqType.d[arg0.eb];
         ++arg0.gb;
         if (arg0.fb < var6.e && arg0.gb > var6.a(0, arg0.fb)) {
            arg0.gb = 1;
            ++arg0.fb;
         }

         if (arg0.fb >= var6.e) {
            arg0.fb -= var6.i;
            ++arg0.ib;
            if (arg0.ib >= var6.o) {
               arg0.eb = -1;
            }

            if (arg0.fb < 0 || arg0.fb >= var6.e) {
               arg0.eb = -1;
            }
         }

         arg0.y = var6.k;
      }

      if (arg0.hb > 0) {
         --arg0.hb;
      }
   }

   @ObfuscatedName("client.p(I)V")
   public final void p(int arg0) {
      if (this.Se == -1 || this.lf != 2 && super.o == null) {
         if (this.Le) {
            this.F(-906);
            this.Le = false;
            this.bc.a(4, 0, super.n, this.of);
            this.cc.a(357, 0, super.n, this.of);
            this.dc.a(4, 722, super.n, this.of);
            this.ec.a(205, 743, super.n, this.of);
            this.fc.a(0, 0, super.n, this.of);
            this.gc.a(4, 516, super.n, this.of);
            this.hc.a(205, 516, super.n, this.of);
            this.ic.a(357, 496, super.n, this.of);
            this.jc.a(338, 0, super.n, this.of);
            this.rh = true;
            this.yi = true;
            this.Tc = true;
            this.Wh = true;
            if (this.lf != 2) {
               this.Ug.a(4, 4, super.n, this.of);
               this.Tg.a(4, 550, super.n, this.of);
            }

            ++vi;
            if (vi > 85) {
               vi = 0;
               this.hd.pIsaac(168);
            }
         }

         if (this.lf == 2) {
            this.L(2);
         }

         if (this.ef && this.Kj == 1) {
            this.rh = true;
         }

         if (this.Df != -1) {
            boolean var4 = this.a(this.Uc, this.Df, (byte)5);
            if (var4) {
               this.rh = true;
            }
         }

         if (this.mk == 2) {
            this.rh = true;
         }

         if (this.bg == 2) {
            this.rh = true;
         }

         if (this.rh) {
            this.k((byte)7);
            this.rh = false;
         }

         if (this.Fd == -1 && this.Ci == 0) {
            this.Hi.v = this.Vf - this.Y - 77;
            if (super.v > 448 && super.v < 560 && super.w > 332) {
               this.a(this.Vf, 0, this.Hi, (byte)102, super.w - 357, -1, super.v - 17, 77, 463);
            }

            int var5 = this.Vf - 77 - this.Hi.v;
            if (var5 < 0) {
               var5 = 0;
            }

            if (var5 > this.Vf - 77) {
               var5 = this.Vf - 77;
            }

            if (this.Y != var5) {
               this.Y = var5;
               this.yi = true;
            }
         }

         if (this.Fd == -1 && this.Ci == 3) {
            int var6 = this.jb * 14 + 7;
            this.Hi.v = this.mb;
            if (super.v > 448 && super.v < 560 && super.w > 332) {
               this.a(var6, 0, this.Hi, (byte)102, super.w - 357, -1, super.v - 17, 77, 463);
            }

            int var7 = this.Hi.v;
            if (var7 < 0) {
               var7 = 0;
            }

            if (var7 > var6 - 77) {
               var7 = var6 - 77;
            }

            if (this.mb != var7) {
               this.mb = var7;
               this.yi = true;
            }
         }

         if (this.Fd != -1) {
            boolean var8 = this.a(this.Uc, this.Fd, (byte)5);
            if (var8) {
               this.yi = true;
            }
         }

         if (this.mk == 3) {
            this.yi = true;
         }

         if (this.bg == 3) {
            this.yi = true;
         }

         if (this.Xe != null) {
            this.yi = true;
         }

         if (this.ef && this.Kj == 2) {
            this.yi = true;
         }

         if (this.yi) {
            this.t(0);
            this.yi = false;
         }

         if (this.lf == 2) {
            this.v(503);
            this.Tg.a(4, 550, super.n, this.of);
         }

         if (this.Xh != -1) {
            this.Tc = true;
         }

         if (this.Tc) {
            if (this.Xh != -1 && this.rj == this.Xh) {
               this.Xh = -1;
               this.hd.pIsaac(119);
               this.hd.p1(this.rj);
            }

            this.Tc = false;
            this.Yf.a(false);
            this.kd.a(0, 0, -488);
            if (this.Df == -1) {
               if (this.vf[this.rj] != -1) {
                  if (this.rj == 0) {
                     this.Bb.a(10, 22, -488);
                  }

                  if (this.rj == 1) {
                     this.Cb.a(8, 54, -488);
                  }

                  if (this.rj == 2) {
                     this.Cb.a(8, 82, -488);
                  }

                  if (this.rj == 3) {
                     this.Db.a(8, 110, -488);
                  }

                  if (this.rj == 4) {
                     this.Fb.a(8, 153, -488);
                  }

                  if (this.rj == 5) {
                     this.Fb.a(8, 181, -488);
                  }

                  if (this.rj == 6) {
                     this.Eb.a(9, 209, -488);
                  }
               }

               if (this.vf[0] != -1 && (this.Xh != 0 || fk % 20 < 10)) {
                  this.td[0].a(13, 29, -488);
               }

               if (this.vf[1] != -1 && (this.Xh != 1 || fk % 20 < 10)) {
                  this.td[1].a(11, 53, -488);
               }

               if (this.vf[2] != -1 && (this.Xh != 2 || fk % 20 < 10)) {
                  this.td[2].a(11, 82, -488);
               }

               if (this.vf[3] != -1 && (this.Xh != 3 || fk % 20 < 10)) {
                  this.td[3].a(12, 115, -488);
               }

               if (this.vf[4] != -1 && (this.Xh != 4 || fk % 20 < 10)) {
                  this.td[4].a(13, 153, -488);
               }

               if (this.vf[5] != -1 && (this.Xh != 5 || fk % 20 < 10)) {
                  this.td[5].a(11, 180, -488);
               }

               if (this.vf[6] != -1 && (this.Xh != 6 || fk % 20 < 10)) {
                  this.td[6].a(13, 208, -488);
               }
            }

            this.Yf.a(160, 516, super.n, this.of);
            this.Xf.a(false);
            this.jd.a(0, 0, -488);
            if (this.Df == -1) {
               if (this.vf[this.rj] != -1) {
                  if (this.rj == 7) {
                     this.Ad.a(0, 42, -488);
                  }

                  if (this.rj == 8) {
                     this.Bd.a(0, 74, -488);
                  }

                  if (this.rj == 9) {
                     this.Bd.a(0, 102, -488);
                  }

                  if (this.rj == 10) {
                     this.Cd.a(1, 130, -488);
                  }

                  if (this.rj == 11) {
                     this.Ed.a(0, 173, -488);
                  }

                  if (this.rj == 12) {
                     this.Ed.a(0, 201, -488);
                  }

                  if (this.rj == 13) {
                     this.Dd.a(0, 229, -488);
                  }
               }

               if (this.vf[8] != -1 && (this.Xh != 8 || fk % 20 < 10)) {
                  this.td[7].a(2, 74, -488);
               }

               if (this.vf[9] != -1 && (this.Xh != 9 || fk % 20 < 10)) {
                  this.td[8].a(3, 102, -488);
               }

               if (this.vf[10] != -1 && (this.Xh != 10 || fk % 20 < 10)) {
                  this.td[9].a(4, 137, -488);
               }

               if (this.vf[11] != -1 && (this.Xh != 11 || fk % 20 < 10)) {
                  this.td[10].a(2, 174, -488);
               }

               if (this.vf[12] != -1 && (this.Xh != 12 || fk % 20 < 10)) {
                  this.td[11].a(2, 201, -488);
               }

               if (this.vf[13] != -1 && (this.Xh != 13 || fk % 20 < 10)) {
                  this.td[12].a(2, 226, -488);
               }
            }

            this.Xf.a(466, 496, super.n, this.of);
            this.Ug.a(false);
            Pix3D.K = this.Td;
         }

         if (this.Wh) {
            this.Wh = false;
            this.Wf.a(false);
            this.id.a(0, 0, -488);
            this.Ze.a(true, this.Ve, 16777215, 28, 55, "Public chat");
            if (this.Xd == 0) {
               this.Ze.a(true, this.Ve, 65280, 41, 55, "On");
            }

            if (this.Xd == 1) {
               this.Ze.a(true, this.Ve, 16776960, 41, 55, "Friends");
            }

            if (this.Xd == 2) {
               this.Ze.a(true, this.Ve, 16711680, 41, 55, "Off");
            }

            if (this.Xd == 3) {
               this.Ze.a(true, this.Ve, 65535, 41, 55, "Hide");
            }

            this.Ze.a(true, this.Ve, 16777215, 28, 184, "Private chat");
            if (this.Ib == 0) {
               this.Ze.a(true, this.Ve, 65280, 41, 184, "On");
            }

            if (this.Ib == 1) {
               this.Ze.a(true, this.Ve, 16776960, 41, 184, "Friends");
            }

            if (this.Ib == 2) {
               this.Ze.a(true, this.Ve, 16711680, 41, 184, "Off");
            }

            this.Ze.a(true, this.Ve, 16777215, 28, 324, "Trade/compete");
            if (this.li == 0) {
               this.Ze.a(true, this.Ve, 65280, 41, 324, "On");
            }

            if (this.li == 1) {
               this.Ze.a(true, this.Ve, 16776960, 41, 324, "Friends");
            }

            if (this.li == 2) {
               this.Ze.a(true, this.Ve, 16711680, 41, 324, "Off");
            }

            this.Ze.a(true, this.Ve, 16777215, 33, 458, "Report abuse");
            this.Wf.a(453, 0, super.n, this.of);
            this.Ug.a(false);
            Pix3D.K = this.Td;
         }

         this.Uc = 0;
         if (arg0 != 7) {
            for(int var9 = 1; var9 > 0; ++var9) {
            }

         }
      } else {
         if (this.lf == 2) {
            this.a(this.Uc, this.Se, (byte)5);
            if (this.dd != -1) {
               this.a(this.Uc, this.dd, (byte)5);
            }

            this.Uc = 0;
            this.J(this.Cg);
            super.o.a(false);
            Pix3D.K = this.Ud;
            Pix2D.a((int)4);
            this.Le = true;
            Component var2 = Component.a(this.Se);
            if (var2.F == 512 && var2.C == 334 && var2.A == 0) {
               var2.F = 765;
               var2.C = 503;
            }

            this.a(0, 0, var2, 0, 8);
            if (this.dd != -1) {
               Component var3 = Component.a(this.dd);
               if (var3.F == 512 && var3.C == 334 && var3.A == 0) {
                  var3.F = 765;
                  var3.C = 503;
               }

               this.a(0, 0, var3, 0, 8);
            }

            if (!this.ef) {
               this.w(-521);
               this.g((byte)-79);
            } else {
               this.p(false);
            }
         }

         super.o.a(0, 0, super.n, this.of);
      }
   }

   @ObfuscatedName("client.q(I)V")
   public final void q(int arg0) {
      this.qb += arg0;
      if (this.hi != 0) {
         PixFont var2 = this.Ze;
         int var3 = 0;
         if (this.We != 0) {
            var3 = 1;
         }

         for(int var4 = 0; var4 < 100; ++var4) {
            if (this.Ej[var4] != null) {
               int var5 = this.Cj[var4];
               String var6 = this.Dj[var4];
               byte var7 = 0;
               if (var6 != null && var6.startsWith("@cr1@")) {
                  var6 = var6.substring(5);
                  var7 = 1;
               }

               if (var6 != null && var6.startsWith("@cr2@")) {
                  var6 = var6.substring(5);
                  var7 = 2;
               }

               if ((var5 == 3 || var5 == 7) && (var5 == 7 || this.Ib == 0 || this.Ib == 1 && this.a((int)13292, (String)var6))) {
                  int var8 = 329 - var3 * 13;
                  byte var9 = 4;
                  var2.b(2245, var9, 0, var8, "From");
                  var2.b(2245, var9, 65535, var8 - 1, "From");
                  int var10 = var9 + var2.a((byte)35, "From ");
                  if (var7 == 1) {
                     this.Eg[0].a(var8 - 12, var10, -488);
                     var10 += 14;
                  }

                  if (var7 == 2) {
                     this.Eg[1].a(var8 - 12, var10, -488);
                     var10 += 14;
                  }

                  var2.b(2245, var10, 0, var8, var6 + ": " + this.Ej[var4]);
                  var2.b(2245, var10, 65535, var8 - 1, var6 + ": " + this.Ej[var4]);
                  ++var3;
                  if (var3 >= 5) {
                     return;
                  }
               }

               if (var5 == 5 && this.Ib < 2) {
                  int var11 = 329 - var3 * 13;
                  var2.b(2245, 4, 0, var11, this.Ej[var4]);
                  var2.b(2245, 4, 65535, var11 - 1, this.Ej[var4]);
                  ++var3;
                  if (var3 >= 5) {
                     return;
                  }
               }

               if (var5 == 6 && this.Ib < 2) {
                  int var12 = 329 - var3 * 13;
                  var2.b(2245, 4, 0, var12, "To " + var6 + ": " + this.Ej[var4]);
                  var2.b(2245, 4, 65535, var12 - 1, "To " + var6 + ": " + this.Ej[var4]);
                  ++var3;
                  if (var3 >= 5) {
                     return;
                  }
               }
            }
         }

      }
   }

   public final void init() {
      sc = Integer.parseInt(this.getParameter("nodeid"));
      tc = Integer.parseInt(this.getParameter("portoff"));
      String var1 = this.getParameter("lowmem");
      if (var1 != null && var1.equals("1")) {
         l(true);
      } else {
         d(true);
      }

      String var2 = this.getParameter("free");
      if (var2 != null && var2.equals("1")) {
         uc = false;
      } else {
         uc = true;
      }

      this.b(765, 503, 2);
   }

   @ObfuscatedName("client.r(I)V")
   public final void r(int arg0) {
      while(arg0 >= 0) {
         this.dk = null;
      }

      for(MapSpotAnim var2 = (MapSpotAnim)this.Uh.b(); var2 != null; var2 = (MapSpotAnim)this.Uh.a(1)) {
         if (this.Ff == var2.m && !var2.r) {
            if (fk >= var2.v) {
               var2.a((byte)1, this.Uc);
               if (var2.r) {
                  var2.a();
               } else {
                  this.ah.a(-1, var2, var2.n, var2.p, false, 0, var2.m, 60, var2.o, 0);
               }
            }
         } else {
            var2.a();
         }
      }

   }

   @ObfuscatedName("client.j(Z)V")
   public final void j(boolean arg0) {
      if (arg0) {
         this.rb = -1;
      }

      while(true) {
         OnDemandRequest var2 = this.xj.a();
         if (var2 == null) {
            return;
         }

         if (var2.h == 0) {
            Model.a(var2.k, var2.i, (byte)7);
            if ((this.xj.a(var2.i, -493) & 98) != 0) {
               this.rh = true;
               if (this.Fd != -1 || this.Bh != -1) {
                  this.yi = true;
               }
            }
         }

         if (var2.h == 1 && var2.k != null) {
            AnimFrame.a(var2.k, true);
         }

         if (var2.h == 2 && this.cj == var2.i && var2.k != null) {
            this.a(this.dj, var2.k, 659);
         }

         if (var2.h == 3 && this.lf == 1) {
            for(int var3 = 0; var3 < this.L.length; ++var3) {
               if (this.eb[var3] == var2.i) {
                  this.L[var3] = var2.k;
                  if (var2.k == null) {
                     this.eb[var3] = -1;
                  }
                  break;
               }

               if (this.fb[var3] == var2.i) {
                  this.qi[var3] = var2.k;
                  if (var2.k == null) {
                     this.fb[var3] = -1;
                  }
                  break;
               }
            }
         }

         if (var2.h == 93 && this.xj.b(var2.i, false)) {
            World.a(this.xj, new Packet(var2.k), (byte)-3);
         }
      }
   }

   @ObfuscatedName("client.s(I)Z")
   public final boolean s(int arg0) {
      if (arg0 <= 0) {
         for(int var2 = 1; var2 > 0; ++var2) {
         }
      }

      return sign.Signlink.wavereplay();
   }

   @ObfuscatedName("client.a(Ljava/lang/String;Ljava/lang/String;Z)V")
   public final void a(String arg0, String arg1, boolean arg2) {
      sign.Signlink.errorname = arg0;

      try {
         if (!arg2) {
            this.ad = "";
            this.bd = "Connecting to server...";
            this.a((byte)-50, true);
         }

         this.pe = new ClientStream((byte)2, this.g(tc + 43594), this);
         long var4 = JString.a(arg0);
         int var6 = (int)(var4 >> 16 & 31L);
         this.hd.pos = 0;
         this.hd.p1((int)14);
         this.hd.p1(var6);
         this.pe.a(0, 2, 0, this.hd.data);

         for(int var7 = 0; var7 < 8; ++var7) {
            this.pe.b();
         }

         int var8 = this.pe.b();
         int var9 = var8;
         if (var8 == 0) {
            this.pe.a(this.yh.data, 0, 8);
            this.yh.pos = 0;
            this.zc = this.yh.g8();
            int[] var10 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(this.zc >> 32), (int)this.zc};
            this.hd.pos = 0;
            this.hd.p1((int)10);
            this.hd.p4(var10[0]);
            this.hd.p4(var10[1]);
            this.hd.p4(var10[2]);
            this.hd.p4(var10[3]);
            this.hd.p4(sign.Signlink.uid);
            this.hd.pjstr(arg0);
            this.hd.pjstr(arg1);
            this.hd.rsaenc(Wj, N);
            this.yc.pos = 0;
            if (arg2) {
               this.yc.p1((int)18);
            } else {
               this.yc.p1((int)16);
            }

            this.yc.p1(this.hd.pos + 36 + 1 + 1 + 2);
            this.yc.p1((int)255);
            this.yc.p2((int)377);
            this.yc.p1(vc ? 1 : 0);

            for(int var11 = 0; var11 < 9; ++var11) {
               this.yc.p4(this.K[var11]);
            }

            this.yc.pdata(this.hd.data, 0, this.hd.pos, 0);
            this.hd.random = new Isaac(this.lh, var10);

            for(int var12 = 0; var12 < 4; ++var12) {
               var10[var12] += 50;
            }

            this.Ub = new Isaac(this.lh, var10);
            this.pe.a(0, this.yc.pos, 0, this.yc.data);
            var8 = this.pe.b();
         }

         if (var8 == 1) {
            try {
               Thread.sleep(2000L);
            } catch (Exception var22) {
            }

            this.a(arg0, arg1, arg2);
         } else if (var8 == 2) {
            this.ob = this.pe.b();
            fd = this.pe.b() == 1;
            this.Xb = 0L;
            this.Fj = 0;
            this.Gi.f = 0;
            super.s = true;
            this.hj = true;
            this.zg = true;
            this.hd.pos = 0;
            this.yh.pos = 0;
            this.rb = -1;
            this.Yb = -1;
            this.Zb = -1;
            this.ac = -1;
            this.qb = 0;
            this.sb = 0;
            this.We = 0;
            this.ub = 0;
            this.Hh = 0;
            this.th = 0;
            this.ef = false;
            super.t = 0;

            for(int var13 = 0; var13 < 100; ++var13) {
               this.Ej[var13] = null;
            }

            this.Ig = 0;
            this.hh = 0;
            this.lf = 0;
            this.Ae = 0;
            this.ab = (int)(Math.random() * 100.0D) - 50;
            this.ae = (int)(Math.random() * 110.0D) - 55;
            this.Ni = (int)(Math.random() * 80.0D) - 40;
            this.lc = (int)(Math.random() * 120.0D) - 60;
            this.ri = (int)(Math.random() * 30.0D) - 20;
            this.Ki = (int)(Math.random() * 20.0D) - 10 & 2047;
            this.Pe = 0;
            this.ij = -1;
            this.ig = 0;
            this.jg = 0;
            this.od = 0;
            this.vg = 0;

            for(int var14 = 0; var14 < this.ld; ++var14) {
               this.nd[var14] = null;
               this.sd[var14] = null;
            }

            for(int var15 = 0; var15 < 16384; ++var15) {
               this.ug[var15] = null;
            }

            dh = this.nd[this.md] = new ClientPlayer();
            this.oj.c();
            this.Uh.c();

            for(int var16 = 0; var16 < 4; ++var16) {
               for(int var17 = 0; var17 < 104; ++var17) {
                  for(int var18 = 0; var18 < 104; ++var18) {
                     this.dk[var16][var17][var18] = null;
                  }
               }
            }

            this.Ti = new LinkList();
            this.hb = 0;
            this.gb = 0;
            this.a(Ah, this.Bh);
            this.Bh = -1;
            this.a(Ah, this.Fd);
            this.Fd = -1;
            this.a(Ah, this.fh);
            this.fh = -1;
            this.a(Ah, this.Se);
            this.Se = -1;
            this.a(Ah, this.dd);
            this.dd = -1;
            this.a(Ah, this.Df);
            this.Df = -1;
            this.a(Ah, this.lj);
            this.lj = -1;
            this.xi = false;
            this.rj = 3;
            this.Ci = 0;
            this.ef = false;
            this.nb = false;
            this.Xe = null;
            this.Zj = 0;
            this.Xh = -1;
            this.Gg = true;
            this.f(this.ge);

            for(int var19 = 0; var19 < 5; ++var19) {
               this.Nf[var19] = 0;
            }

            for(int var20 = 0; var20 < 5; ++var20) {
               this.jf[var20] = null;
               this.kf[var20] = false;
            }

            Of = 0;
            bh = 0;
            ti = 0;
            Re = 0;
            Bg = 0;
            O = 0;
            oi = 0;
            ee = 0;
            Oe = 0;
            Yg = 0;
            this.F(-906);
         } else if (var8 == 3) {
            this.ad = "";
            this.bd = "Invalid username or password.";
         } else if (var8 == 4) {
            this.ad = "Your account has been disabled.";
            this.bd = "Please check your message-centre for details.";
         } else if (var8 == 5) {
            this.ad = "Your account is already logged in.";
            this.bd = "Try again in 60 secs...";
         } else if (var8 == 6) {
            this.ad = "RuneScape has been updated!";
            this.bd = "Please reload this page.";
         } else if (var8 == 7) {
            this.ad = "This world is full.";
            this.bd = "Please use a different world.";
         } else if (var8 == 8) {
            this.ad = "Unable to connect.";
            this.bd = "Login server offline.";
         } else if (var8 == 9) {
            this.ad = "Login limit exceeded.";
            this.bd = "Too many connections from your address.";
         } else if (var8 == 10) {
            this.ad = "Unable to connect.";
            this.bd = "Bad session id.";
         } else if (var8 == 12) {
            this.ad = "You need a members account to login to this world.";
            this.bd = "Please subscribe, or use a different world.";
         } else if (var8 == 13) {
            this.ad = "Could not complete login.";
            this.bd = "Please try using a different world.";
         } else if (var8 == 14) {
            this.ad = "The server is being updated.";
            this.bd = "Please wait 1 minute and try again.";
         } else if (var8 == 15) {
            this.zg = true;
            this.hd.pos = 0;
            this.yh.pos = 0;
            this.rb = -1;
            this.Yb = -1;
            this.Zb = -1;
            this.ac = -1;
            this.qb = 0;
            this.sb = 0;
            this.We = 0;
            this.th = 0;
            this.ef = false;
            this.ni = System.currentTimeMillis();
         } else if (var8 == 16) {
            this.ad = "Login attempts exceeded.";
            this.bd = "Please wait 1 minute and try again.";
         } else if (var8 == 17) {
            this.ad = "You are standing in a members-only area.";
            this.bd = "To play on this world move to a free area first";
         } else if (var8 == 18) {
            this.ad = "Account locked as we suspect it has been stolen.";
            this.bd = "Press 'recover a locked account' on front page.";
         } else if (var8 == 20) {
            this.ad = "Invalid loginserver requested";
            this.bd = "Please try using a different world.";
         } else if (var8 != 21) {
            if (var8 == 22) {
               this.ad = "Malformed login packet.";
               this.bd = "Please try again.";
            } else if (var8 == 23) {
               this.ad = "No reply from loginserver.";
               this.bd = "Please try again.";
            } else if (var8 == 24) {
               this.ad = "Error loading your profile.";
               this.bd = "Please contact customer support.";
            } else if (var8 == 25) {
               this.ad = "Unexpected loginserver response.";
               this.bd = "Please try using a different world.";
            } else if (var8 == 26) {
               this.ad = "This computers address has been blocked";
               this.bd = "as it was used to break our rules";
            } else if (var8 == -1) {
               if (var9 == 0) {
                  if (this.X < 2) {
                     try {
                        Thread.sleep(2000L);
                     } catch (Exception var24) {
                     }

                     ++this.X;
                     this.a(arg0, arg1, arg2);
                  } else {
                     this.ad = "No response from loginserver";
                     this.bd = "Please wait 1 minute and try again.";
                  }
               } else {
                  this.ad = "No response from server";
                  this.bd = "Please try using a different world.";
               }
            } else {
               System.out.println("response:" + var8);
               this.ad = "Unexpected server response";
               this.bd = "Please try using a different world.";
            }
         } else {
            int var21 = this.pe.b();

            for(int var26 = var21 + 3; var26 >= 0; --var26) {
               this.ad = "You have only just left another world";
               this.bd = "Your profile will be transferred in: " + var26;
               this.a((byte)-50, true);

               try {
                  Thread.sleep(1200L);
               } catch (Exception var23) {
               }
            }

            this.a(arg0, arg1, arg2);
         }
      } catch (IOException var25) {
         this.ad = "";
         this.bd = "Error connecting to server.";
      }
   }

   @ObfuscatedName("client.a(IIII)Z")
   public final boolean a(int arg0, int arg1, int arg2, int arg3) {
      int var5 = arg3 >> 14 & 32767;
      int var6 = this.ah.e(this.Ff, arg2, arg0, arg3);
      if (var6 == -1) {
         return false;
      } else {
         int var7 = var6 & 31;
         int var8 = var6 >> 6 & 3;
         if (var7 != 10 && var7 != 11 && var7 != 22) {
            this.a(true, false, arg0, dh.t[0], 0, 0, 2, var7 + 1, arg2, 0, var8, dh.s[0]);
         } else {
            LocType var9 = LocType.a(var5);
            int var10;
            int var11;
            if (var8 != 0 && var8 != 2) {
               var10 = var9.r;
               var11 = var9.R;
            } else {
               var10 = var9.R;
               var11 = var9.r;
            }

            int var12 = var9.g;
            if (var8 != 0) {
               var12 = (var12 >> 4 - var8) + (var12 << var8 & 15);
            }

            this.a(true, false, arg0, dh.t[0], var10, var11, 2, 0, arg2, var12, 0, dh.s[0]);
         }

         this.le = super.C;
         this.me = super.D;
         this.oe = 2;
         this.ne = 0;
         this.qb += arg1;
         return true;
      }
   }

   @ObfuscatedName("client.i(B)V")
   public final void i(byte arg0) {
      short var2 = 256;

      for(int var3 = 10; var3 < 117; ++var3) {
         int var4 = (int)(Math.random() * 100.0D);
         if (var4 < 50) {
            this.yf[(var2 - 2 << 7) + var3] = 255;
         }
      }

      for(int var5 = 0; var5 < 100; ++var5) {
         int var6 = (int)(Math.random() * 124.0D) + 2;
         int var7 = (int)(Math.random() * 128.0D) + 128;
         int var8 = (var7 << 7) + var6;
         this.yf[var8] = 192;
      }

      for(int var9 = 1; var9 < var2 - 1; ++var9) {
         for(int var10 = 1; var10 < 127; ++var10) {
            int var11 = (var9 << 7) + var10;
            this.zf[var11] = (this.yf[var11 - 1] + this.yf[var11 + 1] + this.yf[var11 - 128] + this.yf[var11 + 128]) / 4;
         }
      }

      this.wi += 128;
      if (this.wi > this.mh.length) {
         this.wi -= this.mh.length;
         int var12 = (int)(Math.random() * 12.0D);
         this.a((Pix8)this.fg[var12], 0);
      }

      for(int var13 = 1; var13 < var2 - 1; ++var13) {
         for(int var14 = 1; var14 < 127; ++var14) {
            int var15 = (var13 << 7) + var14;
            int var16 = this.zf[var15 + 128] - this.mh[this.wi + var15 & this.mh.length - 1] / 5;
            if (var16 < 0) {
               var16 = 0;
            }

            this.yf[var15] = var16;
         }
      }

      if (arg0 == 1) {
         boolean var17 = false;
      } else {
         for(int var18 = 1; var18 > 0; ++var18) {
         }
      }

      for(int var19 = 0; var19 < var2 - 1; ++var19) {
         this.ch[var19] = this.ch[var19 + 1];
      }

      this.ch[var2 - 1] = (int)(Math.sin((double)fk / 14.0D) * 16.0D + Math.sin((double)fk / 15.0D) * 14.0D + Math.sin((double)fk / 16.0D) * 12.0D);
      if (this.Me > 0) {
         this.Me -= 4;
      }

      if (this.Ne > 0) {
         this.Ne -= 4;
      }

      if (this.Me == 0 && this.Ne == 0) {
         int var20 = (int)(Math.random() * 2000.0D);
         if (var20 == 0) {
            this.Me = 1024;
         }

         if (var20 == 1) {
            this.Ne = 1024;
            return;
         }
      }

   }

   @ObfuscatedName("client.a(LSLDUQHOR;IIIB)V")
   public final void a(NpcType arg0, int arg1, int arg2, int arg3, byte arg4) {
      if (arg4 != -76) {
         this.dk = null;
      }

      if (this.th < 400) {
         if (arg0.b != null) {
            arg0 = arg0.b(false);
         }

         if (arg0 != null) {
            if (arg0.k) {
               String var6 = arg0.F;
               if (arg0.s != 0) {
                  var6 = var6 + c(arg0.s, dh.Ab, 736) + " (level-" + arg0.s + ")";
               }

               if (this.Ig == 1) {
                  this.uh[this.th] = "Use " + this.Mg + " with @yel@" + var6;
                  this.yd[this.th] = 347;
                  this.zd[this.th] = arg3;
                  this.wd[this.th] = arg2;
                  this.xd[this.th] = arg1;
                  ++this.th;
               } else {
                  if (this.hh == 1) {
                     if ((this.jh & 2) == 2) {
                        this.uh[this.th] = this.kh + " @yel@" + var6;
                        this.yd[this.th] = 67;
                        this.zd[this.th] = arg3;
                        this.wd[this.th] = arg2;
                        this.xd[this.th] = arg1;
                        ++this.th;
                        return;
                     }
                  } else {
                     if (arg0.z != null) {
                        for(int var7 = 4; var7 >= 0; --var7) {
                           if (arg0.z[var7] != null && !arg0.z[var7].equalsIgnoreCase("attack")) {
                              this.uh[this.th] = arg0.z[var7] + " @yel@" + var6;
                              if (var7 == 0) {
                                 this.yd[this.th] = 318;
                              }

                              if (var7 == 1) {
                                 this.yd[this.th] = 921;
                              }

                              if (var7 == 2) {
                                 this.yd[this.th] = 118;
                              }

                              if (var7 == 3) {
                                 this.yd[this.th] = 553;
                              }

                              if (var7 == 4) {
                                 this.yd[this.th] = 432;
                              }

                              this.zd[this.th] = arg3;
                              this.wd[this.th] = arg2;
                              this.xd[this.th] = arg1;
                              ++this.th;
                           }
                        }
                     }

                     if (arg0.z != null) {
                        for(int var8 = 4; var8 >= 0; --var8) {
                           if (arg0.z[var8] != null && arg0.z[var8].equalsIgnoreCase("attack")) {
                              short var9 = 0;
                              if (arg0.s > dh.Ab) {
                                 var9 = 2000;
                              }

                              this.uh[this.th] = arg0.z[var8] + " @yel@" + var6;
                              if (var8 == 0) {
                                 this.yd[this.th] = var9 + 318;
                              }

                              if (var8 == 1) {
                                 this.yd[this.th] = var9 + 921;
                              }

                              if (var8 == 2) {
                                 this.yd[this.th] = var9 + 118;
                              }

                              if (var8 == 3) {
                                 this.yd[this.th] = var9 + 553;
                              }

                              if (var8 == 4) {
                                 this.yd[this.th] = var9 + 432;
                              }

                              this.zd[this.th] = arg3;
                              this.wd[this.th] = arg2;
                              this.xd[this.th] = arg1;
                              ++this.th;
                           }
                        }
                     }

                     this.uh[this.th] = "Examine @yel@" + var6;
                     this.yd[this.th] = 1668;
                     this.zd[this.th] = arg3;
                     this.wd[this.th] = arg2;
                     this.xd[this.th] = arg1;
                     ++this.th;
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("client.a(LWRRBQEHV;I)V")
   public final void a(Pix8 arg0, int arg1) {
      this.qb += arg1;
      short var3 = 256;

      for(int var4 = 0; var4 < this.mh.length; ++var4) {
         this.mh[var4] = 0;
      }

      for(int var5 = 0; var5 < 5000; ++var5) {
         int var6 = (int)(Math.random() * 128.0D * (double)var3);
         this.mh[var6] = (int)(Math.random() * 256.0D);
      }

      for(int var7 = 0; var7 < 20; ++var7) {
         for(int var8 = 1; var8 < var3 - 1; ++var8) {
            for(int var9 = 1; var9 < 127; ++var9) {
               int var10 = (var8 << 7) + var9;
               this.nh[var10] = (this.mh[var10 - 1] + this.mh[var10 + 1] + this.mh[var10 - 128] + this.mh[var10 + 128]) / 4;
            }
         }

         int[] var11 = this.mh;
         this.mh = this.nh;
         this.nh = var11;
      }

      if (arg0 != null) {
         int var12 = 0;

         for(int var13 = 0; var13 < arg0.G; ++var13) {
            for(int var14 = 0; var14 < arg0.F; ++var14) {
               if (arg0.D[var12++] != 0) {
                  int var15 = var14 + 16 + arg0.H;
                  int var16 = var13 + 16 + arg0.I;
                  int var17 = (var16 << 7) + var15;
                  this.mh[var17] = 0;
               }
            }
         }

      }
   }

   @ObfuscatedName("client.t(I)V")
   public final void t(int arg0) {
      this.Vg.a(false);
      Pix3D.K = this.Rd;
      this.xh.a(0, 0, -488);
      if (this.nb) {
         this.af.a(239, 452, 40, 0, this.Gc);
         this.af.a(239, 452, 60, 128, this.re + "*");
      } else if (this.Ci == 1) {
         this.af.a(239, 452, 40, 0, "Enter amount:");
         this.af.a(239, 452, 60, 128, this.Sc + "*");
      } else if (this.Ci == 2) {
         this.af.a(239, 452, 40, 0, "Enter name:");
         this.af.a(239, 452, 60, 128, this.Sc + "*");
      } else if (this.Ci == 3) {
         if (this.ib != this.Sc) {
            this.a((String)this.Sc, 2);
            this.ib = this.Sc;
         }

         PixFont var2 = this.Ze;
         Pix2D.a(0, 0, 77, 463, true);

         for(int var3 = 0; var3 < this.jb; ++var3) {
            int var4 = var3 * 14 + 18 - this.mb;
            if (var4 > 0 && var4 < 110) {
               var2.a(239, 452, var4, 0, this.kb[var3]);
            }
         }

         Pix2D.a((byte)82);
         if (this.jb > 5) {
            this.a(true, this.mb, 463, 77, this.jb * 14 + 7, 0);
         }

         if (this.Sc.length() == 0) {
            this.af.a(239, 452, 40, 255, "Enter object name");
         } else if (this.jb == 0) {
            this.af.a(239, 452, 40, 0, "No matching objects found, please shorten search");
         }

         var2.a(239, 452, 90, 0, this.Sc + "*");
         Pix2D.b(0, 0, 77, 479, true);
      } else if (this.Xe != null) {
         this.af.a(239, 452, 40, 0, this.Xe);
         this.af.a(239, 452, 60, 128, "Click to continue");
      } else if (this.Fd != -1) {
         this.a(0, 0, Component.a(this.Fd), 0, 8);
      } else if (this.Bh != -1) {
         this.a(0, 0, Component.a(this.Bh), 0, 8);
      } else {
         PixFont var5 = this.Ze;
         int var6 = 0;
         Pix2D.a(0, 0, 77, 463, true);

         for(int var7 = 0; var7 < 100; ++var7) {
            if (this.Ej[var7] != null) {
               int var8 = this.Cj[var7];
               int var9 = 70 - var6 * 14 + this.Y;
               String var10 = this.Dj[var7];
               byte var11 = 0;
               if (var10 != null && var10.startsWith("@cr1@")) {
                  var10 = var10.substring(5);
                  var11 = 1;
               }

               if (var10 != null && var10.startsWith("@cr2@")) {
                  var10 = var10.substring(5);
                  var11 = 2;
               }

               if (var8 == 0) {
                  if (var9 > 0 && var9 < 110) {
                     var5.b(2245, 4, 0, var9, this.Ej[var7]);
                  }

                  ++var6;
               }

               if ((var8 == 1 || var8 == 2) && (var8 == 1 || this.Xd == 0 || this.Xd == 1 && this.a((int)13292, (String)var10))) {
                  if (var9 > 0 && var9 < 110) {
                     int var12 = 4;
                     if (var11 == 1) {
                        this.Eg[0].a(var9 - 12, var12, -488);
                        var12 += 14;
                     }

                     if (var11 == 2) {
                        this.Eg[1].a(var9 - 12, var12, -488);
                        var12 += 14;
                     }

                     var5.b(2245, var12, 0, var9, var10 + ":");
                     int var13 = var12 + var5.a((byte)35, var10) + 8;
                     var5.b(2245, var13, 255, var9, this.Ej[var7]);
                  }

                  ++var6;
               }

               if ((var8 == 3 || var8 == 7) && this.hi == 0 && (var8 == 7 || this.Ib == 0 || this.Ib == 1 && this.a((int)13292, (String)var10))) {
                  if (var9 > 0 && var9 < 110) {
                     byte var14 = 4;
                     var5.b(2245, var14, 0, var9, "From");
                     int var15 = var14 + var5.a((byte)35, "From ");
                     if (var11 == 1) {
                        this.Eg[0].a(var9 - 12, var15, -488);
                        var15 += 14;
                     }

                     if (var11 == 2) {
                        this.Eg[1].a(var9 - 12, var15, -488);
                        var15 += 14;
                     }

                     var5.b(2245, var15, 0, var9, var10 + ":");
                     int var16 = var15 + var5.a((byte)35, var10) + 8;
                     var5.b(2245, var16, 8388608, var9, this.Ej[var7]);
                  }

                  ++var6;
               }

               if (var8 == 4 && (this.li == 0 || this.li == 1 && this.a((int)13292, (String)var10))) {
                  if (var9 > 0 && var9 < 110) {
                     var5.b(2245, 4, 8388736, var9, var10 + " " + this.Ej[var7]);
                  }

                  ++var6;
               }

               if (var8 == 5 && this.hi == 0 && this.Ib < 2) {
                  if (var9 > 0 && var9 < 110) {
                     var5.b(2245, 4, 8388608, var9, this.Ej[var7]);
                  }

                  ++var6;
               }

               if (var8 == 6 && this.hi == 0 && this.Ib < 2) {
                  if (var9 > 0 && var9 < 110) {
                     var5.b(2245, 4, 0, var9, "To " + var10 + ":");
                     var5.b(2245, 12 + var5.a((byte)35, "To " + var10), 8388608, var9, this.Ej[var7]);
                  }

                  ++var6;
               }

               if (var8 == 8 && (this.li == 0 || this.li == 1 && this.a((int)13292, (String)var10))) {
                  if (var9 > 0 && var9 < 110) {
                     var5.b(2245, 4, 8270336, var9, var10 + " " + this.Ej[var7]);
                  }

                  ++var6;
               }
            }
         }

         Pix2D.a((byte)82);
         this.Vf = var6 * 14 + 7;
         if (this.Vf < 78) {
            this.Vf = 78;
         }

         this.a(true, this.Vf - this.Y - 77, 463, 77, this.Vf, 0);
         String var17;
         if (dh != null && dh.yb != null) {
            var17 = dh.yb;
         } else {
            var17 = JString.a(this.Gf, (byte)7);
         }

         var5.b(2245, 4, 0, 90, var17 + ":");
         var5.b(2245, 6 + var5.a((byte)35, var17 + ": "), 255, 90, this.Sf + "*");
         Pix2D.b(0, 0, 77, 479, true);
      }

      if (this.ef && this.Kj == 2) {
         this.p(false);
      }

      this.Vg.a(357, 17, super.n, this.of);
      this.Ug.a(false);
      Pix3D.K = this.Td;
      if (arg0 != 0) {
         this.dk = null;
      }
   }

   @ObfuscatedName("client.u(I)V")
   public final void u(int arg0) {
      for(int var2 = -1; var2 < this.od; ++var2) {
         int var3;
         if (var2 == -1) {
            var3 = this.md;
         } else {
            var3 = this.pd[var2];
         }

         ClientPlayer var4 = this.nd[var3];
         if (var4 != null && var4.o > 0) {
            --var4.o;
            if (var4.o == 0) {
               var4.m = null;
            }
         }
      }

      this.qb += arg0;

      for(int var5 = 0; var5 < this.vg; ++var5) {
         int var6 = this.wg[var5];
         ClientNpc var7 = this.ug[var6];
         if (var7 != null && var7.o > 0) {
            --var7.o;
            if (var7.o == 0) {
               var7.m = null;
            }
         }
      }

   }

   @ObfuscatedName("client.k(Z)V")
   public final void k(boolean arg0) {
      int var2 = 5;
      this.K[8] = 0;
      if (arg0) {
         for(int var3 = 1; var3 > 0; ++var3) {
         }
      }

      int var4 = 0;

      while(this.K[8] == 0) {
         String var5 = "Unknown problem";
         this.a(20, true, (String)"Connecting to web server");

         try {
            DataInputStream var6 = this.b("crc" + (int)(Math.random() * 9.9999999E7D) + "-" + 377);
            Packet var7 = new Packet(new byte[40]);
            var6.readFully(var7.data, 0, 40);
            var6.close();

            for(int var8 = 0; var8 < 9; ++var8) {
               this.K[var8] = var7.g4();
            }

            int var9 = var7.g4();
            int var10 = 1234;

            for(int var11 = 0; var11 < 9; ++var11) {
               var10 = (var10 << 1) + this.K[var11];
            }

            if (var9 != var10) {
               var5 = "checksum problem";
               this.K[8] = 0;
            }
         } catch (EOFException var14) {
            var5 = "EOF problem";
            this.K[8] = 0;
         } catch (IOException var15) {
            var5 = "connection problem";
            this.K[8] = 0;
         } catch (Exception var16) {
            var5 = "logic problem";
            this.K[8] = 0;
            if (!sign.Signlink.reporterror) {
               return;
            }
         }

         if (this.K[8] == 0) {
            ++var4;

            for(int var12 = var2; var12 > 0; --var12) {
               if (var4 >= 10) {
                  this.a(10, true, (String)"Game updated - please reload page");
                  var12 = 10;
               } else {
                  this.a(10, true, (String)(var5 + " - Will retry in " + var12 + " secs."));
               }

               try {
                  Thread.sleep(1000L);
               } catch (Exception var13) {
               }
            }

            var2 *= 2;
            if (var2 > 60) {
               var2 = 60;
            }

            this.Vb = !this.Vb;
         }
      }

   }

   @ObfuscatedName("client.v(I)V")
   public final void v(int arg0) {
      this.Tg.a(false);
      if (this.Pe == 2) {
         byte[] var2 = this.wh.D;
         int[] var3 = Pix2D.l;
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            if (var2[var5] == 0) {
               var3[var5] = 0;
            }
         }

         this.eg.a(0, 567, 33, 25, 33, this.sj, 0, this.Ki, 256, this.qh, 25);
         this.Ug.a(false);
         Pix3D.K = this.Td;
      } else {
         int var6 = this.lc + this.Ki & 2047;
         int var7 = dh.Q / 32 + 48;
         int var8 = 58 / arg0;
         int var9 = 464 - dh.R / 32;
         this.kg.a(5, 567, 151, var7, 146, this.pc, 25, var6, this.ri + 256, this.ke, var9);
         this.eg.a(0, 567, 33, 25, 33, this.sj, 0, this.Ki, 256, this.qh, 25);

         for(int var10 = 0; var10 < this.qf; ++var10) {
            int var11 = this.rf[var10] * 4 + 2 - dh.Q / 32;
            int var12 = this.sf[var10] * 4 + 2 - dh.R / 32;
            this.a(var12, true, this.kj[var10], var11);
         }

         for(int var13 = 0; var13 < 104; ++var13) {
            for(int var14 = 0; var14 < 104; ++var14) {
               LinkList var15 = this.dk[this.Ff][var13][var14];
               if (var15 != null) {
                  int var16 = var13 * 4 + 2 - dh.Q / 32;
                  int var17 = var14 * 4 + 2 - dh.R / 32;
                  this.a(var17, true, this.Ch, var16);
               }
            }
         }

         for(int var18 = 0; var18 < this.vg; ++var18) {
            ClientNpc var19 = this.ug[this.wg[var18]];
            if (var19 != null && var19.b((int)0)) {
               NpcType var20 = var19.rb;
               if (var20.b != null) {
                  var20 = var20.b(false);
               }

               if (var20 != null && var20.p && var20.k) {
                  int var21 = var19.Q / 32 - dh.Q / 32;
                  int var22 = var19.R / 32 - dh.R / 32;
                  this.a(var22, true, this.Dh, var21);
               }
            }
         }

         for(int var23 = 0; var23 < this.od; ++var23) {
            ClientPlayer var24 = this.nd[this.pd[var23]];
            if (var24 != null && var24.b((int)0)) {
               int var25 = var24.Q / 32 - dh.Q / 32;
               int var26 = var24.R / 32 - dh.R / 32;
               boolean var27 = false;
               long var28 = JString.a(var24.yb);

               for(int var30 = 0; var30 < this.gb; ++var30) {
                  if (this.sg[var30] == var28 && this.Zi[var30] != 0) {
                     var27 = true;
                     break;
                  }
               }

               boolean var31 = false;
               if (dh.Nb != 0 && var24.Nb != 0 && dh.Nb == var24.Nb) {
                  var31 = true;
               }

               if (var27) {
                  this.a(var26, true, this.Fh, var25);
               } else if (var31) {
                  this.a(var26, true, this.Gh, var25);
               } else {
                  this.a(var26, true, this.Eh, var25);
               }
            }
         }

         if (this.Hh != 0 && fk % 20 < 10) {
            if (this.Hh == 1 && this.ki >= 0 && this.ki < this.ug.length) {
               ClientNpc var32 = this.ug[this.ki];
               if (var32 != null) {
                  int var33 = var32.Q / 32 - dh.Q / 32;
                  int var34 = var32.R / 32 - dh.R / 32;
                  this.a(var34, this.Ce, -687, var33);
               }
            }

            if (this.Hh == 2) {
               int var35 = (this.R - this.Fe) * 4 + 2 - dh.Q / 32;
               int var36 = (this.S - this.Ge) * 4 + 2 - dh.R / 32;
               this.a(var36, this.Ce, -687, var35);
            }

            if (this.Hh == 10 && this.Ng >= 0 && this.Ng < this.nd.length) {
               ClientPlayer var37 = this.nd[this.Ng];
               if (var37 != null) {
                  int var38 = var37.Q / 32 - dh.Q / 32;
                  int var39 = var37.R / 32 - dh.R / 32;
                  this.a(var39, this.Ce, -687, var38);
               }
            }
         }

         if (this.ig != 0) {
            int var40 = this.ig * 4 + 2 - dh.Q / 32;
            int var41 = this.jg * 4 + 2 - dh.R / 32;
            this.a(var41, true, this.Be, var40);
         }

         Pix2D.a(3, 78, 16777215, (byte)-24, 3, 97);
         this.Ug.a(false);
         Pix3D.K = this.Td;
      }
   }

   public final URL getCodeBase() {
      if (sign.Signlink.mainapp != null) {
         return sign.Signlink.mainapp.getCodeBase();
      } else {
         try {
            if (super.q != null) {
               return new URL("http://127.0.0.1:" + (tc + 80));
            }
         } catch (Exception var1) {
         }

         return super.getCodeBase();
      }
   }

   @ObfuscatedName("client.a(IIB)Z")
   public final boolean a(int arg0, int arg1, byte arg2) {
      boolean var4 = false;
      Component var5 = Component.a(arg1);

      for(int var6 = 0; var6 < var5.W.length && var5.W[var6] != -1; ++var6) {
         Component var7 = Component.a(var5.W[var6]);
         if (var7.A == 0) {
            var4 |= this.a(arg0, var7.f, (byte)5);
         }

         if (var7.A == 6 && (var7.yb != -1 || var7.zb != -1)) {
            boolean var8 = this.b((Component)var7, -693);
            int var9;
            if (var8) {
               var9 = var7.zb;
            } else {
               var9 = var7.yb;
            }

            if (var9 != -1) {
               SeqType var10 = SeqType.d[var9];
               var7.r += arg0;

               while(var7.r > var10.a(0, var7.z)) {
                  var7.r -= var10.a(0, var7.z);
                  ++var7.z;
                  if (var7.z >= var10.e) {
                     var7.z -= var10.i;
                     if (var7.z < 0 || var7.z >= var10.e) {
                        var7.z = 0;
                     }
                  }

                  var4 = true;
               }
            }
         }

         if (var7.A == 6 && var7.i != 0) {
            int var11 = var7.i >> 16;
            int var12 = var7.i << 16 >> 16;
            int var13 = arg0 * var11;
            int var14 = arg0 * var12;
            var7.Q = var7.Q + var13 & 2047;
            var7.R = var7.R + var14 & 2047;
            var4 = true;
         }
      }

      if (arg2 == 5) {
         boolean var15 = false;
      } else {
         this.ui = -424;
      }

      return var4;
   }

   @ObfuscatedName("client.e(II)Ljava/lang/String;")
   public final String e(int arg0, int arg1) {
      if (arg1 >= 8 && arg1 <= 8) {
         return arg0 < 999999999 ? String.valueOf(arg0) : "*";
      } else {
         throw new NullPointerException();
      }
   }

   @ObfuscatedName("client.a(IJ)V")
   public final void a(int arg0, long arg1) {
      if (arg0 != -916) {
         this.rb = this.yh.g1();
      }

      if (arg1 != 0L) {
         if (this.cb >= 100) {
            this.a("", (byte)-123, "Your ignore list is full. Max of 100 hit", 0);
         } else {
            String var4 = JString.a(JString.a(arg1, 0), (byte)7);

            for(int var5 = 0; var5 < this.cb; ++var5) {
               if (this.nf[var5] == arg1) {
                  this.a("", (byte)-123, var4 + " is already on your ignore list", 0);
                  return;
               }
            }

            for(int var6 = 0; var6 < this.gb; ++var6) {
               if (this.sg[var6] == arg1) {
                  this.a("", (byte)-123, "Please remove " + var4 + " from your friend list first", 0);
                  return;
               }
            }

            this.nf[this.cb++] = arg1;
            this.rh = true;
            this.hd.pIsaac(217);
            this.hd.p8(arg1);
         }
      }
   }

   @ObfuscatedName("client.a(B)V")
   public final void a(byte arg0) {
      if (!this.he && !this.pj && !this.Lf) {
         ++fk;
         if (arg0 == -111) {
            if (!this.zg) {
               this.K(-724);
            } else {
               this.e((byte)4);
            }

            this.j(false);
         }
      }
   }

   @ObfuscatedName("client.w(I)V")
   public final void w(int arg0) {
      if (this.bg == 0) {
         this.uh[0] = "Cancel";
         this.yd[0] = 1016;
         this.th = 1;
         if (arg0 >= 0) {
            this.Vd = this.Ub.nextInt();
         }

         if (this.Se != -1) {
            this.kc = 0;
            this.Vj = 0;
            this.a(0, Component.a(this.Se), 0, 0, 0, super.v, 23658, super.w);
            if (this.kc != this.Ij) {
               this.Ij = this.kc;
            }

            if (this.rg != this.Vj) {
               this.rg = this.Vj;
            }

         } else {
            this.D(this.oh);
            this.kc = 0;
            this.Vj = 0;
            if (super.v > 4 && super.w > 4 && super.v < 516 && super.w < 338) {
               if (this.fh != -1) {
                  this.a(4, Component.a(this.fh), 0, 0, 4, super.v, 23658, super.w);
               } else {
                  this.h((byte)7);
               }
            }

            if (this.kc != this.Ij) {
               this.Ij = this.kc;
            }

            if (this.rg != this.Vj) {
               this.rg = this.Vj;
            }

            this.kc = 0;
            this.Vj = 0;
            if (super.v > 553 && super.w > 205 && super.v < 743 && super.w < 466) {
               if (this.Df != -1) {
                  this.a(205, Component.a(this.Df), 1, 0, 553, super.v, 23658, super.w);
               } else if (this.vf[this.rj] != -1) {
                  this.a(205, Component.a(this.vf[this.rj]), 1, 0, 553, super.v, 23658, super.w);
               }
            }

            if (this.mj != this.kc) {
               this.rh = true;
               this.mj = this.kc;
            }

            if (this.Vj != this.Je) {
               this.rh = true;
               this.Je = this.Vj;
            }

            this.kc = 0;
            this.Vj = 0;
            if (super.v > 17 && super.w > 357 && super.v < 496 && super.w < 453) {
               if (this.Fd != -1) {
                  this.a(357, Component.a(this.Fd), 2, 0, 17, super.v, 23658, super.w);
               } else if (this.Bh != -1) {
                  this.a(357, Component.a(this.Bh), 3, 0, 17, super.v, 23658, super.w);
               } else if (super.w < 434 && super.v < 426 && this.Ci == 0) {
                  this.d(466, super.v - 17, super.w - 357);
               }
            }

            if ((this.Fd != -1 || this.Bh != -1) && this.kc != this.Uf) {
               this.yi = true;
               this.Uf = this.kc;
            }

            if ((this.Fd != -1 || this.Bh != -1) && this.qj != this.Vj) {
               this.yi = true;
               this.qj = this.Vj;
            }

            boolean var2 = false;

            while(!var2) {
               var2 = true;

               for(int var3 = 0; var3 < this.th - 1; ++var3) {
                  if (this.yd[var3] < 1000 && this.yd[var3 + 1] > 1000) {
                     String var4 = this.uh[var3];
                     this.uh[var3] = this.uh[var3 + 1];
                     this.uh[var3 + 1] = var4;
                     int var5 = this.yd[var3];
                     this.yd[var3] = this.yd[var3 + 1];
                     this.yd[var3 + 1] = var5;
                     int var6 = this.wd[var3];
                     this.wd[var3] = this.wd[var3 + 1];
                     this.wd[var3 + 1] = var6;
                     int var7 = this.xd[var3];
                     this.xd[var3] = this.xd[var3 + 1];
                     this.xd[var3 + 1] = var7;
                     int var8 = this.zd[var3];
                     this.zd[var3] = this.zd[var3 + 1];
                     this.zd[var3 + 1] = var8;
                     var2 = false;
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("client.c(III)Ljava/lang/String;")
   public static final String c(int arg0, int arg1, int arg2) {
      if (arg2 <= 0) {
         throw new NullPointerException();
      } else {
         int var3 = arg1 - arg0;
         if (var3 < -9) {
            return "@red@";
         } else if (var3 < -6) {
            return "@or3@";
         } else if (var3 < -3) {
            return "@or2@";
         } else if (var3 < 0) {
            return "@or1@";
         } else if (var3 > 9) {
            return "@gre@";
         } else if (var3 > 6) {
            return "@gr3@";
         } else if (var3 > 3) {
            return "@gr2@";
         } else {
            return var3 > 0 ? "@gr1@" : "@yel@";
         }
      }
   }

   @ObfuscatedName("client.x(I)V")
   public final void x(int arg0) {
      try {
         this.ij = -1;
         this.Uh.c();
         this.oj.c();
         Pix3D.b((byte)71);
         this.k((int)383);
         this.ah.a((byte)7);
         System.gc();

         for(int var2 = 0; var2 < 4; ++var2) {
            this.Si[var2].a();
         }

         for(int var3 = 0; var3 < 4; ++var3) {
            for(int var4 = 0; var4 < 104; ++var4) {
               for(int var5 = 0; var5 < 104; ++var5) {
                  this.ng[var3][var4][var5] = 0;
               }
            }
         }

         World var6 = new World(this.Mb, 14290, this.ng, 104, 104);
         int var7 = this.L.length;
         this.hd.pIsaac(40);
         if (!this.Zg) {
            for(int var8 = 0; var8 < var7; ++var8) {
               int var9 = (this.db[var8] >> 8) * 64 - this.Fe;
               int var10 = (this.db[var8] & 255) * 64 - this.Ge;
               byte[] var11 = this.L[var8];
               if (var11 != null) {
                  var6.a(var10, false, (this.Lb - 6) * 8, var9, var11, (this.Kb - 6) * 8, this.Si);
               }
            }

            for(int var12 = 0; var12 < var7; ++var12) {
               int var13 = (this.db[var12] >> 8) * 64 - this.Fe;
               int var14 = (this.db[var12] & 255) * 64 - this.Ge;
               byte[] var15 = this.L[var12];
               if (var15 == null && this.Lb < 800) {
                  var6.a(var13, var14, 64, -810, 64);
               }
            }

            this.hd.pIsaac(40);

            for(int var16 = 0; var16 < var7; ++var16) {
               byte[] var17 = this.qi[var16];
               if (var17 != null) {
                  int var18 = (this.db[var16] >> 8) * 64 - this.Fe;
                  int var19 = (this.db[var16] & 255) * 64 - this.Ge;
                  var6.a(var19, this.Si, var18, -571, this.ah, var17);
               }
            }
         }

         if (this.Zg) {
            int var20 = 0;

            label252:
            while(true) {
               if (var20 >= 4) {
                  for(int var31 = 0; var31 < 13; ++var31) {
                     for(int var32 = 0; var32 < 13; ++var32) {
                        int var33 = this.Ab[0][var31][var32];
                        if (var33 == -1) {
                           var6.a(var31 * 8, var32 * 8, 8, -810, 8);
                        }
                     }
                  }

                  this.hd.pIsaac(40);
                  int var34 = 0;

                  while(true) {
                     if (var34 >= 4) {
                        break label252;
                     }

                     for(int var35 = 0; var35 < 13; ++var35) {
                        for(int var36 = 0; var36 < 13; ++var36) {
                           int var37 = this.Ab[var34][var35][var36];
                           if (var37 != -1) {
                              int var38 = var37 >> 24 & 3;
                              int var39 = var37 >> 1 & 3;
                              int var40 = var37 >> 14 & 1023;
                              int var41 = var37 >> 3 & 2047;
                              int var42 = (var40 / 8 << 8) + var41 / 8;

                              for(int var43 = 0; var43 < this.db.length; ++var43) {
                                 if (this.db[var43] == var42 && this.qi[var43] != null) {
                                    var6.a(var34, this.Si, this.ah, false, this.qi[var43], var36 * 8, var39, (var40 & 7) * 8, var35 * 8, (var41 & 7) * 8, var38);
                                    break;
                                 }
                              }
                           }
                        }
                     }

                     ++var34;
                  }
               }

               for(int var21 = 0; var21 < 13; ++var21) {
                  for(int var22 = 0; var22 < 13; ++var22) {
                     boolean var23 = false;
                     int var24 = this.Ab[var20][var21][var22];
                     if (var24 != -1) {
                        int var25 = var24 >> 24 & 3;
                        int var26 = var24 >> 1 & 3;
                        int var27 = var24 >> 14 & 1023;
                        int var28 = var24 >> 3 & 2047;
                        int var29 = (var27 / 8 << 8) + var28 / 8;

                        for(int var30 = 0; var30 < this.db.length; ++var30) {
                           if (this.db[var30] == var29 && this.L[var30] != null) {
                              var6.a(var26, (var28 & 7) * 8, false, this.L[var30], var20, var25, var21 * 8, this.Si, var22 * 8, (var27 & 7) * 8);
                              var23 = true;
                              break;
                           }
                        }
                     }

                     if (!var23) {
                        var6.a(this.mf, var20, var22 * 8, var21 * 8);
                     }
                  }
               }

               ++var20;
            }
         }

         this.hd.pIsaac(40);
         var6.a(this.Si, this.Yj, this.ah);
         if (this.Ug != null) {
            this.Ug.a(false);
            Pix3D.K = this.Td;
         }

         this.hd.pIsaac(40);
         int var44 = World.m;
         if (var44 > this.Ff) {
            var44 = this.Ff;
         }

         if (var44 < this.Ff - 1) {
            int var45 = this.Ff - 1;
         }

         if (vc) {
            this.ah.a(World.m, true);
         } else {
            this.ah.a(0, true);
         }

         for(int var46 = 0; var46 < 104; ++var46) {
            for(int var47 = 0; var47 < 104; ++var47) {
               this.b(var46, var47);
            }
         }

         this.d((byte)3);
      } catch (Exception var61) {
      }

      LocType.v.a();
      if (super.q != null) {
         this.hd.pIsaac(78);
         this.hd.p4(1057001181);
      }

      if (vc && sign.Signlink.cache_dat != null) {
         int var49 = this.xj.c(0, -31140);

         for(int var50 = 0; var50 < var49; ++var50) {
            int var51 = this.xj.a(var50, -493);
            if ((var51 & 121) == 0) {
               Model.a(var50, (int)1);
            }
         }
      }

      System.gc();
      Pix3D.a((byte)7, 20);
      this.xj.a((byte)-125);
      int var52 = (this.Kb - 6) / 8 - 1;
      int var53 = (this.Kb + 6) / 8 + 1;
      int var54 = (this.Lb - 6) / 8 - 1;
      int var55 = (this.Lb + 6) / 8 + 1;
      int var56 = 94 / arg0;
      if (this.gf) {
         var52 = 49;
         var53 = 50;
         var54 = 49;
         var55 = 50;
      }

      for(int var57 = var52; var57 <= var53; ++var57) {
         for(int var58 = var54; var58 <= var55; ++var58) {
            if (var52 == var57 || var53 == var57 || var54 == var58 || var55 == var58) {
               int var59 = this.xj.a(0, var57, (int)var58, 0);
               if (var59 != -1) {
                  this.xj.a(var59, 3, this.Fc);
               }

               int var60 = this.xj.a(0, var57, (int)var58, 1);
               if (var60 != -1) {
                  this.xj.a(var60, 3, this.Fc);
               }
            }
         }
      }

   }

   @ObfuscatedName("client.a(IIIIIIB)V")
   public final void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, byte arg6) {
      int var8 = 2048 - arg2 & 2047;
      int var9 = 2048 - arg4 & 2047;
      if (arg6 != -103) {
         this.rb = -1;
      }

      int var10 = 0;
      int var11 = 0;
      int var12 = arg3;
      if (var8 != 0) {
         int var13 = Model.Ib[var8];
         int var14 = Model.Jb[var8];
         int var15 = var11 * var14 - arg3 * var13 >> 16;
         var12 = var11 * var13 + arg3 * var14 >> 16;
         var11 = var15;
      }

      if (var9 != 0) {
         int var16 = Model.Ib[var9];
         int var17 = Model.Jb[var9];
         int var18 = var10 * var17 + var12 * var16 >> 16;
         var12 = var12 * var17 - var10 * var16 >> 16;
         var10 = var18;
      }

      this.ai = arg1 - var10;
      this.bi = arg0 - var11;
      this.ci = arg5 - var12;
      this.di = arg2;
      this.ei = arg4;
   }

   @ObfuscatedName("client.b(LEWIXBTLV;I)Z")
   public final boolean b(Component arg0, int arg1) {
      if (arg1 >= 0) {
         this.lh = 276;
      }

      if (arg0.lb == null) {
         return false;
      } else {
         for(int var3 = 0; var3 < arg0.lb.length; ++var3) {
            int var4 = this.a(3, (int)var3, (Component)arg0);
            int var5 = arg0.U[var3];
            if (arg0.lb[var3] == 2) {
               if (var4 >= var5) {
                  return false;
               }
            } else if (arg0.lb[var3] == 3) {
               if (var4 <= var5) {
                  return false;
               }
            } else if (arg0.lb[var3] == 4) {
               if (var4 == var5) {
                  return false;
               }
            } else if (var4 != var5) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("client.a(IILMFMVIYHT;)V")
   public final void a(int arg0, int arg1, Packet arg2) {
      this.Aj = 0;
      this.qd = 0;
      this.a(arg0, this.gj, arg2);
      this.b(arg0, (int)-138, arg2);
      int var4 = 40 / arg1;
      this.a(arg0, (byte)6, (Packet)arg2);
      this.a(808, arg2, arg0);

      for(int var5 = 0; var5 < this.Aj; ++var5) {
         int var6 = this.Bj[var5];
         if (fk != this.nd[var6].r) {
            this.nd[var6] = null;
         }
      }

      if (arg2.pos != arg0) {
         sign.Signlink.reporterror("Error packet size mismatch in getplayer pos:" + arg2.pos + " psize:" + arg0);
         throw new RuntimeException("eek");
      } else {
         for(int var7 = 0; var7 < this.od; ++var7) {
            if (this.nd[this.pd[var7]] == null) {
               sign.Signlink.reporterror(this.Gf + " null entry in pl list - pos:" + var7 + " size:" + this.od);
               throw new RuntimeException("eek");
            }
         }

      }
   }

   @ObfuscatedName("client.b(IJ)V")
   public final void b(int arg0, long arg1) {
      if (arg1 != 0L) {
         for(int var4 = 0; var4 < this.cb; ++var4) {
            if (this.nf[var4] == arg1) {
               --this.cb;
               this.rh = true;

               for(int var5 = var4; var5 < this.cb; ++var5) {
                  this.nf[var5] = this.nf[var5 + 1];
               }

               this.hd.pIsaac(160);
               this.hd.p8(arg1);
               break;
            }
         }

         int var6 = 42 / arg0;
      }
   }

   public final String getParameter(String arg0) {
      return sign.Signlink.mainapp != null ? sign.Signlink.mainapp.getParameter(arg0) : super.getParameter(arg0);
   }

   @ObfuscatedName("client.y(I)V")
   public final void y(int arg0) {
      short var2 = 256;
      if (this.Me > 0) {
         for(int var3 = 0; var3 < 256; ++var3) {
            if (this.Me > 768) {
               this.Qj[var3] = this.b(this.Rj[var3], this.Sj[var3], 1024 - this.Me, 8);
            } else if (this.Me > 256) {
               this.Qj[var3] = this.Sj[var3];
            } else {
               this.Qj[var3] = this.b(this.Sj[var3], this.Rj[var3], 256 - this.Me, 8);
            }
         }
      } else if (this.Ne > 0) {
         for(int var4 = 0; var4 < 256; ++var4) {
            if (this.Ne > 768) {
               this.Qj[var4] = this.b(this.Rj[var4], this.Tj[var4], 1024 - this.Ne, 8);
            } else if (this.Ne > 256) {
               this.Qj[var4] = this.Tj[var4];
            } else {
               this.Qj[var4] = this.b(this.Tj[var4], this.Rj[var4], 256 - this.Ne, 8);
            }
         }
      } else {
         for(int var5 = 0; var5 < 256; ++var5) {
            this.Qj[var5] = this.Rj[var5];
         }
      }

      for(int var6 = 0; var6 < 33920; ++var6) {
         this.Lh.b[var6] = this.ie.I[var6];
      }

      int var7 = 0;
      int var8 = 1152;

      for(int var9 = 1; var9 < var2 - 1; ++var9) {
         int var10 = (var2 - var9) * this.ch[var9] / var2;
         int var11 = var10 + 22;
         if (var11 < 0) {
            var11 = 0;
         }

         var7 += var11;

         for(int var12 = var11; var12 < 128; ++var12) {
            int var13 = this.yf[var7++];
            if (var13 != 0) {
               int var15 = 256 - var13;
               int var16 = this.Qj[var13];
               int var17 = this.Lh.b[var8];
               this.Lh.b[var8++] = ((var16 & 16711935) * var13 + (var17 & 16711935) * var15 & -16711936) + ((var16 & 65280) * var13 + (var17 & 65280) * var15 & 16711680) >> 8;
            } else {
               ++var8;
            }
         }

         var8 += var11;
      }

      this.Lh.a(0, 0, super.n, this.of);
      int var18 = 66 / arg0;

      for(int var19 = 0; var19 < 33920; ++var19) {
         this.Mh.b[var19] = this.je.I[var19];
      }

      int var20 = 0;
      int var21 = 1176;

      for(int var22 = 1; var22 < var2 - 1; ++var22) {
         int var23 = (var2 - var22) * this.ch[var22] / var2;
         int var24 = 103 - var23;
         int var25 = var21 + var23;

         for(int var26 = 0; var26 < var24; ++var26) {
            int var27 = this.yf[var20++];
            if (var27 != 0) {
               int var29 = 256 - var27;
               int var30 = this.Qj[var27];
               int var31 = this.Mh.b[var25];
               this.Mh.b[var25++] = ((var30 & 16711935) * var27 + (var31 & 16711935) * var29 & -16711936) + ((var30 & 65280) * var27 + (var31 & 65280) * var29 & 16711680) >> 8;
            } else {
               ++var25;
            }
         }

         var20 += 128 - var24;
         var21 = 128 - var24 - var23 + var25;
      }

      this.Mh.a(0, 637, super.n, this.of);
   }

   @ObfuscatedName("client.a(ZBI)V")
   public final void a(boolean arg0, byte arg1, int arg2) {
      if (arg1 != 8) {
         this.hd.p1((int)49);
      }

      sign.Signlink.midivol = arg2;
      if (arg0) {
         sign.Signlink.midi = "voladjust";
      }
   }

   @ObfuscatedName("client.z(I)V")
   public final void z(int arg0) {
      for(int var2 = -1; var2 < this.od; ++var2) {
         int var3;
         if (var2 == -1) {
            var3 = this.md;
         } else {
            var3 = this.pd[var2];
         }

         ClientPlayer var4 = this.nd[var3];
         if (var4 != null) {
            this.a(1, (byte)-97, (ClientEntity)var4);
         }
      }

      if (arg0 < this.gi || arg0 > this.gi) {
         for(int var5 = 1; var5 > 0; ++var5) {
         }
      }

   }

   @ObfuscatedName("client.l(Z)V")
   public static final void l(boolean arg0) {
      World3D.m = true;
      if (!arg0) {
         Ai = true;
      }

      Pix3D.z = true;
      vc = true;
      World.F = true;
      LocType.o = true;
   }

   @ObfuscatedName("client.b(JI)V")
   public final void b(long arg0, int arg1) {
      if (arg0 != 0L) {
         if (this.gb >= 100 && this.hf != 1) {
            this.a("", (byte)-123, "Your friendlist is full. Max of 100 for free users, and 200 for members", 0);
         } else if (this.gb >= 200) {
            this.a("", (byte)-123, "Your friendlist is full. Max of 100 for free users, and 200 for members", 0);
         } else {
            String var4 = JString.a(JString.a(arg0, 0), (byte)7);

            for(int var5 = 0; var5 < this.gb; ++var5) {
               if (this.sg[var5] == arg0) {
                  this.a("", (byte)-123, var4 + " is already on your friend list", 0);
                  return;
               }
            }

            for(int var6 = 0; var6 < this.cb; ++var6) {
               if (this.nf[var6] == arg0) {
                  this.a("", (byte)-123, "Please remove " + var4 + " from your ignore list first", 0);
                  return;
               }
            }

            if (!var4.equals(dh.yb)) {
               this.W[this.gb] = var4;
               if (arg1 != -45229) {
                  this.oh = -30;
               }

               this.sg[this.gb] = arg0;
               this.Zi[this.gb] = 0;
               ++this.gb;
               this.rh = true;
               this.hd.pIsaac(120);
               this.hd.p8(arg0);
            }
         }
      }
   }

   @ObfuscatedName("client.a(BLEWIXBTLV;)V")
   public final void a(byte arg0, Component arg1) {
      if (arg0 == 2) {
         boolean var3 = false;
      } else {
         this.Vd = -82;
      }

      int var4 = arg1.G;
      if ((var4 < 1 || var4 > 100) && (var4 < 701 || var4 > 800)) {
         if (var4 >= 101 && var4 <= 200 || var4 >= 801 && var4 <= 900) {
            int var6 = this.gb;
            if (this.hb != 2) {
               var6 = 0;
            }

            if (var4 > 800) {
               var4 -= 701;
            } else {
               var4 -= 101;
            }

            if (var4 >= var6) {
               arg1.u = "";
               arg1.Bb = 0;
            } else {
               if (this.Zi[var4] == 0) {
                  arg1.u = "@red@Offline";
               } else if (this.Zi[var4] < 200) {
                  if (this.Zi[var4] == sc) {
                     arg1.u = "@gre@World" + (this.Zi[var4] - 9);
                  } else {
                     arg1.u = "@yel@World" + (this.Zi[var4] - 9);
                  }
               } else if (this.Zi[var4] == sc) {
                  arg1.u = "@gre@Classic" + (this.Zi[var4] - 219);
               } else {
                  arg1.u = "@yel@Classic" + (this.Zi[var4] - 219);
               }

               arg1.Bb = 1;
            }
         } else if (var4 == 203) {
            int var7 = this.gb;
            if (this.hb != 2) {
               var7 = 0;
            }

            arg1.xb = var7 * 15 + 20;
            if (arg1.xb <= arg1.C) {
               arg1.xb = arg1.C + 1;
            }

         } else if (var4 >= 401 && var4 <= 500) {
            var4 -= 401;
            if (var4 == 0 && this.hb == 0) {
               arg1.u = "Loading ignore list";
               arg1.Bb = 0;
            } else if (var4 == 1 && this.hb == 0) {
               arg1.u = "Please wait...";
               arg1.Bb = 0;
            } else {
               int var8 = this.cb;
               if (this.hb == 0) {
                  var8 = 0;
               }

               if (var4 >= var8) {
                  arg1.u = "";
                  arg1.Bb = 0;
               } else {
                  arg1.u = JString.a(JString.a(this.nf[var4], 0), (byte)7);
                  arg1.Bb = 1;
               }
            }
         } else if (var4 == 503) {
            arg1.xb = this.cb * 15 + 20;
            if (arg1.xb <= arg1.C) {
               arg1.xb = arg1.C + 1;
            }

         } else if (var4 == 327) {
            arg1.Q = 150;
            arg1.R = (int)(Math.sin((double)fk / 40.0D) * 256.0D) & 2047;
            if (this.jj) {
               for(int var9 = 0; var9 < 7; ++var9) {
                  int var10 = this.gk[var9];
                  if (var10 >= 0 && !IdkType.e[var10].a((int)256)) {
                     return;
                  }
               }

               this.jj = false;
               Model[] var11 = new Model[7];
               int var12 = 0;

               for(int var13 = 0; var13 < 7; ++var13) {
                  int var14 = this.gk[var13];
                  if (var14 >= 0) {
                     var11[var12++] = IdkType.e[var14].a((byte)2);
                  }
               }

               Model var15 = new Model(var12, var11, (byte)-89);

               for(int var16 = 0; var16 < 5; ++var16) {
                  if (this.Nf[var16] != 0) {
                     var15.c(Zd[var16][0], Zd[var16][this.Nf[var16]]);
                     if (var16 == 1) {
                        var15.c(aj[0], aj[this.Nf[var16]]);
                     }
                  }
               }

               var15.f(7);
               var15.a(SeqType.d[dh.ob].f[0], (byte)6);
               var15.a(64, 850, -30, -50, -30, true);
               arg1.vb = 5;
               arg1.wb = 0;
               Component.a(5, (Model)var15, 0, 6);
            }

         } else if (var4 == 324) {
            if (this.Qf == null) {
               this.Qf = arg1.c;
               this.Rf = arg1.J;
            }

            if (this.Gg) {
               arg1.c = this.Rf;
            } else {
               arg1.c = this.Qf;
            }
         } else if (var4 == 325) {
            if (this.Qf == null) {
               this.Qf = arg1.c;
               this.Rf = arg1.J;
            }

            if (this.Gg) {
               arg1.c = this.Qf;
            } else {
               arg1.c = this.Rf;
            }
         } else if (var4 == 600) {
            arg1.u = this.M;
            if (fk % 20 < 10) {
               arg1.u = arg1.u + "|";
            } else {
               arg1.u = arg1.u + " ";
            }
         } else {
            if (var4 == 620) {
               if (this.ob >= 1) {
                  if (this.Mf) {
                     arg1.E = 16711680;
                     arg1.u = "Moderator option: Mute player for 48 hours: <ON>";
                  } else {
                     arg1.E = 16777215;
                     arg1.u = "Moderator option: Mute player for 48 hours: <OFF>";
                  }
               } else {
                  arg1.u = "";
               }
            }

            if (var4 == 660) {
               int var17 = this.gh - this.Zh;
               String var18;
               if (var17 <= 0) {
                  var18 = "earlier today";
               } else if (var17 == 1) {
                  var18 = "yesterday";
               } else {
                  var18 = var17 + " days ago";
               }

               arg1.u = "You last logged in @red@" + var18 + "@bla@ from: @red@" + sign.Signlink.dns;
            }

            if (var4 == 661) {
               if (this.ze == 0) {
                  arg1.u = "\\nYou have not yet set any recovery questions.\\nIt is @lre@strongly@yel@ recommended that you do so.\\n\\nIf you don't you will be @lre@unable to recover your\\n@lre@password@yel@ if you forget it, or it is stolen.";
               } else if (this.ze <= this.gh) {
                  arg1.u = "\\n\\nRecovery Questions Last Set:\\n@gre@" + this.a(this.ze, (byte)83);
               } else {
                  int var19 = this.gh + 14 - this.ze;
                  String var20;
                  if (var19 <= 0) {
                     var20 = "Earlier today";
                  } else if (var19 == 1) {
                     var20 = "Yesterday";
                  } else {
                     var20 = var19 + " days ago";
                  }

                  arg1.u = var20 + " you requested@lre@ new recovery\\n@lre@questions.@yel@ The requested change will occur\\non: @lre@" + this.a(this.ze, (byte)83) + "\\n\\nIf you do not remember making this request\\ncancel it immediately, and change your password.";
               }
            }

            if (var4 == 662) {
               String var21;
               if (this.fj == 0) {
                  var21 = "@yel@0 unread messages";
               } else if (this.fj == 1) {
                  var21 = "@gre@1 unread message";
               } else {
                  var21 = "@gre@" + this.fj + " unread messages";
               }

               arg1.u = "You have " + var21 + "\\nin your message centre.";
            }

            if (var4 == 663) {
               if (this.xf > 0 && this.xf <= this.gh + 10) {
                  arg1.u = "Last password change:\\n@gre@" + this.a(this.xf, (byte)83);
               } else {
                  arg1.u = "Last password change:\\n@gre@Never changed";
               }
            }

            if (var4 == 665) {
               if (this.Jd > 2 && !uc) {
                  arg1.u = "This is a non-members\\nworld. To enjoy your\\nmembers benefits we\\nrecommend you play on a\\nmembers world instead.";
               } else if (this.Jd > 2) {
                  arg1.u = "\\n\\nYou have @gre@" + this.Jd + "@yel@ days of\\nmember credit remaining.";
               } else if (this.Jd > 0) {
                  arg1.u = "You have @gre@" + this.Jd + "@yel@ days of\\nmember credit remaining.\\n\\n@lre@Credit low! Renew now\\n@lre@to avoid losing members.";
               } else {
                  arg1.u = "You are not a member.\\n\\nChoose to subscribe and\\nyou'll get loads of extra\\nbenefits and features.";
               }
            }

            if (var4 == 667) {
               if (this.Jd > 2 && !uc) {
                  arg1.u = "To switch to a members-only world:\\n1) Logout and return to the world selection page.\\n2) Choose one of the members world with a gold star next to it's name.\\n\\nIf you prefer you can continue to use this world,\\nbut members only features will be unavailable here.";
               } else if (this.Jd > 0) {
                  arg1.u = "To extend or cancel a subscription:\\n1) Logout and return to the frontpage of this website.\\n2)Choose the relevant option from the 'membership' section.\\n\\nNote: If you are a credit card subscriber a top-up payment will\\nautomatically be taken when 3 days credit remain.\\n(unless you cancel your subscription, which can be done at any time.)";
               } else {
                  arg1.u = "To start a subscripton:\\n1) Logout and return to the frontpage of this website.\\n2) Choose 'Start a new subscription'";
               }
            }

            if (var4 == 668) {
               if (this.ze > this.gh) {
                  arg1.u = "To cancel this request:\\n1) Logout and return to the frontpage of this website.\\n2) Choose 'Cancel recovery questions'.";
               } else {
                  arg1.u = "To change your recovery questions:\\n1) Logout and return to the frontpage of this website.\\n2) Choose 'Set new recovery questions'.";
               }
            }
         }
      } else if (var4 == 1 && this.hb == 0) {
         arg1.u = "Loading friend list";
         arg1.Bb = 0;
      } else if (var4 == 1 && this.hb == 1) {
         arg1.u = "Connecting to friendserver";
         arg1.Bb = 0;
      } else if (var4 == 2 && this.hb != 2) {
         arg1.u = "Please wait...";
         arg1.Bb = 0;
      } else {
         int var5 = this.gb;
         if (this.hb != 2) {
            var5 = 0;
         }

         if (var4 > 700) {
            var4 -= 601;
         } else {
            --var4;
         }

         if (var4 >= var5) {
            arg1.u = "";
            arg1.Bb = 0;
         } else {
            arg1.u = this.W[var4];
            arg1.Bb = 1;
         }
      }
   }

   @ObfuscatedName("client.a(IB)Ljava/lang/String;")
   public final String a(int arg0, byte arg1) {
      if (arg1 != 83) {
         this.rb = this.yh.g1();
      }

      if (arg0 > this.gh + 10) {
         return "Unknown";
      } else {
         long var3 = ((long)arg0 + 11745L) * 86400000L;
         Calendar var5 = Calendar.getInstance();
         var5.setTime(new Date(var3));
         int var6 = var5.get(5);
         int var7 = var5.get(2);
         int var8 = var5.get(1);
         String[] var9 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
         return var6 + "-" + var9[var7] + "-" + var8;
      }
   }

   @ObfuscatedName("client.f(II)V")
   public final void f(int arg0, int arg1) {
      this.qb += arg0;
      int var3 = VarpType.b[arg1].j;
      if (var3 != 0) {
         int var4 = this.Ee[arg1];
         if (var3 == 1) {
            if (var4 == 1) {
               Pix3D.a(0.9D, (byte)6);
            }

            if (var4 == 2) {
               Pix3D.a(0.8D, (byte)6);
            }

            if (var4 == 3) {
               Pix3D.a(0.7D, (byte)6);
            }

            if (var4 == 4) {
               Pix3D.a(0.6D, (byte)6);
            }

            ObjType.u.a();
            this.Le = true;
         }

         if (var3 == 3) {
            boolean var5 = this.Yi;
            if (var4 == 0) {
               this.a(this.Yi, (byte)8, 0);
               this.Yi = true;
            }

            if (var4 == 1) {
               this.a(this.Yi, (byte)8, -400);
               this.Yi = true;
            }

            if (var4 == 2) {
               this.a(this.Yi, (byte)8, -800);
               this.Yi = true;
            }

            if (var4 == 3) {
               this.a(this.Yi, (byte)8, -1200);
               this.Yi = true;
            }

            if (var4 == 4) {
               this.Yi = false;
            }

            if (this.Yi != var5 && !vc) {
               if (this.Yi) {
                  this.cj = this.hk;
                  this.dj = true;
                  this.xj.b(2, this.cj);
               } else {
                  this.g(false);
               }

               this.qg = 0;
            }
         }

         if (var3 == 4) {
            if (var4 == 0) {
               this.Hj = true;
               this.c(822, 0);
            }

            if (var4 == 1) {
               this.Hj = true;
               this.c(822, -400);
            }

            if (var4 == 2) {
               this.Hj = true;
               this.c(822, -800);
            }

            if (var4 == 3) {
               this.Hj = true;
               this.c(822, -1200);
            }

            if (var4 == 4) {
               this.Hj = false;
            }
         }

         if (var3 == 5) {
            this.Gj = var4;
         }

         if (var3 == 6) {
            this.Pd = var4;
         }

         if (var3 == 8) {
            this.hi = var4;
            this.yi = true;
         }

         if (var3 == 9) {
            this.Yc = var4;
         }
      }
   }

   @ObfuscatedName("client.b(IIII)I")
   public final int b(int arg0, int arg1, int arg2, int arg3) {
      if (arg3 < 8 || arg3 > 8) {
         this.hd.p1((int)235);
      }

      int var5 = 256 - arg2;
      return ((arg0 & 16711935) * var5 + (arg1 & 16711935) * arg2 & -16711936) + ((arg0 & 65280) * var5 + (arg1 & 65280) * arg2 & 16711680) >> 8;
   }

   @ObfuscatedName("client.A(I)V")
   public final void A(int arg0) {
      this.Ei = 0;
      int var2 = (dh.Q >> 7) + this.Fe;
      int var3 = (dh.R >> 7) + this.Ge;
      if (arg0 < 0) {
         if (var2 >= 3053 && var2 <= 3156 && var3 >= 3056 && var3 <= 3136) {
            this.Ei = 1;
         }

         if (var2 >= 3072 && var2 <= 3118 && var3 >= 9492 && var3 <= 9535) {
            this.Ei = 1;
         }

         if (this.Ei == 1 && var2 >= 3139 && var2 <= 3199 && var3 >= 3008 && var3 <= 3062) {
            this.Ei = 0;
         }
      }
   }

   @ObfuscatedName("client.B(I)V")
   public final void B(int arg0) {
      int var2 = this.af.a((byte)35, "Choose Option");

      for(int var3 = 0; var3 < this.th; ++var3) {
         int var4 = this.af.a((byte)35, this.uh[var3]);
         if (var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      if (arg0 <= 0) {
         Ah = !Ah;
      }

      int var5 = this.th * 15 + 21;
      if (super.C > 4 && super.D > 4 && super.C < 516 && super.D < 338) {
         int var6 = super.C - 4 - var2 / 2;
         if (var2 + var6 > 512) {
            var6 = 512 - var2;
         }

         if (var6 < 0) {
            var6 = 0;
         }

         int var7 = super.D - 4;
         if (var5 + var7 > 334) {
            var7 = 334 - var5;
         }

         if (var7 < 0) {
            var7 = 0;
         }

         this.ef = true;
         this.Kj = 0;
         this.Lj = var6;
         this.Mj = var7;
         this.Nj = var2;
         this.Oj = this.th * 15 + 22;
      }

      if (super.C > 553 && super.D > 205 && super.C < 743 && super.D < 466) {
         int var8 = super.C - 553 - var2 / 2;
         if (var8 < 0) {
            var8 = 0;
         } else if (var2 + var8 > 190) {
            var8 = 190 - var2;
         }

         int var9 = super.D - 205;
         if (var9 < 0) {
            var9 = 0;
         } else if (var5 + var9 > 261) {
            var9 = 261 - var5;
         }

         this.ef = true;
         this.Kj = 1;
         this.Lj = var8;
         this.Mj = var9;
         this.Nj = var2;
         this.Oj = this.th * 15 + 22;
      }

      if (super.C > 17 && super.D > 357 && super.C < 496 && super.D < 453) {
         int var10 = super.C - 17 - var2 / 2;
         if (var10 < 0) {
            var10 = 0;
         } else if (var2 + var10 > 479) {
            var10 = 479 - var2;
         }

         int var11 = super.D - 357;
         if (var11 < 0) {
            var11 = 0;
         } else if (var5 + var11 > 96) {
            var11 = 96 - var5;
         }

         this.ef = true;
         this.Kj = 2;
         this.Lj = var10;
         this.Mj = var11;
         this.Nj = var2;
         this.Oj = this.th * 15 + 22;
      }
   }

   @ObfuscatedName("client.C(I)V")
   public final void C(int arg0) {
      if (arg0 != 30729) {
         this.Ve = this.Ub.nextInt();
      }

      this.q(0);
      if (this.oe == 1) {
         this.Rb[this.ne / 100].b(this.me - 8 - 4, this.le - 8 - 4, -488);
      }

      if (this.oe == 2) {
         this.Rb[this.ne / 100 + 4].b(this.me - 8 - 4, this.le - 8 - 4, -488);
      }

      if (this.lj != -1) {
         this.a(this.Uc, this.lj, (byte)5);
         this.a(0, 0, Component.a(this.lj), 0, 8);
      }

      if (this.fh != -1) {
         this.a(this.Uc, this.fh, (byte)5);
         this.a(0, 0, Component.a(this.fh), 0, 8);
      }

      this.A(-7);
      if (!this.ef) {
         this.w(-521);
         this.g((byte)-79);
      } else if (this.Kj == 0) {
         this.p(false);
      }

      if (this.Zj == 1) {
         this.Af.b(296, 472, -488);
      }

      if (pb) {
         short var2 = 507;
         byte var3 = 20;
         int var4 = 16776960;
         if (super.j < 30 && vc) {
            var4 = 16711680;
         }

         if (super.j < 20 && !vc) {
            var4 = 16711680;
         }

         this.Ze.a(true, "Fps:" + super.j, var4, var2, var3);
         int var13 = var3 + 15;
         Runtime var5 = Runtime.getRuntime();
         int var6 = (int)((var5.totalMemory() - var5.freeMemory()) / 1024L);
         int var7 = 16776960;
         if (var6 > 33554432 && vc) {
            int var8 = 16711680;
         }

         if (var6 > 67108864 && !vc) {
            int var9 = 16711680;
         }

         this.Ze.a(true, "Mem:" + var6 + "k", 16776960, var2, var13);
         var13 += 15;
      }

      if (this.We != 0) {
         int var10 = this.We / 50;
         int var11 = var10 / 60;
         int var12 = var10 % 60;
         if (var12 < 10) {
            this.Ze.b(2245, 4, 16776960, 329, "System update in: " + var11 + ":0" + var12);
         } else {
            this.Ze.b(2245, 4, 16776960, 329, "System update in: " + var11 + ":" + var12);
         }

         ++Qb;
         if (Qb > 112) {
            Qb = 0;
            this.hd.pIsaac(197);
            this.hd.p4(0);
            return;
         }
      }

   }

   public final void run() {
      if (this.Uj) {
         this.c((byte)4);
      } else {
         super.run();
      }
   }

   @ObfuscatedName("client.a(IIBI)I")
   public final int a(int arg0, int arg1, byte arg2, int arg3) {
      int var5 = arg1 >> 7;
      int var6 = arg0 >> 7;
      if (var5 >= 0 && var6 >= 0 && var5 <= 103 && var6 <= 103) {
         int var7 = arg3;
         if (arg3 < 3 && (this.ng[1][var5][var6] & 2) == 2) {
            var7 = arg3 + 1;
         }

         int var8 = arg1 & 127;
         int var9 = arg0 & 127;
         if (arg2 != 9) {
            this.Wc = !this.Wc;
         }

         int var10 = (128 - var8) * this.Mb[var7][var5][var6] + this.Mb[var7][var5 + 1][var6] * var8 >> 7;
         int var11 = (128 - var8) * this.Mb[var7][var5][var6 + 1] + this.Mb[var7][var5 + 1][var6 + 1] * var8 >> 7;
         return (128 - var9) * var10 + var9 * var11 >> 7;
      } else {
         return 0;
      }
   }

   public final AppletContext getAppletContext() {
      return sign.Signlink.mainapp != null ? sign.Signlink.mainapp.getAppletContext() : super.getAppletContext();
   }

   @ObfuscatedName("client.D(I)V")
   public final void D(int arg0) {
      int var2 = 21 / arg0;
      if (this.hi != 0) {
         int var3 = 0;
         if (this.We != 0) {
            var3 = 1;
         }

         for(int var4 = 0; var4 < 100; ++var4) {
            if (this.Ej[var4] != null) {
               int var5 = this.Cj[var4];
               String var6 = this.Dj[var4];
               boolean var7 = false;
               if (var6 != null && var6.startsWith("@cr1@")) {
                  var6 = var6.substring(5);
                  boolean var8 = true;
               }

               if (var6 != null && var6.startsWith("@cr2@")) {
                  var6 = var6.substring(5);
                  boolean var9 = true;
               }

               if ((var5 == 3 || var5 == 7) && (var5 == 7 || this.Ib == 0 || this.Ib == 1 && this.a((int)13292, (String)var6))) {
                  int var10 = 329 - var3 * 13;
                  if (super.v > 4 && super.w - 4 > var10 - 10 && super.w - 4 <= var10 + 3) {
                     int var11 = this.Ze.a((byte)35, "From:  " + var6 + this.Ej[var4]) + 25;
                     if (var11 > 450) {
                        var11 = 450;
                     }

                     if (super.v < var11 + 4) {
                        if (this.ob >= 1) {
                           this.uh[this.th] = "Report abuse @whi@" + var6;
                           this.yd[this.th] = 2507;
                           ++this.th;
                        }

                        this.uh[this.th] = "Add ignore @whi@" + var6;
                        this.yd[this.th] = 2574;
                        ++this.th;
                        this.uh[this.th] = "Add friend @whi@" + var6;
                        this.yd[this.th] = 2762;
                        ++this.th;
                     }
                  }

                  ++var3;
                  if (var3 >= 5) {
                     return;
                  }
               }

               if ((var5 == 5 || var5 == 6) && this.Ib < 2) {
                  ++var3;
                  if (var3 >= 5) {
                     return;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("client.b(BI)V")
   public final void b(byte arg0, int arg1) {
      if (arg0 != 36) {
         this.hd.p1((int)6);
      }

      Component var3 = Component.a(arg1);

      for(int var4 = 0; var4 < var3.W.length && var3.W[var4] != -1; ++var4) {
         Component var5 = Component.a(var3.W[var4]);
         if (var5.A == 1) {
            this.b((byte)36, (int)var5.f);
         }

         var5.z = 0;
         var5.r = 0;
      }

   }

   @ObfuscatedName("client.d(III)V")
   public final void d(int arg0, int arg1, int arg2) {
      int var4 = 0;
      int var5 = 44 / arg0;

      for(int var6 = 0; var6 < 100; ++var6) {
         if (this.Ej[var6] != null) {
            int var7 = this.Cj[var6];
            int var8 = 70 - var4 * 14 + this.Y + 4;
            if (var8 < -20) {
               break;
            }

            String var9 = this.Dj[var6];
            boolean var10 = false;
            if (var9 != null && var9.startsWith("@cr1@")) {
               var9 = var9.substring(5);
               boolean var11 = true;
            }

            if (var9 != null && var9.startsWith("@cr2@")) {
               var9 = var9.substring(5);
               boolean var12 = true;
            }

            if (var7 == 0) {
               ++var4;
            }

            if ((var7 == 1 || var7 == 2) && (var7 == 1 || this.Xd == 0 || this.Xd == 1 && this.a((int)13292, (String)var9))) {
               if (arg2 > var8 - 14 && arg2 <= var8 && !var9.equals(dh.yb)) {
                  if (this.ob >= 1) {
                     this.uh[this.th] = "Report abuse @whi@" + var9;
                     this.yd[this.th] = 507;
                     ++this.th;
                  }

                  this.uh[this.th] = "Add ignore @whi@" + var9;
                  this.yd[this.th] = 574;
                  ++this.th;
                  this.uh[this.th] = "Add friend @whi@" + var9;
                  this.yd[this.th] = 762;
                  ++this.th;
               }

               ++var4;
            }

            if ((var7 == 3 || var7 == 7) && this.hi == 0 && (var7 == 7 || this.Ib == 0 || this.Ib == 1 && this.a((int)13292, (String)var9))) {
               if (arg2 > var8 - 14 && arg2 <= var8) {
                  if (this.ob >= 1) {
                     this.uh[this.th] = "Report abuse @whi@" + var9;
                     this.yd[this.th] = 507;
                     ++this.th;
                  }

                  this.uh[this.th] = "Add ignore @whi@" + var9;
                  this.yd[this.th] = 574;
                  ++this.th;
                  this.uh[this.th] = "Add friend @whi@" + var9;
                  this.yd[this.th] = 762;
                  ++this.th;
               }

               ++var4;
            }

            if (var7 == 4 && (this.li == 0 || this.li == 1 && this.a((int)13292, (String)var9))) {
               if (arg2 > var8 - 14 && arg2 <= var8) {
                  this.uh[this.th] = "Accept trade @whi@" + var9;
                  this.yd[this.th] = 544;
                  ++this.th;
               }

               ++var4;
            }

            if ((var7 == 5 || var7 == 6) && this.hi == 0 && this.Ib < 2) {
               ++var4;
            }

            if (var7 == 8 && (this.li == 0 || this.li == 1 && this.a((int)13292, (String)var9))) {
               if (arg2 > var8 - 14 && arg2 <= var8) {
                  this.uh[this.th] = "Accept challenge @whi@" + var9;
                  this.yd[this.th] = 695;
                  ++this.th;
               }

               ++var4;
            }
         }
      }

   }

   @ObfuscatedName("client.b(IILMFMVIYHT;)V")
   public final void b(int arg0, int arg1, Packet arg2) {
      int var4 = arg2.gBit(8);
      if (var4 < this.od) {
         for(int var5 = var4; var5 < this.od; ++var5) {
            this.Bj[this.Aj++] = this.pd[var5];
         }
      }

      if (var4 > this.od) {
         sign.Signlink.reporterror(this.Gf + " Too many players");
         throw new RuntimeException("eek");
      } else {
         this.od = 0;
         if (arg1 >= 0) {
            this.rb = -1;
         }

         for(int var6 = 0; var6 < var4; ++var6) {
            int var7 = this.pd[var6];
            ClientPlayer var8 = this.nd[var7];
            int var9 = arg2.gBit(1);
            if (var9 == 0) {
               this.pd[this.od++] = var7;
               var8.r = fk;
            } else {
               int var10 = arg2.gBit(2);
               if (var10 == 0) {
                  this.pd[this.od++] = var7;
                  var8.r = fk;
                  this.rd[this.qd++] = var7;
               } else if (var10 == 1) {
                  this.pd[this.od++] = var7;
                  var8.r = fk;
                  int var11 = arg2.gBit(3);
                  var8.a(false, var11, -808);
                  int var12 = arg2.gBit(1);
                  if (var12 == 1) {
                     this.rd[this.qd++] = var7;
                  }
               } else if (var10 == 2) {
                  this.pd[this.od++] = var7;
                  var8.r = fk;
                  int var13 = arg2.gBit(3);
                  var8.a(true, var13, -808);
                  int var14 = arg2.gBit(3);
                  var8.a(true, var14, -808);
                  int var15 = arg2.gBit(1);
                  if (var15 == 1) {
                     this.rd[this.qd++] = var7;
                  }
               } else if (var10 == 3) {
                  this.Bj[this.Aj++] = var7;
               }
            }
         }

      }
   }

   @ObfuscatedName("client.g(II)V")
   public final void g(int arg0, int arg1) {
      int[] var3 = this.kg.I;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         var3[var5] = 0;
      }

      for(int var6 = 1; var6 < 103; ++var6) {
         int var7 = (103 - var6) * 512 * 4 + 24628;

         for(int var8 = 1; var8 < 103; ++var8) {
            if ((this.ng[arg0][var8][var6] & 24) == 0) {
               this.ah.a(var3, var7, 512, arg0, var8, var6);
            }

            if (arg0 < 3 && (this.ng[arg0 + 1][var8][var6] & 8) != 0) {
               this.ah.a(var3, var7, 512, arg0 + 1, var8, var6);
            }

            var7 += 4;
         }
      }

      int var9 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      if (arg1 != 0) {
         this.rb = this.yh.g1();
      }

      int var10 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      this.kg.a(false);

      for(int var11 = 1; var11 < 103; ++var11) {
         for(int var12 = 1; var12 < 103; ++var12) {
            if ((this.ng[arg0][var12][var11] & 24) == 0) {
               this.a(var11, arg0, var12, var10, 563, var9);
            }

            if (arg0 < 3 && (this.ng[arg0 + 1][var12][var11] & 8) != 0) {
               this.a(var11, arg0 + 1, var12, var10, 563, var9);
            }
         }
      }

      if (this.Ug != null) {
         this.Ug.a(false);
         Pix3D.K = this.Td;
      }

      ++wf;
      if (wf > 177) {
         wf = 0;
         this.hd.pIsaac(173);
         this.hd.p3(2657152);
      }

      this.qf = 0;

      for(int var13 = 0; var13 < 104; ++var13) {
         for(int var14 = 0; var14 < 104; ++var14) {
            int var15 = this.ah.d(this.Ff, var13, var14);
            if (var15 != 0) {
               int var16 = var15 >> 14 & 32767;
               int var17 = LocType.a(var16).W;
               if (var17 >= 0) {
                  int var18 = var13;
                  int var19 = var14;
                  if (var17 != 22 && var17 != 29 && var17 != 34 && var17 != 36 && var17 != 46 && var17 != 47 && var17 != 48) {
                     byte var20 = 104;
                     byte var21 = 104;
                     int[][] var22 = this.Si[this.Ff].j;

                     for(int var23 = 0; var23 < 10; ++var23) {
                        int var24 = (int)(Math.random() * 4.0D);
                        if (var24 == 0 && var18 > 0 && var18 > var13 - 3 && (var22[var18 - 1][var19] & 19398920) == 0) {
                           --var18;
                        }

                        if (var24 == 1 && var18 < var20 - 1 && var18 < var13 + 3 && (var22[var18 + 1][var19] & 19399040) == 0) {
                           ++var18;
                        }

                        if (var24 == 2 && var19 > 0 && var19 > var14 - 3 && (var22[var18][var19 - 1] & 19398914) == 0) {
                           --var19;
                        }

                        if (var24 == 3 && var19 < var21 - 1 && var19 < var14 + 3 && (var22[var18][var19 + 1] & 19398944) == 0) {
                           ++var19;
                        }
                     }
                  }

                  this.kj[this.qf] = this.we[var17];
                  this.rf[this.qf] = var18;
                  this.sf[this.qf] = var19;
                  ++this.qf;
               }
            }
         }
      }

   }

   @ObfuscatedName("client.a(II[B)Z")
   public final boolean a(int arg0, int arg1, byte[] arg2) {
      if (arg0 >= 3 && arg0 <= 3) {
         return arg2 == null ? true : sign.Signlink.wavesave(arg2, arg1);
      } else {
         throw new NullPointerException();
      }
   }

   @ObfuscatedName("client.j(B)I")
   public final int j(byte arg0) {
      int var2 = 3;
      if (this.Zc == arg0) {
         boolean var3 = false;
      } else {
         this.a();
      }

      if (this.di < 310) {
         ++vd;
         if (vd > 1457) {
            vd = 0;
            this.hd.pIsaac(244);
            this.hd.p1((int)0);
            int var4 = this.hd.pos;
            this.hd.p1((int)219);
            this.hd.p2(37745);
            this.hd.p1((int)61);
            this.hd.p2(43756);
            this.hd.p2((int)(Math.random() * 65536.0D));
            this.hd.p1((int)(Math.random() * 256.0D));
            this.hd.p2(51171);
            if ((int)(Math.random() * 2.0D) == 0) {
               this.hd.p2((int)15808);
            }

            this.hd.p1((int)97);
            this.hd.p1((int)(Math.random() * 256.0D));
            this.hd.psize1((int)(this.hd.pos - var4));
         }

         int var5 = this.ai >> 7;
         int var6 = this.ci >> 7;
         int var7 = dh.Q >> 7;
         int var8 = dh.R >> 7;
         if ((this.ng[this.Ff][var5][var6] & 4) != 0) {
            var2 = this.Ff;
         }

         int var9;
         if (var7 > var5) {
            var9 = var7 - var5;
         } else {
            var9 = var5 - var7;
         }

         int var10;
         if (var8 > var6) {
            var10 = var8 - var6;
         } else {
            var10 = var6 - var8;
         }

         if (var9 > var10) {
            int var11 = var10 * 65536 / var9;
            int var12 = 32768;

            while(var5 != var7) {
               if (var5 < var7) {
                  ++var5;
               } else if (var5 > var7) {
                  --var5;
               }

               if ((this.ng[this.Ff][var5][var6] & 4) != 0) {
                  var2 = this.Ff;
               }

               var12 += var11;
               if (var12 >= 65536) {
                  var12 -= 65536;
                  if (var6 < var8) {
                     ++var6;
                  } else if (var6 > var8) {
                     --var6;
                  }

                  if ((this.ng[this.Ff][var5][var6] & 4) != 0) {
                     var2 = this.Ff;
                  }
               }
            }
         } else {
            int var13 = var9 * 65536 / var10;
            int var14 = 32768;

            while(var6 != var8) {
               if (var6 < var8) {
                  ++var6;
               } else if (var6 > var8) {
                  --var6;
               }

               if ((this.ng[this.Ff][var5][var6] & 4) != 0) {
                  var2 = this.Ff;
               }

               var14 += var13;
               if (var14 >= 65536) {
                  var14 -= 65536;
                  if (var5 < var7) {
                     ++var5;
                  } else if (var5 > var7) {
                     --var5;
                  }

                  if ((this.ng[this.Ff][var5][var6] & 4) != 0) {
                     var2 = this.Ff;
                  }
               }
            }
         }
      }

      if ((this.ng[this.Ff][dh.Q >> 7][dh.R >> 7] & 4) != 0) {
         var2 = this.Ff;
      }

      return var2;
   }

   @ObfuscatedName("client.E(I)I")
   public final int E(int arg0) {
      int var2 = this.a(this.ci, this.ai, (byte)9, this.Ff);

      while(arg0 >= 0) {
         this.rb = this.yh.g1();
      }

      return var2 - this.bi < 800 && (this.ng[this.Ff][this.ai >> 7][this.ci >> 7] & 4) != 0 ? this.Ff : 3;
   }

   @ObfuscatedName("client.a(Ljava/lang/Runnable;I)V")
   public final void a(Runnable arg0, int arg1) {
      if (arg1 > 10) {
         arg1 = 10;
      }

      if (sign.Signlink.mainapp != null) {
         sign.Signlink.startthread(arg0, arg1);
      } else {
         super.a(arg0, arg1);
      }
   }

   @ObfuscatedName("client.b(IZ)V")
   public final void b(int arg0, boolean arg1) {
      if (dh.Q >> 7 == this.ig && dh.R >> 7 == this.jg) {
         this.ig = 0;
      }

      int var3 = this.od;
      if (arg1) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         ClientPlayer var5;
         int var6;
         if (arg1) {
            var5 = dh;
            var6 = this.md << 14;
         } else {
            var5 = this.nd[this.pd[var4]];
            var6 = this.pd[var4] << 14;
         }

         if (var5 != null && var5.b((int)0)) {
            var5.Kb = false;
            if ((vc && this.od > 50 || this.od > 200) && !arg1 && var5.u == var5.ob) {
               var5.Kb = true;
            }

            int var7 = var5.Q >> 7;
            int var8 = var5.R >> 7;
            if (var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if (var5.tb != null && fk >= var5.Lb && fk < var5.Mb) {
                  var5.Kb = false;
                  var5.xb = this.a(var5.R, var5.Q, (byte)9, this.Ff);
                  this.ah.a(var5.xb, var5.Qb, 60, 7, var5, var5.Pb, var5.R, var5.Sb, var5.Q, var5.S, var5.Rb, this.Ff, var6);
               } else {
                  if ((var5.Q & 127) == 64 && (var5.R & 127) == 64) {
                     if (this.Hb[var7][var8] == this.Ag) {
                        continue;
                     }

                     this.Hb[var7][var8] = this.Ag;
                  }

                  var5.xb = this.a(var5.R, var5.Q, (byte)9, this.Ff);
                  this.ah.a(var6, var5, var5.Q, var5.xb, var5.y, 0, this.Ff, 60, var5.R, var5.S);
               }
            }
         }
      }

      if (arg0 == 0) {
         ;
      }
   }

   @ObfuscatedName("client.h(II)V")
   public final void h(int arg0, int arg1) {
      if (arg0 >= 0) {
         int var3 = this.wd[arg0];
         int var4 = this.xd[arg0];
         int var5 = this.yd[arg0];
         int var6 = this.zd[arg0];
         if (arg1 < this.qc || arg1 > this.qc) {
            this.rb = this.yh.g1();
         }

         if (var5 >= 2000) {
            var5 -= 2000;
         }

         if (this.Ci != 0 && var5 != 1016) {
            this.Ci = 0;
            this.yi = true;
         }

         if (var5 == 200) {
            ClientPlayer var7 = this.nd[var6];
            if (var7 != null) {
               this.a(false, false, var7.t[0], dh.t[0], 1, 1, 2, 0, var7.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(245);
               this.hd.f(3, var6);
            }
         }

         if (var5 == 227) {
            ++bh;
            if (bh >= 62) {
               this.hd.pIsaac(165);
               this.hd.p1((int)206);
               bh = 0;
            }

            this.hd.pIsaac(228);
            this.hd.d(0, var3);
            this.hd.e(var6, 0);
            this.hd.p2(var4);
            this.jk = 0;
            this.kk = var4;
            this.lk = var3;
            this.mk = 2;
            if (Component.a(var4).M == this.fh) {
               this.mk = 1;
            }

            if (Component.a(var4).M == this.Fd) {
               this.mk = 3;
            }
         }

         if (var5 == 876) {
            ClientPlayer var8 = this.nd[var6];
            if (var8 != null) {
               this.a(false, false, var8.t[0], dh.t[0], 1, 1, 2, 0, var8.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(45);
               this.hd.e(var6, 0);
            }
         }

         if (var5 == 921) {
            ClientNpc var9 = this.ug[var6];
            if (var9 != null) {
               this.a(false, false, var9.t[0], dh.t[0], 1, 1, 2, 0, var9.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(67);
               this.hd.e(var6, 0);
            }
         }

         if (var5 == 961) {
            Bg += var6;
            if (Bg >= 115) {
               this.hd.pIsaac(126);
               this.hd.p1((int)125);
               Bg = 0;
            }

            this.hd.pIsaac(203);
            this.hd.e(var4, 0);
            this.hd.d(0, var3);
            this.hd.d(0, var6);
            this.jk = 0;
            this.kk = var4;
            this.lk = var3;
            this.mk = 2;
            if (Component.a(var4).M == this.fh) {
               this.mk = 1;
            }

            if (Component.a(var4).M == this.Fd) {
               this.mk = 3;
            }
         }

         if (var5 == 467 && this.a(var4, 0, (int)var3, var6)) {
            this.hd.pIsaac(152);
            this.hd.d(0, var6 >> 14 & 32767);
            this.hd.d(0, this.Kg);
            this.hd.d(0, this.Lg);
            this.hd.d(0, this.Ge + var4);
            this.hd.p2(this.Jg);
            this.hd.f(3, this.Fe + var3);
         }

         if (var5 == 9) {
            this.hd.pIsaac(3);
            this.hd.e(var6, 0);
            this.hd.p2(var4);
            this.hd.p2(var3);
            this.jk = 0;
            this.kk = var4;
            this.lk = var3;
            this.mk = 2;
            if (Component.a(var4).M == this.fh) {
               this.mk = 1;
            }

            if (Component.a(var4).M == this.Fd) {
               this.mk = 3;
            }
         }

         if (var5 == 553) {
            ClientNpc var10 = this.ug[var6];
            if (var10 != null) {
               this.a(false, false, var10.t[0], dh.t[0], 1, 1, 2, 0, var10.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(42);
               this.hd.d(0, var6);
            }
         }

         if (var5 == 677) {
            ClientPlayer var11 = this.nd[var6];
            if (var11 != null) {
               this.a(false, false, var11.t[0], dh.t[0], 1, 1, 2, 0, var11.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(116);
               this.hd.d(0, var6);
            }
         }

         if (var5 == 762 || var5 == 574 || var5 == 775 || var5 == 859) {
            String var12 = this.uh[arg0];
            int var13 = var12.indexOf("@whi@");
            if (var13 != -1) {
               long var14 = JString.a(var12.substring(var13 + 5).trim());
               if (var5 == 762) {
                  this.b(var14, -45229);
               }

               if (var5 == 574) {
                  this.a(this.Qg, var14);
               }

               if (var5 == 775) {
                  this.a(var14, 0);
               }

               if (var5 == 859) {
                  this.b(325, var14);
               }
            }
         }

         if (var5 == 930) {
            boolean var16 = this.a(false, false, var4, dh.t[0], 0, 0, 2, 0, var3, 0, 0, dh.s[0]);
            if (!var16) {
               this.a(false, false, var4, dh.t[0], 1, 1, 2, 0, var3, 0, 0, dh.s[0]);
            }

            this.le = super.C;
            this.me = super.D;
            this.oe = 2;
            this.ne = 0;
            this.hd.pIsaac(54);
            this.hd.e(var6, 0);
            this.hd.d(0, this.Ge + var4);
            this.hd.p2(this.Fe + var3);
         }

         if (var5 == 399) {
            this.hd.pIsaac(24);
            this.hd.d(0, var4);
            this.hd.d(0, var6);
            this.hd.e(var3, 0);
            this.jk = 0;
            this.kk = var4;
            this.lk = var3;
            this.mk = 2;
            if (Component.a(var4).M == this.fh) {
               this.mk = 1;
            }

            if (Component.a(var4).M == this.Fd) {
               this.mk = 3;
            }
         }

         if (var5 == 347) {
            ClientNpc var18 = this.ug[var6];
            if (var18 != null) {
               this.a(false, false, var18.t[0], dh.t[0], 1, 1, 2, 0, var18.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(57);
               this.hd.p2(var6);
               this.hd.d(0, this.Lg);
               this.hd.f(3, this.Kg);
               this.hd.p2(this.Jg);
            }
         }

         if (var5 == 890) {
            this.hd.pIsaac(79);
            this.hd.p2(var4);
            Component var19 = Component.a(var4);
            if (var19.y != null && var19.y[0][0] == 5) {
               int var20 = var19.y[0][1];
               this.Ee[var20] = 1 - this.Ee[var20];
               this.f(0, var20);
               this.rh = true;
            }
         }

         if (var5 == 493) {
            ClientPlayer var21 = this.nd[var6];
            if (var21 != null) {
               this.a(false, false, var21.t[0], dh.t[0], 1, 1, 2, 0, var21.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(233);
               this.hd.e(var6, 0);
            }
         }

         if (var5 == 14) {
            if (!this.ef) {
               this.ah.e(0, super.C - 4, super.D - 4);
            } else {
               this.ah.e(0, var3 - 4, var4 - 4);
            }
         }

         if (var5 == 903) {
            this.hd.pIsaac(1);
            this.hd.p2(var6);
            this.hd.d(0, this.Jg);
            this.hd.d(0, this.Lg);
            this.hd.f(3, this.Kg);
            this.hd.e(var3, 0);
            this.hd.e(var4, 0);
            this.jk = 0;
            this.kk = var4;
            this.lk = var3;
            this.mk = 2;
            if (Component.a(var4).M == this.fh) {
               this.mk = 1;
            }

            if (Component.a(var4).M == this.Fd) {
               this.mk = 3;
            }
         }

         if (var5 == 361) {
            this.hd.pIsaac(36);
            this.hd.p2(this.ih);
            this.hd.e(var4, 0);
            this.hd.e(var3, 0);
            this.hd.e(var6, 0);
            this.jk = 0;
            this.kk = var4;
            this.lk = var3;
            this.mk = 2;
            if (Component.a(var4).M == this.fh) {
               this.mk = 1;
            }

            if (Component.a(var4).M == this.Fd) {
               this.mk = 3;
            }
         }

         if (var5 == 118) {
            ClientNpc var22 = this.ug[var6];
            if (var22 != null) {
               this.a(false, false, var22.t[0], dh.t[0], 1, 1, 2, 0, var22.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               ti += var6;
               if (ti >= 143) {
                  this.hd.pIsaac(157);
                  this.hd.p4(0);
                  ti = 0;
               }

               this.hd.pIsaac(13);
               this.hd.f(3, var6);
            }
         }

         if (var5 == 376 && this.a(var4, 0, (int)var3, var6)) {
            this.hd.pIsaac(210);
            this.hd.p2(this.ih);
            this.hd.d(0, var6 >> 14 & 32767);
            this.hd.e(this.Fe + var3, 0);
            this.hd.d(0, this.Ge + var4);
         }

         if (var5 == 432) {
            ClientNpc var23 = this.ug[var6];
            if (var23 != null) {
               this.a(false, false, var23.t[0], dh.t[0], 1, 1, 2, 0, var23.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(8);
               this.hd.d(0, var6);
            }
         }

         if (var5 == 639) {
            this.b(false);
         }

         if (var5 == 918) {
            ClientPlayer var24 = this.nd[var6];
            if (var24 != null) {
               this.a(false, false, var24.t[0], dh.t[0], 1, 1, 2, 0, var24.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(31);
               this.hd.p2(var6);
               this.hd.d(0, this.ih);
            }
         }

         if (var5 == 67) {
            ClientNpc var25 = this.ug[var6];
            if (var25 != null) {
               this.a(false, false, var25.t[0], dh.t[0], 1, 1, 2, 0, var25.s[0], 0, 0, dh.s[0]);
               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(104);
               this.hd.e(this.ih, 0);
               this.hd.d(0, var6);
            }
         }

         if (var5 == 68) {
            boolean var26 = this.a(false, false, var4, dh.t[0], 0, 0, 2, 0, var3, 0, 0, dh.s[0]);
            if (!var26) {
               this.a(false, false, var4, dh.t[0], 1, 1, 2, 0, var3, 0, 0, dh.s[0]);
            }

            this.le = super.C;
            this.me = super.D;
            this.oe = 2;
            this.ne = 0;
            this.hd.pIsaac(77);
            this.hd.e(this.Fe + var3, 0);
            this.hd.p2(this.Ge + var4);
            this.hd.f(3, var6);
         }

         if (var5 == 684) {
            boolean var28 = this.a(false, false, var4, dh.t[0], 0, 0, 2, 0, var3, 0, 0, dh.s[0]);
            if (!var28) {
               this.a(false, false, var4, dh.t[0], 1, 1, 2, 0, var3, 0, 0, dh.s[0]);
            }

            this.le = super.C;
            this.me = super.D;
            this.oe = 2;
            this.ne = 0;
            if ((var6 & 3) == 0) {
               ++Re;
            }

            if (Re >= 84) {
               this.hd.pIsaac(222);
               this.hd.p3(11257922);
               Re = 0;
            }

            this.hd.pIsaac(71);
            this.hd.f(3, var6);
            this.hd.f(3, this.Fe + var3);
            this.hd.e(this.Ge + var4, 0);
         }

         if (var5 == 544 || var5 == 695) {
            String var30 = this.uh[arg0];
            int var31 = var30.indexOf("@whi@");
            if (var31 != -1) {
               String var32 = var30.substring(var31 + 5).trim();
               String var33 = JString.a(JString.a(JString.a(var32), 0), (byte)7);
               boolean var34 = false;

               for(int var35 = 0; var35 < this.od; ++var35) {
                  ClientPlayer var36 = this.nd[this.pd[var35]];
                  if (var36 != null && var36.yb != null && var36.yb.equalsIgnoreCase(var33)) {
                     this.a(false, false, var36.t[0], dh.t[0], 1, 1, 2, 0, var36.s[0], 0, 0, dh.s[0]);
                     if (var5 == 544) {
                        this.hd.pIsaac(116);
                        this.hd.d(0, this.pd[var35]);
                     }

                     if (var5 == 695) {
                        this.hd.pIsaac(245);
                        this.hd.f(3, this.pd[var35]);
                     }

                     var34 = true;
                     break;
                  }
               }

               if (!var34) {
                  this.a("", (byte)-123, "Unable to find " + var33, 0);
               }
            }
         }

         if (var5 == 225) {
            this.hd.pIsaac(177);
            this.hd.e(var3, 0);
            this.hd.d(0, var6);
            this.hd.d(0, var4);
            this.jk = 0;
            this.kk = var4;
            this.lk = var3;
            this.mk = 2;
            if (Component.a(var4).M == this.fh) {
               this.mk = 1;
            }

            if (Component.a(var4).M == this.Fd) {
               this.mk = 3;
            }
         }

         if (var5 == 70) {
            Component var37 = Component.a(var4);
            this.hh = 1;
            this.ih = var4;
            this.jh = var37.m;
            this.Ig = 0;
            this.rh = true;
            String var38 = var37.tb;
            if (var38.indexOf(" ") != -1) {
               var38 = var38.substring(0, var38.indexOf(" "));
            }

            String var39 = var37.tb;
            if (var39.indexOf(" ") != -1) {
               var39 = var39.substring(var39.indexOf(" ") + 1);
            }

            this.kh = var38 + " " + var37.b + " " + var39;
            if (this.jh == 16) {
               this.rh = true;
               this.rj = 3;
               this.Tc = true;
            }

         } else {
            if (var5 == 891) {
               this.hd.pIsaac(4);
               this.hd.d(0, var3);
               this.hd.f(3, var6);
               this.hd.f(3, var4);
               this.jk = 0;
               this.kk = var4;
               this.lk = var3;
               this.mk = 2;
               if (Component.a(var4).M == this.fh) {
                  this.mk = 1;
               }

               if (Component.a(var4).M == this.Fd) {
                  this.mk = 3;
               }
            }

            if (var5 == 894) {
               this.hd.pIsaac(158);
               this.hd.f(3, var3);
               this.hd.f(3, var6);
               this.hd.d(0, var4);
               this.jk = 0;
               this.kk = var4;
               this.lk = var3;
               this.mk = 2;
               if (Component.a(var4).M == this.fh) {
                  this.mk = 1;
               }

               if (Component.a(var4).M == this.Fd) {
                  this.mk = 3;
               }
            }

            if (var5 == 1280) {
               this.a(var4, 0, (int)var3, var6);
               this.hd.pIsaac(55);
               this.hd.d(0, var6 >> 14 & 32767);
               this.hd.d(0, this.Ge + var4);
               this.hd.p2(this.Fe + var3);
            }

            if (var5 == 35) {
               this.a(var4, 0, (int)var3, var6);
               this.hd.pIsaac(181);
               this.hd.e(this.Fe + var3, 0);
               this.hd.d(0, this.Ge + var4);
               this.hd.d(0, var6 >> 14 & 32767);
            }

            if (var5 == 888) {
               this.a(var4, 0, (int)var3, var6);
               this.hd.pIsaac(50);
               this.hd.e(this.Ge + var4, 0);
               this.hd.d(0, var6 >> 14 & 32767);
               this.hd.f(3, this.Fe + var3);
            }

            if (var5 == 324) {
               this.hd.pIsaac(161);
               this.hd.f(3, var3);
               this.hd.f(3, var6);
               this.hd.d(0, var4);
               this.jk = 0;
               this.kk = var4;
               this.lk = var3;
               this.mk = 2;
               if (Component.a(var4).M == this.fh) {
                  this.mk = 1;
               }

               if (Component.a(var4).M == this.Fd) {
                  this.mk = 3;
               }
            }

            if (var5 == 1094) {
               ObjType var40 = ObjType.a(var6);
               Component var41 = Component.a(var4);
               String var42;
               if (var41 != null && var41.o[var3] >= 100000) {
                  var42 = var41.o[var3] + " x " + var40.d;
               } else if (var40.c != null) {
                  var42 = new String(var40.c);
               } else {
                  var42 = "It's a " + var40.d + ".";
               }

               this.a("", (byte)-123, var42, 0);
            }

            if (var5 == 352) {
               Component var43 = Component.a(var4);
               boolean var44 = true;
               if (var43.G > 0) {
                  var44 = this.a((int)631, (Component)var43);
               }

               if (var44) {
                  this.hd.pIsaac(79);
                  this.hd.p2(var4);
               }
            }

            if (var5 == 1412) {
               int var45 = var6 >> 14 & 32767;
               LocType var46 = LocType.a(var45);
               String var47;
               if (var46.z != null) {
                  var47 = new String(var46.z);
               } else {
                  var47 = "It's a " + var46.s + ".";
               }

               this.a("", (byte)-123, var47, 0);
            }

            if (var5 == 575 && !this.xi) {
               this.hd.pIsaac(226);
               this.hd.p2(var4);
               this.xi = true;
            }

            if (var5 == 892) {
               this.a(var4, 0, (int)var3, var6);
               this.hd.pIsaac(136);
               this.hd.p2(this.Fe + var3);
               this.hd.d(0, this.Ge + var4);
               this.hd.p2(var6 >> 14 & 32767);
            }

            if (var5 == 270) {
               boolean var48 = this.a(false, false, var4, dh.t[0], 0, 0, 2, 0, var3, 0, 0, dh.s[0]);
               if (!var48) {
                  this.a(false, false, var4, dh.t[0], 1, 1, 2, 0, var3, 0, 0, dh.s[0]);
               }

               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(230);
               this.hd.d(0, var6);
               this.hd.e(this.Fe + var3, 0);
               this.hd.p2(this.Ge + var4);
            }

            if (var5 == 596) {
               ClientPlayer var50 = this.nd[var6];
               if (var50 != null) {
                  this.a(false, false, var50.t[0], dh.t[0], 1, 1, 2, 0, var50.s[0], 0, 0, dh.s[0]);
                  this.le = super.C;
                  this.me = super.D;
                  this.oe = 2;
                  this.ne = 0;
                  this.hd.pIsaac(143);
                  this.hd.d(0, this.Lg);
                  this.hd.f(3, this.Jg);
                  this.hd.p2(this.Kg);
                  this.hd.e(var6, 0);
               }
            }

            if (var5 == 100) {
               boolean var51 = this.a(false, false, var4, dh.t[0], 0, 0, 2, 0, var3, 0, 0, dh.s[0]);
               if (!var51) {
                  this.a(false, false, var4, dh.t[0], 1, 1, 2, 0, var3, 0, 0, dh.s[0]);
               }

               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(211);
               this.hd.f(3, this.Jg);
               this.hd.e(this.Lg, 0);
               this.hd.f(3, this.Ge + var4);
               this.hd.f(3, this.Fe + var3);
               this.hd.d(0, this.Kg);
               this.hd.d(0, var6);
            }

            if (var5 == 1668) {
               ClientNpc var53 = this.ug[var6];
               if (var53 != null) {
                  NpcType var54 = var53.rb;
                  if (var54.b != null) {
                     var54 = var54.b(false);
                  }

                  if (var54 != null) {
                     String var55;
                     if (var54.N != null) {
                        var55 = new String(var54.N);
                     } else {
                        var55 = "It's a " + var54.F + ".";
                     }

                     this.a("", (byte)-123, var55, 0);
                  }
               }
            }

            if (var5 == 26) {
               boolean var56 = this.a(false, false, var4, dh.t[0], 0, 0, 2, 0, var3, 0, 0, dh.s[0]);
               if (!var56) {
                  this.a(false, false, var4, dh.t[0], 1, 1, 2, 0, var3, 0, 0, dh.s[0]);
               }

               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               ++Of;
               if (Of >= 120) {
                  this.hd.pIsaac(95);
                  this.hd.p4(0);
                  Of = 0;
               }

               this.hd.pIsaac(100);
               this.hd.p2(this.Fe + var3);
               this.hd.e(this.Ge + var4, 0);
               this.hd.f(3, var6);
            }

            if (var5 == 444) {
               this.hd.pIsaac(91);
               this.hd.d(0, var6);
               this.hd.f(3, var3);
               this.hd.p2(var4);
               this.jk = 0;
               this.kk = var4;
               this.lk = var3;
               this.mk = 2;
               if (Component.a(var4).M == this.fh) {
                  this.mk = 1;
               }

               if (Component.a(var4).M == this.Fd) {
                  this.mk = 3;
               }
            }

            if (var5 == 507) {
               String var58 = this.uh[arg0];
               int var59 = var58.indexOf("@whi@");
               if (var59 != -1) {
                  if (this.fh == -1) {
                     this.b(false);
                     this.M = var58.substring(var59 + 5).trim();
                     this.Mf = false;
                     this.pi = this.fh = Component.K;
                  } else {
                     this.a("", (byte)-123, "Please close the interface you have open before using 'report abuse'", 0);
                  }
               }
            }

            if (var5 == 389) {
               this.a(var4, 0, (int)var3, var6);
               this.hd.pIsaac(241);
               this.hd.p2(var6 >> 14 & 32767);
               this.hd.p2(this.Fe + var3);
               this.hd.e(this.Ge + var4, 0);
            }

            if (var5 == 564) {
               this.hd.pIsaac(231);
               this.hd.f(3, var4);
               this.hd.d(0, var3);
               this.hd.p2(var6);
               this.jk = 0;
               this.kk = var4;
               this.lk = var3;
               this.mk = 2;
               if (Component.a(var4).M == this.fh) {
                  this.mk = 1;
               }

               if (Component.a(var4).M == this.Fd) {
                  this.mk = 3;
               }
            }

            if (var5 == 984) {
               String var60 = this.uh[arg0];
               int var61 = var60.indexOf("@whi@");
               if (var61 != -1) {
                  long var62 = JString.a(var60.substring(var61 + 5).trim());
                  int var64 = -1;

                  for(int var65 = 0; var65 < this.gb; ++var65) {
                     if (this.sg[var65] == var62) {
                        var64 = var65;
                        break;
                     }
                  }

                  if (var64 != -1 && this.Zi[var64] > 0) {
                     this.yi = true;
                     this.Ci = 0;
                     this.nb = true;
                     this.re = "";
                     this.fi = 3;
                     this.Dg = this.sg[var64];
                     this.Gc = "Enter message to send to " + this.W[var64];
                  }
               }
            }

            if (var5 == 518) {
               this.hd.pIsaac(79);
               this.hd.p2(var4);
               Component var66 = Component.a(var4);
               if (var66.y != null && var66.y[0][0] == 5) {
                  int var67 = var66.y[0][1];
                  if (this.Ee[var67] != var66.U[0]) {
                     this.Ee[var67] = var66.U[0];
                     this.f(0, var67);
                     this.rh = true;
                  }
               }
            }

            if (var5 == 318) {
               ClientNpc var68 = this.ug[var6];
               if (var68 != null) {
                  this.a(false, false, var68.t[0], dh.t[0], 1, 1, 2, 0, var68.s[0], 0, 0, dh.s[0]);
                  this.le = super.C;
                  this.me = super.D;
                  this.oe = 2;
                  this.ne = 0;
                  this.hd.pIsaac(112);
                  this.hd.d(0, var6);
               }
            }

            if (var5 == 199) {
               boolean var69 = this.a(false, false, var4, dh.t[0], 0, 0, 2, 0, var3, 0, 0, dh.s[0]);
               if (!var69) {
                  this.a(false, false, var4, dh.t[0], 1, 1, 2, 0, var3, 0, 0, dh.s[0]);
               }

               this.le = super.C;
               this.me = super.D;
               this.oe = 2;
               this.ne = 0;
               this.hd.pIsaac(83);
               this.hd.d(0, var6);
               this.hd.p2(this.Ge + var4);
               this.hd.d(0, this.ih);
               this.hd.f(3, this.Fe + var3);
            }

            if (var5 == 55) {
               this.a(Ah, this.Bh);
               this.Bh = -1;
               this.yi = true;
            }

            if (var5 == 52) {
               this.Ig = 1;
               this.Jg = var3;
               this.Kg = var4;
               this.Lg = var6;
               this.Mg = String.valueOf(ObjType.a(var6).d);
               this.hh = 0;
               this.rh = true;
            } else {
               if (var5 == 1564) {
                  ObjType var71 = ObjType.a(var6);
                  String var72;
                  if (var71.c != null) {
                     var72 = new String(var71.c);
                  } else {
                     var72 = "It's a " + var71.d + ".";
                  }

                  this.a("", (byte)-123, var72, 0);
               }

               if (var5 == 408) {
                  ClientPlayer var73 = this.nd[var6];
                  if (var73 != null) {
                     this.a(false, false, var73.t[0], dh.t[0], 1, 1, 2, 0, var73.s[0], 0, 0, dh.s[0]);
                     this.le = super.C;
                     this.me = super.D;
                     this.oe = 2;
                     this.ne = 0;
                     this.hd.pIsaac(194);
                     this.hd.d(0, var6);
                  }
               }

               this.Ig = 0;
               this.hh = 0;
               this.rh = true;
            }
         }
      }
   }

   @ObfuscatedName("client.m(Z)V")
   public final void m(boolean arg0) {
      this.Ic = 0;

      for(int var2 = -1; var2 < this.vg + this.od; ++var2) {
         ClientEntity var3;
         if (var2 == -1) {
            var3 = dh;
         } else if (var2 < this.od) {
            var3 = this.nd[this.pd[var2]];
         } else {
            var3 = this.ug[this.wg[var2 - this.od]];
         }

         if (var3 != null && var3.b(0)) {
            if (var3 instanceof ClientNpc) {
               NpcType var4 = ((ClientNpc)var3).rb;
               if (var4.b != null) {
                  var4 = var4.b(false);
               }

               if (var4 == null) {
                  continue;
               }
            }

            if (var2 >= this.od) {
               NpcType var7 = ((ClientNpc)var3).rb;
               if (var7.r >= 0 && var7.r < this.tf.length) {
                  this.a(var3, false, var3.A + 15);
                  if (this.Bc > -1) {
                     this.tf[var7.r].b(this.Cc - 30, this.Bc - 12, -488);
                  }
               }

               if (this.Hh == 1 && this.wg[var2 - this.od] == this.ki && fk % 20 < 10) {
                  this.a(var3, false, var3.A + 15);
                  if (this.Bc > -1) {
                     this.Xc[0].b(this.Cc - 28, this.Bc - 12, -488);
                  }
               }
            } else {
               int var5 = 30;
               ClientPlayer var6 = (ClientPlayer)var3;
               if (var6.Db != -1 || var6.vb != -1) {
                  this.a(var3, false, var3.A + 15);
                  if (this.Bc > -1) {
                     if (var6.Db != -1) {
                        this.uj[var6.Db].b(this.Cc - var5, this.Bc - 12, -488);
                        var5 += 25;
                     }

                     if (var6.vb != -1) {
                        this.tf[var6.vb].b(this.Cc - var5, this.Bc - 12, -488);
                        var5 += 25;
                     }
                  }
               }

               if (var2 >= 0 && this.Hh == 10 && this.pd[var2] == this.Ng) {
                  this.a(var3, false, var3.A + 15);
                  if (this.Bc > -1) {
                     this.Xc[1].b(this.Cc - var5, this.Bc - 12, -488);
                  }
               }
            }

            if (var3.m != null && (var2 >= this.od || this.Xd == 0 || this.Xd == 3 || this.Xd == 1 && this.a((int)13292, (String)((ClientPlayer)var3).yb))) {
               this.a(var3, false, var3.A);
               if (this.Bc > -1 && this.Ic < this.Jc) {
                  this.Nc[this.Ic] = this.af.a(var3.m, (byte)-53) / 2;
                  this.Mc[this.Ic] = this.af.G;
                  this.Kc[this.Ic] = this.Bc;
                  this.Lc[this.Ic] = this.Cc;
                  this.Oc[this.Ic] = var3.p;
                  this.Pc[this.Ic] = var3.z;
                  this.Qc[this.Ic] = var3.o;
                  this.Rc[this.Ic++] = var3.m;
                  if (this.Pd == 0 && var3.z >= 1 && var3.z <= 3) {
                     this.Mc[this.Ic] += 10;
                     this.Lc[this.Ic] += 5;
                  }

                  if (this.Pd == 0 && var3.z == 4) {
                     this.Nc[this.Ic] = 60;
                  }

                  if (this.Pd == 0 && var3.z == 5) {
                     this.Mc[this.Ic] += 5;
                  }
               }
            }

            if (var3.B > fk) {
               this.a(var3, false, var3.A + 15);
               if (this.Bc > -1) {
                  int var8 = var3.C * 30 / var3.D;
                  if (var8 > 30) {
                     var8 = 30;
                  }

                  Pix2D.a(5, this.Cc - 3, 65280, (byte)-24, var8, this.Bc - 15);
                  Pix2D.a(5, this.Cc - 3, 16711680, (byte)-24, 30 - var8, this.Bc - 15 + var8);
               }
            }

            for(int var9 = 0; var9 < 4; ++var9) {
               if (var3.mb[var9] > fk) {
                  this.a(var3, false, var3.A / 2);
                  if (this.Bc > -1) {
                     if (var9 == 1) {
                        this.Cc -= 20;
                     }

                     if (var9 == 2) {
                        this.Bc -= 15;
                        this.Cc -= 10;
                     }

                     if (var9 == 3) {
                        this.Bc += 15;
                        this.Cc -= 10;
                     }

                     this.sh[var3.lb[var9]].b(this.Cc - 12, this.Bc - 12, -488);
                     this.Ye.a(this.Bc, 452, this.Cc + 4, 0, String.valueOf(var3.kb[var9]));
                     this.Ye.a(this.Bc - 1, 452, this.Cc + 3, 16777215, String.valueOf(var3.kb[var9]));
                  }
               }
            }
         }
      }

      for(int var10 = 0; var10 < this.Ic; ++var10) {
         int var11 = this.Kc[var10];
         int var12 = this.Lc[var10];
         int var13 = this.Nc[var10];
         int var14 = this.Mc[var10];
         boolean var15 = true;

         while(var15) {
            var15 = false;

            for(int var16 = 0; var16 < var10; ++var16) {
               if (var12 + 2 > this.Lc[var16] - this.Mc[var16] && var12 - var14 < this.Lc[var16] + 2 && var11 - var13 < this.Nc[var16] + this.Kc[var16] && var11 + var13 > this.Kc[var16] - this.Nc[var16] && this.Lc[var16] - this.Mc[var16] < var12) {
                  var12 = this.Lc[var16] - this.Mc[var16];
                  var15 = true;
               }
            }
         }

         this.Bc = this.Kc[var10];
         this.Cc = this.Lc[var10] = var12;
         String var17 = this.Rc[var10];
         if (this.Pd == 0) {
            int var18 = 16776960;
            if (this.Oc[var10] < 6) {
               var18 = this.P[this.Oc[var10]];
            }

            if (this.Oc[var10] == 6) {
               var18 = this.Ag % 20 < 10 ? 16711680 : 16776960;
            }

            if (this.Oc[var10] == 7) {
               var18 = this.Ag % 20 < 10 ? 255 : 65535;
            }

            if (this.Oc[var10] == 8) {
               var18 = this.Ag % 20 < 10 ? 45056 : 8454016;
            }

            if (this.Oc[var10] == 9) {
               int var19 = 150 - this.Qc[var10];
               if (var19 < 50) {
                  var18 = var19 * 1280 + 16711680;
               } else if (var19 < 100) {
                  var18 = 16776960 - (var19 - 50) * 327680;
               } else if (var19 < 150) {
                  var18 = (var19 - 100) * 5 + 65280;
               }
            }

            if (this.Oc[var10] == 10) {
               int var20 = 150 - this.Qc[var10];
               if (var20 < 50) {
                  var18 = var20 * 5 + 16711680;
               } else if (var20 < 100) {
                  var18 = 16711935 - (var20 - 50) * 327680;
               } else if (var20 < 150) {
                  var18 = (var20 - 100) * 327680 + 255 - (var20 - 100) * 5;
               }
            }

            if (this.Oc[var10] == 11) {
               int var21 = 150 - this.Qc[var10];
               if (var21 < 50) {
                  var18 = 16777215 - var21 * 327685;
               } else if (var21 < 100) {
                  var18 = (var21 - 50) * 327685 + 65280;
               } else if (var21 < 150) {
                  var18 = 16777215 - (var21 - 100) * 327680;
               }
            }

            if (this.Pc[var10] == 0) {
               this.af.a(this.Bc, 452, this.Cc + 1, 0, var17);
               this.af.a(this.Bc, 452, this.Cc, var18, var17);
            }

            if (this.Pc[var10] == 1) {
               this.af.a(this.Cc + 1, (byte)4, (int)this.Ag, var17, this.Bc, 0);
               this.af.a(this.Cc, (byte)4, (int)this.Ag, var17, this.Bc, var18);
            }

            if (this.Pc[var10] == 2) {
               this.af.a(this.Cc + 1, (int)0, (byte)1, var17, this.Bc, this.Ag);
               this.af.a(this.Cc, (int)var18, (byte)1, var17, this.Bc, this.Ag);
            }

            if (this.Pc[var10] == 3) {
               this.af.a(-601, var17, 0, this.Bc, this.Cc + 1, 150 - this.Qc[var10], this.Ag);
               this.af.a(-601, var17, var18, this.Bc, this.Cc, 150 - this.Qc[var10], this.Ag);
            }

            if (this.Pc[var10] == 4) {
               int var22 = this.af.a(var17, (byte)-53);
               int var23 = (150 - this.Qc[var10]) * (var22 + 100) / 150;
               Pix2D.a(0, this.Bc - 50, 334, this.Bc + 50, true);
               this.af.b(2245, this.Bc + 50 - var23, 0, this.Cc + 1, var17);
               this.af.b(2245, this.Bc + 50 - var23, var18, this.Cc, var17);
               Pix2D.a((byte)82);
            }

            if (this.Pc[var10] == 5) {
               int var24 = 150 - this.Qc[var10];
               int var25 = 0;
               if (var24 < 25) {
                  var25 = var24 - 25;
               } else if (var24 > 125) {
                  var25 = var24 - 125;
               }

               Pix2D.a(this.Cc - this.af.G - 1, 0, this.Cc + 5, 512, true);
               this.af.a(this.Bc, 452, this.Cc + 1 + var25, 0, var17);
               this.af.a(this.Bc, 452, this.Cc + var25, var18, var17);
               Pix2D.a((byte)82);
            }
         } else {
            this.af.a(this.Bc, 452, this.Cc + 1, 0, var17);
            this.af.a(this.Bc, 452, this.Cc, 16776960, var17);
         }
      }

      if (arg0) {
         this.rb = -1;
      }
   }

   @ObfuscatedName("client.F(I)V")
   public final void F(int arg0) {
      while(arg0 >= 0) {
      }

      if (this.Vg == null) {
         this.H(28614);
         super.o = null;
         this.Ih = null;
         this.Jh = null;
         this.Kh = null;
         this.Lh = null;
         this.Mh = null;
         this.Nh = null;
         this.Oh = null;
         this.Ph = null;
         this.Qh = null;
         this.Vg = new PixMap(96, (byte)-12, this.d((int)-756), 479);
         this.Tg = new PixMap(156, (byte)-12, this.d((int)-756), 172);
         Pix2D.a((int)4);
         this.wh.a(0, 0, -488);
         this.Sg = new PixMap(261, (byte)-12, this.d((int)-756), 190);
         this.Ug = new PixMap(334, (byte)-12, this.d((int)-756), 512);
         Pix2D.a((int)4);
         this.Wf = new PixMap(50, (byte)-12, this.d((int)-756), 496);
         this.Xf = new PixMap(37, (byte)-12, this.d((int)-756), 269);
         this.Yf = new PixMap(45, (byte)-12, this.d((int)-756), 249);
         this.Le = true;
         this.Ug.a(false);
         Pix3D.K = this.Td;
      }
   }

   @ObfuscatedName("client.G(I)V")
   public final void G(int arg0) {
      Graphics var2 = this.d((int)-756).getGraphics();
      var2.setColor(Color.black);
      int var3 = 68 / arg0;
      var2.fillRect(0, 0, 765, 503);
      this.a((byte)103, 1);
      if (this.pj) {
         this.Bi = false;
         var2.setFont(new Font("Helvetica", 1, 16));
         var2.setColor(Color.yellow);
         byte var4 = 35;
         var2.drawString("Sorry, an error has occured whilst loading RuneScape", 30, var4);
         int var6 = var4 + 50;
         var2.setColor(Color.white);
         var2.drawString("To fix this try the following (in order):", 30, var6);
         int var7 = var6 + 50;
         var2.setColor(Color.white);
         var2.setFont(new Font("Helvetica", 1, 12));
         var2.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, var7);
         int var8 = var7 + 30;
         var2.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, var8);
         int var9 = var8 + 30;
         var2.drawString("3: Try using a different game-world", 30, var9);
         int var11 = var9 + 30;
         var2.drawString("4: Try rebooting your computer", 30, var11);
         int var13 = var11 + 30;
         var2.drawString("5: Try selecting a different version of Java from the play-game menu", 30, var13);
      }

      if (this.Lf) {
         this.Bi = false;
         var2.setFont(new Font("Helvetica", 1, 20));
         var2.setColor(Color.white);
         var2.drawString("Error - unable to load game!", 50, 50);
         var2.drawString("To play RuneScape make sure you play from", 50, 100);
         var2.drawString("http://www.runescape.com", 50, 150);
      }

      if (this.he) {
         this.Bi = false;
         var2.setColor(Color.yellow);
         byte var5 = 35;
         var2.drawString("Error a copy of RuneScape already appears to be loaded", 30, var5);
         int var10 = var5 + 50;
         var2.setColor(Color.white);
         var2.drawString("To fix this try the following (in order):", 30, var10);
         int var12 = var10 + 50;
         var2.setColor(Color.white);
         var2.setFont(new Font("Helvetica", 1, 12));
         var2.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, var12);
         int var14 = var12 + 30;
         var2.drawString("2: Try rebooting your computer, and reloading", 30, var14);
         int var15 = var14 + 30;
      }
   }

   @ObfuscatedName("client.n(Z)V")
   public final void n(boolean arg0) {
      try {
         if (this.pe != null) {
            this.pe.a();
         }
      } catch (Exception var3) {
      }

      this.pe = null;
      this.zg = false;
      this.ji = 0;
      this.Gf = "";
      this.Hf = "";
      this.k((int)383);
      this.zg &= arg0;
      this.ah.a((byte)7);

      for(int var2 = 0; var2 < 4; ++var2) {
         this.Si[var2].a();
      }

      System.gc();
      this.g(false);
      this.hk = -1;
      this.cj = -1;
      this.qg = 0;
   }

   @ObfuscatedName("client.a(ILjava/lang/String;Ljava/lang/String;)V")
   public final void a(int arg0, String arg1, String arg2) {
      if (arg0 < 0) {
         if (this.Ug != null) {
            this.Ug.a(false);
            Pix3D.K = this.Td;
            int var4 = 151;
            if (arg1 != null) {
               var4 -= 7;
            }

            this.Ze.a(257, 452, var4, 0, arg2);
            this.Ze.a(256, 452, var4 - 1, 16777215, arg2);
            var4 += 15;
            if (arg1 != null) {
               this.Ze.a(257, 452, var4, 0, arg1);
               this.Ze.a(256, 452, var4 - 1, 16777215, arg1);
            }

            this.Ug.a(4, 4, super.n, this.of);
         } else if (super.o != null) {
            super.o.a(false);
            Pix3D.K = this.Ud;
            int var5 = 251;
            short var6 = 300;
            byte var7 = 50;
            Pix2D.a(var7, var5 - 5 - var7 / 2, 0, (byte)-24, var6, 383 - var6 / 2);
            Pix2D.a(0, var5 - 5 - var7 / 2, var7, (int)16777215, 383 - var6 / 2, var6);
            if (arg1 != null) {
               var5 -= 7;
            }

            this.Ze.a(383, 452, var5, 0, arg2);
            this.Ze.a(382, 452, var5 - 1, 16777215, arg2);
            var5 += 15;
            if (arg1 != null) {
               this.Ze.a(383, 452, var5, 0, arg1);
               this.Ze.a(382, 452, var5 - 1, 16777215, arg1);
            }

            super.o.a(0, 0, super.n, this.of);
         }
      }
   }

   @ObfuscatedName("client.b(IB)Z")
   public final boolean b(int arg0, byte arg1) {
      if (arg0 < 0) {
         return false;
      } else {
         int var3 = this.yd[arg0];
         if (arg1 != 97) {
            throw new NullPointerException();
         } else {
            if (var3 >= 2000) {
               var3 -= 2000;
            }

            return var3 == 762;
         }
      }
   }

   @ObfuscatedName("client.o(Z)V")
   public final void o(boolean arg0) {
      if (!arg0) {
         this.Ve = this.Ub.nextInt();
      }

      if (this.Hh == 2) {
         this.c((this.R - this.Fe << 7) + this.U, this.T * 2, (this.S - this.Ge << 7) + this.V, -214);
         if (this.Bc > -1 && fk % 20 < 10) {
            this.Xc[0].b(this.Cc - 28, this.Bc - 12, -488);
         }
      }
   }

   @ObfuscatedName("client.c(I)V")
   public final void c(int arg0) {
      if (!this.he && !this.pj && !this.Lf) {
         ++Pj;
         if (arg0 <= 0) {
            this.Vd = -382;
         }

         if (!this.zg) {
            this.a((byte)-50, false);
         } else {
            this.p(7);
         }

         this.If = 0;
      } else {
         this.G(281);
      }
   }

   @ObfuscatedName("client.p(Z)V")
   public final void p(boolean arg0) {
      if (arg0) {
         this.hd.p1((int)23);
      }

      int var2 = this.Lj;
      int var3 = this.Mj;
      int var4 = this.Nj;
      int var5 = this.Oj;
      int var6 = 6116423;
      Pix2D.a(var5, var3, var6, (byte)-24, var4, var2);
      Pix2D.a(16, var3 + 1, 0, (byte)-24, var4 - 2, var2 + 1);
      Pix2D.a(0, var3 + 18, var5 - 19, (int)0, var2 + 1, var4 - 2);
      this.af.b(2245, var2 + 3, var6, var3 + 14, "Choose Option");
      int var7 = super.v;
      int var8 = super.w;
      if (this.Kj == 0) {
         var7 -= 4;
         var8 -= 4;
      }

      if (this.Kj == 1) {
         var7 -= 553;
         var8 -= 205;
      }

      if (this.Kj == 2) {
         var7 -= 17;
         var8 -= 357;
      }

      for(int var9 = 0; var9 < this.th; ++var9) {
         int var10 = (this.th - 1 - var9) * 15 + var3 + 31;
         int var11 = 16777215;
         if (var7 > var2 && var7 < var2 + var4 && var8 > var10 - 13 && var8 < var10 + 3) {
            var11 = 16776960;
         }

         this.af.a(var11, var2 + 3, var10, true, this.uh[var9], -39629);
      }

   }

   @ObfuscatedName("client.a(IILEWIXBTLV;)I")
   public final int a(int arg0, int arg1, Component arg2) {
      if (arg0 != 3) {
         return this.gi;
      } else if (arg2.y != null && arg1 < arg2.y.length) {
         try {
            int[] var4 = arg2.y[arg1];
            int var5 = 0;
            int var6 = 0;
            byte var7 = 0;

            while(true) {
               int var8 = var4[var6++];
               int var9 = 0;
               byte var10 = 0;
               if (var8 == 0) {
                  return var5;
               }

               if (var8 == 1) {
                  var9 = this.ue[var4[var6++]];
               }

               if (var8 == 2) {
                  var9 = this.Te[var4[var6++]];
               }

               if (var8 == 3) {
                  var9 = this.Q[var4[var6++]];
               }

               if (var8 == 4) {
                  Component var11 = Component.a(var4[var6++]);
                  int var12 = var4[var6++];
                  if (var12 >= 0 && var12 < ObjType.j && (!ObjType.a(var12).Z || uc)) {
                     for(int var13 = 0; var13 < var11.hb.length; ++var13) {
                        if (var12 + 1 == var11.hb[var13]) {
                           var9 += var11.o[var13];
                        }
                     }
                  }
               }

               if (var8 == 5) {
                  var9 = this.Ee[var4[var6++]];
               }

               if (var8 == 6) {
                  var9 = Vc[this.Te[var4[var6++]] - 1];
               }

               if (var8 == 7) {
                  var9 = this.Ee[var4[var6++]] * 100 / 46875;
               }

               if (var8 == 8) {
                  var9 = dh.Ab;
               }

               if (var8 == 9) {
                  for(int var14 = 0; var14 < Stats.a; ++var14) {
                     if (Stats.c[var14]) {
                        var9 += this.Te[var14];
                     }
                  }
               }

               if (var8 == 10) {
                  Component var15 = Component.a(var4[var6++]);
                  int var16 = var4[var6++] + 1;
                  if (var16 >= 0 && var16 < ObjType.j && (!ObjType.a(var16).Z || uc)) {
                     for(int var17 = 0; var17 < var15.hb.length; ++var17) {
                        if (var15.hb[var17] == var16) {
                           var9 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if (var8 == 11) {
                  var9 = this.ek;
               }

               if (var8 == 12) {
                  var9 = this.ve;
               }

               if (var8 == 13) {
                  int var18 = this.Ee[var4[var6++]];
                  int var19 = var4[var6++];
                  var9 = (var18 & 1 << var19) != 0 ? 1 : 0;
               }

               if (var8 == 14) {
                  int var20 = var4[var6++];
                  VarbitType var21 = VarbitType.c[var20];
                  int var22 = var21.e;
                  int var23 = var21.f;
                  int var24 = var21.g;
                  int var25 = Yh[var24 - var23];
                  var9 = this.Ee[var22] >> var23 & var25;
               }

               if (var8 == 15) {
                  var10 = 1;
               }

               if (var8 == 16) {
                  var10 = 2;
               }

               if (var8 == 17) {
                  var10 = 3;
               }

               if (var8 == 18) {
                  var9 = (dh.Q >> 7) + this.Fe;
               }

               if (var8 == 19) {
                  var9 = (dh.R >> 7) + this.Ge;
               }

               if (var8 == 20) {
                  var9 = var4[var6++];
               }

               if (var10 == 0) {
                  if (var7 == 0) {
                     var5 += var9;
                  }

                  if (var7 == 1) {
                     var5 -= var9;
                  }

                  if (var7 == 2 && var9 != 0) {
                     var5 /= var9;
                  }

                  if (var7 == 3) {
                     var5 *= var9;
                  }

                  var7 = 0;
               } else {
                  var7 = var10;
               }
            }
         } catch (Exception var26) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("client.a(IZLEPQDEJTO;I)V")
   public final void a(int arg0, boolean arg1, Pix24 arg2, int arg3) {
      if (arg2 != null) {
         int var5 = this.lc + this.Ki & 2047;
         int var6 = arg0 * arg0 + arg3 * arg3;
         if (var6 <= 6400) {
            int var7 = Model.Ib[var5];
            int var8 = Model.Jb[var5];
            int var9 = var7 * 256 / (this.ri + 256);
            int var10 = var8 * 256 / (this.ri + 256);
            if (!arg1) {
               this.rb = this.yh.g1();
            }

            int var11 = arg0 * var9 + arg3 * var10 >> 16;
            int var12 = arg0 * var10 - arg3 * var9 >> 16;
            if (var6 > 2500) {
               arg2.a(this.wh, 83 - var12 - arg2.O / 2 - 4, -49993, var11 + 94 - arg2.N / 2 + 4);
            } else {
               arg2.b(83 - var12 - arg2.O / 2 - 4, var11 + 94 - arg2.N / 2 + 4, -488);
            }
         }
      }
   }

   @ObfuscatedName("client.a(BZ)V")
   public final void a(byte arg0, boolean arg1) {
      this.n(-188);
      this.Kh.a(false);
      this.yj.a(0, 0, -488);
      short var3 = 360;
      short var4 = 200;
      if (arg0 != -50) {
         for(int var5 = 1; var5 > 0; ++var5) {
         }
      }

      if (this.ji == 0) {
         int var6 = var4 / 2 + 80;
         this.Ye.a(true, this.Ve, 7711145, var6, var3 / 2, this.xj.o);
         int var7 = var4 / 2 - 20;
         this.af.a(true, this.Ve, 16776960, var7, var3 / 2, "Welcome to RuneScape");
         int var18 = var7 + 30;
         int var8 = var3 / 2 - 80;
         int var9 = var4 / 2 + 20;
         this.zj.a(var9 - 20, var8 - 73, -488);
         this.af.a(true, this.Ve, 16777215, var9 + 5, var8, "New User");
         int var10 = var3 / 2 + 80;
         this.zj.a(var9 - 20, var10 - 73, -488);
         this.af.a(true, this.Ve, 16777215, var9 + 5, var10, "Existing User");
      }

      if (this.ji == 2) {
         int var11 = var4 / 2 - 40;
         if (this.ad.length() > 0) {
            this.af.a(true, this.Ve, 16776960, var11 - 15, var3 / 2, this.ad);
            this.af.a(true, this.Ve, 16776960, var11, var3 / 2, this.bd);
            var11 += 30;
         } else {
            this.af.a(true, this.Ve, 16776960, var11 - 7, var3 / 2, this.bd);
            var11 += 30;
         }

         this.af.a(16777215, var3 / 2 - 90, var11, true, "Username: " + this.Gf + (this.ud == 0 & fk % 40 < 20 ? "@yel@|" : ""), -39629);
         var11 += 15;
         this.af.a(16777215, var3 / 2 - 88, var11, true, "Password: " + JString.b(2934, this.Hf) + (this.ud == 1 & fk % 40 < 20 ? "@yel@|" : ""), -39629);
         var11 += 15;
         if (!arg1) {
            int var12 = var3 / 2 - 80;
            int var13 = var4 / 2 + 50;
            this.zj.a(var13 - 20, var12 - 73, -488);
            this.af.a(true, this.Ve, 16777215, var13 + 5, var12, "Login");
            int var14 = var3 / 2 + 80;
            this.zj.a(var13 - 20, var14 - 73, -488);
            this.af.a(true, this.Ve, 16777215, var13 + 5, var14, "Cancel");
         }
      }

      if (this.ji == 3) {
         this.af.a(true, this.Ve, 16776960, var4 / 2 - 60, var3 / 2, "Create a free account");
         int var15 = var4 / 2 - 35;
         this.af.a(true, this.Ve, 16777215, var15, var3 / 2, "To create a new account you need to");
         int var19 = var15 + 15;
         this.af.a(true, this.Ve, 16777215, var19, var3 / 2, "go back to the main RuneScape webpage");
         int var20 = var19 + 15;
         this.af.a(true, this.Ve, 16777215, var20, var3 / 2, "and choose the 'create account'");
         int var21 = var20 + 15;
         this.af.a(true, this.Ve, 16777215, var21, var3 / 2, "button near the top of that page.");
         int var22 = var21 + 15;
         int var16 = var3 / 2;
         int var17 = var4 / 2 + 50;
         this.zj.a(var17 - 20, var16 - 73, -488);
         this.af.a(true, this.Ve, 16777215, var17 + 5, var16, "Cancel");
      }

      this.Kh.a(171, 202, super.n, this.of);
      if (this.Le) {
         this.Le = false;
         this.Ih.a(0, 128, super.n, this.of);
         this.Jh.a(371, 202, super.n, this.of);
         this.Nh.a(265, 0, super.n, this.of);
         this.Oh.a(265, 562, super.n, this.of);
         this.Ph.a(171, 128, super.n, this.of);
         this.Qh.a(171, 562, super.n, this.of);
      }
   }

   @ObfuscatedName("client.a(LMFMVIYHT;IZ)V")
   public final void a(Packet arg0, int arg1, boolean arg2) {
      if (arg2) {
         this.Cg = 287;
      }

      while(arg0.bitPos + 21 < arg1 * 8) {
         int var4 = arg0.gBit(14);
         if (var4 == 16383) {
            break;
         }

         if (this.ug[var4] == null) {
            this.ug[var4] = new ClientNpc();
         }

         ClientNpc var5 = this.ug[var4];
         this.wg[this.vg++] = var4;
         var5.r = fk;
         int var6 = arg0.gBit(1);
         if (var6 == 1) {
            this.rd[this.qd++] = var4;
         }

         int var7 = arg0.gBit(5);
         if (var7 > 15) {
            var7 -= 32;
         }

         int var8 = arg0.gBit(5);
         if (var8 > 15) {
            var8 -= 32;
         }

         int var9 = arg0.gBit(1);
         var5.rb = NpcType.c(arg0.gBit(13));
         var5.H = var5.rb.v;
         var5.G = var5.rb.E;
         var5.Z = var5.rb.y;
         var5.ab = var5.rb.w;
         var5.bb = var5.rb.u;
         var5.cb = var5.rb.m;
         var5.ob = var5.rb.a;
         var5.a(dh.t[0] + var7, (byte)5, var9 == 1, dh.s[0] + var8);
      }

      arg0.bytes();
   }

   @ObfuscatedName("client.b(LMFMVIYHT;II)V")
   public final void b(Packet arg0, int arg1, int arg2) {
      if (arg1 != 0) {
         this.dk = null;
      }

      if (arg2 == 203) {
         int var4 = arg0.g2();
         int var5 = arg0.g1();
         int var6 = var5 >> 2;
         int var7 = var5 & 3;
         int var8 = this.xe[var6];
         byte var9 = arg0.l(0);
         int var10 = arg0.h(0);
         int var11 = (var10 >> 4 & 7) + this.Gd;
         int var12 = (var10 & 7) + this.Hd;
         byte var13 = arg0.k(this.Bf);
         int var14 = arg0.b((byte)9);
         int var15 = arg0.n(-125);
         byte var16 = arg0.g1b();
         byte var17 = arg0.k(this.Bf);
         int var18 = arg0.g2();
         ClientPlayer var19;
         if (this.ed == var15) {
            var19 = dh;
         } else {
            var19 = this.nd[var15];
         }

         if (var19 != null) {
            LocType var20 = LocType.a(var4);
            int var21 = this.Mb[this.Ff][var11][var12];
            int var22 = this.Mb[this.Ff][var11 + 1][var12];
            int var23 = this.Mb[this.Ff][var11 + 1][var12 + 1];
            int var24 = this.Mb[this.Ff][var11][var12 + 1];
            Model var25 = var20.a(var6, var7, var21, var22, var23, var24, -1);
            if (var25 != null) {
               this.a(true, this.Ff, var11, 0, var14 + 1, 0, -1, var18 + 1, var8, var12);
               var19.Lb = fk + var18;
               var19.Mb = fk + var14;
               var19.tb = var25;
               int var26 = var20.R;
               int var27 = var20.r;
               if (var7 == 1 || var7 == 3) {
                  var26 = var20.r;
                  var27 = var20.R;
               }

               var19.qb = var11 * 128 + var26 * 64;
               var19.sb = var12 * 128 + var27 * 64;
               var19.rb = this.a(var19.sb, var19.qb, (byte)9, this.Ff);
               if (var13 > var9) {
                  byte var28 = var13;
                  var13 = var9;
                  var9 = var28;
               }

               if (var17 > var16) {
                  byte var29 = var17;
                  var17 = var16;
                  var16 = var29;
               }

               var19.Pb = var11 + var13;
               var19.Rb = var9 + var11;
               var19.Qb = var12 + var17;
               var19.Sb = var12 + var16;
            }
         }
      }

      if (arg2 == 106) {
         int var30 = arg0.h(0);
         int var31 = (var30 >> 4 & 7) + this.Gd;
         int var32 = (var30 & 7) + this.Hd;
         int var33 = arg0.o(-600);
         int var34 = arg0.b((byte)9);
         int var35 = arg0.b((byte)9);
         if (var31 >= 0 && var32 >= 0 && var31 < 104 && var32 < 104 && this.ed != var35) {
            ClientObj var36 = new ClientObj();
            var36.m = var34;
            var36.o = var33;
            if (this.dk[this.Ff][var31][var32] == null) {
               this.dk[this.Ff][var31][var32] = new LinkList();
            }

            this.dk[this.Ff][var31][var32].a(var36);
            this.b(var31, var32);
         }

      } else if (arg2 == 142) {
         int var37 = arg0.g2();
         int var38 = arg0.h(0);
         int var39 = var38 >> 2;
         int var40 = var38 & 3;
         int var41 = this.xe[var39];
         int var42 = arg0.g1();
         int var43 = (var42 >> 4 & 7) + this.Gd;
         int var44 = (var42 & 7) + this.Hd;
         if (var43 >= 0 && var44 >= 0 && var43 < 103 && var44 < 103) {
            int var45 = this.Mb[this.Ff][var43][var44];
            int var46 = this.Mb[this.Ff][var43 + 1][var44];
            int var47 = this.Mb[this.Ff][var43 + 1][var44 + 1];
            int var48 = this.Mb[this.Ff][var43][var44 + 1];
            if (var41 == 0) {
               Wall var49 = this.ah.c(this.Ff, 17734, var43, var44);
               if (var49 != null) {
                  int var50 = var49.h >> 14 & 32767;
                  if (var39 == 2) {
                     var49.f = new ClientLocAnim(var37, var47, var48, var46, 2, (byte)3, var50, false, var45, var40 + 4);
                     var49.g = new ClientLocAnim(var37, var47, var48, var46, 2, (byte)3, var50, false, var45, var40 + 1 & 3);
                  } else {
                     var49.f = new ClientLocAnim(var37, var47, var48, var46, var39, (byte)3, var50, false, var45, var40);
                  }
               }
            }

            if (var41 == 1) {
               Decor var51 = this.ah.b(this.Ff, var44, var43, false);
               if (var51 != null) {
                  var51.f = new ClientLocAnim(var37, var47, var48, var46, 4, (byte)3, var51.g >> 14 & 32767, false, var45, 0);
               }
            }

            if (var41 == 2) {
               Loc var52 = this.ah.a((int)var43, (byte)32, var44, this.Ff);
               if (var39 == 11) {
                  var39 = 10;
               }

               if (var52 != null) {
                  var52.e = new ClientLocAnim(var37, var47, var48, var46, var39, (byte)3, var52.m >> 14 & 32767, false, var45, var40);
               }
            }

            if (var41 == 3) {
               GroundDecor var53 = this.ah.d(this.Ff, var44, 0, var43);
               if (var53 != null) {
                  var53.d = new ClientLocAnim(var37, var47, var48, var46, 22, (byte)3, var53.e >> 14 & 32767, false, var45, var40);
               }
            }
         }

      } else if (arg2 == 107) {
         int var54 = arg0.g2();
         int var55 = arg0.i(-34545);
         int var56 = (var55 >> 4 & 7) + this.Gd;
         int var57 = (var55 & 7) + this.Hd;
         int var58 = arg0.b((byte)9);
         if (var56 >= 0 && var57 >= 0 && var56 < 104 && var57 < 104) {
            ClientObj var59 = new ClientObj();
            var59.m = var54;
            var59.o = var58;
            if (this.dk[this.Ff][var56][var57] == null) {
               this.dk[this.Ff][var56][var57] = new LinkList();
            }

            this.dk[this.Ff][var56][var57].a(var59);
            this.b(var56, var57);
         }

      } else if (arg2 == 121) {
         int var60 = arg0.g1();
         int var61 = (var60 >> 4 & 7) + this.Gd;
         int var62 = (var60 & 7) + this.Hd;
         int var63 = arg0.g2();
         int var64 = arg0.g2();
         int var65 = arg0.g2();
         if (var61 >= 0 && var62 >= 0 && var61 < 104 && var62 < 104) {
            LinkList var66 = this.dk[this.Ff][var61][var62];
            if (var66 != null) {
               for(ClientObj var67 = (ClientObj)var66.b(); var67 != null; var67 = (ClientObj)var66.a(1)) {
                  if ((var63 & 32767) == var67.m && var67.o == var64) {
                     var67.o = var65;
                     break;
                  }
               }

               this.b(var61, var62);
            }
         }

      } else if (arg2 == 181) {
         int var68 = arg0.g1();
         int var69 = (var68 >> 4 & 7) + this.Gd;
         int var70 = (var68 & 7) + this.Hd;
         int var71 = var69 + arg0.g1b();
         int var72 = var70 + arg0.g1b();
         int var73 = arg0.gb2();
         int var74 = arg0.g2();
         int var75 = arg0.g1() * 4;
         int var76 = arg0.g1() * 4;
         int var77 = arg0.g2();
         int var78 = arg0.g2();
         int var79 = arg0.g1();
         int var80 = arg0.g1();
         if (var69 >= 0 && var70 >= 0 && var69 < 104 && var70 < 104 && var71 >= 0 && var72 >= 0 && var71 < 104 && var72 < 104 && var74 != 65535) {
            int var81 = var69 * 128 + 64;
            int var82 = var70 * 128 + 64;
            int var83 = var71 * 128 + 64;
            int var84 = var72 * 128 + 64;
            ClientProj var85 = new ClientProj(this.Ff, var76, var80, var82, var74, fk + var78, var79, var73, (byte)-41, this.a(var82, var81, (byte)9, this.Ff) - var75, var81, fk + var77);
            var85.a(var83, var84, this.a(var84, var83, (byte)9, this.Ff) - var76, fk + var77, 0);
            this.oj.a(var85);
         }

      } else {
         if (arg2 == 41) {
            int var86 = arg0.g1();
            int var87 = (var86 >> 4 & 7) + this.Gd;
            int var88 = (var86 & 7) + this.Hd;
            int var89 = arg0.g2();
            int var90 = arg0.g1();
            int var91 = var90 >> 4 & 15;
            int var92 = var90 & 7;
            if (dh.s[0] >= var87 - var91 && dh.s[0] <= var87 + var91 && dh.t[0] >= var88 - var91 && dh.t[0] <= var88 + var91 && this.Hj && !vc && this.Ae < 50) {
               this.Ef[this.Ae] = var89;
               this.bk[this.Ae] = var92;
               this.Ri[this.Ae] = Wave.f[var89];
               ++this.Ae;
            }
         }

         if (arg2 == 59) {
            int var93 = arg0.g1();
            int var94 = (var93 >> 4 & 7) + this.Gd;
            int var95 = (var93 & 7) + this.Hd;
            int var96 = arg0.g2();
            int var97 = arg0.g1();
            int var98 = arg0.g2();
            if (var94 >= 0 && var95 >= 0 && var94 < 104 && var95 < 104) {
               int var99 = var94 * 128 + 64;
               int var100 = var95 * 128 + 64;
               MapSpotAnim var101 = new MapSpotAnim(var99, this.Ff, this.a(var100, var99, (byte)9, this.Ff) - var97, var98, var96, fk, var100, 10709);
               this.Uh.a(var101);
            }

         } else if (arg2 == 152) {
            int var102 = arg0.i(-34545);
            int var103 = var102 >> 2;
            int var104 = var102 & 3;
            int var105 = this.xe[var103];
            int var106 = arg0.o(-600);
            int var107 = arg0.h(0);
            int var108 = (var107 >> 4 & 7) + this.Gd;
            int var109 = (var107 & 7) + this.Hd;
            if (var108 >= 0 && var109 >= 0 && var108 < 104 && var109 < 104) {
               this.a(true, this.Ff, var108, var104, -1, var103, var106, 0, var105, var109);
            }

         } else if (arg2 != 208) {
            if (arg2 == 88) {
               int var116 = arg0.j(this.ui);
               int var117 = (var116 >> 4 & 7) + this.Gd;
               int var118 = (var116 & 7) + this.Hd;
               int var119 = arg0.j(this.ui);
               int var120 = var119 >> 2;
               int var121 = var119 & 3;
               int var122 = this.xe[var120];
               if (var117 >= 0 && var118 >= 0 && var117 < 104 && var118 < 104) {
                  this.a(true, this.Ff, var117, var121, -1, var120, -1, 0, var122, var118);
               }

            }
         } else {
            int var110 = arg0.b((byte)9);
            int var111 = arg0.h(0);
            int var112 = (var111 >> 4 & 7) + this.Gd;
            int var113 = (var111 & 7) + this.Hd;
            if (var112 >= 0 && var113 >= 0 && var112 < 104 && var113 < 104) {
               LinkList var114 = this.dk[this.Ff][var112][var113];
               if (var114 != null) {
                  for(ClientObj var115 = (ClientObj)var114.b(); var115 != null; var115 = (ClientObj)var114.a(1)) {
                     if ((var110 & 32767) == var115.m) {
                        var115.a();
                        break;
                     }
                  }

                  if (var114.b() == null) {
                     this.dk[this.Ff][var112][var113] = null;
                  }

                  this.b(var112, var113);
               }
            }

         }
      }
   }

   @ObfuscatedName("client.k(B)V")
   public final void k(byte arg0) {
      this.Sg.a(false);
      Pix3D.K = this.Sd;
      this.vh.a(0, 0, -488);
      if (this.Df != -1) {
         this.a(0, 0, Component.a(this.Df), 0, 8);
      } else if (this.vf[this.rj] != -1) {
         this.a(0, 0, Component.a(this.vf[this.rj]), 0, 8);
      }

      if (this.ef && this.Kj == 1) {
         this.p(false);
      }

      this.Sg.a(205, 553, super.n, this.of);
      this.Ug.a(false);
      Pix3D.K = this.Td;
      if (arg0 == 7) {
         ;
      }
   }

   @ObfuscatedName("client.i(II)Ljava/lang/String;")
   public static final String i(int arg0, int arg1) {
      String var2 = String.valueOf(arg1);
      if (arg0 != 0) {
         throw new NullPointerException();
      } else {
         for(int var3 = var2.length() - 3; var3 > 0; var3 -= 3) {
            var2 = var2.substring(0, var3) + "," + var2.substring(var3);
         }

         if (var2.length() > 8) {
            var2 = "@gre@" + var2.substring(0, var2.length() - 8) + " million @whi@(" + var2 + ")";
         } else if (var2.length() > 4) {
            var2 = "@cya@" + var2.substring(0, var2.length() - 4) + "K @whi@(" + var2 + ")";
         }

         return " " + var2;
      }
   }

   @ObfuscatedName("client.a(LLRUWCBNN;ZI)V")
   public final void a(ClientEntity arg0, boolean arg1, int arg2) {
      this.c(arg0.Q, arg2, arg0.R, -214);
      if (!arg1) {
         ;
      }
   }

   @ObfuscatedName("client.c(IIII)V")
   public final void c(int arg0, int arg1, int arg2, int arg3) {
      if (arg0 >= 128 && arg2 >= 128 && arg0 <= 13056 && arg2 <= 13056) {
         int var5 = this.a(arg2, arg0, (byte)9, this.Ff) - arg1;
         int var6 = arg0 - this.ai;
         int var7 = var5 - this.bi;
         int var8 = arg2 - this.ci;
         int var9 = Model.Ib[this.di];
         int var10 = Model.Jb[this.di];
         int var11 = Model.Ib[this.ei];
         int var12 = Model.Jb[this.ei];
         int var13 = var6 * var12 + var8 * var11 >> 16;
         int var14 = var8 * var12 - var6 * var11 >> 16;
         int var16 = var7 * var10 - var9 * var14 >> 16;
         int var17 = var7 * var9 + var10 * var14 >> 16;

         while(arg3 >= 0) {
            this.rb = -1;
         }

         if (var17 >= 50) {
            this.Bc = (var13 << 9) / var17 + Pix3D.E;
            this.Cc = (var16 << 9) / var17 + Pix3D.F;
         } else {
            this.Bc = -1;
            this.Cc = -1;
         }
      } else {
         this.Bc = -1;
         this.Cc = -1;
      }
   }

   @ObfuscatedName("client.q(Z)V")
   public void q(boolean arg0) {
      System.out.println("============");
      System.out.println("flame-cycle:" + this.Pf);
      if (this.xj != null) {
         System.out.println("Od-cycle:" + this.xj.p);
      }

      System.out.println("loop-cycle:" + fk);
      System.out.println("draw-cycle:" + Pj);
      System.out.println("ptype:" + this.rb);
      System.out.println("psize:" + this.qb);
      if (arg0) {
         this.te = !this.te;
      }

      if (this.pe != null) {
         this.pe.a(false);
      }

      super.k = true;
   }

   @ObfuscatedName("client.d(I)Ljava/awt/Component;")
   public final java.awt.Component d(int arg0) {
      while(arg0 >= 0) {
         for(int var2 = 1; var2 > 0; ++var2) {
         }
      }

      if (sign.Signlink.mainapp != null) {
         return sign.Signlink.mainapp;
      } else if (super.q != null) {
         return super.q;
      } else {
         return this;
      }
   }

   @ObfuscatedName("client.a(IZLjava/lang/String;)V")
   public final void a(int arg0, boolean arg1, String arg2) {
      this.ck = arg0;
      if (!arg1) {
         this.Dc = !this.Dc;
      }

      this.se = arg2;
      this.n(-188);
      if (this.Jb == null) {
         super.a(arg0, true, arg2);
      } else {
         this.Kh.a(false);
         short var4 = 360;
         short var5 = 200;
         byte var6 = 20;
         this.af.a(var4 / 2, 452, var5 / 2 - 26 - var6, 16777215, "RuneScape is loading - please wait...");
         int var7 = var5 / 2 - 18 - var6;
         Pix2D.a(0, var7, 34, (int)9179409, var4 / 2 - 152, 304);
         Pix2D.a(0, var7 + 1, 32, (int)0, var4 / 2 - 151, 302);
         Pix2D.a(30, var7 + 2, 9179409, (byte)-24, arg0 * 3, var4 / 2 - 150);
         Pix2D.a(30, var7 + 2, 0, (byte)-24, 300 - arg0 * 3, arg0 * 3 + (var4 / 2 - 150));
         this.af.a(var4 / 2, 452, var5 / 2 + 5 - var6, 16777215, arg2);
         this.Kh.a(171, 202, super.n, this.of);
         if (this.Le) {
            this.Le = false;
            if (!this.Bi) {
               this.Lh.a(0, 0, super.n, this.of);
               this.Mh.a(0, 637, super.n, this.of);
            }

            this.Ih.a(0, 128, super.n, this.of);
            this.Jh.a(371, 202, super.n, this.of);
            this.Nh.a(265, 0, super.n, this.of);
            this.Oh.a(265, 562, super.n, this.of);
            this.Ph.a(171, 128, super.n, this.of);
            this.Qh.a(171, 562, super.n, this.of);
         }
      }
   }

   @ObfuscatedName("client.r(Z)V")
   public final void r(boolean arg0) {
      byte[] var2 = this.Jb.read("title.dat", (byte[])null);
      Pix24 var3 = new Pix24(var2, this);
      this.Lh.a(false);
      var3.a(0, -192, 0);
      this.Mh.a(false);
      var3.a(0, -192, -637);
      this.Ih.a(false);
      var3.a(0, -192, -128);
      this.Jh.a(false);
      var3.a(-371, -192, -202);
      this.Kh.a(false);
      var3.a(-171, -192, -202);
      this.Nh.a(false);
      var3.a(-265, -192, 0);
      this.Oh.a(false);
      var3.a(-265, -192, -562);
      this.Ph.a(false);
      var3.a(-171, -192, -128);
      this.Qh.a(false);
      var3.a(-171, -192, -562);
      int[] var4 = new int[var3.J];

      for(int var5 = 0; var5 < var3.K; ++var5) {
         for(int var6 = 0; var6 < var3.J; ++var6) {
            var4[var6] = var3.I[var3.J * var5 + (var3.J - var6 - 1)];
         }

         for(int var7 = 0; var7 < var3.J; ++var7) {
            var3.I[var3.J * var5 + var7] = var4[var7];
         }
      }

      this.Lh.a(false);
      var3.a(0, -192, 382);
      this.Mh.a(false);
      var3.a(0, -192, -255);
      this.Ih.a(false);
      var3.a(0, -192, 254);
      this.Jh.a(false);
      var3.a(-371, -192, 180);
      this.Kh.a(false);
      var3.a(-171, -192, 180);
      this.Nh.a(false);
      if (arg0) {
         for(int var8 = 1; var8 > 0; ++var8) {
         }
      }

      var3.a(-265, -192, 382);
      this.Oh.a(false);
      var3.a(-265, -192, -180);
      this.Ph.a(false);
      var3.a(-171, -192, 254);
      this.Qh.a(false);
      var3.a(-171, -192, -180);
      Pix24 var9 = new Pix24(this.Jb, "logo", 0);
      this.Ih.a(false);
      var9.b(18, 382 - var9.J / 2 - 128, -488);
      Object var10 = null;
      Object var11 = null;
      Object var12 = null;
      System.gc();
      if (Linkable.d) {
      }

   }

   @ObfuscatedName("client.a(BLNLLHDXXJ;)V")
   public final void a(byte arg0, LocChange arg1) {
      int var3 = 0;
      int var4 = -1;
      int var5 = 0;
      int var6 = 0;
      if (arg0 != -61) {
         this.hd.p1((int)175);
      }

      if (arg1.m == 0) {
         var3 = this.ah.b(arg1.l, arg1.n, arg1.o);
      }

      if (arg1.m == 1) {
         var3 = this.ah.b(arg1.n, (byte)4, arg1.l, arg1.o);
      }

      if (arg1.m == 2) {
         var3 = this.ah.c(arg1.l, arg1.n, arg1.o);
      }

      if (arg1.m == 3) {
         var3 = this.ah.d(arg1.l, arg1.n, arg1.o);
      }

      if (var3 != 0) {
         int var7 = this.ah.e(arg1.l, arg1.n, arg1.o, var3);
         var4 = var3 >> 14 & 32767;
         var5 = var7 & 31;
         var6 = var7 >> 6;
      }

      arg1.h = var4;
      arg1.j = var5;
      arg1.i = var6;
   }

   @ObfuscatedName("client.H(I)V")
   public final void H(int arg0) {
      this.Bi = false;

      while(this.ak) {
         this.Bi = false;

         try {
            Thread.sleep(50L);
         } catch (Exception var2) {
         }
      }

      this.yj = null;
      this.zj = null;
      this.fg = null;
      this.Qj = null;
      this.Rj = null;
      if (arg0 != 28614) {
         this.of = !this.of;
      }

      this.Sj = null;
      this.Tj = null;
      this.mh = null;
      this.nh = null;
      this.yf = null;
      this.zf = null;
      this.ie = null;
      this.je = null;
   }

   @ObfuscatedName("client.a(IILEWIXBTLV;II)V")
   public final void a(int arg0, int arg1, Component arg2, int arg3, int arg4) {
      if (arg2.A == 0 && arg2.W != null) {
         if (!arg2.j || this.Ij == arg2.f || this.mj == arg2.f || this.Uf == arg2.f) {
            int var6 = Pix2D.q;
            int var7 = Pix2D.o;
            int var8 = Pix2D.r;
            int var9 = Pix2D.p;
            Pix2D.a(arg0, arg1, arg2.C + arg0, arg2.F + arg1, true);
            int var10 = arg2.W.length;
            if (arg4 != 8) {
               this.rb = -1;
            }

            for(int var11 = 0; var11 < var10; ++var11) {
               int var12 = arg2.w[var11] + arg1;
               int var13 = arg2.ob[var11] + arg0 - arg3;
               Component var14 = Component.a(arg2.W[var11]);
               int var15 = var14.s + var12;
               int var16 = var14.X + var13;
               if (var14.G > 0) {
                  this.a((byte)2, (Component)var14);
               }

               if (var14.A == 0) {
                  if (var14.v > var14.xb - var14.C) {
                     var14.v = var14.xb - var14.C;
                  }

                  if (var14.v < 0) {
                     var14.v = 0;
                  }

                  this.a(var16, var15, var14, var14.v, 8);
                  if (var14.xb > var14.C) {
                     this.a(true, var14.v, var14.F + var15, var14.C, var14.xb, var16);
                  }
               } else if (var14.A != 1) {
                  if (var14.A == 2) {
                     int var17 = 0;

                     for(int var18 = 0; var18 < var14.C; ++var18) {
                        for(int var19 = 0; var19 < var14.F; ++var19) {
                           int var20 = (var14.bb + 32) * var19 + var15;
                           int var21 = (var14.I + 32) * var18 + var16;
                           if (var17 < 20) {
                              var20 += var14.l[var17];
                              var21 += var14.d[var17];
                           }

                           if (var14.hb[var17] <= 0) {
                              if (var14.db != null && var17 < 20) {
                                 Pix24 var30 = var14.db[var17];
                                 if (var30 != null) {
                                    var30.b(var21, var20, -488);
                                 }
                              }
                           } else {
                              int var22 = 0;
                              int var23 = 0;
                              int var24 = var14.hb[var17] - 1;
                              if (var20 > Pix2D.q - 32 && var20 < Pix2D.r && var21 > Pix2D.o - 32 && var21 < Pix2D.p || this.bg != 0 && this.ag == var17) {
                                 int var25 = 0;
                                 if (this.Ig == 1 && this.Jg == var17 && this.Kg == var14.f) {
                                    var25 = 16777215;
                                 }

                                 Pix24 var26 = ObjType.a((byte)-33, var25, var14.o[var17], var24);
                                 if (var26 != null) {
                                    if (this.bg != 0 && this.ag == var17 && this.Zf == var14.f) {
                                       var22 = super.v - this.cg;
                                       var23 = super.w - this.dg;
                                       if (var22 < 5 && var22 > -5) {
                                          var22 = 0;
                                       }

                                       if (var23 < 5 && var23 > -5) {
                                          var23 = 0;
                                       }

                                       if (this.bj < 5) {
                                          var22 = 0;
                                          var23 = 0;
                                       }

                                       var26.b(0, var20 + var22, var21 + var23, 128);
                                       if (var21 + var23 < Pix2D.o && arg2.v > 0) {
                                          int var27 = (Pix2D.o - var21 - var23) * this.Uc / 3;
                                          if (var27 > this.Uc * 10) {
                                             var27 = this.Uc * 10;
                                          }

                                          if (var27 > arg2.v) {
                                             var27 = arg2.v;
                                          }

                                          arg2.v -= var27;
                                          this.dg += var27;
                                       }

                                       if (var21 + var23 + 32 > Pix2D.p && arg2.v < arg2.xb - arg2.C) {
                                          int var28 = (var21 + var23 + 32 - Pix2D.p) * this.Uc / 3;
                                          if (var28 > this.Uc * 10) {
                                             var28 = this.Uc * 10;
                                          }

                                          if (var28 > arg2.xb - arg2.C - arg2.v) {
                                             var28 = arg2.xb - arg2.C - arg2.v;
                                          }

                                          arg2.v += var28;
                                          this.dg -= var28;
                                       }
                                    } else if (this.mk != 0 && this.lk == var17 && this.kk == var14.f) {
                                       var26.b(0, var20, var21, 128);
                                    } else {
                                       var26.b(var21, var20, -488);
                                    }

                                    if (var26.N == 33 || var14.o[var17] != 1) {
                                       int var29 = var14.o[var17];
                                       this.Ye.b(2245, var20 + 1 + var22, 0, var21 + 10 + var23, a(var29, (int)-243));
                                       this.Ye.b(2245, var20 + var22, 16776960, var21 + 9 + var23, a(var29, (int)-243));
                                    }
                                 }
                              }
                           }

                           ++var17;
                        }
                     }
                  } else if (var14.A == 3) {
                     boolean var31 = false;
                     if (this.Uf == var14.f || this.mj == var14.f || this.Ij == var14.f) {
                        var31 = true;
                     }

                     int var32;
                     if (this.b((Component)var14, -693)) {
                        var32 = var14.Y;
                        if (var31 && var14.q != 0) {
                           var32 = var14.q;
                        }
                     } else {
                        var32 = var14.E;
                        if (var31 && var14.Z != 0) {
                           var32 = var14.Z;
                        }
                     }

                     if (var14.k == 0) {
                        if (var14.D) {
                           Pix2D.a(var14.C, var16, var32, (byte)-24, var14.F, var15);
                        } else {
                           Pix2D.a(0, var16, var14.C, (int)var32, var15, var14.F);
                        }
                     } else if (var14.D) {
                        Pix2D.a(false, var32, var16, var14.F, var14.C, 256 - (var14.k & 255), var15);
                     } else {
                        Pix2D.a(var15, var14.F, var32, var14.C, var16, 256 - (var14.k & 255), (byte)-113);
                     }
                  } else if (var14.A == 4) {
                     PixFont var33 = var14.B;
                     String var34 = var14.u;
                     boolean var35 = false;
                     if (this.Uf == var14.f || this.mj == var14.f || this.Ij == var14.f) {
                        var35 = true;
                     }

                     int var36;
                     if (this.b((Component)var14, -693)) {
                        var36 = var14.Y;
                        if (var35 && var14.q != 0) {
                           var36 = var14.q;
                        }

                        if (var14.N.length() > 0) {
                           var34 = var14.N;
                        }
                     } else {
                        var36 = var14.E;
                        if (var35 && var14.Z != 0) {
                           var36 = var14.Z;
                        }
                     }

                     if (var14.Bb == 6 && this.xi) {
                        var34 = "Please wait...";
                        var36 = var14.E;
                     }

                     if (Pix2D.m == 479) {
                        if (var36 == 16776960) {
                           var36 = 255;
                        }

                        if (var36 == 49152) {
                           var36 = 16777215;
                        }
                     }

                     int var37 = var33.G + var16;

                     while(var34.length() > 0) {
                        if (var34.indexOf("%") != -1) {
                           label390:
                           while(true) {
                              int var38 = var34.indexOf("%1");
                              if (var38 == -1) {
                                 while(true) {
                                    int var39 = var34.indexOf("%2");
                                    if (var39 == -1) {
                                       while(true) {
                                          int var40 = var34.indexOf("%3");
                                          if (var40 == -1) {
                                             while(true) {
                                                int var41 = var34.indexOf("%4");
                                                if (var41 == -1) {
                                                   while(true) {
                                                      int var42 = var34.indexOf("%5");
                                                      if (var42 == -1) {
                                                         break label390;
                                                      }

                                                      var34 = var34.substring(0, var42) + this.e(this.a(3, (int)4, (Component)var14), 8) + var34.substring(var42 + 2);
                                                   }
                                                }

                                                var34 = var34.substring(0, var41) + this.e(this.a(3, (int)3, (Component)var14), 8) + var34.substring(var41 + 2);
                                             }
                                          }

                                          var34 = var34.substring(0, var40) + this.e(this.a(3, (int)2, (Component)var14), 8) + var34.substring(var40 + 2);
                                       }
                                    }

                                    var34 = var34.substring(0, var39) + this.e(this.a(3, (int)1, (Component)var14), 8) + var34.substring(var39 + 2);
                                 }
                              }

                              var34 = var34.substring(0, var38) + this.e(this.a(3, (int)0, (Component)var14), 8) + var34.substring(var38 + 2);
                           }
                        }

                        int var43 = var34.indexOf("\\n");
                        String var44;
                        if (var43 != -1) {
                           var44 = var34.substring(0, var43);
                           var34 = var34.substring(var43 + 2);
                        } else {
                           var44 = var34;
                           var34 = "";
                        }

                        if (var14.kb) {
                           var33.a(var14.L, this.Ve, var36, var37, var14.F / 2 + var15, var44);
                        } else {
                           var33.a(var36, var15, var37, var14.L, var44, -39629);
                        }

                        var37 += var33.G;
                     }
                  } else if (var14.A == 5) {
                     Pix24 var45;
                     if (this.b((Component)var14, -693)) {
                        var45 = var14.J;
                     } else {
                        var45 = var14.c;
                     }

                     if (var45 != null) {
                        var45.b(var16, var15, -488);
                     }
                  } else if (var14.A == 6) {
                     int var46 = Pix3D.E;
                     int var47 = Pix3D.F;
                     Pix3D.E = var14.F / 2 + var15;
                     Pix3D.F = var14.C / 2 + var16;
                     int var48 = Pix3D.I[var14.Q] * var14.P >> 16;
                     int var49 = Pix3D.J[var14.Q] * var14.P >> 16;
                     boolean var50 = this.b((Component)var14, -693);
                     int var51;
                     if (var50) {
                        var51 = var14.zb;
                     } else {
                        var51 = var14.yb;
                     }

                     Model var52;
                     if (var51 == -1) {
                        var52 = var14.a(-1, -1, 0, var50);
                     } else {
                        SeqType var53 = SeqType.d[var51];
                        var52 = var14.a(var53.f[var14.z], var53.g[var14.z], 0, var50);
                     }

                     if (var52 != null) {
                        var52.a(0, var14.R, 0, var14.Q, 0, var48, var49);
                     }

                     Pix3D.E = var46;
                     Pix3D.F = var47;
                  } else {
                     if (var14.A == 7) {
                        PixFont var54 = var14.B;
                        int var55 = 0;

                        for(int var56 = 0; var56 < var14.C; ++var56) {
                           for(int var57 = 0; var57 < var14.F; ++var57) {
                              if (var14.hb[var55] > 0) {
                                 ObjType var58 = ObjType.a(var14.hb[var55] - 1);
                                 String var59 = String.valueOf(var58.d);
                                 if (var58.T || var14.o[var55] != 1) {
                                    var59 = var59 + " x" + i(0, var14.o[var55]);
                                 }

                                 int var60 = (var14.bb + 115) * var57 + var15;
                                 int var61 = (var14.I + 12) * var56 + var16;
                                 if (var14.kb) {
                                    var54.a(var14.L, this.Ve, var14.E, var61, var14.F / 2 + var60, var59);
                                 } else {
                                    var54.a(var14.E, var60, var61, var14.L, var59, -39629);
                                 }
                              }

                              ++var55;
                           }
                        }
                     }

                     if (var14.A == 8 && (this.qj == var14.f || this.Je == var14.f || this.rg == var14.f) && this.Ob == 100) {
                        int var62 = 0;
                        int var63 = 0;
                        PixFont var64 = this.Ze;
                        String var65 = var14.u;

                        while(var65.length() > 0) {
                           int var66 = var65.indexOf("\\n");
                           String var67;
                           if (var66 != -1) {
                              var67 = var65.substring(0, var66);
                              var65 = var65.substring(var66 + 2);
                           } else {
                              var67 = var65;
                              var65 = "";
                           }

                           int var68 = var64.a((byte)35, var67);
                           if (var68 > var62) {
                              var62 = var68;
                           }

                           var63 += var64.G + 1;
                        }

                        var62 += 6;
                        var63 += 7;
                        int var69 = var14.F + var15 - 5 - var62;
                        int var70 = var14.C + var16 + 5;
                        if (var69 < var15 + 5) {
                           var69 = var15 + 5;
                        }

                        if (var62 + var69 > arg2.F + arg1) {
                           var69 = arg2.F + arg1 - var62;
                        }

                        if (var63 + var70 > arg2.C + arg0) {
                           var70 = arg2.C + arg0 - var63;
                        }

                        Pix2D.a(var63, var70, 16777120, (byte)-24, var62, var69);
                        Pix2D.a(0, var70, var63, (int)0, var69, var62);
                        String var71 = var14.u;
                        int var72 = var64.G + var70 + 2;

                        while(var71.length() > 0) {
                           int var73 = var71.indexOf("\\n");
                           String var74;
                           if (var73 != -1) {
                              var74 = var71.substring(0, var73);
                              var71 = var71.substring(var73 + 2);
                           } else {
                              var74 = var71;
                              var71 = "";
                           }

                           var64.a(0, var69 + 3, var72, false, var74, -39629);
                           var72 += var64.G + 1;
                        }
                     }
                  }
               }
            }

            Pix2D.a(var7, var6, var9, var8, true);
         }
      }
   }

   @ObfuscatedName("client.l(B)V")
   public final void l(byte arg0) {
      if (arg0 != -40) {
         Rh = !Rh;
      }

      if (vc && this.lf == 2 && World.y != this.Ff) {
         this.a(-332, (String)null, "Loading - please wait.");
         this.lf = 1;
         this.ni = System.currentTimeMillis();
      }

      if (this.lf == 1) {
         int var2 = this.I(5);
         if (var2 != 0 && System.currentTimeMillis() - this.ni > 360000L) {
            sign.Signlink.reporterror(this.Gf + " glcfb " + this.zc + "," + var2 + "," + vc + "," + this.mi[0] + "," + this.xj.b() + "," + this.Ff + "," + this.Kb + "," + this.Lb);
            this.ni = System.currentTimeMillis();
         }
      }

      if (this.lf == 2 && this.ij != this.Ff) {
         this.ij = this.Ff;
         this.g(this.Ff, 0);
      }
   }

   @ObfuscatedName("client.I(I)I")
   public final int I(int arg0) {
      for(int var2 = 0; var2 < this.L.length; ++var2) {
         if (this.L[var2] == null && this.eb[var2] != -1) {
            return -1;
         }

         if (this.qi[var2] == null && this.fb[var2] != -1) {
            return -2;
         }
      }

      boolean var3 = true;
      if (arg0 < 5 || arg0 > 5) {
         this.Wc = !this.Wc;
      }

      for(int var4 = 0; var4 < this.L.length; ++var4) {
         byte[] var5 = this.qi[var4];
         if (var5 != null) {
            int var6 = (this.db[var4] >> 8) * 64 - this.Fe;
            int var7 = (this.db[var4] & 255) * 64 - this.Ge;
            if (this.Zg) {
               var6 = 10;
               var7 = 10;
            }

            var3 &= World.a(var6, var7, var5, 24515);
         }
      }

      if (!var3) {
         return -3;
      } else if (this.Th) {
         return -4;
      } else {
         this.lf = 2;
         World.y = this.Ff;
         this.x(175);
         this.hd.pIsaac(6);
         return 0;
      }
   }

   @ObfuscatedName("client.a(ZIIIIIIIII)V")
   public final void a(boolean arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
      LocChange var11 = null;

      for(LocChange var12 = (LocChange)this.Ti.b(); var12 != null; var12 = (LocChange)this.Ti.a(1)) {
         if (var12.l == arg1 && var12.n == arg2 && var12.o == arg9 && var12.m == arg8) {
            var11 = var12;
            break;
         }
      }

      if (var11 == null) {
         var11 = new LocChange();
         var11.l = arg1;
         var11.m = arg8;
         var11.n = arg2;
         var11.o = arg9;
         this.a((byte)-61, var11);
         this.Ti.a(var11);
      }

      var11.e = arg6;
      var11.g = arg5;
      var11.f = arg3;
      var11.p = arg7;
      var11.k = arg4;
      this.zg &= arg0;
   }

   @ObfuscatedName("client.m(B)V")
   public final void m(byte arg0) {
      if (arg0 == 4) {
         if (this.Pe == 0) {
            if (super.B == 1) {
               int var2 = super.C - 25 - 550;
               int var3 = super.D - 5 - 4;
               if (var2 >= 0 && var3 >= 0 && var2 < 146 && var3 < 151) {
                  var2 -= 73;
                  var3 -= 75;
                  int var4 = this.lc + this.Ki & 2047;
                  int var5 = Pix3D.I[var4];
                  int var6 = Pix3D.J[var4];
                  int var7 = (this.ri + 256) * var5 >> 8;
                  int var8 = (this.ri + 256) * var6 >> 8;
                  int var9 = var2 * var8 + var3 * var7 >> 11;
                  int var10 = var3 * var8 - var2 * var7 >> 11;
                  int var11 = dh.Q + var9 >> 7;
                  int var12 = dh.R - var10 >> 7;
                  boolean var13 = this.a(true, false, var12, dh.t[0], 0, 0, 1, 0, var11, 0, 0, dh.s[0]);
                  if (var13) {
                     this.hd.p1(var2);
                     this.hd.p1(var3);
                     this.hd.p2(this.Ki);
                     this.hd.p1((int)57);
                     this.hd.p1(this.lc);
                     this.hd.p1(this.ri);
                     this.hd.p1((int)89);
                     this.hd.p2(dh.Q);
                     this.hd.p2(dh.R);
                     this.hd.p1(this.og);
                     this.hd.p1((int)63);
                     return;
                  }
               }
            }

         }
      }
   }

   @ObfuscatedName("client.J(I)V")
   public final void J(int arg0) {
      if (super.o == null) {
         this.H(28614);
         this.Ih = null;
         this.Jh = null;
         this.Kh = null;
         if (arg0 >= 0) {
            this.Vd = -4;
         }

         this.Lh = null;
         this.Mh = null;
         this.Nh = null;
         this.Oh = null;
         this.Ph = null;
         this.Qh = null;
         this.Vg = null;
         this.Tg = null;
         this.Sg = null;
         this.Ug = null;
         this.Wf = null;
         this.Xf = null;
         this.Yf = null;
         super.o = new PixMap(503, (byte)-12, this.d((int)-756), 765);
         this.Le = true;
      }
   }

   @ObfuscatedName("client.a(ILjava/lang/String;)Z")
   public final boolean a(int arg0, String arg1) {
      if (arg1 == null) {
         return false;
      } else {
         for(int var3 = 0; var3 < this.gb; ++var3) {
            if (arg1.equalsIgnoreCase(this.W[var3])) {
               return true;
            }
         }

         if (arg0 != 13292) {
            this.fe = !this.fe;
         }

         return arg1.equalsIgnoreCase(dh.yb);
      }
   }

   @ObfuscatedName("client.K(I)V")
   public final void K(int arg0) {
      while(arg0 >= 0) {
         this.rb = this.yh.g1();
      }

      if (this.ji == 0) {
         int var2 = super.l / 2 - 80;
         int var3 = super.m / 2 + 20;
         int var14 = var3 + 20;
         if (super.B == 1 && super.C >= var2 - 75 && super.C <= var2 + 75 && super.D >= var14 - 20 && super.D <= var14 + 20) {
            this.ji = 3;
            this.ud = 0;
         }

         int var4 = super.l / 2 + 80;
         if (super.B == 1 && super.C >= var4 - 75 && super.C <= var4 + 75 && super.D >= var14 - 20 && super.D <= var14 + 20) {
            this.ad = "";
            this.bd = "Enter your username & password.";
            this.ji = 2;
            this.ud = 0;
         }
      } else if (this.ji == 2) {
         int var5 = super.m / 2 - 40;
         int var15 = var5 + 30;
         int var16 = var15 + 25;
         if (super.B == 1 && super.D >= var16 - 15 && super.D < var16) {
            this.ud = 0;
         }

         var5 = var16 + 15;
         if (super.B == 1 && super.D >= var5 - 15 && super.D < var5) {
            this.ud = 1;
         }

         var5 += 15;
         int var6 = super.l / 2 - 80;
         int var7 = super.m / 2 + 50;
         int var17 = var7 + 20;
         if (super.B == 1 && super.C >= var6 - 75 && super.C <= var6 + 75 && super.D >= var17 - 20 && super.D <= var17 + 20) {
            this.X = 0;
            this.a(this.Gf, this.Hf, false);
            if (this.zg) {
               return;
            }
         }

         int var8 = super.l / 2 + 80;
         if (super.B == 1 && super.C >= var8 - 75 && super.C <= var8 + 75 && super.D >= var17 - 20 && super.D <= var17 + 20) {
            this.ji = 0;
            this.Gf = "";
            this.Hf = "";
         }

         while(true) {
            while(true) {
               int var9 = this.a((int)-983);
               if (var9 == -1) {
                  return;
               }

               boolean var10 = false;

               for(int var11 = 0; var11 < Yd.length(); ++var11) {
                  if (var9 == Yd.charAt(var11)) {
                     var10 = true;
                     break;
                  }
               }

               if (this.ud == 0) {
                  if (var9 == 8 && this.Gf.length() > 0) {
                     this.Gf = this.Gf.substring(0, this.Gf.length() - 1);
                  }

                  if (var9 == 9 || var9 == 10 || var9 == 13) {
                     this.ud = 1;
                  }

                  if (var10) {
                     this.Gf = this.Gf + (char)var9;
                  }

                  if (this.Gf.length() > 12) {
                     this.Gf = this.Gf.substring(0, 12);
                  }
               } else if (this.ud == 1) {
                  if (var9 == 8 && this.Hf.length() > 0) {
                     this.Hf = this.Hf.substring(0, this.Hf.length() - 1);
                  }

                  if (var9 == 9 || var9 == 10 || var9 == 13) {
                     this.ud = 0;
                  }

                  if (var10) {
                     this.Hf = this.Hf + (char)var9;
                  }

                  if (this.Hf.length() > 20) {
                     this.Hf = this.Hf.substring(0, 20);
                  }
               }
            }
         }
      } else {
         if (this.ji == 3) {
            int var12 = super.l / 2;
            int var13 = super.m / 2 + 50;
            int var18 = var13 + 20;
            if (super.B == 1 && super.C >= var12 - 75 && super.C <= var12 + 75 && super.D >= var18 - 20 && super.D <= var18 + 20) {
               this.ji = 0;
               return;
            }
         }

      }
   }

   @ObfuscatedName("client.a(IIIIII)V")
   public final void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
      int var7 = this.ah.b(arg1, arg2, arg0);
      int var8 = 62 / arg4;
      if (var7 != 0) {
         int var9 = this.ah.e(arg1, arg2, arg0, var7);
         int var10 = var9 >> 6 & 3;
         int var11 = var9 & 31;
         int var12 = arg5;
         if (var7 > 0) {
            var12 = arg3;
         }

         int[] var13 = this.kg.I;
         int var14 = (103 - arg0) * 512 * 4 + arg2 * 4 + 24624;
         int var15 = var7 >> 14 & 32767;
         LocType var16 = LocType.a(var15);
         if (var16.L != -1) {
            Pix8 var17 = this.Pg[var16.L];
            if (var17 != null) {
               int var18 = (var16.R * 4 - var17.F) / 2;
               int var19 = (var16.r * 4 - var17.G) / 2;
               var17.a((104 - arg0 - var16.r) * 4 + 48 + var19, arg2 * 4 + 48 + var18, -488);
            }
         } else {
            if (var11 == 0 || var11 == 2) {
               if (var10 == 0) {
                  var13[var14] = var12;
                  var13[var14 + 512] = var12;
                  var13[var14 + 1024] = var12;
                  var13[var14 + 1536] = var12;
               } else if (var10 == 1) {
                  var13[var14] = var12;
                  var13[var14 + 1] = var12;
                  var13[var14 + 2] = var12;
                  var13[var14 + 3] = var12;
               } else if (var10 == 2) {
                  var13[var14 + 3] = var12;
                  var13[var14 + 3 + 512] = var12;
                  var13[var14 + 3 + 1024] = var12;
                  var13[var14 + 3 + 1536] = var12;
               } else if (var10 == 3) {
                  var13[var14 + 1536] = var12;
                  var13[var14 + 1536 + 1] = var12;
                  var13[var14 + 1536 + 2] = var12;
                  var13[var14 + 1536 + 3] = var12;
               }
            }

            if (var11 == 3) {
               if (var10 == 0) {
                  var13[var14] = var12;
               } else if (var10 == 1) {
                  var13[var14 + 3] = var12;
               } else if (var10 == 2) {
                  var13[var14 + 3 + 1536] = var12;
               } else if (var10 == 3) {
                  var13[var14 + 1536] = var12;
               }
            }

            if (var11 == 2) {
               if (var10 == 3) {
                  var13[var14] = var12;
                  var13[var14 + 512] = var12;
                  var13[var14 + 1024] = var12;
                  var13[var14 + 1536] = var12;
               } else if (var10 == 0) {
                  var13[var14] = var12;
                  var13[var14 + 1] = var12;
                  var13[var14 + 2] = var12;
                  var13[var14 + 3] = var12;
               } else if (var10 == 1) {
                  var13[var14 + 3] = var12;
                  var13[var14 + 3 + 512] = var12;
                  var13[var14 + 3 + 1024] = var12;
                  var13[var14 + 3 + 1536] = var12;
               } else if (var10 == 2) {
                  var13[var14 + 1536] = var12;
                  var13[var14 + 1536 + 1] = var12;
                  var13[var14 + 1536 + 2] = var12;
                  var13[var14 + 1536 + 3] = var12;
               }
            }
         }
      }

      int var20 = this.ah.c(arg1, arg2, arg0);
      if (var20 != 0) {
         int var21 = this.ah.e(arg1, arg2, arg0, var20);
         int var22 = var21 >> 6 & 3;
         int var23 = var21 & 31;
         int var24 = var20 >> 14 & 32767;
         LocType var25 = LocType.a(var24);
         if (var25.L != -1) {
            Pix8 var26 = this.Pg[var25.L];
            if (var26 != null) {
               int var27 = (var25.R * 4 - var26.F) / 2;
               int var28 = (var25.r * 4 - var26.G) / 2;
               var26.a((104 - arg0 - var25.r) * 4 + 48 + var28, arg2 * 4 + 48 + var27, -488);
            }
         } else if (var23 == 9) {
            int var29 = 15658734;
            if (var20 > 0) {
               var29 = 15597568;
            }

            int[] var30 = this.kg.I;
            int var31 = (103 - arg0) * 512 * 4 + arg2 * 4 + 24624;
            if (var22 != 0 && var22 != 2) {
               var30[var31] = var29;
               var30[var31 + 512 + 1] = var29;
               var30[var31 + 1024 + 2] = var29;
               var30[var31 + 1536 + 3] = var29;
            } else {
               var30[var31 + 1536] = var29;
               var30[var31 + 1024 + 1] = var29;
               var30[var31 + 512 + 2] = var29;
               var30[var31 + 3] = var29;
            }
         }
      }

      int var32 = this.ah.d(arg1, arg2, arg0);
      if (var32 != 0) {
         int var33 = var32 >> 14 & 32767;
         LocType var34 = LocType.a(var33);
         if (var34.L != -1) {
            Pix8 var35 = this.Pg[var34.L];
            if (var35 != null) {
               int var36 = (var34.R * 4 - var35.F) / 2;
               int var37 = (var34.r * 4 - var35.G) / 2;
               var35.a((104 - arg0 - var34.r) * 4 + 48 + var37, arg2 * 4 + 48 + var36, -488);
               return;
            }
         }
      }

   }

   @ObfuscatedName("client.L(I)V")
   public final void L(int arg0) {
      ++this.Ag;
      this.b(0, true);
      this.a((int)751, true);
      this.b(0, false);
      this.a((int)751, false);
      this.h(false);
      this.r(-992);
      if (!this.Vh) {
         int var2 = this.Ji;
         if (this.vj / 256 > var2) {
            var2 = this.vj / 256;
         }

         if (this.wc[4] && this.Z[4] + 128 > var2) {
            var2 = this.Z[4] + 128;
         }

         int var3 = this.Ni + this.Ki & 2047;
         this.a(this.a(dh.R, dh.Q, (byte)9, this.Ff) - 50, this.Ui, var2, var2 * 3 + 600, var3, this.Vi, (byte)-103);
      }

      int var4;
      if (!this.Vh) {
         var4 = this.j((byte)1);
      } else {
         var4 = this.E(-276);
      }

      int var5 = this.ai;
      int var6 = this.bi;
      int var7 = this.ci;
      int var8 = this.di;
      int var9 = this.ei;
      if (arg0 != 2) {
         this.Vd = this.Ub.nextInt();
      }

      for(int var10 = 0; var10 < 5; ++var10) {
         if (this.wc[var10]) {
            int var11 = (int)(Math.random() * (double)(this.Tf[var10] * 2 + 1) - (double)this.Tf[var10] + Math.sin((double)this.Id[var10] / 100.0D * (double)this.Hg[var10]) * (double)this.Z[var10]);
            if (var10 == 0) {
               this.ai += var11;
            }

            if (var10 == 1) {
               this.bi += var11;
            }

            if (var10 == 2) {
               this.ci += var11;
            }

            if (var10 == 3) {
               this.ei = this.ei + var11 & 2047;
            }

            if (var10 == 4) {
               this.di += var11;
               if (this.di < 128) {
                  this.di = 128;
               }

               if (this.di > 383) {
                  this.di = 383;
               }
            }
         }
      }

      int var12 = Pix3D.T;
      Model.Db = true;
      Model.Gb = 0;
      Model.Eb = super.v - 4;
      Model.Fb = super.w - 4;
      Pix2D.a((int)4);
      this.ah.a(this.ai, var4, 0, this.bi, this.ci, this.ei, this.di);
      this.ah.a(this.Sb);
      this.m(false);
      this.o(true);
      this.d(var12, -927);
      this.C(30729);
      this.Ug.a(4, 4, super.n, this.of);
      this.ai = var5;
      this.bi = var6;
      this.ci = var7;
      this.di = var8;
      this.ei = var9;
   }

   @ObfuscatedName("client.M(I)V")
   public final void M(int arg0) {
      if (arg0 != -23763) {
         this.a();
      }

      for(int var2 = 0; var2 < this.Ae; ++var2) {
         if (this.Ri[var2] <= 0) {
            boolean var3 = false;

            try {
               if (this.Ef[var2] == this.ej && this.bk[var2] == this.Ec) {
                  if (!this.s(295)) {
                     var3 = true;
                  }
               } else {
                  Packet var4 = Wave.a(this.bk[var2], (byte)6, this.Ef[var2]);
                  if (System.currentTimeMillis() + (long)(var4.pos / 22) > (long)(this.ph / 22) + this.Ii) {
                     this.ph = var4.pos;
                     this.Ii = System.currentTimeMillis();
                     if (this.a(3, (int)var4.pos, (byte[])var4.data)) {
                        this.ej = this.Ef[var2];
                        this.Ec = this.bk[var2];
                     } else {
                        var3 = true;
                     }
                  }
               }
            } catch (Exception var7) {
               if (sign.Signlink.reporterror) {
                  this.hd.pIsaac(80);
                  this.hd.p2(this.Ef[var2] & 32767);
               } else {
                  this.hd.pIsaac(80);
                  this.hd.p2((int)-1);
               }
            }

            if (var3 && this.Ri[var2] != -5) {
               this.Ri[var2] = -5;
            } else {
               --this.Ae;

               for(int var6 = var2; var6 < this.Ae; ++var6) {
                  this.Ef[var6] = this.Ef[var6 + 1];
                  this.bk[var6] = this.bk[var6 + 1];
                  this.Ri[var6] = this.Ri[var6 + 1];
               }

               --var2;
            }
         } else {
            int var10002 = this.Ri[var2]--;
         }
      }

      if (this.qg > 0) {
         this.qg -= 20;
         if (this.qg < 0) {
            this.qg = 0;
         }

         if (this.qg == 0 && this.Yi && !vc) {
            this.cj = this.hk;
            this.dj = true;
            this.xj.b(2, this.cj);
            return;
         }
      }

   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         Vc[var1] = var0 / 4;
      }

      gd = true;
      Yd = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
      Zd = new int[][]{{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 2983, 54193}, {8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003, 25239}, {25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003}, {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574}};
      qe = -352;
      Ah = true;
      Yh = new int[32];
      int var4 = 2;

      for(int var5 = 0; var5 < 32; ++var5) {
         Yh[var5] = var4 - 1;
         var4 += var4;
      }

      Ai = true;
      aj = new int[]{9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145, 58654, 5027, 1457, 16565, 34991, 25486};
      Wj = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
   }
}
