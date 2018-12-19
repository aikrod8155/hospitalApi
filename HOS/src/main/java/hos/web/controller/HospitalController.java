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
@Api(tags="合格醫院API")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	
	
	@ApiResponses(value= {
			@ApiResponse(code=500,message="查詢異常"),
			@ApiResponse(code=200,message="查詢成功"),
	})
	@ApiOperation(value="依條件查詢醫院資料")
	@RequestMapping(value="/hospital", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<HospitalBean>> listByCity(
			@ApiParam(value="所在城市",required=false ,allowableValues="基隆市,臺北市,新北市,桃園市,新竹市,新竹縣,苗栗縣,台中市,彰化縣,南投縣,台南市,高雄市,屏東縣,宜蘭縣,花蓮縣,台東縣,澎湖縣,金門縣,連江縣")
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
