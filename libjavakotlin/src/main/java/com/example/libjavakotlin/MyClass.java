package com.example.libjavakotlin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyClass {
    /*
英文（英国）               、英文（美国）、西班牙语(拉丁美洲) 、西班牙语（欧洲）、德语（DE）、法语（法国）、法语（欧洲）、意大利语、荷兰语、捷克语、罗马尼亚语、葡萄牙语（欧洲）
英文（美国）               、英文（英国）、西班牙语(拉丁美洲) 、西班牙语（欧洲）、德语（DE）、法语（法国）、法语（欧洲）、意大利语、荷兰语、捷克语、罗马尼亚语、葡萄牙语（欧洲）
西班牙语(拉丁美洲)          、英文（英国）、英文（美国）、西班牙语（欧洲）、德语（DE）、法语（法国）、法语（欧洲）、意大利语、荷兰语、捷克语、罗马尼亚语、葡萄牙语（欧洲）
西班牙语（欧洲）            、英文（英国）、英文（美国）、西班牙语(拉丁美洲)、德语（DE）、法语（法国）、法语（欧洲）、意大利语、荷兰语、捷克语、罗马尼亚语、葡萄牙语（欧洲）
德语（DE）                 、英文（英国）、英文（美国）、西班牙语(拉丁美洲）、西班牙语（欧洲）、法语（法国）、法语（欧洲）、意大利语、荷兰语、捷克语、罗马尼亚语、葡萄牙语（欧洲）
法语（法国）               、英文（英国）、英文（美国）、西班牙语(拉丁美洲）、西班牙语（欧洲）、德语（DE）、法语（欧洲）、意大利语、荷兰语、捷克语、罗马尼亚语、葡萄牙语（欧洲）
法语（欧洲）               、英文（英国）、英文（美国）、西班牙语(拉丁美洲）、西班牙语（欧洲）、德语（DE）、法语（法国）、意大利语、荷兰语、捷克语、罗马尼亚语、葡萄牙语（欧洲）
意大利语                   、英文（英国）、英文（美国）、西班牙语(拉丁美洲）、西班牙语（欧洲）、德语（DE）、法语（法国）、法语（欧洲）、荷兰语、捷克语、罗马尼亚语、葡萄牙语（欧洲）
荷兰语                     、英文（英国）、英文（美国）、西班牙语(拉丁美洲）、西班牙语（欧洲）、德语（DE）、法语（法国）、法语（欧洲）、意大利语、捷克语、罗马尼亚语、葡萄牙语（欧洲）
捷克语                     、英文（英国）、英文（美国）、西班牙语(拉丁美洲）、西班牙语（欧洲）、德语（DE）、法语（法国）、法语（欧洲）、意大利语、荷兰语、罗马尼亚语、葡萄牙语（欧洲）
罗马尼亚语                 、英文（英国）、英文（美国）、西班牙语(拉丁美洲）、西班牙语（欧洲）、德语（DE）、法语（法国）、法语（欧洲）、意大利语、荷兰语、捷克语、葡萄牙语（欧洲）
葡萄牙语（欧洲）            、英文（英国）、英文（美国）、西班牙语(拉丁美洲）、西班牙语（欧洲）、德语（DE）、法语（法国）、法语（欧洲）、意大利语、荷兰语、捷克语、罗马尼亚语
     */
    public static void main(String[] args) {
        String[][] strs = new String[12][];
        strs[0] = new String[]{"英文（英国）", "英文（美国）", "西班牙语(拉丁美洲） ", "西班牙语（欧洲）", "德语（DE）", "法语（法国）", "法语（欧洲）", "意大利语", "荷兰语", "捷克语", "罗马尼亚语", "葡萄牙语（欧洲）"};
        strs[1] = new String[]{"英文（美国）", "英文（英国）", "西班牙语(拉丁美洲） ", "西班牙语（欧洲）", "德语（DE）", "法语（法国）", "法语（欧洲）", "意大利语", "荷兰语", "捷克语", "罗马尼亚语", "葡萄牙语（欧洲）"};
        strs[2] = new String[]{"西班牙语（拉丁美洲）", "英文（英国）", "英文（美国）", "西班牙语（欧洲）", "德语（DE）", "法语（法国）", "法语（欧洲）", "意大利语", "荷兰语", "捷克语", "罗马尼亚语", "葡萄牙语（欧洲）"};
        strs[3] = new String[]{"西班牙语（欧洲）", "英文（英国）", "英文（美国）", "西班牙语（拉丁美洲）", "德语（DE）", "法语（法国）", "法语（欧洲）", "意大利语", "荷兰语", "捷克语", "罗马尼亚语", "葡萄牙语（欧洲）"};
        strs[4] = new String[]{"德语（DE）", "英文（英国）", "英文（美国）", "西班牙语（拉丁美洲）", "西班牙语（欧洲）", "法语（法国）", "法语（欧洲）", "意大利语", "荷兰语", "捷克语", "罗马尼亚语", "葡萄牙语（欧洲）"};
        strs[5] = new String[]{"法语（法国）", "英文（英国）", "英文（美国）", "西班牙语（拉丁美洲）", "西班牙语（欧洲）", "德语（DE）", "法语（欧洲）", "意大利语", "荷兰语", "捷克语", "罗马尼亚语", "葡萄牙语（欧洲）"};
        strs[6] = new String[]{"法语（欧洲）", "英文（英国）", "英文（美国）", "西班牙语（拉丁美洲）", "西班牙语（欧洲）", "德语（DE）", "法语（法国）", "意大利语", "荷兰语", "捷克语", "罗马尼亚语", "葡萄牙语（欧洲）"};
        strs[7] = new String[]{"意大利语", "英文（英国）", "英文（美国）", "西班牙语（拉丁美洲）", "西班牙语（欧洲）", "德语（DE）", "法语（法国）", "法语（欧洲）", "荷兰语", "捷克语", "罗马尼亚语", "葡萄牙语（欧洲）"};
        strs[8] = new String[]{"荷兰语", "英文（英国）", "英文（美国）", "西班牙语（拉丁美洲）", "西班牙语（欧洲）", "德语（DE）", "法语（法国）", "法语（欧洲）", "意大利语", "捷克语", "罗马尼亚语", "葡萄牙语（欧洲）"};
        strs[9] = new String[]{"捷克语", "英文（英国）", "英文（美国）", "西班牙语（拉丁美洲）", "西班牙语（欧洲）", "德语（DE）", "法语（法国）", "法语（欧洲）", "意大利语", "荷兰语", "罗马尼亚语", "葡萄牙语（欧洲）"};
        strs[10] = new String[]{"罗马尼亚语", "英文（英国）", "英文（美国）", "西班牙语（拉丁美洲）", "西班牙语（欧洲）", "德语（DE）", "法语（法国）", "法语（欧洲）", "意大利语", "荷兰语", "捷克语", "葡萄牙语（欧洲）"};
        strs[11] = new String[]{"葡萄牙语（欧洲）", "英文（英国）", "英文（美国）", "西班牙语（拉丁美洲）", "西班牙语（欧洲）", "德语（DE）", "法语（法国）", "法语（欧洲）", "意大利语", "荷兰语", "捷克语", "罗马尼亚语"};
        trimStrs(strs);
//        final Map<String, String> localMap = localMap();

        printVertical(strs);

//        set(strs);
//        printStrs(strs);
    }

    private static void printVertical(String[][] strs) {
        Map<String, String> localMap = localMap();
        for (int i = 0; i < strs.length; i++) {
            StringBuilder sb = new StringBuilder();
            // 中文名称
            for (int j = 0; j < strs[i].length; j++) {
                String lan = strs[i][j];
                sb.append(lan).append("\n");
            }
            // 英文名称
            for (int j = 0; j < strs[i].length; j++) {
                String lan = strs[i][j];
                sb.append(localMap.get(lan)).append("\n");
            }
            sb.append("主语言 : " + strs[i][0]);
            for (int j = 1; j < strs[i].length; j++) {
                String lan = strs[i][j];
                sb.append(localMap.get(lan)).append(",");
            }

            sb.append("\n\n\n");
            System.out.println(sb);
        }
    }

    private static void trimStrs(String[][] strs) {
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length; j++) {
                strs[i][j] = strs[i][j].trim();
            }
        }
    }

    private static void printStrs(String[][] strs) {
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length; j++) {
                System.out.print(strs[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    private static Map<String, String> localMap() {
        Map<String, String> map = new HashMap<>();
        map.put("葡萄牙语（欧洲）", "pt_PT");
        map.put("西班牙语（拉丁美洲）", "es_LA");
        map.put("荷兰语", "nl");
        map.put("英文（美国）", "en_US");
        map.put("捷克语", "cs");
        map.put("意大利语", "it");
        map.put("法语（法国）", "fr");
        map.put("西班牙语(拉丁美洲）", "es_LA");
        map.put("英文（英国）", "en_GB");
        map.put("罗马尼亚语", "ro");
        map.put("法语（欧洲）", "fr_EU");
        map.put("西班牙语（欧洲）", "es");
        map.put("德语（DE）", "de");
        return map;
    }

    private static void set(String[][] strs) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length; j++) {
                set.add(strs[i][j]);
            }
        }
        System.out.println("set - > " + set);
        Iterator<String> iterator = set.iterator();
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
//        String.format("map.put(\"%s\", \"%s\");", )
        while (iterator.hasNext()) {
            String lan = iterator.next();
            System.out.println(String.format("map.put(\"%s\", \"%s\");", lan, ""));
        }
    }

    private static final class MixLanguage {
        final String main;
        final int[] mix;

        private MixLanguage(String main, int[] mix) {
            this.main = main;
            this.mix = mix;
        }
    }
}