package com.delivery;

import com.delivery.domain.*;

import com.delivery.respositories.AddressRepository;
import com.delivery.respositories.DeliveryCardRepository;
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
import java.util.HashSet;
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
        AddressRepository addressRepository;

        @Autowired
        DeliveryCardRepository deliveryCardRepository;


        @Resource
        BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        public void run(String... args) throws Exception {
            Role role = new Role(0, "admin");
            Role role1 = new Role(0, "user");
            Role role2 = new Role(0, "customer");
            roleRepository.save(role);
            roleRepository.save(role1);
            roleRepository.save(role2);

            Address address = new Address(0, "Dnepr", "Nmaar", 2);
            addressRepository.save(address);

            DeliveryCard deliveryCard = new DeliveryCard();
            deliveryCardRepository.save(deliveryCard);


            User user = new User(0, "Sidorov", "Petr", "380664123587", "sidorov@gmail.com", bCryptPasswordEncoder.encode("123"), new ArrayList<>(), address,new TreeSet<>(),new HashSet<>());
            user = userRepository.save(user);
            user.getRoles().add(role);
            System.out.println(user);
            userRepository.save(user);


            Address address1 = new Address(0, "Dnepr", "cdfdf", 3);
            addressRepository.save(address1);

            DeliveryCard deliveryCard1= new DeliveryCard();
            deliveryCardRepository.save(deliveryCard1);


            User user1 = new User(0, "Vitko", "Eduard", "97665555", "eduardvitko@gmail.com", bCryptPasswordEncoder.encode("test"), new ArrayList<>(), address1,new TreeSet<>(),new HashSet<>());
            user1 = userRepository.save(user1);
            user1.getRoles().add(role2);
            userRepository.save(user1);

        }
    }

}
