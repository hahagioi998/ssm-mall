package cn.e3mall.controller;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SuppressWarnings("all")
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 通过分类id分页显示数据
     * @param categoryId
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/content/query/list")
    @ResponseBody
    public EasyUIDataGridResult list(Long categoryId,Integer page,Integer rows){
        //调用内容服务查询指定内容
        EasyUIDataGridResult result = contentService.getItemList(categoryId,page,rows);
        return result;
    }
    /**
     * 添加内容功能实现
     * @param content
     * @return
     */
    @RequestMapping("/content/save")
    @ResponseBody
    public E3Result addContent(TbContent content){
        //调用内容服务添加内容
        E3Result result=contentService.addContent(content);
        return result;
    }
    /**
     *修改内容功能实现
     * @auther: jun
     * @date: 2018/6/3 0003 13:34
     * @param content
     * @return: com.e3mall.common.utils.E3Result
     * @Description:
     */
    @RequestMapping("/rest/content/edit")
    @ResponseBody
    public E3Result editContent(TbContent content){
        //调用服务修改内容
        E3Result result= contentService.editContent(content);
        return result;
    }
    /**
     * 异步重新回显内容数据
     * @return
     */
    @RequestMapping("/query/content/{id}")
    @ResponseBody
    public TbContent selectContent(@PathVariable Long id){
        TbContent result=contentService.selectByidContent(id);
        return result;
    }
    /**
     * 删除内容信息
     * @param ids
     * @return
     */
    @RequestMapping("/content/delete")
    @ResponseBody
    public E3Result deleteContent(String [] ids){
        E3Result result=contentService.deleteBatchContent(ids);
        return result;
    }
}
