package com.js.deploy;

import javax.swing.*;
import java.io.*;

/**
 * @Name MakeGoOnlineResources
 * @date 2019/7/17
 * @dateTime 18:28
 * @description: 源代码
 */
public class MakeGoOnlineResources {

    private boolean ifAnOtherPathHead;
    private String webInfoPath;


    public void createGoOnline() throws IOException {


        try (FileInputStream fis = new FileInputStream(getResourcesFile());
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr);
        ) {

            String tmp;

            while ((tmp = br.readLine()) != null) {

                tmp = tmp.trim();
                if ("".equals(tmp)) {
                    continue;
                }
                if (!tmp.contains("/") && !tmp.contains("\\")) {
                    continue;
                }
                if (tmp.trim().startsWith("#")) {
                    continue;
                }


                doCreateGoOnline(
                        toCorrectPath(getResourcesRootPath() + "/" + tmp)
                        , toCorrectPath(getProjectPath() + "/" + tmp)
                );

            }

        }


    }

    private void doCreateGoOnline(String onlinePath, String projectPath) throws IOException {


        File onlineFile = new File(onlinePath);
        File projectFile = getProject(projectPath);

        onlineFile.mkdirs();


        if (projectFile.isFile()) {
            fileHandler(onlineFile, projectFile);
        } else {
            File[] files = getFileList(projectFile);
            for (File file : files) {
                doCreateGoOnline(
                        toCorrectPath(onlineFile.getPath() + "/" + file.getName())
                        , file.getPath());
            }

        }

    }

    private File getProject(String projectPath) {
        projectPath = handlerWebInfo(projectPath);
        return new File(projectPath);
    }

    private String handlerWebInfo(String projectPath) {
        if (!ifAnOtherPathHead) {
            return projectPath;
        }
        if (projectPath.contains("WEB-INF")) {
            projectPath = toCorrectPath(webInfoPath + "/" + projectPath.substring(projectPath.indexOf("WEB-INF")  ));
        }
        return projectPath;
    }

    private File[] getFileList(File projectFile) {
        File[] files = projectFile.listFiles();

        alarm(projectFile.getPath(), files);
        return files;
    }

    private void alarm(String filePath, File[] files) {
        if (files == null) {
            JOptionPane.showMessageDialog(null, filePath, "o(╥﹏╥)o 主人出错啦~~~", 0);

            throw new RuntimeException("ths obj files is null , maybe is the file path error");
        }
    }

    private void fileHandler(File onlineFile, File projectFile) throws IOException {
        System.out.println(" now file name is " + onlineFile.getName());
        if (onlineFile.isDirectory()) {
            onlineFile.delete();
        }
        onlineFile.createNewFile();
        try (FileInputStream fis = new FileInputStream(projectFile);
             BufferedInputStream br = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream(onlineFile);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {

            byte[] bytes = new byte[1024 * 4];
            int i;
            while ((i = br.read(bytes, 0, bytes.length)) != -1) {
                bos.write(bytes, 0, i);
                bos.flush();
            }
        }
    }

    public void setWebInfoPath(String webInfoPath) {
        this.ifAnOtherPathHead = true;
        this.webInfoPath = toCorrectPath(webInfoPath);
    }

    public File getResourcesFile() {
        return resourcesFile;
    }

    public void setResourcesFile(File resourcesFile) {
        this.resourcesFile = resourcesFile;
    }

    public String getResourcesRootPath() {
        return resourcesRootPath;
    }

    public void setResourcesRootPath(String resourcesRootPath) {
        this.resourcesRootPath = toCorrectPath(resourcesRootPath);
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = toCorrectPath(projectPath);
    }

    public void setResourcesFile(String filePath) {
        this.resourcesFile = new File(getPathname(filePath, "源码清单.txt"));
    }

    public void setResourcesFile(String filePath, String fileName) {
        this.resourcesFile = new File(getPathname(filePath, fileName));
    }

    private String getPathname(String filePath, String defaultFileName) {
        return toCorrectPath(filePath +"/"+ defaultFileName);
    }

    public String toCorrectPath(String path) {
        return path.replaceAll("\\\\+", "/").replaceAll("/+", "/");
    }


    /**
     * 清单文件所在
     * private File resourcesFile = new File("D:/project/1) 南粤-官网项目资料/上线材料/" + GoOnlinePackageName + "/上线流程材料/源码清单.txt");
     */
    private File resourcesFile;
    /**
     * 文件copy的目的地
     * private String resourcesRootPath = "D:/project/1) 南粤-官网项目资料/上线材料/" + GoOnlinePackageName + "/上线流程材料/源码包/ezsite/";
     */
    private String resourcesRootPath;

    /**
     * 部署测试资源路径
     * private String projectPath = "D:/project/ezsite_fund_upgrade_20200826/ezsite/";
     */
    private String projectPath;
}
