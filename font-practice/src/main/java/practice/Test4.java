package practice;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.CharacterIterator;

public class Test4 {
    public static void main(String[] args) throws IOException, FontFormatException {

        Font font = openFontTTF();
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = img.getGraphics();
        g.setFont(font);
        FontRenderContext fontRenderContext = g.getFontMetrics().getFontRenderContext();

        System.out.println(font.getNumGlyphs());


        /*String ga ="가";
        byte[] bytes = ga.getBytes("UTF-8");
        System.out.println(bytes);

        BreakIterator boundary = BreakIterator.getCharacterInstance();
        boundary.setText();
        for (int start = boundary.first(), end = boundary.next();
             end != BreakIterator.DONE;
             start = end, end = boundary.next()) {
             String chunk = ga.substring(start, end);
            System.out.println(chunk);
        }*/

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
