package io.skysail.server.app.storymapper.story;

import java.io.Serializable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.*;

import java.util.*;
import io.skysail.server.db.DbClassName;
import io.skysail.domain.Identifiable;
import io.skysail.domain.html.*;
import io.skysail.server.forms.*;

import io.skysail.server.app.storymapper.map.*;
import io.skysail.server.app.storymapper.map.resources.*;
import io.skysail.server.app.storymapper.story.*;
import io.skysail.server.app.storymapper.story.resources.*;


import org.apache.commons.lang3.StringUtils;

/**
 * generated from javafile.stg
 */
@SuppressWarnings("serial")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Story implements Identifiable, Serializable {

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
    private String title;

    public void setTitle(String value) {
        this.title = value;
    }

    public String getTitle() {
        return this.title;
    }

    @Field(inputType = InputType.TRIX_EDITOR, htmlPolicy = HtmlPolicy.TRIX_EDITOR)
    private String story;

    public void setStory(String value) {
        this.story = value;
    }

    public String getStory() {
        return this.story;
    }


    // --- relations ---



}