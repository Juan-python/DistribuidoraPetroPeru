/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DistribuidoraPetroPeru;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class facturacion extends javax.swing.JFrame {

    public facturacion() {
        initComponents();
        actualizarHistorialYFactura();
        setTitle("Emision de boleta");
        setLocationRelativeTo(null);
    }

    private void actualizarHistorialYFactura() {
        DefaultTableModel modelo = (DefaultTableModel) tablaEstados.getModel();
        modelo.setRowCount(0); 
        
        List<DistribuidoraPetroPeru.Pedido> pedidos = GestionPedidos.getInstance().getHistorialPedidos();
        
        for (DistribuidoraPetroPeru.Pedido p : pedidos) {
            modelo.addRow(new Object[]{
                p.getIdPedido(),
                p.getCliente(),
                String.format("S/ %.2f", p.getTotal()),
                p.getEstado() 
            });
        }

        DistribuidoraPetroPeru.Pedido ultimo = GestionPedidos.getInstance().getUltimoPedido();
        if (ultimo != null) {
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
            sb.append("=========================================\n");
            sb.append("        Petroperu DISTRIBUIDORA S.A.       \n");
            sb.append("           RUC: 20845391264              \n");
            sb.append("=========================================\n");
            sb.append("Factura N° : ").append(ultimo.getIdPedido()).append("\n");
            sb.append("Fecha Emisión: ").append(sdf.format(ultimo.getFecha())).append("\n");
            sb.append("Cliente    : ").append(ultimo.getCliente()).append("\n");
            sb.append("Estado Actual: ").append(ultimo.getEstado()).append("\n");
            sb.append("=========================================\n");
            sb.append(String.format("%-18s %-8s %-10s\n", "Combustible", "Cant.", "Subtotal"));
            sb.append("-----------------------------------------\n");
            
           for (Producto p : ultimo.getItems()) {
                sb.append(String.format("%-18s %-8.1f S/ %-8.2f\n", 
                        p.getTipoCombustible(), 
                        p.getCantidadGalones(), 
                        p.getSubtotal()));
            }
            
            sb.append("=========================================\n");
            sb.append(String.format("TOTAL A PAGAR:               S/ %.2f\n", ultimo.getTotal()));
            sb.append("=========================================\n");
            sb.append("     ¡Gracias por confiar en Petroperu!     \n");
            
            txtFacturaArea.setText(sb.toString());
        } else {
            txtFacturaArea.setText("No hay transacciones registradas en la sesión actual.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstados = new javax.swing.JTable();
        btnSimularRuta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtFacturaArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuInicio = new javax.swing.JMenu();
        jMenuCompra = new javax.swing.JMenu();
        jMenuCarrito = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Seguimiento y Estado de Pedidos en Curso");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Comprobante de Pago Electrónico (Última Venta)");

        tablaEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Factura", "Titular de Tarjeta", "Monto Total", "Estado de Entrega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEstados);

        btnSimularRuta.setText("Simular Avance de Despacho (Cambiar Estado)");
        btnSimularRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularRutaActionPerformed(evt);
            }
        });

        txtFacturaArea.setColumns(20);
        txtFacturaArea.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        txtFacturaArea.setRows(5);
        txtFacturaArea.setEditable(false);
        jScrollPane2.setViewportView(txtFacturaArea);

        jMenuInicio.setText("Inicio");
        jMenuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuInicioMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuInicio);

        jMenuCompra.setText("Comprar");
        jMenuCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuCompraMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuCompra);

        jMenuCarrito.setText("Carrito");
        jMenuCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuCarritoMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuCarrito);

        jMenuSalir.setText("Salir");
        jMenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimularRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSimularRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimularRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularRutaActionPerformed
        int fila = tablaEstados.getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un pedido de la tabla para actualizar su estado de envío.");
            return;
        }
        
        List<DistribuidoraPetroPeru.Pedido> pedidos = GestionPedidos.getInstance().getHistorialPedidos();
        DistribuidoraPetroPeru.Pedido p = pedidos.get(fila);
        
        if (p.getEstado().equals("Procesado")) {
            p.setEstado("En Ruta");
        } else if (p.getEstado().equals("En Ruta")) {
            p.setEstado("Entregado");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Este pedido ya fue entregado exitosamente en destino.");
        }
        
        actualizarHistorialYFactura(); 
    }//GEN-LAST:event_btnSimularRutaActionPerformed

    private void jMenuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuInicioMouseClicked
        Main inicio = new Main();
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuInicioMouseClicked

    private void jMenuCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuCompraMouseClicked
        PantallaDePedido compras = new PantallaDePedido();
        compras.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuCompraMouseClicked

    private void jMenuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirMouseClicked

    private void jMenuCarritoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuCarritoMouseClicked
        // TODO add your handling code here:
        Carrito ct = new Carrito();
        ct.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuCarritoMouseClicked

    private void jMenuComprarMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        CombustiblePrecio precios = new CombustiblePrecio();
        precios.setVisible(true);
        this.setVisible(false);
    }                                         

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new facturacion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimularRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCarrito;
    private javax.swing.JMenu jMenuCompra;
    private javax.swing.JMenu jMenuInicio;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEstados;
    private javax.swing.JTextArea txtFacturaArea;
    // End of variables declaration//GEN-END:variables

    private static class PantallaDePedido {

        public PantallaDePedido() {
        }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}