package cn.e3mall.controller;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("all")
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/{itemId}")
    public TbItem getItemById(@PathVariable Long itemId) throws Exception{
        try {
            TbItem item = itemService.getItemById(itemId);
            return item;
        }catch (Exception e){
           throw new Exception(e);
        }
    }
}
