package com.module5;
import javax.persistence.*;

@Entity
@Table(name="to_do_items")

public class TaskData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="todo")
    private String todo;

    @Column(name="description")
    private String description;

    public TaskData() {
    }

    public TaskData(String todo, String description) {
        this.todo = todo;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskData[" +
                "id= " + id +
                ", todo= '" + todo + '\'' +
                ", desc= '" + description + '\'' +
                ']';
    }
}
