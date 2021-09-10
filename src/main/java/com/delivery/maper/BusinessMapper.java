package com.delivery.maper;

import com.delivery.domain.*;
import com.delivery.dto.*;
import com.delivery.respositories.RoleRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class BusinessMapper {
    @Resource
    RoleRepository roleRepository;

    public UserDto toUserDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setPhoneNumber(user.getPhoneNumber())
                .setEmail(user.getEmail())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .setAddressDto(user.getAddress())
                .setRoles(user.getRoles().stream().map(r -> toRoleDto(r)).collect(Collectors.toList()))
                .setBillDtos(user.getBills().stream().map(this::toBillDto).collect(Collectors.toSet()))
               .setOrderDtos(user.getOrders().stream().map(this::toOrderDto).collect(Collectors.toSet()));
               // .setDeliveryCardDto(toDeliveryCardDto(user.getDeliveryCard()));

    }

    public User toUserEntity(UserDto user) {


        return new User()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setPhoneNumber(user.getPhoneNumber())
                .setAddress(toAddressEntity(user.getAddressDto()))
                .setRoles(user.getRoles().stream().map(roleDto -> roleRepository.findByRole(roleDto.getRole())).collect(Collectors.toList()))
                .setBills(user.getBillDtos().stream().map(this::toBillEntity).collect(Collectors.toSet()))
                .setOrders(user.getOrderDtos().stream().map(this::toOrderEntity).collect(Collectors.toSet()));
               //.setDeliveryCard(toDeliveryCardEntity(user.getDeliveryCardDto()));


    }

    public AddressDto toAddressDto(Address address) {
        return new AddressDto()
                .setId(address.getId())
                .setCity(address.getCity())
                .setStreet(address.getStreet())
                .setNumberBranch(address.getNumberBranch());


    }

    public Address toAddressEntity(AddressDto address) {
        return new Address()
                .setId(address.getId())
                .setCity(address.getCity())
                .setStreet(address.getStreet())
                .setNumberBranch(address.getNumberBranch());


    }

    public BaggageDto toBaggageDto(Baggage baggage) {
        return new BaggageDto()
                .setB_id(baggage.getB_id())
                .setHeight(baggage.getHeight())
                .setLength(baggage.getLength())
                .setName_Baggage(baggage.getName_Baggage())
                .setWeight(baggage.getWeight())
                .setWidth(baggage.getWidth());
    }

    public Baggage toBaggageEntity(BaggageDto baggage) {
        return new Baggage()
                .setB_id(baggage.getB_id())
                .setHeight(baggage.getHeight())
                .setLength(baggage.getLength())
                .setName_Baggage(baggage.getName_Baggage())
                .setWeight(baggage.getWeight())
                .setWidth(baggage.getWidth());
    }
//    public List<BaggageDto> toBaggageDtoList(List<Baggage>baggagesDtoToEntinies){
//
//        List<BaggageDto>baggageList = new ArrayList<>();
//
//        for (int i = 0; i< baggagesDtoToEntinies.size(); i++) {
//              baggageList.add(toBaggageDto(baggagesDtoToEntinies.get(i)));
//        }
//            return baggageList;
//    }
//    public List<Baggage> toBaggageList(List<BaggageDto> baggageDtos){
//        List<Baggage>baggageList = new ArrayList<>();
//
//        for (int i=0;i<baggageDtos.size(); i++){
//          baggageList.add(toBaggageEntity(baggageDtos.get(i)));
//        }
//        return baggageList;
//    }

    public DeliveryCard toDeliveryCardEntity(DeliveryCardDto cardDto) {
        return new DeliveryCard()
                .setId(cardDto.getId())
                .setBaggages(baggagesDtoToEntinies(cardDto.getBaggageDtos()));
    }

    public DeliveryCardDto toDeliveryCardDto(DeliveryCard card) {
        return new DeliveryCardDto()
                .setId(card.getId())
                .setBaggageDtos(baggageDtoList(card.getBaggages()));
    }


    public BillDto toBillDto(Bill bill) {
        return new BillDto()
                .setId(bill.getId())
                .setNumber(bill.getNumber())
                .setAmountToPay(bill.getAmountToPay())
                .setPaymentSystem(bill.getPaymentSystem())
                .setPayed(bill.isPayed());
    }

    public Bill toBillEntity(BillDto bill) {
        return new Bill()
                .setId(bill.getId())
                .setNumber(bill.getNumber())
                .setAmountToPay(bill.getAmountToPay())
                .setPaymentSystem(bill.getPaymentSystem())
                .setPayed(bill.isPayed());
    }

//    public PersonalCabinetDTO toPersonCabinetDto(PersonalCabinet personalCabinet) {
//        return new PersonalCabinetDTO()
//                .setId(personalCabinet.getId());
//       // .setBills(personalCabinet.getBills().stream().map(this::toBillDto).collect(Collectors.toSet()))
//        //.setOreders(personalCabinet.getOreders().stream().map(this::toOrderDto).collect(Collectors.toList()));
//    }

    //    public List<BillDto> getbillDtoList(List<Bill> bilils){
