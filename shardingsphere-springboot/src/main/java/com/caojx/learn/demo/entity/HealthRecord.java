package com.caojx.learn.demo.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 注释
 *
 * @author caojx
 * @date 2022-06-26 22:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthRecord {

    private Long recordId;

    private Long userId;

    private Long levelId;

    private String remark;
}
