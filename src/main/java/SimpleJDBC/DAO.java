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
}