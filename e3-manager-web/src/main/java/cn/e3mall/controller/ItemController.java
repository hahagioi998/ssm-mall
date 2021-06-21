package cn.e3mall.controller;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

/**
 * 商品管理Controller
 * <p>Title: ItemController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;


	/**
	 * 根据itemid做映射路径
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}

	/**
	 * 查询商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		//调用服务查询商品列表
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	/**
	 * 新增商品
	 * @param tbItem
	 * @param desc
	 * @return
	 */
	@RequestMapping(value = "/item/save",method = RequestMethod.POST)
	@ResponseBody
	public E3Result addItem(TbItem tbItem,String desc){
		E3Result e3Result = itemService.addItem(tbItem, desc);
		return e3Result;
	}

	/**
	 * 编辑商品功能-根据ID从数据库表TbItem表查询一条数据
	 * @param id
	 * @return
	 */
	@RequestMapping("/rest/item/param/item/query/{id}")
	@ResponseBody
	public TbItem queryById(@PathVariable long id){
		TbItem item = itemService.getItemById(id);
		//System.out.println("方法被调用-TbItem");
		return item;
	}

	/**
	 * 异步重新加载回显描述-编辑商品接口-查询商品描述
	 * @param id
	 * @return
	 */
	@RequestMapping("/rest/item/query/item/desc/{id}")
	@ResponseBody
	public TbItemDesc selectTbItemDesc(@PathVariable long id){
		TbItemDesc itemDesc = itemService.selectTbItemDesc(id);
		//System.out.println("方法被调用-TbItemDesc");
		return itemDesc;
	}

	/**
	 * 商品编辑功能
	 * @param item
	 * @param desc
	 * @return
	 */
	@RequestMapping(value = "/rest/item/update",method = RequestMethod.POST)
	@ResponseBody
	public E3Result update(TbItem item,String desc){
	    E3Result  e3Result = itemService.update(item,desc);
	    return e3Result;
	}

	/**
	 * 批量删除商品功能
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/item/delete",method = RequestMethod.POST)
	@ResponseBody
	public E3Result deleteByIds(String ids){
	   E3Result result = itemService.deleteBatch(ids);
	   return result;
	}

	/**
	 * 批量商品id下架
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/item/instock",method = RequestMethod.POST)
	@ResponseBody
	public E3Result updateByShelves(String ids){
		E3Result result = itemService.updateByShelves(ids);
		return result;
	}


	/**
	 * 批量商品id上架
	 * @param ids
	 * @return
	 */
	@RequestMapping("/item/reshelf")
	@ResponseBody
	public E3Result updateByinstock(String ids){
	  E3Result  result = itemService.updateByinstock(ids);
	  return result;
	}

}
