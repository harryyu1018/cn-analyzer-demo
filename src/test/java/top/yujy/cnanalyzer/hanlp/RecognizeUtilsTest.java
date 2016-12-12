package top.yujy.cnanalyzer.hanlp;


import org.testng.annotations.Test;
import top.yujy.cnanalyzer.BaseTest;

public class RecognizeUtilsTest extends BaseTest {

    @Test
    public void peopleName() {

        String[] testCase = new String[] {
                "签约仪式前，秦光荣、李纪恒、仇和等一同会见了参加签约的企业家。",
                "王国强、高峰、汪洋、张朝阳光着头、韩寒、小四",
                "张浩和胡健康复员回家了",
                "王总和小丽结婚了",
                "编剧邵钧林和稽道青说",
                "这里有关天培的有关事迹",
                "龚学平等领导,邓颖超生前",
        };

        for (String text : testCase) {
            print(RecognizeUtils.peopleName(text));
        }
    }

    @Test
    public void translateName() {

        String[] testCase = new String[] {
                "一桶冰水当头倒下，微软的比尔盖茨、Facebook的扎克伯格跟桑德博格、亚马逊的贝索斯、苹果的库克全都不惜湿身入镜，这些硅谷的科技人，飞蛾扑火似地牺牲演出，其实全为了慈善。",
                "世界上最长的姓名是简森·乔伊·亚历山大·比基·卡利斯勒·达夫·埃利奥特·福克斯·伊维鲁莫·马尔尼·梅尔斯·帕特森·汤普森·华莱士·普雷斯顿。",
        };

        for (String text : testCase) {
            print(RecognizeUtils.translateName(text));
        }

    }

    @Test
    public void organization() {

        String[] testCase = new String[]{
                "我在上海林原科技有限公司兼职工作，",
                "我经常在台川喜宴餐厅吃饭，",
                "偶尔去地中海影城看电影。",
                "北京极海纵横科技有限公司"
        };

        for (String text : testCase) {
            print(RecognizeUtils.organization(text));
        }
    }
}
