package Tests;

import SimpleJDBC.ClientEntity;
import SimpleJDBC.DAO;
import SimpleJDBC.DAOException;
import SimpleJDBC.OrdersEntity;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.sql.DataSource;
import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAOTest {
	private DAO myDAO; // L'objet à tester
	private DataSource myDataSource; // La source de données à utiliser
	private static Connection myConnection ; // La connection à la BD de test
	

	@Before
	public void setUp() throws SQLException, IOException, SqlToolError {
		// On utilise la base de données de test
		myDataSource = getDataSource();
		myConnection = myDataSource.getConnection();
		// On crée le schema de la base de test
		executeSQLScript(myConnection, "schema.sql");
		// On y met des données
		executeSQLScript(myConnection, "bigtestdata.sql");		
		
		myDAO = new DAO(myDataSource);
	}

	@After
	public void tearDown() throws IOException, SQLException {
		myConnection.close(); // La base de données de test est détruite ici
             	myDAO = null; // Pas vraiment utile
	}
        
        private void executeSQLScript(Connection connexion, String filename)  throws IOException, SQLException, SqlToolError {
            // On initialise la base avec le contenu d'un fichier de test
            String sqlFilePath = DAOTest.class.getResource(filename).getFile();
            SqlFile sqlFile = new SqlFile(new File(sqlFilePath));

            sqlFile.setConnection(connexion);
            sqlFile.execute();
            sqlFile.closeReader();	
	}
	
	/**
	 * Test of testFindCustomer method, of class DAO.
	 * @throws SimpleJDBC.DAOException
	 */
	@Test
	public void testFindCustomer() throws DAOException {
		int customedID = 1;
		ClientEntity result = myDAO.customer(customedID);
		assertEquals("Jumbo Eagle Corp", result.getNom());
	}
        
        
	/**
	 * Test of testEditionClient method, of class DAO.
	 * @throws SimpleJDBC.DAOException
	 */
	@Test
	public void testEditionClient() throws DAOException {
		    int idClient = 1;
                    String nom = "lol";
                    String adresse = "111 E. Las Olivas Blvd";
                    String ville = "Fort Lauderdale";
                    String etat = "FL";
                    String telephone = "305-555-0188";
                    String fax = "305-555-0189";
                    String email = "jumboeagle@example.com";
                    ClientEntity clientModifie = new ClientEntity(idClient,nom,adresse,ville,etat,telephone,fax,email);
                    int result = myDAO.editClientData(clientModifie);
		assertEquals(1, result);
	}
        
        /**
	 * Test of testEditionClient method, of class DAO.
	 * @throws SimpleJDBC.DAOException
	 */
	@Test
	public void testEditionOrder() throws DAOException {
		    int id = 10398001;
                    int pid = 980001;
                    int quantite = 1;
                    OrdersEntity order = new OrdersEntity(id,pid,quantite);
                    int result = myDAO.editClientOrder(order);
		assertEquals(1, result);
	}
        
         /**
	 * Test of testSuppressionOrder method, of class DAO.
	 * @throws SimpleJDBC.DAOException
	 */
	@Test
	public void testSuppressionOrder() throws DAOException, SQLException {
		    int id = 10398001;
                    int result = myDAO.deleteClientOrder(id);
		assertEquals(1, result);
	}
        
        /**
	 * Test of testAjoutOrder method, of class DAO.
	 * @throws SimpleJDBC.DAOException
	 */
	@Test
	public void testAjoutOrder() throws DAOException, SQLException, ParseException {
            
                int idOrder = 30130;
                int idClient = 2;
                int pid = 980025;
                int quantite = 222;
                float prixLivraison = (float) 3.0;
                //String dateVentes = "2018-12-01";
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = (Date)formatter.parse("29/11/2011");
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String mydate = dateFormat.format(date);
                String nomFournisseur = "Coucou";                
                String dateLivraison = "2018-12-01";
                OrdersEntity ord = new OrdersEntity(idOrder,idClient,pid,quantite,prixLivraison,mydate,dateLivraison,nomFournisseur);
                int result = myDAO.addClientOrder(ord); 
		assertEquals(1, result);
	}
        
        public static DataSource getDataSource() {
            org.hsqldb.jdbc.JDBCDataSource ds = new org.hsqldb.jdbc.JDBCDataSource();
            ds.setDatabase("jdbc:hsqldb:mem:testcase;shutdown=true");
            ds.setUser("sa");
            ds.setPassword("sa");
            return ds;
	}	
	
}
