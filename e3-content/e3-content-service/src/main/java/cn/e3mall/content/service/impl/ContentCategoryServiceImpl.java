package cn.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;
import cn.e3mall.pojo.TbContentCategoryExample.Criteria;

/**
 * 内容分类管理Service
 * <p>Title: ContentCategoryServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {


		// 根据parentid查询子节点列表

		//设置查询条件
		//执行查询
		//转换成EasyUITreeNode的列表

			//添加到列表



		//创建一个tb_content_category表对应的pojo对象
		//设置pojo的属性
		//1(正常),2(删除)
		//默认排序就是1
		//新添加的节点一定是叶子节点
		//插入到数据库
		//判断父节点的isparent属性。如果不是true改为true
		//根据parentid查询父节点
			//更新到数数据库
		//返回结果，返回E3Result，包含pojo


}
