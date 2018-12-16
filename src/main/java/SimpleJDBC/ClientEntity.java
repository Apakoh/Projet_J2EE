package SimpleJDBC;

/**
 *
 * @author Anass DOULACHE
 */
public class ClientEntity {
    private int idClient;
    private char discountCode;
    private String zip; 
    private String Nom;
    private String Prenom;
    private String AdresseLine1;
    private String AdresseLine2;
    private String City;
    private String State;
    private String Telephone;
    private String Fax;
    private String Email;
    private int creditLimit;

    public ClientEntity(int idClient, char discountCode, String zip, String Nom, String Prenom, String AdresseLine1, String AdresseLine2, String City, String State, String Telephone, String Fax, String Email, int creditLimit) {
        this.idClient = idClient;
        this.discountCode = discountCode;
        this.zip = zip;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.AdresseLine1 = AdresseLine1;
        this.AdresseLine2 = AdresseLine2;
        this.City = City;
        this.State = State;
        this.Telephone = Telephone;
        this.Fax = Fax;
        this.Email = Email;
        this.creditLimit = creditLimit;
    }

    public ClientEntity(char discountCode, String zip, String Nom, String Prenom, String AdresseLine1, String AdresseLine2, String City, String State, String Telephone, String Fax, String Email, int creditLimit) {
        this.discountCode = discountCode;
        this.zip = zip;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.AdresseLine1 = AdresseLine1;
        this.AdresseLine2 = AdresseLine2;
        this.City = City;
        this.State = State;
        this.Telephone = Telephone;
        this.Fax = Fax;
        this.Email = Email;
        this.creditLimit = creditLimit;
    }

    public ClientEntity(int idClient, String Email) {
        this.idClient = idClient;
        this.Email = Email;
    }
    
    public ClientEntity(int idClient, String nom, String adresse, String ville, String etat, String tel, String fax, String Email) {
        this.idClient = idClient;
        this.Nom = nom;
        this.AdresseLine1 = adresse;
        this.City = ville;
        this.State = etat;
        this.Telephone = tel;
        this.Fax = fax;
        this.Email = Email;
    }

    public int getIdClient() {
        return idClient;
    }

    public char getDiscountCode() {
        return discountCode;
    }

    public String getZip() {
        return zip;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getAdresseLine1() {
        return AdresseLine1;
    }

    public String getAdresseLine2() {
        return AdresseLine2;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public String getTelephone() {
        return Telephone;
    }

    public String getFax() {
        return Fax;
    }

    public String getEmail() {
        return Email;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setDiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setAdresseLine1(String AdresseLine1) {
        this.AdresseLine1 = AdresseLine1;
    }

    public void setAdresseLine2(String AdresseLine2) {
        this.AdresseLine2 = AdresseLine2;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }
}