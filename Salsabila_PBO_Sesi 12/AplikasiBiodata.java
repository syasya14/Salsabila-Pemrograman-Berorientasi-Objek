import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikasiBiodata extends JFrame {

    // Komponen Input
    private JTextField txtNim, txtNama, txtProdi;
    private JButton btnTampilkan, btnReset;
    
    // Komponen Output
    private JTextArea txtOutput;

    public AplikasiBiodata() {
        // Pengaturan Frame Utama
        setTitle("Aplikasi Biodata Mahasiswa");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. PANEL INPUT DATA
        JPanel panelInput = new JPanel();
        panelInput.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Input Data", TitledBorder.LEFT, TitledBorder.TOP));
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new java.awt.Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label & TextField NIM
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.1;
        panelInput.add(new JLabel("NIM"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.9;
        txtNim = new JTextField();
        panelInput.add(txtNim, gbc);

        // Label & TextField Nama
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.1;
        panelInput.add(new JLabel("Nama"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.9;
        txtNama = new JTextField();
        panelInput.add(txtNama, gbc);

        // Label & TextField Program Studi
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.1;
        panelInput.add(new JLabel("Program Studi"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.9;
        txtProdi = new JTextField();
        panelInput.add(txtProdi, gbc);

        // 2. PANEL TOMBOL (BUTTONS)
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnTampilkan = new JButton("Tampilkan");
        btnReset = new JButton("Reset");
        panelTombol.add(btnTampilkan);
        panelTombol.add(btnReset);

        // Menggabungkan Panel Input dan Tombol ke bagian atas (NORTH)
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelInput, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // 3. PANEL OUTPUT
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Output", TitledBorder.LEFT, TitledBorder.TOP));
        
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Agar format teks rapi sejajar
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        panelOutput.add(scrollPane, BorderLayout.CENTER);

        // Menambahkan semua panel utama ke Frame
        add(panelAtas, BorderLayout.NORTH);
        add(panelOutput, BorderLayout.CENTER);

        // --- LOGIKA EVENT HANDLER (ACTION LISTENER) ---

        // Aksi ketika tombol Tampilkan diklik
        btnTampilkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txtNim.getText();
                String nama = txtNama.getText();
                String prodi = txtProdi.getText();

                // Format cetak output sesuai contoh di gambar
                String hasil = "========== BIODATA MAHASISWA ==========\n\n"
                             + "NIM           : " + nim + "\n"
                             + "Nama          : " + nama + "\n"
                             + "Program Studi : " + prodi + "\n";
                
                txtOutput.setText(hasil);
            }
        });

        // Aksi ketika tombol Reset diklik
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengosongkan text area output
                txtOutput.setText("");
                // Opsional: Mengosongkan form input juga
                txtNim.setText("");
                txtNama.setText("");
                txtProdi.setText("");
                txtNim.requestFocus();
            }
        });
    }

    public static void main(String[] args) {
        // Menjalankan GUI di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplikasiBiodata().setVisible(true);
            }
        });
    }
}