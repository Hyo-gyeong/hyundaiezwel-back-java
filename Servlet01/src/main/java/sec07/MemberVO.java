package sec07;

import java.util.Date;

public class MemberVO {
	private String memId;
	private String memPw;
	private String memName;
	private String memMail;
	private Date memJoinDate;
	
	public MemberVO() {
	}

	public MemberVO(String memId, String memPw, String memName, String memMail) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memMail = memMail;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}

	public Date getMemJoinDate() {
		return memJoinDate;
	}

	public void setMemJoinDate(Date memJoinDate) {
		this.memJoinDate = memJoinDate;
	}
	
}
