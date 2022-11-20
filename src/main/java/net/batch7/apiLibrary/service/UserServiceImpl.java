package net.batch7.apiLibrary.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.batch7.apiLibrary.model.dto.ResponseData;
import net.batch7.apiLibrary.model.dto.UserDto;
import net.batch7.apiLibrary.model.entity.DetailUser;
import net.batch7.apiLibrary.model.entity.User;
import net.batch7.apiLibrary.repository.DetailUserRepository;
import net.batch7.apiLibrary.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private DetailUserRepository detailUserRepository;

  private ResponseData<Object> responseData;
  private User user;
  private DetailUser detailUser;
  private Map<Object, Object> data;

  @Override
  public ResponseData<Object> register(UserDto request) {
    // TODO Auto-generated method stub
    // check user apakah usernya ini udh terdaftar atau belum, check emailnya
    // select * from users where email = ?
    Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
    if (userOpt.isPresent()) {
      responseData = new ResponseData<Object>(HttpStatus.BAD_REQUEST.value(), "User is found, please login!", null);
    } else {
      user = new User(request.getEmail(), request.getPassword());
      // save to db
      userRepository.save(user);

      detailUser = new DetailUser(request.getFirstName(), request.getLastName(), request.getPhoneNumber());
      detailUser.setUser(user);
      detailUserRepository.save(detailUser);

      // data spesific yg dikirim
      data = new HashMap<>();
      data.put("email", user.getEmail());
      data.put("firstName", detailUser.getFirstName());
      data.put("lastName", detailUser.getLastName());
      data.put("phoneNumber", detailUser.getPhoneNumber());

      // response
      responseData = new ResponseData<Object>(HttpStatus.CREATED.value(), "Success registerd", data);
    }
    return responseData;
  }

  @Override
  public ResponseData<Object> login(UserDto request) {
    // TODO Auto-generated method stub
    // check user
    Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
    if (userOpt.isPresent()) {
      user = userOpt.get();

      if (request.getPassword().equals(user.getPassword())) {
        // data spesific
        data = new HashMap<>();
        data.put("email", user.getEmail());

        // response data
        responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Success login.", data);
      } else {
        responseData = new ResponseData<Object>(HttpStatus.BAD_REQUEST.value(), "Wrong password", null);
      }

    } else {
      responseData = new ResponseData<Object>(HttpStatus.BAD_REQUEST.value(), "User is not found, please register",
          null);
    }
    return responseData;
  }

  @Override
  public ResponseData<Object> updateDetailUser(UserDto request) {
    // TODO Auto-generated method stub
    // cari user yg mau kita update detailnya
    Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
    // cek user ada atau tidak
    if (userOpt.isPresent()) {
      user = userOpt.get();
      // cari data detailnya
      Optional<DetailUser> detailOpt = detailUserRepository.findByUser(user);
      // cek ada atau tidak detailnya
      if (detailOpt.isPresent()) {
        detailUser = detailOpt.get();
        // update
        detailUser.setFirstName(request.getFirstName());
        detailUser.setLastName(request.getLastName());
        detailUser.setPhoneNumber(request.getPhoneNumber());
        // save
        detailUserRepository.save(detailUser);
      } else {
        detailUser = new DetailUser(request.getFirstName(), request.getLastName(), request.getPhoneNumber());
        detailUser.setUser(user);
        // save
        detailUserRepository.save(detailUser);
      }

      // data
      data = new HashMap<>();
      data.put("firstName", detailUser.getFirstName());
      data.put("lastName", detailUser.getLastName());
      data.put("phoneNumber", detailUser.getPhoneNumber());

      // response data
      responseData = new ResponseData<Object>(HttpStatus.OK.value(), "Success updated", data);

    } else {
      responseData = new ResponseData<Object>(HttpStatus.NOT_FOUND.value(), "User is not found", null);
    }
    return responseData;
  }

}
