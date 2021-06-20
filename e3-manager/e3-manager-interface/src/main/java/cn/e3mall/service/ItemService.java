package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;

public interface ItemService {

	TbItem getItemById(long itemId);

	EasyUIDataGridResult getItemList(int page, int rows);

	E3Result addItem(TbItem item ,String  desc);

	TbItemDesc selectTbItemDesc(long id);

	E3Result update(TbItem item,String desc);

	E3Result deleteBatch(String ids);

	E3Result updateByShelves(String ids);

	E3Result updateByinstock(String ids);
}
