package com.example.technikonproject.repository;

import com.example.technikonproject.domain.WebUser;
import com.example.technikonproject.domain.subDomain.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class WebUserRepositoryTest {

    @Autowired
    private  WebUserRepository webUserRepository;

    private  final Address address = new Address(
            1L,
            "stname",
            123,
            12345
    );
    private final WebUser webUser = new WebUser(1L,
            "a",
            "b",
            address,
            203959,
            "email",
            "uname",
            "pass"
    );

    @Test
    void itShouldCheckIfWebUserExistsByEmailAndReturnHim() {
        //given
        webUserRepository.save(webUser);
        //when
        WebUser exists = webUserRepository.readWebUserByEmail(webUser.getEmail());
        //then
        assertEquals(exists.getEmail(), webUser.getEmail());
    }

    @Test
    void seeIfReadWebUserByFirstNameFindsIdenticalNamesInDb(){
        //given
        webUserRepository.save(webUser);
        WebUser webUser2 = webUser;
        webUser2.setTin(2L);
        webUserRepository.save(webUser2);
        //when
        List<WebUser> webUsers = webUserRepository.readWebUserByFirstName(webUser.getFirstName());
        //then
        assertAll(
                () -> assertFalse(webUsers.isEmpty()),
                () -> assertEquals(webUsers.get(0).getFirstName(), webUsers.get(1).getFirstName())
        );

    }

    @Test
    void readWebUserByTin(){
        webUserRepository.save(webUser);
        WebUser webUserNew = webUserRepository.readWebUserByTin(1L);
        assertNotNull(webUserNew);
    }

//    @Test
//    void checkIfWebUserEmailIsUpdatedInTheDB(){
//        //given
//        webUserRepository.save(webUser);
//        //when
//        WebUser exists = webUserRepository.findById(webUser.getTin()).orElseThrow(() -> new RuntimeException("Error"));
//        exists.setEmail("thisismynewemail@");
//        webUserRepository.save(exists);
//        WebUser webUserUpdated = webUserRepository.findById(webUser.getTin()).orElseThrow(() -> new RuntimeException("Error"));
//        //then
//        assertNotEquals(webUser.getEmail(), webUserUpdated.getEmail());
//    }


}