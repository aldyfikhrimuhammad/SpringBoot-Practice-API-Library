package net.batch7.apiLibrary.service;

import net.batch7.apiLibrary.model.dto.ResponseData;
import net.batch7.apiLibrary.model.dto.UserDto;

public interface UserService {
  ResponseData<Object> register(UserDto request);

  ResponseData<Object> login(UserDto request);

  ResponseData<Object> updateDetailUser(UserDto request);
}
