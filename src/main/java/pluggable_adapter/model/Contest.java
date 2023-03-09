package pluggable_adapter.model;

public class Contest extends IDDefinedEntity{
    private String name;

    public Contest(Long id, Long parentId, String name) {
        super(id, parentId);
        this.name = name;
    }

    @Override
    public String getInfo() {
        return "Name: " + name;
    }

    @Override
    public String getType() {
        return "Contest";
    }
}
