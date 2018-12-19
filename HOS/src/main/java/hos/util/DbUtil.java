package hos.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.ibatis.jdbc.ScriptRunner;

public class DbUtil {
	public static final String KEY_LOG="log";
	public static final String KEY_ERROR_LOG="errorLOG";
	
	public static void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e) {
				LogUtil.error(e,e);
			}
		}
	}
	
	
	
	public static void close(Statement stmt,Connection con) throws Exception {
		if(stmt!=null) {
			try {
				stmt.close();
			}catch(SQLException e) {
				LogUtil.error(e, e);
			}
			
		}
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e) {
				LogUtil.error(e, e);
			}
		}
	}
	public static void close(PreparedStatement pstmt,Connection con) throws Exception {
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				LogUtil.error(e, e);
			}
			
		}
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e) {
				LogUtil.error(e, e);
			}
		}
	}
	public static void close(CallableStatement cstmt,Connection con) throws Exception {
		if(cstmt!=null) {
			try {
				cstmt.close();
			}catch(SQLException e) {
				LogUtil.error(e, e);
			}
			
		}
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException e) {
				LogUtil.error(e, e);
			}
		}
	}
	
	public static Map<String,String> execute(DataSource dataSource,InputStream in) throws Exception{
		BufferedReader reader=new BufferedReader(new InputStreamReader(in, "UTF-8"));
		return execute(dataSource, reader);
	}
	public static Map<String,String> execute(DataSource dataSource,Reader reader){
		Connection con=null;
		Map<String,String>map=new HashMap<String,String>();
		try {
			con=dataSource.getConnection();
			ScriptRunner runner=new ScriptRunner(con);
			runner.setAutoCommit(true);
			runner.setStopOnError(false);
			runner.setDelimiter(";");
			runner.setSendFullScript(false);
			runner.setFullLineDelimiter(false);
			StringBuilderWriter logWriter=new StringBuilderWriter();
			StringBuilderWriter errorLogWriter=new StringBuilderWriter();
			runner.setLogWriter(new PrintWriter(logWriter));
			runner.setErrorLogWriter(new PrintWriter(errorLogWriter));
			runner.runScript(reader);
			map.put(KEY_ERROR_LOG, logWriter.toString());
			map.put(KEY_ERROR_LOG, errorLogWriter.toString());
		}catch(Exception e) {
			LogUtil.error(e, e);
		}finally {
			try {
				reader.close();
			}catch(IOException e) {
				LogUtil.error(e,e);
			}
			DbUtil.close(con);
		}
		return map;
	}
	

}
