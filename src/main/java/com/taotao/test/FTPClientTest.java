package com.taotao.test;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Victor on 2017/6/3.
 */
public class FTPClientTest {
    //@Test
    public void testFtp() throws Exception{
        //1.连接ftp服务器
        FTPClient ftpClient=new FTPClient();
        ftpClient.connect("192.168.1.102",21);
        //2.登录ftp服务器
        ftpClient.login("dsl","325605");
        FileInputStream inputStream=new FileInputStream(new File("D:\\IntelliJ IDEA workspace\\taotao\\images\\111.png"));

        //4.上传文件
        //1)指定上传目录
        ftpClient.changeWorkingDirectory("/aworkhome/taotao/ftpuser/images");
        //指定文件类型
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        //第一个参数：文件在远程服务器的名称
        //第二个参数：文件流
        ftpClient.storeFile("hello.jpg",inputStream);
        //5.退出登录
        ftpClient.logout();
    }

    public static void main(String[] args) throws Exception {
        FTPClientTest ftpClientTest=new FTPClientTest();
        ftpClientTest.testFtp();
    }
}
