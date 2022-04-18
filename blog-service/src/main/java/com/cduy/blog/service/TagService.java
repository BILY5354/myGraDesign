package com.cduy.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cduy.blog.dto.TagBackDTO;
import com.cduy.blog.dto.TagDTO;
import com.cduy.blog.entity.Tag;
import com.cduy.blog.vo.ConditionVO;
import com.cduy.blog.vo.PageResult;
import com.cduy.blog.vo.TagVO;

import java.util.List;

/**
 * 标签服务
 * @author CDUY
 * @version 1.0
 */
public interface TagService extends IService<Tag> {
    /**
     * 查询标签列表
     *
     * @return 标签列表
     */
    PageResult<TagDTO> listTags();

    /**
     * 查询后台标签
     *
     * @param condition 条件
     * @return {@link PageResult<TagBackDTO>} 标签列表
     */
    PageResult<TagBackDTO> listTagBackDTO(ConditionVO condition);

    /**
     * 搜索文章标签
     *
     * @param condition 条件
     * @return {@link List <TagDTO>} 标签列表
     */
    List<TagDTO> listTagsBySearch(ConditionVO condition);

    /**
     * 删除标签
     *
     * @param tagIdList 标签id集合
     */
    void deleteTag(List<Integer> tagIdList);

    /**
     * 保存或更新标签
     *
     * @param tagVO 标签
     */
    void saveOrUpdateTag(TagVO tagVO);
}
