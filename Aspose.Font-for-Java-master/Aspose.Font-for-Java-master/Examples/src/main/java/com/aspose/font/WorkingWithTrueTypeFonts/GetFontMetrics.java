package com.aspose.font.WorkingWithTrueTypeFonts;

import java.text.MessageFormat;

import com.aspose.font.FileSystemStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.Glyph;
import com.aspose.font.GlyphUInt32Id;
import com.aspose.font.TtfCMapFormatBaseTable;
import com.aspose.font.TtfFont;
import com.aspose.font.utilities.Utils;

public class GetFontMetrics {

	public static void main(String[] args) {
		//ExStart: 1
/*		String fileName = Utils.getDataDir() + "Montserrat-Regular.ttf"; *////폰트 파일 이름 전체 다 적기
        String fileName = Utils.getDataDir() + "MaruBuri-Regular.ttf";

        FontDefinition fd = new FontDefinition(FontType.TTF, new FontFileDefinition("ttf", new FileSystemStreamSource(fileName)));
        TtfFont font = (TtfFont) Font.open(fd);

        String name = font.getFontName();
        System.out.println("Font name: " + name); // 폰트 이름
        System.out.println("Glyph count: " + font.getNumGlyphs()); // 폰트 파일의 글리프 갯수 가져오기

        String metrics = MessageFormat.format(//어센더, 디센더, typo 어센더, typo 디센더 등 초기화
            "Font metrics: ascender - {0}, descender - {1}, typo ascender = {2}, typo descender = {3}, UnitsPerEm = {4}",
            font.getMetrics().getAscender(), font.getMetrics().getDescender(),
            font.getMetrics().getTypoAscender(), font.getMetrics().getTypoDescender(), font.getMetrics().getUnitsPerEM());

        System.out.println(metrics); // 초기화 한 메트릭 출력
        System.out.println("====================================");

        //Get cmap unicode encoding table from font as object TtfCMapFormatBaseTable to access information about font glyph for symbol 'A'.
        //Also check that font has object TtfGlyfTable (table 'glyf') to access glyph.
        TtfCMapFormatBaseTable cmapTable = null;
        if (font.getTtfTables().getCMapTable() != null)
        {//cmap 테이블 잘 만들어졌으면
            cmapTable = font.getTtfTables().getCMapTable().findUnicodeTable(); //camp에다가 font의 유니코드 테이블을 넣기, cmap table의 key값을 유니코드로 채우기
        }
        if (cmapTable != null && font.getTtfTables().getGlyfTable() != null)
        {//camp은 물론, glyphtable을 가져왔을 때 잘있니?
        	System.out.println("Font cmap unicode table: PlatformID = " + cmapTable.getPlatformId() +
        			", PlatformSpecificID = " + cmapTable.getPlatformSpecificId());

            //Code for 'A' symbol
/*            char unicode = (char) 65;*/

            char unicode = 'a';

            //Code for '가' symbol
/*            char unicode = '가';*/

            //cmapTable에서 'A'에 대한 글리프 인덱스 가져옴
            long glIndex = cmapTable.getGlyphIndex(unicode);

            if (glIndex != 0)
            {
                //'A'에 대한 글리프 추출
                Glyph glyph = font.getGlyphById(glIndex);
                // 글리프가 있으면
                if (glyph != null)
                {
                    //아까 초기화 해둔 glyph metrics 출력, 'A'에 대한
                	System.out.println("Glyph metrics for 'A' symbol:");
                    String bbox = MessageFormat.format(
                        "Glyph BBox: Xmin = {0}, Xmax = {1}" + ", Ymin = {2}, Ymax = {3}",
                        glyph.getGlyphBBox().getXMin(), glyph.getGlyphBBox().getXMax(),
                        glyph.getGlyphBBox().getYMin(), glyph.getGlyphBBox().getYMax());
                    System.out.println(bbox);
                    System.out.println("Width:" + font.getMetrics().getGlyphWidth(new GlyphUInt32Id(glIndex)));
                }
            }
        }
        //ExEnd: 1
	}
}
