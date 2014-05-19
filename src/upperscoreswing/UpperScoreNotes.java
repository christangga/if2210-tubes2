package upperscoreswing;


import UpperScore.*;
import javax.swing.DefaultListModel;

public class UpperScoreNotes extends javax.swing.JFrame {

    public static DefaultListModel listModel;
    
    // Constructor, menginisialisasi semua komponen swing dan membuat list model untuk jList
    public UpperScoreNotes() {
        initComponents();
        listModel = new DefaultListModel();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notes");
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        jLabel1.setText("Notes");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField2.setText("0");

        jLabel2.setText("Budget");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25)
                                .addComponent(jTextField2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Tombol Back, jika kotak budget berisi nilai minus maka layar tidak akan
    // berpindah, jika kotak budget berisi kosong / 0, maka budget akan diset 0.
    // Jika budget berisi angka sesuatu, maka budget akan diset menjadi angka
    // itu kemudian kembali ke menu utama
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        assert(UpperScoreShop.isDigitAll(jTextField2.getText()));
        if(Integer.parseInt(jTextField2.getText().toString())<0)
        {
            UpperScoreShop.infoBox("Budget must not be below zero!","title bar message");
            jTextField2.setText("0");
        }
        else
        {
            UpperScoreGUI.note.setVisible(false);
            int x = UpperScoreGUI.note.getX();
            int y = UpperScoreGUI.note.getY();
            UpperScoreGUI.main.pack();
            UpperScoreGUI.main.setLocation(x, y);
            UpperScoreGUI.main.setVisible(true);
            if(!jTextField2.getText().toString().equalsIgnoreCase(""))
            {
                UpperScoreGUI.notes.setBudget(Integer.parseInt(jTextField2.getText().toString()));
            }
            else
            {
                UpperScoreGUI.notes.setBudget(0);
            }
            UpperScoreGUI.notes.save();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Tombol add, jika kata yang diinput sudah ada di list maka tidak akan
    // ditambahkan, jika tidak ada maka akan ditambahkan. List akan diupdate
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String s = jTextField1.getText();
        if(!UpperScoreGUI.notes.getList().contains(s))
        {
            UpperScoreGUI.notes.addList(s);
        }
        listModel.clear();
        for(String a : UpperScoreGUI.notes.getList())
        {
            listModel.addElement(a);
        }
        jList1.setModel(listModel);
        jTextField1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    // Tombol delete, menghapus index yang dipilih pada list
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int[] index = jList1.getSelectedIndices();
        String s = "";
        for(int i=index.length-1;i>=0;i--)
        {
            listModel.remove(index[i]);
            UpperScoreGUI.notes.delList(UpperScoreGUI.notes.getList().get(index[i]));
        }
        jList1.setModel(listModel);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Program utama
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UpperScoreNotes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
