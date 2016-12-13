package top.yujy.cnanalyzer.hanlp;

import com.hankcs.hanlp.HanLP;

import java.util.ArrayList;
import java.util.List;

/**
 * 命名实体识别Demo.
 */
public class RecognizeUtils {

    /**
     * 中国人名识别。目前分词器基本上默认开启了中国人名识别，下面这样写是为了强调。
     * 会有一定的误命中率，比如：关键年。
     * @param text
     * @return
     */
    public static List<String> peopleName(String text) {

        List<String> words = new ArrayList<>();
        HanLP.newSegment()
                .enableNameRecognize(true)
                .seg(text)
                .forEach(t -> { words.add(t.word); });

        return words;
    }

    /**
     * 音译人名识别。目前分词器基本上默认开启了音译人名识别，下面这样写是为了强调。
     * @param text
     * @return
     */
    public static List<String> translateName(String text) {

        List<String> words = new ArrayList<>();
        HanLP.newSegment()
                .enableTranslatedNameRecognize(true)
                .seg(text)
                .forEach(t -> { words.add(t.word); });

        return words;
    }

    /**
     * 日本人名识别。默认关闭，需要手动开启。
     * 原因：出现频次较低，但是又消耗性能。
     * @param text
     * @return
     */
    public static List<String> japaneseName(String text) {

        List<String> words = new ArrayList<>();
        HanLP.newSegment()
                .enableJapaneseNameRecognize(true)
                .seg(text)
                .forEach(t -> { words.add(t.word); });

        return words;
    }

    /**
     * 地名识别。默认关闭，需要手动开启。
     * 原因：消耗性能，并且多数地名都收录在核心词典和用户自定义词典中。
     * @param text
     * @return
     */
    public static List<String> place(String text) {

        List<String> words = new ArrayList<>();
        HanLP.newSegment()
                .enablePlaceRecognize(true)
                .seg(text)
                .forEach(t -> { words.add(t.word); });

        return words;
    }

    /**
     * 机构名识别。 默认关闭，需要用户手动开启。
     * @param text
     * @return
     */
    public static List<String> organization(String text) {

        List<String> words = new ArrayList<>();
        HanLP.newSegment()
                .enableOrganizationRecognize(true)
                .seg(text)
                .forEach(t -> { words.add(t.word); });

        return words;
    }
}
