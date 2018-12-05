package SimpleJDBC;

/**
 *
 * @author Anass DOULACHE
 */
public class ProductEntity {
    private int productID;
    private int manufacturerID;
    private String productCode;
    private Double purchaseCost;
    private int quantity;
    private Double markup;
    private String available;
    private String description;

    public ProductEntity(int productID, int manufacturerID, String productCode, Double purchaseCost, int quantity, Double markup, String available, String description) {
        this.productID = productID;
        this.manufacturerID = manufacturerID;
        this.productCode = productCode;
        this.purchaseCost = purchaseCost;
        this.quantity = quantity;
        this.markup = markup;
        this.available = available;
        this.description = description;
    }

    public ProductEntity(int manufacturerID, String productCode, Double purchaseCost, int quantity, Double markup, String available, String description) {
        this.manufacturerID = manufacturerID;
        this.productCode = productCode;
        this.purchaseCost = purchaseCost;
        this.quantity = quantity;
        this.markup = markup;
        this.available = available;
        this.description = description;
    }

    public int getProductID() {
        return productID;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public String getProductCode() {
        return productCode;
    }

    public Double getPurchaseCost() {
        return purchaseCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getMarkup() {
        return markup;
    }

    public String getAvailable() {
        return available;
    }

    public String getDescription() {
        return description;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setPurchaseCost(Double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMarkup(Double markup) {
        this.markup = markup;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
