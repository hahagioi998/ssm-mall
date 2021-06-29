package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbContent;

/**
 * 内容服务
 */
public interface ContentService {

    EasyUIDataGridResult getItemList(Long categoryId, Integer page, Integer rows);

    E3Result addContent(TbContent content);

    E3Result editContent(TbContent content);

    TbContent selectByidContent(Long id);

    E3Result deleteBatchContent(String[] ids);

    List<TbContent> getContentListByCid(long cid);

}
