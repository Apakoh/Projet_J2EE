package SimpleJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Anass DOULACHE
 */
public class DAO {
	protected final DataSource myDataSource;

	/**
	 *
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        public void editClientData(ClientEntity cl) {
            String sql = "UPDATE CUSTOMER SET DISCOUNT_CODE = ?, ZIP = ?, NAME = ?, ADDRESSLINE1 = ?, ADDRESSLINE2 = ?, CITY = ?, STATE = ?, PHONE = ?, FAX = ?, EMAIL = ?, CREDIT_LIMIT = ? WHERE CUSTOMER_ID = ?";
            try (   Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
                    // Nom + Prénom du client
                    String nomComplet = cl.getNom()+" "+cl.getPrenom();
                    
                    // Définir la valeur du paramètre
                    stmt.setInt(1, cl.getDiscountCode());
                    stmt.setString(2, cl.getZip());
                    stmt.setString(3, nomComplet);
                    stmt.setString(4, cl.getAdresseLine1());
                    stmt.setString(5, cl.getAdresseLine2());
                    stmt.setString(6, cl.getCity());
                    stmt.setString(7, cl.getState());
                    stmt.setString(8, cl.getTelephone());
                    stmt.setString(9, cl.getFax());
                    stmt.setString(10, cl.getEmail());
                    stmt.setInt(11, cl.getCreditLimit());
                    stmt.setInt(12, cl.getIdClient());
                    stmt.executeUpdate();

            }  catch (SQLException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }
        }
        
        public List<ClientEntity> customerLoginList() throws DAOException {
            List<ClientEntity> result = new LinkedList<>(); // Liste vIde

            String sql = "SELECT CUSTOMER_ID,EMAIL FROM CUSTOMER";
            try (Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)) {

                    try (ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) {
                                // On récupère les champs nécessaires de l'enregistrement courant
                                int customerID = rs.getInt("CUSTOMER_ID");
                                String email = rs.getString("EMAIL");
                                // On crée l'objet entité
                                ClientEntity c = new ClientEntity(customerID,email);
                                // On l'ajoute à la liste des résultats
                                result.add(c);
                            }
                    }
            }  catch (SQLException ex) {
                    Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                    throw new DAOException(ex.getMessage());
            }

            return result;
	}     
        
        public List<OrdersEntity> OrdersListByCustomer(int customerNum) throws DAOException {
            List<OrdersEntity> result = new LinkedList<>(); // Liste vIde

            String sql = "SELECT * FROM PURCHASE_ORDER WHERE CUSTOMER_ID = ?";
            try (Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)) {
                
                    stmt.setInt(1, customerNum);

                    try (ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) { // Tant qu'il y a des enregistrements
                                // On récupère les champs nécessaires de l'enregistrement courant
                                int orderNum = rs.getInt("ORDER_NUM");
                                int customerID = rs.getInt("CUSTOMER_ID");
                                int productID = rs.getInt("PRODUCT_ID");
                                int quantite =rs.getInt("QUANTITY") ;
                                float shippingCost = rs.getFloat("SHIPPING_COST");
                                Date salesDate = rs.getDate("SALES_DATE");
                                Date shippingDate = rs.getDate("SHIPPING_DATE");
                                String compagnyName = rs.getString("FREIGHT_COMPANY");
                                // On crée l'objet entité
                                OrdersEntity c = new OrdersEntity(orderNum, customerID, productID, quantite, shippingCost, salesDate, shippingDate, compagnyName);
                                // On l'ajoute à la liste des résultats
                                result.add(c);
                            }
                    }
            }  catch (SQLException ex) {
                    Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                    throw new DAOException(ex.getMessage());
            }

            return result;
	}
        
        public void addClientOrder(OrdersEntity ord){
            String sql = "INSERT INTO PURCHASE_ORDER (CUSTOMER_ID,PRODUCT_ID,QUANTITY,SHIPPING_COST,SALES_DATE,SHIPPING_DATE,FREIGHT_COMPANY) VALUES (?,?,?,?,?,?,?)";
            try (   Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
                
                    // Définir la valeur du paramètre
                    stmt.setInt(1, ord.getCustomerID());
                    stmt.setInt(2, ord.getProductID());
                    stmt.setInt(3, ord.getQuantite());
                    stmt.setFloat(4, ord.getShippingCost());
                    stmt.setDate(5, ord.getSalesDate());
                    stmt.setDate(6, ord.getShippingDate());
                    stmt.setString(7, ord.getCompagnyName());
                    stmt.executeUpdate();

            }  catch (SQLException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }   
        }
        
        public void editClientOrder(OrdersEntity ord){
            String sql = "UPDATE PURCHASE_ORDER SET PRODUCT_ID = ?, QUANTITY = ? WHERE ORDER_NUM = ?";
            try (   Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
                    
                    // Définir la valeur du paramètre
                    stmt.setInt(1, ord.getProductID());
                    stmt.setInt(2, ord.getQuantite());
                    stmt.setInt(3, ord.getOrderNum());
                    stmt.executeUpdate();

            }  catch (SQLException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }
        }
        
        public void deleteClientOrder(int orderNum) throws SQLException {
            String sql = "DELETE FROM PURCHASE_ORDER WHERE ORDER_NUM = ?";
            try (   Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
                    // Définir la valeur du paramètre
                    stmt.setInt(1, orderNum);
                    stmt.executeUpdate();

            }  catch (SQLException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }
        }
        
        public void addProduct(ProductEntity prod){
            String sql = "INSERT INTO PRODUCT (MANUFACTURER_ID,PRODUCT_CODE,PURCHASE_COST,QUANTITY_ON_HAND,MARKUP,AVAILABLE,DESCRIPTION) VALUES (?,?,?,?,?,?,?)";
            try (   Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
                
                    // Définir la valeur du paramètre
                    stmt.setInt(1, prod.getManufacturerID());
                    stmt.setString(2, prod.getProductCode());
                    stmt.setDouble(3, prod.getPurchaseCost());
                    stmt.setInt(4, prod.getQuantity());
                    stmt.setDouble(5, prod.getMarkup());
                    stmt.setString(6, prod.getAvailable());
                    stmt.setString(7, prod.getDescription());
                    stmt.executeUpdate();

            }  catch (SQLException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }   
        }
        
        public void editProduct(ProductEntity prod){
            String sql = "UPDATE PRODUCT SET MANUFACTURER_ID = ?, PRODUCT_CODE = ?, PURCHASE_COST = ?, QUANTITY_ON_HAND = ?, MARKUP = ?, AVAILABLE = ?, DESCRIPTION = ? WHERE PRODUCT_ID = ?";
            try (   Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
                    
                    // Définir la valeur du paramètre
                    stmt.setInt(1, prod.getManufacturerID());
                    stmt.setString(2, prod.getProductCode());
                    stmt.setDouble(3, prod.getPurchaseCost());
                    stmt.setInt(4, prod.getQuantity());
                    stmt.setDouble(5, prod.getMarkup());
                    stmt.setString(6, prod.getAvailable());
                    stmt.setString(7, prod.getDescription());
                    stmt.setInt(8, prod.getProductID());
                    stmt.executeUpdate();

            }  catch (SQLException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }
        }
        
        public void deleteProduct(int productID) throws SQLException {
            String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";
            try (   Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)
            ) {
                    // Définir la valeur du paramètre
                    stmt.setInt(1, productID);
                    stmt.executeUpdate();

            }  catch (SQLException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }
        }
        
        public List<ProductEntity> ProductList() throws DAOException {
            List<ProductEntity> result = new LinkedList<>(); // Liste vIde

            String sql = "SELECT * FROM PRODUCT";
            try (Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)) {

                    try (ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) { // Tant qu'il y a des enregistrements
                                // On récupère les champs nécessaires de l'enregistrement courant
                                int productID = rs.getInt("PRODUCT_ID");
                                int manufacturerID = rs.getInt("MANUFACTURER_ID");
                                String productCode = rs.getString("PRODUCT_CODE");
                                Double purchaseCost = rs.getDouble("PURCHASE_COST");
                                int quantity = rs.getInt("QUANTITY_ON_HAND");
                                Double markup = rs.getDouble("MARKUP");
                                String available = rs.getString("AVAILABLE");
                                String description = rs.getString("DESCRIPTION");
                                // On crée l'objet entité
                                ProductEntity p = new ProductEntity(productID, manufacturerID, productCode, purchaseCost, quantity, markup, available, description);
                                // On l'ajoute à la liste des résultats
                                result.add(p);
                            }
                    }
            }  catch (SQLException ex) {
                    Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                    throw new DAOException(ex.getMessage());
            }

            return result;
	}
        
        public Double turnoverByCategory(String codeProduct, Date dateDebut, Date dateFin){
            double result = 0.00 ;
            String sql = "SELECT SUM(pu.QUANTITY*pu.SHIPPING_COST) AS CA FROM PRODUCT po, PURCHASE_ORDER pu WHERE po.PRODUCT_CODE = ? AND pu.SALES_DATE >= ? AND pu.SALES_DATE <= ? " ;
            
            try (   Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery(sql)
            ) {
                    // Définir la valeur du paramètre
                    stmt.setString(1, codeProduct);
                    stmt.setDate(2, dateDebut);
                    stmt.setDate(3, dateFin);
                    stmt.executeUpdate();
                    if (rs.next()) {
                        result = rs.getInt("CA");
                    }

            }  catch (SQLException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }
            
            return result ;
        }
        
        public Double turnoverByState(String state, Date dateDebut, Date dateFin){
            double result = 0.00 ;
            String sql = "SELECT SUM(pu.QUANTITY*pu.SHIPPING_COST) AS CA FROM CUSTOMER c, PURCHASE_ORDER pu WHERE c.\"STATE\" = ? AND pu.SALES_DATE >= ? AND pu.SALES_DATE <= ? " ;
            
            try (   Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery(sql)
            ) {
                    // Définir la valeur du paramètre
                    stmt.setString(1, state);
                    stmt.setDate(2, dateDebut);
                    stmt.setDate(3, dateFin);
                    stmt.executeUpdate();
                    if (rs.next()) {
                        result = rs.getInt("CA");
                    }

            }  catch (SQLException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }
            
            return result ;
        }
        
        public Double turnoverByCustomer(int customerID, Date dateDebut, Date dateFin){
            double result = 0.00 ;
            String sql = "SELECT SUM(pu.QUANTITY*pu.SHIPPING_COST) AS CA FROM CUSTOMER c, PURCHASE_ORDER pu WHERE c.CUSTOMER_ID = ? AND pu.SALES_DATE >= ? AND pu.SALES_DATE <= ? " ;
            
            try (   Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery(sql)
            ) {
                    // Définir la valeur du paramètre
                    stmt.setInt(1, customerID);
                    stmt.setDate(2, dateDebut);
                    stmt.setDate(3, dateFin);
                    stmt.executeUpdate();
                    if (rs.next()) {
                        result = rs.getInt("CA");
                    }

            }  catch (SQLException ex) {
                System.out.println("Erreur : " + ex.getMessage());
            }
            
            return result ;
        }
}