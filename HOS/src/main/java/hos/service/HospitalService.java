package hos.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import hos.entity.Hospital;
@Transactional
public interface HospitalService {
	int countByCity(Map<String,Object> query);
	
	List<Hospital> listByCity(Map<String,Object> query);
	
	int reset();
	

}
