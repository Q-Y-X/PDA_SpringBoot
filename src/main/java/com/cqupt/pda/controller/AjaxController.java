package com.cqupt.pda.controller;

import com.cqupt.pda.bean.CancelTask;
import com.cqupt.pda.bean.GenAgvSchedulingTask;
import com.cqupt.pda.bean.QueryAgvStatus;
import com.cqupt.pda.bean.QueryTaskStatus;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: Jack Lu
 * @Date: 2022/5/24 18:26
 */
@Slf4j
@Controller
public class AjaxController {
    private String Mission1="W";
    private String AGV1="W";

    private String Mission2="W";
    private String AGV2="W";

    private String Mission3="W";
    private String AGV3="W";

    @ResponseBody
    @PostMapping("/ajax")
    public String Ajaxcontr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mission = request.getParameter("mission");
        String agv = request.getParameter("agv");
        if ( mission!=null && agv!=null ){
//            348
            if (agv.equals("Q2-1")){
                this.AGV1="Q21";
                this.Mission1=mission;
//                105
            }else if (agv.equals("Q2-2")){
                this.AGV2="Q22";
                this.Mission2=mission;
//                789
            }else if (agv.equals("Q2-3")){
                this.AGV3="Q23";
                this.Mission3=mission;
            }
        }
        //注意，当mission和agv字段全为有值的情况下才能进行

        Properties properties = new Properties();
        InputStream resourceAsStream = AjaxController.class.getClassLoader().getResourceAsStream("agv.properties");
        String agvCode = null;
        properties.load(resourceAsStream);
        if (agv != null) {
            agvCode = properties.getProperty(agv);
        }
        String jsonProperties = properties.getProperty(mission);
        Gson gson = new Gson();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssS");
        long times = System.currentTimeMillis() + new Random().nextInt(9999999);
        String dateString = format.format(times);
//        String dateString = str.substring(0, 15);
        switch (mission){
            case "1":
            case "2":
            case "3":
            case "4":
                GenAgvSchedulingTask missionEntity = gson.fromJson(jsonProperties, GenAgvSchedulingTask.class);
                missionEntity.setReqCode(dateString);
//                missionEntity.setAgvCode(agvCode);
                //                response.getWriter().print(missionJson);
                return gson.toJson(missionEntity);
            case "5":
                QueryTaskStatus queryTaskStatus = gson.fromJson(jsonProperties, QueryTaskStatus.class);
                String taskCodes = request.getParameter("taskCodes");
                String[] strings = taskCodes.split(",");
                List<String> taskList = new ArrayList<>();
                for (String string : strings) {
                    String replace = string.replace("\"", "").replace("[", "").replace("]", "");
                    taskList.add(replace);
                }
                queryTaskStatus.setReqCode(dateString);
                queryTaskStatus.setTaskCodes(taskList);
                //                response.getWriter().print(missionQuery);
                return gson.toJson(queryTaskStatus);
            case "6":
                CancelTask task2 = gson.fromJson(jsonProperties, CancelTask.class);
                task2.setReqCode(dateString);
                task2.setAgvCode(agvCode);
                //                response.getWriter().print(jsonString2);
                return gson.toJson(task2);
            case "7":
                GenAgvSchedulingTask mission7 = gson.fromJson(jsonProperties, GenAgvSchedulingTask.class);
                mission7.setReqCode(dateString);
                mission7.setAgvCode(agvCode);
                //                response.getWriter().print(missionJson7);
                return gson.toJson(mission7);
            case "8":
                QueryAgvStatus queryAgvStatus = gson.fromJson(jsonProperties, QueryAgvStatus.class);
                queryAgvStatus.setReqCode(dateString);
                //                response.getWriter().print(mission8);
                return gson.toJson(queryAgvStatus);
            default:
                return null;
        }

    }

    @ResponseBody
    @PostMapping("/selectAgv1")
    public String selectAgv1() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = AjaxController.class.getClassLoader().getResourceAsStream("agv.properties");
        properties.load(resourceAsStream);
        String jsonProperties = properties.getProperty("11");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssS");
        long times = System.currentTimeMillis() + new Random().nextInt(9999999);
        String dateString = format.format(times);
        Gson gson = new Gson();
        GenAgvSchedulingTask missionEntity = gson.fromJson(jsonProperties, GenAgvSchedulingTask.class);
        missionEntity.setReqCode(dateString);
        return gson.toJson(missionEntity);
    }

    @ResponseBody
    @PostMapping("/selectAgv2")
    public String selectAgv2() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = AjaxController.class.getClassLoader().getResourceAsStream("agv.properties");
        properties.load(resourceAsStream);
        String jsonProperties = properties.getProperty("11");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssS");
        long times = System.currentTimeMillis() + new Random().nextInt(9999999);
        String dateString = format.format(times);
        Gson gson = new Gson();
        GenAgvSchedulingTask missionEntity = gson.fromJson(jsonProperties, GenAgvSchedulingTask.class);
        missionEntity.setReqCode(dateString);
        return gson.toJson(missionEntity);
    }

    @ResponseBody
    @PostMapping("/selectAgv3")
    public String selectAgv3() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = AjaxController.class.getClassLoader().getResourceAsStream("agv.properties");
        properties.load(resourceAsStream);
        String jsonProperties = properties.getProperty("11");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssS");
        long times = System.currentTimeMillis() + new Random().nextInt(9999999);
        String dateString = format.format(times);
        Gson gson = new Gson();
        GenAgvSchedulingTask missionEntity = gson.fromJson(jsonProperties, GenAgvSchedulingTask.class);
        missionEntity.setReqCode(dateString);
        return gson.toJson(missionEntity);
    }

    @ResponseBody
    @PostMapping("/agvBack")
    public String agvBack() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = AjaxController.class.getClassLoader().getResourceAsStream("agv.properties");
        properties.load(resourceAsStream);
        String jsonProperties = properties.getProperty("11");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssS");
        long times = System.currentTimeMillis() + new Random().nextInt(9999999);
        String dateString = format.format(times);
        Gson gson = new Gson();
        GenAgvSchedulingTask missionEntity = gson.fromJson(jsonProperties, GenAgvSchedulingTask.class);
        missionEntity.setReqCode(dateString);
        return gson.toJson(missionEntity);
    }


    @ResponseBody
    @PostMapping("/new1")
    public String newPapper1(){
        return this.AGV1 + "-" + this.Mission1;
    }

    @ResponseBody
    @PostMapping("/new2")
    public String newPapper2(){
        return this.AGV2 + "-" + this.Mission2;
    }

    @ResponseBody
    @PostMapping("/new3")
    public String newPapper3(){
        return this.AGV3 + "-" + this.Mission3;
    }

    @ResponseBody
    @PostMapping("/newer1")
    public void newPapper1(@RequestParam("flag") String flag){
        if ("stop".equals(flag)){
            this.AGV1="W";
            this.Mission1="W";
        }
    }

    @ResponseBody
    @PostMapping("/newer2")
    public void newPapper2(@RequestParam("flag") String flag){
        if ("stop".equals(flag)){
            this.AGV2="W";
            this.Mission2="W";
        }
    }

    @ResponseBody
    @PostMapping("/newer3")
    public void newPapper3(@RequestParam("flag") String flag){
        if ("stop".equals(flag)){
            this.AGV3="W";
            this.Mission3="W";
        }
    }


}
