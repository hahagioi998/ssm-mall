package cn.e3mall.publish;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPublish {

    public void publishService() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        while (true){
            Thread.sleep(1000);
        }
    }
}
