package com.amx.service.bean;

public class PaginationInfoTO {
	
	private int pageSize;
	private int pageNumber;
	private int numberOfRows;
	
	public PaginationInfoTO() {
		
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	@Override
	public String toString() {
		return "PaginationInfoTO [pageSize=" + pageSize + ", pageNumber="
				+ pageNumber + ", numberOfRows=" + numberOfRows + "]";
	}
	
	
	

}
