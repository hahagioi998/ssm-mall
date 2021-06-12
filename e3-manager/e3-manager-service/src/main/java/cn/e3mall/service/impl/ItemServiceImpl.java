package cn.e3mall.service.impl;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p>
 * @version 1.0
 */
@Service
@SuppressWarnings("all")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;
    @Override
    public TbItem getItemById(Long itemId) {
        //根据主键查询
//        TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
        //设置查询条件
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        //执行查询
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        if (tbItems.size()>0&&tbItems!=null){
            return tbItems.get(0);
        }
        return null;
    }
}
