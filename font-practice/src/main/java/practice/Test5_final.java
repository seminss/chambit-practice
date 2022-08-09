package practice;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test5_final {
    public static void main(String[] args) throws IOException, FontFormatException {

        Font font = openFontTTF();
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = img.getGraphics();
        g.setFont(font);
        FontRenderContext fontRenderContext = g.getFontMetrics().getFontRenderContext();

        System.out.println(font.getNumGlyphs());
        int cnt=0;

        //Character.MAX_VALUE 로 하면 폰트마다 글리프 갯수가 다르기 때문에, 중복되서 나오는 글자 발생
        for(char c = 0x0000; c<=font.getNumGlyphs(); c++){
            cnt++;
            if(font.canDisplay(c)){
                GlyphVector glyphVector = font.createGlyphVector(fontRenderContext, String.valueOf(c));
                System.out.println(cnt+")"+c+"의 글리프 정보: "+glyphVector.toString());
            }
        }
    }
    public static Font openFontTTF() throws IOException, FontFormatException {
        String fontPath = "C:\\Users\\김세민\\study\\chambit\\font-practice\\src\\main\\resources\\NanumGothic.ttf";
        Font font = Font.createFont(Font.TRUETYPE_FONT,new File(fontPath));
        return font.deriveFont(12f);
    }
}