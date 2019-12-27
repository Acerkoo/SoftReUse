package com.demo.controller;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserMapper userMapper;


    /**
     * 跳转到index.jsp
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    /**
     * 显示全部用户信息
     * @return
     */
    @RequestMapping("all")
    public List<User> All() {
        List<User> list = userMapper.getAll();
        return list;
    }

    /**
     * 添加用户
     * @param username
     * @param email
     * @param password
     * @param user
     * @return
     */
    @RequestMapping("add")
    public @ResponseBody String addNewUser (@RequestParam("username") String username
            , @RequestParam String email, @RequestParam String password, User user) {
        // @ResponseBody means the returned String is a response, not a view name.
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userMapper.insert(user);

        return "Add Success";
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @param model
     * @return
     */

    @RequestMapping("login")
    public @ResponseBody String login(@RequestParam String username,
                                      @RequestParam String password, Model model) {
        List<User> userlist = userMapper.getByName(username);
        if(userlist == null) {
            return "用户不存在";
        } else {
            User user = userlist.get(0);
            if (user.getPassword().equals(password)) {
                return "Username: " + user.getUsername() + "\n email: " + user.getEmail();
            } else {
                return "Logging failed";
            }
        }
    }

    @RequestMapping("del")
    public @ResponseBody String delete(@RequestParam String username, @RequestParam String password) {
        List<User> userlist = userMapper.getByName(username);
        if(userlist == null) {
            return "用户不存在";
        } else {
            User user = userlist.get(0);
            userMapper.delete(user);
            if (user.getPassword().equals(password)) {
                return "Username: " + user.getUsername() + " delete success";
            } else {
                return "delete failed";
            }
        }

    }
}
