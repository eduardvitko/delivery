package com.delivery;

import com.delivery.domain.Address;
import com.delivery.domain.PersonalCabinet;
import com.delivery.domain.Role;
import com.delivery.domain.User;
import com.delivery.dto.PersonalCabinetDTO;
import com.delivery.respositories.AddressRepository;
import com.delivery.respositories.PersonalCabinetRepository;
import com.delivery.respositories.RoleRepository;
import com.delivery.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


@SpringBootApplication
public class DeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }

    @Component
    public class CommandLineAppStartupRunner implements CommandLineRunner {

        @Autowired
        UserRepository userRepository;
        @Autowired
        RoleRepository roleRepository;
        @Autowired
        PersonalCabinetRepository personalCabinetRepository;
        @Autowired
        AddressRepository addressRepository;
        @Resource
        BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        public void run(String... args) throws Exception {
            Role role = new Role(0, "admin");
            Role role1 = new Role(0, "uer");
            Role role2 = new Role(0, "customer");
            roleRepository.save(role);
            roleRepository.save(role1);
            roleRepository.save(role2);


            PersonalCabinet personalCabinet = new PersonalCabinet();
            personalCabinetRepository.save(personalCabinet);

            Address address = new Address(0, "Dnepr", "Nmaar", 2);
            addressRepository.save(address);


            User user = new User(0, "Sidorov", "Petr", "380664123587", "sidorov@gmail.com", bCryptPasswordEncoder.encode("123"), new ArrayList<>(), address, new TreeSet<>());
            user = userRepository.save(user);
            user.getRoles().add(role);
            //user.setUserCabinet(personalCabinet);
            user.setAddress(address);
            userRepository.save(user);
        }
    }

}
