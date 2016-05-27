package tp.app.zz.impl.scriptrunner.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mycontrib.generic.jdbc.helper.ScriptRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/serviceSpringConf.xml","/dataSourceForTestSpringConf.xml"})
public class TestWithScriptRunner {
	
	@Inject
	private DataSource ds;
	
	
	@Before
	public void initDataBase(){
		ScriptRunner.launchSqlScript(ds,"sql/initDB.sql");
	}
	
	@Test
	public void testXy(){
		Connection connection=null;
		  try {
			  connection=  ds.getConnection();
			  Statement st = connection.createStatement();
			  ResultSet rs = st.executeQuery("select count(*) from Devise");
			  int nbDevises=0;
			  if(rs.next()){
				  nbDevises=rs.getInt(1);
			  }
			  rs.close();st.close();
			  Assert.assertTrue(nbDevises==4);	//4 insert into in initDB.sql  
		  }
		  catch(SQLException ex){
			  ex.printStackTrace();
		  }
		  finally {
		    try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
	}

}
