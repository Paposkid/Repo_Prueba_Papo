package com.amx.service.bean;

public class PaginationInfoSalidaTO {
	
	private int pageSize;
	private int pageNumber;
	private int numberOfRows;
	
	public PaginationInfoSalidaTO() {
		
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the numberOfRows
	 */
	public int getNumberOfRows() {
		return numberOfRows;
	}

	/**
	 * @param numberOfRows the numberOfRows to set
	 */
	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaginationInfoSalidaTO [pageSize=" + pageSize + ", pageNumber="
				+ pageNumber + ", numberOfRows=" + numberOfRows + "]";
	}
	

}
