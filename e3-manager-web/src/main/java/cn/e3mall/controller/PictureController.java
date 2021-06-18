package cn.e3mall.controller;

import cn.e3mall.common.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 图片上传Controller
 * @author liulei
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/pic")
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;
    @RequestMapping("/upload")
    @ResponseBody
    public Map uploadFile(MultipartFile uploadFile) throws Exception{
       try{
           //1.把图片上传到图片服务器
           FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
           //取出文件扩展名
           String originalFilename = uploadFile.getOriginalFilename();
           String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
           //2.得到一个图片的地址和文件名
           String url = fastDFSClient.uploadFile(uploadFile.getBytes(), substring);
           //3.补充为完整的url
           url = IMAGE_SERVER_URL+url;
           //4.封装到map中返回
           Map result = new HashMap();
           result.put("error",0);
           result.put("url",url);
           return result;
       }catch (Exception e){
           Map result = new HashMap();
           result.put("error",1);
           result.put("message","图片上传失败");
           throw new RuntimeException(e);
       }
    }
}
