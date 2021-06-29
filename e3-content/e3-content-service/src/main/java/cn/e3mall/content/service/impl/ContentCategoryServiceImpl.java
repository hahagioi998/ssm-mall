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

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<EasyUITreeNode> getContentCatList(long parentId) {

        // 根据parentid查询子节点列表
        TbContentCategoryExample example = new TbContentCategoryExample();
        //设置查询条件
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbContentCategory> tbContentCategories = contentCategoryMapper.selectByExample(example);
        //转换成EasyUITreeNode的列表
        List<EasyUITreeNode> easyUIList = new ArrayList<>();
        for (TbContentCategory tbContentCategory : tbContentCategories) {
             EasyUITreeNode uiTreeNode = new EasyUITreeNode();
             uiTreeNode.setId(tbContentCategory.getId());
             uiTreeNode.setText(tbContentCategory.getName());
             uiTreeNode.setState(tbContentCategory.getIsParent()?"closed":"open");
            //添加到列表
            easyUIList.add(uiTreeNode);
        }
        return easyUIList;
    }

    @Override
    public E3Result addContentCategory(long parentId, String name) {
        //创建一个tb_content_category表对应的pojo对象
        TbContentCategory contentCategory = new TbContentCategory();
        //设置pojo的属性
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        //1(正常),2(删除)
        contentCategory.setStatus(1);
        contentCategory.setParentId(parentId);
        //默认排序就是1
        contentCategory.setSortOrder(1);
        contentCategory.setName(name);
        //新添加的节点一定是叶子节点
        contentCategory.setIsParent(false);
        //插入到数据库
        contentCategoryMapper.insert(contentCategory);
        //判断父节点的isparent属性。如果不是true改为true
        //根据parentid查询父节点
        TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
        if (!parent.getIsParent()){
            //更新到数数据库
            parent.setIsParent(true);
            contentCategoryMapper.updateByPrimaryKey(parent);
        }
        //返回结果，返回E3Result，包含pojo
        return E3Result.ok(contentCategory);
    }

    @Override
    public E3Result deleteById(Long id) {
        //删除节点时需要判断是否有子节点
        //痛id查询内容节点并且获取到父节点
        TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
        //获取父id
        Long parentId = contentCategory.getParentId();
        //如果是父节点删除失败
        if (contentCategory.getIsParent()){
            return E3Result.build(1,"失败");
        }else {
            contentCategoryMapper.deleteByPrimaryKey(id);
            TbContentCategoryExample example =new TbContentCategoryExample();
            Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentId);
            List<TbContentCategory> childes = contentCategoryMapper.selectByExample(example);
            if (childes.size()==0){
                //判断父节点的isParent属性是否为true如果不是就修改为true
                TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
                if (parent.getIsParent()){
                    parent.setIsParent(false);
                    //更新到数据库
                    contentCategoryMapper.updateByPrimaryKey(parent);
                }
            }
        }
        return E3Result.ok(contentCategory);
    }

    @Override
    public E3Result editContentCategoryName(long id, String name) {
        //通过id查询
        TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
        //设置查询到的内容节点名称为修改名称
        contentCategory.setName(name);
        //执行修改
        contentCategoryMapper.updateByPrimaryKey(contentCategory);
        //返回状态
        return E3Result.ok();
    }


}
