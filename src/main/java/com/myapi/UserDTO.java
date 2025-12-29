package com.myapi;

public class UserDTO {

// This class represents the JSON in the POST body.

    private String name;
    private Long id;

    // Default constructor
    public UserDTO() {
    }
// Having the default constructor commented out can be a problem if your JSON
// mapping library (like Jackson or Gson) requires a no-argument constructor to
// deserialize JSON into UserDTO. If you only have the parameterized constructor,
// deserialization may fail. If you do not need to deserialize JSON or use frameworks
// that require a no-arg constructor, it is not an issue. For most Java frameworks handling JSON,
// it is recommended to have a public no-argument constructor.

    public UserDTO(String name, Long id) {
        this.name = name;
        this.id = id;
        System.out.println(this);
    }

    // Getters and setters (also needed for JSON mapping)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
