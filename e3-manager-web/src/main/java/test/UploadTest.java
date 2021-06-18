package test;


import cn.e3mall.common.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

public class UploadTest {

    @Test
    public void test() throws Exception{
        //创建一个配置文件，文件名随意，内容就是tracker服务器地址
        //使用全局对象加载配置文件
        ClientGlobal.init("C:\\Users\\Administrator\\IdeaProjects\\mall-parent\\e3-manager-web\\src\\main\\resources\\conf\\client.conf");
        //创建一个trackerclient对象
        TrackerClient trackerClient = new TrackerClient();
        //通过trackerclient对象获取trackerserver对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //创建storageserver引用可以是null
        StorageServer storageServer = null;
        //创建一个storageclient对象参数需要trackerserver和storageserver对象
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        //使用storageclient上传对象
        String[] pngs = storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\55.jpg", "jpg", null);
        for (String png : pngs) {
            System.out.println(png);
        }
    }
    @Test
    public void testFastDFSClient() throws Exception{
        FastDFSClient fastDFSClient = new FastDFSClient("C:\\Users\\Administrator\\IdeaProjects\\mall-parent\\e3-manager-web\\src\\main\\resources\\conf\\client.conf");
        String uploadFile = fastDFSClient.uploadFile("C:\\Users\\Administrator\\Desktop\\1.jpg");
        System.out.println(uploadFile);
    }
}
