package com.ssafy.happyhouse.serivce;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.QnaDto;
import com.ssafy.happyhouse.repo.QnaRepo;

@Service
public class QnaServiceImpl implements QnaService {
	@Autowired
	private QnaRepo repo;

	@Override
	public List<QnaDto> listQna()  {
		return repo.listQna();
	}

	@Override
	public QnaDto selectQna(int number)  {
		return repo.selectQna(number);
	}

	@Override
	public boolean registerQna(QnaDto notice)  {
		return repo.registerQna(notice)==1;
	}

	@Override
	public boolean deleteQna(int number) {
		return repo.deleteQna(number)==1;
		
	}

	@Override
	public boolean modifyQna(QnaDto notice){		
		return repo.modifyQna(notice)==1;
	}

	@Override
	public List<QnaDto> selectTitle(String title){
		return repo.selectTitle(title);
	}


}
