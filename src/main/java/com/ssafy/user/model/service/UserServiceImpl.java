package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public void regist(UserDto userDto) throws SQLException {
		userMapper.regist(userDto);
	}
	
	@Override
	public UserDto login(UserDto userDto) throws SQLException {
		return userMapper.login(userDto);
	}

	@Override
	public List<UserDto> list() {
		return userMapper.list();
	}

	@Override
	public UserDto detail(String userId) {
		return userMapper.detail(userId);
	}

	@Override
	public UserDto leave(String userId) throws SQLException {
		userMapper.leave(userId);
		return userMapper.detail(userId);
	}

	@Override
	public UserDto update(UserDto userDto) {
		userMapper.update(userDto);
		return userMapper.detail(userDto.getUserId());
	}
	
	@Override
	public UserDto userInfo(String userId) throws Exception {
		return userMapper.userInfo(userId);
	}

	@Override
	public void saveRefreshToken(String userId, String refreshToken) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userToken", refreshToken);
		userMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return userMapper.getRefreshToken(userId);
	}

	@Override
	public void deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userToken", null);
		userMapper.deleteRefreshToken(map);
	}
	
}
