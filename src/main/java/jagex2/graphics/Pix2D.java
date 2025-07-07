package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;

public class Pix2D extends DoublyLinkable {

	@ObfuscatedName("LFYNQWSZ.l")
	public static int[] data;

	@ObfuscatedName("LFYNQWSZ.m")
	public static int width2d;

	@ObfuscatedName("LFYNQWSZ.n")
	public static int height2d;

	@ObfuscatedName("LFYNQWSZ.o")
	public static int top;

	@ObfuscatedName("LFYNQWSZ.p")
	public static int bottom;

	@ObfuscatedName("LFYNQWSZ.q")
	public static int left;

	@ObfuscatedName("LFYNQWSZ.r")
	public static int right;

	@ObfuscatedName("LFYNQWSZ.s")
	public static int safeWidth;

	@ObfuscatedName("LFYNQWSZ.t")
	public static int centerX2d;

	@ObfuscatedName("LFYNQWSZ.u")
	public static int centerY2d;

	@ObfuscatedName("LFYNQWSZ.a(ZII[I)V")
	public static void bind(int width, int[] data, int height) {
		Pix2D.data = data;
		width2d = width;
		height2d = height;
		setBounds(width, height, 0, 0);
	}

	@ObfuscatedName("LFYNQWSZ.a(B)V")
	public static void resetBounds() {
		left = 0;
		top = 0;
		right = width2d;
		bottom = height2d;
		safeWidth = right - 1;
		centerX2d = right / 2;
	}

	@ObfuscatedName("LFYNQWSZ.a(IIIIZ)V")
	public static void setBounds(int right, int bottom, int top, int left) {
		if (left < 0) {
			left = 0;
		}

		if (top < 0) {
			top = 0;
		}

		if (right > width2d) {
			right = width2d;
		}

		if (bottom > height2d) {
			bottom = height2d;
		}

		Pix2D.left = left;
		Pix2D.top = top;
		Pix2D.right = right;
		Pix2D.bottom = bottom;
		safeWidth = Pix2D.right - 1;
		centerX2d = Pix2D.right / 2;
		centerY2d = Pix2D.bottom / 2;
	}

	@ObfuscatedName("LFYNQWSZ.a(I)V")
	public static void clear() {
		int length = height2d * width2d;
		for (int i = 0; i < length; ++i) {
			data[i] = 0;
		}
	}

	@ObfuscatedName("LFYNQWSZ.a(ZIIIIII)V")
	public static void fillRectTrans(int y, int alpha, int height, int width, int colour, int x) {
		if (x < left) {
			width -= left - x;
			x = left;
		}

		if (y < top) {
			height -= top - y;
			y = top;
		}

		if (width + x > right) {
			width = right - x;
		}

		if (y + height > bottom) {
			height = bottom - y;
		}

		int invAlpha = 256 - alpha;
		int r0 = (colour >> 16 & 0xFF) * alpha;
		int g0 = (colour >> 8 & 0xFF) * alpha;
		int b0 = (colour & 0xFF) * alpha;
		int step = width2d - width;
		int offset = width2d * y + x;

		for (int i = 0; i < height; ++i) {
			for (int j = -width; j < 0; ++j) {
				int r1 = (data[offset] >> 16 & 0xFF) * invAlpha;
				int g1 = (data[offset] >> 8 & 0xFF) * invAlpha;
				int b1 = (data[offset] & 0xFF) * invAlpha;

				int rgb = (b0 + b1 >> 8) + (r0 + r1 >> 8 << 16) + (g0 + g1 >> 8 << 8);
				data[offset++] = rgb;
			}

			offset += step;
		}
	}

	@ObfuscatedName("LFYNQWSZ.a(IIIBII)V")
	public static void fillRect(int color, int width, int height, int x, int y) {
		if (x < left) {
			width -= left - x;
			x = left;
		}

		if (y < top) {
			height -= top - y;
			y = top;
		}

		if (width + x > right) {
			width = right - x;
		}

		if (height + y > bottom) {
			height = bottom - y;
		}

		int step = width2d - width;
		int offset = width2d * y + x;

		for (int i = -height; i < 0; i++) {
			for (int j = -width; j < 0; j++) {
				data[offset++] = color;
			}

			offset += step;
		}
	}

