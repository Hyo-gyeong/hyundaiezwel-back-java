package sec02;

public class MemberBean {
	private String memId;
	private String memPw;
	private String memName;
	private String memMail;
	
	public MemberBean() {
	}

	public MemberBean(String memId, String memPw, String memName, String memMail) {
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
	
}
