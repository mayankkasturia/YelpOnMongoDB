
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mayankkasturia
 */
public class HW3 extends javax.swing.JFrame {

    private static String url;
    private static String uname;
    private static String password;
    public static Boolean label;
    private static Connection con = null;
    private static Statement stm = null;
    private static PreparedStatement preparedStatement = null;

    public static ArrayList<String> finalCat;
    public static ArrayList<String> finalCat1;
    public static String fromCheckin;
    public static String fromCheckinHour;
    public static String toCheckin;
    public static String toCheckinHour;
    public static String operationCheckin;
    public static String valueCheckin;
    public static String operationStar;
    public static String operationVote;
    public static String valueStar;
    public static String valueVote;
    public static String fromReview;
    public static String toReview;
    public static String updatedQuery;

    /**
     * Creates new form dbGui
     */
    public HW3() throws SQLException {
        initComponents();
        url = "jdbc:oracle:thin:@localhost:1523:orcl123";
        uname = "sys as sysdba";
        password = "Mansimalik2402";

        label = true;
        finalCat = new ArrayList<>();
        finalCat1 = new ArrayList<String>();
//        query = new StringBuffer("SELECT DISTINCT I.NAME,I.CITY, I.STATE, I.STARS,C.B_CATEGORY,S.B_SUBCATEGORY \n"
//                + "FROM B_INFO I,B_CAT C,B_SUBCAT S,B_CHECKIN CH,B_REVIEW R\n"
//                + "WHERE I.B_ID=C.B_ID AND C.B_ID=S.B_ID AND S.B_ID=CH.B_ID AND CH.B_ID=R.B_ID\n"
//                + "AND ");
        fromCheckin = "";
        fromCheckinHour = "";
        toCheckin = "";
        toCheckinHour = "";
        operationCheckin = "";
        valueCheckin = "";
        operationStar = null;
        operationVote = null;
        valueStar = null;
        valueVote = null;
        fromReview = null;
        toReview = null;
        updatedQuery = null;
        con = DriverManager.getConnection(url, uname, password);
        checkinValueTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text();
            }

