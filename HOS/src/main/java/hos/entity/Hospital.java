package hos.entity;

public class Hospital {
	public static final String PARAM_CITY="city";
	private String city;
	private String name;
	private String seq;
	private String grade1;
	private String grade2;
	private String time1;
	private String time2;
	private String tel;
	private String address;
	public Hospital() {
		
	}
	
	public Hospital(String city, String name, String seq, String grade1, String grade2, String time1, String time2,
			String tel, String address) {
		super();
		this.city = city;
		this.name = name;
		this.seq = seq;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.time1 = time1;
		this.time2 = time2;
		this.tel = tel;
		this.address = address;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getGrade1() {
		return grade1;
	}
	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}
	public String getGrade2() {
		return grade2;
	}
	public void setGrade2(String grade2) {
		this.grade2 = grade2;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hospital [city=" + city + ", name=" + name + ", seq=" + seq + ", grade1=" + grade1 + ", grade2="
				+ grade2 + ", time1=" + time1 + ", time2=" + time2 + ", tel=" + tel + ", address=" + address + "]";
	}
	
	
	
	

}
