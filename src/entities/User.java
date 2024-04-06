package entities;

public class User {

    private String fullName;
    private Card card;

    public User(String fullName, Card card) {
        this.fullName = fullName;
        this.card = card;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
