package com.afourtech.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Represents a specific category's information that includes a list of all its possible attributes,
 * of whose values listings can populate, and a map of children category objects. i.e. A subtree of
 * the entire category tree. (Its parents contains a list of its parent ids useful for fetching
 * another parent subtree.)
 */

//@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryData {
  public CategoryData() {
  }

  @JsonInclude(Include.NON_NULL)
  private String id;

  @JsonInclude(Include.NON_NULL)
  private Integer level;

  @JsonInclude(Include.NON_NULL)
  private String label;

  @JsonInclude(Include.NON_NULL)
  private List<String> parents;

  private boolean active;

  public CategoryData(boolean active, Map<String, CategoryData> children) {
    this.active = active;
    this.children = children;
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<CategoryAttributeData> attributes;

  @JsonInclude(Include.NON_NULL)
  private Map<String, CategoryData> children;

  //Level 2 Attribute
  public CategoryData(String id, Integer level, String label, List<String> parents, boolean active, Map<String, CategoryData> children) {
    this.id = id;
    this.level = level;
    this.label = label;
    this.parents = parents;
    this.active = active;
    this.children = children;
  }

  public CategoryData(String id, Integer level, String label, List<String> parents, boolean active, List<CategoryAttributeData> attributes) {
    this.id = id;
    this.level = level;
    this.label = label;
    this.parents = parents;
    this.active = active;
    this.attributes = attributes;
  }

  @Override
  public String toString() {
    return "categoryData: {" +
            "id='" + id + '\'' +
            ", level=" + level +
            ", label='" + label + '\'' +
            ", parents=" + parents +
            ", active=" + active +
            ", attributes=" + attributes +
            ", children=" + children +
            '}';
  }

  /**
   * @deccription For Level 1 catagory
   */
  public CategoryData(String id, Integer level, String label, boolean active, Map<String, CategoryData> children) {
    this.id = id;
    this.level = level;
    this.label = label;
    this.active = active;
    this.children = children;
  }
  /**
   * @deccription For Level 3 catagory
   */


 /* public CategoryData() {
  }*/

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getParentId(Integer level) {
    if (parents == null) {
      return null;
    } else if (parents.size() < level) {
      return null;
    }
    return parents.get(level - 1);
  }

  public List<String> getParents() {
    return parents;
  }

  public void setParents(List<String> parents) {
    this.parents = parents;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public List<CategoryAttributeData> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<CategoryAttributeData> attributes) {
    this.attributes = attributes;
  }

  public Map<String, CategoryData> getChildren() {
    return children;
  }

  public CategoryData getChild(String categoryId) {
    if (this.children == null) {
      return null;
    }
    return children.get(categoryId);
  }

  public void setChild(String childId, CategoryData child) {
    if (this.children == null) {
      this.children = new HashMap<>();
    }
    this.children.put(childId, child);
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (!(o instanceof CategoryData)) {
//      return false;
//    }
//    CategoryData that = (CategoryData) o;
//    return active == that.active &&
//        Objects.equals(id, that.id) &&
//        Objects.equals(level, that.level) &&
//        Objects.equals(label, that.label) &&
//        Objects.equals(parents, that.parents) &&
//        Objects.equals(attributes, that.attributes) &&
//        Objects.equals(children, that.children);
//  }
}
