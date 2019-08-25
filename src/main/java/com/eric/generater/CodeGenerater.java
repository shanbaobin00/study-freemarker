package com.eric.generater;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shanbb
 * @description
 * @date 2019-08-25
 */
public class CodeGenerater {

    private static final String TEMPLATE_PATH = "ftl";
    private static final String CLASS_PATH = "src/main/java/";

    public static void main(String[] args) {

        CodeGenerater generater = new CodeGenerater();
        generater.start("com.eric.service","test");

    }


    public void start(String packageName,String ftlName){
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        Writer out = null;
        try {

            URL resource = this.getClass().getClassLoader().getResource("");

            System.out.println(resource.getPath());

            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(resource.getPath()+TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("classPath", packageName);
            dataMap.put("className", "GenerateUser");
            dataMap.put("Id", "Id");
            dataMap.put("userName", "userName");
            dataMap.put("password","password");
            // step4 加载模版文件
            Template template = configuration.getTemplate(ftlName + ".ftl");
            // step5 生成数据

            packageName = packageName.replaceAll("\\.","/");

            File directory = new File(CLASS_PATH  + packageName);
            if (!directory.exists()){
                directory.mkdirs();
            }
            File docFile = new File(CLASS_PATH  + packageName + "\\" + "GenerateUser.java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^GenerateUser.java 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
