package school;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;



public class school_Gui{
	private JTable table_show;
	private JScrollPane scrollPane;
	private JFrame frame;
	private JTextField txt_Fname;
	private JTextField txt_Lname;
	private JTextField txt_Bday;
	private JTextField txt_Gender;
	private JTextField txt_Address;
	private JTextField txt_grades;
	private static final String URL = "jdbc:mysql://localhost:3306/school_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					school_Gui window = new school_Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public school_Gui() {
		initialize();
		
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 724, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 621, 243);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Εγγραφη", null, panel, null);
		panel.setLayout(null);
		
		txt_Fname = new JTextField();
		txt_Fname.setBounds(271, 30, 96, 19);
		panel.add(txt_Fname);
		txt_Fname.setColumns(10);
		
		txt_Lname = new JTextField();
		txt_Lname.setBounds(271, 59, 96, 19);
		panel.add(txt_Lname);
		txt_Lname.setColumns(10);
		
		txt_Bday = new JTextField();
		txt_Bday.setBounds(271, 88, 96, 19);
		panel.add(txt_Bday);
		txt_Bday.setColumns(10);
		
		txt_Gender = new JTextField();
		txt_Gender.setBounds(271, 117, 96, 19);
		panel.add(txt_Gender);
		txt_Gender.setColumns(10);
		
		txt_Address = new JTextField();
		txt_Address.setBounds(271, 146, 96, 19);
		panel.add(txt_Address);
		txt_Address.setColumns(10);
		
		JButton btn_insStudent = new JButton("Εγγραφη");
		btn_insStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String fname = txt_Fname.getText();
	        String lname = txt_Lname.getText();
	        String bday = txt_Bday.getText();
	        String gender = txt_Gender.getText();
	        String address = txt_Address.getText();
	        
	        
	        
	        StudentRegistration.insertStudent(fname, lname, bday, gender, address);
	        // clear the text fields
	        txt_Fname.setText ("");
	        txt_Lname.setText("");
	        txt_Bday.setText("");
	        txt_Gender.setText("");
	        txt_Address.setText("");
	        
	        
	        
			}
			
			
			
		}		
				);
		btn_insStudent.setBounds(159, 177, 114, 21);
		panel.add(btn_insStudent);
		
		JLabel lblNewLabel = new JLabel("Ονομα");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(87, 33, 65, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Επώνυμο");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(87, 60, 65, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ημ.γενήσεως");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(87, 89, 65, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Φύλο");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(87, 123, 65, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Διευθυνση");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(87, 149, 65, 16);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Β. μαθηματων", null, panel_1, null);
		panel_1.setLayout(null);
		
		JComboBox cbox_student = new JComboBox();
		cbox_student.setBounds(136, 26, 139, 31);
		panel_1.add(cbox_student);
		
		try {
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school_db", "root", "");
		    String query = "SELECT id FROM students";
		    PreparedStatement stmt = conn.prepareStatement(query);
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		        String studentId = rs.getString("id");
		        cbox_student.addItem(studentId);
		    }
		    conn.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		
		
		JComboBox cbox_courses = new JComboBox();
		cbox_courses.setBounds(435, 26, 130, 31);
		panel_1.add(cbox_courses);
		
		try {
		    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/school_db", "root", "");
		    String query = "SELECT id FROM courses";
		    PreparedStatement stmt = conn.prepareStatement(query);
		    ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		        String courseId = rs.getString("id");
		        cbox_courses.addItem(courseId);
		    }
		     conn.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		JLabel lblNewLabel_5 = new JLabel("Αριθμος μαθητη");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 35, 104, 22);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Κωδικος Μαθηματος");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(305, 40, 120, 17);
		panel_1.add(lblNewLabel_6);
		
		txt_grades = new JTextField();
		txt_grades.setBounds(242, 115, 96, 19);
		panel_1.add(txt_grades);
		txt_grades.setColumns(10);
		
		JButton btn_grade_insertion = new JButton("εισαγωγη βαθμολογιας");
				btn_grade_insertion.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent arg0) {
				    	
				    	try {
				            // Get selected student ID, course ID, and grade
				            int studentId = Integer.parseInt((String) cbox_student.getSelectedItem());
				            int courseId = Integer.parseInt((String) cbox_courses.getSelectedItem());
				            int grade = Integer.parseInt(txt_grades.getText());

				            // Create Grades object and save to database
				            Grades newGrade = new Grades(studentId, courseId, grade);
				            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				            newGrade.saveGrade(conn);
				            conn.close();

				            // Display success message
				            JOptionPane.showMessageDialog(null, "επιτυχής εισαγωγη βαθμολογιας.");
				        } catch (Exception e) {
				            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
				        }
				    }
				    
				});

				
		
		btn_grade_insertion.setBounds(233, 172, 151, 21);
		panel_1.add(btn_grade_insertion);
		
		JLabel lblNewLabel_7 = new JLabel("βαθμολογια");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(112, 115, 94, 22);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(" 1 PHP");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(435, 86, 139, 22);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel(" 2 JAVA");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setBounds(435, 113, 139, 22);
		panel_1.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel(" 3 Javascript");
		lblNewLabel_8_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1.setBounds(435, 136, 139, 22);
		panel_1.add(lblNewLabel_8_1_1);
		
		JLabel lblNewLabel_8_1_2 = new JLabel(" 4 Wordpress");
		lblNewLabel_8_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_2.setBounds(435, 158, 139, 22);
		panel_1.add(lblNewLabel_8_1_2);
		
		JLabel lblNewLabel_8_1_3 = new JLabel("5 Βασεις δεδωμένων");
		lblNewLabel_8_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_3.setBounds(435, 184, 139, 22);
		panel_1.add(lblNewLabel_8_1_3);
		                                		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("αναζητηση", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		
		JLabel lblSearchStudent = new JLabel("Αναζήτηση Μαθητή");
		lblSearchStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchStudent.setBounds(129, 9, 125, 13);
		panel_2.add(lblSearchStudent);
		
		JTextField txtSearchStudent = new JTextField();
        txtSearchStudent.setBounds(265, 9, 70, 19);
        panel_2.add(txtSearchStudent);
        
           
        JButton btnSearch = new JButton("Αναζήτηση");
        btnSearch.setBackground(new Color(255, 255, 255));
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 String searchStudentId = txtSearchStudent.getText();

        		 try {
        	            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        	            Student student = new Student();
        	            ResultSet resultSet = student.getCoursesAndGrades(conn, Integer.parseInt(searchStudentId));

        	            // Create a DefaultTableModel and set it as the table model for table_show
        	            DefaultTableModel model = new DefaultTableModel();
        	            model.addColumn("Μαθήμα");
        	            model.addColumn("Βαθμός");

        	            // Populate the table with the data from the ResultSet
        	            while (resultSet.next()) {
        	                String courseName = resultSet.getString("title");
        	                int grade = resultSet.getInt("grade");
        	                model.addRow(new Object[]{courseName, grade});
        	            }
        	            JTable table_show = new JTable();
        	         JScrollPane scrollPane = new JScrollPane(table_show);
                  scrollPane.setBounds(10, 50, 600, 150);
                  panel_2.add(scrollPane);

        	            table_show.setModel(model);
        	            conn.close();
        	        } catch (SQLException ex) {
        	            ex.printStackTrace();
        	        }
        	    }
        	});
        btnSearch.setBounds(362, 9,86,28);
        panel_2.add(btnSearch);
        
                JLabel lblResult = new JLabel();
                lblResult.setBounds(400, 15, 0, 0);
                panel_2.add(lblResult);
                
                        
                        
                       
                
                JPanel panel_3 = new JPanel();
        		tabbedPane.addTab("Διαγραφη", null, panel_3, null);
        		panel_3.setLayout(null); 
        		
        		JLabel lblStudentId = new JLabel("Αριθμός Μαθητή:");
                lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
                lblStudentId.setBounds(193, 40, 130, 16);
                panel_3.add(lblStudentId);

                JTextField txtStudentId = new JTextField();
                txtStudentId.setBounds(333, 38, 96, 19);
                panel_3.add(txtStudentId);
                txtStudentId.setColumns(10);

                JButton btnDelete = new JButton("Διαγραφή");
                btnDelete.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int studentId = Integer.parseInt(txtStudentId.getText());
                            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                            // Delete student's grades
                            String deleteGradesQuery = "DELETE FROM grades WHERE student_id = ?";
                            PreparedStatement deleteGradesStmt = conn.prepareStatement(deleteGradesQuery);
                            deleteGradesStmt.setInt(1, studentId);
                            deleteGradesStmt.executeUpdate();

                            

                            // Delete student
                            String deleteStudentQuery = "DELETE FROM students WHERE id = ?";
                            PreparedStatement deleteStudentStmt = conn.prepareStatement(deleteStudentQuery);
                            deleteStudentStmt.setInt(1, studentId);
                            deleteStudentStmt.executeUpdate();

                            conn.close();

                            // Display success message
                            JOptionPane.showMessageDialog(null, "Ο μαθητής διαγράφηκε με επιτυχία.");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Σφάλμα κατά τη διαγραφή του μαθητή.");
                            ex.printStackTrace();
                        }
                    }
                });
                btnDelete.setBounds(283, 85, 96, 21);
                panel_3.add(btnDelete);
            	
        		
}                       		
                        		
}
 
                         		        