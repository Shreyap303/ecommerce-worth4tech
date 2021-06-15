package com.worth4tech.ecommerce.user.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.worth4tech.ecommerce.user.pojo.User;
import com.worth4tech.ecommerce.user.repository.UserRepository;

@Repository
@Transactional
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	public User getUserInfoByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public List<User> getAllUserInfo() {
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User userInfo = getUserInfoByUserName(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		return new org.springframework.security.core.userdetails.User(userInfo.getUserName(), userInfo.getPassword(), Arrays.asList(authority));
	}

	public User getUserInfoById(Integer id) {
		return userRepository.findById(id);
	}

	public User addUser(User userRecord) {
		userRecord.setPassword(new BCryptPasswordEncoder().encode(userRecord.getPassword()));
		return userRepository.save(userRecord);
	}

	public User updateUser(Integer id, User userRecord) {
		User userInfo = userRepository.findById(id);
		userInfo.setUserName(userRecord.getUserName());
		userInfo.setPassword(userRecord.getPassword());
		userInfo.setRole(userRecord.getRole());
		return userRepository.save(userInfo);
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	public User updatePassword(Integer id, User userRecord) {
		User userInfo = userRepository.findById(id);
		userInfo.setPassword(userRecord.getPassword());
		return userRepository.save(userInfo);
	}

	public User updateRole(Integer id, User userRecord) {
		User userInfo = userRepository.findById(id);
		userInfo.setRole(userRecord.getRole());
		return userRepository.save(userInfo);
	}

}
