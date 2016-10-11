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

package com.siemens.dasheng.web.service;

import com.github.pagehelper.PageHelper;
import com.siemens.dasheng.web.mapper.UsersMapper;
import com.siemens.dasheng.web.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzh
 * @since 2016-01-31 21:42
 */
@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public List<Users> getAll(Users users) {
        if (users.getPage() != null && users.getRows() != null) {
            PageHelper.startPage(users.getPage(), users.getRows(), "id");
        }
        return usersMapper.selectAll();
    }

    /**
     * 获取普通用户列表
     * @return
     */
    public List<Users> getAllCommonUsers(){
        List<Users> allUsers = usersMapper.selectAll();
        List<Users> returnUsers = new ArrayList<>();
        for (Users allUser : allUsers) {
            if (allUser.getUsertype()==2){
                returnUsers.add(allUser);
            }
        }
        return returnUsers;
    }

    /**
     * 获取管理员用户列表
     * @return
     */
    public List<Users> getAllAdminUsers(){
        List<Users> allUsers = usersMapper.selectAll();
        List<Users> returnUsers = new ArrayList<>();
        for (Users allUser : allUsers) {
            if (allUser.getUsertype()==0||allUser.getUsertype()==1){
                returnUsers.add(allUser);
            }
        }
        return returnUsers;
    }

    public Users getById(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        usersMapper.deleteByPrimaryKey(id);
    }

    public void saveOrUpdate(Users users) {
        if (users.getId() != null) {
            usersMapper.updateByPrimaryKey(users);
        } else {
            usersMapper.insert(users);
        }
    }
}
