package practice;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.CharacterIterator;

public class Test3 {
    public static void main(String[] args) throws IOException, FontFormatException {

        Font font = openFontTTF();
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = img.getGraphics();
        g.setFont(font);
        FontRenderContext fontRenderContext = g.getFontMetrics().getFontRenderContext();

        System.out.println(font.getNumGlyphs());

        // CharacterIterator it = new StringCharacterIterator(font.getNumGlyphs());
        /* while(it.current()!= CharacterIterator.DONE){
            System.out.println(it.current());
            it.next();
        }*/

        for (int i = 0; i < font.getNumGlyphs(); i++){
            if (font.canDisplay(i)) {
                System.out.println(String.valueOf(i));
                GlyphVector textGlyphVector = font.createGlyphVector(fontRenderContext, String.valueOf(i));
                System.out.println(textGlyphVector);
                //System.out.println(((int) i) + ": " + Long.toHexString(i));
            }
        }
/*        GlyphVector textGlyphVector = font.createGlyphVector(fontRenderContext, new char[] {,});
        Shape shape = textGlyphVector.getOutline();
        System.out.println(shape.getBounds2D());*/
        /*g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);*/


    }


    public static void traverseForward(CharacterIterator iter){
        for(char c = iter.first(); c!= CharacterIterator.DONE; c = iter.next()){
            //processChar(c);
            System.out.println(c);
        }
    }

    private void processChar(char c) {
    }

    public static Font openFontTTF() throws IOException, FontFormatException {
        String fontPath = "C:\\Users\\김세민\\study\\chambit\\font-practice\\src\\main\\resources\\NanumGothic.ttf";
        Font font = Font.createFont(Font.TRUETYPE_FONT,new File(fontPath));
        return font.deriveFont(12f);
    }
}
