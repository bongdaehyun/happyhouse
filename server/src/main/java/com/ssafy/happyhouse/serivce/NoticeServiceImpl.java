package com.ssafy.happyhouse.serivce;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.NoticeDto;
import com.ssafy.happyhouse.repo.NoticeRepo;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeRepo repo;

	@Override
	public List<NoticeDto> listNotice()  {
		return repo.listNotice();
	}

	@Override
	public NoticeDto selectNotice(int number)  {
		return repo.selectNotice(number);
	}

	@Override
	public boolean registerNotice(NoticeDto notice)  {
		return repo.registerNotice(notice)==1;
	}

	@Override
	public boolean deleteNotice(int number) {
		return repo.deleteNotice(number)==1;
		
	}

	@Override
	public boolean modifyNotice(NoticeDto notice){		
		return repo.modifyNotice(notice)==1;
	}

	@Override
	public List<NoticeDto> selectTitle(String title){
		return repo.selectTitle(title);
	}

	@Override
	public List<NoticeDto> selectWriter(int author){
		return repo.selectWriter(author);
	}
	


}
