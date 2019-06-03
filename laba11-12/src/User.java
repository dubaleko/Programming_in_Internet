public class  User
{
    String Name, Phone, Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    User(String name, String phone, String email)
    {
        this.Email = email;
        this.Name = name;
        this.Phone = phone;
    }
}