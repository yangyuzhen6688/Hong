package org.example.hong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.hong.dao.UserMapper;
import org.example.hong.dto.UserAddDto;
import org.example.hong.entity.User;
import org.example.hong.service.UserService;
import org.example.hong.vo.UserVo;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public UserVo getUser(int id) {
        return null;
    }

    @Override
    public List<UserVo> getUsers() {
        return Collections.emptyList();
    }

    @Override
    public void addUser(UserAddDto dto) {

    }

    @Override
    public List<UserVo> asyncConvert(List<User> list) {
        return Collections.emptyList();
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void updateUser(UserVo vo) {

    }

    @Override
    public void asyncProcess(List<Integer> ids) {

    }

    public UserVo convert(User user){
        UserVo userVo=new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return userVo;
    }
    public User revert(UserAddDto dto){
        User user=new User();
        BeanUtils.copyProperties(dto,user);
        return user;
    }
}
