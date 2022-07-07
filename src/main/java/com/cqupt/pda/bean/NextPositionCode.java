package com.cqupt.pda.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: Jack Lu
 * @Date: 2022/5/24 18:20
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NextPositionCode {
    private String positionCode;
    private String type;
}
