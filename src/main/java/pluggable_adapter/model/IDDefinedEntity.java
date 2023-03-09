package pluggable_adapter.model;


public abstract class IDDefinedEntity {
    private Long id;

    private Long parentId;

    public IDDefinedEntity(Long id, Long parentId){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getParentId() {
        return parentId;
    }

    public abstract String getType();
}
