import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {

    private final String first;
    private final String last;

    public Name(
            @JsonProperty("first") String first,
            @JsonProperty("last") String last
    ) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

}

