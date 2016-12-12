package top.yujy.cnanalyzer.hanlp;

import org.testng.annotations.Test;
import top.yujy.cnanalyzer.BaseTest;

import java.util.List;

public class SegmentUtilsTest extends BaseTest {

    String[] texts = {
            "北京市朝阳区北辰西路8号北辰世纪中心A座5层537",
            "攻城狮逆袭单身狗，迎娶白富美，走上人生巅峰"
    };

    @Test
    public void allTest() {

        for (String text : texts) {
            System.out.print("标准:\t");
            print(SegmentUtils.standard(text));

            System.out.print("NLP:\t");
            print(SegmentUtils.nlp(text));

            System.out.print("索引:\t");
            print(SegmentUtils.index(text));

            System.out.print("N最短:\t");
            print(SegmentUtils.nshort(text));

            System.out.print("最短:\t");
            print(SegmentUtils.shortest(text));

            System.out.print("极速:\t");
            print(SegmentUtils.highSpeed(text));


            System.out.println();
            System.out.println("===================================");
            System.out.println();
        }

    }

    @Test
    public void standardTest() {

        for (String text : texts) {
            List<String> words = SegmentUtils.standard(text);
            print(words);
        }

    }

    @Test
    public void nlpTest() {

        for (String text : texts) {
            List<String> words = SegmentUtils.nlp(text);
            print(words);
        }

    }

    @Test
    public void indexText() {

        for (String text : texts) {
            List<String> words = SegmentUtils.index(text);
            print(words);
        }
    }

    @Test
    public void nshortText() {

        for (String text : texts) {
            List<String> words = SegmentUtils.nshort(text);
            print(words);
        }
    }

    @Test
    public void shortestText() {

        for (String text : texts) {
            List<String> words = SegmentUtils.shortest(text);
            print(words);
        }
    }

    @Test
    public void crfText() {

        for (String text : texts) {
            List<String> words = SegmentUtils.crf(text);
            print(words);
        }
    }

    @Test
    public void highSpeedText() {

        /**
         * 测试了一下的确分词效果不是很好。对于连续数字无法识别。
         */

        for (String text : texts) {
            List<String> words = SegmentUtils.highSpeed(text);
            print(words);
        }
    }
}
