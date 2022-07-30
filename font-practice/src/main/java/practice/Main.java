package practice;

import java.awt.*;

public class Main {
    public static void main(String[] args){

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 250); //이름,스타일,크기
        /*AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
        String text ="aa bb cc dd ee !!";
        char[] chars=text.toCharArray();*/

/*        for (char c = 0x0000; c <= Character.MAX_VALUE; c++) {
            if (font.canDisplay(c)) {
            }
        }*/

        /*GlyphVector vector = font.createGlyphVector(frc,text);*/ //FontRenderContext, char[]
/*        GlyphVector vector = font.layoutGlyphVector(GlyphPage.renderContext, chars, 0,chars.length,Font.LAYOUT_LEFT_TO_RIGHT);
        FontMetircs metrics = GlyphPage.getScratchGraphics().getFontMetircs(font);*/
        /*System.out.println(vector.getGlyphOutline(1));
        System.out.println(vector.getFont());
        System.out.println(vector.getGlyphCode(1));
        System.out.println(vector.toString());*/
    }

}

