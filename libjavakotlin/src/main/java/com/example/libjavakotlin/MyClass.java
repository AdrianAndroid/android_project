package com.example.libjavakotlin;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyClass {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("111", "one");
        map.put("222", "two");
        map.put("333", "three");
        map.put("one", "111");
        map.put("two", "222");
        map.put("three", "333");

        System.out.println(map);
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if ("111".equals(entry.getValue()) || "111".equals(entry.getKey())) {
                entry.setValue("");
            }
        }
        System.out.println(map);

    }

    public static void main2(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("111", "one");
        map.put("222", "two");
        map.put("333", "three");
        map.put("one", "111");
        map.put("two", "222");
        map.put("three", "333");

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(String.format("%s:%s", entry.getKey(), entry.getValue())).append(";");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static void text(String[] args) {
        String s = readCityFile();
        System.out.println(s);

        Subtype subtype = JSON.parseObject(s, Subtype.class);

        System.out.println(subtype.getSubtypeImeData().size());
        Set<String> set = new HashSet<>();
        for (Subtype.SubtypeImeDataDTO subtypeImeDatum : subtype.getSubtypeImeData()) {
            if (!set.add(subtypeImeDatum.getLocaleStr())) {
                System.out.println(subtypeImeDatum.getLocaleStr());
            }
        }
        System.out.println(set.size());

//        List<Subtype.SubtypeImeDataDTO> subtypeImeDataDTOS = JSON.parseArray(s, Subtype.SubtypeImeDataDTO.class);
//        System.out.println(subtypeImeDataDTOS.toString());
    }


    private static String readCityFile() {
        File file02 = new File("/Users/zhaojian/Documents/android_project/libjavakotlin/subtype.json");
        FileInputStream is = null;
        StringBuilder stringBuilder = null;
        try {
            if (file02.length() != 0) {
                /**
                 * 文件有内容才去读文件
                 */
                is = new FileInputStream(file02);
                InputStreamReader streamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;
                stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    // stringBuilder.append(line);
                    stringBuilder.append(line);
                }
                reader.close();
                is.close();
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(stringBuilder);

    }
}