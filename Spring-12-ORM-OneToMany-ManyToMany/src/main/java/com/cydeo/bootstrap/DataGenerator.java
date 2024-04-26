package com.cydeo.bootstrap;

import com.cydeo.enums.Status;
import com.cydeo.model.*;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {
    private final PaymentRepository paymentRepository;
    private final MerchantRepository merchantRepository;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository, CustomerRepository customerRepository, CartRepository cartRepository, ItemRepository itemRepository) {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Merchant merchant1=new Merchant("AmazonSubMerchant", "M123", new BigDecimal("0.25"), new BigDecimal("3.25"), 5) ;
        merchantRepository.save(merchant1);

        Customer customer1=new Customer("Customer Address", "customer@email", "First", "Last", "username");
        customerRepository.save(customer1);


        Item item1 = new Item("I01", "First");
        Item item2 = new Item("I02", "Second");
        Item item3 = new Item("I03", "Third");
        Item item4 = new Item("I04", "Fourth");


        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        cart1.setItemList(Arrays.asList(item1, item2, item3));
        cart2.setItemList(Arrays.asList(item4, item2, item3));


        cartRepository.save(cart1);
        cartRepository.save(cart2);


        Payment payment1=new Payment(LocalDate.of(2022,4,19), new BigDecimal("150000"), Status.SUCCESS);
        PaymentDetail paymentDetail1=new PaymentDetail(new BigDecimal("140000"), new BigDecimal("10000"), LocalDate.of(2022,04,24));
        payment1.setPaymentDetail(paymentDetail1);
        payment1.setMerchant(merchant1);
        payment1.setCustomer(customer1);
        payment1.setCart(cart2);

        Payment payment2=new Payment(LocalDate.of(2022,4,25), new BigDecimal("100000"), Status.FAILURE);
        PaymentDetail paymentDetail2=new PaymentDetail(new BigDecimal("90000"), new BigDecimal("5000"), LocalDate.of(2022,04,29));
        payment2.setPaymentDetail(paymentDetail2);
        payment2.setMerchant(merchant1);
        payment2.setCustomer(customer1);
        payment2.setCart(cart1);



        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

    }
}
