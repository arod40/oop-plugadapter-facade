package pluggable_adapter;

import pluggable_adapter.builder.IDDefinedEntityCollection;
import pluggable_adapter.builder.SwingTreeBuilder;

import java.io.IOException;

public class TreeTest {
    public static void main(String[] args) {
        SwingTreeBuilder gui = new SwingTreeBuilder();

        try {
            IDDefinedEntityCollection.construct("src/test/resources/contests.csv", gui);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new SwingDisplay(gui.getJTree());
    }
}
