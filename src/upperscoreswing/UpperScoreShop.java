package upperscoreswing;

import UpperScore.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UpperScoreShop extends javax.swing.JFrame{
    public static TableData TD;
    public JFrame review;
    
    // Constructor, menginisialisasi semua komponen swing, membuat tabel data
    // dan mengisi tabel kosong
    public UpperScoreShop() {
        initComponents();
        TD = new TableData();
        jTable2.setModel(TD);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shop");
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Shopping Mode");

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Finish");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Barcode");

        jLabel3.setText("Jumlah");

        jLabel6.setText("Total Harga : ");

        jTextField4.setEditable(false);
        jTextField4.setText("0");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, null}
            },
            new String [] {
                "Barcode", "Nama", "Quantity", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Set");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton5))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Tombol Back, kembali ke menu utama
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UpperScoreGUI.shop.setVisible(false);
        int x = UpperScoreGUI.shop.getX();
        int y = UpperScoreGUI.shop.getY();
        UpperScoreGUI.main.pack();
        UpperScoreGUI.main.setLocation(x, y);
        UpperScoreGUI.main.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Method untuk memunculkan messagebox berisi pesan kesalahan
    public static void infoBox(String infoMessage, String location)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Warning", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Method untuk mengecek apakah sebuah string terdiri dari angka semua
    public static boolean isDigitAll(String s)
    {
        char[] array = s.toCharArray();
        int i=0;
        boolean isdigit=true;
        while(i<array.length && isdigit)
        {
            if(!Character.isDigit(array[i]))
            {
                isdigit=false;
            }
            i++;
        }
        return isdigit;
    }
    
    // Tombol Add, Jika Barcode yang diinput belum ada di list belanjaan maka
    // barang akan ditambahkan ke tabel, jika sudah ada, maka jumlah barang
    // tersebut akan bertambah sesuai quantity yang diinput pada jSpinner.
    // Akan menampilkan pesan kesalahan jika quantity yang diinput <= 0.
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        assert(isDigitAll(jTextField1.getText()));
        if(!jTextField1.getText().equalsIgnoreCase(""))
        {
            // 8990057408305
            // 8990057426040
            int jumlah = Integer.parseInt(jSpinner1.getValue().toString());
            Barcode bartemp = new Barcode(jTextField1.getText());
            if(jumlah>0)
            {
                try{
                    UpperScoreGUI.Shop.addBelanja(bartemp, jumlah);
                }
                catch(Exception e)
                {
                    UpperScoreShop.infoBox(e.getMessage(),"title bar message");
                }
            }
            else
            {
                UpperScoreShop.infoBox("Quantity must be above zero!","title bar message");
            }
            UpdatePage();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Tombol Delete, akan menghapus index belanjaan yang dipilih di tabel
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int[] index = jTable2.getSelectedRows();
        if(index.length!=0 && !UpperScoreGUI.Shop.getshoppingList().isEmpty())
        {
            for(int i=index.length-1;i>=0;i--)
            {
                UpperScoreGUI.Shop.delBelanja(index[i]);
            }
        }
        UpdatePage();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Tombol Finish, menandakan sudah selesai belanja dan berpindah ke layar
    // ReviewShop
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        UpperScoreGUI.shop.setVisible(false);
        int x = UpperScoreGUI.shop.getX();
        int y = UpperScoreGUI.shop.getY();
        review = new ReviewShopGUI();
        review.pack();
        review.setLocation(x, y);
        review.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Tombol Set, mencari barcode yang diinput pada tabel, jika ketemu maka
    // jumlah barang tersebut akan diubah menjadi inputan, jika tidak ketemu
    // maka tabel tidak akan berubah.
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(!jTextField1.getText().equalsIgnoreCase(""))
        {
            int jumlah = Integer.parseInt(jSpinner1.getValue().toString());
            Barcode bartemp = new Barcode(jTextField1.getText());
            if(jumlah>0)
            {
                int i=0;
                boolean found=false;
                while(i<UpperScoreGUI.Shop.getshoppingList().size() && !found)
                {
                    if(UpperScoreGUI.Shop.getshoppingList().get(i).getBarcode().getId().equalsIgnoreCase(bartemp.getId()))
                    {
                        found = true;
                    }
                    else
                    {
                        i++;
                    }
                }
                if(found)
                {
                    UpperScoreGUI.Shop.getshoppingList().get(i).setQuantity(jumlah);
                }
            }
            else
            {
                UpperScoreShop.infoBox("Quantity must be above zero!","title bar message");
            }
            UpdatePage();
        }
    }//GEN-LAST:event_jButton5ActionPerformed
   
    // Method untuk mengupdate tabel, serta field - field pada layar menjadi
    // yang terbaru
    public void UpdatePage()
    {
        TD.RefreshTable(UpperScoreGUI.Shop);
        jTable2.setModel(TD);
        jTextField1.setText("");
        jSpinner1.setValue(0);
        int hargatotal = UpperScoreGUI.Shop.totalHarga();
        jTextField4.setText(hargatotal+"");
    }
    
    // Program Utama
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UpperScoreShop().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}