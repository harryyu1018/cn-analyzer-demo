package top.yujy.cnanalyzer.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.dictionary.BaseSearcher;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;

import java.util.Map;

/**
 * 用户词典Demo. 演示动态增删该查。
 */
public class CustomDictionaryDemo {

    public static void main(String[] args) {

        CustomDictionary.add("攻城狮");
        CustomDictionary.insert("白富美", "nz 1024");

        System.out.println(CustomDictionary.add("单身狗", "nz 1024 n 1"));

        // 这是一个美好的愿望
        String text = "攻城狮逆袭单身狗，迎娶白富美，走上人生巅峰";

        final char[] charArray = text.toCharArray();
        CustomDictionary.parseText(charArray, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>() {
            @Override
            public void hit(int begin, int end, CoreDictionary.Attribute attribute) {
                System.out.printf("[%d:%d]=%s %s\n", begin, end, new String(charArray, begin, end - begin), attribute);
            }
        });

        System.out.println("=============================");

        // trie树分词
        BaseSearcher searcher = CustomDictionary.getSearcher(text);
        Map.Entry entry;
        while ((entry = searcher.next()) != null) {
            System.out.println(entry);
        }

        System.out.println("=============================");

        CustomDictionary.remove("单身狗");
        // 再用trie树分词一次
        searcher = CustomDictionary.getSearcher(text);
        while ((entry = searcher.next()) != null) {
            System.out.println(entry);
        }

        System.out.println("=============================");

        // 标准分词
        System.out.println(HanLP.segment(text));

    }


}
