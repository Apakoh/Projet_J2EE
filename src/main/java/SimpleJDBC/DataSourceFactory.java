package SimpleJDBC;

import javax.sql.DataSource;

/**
 *
 * @author Anass DOULACHE
 */
public class DataSourceFactory {
    
    	public static DataSource getDataSource() {
		org.apache.derby.jdbc.EmbeddedDataSource es = new org.apache.derby.jdbc.EmbeddedDataSource();
                es.setCreateDatabase("create");
                es.setDatabaseName("embedded_sample");
                return es;
	}	
    
}