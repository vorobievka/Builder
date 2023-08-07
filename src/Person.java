import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    //...
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return this.age.isPresent();
    }

    public boolean hasAddress() {
        if (address != null) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age.getAsInt();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        int a = 0;
        if (this.age.isPresent()) {
            a = this.age.getAsInt();
        }
        a++;
        age = OptionalInt.of(a);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.surname.hashCode() + this.age.hashCode();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder son = new PersonBuilder();
        son.setSurname(getSurname());
        son.setAddress(getAddress());
        son.setAge(5);
        return son;
    }
}