            public void text() {
                valueCheckin = checkinValueTextField.getText();
                //System.out.println(valueCheckin);
            }

        });
        starsValueTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text();
            }

            public void text() {
                valueStar = starsValueTextField.getText();
                //System.out.println(valueStar);
            }

        });

        votesValueTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text();
            }

            public void text() {
                valueVote = votesValueTextField.getText();
                //System.out.println(valueVote);
            }

        });
        fromReview = ((JTextField) fromReviewDate.getDateEditor().getUiComponent()).getText();
        System.out.println(fromReview);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        dbCategory = new javax.swing.JPanel();
        checkinLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        subCategoryLabel = new javax.swing.JLabel();
        checkinPanel = new javax.swing.JPanel();
        fromLabel = new javax.swing.JLabel();
        fromComboBox = new javax.swing.JComboBox();
        toLabel = new javax.swing.JLabel();
        toComboBox = new javax.swing.JComboBox();
        fromHourComboBox = new javax.swing.JComboBox();
        toHourComboBox = new javax.swing.JComboBox();
        noCheckinLabel = new javax.swing.JLabel();
        checkinValueComboBox = new javax.swing.JComboBox();
        checkinValueTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        reviewPanel = new javax.swing.JPanel();
        fromReviewLabel = new javax.swing.JLabel();
        toReviewLabel = new javax.swing.JLabel();
        starsLabel = new javax.swing.JLabel();
        starsComboBox = new javax.swing.JComboBox();
        starValueLabel = new javax.swing.JLabel();
        starsValueTextField = new javax.swing.JTextField();
        votesLabel = new javax.swing.JLabel();
        votesComboBox = new javax.swing.JComboBox();
        votesValueLabel = new javax.swing.JLabel();
        votesValueTextField = new javax.swing.JTextField();
        fromReviewDate = new com.toedter.calendar.JDateChooser();
        toReviewDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        checkinPanel1 = new javax.swing.JPanel();
        fromLabel1 = new javax.swing.JLabel();
        fromComboBox1 = new javax.swing.JComboBox();
        toLabel1 = new javax.swing.JLabel();
        toComboBox1 = new javax.swing.JComboBox();
        fromHourComboBox1 = new javax.swing.JComboBox();
        toHourComboBox1 = new javax.swing.JComboBox();
        noCheckinLabel1 = new javax.swing.JLabel();
        checkinValueComboBox1 = new javax.swing.JComboBox();
        checkinValueTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        categoryPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        subCategoryPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane8 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        queryLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        executeQueryButton = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dbCategory.setBackground(new java.awt.Color(204, 204, 255));
        dbCategory.setMaximumSize(new java.awt.Dimension(1099, 1239));

        checkinLabel.setBackground(new java.awt.Color(255, 255, 255));
        checkinLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        checkinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkinLabel.setText("Checkin");

        categoryLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        categoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoryLabel.setText("Category");

        subCategoryLabel.setBackground(new java.awt.Color(255, 255, 255));
        subCategoryLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        subCategoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subCategoryLabel.setText("SubCategory");

        checkinPanel.setBackground(new java.awt.Color(255, 255, 255));
        checkinPanel.setAutoscrolls(true);

        fromLabel.setBackground(new java.awt.Color(255, 255, 255));
        fromLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fromLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fromLabel.setLabelFor(fromComboBox);
        fromLabel.setText("From");

        fromComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fromComboBox.setMaximumRowCount(8);
        fromComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Day", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        fromComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromComboBoxMouseClicked(evt);
            }
        });
        fromComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromComboBoxActionPerformed(evt);
            }
        });

        toLabel.setBackground(new java.awt.Color(255, 255, 255));
        toLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        toLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toLabel.setLabelFor(toComboBox);
        toLabel.setText("to");

        toComboBox.setMaximumRowCount(8);
        toComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Day", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        toComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toComboBoxActionPerformed(evt);
            }
        });

        fromHourComboBox.setMaximumRowCount(10);
        fromHourComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Time","00.00.00", "01.00.00", "02.00.00", "03.00.00", "04.00.00", "05.00.00", "06.00.00", "07.00.00", "08.00.00", "09.00.00", "10.00.00", "11.00.00", "12.00.00", "13.00.00", "14.00.00", "15.00.00", "16.00.00", "17.00.00", "18.00.00", "19.00.00", "20.00.00", "21.00.00", "22.00.00", "23.00.00", "24.00.00" }));
        fromHourComboBox.setAutoscrolls(true);
        fromHourComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromHourComboBoxActionPerformed(evt);
            }
        });

        toHourComboBox.setMaximumRowCount(10);
        toHourComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Time", "00.00.00", "01.00.00", "02.00.00", "03.00.00", "04.00.00", "05.00.00", "06.00.00", "07.00.00", "08.00.00", "09.00.00", "10.00.00", "11.00.00", "12.00.00", "13.00.00", "14.00.00", "15.00.00", "16.00.00", "17.00.00", "18.00.00", "19.00.00", "20.00.00", "21.00.00", "22.00.00", "23.00.00", "24.00.00" }));
        toHourComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toHourComboBoxActionPerformed(evt);
            }
        });

        noCheckinLabel.setBackground(new java.awt.Color(255, 255, 255));
        noCheckinLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        noCheckinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noCheckinLabel.setLabelFor(fromComboBox);
        noCheckinLabel.setText("Number of Checkins:");

        checkinValueComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select =,>,<", "=", ">", "<" }));
        checkinValueComboBox.setToolTipText("");
        checkinValueComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinValueComboBoxActionPerformed(evt);
            }
        });

        checkinValueTextField.setPreferredSize(new java.awt.Dimension(78, 26));
        checkinValueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinValueTextFieldActionPerformed(evt);
            }
        });
        checkinValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                checkinValueTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout checkinPanelLayout = new javax.swing.GroupLayout(checkinPanel);
        checkinPanel.setLayout(checkinPanelLayout);
        checkinPanelLayout.setHorizontalGroup(
            checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkinPanelLayout.createSequentialGroup()
                        .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(toComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fromComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fromHourComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toHourComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(checkinPanelLayout.createSequentialGroup()
                        .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromLabel)
                            .addComponent(toLabel)
                            .addComponent(noCheckinLabel)
                            .addGroup(checkinPanelLayout.createSequentialGroup()
                                .addComponent(checkinValueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(checkinValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        checkinPanelLayout.setVerticalGroup(
            checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fromLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(noCheckinLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkinValueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkinValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Review");

        reviewPanel.setBackground(new java.awt.Color(255, 255, 255));
        reviewPanel.setAutoscrolls(true);

        fromReviewLabel.setBackground(new java.awt.Color(255, 255, 255));
        fromReviewLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fromReviewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fromReviewLabel.setText("From");

        toReviewLabel.setBackground(new java.awt.Color(255, 255, 255));
        toReviewLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        toReviewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toReviewLabel.setText("to");

        starsLabel.setBackground(new java.awt.Color(255, 255, 255));
        starsLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        starsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        starsLabel.setLabelFor(starsComboBox);
        starsLabel.setText("Stars");

        starsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select =,>,<","=", ">", "<" }));
        starsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starsComboBoxActionPerformed(evt);
            }
        });

        starValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        starValueLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        starValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        starValueLabel.setLabelFor(starsValueTextField);
        starValueLabel.setText("Values:");

        starsValueTextField.setPreferredSize(new java.awt.Dimension(78, 26));
        starsValueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starsValueTextFieldActionPerformed(evt);
            }
        });
        starsValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                starsValueTextFieldKeyTyped(evt);
            }
        });

        votesLabel.setBackground(new java.awt.Color(255, 255, 255));
        votesLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        votesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        votesLabel.setLabelFor(votesComboBox);
        votesLabel.setText("Votes");

        votesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select =,>,<", "=", ">", "<" }));
        votesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votesComboBoxActionPerformed(evt);
            }
        });

        votesValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        votesValueLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        votesValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        votesValueLabel.setLabelFor(votesValueTextField);
        votesValueLabel.setText("Values:");

        votesValueTextField.setPreferredSize(new java.awt.Dimension(78, 26));
        votesValueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votesValueTextFieldActionPerformed(evt);
            }
        });
        votesValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                votesValueTextFieldKeyTyped(evt);
            }
        });

        fromReviewDate.setDateFormatString("MM/dd/yy");
        fromReviewDate.setName("");
        fromReviewDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromReviewDateMouseClicked(evt);
            }
        });
        fromReviewDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fromReviewDatePropertyChange(evt);
            }
        });

        toReviewDate.setDateFormatString("MM/dd/yy");
        toReviewDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toReviewDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout reviewPanelLayout = new javax.swing.GroupLayout(reviewPanel);
        reviewPanel.setLayout(reviewPanelLayout);
        reviewPanelLayout.setHorizontalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewPanelLayout.createSequentialGroup()
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(starsLabel)
                            .addComponent(starValueLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(starsValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(starsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(reviewPanelLayout.createSequentialGroup()
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(votesLabel)
                            .addComponent(votesValueLabel))
                        .addGap(30, 30, 30)
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(votesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(votesValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(reviewPanelLayout.createSequentialGroup()
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromReviewLabel)
                            .addComponent(toReviewLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromReviewDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toReviewDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );
        reviewPanelLayout.setVerticalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromReviewLabel)
                    .addComponent(fromReviewDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toReviewLabel)
                    .addComponent(toReviewDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(starsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(starValueLabel)
                    .addComponent(starsValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(votesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(votesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(votesValueLabel)
                    .addComponent(votesValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Result Table");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sql Query");

        checkinPanel1.setBackground(new java.awt.Color(255, 255, 255));
        checkinPanel1.setAutoscrolls(true);

        fromLabel1.setBackground(new java.awt.Color(255, 255, 255));
        fromLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fromLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fromLabel1.setLabelFor(fromComboBox);
        fromLabel1.setText("From");

        fromComboBox1.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fromComboBox1.setMaximumRowCount(7);
        fromComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));

        toLabel1.setBackground(new java.awt.Color(255, 255, 255));
        toLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        toLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toLabel1.setLabelFor(toComboBox);
        toLabel1.setText("to");

        toComboBox1.setMaximumRowCount(7);
        toComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        toComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toComboBox1ActionPerformed(evt);
            }
        });

        fromHourComboBox1.setMaximumRowCount(10);
        fromHourComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00.00.00", "01.00.00", "02.00.00", "03.00.00", "04.00.00", "05.00.00", "06.00.00", "07.00.00", "08.00.00", "09.00.00", "10.00.00", "11.00.00", "12.00.00", "13.00.00", "14.00.00", "15.00.00", "16.00.00", "17.00.00", "18.00.00", "19.00.00", "20.00.00", "21.00.00", "22.00.00", "23.00.00", "24.00.00" }));
        fromHourComboBox1.setAutoscrolls(true);

        toHourComboBox1.setMaximumRowCount(10);
        toHourComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00.00.00", "01.00.00", "02.00.00", "03.00.00", "04.00.00", "05.00.00", "06.00.00", "07.00.00", "08.00.00", "09.00.00", "10.00.00", "11.00.00", "12.00.00", "13.00.00", "14.00.00", "15.00.00", "16.00.00", "17.00.00", "18.00.00", "19.00.00", "20.00.00", "21.00.00", "22.00.00", "23.00.00", "24.00.00" }));

        noCheckinLabel1.setBackground(new java.awt.Color(255, 255, 255));
        noCheckinLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        noCheckinLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noCheckinLabel1.setLabelFor(fromComboBox);
        noCheckinLabel1.setText("Number of Checkins:");

        checkinValueComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "=", ">", "<" }));
        checkinValueComboBox1.setToolTipText("");

        checkinValueTextField1.setPreferredSize(new java.awt.Dimension(78, 26));
        checkinValueTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinValueTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checkinPanel1Layout = new javax.swing.GroupLayout(checkinPanel1);
        checkinPanel1.setLayout(checkinPanel1Layout);
        checkinPanel1Layout.setHorizontalGroup(
            checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkinPanel1Layout.createSequentialGroup()
                        .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(toComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fromComboBox1, 0, 396, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fromHourComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toHourComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(checkinPanel1Layout.createSequentialGroup()
                        .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromLabel1)
                            .addComponent(toLabel1)
                            .addComponent(noCheckinLabel1)
                            .addGroup(checkinPanel1Layout.createSequentialGroup()
                                .addComponent(checkinValueComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(checkinValueTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        checkinPanel1Layout.setVerticalGroup(
            checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fromLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromHourComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toHourComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(noCheckinLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkinValueComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkinValueTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        categoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        DefaultListModel<String> listModel = new DefaultListModel<String>();
        jList1.setModel(listModel);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout categoryPanelLayout = new javax.swing.GroupLayout(categoryPanel);
        categoryPanel.setLayout(categoryPanelLayout);
        categoryPanelLayout.setHorizontalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        );
        categoryPanelLayout.setVerticalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(categoryPanel);

        subCategoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        DefaultListModel<String> listModel2 = new DefaultListModel<String>();
        jList2.setModel(listModel2);
        jScrollPane3.setViewportView(jList2);

        javax.swing.GroupLayout subCategoryPanelLayout = new javax.swing.GroupLayout(subCategoryPanel);
        subCategoryPanel.setLayout(subCategoryPanelLayout);
        subCategoryPanelLayout.setHorizontalGroup(
            subCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );
        subCategoryPanelLayout.setVerticalGroup(
            subCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(subCategoryPanel);

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(resultTable);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        queryLabel.setBackground(new java.awt.Color(255, 255, 255));
        queryLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        queryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        queryLabel.setLabelFor(executeQueryButton);
        queryLabel.setText("mk");
        queryLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(queryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(queryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("User");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        executeQueryButton.setText("Execute Query");
        executeQueryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeQueryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dbCategoryLayout = new javax.swing.GroupLayout(dbCategory);
        dbCategory.setLayout(dbCategoryLayout);
        dbCategoryLayout.setHorizontalGroup(
            dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dbCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE))
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkinPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(executeQueryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(checkinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkinPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dbCategoryLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(reviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dbCategoryLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))))
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );
        dbCategoryLayout.setVerticalGroup(
            dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dbCategoryLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkinPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11))
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addComponent(checkinPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(executeQueryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );

        jScrollPane6.setViewportView(dbCategory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkinValueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinValueTextFieldActionPerformed

    }//GEN-LAST:event_checkinValueTextFieldActionPerformed

    private void starsValueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_starsValueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_starsValueTextFieldActionPerformed

    private void votesValueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votesValueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_votesValueTextFieldActionPerformed

    private void toComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Day") {
            toCheckin = null;
        } else {
            toCheckin = a;
        }
        //System.out.println("Hour checkin :"+toCheckin);
    }//GEN-LAST:event_toComboBoxActionPerformed

    private void toComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toComboBox1ActionPerformed

    private void checkinValueTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinValueTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkinValueTextField1ActionPerformed

    private void fromComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fromComboBoxMouseClicked

    private void fromHourComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromHourComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Time") {
            fromCheckinHour = null;
        } else {
            fromCheckinHour = a;
        }
        //System.out.println("Hour checkin :"+fromCheckinHour);
    }//GEN-LAST:event_fromHourComboBoxActionPerformed

    private void fromComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Day") {
            fromCheckin = "";
        } else {
            fromCheckin = a;
        }
        // System.out.println("From checkin :"+fromCheckin);
    }//GEN-LAST:event_fromComboBoxActionPerformed

    private void toHourComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toHourComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Time") {
            toCheckinHour = null;
        } else {
            toCheckinHour = a;
        }
        //System.out.println("Hour checkin :"+toCheckinHour);
    }//GEN-LAST:event_toHourComboBoxActionPerformed

    private void checkinValueComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinValueComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Select =,>,<") {
            operationCheckin = null;
        } else {
            operationCheckin = a;
        }
        //System.out.println("Hour checkin :"+operationCheckin);
    }//GEN-LAST:event_checkinValueComboBoxActionPerformed

    private void checkinValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_checkinValueTextFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_checkinValueTextFieldKeyTyped

    private void starsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_starsComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Select =,>,<") {
            operationStar = null;
        } else {
            operationStar = a;
        }
        //System.out.println("Hour checkin :"+operationStar);
    }//GEN-LAST:event_starsComboBoxActionPerformed

    private void votesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votesComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Select =,>,<") {
            operationVote = null;
        } else {
            operationVote = a;
        }
        //System.out.println("Hour checkin :"+operationVote);
    }//GEN-LAST:event_votesComboBoxActionPerformed

    private void starsValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_starsValueTextFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_starsValueTextFieldKeyTyped

    private void votesValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_votesValueTextFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_votesValueTextFieldKeyTyped

    private void fromReviewDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromReviewDateMouseClicked

    }//GEN-LAST:event_fromReviewDateMouseClicked

    private void fromReviewDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fromReviewDatePropertyChange
        //System.out.println(evt.getNewValue().toString());
        fromReview = ((JTextField) fromReviewDate.getDateEditor().getUiComponent()).getText();
        System.out.println(fromReview);
    }//GEN-LAST:event_fromReviewDatePropertyChange

    private void toReviewDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_toReviewDatePropertyChange
        toReview = ((JTextField) toReviewDate.getDateEditor().getUiComponent()).getText();
        System.out.println(toReview);
    }//GEN-LAST:event_toReviewDatePropertyChange

    @SuppressWarnings("empty-statement")
    private void executeQueryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeQueryButtonActionPerformed
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
        }

        //nothing is selected
        if (finalCat.isEmpty()) {
            queryLabel.setText("Please select atleast one category from business");
        } //only cat selected
        else if (finalCat.size() > 0 && finalCat1.isEmpty()) {
            String query = "SELECT DISTINCT I.NAME,I.CITY, I.STATE, I.STARS,C.B_CATEGORY \n"
                    + "FROM B_INFO I,B_CAT C\n"
                    + "WHERE I.B_ID=C.B_ID \n"
                    + "AND C.B_CATEGORY= ?";
            ResultSet resultSet;
            for (String t : finalCat) {
                try {
                    preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1, t);
                    resultSet = preparedStatement.executeQuery();
                    //queryLabel.setText(query.toString());
                    while (resultSet.next()) {
                        for (int i = 1; i <= 5; i++) {
                            System.out.print(resultSet.getString(i) + "\t\t");
                            if (i == 5) {
                                System.out.println();
                            }
                        }
                        //String cat = resultSet.getString(1);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } //cat and subCat is selected
        else if (finalCat.size() > 0 && finalCat1.size() > 0) {
           
            if (!fromCheckin.isEmpty() && !fromCheckinHour.isEmpty() && !toCheckin.isEmpty() && !toCheckinHour.isEmpty()
                    && !operationCheckin.isEmpty() && !valueCheckin.isEmpty()) {
                System.out.println(fromCheckin);
                System.out.println(fromCheckinHour);
                System.out.println(toCheckin);
                System.out.println(toCheckinHour);
                System.out.println(operationCheckin);
                System.out.println(valueCheckin);
                int j=0;
                for (String t : finalCat) {
                    for (String s : finalCat1) {
                        System.out.println("I am in checkin box");
                     
                        String[] arrayDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
                        for (int i = 0; i < arrayDays.length; i++) {
                            if (fromCheckin == arrayDays[i]) {
                                j = i;
                            }}
//               System.out.println(j);         
                        int difference = CheckForDay(fromCheckin, toCheckin);
//                System.out.println(difference);
                        StringBuffer query1 = new StringBuffer(
                                "SELECT DISTINCT C.B_ID,I.name,I.CITY, I.STATE, I.STARS,C.B_CATEGORY,S.B_SUBCATEGORY \n"
                                + "from b_info I,b_cat C,b_subcat S\n"
                                + "where I.B_ID=C.B_ID and C.B_ID=S.B_ID and C.B_CATEGORY= ? and S.B_SUBCATEGORY= ? and C.B_ID in (  \n"
                                + "SELECT b_id FROM B_CHECKIN CH WHERE \n"
                                + "((CH.CHECKIN_DAY=? and TO_CHAR(CH.CHECKIN_TIME,'hh24.mi.ss') >= ?)");
                        if (difference > 0) {
                                for(int k=0;k<difference;k++){
                                j=j+1;
                                if(j==7){j=0;}
                                query1.append(" or CH.CHECKIN_DAY='"+arrayDays[j]+"'");
                                
                                }
                        }
                        
                        String fQuery= query1.toString()+"or (CH.CHECKIN_DAY=? and TO_CHAR(CH.CHECKIN_TIME,'hh24.mi.ss') <= ?))\n"
                                    + "group by b_id having sum(NUMBER_CHECKIN)"+operationCheckin+" ?)";
                        //System.out.println(fQuery);
                        try (PreparedStatement preparedStatement = con.prepareStatement(fQuery.toString())) {
                            preparedStatement.setString(1, t);
                            preparedStatement.setString(2, s);
                            preparedStatement.setString(3, fromCheckin);
                            preparedStatement.setString(4, fromCheckinHour);
                            preparedStatement.setString(5, toCheckin);
                            preparedStatement.setString(6, toCheckinHour);
                            preparedStatement.setString(7, valueCheckin);

                            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                                //queryLabel.setText(query.toString());
                                while (resultSet.next()) {
                                    for (int i = 1; i <= 7; i++) {
                                        System.out.print(resultSet.getString(i) + "\t\t");
                                        if (i == 7) {
                                            System.out.println();
                                        }
                                    }
                                    //String cat = resultSet.getString(1);

                                }
                            }

                        } catch (SQLException ex) {
                            Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }//for cat n subcat

            }//if
            else {

                String query = "SELECT DISTINCT I.NAME,I.CITY, I.STATE, I.STARS,C.B_CATEGORY,S.B_SUBCATEGORY \n"
                        + "FROM B_INFO I,B_CAT C,B_SUBCAT S\n"
                        + "WHERE I.B_ID=C.B_ID AND C.B_ID=S.B_ID \n"
                        + "AND C.B_CATEGORY= ? AND S.B_SUBCATEGORY= ?";

                //System.out.println(query.toString());
                for (String t : finalCat) {
                    for (String s : finalCat1) {
                        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                            preparedStatement.setString(1, t);
                            preparedStatement.setString(2, s);
                            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                                //queryLabel.setText(query.toString());
                                while (resultSet.next()) {
                                    for (int i = 1; i <= 6; i++) {
                                        System.out.print(resultSet.getString(i) + "\t\t");
                                        if (i == 6) {
                                            System.out.println();
                                        }
                                    }
                                    //String cat = resultSet.getString(1);
                                }
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }// for subcat
                }//for cat
            }
        } // end sub cat


    }//GEN-LAST:event_executeQueryButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HW3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HW3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HW3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HW3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HW3 jFrame;

                try {
                    jFrame = new HW3();
                    jFrame.setVisible(true);
                    jFrame.connect();
                    jFrame.pack();
                    jFrame.setVisible(true);

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JLabel checkinLabel;
    private javax.swing.JPanel checkinPanel;
    private javax.swing.JPanel checkinPanel1;
    private javax.swing.JComboBox checkinValueComboBox;
    private javax.swing.JComboBox checkinValueComboBox1;
    private javax.swing.JTextField checkinValueTextField;
    private javax.swing.JTextField checkinValueTextField1;
    private javax.swing.JPanel dbCategory;
    private javax.swing.JButton executeQueryButton;
    private javax.swing.JComboBox fromComboBox;
    private javax.swing.JComboBox fromComboBox1;
    private javax.swing.JComboBox fromHourComboBox;
    private javax.swing.JComboBox fromHourComboBox1;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel fromLabel1;
    private com.toedter.calendar.JDateChooser fromReviewDate;
    private javax.swing.JLabel fromReviewLabel;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel noCheckinLabel;
    private javax.swing.JLabel noCheckinLabel1;
    private javax.swing.JLabel queryLabel;
    private javax.swing.JTable resultTable;
    private javax.swing.JPanel reviewPanel;
    private javax.swing.JLabel starValueLabel;
    private javax.swing.JComboBox starsComboBox;
    private javax.swing.JLabel starsLabel;
    private javax.swing.JTextField starsValueTextField;
    private javax.swing.JLabel subCategoryLabel;
    private javax.swing.JPanel subCategoryPanel;
    private javax.swing.JComboBox toComboBox;
    private javax.swing.JComboBox toComboBox1;
    private javax.swing.JComboBox toHourComboBox;
    private javax.swing.JComboBox toHourComboBox1;
    private javax.swing.JLabel toLabel;
    private javax.swing.JLabel toLabel1;
    private com.toedter.calendar.JDateChooser toReviewDate;
    private javax.swing.JLabel toReviewLabel;
    private javax.swing.JComboBox votesComboBox;
    private javax.swing.JLabel votesLabel;
    private javax.swing.JLabel votesValueLabel;
    private javax.swing.JTextField votesValueTextField;
    // End of variables declaration//GEN-END:variables

    private void connect() throws ClassNotFoundException, SQLException {
//        String url = "jdbc:oracle:thin:@localhost:1523:orcl123";
//        String uname = "sys as sysdba";
//        String password = "Mansimalik2402";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        stm = con.createStatement();
        ResultSet result = stm.executeQuery("select distinct b_category from b_cat");
        jList1.setCellRenderer(new CheckboxListRenderer());
        jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jList1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                JList<CheckboxListItem> list
                        = (JList<CheckboxListItem>) event.getSource();
                // Get index of item clicked
                int index = list.locationToIndex(event.getPoint());
                CheckboxListItem item = (CheckboxListItem) list.getModel()
                        .getElementAt(index);
                // Toggle selected state
                item.setSelected(!item.isSelected());

                DefaultListModel<CheckboxListItem> model1 = (DefaultListModel) jList2.getModel();

                if (item.isSelected()) {
                    model1.clear();
                    finalCat1.clear();
                    finalCat.add(item.toString());
                    try {
                        subCat(finalCat, model1);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                for(String t:finalCat){
//                System.out.println(t);
//                }
                } else {
                    model1.clear();
                    finalCat1.clear();
                    finalCat.remove(item.toString());
                    try {
                        subCat(finalCat, model1);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(HW3.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                //System.out.println("Size of arraylist : "+finalCat.size());
                // Repaint cell

                list.repaint(list.getCellBounds(index, index));
            }
        });
        while (result.next()) {
            DefaultListModel<CheckboxListItem> model = (DefaultListModel) jList1.getModel();
            String cat = result.getString(1);
            CheckboxListItem cbl = new CheckboxListItem(cat);
            model.addElement(cbl);
        }
    }

    private void subCat(ArrayList<String> finalCat, DefaultListModel<CheckboxListItem> model) throws ClassNotFoundException, SQLException {
        for (String t : finalCat) {
            //System.out.println(t);
            ResultSet subResult = stm.executeQuery("select distinct b_subcategory from b_subcat where b_category='" + t + "'");
            jList2.setCellRenderer(new CheckboxListRenderer());
            jList2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            jList2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    JList<CheckboxListItem> list2
                            = (JList<CheckboxListItem>) event.getSource();
                    // Get index of item clicked
                    int index = list2.locationToIndex(event.getPoint());
                    CheckboxListItem item = (CheckboxListItem) list2.getModel()
                            .getElementAt(index);
                    // Toggle selected state
                    item.setSelected(!item.isSelected());
                    if (item.isSelected()) {
                        //System.out.println(item.toString());
                        finalCat1.add(item.toString());
                    } else {
                        finalCat1.remove(item.toString());
                        //System.out.println("Size of arraylist off click : "+finalCat1.size());
                    }
                    //System.out.println("Size of arraylist : " + finalCat1.size());
                    // Repaint cell
                    list2.repaint(list2.getCellBounds(index, index));

                }//mouse event
            });//mouse adapter
            while (subResult.next()) {
                String subCat = subResult.getString(1);
                CheckboxListItem cb2 = new CheckboxListItem(subCat);
                model.addElement(cb2);

            }//while
        }//for

    }//subcat method

    private int CheckForDay(String from, String to) {
        int value1 = 0;
        int value2 = 0;
        if ("Sunday".equals(from)) {
            value1 = 0;
        }
        if ("Monday".equals(from)) {
            value1 = 1;
        }
        if ("Tuesday".equals(from)) {
            value1 = 2;
        }
        if ("Wednesday".equals(from)) {
            value1 = 3;
        }
        if ("Thursday".equals(from)) {
            value1 = 4;
        }
        if ("Friday".equals(from)) {
            value1 = 5;
        }
        if ("Saturday".equals(from)) {
            value1 = 6;
        }

        if ("Sunday".equals(to)) {
            value2 = 0;
        }
        if ("Monday".equals(to)) {
            value2 = 1;
        }
        if ("Tuesday".equals(to)) {
            value2 = 2;
        }
        if ("Wednesday".equals(to)) {
            value2 = 3;
        }
        if ("Thursday".equals(to)) {
            value2 = 4;
        }
        if ("Friday".equals(to)) {
            value2 = 5;
        }
        if ("Saturday".equals(to)) {
            value2 = 6;
        }

        int difference = value2 - value1;
        if (difference > 0) {
            difference = difference - 1;
        }
        if (difference == -0) {
            difference = 6;
        }
        if (difference == -1) {
            difference = 5;
        }
        if (difference == -2) {
            difference = 4;
        }
        if (difference == -3) {
            difference = 3;
        }
        if (difference == -4) {
            difference = 2;
        }
        if (difference == -5) {
            difference = 1;
        }
        if (difference == -6) {
            difference = 0;
        }
        return difference;
    }//checkForDay

}//class hw3

class CheckboxListItem {

    private String label;
    private boolean isSelected = false;

    public CheckboxListItem(String label) {
        this.label = label;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String toString() {
        return label;
    }
}

class CheckboxListRenderer extends JCheckBox implements
        ListCellRenderer<CheckboxListItem> {

    @Override
    public Component getListCellRendererComponent(
            JList<? extends CheckboxListItem> list, CheckboxListItem value,
            int index, boolean isSelected, boolean cellHasFocus) {
        setEnabled(list.isEnabled());
        setSelected(value.isSelected());
        setFont(list.getFont());
        setBackground(list.getBackground());
        setForeground(list.getForeground());
        setText(value.toString());
        return this;
    }
}
