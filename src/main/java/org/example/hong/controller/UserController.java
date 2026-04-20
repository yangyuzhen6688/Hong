package org.example.hong.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.hong.common.Result;
import org.example.hong.dto.UserAddDto;
import org.example.hong.entity.User;
import org.example.hong.service.UserService;
import org.example.hong.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
@Api(tags="用户管理")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ApiOperation("根据用户ID查")
    @GetMapping("/{id}")
    public Result<UserVo> getUserById(@PathVariable Integer id){
        return Result.sucess(userService.getUser(id));
    }
    @ApiOperation("添加用户")
    @PostMapping("/add")
    public Result<?> add(UserAddDto dto){
        userService.addUser(dto);
        return Result.sucess();
    }
    @ApiOperation("更新用户")
    @PutMapping("/update")
    public Result<?> update(UserAddDto dto){
        userService.updateUser(dto);
        return Result.sucess();
    }
    @ApiOperation("删除用户")
    @DeleteMapping("/delete")
    public Result<?> delete(Integer id){
        userService.deleteUser(id);
        return Result.sucess();
    }
    @ApiOperation("查询全部")
    @GetMapping("/list")
    public Result<List<UserVo>> getUserList(){
        return Result.sucess(userService.getUsers());
    }
    @ApiOperation("异步批量查询用户")
    @PostMapping("/async")
    public Result<?> getUsersListById(List<Integer> ids){
        userService.asyncProcess(ids);
        return Result.sucess();
    }
}
