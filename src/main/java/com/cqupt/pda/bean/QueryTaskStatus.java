package com.cqupt.pda.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Author: Jack Lu
 * @Date: 2022/5/24 18:22
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QueryTaskStatus {
    private String reqCode;
    private String reqTime;
    private String clientCode;
    private String tokenCode;
    private String agvCode;
    private List<String> taskCodes;
}
