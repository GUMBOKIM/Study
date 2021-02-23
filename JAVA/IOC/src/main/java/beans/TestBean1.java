package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class TestBean1 {
	private int data1;
	private DataBean1 data2;
	// 자동주입 변수에 설정
	@Autowired
	private DataBean1 data3;

	@Autowired
	@Qualifier("obj4")
	private DataBean2 data4;

	@Autowired
	@Qualifier("obj5")
	private DataBean2 data5;
	
	@Autowired(required = false)
	@Qualifier("obj6")
	private DataBean2 data6;

	public int getData1() {
		return data1;
	}

	public DataBean1 getData2() {
		return data2;
	}

	public DataBean2 getData4() {
		return data4;
	}

	public DataBean2 getData5() {
		return data5;
	}

	// 필수 주입 프로퍼티 (스프링 5.1부터 혹은 자바 파일로 빈을 등록했을경우 무시된다.)
	@Required
	public void setData1(int data1) {
		this.data1 = data1;
	}

	// 자동 주입(타입)
	@Autowired
	public void setData2(DataBean1 data2) {
		this.data2 = data2;
	}

	public DataBean1 getData3() {
		return data3;
	}

	public void setData3(DataBean1 data3) {
		this.data3 = data3;
	}

}
