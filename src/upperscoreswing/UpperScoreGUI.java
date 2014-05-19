package upperscoreswing;
import UpperScore.*;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

public class UpperScoreGUI extends javax.swing.JFrame {

    public static JFrame main,note,shop,about;
    public static Belanja Shop;
    public static String market;
    public static Notes notes;
    
    // Constructor, menginisialisasi semua komponen swing dan membuat belanja baru
    public UpperScoreGUI() {
        initComponents();
        Shop = new Belanja();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UpperShop");
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        jButton1.setText("Notes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Shop");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("About Us");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/upperscoreswing/banner.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Menu :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Indomaret", "Alfamart" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3)))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Tombol Notes, memunculkan layar notes dan mengisikan list dengan notes
    // yang sudah ada
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        main.setVisible(false);
        int x = main.getX();
        int y = main.getY();
        note = new UpperScoreNotes();
        UpperScoreNotes.listModel = new DefaultListModel();
        for(String s : notes.getList())
        {
            UpperScoreNotes.listModel.addElement(s);
        }
        UpperScoreNotes.jList1.setModel(UpperScoreNotes.listModel);
        UpperScoreNotes.jTextField2.setText(notes.getBudget()+"");
        note.pack();
        note.setLocation(x, y);
        note.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Tombol Shop, membuka layar belanjaan, mengambil supermarket yang sudah
    // dipilih dan mengdisable combo box untuk memilih tempat belanja
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        main.setVisible(false);
        int x = main.getX();
        int y = main.getY();
        shop.pack();
        shop.setLocation(x, y);
        market = jComboBox1.getSelectedItem().toString();
        jComboBox1.setEnabled(false);
        Shop.setsupermarket(market);
        shop.setVisible(true);
        jComboBox1.setEditable(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Tombol About Us, berisi data kami yang membuat program ini
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        main.setVisible(false);
        int x = main.getX();
        int y = main.getY();
        about.pack();
        about.setLocation(x, y);
        about.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Program Utama, membuat seluruh GUI yang ada kecuali ReviewShopGUI
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                main = new UpperScoreGUI();
                note = new UpperScoreNotes();
                shop = new UpperScoreShop();
                about = new AboutUSGUI();
                main.setVisible(true);
                main.pack();
                main.setLocationRelativeTo(null);
                note.setVisible(false);
                shop.setVisible(false);
                about.setVisible(false);
                notes = new Notes();
                notes.setBudget(0);
                notes.load();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
