package kr.co.tjoeun.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.mapper.MainMapper;

@Repository
public class MainDAO {
	
	@Autowired
	private MainMapper mainMapper;
	
	
}
