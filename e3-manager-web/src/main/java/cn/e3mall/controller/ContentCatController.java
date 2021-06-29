package cn.e3mall.controller;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分类管理
 */
@Controller
public class ContentCatController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    /**
     * 获取内容分类管理列表
     * @param parentId
     * @return
     */
    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategory(@RequestParam(name = "id",defaultValue = "0") long parentId ){
        List<EasyUITreeNode> contentCatList = contentCategoryService.getContentCatList(parentId);
        return contentCatList;
    }
    /**
     * 添加内容分类管理节点
     * @param parentId
     * @param name
     * @return
     */
    @RequestMapping(value = "/content/category/create",method = RequestMethod.POST)
    @ResponseBody
    public E3Result createContentCategory(Long parentId,String name){
        E3Result result = contentCategoryService.addContentCategory(parentId, name);
        return result;
    }

    /**
     * 删除内容分类管理节点
     * @param id
     * @return
     */
    @RequestMapping(value = "/content/category/delete",method = RequestMethod.POST)
    @ResponseBody
    public E3Result deleteContentCategory(Long id){
        //调用服务删除节点
        E3Result result = contentCategoryService.deleteById(id);
        return result;
    }
    /**
     * 重命名节点名
     * @param id 节点id
     * @param name 节点名
     * @return
     */
    @RequestMapping("/content/category/update")
    @ResponseBody
    public E3Result editContentCategoryName(long id,String name){
        E3Result result = contentCategoryService.editContentCategoryName(id,name);
        return result;
    }
}
