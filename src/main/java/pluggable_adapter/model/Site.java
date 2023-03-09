package pluggable_adapter.model;

public class Site extends IDDefinedEntity{
    private String name;
    private Integer attendees;

    public Site(Long id, Long parentId, String name, Integer attendees){
        super(id, parentId);
        this.name = name;
        this.attendees = attendees;
    }


    @Override
    public String getInfo() {
        return "Name: " + name + "; Attendees: " + attendees;
    }

    @Override
    public String getType() {
        return "Site";
    }
}
