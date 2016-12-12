package top.yujy.cnanalyzer.hanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.dictionary.BaseSearcher;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;

import java.util.Map;

/**
 * 用户词典Demo. 演示动态增删该查。
 *
 * {@link com.hankcs.hanlp.dictionary.CustomDictionary}是一份全局的用户自定义词典，可以随时增删，影响全部分词器。
 * 另外，可以在分词器中关闭它。通过代码动态增删不会保存到词典文件。
 *
 * 追加词典：
 * - CustomDictionary主词典路径是：data/dictionary/custom/CustomDictionary.txt，用户可以直接在此文件中追加词项（但是不推荐）；
 * - 比较推荐的做法是，通过单独新建一个文本文件通过配置进行追加，如：data/dictionary/custom/CustomDictionary.txt; 我的词典.txt。
 * 另外，官方建议把词性相同的词语放到同一个词典文件里，便于维护和分享。
 *
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
