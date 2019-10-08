package com.shareinfo.service.impl;

import com.shareinfo.dao.UserInfoDao;
import com.shareinfo.entity.User;
import com.shareinfo.dao.UserDao;
import com.shareinfo.entity.UserInfo;
import com.shareinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxx
 * */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * find user by userId
     *
     * @Description find user by userId
     * @param id user's id
     * @return if dao is success return user else throw error
     * */
    @Override
    public User findUserById(Integer id) {
        User user = userDao.findUserById(id);
        if(user == null) {
            throw new RuntimeException("不存在该用户！！！");
        } else {
            return user;
        }
    }

    /**
     * find all user
     *
     * @Description find all user
     * @param void
     * @return if dao is success return userList else throw error
     * */
    @Override
    public List<UserInfo> findAll() {
        System.out.println("业务层。查询所有用户信息");
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        for (User user:userDao.findAll()) {
            userInfos.add(userInfoDao.getUserInfoById(user.getId()));
        }
        return userInfos;
    }


    /**
     * Verify Register
     *
     * @Description Verify Register
     * @param user user's object
     * @return if dao is success return true else throw error
     * */
    @Override
    public String VerifyRegister(User user) {
        System.out.println("业务层。校验用户登录信息中。。。");
        if (user.getUserName() != null && !"".equals(user.getUserName())) {
            //先判断用户信息是否存在 若不存在直接抛出错误信息
            if (userDao.findUserByName(user.getUserName()) == null) {
                throw new RuntimeException("用户名不存在！！！");
            }
            User euser = userDao.findUserByName(user.getUserName());
            String userName = euser.getUserName();
            String password = euser.getPassword();
            Integer id = euser.getId();

            if (user.getUserName().equals(euser.getUserName())) {
                if (user.getPassword().equals(euser.getPassword())) {
                    //密码正确
                    user.setId(id);
                    return "1";
                } else {
                    //密码错误
                    throw new RuntimeException("密码错误！！！");
                }
            } else {
                //用户名不存在
                throw new RuntimeException("用户名不存在！！！");
            }
        } else {
            //用户名为空
            throw new RuntimeException("用户名为空！！！");
        }

    }


    /**
     * find userName whether or not exist
     *
     * @Description find userName whether or not exist
     * @param user user's object
     * @return if dao is success return true else throw error
     * */
    @Override
    public User UserNameExist(String userName) {
        User user = userDao.findUserByName(userName);
        if (user != null) {
            throw new RuntimeException("用户名已经存在！！！");
        }
        return user;
    }

    /**
     * find user by userName
     *
     * @Description find user by userName
     * @param userName user's name
     * @return if dao is success return user else throw error
     * */
    @Override
    public User findUserByName(String userName) {

        if (userDao.findUserByName(userName) == null) {
            throw new RuntimeException("该用户不存在！！！");
        } else {
            return userDao.findUserByName(userName);
        }
    }

    /**
     * add user
     *
     * @Description add user
     * @param user user's object
     * @return if dao is success return user else throw error
     * */
    /**
     * 用户注册模块的service层实现
     * 对数据进行再次的检查 防止插入空数据
     * */
    @Override
    public User register(User user) {

        if(user.getUserName()==null || "".equals(user.getUserName())){
            throw new RuntimeException("用户名不能为空！！！");
        }else if (userDao.findUserByName(user.getUserName()) != null){
            throw new RuntimeException("用户名已经存在！！！");
        }
        int i = userDao.saveUser(user);
        int insertUserInfoNum = userInfoDao.insertNullUserInfo(user.getId());
        System.out.println(i);
        //如果没有插入 则直接抛出异常 由统一的异常处理模块 将错误信息抛到前端
        if(i<=0 || insertUserInfoNum <= 0){
            throw new RuntimeException("数据库修改失败！！！");
        }
        return userDao.findUserByName(user.getUserName());
    }

    /**
     * modify user password
     *
     * @Description modify user password
     * @param user user's object
     * @return if dao is success return user else throw error
     * */
    @Override
    public User passwordChange(User user) {

        User u = userDao.findUserByName(user.getUserName());
        if (u == null){
            throw new RuntimeException("可能无该用户信息！！！");
        }
        if (!(u.getPassword().equals(user.getPassword()))){
            throw new RuntimeException("用户密码输入错误！！！");
        }
        int i = userDao.updateUser(user);
        if (i<=0){
            throw new RuntimeException("数据库修改失败！！！");
        }
        return userDao.findUserByName(user.getUserName());
    }

}
