package top.yujy.cnanalyzer.hanlp;

import org.testng.annotations.Test;
import top.yujy.cnanalyzer.BaseTest;

import java.util.List;

public class SegmentUtilsTest extends BaseTest {

    String[] texts = {
            "北京市朝阳区北辰西路8号北辰世纪中心A座5层537"
    };

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
