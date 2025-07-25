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
import jagex2.client.sign.SignLink;
import jagex2.config.*;
import jagex2.dash3d.*;
import jagex2.datastruct.JString;
import jagex2.datastruct.LinkList;
import jagex2.graphics.*;
import jagex2.io.*;
import jagex2.sound.Wave;
import jagex2.wordenc.WordFilter;
import jagex2.wordenc.WordPack;

public class Client extends GameShell {

	@ObfuscatedName("client.sc")
	public static int nodeId = 10;

	@ObfuscatedName("client.tc")
	public static int portOffset;

	@ObfuscatedName("client.uc")
	public static boolean membersWorld = true;

	@ObfuscatedName("client.vc")
	public static boolean lowMemory;

	@ObfuscatedName("client.Qd")
	public static boolean alreadyStarted;

	@ObfuscatedName("client.fk")
	public static int loopCycle;

	@ObfuscatedName("client.Gi")
	public MouseTracking mousetracking;

	@ObfuscatedName("client.We")
	public int systemUpdateTimer;

	@ObfuscatedName("client.K")
	public int[] jagChecksum = new int[9];
	@ObfuscatedName("client.M")
	public String reportAbuseInput = "";
	@ObfuscatedName("client.P")
	public int[] CHAT_COLOURS = new int[]{16776960, 16711680, 65280, 65535, 16711935, 16777215};
	@ObfuscatedName("client.Q")
	public int[] skillExperience = new int[Stats.SKILL_COUNT];
	@ObfuscatedName("client.W")
	public String[] friendName = new String[200];
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
	public boolean showSocialInput = false;
	@ObfuscatedName("client.Ab")
	public int[][][] Ab = new int[4][13][13];
	@ObfuscatedName("client.Gb")
	public int[][] Gb = new int[104][104];
	@ObfuscatedName("client.Hb")
	public int[][] Hb = new int[104][104];

	@ObfuscatedName("client.Rb")
	public Pix24[] Rb = new Pix24[8];
	@ObfuscatedName("client.Sb")
	public int Sb = 559;
	@ObfuscatedName("client.Tb")
	public byte Tb = 6;
	@ObfuscatedName("client.Vb")
	public boolean Vb = false;
	@ObfuscatedName("client.mc")
	public int mc = 2;
	@ObfuscatedName("client.pc")
	public int[] minimapMaskLineLengths = new int[151];
	@ObfuscatedName("client.qc")
	public int qc = 8;
	@ObfuscatedName("client.wc")
	public boolean[] cameraModifierEnabled = new boolean[5];
	@ObfuscatedName("client.xc")
	public int xc = -188;
	@ObfuscatedName("client.yc")
	public Packet login = Packet.alloc(1);
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
	@ObfuscatedName("client.Gc")
	public String socialMessage = "";
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
	public String chatbackInput = "";
	@ObfuscatedName("client.Tc")
	public boolean redrawSideicons = false;

	@ObfuscatedName("client.Xc")
	public Pix24[] Xc = new Pix24[32];
	@ObfuscatedName("client.Zc")
	public byte Zc = 1;
	@ObfuscatedName("client.ad")
	public String loginMessage0 = "";
	@ObfuscatedName("client.bd")
	public String loginMessage1 = "";
	@ObfuscatedName("client.cd")
	public boolean cd = true;
	@ObfuscatedName("client.dd")
	public int dd = -1;
	@ObfuscatedName("client.ed")
	public int localPid = -1;
	@ObfuscatedName("client.hd")
	public Packet out = Packet.alloc(1);

	@ObfuscatedName("client.ld")
	public int MAX_PLAYER_COUNT = 2048;

	@ObfuscatedName("client.md")
	public int LOCAL_PLAYER_INDEX = 2047;

	@ObfuscatedName("client.nd")
	public ClientPlayer[] players = new ClientPlayer[this.MAX_PLAYER_COUNT];
	@ObfuscatedName("client.pd")
	public int[] pd = new int[this.MAX_PLAYER_COUNT];
	@ObfuscatedName("client.rd")
	public int[] entityUpdateIds = new int[this.MAX_PLAYER_COUNT];
	@ObfuscatedName("client.sd")
	public Packet[] playerAppearanceBuffer = new Packet[this.MAX_PLAYER_COUNT];
	@ObfuscatedName("client.td")
	public Pix8[] td = new Pix8[13];
	@ObfuscatedName("client.wd")
	public int[] menuParamB = new int[500];
	@ObfuscatedName("client.xd")
	public int[] menuParamC = new int[500];
	@ObfuscatedName("client.yd")
	public int[] menuAction = new int[500];
	@ObfuscatedName("client.zd")
	public int[] menuParamA = new int[500];
	@ObfuscatedName("client.Fd")
	public int chatInterfaceId = -1;
	@ObfuscatedName("client.Id")
	public int[] Id = new int[5];
	@ObfuscatedName("client.Wd")
	public int[] varCache = new int[2000];
	@ObfuscatedName("client.be")
	public int be = 2;
	@ObfuscatedName("client.fe")
	public boolean fe = false;
	@ObfuscatedName("client.he")
	public boolean errorStarted = false;
	@ObfuscatedName("client.ke")
	public int[] minimapMaskLineOffsets = new int[151];
	@ObfuscatedName("client.re")
	public String socialInput = "";
	@ObfuscatedName("client.te")
	public boolean te = false;
	@ObfuscatedName("client.ue")
	public int[] skillLevel = new int[Stats.SKILL_COUNT];
	@ObfuscatedName("client.we")
	public Pix24[] imageMapfunction = new Pix24[100];
	@ObfuscatedName("client.xe")
	public final int[] LOC_SHAPE_TO_LAYER = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};

	@ObfuscatedName("client.De")
	public boolean De = true;
	@ObfuscatedName("client.Ee")
	public int[] varps = new int[2000];
	@ObfuscatedName("client.Le")
	public boolean Le = false;
	@ObfuscatedName("client.Qe")
	public int Qe = 69;
	@ObfuscatedName("client.Se")
	public int Se = -1;
	@ObfuscatedName("client.Te")
	public int[] skillbaseLevel = new int[Stats.SKILL_COUNT];
	@ObfuscatedName("client.Ue")
	public int Ue = 2;
	@ObfuscatedName("client.Ve")
	public int Ve = 3;
	@ObfuscatedName("client.ef")
	public boolean menuVisible = false;
	@ObfuscatedName("client.ff")
	public byte ff = 1;
	@ObfuscatedName("client.gf")
	public boolean withinTutorialIsland = false;
	@ObfuscatedName("client.jf")
	public String[] jf = new String[5];
	@ObfuscatedName("client.kf")
	public boolean[] kf = new boolean[5];
	@ObfuscatedName("client.mf")
	public int mf = 20411;
	@ObfuscatedName("client.nf")
	public long[] ignoreName37 = new long[100];
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
	public int[] tabInterfaceId = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	@ObfuscatedName("client.Cf")
	public CRC32 Cf = new CRC32();
	@ObfuscatedName("client.Df")
	public int Df = -1;
	@ObfuscatedName("client.Ef")
	public int[] waveIds = new int[50];
	@ObfuscatedName("client.Gf")
	public String username = "";
	@ObfuscatedName("client.Hf")
	public String pasword = "";
	@ObfuscatedName("client.Lf")
	public boolean errorHost = false;
	@ObfuscatedName("client.Mf")
	public boolean reportAbuseMuteOption = false;
	@ObfuscatedName("client.Nf")
	public int[] designColours = new int[5];
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
	public boolean scrollGrabbed = false;
	@ObfuscatedName("client.sg")
	public long[] friendName37 = new long[200];
	@ObfuscatedName("client.tg")
	public Packet tg = new Packet(new byte[5000]);
	@ObfuscatedName("client.ug")
	public ClientNpc[] npcs = new ClientNpc[16384];
	@ObfuscatedName("client.wg")
	public int[] npcIds = new int[16384];
	@ObfuscatedName("client.xg")
	public int xg = 7759444;

	@ObfuscatedName("client.zg")
	public boolean ingame = false;
	@ObfuscatedName("client.Cg")
	public int Cg = -110;
	@ObfuscatedName("client.Eg")
	public Pix8[] modIcons = new Pix8[2];
	@ObfuscatedName("client.Fg")
	public byte Fg = -80;
	@ObfuscatedName("client.Gg")
	public boolean designGender = true;
	@ObfuscatedName("client.Hg")
	public int[] cameraModifierCycle = new int[5];
	@ObfuscatedName("client.Pg")
	public Pix8[] imageMapscene = new Pix8[100];

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
	public int[] compassMaskLineOffsets = new int[33];
	@ObfuscatedName("client.rh")
	public boolean redrawSidebar = false;
	@ObfuscatedName("client.sh")
	public Pix24[] sh = new Pix24[20];
	@ObfuscatedName("client.uh")
	public String[] menuOption = new String[500];
	@ObfuscatedName("client.yh")
	public Packet in = Packet.alloc(1);
	@ObfuscatedName("client.zh")
	public int[][] zh = new int[104][104];
	@ObfuscatedName("client.Bh")
	public int stickyChatInterfaceId = -1;
	@ObfuscatedName("client.Th")
	public boolean awaitingSync = false;
	@ObfuscatedName("client.Uh")
	public LinkList Uh = new LinkList();
	@ObfuscatedName("client.Vh")
	public boolean cutscene = false;
	@ObfuscatedName("client.Wh")
	public boolean redrawPrivacySettings = false;
	@ObfuscatedName("client.Xh")
	public int flashingTab = -1;
	@ObfuscatedName("client.mi")
	public FileStream[] fileStreams = new FileStream[5];
	@ObfuscatedName("client.pi")
	public int pi = -1;
	@ObfuscatedName("client.si")
	public int si = 1;
	@ObfuscatedName("client.ui")
	public int ui = 326;
	@ObfuscatedName("client.xi")
	public boolean xi = false;
	@ObfuscatedName("client.yi")
	public boolean redrawChatback = false;
	@ObfuscatedName("client.Bi")
	public volatile boolean flameActive = false;
	@ObfuscatedName("client.Di")
	public byte[] Di = new byte[16384];
	@ObfuscatedName("client.Hi")
	public Component Hi = new Component();
	@ObfuscatedName("client.Ji")
	public int Ji = 128;
	@ObfuscatedName("client.Oi")
	public int Oi = 1;

	@ObfuscatedName("client.Qi")
	public int[] Qi = new int[100];
	@ObfuscatedName("client.Ri")
	public int[] waveDelay = new int[50];
	@ObfuscatedName("client.Si")
	public CollisionMap[] levelCollisionMap = new CollisionMap[4];
	@ObfuscatedName("client.Ti")
	public LinkList locChanges = new LinkList();
	@ObfuscatedName("client.Xi")
	public boolean Xi = false;
	@ObfuscatedName("client.Yi")
	public boolean midiActive = true;
	@ObfuscatedName("client.Zi")
	public int[] friendWorld = new int[200];
	@ObfuscatedName("client.dj")
	public boolean midiFading = true;
	@ObfuscatedName("client.ej")
	public int ej = -1;
	@ObfuscatedName("client.gj")
	public boolean gj = true;
	@ObfuscatedName("client.hj")
	public boolean hj = true;
	@ObfuscatedName("client.ij")
	public int minimapLevel = -1;
	@ObfuscatedName("client.jj")
	public boolean updateDesignModel = false;
	@ObfuscatedName("client.kj")
	public Pix24[] kj = new Pix24[1000];
	@ObfuscatedName("client.lj")
	public int lj = -1;
	@ObfuscatedName("client.nj")
	public int nj = -939;
	@ObfuscatedName("client.oj")
	public LinkList oj = new LinkList();
	@ObfuscatedName("client.pj")
	public boolean errorLoading = false;
	@ObfuscatedName("client.rj")
	public int selectedTab = 3;
	@ObfuscatedName("client.sj")
	public int[] compassMaskLineLengths = new int[33];
	@ObfuscatedName("client.tj")
	public int tj = 3353893;
	@ObfuscatedName("client.uj")
	public Pix24[] uj = new Pix24[32];
	@ObfuscatedName("client.wj")
	public int[] wj = new int[]{17, 24, 34, 40};
	@ObfuscatedName("client.Bj")
	public int[] entityRemovalIds = new int[1000];
	@ObfuscatedName("client.Cj")
	public int[] messageType = new int[100];
	@ObfuscatedName("client.Dj")
	public String[] messageSender = new String[100];
	@ObfuscatedName("client.Ej")
	public String[] messageText = new String[100];
	@ObfuscatedName("client.Hj")
	public boolean waveEnabled = true;
	@ObfuscatedName("client.Uj")
	public volatile boolean Uj = false;
	@ObfuscatedName("client.Xj")
	public byte Xj = -58;
	@ObfuscatedName("client.Yj")
	public int Yj = 416;
	@ObfuscatedName("client.ak")
	public volatile boolean ak = false;
	@ObfuscatedName("client.bk")
	public int[] waveLoops = new int[50];
	@ObfuscatedName("client.dk")
	public LinkList[][][] objStacks = new LinkList[4][104][104];
	@ObfuscatedName("client.gk")
	public int[] designKits = new int[7];
	@ObfuscatedName("client.hk")
	public int nextMidiSong = -1;
	@ObfuscatedName("client.ik")
	public int ik = 409;
	@ObfuscatedName("client.N")
	public static BigInteger N = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");


	@ObfuscatedName("client.Vc")
	public static int[] levelExperience = new int[99];
	@ObfuscatedName("client.gd")
	public static boolean gd;
	@ObfuscatedName("client.Yd")
	public static String Yd;
	@ObfuscatedName("client.Zd")
	public static final int[][] DESIGN_BODY_COLOUR;
	@ObfuscatedName("client.qe")
	public static int qe;
	@ObfuscatedName("client.Ah")
	public static boolean Ah;
	@ObfuscatedName("client.Yh")
	public static int[] Yh;
	@ObfuscatedName("client.Ai")
	public static boolean Ai;
	@ObfuscatedName("client.aj")
	public static final int[] DESIGN_HAIR_COLOUR;
	@ObfuscatedName("client.Wj")
	public static BigInteger Wj;
	@ObfuscatedName("client.Ae")
	public int waveCount;
	@ObfuscatedName("client.Ag")
	public int Ag;
	@ObfuscatedName("client.Aj")
	public int entityRemovalCount;
	@ObfuscatedName("client.Bf")
	public int Bf;
	@ObfuscatedName("client.Bg")
	public static int Bg;
	@ObfuscatedName("client.Ci")
	public int Ci;
	@ObfuscatedName("client.Ei")
	public int overrideChat;
	@ObfuscatedName("client.Fe")
	public int sceneBaseTileX;
	@ObfuscatedName("client.Ff")
	public int currentLevel;
	@ObfuscatedName("client.Fj")
	public int Fj;
	@ObfuscatedName("client.Gd")
	public int baseX;
	@ObfuscatedName("client.Ge")
	public int sceneBaseTileZ;
	@ObfuscatedName("client.Gj")
	public int Gj;
	@ObfuscatedName("client.Hd")
	public int baseZ;
	@ObfuscatedName("client.He")
	public int mapLastBaseX;
	@ObfuscatedName("client.Hh")
	public int hintType;
	@ObfuscatedName("client.Ib")
	public int Ib;
	@ObfuscatedName("client.Ic")
	public int Ic;
	@ObfuscatedName("client.Ie")
	public int mapLastBaseZ;
	@ObfuscatedName("client.If")
	public int dragCycles;
	@ObfuscatedName("client.Ig")
	public int objSelected;
	@ObfuscatedName("client.Ij")
	public int Ij;
	@ObfuscatedName("client.Jd")
	public int Jd;
	@ObfuscatedName("client.Je")
	public int Je;
	@ObfuscatedName("client.Jg")
	public int Jg;
	@ObfuscatedName("client.Jj")
	public int scrollInputPadding;
	@ObfuscatedName("client.Kb")
	public int Kb;
	@ObfuscatedName("client.Kd")
	public int cutsceneDstLocalTileX;
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
	public int cutsceneDstLocalTIleZ;
	@ObfuscatedName("client.Lg")
	public int Lg;
	@ObfuscatedName("client.Li")
	public int Li;
	@ObfuscatedName("client.Lj")
	public int Lj;
	@ObfuscatedName("client.Md")
	public int cutsceneDstHeight;
	@ObfuscatedName("client.Me")
	public int Me;
	@ObfuscatedName("client.Mi")
	public int Mi;
	@ObfuscatedName("client.Mj")
	public int Mj;
	@ObfuscatedName("client.Nd")
	public int cutsceneRotateSpeed;
	@ObfuscatedName("client.Ne")
	public int Ne;
	@ObfuscatedName("client.Ng")
	public int hintPlayer;
	@ObfuscatedName("client.Ni")
	public int Ni;
	@ObfuscatedName("client.Nj")
	public int Nj;
	@ObfuscatedName("client.O")
	public static int O;
	@ObfuscatedName("client.Ob")
	public int Ob;
	@ObfuscatedName("client.Od")
	public int cutsceneRotateAcceleration;
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
	public int hintHeight;
	@ObfuscatedName("client.U")
	public int hintOffsetX;
	@ObfuscatedName("client.Uc")
	public int Uc;
	@ObfuscatedName("client.Uf")
	public int Uf;
	@ObfuscatedName("client.Ui")
	public int Ui;
	@ObfuscatedName("client.V")
	public int hintOffsetZ;
	@ObfuscatedName("client.Vd")
	public int Vd;
	@ObfuscatedName("client.Vi")
	public int Vi;
	@ObfuscatedName("client.Vj")
	public int Vj;

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
	public int ptype0;
	@ObfuscatedName("client.Yc")
	public int Yc;
	@ObfuscatedName("client.Yg")
	public static int Yg;
	@ObfuscatedName("client.Zb")
	public int ptype1;
	@ObfuscatedName("client.Zf")
	public int Zf;
	@ObfuscatedName("client.Zh")
	public int Zh;
	@ObfuscatedName("client.Zj")
	public int inMultizone;
	@ObfuscatedName("client.ab")
	public int ab;
	@ObfuscatedName("client.ac")
	public int ptype2;
	@ObfuscatedName("client.ae")
	public int ae;
	@ObfuscatedName("client.ag")
	public int ag;
	@ObfuscatedName("client.ai")
	public int cameraX;
	@ObfuscatedName("client.bg")
	public int bg;
	@ObfuscatedName("client.bh")
	public static int bh;
	@ObfuscatedName("client.bi")
	public int cameraY;
	@ObfuscatedName("client.bj")
	public int bj;
	@ObfuscatedName("client.cb")
	public int ignoreCount;
	@ObfuscatedName("client.ce")
	public int ce;
	@ObfuscatedName("client.cf")
	public int cf;
	@ObfuscatedName("client.cg")
	public int cg;
	@ObfuscatedName("client.ci")
	public int cameraZ;
	@ObfuscatedName("client.cj")
	public int midiSong;
	@ObfuscatedName("client.ck")
	public int ck;
	@ObfuscatedName("client.de")
	public int de;
	@ObfuscatedName("client.df")
	public int df;
	@ObfuscatedName("client.dg")
	public int dg;
	@ObfuscatedName("client.di")
	public int cameraPitch;
	@ObfuscatedName("client.ee")
	public static int ee;
	@ObfuscatedName("client.eh")
	public static int eh;
	@ObfuscatedName("client.ei")
	public int cameraYaw;
	@ObfuscatedName("client.ek")
	public int runenergy;
	@ObfuscatedName("client.fi")
	public int socialInputType;
	@ObfuscatedName("client.fj")
	public int fj;

	@ObfuscatedName("client.gb")
	public int friendCount;
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
	public int membersAccount;
	@ObfuscatedName("client.hh")
	public int hh;
	@ObfuscatedName("client.hi")
	public int hi;
	@ObfuscatedName("client.ig")
	public int flagSceneTileX;
	@ObfuscatedName("client.ih")
	public int ih;
	@ObfuscatedName("client.jb")
	public int jb;
	@ObfuscatedName("client.jg")
	public int flagSceneTileZ;
	@ObfuscatedName("client.jh")
	public int jh;
	@ObfuscatedName("client.ji")
	public int titleScreenState;
	@ObfuscatedName("client.jk")
	public int jk;
	@ObfuscatedName("client.kc")
	public int kc;
	@ObfuscatedName("client.ki")
	public int hintNpc;
	@ObfuscatedName("client.kk")
	public int kk;
	@ObfuscatedName("client.lc")
	public int lc;
	@ObfuscatedName("client.le")
	public int le;
	@ObfuscatedName("client.lf")
	public int sceneState;
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

	@ObfuscatedName("client.ob")
	public int staffModLevel;
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
	public int psize;
	@ObfuscatedName("client.qd")
	public int entityUpdateCount;
	@ObfuscatedName("client.qf")
	public int qf;
	@ObfuscatedName("client.qg")
	public int nextMusicDelay;
	@ObfuscatedName("client.qj")
	public int qj;
	@ObfuscatedName("client.rb")
	public int ptype;

	@ObfuscatedName("client.rg")
	public int rg;
	@ObfuscatedName("client.ri")
	public int ri;
	@ObfuscatedName("client.sb")
	public int idleNetCycles;
	@ObfuscatedName("client.tb")
	public int tb;

	@ObfuscatedName("client.th")
	public int menuSize;
	@ObfuscatedName("client.ti")
	public static int ti;
	@ObfuscatedName("client.ub")
	public int idleTimeout;
	@ObfuscatedName("client.ud")
	public int ud;
	@ObfuscatedName("client.vb")
	public int vb;
	@ObfuscatedName("client.vd")
	public static int vd;
	@ObfuscatedName("client.ve")
	public int runweight;
	@ObfuscatedName("client.vg")
	public int npcCount;
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
	public int cutsceneSrcHeight;
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
	public long sceneLoadStartTime;
	@ObfuscatedName("client.zc")
	public long serverSeed;
	@ObfuscatedName("client.Jb")
	public Jagfile jagTitle;

	@ObfuscatedName("client.Af")
	public Pix24 Af;
	@ObfuscatedName("client.Be")
	public Pix24 Be;
	@ObfuscatedName("client.Ce")
	public Pix24 Ce;
	@ObfuscatedName("client.Ch")
	public Pix24 imageMapdot0;
	@ObfuscatedName("client.Dh")
	public Pix24 imageMapdot1;
	@ObfuscatedName("client.Eh")
	public Pix24 imageMapdot2;
	@ObfuscatedName("client.Fh")
	public Pix24 imageMapdot3;
	@ObfuscatedName("client.Fi")
	public Pix24 Fi;
	@ObfuscatedName("client.Gh")
	public Pix24 imageMapdot4;
	@ObfuscatedName("client.Qf")
	public Pix24 genderButtonImage0;
	@ObfuscatedName("client.Rf")
	public Pix24 genderButtonImage1;
	@ObfuscatedName("client.eg")
	public Pix24 eg;
	@ObfuscatedName("client.ie")
	public Pix24 ie;
	@ObfuscatedName("client.je")
	public Pix24 je;
	@ObfuscatedName("client.kg")
	public Pix24 imageMinimap;
	@ObfuscatedName("client.pe")
	public ClientStream stream;
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
	public PixMap areaBackleft1;
	@ObfuscatedName("client.cc")
	public PixMap areaBackleft2;
	@ObfuscatedName("client.dc")
	public PixMap areaBackright1;
	@ObfuscatedName("client.ec")
	public PixMap areaBackright2;
	@ObfuscatedName("client.fc")
	public PixMap areaBacktop1;
	@ObfuscatedName("client.gc")
	public PixMap areaBackvmid1;
	@ObfuscatedName("client.hc")
	public PixMap areaBackvmid2;
	@ObfuscatedName("client.ic")
	public PixMap areaBackvmid3;
	@ObfuscatedName("client.jc")
	public PixMap areaBackhmid2;
	@ObfuscatedName("client.Ye")
	public PixFont fontPlain11;
	@ObfuscatedName("client.Ze")
	public PixFont fontPlain12;
	@ObfuscatedName("client.af")
	public PixFont fontBold12;
	@ObfuscatedName("client.bf")
	public PixFont fontQuill8;
	@ObfuscatedName("client.ah")
	public World3D scene;
	@ObfuscatedName("client.Ub")
	public Isaac randomIn;
	@ObfuscatedName("client.Ad")
	public Pix8 imageRedstone1v;
	@ObfuscatedName("client.Bb")
	public Pix8 imageRedstone1;
	@ObfuscatedName("client.Bd")
	public Pix8 imageRedstone2v;
	@ObfuscatedName("client.Cb")
	public Pix8 imageRedstone2;
	@ObfuscatedName("client.Cd")
	public Pix8 imageRedstone3v;
	@ObfuscatedName("client.Db")
	public Pix8 imageRedstone3;
	@ObfuscatedName("client.Dd")
	public Pix8 imageRedstone1hv;
	@ObfuscatedName("client.Eb")
	public Pix8 imageRedstone1h;
	@ObfuscatedName("client.Ed")
	public Pix8 imageRedstone2hv;
	@ObfuscatedName("client.Fb")
	public Pix8 imageRedstone2h;
	@ObfuscatedName("client.Jf")
	public Pix8 imageScrollbar0;
	@ObfuscatedName("client.Kf")
	public Pix8 imageScrollbar1;
	@ObfuscatedName("client.id")
	public Pix8 id;
	@ObfuscatedName("client.jd")
	public Pix8 jd;
	@ObfuscatedName("client.kd")
	public Pix8 kd;
	@ObfuscatedName("client.vh")
	public Pix8 vh;
	@ObfuscatedName("client.wh")
	public Pix8 imageMapback;
	@ObfuscatedName("client.xh")
	public Pix8 xh;
	@ObfuscatedName("client.yj")
	public Pix8 yj;
	@ObfuscatedName("client.zj")
	public Pix8 zj;
	@ObfuscatedName("client.dh")
	public static ClientPlayer localPlayer;
	@ObfuscatedName("client.xj")
	public OnDemand onDemand;
	@ObfuscatedName("client.Mg")
	public String objSelectedName;
	@ObfuscatedName("client.Xe")
	public String modelMessage;
	@ObfuscatedName("client.kh")
	public String kh;
	@ObfuscatedName("client.se")
	public String se;
	@ObfuscatedName("client.ii")
	public Socket ii;

	@ObfuscatedName("client.Rh")
	public static boolean Rh;
	@ObfuscatedName("client.fd")
	public static boolean fd;
	@ObfuscatedName("client.pb")
	public static boolean pb;

	@ObfuscatedName("client.Qj")
	public int[] Qj;
	@ObfuscatedName("client.Rd")
	public int[] areaChatbackOffset;
	@ObfuscatedName("client.Rj")
	public int[] Rj;
	@ObfuscatedName("client.Sd")
	public int[] areaSidebarOffset;
	@ObfuscatedName("client.Sj")
	public int[] Sj;
	@ObfuscatedName("client.Td")
	public int[] areaViewportOffset;
	@ObfuscatedName("client.Tj")
	public int[] Tj;
	@ObfuscatedName("client.Ud")
	public int[] Ud;
	@ObfuscatedName("client.db")
	public int[] db;
	@ObfuscatedName("client.eb")
	public int[] sceneMaplandFile;
	@ObfuscatedName("client.fb")
	public int[] sceneMapLocFile;
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
	public byte[][] sceneMapLandData;
	@ObfuscatedName("client.qi")
	public byte[][] sceneMapLocData;
	@ObfuscatedName("client.ng")
	public byte[][][] levelTileFlags;
	@ObfuscatedName("client.Mb")
	public int[][][] levelHeightmap;

	@ObfuscatedName("client.a(Ljava/lang/String;I)V")
	public final void a(String arg0, int arg1) {
		if (arg0 != null && arg0.length() != 0) {
			String var3 = arg0;
			String[] var4 = new String[100];
			int var5 = 0;

			while (true) {
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
					for (int var9 = 0; var9 < ObjType.count; ++var9) {
						ObjType var10 = ObjType.get(var9);
						if (var10.certtemplate == -1 && var10.name != null) {
							String var11 = var10.name.toLowerCase();

							for (int var12 = 0; var12 < var5; ++var12) {
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
		this.out.pIsaac(110);
		if (arg0) {
			this.objStacks = null;
		}

		if (this.Df != -1) {
			this.a(Ah, this.Df);
			this.Df = -1;
			this.redrawSidebar = true;
			this.xi = false;
			this.redrawSideicons = true;
		}

		if (this.chatInterfaceId != -1) {
			this.a(Ah, this.chatInterfaceId);
			this.chatInterfaceId = -1;
			this.redrawChatback = true;
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
		while (true) {
			if (arg2.bitPos + 10 < arg0 * 8) {
				int var4 = arg2.gBit(11);
				if (var4 != 2047) {
					if (this.players[var4] == null) {
						this.players[var4] = new ClientPlayer();
						if (this.playerAppearanceBuffer[var4] != null) {
							this.players[var4].read(this.playerAppearanceBuffer[var4], 0);
						}
					}

					this.pd[this.od++] = var4;
					ClientPlayer var5 = this.players[var4];
					var5.cycle = loopCycle;
					int var6 = arg2.gBit(5);
					if (var6 > 15) {
						var6 -= 32;
					}

					int var7 = arg2.gBit(1);
					if (var7 == 1) {
						this.entityUpdateIds[this.entityUpdateCount++] = var4;
					}

					int var8 = arg2.gBit(1);
					int var9 = arg2.gBit(5);
					if (var9 > 15) {
						var9 -= 32;
					}

					var5.move(var8 == 1, localPlayer.routeTileX[0] + var6, localPlayer.routeTileZ[0] + var9);
					continue;
				}
			}

			arg2.bytes();
			if (arg1 == 6) {
				boolean var10 = false;
				return;
			}

			this.ptype = -1;
			return;
		}
	}

	public static final void main(String[] args) {
		try {
			System.out.println("RS2 user client - release #" + 377);
			if (args.length != 5) {
				System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
			} else {
				nodeId = Integer.parseInt(args[0]);
				portOffset = Integer.parseInt(args[1]);
				if (args[2].equals("lowmem")) {
					setLowMemory();
				} else {
					if (!args[2].equals("highmem")) {
						System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
						return;
					}

					setHighMemory();
				}

				if (args[3].equals("free")) {
					membersWorld = false;
				} else {
					if (!args[3].equals("members")) {
						System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members], storeid");
						return;
					}

					membersWorld = true;
				}

				SignLink.storeid = Integer.parseInt(args[4]);
				SignLink.startpriv(InetAddress.getLocalHost());
				Client var1 = new Client();
				var1.initApplication(503, 765);
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
			this.objStacks = null;
		}

		try {
			long var3 = System.currentTimeMillis();
			int var5 = 0;
			int var6 = 20;

			while (this.flameActive) {
				++this.Pf;
				this.i((byte) 1);
				this.i((byte) 1);
				this.y(47);
				++var5;
				if (var5 > 10) {
					long var7 = System.currentTimeMillis();
					int var9 = (int) (var7 - var3) / 10 - var6;
					var6 = 40 - var9;
					if (var6 < 5) {
						var6 = 5;
					}

					var5 = 0;
					var3 = var7;
				}

				try {
					Thread.sleep((long) var6);
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
			for (LocChange var2 = (LocChange) this.locChanges.head(); var2 != null; var2 = (LocChange) this.locChanges.next()) {
				if (var2.endTime == -1) {
					var2.p = 0;
					this.a((byte) -61, var2);
				} else {
					var2.unlink();
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

		while (true) {
			while (true) {
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
		this.players = null;
		this.pd = null;
		this.entityUpdateIds = null;
		this.playerAppearanceBuffer = null;
		this.entityRemovalIds = null;
		this.areaBackleft1 = null;
		this.areaBackleft2 = null;
		this.areaBackright1 = null;
		this.areaBackright2 = null;
		this.imageRedstone1 = null;
		this.imageRedstone2 = null;
		this.imageRedstone3 = null;
		this.imageRedstone1h = null;
		this.imageRedstone2h = null;
		this.imageRedstone1v = null;
		this.imageRedstone2v = null;
		this.imageRedstone3v = null;
		this.imageRedstone1hv = null;
		this.imageRedstone2hv = null;
		this.friendName = null;
		this.friendName37 = null;
		this.friendWorld = null;
		this.Wf = null;
		this.Xf = null;
		this.Yf = null;
		this.varps = null;
		this.db = null;
		this.sceneMapLandData = null;
		this.sceneMapLocData = null;
		this.sceneMaplandFile = null;
		this.sceneMapLocFile = null;
		this.Nh = null;
		this.Oh = null;
		this.Ph = null;
		this.Qh = null;
		this.Gb = null;
		this.zh = null;
		this.lg = null;
		this.mg = null;
		this.imageMapdot0 = null;
		this.imageMapdot1 = null;
		this.imageMapdot2 = null;
		this.imageMapdot3 = null;
		this.imageMapdot4 = null;
		if (this.mousetracking != null) {
			this.mousetracking.a = false;
		}

		this.mousetracking = null;
		this.id = null;
		this.jd = null;
		this.kd = null;
		this.areaBacktop1 = null;
		this.areaBackvmid1 = null;
		this.areaBackvmid2 = null;
		this.areaBackvmid3 = null;
		this.areaBackhmid2 = null;
		this.levelHeightmap = null;
		this.levelTileFlags = null;
		this.scene = null;
		this.levelCollisionMap = null;
		this.imageMinimap = null;
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
		this.out = null;
		this.login = null;
		this.in = null;
		this.Sg = null;
		this.Tg = null;
		this.Ug = null;
		this.Vg = null;
		this.vh = null;
		this.imageMapback = null;
		this.xh = null;

		try {
			if (this.stream != null) {
				this.stream.close();
			}
		} catch (Exception var3) {
		}

		this.stream = null;
		this.rf = null;
		this.sf = null;
		this.kj = null;
		this.npcs = null;
		this.npcIds = null;
		this.Di = null;
		this.tg = null;
		this.imageMapscene = null;
		this.imageMapfunction = null;
		this.Hb = null;
		this.td = null;
		this.oj = null;
		this.Uh = null;
		this.Af = null;
		if (this.onDemand != null) {
			this.onDemand.stop();
		}

		this.onDemand = null;
		this.menuParamB = null;
		this.menuParamC = null;
		this.menuAction = null;
		this.menuParamA = null;
		this.menuOption = null;
		this.objStacks = null;
		int var2 = 96 / arg0;
		this.locChanges = null;
		this.H(28614);
		LocType.a(false);
		NpcType.unload(false);
		ObjType.unload();
		Component.clear();
		FloType.e = null;
		IdkType.types = null;
		UnkType.b = null;
		SeqType.types = null;
		SpotAnimType.e = null;
		SpotAnimType.q = null;
		VarpType.types = null;
		super.drawArea = null;
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
			if (super.mouseClickButton == 1) {
				if (super.C >= 539 && super.C <= 573 && super.D >= 169 && super.D < 205 && this.tabInterfaceId[0] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 0;
					this.redrawSideicons = true;
				}

				if (super.C >= 569 && super.C <= 599 && super.D >= 168 && super.D < 205 && this.tabInterfaceId[1] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 1;
					this.redrawSideicons = true;
				}

				if (super.C >= 597 && super.C <= 627 && super.D >= 168 && super.D < 205 && this.tabInterfaceId[2] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 2;
					this.redrawSideicons = true;
				}

				if (super.C >= 625 && super.C <= 669 && super.D >= 168 && super.D < 203 && this.tabInterfaceId[3] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 3;
					this.redrawSideicons = true;
				}

				if (super.C >= 666 && super.C <= 696 && super.D >= 168 && super.D < 205 && this.tabInterfaceId[4] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 4;
					this.redrawSideicons = true;
				}

				if (super.C >= 694 && super.C <= 724 && super.D >= 168 && super.D < 205 && this.tabInterfaceId[5] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 5;
					this.redrawSideicons = true;
				}

				if (super.C >= 722 && super.C <= 756 && super.D >= 169 && super.D < 205 && this.tabInterfaceId[6] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 6;
					this.redrawSideicons = true;
				}

				if (super.C >= 540 && super.C <= 574 && super.D >= 466 && super.D < 502 && this.tabInterfaceId[7] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 7;
					this.redrawSideicons = true;
				}

				if (super.C >= 572 && super.C <= 602 && super.D >= 466 && super.D < 503 && this.tabInterfaceId[8] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 8;
					this.redrawSideicons = true;
				}

				if (super.C >= 599 && super.C <= 629 && super.D >= 466 && super.D < 503 && this.tabInterfaceId[9] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 9;
					this.redrawSideicons = true;
				}

				if (super.C >= 627 && super.C <= 671 && super.D >= 467 && super.D < 502 && this.tabInterfaceId[10] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 10;
					this.redrawSideicons = true;
				}

				if (super.C >= 669 && super.C <= 699 && super.D >= 466 && super.D < 503 && this.tabInterfaceId[11] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 11;
					this.redrawSideicons = true;
				}

				if (super.C >= 696 && super.C <= 726 && super.D >= 466 && super.D < 503 && this.tabInterfaceId[12] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 12;
					this.redrawSideicons = true;
				}

				if (super.C >= 724 && super.C <= 758 && super.D >= 466 && super.D < 502 && this.tabInterfaceId[13] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 13;
					this.redrawSideicons = true;
					return;
				}
			}

		}
	}

	@ObfuscatedName("client.e(I)V")
	public final void e(int arg0) {
		int var2 = 61 / arg0;

		try {
			int var3 = localPlayer.x + this.ab;
			int var4 = localPlayer.z + this.ae;
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
			int var7 = this.getHeightMapY(this.Vi, this.Ui, (byte) 9, this.currentLevel);
			int var8 = 0;
			if (var5 > 3 && var6 > 3 && var5 < 100 && var6 < 100) {
				for (int var9 = var5 - 4; var9 <= var5 + 4; ++var9) {
					for (int var10 = var6 - 4; var10 <= var6 + 4; ++var10) {
						int var11 = this.currentLevel;
						if (var11 < 3 && (this.levelTileFlags[1][var9][var10] & 2) == 2) {
							++var11;
						}

						int var12 = var7 - this.levelHeightmap[var11][var9][var10];
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
			SignLink.reporterror("glfc_ex " + localPlayer.x + "," + localPlayer.z + "," + this.Ui + "," + this.Vi + "," + this.Kb + "," + this.Lb + "," + this.sceneBaseTileX + "," + this.sceneBaseTileZ);
			throw new RuntimeException("eek");
		}
	}

	@ObfuscatedName("client.a(LEWIXBTLV;I)Z")
	public final boolean a(Component arg0, int arg1) {
		int var3 = 98 / arg1;
		int var4 = arg0.clientCode;
		if ((var4 < 1 || var4 > 200) && (var4 < 701 || var4 > 900)) {
			if (var4 >= 401 && var4 <= 500) {
				this.menuOption[this.menuSize] = "Remove @whi@" + arg0.text;
				this.menuAction[this.menuSize] = 859;
				this.menuSize++;
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

			this.menuOption[this.menuSize] = "Remove @whi@" + this.friendName[var4];
			this.menuAction[this.menuSize] = 775;
			this.menuSize++;
			this.menuOption[this.menuSize] = "Message @whi@" + this.friendName[var4];
			this.menuAction[this.menuSize] = 984;
			this.menuSize++;
			return true;
		}
	}

	@ObfuscatedName("client.a(Z[BI)V")
	public final void saveMidi(boolean arg0, byte[] arg1, int arg2) {
		if (this.midiActive) {
			SignLink.midifade = arg0 ? 1 : 0;
			SignLink.midisave(arg1, arg1.length);
			int var4 = 71 / arg2;
		}
	}

	@ObfuscatedName("client.f(I)V")
	public final void f(int arg0) {
		if (arg0 != 0) {
			this.out.p1((int) 186);
		}

		this.updateDesignModel = true;

		for (int var2 = 0; var2 < 7; ++var2) {
			this.designKits[var2] = -1;

			for (int var3 = 0; var3 < IdkType.d; ++var3) {
				if (!IdkType.types[var3].k && IdkType.types[var3].f == var2 + (this.designGender ? 0 : 7)) {
					this.designKits[var2] = var3;
					break;
				}
			}
		}

	}

	@ObfuscatedName("client.b(II)V")
	public final void sortObjStacks(int arg0, int arg1) {
		LinkList var3 = this.objStacks[this.currentLevel][arg0][arg1];
		if (var3 == null) {
			this.scene.a(this.currentLevel, arg0, arg1);
		} else {
			int var4 = -99999999;
			ClientObj var5 = null;

			for (ClientObj var6 = (ClientObj) var3.head(); var6 != null; var6 = (ClientObj) var3.next()) {
				ObjType var7 = ObjType.get(var6.m);
				int var8 = var7.cost;
				if (var7.stackable) {
					var8 = (var6.o + 1) * var8;
				}

				if (var8 > var4) {
					var4 = var8;
					var5 = var6;
				}
			}

			var3.addHead(var5);
			ClientObj var9 = null;
			ClientObj var10 = null;

			for (ClientObj var11 = (ClientObj) var3.head(); var11 != null; var11 = (ClientObj) var3.next()) {
				if (var5.m != var11.m && var9 == null) {
					var9 = var11;
				}

				if (var5.m != var11.m && var9.m != var11.m && var10 == null) {
					var10 = var11;
				}
			}

			int var12 = (arg1 << 7) + arg0 + 1610612736;
			this.scene.a(this.getHeightMapY(arg1 * 128 + 64, arg0 * 128 + 64, (byte) 9, this.currentLevel), this.currentLevel, var5, var9, var12, var10, 2, arg1, arg0);
		}
	}

	@ObfuscatedName("client.d(Z)V")
	public static final void setHighMemory() {
		World3D.lowMemory = false;
		Pix3D.lowMemory = false;
		lowMemory = false;
		World.lowMemory = false;
		LocType.lowMemory = false;
	}

	@ObfuscatedName("client.e(B)V")
	public final void e(byte arg0) {
		if (this.systemUpdateTimer > 1) {
			--this.systemUpdateTimer;
		}

		if (this.idleTimeout > 0) {
			--this.idleTimeout;
		}

		for (int var2 = 0; var2 < 5 && this.readPacket(); ++var2) {
		}

		if (this.ingame) {
			Object var3 = this.mousetracking.c;
			synchronized (this.mousetracking.c) {
				if (!fd) {
					this.mousetracking.f = 0;
				} else if (super.mouseClickButton != 0 || this.mousetracking.f >= 40) {
					this.out.pIsaac(171);
					this.out.p1((int) 0);
					int var4 = this.out.pos;
					int var5 = 0;

					for (int var6 = 0; var6 < this.mousetracking.f && var4 - this.out.pos < 240; ++var6) {
						++var5;
						int var7 = this.mousetracking.b[var6];
						if (var7 < 0) {
							var7 = 0;
						} else if (var7 > 502) {
							var7 = 502;
						}

						int var8 = this.mousetracking.g[var6];
						if (var8 < 0) {
							var8 = 0;
						} else if (var8 > 764) {
							var8 = 764;
						}

						int var9 = var7 * 765 + var8;
						if (this.mousetracking.b[var6] == -1 && this.mousetracking.g[var6] == -1) {
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
								this.out.p2((this.Fj << 12) + (var10 << 6) + var11);
								this.Fj = 0;
							} else if (this.Fj < 8) {
								this.out.p3((this.Fj << 19) + 8388608 + var9);
								this.Fj = 0;
							} else {
								this.out.p4((this.Fj << 19) + -1073741824 + var9);
								this.Fj = 0;
							}
						}
					}

					this.out.psize1((int) (this.out.pos - var4));
					if (var5 >= this.mousetracking.f) {
						this.mousetracking.f = 0;
					} else {
						this.mousetracking.f -= var5;

						for (int var12 = 0; var12 < this.mousetracking.f; ++var12) {
							this.mousetracking.g[var12] = this.mousetracking.g[var5 + var12];
							this.mousetracking.b[var12] = this.mousetracking.b[var5 + var12];
						}
					}
				}
			}

			if (super.mouseClickButton != 0) {
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
				if (super.mouseClickButton == 2) {
					var18 = 1;
				}

				int var19 = (int) var13;
				this.out.pIsaac(19);
				this.out.p4((var18 << 19) + (var19 << 20) + var17);
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
				this.out.pIsaac(140);
				this.out.p2_alt1(this.Ji);
				this.out.p2_alt1(this.Ki);
			}

			if (super.s && !this.hj) {
				this.hj = true;
				this.out.pIsaac(187);
				this.out.p1((int) 1);
			}

			if (!super.s && this.hj) {
				this.hj = false;
				this.out.pIsaac(187);
				this.out.p1((int) 0);
			}

			this.l((byte) -40);
			this.i((int) 16220);
			this.M(-23763);
			++this.idleNetCycles;
			if (this.idleNetCycles > 750) {
				this.tryReconnect();
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
						this.redrawSidebar = true;
					}

					if (this.mk == 3) {
						this.redrawChatback = true;
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
						this.redrawSidebar = true;
					}

					if (this.bg == 3) {
						this.redrawChatback = true;
					}

					this.bg = 0;
					if (this.Rg && this.bj >= 5) {
						this.df = -1;
						this.w(-521);
						if (this.df == this.Zf && this.cf != this.ag) {
							Component var20 = Component.types(this.Zf);
							byte var21 = 0;
							if (this.Yc == 1 && var20.clientCode == 206) {
								var21 = 1;
							}

							if (var20.invSlotObjId[this.cf] <= 0) {
								var21 = 0;
							}

							if (var20.h) {
								int var22 = this.ag;
								int var23 = this.cf;
								var20.invSlotObjId[var23] = var20.invSlotObjId[var22];
								var20.invSlotObjCount[var23] = var20.invSlotObjCount[var22];
								var20.invSlotObjId[var22] = -1;
								var20.invSlotObjCount[var22] = 0;
							} else if (var21 == 1) {
								int var24 = this.ag;
								int var25 = this.cf;

								while (var24 != var25) {
									if (var24 > var25) {
										var20.swapObj(var24, var24 - 1);
										--var24;
									} else if (var24 < var25) {
										var20.swapObj(var24, var24 + 1);
										++var24;
									}
								}
							} else {
								var20.swapObj(this.ag, this.cf);
							}

							this.out.pIsaac(123);
							this.out.p2_alt3(this.cf);
							this.out.p1_alt1(var21);
							this.out.p2_alt2(this.Zf);
							this.out.p2_alt1(this.ag);
						}
					} else if ((this.Gj == 1 || this.b(this.menuSize - 1, this.Xg)) && this.menuSize > 2) {
						this.B(811);
					} else if (this.menuSize > 0) {
						this.h(this.menuSize - 1, 8);
					}

					this.jk = 10;
					super.mouseClickButton = 0;
				}
			}

			if (World3D.U != -1) {
				int var26 = World3D.U;
				int var27 = World3D.V;
				boolean var28 = this.a(true, false, var27, localPlayer.routeTileZ[0], 0, 0, 0, 0, var26, 0, 0, localPlayer.routeTileX[0]);
				World3D.U = -1;
				if (var28) {
					this.le = super.C;
					this.me = super.D;
					this.oe = 1;
					this.ne = 0;
				}
			}

			if (super.mouseClickButton == 1 && this.modelMessage != null) {
				this.modelMessage = null;
				this.redrawChatback = true;
				super.mouseClickButton = 0;
			}

			this.l((int) 0);
			if (this.Se == -1) {
				this.m((byte) 4);
				this.c(false);
				this.f(true);
			}

			if (super.u == 1 || super.mouseClickButton == 1) {
				++this.dragCycles;
			}

			if (this.qj == 0 && this.Je == 0 && this.rg == 0) {
				if (this.Ob > 0) {
					--this.Ob;
				}
			} else if (this.Ob < 100) {
				++this.Ob;
				if (this.Ob == 100) {
					if (this.qj != 0) {
						this.redrawChatback = true;
					}

					if (this.Je != 0) {
						this.redrawSidebar = true;
					}
				}
			}

			if (this.sceneState == 2) {
				this.e((int) 409);
			}

			if (this.sceneState == 2 && this.cutscene) {
				this.e(this.cd);
			}

			for (int var29 = 0; var29 < 5; ++var29) {
				int var10002 = this.cameraModifierCycle[var29]++;
			}

			this.f((byte) 2);
			++super.idleCycles;
			if (super.idleCycles > 4500) {
				this.idleTimeout = 250;
				super.idleCycles -= 500;
				this.out.pIsaac(202);
			}

			++this.gg;
			if (this.gg > 500) {
				this.gg = 0;
				int var30 = (int) (Math.random() * 8.0D);
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
				int var31 = (int) (Math.random() * 8.0D);
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
				this.ptype = this.in.g1();
			}

			if (this.tb > 50) {
				this.out.pIsaac(40);
			}

			try {
				if (this.stream != null && this.out.pos > 0) {
					this.stream.write(0, this.out.pos, 0, this.out.data);
					this.out.pos = 0;
					this.tb = 0;
				}
			} catch (IOException var33) {
				this.tryReconnect();
			} catch (Exception var34) {
				this.logout(true);
			}
		}
	}

	@ObfuscatedName("client.e(Z)V")
	public final void e(boolean arg0) {
		int var2 = this.vb * 128 + 64;
		int var3 = this.wb * 128 + 64;
		int var4 = this.getHeightMapY(var3, var2, (byte) 9, this.currentLevel) - this.cutsceneSrcHeight;
		if (this.cameraX < var2) {
			this.cameraX += (var2 - this.cameraX) * this.zb / 1000 + this.yb;
			if (this.cameraX > var2) {
				this.cameraX = var2;
			}
		}

		if (this.cameraX > var2) {
			this.cameraX -= (this.cameraX - var2) * this.zb / 1000 + this.yb;
			if (this.cameraX < var2) {
				this.cameraX = var2;
			}
		}

		if (this.cameraY < var4) {
			this.cameraY += (var4 - this.cameraY) * this.zb / 1000 + this.yb;
			if (this.cameraY > var4) {
				this.cameraY = var4;
			}
		}

		if (this.cameraY > var4) {
			this.cameraY -= (this.cameraY - var4) * this.zb / 1000 + this.yb;
			if (this.cameraY < var4) {
				this.cameraY = var4;
			}
		}

		if (this.cameraZ < var3) {
			this.cameraZ += (var3 - this.cameraZ) * this.zb / 1000 + this.yb;
			if (this.cameraZ > var3) {
				this.cameraZ = var3;
			}
		}

		if (this.cameraZ > var3) {
			this.cameraZ -= (this.cameraZ - var3) * this.zb / 1000 + this.yb;
			if (this.cameraZ < var3) {
				this.cameraZ = var3;
			}
		}

		int var5 = this.cutsceneDstLocalTileX * 128 + 64;
		int var6 = this.cutsceneDstLocalTIleZ * 128 + 64;
		int var7 = this.getHeightMapY(var6, var5, (byte) 9, this.currentLevel) - this.cutsceneDstHeight;
		int var8 = var5 - this.cameraX;
		int var9 = var7 - this.cameraY;
		int var10 = var6 - this.cameraZ;
		int var11 = (int) Math.sqrt((double) (var8 * var8 + var10 * var10));
		int var12 = (int) (Math.atan2((double) var9, (double) var11) * 325.949D) & 2047;
		if (!arg0) {
			for (int var13 = 1; var13 > 0; ++var13) {
			}
		}

		int var14 = (int) (Math.atan2((double) var8, (double) var10) * -325.949D) & 2047;
		if (var12 < 128) {
			var12 = 128;
		}

		if (var12 > 383) {
			var12 = 383;
		}

		if (this.cameraPitch < var12) {
			this.cameraPitch += (var12 - this.cameraPitch) * this.cutsceneRotateAcceleration / 1000 + this.cutsceneRotateSpeed;
			if (this.cameraPitch > var12) {
				this.cameraPitch = var12;
			}
		}

		if (this.cameraPitch > var12) {
			this.cameraPitch -= (this.cameraPitch - var12) * this.cutsceneRotateAcceleration / 1000 + this.cutsceneRotateSpeed;
			if (this.cameraPitch < var12) {
				this.cameraPitch = var12;
			}
		}

		int var15 = var14 - this.cameraYaw;
		if (var15 > 1024) {
			var15 -= 2048;
		}

		if (var15 < -1024) {
			var15 += 2048;
		}

		if (var15 > 0) {
			this.cameraYaw += this.cutsceneRotateAcceleration * var15 / 1000 + this.cutsceneRotateSpeed;
			this.cameraYaw &= 2047;
		}

		if (var15 < 0) {
			this.cameraYaw -= -var15 * this.cutsceneRotateAcceleration / 1000 + this.cutsceneRotateSpeed;
			this.cameraYaw &= 2047;
		}

		int var16 = var14 - this.cameraYaw;
		if (var16 > 1024) {
			var16 -= 2048;
		}

		if (var16 < -1024) {
			var16 += 2048;
		}

		if (var16 < 0 && var15 > 0 || var16 > 0 && var15 < 0) {
			this.cameraYaw = var14;
		}
	}

	@ObfuscatedName("client.f(B)V")
	public final void f(byte arg0) {
		if (arg0 == 2) {
			boolean var2 = false;

			while (true) {
				int var3;
				do {
					while (true) {
						var3 = this.a((int) -983);
						if (var3 == -1) {
							return;
						}

						if (this.fh != -1 && this.pi == this.fh) {
							if (var3 == 8 && this.reportAbuseInput.length() > 0) {
								this.reportAbuseInput = this.reportAbuseInput.substring(0, this.reportAbuseInput.length() - 1);
							}
							break;
						}

						if (this.showSocialInput) {
							if (var3 >= 32 && var3 <= 122 && this.socialInput.length() < 80) {
								this.socialInput = this.socialInput + (char) var3;
								this.redrawChatback = true;
							}

							if (var3 == 8 && this.socialInput.length() > 0) {
								this.socialInput = this.socialInput.substring(0, this.socialInput.length() - 1);
								this.redrawChatback = true;
							}

							if (var3 == 13 || var3 == 10) {
								this.showSocialInput = false;
								this.redrawChatback = true;
								if (this.socialInputType == 1) {
									long var4 = JString.toBase37(this.socialInput);
									this.addFriend(var4, -45229);
								}

								if (this.socialInputType == 2 && this.friendCount > 0) {
									long var6 = JString.toBase37(this.socialInput);
									this.a(var6, 0);
								}

								if (this.socialInputType == 3 && this.socialInput.length() > 0) {
									this.out.pIsaac(227);
									this.out.p1((int) 0);
									int var8 = this.out.pos;
									this.out.p8(this.Dg);
									WordPack.a(this.socialInput, 569, this.out);
									this.out.psize1((int) (this.out.pos - var8));
									this.socialInput = WordPack.a((byte) 0, this.socialInput);
									this.socialInput = WordFilter.a((byte) 0, (String) this.socialInput);
									this.addMessage(this.socialInput, JString.formatDisplayName(JString.fromBase37(this.Dg)), 6);
									if (this.Ib == 2) {
										this.Ib = 1;
										this.redrawPrivacySettings = true;
										this.out.pIsaac(176);
										this.out.p1(this.Xd);
										this.out.p1(this.Ib);
										this.out.p1(this.li);
									}
								}

								if (this.socialInputType == 4 && this.ignoreCount < 100) {
									long username = JString.toBase37(this.socialInput);
									this.addIgnore(username);
								}

								if (this.socialInputType == 5 && this.ignoreCount > 0) {
									long username = JString.toBase37(this.socialInput);
									this.removeIgnore(username);
								}
							}
						} else if (this.Ci == 1) {
							if (var3 >= 48 && var3 <= 57 && this.chatbackInput.length() < 10) {
								this.chatbackInput = this.chatbackInput + (char) var3;
								this.redrawChatback = true;
							}

							if (var3 == 8 && this.chatbackInput.length() > 0) {
								this.chatbackInput = this.chatbackInput.substring(0, this.chatbackInput.length() - 1);
								this.redrawChatback = true;
							}

							if (var3 == 13 || var3 == 10) {
								if (this.chatbackInput.length() > 0) {
									int var13 = 0;

									try {
										var13 = Integer.parseInt(this.chatbackInput);
									} catch (Exception var23) {
									}

									this.out.pIsaac(75);
									this.out.p4(var13);
								}

								this.Ci = 0;
								this.redrawChatback = true;
							}
						} else if (this.Ci == 2) {
							if (var3 >= 32 && var3 <= 122 && this.chatbackInput.length() < 12) {
								this.chatbackInput = this.chatbackInput + (char) var3;
								this.redrawChatback = true;
							}

							if (var3 == 8 && this.chatbackInput.length() > 0) {
								this.chatbackInput = this.chatbackInput.substring(0, this.chatbackInput.length() - 1);
								this.redrawChatback = true;
							}

							if (var3 == 13 || var3 == 10) {
								if (this.chatbackInput.length() > 0) {
									this.out.pIsaac(206);
									this.out.p8(JString.toBase37(this.chatbackInput));
								}

								this.Ci = 0;
								this.redrawChatback = true;
							}
						} else if (this.Ci == 3) {
							if (var3 >= 32 && var3 <= 122 && this.chatbackInput.length() < 40) {
								this.chatbackInput = this.chatbackInput + (char) var3;
								this.redrawChatback = true;
							}

							if (var3 == 8 && this.chatbackInput.length() > 0) {
								this.chatbackInput = this.chatbackInput.substring(0, this.chatbackInput.length() - 1);
								this.redrawChatback = true;
							}
						} else if (this.chatInterfaceId == -1 && this.Se == -1) {
							if (var3 >= 32 && var3 <= 122 && this.Sf.length() < 80) {
								this.Sf = this.Sf + (char) var3;
								this.redrawChatback = true;
							}

							if (var3 == 8 && this.Sf.length() > 0) {
								this.Sf = this.Sf.substring(0, this.Sf.length() - 1);
								this.redrawChatback = true;
							}

							if ((var3 == 13 || var3 == 10) && this.Sf.length() > 0) {
								if (this.staffModLevel == 2) {
									if (this.Sf.equals("::clientdrop")) {
										this.tryReconnect();
									}

									if (this.Sf.equals("::lag")) {
										this.q(false);
									}

									if (this.Sf.equals("::prefetchmusic")) {
										for (int var14 = 0; var14 < this.onDemand.getFileCount(2); ++var14) {
											this.onDemand.prefetchPriority(2, var14, (byte) 1);
										}
									}

									if (this.Sf.equals("::fpson")) {
										pb = true;
									}

									if (this.Sf.equals("::fpsoff")) {
										pb = false;
									}

									if (this.Sf.equals("::noclip")) {
										for (int var15 = 0; var15 < 4; ++var15) {
											for (int var16 = 1; var16 < 103; ++var16) {
												for (int var17 = 1; var17 < 103; ++var17) {
													this.levelCollisionMap[var15].j[var16][var17] = 0;
												}
											}
										}
									}
								}

								if (this.Sf.startsWith("::")) {
									this.out.pIsaac(56);
									this.out.p1(this.Sf.length() - 1);
									this.out.pjstr(this.Sf.substring(2));
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

									this.out.pIsaac(49);
									this.out.p1((int) 0);
									int var22 = this.out.pos;
									this.out.p1_alt2(var19);
									this.out.p1_alt1(var21);
									this.tg.pos = 0;
									WordPack.a(this.Sf, 569, this.tg);
									this.out.pdata(this.tg.data, 0, this.tg.pos, 0);
									this.out.psize1((int) (this.out.pos - var22));
									this.Sf = WordPack.a((byte) 0, this.Sf);
									this.Sf = WordFilter.a((byte) 0, (String) this.Sf);
									localPlayer.chatMessage = this.Sf;
									localPlayer.chatColour = var19;
									localPlayer.chatEffect = var21;
									localPlayer.chatTimer = 150;
									if (this.staffModLevel == 2) {
										this.addMessage(localPlayer.chatMessage, "@cr2@" + localPlayer.name, 2);
									} else if (this.staffModLevel == 1) {
										this.addMessage(localPlayer.chatMessage, "@cr1@" + localPlayer.name, 2);
									} else {
										this.addMessage(localPlayer.chatMessage, localPlayer.name, 2);
									}

									if (this.Xd == 2) {
										this.Xd = 3;
										this.redrawPrivacySettings = true;
										this.out.pIsaac(176);
										this.out.p1(this.Xd);
										this.out.p1(this.Ib);
										this.out.p1(this.li);
									}
								}

								this.Sf = "";
								this.redrawChatback = true;
							}
						}
					}
				} while ((var3 < 97 || var3 > 122) && (var3 < 65 || var3 > 90) && (var3 < 48 || var3 > 57) && var3 != 32);

				if (this.reportAbuseInput.length() < 12) {
					this.reportAbuseInput = this.reportAbuseInput + (char) var3;
				}
			}
		}
	}

	@ObfuscatedName("client.b(Ljava/lang/String;)Ljava/io/DataInputStream;")
	public final DataInputStream b(String arg0) throws IOException {
		if (!this.Vb) {
			return SignLink.mainapp != null ? SignLink.openurl(arg0) : new DataInputStream((new URL(this.getCodeBase(), arg0)).openStream());
		} else {
			if (this.ii != null) {
				try {
					this.ii.close();
				} catch (Exception var4) {
				}

				this.ii = null;
			}

			this.ii = this.openSocket(43595);
			this.ii.setSoTimeout(10000);
			InputStream var2 = this.ii.getInputStream();
			OutputStream var3 = this.ii.getOutputStream();
			var3.write(("JAGGRAB /" + arg0 + "\n\n").getBytes());
			return new DataInputStream(var2);
		}
	}

	@ObfuscatedName("client.g(I)Ljava/net/Socket;")
	public final Socket openSocket(int arg0) throws IOException {
		return SignLink.mainapp != null ? SignLink.opensocket(arg0) : new Socket(InetAddress.getByName(this.getCodeBase().getHost()), arg0);
	}

	@ObfuscatedName("client.h(I)Z")
	public final boolean readPacket() {
		if (this.stream == null) {
			return false;
		}

		try {
			int available = this.stream.c();
			if (available == 0) {
				return false;
			}

			if (this.ptype == -1) {
				this.stream.a(this.in.data, 0, 1);
				this.ptype = this.in.data[0] & 255;
				if (this.randomIn != null) {
					this.ptype = this.ptype - this.randomIn.nextInt() & 0xFF;
				}
				this.psize = Protocol.SERVERPROT_LENGTH[this.ptype];
				available--;
			}

			if (this.psize == -1) {
				if (available <= 0) {
					return false;
				}

				this.stream.a(this.in.data, 0, 1);
				this.psize = this.in.data[0] & 0xFF;
				available--;
			}

			if (this.psize == -2) {
				if (available <= 1) {
					return false;
				}

				this.stream.a(this.in.data, 0, 2);
				this.in.pos = 0;
				this.psize = this.in.g2();
				available -= 2;
			}

			if (available < this.psize) {
				return false;
			}

			this.in.pos = 0;
			this.stream.a(this.in.data, 0, this.psize);

			this.idleNetCycles = 0;
			this.ptype2 = this.ptype1;
			this.ptype1 = this.ptype0;
			this.ptype0 = this.ptype;

			if (this.ptype == 166) {
				// IF_SETPOSITION
				int var4 = this.in.g2b_alt1();
				int var5 = this.in.g2b_alt1();
				int comId = this.in.g2();

				Component com = Component.types(comId);
				com.s = var5;
				com.X = var4;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 186) {
				int var8 = this.in.g2_alt2();
				int com = this.in.g2_alt3();
				int var10 = this.in.g2_alt2();
				int var11 = this.in.g2_alt1();

				Component.types(com).xan = var8;
				Component.types(com).yan = var11;
				Component.types(com).zoom = var10;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 216) {
				// IF_SETMODEL
				int model = this.in.g2_alt3();
				int comId = this.in.g2_alt3();

				Component.types(comId).modelType = 1;
				Component.types(comId).model = model;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 26) {
				// SYNTH_SOUND
				int id = this.in.g2();
				int loop = this.in.g1();
				int delay = this.in.g2();

				if (delay == 65535 && this.waveCount < 50) {
					this.waveIds[this.waveCount] = (short) id;
					this.waveLoops[this.waveCount] = loop;
					this.waveDelay[this.waveCount] = 0;
					this.waveCount++;
				} else if (this.waveEnabled && !lowMemory && this.waveCount < 50) {
					this.waveIds[this.waveCount] = id;
					this.waveLoops[this.waveCount] = loop;
					this.waveDelay[this.waveCount] = Wave.delays[id] + delay;
					this.waveCount++;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 182) {
				// VARP_SMALL
				int varp = this.in.g2_alt2();
				byte value = this.in.g1b_alt3();

				this.varCache[varp] = value;

				if (this.varps[varp] != value) {
					this.varps[varp] = value;
					this.updateVarp(0, varp);

					this.redrawSidebar = true;

					if (this.stickyChatInterfaceId != -1) {
						this.redrawChatback = true;
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 13) {
				// RESET_ANIMS
				for (int i = 0; i < this.players.length; ++i) {
					if (this.players[i] != null) {
						this.players[i].primarySeqId = -1;
					}
				}

				for (int i = 0; i < this.npcs.length; ++i) {
					if (this.npcs[i] != null) {
						this.npcs[i].primarySeqId = -1;
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 156) {
				this.Pe = this.in.g1();
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 162) {
				// IF_SETNPCHEAD
				int npcId = this.in.g2_alt2();
				int comId = this.in.g2_alt1();

				Component.types(comId).modelType = 2;
				Component.types(comId).model = npcId;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 109) {
				int var23 = this.in.g2();
				this.b((byte) 36, (int) var23);
				if (this.Df != -1) {
					this.a(Ah, this.Df);
					this.Df = -1;
					this.redrawSidebar = true;
					this.redrawSideicons = true;
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

				if (this.chatInterfaceId != var23) {
					this.a(Ah, this.chatInterfaceId);
					this.chatInterfaceId = var23;
				}

				this.xi = false;
				this.redrawChatback = true;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 220) {
				// MIDI_SONG
				int id = this.in.g2_alt3();
				if (id == 65535) {
					id = -1;
				}

				if (this.nextMidiSong != id && this.midiActive && !lowMemory && this.nextMusicDelay == 0) {
					this.midiSong = id;
					this.midiFading = true;
					this.onDemand.request(2, this.midiSong);
				}

				this.nextMidiSong = id;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 249) {
				// MIDI_JINGLE
				int id = this.in.g2_alt1();
				int delay = this.in.g3_alt3();

				if (this.midiActive && !lowMemory) {
					this.midiSong = id;
					this.midiFading = false;
					this.onDemand.request(2, this.midiSong);
					this.nextMusicDelay = delay;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 158) {
				int var27 = this.in.g2b_alt1();
				if (this.stickyChatInterfaceId != var27) {
					this.a(Ah, this.stickyChatInterfaceId);
					this.stickyChatInterfaceId = var27;
				}

				this.redrawChatback = true;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 218) {
				// IF_SETCOLOUR
				int com = this.in.g2();
				int colour = this.in.g2_alt2();

				int r = colour >> 10 & 31;
				int g = colour >> 5 & 31;
				int b = colour & 31;
				Component.types(com).colour = (b << 3) + (r << 19) + (g << 11);

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 157) {
				int var33 = this.in.g1_alt2();
				String var34 = this.in.gjstr();
				int var35 = this.in.g1();
				if (var33 >= 1 && var33 <= 5) {
					if (var34.equalsIgnoreCase("null")) {
						var34 = null;
					}

					this.jf[var33 - 1] = var34;
					this.kf[var33 - 1] = var35 == 0;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 6) {
				this.showSocialInput = false;
				this.Ci = 2;
				this.chatbackInput = "";
				this.redrawChatback = true;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 201) {
				// CHAT_FILTER_SETTINGS
				this.Xd = this.in.g1();
				this.Ib = this.in.g1();
				this.li = this.in.g1();

				this.redrawPrivacySettings = true;
				this.redrawChatback = true;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 199) {
				// HINT_ARROW
				this.hintType = this.in.g1();

				if (this.hintType == 1) {
					this.hintNpc = this.in.g2();
				} else if (this.hintType >= 2 && this.hintType <= 6) {
					if (this.hintType == 2) {
						this.hintOffsetX = 64;
						this.hintOffsetZ = 64;
					} else if (this.hintType == 3) {
						this.hintOffsetX = 0;
						this.hintOffsetZ = 64;
					} else if (this.hintType == 4) {
						this.hintOffsetX = 128;
						this.hintOffsetZ = 64;
					} else if (this.hintType == 5) {
						this.hintOffsetX = 64;
						this.hintOffsetZ = 0;
					} else if (this.hintType == 6) {
						this.hintOffsetX = 64;
						this.hintOffsetZ = 128;
					}

					this.hintType = 2;
					this.R = this.in.g2();
					this.S = this.in.g2();
					this.hintHeight = this.in.g1();
				} else if (this.hintType == 10) {
					this.hintPlayer = this.in.g2();
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 167) {
				// CAM_LOOKAT
				this.cutscene = true;
				this.cutsceneDstLocalTileX = this.in.g1();
				this.cutsceneDstLocalTIleZ = this.in.g1();
				this.cutsceneDstHeight = this.in.g2();
				this.cutsceneRotateSpeed = this.in.g1();
				this.cutsceneRotateAcceleration = this.in.g1();

				if (this.cutsceneRotateAcceleration >= 100) {
					int sceneX = this.cutsceneDstLocalTileX * 128 + 64;
					int sceneZ = this.cutsceneDstLocalTIleZ * 128 + 64;
					int sceneY = this.getHeightMapY(sceneZ, sceneX, (byte) 9, this.currentLevel) - this.cutsceneDstHeight;

					int dx = sceneX - this.cameraX;
					int dy = sceneY - this.cameraY;
					int dz = sceneZ - this.cameraZ;

					int distance = (int) Math.sqrt(dx * dx + dz * dz);

					this.cameraPitch = (int) (Math.atan2(dy, distance) * 325.949D) & 2047;
					this.cameraYaw = (int) (Math.atan2(dx, dz) * -325.949D) & 2047;

					if (this.cameraPitch < 128) {
						this.cameraPitch = 128;
					}

					if (this.cameraPitch > 383) {
						this.cameraPitch = 383;
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 5) {
				// LOGOUT
				this.logout(true);

				this.ptype = -1;
				return false;
			}

			if (this.ptype == 115) {
				// VARP_LARGE
				int value = this.in.g4_alt3();
				int varp = this.in.g2_alt1();

				this.varCache[varp] = value;

				if (this.varps[varp] != value) {
					this.varps[varp] = value;
					this.updateVarp(0, varp);

					this.redrawSidebar = true;

					if (this.stickyChatInterfaceId != -1) {
						this.redrawChatback = true;
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 29) {
				if (this.Df != -1) {
					this.a(Ah, this.Df);
					this.Df = -1;
					this.redrawSidebar = true;
					this.redrawSideicons = true;
				}

				if (this.chatInterfaceId != -1) {
					this.a(Ah, this.chatInterfaceId);
					this.chatInterfaceId = -1;
					this.redrawChatback = true;
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
					this.redrawChatback = true;
				}

				this.xi = false;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 76) {
				// LAST_LOGIN_INFO / Welcome screen thing?
				this.xf = this.in.g2_alt1();
				this.pf = this.in.g2_alt3();
				this.in.g2();
				this.Sh = this.in.g2();
				this.gh = this.in.g2_alt1();
				this.fj = this.in.g2_alt2();
				this.Zh = this.in.g2_alt2();
				this.Jd = this.in.g2();
				this.zi = this.in.g4_alt1();
				this.ze = this.in.g2_alt3();
				this.in.g1_alt1();
				SignLink.dnslookup(JString.formatIPv4(this.zi));
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 63) {
				// MESSAGE_GAME
				String message = this.in.gjstr();

				if (message.endsWith(":tradereq:")) {
					String player = message.substring(0, message.indexOf(":"));
					long username37 = JString.toBase37(player);

					boolean ignored = false;
					for (int i = 0; i < this.ignoreCount; ++i) {
						if (this.ignoreName37[i] == username37) {
							ignored = true;
							break;
						}
					}

					if (!ignored && this.overrideChat == 0) {
						this.addMessage("wishes to trade with you.", player, 4);
					}
				} else if (message.endsWith(":duelreq:")) {
					String player = message.substring(0, message.indexOf(":"));
					long username37 = JString.toBase37(player);

					boolean ignored = false;
					for (int i = 0; i < this.ignoreCount; ++i) {
						if (this.ignoreName37[i] == username37) {
							ignored = true;
							break;
						}
					}

					if (!ignored && this.overrideChat == 0) {
						this.addMessage("wishes to duel with you.", player, 8);
					}
				} else if (!message.endsWith(":chalreq:")) {
					this.addMessage(message, "", 0);
				} else {
					String player = message.substring(0, message.indexOf(":"));
					long username37 = JString.toBase37(player);

					boolean ignored = false;
					for (int i = 0; i < this.ignoreCount; ++i) {
						if (this.ignoreName37[i] == username37) {
							ignored = true;
							break;
						}
					}

					if (!ignored && this.overrideChat == 0) {
						String mes = message.substring(message.indexOf(":") + 1, message.length() - 9);
						this.addMessage(mes, player, 8);
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 50) {
				int var62 = this.in.gb2();
				if (var62 >= 0) {
					this.b((byte) 36, (int) var62);
				}

				if (this.lj != var62) {
					this.a(Ah, this.lj);
					this.lj = var62;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 82) {
				// IF_SETHIDE
				boolean hide = this.in.g1() == 1;
				int comId = this.in.g2();
				Component.types(comId).hide = hide;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 174) {
				// UPDATE_RUNWEIGHT
				if (this.selectedTab == 12) {
					this.redrawSidebar = true;
				}

				this.runweight = this.in.gb2();

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 233) {
				// SET_MULTIWAY
				this.inMultizone = this.in.g1();

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 61) {
				// UNSET_MAP_FLAG
				this.flagSceneTileX = 0;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 128) {
				int var65 = this.in.g2_alt2();
				int var66 = this.in.g2_alt3();

				if (this.chatInterfaceId != -1) {
					this.a(Ah, this.chatInterfaceId);
					this.chatInterfaceId = -1;
					this.redrawChatback = true;
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
					this.redrawChatback = true;
				}

				this.redrawSidebar = true;
				this.redrawSideicons = true;
				this.xi = false;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 67) {
				// CAM_SHAKE
				int type = this.in.g1();
				int var68 = this.in.g1();
				int var69 = this.in.g1();
				int var70 = this.in.g1();

				this.cameraModifierEnabled[type] = true;
				this.Tf[type] = var68;
				this.Z[type] = var69;
				this.Id[type] = var70;
				this.cameraModifierCycle[type] = 0;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 134) {
				// UPDATE_INV_PARTIAL
				this.redrawSidebar = true;

				int comId = this.in.g2();
				Component inv = Component.types(comId);

				while (this.in.pos < this.psize) {
					int slot = this.in.gsmarts();
					int id = this.in.g2();

					int count = this.in.g1();
					if (count == 255) {
						count = this.in.g4();
					}

					if (slot >= 0 && slot < inv.invSlotObjId.length) {
						inv.invSlotObjId[slot] = id;
						inv.invSlotObjCount[slot] = count;
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 78) {
				// UPDATE_FRIENDLIST
				long username = this.in.g8();
				int world = this.in.g1();

				String displayName = JString.formatDisplayName(JString.fromBase37(username));

				for (int i = 0; i < this.friendCount; ++i) {
					if (this.friendName37[i] == username) {
						if (this.friendWorld[i] != world) {
							this.friendWorld[i] = world;
							this.redrawSidebar = true;
							if (world > 0) {
								this.addMessage(displayName + " has logged in.", "", 5);
							}

							if (world == 0) {
								this.addMessage(displayName + " has logged out.", "", 5);
							}
						}

						displayName = null;
						break;
					}
				}

				if (displayName != null && this.friendCount < 200) {
					this.friendName37[this.friendCount] = username;
					this.friendName[this.friendCount] = displayName;
					this.friendWorld[this.friendCount] = world;
					this.friendCount++;
					this.redrawSidebar = true;
				}

				boolean sorted = false;
				while (!sorted) {
					sorted = true;

					for (int i = 0; i < this.friendCount - 1; ++i) {
						if (this.friendWorld[i] != nodeId && this.friendWorld[i + 1] == nodeId || this.friendWorld[i] == 0 && this.friendWorld[i + 1] != 0) {
							int oldWorld = this.friendWorld[i];
							this.friendWorld[i] = this.friendWorld[i + 1];
							this.friendWorld[i + 1] = oldWorld;

							String oldName = this.friendName[i];
							this.friendName[i] = this.friendName[i + 1];
							this.friendName[i + 1] = oldName;

							long oldName37 = this.friendName37[i];
							this.friendName37[i] = this.friendName37[i + 1];
							this.friendName37[i + 1] = oldName37;

							this.redrawSidebar = true;
							sorted = false;
						}
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 58) {
				this.showSocialInput = false;
				this.Ci = 1;
				this.chatbackInput = "";
				this.redrawChatback = true;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 252) {
				// IF_SETTAB_ACTIVE
				this.selectedTab = this.in.g1_alt2();

				this.redrawSidebar = true;
				this.redrawSideicons = true;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 40) {
				// UPDATE_ZONE_FULL_FOLLOWS
				this.baseZ = this.in.g1_alt3();
				this.baseX = this.in.g1_alt2();

				for (int x = this.baseX; x < this.baseX + 8; ++x) {
					for (int z = this.baseZ; z < this.baseZ + 8; ++z) {
						if (this.objStacks[this.currentLevel][x][z] != null) {
							this.objStacks[this.currentLevel][x][z] = null;
							this.sortObjStacks(x, z);
						}
					}
				}

				for (LocChange loc = (LocChange) this.locChanges.head(); loc != null; loc = (LocChange) this.locChanges.next()) {
					if (loc.x >= this.baseX && loc.x < this.baseX + 8 && loc.z >= this.baseZ && loc.z < this.baseZ + 8 && this.currentLevel == loc.l) {
						loc.endTime = 0;
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 255) {
				// IF_SETPLAYERHEAD
				int comId = this.in.g2_alt3();

				Component.types(comId).modelType = 3;

				if (localPlayer.Eb == null) {
					Component.types(comId).model = (localPlayer.appearance[11] << 5) + (localPlayer.appearance[8] << 10) + (localPlayer.appearance[0] << 15) + (localPlayer.colour[0] << 25) + (localPlayer.colour[4] << 20) + localPlayer.appearance[1];
				} else {
					Component.types(comId).model = (int) (localPlayer.Eb.id + 305419896L);
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 135) {
				// CHAT
				long username37 = this.in.g8();
				int var93 = this.in.g4();
				int type = this.in.g1();

				boolean ignored = false;

				for (int i = 0; i < 100; ++i) {
					if (this.Qi[i] == var93) {
						ignored = true;
						break;
					}
				}

				if (type <= 1) {
					for (int i = 0; i < this.ignoreCount; ++i) {
						if (this.ignoreName37[i] == username37) {
							ignored = true;
							break;
						}
					}
				}

				if (!ignored && this.overrideChat == 0) {
					try {
						this.Qi[this.Og] = var93;
						this.Og = (this.Og + 1) % 100;
						String filtered = WordPack.a(0, this.in, this.psize - 13);
						if (type != 3) {
							filtered = WordFilter.a((byte) 0, (String) filtered);
						}

						if (type != 2 && type != 3) {
							if (type == 1) {
								this.addMessage(filtered, "@cr1@" + JString.formatDisplayName(JString.fromBase37(username37)), 7);
							} else {
								this.addMessage(filtered, JString.formatDisplayName(JString.fromBase37(username37)), 3);
							}
						} else {
							this.addMessage(filtered, "@cr2@" + JString.formatDisplayName(JString.fromBase37(username37)), 7);
						}
					} catch (Exception ignore) {
						SignLink.reporterror("cde1");
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 183) {
				// UPDATE_ZONE_PARTIAL_ENCLOSED
				this.baseX = this.in.g1();
				this.baseZ = this.in.g1_alt1();

				while (this.in.pos < this.psize) {
					int ptype = this.in.g1();
					this.readZonePacket(this.in, 0, ptype);
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 159) {
				int var101 = this.in.g2_alt3();
				this.b((byte) 36, (int) var101);
				if (this.Df != -1) {
					this.a(Ah, this.Df);
					this.Df = -1;
					this.redrawSidebar = true;
					this.redrawSideicons = true;
				}

				if (this.chatInterfaceId != -1) {
					this.a(Ah, this.chatInterfaceId);
					this.chatInterfaceId = -1;
					this.redrawChatback = true;
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
					this.redrawChatback = true;
				}

				this.xi = false;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 246) {
				int var102 = this.in.g2_alt3();
				this.b((byte) 36, (int) var102);
				if (this.chatInterfaceId != -1) {
					this.a(Ah, this.chatInterfaceId);
					this.chatInterfaceId = -1;
					this.redrawChatback = true;
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
					this.redrawChatback = true;
				}

				this.redrawSidebar = true;
				this.redrawSideicons = true;
				this.xi = false;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 49) {
				// UPDATE_STAT
				this.redrawSidebar = true;

				int stat = this.in.g1_alt2();
				int level = this.in.g1();
				int xp = this.in.g4();

				this.skillExperience[stat] = xp;
				this.skillLevel[stat] = level;
				this.skillbaseLevel[stat] = 1;

				for (int i = 0; i < 98; ++i) {
					if (xp >= levelExperience[i]) {
						this.skillbaseLevel[stat] = i + 2;
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 206) {
				// UPDATE_INV_FULL
				this.redrawSidebar = true;

				int comId = this.in.g2();
				Component com = Component.types(comId);
				int size = this.in.g2();

				for (int i = 0; i < size; ++i) {
					com.invSlotObjId[i] = this.in.g2_alt3();

					int count = this.in.g1_alt2();
					if (count == 255) {
						count = this.in.g4_alt1();
					}

					com.invSlotObjCount[i] = count;
				}

				for (int i = size; i < com.invSlotObjId.length; ++i) {
					com.invSlotObjId[i] = 0;
					com.invSlotObjCount[i] = 0;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 222 || this.ptype == 53) {
				int var113 = this.Kb;
				int var114 = this.Lb;
				if (this.ptype == 222) {
					var114 = this.in.g2();
					var113 = this.in.g2_alt3();
					this.Zg = false;
				}

				if (this.ptype == 53) {
					var113 = this.in.g2_alt2();
					this.in.bits();
					int var115 = 0;

					while (true) {
						if (var115 >= 4) {
							this.in.bytes();
							var114 = this.in.g2_alt2();
							this.Zg = true;
							break;
						}

						for (int var116 = 0; var116 < 13; ++var116) {
							for (int var117 = 0; var117 < 13; ++var117) {
								int var118 = this.in.gBit(1);
								if (var118 == 1) {
									this.Ab[var115][var116][var117] = this.in.gBit(26);
								} else {
									this.Ab[var115][var116][var117] = -1;
								}
							}
						}

						++var115;
					}
				}

				if (this.Kb == var113 && this.Lb == var114 && this.sceneState == 2) {
					this.ptype = -1;
					return true;
				}

				this.Kb = var113;
				this.Lb = var114;
				this.sceneBaseTileX = (this.Kb - 6) * 8;
				this.sceneBaseTileZ = (this.Lb - 6) * 8;

				this.withinTutorialIsland = false;
				if ((this.Kb / 8 == 48 || this.Kb / 8 == 49) && this.Lb / 8 == 48) {
					this.withinTutorialIsland = true;
				}

				if (this.Kb / 8 == 48 && this.Lb / 8 == 148) {
					this.withinTutorialIsland = true;
				}

				this.sceneState = 1;
				this.sceneLoadStartTime = System.currentTimeMillis();

				this.a(-332, (String) null, "Loading - please wait.");
				if (this.ptype == 222) {
					int var119 = 0;
					int var120 = (this.Kb - 6) / 8;

					label1207:
					while (true) {
						if (var120 > (this.Kb + 6) / 8) {
							this.sceneMapLandData = new byte[var119][];
							this.sceneMapLocData = new byte[var119][];
							this.db = new int[var119];
							this.sceneMaplandFile = new int[var119];
							this.sceneMapLocFile = new int[var119];
							int var122 = 0;
							int var123 = (this.Kb - 6) / 8;

							while (true) {
								if (var123 > (this.Kb + 6) / 8) {
									break label1207;
								}

								for (int var124 = (this.Lb - 6) / 8; var124 <= (this.Lb + 6) / 8; ++var124) {
									this.db[var122] = (var123 << 8) + var124;

									if (this.withinTutorialIsland && (var124 == 49 || var124 == 149 || var124 == 147 || var123 == 50 || var123 == 49 && var124 == 47)) {
										this.sceneMaplandFile[var122] = -1;
										this.sceneMapLocFile[var122] = -1;
										++var122;
									} else {
										int var125 = this.sceneMaplandFile[var122] = this.onDemand.getMapFile((int) var124, var123, 0);
										if (var125 != -1) {
											this.onDemand.request(3, var125);
										}

										int var126 = this.sceneMapLocFile[var122] = this.onDemand.getMapFile((int) var124, var123, 1);
										if (var126 != -1) {
											this.onDemand.request(3, var126);
										}

										++var122;
									}
								}

								++var123;
							}
						}

						for (int var121 = (this.Lb - 6) / 8; var121 <= (this.Lb + 6) / 8; ++var121) {
							++var119;
						}

						++var120;
					}
				}

				if (this.ptype == 53) {
					int var127 = 0;
					int[] var128 = new int[676];
					int var129 = 0;

					label1168:
					while (true) {
						if (var129 >= 4) {
							this.sceneMapLandData = new byte[var127][];
							this.sceneMapLocData = new byte[var127][];
							this.db = new int[var127];
							this.sceneMaplandFile = new int[var127];
							this.sceneMapLocFile = new int[var127];

							int mapCount = 0;
							while (true) {
								if (mapCount >= var127) {
									break label1168;
								}

								int var138 = this.db[mapCount] = var128[mapCount];
								int x = var138 >> 8 & 0xFF;
								int z = var138 & 0xFF;

								int landFile = this.sceneMaplandFile[mapCount] = this.onDemand.getMapFile((int) z, x, 0);
								if (landFile != -1) {
									this.onDemand.request(3, landFile);
								}

								int locFile = this.sceneMapLocFile[mapCount] = this.onDemand.getMapFile((int) z, x, 1);
								if (locFile != -1) {
									this.onDemand.request(3, locFile);
								}

								++mapCount;
							}
						}

						for (int var130 = 0; var130 < 13; ++var130) {
							for (int var131 = 0; var131 < 13; ++var131) {
								int var132 = this.Ab[var129][var130][var131];
								if (var132 != -1) {
									int var133 = var132 >> 14 & 1023;
									int var134 = var132 >> 3 & 2047;
									int var135 = (var133 / 8 << 8) + var134 / 8;

									for (int var136 = 0; var136 < var127; ++var136) {
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

				int dx = this.sceneBaseTileX - this.mapLastBaseX;
				int dz = this.sceneBaseTileZ - this.mapLastBaseZ;
				this.mapLastBaseX = this.sceneBaseTileX;
				this.mapLastBaseZ = this.sceneBaseTileZ;

				for (int i = 0; i < 16384; ++i) {
					ClientNpc npc = this.npcs[i];
					if (npc != null) {
						for (int j = 0; j < 10; ++j) {
							npc.routeTileX[j] -= dx;
							npc.routeTileZ[j] -= dz;
						}

						npc.x -= dx * 128;
						npc.z -= dz * 128;
					}
				}

				for (int i = 0; i < this.MAX_PLAYER_COUNT; ++i) {
					ClientPlayer player = this.players[i];
					if (player != null) {
						for (int j = 0; j < 10; ++j) {
							player.routeTileX[j] -= dx;
							player.routeTileZ[j] -= dz;
						}

						player.x -= dx * 128;
						player.z -= dz * 128;
					}
				}

				this.awaitingSync = true;

				byte startTileX = 0;
				byte endTileX = 104;
				byte dirX = 1;
				if (dx < 0) {
					startTileX = 103;
					endTileX = -1;
					dirX = -1;
				}

				byte startTileZ = 0;
				byte endTileZ = 104;
				byte dirZ = 1;
				if (dz < 0) {
					startTileZ = 103;
					endTileZ = -1;
					dirZ = -1;
				}

				for (int x = startTileX; endTileX != x; x += dirX) {
					for (int z = startTileZ; endTileZ != z; z += dirZ) {
						int lastX = dx + x;
						int lastZ = dz + z;

						for (int level = 0; level < 4; ++level) {
							if (lastX >= 0 && lastZ >= 0 && lastX < 104 && lastZ < 104) {
								this.objStacks[level][x][z] = this.objStacks[level][lastX][lastZ];
							} else {
								this.objStacks[level][x][z] = null;
							}
						}
					}
				}

				for (LocChange loc = (LocChange) this.locChanges.head(); loc != null; loc = (LocChange) this.locChanges.next()) {
					loc.x -= dx;
					loc.z -= dz;
					if (loc.x < 0 || loc.z < 0 || loc.x >= 104 || loc.z >= 104) {
						loc.unlink();
					}
				}

				if (this.flagSceneTileX != 0) {
					this.flagSceneTileX -= dx;
					this.flagSceneTileZ -= dz;
				}

				this.cutscene = false;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 190) {
				// UPDATE_REBOOT_TIMER
				this.systemUpdateTimer = this.in.g2_alt1() * 30;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 41 || this.ptype == 121 || this.ptype == 203 || this.ptype == 106 || this.ptype == 59 || this.ptype == 181 || this.ptype == 208 || this.ptype == 107 || this.ptype == 142 || this.ptype == 88 || this.ptype == 152) {
				this.readZonePacket(this.in, 0, this.ptype);
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 125) {
				// UPDATE_RUNENERGY
				if (this.selectedTab == 12) {
					this.redrawSidebar = true;
				}

				this.runenergy = this.in.g1();

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 21) {
				// IF_SETOBJECT
				int zoom = this.in.g2();
				int objId = this.in.g2_alt1();
				int com = this.in.g2_alt3();

				if (objId == 65535) {
					Component.types(com).modelType = 0;
					this.ptype = -1;
					return true;
				}

				ObjType obj = ObjType.get(objId);
				Component.types(com).modelType = 4;
				Component.types(com).model = objId;
				Component.types(com).xan = obj.xan2d;
				Component.types(com).yan = obj.yan2d;
				Component.types(com).zoom = obj.zoom2d * 100 / zoom;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 3) {
				// CAM_MOVETO
				this.cutscene = true;

				this.vb = this.in.g1();
				this.wb = this.in.g1();
				this.cutsceneSrcHeight = this.in.g2();
				this.yb = this.in.g1();
				this.zb = this.in.g1();

				if (this.zb >= 100) {
					this.cameraX = this.vb * 128 + 64;
					this.cameraZ = this.wb * 128 + 64;
					this.cameraY = this.getHeightMapY(this.cameraZ, this.cameraX, (byte) 9, this.currentLevel) - this.cutsceneSrcHeight;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 2) {
				// IF_SETANIM
				int comId = this.in.g2_alt3();
				int seqId = this.in.g2b_alt2();

				Component com = Component.types(comId);
				if (com.anim != seqId || seqId == -1) {
					com.anim = seqId;
					com.z = 0;
					com.r = 0;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 71) {
				// NPC_INFO
				this.getNpcPos(this.in, this.De, this.psize);
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 226) {
				// UPDATE_IGNORELIST
				this.ignoreCount = this.psize / 8;
				for (int i = 0; i < this.ignoreCount; ++i) {
					this.ignoreName37[i] = this.in.g8();
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 10) {
				// IF_SETTAB
				int tab = this.in.g1_alt3();
				int comId = this.in.g2_alt2();

				if (comId == 65535) {
					comId = -1;
				}

				if (this.tabInterfaceId[tab] != comId) {
					this.a(Ah, this.tabInterfaceId[tab]);
					this.tabInterfaceId[tab] = comId;
				}

				this.redrawSidebar = true;
				this.redrawSideicons = true;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 219) {
				// UPDATE_INV_STOP_TRANSIT
				int comId = this.in.g2_alt1();
				Component inv = Component.types(comId);

				for (int i = 0; i < inv.invSlotObjId.length; ++i) {
					inv.invSlotObjId[i] = -1;
					inv.invSlotObjId[i] = 0;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 238) {
				// TUT_FLASH
				this.flashingTab = this.in.g1();
				if (this.selectedTab == this.flashingTab) {
					if (this.flashingTab == 3) {
						this.selectedTab = 1;
					} else {
						this.selectedTab = 3;
					}

					this.redrawSidebar = true;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 148) {
				// CAM_RESET
				this.cutscene = false;

				for (int i = 0; i < 5; ++i) {
					this.cameraModifierEnabled[i] = false;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 126) {
				// UPDATE_PID
				this.membersAccount = this.in.g1();
				this.localPid = this.in.g2_alt1();
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 75) {
				// UPDATE_ZONE_PARTIAL_FOLLOWS
				this.baseX = this.in.g1_alt2();
				this.baseZ = this.in.g1_alt1();

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 253) {
				int var177 = this.in.g2_alt1();
				int var178 = this.in.g2_alt2();
				this.b((byte) 36, (int) var178);
				if (var177 != -1) {
					this.b((byte) 36, (int) var177);
				}

				if (this.fh != -1) {
					this.a(Ah, this.fh);
					this.fh = -1;
				}

				if (this.Df != -1) {
					this.a(Ah, this.Df);
					this.Df = -1;
				}

				if (this.chatInterfaceId != -1) {
					this.a(Ah, this.chatInterfaceId);
					this.chatInterfaceId = -1;
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
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 251) {
				this.hb = this.in.g1();

				this.redrawSidebar = true;

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 18) {
				int var179 = this.in.g2();
				int var180 = this.in.g2_alt2();
				int var181 = this.in.g2_alt1();
				Component.types(var180).i = (var179 << 16) + var181;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 90) {
				// PLAYER_INFO
				this.getPlayerPos(this.psize, (int) 69, (Packet) this.in);
				this.awaitingSync = false;
				this.ptype = -1;
				return true;
			}

			if (this.ptype == 113) {
				// RESET_CLIENT_VARCACHE
				for (int i = 0; i < this.varps.length; ++i) {
					if (this.varCache[i] != this.varps[i]) {
						this.varps[i] = this.varCache[i];
						this.updateVarp(0, i);
						this.redrawSidebar = true;
					}
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 232) {
				// IF_SETTEXT
				int comId = this.in.g2_alt3();
				String text = this.in.gjstr();

				Component.types(comId).text = text;

				int selectedTab = this.tabInterfaceId[this.selectedTab];
				if (Component.types(comId).layer == selectedTab) {
					this.redrawSidebar = true;
				}

				this.ptype = -1;
				return true;
			}

			if (this.ptype == 200) {
				int comId = this.in.g2();
				int var186 = this.in.g2_alt3();

				Component var187 = Component.types(comId);
				if (var187 != null && var187.type == 0) {
					if (var186 < 0) {
						var186 = 0;
					}

					if (var186 > var187.scroll - var187.width) {
						var186 = var187.scroll - var187.width;
					}

					var187.scrollPosition = var186;
				}

				this.ptype = -1;
				return true;
			}

			SignLink.reporterror("T1 - " + this.ptype + "," + this.psize + " - " + this.ptype1 + "," + this.ptype2);
			this.logout(true);
		} catch (IOException var192) {
			this.tryReconnect();
		} catch (Exception var193) {
			String var189 = "T2 - " + this.ptype + "," + this.ptype1 + "," + this.ptype2 + " - " + this.psize + "," + (localPlayer.routeTileX[0] + this.sceneBaseTileX) + "," + (localPlayer.routeTileZ[0] + this.sceneBaseTileZ) + " - ";

			for (int var190 = 0; var190 < this.psize && var190 < 50; ++var190) {
				var189 = var189 + this.in.data[var190] + ",";
			}

			SignLink.reporterror(var189);
			this.logout(true);
		}

		return true;
	}

	@ObfuscatedName("client.g(B)V")
	public final void g(byte arg0) {
		if (this.menuSize >= 2 || this.objSelected != 0 || this.hh != 0) {
			if (arg0 == -79) {
				String var2;
				if (this.objSelected == 1 && this.menuSize < 2) {
					var2 = "Use " + this.objSelectedName + " with...";
				} else if (this.hh == 1 && this.menuSize < 2) {
					var2 = this.kh + "...";
				} else {
					var2 = this.menuOption[this.menuSize - 1];
				}

				if (this.menuSize > 2) {
					var2 = var2 + "@whi@ / " + (this.menuSize - 2) + " more options";
				}

				this.fontBold12.a(true, loopCycle / 1000, 4, 16777215, 15, var2, 0);
			}
		}
	}

	@ObfuscatedName("client.a(ZZIIIIIIIIII)Z")
	public final boolean a(boolean arg0, boolean arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
		byte var13 = 104;
		byte var14 = 104;

		for (int var15 = 0; var15 < var13; ++var15) {
			for (int var16 = 0; var16 < var14; ++var16) {
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
		int[][] var23 = this.levelCollisionMap[this.currentLevel].j;

		while (var40 != var20) {
			var17 = this.lg[var20];
			var18 = this.mg[var20];
			var20 = (var20 + 1) % var22;
			if (arg8 == var17 && arg2 == var18) {
				var21 = true;
				break;
			}

			if (arg7 != 0) {
				if ((arg7 < 5 || arg7 == 10) && this.levelCollisionMap[this.currentLevel].a(arg8, 0, arg2, arg7 - 1, var17, var18, arg10)) {
					var21 = true;
					break;
				}

				if (arg7 < 10 && this.levelCollisionMap[this.currentLevel].b(-37, var18, arg8, var17, arg10, arg7 - 1, arg2)) {
					var21 = true;
					break;
				}
			}

			if (arg4 != 0 && arg5 != 0 && this.levelCollisionMap[this.currentLevel].a(arg4, var17, true, arg8, arg9, arg5, arg2, var18)) {
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

			for (int var28 = arg8 - var27; var28 <= arg8 + var27; ++var28) {
				for (int var29 = arg2 - var27; var29 <= arg2 + var27; ++var29) {
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
			this.load();
		}

		this.lg[var33] = var17;
		int var41 = var33 + 1;
		this.mg[var33] = var18;
		int var34;
		int var35 = var34 = this.Gb[var17][var18];

		while (arg11 != var17 || arg3 != var18) {
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
				this.out.pIsaac(28);
				this.out.p1(var36 + var36 + 3);
			}

			if (arg6 == 1) {
				this.out.pIsaac(213);
				this.out.p1(var36 + var36 + 3 + 14);
			}

			if (arg6 == 2) {
				this.out.pIsaac(247);
				this.out.p1(var36 + var36 + 3);
			}

			this.out.p2_alt3(this.sceneBaseTileX + var37);
			this.out.p1(super.F[5] == 1 ? 1 : 0);
			this.out.p2_alt3(this.sceneBaseTileZ + var38);
			this.flagSceneTileX = this.lg[0];
			this.flagSceneTileZ = this.mg[0];

			for (int var39 = 1; var39 < var36; ++var39) {
				--var41;
				this.out.p1(this.lg[var41] - var37);
				this.out.p1_alt3((int) (this.mg[var41] - var38));
			}

			return true;
		}
	}

	@ObfuscatedName("client.i(I)V")
	public final void i(int arg0) {
		if (arg0 != 16220) {
			this.ik = 458;
		}

		if (this.sceneState == 2) {
			for (LocChange var2 = (LocChange) this.locChanges.head(); var2 != null; var2 = (LocChange) this.locChanges.next()) {
				if (var2.endTime > 0) {
					--var2.endTime;
				}

				if (var2.endTime == 0) {
					if (var2.h < 0 || World.a(var2.j, this.Fg, var2.h)) {
						this.addLoc(var2.i, var2.x, var2.h, var2.z, var2.l, var2.j, (byte) 1, var2.m);
						var2.unlink();
					}
				} else {
					if (var2.p > 0) {
						--var2.p;
					}

					if (var2.p == 0 && var2.x >= 1 && var2.z >= 1 && var2.x <= 102 && var2.z <= 102 && (var2.e < 0 || World.a(var2.g, this.Fg, var2.e))) {
						this.addLoc(var2.f, var2.x, var2.e, var2.z, var2.l, var2.g, (byte) 1, var2.m);
						var2.p = -1;
						if (var2.h == var2.e && var2.h == -1) {
							var2.unlink();
						} else if (var2.h == var2.e && var2.i == var2.f && var2.j == var2.g) {
							var2.unlink();
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("client.j(I)Ljava/lang/String;")
	public final String getHost(int arg0) {
		if (arg0 != -42588) {
			this.ptype = this.in.g1();
		}

		if (SignLink.mainapp != null) {
			return SignLink.mainapp.getDocumentBase().getHost().toLowerCase();
		} else {
			return super.frame != null ? "runescape.com" : super.getDocumentBase().getHost().toLowerCase();
		}
	}

	@ObfuscatedName("client.a(IIILZGNGQRPJ;I)V")
	public final void a(int arg0, int arg1, int arg2, ClientPlayer arg3, int arg4) {
		if (localPlayer != arg3) {
			if (this.menuSize < 400) {
				if (arg4 != 0) {
					gd = !gd;
				}

				String var6;
				if (arg3.Gb == 0) {
					var6 = arg3.name + getCombatLevelColorTag(arg3.vislevel, localPlayer.vislevel) + " (level-" + arg3.vislevel + ")";
				} else {
					var6 = arg3.name + " (skill-" + arg3.Gb + ")";
				}

				if (this.objSelected == 1) {
					this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @whi@" + var6;
					this.menuAction[this.menuSize] = 596;
					this.menuParamA[this.menuSize] = arg0;
					this.menuParamB[this.menuSize] = arg2;
					this.menuParamC[this.menuSize] = arg1;
					this.menuSize++;
				} else if (this.hh == 1) {
					if ((this.jh & 8) == 8) {
						this.menuOption[this.menuSize] = this.kh + " @whi@" + var6;
						this.menuAction[this.menuSize] = 918;
						this.menuParamA[this.menuSize] = arg0;
						this.menuParamB[this.menuSize] = arg2;
						this.menuParamC[this.menuSize] = arg1;
						this.menuSize++;
					}
				} else {
					for (int var7 = 4; var7 >= 0; --var7) {
						if (this.jf[var7] != null) {
							this.menuOption[this.menuSize] = this.jf[var7] + " @whi@" + var6;
							short var8 = 0;
							if (this.jf[var7].equalsIgnoreCase("attack")) {
								if (arg3.vislevel > localPlayer.vislevel) {
									var8 = 2000;
								}

								if (localPlayer.Nb != 0 && arg3.Nb != 0) {
									if (localPlayer.Nb == arg3.Nb) {
										var8 = 2000;
									} else {
										var8 = 0;
									}
								}
							} else if (this.kf[var7]) {
								var8 = 2000;
							}

							if (var7 == 0) {
								this.menuAction[this.menuSize] = var8 + 200;
							}

							if (var7 == 1) {
								this.menuAction[this.menuSize] = var8 + 493;
							}

							if (var7 == 2) {
								this.menuAction[this.menuSize] = var8 + 408;
							}

							if (var7 == 3) {
								this.menuAction[this.menuSize] = var8 + 677;
							}

							if (var7 == 4) {
								this.menuAction[this.menuSize] = var8 + 876;
							}

							this.menuParamA[this.menuSize] = arg0;
							this.menuParamB[this.menuSize] = arg2;
							this.menuParamC[this.menuSize] = arg1;
							this.menuSize++;
						}
					}
				}

				for (int var9 = 0; var9 < this.menuSize; ++var9) {
					if (this.menuAction[var9] == 14) {
						this.menuOption[var9] = "Walk here @whi@" + var6;
						return;
					}
				}

			}
		}
	}

	@ObfuscatedName("client.f(Z)V")
	public final void f(boolean arg0) {
		if (!arg0) {
			this.objStacks = null;
		}

		if (super.mouseClickButton == 1) {
			if (super.C >= 6 && super.C <= 106 && super.D >= 467 && super.D <= 499) {
				this.Xd = (this.Xd + 1) % 4;
				this.redrawPrivacySettings = true;
				this.redrawChatback = true;
				this.out.pIsaac(176);
				this.out.p1(this.Xd);
				this.out.p1(this.Ib);
				this.out.p1(this.li);
			}

			if (super.C >= 135 && super.C <= 235 && super.D >= 467 && super.D <= 499) {
				this.Ib = (this.Ib + 1) % 3;
				this.redrawPrivacySettings = true;
				this.redrawChatback = true;
				this.out.pIsaac(176);
				this.out.p1(this.Xd);
				this.out.p1(this.Ib);
				this.out.p1(this.li);
			}

			if (super.C >= 273 && super.C <= 373 && super.D >= 467 && super.D <= 499) {
				this.li = (this.li + 1) % 3;
				this.redrawPrivacySettings = true;
				this.redrawChatback = true;
				this.out.pIsaac(176);
				this.out.p1(this.Xd);
				this.out.p1(this.Ib);
				this.out.p1(this.li);
			}

			if (super.C >= 412 && super.C <= 512 && super.D >= 467 && super.D <= 499) {
				if (this.fh == -1) {
					this.b(false);
					this.reportAbuseInput = "";
					this.reportAbuseMuteOption = false;
					this.pi = this.fh = Component.K;
				} else {
					this.addMessage("Please close the interface you have open before using 'report abuse'", "", 0);
				}
			}

			++Wg;
			if (Wg > 161) {
				Wg = 0;
				this.out.pIsaac(22);
				this.out.p2(38304);
				return;
			}
		}

	}

	@ObfuscatedName("client.a(ILMFMVIYHT;I)V")
	public final void a(int size, Packet buf, int arg2) {
		for (int i = 0; i < this.entityUpdateCount; ++i) {
			int var5 = this.entityUpdateIds[i];
			ClientPlayer player = this.players[var5];

			int mask = buf.g1();
			if ((mask & 32) != 0) {
				mask += buf.g1() << 8;
			}

			this.getPlayerExtendedInfo(buf, player, var5, mask);
		}
	}

	@ObfuscatedName("client.a(IZLMFMVIYHT;)V")
	public final void a(int arg0, boolean arg1, Packet arg2) {
		arg2.bits();
		int var4 = arg2.gBit(1);
		if (var4 != 0) {
			int var5 = arg2.gBit(2);
			this.ingame &= arg1;
			if (var5 == 0) {
				this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
			} else if (var5 == 1) {
				int var6 = arg2.gBit(3);
				localPlayer.step(false, var6);
				int var7 = arg2.gBit(1);
				if (var7 == 1) {
					this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
				}

			} else if (var5 == 2) {
				int var8 = arg2.gBit(3);
				localPlayer.step(true, var8);
				int var9 = arg2.gBit(3);
				localPlayer.step(true, var9);
				int var10 = arg2.gBit(1);
				if (var10 == 1) {
					this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
				}

			} else if (var5 == 3) {
				int var11 = arg2.gBit(1);
				this.currentLevel = arg2.gBit(2);
				int var12 = arg2.gBit(7);
				int var13 = arg2.gBit(7);
				int var14 = arg2.gBit(1);
				if (var14 == 1) {
					this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
				}

				localPlayer.move(var11 == 1, var13, var12);
			}
		}
	}

	@ObfuscatedName("client.a(IILEWIXBTLV;BIIIII)V")
	public final void handleScrollInput(int scrollHeight, int arg1, Component com, int arg4, int arg5, int arg6, int height, int arg8) {
		if (this.scrollGrabbed) {
			this.scrollInputPadding = 32;
		} else {
			this.scrollInputPadding = 0;
		}

		this.scrollGrabbed = false;

		if (arg6 >= arg8 && arg6 < arg8 + 16 && arg4 >= arg1 && arg4 < arg1 + 16) {
			com.scrollPosition -= this.dragCycles * 4;

			if (arg5 == 1) {
				this.redrawSidebar = true;
			}

			if (arg5 == 2 || arg5 == 3) {
				this.redrawChatback = true;
			}

		} else if (arg6 >= arg8 && arg6 < arg8 + 16 && arg4 >= arg1 + height - 16 && arg4 < arg1 + height) {
			com.scrollPosition += this.dragCycles * 4;

			if (arg5 == 1) {
				this.redrawSidebar = true;
			}

			if (arg5 == 2 || arg5 == 3) {
				this.redrawChatback = true;
			}

		} else if (arg6 >= arg8 - this.scrollInputPadding && arg6 < arg8 + 16 + this.scrollInputPadding && arg4 >= arg1 + 16 && arg4 < arg1 + height - 16 && this.dragCycles > 0) {
			int gripSize = (height - 32) * height / scrollHeight;
			if (gripSize < 8) {
				gripSize = 8;
			}

			int gripY = arg4 - arg1 - 16 - gripSize / 2;
			int maxY = height - 32 - gripSize;

			com.scrollPosition = (scrollHeight - height) * gripY / maxY;

			if (arg5 == 1) {
				this.redrawSidebar = true;
			}

			if (arg5 == 2 || arg5 == 3) {
				this.redrawChatback = true;
			}

			this.scrollGrabbed = true;
		}
	}

	@ObfuscatedName("client.h(B)V")
	public final void handleViewportOptions(byte arg0) {
		if (this.objSelected == 0 && this.hh == 0) {
			this.menuOption[this.menuSize] = "Walk here";
			this.menuAction[this.menuSize] = 14;
			this.menuParamB[this.menuSize] = super.v;
			this.menuParamC[this.menuSize] = super.w;
			this.menuSize++;
		}

		int lastTypeCode = -1;
		if (arg0 != 7) {
			this.ptype = -1;
		}

		for (int picked = 0; picked < Model.Gb; ++picked) {
			int typeCode = Model.pickedBitsets[picked];
			int x = typeCode & 127;
			int z = typeCode >> 7 & 127;
			int entityType = typeCode >> 29 & 3;
			int typeId = typeCode >> 14 & 32767;

			if (lastTypeCode != typeCode) {
				lastTypeCode = typeCode;
				if (entityType == 2 && this.scene.getInfo(this.currentLevel, x, z, typeCode) >= 0) {
					LocType loc = LocType.a(typeId);

					if (loc.V != null) {
						loc = loc.b(0);
					}

					if (loc == null) {
						continue;
					}

					if (this.objSelected == 1) {
						this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @cya@" + loc.name;
						this.menuAction[this.menuSize] = 467;
						this.menuParamA[this.menuSize] = typeCode;
						this.menuParamB[this.menuSize] = x;
						this.menuParamC[this.menuSize] = z;
						this.menuSize++;
					} else if (this.hh == 1) {
						if ((this.jh & 4) == 4) {
							this.menuOption[this.menuSize] = this.kh + " @cya@" + loc.name;
							this.menuAction[this.menuSize] = 376;
							this.menuParamA[this.menuSize] = typeCode;
							this.menuParamB[this.menuSize] = x;
							this.menuParamC[this.menuSize] = z;
							this.menuSize++;
						}
					} else {
						if (loc.G != null) {
							for (int i = 4; i >= 0; --i) {
								if (loc.G[i] != null) {
									this.menuOption[this.menuSize] = loc.G[i] + " @cya@" + loc.name;
									if (i == 0) {
										this.menuAction[this.menuSize] = 35;
									}

									if (i == 1) {
										this.menuAction[this.menuSize] = 389;
									}

									if (i == 2) {
										this.menuAction[this.menuSize] = 888;
									}

									if (i == 3) {
										this.menuAction[this.menuSize] = 892;
									}

									if (i == 4) {
										this.menuAction[this.menuSize] = 1280;
									}

									this.menuParamA[this.menuSize] = typeCode;
									this.menuParamB[this.menuSize] = x;
									this.menuParamC[this.menuSize] = z;
									this.menuSize++;
								}
							}
						}

						this.menuOption[this.menuSize] = "Examine @cya@" + loc.name;
						this.menuAction[this.menuSize] = 1412;
						this.menuParamA[this.menuSize] = loc.p << 14;
						this.menuParamB[this.menuSize] = x;
						this.menuParamC[this.menuSize] = z;
						this.menuSize++;
					}
				}

				if (entityType == 1) {
					ClientNpc var11 = this.npcs[typeId];
					if (var11.type.size == 1 && (var11.x & 127) == 64 && (var11.z & 127) == 64) {
						for (int var12 = 0; var12 < this.npcCount; ++var12) {
							ClientNpc var13 = this.npcs[this.npcIds[var12]];
							if (var13 != null && var11 != var13 && var13.type.size == 1 && var11.x == var13.x && var11.z == var13.z) {
								this.a(var13.type, z, x, this.npcIds[var12], (byte) -76);
							}
						}

						for (int var14 = 0; var14 < this.od; ++var14) {
							ClientPlayer var15 = this.players[this.pd[var14]];
							if (var15 != null && var11.x == var15.x && var11.z == var15.z) {
								this.a(this.pd[var14], z, x, var15, 0);
							}
						}
					}

					this.a(var11.type, z, x, typeId, (byte) -76);
				}

				if (entityType == 0) {
					ClientPlayer var16 = this.players[typeId];
					if ((var16.x & 127) == 64 && (var16.z & 127) == 64) {
						for (int var17 = 0; var17 < this.npcCount; ++var17) {
							ClientNpc var18 = this.npcs[this.npcIds[var17]];
							if (var18 != null && var18.type.size == 1 && var16.x == var18.x && var16.z == var18.z) {
								this.a(var18.type, z, x, this.npcIds[var17], (byte) -76);
							}
						}

						for (int var19 = 0; var19 < this.od; ++var19) {
							ClientPlayer var20 = this.players[this.pd[var19]];
							if (var20 != null && var16 != var20 && var16.x == var20.x && var16.z == var20.z) {
								this.a(this.pd[var19], z, x, var20, 0);
							}
						}
					}

					this.a(typeId, z, x, var16, 0);
				}

				if (entityType == 3) {
					LinkList var21 = this.objStacks[this.currentLevel][x][z];
					if (var21 != null) {
						for (ClientObj var22 = (ClientObj) var21.tail(); var22 != null; var22 = (ClientObj) var21.prev()) {
							ObjType var23 = ObjType.get(var22.m);
							if (this.objSelected == 1) {
								this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @lre@" + var23.name;
								this.menuAction[this.menuSize] = 100;
								this.menuParamA[this.menuSize] = var22.m;
								this.menuParamB[this.menuSize] = x;
								this.menuParamC[this.menuSize] = z;
								this.menuSize++;
							} else if (this.hh == 1) {
								if ((this.jh & 1) == 1) {
									this.menuOption[this.menuSize] = this.kh + " @lre@" + var23.name;
									this.menuAction[this.menuSize] = 199;
									this.menuParamA[this.menuSize] = var22.m;
									this.menuParamB[this.menuSize] = x;
									this.menuParamC[this.menuSize] = z;
									this.menuSize++;
								}
							} else {
								for (int var24 = 4; var24 >= 0; --var24) {
									if (var23.op != null && var23.op[var24] != null) {
										this.menuOption[this.menuSize] = var23.op[var24] + " @lre@" + var23.name;
										if (var24 == 0) {
											this.menuAction[this.menuSize] = 68;
										}

										if (var24 == 1) {
											this.menuAction[this.menuSize] = 26;
										}

										if (var24 == 2) {
											this.menuAction[this.menuSize] = 684;
										}

										if (var24 == 3) {
											this.menuAction[this.menuSize] = 930;
										}

										if (var24 == 4) {
											this.menuAction[this.menuSize] = 270;
										}

										this.menuParamA[this.menuSize] = var22.m;
										this.menuParamB[this.menuSize] = x;
										this.menuParamC[this.menuSize] = z;
										this.menuSize++;
									} else if (var24 == 2) {
										this.menuOption[this.menuSize] = "Take @lre@" + var23.name;
										this.menuAction[this.menuSize] = 684;
										this.menuParamA[this.menuSize] = var22.m;
										this.menuParamB[this.menuSize] = x;
										this.menuParamC[this.menuSize] = z;
										this.menuSize++;
									}
								}

								this.menuOption[this.menuSize] = "Examine @lre@" + var23.name;
								this.menuAction[this.menuSize] = 1564;
								this.menuParamA[this.menuSize] = var22.m;
								this.menuParamB[this.menuSize] = x;
								this.menuParamC[this.menuSize] = z;
								this.menuSize++;
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("client.a(ZI)V")
	public final void a(boolean arg0, int arg1) {
		Component.a(arg1);
	}

	@ObfuscatedName("client.a(IIIIIIBI)V")
	public final void addLoc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, byte arg6, int layer) {
		if (arg1 >= 1 && arg3 >= 1 && arg1 <= 102 && arg3 <= 102) {
			if (lowMemory && this.currentLevel != arg4) {
				return;
			}

			int typeCode = 0;
			boolean var10 = true;
			boolean var11 = false;
			boolean var12 = false;
			if (layer == 0) {
				typeCode = this.scene.b(arg4, arg1, arg3);
			}

			if (layer == 1) {
				typeCode = this.scene.b(arg1, (byte) 4, arg4, arg3);
			}

			if (layer == 2) {
				typeCode = this.scene.c(arg4, arg1, arg3);
			}

			if (layer == 3) {
				typeCode = this.scene.d(arg4, arg1, arg3);
			}

			if (typeCode != 0) {
				int var13 = this.scene.getInfo(arg4, arg1, arg3, typeCode);
				int var14 = typeCode >> 14 & 32767;
				int var15 = var13 & 31;
				int var16 = var13 >> 6;
				if (layer == 0) {
					this.scene.a(arg3, arg4, arg1, true);
					LocType var17 = LocType.a(var14);
					if (var17.ab) {
						this.levelCollisionMap[arg4].a(var16, arg1, 0, arg3, var15, var17.Z);
					}
				}

				if (layer == 1) {
					this.scene.a(false, arg1, arg3, arg4);
				}

				if (layer == 2) {
					this.scene.b(arg3, (int) arg4, -779, arg1);
					LocType var18 = LocType.a(var14);
					if (var18.R + arg1 > 103 || var18.R + arg3 > 103 || var18.r + arg1 > 103 || var18.r + arg3 > 103) {
						return;
					}

					if (var18.ab) {
						this.levelCollisionMap[arg4].a(this.Ue, arg3, arg1, var16, var18.r, var18.Z, var18.R);
					}
				}

				if (layer == 3) {
					this.scene.a(arg1, arg3, true, arg4);
					LocType var19 = LocType.a(var14);
					if (var19.ab && var19.b) {
						this.levelCollisionMap[arg4].a(arg1, (byte) -122, arg3);
					}
				}
			}

			if (arg2 >= 0) {
				int var20 = arg4;
				if (arg4 < 3 && (this.levelTileFlags[1][arg1][arg3] & 2) == 2) {
					var20 = arg4 + 1;
				}

				World.a(arg2, var20, arg5, arg3, this.levelCollisionMap[arg4], arg0, arg1, 0, arg4, this.scene, this.levelHeightmap);
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

		if (var4 < this.npcCount) {
			for (int var5 = var4; var5 < this.npcCount; ++var5) {
				this.entityRemovalIds[this.entityRemovalCount++] = this.npcIds[var5];
			}
		}

		if (var4 > this.npcCount) {
			SignLink.reporterror(this.username + " Too many npcs");
			throw new RuntimeException("eek");
		} else {
			this.npcCount = 0;

			for (int var6 = 0; var6 < var4; ++var6) {
				int var7 = this.npcIds[var6];
				ClientNpc var8 = this.npcs[var7];
				int var9 = arg2.gBit(1);
				if (var9 == 0) {
					this.npcIds[this.npcCount++] = var7;
					var8.cycle = loopCycle;
				} else {
					int var10 = arg2.gBit(2);
					if (var10 == 0) {
						this.npcIds[this.npcCount++] = var7;
						var8.cycle = loopCycle;
						this.entityUpdateIds[this.entityUpdateCount++] = var7;
					} else if (var10 == 1) {
						this.npcIds[this.npcCount++] = var7;
						var8.cycle = loopCycle;
						int var11 = arg2.gBit(3);
						var8.step(false, var11);
						int var12 = arg2.gBit(1);
						if (var12 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = var7;
						}
					} else if (var10 == 2) {
						this.npcIds[this.npcCount++] = var7;
						var8.cycle = loopCycle;
						int var13 = arg2.gBit(3);
						var8.step(true, var13);
						int var14 = arg2.gBit(3);
						var8.step(true, var14);
						int var15 = arg2.gBit(1);
						if (var15 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = var7;
						}
					} else if (var10 == 3) {
						this.entityRemovalIds[this.entityRemovalCount++] = var7;
					}
				}
			}

		}
	}

	@ObfuscatedName("client.a(Ljava/lang/String;BLjava/lang/String;I)V")
	public final void addMessage(String text, String sender, int type) {
		if (type == 0 && this.stickyChatInterfaceId != -1) {
			this.modelMessage = text;
			super.mouseClickButton = 0;
		}

		if (this.chatInterfaceId == -1) {
			this.redrawChatback = true;
		}

		for (int i = 99; i > 0; --i) {
			this.messageType[i] = this.messageType[i - 1];
			this.messageSender[i] = this.messageSender[i - 1];
			this.messageText[i] = this.messageText[i - 1];
		}

		this.messageType[0] = type;
		this.messageSender[0] = sender;
		this.messageText[0] = text;
	}

	@ObfuscatedName("client.a(LMFMVIYHT;ZI)V")
	public final void getNpcPos(Packet buf, boolean arg1, int size) {
		this.ingame &= arg1;
		this.entityRemovalCount = 0;
		this.entityUpdateCount = 0;

		this.b(size, (byte) -58, buf);
		this.a(buf, size, false);
		this.a(buf, size, 838);

		for (int i = 0; i < this.entityRemovalCount; ++i) {
			int id = this.entityRemovalIds[i];
			if (loopCycle != this.npcs[id].cycle) {
				this.npcs[id].type = null;
				this.npcs[id] = null;
			}
		}

		if (buf.pos != size) {
			SignLink.reporterror(this.username + " size mismatch in getnpcpos - pos:" + buf.pos + " psize:" + size);
			throw new RuntimeException("eek");
		} else {
			for (int i = 0; i < this.npcCount; ++i) {
				if (this.npcs[this.npcIds[i]] == null) {
					SignLink.reporterror(this.username + " null entry in npc list - pos:" + i + " size:" + this.npcCount);
					throw new RuntimeException("eek");
				}
			}
		}
	}

	@ObfuscatedName("client.k(I)V")
	public final void k(int arg0) {
		LocType.v.clear();
		LocType.e.clear();
		NpcType.modelCache.clear();
		ObjType.modelCache.clear();
		ObjType.iconCache.clear();
		ClientPlayer.Ib.clear();
		SpotAnimType.q.clear();
	}

	@ObfuscatedName("client.g(Z)V")
	public final void g(boolean arg0) {
		SignLink.midiplay = false;
		if (arg0) {
			this.hg = 466;
		}

		SignLink.midifade = 0;
		SignLink.midi = "stop";
	}

	@ObfuscatedName("client.h(Z)V")
	public final void h(boolean arg0) {
		ClientProj var2 = (ClientProj) this.oj.head();
		if (arg0) {
			this.ik = 153;
		}

		while (var2 != null) {
			if (this.currentLevel == var2.n && loopCycle <= var2.z) {
				if (loopCycle >= var2.y) {
					if (var2.t > 0) {
						ClientNpc var3 = this.npcs[var2.t - 1];
						if (var3 != null && var3.x >= 0 && var3.x < 13312 && var3.z >= 0 && var3.z < 13312) {
							var2.a(var3.x, var3.z, this.getHeightMapY(var3.z, var3.x, (byte) 9, var2.n) - var2.M, loopCycle, 0);
						}
					}

					if (var2.t < 0) {
						int var4 = -var2.t - 1;
						ClientPlayer var5;
						if (this.localPid == var4) {
							var5 = localPlayer;
						} else {
							var5 = this.players[var4];
						}

						if (var5 != null && var5.x >= 0 && var5.x < 13312 && var5.z >= 0 && var5.z < 13312) {
							var2.a(var5.x, var5.z, this.getHeightMapY(var5.z, var5.x, (byte) 9, var2.n) - var2.M, loopCycle, 0);
						}
					}

					var2.a(this.Uc, false);
					this.scene.a(-1, var2, (int) var2.o, (int) var2.q, false, 0, this.currentLevel, 60, (int) var2.p, var2.v);
				}
			} else {
				var2.unlink();
			}

			var2 = (ClientProj) this.oj.next();
		}

		++eh;
		if (eh > 51) {
			eh = 0;
			this.out.pIsaac(248);
		}
	}

	@ObfuscatedName("client.i(Z)V")
	public final void i(boolean arg0) {
		this.yj = new Pix8(this.jagTitle, "titlebox", 0);
		this.zj = new Pix8(this.jagTitle, "titlebutton", 0);
		this.fg = new Pix8[12];
		if (arg0) {
			this.load();
		}

		for (int var2 = 0; var2 < 12; ++var2) {
			this.fg[var2] = new Pix8(this.jagTitle, "runes", var2);
		}

		this.ie = new Pix24(128, 265);
		this.je = new Pix24(128, 265);

		for (int var3 = 0; var3 < 33920; ++var3) {
			this.ie.pixels[var3] = this.Lh.b[var3];
		}

		for (int var4 = 0; var4 < 33920; ++var4) {
			this.je.pixels[var4] = this.Mh.b[var4];
		}

		this.Rj = new int[256];

		for (int var5 = 0; var5 < 64; ++var5) {
			this.Rj[var5] = var5 * 262144;
		}

		for (int var6 = 0; var6 < 64; ++var6) {
			this.Rj[var6 + 64] = var6 * 1024 + 16711680;
		}

		for (int var7 = 0; var7 < 64; ++var7) {
			this.Rj[var7 + 128] = var7 * 4 + 16776960;
		}

		for (int var8 = 0; var8 < 64; ++var8) {
			this.Rj[var8 + 192] = 16777215;
		}

		this.Sj = new int[256];

		for (int var9 = 0; var9 < 64; ++var9) {
			this.Sj[var9] = var9 * 1024;
		}

		for (int var10 = 0; var10 < 64; ++var10) {
			this.Sj[var10 + 64] = var10 * 4 + 65280;
		}

		for (int var11 = 0; var11 < 64; ++var11) {
			this.Sj[var11 + 128] = var11 * 262144 + 65535;
		}

		for (int var12 = 0; var12 < 64; ++var12) {
			this.Sj[var12 + 192] = 16777215;
		}

		this.Tj = new int[256];

		for (int var13 = 0; var13 < 64; ++var13) {
			this.Tj[var13] = var13 * 4;
		}

		for (int var14 = 0; var14 < 64; ++var14) {
			this.Tj[var14 + 64] = var14 * 262144 + 255;
		}

		for (int var15 = 0; var15 < 64; ++var15) {
			this.Tj[var15 + 128] = var15 * 1024 + 16711935;
		}

		for (int var16 = 0; var16 < 64; ++var16) {
			this.Tj[var16 + 192] = 16777215;
		}

		this.Qj = new int[256];
		this.mh = new int[32768];
		this.nh = new int[32768];
		this.a((Pix8) null, 0);
		this.yf = new int[32768];
		this.zf = new int[32768];
		this.drawProgress(10, true, (String) "Connecting to fileserver");
		if (!this.flameActive) {
			this.Uj = true;
			this.flameActive = true;
			this.startThread((Runnable) this, 2);
		}
	}

	@ObfuscatedName("client.a(JI)V")
	public final void a(long arg0, int arg1) {
		if (arg0 != 0L) {
			for (int var4 = 0; var4 < this.friendCount; ++var4) {
				if (this.friendName37[var4] == arg0) {
					--this.friendCount;
					this.redrawSidebar = true;

					for (int var5 = var4; var5 < this.friendCount; ++var5) {
						this.friendName[var5] = this.friendName[var5 + 1];
						this.friendWorld[var5] = this.friendWorld[var5 + 1];
						this.friendName37[var5] = this.friendName37[var5 + 1];
					}

					this.out.pIsaac(141);
					this.out.p8(arg0);
					break;
				}
			}

			this.psize += arg1;
		}
	}

	@ObfuscatedName("client.l(I)V")
	public final void l(int arg0) {
		if (this.bg == 0) {
			int var2 = super.mouseClickButton;
			if (arg0 != 0) {
				this.ptype = this.in.g1();
			}

			if (this.hh == 1 && super.C >= 516 && super.D >= 160 && super.C <= 765 && super.D <= 205) {
				var2 = 0;
			}

			if (this.menuVisible) {
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
						this.menuVisible = false;
						if (this.Kj == 1) {
							this.redrawSidebar = true;
						}

						if (this.Kj == 2) {
							this.redrawChatback = true;
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

					for (int var11 = 0; var11 < this.menuSize; ++var11) {
						int var12 = (this.menuSize - 1 - var11) * 15 + var6 + 31;
						if (var8 > var5 && var8 < var5 + var7 && var9 > var12 - 13 && var9 < var12 + 3) {
							var10 = var11;
						}
					}

					if (var10 != -1) {
						this.h(var10, 8);
					}

					this.menuVisible = false;
					if (this.Kj == 1) {
						this.redrawSidebar = true;
					}

					if (this.Kj == 2) {
						this.redrawChatback = true;
						return;
					}
				}
			} else {
				if (var2 == 1 && this.menuSize > 0) {
					int var13 = this.menuAction[this.menuSize - 1];
					if (var13 == 9 || var13 == 225 || var13 == 444 || var13 == 564 || var13 == 894 || var13 == 961 || var13 == 399 || var13 == 324 || var13 == 227 || var13 == 891 || var13 == 52 || var13 == 1094) {
						int var14 = this.menuParamB[this.menuSize - 1];
						int var15 = this.menuParamC[this.menuSize - 1];
						Component var16 = Component.types(var15);
						if (var16.draggable || var16.h) {
							this.Rg = false;
							this.bj = 0;
							this.Zf = var15;
							this.ag = var14;
							this.bg = 2;
							this.cg = super.C;
							this.dg = super.D;
							if (Component.types(var15).layer == this.fh) {
								this.bg = 1;
							}

							if (Component.types(var15).layer == this.chatInterfaceId) {
								this.bg = 3;
							}

							return;
						}
					}
				}

				if (var2 == 1 && (this.Gj == 1 || this.b(this.menuSize - 1, this.Xg)) && this.menuSize > 2) {
					var2 = 2;
				}

				if (var2 == 1 && this.menuSize > 0) {
					this.h(this.menuSize - 1, 8);
				}

				if (var2 != 2 || this.menuSize <= 0) {
					return;
				}

				this.B(811);
			}

		}
	}

	@ObfuscatedName("client.a(ILEPQDEJTO;II)V")
	public final void a(int arg0, Pix24 arg1, int arg2, int arg3) {
		int var5 = arg0 * arg0 + arg3 * arg3;

		while (arg2 >= 0) {
			this.ptype = -1;
		}

		if (var5 > 4225 && var5 < 90000) {
			int var6 = this.lc + this.Ki & 2047;
			int var7 = Model.Ib[var6];
			int var8 = Model.Jb[var6];
			int var9 = var7 * 256 / (this.ri + 256);
			int var10 = var8 * 256 / (this.ri + 256);
			int var11 = arg0 * var9 + arg3 * var10 >> 16;
			int var12 = arg0 * var10 - arg3 * var9 >> 16;
			double var13 = Math.atan2((double) var11, (double) var12);
			int var15 = (int) (Math.sin(var13) * 63.0D);
			int var16 = (int) (Math.cos(var13) * 57.0D);
			this.Fi.a(256, 15, var15 + 94 + 4 - 10, 15, 20, this.hg, 20, var13, 83 - var16 - 20);
		} else {
			this.a(arg0, true, arg1, arg3);
		}
	}

	@ObfuscatedName("client.a(ZIIIII)V")
	public final void a(boolean arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		this.imageScrollbar0.a(arg5, arg2, -488);
		this.imageScrollbar1.a(arg3 + arg5 - 16, arg2, -488);
		Pix2D.fillRect(this.Ac, 16, arg3 - 32, arg2, arg5 + 16);
		int var7 = (arg3 - 32) * arg3 / arg4;
		if (var7 < 8) {
			var7 = 8;
		}

		int var8 = (arg3 - 32 - var7) * arg1 / (arg4 - arg3);
		Pix2D.fillRect(this.uf, 16, var7, arg2, arg5 + 16 + var8);
		Pix2D.drawVerticalLine(arg2, arg5 + 16 + var8, var7, this.xg);
		Pix2D.drawVerticalLine(arg2 + 1, arg5 + 16 + var8, var7, this.xg);
		if (!arg0) {
			this.qc = -136;
		}

		Pix2D.drawHorizontalLine(arg2, arg5 + 16 + var8, 16, this.xg);
		Pix2D.drawHorizontalLine(arg2, arg5 + 17 + var8, 16, this.xg);
		Pix2D.drawVerticalLine(arg2 + 15, arg5 + 16 + var8, var7, this.tj);
		Pix2D.drawVerticalLine(arg2 + 14, arg5 + 17 + var8, var7 - 1, this.tj);
		Pix2D.drawHorizontalLine(arg2, arg5 + 15 + var8 + var7, 16, this.tj);
		Pix2D.drawHorizontalLine(arg2 + 1, arg5 + 14 + var8 + var7, 15, this.tj);
	}

	@ObfuscatedName("client.a(IZ)V")
	public final void a(int arg0, boolean arg1) {
		int var3 = 26 / arg0;

		for (int var4 = 0; var4 < this.npcCount; ++var4) {
			ClientNpc var5 = this.npcs[this.npcIds[var4]];
			int var6 = (this.npcIds[var4] << 14) + 536870912;
			if (var5 != null && var5.isVisible() && var5.type.alwaysontop == arg1 && var5.type.isNotMulti()) {
				int var7 = var5.x >> 7;
				int var8 = var5.z >> 7;
				if (var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
					if (var5.size == 1 && (var5.x & 127) == 64 && (var5.z & 127) == 64) {
						if (this.Hb[var7][var8] == this.Ag) {
							continue;
						}

						this.Hb[var7][var8] = this.Ag;
					}

					if (!var5.type.active) {
						var6 += Integer.MIN_VALUE;
					}

					this.scene.a(var6, var5, var5.x, this.getHeightMapY(var5.z, var5.x, (byte) 9, this.currentLevel), var5.y, 0, this.currentLevel, (var5.size - 1) * 64 + 60, var5.z, var5.S);
				}
			}
		}

	}

	@ObfuscatedName("client.c(II)V")
	public final void c(int arg0, int arg1) {
		SignLink.wavevol = arg1;
		if (arg0 <= 0) {
			this.Qe = 57;
		}
	}

	@ObfuscatedName("client.m(I)V")
	public final void tryReconnect() {
		if (this.idleTimeout > 0) {
			this.logout(true);
		} else {
			this.a(-332, "Please wait - attempting to reestablish", "Connection lost");
			this.Pe = 0;
			this.flagSceneTileX = 0;

			ClientStream stream = this.stream;
			this.ingame = false;
			this.X = 0;

			this.login(this.username, this.pasword, true);

			if (!this.ingame) {
				this.logout(true);
			}

			try {
				stream.close();
			} catch (Exception ignore) {
			}
		}
	}

	@ObfuscatedName("client.a(ILEWIXBTLV;)Z")
	public final boolean a(int arg0, Component arg1) {
		int var3 = arg1.clientCode;
		if (arg0 <= 0) {
			this.ptype = -1;
		}

		if (this.hb == 2) {
			if (var3 == 201) {
				this.redrawChatback = true;
				this.Ci = 0;
				this.showSocialInput = true;
				this.socialInput = "";
				this.socialInputType = 1;
				this.socialMessage = "Enter name of friend to add to list";
			}

			if (var3 == 202) {
				this.redrawChatback = true;
				this.Ci = 0;
				this.showSocialInput = true;
				this.socialInput = "";
				this.socialInputType = 2;
				this.socialMessage = "Enter name of friend to delete from list";
			}
		}

		if (var3 == 205) {
			this.idleTimeout = 250;
			return true;
		} else {
			if (var3 == 501) {
				this.redrawChatback = true;
				this.Ci = 0;
				this.showSocialInput = true;
				this.socialInput = "";
				this.socialInputType = 4;
				this.socialMessage = "Enter name of player to add to list";
			}

			if (var3 == 502) {
				this.redrawChatback = true;
				this.Ci = 0;
				this.showSocialInput = true;
				this.socialInput = "";
				this.socialInputType = 5;
				this.socialMessage = "Enter name of player to delete from list";
			}

			if (var3 >= 300 && var3 <= 313) {
				int var4 = (var3 - 300) / 2;
				int var5 = var3 & 1;
				int var6 = this.designKits[var4];
				if (var6 != -1) {
					while (true) {
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

						if (!IdkType.types[var6].k && IdkType.types[var6].f == var4 + (this.designGender ? 0 : 7)) {
							this.designKits[var4] = var6;
							this.updateDesignModel = true;
							break;
						}
					}
				}
			}

			if (var3 >= 314 && var3 <= 323) {
				int var7 = (var3 - 314) / 2;
				int var8 = var3 & 1;
				int var9 = this.designColours[var7];
				if (var8 == 0) {
					--var9;
					if (var9 < 0) {
						var9 = DESIGN_BODY_COLOUR[var7].length - 1;
					}
				}

				if (var8 == 1) {
					++var9;
					if (var9 >= DESIGN_BODY_COLOUR[var7].length) {
						var9 = 0;
					}
				}

				this.designColours[var7] = var9;
				this.updateDesignModel = true;
			}

			if (var3 == 324 && !this.designGender) {
				this.designGender = true;
				this.f(this.ge);
			}

			if (var3 == 325 && this.designGender) {
				this.designGender = false;
				this.f(this.ge);
			}

			if (var3 != 326) {
				if (var3 == 620) {
					this.reportAbuseMuteOption = !this.reportAbuseMuteOption;
				}

				if (var3 >= 601 && var3 <= 613) {
					this.b(false);
					if (this.reportAbuseInput.length() > 0) {
						this.out.pIsaac(184);
						this.out.p8(JString.toBase37(this.reportAbuseInput));
						this.out.p1(var3 - 601);
						this.out.p1(this.reportAbuseMuteOption ? 1 : 0);
					}
				}

				return false;
			} else {
				this.out.pIsaac(163);
				this.out.p1(this.designGender ? 0 : 1);

				for (int var10 = 0; var10 < 7; ++var10) {
					this.out.p1(this.designKits[var10]);
				}

				for (int var11 = 0; var11 < 5; ++var11) {
					this.out.p1(this.designColours[var11]);
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
			if (this.fileStreams[0] != null) {
				var7 = this.fileStreams[0].read(this.Tb, arg4);
			}
		} catch (Exception var30) {
		}

		if (var7 != null) {
			this.Cf.reset();
			this.Cf.update(var7);
			int var9 = (int) this.Cf.getValue();
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

			while (var7 == null) {
				String var12 = "Unknown error";
				this.drawProgress(arg3, true, "Requesting " + arg5);
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

					for (int var20 = 0; var20 < 6; ++var20) {
						var7[var20] = var16[var20];
					}

					while (var19 < var18) {
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
							this.drawProgress(arg3, true, "Loading " + arg5 + " - " + var23 + "%");
						}

						var14 = var23;
					}

					var15.close();

					try {
						if (this.fileStreams[0] != null) {
							this.fileStreams[0].a(var7.length, true, var7, arg4);
						}
					} catch (Exception var29) {
						this.fileStreams[0] = null;
					}

					if (var7 != null) {
						this.Cf.reset();
						this.Cf.update(var7);
						int var24 = (int) this.Cf.getValue();
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
					if (!SignLink.reporterror) {
						return null;
					}
				} catch (ArrayIndexOutOfBoundsException var33) {
					var12 = "Bounds error";
					var7 = null;
					if (!SignLink.reporterror) {
						return null;
					}
				} catch (Exception var34) {
					var12 = "Unexpected error";
					var7 = null;
					if (!SignLink.reporterror) {
						return null;
					}
				}

				if (var7 == null) {
					for (int var26 = var8; var26 > 0; --var26) {
						if (var11 >= 3) {
							this.drawProgress(arg3, true, "Game updated - please reload page");
							var26 = 10;
						} else {
							this.drawProgress(arg3, true, var12 + " - Retrying in " + var26);
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

		for (int var5 = 0; var5 < this.entityUpdateCount; ++var5) {
			int var6 = this.entityUpdateIds[var5];
			ClientNpc var7 = this.npcs[var6];
			int var8 = arg0.g1();
			if ((var8 & 1) != 0) {
				var7.type = NpcType.get(arg0.g2_alt2());
				var7.size = var7.type.size;
				var7.G = var7.type.turnspeed;
				var7.Z = var7.type.walkanim;
				var7.ab = var7.type.walkanim_b;
				var7.bb = var7.type.walkanim_r;
				var7.cb = var7.type.walkanim_l;
				var7.readyanim = var7.type.readyanim;
			}

			if ((var8 & 64) != 0) {
				var7.targetId = arg0.g2_alt1();
				if (var7.targetId == 65535) {
					var7.targetId = -1;
				}
			}

			if ((var8 & 128) != 0) {
				int var9 = arg0.g1_alt1();
				int var10 = arg0.g1_alt1();
				var7.hit(var9, var10, loopCycle);
				var7.combatCycle = loopCycle + 300;
				var7.C = arg0.g1();
				var7.D = arg0.g1_alt3();
			}

			if ((var8 & 4) != 0) {
				var7.spotAnimId = arg0.g2();
				int var11 = arg0.g4_alt2();
				var7.spotanimHeight = var11 >> 16;
				var7.spotanimLastCycle = (var11 & 65535) + loopCycle;
				var7.spotanimFrame = 0;
				var7.spotanimCycle = 0;
				if (var7.spotanimLastCycle > loopCycle) {
					var7.spotanimFrame = -1;
				}

				if (var7.spotAnimId == 65535) {
					var7.spotAnimId = -1;
				}
			}

			if ((var8 & 32) != 0) {
				var7.chatMessage = arg0.gjstr();
				var7.chatTimer = 100;
			}

			if ((var8 & 8) != 0) {
				var7.E = arg0.g2_alt3();
				var7.F = arg0.g2_alt1();
			}

			if ((var8 & 2) != 0) {
				int var12 = arg0.g2();
				if (var12 == 65535) {
					var12 = -1;
				}

				int var13 = arg0.g1_alt3();
				if (var7.primarySeqId == var12 && var12 != -1) {
					int var14 = SeqType.types[var12].restart_mode;
					if (var14 == 1) {
						var7.fb = 0;
						var7.gb = 0;
						var7.primarySeqDelay = var13;
						var7.primarySeqLoop = 0;
					}

					if (var14 == 2) {
						var7.primarySeqLoop = 0;
					}
				} else if (var12 == -1 || var7.primarySeqId == -1 || SeqType.types[var12].priority >= SeqType.types[var7.primarySeqId].priority) {
					var7.primarySeqId = var12;
					var7.fb = 0;
					var7.gb = 0;
					var7.primarySeqDelay = var13;
					var7.primarySeqLoop = 0;
					var7.preanimRouteLength = var7.routeLength;
				}
			}

			if ((var8 & 16) != 0) {
				int var15 = arg0.g1_alt3();
				int var16 = arg0.g1_alt3();
				var7.hit(var15, var16, loopCycle);
				var7.combatCycle = loopCycle + 300;
				var7.C = arg0.g1();
				var7.D = arg0.g1_alt2();
			}
		}

	}

	@ObfuscatedName("client.a(IILZGNGQRPJ;ILMFMVIYHT;)V")
	public final void getPlayerExtendedInfo(Packet buf, ClientPlayer player, int index, int mask) {

		if ((mask & 8) != 0) {
			// ANIM
			int seqId = buf.g2();
			if (seqId == 65535) {
				seqId = -1;
			}

			int delay = buf.g1_alt3();
			if (player.primarySeqId == seqId && seqId != -1) {

				int replaceMode = SeqType.types[seqId].restart_mode;
				if (replaceMode == 1) {
					player.fb = 0;
					player.gb = 0;
					player.primarySeqDelay = delay;
					player.primarySeqLoop = 0;
				}

				if (replaceMode == 2) {
					player.primarySeqLoop = 0;
				}
			} else if (seqId == -1 || player.primarySeqId == -1 || SeqType.types[seqId].priority >= SeqType.types[player.primarySeqId].priority) {
				player.primarySeqId = seqId;
				player.fb = 0;
				player.gb = 0;
				player.primarySeqDelay = delay;
				player.primarySeqLoop = 0;
				player.preanimRouteLength = player.routeLength;
			}
		}

		if ((mask & 16) != 0) {
			// SAY
			player.chatMessage = buf.gjstr();
			if (player.chatMessage.charAt(0) == '~') {
				player.chatMessage = player.chatMessage.substring(1);
				this.addMessage(player.chatMessage, player.name, 2);
			} else if (localPlayer == player) {
				this.addMessage(player.chatMessage, player.name, 2);
			}

			player.chatColour = 0;
			player.chatEffect = 0;
			player.chatTimer = 150;
		}

		if ((mask & 256) != 0) {
			// EXACT_MOVE
			player.I = buf.g1_alt1();
			player.K = buf.g1_alt2();
			player.J = buf.g1_alt3();
			player.L = buf.g1();
			player.M = buf.g2() + loopCycle;
			player.N = buf.g2_alt2() + loopCycle;
			player.O = buf.g1();

			player.clearRoute();
		}

		if ((mask & 1) != 0) {
			// FACE_ENTITY
			player.targetId = buf.g2_alt2();
			if (player.targetId == 65535) {
				player.targetId = -1;
			}
		}

		if ((mask & 2) != 0) {
			// FACE_COORD
			player.E = buf.g2();
			player.F = buf.g2();
		}

		if ((mask & 512) != 0) {
			// SPOTANIM
			player.spotAnimId = buf.g2_alt2();
			int heightDelay = buf.g4_alt2();

			player.spotanimHeight = heightDelay >> 16;
			player.spotanimLastCycle = (heightDelay & 65535) + loopCycle;
			player.spotanimFrame = 0;
			player.spotanimCycle = 0;

			if (player.spotanimLastCycle > loopCycle) {
				player.spotanimFrame = -1;
			}

			if (player.spotAnimId == 65535) {
				player.spotAnimId = -1;
			}
		}

		if ((mask & 4) != 0) {
			// APPEARANCE
			int var11 = buf.g1();

			byte[] var12 = new byte[var11];
			Packet var13 = new Packet(var12);
			buf.gdata_alt1(var12, 0, var11);

			this.playerAppearanceBuffer[index] = var13;
			// UH-OH!
			player.read(var13, 0);
		}

		if ((mask & 1024) != 0) {
			// DAMAGE
			int damage = buf.g1_alt1();
			int damageType = buf.g1_alt3();
			player.hit(damage, damageType, loopCycle);
			player.combatCycle = loopCycle + 300;
			player.C = buf.g1_alt2();
			player.D = buf.g1();
		}

		if ((mask & 64) != 0) {
			// CHAT
			int var16 = buf.g2();
			int var17 = buf.g1_alt2();
			int var18 = buf.g1_alt1();
			int var19 = buf.pos;
			if (player.name != null && player.Fb) {
				long var20 = JString.toBase37(player.name);
				boolean var22 = false;
				if (var17 <= 1) {
					for (int var23 = 0; var23 < this.ignoreCount; ++var23) {
						if (this.ignoreName37[var23] == var20) {
							var22 = true;
							break;
						}
					}
				}

				if (!var22 && this.overrideChat == 0) {
					try {
						this.tg.pos = 0;
						buf.gdata_alt2(this.tg.data, 0, var18);
						this.tg.pos = 0;

						String uncompressed = WordPack.a(0, this.tg, var18);
						String filter = WordFilter.a((byte) 0, (String) uncompressed);

						player.chatMessage = filter;
						player.chatColour = var16 >> 8;
						player.chatEffect = var16 & 255;
						player.chatTimer = 150;
						if (var17 != 2 && var17 != 3) {
							if (var17 == 1) {
								this.addMessage(filter, "@cr1@" + player.name, 1);
							} else {
								this.addMessage(filter, player.name, 2);
							}
						} else {
							this.addMessage(filter, "@cr2@" + player.name, 1);
						}
					} catch (Exception var29) {
						SignLink.reporterror("cde2");
					}
				}
			}

			buf.pos = var18 + var19;
		}

		if ((mask & 128) != 0) {
			// DAMAGE
			int damage = buf.g1_alt3();
			int damageType = buf.g1_alt2();

			player.hit(damage, damageType, loopCycle);
			player.combatCycle = loopCycle + 300;
			player.C = buf.g1_alt3();
			player.D = buf.g1();
		}
	}

	@ObfuscatedName("client.n(I)V")
	public final void n(int arg0) {
		if (this.Ih == null) {
			super.drawArea = null;
			this.Vg = null;
			this.Tg = null;
			this.Sg = null;
			this.Ug = null;
			this.Wf = null;
			this.Xf = null;
			this.Yf = null;
			if (arg0 < 0) {
				this.Lh = new PixMap(128, 265, this.getBaseComponent(), (byte) -12);
				Pix2D.clear();
				this.Mh = new PixMap(128, 265, this.getBaseComponent(), (byte) -12);
				Pix2D.clear();
				this.Ih = new PixMap(509, 171, this.getBaseComponent(), (byte) -12);
				Pix2D.clear();
				this.Jh = new PixMap(360, 132, this.getBaseComponent(), (byte) -12);
				Pix2D.clear();
				this.Kh = new PixMap(360, 200, this.getBaseComponent(), (byte) -12);
				Pix2D.clear();
				this.Nh = new PixMap(202, 238, this.getBaseComponent(), (byte) -12);
				Pix2D.clear();
				this.Oh = new PixMap(203, 238, this.getBaseComponent(), (byte) -12);
				Pix2D.clear();
				this.Ph = new PixMap(74, 94, this.getBaseComponent(), (byte) -12);
				Pix2D.clear();
				this.Qh = new PixMap(75, 94, this.getBaseComponent(), (byte) -12);
				Pix2D.clear();
				if (this.jagTitle != null) {
					this.r(Rh);
					this.i(false);
				}

				this.Le = true;
			}
		}
	}

	@ObfuscatedName("client.a()V")
	public final void load() {
		this.drawProgress(20, true, (String) "Starting up");
		if (SignLink.sunjava) {
			super.mindel = 5;
		}

		if (alreadyStarted) {
			this.errorStarted = true;
		} else {

			alreadyStarted = true;

			boolean validHost = false;
			String host = this.getHost(-42588);
			if (host.endsWith("jagex.com")) {
				validHost = true;
			}

			if (host.endsWith("runescape.com")) {
				validHost = true;
			}

			if (host.endsWith("192.168.1.2")) {
				validHost = true;
			}

			if (host.endsWith("192.168.1.231")) {
				validHost = true;
			}

			if (host.endsWith("192.168.1.229")) {
				validHost = true;
			}

			if (host.endsWith("192.168.1.228")) {
				validHost = true;
			}

			if (host.endsWith("192.168.1.227")) {
				validHost = true;
			}

			if (host.endsWith("192.168.1.226")) {
				validHost = true;
			}

			if (host.endsWith("192.168.1.224")) {
				validHost = true;
			}

			if (host.endsWith("192.168.1.223")) {
				validHost = true;
			}

			if (host.endsWith("192.168.1.221")) {
				validHost = true;
			}

			if (host.endsWith("127.0.0.1")) {
				validHost = true;
			}

			if (!validHost) {
				this.errorHost = true;
			} else {
				if (SignLink.cache_dat != null) {
					for (int i = 0; i < 5; ++i) {
						this.fileStreams[i] = new FileStream(i + 1, 600000, SignLink.cache_dat, SignLink.cache_idx[i], 4);
					}
				}

				try {
					this.k(false);
					this.jagTitle = this.a(14076, this.jagChecksum[1], "title", 25, 1, "title screen");
					this.fontPlain11 = new PixFont(this.jagTitle, "p11_full", false);
					this.fontPlain12 = new PixFont(this.jagTitle, "p12_full", false);
					this.fontBold12 = new PixFont(this.jagTitle, "b12_full", false);
					this.fontQuill8 = new PixFont(this.jagTitle, "q8_full", true);
					this.r(Rh);
					this.i(false);
					Jagfile jagConfig = this.a(14076, this.jagChecksum[2], "config", 30, 2, "config");
					Jagfile jagInterface = this.a(14076, this.jagChecksum[3], "interface", 35, 3, "interface");
					Jagfile jagMedia = this.a(14076, this.jagChecksum[4], "media", 40, 4, "2d graphics");
					Jagfile jagTextures = this.a(14076, this.jagChecksum[6], "textures", 45, 6, "textures");
					Jagfile jagWordenc = this.a(14076, this.jagChecksum[7], "wordenc", 50, 7, "chat system");
					Jagfile jagSounds = this.a(14076, this.jagChecksum[8], "sounds", 55, 8, "sound effects");

					this.levelTileFlags = new byte[4][104][104];
					this.levelHeightmap = new int[4][105][105];
					this.scene = new World3D(this.levelHeightmap, 104, 4, 104, (byte) 5);
					for (int i = 0; i < 4; ++i) {
						this.levelCollisionMap[i] = new CollisionMap(104, 0, 104);
					}
					this.imageMinimap = new Pix24(512, 512);

					Jagfile jagVersionList = this.a(14076, this.jagChecksum[5], "versionlist", 60, 5, "update list");

					this.drawProgress(60, true, (String) "Connecting to update server");

					this.onDemand = new OnDemand();
					this.onDemand.unpack(jagVersionList, this);
					AnimFrame.a(this.onDemand.getAnimCount());
					Model.a(this.onDemand.getFileCount(0), this.onDemand);

					if (!lowMemory) {
						this.midiSong = 0;
						this.midiFading = true;
						this.onDemand.request(2, this.midiSong);

						while (this.onDemand.remaining() > 0) {
							this.updateOnDemand(false);

							try {
								Thread.sleep(100L);
							} catch (Exception ignore) {
							}

							if (this.onDemand.U > 3) {
								this.a("ondemand");
								return;
							}
						}
					}

					this.drawProgress(65, true, (String) "Requesting animations");
					int var12 = this.onDemand.getFileCount(1);

					for (int var13 = 0; var13 < var12; ++var13) {
						this.onDemand.request(1, var13);
					}

					while (this.onDemand.remaining() > 0) {
						int var14 = var12 - this.onDemand.remaining();
						if (var14 > 0) {
							this.drawProgress(65, true, (String) ("Loading animations - " + var14 * 100 / var12 + "%"));
						}

						this.updateOnDemand(false);

						try {
							Thread.sleep(100L);
						} catch (Exception var73) {
						}

						if (this.onDemand.U > 3) {
							this.a("ondemand");
							return;
						}
					}

					this.drawProgress(70, true, (String) "Requesting models");
					int var15 = this.onDemand.getFileCount(0);

					for (int var16 = 0; var16 < var15; ++var16) {
						int var17 = this.onDemand.getModelFlags(var16);
						if ((var17 & 1) != 0) {
							this.onDemand.request(0, var16);
						}
					}

					int var18 = this.onDemand.remaining();

					while (this.onDemand.remaining() > 0) {
						int var19 = var18 - this.onDemand.remaining();
						if (var19 > 0) {
							this.drawProgress(70, true, (String) ("Loading models - " + var19 * 100 / var18 + "%"));
						}

						this.updateOnDemand(false);

						try {
							Thread.sleep(100L);
						} catch (Exception var72) {
						}
					}

					if (this.fileStreams[0] != null) {
						this.drawProgress(75, true, (String) "Requesting maps");
						this.onDemand.request(3, this.onDemand.getMapFile((int) 48, 47, 0));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 48, 47, 1));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 48, 48, 0));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 48, 48, 1));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 48, 49, 0));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 48, 49, 1));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 47, 47, 0));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 47, 47, 1));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 47, 48, 0));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 47, 48, 1));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 148, 48, 0));
						this.onDemand.request(3, this.onDemand.getMapFile((int) 148, 48, 1));
						int var20 = this.onDemand.remaining();

						while (this.onDemand.remaining() > 0) {
							int var21 = var20 - this.onDemand.remaining();
							if (var21 > 0) {
								this.drawProgress(75, true, (String) ("Loading maps - " + var21 * 100 / var20 + "%"));
							}

							this.updateOnDemand(false);

							try {
								Thread.sleep(100L);
							} catch (Exception var71) {
							}
						}
					}

					int var22 = this.onDemand.getFileCount(0);

					for (int var23 = 0; var23 < var22; ++var23) {
						int var24 = this.onDemand.getModelFlags(var23);
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
							this.onDemand.prefetchPriority(0, var23, (byte) var25);
						}
					}

					this.onDemand.prefetchMaps(membersWorld);
					if (!lowMemory) {
						int var26 = this.onDemand.getFileCount(2);

						for (int var27 = 1; var27 < var26; ++var27) {
							if (this.onDemand.shouldPrefectMidi(var27)) {
								this.onDemand.prefetchPriority(2, var27, (byte) 1);
							}
						}
					}

					int var28 = this.onDemand.getFileCount(0);

					for (int var29 = 0; var29 < var28; ++var29) {
						int var30 = this.onDemand.getModelFlags(var29);
						if (var30 == 0 && this.onDemand.totalPrefetchFiles < 200) {
							this.onDemand.prefetchPriority(0, var29, (byte) 1);
						}
					}

					this.drawProgress(80, true, (String) "Unpacking media");
					this.vh = new Pix8(jagMedia, "invback", 0);
					this.xh = new Pix8(jagMedia, "chatback", 0);
					this.imageMapback = new Pix8(jagMedia, "mapback", 0);
					this.id = new Pix8(jagMedia, "backbase1", 0);
					this.jd = new Pix8(jagMedia, "backbase2", 0);
					this.kd = new Pix8(jagMedia, "backhmid1", 0);

					for (int var31 = 0; var31 < 13; ++var31) {
						this.td[var31] = new Pix8(jagMedia, "sideicons", var31);
					}

					this.eg = new Pix24(jagMedia, "compass", 0);
					this.Fi = new Pix24(jagMedia, "mapedge", 0);
					this.Fi.b(1790);

					for (int var32 = 0; var32 < 72; ++var32) {
						this.imageMapscene[var32] = new Pix8(jagMedia, "mapscene", var32);
					}

					for (int var33 = 0; var33 < 70; ++var33) {
						this.imageMapfunction[var33] = new Pix24(jagMedia, "mapfunction", var33);
					}

					for (int var34 = 0; var34 < 5; ++var34) {
						this.sh[var34] = new Pix24(jagMedia, "hitmarks", var34);
					}

					for (int var35 = 0; var35 < 6; ++var35) {
						this.uj[var35] = new Pix24(jagMedia, "headicons_pk", var35);
					}

					for (int var36 = 0; var36 < 9; ++var36) {
						this.tf[var36] = new Pix24(jagMedia, "headicons_prayer", var36);
					}

					for (int var37 = 0; var37 < 6; ++var37) {
						this.Xc[var37] = new Pix24(jagMedia, "headicons_hint", var37);
					}

					this.Af = new Pix24(jagMedia, "overlay_multiway", 0);
					this.Be = new Pix24(jagMedia, "mapmarker", 0);
					this.Ce = new Pix24(jagMedia, "mapmarker", 1);

					for (int var38 = 0; var38 < 8; ++var38) {
						this.Rb[var38] = new Pix24(jagMedia, "cross", var38);
					}

					this.imageMapdot0 = new Pix24(jagMedia, "mapdots", 0);
					this.imageMapdot1 = new Pix24(jagMedia, "mapdots", 1);
					this.imageMapdot2 = new Pix24(jagMedia, "mapdots", 2);
					this.imageMapdot3 = new Pix24(jagMedia, "mapdots", 3);
					this.imageMapdot4 = new Pix24(jagMedia, "mapdots", 4);

					this.imageScrollbar0 = new Pix8(jagMedia, "scrollbar", 0);
					this.imageScrollbar1 = new Pix8(jagMedia, "scrollbar", 1);

					this.imageRedstone1 = new Pix8(jagMedia, "redstone1", 0);
					this.imageRedstone2 = new Pix8(jagMedia, "redstone2", 0);
					this.imageRedstone3 = new Pix8(jagMedia, "redstone3", 0);

					this.imageRedstone1h = new Pix8(jagMedia, "redstone1", 0);
					this.imageRedstone1h.flipHorizontally();

					this.imageRedstone2h = new Pix8(jagMedia, "redstone2", 0);
					this.imageRedstone2h.flipHorizontally();

					this.imageRedstone1v = new Pix8(jagMedia, "redstone1", 0);
					this.imageRedstone1v.flipVertically();

					this.imageRedstone2v = new Pix8(jagMedia, "redstone2", 0);
					this.imageRedstone2v.flipVertically();

					this.imageRedstone3v = new Pix8(jagMedia, "redstone3", 0);
					this.imageRedstone3v.flipVertically();

					this.imageRedstone1hv = new Pix8(jagMedia, "redstone1", 0);
					this.imageRedstone1hv.flipHorizontally();
					this.imageRedstone1hv.flipVertically();

					this.imageRedstone2hv = new Pix8(jagMedia, "redstone2", 0);
					this.imageRedstone2hv.flipHorizontally();
					this.imageRedstone2hv.flipVertically();

					for (int i = 0; i < 2; ++i) {
						this.modIcons[i] = new Pix8(jagMedia, "mod_icons", i);
					}

					Pix24 backleft1 = new Pix24(jagMedia, "backleft1", 0);
					this.areaBackleft1 = new PixMap(backleft1.J, backleft1.K, this.getBaseComponent(), (byte) -12);
					backleft1.blitOpaque(0, 0);

					Pix24 backleft2 = new Pix24(jagMedia, "backleft2", 0);
					this.areaBackleft2 = new PixMap(backleft2.J, backleft2.K, this.getBaseComponent(), (byte) -12);
					backleft2.blitOpaque(0, 0);

					Pix24 backright1 = new Pix24(jagMedia, "backright1", 0);
					this.areaBackright1 = new PixMap(backright1.J, backright1.K, this.getBaseComponent(), (byte) -12);
					backright1.blitOpaque(0, 0);

					Pix24 backright2 = new Pix24(jagMedia, "backright2", 0);
					this.areaBackright2 = new PixMap(backright2.J, backright2.K, this.getBaseComponent(), (byte) -12);
					backright2.blitOpaque(0, 0);

					Pix24 backtop1 = new Pix24(jagMedia, "backtop1", 0);
					this.areaBacktop1 = new PixMap(backtop1.J, backtop1.K, this.getBaseComponent(), (byte) -12);
					backtop1.blitOpaque(0, 0);

					Pix24 backvmid1 = new Pix24(jagMedia, "backvmid1", 0);
					this.areaBackvmid1 = new PixMap(backvmid1.J, backvmid1.K, this.getBaseComponent(), (byte) -12);
					backvmid1.blitOpaque(0, 0);

					Pix24 backvmid2 = new Pix24(jagMedia, "backvmid2", 0);
					this.areaBackvmid2 = new PixMap(backvmid2.J, backvmid2.K, this.getBaseComponent(), (byte) -12);
					backvmid2.blitOpaque(0, 0);

					Pix24 backvmid3 = new Pix24(jagMedia, "backvmid3", 0);
					this.areaBackvmid3 = new PixMap(backvmid3.J, backvmid3.K, this.getBaseComponent(), (byte) -12);
					backvmid3.blitOpaque(0, 0);

					Pix24 backhmid2 = new Pix24(jagMedia, "backhmid2", 0);
					this.areaBackhmid2 = new PixMap(backhmid2.J, backhmid2.K, this.getBaseComponent(), (byte) -12);
					backhmid2.blitOpaque(0, 0);

					int randR = (int) (Math.random() * 21.0D) - 10;
					int randG = (int) (Math.random() * 21.0D) - 10;
					int rangB = (int) (Math.random() * 21.0D) - 10;
					int rand = (int) (Math.random() * 41.0D) - 20;

					for (int i = 0; i < 100; ++i) {
						if (this.imageMapfunction[i] != null) {
							this.imageMapfunction[i].tranlsate(rangB + rand, randG + rand, randR + rand, -235);
						}

						if (this.imageMapscene[i] != null) {
							this.imageMapscene[i].translate(rangB + rand, randG + rand, randR + rand, -235);
						}
					}

					this.drawProgress(83, true, "Unpacking textures");

					Pix3D.unpackTextures(jagTextures, -17551);
					Pix3D.setBrightness(0.8D, (byte) 6);
					Pix3D.initPool((byte) 7, 20);

					this.drawProgress(86, true, "Unpacking config");

					SeqType.unpack(jagConfig, 36135);
					LocType.unpack(jagConfig);
					FloType.unpack(jagConfig, 36135);
					ObjType.unpack(jagConfig);
					NpcType.unpack(jagConfig);
					IdkType.unpack(jagConfig, 36135);
					SpotAnimType.unpack(jagConfig, 36135);
					VarpType.unpack(jagConfig);
					VarbitType.unpack(jagConfig);
					ObjType.membersWorld = membersWorld;

					if (!lowMemory) {
						this.drawProgress(90, true, "Unpacking sounds");

						byte[] dat = jagSounds.read("sounds.dat", (byte[]) null);
						Packet sounds = new Packet(dat);
						Wave.unpack(sounds, 36135);
					}

					this.drawProgress(95, true, "Unpacking interfaces");

					PixFont[] fonts = new PixFont[]{this.fontPlain11, this.fontPlain12, this.fontBold12, this.fontQuill8};
					Component.unpack(jagInterface, jagMedia, fonts, -845);

					this.drawProgress(100, true, "Preparing game engine");

					for (int y = 0; y < 33; ++y) {
						int left = 999;
						int right = 0;

						for (int x = 0; x < 34; ++x) {
							if (this.imageMapback.pixels[this.imageMapback.width * y + x] == 0) {
								if (left == 999) {
									left = x;
								}
							} else if (left != 999) {
								right = x;
								break;
							}
						}

						this.compassMaskLineOffsets[y] = left;
						this.compassMaskLineLengths[y] = right - left;
					}

					for (int y = 5; y < 156; ++y) {
						int left = 999;
						int right = 0;

						for (int x = 25; x < 172; ++x) {
							if (this.imageMapback.pixels[this.imageMapback.width * y + x] == 0 && (x > 34 || y > 34)) {
								if (left == 999) {
									left = x;
								}
							} else if (left != 999) {
								right = x;
								break;
							}
						}

						this.minimapMaskLineOffsets[y - 5] = left - 25;
						this.minimapMaskLineLengths[y - 5] = right - left;
					}

					Pix3D.init3D(503, 7, 765);
					this.Ud = Pix3D.lineOffset;

					Pix3D.init3D(96, 7, 479);
					this.areaChatbackOffset = Pix3D.lineOffset;

					Pix3D.init3D(261, 7, 190);
					this.areaSidebarOffset = Pix3D.lineOffset;

					Pix3D.init3D(334, 7, 512);
					this.areaViewportOffset = Pix3D.lineOffset;

					int[] distance = new int[9];
					for (int x = 0; x < 9; ++x) {
						int angle = x * 32 + 128 + 15;
						int offset = angle * 3 + 600;
						int sin = Pix3D.sinTable[angle];
						distance[x] = offset * sin >> 16;
					}

					World3D.init(334, 22845, distance, 800, 500, 512);
					WordFilter.unpack(jagWordenc);

					this.mousetracking = new MouseTracking(this, (byte) -116);
					this.startThread((Runnable) this.mousetracking, 10);
					ClientLocAnim.v = this;
					LocType.m = this;
					NpcType.i = this;
				} catch (Exception var75) {
					SignLink.reporterror("loaderror " + this.se + " " + this.ck);
					this.errorLoading = true;
				}
			}
		}
	}

	@ObfuscatedName("client.d(II)V")
	public final void d(int arg0, int arg1) {
		if (arg1 < 0) {
			if (!lowMemory) {
				for (int var3 = 0; var3 < this.wj.length; ++var3) {
					int var4 = this.wj[var3];
					if (Pix3D.S[var4] >= arg0) {
						Pix8 var5 = Pix3D.M[var4];
						int var6 = var5.height * var5.width - 1;
						int var7 = this.Uc * var5.width * 2;
						byte[] var8 = var5.pixels;
						byte[] var9 = this.Di;

						for (int var10 = 0; var10 <= var6; ++var10) {
							var9[var10] = var8[var10 - var7 & var6];
						}

						var5.pixels = var9;
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
			if (arg1.type == 0 && arg1.children != null && !arg1.hide) {
				if (arg5 >= arg4 && arg7 >= arg0 && arg5 <= arg1.height + arg4 && arg7 <= arg1.width + arg0) {
					int var9 = arg1.children.length;

					for (int var10 = 0; var10 < var9; ++var10) {
						int var11 = arg1.childX[var10] + arg4;
						int var12 = arg1.childY[var10] + arg0 - arg3;
						Component var13 = Component.types(arg1.children[var10]);
						int var14 = var13.s + var11;
						int var15 = var13.X + var12;
						if ((var13.overlayer >= 0 || var13.overColour != 0) && arg5 >= var14 && arg7 >= var15 && arg5 < var13.height + var14 && arg7 < var13.width + var15) {
							if (var13.overlayer >= 0) {
								this.kc = var13.overlayer;
							} else {
								this.kc = var13.id;
							}
						}

						if (var13.type == 8 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.height + var14 && arg7 < var13.width + var15) {
							this.Vj = var13.id;
						}

						if (var13.type == 0) {
							this.a(var15, var13, arg2, var13.scrollPosition, var14, arg5, 23658, arg7);
							if (var13.scroll > var13.width) {
								this.handleScrollInput(var13.scroll, var15, var13, arg7, arg2, arg5, var13.width, var13.height + var14);
							}
						} else {
							if (var13.buttonType == 1 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.height + var14 && arg7 < var13.width + var15) {
								boolean var16 = false;
								if (var13.clientCode != 0) {
									var16 = this.a((Component) var13, 8);
								}

								if (!var16) {
									this.menuOption[this.menuSize] = var13.option;
									this.menuAction[this.menuSize] = 352;
									this.menuParamC[this.menuSize] = var13.id;
									this.menuSize++;
								}
							}

							if (var13.buttonType == 2 && this.hh == 0 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.height + var14 && arg7 < var13.width + var15) {
								String var17 = var13.targetVerb;
								if (var17.indexOf(" ") != -1) {
									var17 = var17.substring(0, var17.indexOf(" "));
								}

								this.menuOption[this.menuSize] = var17 + " @gre@" + var13.targetText;
								this.menuAction[this.menuSize] = 70;
								this.menuParamC[this.menuSize] = var13.id;
								this.menuSize++;
							}

							if (var13.buttonType == 3 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.height + var14 && arg7 < var13.width + var15) {
								this.menuOption[this.menuSize] = "Close";
								if (arg2 == 3) {
									this.menuAction[this.menuSize] = 55;
								} else {
									this.menuAction[this.menuSize] = 639;
								}

								this.menuParamC[this.menuSize] = var13.id;
								this.menuSize++;
							}

							if (var13.buttonType == 4 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.height + var14 && arg7 < var13.width + var15) {
								this.menuOption[this.menuSize] = var13.option;
								this.menuAction[this.menuSize] = 890;
								this.menuParamC[this.menuSize] = var13.id;
								this.menuSize++;
							}

							if (var13.buttonType == 5 && arg5 >= var14 && arg7 >= var15 && arg5 < var13.height + var14 && arg7 < var13.width + var15) {
								this.menuOption[this.menuSize] = var13.option;
								this.menuAction[this.menuSize] = 518;
								this.menuParamC[this.menuSize] = var13.id;
								this.menuSize++;
							}

							if (var13.buttonType == 6 && !this.xi && arg5 >= var14 && arg7 >= var15 && arg5 < var13.height + var14 && arg7 < var13.width + var15) {
								this.menuOption[this.menuSize] = var13.option;
								this.menuAction[this.menuSize] = 575;
								this.menuParamC[this.menuSize] = var13.id;
								this.menuSize++;
							}

							if (var13.type == 2) {
								int var18 = 0;

								for (int var19 = 0; var19 < var13.width; ++var19) {
									for (int var20 = 0; var20 < var13.height; ++var20) {
										int var21 = (var13.marginX + 32) * var20 + var14;
										int var22 = (var13.marginY + 32) * var19 + var15;
										if (var18 < 20) {
											var21 += var13.invSlotOffsetX[var18];
											var22 += var13.invSlotOffsetY[var18];
										}

										if (arg5 >= var21 && arg7 >= var22 && arg5 < var21 + 32 && arg7 < var22 + 32) {
											this.cf = var18;
											this.df = var13.id;
											if (var13.invSlotObjId[var18] > 0) {
												ObjType var23 = ObjType.get(var13.invSlotObjId[var18] - 1);
												if (this.objSelected == 1 && var13.interactable) {
													if (this.Kg != var13.id || this.Jg != var18) {
														this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @lre@" + var23.name;
														this.menuAction[this.menuSize] = 903;
														this.menuParamA[this.menuSize] = var23.id;
														this.menuParamB[this.menuSize] = var18;
														this.menuParamC[this.menuSize] = var13.id;
														this.menuSize++;
													}
												} else if (this.hh == 1 && var13.interactable) {
													if ((this.jh & 16) == 16) {
														this.menuOption[this.menuSize] = this.kh + " @lre@" + var23.name;
														this.menuAction[this.menuSize] = 361;
														this.menuParamA[this.menuSize] = var23.id;
														this.menuParamB[this.menuSize] = var18;
														this.menuParamC[this.menuSize] = var13.id;
														this.menuSize++;
													}
												} else {
													if (var13.interactable) {
														for (int var24 = 4; var24 >= 3; --var24) {
															if (var23.iop != null && var23.iop[var24] != null) {
																this.menuOption[this.menuSize] = var23.iop[var24] + " @lre@" + var23.name;
																if (var24 == 3) {
																	this.menuAction[this.menuSize] = 227;
																}

																if (var24 == 4) {
																	this.menuAction[this.menuSize] = 891;
																}

																this.menuParamA[this.menuSize] = var23.id;
																this.menuParamB[this.menuSize] = var18;
																this.menuParamC[this.menuSize] = var13.id;
																this.menuSize++;
															} else if (var24 == 4) {
																this.menuOption[this.menuSize] = "Drop @lre@" + var23.name;
																this.menuAction[this.menuSize] = 891;
																this.menuParamA[this.menuSize] = var23.id;
																this.menuParamB[this.menuSize] = var18;
																this.menuParamC[this.menuSize] = var13.id;
																this.menuSize++;
															}
														}
													}

													if (var13.usable) {
														this.menuOption[this.menuSize] = "Use @lre@" + var23.name;
														this.menuAction[this.menuSize] = 52;
														this.menuParamA[this.menuSize] = var23.id;
														this.menuParamB[this.menuSize] = var18;
														this.menuParamC[this.menuSize] = var13.id;
														this.menuSize++;
													}

													if (var13.interactable && var23.iop != null) {
														for (int var25 = 2; var25 >= 0; --var25) {
															if (var23.iop[var25] != null) {
																this.menuOption[this.menuSize] = var23.iop[var25] + " @lre@" + var23.name;
																if (var25 == 0) {
																	this.menuAction[this.menuSize] = 961;
																}

																if (var25 == 1) {
																	this.menuAction[this.menuSize] = 399;
																}

																if (var25 == 2) {
																	this.menuAction[this.menuSize] = 324;
																}

																this.menuParamA[this.menuSize] = var23.id;
																this.menuParamB[this.menuSize] = var18;
																this.menuParamC[this.menuSize] = var13.id;
																this.menuSize++;
															}
														}
													}

													if (var13.iop != null) {
														for (int var26 = 4; var26 >= 0; --var26) {
															if (var13.iop[var26] != null) {
																this.menuOption[this.menuSize] = var13.iop[var26] + " @lre@" + var23.name;
																if (var26 == 0) {
																	this.menuAction[this.menuSize] = 9;
																}

																if (var26 == 1) {
																	this.menuAction[this.menuSize] = 225;
																}

																if (var26 == 2) {
																	this.menuAction[this.menuSize] = 444;
																}

																if (var26 == 3) {
																	this.menuAction[this.menuSize] = 564;
																}

																if (var26 == 4) {
																	this.menuAction[this.menuSize] = 894;
																}

																this.menuParamA[this.menuSize] = var23.id;
																this.menuParamB[this.menuSize] = var18;
																this.menuParamC[this.menuSize] = var13.id;
																this.menuSize++;
															}
														}
													}

													this.menuOption[this.menuSize] = "Examine @lre@" + var23.name;
													this.menuAction[this.menuSize] = 1094;
													this.menuParamA[this.menuSize] = var23.id;
													this.menuParamB[this.menuSize] = var18;
													this.menuParamC[this.menuSize] = var13.id;
													this.menuSize++;
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
		for (int var2 = 0; var2 < this.npcCount; ++var2) {
			int var3 = this.npcIds[var2];
			ClientNpc var4 = this.npcs[var3];
			if (var4 != null) {
				this.a(var4.type.size, (byte) -97, (ClientEntity) var4);
			}
		}

		if (arg0 != -37214) {
			this.out.p1((int) 41);
		}
	}

	@ObfuscatedName("client.a(IBLLRUWCBNN;)V")
	public final void a(int arg0, byte arg1, ClientEntity arg2) {
		if (arg2.x < 128 || arg2.z < 128 || arg2.x >= 13184 || arg2.z >= 13184) {
			arg2.primarySeqId = -1;
			arg2.spotAnimId = -1;
			arg2.M = 0;
			arg2.N = 0;
			arg2.x = arg2.routeTileX[0] * 128 + arg2.size * 64;
			arg2.z = arg2.routeTileZ[0] * 128 + arg2.size * 64;
			arg2.clearRoute();
		}

		if (localPlayer == arg2 && (arg2.x < 1536 || arg2.z < 1536 || arg2.x >= 11776 || arg2.z >= 11776)) {
			arg2.primarySeqId = -1;
			arg2.spotAnimId = -1;
			arg2.M = 0;
			arg2.N = 0;
			arg2.x = arg2.routeTileX[0] * 128 + arg2.size * 64;
			arg2.z = arg2.routeTileZ[0] * 128 + arg2.size * 64;
			arg2.clearRoute();
		}

		if (arg2.M > loopCycle) {
			this.a(arg2, true);
		} else if (arg2.N >= loopCycle) {
			this.a((ClientEntity) arg2, -31135);
		} else {
			this.b((ClientEntity) arg2, 0);
		}

		this.a((byte) 8, (ClientEntity) arg2);
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

		int var3 = arg0.M - loopCycle;
		int var4 = arg0.I * 128 + arg0.size * 64;
		int var5 = arg0.K * 128 + arg0.size * 64;
		arg0.x += (var4 - arg0.x) / var3;
		arg0.z += (var5 - arg0.z) / var3;
		arg0.seqDelayMove = 0;
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
		if (loopCycle == arg0.N || arg0.primarySeqId == -1 || arg0.primarySeqDelay != 0 || arg0.gb + 1 > SeqType.types[arg0.primarySeqId].a(0, arg0.fb)) {
			int var3 = arg0.N - arg0.M;
			int var4 = loopCycle - arg0.M;
			int var5 = arg0.I * 128 + arg0.size * 64;
			int var6 = arg0.K * 128 + arg0.size * 64;
			int var7 = arg0.J * 128 + arg0.size * 64;
			int var8 = arg0.L * 128 + arg0.size * 64;
			arg0.x = ((var3 - var4) * var5 + var4 * var7) / var3;
			arg0.z = ((var3 - var4) * var6 + var4 * var8) / var3;
		}

		arg0.seqDelayMove = 0;
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
		arg0.u = arg0.readyanim;
		if (arg0.routeLength == 0) {
			arg0.seqDelayMove = 0;
		} else {
			if (arg0.primarySeqId != -1 && arg0.primarySeqDelay == 0) {
				SeqType var3 = SeqType.types[arg0.primarySeqId];
				if (arg0.preanimRouteLength > 0 && var3.p == 0) {
					++arg0.seqDelayMove;
					return;
				}

				if (arg0.preanimRouteLength <= 0 && var3.postanim_mode == 0) {
					++arg0.seqDelayMove;
					return;
				}
			}

			int var4 = arg0.x;
			int var5 = arg0.z;
			int var6 = arg0.routeTileX[arg0.routeLength - 1] * 128 + arg0.size * 64;
			int var7 = arg0.routeTileZ[arg0.routeLength - 1] * 128 + arg0.size * 64;
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
					this.out.p1((int) 34);
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
				if (arg0.q != arg0.S && arg0.targetId == -1 && arg0.G != 0) {
					var10 = 2;
				}

				if (arg0.routeLength > 2) {
					var10 = 6;
				}

				if (arg0.routeLength > 3) {
					var10 = 8;
				}

				if (arg0.seqDelayMove > 0 && arg0.routeLength > 1) {
					var10 = 8;
					--arg0.seqDelayMove;
				}

				if (arg0.routeRun[arg0.routeLength - 1]) {
					var10 <<= 1;
				}

				if (var10 >= 8 && arg0.u == arg0.Z && arg0.jb != -1) {
					arg0.u = arg0.jb;
				}

				if (var4 < var6) {
					arg0.x += var10;
					if (arg0.x > var6) {
						arg0.x = var6;
					}
				} else if (var4 > var6) {
					arg0.x -= var10;
					if (arg0.x < var6) {
						arg0.x = var6;
					}
				}

				if (var5 < var7) {
					arg0.z += var10;
					if (arg0.z > var7) {
						arg0.z = var7;
					}
				} else if (var5 > var7) {
					arg0.z -= var10;
					if (arg0.z < var7) {
						arg0.z = var7;
					}
				}

				if (arg0.x == var6 && arg0.z == var7) {
					--arg0.routeLength;
					if (arg0.preanimRouteLength > 0) {
						--arg0.preanimRouteLength;
						return;
					}
				}

			} else {
				arg0.x = var6;
				arg0.z = var7;
			}
		}
	}

	@ObfuscatedName("client.a(BLLRUWCBNN;)V")
	public final void a(byte arg0, ClientEntity arg1) {
		if (arg0 != 8) {
			this.xc = this.randomIn.nextInt();
		}

		if (arg1.G != 0) {
			if (arg1.targetId != -1 && arg1.targetId < 32768) {
				ClientNpc var3 = this.npcs[arg1.targetId];
				if (var3 != null) {
					int var4 = arg1.x - var3.x;
					int var5 = arg1.z - var3.z;
					if (var4 != 0 || var5 != 0) {
						arg1.q = (int) (Math.atan2((double) var4, (double) var5) * 325.949D) & 2047;
					}
				}
			}

			if (arg1.targetId >= 32768) {
				int var6 = arg1.targetId - 32768;
				if (this.localPid == var6) {
					var6 = this.LOCAL_PLAYER_INDEX;
				}

				ClientPlayer var7 = this.players[var6];
				if (var7 != null) {
					int var8 = arg1.x - var7.x;
					int var9 = arg1.z - var7.z;
					if (var8 != 0 || var9 != 0) {
						arg1.q = (int) (Math.atan2((double) var8, (double) var9) * 325.949D) & 2047;
					}
				}
			}

			if ((arg1.E != 0 || arg1.F != 0) && (arg1.routeLength == 0 || arg1.seqDelayMove > 0)) {
				int var10 = arg1.x - (arg1.E - this.sceneBaseTileX - this.sceneBaseTileX) * 64;
				int var11 = arg1.z - (arg1.F - this.sceneBaseTileZ - this.sceneBaseTileZ) * 64;
				if (var10 != 0 || var11 != 0) {
					arg1.q = (int) (Math.atan2((double) var10, (double) var11) * 325.949D) & 2047;
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
				if (arg1.u == arg1.readyanim && arg1.q != arg1.S) {
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
		while (arg1 >= 0) {
			this.ik = this.randomIn.nextInt();
		}

		arg0.y = false;
		if (arg0.u != -1) {
			SeqType var3 = SeqType.types[arg0.u];
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

		if (arg0.spotAnimId != -1 && loopCycle >= arg0.spotanimLastCycle) {
			if (arg0.spotanimFrame < 0) {
				arg0.spotanimFrame = 0;
			}

			SeqType var4 = SpotAnimType.e[arg0.spotAnimId].i;
			++arg0.spotanimCycle;
			if (arg0.spotanimFrame < var4.e && arg0.spotanimCycle > var4.a(0, arg0.spotanimFrame)) {
				arg0.spotanimCycle = 1;
				++arg0.spotanimFrame;
			}

			if (arg0.spotanimFrame >= var4.e && (arg0.spotanimFrame < 0 || arg0.spotanimFrame >= var4.e)) {
				arg0.spotAnimId = -1;
			}
		}

		if (arg0.primarySeqId != -1 && arg0.primarySeqDelay <= 1) {
			SeqType var5 = SeqType.types[arg0.primarySeqId];
			if (var5.p == 1 && arg0.preanimRouteLength > 0 && arg0.M <= loopCycle && arg0.N < loopCycle) {
				arg0.primarySeqDelay = 1;
				return;
			}
		}

		if (arg0.primarySeqId != -1 && arg0.primarySeqDelay == 0) {
			SeqType var6 = SeqType.types[arg0.primarySeqId];
			++arg0.gb;
			if (arg0.fb < var6.e && arg0.gb > var6.a(0, arg0.fb)) {
				arg0.gb = 1;
				++arg0.fb;
			}

			if (arg0.fb >= var6.e) {
				arg0.fb -= var6.i;
				++arg0.primarySeqLoop;
				if (arg0.primarySeqLoop >= var6.o) {
					arg0.primarySeqId = -1;
				}

				if (arg0.fb < 0 || arg0.fb >= var6.e) {
					arg0.primarySeqId = -1;
				}
			}

			arg0.y = var6.k;
		}

		if (arg0.primarySeqDelay > 0) {
			--arg0.primarySeqDelay;
		}
	}

	@ObfuscatedName("client.p(I)V")
	public final void p(int arg0) {
		if (this.Se == -1 || this.sceneState != 2 && super.drawArea == null) {
			if (this.Le) {
				this.prepareGame();
				this.Le = false;
				this.areaBackleft1.a(4, 0, super.graphics, this.of);
				this.areaBackleft2.a(357, 0, super.graphics, this.of);
				this.areaBackright1.a(4, 722, super.graphics, this.of);
				this.areaBackright2.a(205, 743, super.graphics, this.of);
				this.areaBacktop1.a(0, 0, super.graphics, this.of);
				this.areaBackvmid1.a(4, 516, super.graphics, this.of);
				this.areaBackvmid2.a(205, 516, super.graphics, this.of);
				this.areaBackvmid3.a(357, 496, super.graphics, this.of);
				this.areaBackhmid2.a(338, 0, super.graphics, this.of);
				this.redrawSidebar = true;
				this.redrawChatback = true;
				this.redrawSideicons = true;
				this.redrawPrivacySettings = true;
				if (this.sceneState != 2) {
					this.Ug.a(4, 4, super.graphics, this.of);
					this.Tg.a(4, 550, super.graphics, this.of);
				}

				++vi;
				if (vi > 85) {
					vi = 0;
					this.out.pIsaac(168);
				}
			}

			if (this.sceneState == 2) {
				this.L(2);
			}

			if (this.menuVisible && this.Kj == 1) {
				this.redrawSidebar = true;
			}

			if (this.Df != -1) {
				boolean var4 = this.a(this.Uc, this.Df, (byte) 5);
				if (var4) {
					this.redrawSidebar = true;
				}
			}

			if (this.mk == 2) {
				this.redrawSidebar = true;
			}

			if (this.bg == 2) {
				this.redrawSidebar = true;
			}

			if (this.redrawSidebar) {
				this.k((byte) 7);
				this.redrawSidebar = false;
			}

			if (this.chatInterfaceId == -1 && this.Ci == 0) {
				this.Hi.scrollPosition = this.Vf - this.Y - 77;
				if (super.v > 448 && super.v < 560 && super.w > 332) {
					this.handleScrollInput(this.Vf, 0, this.Hi, super.w - 357, -1, super.v - 17, 77, 463);
				}

				int var5 = this.Vf - 77 - this.Hi.scrollPosition;
				if (var5 < 0) {
					var5 = 0;
				}

				if (var5 > this.Vf - 77) {
					var5 = this.Vf - 77;
				}

				if (this.Y != var5) {
					this.Y = var5;
					this.redrawChatback = true;
				}
			}

			if (this.chatInterfaceId == -1 && this.Ci == 3) {
				int var6 = this.jb * 14 + 7;
				this.Hi.scrollPosition = this.mb;
				if (super.v > 448 && super.v < 560 && super.w > 332) {
					this.handleScrollInput(var6, 0, this.Hi, super.w - 357, -1, super.v - 17, 77, 463);
				}

				int var7 = this.Hi.scrollPosition;
				if (var7 < 0) {
					var7 = 0;
				}

				if (var7 > var6 - 77) {
					var7 = var6 - 77;
				}

				if (this.mb != var7) {
					this.mb = var7;
					this.redrawChatback = true;
				}
			}

			if (this.chatInterfaceId != -1) {
				boolean var8 = this.a(this.Uc, this.chatInterfaceId, (byte) 5);
				if (var8) {
					this.redrawChatback = true;
				}
			}

			if (this.mk == 3) {
				this.redrawChatback = true;
			}

			if (this.bg == 3) {
				this.redrawChatback = true;
			}

			if (this.modelMessage != null) {
				this.redrawChatback = true;
			}

			if (this.menuVisible && this.Kj == 2) {
				this.redrawChatback = true;
			}

			if (this.redrawChatback) {
				this.drawChat(0);
				this.redrawChatback = false;
			}

			if (this.sceneState == 2) {
				this.v(503);
				this.Tg.a(4, 550, super.graphics, this.of);
			}

			if (this.flashingTab != -1) {
				this.redrawSideicons = true;
			}

			if (this.redrawSideicons) {
				if (this.flashingTab != -1 && this.selectedTab == this.flashingTab) {
					this.flashingTab = -1;
					this.out.pIsaac(119);
					this.out.p1(this.selectedTab);
				}

				this.redrawSideicons = false;
				this.Yf.a(false);
				this.kd.a(0, 0, -488);
				if (this.Df == -1) {
					if (this.tabInterfaceId[this.selectedTab] != -1) {
						if (this.selectedTab == 0) {
							this.imageRedstone1.a(10, 22, -488);
						}

						if (this.selectedTab == 1) {
							this.imageRedstone2.a(8, 54, -488);
						}

						if (this.selectedTab == 2) {
							this.imageRedstone2.a(8, 82, -488);
						}

						if (this.selectedTab == 3) {
							this.imageRedstone3.a(8, 110, -488);
						}

						if (this.selectedTab == 4) {
							this.imageRedstone2h.a(8, 153, -488);
						}

						if (this.selectedTab == 5) {
							this.imageRedstone2h.a(8, 181, -488);
						}

						if (this.selectedTab == 6) {
							this.imageRedstone1h.a(9, 209, -488);
						}
					}

					if (this.tabInterfaceId[0] != -1 && (this.flashingTab != 0 || loopCycle % 20 < 10)) {
						this.td[0].a(13, 29, -488);
					}

					if (this.tabInterfaceId[1] != -1 && (this.flashingTab != 1 || loopCycle % 20 < 10)) {
						this.td[1].a(11, 53, -488);
					}

					if (this.tabInterfaceId[2] != -1 && (this.flashingTab != 2 || loopCycle % 20 < 10)) {
						this.td[2].a(11, 82, -488);
					}

					if (this.tabInterfaceId[3] != -1 && (this.flashingTab != 3 || loopCycle % 20 < 10)) {
						this.td[3].a(12, 115, -488);
					}

					if (this.tabInterfaceId[4] != -1 && (this.flashingTab != 4 || loopCycle % 20 < 10)) {
						this.td[4].a(13, 153, -488);
					}

					if (this.tabInterfaceId[5] != -1 && (this.flashingTab != 5 || loopCycle % 20 < 10)) {
						this.td[5].a(11, 180, -488);
					}

					if (this.tabInterfaceId[6] != -1 && (this.flashingTab != 6 || loopCycle % 20 < 10)) {
						this.td[6].a(13, 208, -488);
					}
				}

				this.Yf.a(160, 516, super.graphics, this.of);
				this.Xf.a(false);
				this.jd.a(0, 0, -488);
				if (this.Df == -1) {
					if (this.tabInterfaceId[this.selectedTab] != -1) {
						if (this.selectedTab == 7) {
							this.imageRedstone1v.a(0, 42, -488);
						}

						if (this.selectedTab == 8) {
							this.imageRedstone2v.a(0, 74, -488);
						}

						if (this.selectedTab == 9) {
							this.imageRedstone2v.a(0, 102, -488);
						}

						if (this.selectedTab == 10) {
							this.imageRedstone3v.a(1, 130, -488);
						}

						if (this.selectedTab == 11) {
							this.imageRedstone2hv.a(0, 173, -488);
						}

						if (this.selectedTab == 12) {
							this.imageRedstone2hv.a(0, 201, -488);
						}

						if (this.selectedTab == 13) {
							this.imageRedstone1hv.a(0, 229, -488);
						}
					}

					if (this.tabInterfaceId[8] != -1 && (this.flashingTab != 8 || loopCycle % 20 < 10)) {
						this.td[7].a(2, 74, -488);
					}

					if (this.tabInterfaceId[9] != -1 && (this.flashingTab != 9 || loopCycle % 20 < 10)) {
						this.td[8].a(3, 102, -488);
					}

					if (this.tabInterfaceId[10] != -1 && (this.flashingTab != 10 || loopCycle % 20 < 10)) {
						this.td[9].a(4, 137, -488);
					}

					if (this.tabInterfaceId[11] != -1 && (this.flashingTab != 11 || loopCycle % 20 < 10)) {
						this.td[10].a(2, 174, -488);
					}

					if (this.tabInterfaceId[12] != -1 && (this.flashingTab != 12 || loopCycle % 20 < 10)) {
						this.td[11].a(2, 201, -488);
					}

					if (this.tabInterfaceId[13] != -1 && (this.flashingTab != 13 || loopCycle % 20 < 10)) {
						this.td[12].a(2, 226, -488);
					}
				}

				this.Xf.a(466, 496, super.graphics, this.of);
				this.Ug.a(false);
				Pix3D.lineOffset = this.areaViewportOffset;
			}

			if (this.redrawPrivacySettings) {
				this.redrawPrivacySettings = false;
				this.Wf.a(false);
				this.id.a(0, 0, -488);
				this.fontPlain12.a(true, this.Ve, 16777215, 28, 55, "Public chat");
				if (this.Xd == 0) {
					this.fontPlain12.a(true, this.Ve, 65280, 41, 55, "On");
				}

				if (this.Xd == 1) {
					this.fontPlain12.a(true, this.Ve, 16776960, 41, 55, "Friends");
				}

				if (this.Xd == 2) {
					this.fontPlain12.a(true, this.Ve, 16711680, 41, 55, "Off");
				}

				if (this.Xd == 3) {
					this.fontPlain12.a(true, this.Ve, 65535, 41, 55, "Hide");
				}

				this.fontPlain12.a(true, this.Ve, 16777215, 28, 184, "Private chat");
				if (this.Ib == 0) {
					this.fontPlain12.a(true, this.Ve, 65280, 41, 184, "On");
				}

				if (this.Ib == 1) {
					this.fontPlain12.a(true, this.Ve, 16776960, 41, 184, "Friends");
				}

				if (this.Ib == 2) {
					this.fontPlain12.a(true, this.Ve, 16711680, 41, 184, "Off");
				}

				this.fontPlain12.a(true, this.Ve, 16777215, 28, 324, "Trade/compete");
				if (this.li == 0) {
					this.fontPlain12.a(true, this.Ve, 65280, 41, 324, "On");
				}

				if (this.li == 1) {
					this.fontPlain12.a(true, this.Ve, 16776960, 41, 324, "Friends");
				}

				if (this.li == 2) {
					this.fontPlain12.a(true, this.Ve, 16711680, 41, 324, "Off");
				}

				this.fontPlain12.a(true, this.Ve, 16777215, 33, 458, "Report abuse");
				this.Wf.a(453, 0, super.graphics, this.of);
				this.Ug.a(false);
				Pix3D.lineOffset = this.areaViewportOffset;
			}

			this.Uc = 0;
			if (arg0 != 7) {
				for (int var9 = 1; var9 > 0; ++var9) {
				}

			}
		} else {
			if (this.sceneState == 2) {
				this.a(this.Uc, this.Se, (byte) 5);
				if (this.dd != -1) {
					this.a(this.Uc, this.dd, (byte) 5);
				}

				this.Uc = 0;
				this.J(this.Cg);
				super.drawArea.a(false);
				Pix3D.lineOffset = this.Ud;
				Pix2D.clear();
				this.Le = true;
				Component var2 = Component.types(this.Se);
				if (var2.height == 512 && var2.width == 334 && var2.type == 0) {
					var2.height = 765;
					var2.width = 503;
				}

				this.a(0, 0, var2, 0, 8);
				if (this.dd != -1) {
					Component var3 = Component.types(this.dd);
					if (var3.height == 512 && var3.width == 334 && var3.type == 0) {
						var3.height = 765;
						var3.width = 503;
					}

					this.a(0, 0, var3, 0, 8);
				}

				if (!this.menuVisible) {
					this.w(-521);
					this.g((byte) -79);
				} else {
					this.p(false);
				}
			}

			super.drawArea.a(0, 0, super.graphics, this.of);
		}
	}

	@ObfuscatedName("client.q(I)V")
	public final void q(int arg0) {
		this.psize += arg0;
		if (this.hi != 0) {
			PixFont var2 = this.fontPlain12;
			int var3 = 0;
			if (this.systemUpdateTimer != 0) {
				var3 = 1;
			}

			for (int var4 = 0; var4 < 100; ++var4) {
				if (this.messageText[var4] != null) {
					int var5 = this.messageType[var4];
					String var6 = this.messageSender[var4];
					byte var7 = 0;
					if (var6 != null && var6.startsWith("@cr1@")) {
						var6 = var6.substring(5);
						var7 = 1;
					}

					if (var6 != null && var6.startsWith("@cr2@")) {
						var6 = var6.substring(5);
						var7 = 2;
					}

					if ((var5 == 3 || var5 == 7) && (var5 == 7 || this.Ib == 0 || this.Ib == 1 && this.a((int) 13292, (String) var6))) {
						int var8 = 329 - var3 * 13;
						byte var9 = 4;
						var2.b(2245, var9, 0, var8, "From");
						var2.b(2245, var9, 65535, var8 - 1, "From");
						int var10 = var9 + var2.a((byte) 35, "From ");
						if (var7 == 1) {
							this.modIcons[0].a(var8 - 12, var10, -488);
							var10 += 14;
						}

						if (var7 == 2) {
							this.modIcons[1].a(var8 - 12, var10, -488);
							var10 += 14;
						}

						var2.b(2245, var10, 0, var8, var6 + ": " + this.messageText[var4]);
						var2.b(2245, var10, 65535, var8 - 1, var6 + ": " + this.messageText[var4]);
						++var3;
						if (var3 >= 5) {
							return;
						}
					}

					if (var5 == 5 && this.Ib < 2) {
						int var11 = 329 - var3 * 13;
						var2.b(2245, 4, 0, var11, this.messageText[var4]);
						var2.b(2245, 4, 65535, var11 - 1, this.messageText[var4]);
						++var3;
						if (var3 >= 5) {
							return;
						}
					}

					if (var5 == 6 && this.Ib < 2) {
						int var12 = 329 - var3 * 13;
						var2.b(2245, 4, 0, var12, "To " + var6 + ": " + this.messageText[var4]);
						var2.b(2245, 4, 65535, var12 - 1, "To " + var6 + ": " + this.messageText[var4]);
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
		nodeId = Integer.parseInt(this.getParameter("nodeid"));
		portOffset = Integer.parseInt(this.getParameter("portoff"));
		String var1 = this.getParameter("lowmem");
		if (var1 != null && var1.equals("1")) {
			setLowMemory();
		} else {
			setHighMemory();
		}

		String var2 = this.getParameter("free");
		if (var2 != null && var2.equals("1")) {
			membersWorld = false;
		} else {
			membersWorld = true;
		}

		this.initApplet(765, 503);
	}

	@ObfuscatedName("client.r(I)V")
	public final void r(int arg0) {
		while (arg0 >= 0) {
			this.objStacks = null;
		}

		for (MapSpotAnim var2 = (MapSpotAnim) this.Uh.head(); var2 != null; var2 = (MapSpotAnim) this.Uh.next()) {
			if (this.currentLevel == var2.m && !var2.r) {
				if (loopCycle >= var2.v) {
					var2.a((byte) 1, this.Uc);
					if (var2.r) {
						var2.unlink();
					} else {
						this.scene.a(-1, var2, var2.n, var2.p, false, 0, var2.m, 60, var2.o, 0);
					}
				}
			} else {
				var2.unlink();
			}
		}

	}

	@ObfuscatedName("client.j(Z)V")
	public final void updateOnDemand(boolean arg0) {
		if (arg0) {
			this.ptype = -1;
		}

		while (true) {
			OnDemandRequest req = this.onDemand.cycle();
			if (req == null) {
				return;
			}

			if (req.archive == 0) {
				Model.unpack(req.data, req.file, (byte) 7);
				if ((this.onDemand.getModelFlags(req.file) & 98) != 0) {
					this.redrawSidebar = true;
					if (this.chatInterfaceId != -1 || this.stickyChatInterfaceId != -1) {
						this.redrawChatback = true;
					}
				}
			}

			if (req.archive == 1 && req.data != null) {
				AnimFrame.unpack(req.data, true);
			}

			if (req.archive == 2 && this.midiSong == req.file && req.data != null) {
				this.saveMidi(this.midiFading, req.data, 659);
			}

			if (req.archive == 3 && this.sceneState == 1) {
				for (int i = 0; i < this.sceneMapLandData.length; ++i) {
					if (this.sceneMaplandFile[i] == req.file) {
						this.sceneMapLandData[i] = req.data;

						if (req.data == null) {
							this.sceneMaplandFile[i] = -1;
						}
						break;
					}

					if (this.sceneMapLocFile[i] == req.file) {
						this.sceneMapLocData[i] = req.data;

						if (req.data == null) {
							this.sceneMapLocFile[i] = -1;
						}
						break;
					}
				}
			}

			if (req.archive == 93 && this.onDemand.hasMapLocFile(req.file)) {
				World.prefetchLocs(this.onDemand, new Packet(req.data), (byte) -3);
			}
		}
	}

	@ObfuscatedName("client.s(I)Z")
	public final boolean replayWave() {
		return SignLink.wavereplay();
	}

	@ObfuscatedName("client.a(Ljava/lang/String;Ljava/lang/String;Z)V")
	public final void login(String username, String password, boolean reconnect) {
		SignLink.errorname = username;

		try {
			if (!reconnect) {
				this.loginMessage0 = "";
				this.loginMessage1 = "Connecting to server...";
				this.drawTitle((byte) -50, true);
			}

			this.stream = new ClientStream((byte) 2, this.openSocket(portOffset + 43594), this);

			long var4 = JString.toBase37(username);
			int loginServer = (int) (var4 >> 16 & 31L);

			this.out.pos = 0;
			this.out.p1((int) 14);
			this.out.p1(loginServer);

			this.stream.write(0, 2, 0, this.out.data);
			for (int i = 0; i < 8; ++i) {
				this.stream.read();
			}

			int reply = this.stream.read();
			int var9 = reply;
			if (reply == 0) {
				this.stream.a(this.in.data, 0, 8);
				this.in.pos = 0;

				this.serverSeed = this.in.g8();
				int[] seed = new int[]{(int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (this.serverSeed >> 32), (int) this.serverSeed};

				this.out.pos = 0;
				this.out.p1((int) 10);
				this.out.p4(seed[0]);
				this.out.p4(seed[1]);
				this.out.p4(seed[2]);
				this.out.p4(seed[3]);
				this.out.p4(SignLink.uid);
				this.out.pjstr(username);
				this.out.pjstr(password);
				this.out.rsaenc(Wj, N);

				this.login.pos = 0;
				if (reconnect) {
					this.login.p1((int) 18);
				} else {
					this.login.p1((int) 16);
				}

				this.login.p1(this.out.pos + 36 + 1 + 1 + 2);
				this.login.p1((int) 255);
				this.login.p2((int) 377);
				this.login.p1(lowMemory ? 1 : 0);

				for (int var11 = 0; var11 < 9; ++var11) {
					this.login.p4(this.jagChecksum[var11]);
				}

				this.login.pdata(this.out.data, 0, this.out.pos, 0);
				this.out.random = new Isaac(this.lh, seed);

				for (int i = 0; i < 4; ++i) {
					seed[i] += 50;
				}

				this.randomIn = new Isaac(this.lh, seed);
				this.stream.write(0, this.login.pos, 0, this.login.data);
				reply = this.stream.read();
			}

			if (reply == 1) {
				try {
					Thread.sleep(2000L);
				} catch (Exception var22) {
				}

				this.login(username, password, reconnect);
			} else if (reply == 2) {
				this.staffModLevel = this.stream.read();
				fd = this.stream.read() == 1;
				this.Xb = 0L;
				this.Fj = 0;
				this.mousetracking.f = 0;
				super.s = true;
				this.hj = true;
				this.ingame = true;
				this.out.pos = 0;
				this.in.pos = 0;
				this.ptype = -1;
				this.ptype0 = -1;
				this.ptype1 = -1;
				this.ptype2 = -1;
				this.psize = 0;
				this.idleNetCycles = 0;
				this.systemUpdateTimer = 0;
				this.idleTimeout = 0;
				this.hintType = 0;
				this.menuSize = 0;
				this.menuVisible = false;
				super.idleCycles = 0;

				for (int i = 0; i < 100; ++i) {
					this.messageText[i] = null;
				}

				this.objSelected = 0;
				this.hh = 0;
				this.sceneState = 0;
				this.waveCount = 0;

				this.ab = (int) (Math.random() * 100.0D) - 50;
				this.ae = (int) (Math.random() * 110.0D) - 55;
				this.Ni = (int) (Math.random() * 80.0D) - 40;
				this.lc = (int) (Math.random() * 120.0D) - 60;
				this.ri = (int) (Math.random() * 30.0D) - 20;
				this.Ki = (int) (Math.random() * 20.0D) - 10 & 2047;

				this.Pe = 0;
				this.minimapLevel = -1;
				this.flagSceneTileX = 0;
				this.flagSceneTileZ = 0;

				this.od = 0;
				this.npcCount = 0;

				for (int i = 0; i < this.MAX_PLAYER_COUNT; ++i) {
					this.players[i] = null;
					this.playerAppearanceBuffer[i] = null;
				}

				for (int i = 0; i < 16384; ++i) {
					this.npcs[i] = null;
				}

				localPlayer = this.players[this.LOCAL_PLAYER_INDEX] = new ClientPlayer();

				this.oj.clear();
				this.Uh.clear();

				for (int level = 0; level < 4; ++level) {
					for (int x = 0; x < 104; ++x) {
						for (int y = 0; y < 104; ++y) {
							this.objStacks[level][x][y] = null;
						}
					}
				}

				this.locChanges = new LinkList();
				this.hb = 0;
				this.friendCount = 0;
				this.a(Ah, this.stickyChatInterfaceId);
				this.stickyChatInterfaceId = -1;
				this.a(Ah, this.chatInterfaceId);
				this.chatInterfaceId = -1;
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
				this.selectedTab = 3;
				this.Ci = 0;
				this.menuVisible = false;
				this.showSocialInput = false;
				this.modelMessage = null;
				this.inMultizone = 0;
				this.flashingTab = -1;
				this.designGender = true;
				this.f(this.ge);

				for (int var19 = 0; var19 < 5; ++var19) {
					this.designColours[var19] = 0;
				}

				for (int var20 = 0; var20 < 5; ++var20) {
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
				this.prepareGame();
			} else if (reply == 3) {
				this.loginMessage0 = "";
				this.loginMessage1 = "Invalid username or password.";
			} else if (reply == 4) {
				this.loginMessage0 = "Your account has been disabled.";
				this.loginMessage1 = "Please check your message-centre for details.";
			} else if (reply == 5) {
				this.loginMessage0 = "Your account is already logged in.";
				this.loginMessage1 = "Try again in 60 secs...";
			} else if (reply == 6) {
				this.loginMessage0 = "RuneScape has been updated!";
				this.loginMessage1 = "Please reload this page.";
			} else if (reply == 7) {
				this.loginMessage0 = "This world is full.";
				this.loginMessage1 = "Please use a different world.";
			} else if (reply == 8) {
				this.loginMessage0 = "Unable to connect.";
				this.loginMessage1 = "Login server offline.";
			} else if (reply == 9) {
				this.loginMessage0 = "Login limit exceeded.";
				this.loginMessage1 = "Too many connections from your address.";
			} else if (reply == 10) {
				this.loginMessage0 = "Unable to connect.";
				this.loginMessage1 = "Bad session id.";
			} else if (reply == 12) {
				this.loginMessage0 = "You need a members account to login to this world.";
				this.loginMessage1 = "Please subscribe, or use a different world.";
			} else if (reply == 13) {
				this.loginMessage0 = "Could not complete login.";
				this.loginMessage1 = "Please try using a different world.";
			} else if (reply == 14) {
				this.loginMessage0 = "The server is being updated.";
				this.loginMessage1 = "Please wait 1 minute and try again.";
			} else if (reply == 15) {
				this.ingame = true;
				this.out.pos = 0;
				this.in.pos = 0;
				this.ptype = -1;
				this.ptype0 = -1;
				this.ptype1 = -1;
				this.ptype2 = -1;
				this.psize = 0;
				this.idleNetCycles = 0;
				this.systemUpdateTimer = 0;
				this.menuSize = 0;
				this.menuVisible = false;
				this.sceneLoadStartTime = System.currentTimeMillis();
			} else if (reply == 16) {
				this.loginMessage0 = "Login attempts exceeded.";
				this.loginMessage1 = "Please wait 1 minute and try again.";
			} else if (reply == 17) {
				this.loginMessage0 = "You are standing in a members-only area.";
				this.loginMessage1 = "To play on this world move to a free area first";
			} else if (reply == 18) {
				this.loginMessage0 = "Account locked as we suspect it has been stolen.";
				this.loginMessage1 = "Press 'recover a locked account' on front page.";
			} else if (reply == 20) {
				this.loginMessage0 = "Invalid loginserver requested";
				this.loginMessage1 = "Please try using a different world.";
			} else if (reply != 21) {
				if (reply == 22) {
					this.loginMessage0 = "Malformed login packet.";
					this.loginMessage1 = "Please try again.";
				} else if (reply == 23) {
					this.loginMessage0 = "No reply from loginserver.";
					this.loginMessage1 = "Please try again.";
				} else if (reply == 24) {
					this.loginMessage0 = "Error loading your profile.";
					this.loginMessage1 = "Please contact customer support.";
				} else if (reply == 25) {
					this.loginMessage0 = "Unexpected loginserver response.";
					this.loginMessage1 = "Please try using a different world.";
				} else if (reply == 26) {
					this.loginMessage0 = "This computers address has been blocked";
					this.loginMessage1 = "as it was used to break our rules";
				} else if (reply == -1) {
					if (var9 == 0) {
						if (this.X < 2) {
							try {
								Thread.sleep(2000L);
							} catch (Exception var24) {
							}

							++this.X;
							this.login(username, password, reconnect);
						} else {
							this.loginMessage0 = "No response from loginserver";
							this.loginMessage1 = "Please wait 1 minute and try again.";
						}
					} else {
						this.loginMessage0 = "No response from server";
						this.loginMessage1 = "Please try using a different world.";
					}
				} else {
					System.out.println("response:" + reply);
					this.loginMessage0 = "Unexpected server response";
					this.loginMessage1 = "Please try using a different world.";
				}
			} else {
				int var21 = this.stream.read();

				for (int var26 = var21 + 3; var26 >= 0; --var26) {
					this.loginMessage0 = "You have only just left another world";
					this.loginMessage1 = "Your profile will be transferred in: " + var26;
					this.drawTitle((byte) -50, true);

					try {
						Thread.sleep(1200L);
					} catch (Exception var23) {
					}
				}

				this.login(username, password, reconnect);
			}
		} catch (IOException var25) {
			this.loginMessage0 = "";
			this.loginMessage1 = "Error connecting to server.";
		}
	}

	@ObfuscatedName("client.a(IIII)Z")
	public final boolean a(int arg0, int arg1, int arg2, int arg3) {
		int var5 = arg3 >> 14 & 32767;
		int var6 = this.scene.getInfo(this.currentLevel, arg2, arg0, arg3);
		if (var6 == -1) {
			return false;
		} else {
			int var7 = var6 & 31;
			int var8 = var6 >> 6 & 3;
			if (var7 != 10 && var7 != 11 && var7 != 22) {
				this.a(true, false, arg0, localPlayer.routeTileZ[0], 0, 0, 2, var7 + 1, arg2, 0, var8, localPlayer.routeTileX[0]);
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

				this.a(true, false, arg0, localPlayer.routeTileZ[0], var10, var11, 2, 0, arg2, var12, 0, localPlayer.routeTileX[0]);
			}

			this.le = super.C;
			this.me = super.D;
			this.oe = 2;
			this.ne = 0;
			this.psize += arg1;
			return true;
		}
	}

	@ObfuscatedName("client.i(B)V")
	public final void i(byte arg0) {
		short var2 = 256;

		for (int var3 = 10; var3 < 117; ++var3) {
			int var4 = (int) (Math.random() * 100.0D);
			if (var4 < 50) {
				this.yf[(var2 - 2 << 7) + var3] = 255;
			}
		}

		for (int var5 = 0; var5 < 100; ++var5) {
			int var6 = (int) (Math.random() * 124.0D) + 2;
			int var7 = (int) (Math.random() * 128.0D) + 128;
			int var8 = (var7 << 7) + var6;
			this.yf[var8] = 192;
		}

		for (int var9 = 1; var9 < var2 - 1; ++var9) {
			for (int var10 = 1; var10 < 127; ++var10) {
				int var11 = (var9 << 7) + var10;
				this.zf[var11] = (this.yf[var11 - 1] + this.yf[var11 + 1] + this.yf[var11 - 128] + this.yf[var11 + 128]) / 4;
			}
		}

		this.wi += 128;
		if (this.wi > this.mh.length) {
			this.wi -= this.mh.length;
			int var12 = (int) (Math.random() * 12.0D);
			this.a((Pix8) this.fg[var12], 0);
		}

		for (int var13 = 1; var13 < var2 - 1; ++var13) {
			for (int var14 = 1; var14 < 127; ++var14) {
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
			for (int var18 = 1; var18 > 0; ++var18) {
			}
		}

		for (int var19 = 0; var19 < var2 - 1; ++var19) {
			this.ch[var19] = this.ch[var19 + 1];
		}

		this.ch[var2 - 1] = (int) (Math.sin((double) loopCycle / 14.0D) * 16.0D + Math.sin((double) loopCycle / 15.0D) * 14.0D + Math.sin((double) loopCycle / 16.0D) * 12.0D);
		if (this.Me > 0) {
			this.Me -= 4;
		}

		if (this.Ne > 0) {
			this.Ne -= 4;
		}

		if (this.Me == 0 && this.Ne == 0) {
			int var20 = (int) (Math.random() * 2000.0D);
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
			this.objStacks = null;
		}

		if (this.menuSize < 400) {
			if (arg0.multinpc != null) {
				arg0 = arg0.getMultiNpc();
			}

			if (arg0 != null) {
				if (arg0.active) {
					String var6 = arg0.name;
					if (arg0.visLevel != 0) {
						var6 = var6 + getCombatLevelColorTag(arg0.visLevel, localPlayer.vislevel) + " (level-" + arg0.visLevel + ")";
					}

					if (this.objSelected == 1) {
						this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @yel@" + var6;
						this.menuAction[this.menuSize] = 347;
						this.menuParamA[this.menuSize] = arg3;
						this.menuParamB[this.menuSize] = arg2;
						this.menuParamC[this.menuSize] = arg1;
						this.menuSize++;
					} else {
						if (this.hh == 1) {
							if ((this.jh & 2) == 2) {
								this.menuOption[this.menuSize] = this.kh + " @yel@" + var6;
								this.menuAction[this.menuSize] = 67;
								this.menuParamA[this.menuSize] = arg3;
								this.menuParamB[this.menuSize] = arg2;
								this.menuParamC[this.menuSize] = arg1;
								this.menuSize++;
							}
						} else {
							if (arg0.op != null) {
								for (int var7 = 4; var7 >= 0; --var7) {
									if (arg0.op[var7] != null && !arg0.op[var7].equalsIgnoreCase("attack")) {
										this.menuOption[this.menuSize] = arg0.op[var7] + " @yel@" + var6;
										if (var7 == 0) {
											this.menuAction[this.menuSize] = 318;
										}

										if (var7 == 1) {
											this.menuAction[this.menuSize] = 921;
										}

										if (var7 == 2) {
											this.menuAction[this.menuSize] = 118;
										}

										if (var7 == 3) {
											this.menuAction[this.menuSize] = 553;
										}

										if (var7 == 4) {
											this.menuAction[this.menuSize] = 432;
										}

										this.menuParamA[this.menuSize] = arg3;
										this.menuParamB[this.menuSize] = arg2;
										this.menuParamC[this.menuSize] = arg1;
										this.menuSize++;
									}
								}
							}

							if (arg0.op != null) {
								for (int var8 = 4; var8 >= 0; --var8) {
									if (arg0.op[var8] != null && arg0.op[var8].equalsIgnoreCase("attack")) {
										short var9 = 0;
										if (arg0.visLevel > localPlayer.vislevel) {
											var9 = 2000;
										}

										this.menuOption[this.menuSize] = arg0.op[var8] + " @yel@" + var6;
										if (var8 == 0) {
											this.menuAction[this.menuSize] = var9 + 318;
										}

										if (var8 == 1) {
											this.menuAction[this.menuSize] = var9 + 921;
										}

										if (var8 == 2) {
											this.menuAction[this.menuSize] = var9 + 118;
										}

										if (var8 == 3) {
											this.menuAction[this.menuSize] = var9 + 553;
										}

										if (var8 == 4) {
											this.menuAction[this.menuSize] = var9 + 432;
										}

										this.menuParamA[this.menuSize] = arg3;
										this.menuParamB[this.menuSize] = arg2;
										this.menuParamC[this.menuSize] = arg1;
										this.menuSize++;
									}
								}
							}

							this.menuOption[this.menuSize] = "Examine @yel@" + var6;
							this.menuAction[this.menuSize] = 1668;
							this.menuParamA[this.menuSize] = arg3;
							this.menuParamB[this.menuSize] = arg2;
							this.menuParamC[this.menuSize] = arg1;
							this.menuSize++;
						}

					}
				}
			}
		}
	}

	@ObfuscatedName("client.a(LWRRBQEHV;I)V")
	public final void a(Pix8 arg0, int arg1) {
		this.psize += arg1;
		short var3 = 256;

		for (int var4 = 0; var4 < this.mh.length; ++var4) {
			this.mh[var4] = 0;
		}

		for (int var5 = 0; var5 < 5000; ++var5) {
			int var6 = (int) (Math.random() * 128.0D * (double) var3);
			this.mh[var6] = (int) (Math.random() * 256.0D);
		}

		for (int var7 = 0; var7 < 20; ++var7) {
			for (int var8 = 1; var8 < var3 - 1; ++var8) {
				for (int var9 = 1; var9 < 127; ++var9) {
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

			for (int var13 = 0; var13 < arg0.height; ++var13) {
				for (int var14 = 0; var14 < arg0.width; ++var14) {
					if (arg0.pixels[var12++] != 0) {
						int var15 = var14 + 16 + arg0.cropX;
						int var16 = var13 + 16 + arg0.cropY;
						int var17 = (var16 << 7) + var15;
						this.mh[var17] = 0;
					}
				}
			}

		}
	}

	@ObfuscatedName("client.t(I)V")
	public final void drawChat(int arg0) {
		this.Vg.a(false);
		Pix3D.lineOffset = this.areaChatbackOffset;

		this.xh.a(0, 0, -488);

		if (this.showSocialInput) {
			this.fontBold12.drawStringCenter(239, 40, this.socialMessage, 0);
			this.fontBold12.drawStringCenter(239, 60, this.socialInput + "*", 128);
		} else if (this.Ci == 1) {
			this.fontBold12.drawStringCenter(239, 40, "Enter amount:", 0);
			this.fontBold12.drawStringCenter(239, 60, this.chatbackInput + "*", 128);
		} else if (this.Ci == 2) {
			this.fontBold12.drawStringCenter(239, 40, "Enter name:", 0);
			this.fontBold12.drawStringCenter(239, 60, this.chatbackInput + "*", 128);
		} else if (this.Ci == 3) {
			if (this.ib != this.chatbackInput) {
				this.a(this.chatbackInput, 2);
				this.ib = this.chatbackInput;
			}

			PixFont var2 = this.fontPlain12;
			Pix2D.setBounds(463, 77, 0, 0);

			for (int var3 = 0; var3 < this.jb; ++var3) {
				int var4 = var3 * 14 + 18 - this.mb;
				if (var4 > 0 && var4 < 110) {
					var2.drawStringCenter(239, var4, this.kb[var3], 0);
				}
			}

			Pix2D.resetBounds();
			if (this.jb > 5) {
				this.a(true, this.mb, 463, 77, this.jb * 14 + 7, 0);
			}

			if (this.chatbackInput.length() == 0) {
				this.fontBold12.drawStringCenter(239, 40, "Enter object name", 255);
			} else if (this.jb == 0) {
				this.fontBold12.drawStringCenter(239, 40, "No matching objects found, please shorten search", 0);
			}

			var2.drawStringCenter(239, 90, this.chatbackInput + "*", 0);
			Pix2D.drawHorizontalLine(0, 77, 479, 0);
		} else if (this.modelMessage != null) {
			this.fontBold12.drawStringCenter(239, 40, this.modelMessage, 0);
			this.fontBold12.drawStringCenter(239, 60, "Click to continue", 128);
		} else if (this.chatInterfaceId != -1) {
			this.a(0, 0, Component.types(this.chatInterfaceId), 0, 8);
		} else if (this.stickyChatInterfaceId != -1) {
			this.a(0, 0, Component.types(this.stickyChatInterfaceId), 0, 8);
		} else {
			PixFont var5 = this.fontPlain12;
			int var6 = 0;
			Pix2D.setBounds(463, 77, 0, 0);

			for (int var7 = 0; var7 < 100; ++var7) {
				if (this.messageText[var7] != null) {
					int var8 = this.messageType[var7];
					int var9 = 70 - var6 * 14 + this.Y;
					String var10 = this.messageSender[var7];
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
							var5.b(2245, 4, 0, var9, this.messageText[var7]);
						}

						++var6;
					}

					if ((var8 == 1 || var8 == 2) && (var8 == 1 || this.Xd == 0 || this.Xd == 1 && this.a((int) 13292, (String) var10))) {
						if (var9 > 0 && var9 < 110) {
							int var12 = 4;
							if (var11 == 1) {
								this.modIcons[0].a(var9 - 12, var12, -488);
								var12 += 14;
							}

							if (var11 == 2) {
								this.modIcons[1].a(var9 - 12, var12, -488);
								var12 += 14;
							}

							var5.b(2245, var12, 0, var9, var10 + ":");
							int var13 = var12 + var5.a((byte) 35, var10) + 8;
							var5.b(2245, var13, 255, var9, this.messageText[var7]);
						}

						++var6;
					}

					if ((var8 == 3 || var8 == 7) && this.hi == 0 && (var8 == 7 || this.Ib == 0 || this.Ib == 1 && this.a((int) 13292, (String) var10))) {
						if (var9 > 0 && var9 < 110) {
							byte var14 = 4;
							var5.b(2245, var14, 0, var9, "From");
							int var15 = var14 + var5.a((byte) 35, "From ");
							if (var11 == 1) {
								this.modIcons[0].a(var9 - 12, var15, -488);
								var15 += 14;
							}

							if (var11 == 2) {
								this.modIcons[1].a(var9 - 12, var15, -488);
								var15 += 14;
							}

							var5.b(2245, var15, 0, var9, var10 + ":");
							int var16 = var15 + var5.a((byte) 35, var10) + 8;
							var5.b(2245, var16, 8388608, var9, this.messageText[var7]);
						}

						++var6;
					}

					if (var8 == 4 && (this.li == 0 || this.li == 1 && this.a((int) 13292, (String) var10))) {
						if (var9 > 0 && var9 < 110) {
							var5.b(2245, 4, 8388736, var9, var10 + " " + this.messageText[var7]);
						}

						++var6;
					}

					if (var8 == 5 && this.hi == 0 && this.Ib < 2) {
						if (var9 > 0 && var9 < 110) {
							var5.b(2245, 4, 8388608, var9, this.messageText[var7]);
						}

						++var6;
					}

					if (var8 == 6 && this.hi == 0 && this.Ib < 2) {
						if (var9 > 0 && var9 < 110) {
							var5.b(2245, 4, 0, var9, "To " + var10 + ":");
							var5.b(2245, 12 + var5.a((byte) 35, "To " + var10), 8388608, var9, this.messageText[var7]);
						}

						++var6;
					}

					if (var8 == 8 && (this.li == 0 || this.li == 1 && this.a((int) 13292, (String) var10))) {
						if (var9 > 0 && var9 < 110) {
							var5.b(2245, 4, 8270336, var9, var10 + " " + this.messageText[var7]);
						}

						++var6;
					}
				}
			}

			Pix2D.resetBounds();
			this.Vf = var6 * 14 + 7;
			if (this.Vf < 78) {
				this.Vf = 78;
			}

			this.a(true, this.Vf - this.Y - 77, 463, 77, this.Vf, 0);
			String var17;
			if (localPlayer != null && localPlayer.name != null) {
				var17 = localPlayer.name;
			} else {
				var17 = JString.formatDisplayName(this.username);
			}

			var5.b(2245, 4, 0, 90, var17 + ":");
			var5.b(2245, 6 + var5.a((byte) 35, var17 + ": "), 255, 90, this.Sf + "*");
			Pix2D.drawHorizontalLine(0, 77, 479, 0);
		}

		if (this.menuVisible && this.Kj == 2) {
			this.p(false);
		}

		this.Vg.a(357, 17, super.graphics, this.of);
		this.Ug.a(false);
		Pix3D.lineOffset = this.areaViewportOffset;
		if (arg0 != 0) {
			this.objStacks = null;
		}
	}

	@ObfuscatedName("client.u(I)V")
	public final void u(int arg0) {
		for (int var2 = -1; var2 < this.od; ++var2) {
			int var3;
			if (var2 == -1) {
				var3 = this.LOCAL_PLAYER_INDEX;
			} else {
				var3 = this.pd[var2];
			}

			ClientPlayer var4 = this.players[var3];
			if (var4 != null && var4.chatTimer > 0) {
				--var4.chatTimer;
				if (var4.chatTimer == 0) {
					var4.chatMessage = null;
				}
			}
		}

		this.psize += arg0;

		for (int var5 = 0; var5 < this.npcCount; ++var5) {
			int var6 = this.npcIds[var5];
			ClientNpc var7 = this.npcs[var6];
			if (var7 != null && var7.chatTimer > 0) {
				--var7.chatTimer;
				if (var7.chatTimer == 0) {
					var7.chatMessage = null;
				}
			}
		}

	}

	@ObfuscatedName("client.k(Z)V")
	public final void k(boolean arg0) {
		int var2 = 5;
		this.jagChecksum[8] = 0;
		int var4 = 0;

		while (this.jagChecksum[8] == 0) {
			String var5 = "Unknown problem";
			this.drawProgress(20, true, (String) "Connecting to web server");

			try {
				DataInputStream var6 = this.b("crc" + (int) (Math.random() * 9.9999999E7D) + "-" + 377);
				Packet var7 = new Packet(new byte[40]);
				var6.readFully(var7.data, 0, 40);
				var6.close();

				for (int var8 = 0; var8 < 9; ++var8) {
					this.jagChecksum[var8] = var7.g4();
				}

				int var9 = var7.g4();
				int var10 = 1234;

				for (int var11 = 0; var11 < 9; ++var11) {
					var10 = (var10 << 1) + this.jagChecksum[var11];
				}

				if (var9 != var10) {
					var5 = "checksum problem";
					this.jagChecksum[8] = 0;
				}
			} catch (EOFException var14) {
				var5 = "EOF problem";
				this.jagChecksum[8] = 0;
			} catch (IOException var15) {
				var5 = "connection problem";
				this.jagChecksum[8] = 0;
			} catch (Exception var16) {
				var5 = "logic problem";
				this.jagChecksum[8] = 0;
				if (!SignLink.reporterror) {
					return;
				}
			}

			if (this.jagChecksum[8] == 0) {
				++var4;

				for (int var12 = var2; var12 > 0; --var12) {
					if (var4 >= 10) {
						this.drawProgress(10, true, (String) "Game updated - please reload page");
						var12 = 10;
					} else {
						this.drawProgress(10, true, (String) (var5 + " - Will retry in " + var12 + " secs."));
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
			byte[] var2 = this.imageMapback.pixels;
			int[] var3 = Pix2D.data;
			int var4 = var2.length;

			for (int var5 = 0; var5 < var4; ++var5) {
				if (var2[var5] == 0) {
					var3[var5] = 0;
				}
			}

			this.eg.a(0, 567, 33, 25, 33, this.compassMaskLineLengths, 0, this.Ki, 256, this.compassMaskLineOffsets, 25);
			this.Ug.a(false);
			Pix3D.lineOffset = this.areaViewportOffset;
		} else {
			int var6 = this.lc + this.Ki & 2047;
			int var7 = localPlayer.x / 32 + 48;
			int var8 = 58 / arg0;
			int var9 = 464 - localPlayer.z / 32;
			this.imageMinimap.a(5, 567, 151, var7, 146, this.minimapMaskLineLengths, 25, var6, this.ri + 256, this.minimapMaskLineOffsets, var9);
			this.eg.a(0, 567, 33, 25, 33, this.compassMaskLineLengths, 0, this.Ki, 256, this.compassMaskLineOffsets, 25);

			for (int var10 = 0; var10 < this.qf; ++var10) {
				int var11 = this.rf[var10] * 4 + 2 - localPlayer.x / 32;
				int var12 = this.sf[var10] * 4 + 2 - localPlayer.z / 32;
				this.a(var12, true, this.kj[var10], var11);
			}

			for (int var13 = 0; var13 < 104; ++var13) {
				for (int var14 = 0; var14 < 104; ++var14) {
					LinkList var15 = this.objStacks[this.currentLevel][var13][var14];
					if (var15 != null) {
						int var16 = var13 * 4 + 2 - localPlayer.x / 32;
						int var17 = var14 * 4 + 2 - localPlayer.z / 32;
						this.a(var17, true, this.imageMapdot0, var16);
					}
				}
			}

			for (int var18 = 0; var18 < this.npcCount; ++var18) {
				ClientNpc var19 = this.npcs[this.npcIds[var18]];
				if (var19 != null && var19.isVisible()) {
					NpcType var20 = var19.type;
					if (var20.multinpc != null) {
						var20 = var20.getMultiNpc();
					}

					if (var20 != null && var20.minimap && var20.active) {
						int var21 = var19.x / 32 - localPlayer.x / 32;
						int var22 = var19.z / 32 - localPlayer.z / 32;
						this.a(var22, true, this.imageMapdot1, var21);
					}
				}
			}

			for (int var23 = 0; var23 < this.od; ++var23) {
				ClientPlayer var24 = this.players[this.pd[var23]];
				if (var24 != null && var24.isVisible()) {
					int var25 = var24.x / 32 - localPlayer.x / 32;
					int var26 = var24.z / 32 - localPlayer.z / 32;
					boolean var27 = false;
					long var28 = JString.toBase37(var24.name);

					for (int var30 = 0; var30 < this.friendCount; ++var30) {
						if (this.friendName37[var30] == var28 && this.friendWorld[var30] != 0) {
							var27 = true;
							break;
						}
					}

					boolean var31 = false;
					if (localPlayer.Nb != 0 && var24.Nb != 0 && localPlayer.Nb == var24.Nb) {
						var31 = true;
					}

					if (var27) {
						this.a(var26, true, this.imageMapdot3, var25);
					} else if (var31) {
						this.a(var26, true, this.imageMapdot4, var25);
					} else {
						this.a(var26, true, this.imageMapdot2, var25);
					}
				}
			}

			if (this.hintType != 0 && loopCycle % 20 < 10) {
				if (this.hintType == 1 && this.hintNpc >= 0 && this.hintNpc < this.npcs.length) {
					ClientNpc var32 = this.npcs[this.hintNpc];
					if (var32 != null) {
						int var33 = var32.x / 32 - localPlayer.x / 32;
						int var34 = var32.z / 32 - localPlayer.z / 32;
						this.a(var34, this.Ce, -687, var33);
					}
				}

				if (this.hintType == 2) {
					int var35 = (this.R - this.sceneBaseTileX) * 4 + 2 - localPlayer.x / 32;
					int var36 = (this.S - this.sceneBaseTileZ) * 4 + 2 - localPlayer.z / 32;
					this.a(var36, this.Ce, -687, var35);
				}

				if (this.hintType == 10 && this.hintPlayer >= 0 && this.hintPlayer < this.players.length) {
					ClientPlayer var37 = this.players[this.hintPlayer];
					if (var37 != null) {
						int var38 = var37.x / 32 - localPlayer.x / 32;
						int var39 = var37.z / 32 - localPlayer.z / 32;
						this.a(var39, this.Ce, -687, var38);
					}
				}
			}

			if (this.flagSceneTileX != 0) {
				int var40 = this.flagSceneTileX * 4 + 2 - localPlayer.x / 32;
				int var41 = this.flagSceneTileZ * 4 + 2 - localPlayer.z / 32;
				this.a(var41, true, this.Be, var40);
			}

			Pix2D.fillRect(16777215, 3, 3, 97, 78);
			this.Ug.a(false);
			Pix3D.lineOffset = this.areaViewportOffset;
		}
	}

	public final URL getCodeBase() {
		if (SignLink.mainapp != null) {
			return SignLink.mainapp.getCodeBase();
		} else {
			try {
				if (super.frame != null) {
					return new URL("http://127.0.0.1:" + (portOffset + 80));
				}
			} catch (Exception var1) {
			}

			return super.getCodeBase();
		}
	}

	@ObfuscatedName("client.a(IIB)Z")
	public final boolean a(int arg0, int arg1, byte arg2) {
		boolean var4 = false;
		Component var5 = Component.types(arg1);

		for (int var6 = 0; var6 < var5.children.length && var5.children[var6] != -1; ++var6) {
			Component var7 = Component.types(var5.children[var6]);
			if (var7.type == 0) {
				var4 |= this.a(arg0, var7.id, (byte) 5);
			}

			if (var7.type == 6 && (var7.anim != -1 || var7.activeAnim != -1)) {
				boolean var8 = this.b((Component) var7, -693);
				int var9;
				if (var8) {
					var9 = var7.activeAnim;
				} else {
					var9 = var7.anim;
				}

				if (var9 != -1) {
					SeqType var10 = SeqType.types[var9];
					var7.r += arg0;

					while (var7.r > var10.a(0, var7.z)) {
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

			if (var7.type == 6 && var7.i != 0) {
				int var11 = var7.i >> 16;
				int var12 = var7.i << 16 >> 16;
				int var13 = arg0 * var11;
				int var14 = arg0 * var12;
				var7.xan = var7.xan + var13 & 2047;
				var7.yan = var7.yan + var14 & 2047;
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
	public final void addIgnore(long username37) {
		if (username37 != 0L) {
			if (this.ignoreCount >= 100) {
				this.addMessage("Your ignore list is full. Max of 100 hit", "", 0);
			} else {
				String name = JString.formatDisplayName(JString.fromBase37(username37));

				for (int i = 0; i < this.ignoreCount; ++i) {
					if (this.ignoreName37[i] == username37) {
						this.addMessage(name + " is already on your ignore list", "", 0);
						return;
					}
				}

				for (int i = 0; i < this.friendCount; ++i) {
					if (this.friendName37[i] == username37) {
						this.addMessage("Please remove " + name + " from your friend list first", "", 0);
						return;
					}
				}

				this.ignoreName37[this.ignoreCount++] = username37;
				this.redrawSidebar = true;

				// IGNORELIST_ADD
				this.out.pIsaac(217);
				this.out.p8(username37);
			}
		}
	}

	@ObfuscatedName("client.a(B)V")
	public final void a(byte arg0) {
		if (!this.errorStarted && !this.errorLoading && !this.errorHost) {
			++loopCycle;
			if (arg0 == -111) {
				if (!this.ingame) {
					this.K(-724);
				} else {
					this.e((byte) 4);
				}

				this.updateOnDemand(false);
			}
		}
	}

	@ObfuscatedName("client.w(I)V")
	public final void w(int arg0) {
		if (this.bg == 0) {
			this.menuOption[0] = "Cancel";
			this.menuAction[0] = 1016;
			this.menuSize = 1;
			if (arg0 >= 0) {
				this.Vd = this.randomIn.nextInt();
			}

			if (this.Se != -1) {
				this.kc = 0;
				this.Vj = 0;
				this.a(0, Component.types(this.Se), 0, 0, 0, super.v, 23658, super.w);
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
						this.a(4, Component.types(this.fh), 0, 0, 4, super.v, 23658, super.w);
					} else {
						this.handleViewportOptions((byte) 7);
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
						this.a(205, Component.types(this.Df), 1, 0, 553, super.v, 23658, super.w);
					} else if (this.tabInterfaceId[this.selectedTab] != -1) {
						this.a(205, Component.types(this.tabInterfaceId[this.selectedTab]), 1, 0, 553, super.v, 23658, super.w);
					}
				}

				if (this.mj != this.kc) {
					this.redrawSidebar = true;
					this.mj = this.kc;
				}

				if (this.Vj != this.Je) {
					this.redrawSidebar = true;
					this.Je = this.Vj;
				}

				this.kc = 0;
				this.Vj = 0;
				if (super.v > 17 && super.w > 357 && super.v < 496 && super.w < 453) {
					if (this.chatInterfaceId != -1) {
						this.a(357, Component.types(this.chatInterfaceId), 2, 0, 17, super.v, 23658, super.w);
					} else if (this.stickyChatInterfaceId != -1) {
						this.a(357, Component.types(this.stickyChatInterfaceId), 3, 0, 17, super.v, 23658, super.w);
					} else if (super.w < 434 && super.v < 426 && this.Ci == 0) {
						this.d(466, super.v - 17, super.w - 357);
					}
				}

				if ((this.chatInterfaceId != -1 || this.stickyChatInterfaceId != -1) && this.kc != this.Uf) {
					this.redrawChatback = true;
					this.Uf = this.kc;
				}

				if ((this.chatInterfaceId != -1 || this.stickyChatInterfaceId != -1) && this.qj != this.Vj) {
					this.redrawChatback = true;
					this.qj = this.Vj;
				}

				boolean var2 = false;

				while (!var2) {
					var2 = true;

					for (int var3 = 0; var3 < this.menuSize - 1; ++var3) {
						if (this.menuAction[var3] < 1000 && this.menuAction[var3 + 1] > 1000) {
							String var4 = this.menuOption[var3];
							this.menuOption[var3] = this.menuOption[var3 + 1];
							this.menuOption[var3 + 1] = var4;
							int var5 = this.menuAction[var3];
							this.menuAction[var3] = this.menuAction[var3 + 1];
							this.menuAction[var3 + 1] = var5;
							int var6 = this.menuParamB[var3];
							this.menuParamB[var3] = this.menuParamB[var3 + 1];
							this.menuParamB[var3 + 1] = var6;
							int var7 = this.menuParamC[var3];
							this.menuParamC[var3] = this.menuParamC[var3 + 1];
							this.menuParamC[var3 + 1] = var7;
							int var8 = this.menuParamA[var3];
							this.menuParamA[var3] = this.menuParamA[var3 + 1];
							this.menuParamA[var3 + 1] = var8;
							var2 = false;
						}
					}
				}

			}
		}
	}

	@ObfuscatedName("client.c(III)Ljava/lang/String;")
	public static final String getCombatLevelColorTag(int otherLevel, int viewerLevel) {
		int levelDifference = viewerLevel - otherLevel;
		if (levelDifference < -9) {
			return "@red@";
		} else if (levelDifference < -6) {
			return "@or3@";
		} else if (levelDifference < -3) {
			return "@or2@";
		} else if (levelDifference < 0) {
			return "@or1@";
		} else if (levelDifference > 9) {
			return "@gre@";
		} else if (levelDifference > 6) {
			return "@gr3@";
		} else if (levelDifference > 3) {
			return "@gr2@";
		} else {
			return levelDifference > 0 ? "@gr1@" : "@yel@";
		}
	}

	@ObfuscatedName("client.x(I)V")
	public final void buildScene(int arg0) {
		try {
			this.minimapLevel = -1;
			this.Uh.clear();
			this.oj.clear();
			Pix3D.b((byte) 71);
			this.k((int) 383);
			this.scene.reset((byte) 7);
			System.gc();

			for (int i = 0; i < 4; ++i) {
				this.levelCollisionMap[i].reset();
			}

			for (int var3 = 0; var3 < 4; ++var3) {
				for (int var4 = 0; var4 < 104; ++var4) {
					for (int var5 = 0; var5 < 104; ++var5) {
						this.levelTileFlags[var3][var4][var5] = 0;
					}
				}
			}

			World var6 = new World(this.levelHeightmap, 14290, this.levelTileFlags, 104, 104);
			int var7 = this.sceneMapLandData.length;
			this.out.pIsaac(40);
			if (!this.Zg) {
				for (int var8 = 0; var8 < var7; ++var8) {
					int var9 = (this.db[var8] >> 8) * 64 - this.sceneBaseTileX;
					int var10 = (this.db[var8] & 255) * 64 - this.sceneBaseTileZ;
					byte[] var11 = this.sceneMapLandData[var8];
					if (var11 != null) {
						var6.a(var10, false, (this.Lb - 6) * 8, var9, var11, (this.Kb - 6) * 8, this.levelCollisionMap);
					}
				}

				for (int var12 = 0; var12 < var7; ++var12) {
					int var13 = (this.db[var12] >> 8) * 64 - this.sceneBaseTileX;
					int var14 = (this.db[var12] & 255) * 64 - this.sceneBaseTileZ;
					byte[] var15 = this.sceneMapLandData[var12];
					if (var15 == null && this.Lb < 800) {
						var6.a(var13, var14, 64, -810, 64);
					}
				}

				this.out.pIsaac(40);

				for (int var16 = 0; var16 < var7; ++var16) {
					byte[] var17 = this.sceneMapLocData[var16];
					if (var17 != null) {
						int var18 = (this.db[var16] >> 8) * 64 - this.sceneBaseTileX;
						int var19 = (this.db[var16] & 255) * 64 - this.sceneBaseTileZ;
						var6.a(var19, this.levelCollisionMap, var18, -571, this.scene, var17);
					}
				}
			}

			if (this.Zg) {
				int var20 = 0;

				label252:
				while (true) {
					if (var20 >= 4) {
						for (int var31 = 0; var31 < 13; ++var31) {
							for (int var32 = 0; var32 < 13; ++var32) {
								int var33 = this.Ab[0][var31][var32];
								if (var33 == -1) {
									var6.a(var31 * 8, var32 * 8, 8, -810, 8);
								}
							}
						}

						this.out.pIsaac(40);
						int var34 = 0;

						while (true) {
							if (var34 >= 4) {
								break label252;
							}

							for (int var35 = 0; var35 < 13; ++var35) {
								for (int var36 = 0; var36 < 13; ++var36) {
									int var37 = this.Ab[var34][var35][var36];
									if (var37 != -1) {
										int var38 = var37 >> 24 & 3;
										int var39 = var37 >> 1 & 3;
										int var40 = var37 >> 14 & 1023;
										int var41 = var37 >> 3 & 2047;
										int var42 = (var40 / 8 << 8) + var41 / 8;

										for (int var43 = 0; var43 < this.db.length; ++var43) {
											if (this.db[var43] == var42 && this.sceneMapLocData[var43] != null) {
												var6.a(var34, this.levelCollisionMap, this.scene, false, this.sceneMapLocData[var43], var36 * 8, var39, (var40 & 7) * 8, var35 * 8, (var41 & 7) * 8, var38);
												break;
											}
										}
									}
								}
							}

							++var34;
						}
					}

					for (int var21 = 0; var21 < 13; ++var21) {
						for (int var22 = 0; var22 < 13; ++var22) {
							boolean var23 = false;
							int var24 = this.Ab[var20][var21][var22];
							if (var24 != -1) {
								int var25 = var24 >> 24 & 3;
								int var26 = var24 >> 1 & 3;
								int var27 = var24 >> 14 & 1023;
								int var28 = var24 >> 3 & 2047;
								int var29 = (var27 / 8 << 8) + var28 / 8;

								for (int var30 = 0; var30 < this.db.length; ++var30) {
									if (this.db[var30] == var29 && this.sceneMapLandData[var30] != null) {
										var6.a(var26, (var28 & 7) * 8, false, this.sceneMapLandData[var30], var20, var25, var21 * 8, this.levelCollisionMap, var22 * 8, (var27 & 7) * 8);
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

			this.out.pIsaac(40);
			var6.a(this.levelCollisionMap, this.Yj, this.scene);
			if (this.Ug != null) {
				this.Ug.a(false);
				Pix3D.lineOffset = this.areaViewportOffset;
			}

			this.out.pIsaac(40);
			int var44 = World.m;
			if (var44 > this.currentLevel) {
				var44 = this.currentLevel;
			}

			if (var44 < this.currentLevel - 1) {
				int var45 = this.currentLevel - 1;
			}

			if (lowMemory) {
				this.scene.a(World.m, true);
			} else {
				this.scene.a(0, true);
			}

			for (int var46 = 0; var46 < 104; ++var46) {
				for (int var47 = 0; var47 < 104; ++var47) {
					this.sortObjStacks(var46, var47);
				}
			}

			this.d((byte) 3);
		} catch (Exception var61) {
		}

		LocType.v.clear();
		if (super.frame != null) {
			this.out.pIsaac(78);
			this.out.p4(1057001181);
		}

		if (lowMemory && SignLink.cache_dat != null) {
			int var49 = this.onDemand.getFileCount(0);

			for (int var50 = 0; var50 < var49; ++var50) {
				int var51 = this.onDemand.getModelFlags(var50);
				if ((var51 & 121) == 0) {
					Model.a(var50, (int) 1);
				}
			}
		}

		System.gc();
		Pix3D.initPool((byte) 7, 20);
		this.onDemand.clearPrefetches();
		int var52 = (this.Kb - 6) / 8 - 1;
		int var53 = (this.Kb + 6) / 8 + 1;
		int var54 = (this.Lb - 6) / 8 - 1;
		int var55 = (this.Lb + 6) / 8 + 1;
		int var56 = 94 / arg0;
		if (this.withinTutorialIsland) {
			var52 = 49;
			var53 = 50;
			var54 = 49;
			var55 = 50;
		}

		for (int var57 = var52; var57 <= var53; ++var57) {
			for (int var58 = var54; var58 <= var55; ++var58) {
				if (var52 == var57 || var53 == var57 || var54 == var58 || var55 == var58) {
					int var59 = this.onDemand.getMapFile((int) var58, var57, 0);
					if (var59 != -1) {
						this.onDemand.prefetch(3, var59);
					}

					int var60 = this.onDemand.getMapFile((int) var58, var57, 1);
					if (var60 != -1) {
						this.onDemand.prefetch(3, var60);
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
			this.ptype = -1;
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

		this.cameraX = arg1 - var10;
		this.cameraY = arg0 - var11;
		this.cameraZ = arg5 - var12;
		this.cameraPitch = arg2;
		this.cameraYaw = arg4;
	}

	@ObfuscatedName("client.b(LEWIXBTLV;I)Z")
	public final boolean b(Component arg0, int arg1) {
		if (arg1 >= 0) {
			this.lh = 276;
		}

		if (arg0.scriptComparator == null) {
			return false;
		} else {
			for (int var3 = 0; var3 < arg0.scriptComparator.length; ++var3) {
				int var4 = this.executeClientScript((Component) arg0, (int) var3);
				int var5 = arg0.scriptOperand[var3];
				if (arg0.scriptComparator[var3] == 2) {
					if (var4 >= var5) {
						return false;
					}
				} else if (arg0.scriptComparator[var3] == 3) {
					if (var4 <= var5) {
						return false;
					}
				} else if (arg0.scriptComparator[var3] == 4) {
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
	public final void getPlayerPos(int size, int arg1, Packet buf) {
		this.entityRemovalCount = 0;
		this.entityUpdateCount = 0;

		this.a(size, this.gj, buf);
		this.b(size, (int) -138, buf);
		this.a(size, (byte) 6, (Packet) buf);
		this.a(808, buf, size);

		for (int i = 0; i < this.entityRemovalCount; ++i) {
			int index = this.entityRemovalIds[i];
			if (loopCycle != this.players[index].cycle) {
				this.players[index] = null;
			}
		}

		if (buf.pos != size) {
			SignLink.reporterror("Error packet size mismatch in getplayer pos:" + buf.pos + " psize:" + size);
			throw new RuntimeException("eek");
		} else {
			for (int var7 = 0; var7 < this.od; ++var7) {
				if (this.players[this.pd[var7]] == null) {
					SignLink.reporterror(this.username + " null entry in pl list - pos:" + var7 + " size:" + this.od);
					throw new RuntimeException("eek");
				}
			}

		}
	}

	@ObfuscatedName("client.b(IJ)V")
	public final void removeIgnore(long username) {
		if (username == 0L) {
			return;
		}

		for (int i = 0; i < this.ignoreCount; ++i) {
			if (this.ignoreName37[i] == username) {
				this.ignoreCount--;
				this.redrawSidebar = true;

				for (int j = i; j < this.ignoreCount; j++) {
					this.ignoreName37[j] = this.ignoreName37[j + 1];
				}

				// IGNORELIST_DEL
				this.out.pIsaac(160);
				this.out.p8(username);
				break;
			}
		}
	}

	public final String getParameter(String name) {
		return SignLink.mainapp != null ? SignLink.mainapp.getParameter(name) : super.getParameter(name);
	}

	@ObfuscatedName("client.y(I)V")
	public final void y(int arg0) {
		short var2 = 256;
		if (this.Me > 0) {
			for (int var3 = 0; var3 < 256; ++var3) {
				if (this.Me > 768) {
					this.Qj[var3] = this.b(this.Rj[var3], this.Sj[var3], 1024 - this.Me, 8);
				} else if (this.Me > 256) {
					this.Qj[var3] = this.Sj[var3];
				} else {
					this.Qj[var3] = this.b(this.Sj[var3], this.Rj[var3], 256 - this.Me, 8);
				}
			}
		} else if (this.Ne > 0) {
			for (int var4 = 0; var4 < 256; ++var4) {
				if (this.Ne > 768) {
					this.Qj[var4] = this.b(this.Rj[var4], this.Tj[var4], 1024 - this.Ne, 8);
				} else if (this.Ne > 256) {
					this.Qj[var4] = this.Tj[var4];
				} else {
					this.Qj[var4] = this.b(this.Tj[var4], this.Rj[var4], 256 - this.Ne, 8);
				}
			}
		} else {
			for (int var5 = 0; var5 < 256; ++var5) {
				this.Qj[var5] = this.Rj[var5];
			}
		}

		for (int var6 = 0; var6 < 33920; ++var6) {
			this.Lh.b[var6] = this.ie.pixels[var6];
		}

		int var7 = 0;
		int var8 = 1152;

		for (int var9 = 1; var9 < var2 - 1; ++var9) {
			int var10 = (var2 - var9) * this.ch[var9] / var2;
			int var11 = var10 + 22;
			if (var11 < 0) {
				var11 = 0;
			}

			var7 += var11;

			for (int var12 = var11; var12 < 128; ++var12) {
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

		this.Lh.a(0, 0, super.graphics, this.of);
		int var18 = 66 / arg0;

		for (int var19 = 0; var19 < 33920; ++var19) {
			this.Mh.b[var19] = this.je.pixels[var19];
		}

		int var20 = 0;
		int var21 = 1176;

		for (int var22 = 1; var22 < var2 - 1; ++var22) {
			int var23 = (var2 - var22) * this.ch[var22] / var2;
			int var24 = 103 - var23;
			int var25 = var21 + var23;

			for (int var26 = 0; var26 < var24; ++var26) {
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

		this.Mh.a(0, 637, super.graphics, this.of);
	}

	@ObfuscatedName("client.a(ZBI)V")
	public final void setMidiVolume(int volume, boolean active) {
		SignLink.midivol = volume;
		if (active) {
			SignLink.midi = "voladjust";
		}
	}

	@ObfuscatedName("client.z(I)V")
	public final void z(int arg0) {
		for (int var2 = -1; var2 < this.od; ++var2) {
			int var3;
			if (var2 == -1) {
				var3 = this.LOCAL_PLAYER_INDEX;
			} else {
				var3 = this.pd[var2];
			}

			ClientPlayer var4 = this.players[var3];
			if (var4 != null) {
				this.a(1, (byte) -97, (ClientEntity) var4);
			}
		}

		if (arg0 < this.gi || arg0 > this.gi) {
			for (int var5 = 1; var5 > 0; ++var5) {
			}
		}

	}

	@ObfuscatedName("client.l(Z)V")
	public static final void setLowMemory() {
		World3D.lowMemory = true;
		Pix3D.lowMemory = true;
		lowMemory = true;
		World.lowMemory = true;
		LocType.lowMemory = true;
	}

	@ObfuscatedName("client.b(JI)V")
	public final void addFriend(long username, int arg1) {
		if (username == 0L) {
			return;
		}

		if (this.friendCount >= 100 && this.membersAccount != 1) {
			this.addMessage("Your friendlist is full. Max of 100 for free users, and 200 for members", "", 0);
		} else if (this.friendCount >= 200) {
			this.addMessage("Your friendlist is full. Max of 100 for free users, and 200 for members", "", 0);
		} else {
			String displayName = JString.formatDisplayName(JString.fromBase37(username));

			for (int i = 0; i < this.friendCount; ++i) {
				if (this.friendName37[i] == username) {
					this.addMessage(displayName + " is already on your friend list", "", 0);
					return;
				}
			}

			for (int i = 0; i < this.ignoreCount; ++i) {
				if (this.ignoreName37[i] == username) {
					this.addMessage("Please remove " + displayName + " from your ignore list first", "", 0);
					return;
				}
			}

			if (!displayName.equals(localPlayer.name)) {
				this.friendName[this.friendCount] = displayName;
				this.friendName37[this.friendCount] = username;
				this.friendWorld[this.friendCount] = 0;
				this.friendCount++;

				this.redrawSidebar = true;

				// FRIENDLIST_ADD
				this.out.pIsaac(120);
				this.out.p8(username);
			}
		}
	}

	@ObfuscatedName("client.a(BLEWIXBTLV;)V")
	public final void updateInterfaceContent(Component com) {
		int clientCode = com.clientCode;

		if ((clientCode < 1 || clientCode > 100) && (clientCode < 701 || clientCode > 800)) {
			if (clientCode >= 101 && clientCode <= 200 || clientCode >= 801 && clientCode <= 900) {
				int friendCount = this.friendCount;
				if (this.hb != 2) {
					friendCount = 0;
				}

				if (clientCode > 800) {
					clientCode -= 701;
				} else {
					clientCode -= 101;
				}

				if (clientCode >= friendCount) {
					com.text = "";
					com.buttonType = 0;
				} else {
					if (this.friendWorld[clientCode] == 0) {
						com.text = "@red@Offline";
					} else if (this.friendWorld[clientCode] < 200) {
						if (this.friendWorld[clientCode] == nodeId) {
							com.text = "@gre@World" + (this.friendWorld[clientCode] - 9);
						} else {
							com.text = "@yel@World" + (this.friendWorld[clientCode] - 9);
						}
					} else if (this.friendWorld[clientCode] == nodeId) {
						com.text = "@gre@Classic" + (this.friendWorld[clientCode] - 219);
					} else {
						com.text = "@yel@Classic" + (this.friendWorld[clientCode] - 219);
					}

					com.buttonType = 1;
				}
			} else if (clientCode == 203) {
				int scroll = this.friendCount;

				if (this.hb != 2) {
					scroll = 0;
				}

				com.scroll = scroll * 15 + 20;
				if (com.scroll <= com.width) {
					com.scroll = com.width + 1;
				}

			} else if (clientCode >= 401 && clientCode <= 500) {
				clientCode -= 401;
				if (clientCode == 0 && this.hb == 0) {
					com.text = "Loading ignore list";
					com.buttonType = 0;
				} else if (clientCode == 1 && this.hb == 0) {
					com.text = "Please wait...";
					com.buttonType = 0;
				} else {
					int ignoreCount = this.ignoreCount;
					if (this.hb == 0) {
						ignoreCount = 0;
					}

					if (clientCode >= ignoreCount) {
						com.text = "";
						com.buttonType = 0;
					} else {
						com.text = JString.formatDisplayName(JString.fromBase37(this.ignoreName37[clientCode]));
						com.buttonType = 1;
					}
				}
			} else if (clientCode == 503) {
				com.scroll = this.ignoreCount * 15 + 20;
				if (com.scroll <= com.width) {
					com.scroll = com.width + 1;
				}

			} else if (clientCode == 327) {
				com.xan = 150;
				com.yan = (int) (Math.sin((double) loopCycle / 40.0D) * 256.0D) & 0x7FF;

				if (this.updateDesignModel) {
					for (int i = 0; i < 7; ++i) {
						int kit = this.designKits[i];
						if (kit >= 0 && !IdkType.types[kit].modelIsReady((int) 256)) {
							return;
						}
					}

					this.updateDesignModel = false;

					Model[] models = new Model[7];
					int modelCount = 0;

					for (int i = 0; i < 7; ++i) {
						int kit = this.designKits[i];
						if (kit >= 0) {
							models[modelCount++] = IdkType.types[kit].getModel((byte) 2);
						}
					}

					Model model = new Model(modelCount, models);
					for (int i = 0; i < 5; ++i) {
						if (this.designColours[i] != 0) {
							model.recolour(DESIGN_BODY_COLOUR[i][0], DESIGN_BODY_COLOUR[i][this.designColours[i]]);
							if (i == 1) {
								model.recolour(DESIGN_HAIR_COLOUR[0], DESIGN_HAIR_COLOUR[this.designColours[i]]);
							}
						}
					}

					model.createLabelReferences();
					model.applyTransform(SeqType.types[localPlayer.readyanim].frames[0]);
					model.calculateNormals(64, 850, -30, -50, -30, true);

					com.modelType = 5;
					com.model = 0;
					Component.cacheModel((Model) model, 0, 5);
				}

			} else if (clientCode == 324) {
				if (this.genderButtonImage0 == null) {
					this.genderButtonImage0 = com.graphic;
					this.genderButtonImage1 = com.activeGraphic;
				}

				if (this.designGender) {
					com.graphic = this.genderButtonImage1;
				} else {
					com.graphic = this.genderButtonImage0;
				}
			} else if (clientCode == 325) {
				if (this.genderButtonImage0 == null) {
					this.genderButtonImage0 = com.graphic;
					this.genderButtonImage1 = com.activeGraphic;
				}

				if (this.designGender) {
					com.graphic = this.genderButtonImage0;
				} else {
					com.graphic = this.genderButtonImage1;
				}
			} else if (clientCode == 600) {
				com.text = this.reportAbuseInput;

				if (loopCycle % 20 < 10) {
					com.text = com.text + "|";
				} else {
					com.text = com.text + " ";
				}
			} else {
				if (clientCode == 620) {
					if (this.staffModLevel >= 1) {
						if (this.reportAbuseMuteOption) {
							com.colour = 16711680;
							com.text = "Moderator option: Mute player for 48 hours: <ON>";
						} else {
							com.colour = 16777215;
							com.text = "Moderator option: Mute player for 48 hours: <OFF>";
						}
					} else {
						com.text = "";
					}
				}

				if (clientCode == 660) {
					int text = this.gh - this.Zh;
					String var18;
					if (text <= 0) {
						var18 = "earlier today";
					} else if (text == 1) {
						var18 = "yesterday";
					} else {
						var18 = text + " days ago";
					}

					com.text = "You last logged in @red@" + var18 + "@bla@ from: @red@" + SignLink.dns;
				}

				if (clientCode == 661) {
					if (this.ze == 0) {
						com.text = "\\nYou have not yet set any recovery questions.\\nIt is @lre@strongly@yel@ recommended that you do so.\\n\\nIf you don't you will be @lre@unable to recover your\\n@lre@password@yel@ if you forget it, or it is stolen.";
					} else if (this.ze <= this.gh) {
						com.text = "\\n\\nRecovery Questions Last Set:\\n@gre@" + this.a(this.ze, (byte) 83);
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

						com.text = var20 + " you requested@lre@ new recovery\\n@lre@questions.@yel@ The requested change will occur\\non: @lre@" + this.a(this.ze, (byte) 83) + "\\n\\nIf you do not remember making this request\\ncancel it immediately, and change your password.";
					}
				}

				if (clientCode == 662) {
					String var21;
					if (this.fj == 0) {
						var21 = "@yel@0 unread messages";
					} else if (this.fj == 1) {
						var21 = "@gre@1 unread message";
					} else {
						var21 = "@gre@" + this.fj + " unread messages";
					}

					com.text = "You have " + var21 + "\\nin your message centre.";
				}

				if (clientCode == 663) {
					if (this.xf > 0 && this.xf <= this.gh + 10) {
						com.text = "Last password change:\\n@gre@" + this.a(this.xf, (byte) 83);
					} else {
						com.text = "Last password change:\\n@gre@Never changed";
					}
				}

				if (clientCode == 665) {
					if (this.Jd > 2 && !membersWorld) {
						com.text = "This is a non-members\\nworld. To enjoy your\\nmembers benefits we\\nrecommend you play on a\\nmembers world instead.";
					} else if (this.Jd > 2) {
						com.text = "\\n\\nYou have @gre@" + this.Jd + "@yel@ days of\\nmember credit remaining.";
					} else if (this.Jd > 0) {
						com.text = "You have @gre@" + this.Jd + "@yel@ days of\\nmember credit remaining.\\n\\n@lre@Credit low! Renew now\\n@lre@to avoid losing members.";
					} else {
						com.text = "You are not a member.\\n\\nChoose to subscribe and\\nyou'll get loads of extra\\nbenefits and features.";
					}
				}

				if (clientCode == 667) {
					if (this.Jd > 2 && !membersWorld) {
						com.text = "To switch to a members-only world:\\n1) Logout and return to the world selection page.\\n2) Choose one of the members world with a gold star next to it's name.\\n\\nIf you prefer you can continue to use this world,\\nbut members only features will be unavailable here.";
					} else if (this.Jd > 0) {
						com.text = "To extend or cancel a subscription:\\n1) Logout and return to the frontpage of this website.\\n2)Choose the relevant option from the 'membership' section.\\n\\nNote: If you are a credit card subscriber a top-up payment will\\nautomatically be taken when 3 days credit remain.\\n(unless you cancel your subscription, which can be done at any time.)";
					} else {
						com.text = "To start a subscripton:\\n1) Logout and return to the frontpage of this website.\\n2) Choose 'Start a new subscription'";
					}
				}

				if (clientCode == 668) {
					if (this.ze > this.gh) {
						com.text = "To cancel this request:\\n1) Logout and return to the frontpage of this website.\\n2) Choose 'Cancel recovery questions'.";
					} else {
						com.text = "To change your recovery questions:\\n1) Logout and return to the frontpage of this website.\\n2) Choose 'Set new recovery questions'.";
					}
				}
			}
		} else if (clientCode == 1 && this.hb == 0) {
			com.text = "Loading friend list";
			com.buttonType = 0;
		} else if (clientCode == 1 && this.hb == 1) {
			com.text = "Connecting to friendserver";
			com.buttonType = 0;
		} else if (clientCode == 2 && this.hb != 2) {
			com.text = "Please wait...";
			com.buttonType = 0;
		} else {
			int var5 = this.friendCount;
			if (this.hb != 2) {
				var5 = 0;
			}

			if (clientCode > 700) {
				clientCode -= 601;
			} else {
				--clientCode;
			}

			if (clientCode >= var5) {
				com.text = "";
				com.buttonType = 0;
			} else {
				com.text = this.friendName[clientCode];
				com.buttonType = 1;
			}
		}
	}

	@ObfuscatedName("client.a(IB)Ljava/lang/String;")
	public final String a(int arg0, byte arg1) {
		if (arg1 != 83) {
			this.ptype = this.in.g1();
		}

		if (arg0 > this.gh + 10) {
			return "Unknown";
		} else {
			long var3 = ((long) arg0 + 11745L) * 86400000L;
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
	public final void updateVarp(int arg0, int arg1) {
		this.psize += arg0;
		int var3 = VarpType.types[arg1].clientcode;
		if (var3 != 0) {
			int var4 = this.varps[arg1];
			if (var3 == 1) {
				if (var4 == 1) {
					Pix3D.setBrightness(0.9D, (byte) 6);
				}

				if (var4 == 2) {
					Pix3D.setBrightness(0.8D, (byte) 6);
				}

				if (var4 == 3) {
					Pix3D.setBrightness(0.7D, (byte) 6);
				}

				if (var4 == 4) {
					Pix3D.setBrightness(0.6D, (byte) 6);
				}

				ObjType.iconCache.clear();
				this.Le = true;
			}

			if (var3 == 3) {
				boolean var5 = this.midiActive;
				if (var4 == 0) {
					this.setMidiVolume(0, this.midiActive);
					this.midiActive = true;
				}

				if (var4 == 1) {
					this.setMidiVolume(-400, this.midiActive);
					this.midiActive = true;
				}

				if (var4 == 2) {
					this.setMidiVolume(-800, this.midiActive);
					this.midiActive = true;
				}

				if (var4 == 3) {
					this.setMidiVolume(-1200, this.midiActive);
					this.midiActive = true;
				}

				if (var4 == 4) {
					this.midiActive = false;
				}

				if (this.midiActive != var5 && !lowMemory) {
					if (this.midiActive) {
						this.midiSong = this.nextMidiSong;
						this.midiFading = true;
						this.onDemand.request(2, this.midiSong);
					} else {
						this.g(false);
					}

					this.nextMusicDelay = 0;
				}
			}

			if (var3 == 4) {
				if (var4 == 0) {
					this.waveEnabled = true;
					this.c(822, 0);
				}

				if (var4 == 1) {
					this.waveEnabled = true;
					this.c(822, -400);
				}

				if (var4 == 2) {
					this.waveEnabled = true;
					this.c(822, -800);
				}

				if (var4 == 3) {
					this.waveEnabled = true;
					this.c(822, -1200);
				}

				if (var4 == 4) {
					this.waveEnabled = false;
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
				this.redrawChatback = true;
			}

			if (var3 == 9) {
				this.Yc = var4;
			}
		}
	}

	@ObfuscatedName("client.b(IIII)I")
	public final int b(int arg0, int arg1, int arg2, int arg3) {
		if (arg3 < 8 || arg3 > 8) {
			this.out.p1((int) 235);
		}

		int var5 = 256 - arg2;
		return ((arg0 & 16711935) * var5 + (arg1 & 16711935) * arg2 & -16711936) + ((arg0 & 65280) * var5 + (arg1 & 65280) * arg2 & 16711680) >> 8;
	}

	@ObfuscatedName("client.A(I)V")
	public final void A(int arg0) {
		this.overrideChat = 0;
		int var2 = (localPlayer.x >> 7) + this.sceneBaseTileX;
		int var3 = (localPlayer.z >> 7) + this.sceneBaseTileZ;
		if (arg0 < 0) {
			if (var2 >= 3053 && var2 <= 3156 && var3 >= 3056 && var3 <= 3136) {
				this.overrideChat = 1;
			}

			if (var2 >= 3072 && var2 <= 3118 && var3 >= 9492 && var3 <= 9535) {
				this.overrideChat = 1;
			}

			if (this.overrideChat == 1 && var2 >= 3139 && var2 <= 3199 && var3 >= 3008 && var3 <= 3062) {
				this.overrideChat = 0;
			}
		}
	}

	@ObfuscatedName("client.B(I)V")
	public final void B(int arg0) {
		int var2 = this.fontBold12.a((byte) 35, "Choose Option");

		for (int var3 = 0; var3 < this.menuSize; ++var3) {
			int var4 = this.fontBold12.a((byte) 35, this.menuOption[var3]);
			if (var4 > var2) {
				var2 = var4;
			}
		}

		var2 += 8;

		int var5 = this.menuSize * 15 + 21;
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

			this.menuVisible = true;
			this.Kj = 0;
			this.Lj = var6;
			this.Mj = var7;
			this.Nj = var2;
			this.Oj = this.menuSize * 15 + 22;
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

			this.menuVisible = true;
			this.Kj = 1;
			this.Lj = var8;
			this.Mj = var9;
			this.Nj = var2;
			this.Oj = this.menuSize * 15 + 22;
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

			this.menuVisible = true;
			this.Kj = 2;
			this.Lj = var10;
			this.Mj = var11;
			this.Nj = var2;
			this.Oj = this.menuSize * 15 + 22;
		}
	}

	@ObfuscatedName("client.C(I)V")
	public final void C(int arg0) {
		if (arg0 != 30729) {
			this.Ve = this.randomIn.nextInt();
		}

		this.q(0);
		if (this.oe == 1) {
			this.Rb[this.ne / 100].b(this.me - 8 - 4, this.le - 8 - 4, -488);
		}

		if (this.oe == 2) {
			this.Rb[this.ne / 100 + 4].b(this.me - 8 - 4, this.le - 8 - 4, -488);
		}

		if (this.lj != -1) {
			this.a(this.Uc, this.lj, (byte) 5);
			this.a(0, 0, Component.types(this.lj), 0, 8);
		}

		if (this.fh != -1) {
			this.a(this.Uc, this.fh, (byte) 5);
			this.a(0, 0, Component.types(this.fh), 0, 8);
		}

		this.A(-7);
		if (!this.menuVisible) {
			this.w(-521);
			this.g((byte) -79);
		} else if (this.Kj == 0) {
			this.p(false);
		}

		if (this.inMultizone == 1) {
			this.Af.b(296, 472, -488);
		}

		if (pb) {
			short var2 = 507;
			byte var3 = 20;
			int var4 = 16776960;
			if (super.fps < 30 && lowMemory) {
				var4 = 16711680;
			}

			if (super.fps < 20 && !lowMemory) {
				var4 = 16711680;
			}

			this.fontPlain12.a(true, "Fps:" + super.fps, var4, var2, var3);
			int var13 = var3 + 15;
			Runtime var5 = Runtime.getRuntime();
			int var6 = (int) ((var5.totalMemory() - var5.freeMemory()) / 1024L);
			int var7 = 16776960;
			if (var6 > 33554432 && lowMemory) {
				int var8 = 16711680;
			}

			if (var6 > 67108864 && !lowMemory) {
				int var9 = 16711680;
			}

			this.fontPlain12.a(true, "Mem:" + var6 + "k", 16776960, var2, var13);
			var13 += 15;
		}

		if (this.systemUpdateTimer != 0) {
			int var10 = this.systemUpdateTimer / 50;
			int var11 = var10 / 60;
			int var12 = var10 % 60;
			if (var12 < 10) {
				this.fontPlain12.b(2245, 4, 16776960, 329, "System update in: " + var11 + ":0" + var12);
			} else {
				this.fontPlain12.b(2245, 4, 16776960, 329, "System update in: " + var11 + ":" + var12);
			}

			++Qb;
			if (Qb > 112) {
				Qb = 0;
				this.out.pIsaac(197);
				this.out.p4(0);
				return;
			}
		}

	}

	public final void run() {
		if (this.Uj) {
			this.c((byte) 4);
		} else {
			super.run();
		}
	}

	@ObfuscatedName("client.a(IIBI)I")
	public final int getHeightMapY(int sceneZ, int arg1, byte arg2, int level) {
		int tileX = arg1 >> 7;
		int tileZ = sceneZ >> 7;

		if (tileX < 0 || tileZ < 0 || tileX > 103 || tileZ > 103) {
			return 0;
		}

		int realLevel = level;
		if (level < 3 && (this.levelTileFlags[1][tileX][tileZ] & 2) == 2) {
			realLevel = level + 1;
		}

		int tileLocalX = arg1 & 0x7F;
		int tileLocalZ = sceneZ & 0x7F;
		int y00 = (128 - tileLocalX) * this.levelHeightmap[realLevel][tileX][tileZ] + this.levelHeightmap[realLevel][tileX + 1][tileZ] * tileLocalX >> 7;
		int y11 = (128 - tileLocalX) * this.levelHeightmap[realLevel][tileX][tileZ + 1] + this.levelHeightmap[realLevel][tileX + 1][tileZ + 1] * tileLocalX >> 7;
		return (128 - tileLocalZ) * y00 + tileLocalZ * y11 >> 7;
	}

	public final AppletContext getAppletContext() {
		return SignLink.mainapp != null ? SignLink.mainapp.getAppletContext() : super.getAppletContext();
	}

	@ObfuscatedName("client.D(I)V")
	public final void D(int arg0) {
		int var2 = 21 / arg0;
		if (this.hi != 0) {
			int var3 = 0;
			if (this.systemUpdateTimer != 0) {
				var3 = 1;
			}

			for (int var4 = 0; var4 < 100; ++var4) {
				if (this.messageText[var4] != null) {
					int var5 = this.messageType[var4];
					String var6 = this.messageSender[var4];
					boolean var7 = false;
					if (var6 != null && var6.startsWith("@cr1@")) {
						var6 = var6.substring(5);
						boolean var8 = true;
					}

					if (var6 != null && var6.startsWith("@cr2@")) {
						var6 = var6.substring(5);
						boolean var9 = true;
					}

					if ((var5 == 3 || var5 == 7) && (var5 == 7 || this.Ib == 0 || this.Ib == 1 && this.a((int) 13292, (String) var6))) {
						int var10 = 329 - var3 * 13;
						if (super.v > 4 && super.w - 4 > var10 - 10 && super.w - 4 <= var10 + 3) {
							int var11 = this.fontPlain12.a((byte) 35, "From:  " + var6 + this.messageText[var4]) + 25;
							if (var11 > 450) {
								var11 = 450;
							}

							if (super.v < var11 + 4) {
								if (this.staffModLevel >= 1) {
									this.menuOption[this.menuSize] = "Report abuse @whi@" + var6;
									this.menuAction[this.menuSize] = 2507;
									this.menuSize++;
								}

								this.menuOption[this.menuSize] = "Add ignore @whi@" + var6;
								this.menuAction[this.menuSize] = 2574;
								this.menuSize++;
								this.menuOption[this.menuSize] = "Add friend @whi@" + var6;
								this.menuAction[this.menuSize] = 2762;
								this.menuSize++;
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
			this.out.p1((int) 6);
		}

		Component var3 = Component.types(arg1);

		for (int var4 = 0; var4 < var3.children.length && var3.children[var4] != -1; ++var4) {
			Component var5 = Component.types(var3.children[var4]);
			if (var5.type == 1) {
				this.b((byte) 36, (int) var5.id);
			}

			var5.z = 0;
			var5.r = 0;
		}

	}

	@ObfuscatedName("client.d(III)V")
	public final void d(int arg0, int arg1, int arg2) {
		int var4 = 0;
		int var5 = 44 / arg0;

		for (int var6 = 0; var6 < 100; ++var6) {
			if (this.messageText[var6] != null) {
				int var7 = this.messageType[var6];
				int var8 = 70 - var4 * 14 + this.Y + 4;
				if (var8 < -20) {
					break;
				}

				String var9 = this.messageSender[var6];
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

				if ((var7 == 1 || var7 == 2) && (var7 == 1 || this.Xd == 0 || this.Xd == 1 && this.a((int) 13292, (String) var9))) {
					if (arg2 > var8 - 14 && arg2 <= var8 && !var9.equals(localPlayer.name)) {
						if (this.staffModLevel >= 1) {
							this.menuOption[this.menuSize] = "Report abuse @whi@" + var9;
							this.menuAction[this.menuSize] = 507;
							this.menuSize++;
						}

						this.menuOption[this.menuSize] = "Add ignore @whi@" + var9;
						this.menuAction[this.menuSize] = 574;
						this.menuSize++;
						this.menuOption[this.menuSize] = "Add friend @whi@" + var9;
						this.menuAction[this.menuSize] = 762;
						this.menuSize++;
					}

					++var4;
				}

				if ((var7 == 3 || var7 == 7) && this.hi == 0 && (var7 == 7 || this.Ib == 0 || this.Ib == 1 && this.a((int) 13292, (String) var9))) {
					if (arg2 > var8 - 14 && arg2 <= var8) {
						if (this.staffModLevel >= 1) {
							this.menuOption[this.menuSize] = "Report abuse @whi@" + var9;
							this.menuAction[this.menuSize] = 507;
							this.menuSize++;
						}

						this.menuOption[this.menuSize] = "Add ignore @whi@" + var9;
						this.menuAction[this.menuSize] = 574;
						this.menuSize++;
						this.menuOption[this.menuSize] = "Add friend @whi@" + var9;
						this.menuAction[this.menuSize] = 762;
						this.menuSize++;
					}

					++var4;
				}

				if (var7 == 4 && (this.li == 0 || this.li == 1 && this.a((int) 13292, (String) var9))) {
					if (arg2 > var8 - 14 && arg2 <= var8) {
						this.menuOption[this.menuSize] = "Accept trade @whi@" + var9;
						this.menuAction[this.menuSize] = 544;
						this.menuSize++;
					}

					++var4;
				}

				if ((var7 == 5 || var7 == 6) && this.hi == 0 && this.Ib < 2) {
					++var4;
				}

				if (var7 == 8 && (this.li == 0 || this.li == 1 && this.a((int) 13292, (String) var9))) {
					if (arg2 > var8 - 14 && arg2 <= var8) {
						this.menuOption[this.menuSize] = "Accept challenge @whi@" + var9;
						this.menuAction[this.menuSize] = 695;
						this.menuSize++;
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
			for (int var5 = var4; var5 < this.od; ++var5) {
				this.entityRemovalIds[this.entityRemovalCount++] = this.pd[var5];
			}
		}

		if (var4 > this.od) {
			SignLink.reporterror(this.username + " Too many players");
			throw new RuntimeException("eek");
		} else {
			this.od = 0;
			if (arg1 >= 0) {
				this.ptype = -1;
			}

			for (int var6 = 0; var6 < var4; ++var6) {
				int var7 = this.pd[var6];
				ClientPlayer var8 = this.players[var7];
				int var9 = arg2.gBit(1);
				if (var9 == 0) {
					this.pd[this.od++] = var7;
					var8.cycle = loopCycle;
				} else {
					int var10 = arg2.gBit(2);
					if (var10 == 0) {
						this.pd[this.od++] = var7;
						var8.cycle = loopCycle;
						this.entityUpdateIds[this.entityUpdateCount++] = var7;
					} else if (var10 == 1) {
						this.pd[this.od++] = var7;
						var8.cycle = loopCycle;
						int var11 = arg2.gBit(3);
						var8.step(false, var11);
						int var12 = arg2.gBit(1);
						if (var12 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = var7;
						}
					} else if (var10 == 2) {
						this.pd[this.od++] = var7;
						var8.cycle = loopCycle;
						int var13 = arg2.gBit(3);
						var8.step(true, var13);
						int var14 = arg2.gBit(3);
						var8.step(true, var14);
						int var15 = arg2.gBit(1);
						if (var15 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = var7;
						}
					} else if (var10 == 3) {
						this.entityRemovalIds[this.entityRemovalCount++] = var7;
					}
				}
			}

		}
	}

	@ObfuscatedName("client.g(II)V")
	public final void g(int arg0, int arg1) {
		int[] var3 = this.imageMinimap.pixels;
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			var3[var5] = 0;
		}

		for (int var6 = 1; var6 < 103; ++var6) {
			int var7 = (103 - var6) * 512 * 4 + 24628;

			for (int var8 = 1; var8 < 103; ++var8) {
				if ((this.levelTileFlags[arg0][var8][var6] & 24) == 0) {
					this.scene.a(var3, var7, 512, arg0, var8, var6);
				}

				if (arg0 < 3 && (this.levelTileFlags[arg0 + 1][var8][var6] & 8) != 0) {
					this.scene.a(var3, var7, 512, arg0 + 1, var8, var6);
				}

				var7 += 4;
			}
		}

		int var9 = (238 + (int) (Math.random() * 20.0D) - 10 << 16) + (238 + (int) (Math.random() * 20.0D) - 10 << 8) + (238 + (int) (Math.random() * 20.0D) - 10);
		if (arg1 != 0) {
			this.ptype = this.in.g1();
		}

		int var10 = 238 + (int) (Math.random() * 20.0D) - 10 << 16;
		this.imageMinimap.a(false);

		for (int var11 = 1; var11 < 103; ++var11) {
			for (int var12 = 1; var12 < 103; ++var12) {
				if ((this.levelTileFlags[arg0][var12][var11] & 24) == 0) {
					this.a(var11, arg0, var12, var10, 563, var9);
				}

				if (arg0 < 3 && (this.levelTileFlags[arg0 + 1][var12][var11] & 8) != 0) {
					this.a(var11, arg0 + 1, var12, var10, 563, var9);
				}
			}
		}

		if (this.Ug != null) {
			this.Ug.a(false);
			Pix3D.lineOffset = this.areaViewportOffset;
		}

		++wf;
		if (wf > 177) {
			wf = 0;
			this.out.pIsaac(173);
			this.out.p3(2657152);
		}

		this.qf = 0;

		for (int var13 = 0; var13 < 104; ++var13) {
			for (int var14 = 0; var14 < 104; ++var14) {
				int var15 = this.scene.d(this.currentLevel, var13, var14);
				if (var15 != 0) {
					int var16 = var15 >> 14 & 32767;
					int var17 = LocType.a(var16).W;
					if (var17 >= 0) {
						int var18 = var13;
						int var19 = var14;
						if (var17 != 22 && var17 != 29 && var17 != 34 && var17 != 36 && var17 != 46 && var17 != 47 && var17 != 48) {
							byte var20 = 104;
							byte var21 = 104;
							int[][] var22 = this.levelCollisionMap[this.currentLevel].j;

							for (int var23 = 0; var23 < 10; ++var23) {
								int var24 = (int) (Math.random() * 4.0D);
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

						this.kj[this.qf] = this.imageMapfunction[var17];
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
			return arg2 == null ? true : SignLink.wavesave(arg2, arg1);
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
			this.load();
		}

		if (this.cameraPitch < 310) {
			++vd;
			if (vd > 1457) {
				vd = 0;
				this.out.pIsaac(244);
				this.out.p1((int) 0);
				int var4 = this.out.pos;
				this.out.p1((int) 219);
				this.out.p2(37745);
				this.out.p1((int) 61);
				this.out.p2(43756);
				this.out.p2((int) (Math.random() * 65536.0D));
				this.out.p1((int) (Math.random() * 256.0D));
				this.out.p2(51171);
				if ((int) (Math.random() * 2.0D) == 0) {
					this.out.p2((int) 15808);
				}

				this.out.p1((int) 97);
				this.out.p1((int) (Math.random() * 256.0D));
				this.out.psize1((int) (this.out.pos - var4));
			}

			int var5 = this.cameraX >> 7;
			int var6 = this.cameraZ >> 7;
			int var7 = localPlayer.x >> 7;
			int var8 = localPlayer.z >> 7;
			if ((this.levelTileFlags[this.currentLevel][var5][var6] & 4) != 0) {
				var2 = this.currentLevel;
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

				while (var5 != var7) {
					if (var5 < var7) {
						++var5;
					} else if (var5 > var7) {
						--var5;
					}

					if ((this.levelTileFlags[this.currentLevel][var5][var6] & 4) != 0) {
						var2 = this.currentLevel;
					}

					var12 += var11;
					if (var12 >= 65536) {
						var12 -= 65536;
						if (var6 < var8) {
							++var6;
						} else if (var6 > var8) {
							--var6;
						}

						if ((this.levelTileFlags[this.currentLevel][var5][var6] & 4) != 0) {
							var2 = this.currentLevel;
						}
					}
				}
			} else {
				int var13 = var9 * 65536 / var10;
				int var14 = 32768;

				while (var6 != var8) {
					if (var6 < var8) {
						++var6;
					} else if (var6 > var8) {
						--var6;
					}

					if ((this.levelTileFlags[this.currentLevel][var5][var6] & 4) != 0) {
						var2 = this.currentLevel;
					}

					var14 += var13;
					if (var14 >= 65536) {
						var14 -= 65536;
						if (var5 < var7) {
							++var5;
						} else if (var5 > var7) {
							--var5;
						}

						if ((this.levelTileFlags[this.currentLevel][var5][var6] & 4) != 0) {
							var2 = this.currentLevel;
						}
					}
				}
			}
		}

		if ((this.levelTileFlags[this.currentLevel][localPlayer.x >> 7][localPlayer.z >> 7] & 4) != 0) {
			var2 = this.currentLevel;
		}

		return var2;
	}

	@ObfuscatedName("client.E(I)I")
	public final int E(int arg0) {
		int var2 = this.getHeightMapY(this.cameraZ, this.cameraX, (byte) 9, this.currentLevel);

		while (arg0 >= 0) {
			this.ptype = this.in.g1();
		}

		return var2 - this.cameraY < 800 && (this.levelTileFlags[this.currentLevel][this.cameraX >> 7][this.cameraZ >> 7] & 4) != 0 ? this.currentLevel : 3;
	}

	@ObfuscatedName("client.a(Ljava/lang/Runnable;I)V")
	public final void startThread(Runnable thread, int priority) {
		if (priority > 10) {
			priority = 10;
		}

		if (SignLink.mainapp != null) {
			SignLink.startthread(thread, priority);
		} else {
			super.startThread(thread, priority);
		}
	}

	@ObfuscatedName("client.b(IZ)V")
	public final void b(int arg0, boolean arg1) {
		if (localPlayer.x >> 7 == this.flagSceneTileX && localPlayer.z >> 7 == this.flagSceneTileZ) {
			this.flagSceneTileX = 0;
		}

		int var3 = this.od;
		if (arg1) {
			var3 = 1;
		}

		for (int var4 = 0; var4 < var3; ++var4) {
			ClientPlayer var5;
			int var6;
			if (arg1) {
				var5 = localPlayer;
				var6 = this.LOCAL_PLAYER_INDEX << 14;
			} else {
				var5 = this.players[this.pd[var4]];
				var6 = this.pd[var4] << 14;
			}

			if (var5 != null && var5.isVisible()) {
				var5.Kb = false;
				if ((lowMemory && this.od > 50 || this.od > 200) && !arg1 && var5.u == var5.readyanim) {
					var5.Kb = true;
				}

				int var7 = var5.x >> 7;
				int var8 = var5.z >> 7;
				if (var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
					if (var5.tb != null && loopCycle >= var5.Lb && loopCycle < var5.Mb) {
						var5.Kb = false;
						var5.xb = this.getHeightMapY(var5.z, var5.x, (byte) 9, this.currentLevel);
						this.scene.a(var5.xb, var5.Qb, 60, 7, var5, var5.Pb, var5.z, var5.Sb, var5.x, var5.S, var5.Rb, this.currentLevel, var6);
					} else {
						if ((var5.x & 127) == 64 && (var5.z & 127) == 64) {
							if (this.Hb[var7][var8] == this.Ag) {
								continue;
							}

							this.Hb[var7][var8] = this.Ag;
						}

						var5.xb = this.getHeightMapY(var5.z, var5.x, (byte) 9, this.currentLevel);
						this.scene.a(var6, var5, var5.x, var5.xb, var5.y, 0, this.currentLevel, 60, var5.z, var5.S);
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
			int var3 = this.menuParamB[arg0];
			int var4 = this.menuParamC[arg0];
			int action = this.menuAction[arg0];
			int var6 = this.menuParamA[arg0];
			if (arg1 < this.qc || arg1 > this.qc) {
				this.ptype = this.in.g1();
			}

			if (action >= 2000) {
				action -= 2000;
			}

			if (this.Ci != 0 && action != 1016) {
				this.Ci = 0;
				this.redrawChatback = true;
			}

			if (action == 200) {
				ClientPlayer var7 = this.players[var6];
				if (var7 != null) {
					this.a(false, false, var7.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var7.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(245);
					this.out.p2_alt3(var6);
				}
			}

			if (action == 227) {
				++bh;
				if (bh >= 62) {
					this.out.pIsaac(165);
					this.out.p1((int) 206);
					bh = 0;
				}

				this.out.pIsaac(228);
				this.out.p2_alt1(var3);
				this.out.p2_alt2(var6);
				this.out.p2(var4);
				this.jk = 0;
				this.kk = var4;
				this.lk = var3;
				this.mk = 2;
				if (Component.types(var4).layer == this.fh) {
					this.mk = 1;
				}

				if (Component.types(var4).layer == this.chatInterfaceId) {
					this.mk = 3;
				}
			}

			if (action == 876) {
				ClientPlayer var8 = this.players[var6];
				if (var8 != null) {
					this.a(false, false, var8.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var8.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(45);
					this.out.p2_alt2(var6);
				}
			}

			if (action == 921) {
				ClientNpc var9 = this.npcs[var6];
				if (var9 != null) {
					this.a(false, false, var9.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var9.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(67);
					this.out.p2_alt2(var6);
				}
			}

			if (action == 961) {
				Bg += var6;
				if (Bg >= 115) {
					this.out.pIsaac(126);
					this.out.p1((int) 125);
					Bg = 0;
				}

				this.out.pIsaac(203);
				this.out.p2_alt2(var4);
				this.out.p2_alt1(var3);
				this.out.p2_alt1(var6);
				this.jk = 0;
				this.kk = var4;
				this.lk = var3;
				this.mk = 2;
				if (Component.types(var4).layer == this.fh) {
					this.mk = 1;
				}

				if (Component.types(var4).layer == this.chatInterfaceId) {
					this.mk = 3;
				}
			}

			if (action == 467 && this.a(var4, 0, (int) var3, var6)) {
				this.out.pIsaac(152);
				this.out.p2_alt1(var6 >> 14 & 32767);
				this.out.p2_alt1(this.Kg);
				this.out.p2_alt1(this.Lg);
				this.out.p2_alt1(this.sceneBaseTileZ + var4);
				this.out.p2(this.Jg);
				this.out.p2_alt3(this.sceneBaseTileX + var3);
			}

			if (action == 9) {
				this.out.pIsaac(3);
				this.out.p2_alt2(var6);
				this.out.p2(var4);
				this.out.p2(var3);
				this.jk = 0;
				this.kk = var4;
				this.lk = var3;
				this.mk = 2;
				if (Component.types(var4).layer == this.fh) {
					this.mk = 1;
				}

				if (Component.types(var4).layer == this.chatInterfaceId) {
					this.mk = 3;
				}
			}

			if (action == 553) {
				ClientNpc var10 = this.npcs[var6];
				if (var10 != null) {
					this.a(false, false, var10.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var10.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(42);
					this.out.p2_alt1(var6);
				}
			}

			if (action == 677) {
				ClientPlayer var11 = this.players[var6];
				if (var11 != null) {
					this.a(false, false, var11.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var11.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(116);
					this.out.p2_alt1(var6);
				}
			}

			if (action == 762 || action == 574 || action == 775 || action == 859) {
				String var12 = this.menuOption[arg0];
				int var13 = var12.indexOf("@whi@");
				if (var13 != -1) {
					long var14 = JString.toBase37(var12.substring(var13 + 5).trim());
					if (action == 762) {
						this.addFriend(var14, -45229);
					}

					if (action == 574) {
						this.addIgnore(var14);
					}

					if (action == 775) {
						this.a(var14, 0);
					}

					if (action == 859) {
						this.removeIgnore(var14);
					}
				}
			}

			if (action == 930) {
				boolean var16 = this.a(false, false, var4, localPlayer.routeTileZ[0], 0, 0, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
				if (!var16) {
					this.a(false, false, var4, localPlayer.routeTileZ[0], 1, 1, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
				}

				this.le = super.C;
				this.me = super.D;
				this.oe = 2;
				this.ne = 0;
				this.out.pIsaac(54);
				this.out.p2_alt2(var6);
				this.out.p2_alt1(this.sceneBaseTileZ + var4);
				this.out.p2(this.sceneBaseTileX + var3);
			}

			if (action == 399) {
				this.out.pIsaac(24);
				this.out.p2_alt1(var4);
				this.out.p2_alt1(var6);
				this.out.p2_alt2(var3);
				this.jk = 0;
				this.kk = var4;
				this.lk = var3;
				this.mk = 2;
				if (Component.types(var4).layer == this.fh) {
					this.mk = 1;
				}

				if (Component.types(var4).layer == this.chatInterfaceId) {
					this.mk = 3;
				}
			}

			if (action == 347) {
				ClientNpc var18 = this.npcs[var6];
				if (var18 != null) {
					this.a(false, false, var18.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var18.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(57);
					this.out.p2(var6);
					this.out.p2_alt1(this.Lg);
					this.out.p2_alt3(this.Kg);
					this.out.p2(this.Jg);
				}
			}

			if (action == 890) {
				this.out.pIsaac(79);
				this.out.p2(var4);
				Component var19 = Component.types(var4);
				if (var19.scripts != null && var19.scripts[0][0] == 5) {
					int var20 = var19.scripts[0][1];
					this.varps[var20] = 1 - this.varps[var20];
					this.updateVarp(0, var20);
					this.redrawSidebar = true;
				}
			}

			if (action == 493) {
				ClientPlayer var21 = this.players[var6];
				if (var21 != null) {
					this.a(false, false, var21.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var21.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(233);
					this.out.p2_alt2(var6);
				}
			}

			if (action == 14) {
				if (!this.menuVisible) {
					this.scene.e(0, super.C - 4, super.D - 4);
				} else {
					this.scene.e(0, var3 - 4, var4 - 4);
				}
			}

			if (action == 903) {
				this.out.pIsaac(1);
				this.out.p2(var6);
				this.out.p2_alt1(this.Jg);
				this.out.p2_alt1(this.Lg);
				this.out.p2_alt3(this.Kg);
				this.out.p2_alt2(var3);
				this.out.p2_alt2(var4);
				this.jk = 0;
				this.kk = var4;
				this.lk = var3;
				this.mk = 2;
				if (Component.types(var4).layer == this.fh) {
					this.mk = 1;
				}

				if (Component.types(var4).layer == this.chatInterfaceId) {
					this.mk = 3;
				}
			}

			if (action == 361) {
				this.out.pIsaac(36);
				this.out.p2(this.ih);
				this.out.p2_alt2(var4);
				this.out.p2_alt2(var3);
				this.out.p2_alt2(var6);
				this.jk = 0;
				this.kk = var4;
				this.lk = var3;
				this.mk = 2;
				if (Component.types(var4).layer == this.fh) {
					this.mk = 1;
				}

				if (Component.types(var4).layer == this.chatInterfaceId) {
					this.mk = 3;
				}
			}

			if (action == 118) {
				ClientNpc var22 = this.npcs[var6];
				if (var22 != null) {
					this.a(false, false, var22.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var22.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					ti += var6;
					if (ti >= 143) {
						this.out.pIsaac(157);
						this.out.p4(0);
						ti = 0;
					}

					this.out.pIsaac(13);
					this.out.p2_alt3(var6);
				}
			}

			if (action == 376 && this.a(var4, 0, (int) var3, var6)) {
				this.out.pIsaac(210);
				this.out.p2(this.ih);
				this.out.p2_alt1(var6 >> 14 & 32767);
				this.out.p2_alt2(this.sceneBaseTileX + var3);
				this.out.p2_alt1(this.sceneBaseTileZ + var4);
			}

			if (action == 432) {
				ClientNpc var23 = this.npcs[var6];
				if (var23 != null) {
					this.a(false, false, var23.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var23.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(8);
					this.out.p2_alt1(var6);
				}
			}

			if (action == 639) {
				this.b(false);
			}

			if (action == 918) {
				ClientPlayer var24 = this.players[var6];
				if (var24 != null) {
					this.a(false, false, var24.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var24.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(31);
					this.out.p2(var6);
					this.out.p2_alt1(this.ih);
				}
			}

			if (action == 67) {
				ClientNpc var25 = this.npcs[var6];
				if (var25 != null) {
					this.a(false, false, var25.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var25.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(104);
					this.out.p2_alt2(this.ih);
					this.out.p2_alt1(var6);
				}
			}

			if (action == 68) {
				boolean var26 = this.a(false, false, var4, localPlayer.routeTileZ[0], 0, 0, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
				if (!var26) {
					this.a(false, false, var4, localPlayer.routeTileZ[0], 1, 1, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
				}

				this.le = super.C;
				this.me = super.D;
				this.oe = 2;
				this.ne = 0;
				this.out.pIsaac(77);
				this.out.p2_alt2(this.sceneBaseTileX + var3);
				this.out.p2(this.sceneBaseTileZ + var4);
				this.out.p2_alt3(var6);
			}

			if (action == 684) {
				boolean var28 = this.a(false, false, var4, localPlayer.routeTileZ[0], 0, 0, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
				if (!var28) {
					this.a(false, false, var4, localPlayer.routeTileZ[0], 1, 1, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
				}

				this.le = super.C;
				this.me = super.D;
				this.oe = 2;
				this.ne = 0;
				if ((var6 & 3) == 0) {
					++Re;
				}

				if (Re >= 84) {
					this.out.pIsaac(222);
					this.out.p3(11257922);
					Re = 0;
				}

				this.out.pIsaac(71);
				this.out.p2_alt3(var6);
				this.out.p2_alt3(this.sceneBaseTileX + var3);
				this.out.p2_alt2(this.sceneBaseTileZ + var4);
			}

			if (action == 544 || action == 695) {
				String var30 = this.menuOption[arg0];
				int var31 = var30.indexOf("@whi@");
				if (var31 != -1) {
					String var32 = var30.substring(var31 + 5).trim();
					String var33 = JString.formatDisplayName(JString.fromBase37(JString.toBase37(var32)));
					boolean var34 = false;

					for (int var35 = 0; var35 < this.od; ++var35) {
						ClientPlayer var36 = this.players[this.pd[var35]];
						if (var36 != null && var36.name != null && var36.name.equalsIgnoreCase(var33)) {
							this.a(false, false, var36.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var36.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
							if (action == 544) {
								this.out.pIsaac(116);
								this.out.p2_alt1(this.pd[var35]);
							}

							if (action == 695) {
								this.out.pIsaac(245);
								this.out.p2_alt3(this.pd[var35]);
							}

							var34 = true;
							break;
						}
					}

					if (!var34) {
						this.addMessage("Unable to find " + var33, "", 0);
					}
				}
			}

			if (action == 225) {
				this.out.pIsaac(177);
				this.out.p2_alt2(var3);
				this.out.p2_alt1(var6);
				this.out.p2_alt1(var4);
				this.jk = 0;
				this.kk = var4;
				this.lk = var3;
				this.mk = 2;
				if (Component.types(var4).layer == this.fh) {
					this.mk = 1;
				}

				if (Component.types(var4).layer == this.chatInterfaceId) {
					this.mk = 3;
				}
			}

			if (action == 70) {
				Component var37 = Component.types(var4);
				this.hh = 1;
				this.ih = var4;
				this.jh = var37.targetMask;
				this.objSelected = 0;
				this.redrawSidebar = true;
				String var38 = var37.targetVerb;
				if (var38.indexOf(" ") != -1) {
					var38 = var38.substring(0, var38.indexOf(" "));
				}

				String var39 = var37.targetVerb;
				if (var39.indexOf(" ") != -1) {
					var39 = var39.substring(var39.indexOf(" ") + 1);
				}

				this.kh = var38 + " " + var37.targetText + " " + var39;
				if (this.jh == 16) {
					this.redrawSidebar = true;
					this.selectedTab = 3;
					this.redrawSideicons = true;
				}

			} else {
				if (action == 891) {
					this.out.pIsaac(4);
					this.out.p2_alt1(var3);
					this.out.p2_alt3(var6);
					this.out.p2_alt3(var4);
					this.jk = 0;
					this.kk = var4;
					this.lk = var3;
					this.mk = 2;
					if (Component.types(var4).layer == this.fh) {
						this.mk = 1;
					}

					if (Component.types(var4).layer == this.chatInterfaceId) {
						this.mk = 3;
					}
				}

				if (action == 894) {
					this.out.pIsaac(158);
					this.out.p2_alt3(var3);
					this.out.p2_alt3(var6);
					this.out.p2_alt1(var4);
					this.jk = 0;
					this.kk = var4;
					this.lk = var3;
					this.mk = 2;
					if (Component.types(var4).layer == this.fh) {
						this.mk = 1;
					}

					if (Component.types(var4).layer == this.chatInterfaceId) {
						this.mk = 3;
					}
				}

				if (action == 1280) {
					this.a(var4, 0, (int) var3, var6);
					this.out.pIsaac(55);
					this.out.p2_alt1(var6 >> 14 & 32767);
					this.out.p2_alt1(this.sceneBaseTileZ + var4);
					this.out.p2(this.sceneBaseTileX + var3);
				}

				if (action == 35) {
					this.a(var4, 0, (int) var3, var6);
					this.out.pIsaac(181);
					this.out.p2_alt2(this.sceneBaseTileX + var3);
					this.out.p2_alt1(this.sceneBaseTileZ + var4);
					this.out.p2_alt1(var6 >> 14 & 32767);
				}

				if (action == 888) {
					this.a(var4, 0, (int) var3, var6);
					this.out.pIsaac(50);
					this.out.p2_alt2(this.sceneBaseTileZ + var4);
					this.out.p2_alt1(var6 >> 14 & 32767);
					this.out.p2_alt3(this.sceneBaseTileX + var3);
				}

				if (action == 324) {
					this.out.pIsaac(161);
					this.out.p2_alt3(var3);
					this.out.p2_alt3(var6);
					this.out.p2_alt1(var4);
					this.jk = 0;
					this.kk = var4;
					this.lk = var3;
					this.mk = 2;
					if (Component.types(var4).layer == this.fh) {
						this.mk = 1;
					}

					if (Component.types(var4).layer == this.chatInterfaceId) {
						this.mk = 3;
					}
				}

				if (action == 1094) {
					ObjType obj = ObjType.get(var6);
					Component var41 = Component.types(var4);
					String examine;
					if (var41 != null && var41.invSlotObjCount[var3] >= 100000) {
						examine = var41.invSlotObjCount[var3] + " x " + obj.name;
					} else if (obj.desc != null) {
						examine = new String(obj.desc);
					} else {
						examine = "It's a " + obj.name + ".";
					}

					this.addMessage(examine, "", 0);
				}

				if (action == 352) {
					Component var43 = Component.types(var4);
					boolean var44 = true;
					if (var43.clientCode > 0) {
						var44 = this.a((int) 631, (Component) var43);
					}

					if (var44) {
						this.out.pIsaac(79);
						this.out.p2(var4);
					}
				}

				if (action == 1412) {
					int var45 = var6 >> 14 & 32767;
					LocType var46 = LocType.a(var45);
					String var47;
					if (var46.z != null) {
						var47 = new String(var46.z);
					} else {
						var47 = "It's a " + var46.name + ".";
					}

					this.addMessage(var47, "", 0);
				}

				if (action == 575 && !this.xi) {
					this.out.pIsaac(226);
					this.out.p2(var4);
					this.xi = true;
				}

				if (action == 892) {
					this.a(var4, 0, (int) var3, var6);
					this.out.pIsaac(136);
					this.out.p2(this.sceneBaseTileX + var3);
					this.out.p2_alt1(this.sceneBaseTileZ + var4);
					this.out.p2(var6 >> 14 & 32767);
				}

				if (action == 270) {
					boolean var48 = this.a(false, false, var4, localPlayer.routeTileZ[0], 0, 0, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
					if (!var48) {
						this.a(false, false, var4, localPlayer.routeTileZ[0], 1, 1, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
					}

					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(230);
					this.out.p2_alt1(var6);
					this.out.p2_alt2(this.sceneBaseTileX + var3);
					this.out.p2(this.sceneBaseTileZ + var4);
				}

				if (action == 596) {
					ClientPlayer var50 = this.players[var6];
					if (var50 != null) {
						this.a(false, false, var50.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var50.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
						this.le = super.C;
						this.me = super.D;
						this.oe = 2;
						this.ne = 0;
						this.out.pIsaac(143);
						this.out.p2_alt1(this.Lg);
						this.out.p2_alt3(this.Jg);
						this.out.p2(this.Kg);
						this.out.p2_alt2(var6);
					}
				}

				if (action == 100) {
					boolean var51 = this.a(false, false, var4, localPlayer.routeTileZ[0], 0, 0, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
					if (!var51) {
						this.a(false, false, var4, localPlayer.routeTileZ[0], 1, 1, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
					}

					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(211);
					this.out.p2_alt3(this.Jg);
					this.out.p2_alt2(this.Lg);
					this.out.p2_alt3(this.sceneBaseTileZ + var4);
					this.out.p2_alt3(this.sceneBaseTileX + var3);
					this.out.p2_alt1(this.Kg);
					this.out.p2_alt1(var6);
				}

				if (action == 1668) {
					ClientNpc var53 = this.npcs[var6];
					if (var53 != null) {
						NpcType var54 = var53.type;
						if (var54.multinpc != null) {
							var54 = var54.getMultiNpc();
						}

						if (var54 != null) {
							String var55;
							if (var54.desc != null) {
								var55 = new String(var54.desc);
							} else {
								var55 = "It's a " + var54.name + ".";
							}

							this.addMessage(var55, "", 0);
						}
					}
				}

				if (action == 26) {
					boolean var56 = this.a(false, false, var4, localPlayer.routeTileZ[0], 0, 0, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
					if (!var56) {
						this.a(false, false, var4, localPlayer.routeTileZ[0], 1, 1, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
					}

					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					++Of;
					if (Of >= 120) {
						this.out.pIsaac(95);
						this.out.p4(0);
						Of = 0;
					}

					this.out.pIsaac(100);
					this.out.p2(this.sceneBaseTileX + var3);
					this.out.p2_alt2(this.sceneBaseTileZ + var4);
					this.out.p2_alt3(var6);
				}

				if (action == 444) {
					this.out.pIsaac(91);
					this.out.p2_alt1(var6);
					this.out.p2_alt3(var3);
					this.out.p2(var4);
					this.jk = 0;
					this.kk = var4;
					this.lk = var3;
					this.mk = 2;
					if (Component.types(var4).layer == this.fh) {
						this.mk = 1;
					}

					if (Component.types(var4).layer == this.chatInterfaceId) {
						this.mk = 3;
					}
				}

				if (action == 507) {
					String var58 = this.menuOption[arg0];
					int var59 = var58.indexOf("@whi@");
					if (var59 != -1) {
						if (this.fh == -1) {
							this.b(false);
							this.reportAbuseInput = var58.substring(var59 + 5).trim();
							this.reportAbuseMuteOption = false;
							this.pi = this.fh = Component.K;
						} else {
							this.addMessage("Please close the interface you have open before using 'report abuse'", "", 0);
						}
					}
				}

				if (action == 389) {
					this.a(var4, 0, (int) var3, var6);
					this.out.pIsaac(241);
					this.out.p2(var6 >> 14 & 32767);
					this.out.p2(this.sceneBaseTileX + var3);
					this.out.p2_alt2(this.sceneBaseTileZ + var4);
				}

				if (action == 564) {
					this.out.pIsaac(231);
					this.out.p2_alt3(var4);
					this.out.p2_alt1(var3);
					this.out.p2(var6);
					this.jk = 0;
					this.kk = var4;
					this.lk = var3;
					this.mk = 2;
					if (Component.types(var4).layer == this.fh) {
						this.mk = 1;
					}

					if (Component.types(var4).layer == this.chatInterfaceId) {
						this.mk = 3;
					}
				}

				if (action == 984) {
					String var60 = this.menuOption[arg0];
					int var61 = var60.indexOf("@whi@");
					if (var61 != -1) {
						long var62 = JString.toBase37(var60.substring(var61 + 5).trim());
						int var64 = -1;

						for (int var65 = 0; var65 < this.friendCount; ++var65) {
							if (this.friendName37[var65] == var62) {
								var64 = var65;
								break;
							}
						}

						if (var64 != -1 && this.friendWorld[var64] > 0) {
							this.redrawChatback = true;
							this.Ci = 0;
							this.showSocialInput = true;
							this.socialInput = "";
							this.socialInputType = 3;
							this.Dg = this.friendName37[var64];
							this.socialMessage = "Enter message to send to " + this.friendName[var64];
						}
					}
				}

				if (action == 518) {
					this.out.pIsaac(79);
					this.out.p2(var4);
					Component var66 = Component.types(var4);
					if (var66.scripts != null && var66.scripts[0][0] == 5) {
						int var67 = var66.scripts[0][1];
						if (this.varps[var67] != var66.scriptOperand[0]) {
							this.varps[var67] = var66.scriptOperand[0];
							this.updateVarp(0, var67);
							this.redrawSidebar = true;
						}
					}
				}

				if (action == 318) {
					ClientNpc var68 = this.npcs[var6];
					if (var68 != null) {
						this.a(false, false, var68.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var68.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
						this.le = super.C;
						this.me = super.D;
						this.oe = 2;
						this.ne = 0;
						this.out.pIsaac(112);
						this.out.p2_alt1(var6);
					}
				}

				if (action == 199) {
					boolean var69 = this.a(false, false, var4, localPlayer.routeTileZ[0], 0, 0, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
					if (!var69) {
						this.a(false, false, var4, localPlayer.routeTileZ[0], 1, 1, 2, 0, var3, 0, 0, localPlayer.routeTileX[0]);
					}

					this.le = super.C;
					this.me = super.D;
					this.oe = 2;
					this.ne = 0;
					this.out.pIsaac(83);
					this.out.p2_alt1(var6);
					this.out.p2(this.sceneBaseTileZ + var4);
					this.out.p2_alt1(this.ih);
					this.out.p2_alt3(this.sceneBaseTileX + var3);
				}

				if (action == 55) {
					this.a(Ah, this.stickyChatInterfaceId);
					this.stickyChatInterfaceId = -1;
					this.redrawChatback = true;
				}

				if (action == 52) {
					this.objSelected = 1;
					this.Jg = var3;
					this.Kg = var4;
					this.Lg = var6;
					this.objSelectedName = String.valueOf(ObjType.get(var6).name);
					this.hh = 0;
					this.redrawSidebar = true;
				} else {
					if (action == 1564) {
						ObjType var71 = ObjType.get(var6);
						String var72;
						if (var71.desc != null) {
							var72 = new String(var71.desc);
						} else {
							var72 = "It's a " + var71.name + ".";
						}

						this.addMessage(var72, "", 0);
					}

					if (action == 408) {
						ClientPlayer var73 = this.players[var6];
						if (var73 != null) {
							this.a(false, false, var73.routeTileZ[0], localPlayer.routeTileZ[0], 1, 1, 2, 0, var73.routeTileX[0], 0, 0, localPlayer.routeTileX[0]);
							this.le = super.C;
							this.me = super.D;
							this.oe = 2;
							this.ne = 0;
							this.out.pIsaac(194);
							this.out.p2_alt1(var6);
						}
					}

					this.objSelected = 0;
					this.hh = 0;
					this.redrawSidebar = true;
				}
			}
		}
	}

	@ObfuscatedName("client.m(Z)V")
	public final void m(boolean arg0) {
		this.Ic = 0;

		for (int var2 = -1; var2 < this.npcCount + this.od; ++var2) {
			ClientEntity var3;
			if (var2 == -1) {
				var3 = localPlayer;
			} else if (var2 < this.od) {
				var3 = this.players[this.pd[var2]];
			} else {
				var3 = this.npcs[this.npcIds[var2 - this.od]];
			}

			if (var3 != null && var3.isVisible()) {
				if (var3 instanceof ClientNpc) {
					NpcType var4 = ((ClientNpc) var3).type;
					if (var4.multinpc != null) {
						var4 = var4.getMultiNpc();
					}

					if (var4 == null) {
						continue;
					}
				}

				if (var2 >= this.od) {
					NpcType var7 = ((ClientNpc) var3).type;
					if (var7.headicon >= 0 && var7.headicon < this.tf.length) {
						this.a(var3, false, var3.A + 15);
						if (this.Bc > -1) {
							this.tf[var7.headicon].b(this.Cc - 30, this.Bc - 12, -488);
						}
					}

					if (this.hintType == 1 && this.npcIds[var2 - this.od] == this.hintNpc && loopCycle % 20 < 10) {
						this.a(var3, false, var3.A + 15);
						if (this.Bc > -1) {
							this.Xc[0].b(this.Cc - 28, this.Bc - 12, -488);
						}
					}
				} else {
					int var5 = 30;
					ClientPlayer var6 = (ClientPlayer) var3;
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

					if (var2 >= 0 && this.hintType == 10 && this.pd[var2] == this.hintPlayer) {
						this.a(var3, false, var3.A + 15);
						if (this.Bc > -1) {
							this.Xc[1].b(this.Cc - var5, this.Bc - 12, -488);
						}
					}
				}

				if (var3.chatMessage != null && (var2 >= this.od || this.Xd == 0 || this.Xd == 3 || this.Xd == 1 && this.a((int) 13292, (String) ((ClientPlayer) var3).name))) {
					this.a(var3, false, var3.A);
					if (this.Bc > -1 && this.Ic < this.Jc) {
						this.Nc[this.Ic] = this.fontBold12.a(var3.chatMessage, (byte) -53) / 2;
						this.Mc[this.Ic] = this.fontBold12.G;
						this.Kc[this.Ic] = this.Bc;
						this.Lc[this.Ic] = this.Cc;
						this.Oc[this.Ic] = var3.chatColour;
						this.Pc[this.Ic] = var3.chatEffect;
						this.Qc[this.Ic] = var3.chatTimer;
						this.Rc[this.Ic++] = var3.chatMessage;
						if (this.Pd == 0 && var3.chatEffect >= 1 && var3.chatEffect <= 3) {
							this.Mc[this.Ic] += 10;
							this.Lc[this.Ic] += 5;
						}

						if (this.Pd == 0 && var3.chatEffect == 4) {
							this.Nc[this.Ic] = 60;
						}

						if (this.Pd == 0 && var3.chatEffect == 5) {
							this.Mc[this.Ic] += 5;
						}
					}
				}

				if (var3.combatCycle > loopCycle) {
					this.a(var3, false, var3.A + 15);
					if (this.Bc > -1) {
						int var8 = var3.C * 30 / var3.D;
						if (var8 > 30) {
							var8 = 30;
						}

						Pix2D.fillRect(65280, var8, 5, this.Bc - 15, this.Cc - 3);
						Pix2D.fillRect(16711680, 30 - var8, 5, this.Bc - 15 + var8, this.Cc - 3);
					}
				}

				for (int var9 = 0; var9 < 4; ++var9) {
					if (var3.damageCycles[var9] > loopCycle) {
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

							this.sh[var3.damageTypes[var9]].b(this.Cc - 12, this.Bc - 12, -488);
							this.fontPlain11.drawStringCenter(this.Bc, this.Cc + 4, String.valueOf(var3.damageValues[var9]), 0);
							this.fontPlain11.drawStringCenter(this.Bc - 1, this.Cc + 3, String.valueOf(var3.damageValues[var9]), 16777215);
						}
					}
				}
			}
		}

		for (int var10 = 0; var10 < this.Ic; ++var10) {
			int var11 = this.Kc[var10];
			int var12 = this.Lc[var10];
			int var13 = this.Nc[var10];
			int var14 = this.Mc[var10];
			boolean var15 = true;

			while (var15) {
				var15 = false;

				for (int var16 = 0; var16 < var10; ++var16) {
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
					var18 = this.CHAT_COLOURS[this.Oc[var10]];
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
					this.fontBold12.drawStringCenter(this.Bc, this.Cc + 1, var17, 0);
					this.fontBold12.drawStringCenter(this.Bc, this.Cc, var17, var18);
				}

				if (this.Pc[var10] == 1) {
					this.fontBold12.a(this.Cc + 1, (byte) 4, (int) this.Ag, var17, this.Bc, 0);
					this.fontBold12.a(this.Cc, (byte) 4, (int) this.Ag, var17, this.Bc, var18);
				}

				if (this.Pc[var10] == 2) {
					this.fontBold12.a(this.Cc + 1, (int) 0, (byte) 1, var17, this.Bc, this.Ag);
					this.fontBold12.a(this.Cc, (int) var18, (byte) 1, var17, this.Bc, this.Ag);
				}

				if (this.Pc[var10] == 3) {
					this.fontBold12.a(-601, var17, 0, this.Bc, this.Cc + 1, 150 - this.Qc[var10], this.Ag);
					this.fontBold12.a(-601, var17, var18, this.Bc, this.Cc, 150 - this.Qc[var10], this.Ag);
				}

				if (this.Pc[var10] == 4) {
					int var22 = this.fontBold12.a(var17, (byte) -53);
					int var23 = (150 - this.Qc[var10]) * (var22 + 100) / 150;
					Pix2D.setBounds(this.Bc + 50, 334, 0, this.Bc - 50);
					this.fontBold12.b(2245, this.Bc + 50 - var23, 0, this.Cc + 1, var17);
					this.fontBold12.b(2245, this.Bc + 50 - var23, var18, this.Cc, var17);
					Pix2D.resetBounds();
				}

				if (this.Pc[var10] == 5) {
					int var24 = 150 - this.Qc[var10];
					int var25 = 0;
					if (var24 < 25) {
						var25 = var24 - 25;
					} else if (var24 > 125) {
						var25 = var24 - 125;
					}

					Pix2D.setBounds(512, this.Cc + 5, this.Cc - this.fontBold12.G - 1, 0);
					this.fontBold12.drawStringCenter(this.Bc, this.Cc + 1 + var25, var17, 0);
					this.fontBold12.drawStringCenter(this.Bc, this.Cc + var25, var17, var18);
					Pix2D.resetBounds();
				}
			} else {
				this.fontBold12.drawStringCenter(this.Bc, this.Cc + 1, var17, 0);
				this.fontBold12.drawStringCenter(this.Bc, this.Cc, var17, 16776960);
			}
		}

		if (arg0) {
			this.ptype = -1;
		}
	}

	@ObfuscatedName("client.F(I)V")
	public final void prepareGame() {
		if (this.Vg == null) {
			this.H(28614);
			super.drawArea = null;
			this.Ih = null;
			this.Jh = null;
			this.Kh = null;
			this.Lh = null;
			this.Mh = null;
			this.Nh = null;
			this.Oh = null;
			this.Ph = null;
			this.Qh = null;
			this.Vg = new PixMap(479, 96, this.getBaseComponent(), (byte) -12);
			this.Tg = new PixMap(172, 156, this.getBaseComponent(), (byte) -12);
			Pix2D.clear();
			this.imageMapback.a(0, 0, -488);
			this.Sg = new PixMap(190, 261, this.getBaseComponent(), (byte) -12);
			this.Ug = new PixMap(512, 334, this.getBaseComponent(), (byte) -12);
			Pix2D.clear();
			this.Wf = new PixMap(496, 50, this.getBaseComponent(), (byte) -12);
			this.Xf = new PixMap(269, 37, this.getBaseComponent(), (byte) -12);
			this.Yf = new PixMap(249, 45, this.getBaseComponent(), (byte) -12);
			this.Le = true;
			this.Ug.a(false);
			Pix3D.lineOffset = this.areaViewportOffset;
		}
	}

	@ObfuscatedName("client.G(I)V")
	public final void drawError() {
		Graphics g = this.getBaseComponent().getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 765, 503);

		this.setFramerate((byte) 103, 1);

		if (this.errorLoading) {
			this.flameActive = false;

			g.setFont(new Font("Helvetica", 1, 16));
			g.setColor(Color.yellow);
			byte var4 = 35;
			g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, var4);

			int var6 = var4 + 50;
			g.setColor(Color.white);
			g.drawString("To fix this try the following (in order):", 30, var6);

			int var7 = var6 + 50;
			g.setColor(Color.white);
			g.setFont(new Font("Helvetica", 1, 12));
			g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, var7);

			int var8 = var7 + 30;
			g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, var8);

			int var9 = var8 + 30;
			g.drawString("3: Try using a different game-world", 30, var9);

			int var11 = var9 + 30;
			g.drawString("4: Try rebooting your computer", 30, var11);

			int var13 = var11 + 30;
			g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, var13);
		}

		if (this.errorHost) {
			this.flameActive = false;

			g.setFont(new Font("Helvetica", 1, 20));
			g.setColor(Color.white);

			g.drawString("Error - unable to load game!", 50, 50);
			g.drawString("To play RuneScape make sure you play from", 50, 100);
			g.drawString("http://www.runescape.com", 50, 150);
		}

		if (this.errorStarted) {
			this.flameActive = false;

			g.setColor(Color.yellow);
			byte var5 = 35;

			g.drawString("Error a copy of RuneScape already appears to be loaded", 30, var5);
			int var10 = var5 + 50;

			g.setColor(Color.white);
			g.drawString("To fix this try the following (in order):", 30, var10);
			int var12 = var10 + 50;

			g.setColor(Color.white);
			g.setFont(new Font("Helvetica", 1, 12));
			g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, var12);
			int var14 = var12 + 30;

			g.drawString("2: Try rebooting your computer, and reloading", 30, var14);
			int var15 = var14 + 30;
		}
	}

	@ObfuscatedName("client.n(Z)V")
	public final void logout(boolean arg0) {
		try {
			if (this.stream != null) {
				this.stream.close();
			}
		} catch (Exception ignore) {
		}

		this.stream = null;
		this.ingame = false;
		this.titleScreenState = 0;
		this.username = "";
		this.pasword = "";

		this.k((int) 383);
		this.ingame &= arg0;
		this.scene.reset((byte) 7);

		for (int level = 0; level < 4; ++level) {
			this.levelCollisionMap[level].reset();
		}

		System.gc();

		this.g(false);
		this.nextMidiSong = -1;
		this.midiSong = -1;
		this.nextMusicDelay = 0;
	}

	@ObfuscatedName("client.a(ILjava/lang/String;Ljava/lang/String;)V")
	public final void a(int arg0, String arg1, String arg2) {
		if (arg0 < 0) {
			if (this.Ug != null) {
				this.Ug.a(false);
				Pix3D.lineOffset = this.areaViewportOffset;
				int var4 = 151;
				if (arg1 != null) {
					var4 -= 7;
				}

				this.fontPlain12.drawStringCenter(257, var4, arg2, 0);
				this.fontPlain12.drawStringCenter(256, var4 - 1, arg2, 16777215);
				var4 += 15;
				if (arg1 != null) {
					this.fontPlain12.drawStringCenter(257, var4, arg1, 0);
					this.fontPlain12.drawStringCenter(256, var4 - 1, arg1, 16777215);
				}

				this.Ug.a(4, 4, super.graphics, this.of);
			} else if (super.drawArea != null) {
				super.drawArea.a(false);
				Pix3D.lineOffset = this.Ud;
				int var5 = 251;
				short var6 = 300;
				byte var7 = 50;
				Pix2D.fillRect(0, var6, var7, 383 - var6 / 2, var5 - 5 - var7 / 2);
				Pix2D.drawRect(383 - var6 / 2, var5 - 5 - var7 / 2, var6, var7, (int) 16777215);
				if (arg1 != null) {
					var5 -= 7;
				}

				this.fontPlain12.drawStringCenter(383, var5, arg2, 0);
				this.fontPlain12.drawStringCenter(382, var5 - 1, arg2, 16777215);
				var5 += 15;
				if (arg1 != null) {
					this.fontPlain12.drawStringCenter(383, var5, arg1, 0);
					this.fontPlain12.drawStringCenter(382, var5 - 1, arg1, 16777215);
				}

				super.drawArea.a(0, 0, super.graphics, this.of);
			}
		}
	}

	@ObfuscatedName("client.b(IB)Z")
	public final boolean b(int arg0, byte arg1) {
		if (arg0 < 0) {
			return false;
		} else {
			int var3 = this.menuAction[arg0];
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
			this.Ve = this.randomIn.nextInt();
		}

		if (this.hintType == 2) {
			this.c((this.R - this.sceneBaseTileX << 7) + this.hintOffsetX, this.hintHeight * 2, (this.S - this.sceneBaseTileZ << 7) + this.hintOffsetZ, -214);
			if (this.Bc > -1 && loopCycle % 20 < 10) {
				this.Xc[0].b(this.Cc - 28, this.Bc - 12, -488);
			}
		}
	}

	@ObfuscatedName("client.c(I)V")
	public final void c(int arg0) {
		if (!this.errorStarted && !this.errorLoading && !this.errorHost) {
			++Pj;
			if (arg0 <= 0) {
				this.Vd = -382;
			}

			if (!this.ingame) {
				this.drawTitle((byte) -50, false);
			} else {
				this.p(7);
			}

			this.dragCycles = 0;
		} else {
			this.drawError();
		}
	}

	@ObfuscatedName("client.p(Z)V")
	public final void p(boolean arg0) {
		if (arg0) {
			this.out.p1((int) 23);
		}

		int var2 = this.Lj;
		int var3 = this.Mj;
		int var4 = this.Nj;
		int var5 = this.Oj;
		int var6 = 6116423;
		Pix2D.fillRect(var6, var4, var5, var2, var3);
		Pix2D.fillRect(0, var4 - 2, 16, var2 + 1, var3 + 1);
		Pix2D.drawRect(var2 + 1, var3 + 18, var4 - 2, var5 - 19, (int) 0);
		this.fontBold12.b(2245, var2 + 3, var6, var3 + 14, "Choose Option");
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

		for (int var9 = 0; var9 < this.menuSize; ++var9) {
			int var10 = (this.menuSize - 1 - var9) * 15 + var3 + 31;
			int var11 = 16777215;
			if (var7 > var2 && var7 < var2 + var4 && var8 > var10 - 13 && var8 < var10 + 3) {
				var11 = 16776960;
			}

			this.fontBold12.a(var11, var2 + 3, var10, true, this.menuOption[var9], -39629);
		}

	}

	@ObfuscatedName("client.a(IILEWIXBTLV;)I")
	public final int executeClientScript(Component com, int scriptId) {
		if (com.scripts == null || scriptId >= com.scripts.length) {
			return -2;
		}

		try {
			int[] script = com.scripts[scriptId];
			int register = 0;
			int pc = 0;
			byte operator = 0;

			while (true) {
				int opcode = script[pc++];
				int value = 0;
				byte nextAccumulatorMode = 0;

				if (opcode == 0) {
					return register;
				} else if (opcode == 1) {
					value = this.skillLevel[script[pc++]];
				} else if (opcode == 2) {
					value = this.skillbaseLevel[script[pc++]];
				} else if (opcode == 3) {
					value = this.skillExperience[script[pc++]];
				} else if (opcode == 4) {
					Component inv = Component.types(script[pc++]);
					int obj = script[pc++];
					if (obj >= 0 && obj < ObjType.count && (!ObjType.get(obj).members || membersWorld)) {
						for (int i = 0; i < inv.invSlotObjId.length; ++i) {
							if (obj + 1 == inv.invSlotObjId[i]) {
								register += inv.invSlotObjCount[i];
							}
						}
					}
				} else if (opcode == 5) {
					value = this.varps[script[pc++]];
				} else if (opcode == 6) {
					value = levelExperience[this.skillbaseLevel[script[pc++]] - 1];
				} else if (opcode == 7) {
					value = this.varps[script[pc++]] * 100 / 46875;
				} else if (opcode == 8) {
					value = localPlayer.vislevel;
				} else if (opcode == 9) {
					for (int i = 0; i < Stats.SKILL_COUNT; i++) {
						if (Stats.SKILL_ENABLED[i]) {
							value += this.skillbaseLevel[i];
						}
					}
				} else if (opcode == 10) {
					Component var15 = Component.types(script[pc++]);
					int var16 = script[pc++] + 1;
					if (var16 >= 0 && var16 < ObjType.count && (!ObjType.get(var16).members || membersWorld)) {
						for (int var17 = 0; var17 < var15.invSlotObjId.length; ++var17) {
							if (var15.invSlotObjId[var17] == var16) {
								value = 999999999;
								break;
							}
						}
					}
				} else if (opcode == 11) {
					value = this.runenergy;
				} else if (opcode == 12) {
					value = this.runweight;
				} else if (opcode == 13) {
					int varp = this.varps[script[pc++]];
					int lsb = script[pc++];
					value = (varp & 1 << lsb) != 0 ? 1 : 0;
				} else if (opcode == 14) {
					int varb = script[pc++];
					VarbitType var21 = VarbitType.c[varb];
					int var22 = var21.e;
					int var23 = var21.f;
					int var24 = var21.g;
					int var25 = Yh[var24 - var23];
					value = this.varps[var22] >> var23 & var25;
				} else if (opcode == 15) {
					nextAccumulatorMode = 1;
				} else if (opcode == 16) {
					nextAccumulatorMode = 2;
				} else if (opcode == 17) {
					nextAccumulatorMode = 3;
				} else if (opcode == 18) {
					value = (localPlayer.x >> 7) + this.sceneBaseTileX;
				} else if (opcode == 19) {
					value = (localPlayer.z >> 7) + this.sceneBaseTileZ;
				} else if (opcode == 20) {
					value = script[pc++];
				}

				if (nextAccumulatorMode == 0) {
					if (operator == 0) {
						register += value;
					}

					if (operator == 1) {
						register -= value;
					}

					if (operator == 2 && value != 0) {
						register /= value;
					}

					if (operator == 3) {
						register *= value;
					}

					operator = 0;
				} else {
					operator = nextAccumulatorMode;
				}
			}
		} catch (Exception exception) {
			return -1;
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
					this.ptype = this.in.g1();
				}

				int var11 = arg0 * var9 + arg3 * var10 >> 16;
				int var12 = arg0 * var10 - arg3 * var9 >> 16;
				if (var6 > 2500) {
					arg2.a(this.imageMapback, 83 - var12 - arg2.height / 2 - 4, -49993, var11 + 94 - arg2.width / 2 + 4);
				} else {
					arg2.b(83 - var12 - arg2.height / 2 - 4, var11 + 94 - arg2.width / 2 + 4, -488);
				}
			}
		}
	}

	@ObfuscatedName("client.a(BZ)V")
	public final void drawTitle(byte arg0, boolean arg1) {
		this.n(-188);
		this.Kh.a(false);
		this.yj.a(0, 0, -488);
		short var3 = 360;
		short var4 = 200;
		if (arg0 != -50) {
			for (int var5 = 1; var5 > 0; ++var5) {
			}
		}

		if (this.titleScreenState == 0) {
			int var6 = var4 / 2 + 80;
			this.fontPlain11.a(true, this.Ve, 7711145, var6, var3 / 2, this.onDemand.message);
			int var7 = var4 / 2 - 20;
			this.fontBold12.a(true, this.Ve, 16776960, var7, var3 / 2, "Welcome to RuneScape");
			int var18 = var7 + 30;
			int var8 = var3 / 2 - 80;
			int var9 = var4 / 2 + 20;
			this.zj.a(var9 - 20, var8 - 73, -488);
			this.fontBold12.a(true, this.Ve, 16777215, var9 + 5, var8, "New User");
			int var10 = var3 / 2 + 80;
			this.zj.a(var9 - 20, var10 - 73, -488);
			this.fontBold12.a(true, this.Ve, 16777215, var9 + 5, var10, "Existing User");
		}

		if (this.titleScreenState == 2) {
			int var11 = var4 / 2 - 40;
			if (this.loginMessage0.length() > 0) {
				this.fontBold12.a(true, this.Ve, 16776960, var11 - 15, var3 / 2, this.loginMessage0);
				this.fontBold12.a(true, this.Ve, 16776960, var11, var3 / 2, this.loginMessage1);
				var11 += 30;
			} else {
				this.fontBold12.a(true, this.Ve, 16776960, var11 - 7, var3 / 2, this.loginMessage1);
				var11 += 30;
			}

			this.fontBold12.a(16777215, var3 / 2 - 90, var11, true, "Username: " + this.username + (this.ud == 0 & loopCycle % 40 < 20 ? "@yel@|" : ""), -39629);
			var11 += 15;
			this.fontBold12.a(16777215, var3 / 2 - 88, var11, true, "Password: " + JString.censor(this.pasword) + (this.ud == 1 & loopCycle % 40 < 20 ? "@yel@|" : ""), -39629);
			var11 += 15;
			if (!arg1) {
				int var12 = var3 / 2 - 80;
				int var13 = var4 / 2 + 50;
				this.zj.a(var13 - 20, var12 - 73, -488);
				this.fontBold12.a(true, this.Ve, 16777215, var13 + 5, var12, "Login");
				int var14 = var3 / 2 + 80;
				this.zj.a(var13 - 20, var14 - 73, -488);
				this.fontBold12.a(true, this.Ve, 16777215, var13 + 5, var14, "Cancel");
			}
		}

		if (this.titleScreenState == 3) {
			this.fontBold12.a(true, this.Ve, 16776960, var4 / 2 - 60, var3 / 2, "Create a free account");
			int var15 = var4 / 2 - 35;
			this.fontBold12.a(true, this.Ve, 16777215, var15, var3 / 2, "To create a new account you need to");
			int var19 = var15 + 15;
			this.fontBold12.a(true, this.Ve, 16777215, var19, var3 / 2, "go back to the main RuneScape webpage");
			int var20 = var19 + 15;
			this.fontBold12.a(true, this.Ve, 16777215, var20, var3 / 2, "and choose the 'create account'");
			int var21 = var20 + 15;
			this.fontBold12.a(true, this.Ve, 16777215, var21, var3 / 2, "button near the top of that page.");
			int var22 = var21 + 15;
			int var16 = var3 / 2;
			int var17 = var4 / 2 + 50;
			this.zj.a(var17 - 20, var16 - 73, -488);
			this.fontBold12.a(true, this.Ve, 16777215, var17 + 5, var16, "Cancel");
		}

		this.Kh.a(171, 202, super.graphics, this.of);
		if (this.Le) {
			this.Le = false;
			this.Ih.a(0, 128, super.graphics, this.of);
			this.Jh.a(371, 202, super.graphics, this.of);
			this.Nh.a(265, 0, super.graphics, this.of);
			this.Oh.a(265, 562, super.graphics, this.of);
			this.Ph.a(171, 128, super.graphics, this.of);
			this.Qh.a(171, 562, super.graphics, this.of);
		}
	}

	@ObfuscatedName("client.a(LMFMVIYHT;IZ)V")
	public final void a(Packet arg0, int arg1, boolean arg2) {
		if (arg2) {
			this.Cg = 287;
		}

		while (arg0.bitPos + 21 < arg1 * 8) {
			int var4 = arg0.gBit(14);
			if (var4 == 16383) {
				break;
			}

			if (this.npcs[var4] == null) {
				this.npcs[var4] = new ClientNpc();
			}

			ClientNpc var5 = this.npcs[var4];
			this.npcIds[this.npcCount++] = var4;
			var5.cycle = loopCycle;
			int var6 = arg0.gBit(1);
			if (var6 == 1) {
				this.entityUpdateIds[this.entityUpdateCount++] = var4;
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
			var5.type = NpcType.get(arg0.gBit(13));
			var5.size = var5.type.size;
			var5.G = var5.type.turnspeed;
			var5.Z = var5.type.walkanim;
			var5.ab = var5.type.walkanim_b;
			var5.bb = var5.type.walkanim_r;
			var5.cb = var5.type.walkanim_l;
			var5.readyanim = var5.type.readyanim;
			var5.move(var9 == 1, localPlayer.routeTileX[0] + var8, localPlayer.routeTileZ[0] + var7);
		}

		arg0.bytes();
	}

	@ObfuscatedName("client.b(LMFMVIYHT;II)V")
	public final void readZonePacket(Packet arg0, int arg1, int arg2) {
		if (arg1 != 0) {
			this.objStacks = null;
		}

		if (arg2 == 203) {
			int var4 = arg0.g2();
			int var5 = arg0.g1();
			int var6 = var5 >> 2;
			int var7 = var5 & 3;
			int var8 = this.LOC_SHAPE_TO_LAYER[var6];
			byte var9 = arg0.g1b_alt2();
			int var10 = arg0.g1_alt1();
			int var11 = (var10 >> 4 & 7) + this.baseX;
			int var12 = (var10 & 7) + this.baseZ;
			byte var13 = arg0.g1b_alt1();
			int var14 = arg0.g2_alt2();
			int var15 = arg0.g2_alt1();
			byte var16 = arg0.g1b();
			byte var17 = arg0.g1b_alt1();
			int var18 = arg0.g2();
			ClientPlayer var19;
			if (this.localPid == var15) {
				var19 = localPlayer;
			} else {
				var19 = this.players[var15];
			}

			if (var19 != null) {
				LocType var20 = LocType.a(var4);
				int var21 = this.levelHeightmap[this.currentLevel][var11][var12];
				int var22 = this.levelHeightmap[this.currentLevel][var11 + 1][var12];
				int var23 = this.levelHeightmap[this.currentLevel][var11 + 1][var12 + 1];
				int var24 = this.levelHeightmap[this.currentLevel][var11][var12 + 1];
				Model var25 = var20.a(var6, var7, var21, var22, var23, var24, -1);
				if (var25 != null) {
					this.a(true, this.currentLevel, var11, 0, var14 + 1, 0, -1, var18 + 1, var8, var12);
					var19.Lb = loopCycle + var18;
					var19.Mb = loopCycle + var14;
					var19.tb = var25;
					int var26 = var20.R;
					int var27 = var20.r;
					if (var7 == 1 || var7 == 3) {
						var26 = var20.r;
						var27 = var20.R;
					}

					var19.qb = var11 * 128 + var26 * 64;
					var19.sb = var12 * 128 + var27 * 64;
					var19.rb = this.getHeightMapY(var19.sb, var19.qb, (byte) 9, this.currentLevel);
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
			int var30 = arg0.g1_alt1();
			int var31 = (var30 >> 4 & 7) + this.baseX;
			int var32 = (var30 & 7) + this.baseZ;
			int var33 = arg0.g2_alt3();
			int var34 = arg0.g2_alt2();
			int var35 = arg0.g2_alt2();
			if (var31 >= 0 && var32 >= 0 && var31 < 104 && var32 < 104 && this.localPid != var35) {
				ClientObj var36 = new ClientObj();
				var36.m = var34;
				var36.o = var33;
				if (this.objStacks[this.currentLevel][var31][var32] == null) {
					this.objStacks[this.currentLevel][var31][var32] = new LinkList();
				}

				this.objStacks[this.currentLevel][var31][var32].push(var36);
				this.sortObjStacks(var31, var32);
			}

		} else if (arg2 == 142) {
			int var37 = arg0.g2();
			int var38 = arg0.g1_alt1();
			int var39 = var38 >> 2;
			int var40 = var38 & 3;
			int var41 = this.LOC_SHAPE_TO_LAYER[var39];
			int var42 = arg0.g1();
			int var43 = (var42 >> 4 & 7) + this.baseX;
			int var44 = (var42 & 7) + this.baseZ;
			if (var43 >= 0 && var44 >= 0 && var43 < 103 && var44 < 103) {
				int var45 = this.levelHeightmap[this.currentLevel][var43][var44];
				int var46 = this.levelHeightmap[this.currentLevel][var43 + 1][var44];
				int var47 = this.levelHeightmap[this.currentLevel][var43 + 1][var44 + 1];
				int var48 = this.levelHeightmap[this.currentLevel][var43][var44 + 1];
				if (var41 == 0) {
					Wall var49 = this.scene.c(this.currentLevel, 17734, var43, var44);
					if (var49 != null) {
						int var50 = var49.h >> 14 & 32767;
						if (var39 == 2) {
							var49.f = new ClientLocAnim(var37, var47, var48, var46, 2, (byte) 3, var50, false, var45, var40 + 4);
							var49.g = new ClientLocAnim(var37, var47, var48, var46, 2, (byte) 3, var50, false, var45, var40 + 1 & 3);
						} else {
							var49.f = new ClientLocAnim(var37, var47, var48, var46, var39, (byte) 3, var50, false, var45, var40);
						}
					}
				}

				if (var41 == 1) {
					Decor var51 = this.scene.b(this.currentLevel, var44, var43, false);
					if (var51 != null) {
						var51.f = new ClientLocAnim(var37, var47, var48, var46, 4, (byte) 3, var51.g >> 14 & 32767, false, var45, 0);
					}
				}

				if (var41 == 2) {
					Loc var52 = this.scene.a((int) var43, (byte) 32, var44, this.currentLevel);
					if (var39 == 11) {
						var39 = 10;
					}

					if (var52 != null) {
						var52.e = new ClientLocAnim(var37, var47, var48, var46, var39, (byte) 3, var52.m >> 14 & 32767, false, var45, var40);
					}
				}

				if (var41 == 3) {
					GroundDecor var53 = this.scene.d(this.currentLevel, var44, 0, var43);
					if (var53 != null) {
						var53.d = new ClientLocAnim(var37, var47, var48, var46, 22, (byte) 3, var53.e >> 14 & 32767, false, var45, var40);
					}
				}
			}

		} else if (arg2 == 107) {
			int var54 = arg0.g2();
			int var55 = arg0.g1_alt2();
			int var56 = (var55 >> 4 & 7) + this.baseX;
			int var57 = (var55 & 7) + this.baseZ;
			int var58 = arg0.g2_alt2();
			if (var56 >= 0 && var57 >= 0 && var56 < 104 && var57 < 104) {
				ClientObj var59 = new ClientObj();
				var59.m = var54;
				var59.o = var58;
				if (this.objStacks[this.currentLevel][var56][var57] == null) {
					this.objStacks[this.currentLevel][var56][var57] = new LinkList();
				}

				this.objStacks[this.currentLevel][var56][var57].push(var59);
				this.sortObjStacks(var56, var57);
			}

		} else if (arg2 == 121) {
			int var60 = arg0.g1();
			int var61 = (var60 >> 4 & 7) + this.baseX;
			int var62 = (var60 & 7) + this.baseZ;
			int var63 = arg0.g2();
			int var64 = arg0.g2();
			int var65 = arg0.g2();
			if (var61 >= 0 && var62 >= 0 && var61 < 104 && var62 < 104) {
				LinkList var66 = this.objStacks[this.currentLevel][var61][var62];
				if (var66 != null) {
					for (ClientObj var67 = (ClientObj) var66.head(); var67 != null; var67 = (ClientObj) var66.next()) {
						if ((var63 & 32767) == var67.m && var67.o == var64) {
							var67.o = var65;
							break;
						}
					}

					this.sortObjStacks(var61, var62);
				}
			}

		} else if (arg2 == 181) {
			int var68 = arg0.g1();
			int var69 = (var68 >> 4 & 7) + this.baseX;
			int var70 = (var68 & 7) + this.baseZ;
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
				ClientProj var85 = new ClientProj(this.currentLevel, var76, var80, var82, var74, loopCycle + var78, var79, var73, (byte) -41, this.getHeightMapY(var82, var81, (byte) 9, this.currentLevel) - var75, var81, loopCycle + var77);
				var85.a(var83, var84, this.getHeightMapY(var84, var83, (byte) 9, this.currentLevel) - var76, loopCycle + var77, 0);
				this.oj.push(var85);
			}

		} else {
			if (arg2 == 41) {
				int var86 = arg0.g1();
				int var87 = (var86 >> 4 & 7) + this.baseX;
				int var88 = (var86 & 7) + this.baseZ;
				int var89 = arg0.g2();
				int var90 = arg0.g1();
				int var91 = var90 >> 4 & 15;
				int var92 = var90 & 7;
				if (localPlayer.routeTileX[0] >= var87 - var91 && localPlayer.routeTileX[0] <= var87 + var91 && localPlayer.routeTileZ[0] >= var88 - var91 && localPlayer.routeTileZ[0] <= var88 + var91 && this.waveEnabled && !lowMemory && this.waveCount < 50) {
					this.waveIds[this.waveCount] = var89;
					this.waveLoops[this.waveCount] = var92;
					this.waveDelay[this.waveCount] = Wave.delays[var89];
					++this.waveCount;
				}
			}

			if (arg2 == 59) {
				int var93 = arg0.g1();
				int var94 = (var93 >> 4 & 7) + this.baseX;
				int var95 = (var93 & 7) + this.baseZ;
				int var96 = arg0.g2();
				int var97 = arg0.g1();
				int var98 = arg0.g2();
				if (var94 >= 0 && var95 >= 0 && var94 < 104 && var95 < 104) {
					int var99 = var94 * 128 + 64;
					int var100 = var95 * 128 + 64;
					MapSpotAnim var101 = new MapSpotAnim(var99, this.currentLevel, this.getHeightMapY(var100, var99, (byte) 9, this.currentLevel) - var97, var98, var96, loopCycle, var100, 10709);
					this.Uh.push(var101);
				}

			} else if (arg2 == 152) {
				int var102 = arg0.g1_alt2();
				int var103 = var102 >> 2;
				int var104 = var102 & 3;
				int var105 = this.LOC_SHAPE_TO_LAYER[var103];
				int var106 = arg0.g2_alt3();
				int var107 = arg0.g1_alt1();
				int var108 = (var107 >> 4 & 7) + this.baseX;
				int var109 = (var107 & 7) + this.baseZ;
				if (var108 >= 0 && var109 >= 0 && var108 < 104 && var109 < 104) {
					this.a(true, this.currentLevel, var108, var104, -1, var103, var106, 0, var105, var109);
				}

			} else if (arg2 != 208) {
				if (arg2 == 88) {
					int var116 = arg0.g1_alt3();
					int var117 = (var116 >> 4 & 7) + this.baseX;
					int var118 = (var116 & 7) + this.baseZ;
					int var119 = arg0.g1_alt3();
					int var120 = var119 >> 2;
					int var121 = var119 & 3;
					int var122 = this.LOC_SHAPE_TO_LAYER[var120];
					if (var117 >= 0 && var118 >= 0 && var117 < 104 && var118 < 104) {
						this.a(true, this.currentLevel, var117, var121, -1, var120, -1, 0, var122, var118);
					}

				}
			} else {
				int var110 = arg0.g2_alt2();
				int var111 = arg0.g1_alt1();
				int var112 = (var111 >> 4 & 7) + this.baseX;
				int var113 = (var111 & 7) + this.baseZ;
				if (var112 >= 0 && var113 >= 0 && var112 < 104 && var113 < 104) {
					LinkList var114 = this.objStacks[this.currentLevel][var112][var113];
					if (var114 != null) {
						for (ClientObj var115 = (ClientObj) var114.head(); var115 != null; var115 = (ClientObj) var114.next()) {
							if ((var110 & 32767) == var115.m) {
								var115.unlink();
								break;
							}
						}

						if (var114.head() == null) {
							this.objStacks[this.currentLevel][var112][var113] = null;
						}

						this.sortObjStacks(var112, var113);
					}
				}

			}
		}
	}

	@ObfuscatedName("client.k(B)V")
	public final void k(byte arg0) {
		this.Sg.a(false);
		Pix3D.lineOffset = this.areaSidebarOffset;
		this.vh.a(0, 0, -488);
		if (this.Df != -1) {
			this.a(0, 0, Component.types(this.Df), 0, 8);
		} else if (this.tabInterfaceId[this.selectedTab] != -1) {
			this.a(0, 0, Component.types(this.tabInterfaceId[this.selectedTab]), 0, 8);
		}

		if (this.menuVisible && this.Kj == 1) {
			this.p(false);
		}

		this.Sg.a(205, 553, super.graphics, this.of);
		this.Ug.a(false);
		Pix3D.lineOffset = this.areaViewportOffset;
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
			for (int var3 = var2.length() - 3; var3 > 0; var3 -= 3) {
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
		this.c(arg0.x, arg2, arg0.z, -214);
		if (!arg1) {
			;
		}
	}

	@ObfuscatedName("client.c(IIII)V")
	public final void c(int arg0, int arg1, int arg2, int arg3) {
		if (arg0 >= 128 && arg2 >= 128 && arg0 <= 13056 && arg2 <= 13056) {
			int var5 = this.getHeightMapY(arg2, arg0, (byte) 9, this.currentLevel) - arg1;
			int var6 = arg0 - this.cameraX;
			int var7 = var5 - this.cameraY;
			int var8 = arg2 - this.cameraZ;
			int var9 = Model.Ib[this.cameraPitch];
			int var10 = Model.Jb[this.cameraPitch];
			int var11 = Model.Ib[this.cameraYaw];
			int var12 = Model.Jb[this.cameraYaw];
			int var13 = var6 * var12 + var8 * var11 >> 16;
			int var14 = var8 * var12 - var6 * var11 >> 16;
			int var16 = var7 * var10 - var9 * var14 >> 16;
			int var17 = var7 * var9 + var10 * var14 >> 16;

			while (arg3 >= 0) {
				this.ptype = -1;
			}

			if (var17 >= 50) {
				this.Bc = (var13 << 9) / var17 + Pix3D.centerX;
				this.Cc = (var16 << 9) / var17 + Pix3D.centerY;
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
		if (this.onDemand != null) {
			System.out.println("Od-cycle:" + this.onDemand.cycle);
		}

		System.out.println("loop-cycle:" + loopCycle);
		System.out.println("draw-cycle:" + Pj);
		System.out.println("ptype:" + this.ptype);
		System.out.println("psize:" + this.psize);
		if (arg0) {
			this.te = !this.te;
		}

		if (this.stream != null) {
			this.stream.a(false);
		}

		super.debug = true;
	}

	@ObfuscatedName("client.d(I)Ljava/awt/Component;")
	public final java.awt.Component getBaseComponent() {
		if (SignLink.mainapp != null) {
			return SignLink.mainapp;
		} else if (super.frame != null) {
			return super.frame;
		} else {
			return this;
		}
	}

	@ObfuscatedName("client.a(IZLjava/lang/String;)V")
	public final void drawProgress(int arg0, boolean arg1, String arg2) {
		this.ck = arg0;
		if (!arg1) {
			this.Dc = !this.Dc;
		}

		this.se = arg2;
		this.n(-188);
		if (this.jagTitle == null) {
			super.drawProgress(arg0, true, arg2);
		} else {
			this.Kh.a(false);
			short var4 = 360;
			short var5 = 200;
			byte var6 = 20;
			this.fontBold12.drawStringCenter(var4 / 2, var5 / 2 - 26 - var6, "RuneScape is loading - please wait...", 16777215);
			int var7 = var5 / 2 - 18 - var6;
			Pix2D.drawRect(var4 / 2 - 152, var7, 304, 34, (int) 9179409);
			Pix2D.drawRect(var4 / 2 - 151, var7 + 1, 302, 32, (int) 0);
			Pix2D.fillRect(9179409, arg0 * 3, 30, var4 / 2 - 150, var7 + 2);
			Pix2D.fillRect(0, 300 - arg0 * 3, 30, arg0 * 3 + (var4 / 2 - 150), var7 + 2);
			this.fontBold12.drawStringCenter(var4 / 2, var5 / 2 + 5 - var6, arg2, 16777215);
			this.Kh.a(171, 202, super.graphics, this.of);
			if (this.Le) {
				this.Le = false;
				if (!this.flameActive) {
					this.Lh.a(0, 0, super.graphics, this.of);
					this.Mh.a(0, 637, super.graphics, this.of);
				}

				this.Ih.a(0, 128, super.graphics, this.of);
				this.Jh.a(371, 202, super.graphics, this.of);
				this.Nh.a(265, 0, super.graphics, this.of);
				this.Oh.a(265, 562, super.graphics, this.of);
				this.Ph.a(171, 128, super.graphics, this.of);
				this.Qh.a(171, 562, super.graphics, this.of);
			}
		}
	}

	@ObfuscatedName("client.r(Z)V")
	public final void r(boolean arg0) {
		byte[] var2 = this.jagTitle.read("title.dat", (byte[]) null);
		Pix24 var3 = new Pix24(var2, this);
		this.Lh.a(false);
		var3.blitOpaque(0, 0);
		this.Mh.a(false);
		var3.blitOpaque(0, -637);
		this.Ih.a(false);
		var3.blitOpaque(0, -128);
		this.Jh.a(false);
		var3.blitOpaque(-371, -202);
		this.Kh.a(false);
		var3.blitOpaque(-171, -202);
		this.Nh.a(false);
		var3.blitOpaque(-265, 0);
		this.Oh.a(false);
		var3.blitOpaque(-265, -562);
		this.Ph.a(false);
		var3.blitOpaque(-171, -128);
		this.Qh.a(false);
		var3.blitOpaque(-171, -562);
		int[] var4 = new int[var3.J];

		for (int var5 = 0; var5 < var3.K; ++var5) {
			for (int var6 = 0; var6 < var3.J; ++var6) {
				var4[var6] = var3.pixels[var3.J * var5 + (var3.J - var6 - 1)];
			}

			for (int var7 = 0; var7 < var3.J; ++var7) {
				var3.pixels[var3.J * var5 + var7] = var4[var7];
			}
		}

		this.Lh.a(false);
		var3.blitOpaque(0, 382);
		this.Mh.a(false);
		var3.blitOpaque(0, -255);
		this.Ih.a(false);
		var3.blitOpaque(0, 254);
		this.Jh.a(false);
		var3.blitOpaque(-371, 180);
		this.Kh.a(false);
		var3.blitOpaque(-171, 180);
		this.Nh.a(false);
		if (arg0) {
			for (int var8 = 1; var8 > 0; ++var8) {
			}
		}

		var3.blitOpaque(-265, 382);
		this.Oh.a(false);
		var3.blitOpaque(-265, -180);
		this.Ph.a(false);
		var3.blitOpaque(-171, 254);
		this.Qh.a(false);
		var3.blitOpaque(-171, -180);
		Pix24 var9 = new Pix24(this.jagTitle, "logo", 0);
		this.Ih.a(false);
		var9.b(18, 382 - var9.J / 2 - 128, -488);
		Object var10 = null;
		Object var11 = null;
		Object var12 = null;
		System.gc();

	}

	@ObfuscatedName("client.a(BLNLLHDXXJ;)V")
	public final void a(byte arg0, LocChange arg1) {
		int var3 = 0;
		int var4 = -1;
		int var5 = 0;
		int var6 = 0;
		if (arg0 != -61) {
			this.out.p1((int) 175);
		}

		if (arg1.m == 0) {
			var3 = this.scene.b(arg1.l, arg1.x, arg1.z);
		}

		if (arg1.m == 1) {
			var3 = this.scene.b(arg1.x, (byte) 4, arg1.l, arg1.z);
		}

		if (arg1.m == 2) {
			var3 = this.scene.c(arg1.l, arg1.x, arg1.z);
		}

		if (arg1.m == 3) {
			var3 = this.scene.d(arg1.l, arg1.x, arg1.z);
		}

		if (var3 != 0) {
			int var7 = this.scene.getInfo(arg1.l, arg1.x, arg1.z, var3);
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
		this.flameActive = false;

		while (this.ak) {
			this.flameActive = false;

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
		if (arg2.type == 0 && arg2.children != null) {
			if (!arg2.hide || this.Ij == arg2.id || this.mj == arg2.id || this.Uf == arg2.id) {
				int var6 = Pix2D.left;
				int var7 = Pix2D.top;
				int var8 = Pix2D.right;
				int var9 = Pix2D.bottom;
				Pix2D.setBounds(arg2.height + arg1, arg2.width + arg0, arg0, arg1);
				int var10 = arg2.children.length;
				if (arg4 != 8) {
					this.ptype = -1;
				}

				for (int var11 = 0; var11 < var10; ++var11) {
					int var12 = arg2.childX[var11] + arg1;
					int var13 = arg2.childY[var11] + arg0 - arg3;
					Component var14 = Component.types(arg2.children[var11]);
					int var15 = var14.s + var12;
					int var16 = var14.X + var13;
					if (var14.clientCode > 0) {
						this.updateInterfaceContent((Component) var14);
					}

					if (var14.type == 0) {
						if (var14.scrollPosition > var14.scroll - var14.width) {
							var14.scrollPosition = var14.scroll - var14.width;
						}

						if (var14.scrollPosition < 0) {
							var14.scrollPosition = 0;
						}

						this.a(var16, var15, var14, var14.scrollPosition, 8);
						if (var14.scroll > var14.width) {
							this.a(true, var14.scrollPosition, var14.height + var15, var14.width, var14.scroll, var16);
						}
					} else if (var14.type != 1) {
						if (var14.type == 2) {
							int var17 = 0;

							for (int var18 = 0; var18 < var14.width; ++var18) {
								for (int var19 = 0; var19 < var14.height; ++var19) {
									int var20 = (var14.marginX + 32) * var19 + var15;
									int var21 = (var14.marginY + 32) * var18 + var16;
									if (var17 < 20) {
										var20 += var14.invSlotOffsetX[var17];
										var21 += var14.invSlotOffsetY[var17];
									}

									if (var14.invSlotObjId[var17] <= 0) {
										if (var14.invSlotGraphic != null && var17 < 20) {
											Pix24 var30 = var14.invSlotGraphic[var17];
											if (var30 != null) {
												var30.b(var21, var20, -488);
											}
										}
									} else {
										int var22 = 0;
										int var23 = 0;
										int var24 = var14.invSlotObjId[var17] - 1;
										if (var20 > Pix2D.left - 32 && var20 < Pix2D.right && var21 > Pix2D.top - 32 && var21 < Pix2D.bottom || this.bg != 0 && this.ag == var17) {
											int var25 = 0;
											if (this.objSelected == 1 && this.Jg == var17 && this.Kg == var14.id) {
												var25 = 16777215;
											}

											Pix24 var26 = ObjType.getIcon(var24, var14.invSlotObjCount[var17], var25);
											if (var26 != null) {
												if (this.bg != 0 && this.ag == var17 && this.Zf == var14.id) {
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
													if (var21 + var23 < Pix2D.top && arg2.scrollPosition > 0) {
														int var27 = (Pix2D.top - var21 - var23) * this.Uc / 3;
														if (var27 > this.Uc * 10) {
															var27 = this.Uc * 10;
														}

														if (var27 > arg2.scrollPosition) {
															var27 = arg2.scrollPosition;
														}

														arg2.scrollPosition -= var27;
														this.dg += var27;
													}

													if (var21 + var23 + 32 > Pix2D.bottom && arg2.scrollPosition < arg2.scroll - arg2.width) {
														int var28 = (var21 + var23 + 32 - Pix2D.bottom) * this.Uc / 3;
														if (var28 > this.Uc * 10) {
															var28 = this.Uc * 10;
														}

														if (var28 > arg2.scroll - arg2.width - arg2.scrollPosition) {
															var28 = arg2.scroll - arg2.width - arg2.scrollPosition;
														}

														arg2.scrollPosition += var28;
														this.dg -= var28;
													}
												} else if (this.mk != 0 && this.lk == var17 && this.kk == var14.id) {
													var26.b(0, var20, var21, 128);
												} else {
													var26.b(var21, var20, -488);
												}

												if (var26.width == 33 || var14.invSlotObjCount[var17] != 1) {
													int var29 = var14.invSlotObjCount[var17];
													this.fontPlain11.b(2245, var20 + 1 + var22, 0, var21 + 10 + var23, a(var29, (int) -243));
													this.fontPlain11.b(2245, var20 + var22, 16776960, var21 + 9 + var23, a(var29, (int) -243));
												}
											}
										}
									}

									++var17;
								}
							}
						} else if (var14.type == 3) {
							boolean var31 = false;
							if (this.Uf == var14.id || this.mj == var14.id || this.Ij == var14.id) {
								var31 = true;
							}

							int var32;
							if (this.b((Component) var14, -693)) {
								var32 = var14.activeColour;
								if (var31 && var14.q != 0) {
									var32 = var14.q;
								}
							} else {
								var32 = var14.colour;
								if (var31 && var14.overColour != 0) {
									var32 = var14.overColour;
								}
							}

							if (var14.alpha == 0) {
								if (var14.fill) {
									Pix2D.fillRect(var32, var14.height, var14.width, var15, var16);
								} else {
									Pix2D.drawRect(var15, var16, var14.height, var14.width, (int) var32);
								}
							} else if (var14.fill) {
								Pix2D.fillRectTrans(var16, 256 - (var14.alpha & 255), var14.width, var14.height, var32, var15);
							} else {
								Pix2D.drawRectTrans(var15, var16, var14.height, var14.width, var32, 256 - (var14.alpha & 255));
							}
						} else if (var14.type == 4) {
							PixFont var33 = var14.font;
							String var34 = var14.text;
							boolean var35 = false;
							if (this.Uf == var14.id || this.mj == var14.id || this.Ij == var14.id) {
								var35 = true;
							}

							int var36;
							if (this.b((Component) var14, -693)) {
								var36 = var14.activeColour;
								if (var35 && var14.q != 0) {
									var36 = var14.q;
								}

								if (var14.activeText.length() > 0) {
									var34 = var14.activeText;
								}
							} else {
								var36 = var14.colour;
								if (var35 && var14.overColour != 0) {
									var36 = var14.overColour;
								}
							}

							if (var14.buttonType == 6 && this.xi) {
								var34 = "Please wait...";
								var36 = var14.colour;
							}

							if (Pix2D.width2d == 479) {
								if (var36 == 16776960) {
									var36 = 255;
								}

								if (var36 == 49152) {
									var36 = 16777215;
								}
							}

							int var37 = var33.G + var16;

							while (var34.length() > 0) {
								if (var34.indexOf("%") != -1) {
									label390:
									while (true) {
										int var38 = var34.indexOf("%1");
										if (var38 == -1) {
											while (true) {
												int var39 = var34.indexOf("%2");
												if (var39 == -1) {
													while (true) {
														int var40 = var34.indexOf("%3");
														if (var40 == -1) {
															while (true) {
																int var41 = var34.indexOf("%4");
																if (var41 == -1) {
																	while (true) {
																		int var42 = var34.indexOf("%5");
																		if (var42 == -1) {
																			break label390;
																		}

																		var34 = var34.substring(0, var42) + this.e(this.executeClientScript((Component) var14, (int) 4), 8) + var34.substring(var42 + 2);
																	}
																}

																var34 = var34.substring(0, var41) + this.e(this.executeClientScript((Component) var14, (int) 3), 8) + var34.substring(var41 + 2);
															}
														}

														var34 = var34.substring(0, var40) + this.e(this.executeClientScript((Component) var14, (int) 2), 8) + var34.substring(var40 + 2);
													}
												}

												var34 = var34.substring(0, var39) + this.e(this.executeClientScript((Component) var14, (int) 1), 8) + var34.substring(var39 + 2);
											}
										}

										var34 = var34.substring(0, var38) + this.e(this.executeClientScript((Component) var14, (int) 0), 8) + var34.substring(var38 + 2);
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

								if (var14.center) {
									var33.a(var14.shadowed, this.Ve, var36, var37, var14.height / 2 + var15, var44);
								} else {
									var33.a(var36, var15, var37, var14.shadowed, var44, -39629);
								}

								var37 += var33.G;
							}
						} else if (var14.type == 5) {
							Pix24 var45;
							if (this.b((Component) var14, -693)) {
								var45 = var14.activeGraphic;
							} else {
								var45 = var14.graphic;
							}

							if (var45 != null) {
								var45.b(var16, var15, -488);
							}
						} else if (var14.type == 6) {
							int var46 = Pix3D.centerX;
							int var47 = Pix3D.centerY;
							Pix3D.centerX = var14.height / 2 + var15;
							Pix3D.centerY = var14.width / 2 + var16;
							int var48 = Pix3D.sinTable[var14.xan] * var14.zoom >> 16;
							int var49 = Pix3D.cosTable[var14.xan] * var14.zoom >> 16;
							boolean var50 = this.b((Component) var14, -693);
							int var51;
							if (var50) {
								var51 = var14.activeAnim;
							} else {
								var51 = var14.anim;
							}

							Model var52;
							if (var51 == -1) {
								var52 = var14.getModel(-1, -1, 0, var50);
							} else {
								SeqType var53 = SeqType.types[var51];
								var52 = var14.getModel(var53.frames[var14.z], var53.g[var14.z], 0, var50);
							}

							if (var52 != null) {
								var52.drawSimple(0, var14.yan, 0, var14.xan, 0, var48, var49);
							}

							Pix3D.centerX = var46;
							Pix3D.centerY = var47;
						} else {
							if (var14.type == 7) {
								PixFont var54 = var14.font;
								int var55 = 0;

								for (int var56 = 0; var56 < var14.width; ++var56) {
									for (int var57 = 0; var57 < var14.height; ++var57) {
										if (var14.invSlotObjId[var55] > 0) {
											ObjType var58 = ObjType.get(var14.invSlotObjId[var55] - 1);
											String var59 = String.valueOf(var58.name);
											if (var58.stackable || var14.invSlotObjCount[var55] != 1) {
												var59 = var59 + " x" + i(0, var14.invSlotObjCount[var55]);
											}

											int var60 = (var14.marginX + 115) * var57 + var15;
											int var61 = (var14.marginY + 12) * var56 + var16;
											if (var14.center) {
												var54.a(var14.shadowed, this.Ve, var14.colour, var61, var14.height / 2 + var60, var59);
											} else {
												var54.a(var14.colour, var60, var61, var14.shadowed, var59, -39629);
											}
										}

										++var55;
									}
								}
							}

							if (var14.type == 8 && (this.qj == var14.id || this.Je == var14.id || this.rg == var14.id) && this.Ob == 100) {
								int var62 = 0;
								int var63 = 0;
								PixFont var64 = this.fontPlain12;
								String var65 = var14.text;

								while (var65.length() > 0) {
									int var66 = var65.indexOf("\\n");
									String var67;
									if (var66 != -1) {
										var67 = var65.substring(0, var66);
										var65 = var65.substring(var66 + 2);
									} else {
										var67 = var65;
										var65 = "";
									}

									int var68 = var64.a((byte) 35, var67);
									if (var68 > var62) {
										var62 = var68;
									}

									var63 += var64.G + 1;
								}

								var62 += 6;
								var63 += 7;
								int var69 = var14.height + var15 - 5 - var62;
								int var70 = var14.width + var16 + 5;
								if (var69 < var15 + 5) {
									var69 = var15 + 5;
								}

								if (var62 + var69 > arg2.height + arg1) {
									var69 = arg2.height + arg1 - var62;
								}

								if (var63 + var70 > arg2.width + arg0) {
									var70 = arg2.width + arg0 - var63;
								}

								Pix2D.fillRect(16777120, var62, var63, var69, var70);
								Pix2D.drawRect(var69, var70, var62, var63, (int) 0);
								String var71 = var14.text;
								int var72 = var64.G + var70 + 2;

								while (var71.length() > 0) {
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

				Pix2D.setBounds(var8, var9, var7, var6);
			}
		}
	}

	@ObfuscatedName("client.l(B)V")
	public final void l(byte arg0) {
		if (arg0 != -40) {
			Rh = !Rh;
		}

		if (lowMemory && this.sceneState == 2 && World.levelBuilt != this.currentLevel) {
			this.a(-332, (String) null, "Loading - please wait.");
			this.sceneState = 1;
			this.sceneLoadStartTime = System.currentTimeMillis();
		}

		if (this.sceneState == 1) {
			int var2 = this.checkScene();
			if (var2 != 0 && System.currentTimeMillis() - this.sceneLoadStartTime > 360000L) {
				SignLink.reporterror(this.username + " glcfb " + this.serverSeed + "," + var2 + "," + lowMemory + "," + this.fileStreams[0] + "," + this.onDemand.remaining() + "," + this.currentLevel + "," + this.Kb + "," + this.Lb);
				this.sceneLoadStartTime = System.currentTimeMillis();
			}
		}

		if (this.sceneState == 2 && this.minimapLevel != this.currentLevel) {
			this.minimapLevel = this.currentLevel;
			this.g(this.currentLevel, 0);
		}
	}

	@ObfuscatedName("client.I(I)I")
	public final int checkScene() {
		for (int i = 0; i < this.sceneMapLandData.length; ++i) {
			if (this.sceneMapLandData[i] == null && this.sceneMaplandFile[i] != -1) {
				return -1;
			}

			if (this.sceneMapLocData[i] == null && this.sceneMapLocFile[i] != -1) {
				return -2;
			}
		}

		boolean ready = true;
		for (int i = 0; i < this.sceneMapLandData.length; ++i) {
			byte[] data = this.sceneMapLocData[i];
			if (data != null) {
				int x = (this.db[i] >> 8) * 64 - this.sceneBaseTileX;
				int z = (this.db[i] & 255) * 64 - this.sceneBaseTileZ;
				if (this.Zg) {
					x = 10;
					z = 10;
				}

				ready &= World.locsAreReady(x, z, data, 24515);
			}
		}

		if (!ready) {
			return -3;
		} else if (this.awaitingSync) {
			return -4;
		} else {
			this.sceneState = 2;
			World.levelBuilt = this.currentLevel;
			this.buildScene(175);
			this.out.pIsaac(6);
			return 0;
		}
	}

	@ObfuscatedName("client.a(ZIIIIIIIII)V")
	public final void a(boolean arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
		LocChange var11 = null;

		for (LocChange var12 = (LocChange) this.locChanges.head(); var12 != null; var12 = (LocChange) this.locChanges.next()) {
			if (var12.l == arg1 && var12.x == arg2 && var12.z == arg9 && var12.m == arg8) {
				var11 = var12;
				break;
			}
		}

		if (var11 == null) {
			var11 = new LocChange();
			var11.l = arg1;
			var11.m = arg8;
			var11.x = arg2;
			var11.z = arg9;
			this.a((byte) -61, var11);
			this.locChanges.push(var11);
		}

		var11.e = arg6;
		var11.g = arg5;
		var11.f = arg3;
		var11.p = arg7;
		var11.endTime = arg4;
		this.ingame &= arg0;
	}

	@ObfuscatedName("client.m(B)V")
	public final void m(byte arg0) {
		if (arg0 == 4) {
			if (this.Pe == 0) {
				if (super.mouseClickButton == 1) {
					int var2 = super.C - 25 - 550;
					int var3 = super.D - 5 - 4;
					if (var2 >= 0 && var3 >= 0 && var2 < 146 && var3 < 151) {
						var2 -= 73;
						var3 -= 75;
						int var4 = this.lc + this.Ki & 2047;
						int var5 = Pix3D.sinTable[var4];
						int var6 = Pix3D.cosTable[var4];
						int var7 = (this.ri + 256) * var5 >> 8;
						int var8 = (this.ri + 256) * var6 >> 8;
						int var9 = var2 * var8 + var3 * var7 >> 11;
						int var10 = var3 * var8 - var2 * var7 >> 11;
						int var11 = localPlayer.x + var9 >> 7;
						int var12 = localPlayer.z - var10 >> 7;
						boolean var13 = this.a(true, false, var12, localPlayer.routeTileZ[0], 0, 0, 1, 0, var11, 0, 0, localPlayer.routeTileX[0]);
						if (var13) {
							this.out.p1(var2);
							this.out.p1(var3);
							this.out.p2(this.Ki);
							this.out.p1((int) 57);
							this.out.p1(this.lc);
							this.out.p1(this.ri);
							this.out.p1((int) 89);
							this.out.p2(localPlayer.x);
							this.out.p2(localPlayer.z);
							this.out.p1(this.og);
							this.out.p1((int) 63);
							return;
						}
					}
				}

			}
		}
	}

	@ObfuscatedName("client.J(I)V")
	public final void J(int arg0) {
		if (super.drawArea == null) {
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
			super.drawArea = new PixMap(765, 503, this.getBaseComponent(), (byte) -12);
			this.Le = true;
		}
	}

	@ObfuscatedName("client.a(ILjava/lang/String;)Z")
	public final boolean a(int arg0, String arg1) {
		if (arg1 == null) {
			return false;
		} else {
			for (int var3 = 0; var3 < this.friendCount; ++var3) {
				if (arg1.equalsIgnoreCase(this.friendName[var3])) {
					return true;
				}
			}

			if (arg0 != 13292) {
				this.fe = !this.fe;
			}

			return arg1.equalsIgnoreCase(localPlayer.name);
		}
	}

	@ObfuscatedName("client.K(I)V")
	public final void K(int arg0) {
		while (arg0 >= 0) {
			this.ptype = this.in.g1();
		}

		if (this.titleScreenState == 0) {
			int var2 = super.screenWidth / 2 - 80;
			int var3 = super.screenHeight / 2 + 20;
			int var14 = var3 + 20;
			if (super.mouseClickButton == 1 && super.C >= var2 - 75 && super.C <= var2 + 75 && super.D >= var14 - 20 && super.D <= var14 + 20) {
				this.titleScreenState = 3;
				this.ud = 0;
			}

			int var4 = super.screenWidth / 2 + 80;
			if (super.mouseClickButton == 1 && super.C >= var4 - 75 && super.C <= var4 + 75 && super.D >= var14 - 20 && super.D <= var14 + 20) {
				this.loginMessage0 = "";
				this.loginMessage1 = "Enter your username & password.";
				this.titleScreenState = 2;
				this.ud = 0;
			}
		} else if (this.titleScreenState == 2) {
			int var5 = super.screenHeight / 2 - 40;
			int var15 = var5 + 30;
			int var16 = var15 + 25;
			if (super.mouseClickButton == 1 && super.D >= var16 - 15 && super.D < var16) {
				this.ud = 0;
			}

			var5 = var16 + 15;
			if (super.mouseClickButton == 1 && super.D >= var5 - 15 && super.D < var5) {
				this.ud = 1;
			}

			var5 += 15;
			int var6 = super.screenWidth / 2 - 80;
			int var7 = super.screenHeight / 2 + 50;
			int var17 = var7 + 20;
			if (super.mouseClickButton == 1 && super.C >= var6 - 75 && super.C <= var6 + 75 && super.D >= var17 - 20 && super.D <= var17 + 20) {
				this.X = 0;
				this.login(this.username, this.pasword, false);
				if (this.ingame) {
					return;
				}
			}

			int var8 = super.screenWidth / 2 + 80;
			if (super.mouseClickButton == 1 && super.C >= var8 - 75 && super.C <= var8 + 75 && super.D >= var17 - 20 && super.D <= var17 + 20) {
				this.titleScreenState = 0;
				this.username = "";
				this.pasword = "";
			}

			while (true) {
				while (true) {
					int var9 = this.a((int) -983);
					if (var9 == -1) {
						return;
					}

					boolean var10 = false;

					for (int var11 = 0; var11 < Yd.length(); ++var11) {
						if (var9 == Yd.charAt(var11)) {
							var10 = true;
							break;
						}
					}

					if (this.ud == 0) {
						if (var9 == 8 && this.username.length() > 0) {
							this.username = this.username.substring(0, this.username.length() - 1);
						}

						if (var9 == 9 || var9 == 10 || var9 == 13) {
							this.ud = 1;
						}

						if (var10) {
							this.username = this.username + (char) var9;
						}

						if (this.username.length() > 12) {
							this.username = this.username.substring(0, 12);
						}
					} else if (this.ud == 1) {
						if (var9 == 8 && this.pasword.length() > 0) {
							this.pasword = this.pasword.substring(0, this.pasword.length() - 1);
						}

						if (var9 == 9 || var9 == 10 || var9 == 13) {
							this.ud = 0;
						}

						if (var10) {
							this.pasword = this.pasword + (char) var9;
						}

						if (this.pasword.length() > 20) {
							this.pasword = this.pasword.substring(0, 20);
						}
					}
				}
			}
		} else {
			if (this.titleScreenState == 3) {
				int var12 = super.screenWidth / 2;
				int var13 = super.screenHeight / 2 + 50;
				int var18 = var13 + 20;
				if (super.mouseClickButton == 1 && super.C >= var12 - 75 && super.C <= var12 + 75 && super.D >= var18 - 20 && super.D <= var18 + 20) {
					this.titleScreenState = 0;
					return;
				}
			}

		}
	}

	@ObfuscatedName("client.a(IIIIII)V")
	public final void a(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		int var7 = this.scene.b(arg1, arg2, arg0);
		int var8 = 62 / arg4;
		if (var7 != 0) {
			int var9 = this.scene.getInfo(arg1, arg2, arg0, var7);
			int var10 = var9 >> 6 & 3;
			int var11 = var9 & 31;
			int var12 = arg5;
			if (var7 > 0) {
				var12 = arg3;
			}

			int[] var13 = this.imageMinimap.pixels;
			int var14 = (103 - arg0) * 512 * 4 + arg2 * 4 + 24624;
			int var15 = var7 >> 14 & 32767;
			LocType var16 = LocType.a(var15);
			if (var16.L != -1) {
				Pix8 var17 = this.imageMapscene[var16.L];
				if (var17 != null) {
					int var18 = (var16.R * 4 - var17.width) / 2;
					int var19 = (var16.r * 4 - var17.height) / 2;
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

		int var20 = this.scene.c(arg1, arg2, arg0);
		if (var20 != 0) {
			int var21 = this.scene.getInfo(arg1, arg2, arg0, var20);
			int var22 = var21 >> 6 & 3;
			int var23 = var21 & 31;
			int var24 = var20 >> 14 & 32767;
			LocType var25 = LocType.a(var24);
			if (var25.L != -1) {
				Pix8 var26 = this.imageMapscene[var25.L];
				if (var26 != null) {
					int var27 = (var25.R * 4 - var26.width) / 2;
					int var28 = (var25.r * 4 - var26.height) / 2;
					var26.a((104 - arg0 - var25.r) * 4 + 48 + var28, arg2 * 4 + 48 + var27, -488);
				}
			} else if (var23 == 9) {
				int var29 = 15658734;
				if (var20 > 0) {
					var29 = 15597568;
				}

				int[] var30 = this.imageMinimap.pixels;
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

		int var32 = this.scene.d(arg1, arg2, arg0);
		if (var32 != 0) {
			int var33 = var32 >> 14 & 32767;
			LocType var34 = LocType.a(var33);
			if (var34.L != -1) {
				Pix8 var35 = this.imageMapscene[var34.L];
				if (var35 != null) {
					int var36 = (var34.R * 4 - var35.width) / 2;
					int var37 = (var34.r * 4 - var35.height) / 2;
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
		this.a((int) 751, true);
		this.b(0, false);
		this.a((int) 751, false);
		this.h(false);
		this.r(-992);
		if (!this.cutscene) {
			int var2 = this.Ji;
			if (this.vj / 256 > var2) {
				var2 = this.vj / 256;
			}

			if (this.cameraModifierEnabled[4] && this.Z[4] + 128 > var2) {
				var2 = this.Z[4] + 128;
			}

			int var3 = this.Ni + this.Ki & 2047;
			this.a(this.getHeightMapY(localPlayer.z, localPlayer.x, (byte) 9, this.currentLevel) - 50, this.Ui, var2, var2 * 3 + 600, var3, this.Vi, (byte) -103);
		}

		int var4;
		if (!this.cutscene) {
			var4 = this.j((byte) 1);
		} else {
			var4 = this.E(-276);
		}

		int var5 = this.cameraX;
		int var6 = this.cameraY;
		int var7 = this.cameraZ;
		int var8 = this.cameraPitch;
		int var9 = this.cameraYaw;
		if (arg0 != 2) {
			this.Vd = this.randomIn.nextInt();
		}

		for (int var10 = 0; var10 < 5; ++var10) {
			if (this.cameraModifierEnabled[var10]) {
				int var11 = (int) (Math.random() * (double) (this.Tf[var10] * 2 + 1) - (double) this.Tf[var10] + Math.sin((double) this.Id[var10] / 100.0D * (double) this.cameraModifierCycle[var10]) * (double) this.Z[var10]);
				if (var10 == 0) {
					this.cameraX += var11;
				}

				if (var10 == 1) {
					this.cameraY += var11;
				}

				if (var10 == 2) {
					this.cameraZ += var11;
				}

				if (var10 == 3) {
					this.cameraYaw = this.cameraYaw + var11 & 2047;
				}

				if (var10 == 4) {
					this.cameraPitch += var11;
					if (this.cameraPitch < 128) {
						this.cameraPitch = 128;
					}

					if (this.cameraPitch > 383) {
						this.cameraPitch = 383;
					}
				}
			}
		}

		int var12 = Pix3D.T;
		Model.Db = true;
		Model.Gb = 0;
		Model.Eb = super.v - 4;
		Model.Fb = super.w - 4;
		Pix2D.clear();
		this.scene.a(this.cameraX, var4, 0, this.cameraY, this.cameraZ, this.cameraYaw, this.cameraPitch);
		this.scene.a(this.Sb);
		this.m(false);
		this.o(true);
		this.d(var12, -927);
		this.C(30729);
		this.Ug.a(4, 4, super.graphics, this.of);
		this.cameraX = var5;
		this.cameraY = var6;
		this.cameraZ = var7;
		this.cameraPitch = var8;
		this.cameraYaw = var9;
	}

	@ObfuscatedName("client.M(I)V")
	public final void M(int arg0) {
		if (arg0 != -23763) {
			this.load();
		}

		for (int var2 = 0; var2 < this.waveCount; ++var2) {
			if (this.waveDelay[var2] <= 0) {
				boolean var3 = false;

				try {
					if (this.waveIds[var2] == this.ej && this.waveLoops[var2] == this.Ec) {
						if (!this.replayWave()) {
							var3 = true;
						}
					} else {
						Packet var4 = Wave.a(this.waveLoops[var2], (byte) 6, this.waveIds[var2]);
						if (System.currentTimeMillis() + (long) (var4.pos / 22) > (long) (this.ph / 22) + this.Ii) {
							this.ph = var4.pos;
							this.Ii = System.currentTimeMillis();
							if (this.a(3, (int) var4.pos, (byte[]) var4.data)) {
								this.ej = this.waveIds[var2];
								this.Ec = this.waveLoops[var2];
							} else {
								var3 = true;
							}
						}
					}
				} catch (Exception var7) {
					if (SignLink.reporterror) {
						this.out.pIsaac(80);
						this.out.p2(this.waveIds[var2] & 32767);
					} else {
						this.out.pIsaac(80);
						this.out.p2((int) -1);
					}
				}

				if (var3 && this.waveDelay[var2] != -5) {
					this.waveDelay[var2] = -5;
				} else {
					--this.waveCount;

					for (int var6 = var2; var6 < this.waveCount; ++var6) {
						this.waveIds[var6] = this.waveIds[var6 + 1];
						this.waveLoops[var6] = this.waveLoops[var6 + 1];
						this.waveDelay[var6] = this.waveDelay[var6 + 1];
					}

					--var2;
				}
			} else {
				int var10002 = this.waveDelay[var2]--;
			}
		}

		if (this.nextMusicDelay > 0) {
			this.nextMusicDelay -= 20;
			if (this.nextMusicDelay < 0) {
				this.nextMusicDelay = 0;
			}

			if (this.nextMusicDelay == 0 && this.midiActive && !lowMemory) {
				this.midiSong = this.nextMidiSong;
				this.midiFading = true;
				this.onDemand.request(2, this.midiSong);
				return;
			}
		}

	}

	static {
		int var0 = 0;

		for (int var1 = 0; var1 < 99; ++var1) {
			int var2 = var1 + 1;
			int var3 = (int) ((double) var2 + 300.0D * Math.pow(2.0D, (double) var2 / 7.0D));
			var0 += var3;
			levelExperience[var1] = var0 / 4;
		}

		gd = true;
		Yd = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
		DESIGN_BODY_COLOUR = new int[][]{{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 2983, 54193}, {8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003, 25239}, {25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003}, {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574}};
		qe = -352;
		Ah = true;
		Yh = new int[32];
		int var4 = 2;

		for (int var5 = 0; var5 < 32; ++var5) {
			Yh[var5] = var4 - 1;
			var4 += var4;
		}

		Ai = true;
		DESIGN_HAIR_COLOUR = new int[]{9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145, 58654, 5027, 1457, 16565, 34991, 25486};
		Wj = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");
	}
}
