package com.staroot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.staroot.mybatis.domain.User;
import com.staroot.mybatis.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JpaTests {
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void book_save_test() {
        final User user = new User();
        user.setUserId("hellouser");
        user.setPassword("password");
        user.setName("HELOO");
        user.setEmail("HELOO@gmail.com");
        final User saveUser = userRepository.save(user);
        final User findUser = userRepository.findById(saveUser.getId()).get();
        System.out.println("findUser.getUserId ::"+findUser.getUserId());
        System.out.println("findUser.getName ::"+findUser.getName());
        System.out.println("findUser.getEmail ::"+findUser.getEmail());
        assertThat(findUser.getUserId(),is("hellouser"));
    }
    /*
    @Test
    public void book_save_and_find() {
        final Book book = new Book("title", 1000D);
        final Book saveBook = bookRepository.save(book);
        final Book findBook = bookRepository.findById(saveBook.getId()).get();
        assertThat(findBook.getId(), is(notNullValue()));
    }
    */
}