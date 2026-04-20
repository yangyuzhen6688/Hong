package org.example.hong.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.hong.entity.User;
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