//        List<BillDto> billList = new ArrayList<>();
//        for (int i=0;i< bilils.size();i++)
//            billList.add(toBillDto(bilils.get(i)));
//        return billList;
//    }
//    public List<Bill> getBillList(List<BillDto> billDtoList){
//        List<Bill> billList = new ArrayList<>();
//        for (int i=0; i<billList.size(); i++){
//           Bill bill= toBillEntity(billDtoList.get(i));
//           billList.add(bill);
//
//        }
//        return billList;
//    }
//    public PersonalCabinet toPersonCabinetEntity(PersonalCabinetDTO personalCabinet) {
//        return new PersonalCabinet()
//                .setId(personalCabinet.getId());
//
//        //.setOreders(personalCabinet.getOreders().stream().map(this::toOrderEntity).collect(Collectors.toList()));
//    }

    public PaymentDto toPaymentDto(Payment payment) {
        return new PaymentDto()
                .setId(payment.getId())
                .setCheckingAccount(payment.getCheckingAccount())
                .setNamePayment(payment.getNamePayment());
    }

    public Payment toPaymentEntity(PaymentDto payment) {
        return new Payment()
                .setId(payment.getId())
                .setCheckingAccount(payment.getCheckingAccount())
                .setNamePayment(payment.getNamePayment());
    }

    public RoutesDto toRoutesDto(Routes routes) {
        return new RoutesDto()
                .setNumber(routes.getNumber())
                .setDistance(routes.getDistance())
                .setDuration(routes.getDuration())
                .setFromAddress(routes.getFromAddress())
                .setToAddress(routes.getToAddress());
    }

    public Routes toRoutesEntity(RoutesDto routes) {
        return new Routes()
                .setNumber(routes.getNumber())
                .setDistance(routes.getDistance())
                .setDuration(routes.getDuration())
                .setFromAddress(toAddressEntity(routes.getFromAddress()))
                .setToAddress(toAddressEntity(routes.getToAddress()));
    }

    public OrderDto toOrderDto(Order order) {
        return new OrderDto()
                .setId(order.getId())
                .setNumberOrder(order.getNumberOrder())
                .setBaggages(order.getBaggages().stream().map(this::toBaggageDto).collect(Collectors.toList()))
                .setDelivery_time(order.getDelivery_time())
                .setShippet_time(order.getShippet_time())
                .setRoute(toRoutesDto(order.getRoute()))
                .setOrder_price(order.getOrder_price());
    }

    public Order toOrderEntity(OrderDto order) {
        return new Order()
                .setId(order.getId())
                .setNumberOrder(order.getNumberOrder())
                .setBaggages(order.getBaggages().stream().map(this::toBaggageEntity).collect(Collectors.toList()))
                .setDelivery_time(order.getDelivery_time())
                .setShippet_time(order.getShippet_time())
                .setRoute(toRoutesEntity(order.getRoute()))
                .setOrder_price(order.getOrder_price());
    }

    //    public List<OrderDto> getOrderDtoList(List<Order> orders){
//        List<OrderDto> orderDtoList = new ArrayList<>();
//        for (int i = 0; i< orders.size(); i++){
//            orderDtoList.add(toOrderDto(orders.get(i)));
//        }
//        return orderDtoList;
//    }
//    public List<Order>getOrderList(List<OrderDto> orderDtoList){
//        List<Order> orders = new ArrayList<>();
//        for (int i = 0; i< orderDtoList.size(); i++){
//            orders.add(toOrderEntity(orderDtoList.get(i)));
//        }
//        return orders;
//    }
    public RoleDto toRoleDto(Role role) {
        return new RoleDto()
                .setId(role.getId())
                .setRole(role.getRole());
    }

    public Role toRoleEntity(RoleDto role) {
        Role current = roleRepository.findByRole(role.getRole());
        return current;
    }

    public UserDto toUserDto(UserSignUpRequest userSignUpRequest) {
        return new UserDto()
                .setFirstName(userSignUpRequest.getFirstName())
                .setLastName(userSignUpRequest.getLastName())
                .setPassword(userSignUpRequest.getFirstPassword())
                .setPhoneNumber(userSignUpRequest.getPhone())
                .setEmail(userSignUpRequest.getEmail())
                .setAddressDto(new AddressDto(0, "", "", 0))
                .setBillDtos(new TreeSet<>())
                .setOrderDtos(new TreeSet<>())
                .setDeliveryCardDto(new DeliveryCardDto(0,new HashSet<>()));

    }

    public List<UserDto> userDtoList(List<User> userList) {
        List<UserDto> userDtos = new ArrayList<>();
        return userList.stream().map(user -> toUserDto(user)).collect(Collectors.toList());
    }

    public Set<OrderDto> orderDtoSet(Set<Order> orders) {
        return orders.stream().map(order -> toOrderDto(order)).collect(Collectors.toSet());
    }

    public Set<BillDto> billDtoList(Set<Bill> bills) {
        return bills.stream().map(bill -> toBillDto(bill)).collect(Collectors.toSet());
    }

    public Set<Baggage> baggagesDtoToEntinies(Set<BaggageDto> baggage) {
        return baggage.stream().map(this::toBaggageEntity).collect(Collectors.toSet());
    }

    public Set<BaggageDto> baggageDtoList(Set<Baggage> baggages) {
        return baggages.stream().map(this::toBaggageDto).collect(Collectors.toSet());
    }

}

