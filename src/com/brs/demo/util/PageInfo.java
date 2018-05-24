package com.brs.demo.util;

public class PageInfo {
	
	private int total;
	
	private int page;
	
	private int next;
	
	private int pre;
	
	private int last;

	public PageInfo(int total, int page, int next, int pre, int last) {
		super();
		this.total = total;
		this.page = page;
		this.next = next;
		this.pre = pre;
		this.last = last;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}
	
	
}
