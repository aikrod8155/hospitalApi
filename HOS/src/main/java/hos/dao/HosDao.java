package hos.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import hos.entity.Hospital;
@Repository
public interface HosDao {
	int countByCity(Map<String,Object> map);
	
	List<Hospital> listByCity(Map<String,Object> map);
	
	int insertHospital(Hospital hospital);

}
