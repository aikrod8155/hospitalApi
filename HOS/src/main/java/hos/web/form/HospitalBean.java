package hos.web.form;

import hos.entity.Hospital;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="�X����|")
public class HospitalBean {
	
	
	@ApiModelProperty(dataType="string" , value="���ݫ���")
	private String city;
	@ApiModelProperty(dataType="string" , value="��|�W��")
	private String name;
	@ApiModelProperty(dataType="string" , value="�s��")
	private String seq;
	@ApiModelProperty(dataType="string" , value="��|��Ų���G")
	private String grade1;
	@ApiModelProperty(dataType="string" , value="�о���|��Ų���G")
	private String grade2;
	@ApiModelProperty(dataType="string" , value="��|��Ų�X��Ĵ�")
	private String time1;
	@ApiModelProperty(dataType="string" , value="�о���|�X��Ĵ�")
	private String time2;
	@ApiModelProperty(dataType="string" , value="��|�q��")
	private String tel;
	@ApiModelProperty(dataType="string" , value="�a�}")
	private String address;
	public HospitalBean() {
		
	}
	public HospitalBean(Hospital hos) {
		super();
		this.city = hos.getCity();
		this.name = hos.getName();
		this.seq = hos.getSeq();
		this.grade1 = hos.getGrade1();
		this.grade2 = hos.getGrade2();
		this.time1 = hos.getTime1();
		this.time2 = hos.getTime2();
		this.tel = hos.getTel();
		this.address = hos.getAddress();
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	

}
