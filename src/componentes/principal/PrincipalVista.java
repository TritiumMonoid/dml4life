/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.principal;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author tritiummonoid
 */
public class PrincipalVista extends javax.swing.JFrame 
        implements IPrincipalVista {
    
    private PrincipalPresentador presentador;
        
    /**
     * Creates new form PrincipalVista
     */
    public PrincipalVista(PrincipalPresentador presentador) {
        initComponents();
        this.presentador = presentador;
        presentador.setVista(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollBasesDeDatos = new javax.swing.JScrollPane();
        treeBasesDeDatos = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("dml4life");

        scrollBasesDeDatos.setViewportView(treeBasesDeDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollBasesDeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 334, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollBasesDeDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollBasesDeDatos;
    private javax.swing.JTree treeBasesDeDatos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cambioBasesDeDatos(List<String> basesDeDatos) {
        DefaultMutableTreeNode raiz = 
                new DefaultMutableTreeNode("Bases de datos");
        for (String baseDeDatos : basesDeDatos) {
            raiz.add(new DefaultMutableTreeNode(baseDeDatos));
        }
        DefaultTreeModel modelo = new DefaultTreeModel(raiz);
        treeBasesDeDatos.setModel(modelo);
    }

    @Override
    public void consultaInvalida() {
        JOptionPane.showMessageDialog(null, "Consulta inválida.");
    }

    @Override
    public void conexionFallida() {
        JOptionPane.showMessageDialog(null, "Conexión fallida.");
    }
}