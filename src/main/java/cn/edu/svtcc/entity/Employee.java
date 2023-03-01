package cn.edu.svtcc.entity;

import java.io.Serializable;

/**
 * 员工表(Employee)实体类
 *
 * @author makejava
 * @since 2023-03-01 11:27:31
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = -98039279586086617L;
    /**
     * 员工编号
     */
    private Long id;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工年龄
     */
    private Integer age;
    /**
     * 员工职位
     */
    private String position;

    public Employee() {
    }

    public Employee(Long id, String name, Integer age, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                '}';
    }
}

