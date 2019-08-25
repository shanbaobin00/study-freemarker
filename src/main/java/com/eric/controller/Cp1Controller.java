package com.eric.controller;

import com.eric.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * @author shanbb
 * @description
 * @date 2019-08-24
 */
@Controller
@RequestMapping("/")
public class Cp1Controller {

    @RequestMapping(value = "/cp1")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("cp1");
        mv.addObject("intVar",100);
        mv.addObject("longVar",10000);
        mv.addObject("stringVar","我是字符串");
        mv.addObject("doubleVar",3.45d);
        mv.addObject("booleanVar",true);
        mv.addObject("dateVar",new Date());
        mv.addObject("nullVar",null);

        User user = new User();
        user.setName("freemarker");
        user.setBrief("<font color='red'>我只想早点下班。对不起，你是程序员！</font>");
        mv.addObject("userObj", user);

        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("python");
        list.add("nodejs");
        mv.addObject("myList", list);

        Map<String,String> map = new HashMap<>();
        map.put("java","hello java");
        map.put("python","hello python");
        map.put("nodejs","hello nodejs");
        mv.addObject("myMap",map);

        //将我们自定义的排序函数传入mv中给freemarker使用
        mv.addObject("sort_int", new SortMethod());

        return mv;
    }


}
