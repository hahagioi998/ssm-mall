package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;

/**
 * 内容分类管理服务
 */
public interface ContentCategoryService {

    /**
     * 获取内容分类管理列表
     * @param parentId
     * @return
     */
    List<EasyUITreeNode> getContentCatList(long parentId);

    /**
     * 添加内容分类管理节点
     * @param parentId
     * @param name
     * @return
     */
    E3Result addContentCategory(long parentId,String name);
    /**
     * 删除内容分类管理节点
     * @param id
     * @return
     */
    E3Result deleteById(Long id);
    /**
     * 重命名节点名
     * @param id 节点id
     * @param name 节点名
     * @return
     */
    E3Result editContentCategoryName(long id, String name);
}
