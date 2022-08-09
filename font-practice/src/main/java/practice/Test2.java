package practice;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException, FontFormatException {

        Font font = openFontTTF();
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = img.getGraphics();
        g.setFont(font);
        FontRenderContext fontRenderContext = g.getFontMetrics().getFontRenderContext();
        GlyphVector glyphVector[] = new GlyphVector[100];
        char start = 'ㄱ'; int cnt=0;

        for (int i = 0; i < 100; i++){
            char c = (char)(start + i);
            cnt++;
            String str =String.valueOf(c).trim();
            glyphVector[i] = font.createGlyphVector(fontRenderContext,str);
            System.out.println(str +" bounds: "+glyphVector[i].getGlyphOutline(0).getBounds());
        }
/*        for (int w = 0; w < cnt; w++) {
            *//** glyph에서 불러오고 싶은거 불러오기*//*
            System.out.println(" bounds: "+glyphVector[w].getGlyphOutline(0).getBounds());
        }*/


/*        System.out.println("폰트 정보: "+g.getFontMetrics().getFont());
        System.out.println("테두리: "+glyphVector.getGlyphOutline(0).getBounds()); //getBounds
        System.out.println("텍스트 안의 글리프 개수: "+glyphVector.getNumGlyphs());
        System.out.println(glyphVector.getGlyphCode(0));// getGlyphCode
        System.out.println("현재 인덱스 출력: "+ glyphVector.getGlyphCharIndex(0));*/

        /*System.out.println("-----------------");
        System.out.println("(Glyph OutLine)");
        GlyphOutLine(glyphVector,0);

        System.out.println("-----------------");
        System.out.println("(GlyphLogicalBounds)");
        GlyphLogicalBounds(glyphVector,0);

        System.out.println("-----------------");
        System.out.println("(GlyphMetrics)");
        GlyphMetrics(glyphVector,0);

        System.out.println("------------------");
        System.out.println(glyphVector.getGlyphPosition(0));
        System.out.println(glyphVector.getFont());*/


//        System.out.println(glyphVector.getGlyphTransform(0).getScaleX());
//        System.out.println(glyphVector.getGlyphTransform(0).getScaleY());

    }

    public static void GlyphOutLine(GlyphVector glyphVector, int index){

        System.out.println(glyphVector.getGlyphOutline(index).getBounds2D());
        System.out.println(glyphVector.getGlyphOutline(index).getBounds2D().getMaxX());
        System.out.println(glyphVector.getGlyphOutline(index).getBounds2D().getMinX());
        System.out.println(glyphVector.getGlyphOutline(index).getBounds2D().getMaxY());
        System.out.println(glyphVector.getGlyphOutline(index).getBounds2D().getMinY());
    }
    public static void GlyphLogicalBounds(GlyphVector glyphVector, int index){

        System.out.println(glyphVector.getGlyphLogicalBounds(index).getBounds().getMaxX());
        System.out.println(glyphVector.getGlyphLogicalBounds(index).getBounds().getMinX());
        System.out.println(glyphVector.getGlyphLogicalBounds(index).getBounds().getMaxY());
        System.out.println(glyphVector.getGlyphLogicalBounds(index).getBounds().getMinY());
    }
    public static void GlyphMetrics(GlyphVector glyphVector, int index){

        System.out.println(glyphVector.getGlyphMetrics(index).getAdvanceX());
        System.out.println(glyphVector.getGlyphMetrics(index).getAdvanceY());
        System.out.println(glyphVector.getGlyphMetrics(index).getLSB());
        System.out.println(glyphVector.getGlyphMetrics(index).getRSB());
        System.out.println(glyphVector.getGlyphMetrics(index).getType());
    }

    public static Font openFontTTF() throws IOException, FontFormatException {
        String fontPath = "C:\\Users\\김세민\\study\\chambit\\font-practice\\src\\main\\resources\\Montserrat-Regular.ttf";
        Font font = Font.createFont(Font.TRUETYPE_FONT,new File(fontPath));
        return font.deriveFont(12f);
    }
}
