package hos.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hos.dao.DataDao;
import hos.service.DataService;
import hos.service.HospitalService;
import hos.util.DbUtil;
import hos.util.LogUtil;
@Service("DataService")
public class DataServiceImpl implements DataService{
	@Autowired
	private DataDao dataDao;
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private DataSource dataSource;
	
	
	public void init() {
		boolean tableExist=this.checkTableExist("t_hospital");
		if(!tableExist) {
			try {
				DbUtil.execute(dataSource, DataServiceImpl.class.getResourceAsStream("/sql/t-hospital.sql"));
				hospitalService.reset();
				
			}catch(Exception ex) {
				LogUtil.error(ex, ex);
			}
		}
	}
	
	public boolean checkTableExist(String tableName) {
		
		return checkTableExist(null,tableName);
	}

	public boolean checkTableExist(String dbName, String tableName) {
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(dbName)) {
			map.put("dbName", dbName);
		}
		map.put("tableName", tableName);
		
		return (dataDao.countByTable(map)>0);
	}


}
