package com.cqupt.pda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


/**
 * description: MaterialController <br>
 * date: 2022/6/29 15:58 <br>
 * author: Sora <br>
 * version: 1.0 <br>
 *
 * @author Sora
 */
@Slf4j
@Controller
public class MaterialController {

    String[] materials = new String[3];
    public static final String CLEAR = "clear";


    @ResponseBody
    @PostMapping("/judge")
    public void material(@RequestParam(value = "taskNumber[]") Integer[] taskNumber,
                         @RequestParam(value = "task1", required = false) String[][] map1,
                         @RequestParam(value = "task2", required = false) String[][] map2,
                         @RequestParam(value = "task3", required = false) String[][] map3,
                         @RequestParam(value = "task4", required = false) String[][] map4) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = MaterialController.class.getClassLoader().getResourceAsStream("material.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("请求进来了!");
        StringBuilder builder;
        for (int i = 0; i < taskNumber.length; i++) {
            switch (taskNumber[i]) {
                case 1:
                    log.info("map1");
                    builder = new StringBuilder();
                    mapToMaterial(map1, properties, builder);
                    materials[i] = builder.toString();
                    break;
                case 2:
                    log.info("map2");
                    builder = new StringBuilder();
                    mapToMaterial(map2, properties, builder);
                    materials[i] = builder.toString();
                    break;
                case 3:
                    log.info("map3");
                    builder = new StringBuilder();
                    mapToMaterial(map3, properties, builder);
                    materials[i] = builder.toString();
                    break;
                case 4:
                    log.info("map4");
                    builder = new StringBuilder();
                    mapToMaterial(map4, properties, builder);
                    materials[i] = builder.toString();
                    break;
                default:
                    break;
            }
            log.info(Arrays.toString(materials));
        }
    }

    /**
     * TODO 提取数组获取原料信息
     *
     * @param map
     * @param properties
     * @param builder
     */
    private void mapToMaterial(String[][] map, Properties properties, StringBuilder builder) {
        for (String[] s : map) {
            for (String s1 : s) {
                if (s1.length() > 7) {
                    log.info(s1.replace("[", "").replace("\"", "").substring(5));
                    builder.append(properties.getProperty(s1.replace("[", "").replace("\"", "").substring(5)));
                    log.info("进入方法体");
                }
            }
        }
    }

    @ResponseBody
    @PostMapping("/pad1")
    public String newPaper1() {
        return materials[0];
    }

    @ResponseBody
    @PostMapping("/pad2")
    public String newPaper2() {
        return materials[1];
    }

    @ResponseBody
    @PostMapping("/pad3")
    public String newPaper3() {
        return materials[2];
    }

    @ResponseBody
    @PostMapping("/padStop1")
    public void newPaper1(@RequestParam("flag") String flag) {
        if (CLEAR.equals(flag)) {
            materials[0] = null;
        }
    }

    @ResponseBody
    @PostMapping("/padStop2")
    public void newPaper2(@RequestParam("flag") String flag) {
        if (CLEAR.equals(flag)) {
            materials[1] = null;
        }
        log.info(Arrays.toString(materials));
    }

    @ResponseBody
    @PostMapping("/padStop3")
    public void newPaper3(@RequestParam("flag") String flag) {
        if (CLEAR.equals(flag)) {
            materials[2] = null;
        }
    }

}
