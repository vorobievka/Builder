public class PersonBuilder {

    private String name;
    private String surname;
    private String address;
    private int age;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) throws IllegalArgumentException {
       if(age < 0 | age > 150 ) {
           throw new IllegalArgumentException("Возраст недопустимый");
       }
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException  {
       if(name == null | surname == null){
           throw new IllegalStateException("Не хватает обязательных полей");
       }
        Person person = new Person(name, surname, age);
        if(address != null) {person.setAddress(address);}
        return person;
    }

}
