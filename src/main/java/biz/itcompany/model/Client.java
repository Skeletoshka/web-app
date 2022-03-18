package biz.itcompany.model;

import jdk.jfr.Description;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "client")
public class Client {

    @Id
    @Column(name = "client_id", nullable = false)
    private Integer clientId;

    @Column(name = "client_companyname", nullable = false)
    @NotNull(message = "Поле \"Имя компании\" не может быть пустым")
    @Size(max=30, message = "Поле \"Имя компании\" не может содержать больше {max} символов")
    private Integer clientCompanyName;

    @Column(name = "client_city")
    @NotNull(message = "Поле \"Город компании\" не может быть пустым")
    @Size(max=20, message = "Поле \"Город компании\" не может содержать больше {max} символов")
    private Integer clientCity;

    @Column(name = "client_street")
    @NotNull(message = "Поле \"Улица компании\" не может быть пустым")
    @Size(max=30, message = "Поле \"Улица компании\" не может содержать больше {max} символов")
    private Integer clientTown;

    @Column(name = "client_house")
    @NotNull(message = "Поле \"Дом компании\" не может быть пустым")
    @Size(max=5, message = "Поле \"Дом компании\" не может содержать больше {max} символов")
    private Integer clientHouse;

    @Column(name = "client_phonenumber")
    @NotNull(message = "Поле \"Телефон компании\" не может быть пустым")
    @Size(max=11, message = "Поле \"Телефон компании\" не может содержать больше {max} символов")
    private Integer clientPhoneNumber;

    @Column(name = "client_email")
    @NotNull(message = "Поле \"Имя компании\" не может быть пустым")
    @Size(max=30, message = "Поле \"Имя компании\" не может содержать больше {max} символов")
    private Integer clientEmail;

    @Column(name = "client_lastname")
    @NotNull(message = "Поле \"Имя компании\" не может быть пустым")
    @Size(max=20, message = "Поле \"Имя компании\" не может содержать больше {max} символов")
    private Integer clientLastName;

    @Column(name = "client_name")
    @NotNull(message = "Поле \"Имя компании\" не может быть пустым")
    @Size(max=20, message = "Поле \"Имя компании\" не может содержать больше {max} символов")
    private Integer clientName;

    @Column(name = "client_middlename")
    @NotNull(message = "Поле \"Имя компании\" не может быть пустым")
    @Size(max=20, message = "Поле \"Имя компании\" не может содержать больше {max} символов")
    private Integer clientMiddleName;

    public Client(Integer clientId,
                  Integer clientCompanyName,
                  Integer clientCity,
                  Integer clientTown,
                  Integer clientHouse,
                  Integer clientPhoneNumber,
                  Integer clientEmail,
                  Integer clientLastName,
                  Integer clientName,
                  Integer clientMiddleName) {
        this.clientId = clientId;
        this.clientCompanyName = clientCompanyName;
        this.clientCity = clientCity;
        this.clientTown = clientTown;
        this.clientHouse = clientHouse;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
        this.clientLastName = clientLastName;
        this.clientName = clientName;
        this.clientMiddleName = clientMiddleName;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getClientCompanyName() {
        return clientCompanyName;
    }

    public void setClientCompanyName(Integer clientCompanyName) {
        this.clientCompanyName = clientCompanyName;
    }

    public Integer getClientCity() {
        return clientCity;
    }

    public void setClientCity(Integer clientCity) {
        this.clientCity = clientCity;
    }

    public Integer getClientTown() {
        return clientTown;
    }

    public void setClientTown(Integer clientTown) {
        this.clientTown = clientTown;
    }

    public Integer getClientHouse() {
        return clientHouse;
    }

    public void setClientHouse(Integer clientHouse) {
        this.clientHouse = clientHouse;
    }

    public Integer getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(Integer clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public Integer getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(Integer clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Integer getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(Integer clientLastName) {
        this.clientLastName = clientLastName;
    }

    public Integer getClientName() {
        return clientName;
    }

    public void setClientName(Integer clientName) {
        this.clientName = clientName;
    }

    public Integer getClientMiddleName() {
        return clientMiddleName;
    }

    public void setClientMiddleName(Integer clientMiddleName) {
        this.clientMiddleName = clientMiddleName;
    }
}
