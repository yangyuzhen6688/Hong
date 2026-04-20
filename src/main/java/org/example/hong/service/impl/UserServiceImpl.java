package org.example.hong.service.impl;

import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.hong.constants.RedisKeyConstants;
import org.example.hong.dao.UserMapper;
import org.example.hong.dto.UserAddDto;
import org.example.hong.entity.User;
import org.example.hong.service.UserService;
import org.example.hong.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final RedisTemplate<String, Object> redisTemplate;
    public UserServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @Override
    public UserVo getUser(int id) {
        String key= RedisKeyConstants.USER_INFO_KFY+"id";
        User user = (User)redisTemplate.opsForValue().get(key);
        if(user==null){
            user=getById(id);
            redisTemplate.opsForValue().set(key,user);
        }
        return convert(user);
    }
    @Override
    public List<UserVo> getUsers() {
        try{
            CompletableFuture<List<UserVo>> future=asyncConvert(list());
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserAddDto dto) {
        save(revert(dto));
    }
    @Override
    @Async("taskExecutor")
    public CompletableFuture<List<UserVo>> asyncConvert(List<User> list) {
        List<UserVo> userVoList=new ArrayList<>();
        for(User user:list){
            userVoList.add(convert(user));
        }
        return CompletableFuture.completedFuture(userVoList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(int id) {
        String key= RedisKeyConstants.USER_INFO_KFY+"id";
        redisTemplate.delete(key);
        removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserAddDto dto) {
        updateById(revert(dto));
    }

    @Override
    @Async("taskExecutor")
    public void asyncProcess(List<Integer> ids) {
        for(Integer id:ids){
            String key= RedisKeyConstants.USER_INFO_KFY+"id";
            User user = (User)redisTemplate.opsForValue().get(key);
            if(user==null){
                user=getById(id);
                redisTemplate.opsForValue().set(key,user);
            }
            System.out.println(user.getUserName());
        }
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
    public User revertVo(UserVo vo){
        User user=new User();
        BeanUtils.copyProperties(vo,user);
        return user;
    }
}
