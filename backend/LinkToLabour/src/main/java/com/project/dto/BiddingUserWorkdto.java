package com.project.dto;

import java.time.LocalDate;

import com.project.pojos.Status;

public class BiddingUserWorkdto {
	
private int	biddingId;
private String	bdescription;
private double	bamount;
private LocalDate	bfromDate;
private LocalDate	btoDate;
private Status	bstatus;
private int	workId;
private String	wtitle;
private String	wdescription;
private int	userId;
private String	userName;

public BiddingUserWorkdto() {
	super();
	
}
public BiddingUserWorkdto(int biddingId, String bdescription, double bamount, LocalDate bfromDate, LocalDate btoDate,
		Status bstatus, int workId, String wtitle, String wdescription, int userId, String userName) {
	super();
	this.biddingId = biddingId;
	this.bdescription = bdescription;
	this.bamount = bamount;
	this.bfromDate = bfromDate;
	this.btoDate = btoDate;
	this.bstatus = bstatus;
	this.workId = workId;
	this.wtitle = wtitle;
	this.wdescription = wdescription;
	this.userId = userId;
	this.userName = userName;
}
public int getBiddingId() {
	return biddingId;
}
public void setBiddingId(int biddingId) {
	this.biddingId = biddingId;
}
public String getBdescription() {
	return bdescription;
}
public void setBdescription(String bdescription) {
	this.bdescription = bdescription;
}
public double getBamount() {
	return bamount;
}
public void setBamount(double bamount) {
	this.bamount = bamount;
}
public LocalDate getBfromDate() {
	return bfromDate;
}
public void setBfromDate(LocalDate bfromDate) {
	this.bfromDate = bfromDate;
}
public LocalDate getBtoDate() {
	return btoDate;
}
public void setBtoDate(LocalDate btoDate) {
	this.btoDate = btoDate;
}
public Status getBstatus() {
	return bstatus;
}
public void setBstatus(Status bstatus) {
	this.bstatus = bstatus;
}
public int getWorkId() {
	return workId;
}
public void setWorkId(int workId) {
	this.workId = workId;
}
public String getWtitle() {
	return wtitle;
}
public void setWtitle(String wtitle) {
	this.wtitle = wtitle;
}
public String getWdescription() {
	return wdescription;
}
public void setWdescription(String wdescription) {
	this.wdescription = wdescription;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
@Override
public String toString() {
	return "BiddingUserWorkdto [biddingId=" + biddingId + ", bdescription=" + bdescription + ", bamount=" + bamount
			+ ", bfromDate=" + bfromDate + ", btoDate=" + btoDate + ", bstatus=" + bstatus + ", workId=" + workId
			+ ", wtitle=" + wtitle + ", wdescription=" + wdescription + ", userId=" + userId + ", userName=" + userName
			+ "]";
}
	

}
