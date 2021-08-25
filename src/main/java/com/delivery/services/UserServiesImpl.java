package com.delivery.services;

import com.delivery.domain.Address;

import com.delivery.domain.Role;
import com.delivery.domain.User;
import com.delivery.dto.*;
import com.delivery.exeption.BRSException;
import com.delivery.exeption.EntityType;
import com.delivery.exeption.ExceptionType;
import com.delivery.maper.BusinessMapper;
import com.delivery.respositories.AddressRepository;
//import com.delivery.respositories.PersonalCabinetRepository;
import com.delivery.respositories.RoleRepository;
import com.delivery.respositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

import static com.delivery.exeption.EntityType.USER;
import static com.delivery.exeption.ExceptionType.ENTITY_NOT_FOUND;

@Component
public class UserServiesImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BusinessMapper businessMapper;
    //@Autowired
   // private PersonalCabinetRepository cabinetRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public UserDto signup(UserSignUpRequest userSignUpRequest) {
        UserDto userDto = businessMapper.toUserDto(userSignUpRequest);
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userDto.getRoles().add(new RoleDto(0, "customer"));
        //   userDto.setUserCabinet(new PersonalCabinetDTO(0, new ArrayList<>(), new TreeSet<>()));

        User currentUser = businessMapper.toUserEntity(userDto);
        addressRepository.save(currentUser.getAddress());
        //  cabinetRepository.save(currentUser.getUserCabinet());

        currentUser = userRepository.save(currentUser);
        System.out.println(currentUser);

        return businessMapper.toUserDto(currentUser);
    }

    @Override
    public UserDto findUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {
            return businessMapper.toUserDto(user.get());
        }
        throw exception(USER, ENTITY_NOT_FOUND, email);
    }

    @Override
    public UserDto findById(int id) {
        Optional<User> user = userRepository.findById(id);

        return businessMapper.toUserDto(user.get());
    }

    @Override
    public UserDto updateProfile(UserDto userDto) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));
        if (user.isPresent()) {
            User userModel = user.get();
            userModel.setFirstName(userDto.getFirstName())
                    .setLastName(userDto.getLastName());

            return businessMapper.toUserDto(userRepository.save(userModel));
        }
        throw exception(USER, ENTITY_NOT_FOUND, userDto.getEmail());
    }

    @Override
    public UserDto changePassword(UserDto userDto, String newPassword) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));
        if (user.isPresent()) {
            User userModel = user.get();
            userModel.setPassword(bCryptPasswordEncoder.encode(newPassword));
            return businessMapper.toUserDto(userRepository.save(userModel));
        }
        throw exception(USER, ENTITY_NOT_FOUND, userDto.getEmail());
    }

    @Override
    public void deleteById(int id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.deleteById(id);
    }

    //    @Override
//    public UserDto signIn(UserSignIn userSignIn) {
//        UserDto userDto = businessMapper.toUserDto(userSignIn);
//        userSignIn.setEmail(userDto.getEmail());
//        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//        return null;
//    }

    @Override
    public List<UserDto> usersAll() {
        return businessMapper.userDtoList(userRepository.findAll());
    }

    private RuntimeException exception(EntityType entityType, ExceptionType exceptionType, String... args) {
        return BRSException.throwException(entityType, exceptionType, args);
    }

}
