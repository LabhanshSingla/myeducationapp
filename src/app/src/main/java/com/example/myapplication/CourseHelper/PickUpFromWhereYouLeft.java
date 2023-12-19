
package com.example.myapplication.CourseHelper;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;



public class PickUpFromWhereYouLeft implements Serializable
{


    private String name;

    private String url;

    private String offeredBy;

    private String courseimg;

    public String getCourseimg() {
        return courseimg;
    }

    public void setCourseimg(String courseimg) {
        this.courseimg = courseimg;
    }

    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    private final static long serialVersionUID = -3391528235514948718L;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getOfferedBy() {
        return offeredBy;
    }


    public void setOfferedBy(String offeredBy) {
        this.offeredBy = offeredBy;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
