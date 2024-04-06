package entities.dtos;

public class RegisterRequestDto {

    private String fullName;
    private String email;
    private String cardNumber;
    private int pinCode;

    public RegisterRequestDto(String fullName, String email, String cardNumber, int pinCode) {
        this.fullName = fullName;
        this.email = email;
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
