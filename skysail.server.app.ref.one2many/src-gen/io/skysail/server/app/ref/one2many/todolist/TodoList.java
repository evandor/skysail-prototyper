package io.skysail.server.app.ref.one2many.todolist;

import java.io.Serializable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.*;

import java.util.*;
import io.skysail.server.db.DbClassName;
import io.skysail.domain.Identifiable;
import io.skysail.domain.html.*;
import io.skysail.server.forms.*;

import io.skysail.server.app.ref.one2many.todolist.*;
import io.skysail.server.app.ref.one2many.todolist.resources.*;
import io.skysail.server.app.ref.one2many.todo.*;
import io.skysail.server.app.ref.one2many.todo.resources.*;


import org.apache.commons.lang3.StringUtils;

/**
 * generated from javafile.stg
 */
@SuppressWarnings("serial")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class TodoList implements Identifiable, Serializable {

    @Id
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    // --- fields ---

    @Field(inputType = InputType.TEXT, htmlPolicy = HtmlPolicy.NO_HTML)
    @ListView(link = TodosResourceGen.class)
    private String listname;

    public void setListname(String value) {
        this.listname = value;
    }

    public String getListname() {
        return this.listname;
    }

    @Field(inputType = InputType.TEXTAREA, htmlPolicy = HtmlPolicy.NO_HTML)
    @ListView(link = TodosResourceGen.class)
    private String description;

    public void setDescription(String value) {
        this.description = value;
    }

    public String getDescription() {
        return this.description;
    }


    // --- relations ---

    @Relation
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
    private List<io.skysail.server.app.ref.one2many.todo.Todo> todos = new ArrayList<>();

    public void setTodos(List<io.skysail.server.app.ref.one2many.todo.Todo> value) {
        this.todos = value;
    }

    public List<io.skysail.server.app.ref.one2many.todo.Todo> getTodos() {
        return todos;
    }




}