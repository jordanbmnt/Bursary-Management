package com.bbd.bursary.manager.repository;
import java.util.List;
public interface UserInterface {
    List create(User user);
    int save(User user);

    int update(User user);

    User findById(Long id);

    int deleteById(Long id);

    List<User> findAll();

}
