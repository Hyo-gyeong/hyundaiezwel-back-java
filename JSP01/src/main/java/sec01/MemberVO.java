package sec01;
/*
 * DTO vs VO
 * VO : 데이터 저장만
 * DTO : 가변 성격(setter)
 * 하지만 거의 같은 개념으로 사용됨
 */
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	public MemberVO() {
	}

	public MemberVO(String id, String pwd, String name, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
