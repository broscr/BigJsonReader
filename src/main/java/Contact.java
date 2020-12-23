public class Contact {

    private String author_id;
    private String phone_name;
    private String phone_number;

    public Contact(){}

    public Contact(String author_id, String phone_name, String phone_number) {
        this.author_id = author_id;
        this.phone_name = phone_name;
        this.phone_number = phone_number;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getPhone_name() {
        return phone_name;
    }

    public void setPhone_name(String phone_name) {
        this.phone_name = phone_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "author_id='" + author_id + '\'' +
                ", phone_name='" + phone_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
