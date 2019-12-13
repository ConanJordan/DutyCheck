package com.jp.co.netwisdom.service;

import java.sql.SQLException;
import java.util.List;

import com.jp.co.netwisdom.dao.DutyNoteDao;
import com.jp.co.netwisdom.dto.DutyNoteDto;
import com.jp.co.netwisdom.interfaces.QueryIF;

public class DutyNoteService implements QueryIF {

	@Override
	public List<DutyNoteDto> queryDutyNote(int year, int month) throws SQLException {
		
		DutyNoteDao dutyNoteDao = new DutyNoteDao();
		
		return dutyNoteDao.queryDutyNote(year, month);
	}

}
