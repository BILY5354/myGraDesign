package com.cduy.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分类选项
 * @author CDUY
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryOptionDTO {
    /**
     * 分类id
     */
    private Integer id;

    /**
     * 分类名
     */
    private String categoryName;
}
