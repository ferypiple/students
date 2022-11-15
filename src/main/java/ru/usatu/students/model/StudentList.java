package ru.usatu.students.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
//XmlRootElement используется для аннотаций на уровне класса, соответствующих следующему элементу xml,
//часто с @XmlType и @XmlAccessorTypeиспользовать вместе.
@XmlRootElement(name = "students")
//@XmlAccessorType используется для указания метода доступа к свойствам объекта Java, когда файл XML создается объектом Java.
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentList {
//XmlElement отображает атрибуты java-объектов на узлы xml.
// При использовании @XmlElement вы можете изменять имена атрибутов java-объектов, отображаемых в xml, через атрибут name.
    @XmlElement(name= "student")
    private List<Student> students;

    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(List<Student> student){
        this.students=students;
    }
}
