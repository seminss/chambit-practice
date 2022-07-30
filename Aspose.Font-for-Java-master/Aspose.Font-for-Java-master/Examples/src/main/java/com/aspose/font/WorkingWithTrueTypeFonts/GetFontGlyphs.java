package com.aspose.font.WorkingWithTrueTypeFonts;

import com.aspose.font.*;
import com.aspose.font.utilities.Utils;

public class GetFontGlyphs {
    public static void main(String[] args) {
        String fileName = Utils.getDataDir() + "Montserrat-Regular.ttf"; //Font file name with full path

        FontDefinition fd = new FontDefinition(FontType.TTF, new FontFileDefinition("ttf", new FileSystemStreamSource(fileName)));
        TtfFont font = (TtfFont) Font.open(fd);

        String name = font.getFontName();
    }
}
