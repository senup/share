package com.shareinfo.web;

import com.shareinfo.entity.UserInfo;
import com.shareinfo.service.UserService;
import com.shareinfo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/user")
/**
 * @author zxx
 * */
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @Author: Deng
     * @URL： http://localhost:8080/user/userNameExist
     * @Description: 查询用户名是否存在
     * @Create time: 2019/5/15 13:39
     * @Param: username
     * @return： status{0,1}
     */
    @RequestMapping(value = "/userNameExist" , method = RequestMethod.GET)
    public Map<String , Object> UserNameExist(String userName) {
        User user = userService.UserNameExist(userName);
        Map<String , Object> modelMap = new HashMap<String, Object>();
        if(user==null){
            throw new RuntimeException("用户不存在！！！");
        } else {
            modelMap.put("status" , 1);
            return modelMap;
        }
    }

    /**
     * @Author: Deng
     * @URL： http://localhost:8080/user/findAll
     * @Description: 显示所有用户信息
     * @Create time: 2019/5/15 13:39
     * @Param: null
     * @return： list(一个status和全部data)
     */
    @RequestMapping("/findAll")
    public Map<String , Object> findAll() {
        List<UserInfo> list = userService.findAll();
        Map<String , Object> modelMap = new HashMap<String, Object>();
        if(list.isEmpty()){
            throw new RuntimeException("数据获取失败或用户信息为空！！！");
        } else {
            modelMap.put("status" , 1);
            modelMap.put("data" , list);
            return modelMap;
        }
    }

    /**
     * @Author: Deng
     * @URL： http://localhost:8080/user/login
     * @Description: 登录校验
     * @Create time: 2019/5/15 13:38
     * @Param: username,password
     * @return： status{0,1}
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String , Object> login(@RequestBody User user , HttpSession session) {
        String value = userService.VerifyRegister(user);
        Map<String , Object> modelMap = new HashMap<String, Object>();
        if(Integer.parseInt(value) == 1){
            session.setAttribute("USER_SESSION" , user);
            modelMap.put("data",user);
            modelMap.put("status" , 1);
            return modelMap;
        } else {
            throw new RuntimeException("输入数据有误无法登陆！！！");
        }

    }

    /**
     * @author zxx
     * @desciption 退出登陆
     * */
    @RequestMapping(value = "/logout")
    public Map<String , Object> logout(HttpSession session) {
        //清除session
        session.invalidate();
        Map<String , Object> modelMap = new HashMap<String, Object>();
        modelMap.put("status" , 1);
        return modelMap;
    }

    /**
     * @Author: Deng
     * @URL： http://localhost:8080/user/passwordChange
     * @Description: 用户密码更新请求
     * @Create time: 2019/5/15 15:12
     * @Param: username,password,newpassword
     * @return： status{0,1}(1的话返回用户的用户名和密码（新密码）)
     */
    @RequestMapping(value = "/passwordChange" , method = RequestMethod.POST)
    public Map<String , Object> passwordChange(@RequestBody User user){
        System.out.println("新密码 ： " + user.getNewpassword());
        Map<String , Object> modelMap = new HashMap<String, Object>();
        User u = userService.passwordChange(user);
        if(u==null){
            //抛出错误信息 提供后门 前台需要的时候可以获取 返回状态码0 前台需要也可以返回错误信息
            throw new RuntimeException("请求失败！！！");
        } else {
            modelMap.put("status" , 1);
            modelMap.put("data" , user);
            return modelMap;
        }
    }

    /**
     * @Author: Deng
     * @URL： http://localhost:8080/user/register
     * @Description: 用户注册
     * @Create time: 2019/5/15 13:54
     * @Param: username,password
     * @return： status{0,1}(若为1则发送用户全部信息)
     */
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public Map<String , Object> register(@RequestBody User user){
        Map<String , Object> modelMap = new HashMap<String, Object>();
        User u=userService.register(user);
        if(u==null){
            throw new RuntimeException("注册失败！！！");
        } else {
            modelMap.put("status" , 1);
            modelMap.put("data" , user);
            System.out.println("用户id是：" + user.getId());
            return modelMap;
        }
    }

}
