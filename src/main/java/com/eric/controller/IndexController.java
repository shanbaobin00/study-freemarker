package com.eric.controller;

import com.eric.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shanbb
 * @description
 * @date 2019-08-24
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("username", "你好,Freemarker!");
        mv.addObject("userList",this.prepareUserList());
        return mv;
    }

    public List<User> prepareUserList(){
        List<User> list = new ArrayList<>();
        for (int i=0; i<5; i++){
            User item = new User();
            item.setName("用户" + i);
            item.setBirthday(new Date());
            list.add(item);
        }
        return list;
    }

}
