package com.wpf.jdbc.util;

import java.util.List;

public class PageModel<T> {
	private int currentPage;//当前页
	private int pageSize;//页面显示行数
	private List<T> list;//页面中显示的数据
	private int totalRecord;//总记录数


	//总页数
	public int getTotalPage() {
		return (this.getTotalRecord() + pageSize - 1) / pageSize;
	}

	//获得第一页
	public int getPageFirst() {
		return 1;
	}

	//上一页
	public int getPageUp() {
		if (this.currentPage <= 1)
			return 1;
		else
			return --this.currentPage;
	}

	//下一页
	public int getPageDown() {
		if (this.currentPage >= this.getTotalPage())
			return this.getTotalPage();
		else
			return ++this.currentPage;
	}


	public PageModel() {
	}

	public PageModel(int currentPage, int pageSize, List<T> list, int totalRecord) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.list = list;
		this.totalRecord = totalRecord;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
}
