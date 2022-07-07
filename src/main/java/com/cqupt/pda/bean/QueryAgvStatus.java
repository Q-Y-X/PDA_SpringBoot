package com.cqupt.pda.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: Jack Lu
 * @Date: 2022/5/24 18:21
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QueryAgvStatus {
    private String reqCode;

    private String reqTime;

    private String clientCode;

    private String tokenCode;

    private String mapShortName;
}
