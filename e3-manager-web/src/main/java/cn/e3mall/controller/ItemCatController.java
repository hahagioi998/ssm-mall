package cn.e3mall.controller;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品分类管理controller
 */
@RestController
@SuppressWarnings("all")
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    /**
     * 调用服务查询节点列表
     * @param parentId
     * @return
     */
    @RequestMapping("/list")
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id" , defaultValue = "0") Long parentId){
            //调用服务查询节点列表
            List<EasyUITreeNode> itemCatList = itemCatService.getItemCatlist(parentId);
            return itemCatList;
    }

}
