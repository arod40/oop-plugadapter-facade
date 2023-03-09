package pluggable_adapter;

import pluggable_adapter.model.IDDefinedEntity;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class SwingDisplay{
    private JFrame frame;
    private JTree tree;

    public SwingDisplay(JTree tree){
        this.tree = tree;
        initComponents();
        layoutComponents();
        show();
    }

    private void show(){ frame.setVisible(true); }

    private void initComponents(){
        frame = new JFrame("Tree display");
        tree.setCellRenderer(new CustomTreeCellRenderer());
    }

    private void layoutComponents(){
        frame.add(tree, BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    private class CustomTreeCellRenderer extends DefaultTreeCellRenderer {
        private ImageIcon redIcon;
        private ImageIcon blueIcon;

        public CustomTreeCellRenderer(){
            redIcon = resizeImageIcon(new ImageIcon("src/main/resources/red.png"));
            blueIcon = resizeImageIcon(new ImageIcon("src/main/resources/blue.png"));
        }

        private ImageIcon resizeImageIcon(ImageIcon imageIcon){
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            return new ImageIcon(newimg);  // transform it back
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, exp, leaf, row, hasFocus);
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            IDDefinedEntity entity = (IDDefinedEntity) node.getUserObject();
            if (entity.getType().equals("Site")) {
                this.setIcon(redIcon);
            } else {
                this.setIcon(blueIcon);
            }
            return this;
        }
    }
}
