package com.akash.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.akash.bean.Users;
import com.akash.dao.UserDAOIMP;

@Controller
@RequestMapping(value="/user/")
public class UserController {
	@Autowired
	UserDAOIMP userDAOIMP;
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		List<Users> userList = userDAOIMP.getUsers();
		model.addObject("userList", userList);
		return model;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		ModelAndView model = new ModelAndView("redirect:/user/");
		int i = userDAOIMP.deleteUser(id);
		if(i > 0) {
			model.addObject("e", i);
		} else {
			model.addObject("e", i);
		}
		return model;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveorupdate(@ModelAttribute("user") Users user) throws DataAccessException, Exception {
		ModelAndView model = new ModelAndView("redirect:/user/");
		if(user.getId() == 0) {
			int i = userDAOIMP.createUser(user);
			if(i > 0) {
				model.addObject("f", i);
			} else {
				model.addObject("f", i);
			}
		} else {
			int i = userDAOIMP.updateUser(user);
			if(i > 0) {
				model.addObject("d", i);
			} else {
				model.addObject("d", i);
			}
		}
		return model;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable int id) {
		ModelAndView model = new ModelAndView("index");
		Users u = userDAOIMP.getUser(id);
		model.addObject("user", u);
		List<Users> userList = userDAOIMP.getUsers();
		model.addObject("userList", userList);
		return model;
	}
}
