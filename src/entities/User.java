package entities;

public class User {

    private String email;
    private String phoneNumber;
    private Card card;

    public User(String email, String phoneNumber, Card card) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.card = card;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
