/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.principal;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

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
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablita = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("dml4life");
        setLocation(new java.awt.Point(400, 250));

        treeBasesDeDatos.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                mostrar(evt);
            }
        });
        scrollBasesDeDatos.setViewportView(treeBasesDeDatos);

        Tablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tablita.setName("Tablita"); // NOI18N
        jScrollPane1.setViewportView(Tablita);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollBasesDeDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollBasesDeDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrar(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_mostrar
 DefaultMutableTreeNode nodoSeleccionado;
nodoSeleccionado=(DefaultMutableTreeNode)treeBasesDeDatos.getLastSelectedPathComponent(); 
TreeNode BdT;
BdT=nodoSeleccionado.getParent();

   //JOptionPane.showMessageDialog(null,BdT.toString());     
        
        if(tablas.contains(nodoSeleccionado.toString()))
    {
     
       JOptionPane.showMessageDialog(null,"Ha seleccionado la tabla "+ nodoSeleccionado +" de la base de datos "+BdT);
       DefaultTableModel modelin;
       modelin= presentador.actualizarTbl(BdT.toString(), nodoSeleccionado.toString());
     Tablita.setModel(modelin);
    }
else
{
  JOptionPane.showMessageDialog(null,"Debe Seleccionar una tabla a cargar");

}

    }//GEN-LAST:event_mostrar

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tablita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrollBasesDeDatos;
    private javax.swing.JTree treeBasesDeDatos;
    // End of variables declaration//GEN-END:variables

    List<String> tablas=new ArrayList<String>();
    @Override
    public void cambioBasesDeDatos(List<BaseDeDatos> basesDeDatos) {
        DefaultMutableTreeNode raiz = 
                new DefaultMutableTreeNode("Bases de datos");
        for (BaseDeDatos baseDeDatos : basesDeDatos) {
            DefaultMutableTreeNode nodo = 
                    new DefaultMutableTreeNode(baseDeDatos.getNombre());
            for (Tabla tabla : baseDeDatos.getTablas()) {
                nodo.add(new DefaultMutableTreeNode(tabla.getNombre()));
                tablas.add(tabla.getNombre().toString());
            }
            raiz.add(nodo);
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
