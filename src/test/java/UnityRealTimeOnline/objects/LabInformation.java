package UnityRealTimeOnline.objects;

public class LabInformation {
    private String labNumber;
    private String description;
    private String labName;
    private String department;
    private String contact;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String areaCode;
    private String telephone;
    private String email;

    public LabInformation(){}

    public LabInformation(String labNumber, String description, String labName, String department,
                          String contact, String address, String city, String state, String postalCode,
                          String areaCode, String telephone, String email){
        this.labNumber = labNumber;
        this.description = description;
        this.labName = labName;
        this.department = department;
        this.contact = contact;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.areaCode = areaCode;
        this.telephone = telephone;
        this.email = email;
    }


    public String getLabNumber() {
        return labNumber;
    }

    public LabInformation setLabNumber(String labNumber) {
        this.labNumber = labNumber;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LabInformation setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLabName() {
        return labName;
    }

    public LabInformation setLabName(String labName) {
        this.labName = labName;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public LabInformation setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public LabInformation setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public LabInformation setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public LabInformation setCity(String city) {
        this.city = city;
        return  this;
    }

    public String getState() {
        return state;
    }

    public LabInformation setState(String state) {
        this.state = state;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public LabInformation setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public LabInformation setAreaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }


    public String getTelephone() {
        return telephone;
    }

    public LabInformation setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LabInformation setEmail(String email) {
        this.email = email;
        return this;
    }
}
