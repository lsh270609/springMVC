package kr.co.tjoeun.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.dao.MainDAO;

@Service
public class MainService {
	
	@Autowired
	private MainDAO mainDAO;
	
	
}
