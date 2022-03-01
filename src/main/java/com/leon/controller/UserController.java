package com.leon.controller;

import com.leon.model.SysUser;
import com.leon.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/select")
    public ModelAndView selectUser() throws Exception {
        ModelAndView mv = new ModelAndView();
        SysUser user = sysUserService.getOneById(1);
        mv.addObject("user", user);
        mv.setViewName("user");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add() throws Exception {
        SysUser user = sysUserService.getOneById(1);
        user.setId(null);
        user.setUsername("测试回滚");
        sysUserService.insert(user);
        return "新增成功";
    }
}
