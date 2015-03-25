package com.trainings.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement(name = "person")
public class PersonSearchDto {
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
