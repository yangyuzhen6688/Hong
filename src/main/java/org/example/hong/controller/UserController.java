package org.example.hong.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hong.common.Result;
import org.example.hong.dto.UserAddDto;
import org.example.hong.entity.User;
import org.example.hong.service.UserService;
import org.example.hong.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/user")
@Tag(name = "用户管理")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Operation(summary = "根据用户ID查询")
    @GetMapping("/{id}")
    public Result<UserVo> getUserById(@PathVariable Integer id){
        return Result.sucess(userService.getUser(id));
    }
    @Operation(summary = "添加用户")
    @PostMapping("/add")
    public Result<?> add(@RequestBody @Valid UserAddDto dto){
        userService.addUser(dto);
        return Result.sucess();
    }
    @Operation(summary = "更新用户")
    @PutMapping("/update")
    public Result<?> update(@RequestBody @Valid UserAddDto dto){
        userService.updateUser(dto);
        return Result.sucess();
    }
    @Operation(summary = "删除用户")
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestBody Integer id){
        userService.deleteUser(id);
        return Result.sucess();
    }
    @Operation(summary = "查询全部用户")
    @GetMapping("/list")
    public Result<List<UserVo>> getUserList(){
        return Result.sucess(userService.getUsers());
    }
    @Operation(summary = "异步批量查询用户")
    @PostMapping("/async")
    public Result<?> getUsersListById(@RequestBody List<Integer> ids){
        userService.asyncProcess(ids);
        return Result.sucess();
    }
}
