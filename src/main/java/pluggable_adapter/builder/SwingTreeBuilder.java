package pluggable_adapter.builder;

import org.apache.commons.csv.CSVRecord;
import pluggable_adapter.model.Contest;
import pluggable_adapter.model.IDDefinedEntity;
import pluggable_adapter.model.Site;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.HashMap;
import java.util.Map;

public class SwingTreeBuilder implements IDDefinedEntityCollection.Builder {
    private Map<Long, DefaultMutableTreeNode>  id2Node = new HashMap<Long, DefaultMutableTreeNode>();

    private DefaultMutableTreeNode root;

    public void addRecord(CSVRecord record){
        Long id = Long.valueOf(record.get("ID"));
        String name = record.get("Name");
        String type = record.get("Type");
        Long parentId = !record.get("ParentContestID").equals("") ? Long.valueOf(record.get("ParentContestID")) : null;
        Integer attendees = !record.get("Attendees").equals("") ? Integer.valueOf(record.get("Attendees")) : 0;

        IDDefinedEntity entity;

        if(type.equals("Site")){
            entity = new Site(id, parentId, name, attendees);
        }
        else{
            entity = new Contest(id, parentId, name);
        }

        DefaultMutableTreeNode node = new DefaultMutableTreeNode(entity);
        if(id2Node.containsKey(parentId) && id2Node.get(parentId) != null)
            id2Node.get(parentId).add(node);
        id2Node.put(id, node);
        if(root == null) this.root = node;
    }

    public JTree getJTree(){
        return new JTree(root);
    }
}
