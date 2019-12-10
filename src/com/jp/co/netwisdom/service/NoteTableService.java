package com.jp.co.netwisdom.service;

import java.sql.SQLException;
import java.util.List;

import com.jp.co.netwisdom.dao.NoteTableDao;
import com.jp.co.netwisdom.entity.NoteTableEntity;
import com.jp.co.netwisdom.interfaces.QueryIF;

public class NoteTableService {
	
	public List<NoteTableEntity> queryNoteTables 
		(String cardNo, int year, int month) 
		throws SQLException {
		QueryIF queryBean = new NoteTableDao();
		return queryBean.queryNoteTable(cardNo, year, month);
	}
	
}
