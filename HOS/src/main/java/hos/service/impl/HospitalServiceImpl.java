package hos.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hos.dao.HosDao;
import hos.entity.Hospital;
import hos.service.HospitalService;

@Service("HospitalService")
public class HospitalServiceImpl implements HospitalService{
	
	@Autowired
	private HosDao hosdao;

	public int countByCity(Map<String, Object> query) {
		
		return hosdao.countByCity(query);
	}

	public List<Hospital> listByCity(Map<String, Object> query) {
		Map<String,Object> map=new HashMap<String,Object>(query);
		return hosdao.listByCity(map);
	}
	
	public int reset() {
		int row=0;
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(HospitalServiceImpl.class.getResourceAsStream("/hospital.csv"), "UTF-8"));
			String line=null;
			
			reader.readLine();
			while((line=reader.readLine())!=null) {
				String[]rows=line.split(",");
				Hospital hospital=new Hospital(rows[0],rows[1],rows[2],rows[3],rows[4],rows[5],rows[6],rows[7],rows[8]);
				System.out.println(hospital);
				row+=hosdao.insertHospital(hospital);
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return row;
	}
	

}
