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
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CancelTask {
    private String reqCode;
    private String reqTime;
    private String clientCode;
    private String tokenCode;
    private String forceCancel;
    private String matterArea;
    private String agvCode;
    private String taskCode;
}
