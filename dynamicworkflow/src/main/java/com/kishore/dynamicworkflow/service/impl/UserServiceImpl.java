package com.kishore.dynamicworkflow.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kishore.dynamicworkflow.bean.UserBean;
import com.kishore.dynamicworkflow.model.User;
import com.kishore.dynamicworkflow.repository.UserRepository;
import com.kishore.dynamicworkflow.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserBean> getAllUsers() {
		List<UserBean> userBeanList = new ArrayList<>();
		
		List<User> userList = userRepository.findAll();
		
		if (userList != null) {
			userList.forEach(user -> {
				UserBean userBean = new UserBean();
				userBean.setUserId(user.getId());
				userBean.setName(user.getName());
				
				userBeanList.add(userBean);
			});
		}
		
		return userBeanList;
	}

	
	
}
