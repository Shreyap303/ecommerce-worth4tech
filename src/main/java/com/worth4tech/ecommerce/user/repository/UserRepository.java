package com.worth4tech.ecommerce.user.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.worth4tech.ecommerce.user.pojo.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUserName(String userName);

	public List<User> findAll();
	
	public User findById(int id);
	
	public void deleteById(int id);
}
