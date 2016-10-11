/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.siemens.dasheng.web.controller;

import com.siemens.dasheng.web.model.Users;
import com.siemens.dasheng.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzh
 * @since 2015-12-19 11:10
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;


    /*@RequestMapping
    public PageInfo<Users> getAll(Users users) {
        List<Users> usersList = usersService.getAll(users);
        return new PageInfo<>(usersList);
    }*/


    @RequestMapping(value = "/all/{userType}")
    public List<Users> getAll(@PathVariable Integer userType){
        if (userType==0||userType==1){//超级管理员和普通管理员列表
            return usersService.getAllAdminUsers();
        }else if (userType==2){//普通用户列表
            return usersService.getAllCommonUsers();
        }else{
            return new ArrayList<>();
        }
    }

    /**
     * 查询单个用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/view/{id}")
    public Users view(@PathVariable Integer id) {
        Users userInfo = usersService.getById(id);
        return userInfo;
    }

    /**
     * 删除单个用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public ModelMap delete(@PathVariable Integer id) {
        ModelMap result = new ModelMap();
        usersService.deleteById(id);
        result.put("msg", "删除成功!");
        return result;
    }

    /**
     * 新增或者更新用户信息
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap saveOrUpdate(Users userInfo) {

        ModelMap result = new ModelMap();
        String msg = userInfo.getId() == null ? "新增成功!" : "更新成功!";

        usersService.saveOrUpdate(userInfo);
        result.put("userInfo", userInfo);
        result.put("msg", msg);

        return result;

    }
}