package me.soyoungpark.nosql.mongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AccountRepositoryTest {

    @Autowired
    MongoAccountRepository accountRepository;

    @Test
    public void findByEmail() {
        Account account = new Account();
        account.setEmail("soyoungpark.me@gmail.com");
        account.setUsername("soyoung");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        assertThat(byId).isNotEmpty();

        Optional<Account> byEmail = accountRepository.findByEmail(account.getEmail());
        assertThat(byEmail).isNotEmpty();
        assertThat(byEmail.get().getUsername()).isEqualTo("soyoung");
    }

}