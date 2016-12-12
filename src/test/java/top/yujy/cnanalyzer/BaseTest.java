package top.yujy.cnanalyzer;

import java.util.List;

public class BaseTest {

    private static final String WHITESPACE = "  ";

    public void print(List<String> list) {

        StringBuilder builder = new StringBuilder();
        list.forEach(e -> { builder.append(e).append(WHITESPACE); });

        System.out.println(builder.toString());
    }
}
