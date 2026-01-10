package jm.task.core.jdbc.model;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкремент в MySQL
    private Long id;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private Byte age;
    public User() {

    }
    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }
    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return java.util.Objects.equals(id, user.id) &&
                java.util.Objects.equals(name, user.name) &&
                java.util.Objects.equals(lastName, user.lastName) &&
                java.util.Objects.equals(age, user.age);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name, lastName, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", lastName=" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}