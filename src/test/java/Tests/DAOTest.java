package Tests;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import SimpleJDBC.ClientEntity;
import SimpleJDBC.DAO;
import SimpleJDBC.DAOException;
import SimpleJDBC.DataSourceFactory;

public class DAOTest {
	private DAO myDAO; // L'objet à tester
	private DataSource myDataSource; // La source de données à utiliser
	

	@Before
	public void setUp() throws SQLException {
		myDataSource = DataSourceFactory.getDataSource();
		myDAO = new DAO(myDataSource);
	}
	

	/**
	 * Test of findCustomer method, of class DAO.
	 * @throws SimpleJDBC.DAOException
	 */
	@Test
	public void testFindCustomer() throws DAOException {
		int customedID = 1;
		ClientEntity result = myDAO.customer(customedID);
		assertEquals("Jumbo Eagle Corp", result.getNom());
	}


	
}
