package Employer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkPlace implements Serializable {
    List<Employer> list = new ArrayList<>();

    public WorkPlace(List<Employer> list) {
        Objects.requireNonNull(list);
        this.list = List.copyOf(list); //FONTOS!! így kívülről nem tudnak belenyúlni a listába
    }

    @Override
    public String toString() {
        return "WorkPlace{ " + list +
                '}';
    }
}
