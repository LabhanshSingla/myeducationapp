
package com.example.myapplication.CourseHelper;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class Courses implements Serializable
{


    private List<PopularCourse> popularCourses;

    private List<PickUpFromWhereYouLeft> pickUpFromWhereYouLeft;

    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    private final static long serialVersionUID = 7633467943331354946L;


    public List<PopularCourse> getPopularCourses() {
        return popularCourses;
    }


    public void setPopularCourses(List<PopularCourse> popularCourses) {
        this.popularCourses = popularCourses;
    }


    public List<PickUpFromWhereYouLeft> getPickUpFromWhereYouLeft() {
        return pickUpFromWhereYouLeft;
    }


    public void setPickUpFromWhereYouLeft(List<PickUpFromWhereYouLeft> pickUpFromWhereYouLeft) {
        this.pickUpFromWhereYouLeft = pickUpFromWhereYouLeft;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
