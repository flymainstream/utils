package com.js;

import com.js.deploy.MakeGoOnlineResources;

import java.io.IOException;

/**
 * @author 刘锦涛
 * @title: ApplicaitonRunning
 * @projectName deploying_help
 * @date 2021/1/15
 * @dateTime 15:57
 * @description: TODO
 */
public class ApplicationRunning {

    public static void main(String[] args) throws IOException {
        ApplicationRunning run = new ApplicationRunning();
        run.netPersonalBankOfJavaResources();
//        run.netBankOfJavaResources();
//        run.netBankOfClassesResources();
    }


    public void netBankOfJavaResources() throws IOException {

        MakeGoOnlineResources makeGoOnlineResources = new MakeGoOnlineResources();
//        源文件所在
        makeGoOnlineResources.setProjectPath("D:\\project\\3)_xxxProject\\code\\mgmt\\");
//        copy 目录
        makeGoOnlineResources.setResourcesRootPath("D:\\project\\3)_xxxProject\\05_系统上线\\09_2021年\\GoOnlineTemp\\20200115\\上线流程材料\\源码包\\");
//        资源清单
        makeGoOnlineResources.setResourcesFile("D:/project/3)_xxxProject/05_系统上线/09_2021年/GoOnlineTemp/20200115/上线流程材料");

        makeGoOnlineResources.createGoOnline();


    }

    public void netPersonalBankOfJavaResources() throws IOException {

        MakeGoOnlineResources makeGoOnlineResources = new MakeGoOnlineResources();
//        源文件所在
        makeGoOnlineResources.setProjectPath("D:\\project\\3)_xxxProject\\code\\per\\");
//        copy 目录
        makeGoOnlineResources.setResourcesRootPath("D:\\project\\3)_xxxProject\\05_系统上线\\09_2021年\\GoOnlineTemp\\20210128\\上线流程材料\\源码包\\");
//        资源清单
        makeGoOnlineResources.setResourcesFile("D:\\project\\3)_xxxProject\\05_系统上线\\09_2021年\\GoOnlineTemp\\20210128\\上线流程材料");

        makeGoOnlineResources.createGoOnline();


    }

    public void netBankOfClassesResources() throws IOException {

        MakeGoOnlineResources makeGoOnlineResources = new MakeGoOnlineResources();
//        源文件所在
        makeGoOnlineResources.setProjectPath("D:\\project\\3)_xxxProject\\code\\mgmt\\mweb-ecifmgmt\\target\\classes");
//        copy 目录
        makeGoOnlineResources.setResourcesRootPath("D:\\project\\3)_xxxProject\\05_系统上线\\09_2021年\\GoOnlineTemp\\20200115\\上线流程材料\\资源包\\");
//        资源清单
        makeGoOnlineResources.setResourcesFile("D:/project/3)_xxxProject/05_系统上线/09_2021年/GoOnlineTemp/20200115/上线流程材料", "资源清单.txt");
//        webInfo 在不同路径下
        makeGoOnlineResources.setWebInfoPath("D:\\project\\3)_xxxProject\\code\\mgmt\\mweb\\target\\mweb");

        makeGoOnlineResources.createGoOnline();


    }
}
