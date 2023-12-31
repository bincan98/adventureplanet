package com.ssafy.user.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.user.model.UserDto;

@Mapper
public interface UserMapper {
	
	public void regist(UserDto userDto) throws SQLException;
	public UserDto login(UserDto userDto) throws SQLException;
	public List<UserDto> list();
	public UserDto detail(String userId);
	public void leave(String userId) throws SQLException;
	public void update(UserDto userDto);
	public void saveRefreshToken(Map<String, String> map);
	public UserDto userInfo(String userId);
	public Object getRefreshToken(String userId);
	public void deleteRefreshToken(Map<String, String> map);

}
