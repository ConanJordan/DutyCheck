package com.jp.co.netwisdom.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.jp.co.netwisdom.dto.DutyNoteDto;

public interface QueryIF {
	
	public List<DutyNoteDto> queryDutyNote (int year, int month) throws SQLException;
	
}
