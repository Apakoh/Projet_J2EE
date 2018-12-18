package SimpleJDBC;

import java.sql.Date;

/**
 *
 * @author Anass DOULACHE
 */
public class OrdersEntity {
    
    private int orderNum;
    private int customerID;
    private int productID;
    private int quantite;
    private float shippingCost;
    private String salesDate;
    private String shippingDate;
    private String compagnyName;
    
    public OrdersEntity(int orderNum, int customerID, int productID, int quantite, float shippingCost, String salesDate, String shippingDate, String compagnyName){
        this.orderNum = orderNum ;
        this.customerID = customerID ;
        this.productID = productID ;
        this.quantite = quantite;
        this.shippingCost = shippingCost;
        this.salesDate = salesDate;
        this.shippingDate = shippingDate;
        this.compagnyName = compagnyName;
    }
    
    public OrdersEntity(int customerID, int productID, int quantite, float shippingCost, String salesDate, String shippingDate, String compagnyName){
        this.customerID = customerID ;
        this.productID = productID ;
        this.quantite = quantite;
        this.shippingCost = shippingCost;
        this.salesDate = salesDate;
        this.shippingDate = shippingDate;
        this.compagnyName = compagnyName;
    }
    
    public OrdersEntity(int orderNum, int productID, int quantite){
        this.orderNum = orderNum ; 
        this.productID = productID ;
        this.quantite = quantite;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public String getCompagnyName() {
        return compagnyName;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public void setCompagnyName(String compagnyName) {
        this.compagnyName = compagnyName;
    }
}