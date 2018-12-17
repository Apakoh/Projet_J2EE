package Controleur;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import SimpleJDBC.DAO;
import SimpleJDBC.DataSourceFactory;
import SimpleJDBC.ClientEntity;
import SimpleJDBC.DAOException;
import org.apache.derby.tools.ij;

/**
 * Web application lifecycle listener, initialise la base de données au démarrage de l'application si nécessaire
 */
@WebListener()
public class DatabaseInitializer implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
            try {
                if (!databaseExists()) {
                    initializeDatabase();
                }
            } catch (DAOException ex) {
                Logger.getLogger(DatabaseInitializer.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	private boolean databaseExists() throws DAOException {
		boolean result = false;
		DAO dao = new DAO(DataSourceFactory.getDataSource());
		try {
			List<ClientEntity> allCodes = dao.customerLoginList();
			Logger.getLogger("BDD").log(Level.INFO, "Database already exists");
			result = true;
		} catch (DAOException ex) {
			Logger.getLogger("BDD").log(Level.INFO, "Database does not exist");
		}
		return result;
	}

	private void initializeDatabase() {
		OutputStream nowhere = new OutputStream() {
			@Override
			public void write(int b) {
			}
		};
		
		Logger.getLogger("BDD").log(Level.INFO, "Creating databse from SQL script");
		try {
			Connection connection = DataSourceFactory.getDataSource().getConnection();
			int result = ij.runScript(connection, this.getClass().getResourceAsStream("BDD.sql"), "UTF-8", System.out /* nowhere */ , "UTF-8");
			if (result == 0) {
				Logger.getLogger("BDD").log(Level.INFO, "Database succesfully created");
			} else {
				Logger.getLogger("BDD").log(Level.SEVERE, "Errors creating database");
			}

		} catch (UnsupportedEncodingException | SQLException e) {
			Logger.getLogger("BDD").log(Level.SEVERE, null, e);
		}

	}
}