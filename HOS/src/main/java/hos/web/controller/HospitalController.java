package hos.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hos.entity.Hospital;
import hos.service.HospitalService;
import hos.web.form.HospitalBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.service.AllowableValues;

@Controller
@Api(tags="�X����|API")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	
	
	@ApiResponses(value= {
			@ApiResponse(code=500,message="�d�߲��`"),
			@ApiResponse(code=200,message="�d�ߦ��\"),
	})
	@ApiOperation(value="�̱���d����|���")
	@RequestMapping(value="/hospital", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<HospitalBean>> listByCity(
			@ApiParam(value="�Ҧb����",required=false ,allowableValues="�򶩥�,�O�_��,�s�_��,��饫,�s�˥�,�s�˿�,�]�߿�,�x����,���ƿ�,�n�뿤,�x�n��,������,�̪F��,�y����,�Ὤ��,�x�F��,���,������,�s����")
			@RequestParam(value="city", required=false) String city
			
			){
	
		Map<String,Object> query=getQuery(city);
		List<Hospital> entitys=hospitalService.listByCity(query);
		if(entitys==null || entitys.size()==0) {
			return ResponseEntity.notFound().build();
		}
		List<HospitalBean> entityBeans=new ArrayList<HospitalBean>();
		for(Hospital entity:entitys) {
			entityBeans.add(new HospitalBean(entity));
		}
		return ResponseEntity.ok(entityBeans);
	}
	
	
	private Map<String,Object> getQuery(String city){
		Map<String,Object> query=new HashMap<String,Object>();
		if(StringUtils.hasText(city)) {
			query.put(Hospital.PARAM_CITY, city);
		}
		return query;
	}
	
}
