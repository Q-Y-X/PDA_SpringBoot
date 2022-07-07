package com.cqupt.pda.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Author: Jack Lu
 * @Date: 2022/5/24 18:19
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GenAgvSchedulingTask {
    private String reqCode;
    private String reqTime;
    private String clientCode;
    private String tokenCode;
    private String taskTyp;
    private String sceneTyp;
    private String ctnrTyp;
    private String ctnrCode;
    private String wbCode;
    private List<PositionCodePath> positionCodePath;
    private String podCode;
    private String podDir;
    private String podTyp;
    private String materialLot;
    private String priority;
    private String agvCode;
    private String taskCode;
    private String data;
}
