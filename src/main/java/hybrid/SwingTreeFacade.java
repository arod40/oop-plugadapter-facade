package hybrid;

import pluggable_adapter.SwingDisplay;
import pluggable_adapter.builder.IDDefinedEntityCollection;
import pluggable_adapter.builder.SwingTreeBuilder;

import java.io.IOException;

public class SwingTreeFacade {
    // This method is acting as a Facade for the logic of building the tree and displaying it
    // The client only knows there is a csvPath they want to render and that
    // a render of the tree will pop up in a window
    public static void displayTree(String csvPath){
        SwingTreeBuilder gui = new SwingTreeBuilder();

        try {
            IDDefinedEntityCollection.construct(csvPath, gui);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new SwingDisplay(gui.getJPanel());
    }
}
