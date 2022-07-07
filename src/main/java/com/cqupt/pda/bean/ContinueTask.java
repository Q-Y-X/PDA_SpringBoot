package com.cqupt.pda.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: Jack Lu
 * @Date: 2022/5/24 18:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContinueTask {
    private String reqCode;
    private String reqTime;
    private String clientCode;
    private String tokenCode;
    private String wbCode;
    private String podCode;
    private String agvCode;
    private String taskCode;
    private String taskSeq;
    private NextPositionCode nextPositionCode;
}
