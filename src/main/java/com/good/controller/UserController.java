package com.good.controller;

import com.good.model.User;
import com.good.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by dai on 2017/2/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "showUser";
    }

    @RequestMapping("/{userId}")
    public ModelAndView showDetail(@PathVariable("userId") long userId){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/showDetail");
        mav.addObject("user",userService.getUserById(userId));
        return mav;
    }

    @RequestMapping("/rp")
    public ModelAndView showDetail2(@RequestParam(value="userId",required = false) long userId){
        log.info("根据userId查询用户信息");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/showDetail2");
        mav.addObject("user",userService.getUserById(userId));
        return mav;
    }

    @RequestMapping(value="/showUserById",method = GET)
    public String showUserById(@RequestParam("userId") long userId,Model model){
        model.addAttribute("oneuser",userService.getUserById(userId));
        return "user/showUserById";
    }



}
