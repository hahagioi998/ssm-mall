package cn.e3mall.pagehelper;


import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PageHelperTest {

    @Test
    public void testPageHelper() throws Exception{
        //初始化spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        //从容器中获取mapper代理对象
        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
        //执行SQL语句之前设置分页信息使pagehelper的start方法执行
        PageHelper.startPage(1,10);
        //执行查询只对一个查询生效，在需要分页在使用start方法
        TbItemExample example = new TbItemExample();
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        //取分页信息pageinfo类可以取到总记录数，总页数，当前页码，每页显示记录数
        PageInfo<TbItem> pageInfo = new PageInfo(tbItems);
        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println(pageInfo.getList());
    }
}
