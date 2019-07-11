package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;

@RequestMapping("/user")
@RestController
public class MongoDBController {
	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping("/saveUser")
	public String saveUser(User user) {
		this.mongoTemplate.save(user);
		return "新增成功！";
	}
	@RequestMapping("/getUserByUserName")
	public String getUserByUserName(String username) {
		Query query = new Query(Criteria.where("username").is(username));
		List<User> user = this.mongoTemplate.find(query, User.class);
		return user.toString();
	}
	@RequestMapping("/updateUser")
	public String updateUser(User user) {
		Query query = new Query(Criteria.where("username").is(user.getUsername()));
		Update update= new Update().set("age", user.getAge()).set("sex", user.getSex());
		this.mongoTemplate.updateFirst(query, update, User.class);
		return "修改成功！";
	}
	@RequestMapping("/deleteUser")
	public String deleteUser(String username) {
		Query query = new Query(Criteria.where("username").is(username));
		this.mongoTemplate.remove(query, User.class);
		return "删除成功！";
	}

}
