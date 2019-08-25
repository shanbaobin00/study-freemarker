package com.eric.controller;

import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shanbb
 * @description 自定义指令类
 * 通过实现freemarker中的TemplateDirectiveModel接口，并重写execute方法
 * @date 2019-08-24
 */
@Service
public class RoleDirectiveModel implements TemplateDirectiveModel {

    /**
     *
     * @param environment
     * @param map
     * @param templateModels
     * @param templateDirectiveBody
     * @throws TemplateException
     * @throws IOException
     */
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        System.out.println("===========");
        TemplateScalarModel user = (TemplateScalarModel) map.get("user");
        TemplateScalarModel role = (TemplateScalarModel) map.get("role");

        if("123456".equals(user.getAsString()) && "admin".equals(role.getAsString())){
            templateModels[0] = TemplateBooleanModel.TRUE;
        }
        List<String> otherRights = new ArrayList<>();
        otherRights.add("add");
        otherRights.add("delete");
        otherRights.add("update");

        templateModels[1] = new SimpleSequence(otherRights);

        templateDirectiveBody.render(environment.getOut());
    }
}
