package com.cjh.ex.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cjh.ex.dto.TraineeDTO;

@Repository
public class TraineeRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public int insert(TraineeDTO trainee) {
		return sql.insert("Trainee.insertTrainee", trainee);
		
	}

	public List<TraineeDTO> findAll() {
		
		return sql.selectList("Trainee.findAll");
	}

	public TraineeDTO findById(long t_number) {
		
		return sql.selectOne("Trainee.findById", t_number);
	}

	public void delete(long t_number) {
		
		sql.delete("Trainee.delete", t_number);
	}

	public void update(TraineeDTO trainee) {
		sql.update("Trainee.update", trainee);
		
	}

	

	
}