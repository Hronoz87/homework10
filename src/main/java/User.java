import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private final String _id;
    private final Name name;

    public User(
            @JsonProperty("_id") String _id,
            @JsonProperty("name") Name name
    ){
        this._id = _id;
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + _id + '\'' +
                ", name=" + name +
                '}';
    }
}
