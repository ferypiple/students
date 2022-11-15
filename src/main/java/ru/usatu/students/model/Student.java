package ru.usatu.students.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

//легковесный хранимый объект бизнес логики (persistent domain object).
// POJO класс связанный с базой данных  с помощью аннотации (@Entity) или через XML.
@Entity
//@Table — указывает на имя таблицы, которая будет отображаться в этой сущности.
@Table(name="students")
//@XmlAccessorType используется для указания метода доступа к свойствам объекта Java, когда файл XML создается объектом Java.
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
//Hibernate отобразит атрибут id, помеченный аннотацией @Id, в столбец с названием ID.
    @Id
//XmlElement отображает атрибуты java-объектов на узлы xml.
// При использовании @XmlElement вы можете изменять имена атрибутов java-объектов, отображаемых в xml, через атрибут name.
    @XmlElement(name="id")
    private int id;
//Настраиваемое сопоставление обеспечивается JPA-аннотацией @Column(name="name"),
// которая позволяет произвести более тонкую настройку проецирования свойства класса в колонку таблицы базы данных.
    @Column(name = "name")
//XmlElement отображает атрибуты java-объектов на узлы xml.
// При использовании @XmlElement вы можете изменять имена атрибутов java-объектов, отображаемых в xml, через атрибут name.
    @XmlElement(name="name")
    private String name;

    public Student(){

    }
    public Student(int id,String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {return Objects.hash(id);}



}
