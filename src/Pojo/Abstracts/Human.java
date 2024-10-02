package Pojo.Abstracts;

public abstract class Human
{
    private String name;
    private String phoneNumber;

    public Human(String name, String phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void Human(String name,  String phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return this.phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