	@ObfuscatedName("LFYNQWSZ.a(IIIIII)V")
	public static void drawRect(int x, int y, int width, int height, int colour) {
		drawHorizontalLine(x, y, width, colour);
		drawHorizontalLine(x, y + height - 1, width, colour);
		drawVerticalLine(x, y, height, colour);
		drawVerticalLine(x + width - 1, y, height, colour);
	}

	@ObfuscatedName("LFYNQWSZ.a(IIIIIIB)V")
	public static void drawRectTrans(int x, int y, int width, int height, int color, int alpha) {
		drawHorizontalLineTrans(x, y, width, color, alpha);
		drawHorizontalLineTrans(x, height + y - 1, width, color, alpha);
		if (height >= 3) {
			drawVerticalLineTrans(x, y + 1, height - 2, color, alpha);
			drawVerticalLineTrans(x + width - 1, y + 1, height - 2, color, alpha);
		}
	}

	@ObfuscatedName("LFYNQWSZ.b(IIIIZ)V")
	public static void drawHorizontalLine(int x, int y, int width, int color) {
		if (y >= top && y < bottom) {
			if (x < left) {
				width -= left - x;
				x = left;
			}

			if (x + width > right) {
				width = right - x;
			}

			int offset = width2d * y + x;

			for (int i = 0; i < width; ++i) {
				data[offset + i] = color;
			}

		}
	}

	@ObfuscatedName("LFYNQWSZ.b(IIIIII)V")
	public static void drawHorizontalLineTrans(int x, int y, int width, int colour, int alpha) {
		if (y >= top && y < bottom) {
			if (x < left) {
				width -= left - x;
				x = left;
			}

			if (x + width > right) {
				width = right - x;
			}

			int invAlpha = 256 - alpha;
			int r0 = (colour >> 16 & 0xFF) * alpha;
			int g0 = (colour >> 8 & 0xFF) * alpha;
			int b0 = (colour & 0xFF) * alpha;
			int offset = width2d * y + x;

			for (int i = 0; i < width; ++i) {
				int r1 = (data[offset] >> 16 & 0xFF) * invAlpha;
				int g1 = (data[offset] >> 8 & 0xFF) * invAlpha;
				int b1 = (data[offset] & 0xFF) * invAlpha;

				int rgb = (b0 + b1 >> 8) + (r0 + r1 >> 8 << 16) + (g0 + g1 >> 8 << 8);
				data[offset++] = rgb;
			}
		}
	}

	@ObfuscatedName("LFYNQWSZ.a(IIIZI)V")
	public static void drawVerticalLine(int x, int y, int height, int color) {
		if (x >= left && x < right) {
			if (y < top) {
				height -= top - y;
				y = top;
			}

			if (height + y > bottom) {
				height = bottom - y;
			}

			int offset = width2d * y + x;

			for (int i = 0; i < height; ++i) {
				data[width2d * i + offset] = color;
			}

		}
	}

	@ObfuscatedName("LFYNQWSZ.c(IIIIII)V")
	public static void drawVerticalLineTrans(int x, int y, int height, int color, int alpha) {
		if (x >= left && x < right) {
			if (y < top) {
				height -= top - y;
				y = top;
			}

			if (y + height > bottom) {
				height = bottom - y;
			}

			int invAlpha = 256 - alpha;
			int r0 = (color >> 16 & 255) * alpha;
			int g0 = (color >> 8 & 255) * alpha;
			int b0 = (color & 255) * alpha;
			int offset = width2d * y + x;

			for (int i = 0; i < height; i++) {
				int r1 = (data[offset] >> 16 & 255) * invAlpha;
				int g1 = (data[offset] >> 8 & 255) * invAlpha;
				int b1 = (data[offset] & 255) * invAlpha;

				int rgb = (b0 + b1 >> 8) + (r0 + r1 >> 8 << 16) + (g0 + g1 >> 8 << 8);
				data[offset] = rgb;

				offset += width2d;
			}
		}
	}
}
