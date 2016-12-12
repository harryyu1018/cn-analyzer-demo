package top.yujy.cnanalyzer.hanlp;

import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * HanLP多种分词方法的实验.
 */
public class SegmentUtils {

    /**
     * HanLP中的标准分词.
     * @param text
     * @return
     */
    public static List<String> standard(String text) {

        List<String> words = new ArrayList<>();

        List<Term> terms = StandardTokenizer.segment(text);
        terms.forEach(t -> { words.add(t.word); });

        return words;
    }

    /**
     * NLP分词。会执行全部命名实体识别和词性标注。
     * @param text
     * @return
     */
    public static List<String> nlp(String text) {

        List<String> words = new ArrayList<>();
        NLPTokenizer.segment(text).forEach(t -> { words.add(t.word); });

        return words;
    }

    /**
     * 索引分词IndexTokenizer是面向搜索引擎的分词器，能够对长词全切分，
     * 另外，通过term.offset可以获取单词在文本中的偏移量。
     * @param text
     * @return
     */
    public static List<String> index(String text) {

        List<String> words = new ArrayList<>();
        IndexTokenizer.segment(text).forEach(t -> { words.add(t.word); });

        return words;
    }

    /**
     * N最短分词，比下面的最短分词器要慢，但是效果稍微好一些，对命名实体识别能力更强。
     * @param text
     * @return
     */
    public static List<String> nshort(String text) {

        List<String> words = new ArrayList<>();
        new NShortSegment()
                .enableCustomDictionary(false)
                .enablePlaceRecognize(false)
                .enableOrganizationRecognize(false)
                .seg(text)
                .forEach(t -> { words.add(t.word); });

        return words;
    }

    /**
     * 最短路径分词。一般场景下最短路径分词的精度已经足够，而且速度比N最短分词器快几倍。
     * @param text
     * @return
     */
    public static List<String> shortest(String text) {

        List<String> words = new ArrayList<>();
        new DijkstraSegment()
                .enableCustomDictionary(false)
                .enablePlaceRecognize(false)
                .enableOrganizationRecognize(false)
                .seg(text)
                .forEach(t -> { words.add(t.word); });

        return words;
    }

    /**
     * CRF分词。对新词有很好的识别能力，但是开销较大。
     * @param text
     * @return
     */
    public static List<String> crf(String text) {

        List<String> words = new ArrayList<>();
        new CRFSegment()
                .enablePartOfSpeechTagging(true)
                .seg(text)
                .forEach(t -> { words.add(t.word); });

        return words;
    }

    /**
     * 极速词典分词。采用了词典最长分词，速度极其快，但是精度一般。
     * @param text
     * @return
     */
    public static List<String> highSpeed(String text) {

        List<String> words = new ArrayList<>();
        SpeedTokenizer.segment(text).forEach(t -> { words.add(t.word); });

        return words;
    }

}
