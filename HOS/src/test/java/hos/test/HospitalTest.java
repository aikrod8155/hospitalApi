package hos.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hos.entity.Hospital;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"classpath:beans.xml"})
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HospitalTest {
	private static final String path="/hospital.csv";
	@Autowired
	private Hospital hospital;
	@Test
	public void testReadFile() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(HospitalTest.class.getResourceAsStream(path), "UTF-8"));
			String line=null;
			int row=0;
			reader.readLine();
			while((line=reader.readLine())!=null) {
				String[]rows=line.split(",");
				Hospital hospital=new Hospital(rows[0],rows[1],rows[2],rows[3],rows[4],rows[5],rows[6],rows[7],rows[8]);
				System.out.println(hospital);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
