package org.example.hong.service;

import org.example.hong.dto.UserAddDto;
import org.example.hong.entity.User;
import org.example.hong.vo.UserVo;

import java.util.List;

public interface UserService {
    public void   addUser(UserAddDto dto);
    public void  updateUser(UserVo vo);
    public void  deleteUser(int id);
    public UserVo getUser(int id);
    public List<UserVo> getUsers();
    public List<UserVo> asyncConvert(List<User> list);
    public void asyncProcess(List<Integer> ids);
    public UserVo convert(User user);
    public User revert(UserAddDto dto);

}
