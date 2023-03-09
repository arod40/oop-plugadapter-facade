package pluggable_adapter.builder;

import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import java.awt.*;

public class SwingTreeBuilder implements IDDefinedEntityCollection.Builder {
    private String name;
    private String type;
    private Long id;
    private Long parentId;

    public void addRecord(CSVRecord record){
        this.id = Long.valueOf(record.get("ID"));
        this.name = record.get("Name");
        this.type = record.get("Type");
        this.parentId = !record.get("ParentContestID").equals("") ? Long.valueOf(record.get("ParentContestID")) : null;
    }

    public JPanel getJPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        panel.add(new JLabel("Name:"));
        panel.add(new JTextField(name));
        panel.add(new JLabel("Type:"));
        panel.add(new JTextField(type));
        panel.add(new JLabel("ID:"));
        panel.add(new JTextField(id.toString()));
        panel.add(new JLabel("Parent ID:"));
        panel.add(new JTextField(parentId.toString()));
        return panel;
    }
}
