package StudentCRUD;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author kimdohun
 */
public class StudentUI extends javax.swing.JFrame implements ActionListener, FocusListener {

    //등록,조회,수정,저장,불러오기,정렬 기능을 수행하기 위한 StudentDAO =
    public StudentDAO dao;

    private javax.swing.JPanel input_P, south_P, side_P, sideIn_P1, sideIn_P2;
    private javax.swing.JPanel create_P, search_P, update_P, save_P, load_P, numeric_P, exit_P, delete_P, change_P;
    private javax.swing.JLabel title_L;
    private javax.swing.JSeparator title_Separator; //구분선
    private javax.swing.JLabel create_imgL, create_L;
    private javax.swing.JLabel search_L, search_imgL;
    private javax.swing.JLabel update_imgL, update_L;
    private javax.swing.JLabel save_imgL, save_L;

    private javax.swing.JLabel load_imgL, load_L;
    private javax.swing.JLabel numeric_imgL, numeric_L;
    private javax.swing.JLabel change_imgL, change_L;
    private javax.swing.JLabel exit_imgL, exit_L;

    private javax.swing.JLabel delete_imgL, delete_L;

    //input_P inner>
    private javax.swing.JLabel school_L;

    private javax.swing.JLabel user_id_L, name_L, score_L;
    //입력 창 
    private javax.swing.JTextField user_id_TF, name_TF, score_TF;

    private javax.swing.JButton create_B;

    //south_P inner>
    private javax.swing.JTextArea result_Ta;
    private javax.swing.JScrollPane jScrollPane1;

    //알림 메세지 보여주는 Dialog
    JOptionPane messageDial;
    JOptionPane messageDial2;

    //등록 완료 후 그전인지 판별을 위한 boolean
    private boolean af_Check = false;

    //다이얼로그 (검색 ,수정, 정렬, 테마 변경)
    private search_Dialog search_dialog;
    private update_Dialog update_Dialog;

    private sort_Dialog sort_Dialog;

    private changeDialog changeDialog;

    //테마 변경시 변경된 테마에 따라 Label 변하는 색
    int nowColor = 0;

    //저장, 불러오기 용 
    private JFileChooser fc = new JFileChooser("/Users/kimdohun/Desktop/Spring/spring/JavaFinal/javaFinal/src/StudentCRUD");


    // -------제작자-------
    private javax.swing.JLabel makeMe;


    public StudentUI() {
        this.setTitle("학생관리시스템");
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
    }


    @SuppressWarnings("unchecked")

    private void formDesign() {
        //member 초기화
        side_P = new javax.swing.JPanel();
        input_P = new javax.swing.JPanel();
        south_P = new javax.swing.JPanel();
        sideIn_P2 = new javax.swing.JPanel();
        sideIn_P1 = new javax.swing.JPanel();
        title_L = new javax.swing.JLabel();
        title_Separator = new javax.swing.JSeparator();
        create_P = new javax.swing.JPanel();
        create_imgL = new javax.swing.JLabel();
        create_L = new javax.swing.JLabel();
        search_P = new javax.swing.JPanel();
        search_imgL = new javax.swing.JLabel();
        search_L = new javax.swing.JLabel();
        update_P = new javax.swing.JPanel();
        update_imgL = new javax.swing.JLabel();
        update_L = new javax.swing.JLabel();
        save_P = new javax.swing.JPanel();
        save_imgL = new javax.swing.JLabel();
        save_L = new javax.swing.JLabel();
        load_P = new javax.swing.JPanel();
        load_imgL = new javax.swing.JLabel();
        load_L = new javax.swing.JLabel();
        numeric_P = new javax.swing.JPanel();
        numeric_imgL = new javax.swing.JLabel();
        numeric_L = new javax.swing.JLabel();
        change_P = new javax.swing.JPanel();
        change_imgL = new javax.swing.JLabel();
        change_L = new javax.swing.JLabel();
        exit_P = new javax.swing.JPanel();
        exit_imgL = new javax.swing.JLabel();
        exit_L = new javax.swing.JLabel();
        delete_P = new javax.swing.JPanel();
        delete_imgL = new javax.swing.JLabel();
        delete_L = new javax.swing.JLabel();
        school_L = new javax.swing.JLabel();
        user_id_L = new javax.swing.JLabel();
        user_id_TF = new javax.swing.JTextField();
        name_L = new javax.swing.JLabel();
        name_TF = new javax.swing.JTextField();
        score_L = new javax.swing.JLabel();
        score_TF = new javax.swing.JTextField();
        create_B = new javax.swing.JButton();
        result_Ta = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        dao = new StudentDAO();
        messageDial = new JOptionPane();
        makeMe = new javax.swing.JLabel();
        search_dialog = new search_Dialog();
        sort_Dialog = new sort_Dialog();
        changeDialog = new changeDialog();

        //side_Panel
        javax.swing.GroupLayout side_PLayout = new javax.swing.GroupLayout(side_P);
        side_P.setLayout(side_PLayout);
        side_PLayout.setHorizontalGroup(
                side_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sideIn_P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sideIn_P1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        side_PLayout.setVerticalGroup(
                side_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, side_PLayout.createSequentialGroup()
                                .addComponent(sideIn_P1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(sideIn_P2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );

        //sideIn_p1
        sideIn_P1.setBackground(new java.awt.Color(54, 34, 89));

        javax.swing.GroupLayout sideIn_P1Layout = new javax.swing.GroupLayout(sideIn_P1);
        sideIn_P1.setLayout(sideIn_P1Layout);
        sideIn_P1Layout.setHorizontalGroup(
                sideIn_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(title_Separator, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sideIn_P1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title_L, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(31, Short.MAX_VALUE))
        );
        sideIn_P1Layout.setVerticalGroup(
                sideIn_P1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sideIn_P1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(title_L, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(title_Separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //sideIn_p1 > title_L
        title_L.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        title_L.setForeground(new java.awt.Color(255, 255, 255));
        title_L.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title_L.setText("학생관리 시스템");


        // side IN 2 Page start --------
        //sideIn_P2
        sideIn_P2.setBackground(new java.awt.Color(54, 34, 89));

        makeMe.setForeground(new java.awt.Color(255, 255, 255));
        makeMe.setText("@Created by KimDohun.");

        javax.swing.GroupLayout sideIn_P2Layout = new javax.swing.GroupLayout(sideIn_P2);
        sideIn_P2.setLayout(sideIn_P2Layout);
        sideIn_P2Layout.setHorizontalGroup(
                sideIn_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(create_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(load_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numeric_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(change_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(makeMe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sideIn_P2Layout.setVerticalGroup(
                sideIn_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sideIn_P2Layout.createSequentialGroup()
                                .addComponent(create_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(search_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(update_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(delete_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(save_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(load_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(numeric_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(change_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(exit_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(makeMe, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGap(0, 270, Short.MAX_VALUE))
        );

        //sideIn_P2 > create_P
        create_P.setBackground(new java.awt.Color(54, 34, 89));
        create_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                create_P_mouseEntered(e);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                create_P_mouseExited(e);
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                create_PMouseClicked(e);
            }


        });
        create_imgL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create_imgL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/student.png"))); // NOI18N

        create_L.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        create_L.setForeground(new java.awt.Color(255, 255, 255));
        create_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create_L.setText("등록");

        javax.swing.GroupLayout create_PLayout = new javax.swing.GroupLayout(create_P);
        create_P.setLayout(create_PLayout);
        create_PLayout.setHorizontalGroup(
                create_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(create_PLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(create_imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(create_L, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        create_PLayout.setVerticalGroup(
                create_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, create_PLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(create_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(create_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(create_imgL, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );


        //sideIn_P2 >search_P
        search_P.setBackground(new java.awt.Color(54, 34, 89));

        search_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

                search_P_mouseEntered(e);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                search_P_mouseExited(e);
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                search_PMouseClicked(e);
            }

        });

        search_imgL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search_imgL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/search.png"))); // NOI18N

        search_L.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        search_L.setForeground(new java.awt.Color(255, 255, 255));
        search_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search_L.setText("조회");

        javax.swing.GroupLayout search_PLayout = new javax.swing.GroupLayout(search_P);
        search_P.setLayout(search_PLayout);
        search_PLayout.setHorizontalGroup(
                search_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(search_PLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(search_imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(search_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        search_PLayout.setVerticalGroup(
                search_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, search_PLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(search_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(search_imgL, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                        .addComponent(search_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );
        //sideIn_P2 > update_P
        update_P.setBackground(new java.awt.Color(54, 34, 89));

        update_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

                update_P_mouseEntered(e);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                update_P_mouseExited(e);
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                update_PMouseClicked(e);
            }

        });

        update_imgL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        update_imgL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/edit.png"))); // NOI18N

        update_L.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        update_L.setForeground(new java.awt.Color(255, 255, 255));
        update_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        update_L.setText("수정");

        javax.swing.GroupLayout update_PLayout = new javax.swing.GroupLayout(update_P);
        update_P.setLayout(update_PLayout);
        update_PLayout.setHorizontalGroup(
                update_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(update_PLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(update_imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(update_L, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        update_PLayout.setVerticalGroup(
                update_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, update_PLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(update_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(update_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(update_imgL, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );


        //sideIn_P2 > delete_P
        delete_P.setBackground(new java.awt.Color(54, 34, 89));
        delete_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

                delete_P_mouseEntered(e);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {

                delete_P_mouseExited(e);
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                delete_PMouseClicked(e);
            }


        });
        delete_imgL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete_imgL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/delete.png"))); // NOI18N

        delete_L.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        delete_L.setForeground(new java.awt.Color(255, 255, 255));
        delete_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete_L.setText("제거");

        javax.swing.GroupLayout delete_PLayout = new javax.swing.GroupLayout(delete_P);
        delete_P.setLayout(delete_PLayout);
        delete_PLayout.setHorizontalGroup(
                delete_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(delete_PLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(delete_imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(delete_L, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        delete_PLayout.setVerticalGroup(
                delete_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, delete_PLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(delete_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(delete_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(delete_imgL, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );


        //sideIn_P2 > save_P
        save_P.setBackground(new java.awt.Color(54, 34, 89));

        save_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

                save_P_mouseEntered(e);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {

                save_P_mouseExited(e);
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                save_PMouseClicked(e);
            }


        });


        save_imgL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save_imgL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/save.png"))); // NOI18N

        save_L.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        save_L.setForeground(new java.awt.Color(255, 255, 255));
        save_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save_L.setText("저장");

        javax.swing.GroupLayout save_PLayout = new javax.swing.GroupLayout(save_P);
        save_P.setLayout(save_PLayout);
        save_PLayout.setHorizontalGroup(
                save_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(save_PLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(save_imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(save_L, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        save_PLayout.setVerticalGroup(
                save_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, save_PLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(save_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(save_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(save_imgL, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );
        //sideIn_P2 > load_P
        load_P.setBackground(new java.awt.Color(54, 34, 89));

        load_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

                load_P_mouseEntered(e);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {

                load_P_mouseExited(e);
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                load_PMouseClicked(e);
            }


        });

        load_imgL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        load_imgL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/download.png"))); // NOI18N

        load_L.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        load_L.setForeground(new java.awt.Color(255, 255, 255));
        load_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        load_L.setText("불러오기");

        javax.swing.GroupLayout load_PLayout = new javax.swing.GroupLayout(load_P);
        load_P.setLayout(load_PLayout);
        load_PLayout.setHorizontalGroup(
                load_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(load_PLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(load_imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(load_L, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        load_PLayout.setVerticalGroup(
                load_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, load_PLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(load_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(load_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(load_imgL, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );

        //sideIn_P2 > numeric_P
        numeric_P.setBackground(new java.awt.Color(54, 34, 89));

        numeric_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

                numeric_P_mouseEntered(e);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {

                numeric_P_mouseExited(e);
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                numeric_PMouseClicked(e);
            }

        });

        numeric_imgL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeric_imgL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/numeric.png"))); // NOI18N

        numeric_L.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        numeric_L.setForeground(new java.awt.Color(255, 255, 255));
        numeric_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numeric_L.setText("정렬");

        javax.swing.GroupLayout numeric_PLayout = new javax.swing.GroupLayout(numeric_P);
        numeric_P.setLayout(numeric_PLayout);
        numeric_PLayout.setHorizontalGroup(
                numeric_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(numeric_PLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(numeric_imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(numeric_L, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        numeric_PLayout.setVerticalGroup(
                numeric_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, numeric_PLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(numeric_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(numeric_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(numeric_imgL, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );

        //sideIn_P2 > change_P
        change_P.setBackground(new java.awt.Color(54, 34, 89));

        change_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

                change_P_mouseEntered(e);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {

                change_P_mouseExited(e);
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                change_PMouseClicked(e);
            }


        });

        change_imgL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        change_imgL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/setting.png"))); // NOI18N

        change_L.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        change_L.setForeground(new java.awt.Color(255, 255, 255));
        change_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        change_L.setText("테마 변경");

        javax.swing.GroupLayout change_PLayout = new javax.swing.GroupLayout(change_P);
        change_P.setLayout(change_PLayout);
        change_PLayout.setHorizontalGroup(
                change_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(change_PLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(change_imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(change_L, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        change_PLayout.setVerticalGroup(
                change_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, change_PLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(change_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(change_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(change_imgL, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );


        //sideIn_P2 > exit_P
        exit_P.setBackground(new java.awt.Color(54, 34, 89));
        exit_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

                exit_P_mouseEntered(e);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {

                exit_P_mouseExited(e);
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                exit_PMouseClicked(e);
            }

        });
        exit_imgL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_imgL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/exit.png"))); // NOI18N

        exit_L.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        exit_L.setForeground(new java.awt.Color(255, 255, 255));
        exit_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_L.setText("종료");

        javax.swing.GroupLayout exit_PLayout = new javax.swing.GroupLayout(exit_P);
        exit_P.setLayout(exit_PLayout);
        exit_PLayout.setHorizontalGroup(
                exit_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(exit_PLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(exit_imgL, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(exit_L, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        exit_PLayout.setVerticalGroup(
                exit_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exit_PLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(exit_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(exit_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(exit_imgL, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );


        //--------------input_Panel Start -----------
        //input_Panel
        input_P.setBackground(new java.awt.Color(204, 204, 255));

        school_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/school.png")));

        user_id_L.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        user_id_L.setForeground(new java.awt.Color(51, 51, 255));
        user_id_L.setText("UserID :");

        user_id_TF.setBackground(new java.awt.Color(204, 204, 255));
        user_id_TF.setForeground(new java.awt.Color(153, 153, 153));

        name_L.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        name_L.setForeground(new java.awt.Color(51, 51, 255));
        name_L.setText("이름 :");

        name_TF.setBackground(new java.awt.Color(204, 204, 255));
        name_TF.setForeground(new java.awt.Color(153, 153, 153));

        score_L.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        score_L.setForeground(new java.awt.Color(51, 51, 255));
        score_L.setText("성적 :");

        score_TF.setBackground(new java.awt.Color(204, 204, 255));
        score_TF.setForeground(new java.awt.Color(153, 153, 153));

        create_B.setBackground(new java.awt.Color(204, 204, 255));
        create_B.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        create_B.setForeground(new java.awt.Color(255, 255, 255));
        create_B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/add.png"))); // NOI18N
        create_B.setText("등록하기");
        create_B.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        create_B.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);


        javax.swing.GroupLayout input_PLayout = new javax.swing.GroupLayout(input_P);
        input_P.setLayout(input_PLayout);
        input_PLayout.setHorizontalGroup(
                input_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(input_PLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(school_L, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123)
                                .addGroup(input_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(input_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(input_PLayout.createSequentialGroup()
                                                        .addComponent(user_id_L, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(user_id_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(input_PLayout.createSequentialGroup()
                                                        .addComponent(name_L, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(input_PLayout.createSequentialGroup()
                                                .addComponent(score_L, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(score_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)
                                .addComponent(create_B, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        input_PLayout.setVerticalGroup(
                input_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, input_PLayout.createSequentialGroup()
                                .addContainerGap(42, Short.MAX_VALUE)
                                .addComponent(school_L)
                                .addGap(34, 34, 34))
                        .addGroup(input_PLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(input_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(create_B, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(input_PLayout.createSequentialGroup()
                                                .addGroup(input_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(user_id_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(user_id_L, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(input_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(name_L, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(input_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(score_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(score_L, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        //-------------------south_Panel start---------
        //south_Panel
        south_P.setBackground(new java.awt.Color(204, 204, 255));

        result_Ta.setBackground(new java.awt.Color(204, 204, 255));
        result_Ta.setColumns(30);
        result_Ta.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        result_Ta.setRows(5);
        result_Ta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 3),
                "<조회 결과>", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 36), new java.awt.Color(102, 102, 255))); // NOI18N
        result_Ta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(result_Ta);

        javax.swing.GroupLayout south_PLayout = new javax.swing.GroupLayout(south_P);
        south_P.setLayout(south_PLayout);
        south_PLayout.setHorizontalGroup(
                south_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );
        south_PLayout.setVerticalGroup(
                south_PLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(side_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(input_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(south_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );

        //laout 구성 
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(side_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, 0)
                                                .addComponent(input_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(south_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, 0))
        );

        //등록 처리가 되기전까지 등록 or 종료 버튼만 사용 가능.
//        search_P.setEnabled(false);
//        update_P.setEnabled(false);
//        save_P.setEnabled(false);

        //등록시 아이디 입력전까지 이름과 성적 text 입력 불가
        user_id_TF.setEnabled(false);
        name_TF.setEnabled(false);
        score_TF.setEnabled(false);

        //입력 폼에서 전부 입력 받기 전까지는 등록 버튼 비활성화
        create_B.setEnabled(false);


        pack();
    }// </editor-fold>

    private void eventHandler() {
        //등록 입력시 빈칸 입력시 오류메시지 출력을 위한 method
        user_id_TF.addFocusListener(this);
        name_TF.addFocusListener(this);
        score_TF.addFocusListener(this);


        create_B.addActionListener(this);
    }


    //버튼 별 event 재정의 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("등록하기")) {
            if (dao.create(user_id_TF.getText(), name_TF.getText(), Integer.parseInt(score_TF.getText()))) {
                JOptionPane.showMessageDialog(null, "정상적으로 등록되었습니다.");
                user_id_TF.setEnabled(false);
                name_TF.setEnabled(false);
                score_TF.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "등록 오류", "에러 발생", JOptionPane.ERROR_MESSAGE);

            }
            user_id_TF.setText("");
            name_TF.setText("");
            score_TF.setText("");
            af_Check = true;


        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(user_id_TF))
            result_Ta.setText("""
                    ID(학번)를 입력해주세요.학번은 7자리 입니다.
                     Tip.입력후 포커스 이동을 위해 조회창을 클릭해주세요!!!
                    """);
        else if (e.getSource().equals(name_TF))
            result_Ta.setText("이름을 입력해주세요       Tip.입력후 포커스 이동을 위해 조회창을 클릭해주세요!!!" + '\n');
        else if (e.getSource().equals(score_TF))
            result_Ta.setText("성적을 입력해주세요       Tip.입력후 포커스 이동을 위해 조회창을 클릭해주세요!!!" + '\n');

    }


    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource().equals(user_id_TF)) {
            create_B.setEnabled(false);
            if (user_id_TF.getText().equals(""))
                JOptionPane.showMessageDialog(null, "ID(학번)를 입력해주세요", "에러 발생", JOptionPane.ERROR_MESSAGE);
            else if (user_id_TF.getText().length() != 7) {
                JOptionPane.showMessageDialog(null, "ID(학번)는 7자리 입니다. ", "에러 발생", JOptionPane.ERROR_MESSAGE);
                user_id_TF.setText("");
            } else if (dao.Search(user_id_TF.getText())) {
                JOptionPane.showMessageDialog(null, "이미 ID(학번)는 존재합니다. ", "에러 발생", JOptionPane.ERROR_MESSAGE);
                user_id_TF.setText("");
            } else if (dao.strContain(user_id_TF.getText())) {
                JOptionPane.showMessageDialog(null, "문자가 포함되어있습니다.", "에러 발생", JOptionPane.ERROR_MESSAGE);
                user_id_TF.setText("");
            } else
                name_TF.setEnabled(true);
        } else if (e.getSource().equals(name_TF)) {
            if (name_TF.getText().equals(""))
                JOptionPane.showMessageDialog(null, "이름을 입력해주세요", "에러 발생", JOptionPane.ERROR_MESSAGE);
            else
                score_TF.setEnabled(true);
        } else if (e.getSource().equals(score_TF)) {
            if (score_TF.getText().equals(""))
                JOptionPane.showMessageDialog(null, "성적을 입력해주세요", "에러 발생", JOptionPane.ERROR_MESSAGE);
            else if (!((Integer.parseInt(score_TF.getText()) <= 100) && (Integer.parseInt(score_TF.getText()) >= 1))) {
                JOptionPane.showMessageDialog(null, "1~100사이 숫자만 입력하세요", "에러 발생", JOptionPane.ERROR_MESSAGE);
                score_TF.setText("");
            }else if (dao.strContain(score_TF.getText())) {
                JOptionPane.showMessageDialog(null, "문자가 포함되어있습니다.", "에러 발생", JOptionPane.ERROR_MESSAGE);
                score_TF.setText("");
            }
            else {
                create_B.setEnabled(true);
                search_P.setEnabled(true);
            }
        } else if (e.getSource().equals(create_B)) {
            if (user_id_TF.getText().equals("") && name_TF.getText().equals("") && score_TF.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "입력폼에 빈칸이 존재합니다. 모두 작성 후 눌러 주세요!!!", "에러 발생", JOptionPane.ERROR_MESSAGE);
                create_B.setEnabled(false);
            }
            else {
                create_B.setEnabled(true);
            }

        }

    }


    //마우스 영역내에 들어올시 Panel 색 변경 처리 영역 start -------

    //등록 패널
    private void create_P_mouseEntered(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            create_P.setBackground(new java.awt.Color(153, 153, 255));
        } else if (nowColor == 1) {
            create_P.setBackground(new java.awt.Color(0, 0, 0));
        } else if (nowColor == 2) {
            create_P.setBackground(new java.awt.Color(255, 102, 0));
        }
    }

    private void create_P_mouseExited(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            create_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            create_P.setBackground(new java.awt.Color(51, 51, 51));
        } else if (nowColor == 2) {
            create_P.setBackground(new java.awt.Color(255, 153, 51));
        }
    }

    //종료 패널
    private void exit_P_mouseEntered(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            exit_P.setBackground(new java.awt.Color(153, 153, 255));
        } else if (nowColor == 1) {
            exit_P.setBackground(new java.awt.Color(0, 0, 0));
        } else if (nowColor == 2) {
            exit_P.setBackground(new java.awt.Color(255, 102, 0));
        }
    }

    private void exit_P_mouseExited(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            exit_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            exit_P.setBackground(new java.awt.Color(51, 51, 51));
        } else if (nowColor == 2) {
            exit_P.setBackground(new java.awt.Color(255, 153, 51));
        }
    }

    //조회 패널
    private void search_P_mouseEntered(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            if (af_Check) {
                search_P.setBackground(new java.awt.Color(153, 153, 255));
            } else
                search_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            if (af_Check) {
                search_P.setBackground(new java.awt.Color(0, 0, 0));
            } else
                search_P.setBackground(new java.awt.Color(51, 51, 51));
        } else if (nowColor == 2) {
            if (af_Check) {
                search_P.setBackground(new java.awt.Color(255, 102, 0));
            } else
                search_P.setBackground(new java.awt.Color(255, 153, 51));

        }
    }

    private void search_P_mouseExited(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            search_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            search_P.setBackground(new java.awt.Color(51, 51, 51));
        } else if (nowColor == 2) {
            search_P.setBackground(new java.awt.Color(255, 153, 51));
        }
    }

    //수정 패널
    private void update_P_mouseEntered(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            if (af_Check) {
                update_P.setBackground(new java.awt.Color(153, 153, 255));
            } else
                update_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            if (af_Check) {
                update_P.setBackground(new java.awt.Color(0, 0, 0));
            } else
                update_P.setBackground(new java.awt.Color(51, 51, 51));

        } else if (nowColor == 2) {
            if (af_Check) {
                update_P.setBackground(new java.awt.Color(255, 102, 0));
            } else
                update_P.setBackground(new java.awt.Color(255, 153, 51));


        }
    }

    private void update_P_mouseExited(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            update_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            update_P.setBackground(new java.awt.Color(51, 51, 51));
        } else if (nowColor == 2) {
            update_P.setBackground(new java.awt.Color(255, 153, 51));
        }
    }

    // 제거 패널
    private void delete_P_mouseEntered(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            if (af_Check) {
                delete_P.setBackground(new java.awt.Color(153, 153, 255));
            } else
                delete_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            if (af_Check) {
                delete_P.setBackground(new java.awt.Color(0, 0, 0));
            } else
                delete_P.setBackground(new java.awt.Color(51, 51, 51));

        } else if (nowColor == 2) {
            if (af_Check) {
                delete_P.setBackground(new java.awt.Color(255, 102, 0));
            } else
                delete_P.setBackground(new java.awt.Color(255, 153, 51));


        }
    }

    private void delete_P_mouseExited(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            delete_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            delete_P.setBackground(new java.awt.Color(51, 51, 51));
        } else if (nowColor == 2) {
            delete_P.setBackground(new java.awt.Color(255, 153, 51));
        }
    }

    //저장 패널
    private void save_P_mouseEntered(java.awt.event.MouseEvent event) {
        if (nowColor == 0) {
            if (af_Check) {
                save_P.setBackground(new java.awt.Color(153, 153, 255));
            } else
                save_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            if (af_Check) {
                save_P.setBackground(new java.awt.Color(0, 0, 0));
            } else
                save_P.setBackground(new java.awt.Color(51, 51, 51));

        } else if (nowColor == 2) {
            if (af_Check) {
                save_P.setBackground(new java.awt.Color(255, 102, 0));
            } else
                save_P.setBackground(new java.awt.Color(255, 153, 51));

        }
    }

    private void save_P_mouseExited(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            save_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            save_P.setBackground(new java.awt.Color(51, 51, 51));
        } else if (nowColor == 2) {
            save_P.setBackground(new java.awt.Color(255, 153, 51));
        }
    }

    //불러오기 패널
    private void load_P_mouseEntered(java.awt.event.MouseEvent event) {
        if (nowColor == 0) {
            if (af_Check) {
                load_P.setBackground(new java.awt.Color(153, 153, 255));
            } else
                load_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            if (af_Check) {
                load_P.setBackground(new java.awt.Color(0, 0, 0));
            } else
                load_P.setBackground(new java.awt.Color(51, 51, 51));

        } else if (nowColor == 2) {
            if (af_Check) {
                load_P.setBackground(new java.awt.Color(255, 102, 0));
            } else
                load_P.setBackground(new java.awt.Color(255, 153, 51));

        }

    }

    private void load_P_mouseExited(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            load_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            load_P.setBackground(new java.awt.Color(51, 51, 51));
        } else if (nowColor == 2) {
            load_P.setBackground(new java.awt.Color(255, 153, 51));
        }
    }

    // 정렬 패널
    private void numeric_P_mouseEntered(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            if (af_Check) {
                numeric_P.setBackground(new java.awt.Color(153, 153, 255));
            } else
                numeric_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            if (af_Check) {
                numeric_P.setBackground(new java.awt.Color(0, 0, 0));
            } else
                numeric_P.setBackground(new java.awt.Color(51, 51, 51));

        } else if (nowColor == 2) {
            if (af_Check) {
                numeric_P.setBackground(new java.awt.Color(255, 102, 0));
            } else
                numeric_P.setBackground(new java.awt.Color(255, 153, 51));

        }
    }

    private void numeric_P_mouseExited(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            numeric_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            numeric_P.setBackground(new java.awt.Color(51, 51, 51));
        } else if (nowColor == 2) {
            numeric_P.setBackground(new java.awt.Color(255, 153, 51));
        }
    }

    // 색 변경 패널

    private void change_P_mouseEntered(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            change_P.setBackground(new java.awt.Color(153, 153, 255));
        } else if (nowColor == 1) {
            change_P.setBackground(new java.awt.Color(0, 0, 0));
        } else if (nowColor == 2) {
            change_P.setBackground(new java.awt.Color(255, 102, 0));
        }
    }

    private void change_P_mouseExited(java.awt.event.MouseEvent e) {
        if (nowColor == 0) {
            change_P.setBackground(new java.awt.Color(54, 34, 89));
        } else if (nowColor == 1) {
            change_P.setBackground(new java.awt.Color(51, 51, 51));
        } else if (nowColor == 2) {
            change_P.setBackground(new java.awt.Color(255, 153, 51));
        }
    }


    //----------------Panel 색 변경 영역 end-------------------


    // ------------panel 클릭 event start ------------------
    //등록 클릭 시
    private void create_PMouseClicked(java.awt.event.MouseEvent e) {
        user_id_TF.setEnabled(true);
    }

    //조회 클릭시
    private void search_PMouseClicked(java.awt.event.MouseEvent e) {
        if (af_Check) {
            result_Ta.setText(dao.read());
        }
    }

    //종료 클릭시
    private void exit_PMouseClicked(java.awt.event.MouseEvent e) {
        if (exitMessageDialog("정말로 종료 하시겠습니까?", "종료 확인 메시지")) {
            System.exit(0);
        }
    }

    private boolean exitMessageDialog(String message, String title) {
        int optionType = JOptionPane.DEFAULT_OPTION;
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        Object[] options = {"확인", "취소"};
        int result = JOptionPane.showOptionDialog(null, message, title, optionType, messageType, null, options, options[0]);
        return result == JOptionPane.YES_OPTION;
    }

    //수정 클릭시
    private void update_PMouseClicked(java.awt.event.MouseEvent e) {
        if (af_Check) {
            //아이디 검사 다이얼로그 setVisible(true)
            search_dialog.setVisible(true);

        }
    }

    //제거 클릭시
    private void delete_PMouseClicked(java.awt.event.MouseEvent e) {
        if (af_Check) {
            search_dialog.setVisible(true);
        }
    }

    //저장 클릭시
    private void save_PMouseClicked(java.awt.event.MouseEvent e) {
        if (af_Check) {
            int sv = fc.showSaveDialog(this);
            if (sv == 0) {
                String filesavePath = fc.getSelectedFile().getAbsolutePath();
                if (dao.save(filesavePath)) {
                    JOptionPane.showMessageDialog(null, "정상적으로 저장되었습니다.");
                } else {
                    JOptionPane.showMessageDialog(null, "저장 오류 발생", "에러 발생", JOptionPane.ERROR_MESSAGE);
                }


            }
        }
    }

    //불러오기 클릭시
    private void load_PMouseClicked(java.awt.event.MouseEvent e) {
        if (af_Check) {
            int lv = fc.showOpenDialog(this);
            if (lv == 0) {
                String fileloadPath = fc.getSelectedFile().getAbsolutePath();
                if (dao.load(fileloadPath)) {
                    JOptionPane.showMessageDialog(null, "정상적으로 불러왔습니다.");
                    result_Ta.setText(dao.read());
                } else {
                    JOptionPane.showMessageDialog(null, "불러오기 오류 발생", "에러 발생", JOptionPane.ERROR_MESSAGE);
                }
            }
        }


    }

    //정렬하기 클릭 시
    private void numeric_PMouseClicked(java.awt.event.MouseEvent e) {
        if (af_Check) {
            sort_Dialog.setVisible(true);
        }

    }

    //테마 변경 클릭 시
    private void change_PMouseClicked(java.awt.event.MouseEvent event) {
        changeDialog.setVisible(true);

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentUI().setVisible(true);
            }
        });
    }

    //search_Dialog
    class search_Dialog extends javax.swing.JDialog {

        private javax.swing.JLabel id_L;
        private javax.swing.JTextField id_TF;
        private javax.swing.JLabel img_L;
        private javax.swing.JButton update_btn;
        private javax.swing.JButton search_btn;
        private javax.swing.JButton delete_btn;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTextArea jTextArea1;
        private javax.swing.JTextArea text_TF;


        public search_Dialog() {


            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("아이디 검색 다이얼로그");
            formDesign();
            eventHandler();

        }


        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void formDesign() {

            jScrollPane1 = new javax.swing.JScrollPane();
            jTextArea1 = new javax.swing.JTextArea();
            jPanel1 = new javax.swing.JPanel();
            img_L = new javax.swing.JLabel();
            id_L = new javax.swing.JLabel();
            id_TF = new javax.swing.JTextField();
            update_btn = new javax.swing.JButton();
            search_btn = new javax.swing.JButton();
            jScrollPane2 = new javax.swing.JScrollPane();
            text_TF = new javax.swing.JTextArea();
            delete_btn = new javax.swing.JButton();

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane1.setViewportView(jTextArea1);

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            jPanel1.setBackground(new java.awt.Color(110, 203, 244));

            img_L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/StudentCRUD/images/search_log.png"))); // NOI18N

            id_L.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
            id_L.setForeground(new java.awt.Color(255, 255, 255));
            id_L.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            id_L.setText("UserId");

            id_TF.setBackground(new java.awt.Color(110, 203, 244));
            id_TF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

            update_btn.setBackground(new java.awt.Color(41, 131, 222));
            update_btn.setText("수정하기");

            search_btn.setBackground(new java.awt.Color(41, 131, 222));
            search_btn.setText("검색하기");

            text_TF.setBackground(new java.awt.Color(110, 203, 244));
            text_TF.setColumns(15);
            text_TF.setForeground(new java.awt.Color(255, 255, 255));
            text_TF.setRows(1);
            text_TF.setBorder(null);
            text_TF.setDisabledTextColor(new java.awt.Color(255, 255, 255));
            jScrollPane2.setViewportView(text_TF);

            delete_btn.setBackground(new java.awt.Color(41, 131, 222));
            delete_btn.setText("삭제하기");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(24, 24, 24)
                                                    .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(180, 180, 180)
                                                    .addComponent(img_L))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(115, 115, 115)
                                                    .addComponent(id_L, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(138, 138, 138)
                                                    .addComponent(id_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(123, 123, 123)
                                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(21, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(img_L, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(id_L)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(id_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(26, 26, 26))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );


            //검색결과가 넘어오기 전까지 false
            update_btn.setEnabled(false);
            delete_btn.setEnabled(false);

            pack();
        }// </editor-fold>

        private void eventHandler() {
            id_TF.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {

                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (e.getSource().equals(id_TF)) {
                        update_btn.setEnabled(false);
                        delete_btn.setEnabled(false);

                        if (id_TF.getText().equals(""))
                            messageDial2.showMessageDialog(null, "ID(학번)를 입력해주세요", "에러 발생", JOptionPane.ERROR_MESSAGE);
                        else if (id_TF.getText().length() != 7) {
                            messageDial2.showMessageDialog(null, "ID(학번)는 7자리 입니다. ", "에러 발생", JOptionPane.ERROR_MESSAGE);
                            id_TF.setText("");
                        } else if (dao.strContain(id_TF.getText())) {
                            messageDial2.showMessageDialog(null, "문자가 포함되어있습니다.", "에러 발생", JOptionPane.ERROR_MESSAGE);
                            id_TF.setText("");
                        }
                    }
                }


            });
            search_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean result = dao.Search(id_TF.getText());
                    if (result) {
                        update_btn.setEnabled(true);
                        delete_btn.setEnabled(true);
                        text_TF.setText("검색결과 :검색하신 ID가" + id_TF.getText() + "가 존재.");
                    } else
                        text_TF.setText("검색결과 :검색하신 ID가" + id_TF.getText() + "가 존재X.");
                }
            });
            update_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int id_i = dao.update(id_TF.getText());
                    Student st1 = dao.Search_i(id_i);
                    update_Dialog = new update_Dialog(st1.getId(), st1.getName(), st1.getScore());
                    update_Dialog.setVisible(true);
                    update_btn.setEnabled(false);
                    delete_btn.setEnabled(false);
                    text_TF.setText("");
                    search_dialog.setVisible(false);


                }
            });
            delete_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (dao.delete(id_TF.getText())) {
                        JOptionPane.showMessageDialog(null, "정상적으로 삭제되었습니다.");
                        update_btn.setEnabled(false);
                        delete_btn.setEnabled(false);
                        text_TF.setText("");
                        search_dialog.setVisible(false);
                    } else
                        JOptionPane.showMessageDialog(null, "삭제 오류 발생", "에러 발생", JOptionPane.ERROR_MESSAGE);
                }
            });

        }
    }

    //update_Dialog
    class update_Dialog extends javax.swing.JDialog {

        private static final long serialVersionUID = 8309207734155538748L;
        private JLabel Lid, Lname, Lscore, LTid;
        private JTextField Tname, Tscore;
        private JButton cancel, upBtn;
        private JPanel up1, up2, up3;


        update_Dialog(String id_i, String name_i, int socre_i) {
            this.setTitle("수정하기");
            this.setSize(450, 300);
            this.formDesign(id_i, name_i, socre_i);
            this.eventHandler();
            this.setVisible(true);
            this.setBackground(new java.awt.Color(110, 203, 244));

        }

        public void formDesign(String id_i, String name_i, int socre_i) {
            Lid = new JLabel("id:");
            Lid.setBackground(new java.awt.Color(110, 203, 244));
            Lname = new JLabel("name:");
            Lname.setBackground(new java.awt.Color(110, 203, 244));
            Lscore = new JLabel("score");
            Lscore.setBackground(new java.awt.Color(110, 203, 244));
            LTid = new JLabel(id_i);
            LTid.setBackground(new java.awt.Color(110, 203, 244));
            Tname = new JTextField(name_i, 10);
            Tname.setBackground(new java.awt.Color(110, 203, 244));
            Tscore = new JTextField(String.valueOf(socre_i), 10);
            Tscore.setBackground(new java.awt.Color(110, 203, 244));
            cancel = new JButton("취소");
            cancel.setBackground(new java.awt.Color(41, 131, 222));
            upBtn = new JButton("확인(수정)");
            upBtn.setBackground(new java.awt.Color(41, 131, 222));
            up1 = new JPanel();
            up1.setBackground(new java.awt.Color(110, 203, 244));
            up2 = new JPanel();
            up2.setBackground(new java.awt.Color(110, 203, 244));
            up3 = new JPanel();
            up3.setBackground(new java.awt.Color(110, 203, 244));

            this.add(up1, BorderLayout.CENTER);
            up1.setLayout(new GridLayout(2, 1));
            up1.add(up2);
            up2.setLayout(new GridLayout(3, 2));
            up2.add(Lid);
            up2.add(LTid);
            up2.add(Lname);
            up2.add(Tname);
            up2.add(Lscore);
            up2.add(Tscore);
            up1.add(up3);
            up3.setLayout(new GridLayout(1, 2));
            up3.add(cancel);
            up3.add(upBtn);


        }

        public void eventHandler() {
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    update_Dialog.setVisible(false);
                }
            });

            upBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!((Integer.parseInt(Tscore.getText()) <= 100) && (Integer.parseInt(Tscore.getText()) >= 1))) {
                        messageDial2.showMessageDialog(null, "1~100사이 숫자만 입력하세요", "에러 발생", JOptionPane.ERROR_MESSAGE);
                        Tscore.setText("");
                    } else {
                        int id_i = dao.update(LTid.getText());
                        String id = LTid.getText();
                        String name = Tname.getText();
                        int score = Integer.parseInt(Tscore.getText());
                        dao.update_2(id_i, id, name, score);
                        JOptionPane.showMessageDialog(null, "정상적으로 수정되었습니다.");
                        result_Ta.setText(dao.read());
                        update_Dialog.setVisible(false);
                        
                    }


                }
            });
            Tscore.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                }

                @Override
                public void focusLost(FocusEvent e) {


                }
            });


        }


    }

    //sort_Dialog
    class sort_Dialog extends javax.swing.JDialog {

        private javax.swing.JButton Asc_btn;
        private javax.swing.JButton Desc_btn;
        private javax.swing.JButton Rank_btn1;
        private javax.swing.JButton Rank_btn2;
        private javax.swing.JButton exit_btn;
        private javax.swing.JButton name_btn1;
        private javax.swing.JButton name_btn2;
        private javax.swing.JPanel jPanel1;

        public sort_Dialog() {
            setTitle("정렬 다이얼로그");
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            formDesign();
            sort_eventHandler();
        }


        @SuppressWarnings("unchecked")

        private void formDesign() {

            jPanel1 = new javax.swing.JPanel();
            Asc_btn = new javax.swing.JButton();
            Desc_btn = new javax.swing.JButton();
            Rank_btn1 = new javax.swing.JButton();
            Rank_btn2 = new javax.swing.JButton();
            exit_btn = new javax.swing.JButton();
            name_btn2 = new javax.swing.JButton();
            name_btn1 = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            jPanel1.setBackground(new java.awt.Color(153, 51, 255));

            Asc_btn.setBackground(new java.awt.Color(153, 51, 255));
            Asc_btn.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            Asc_btn.setForeground(new java.awt.Color(255, 255, 255));
            Asc_btn.setText("학번순(오름차순)");

            Desc_btn.setBackground(new java.awt.Color(102, 102, 255));
            Desc_btn.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            Desc_btn.setForeground(new java.awt.Color(255, 255, 255));
            Desc_btn.setText("학번순(내림차순)");

            Rank_btn1.setBackground(new java.awt.Color(255, 102, 153));
            Rank_btn1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            Rank_btn1.setForeground(new java.awt.Color(255, 255, 255));
            Rank_btn1.setText("성적순(오름차순)");

            Rank_btn2.setBackground(new java.awt.Color(255, 153, 0));
            Rank_btn2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            Rank_btn2.setForeground(new java.awt.Color(255, 255, 255));
            Rank_btn2.setText("성적순(내림차순)");
            Rank_btn2.setActionCommand("성적순(내림차순)");

            exit_btn.setBackground(new java.awt.Color(51, 204, 255));
            exit_btn.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            exit_btn.setForeground(new java.awt.Color(255, 255, 255));
            exit_btn.setText("취소 ");

            name_btn2.setBackground(new java.awt.Color(255, 204, 204));
            name_btn2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            name_btn2.setForeground(new java.awt.Color(255, 255, 255));
            name_btn2.setText("이름순(내림차순)");

            name_btn1.setBackground(new java.awt.Color(204, 204, 255));
            name_btn1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            name_btn1.setForeground(new java.awt.Color(255, 255, 255));
            name_btn1.setText("이름순(오름차순)");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Rank_btn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Asc_btn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Desc_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Rank_btn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(name_btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(0, 0, 0)
                                    .addComponent(name_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(exit_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Asc_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Desc_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Rank_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Rank_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(exit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(name_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(name_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 63, Short.MAX_VALUE))))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
            );

            pack();
        }

        private void sort_eventHandler() {
            Asc_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (dao.sortAsc_id()) {
                        JOptionPane.showMessageDialog(null, "정상적으로 정렬되었습니다.");
                        result_Ta.setText(dao.read());
                    } else {
                        JOptionPane.showMessageDialog(null, "정렬 오류 발생", "정렬 에러 ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            Desc_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (dao.sortDesc_id()) {
                        JOptionPane.showMessageDialog(null, "정상적으로 정렬되었습니다.");
                        result_Ta.setText(dao.read());
                    } else {
                        JOptionPane.showMessageDialog(null, "정렬 오류 발생", "정렬 에러 ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            Rank_btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (dao.sortAsc_score()) {
                        JOptionPane.showMessageDialog(null, "정상적으로 정렬되었습니다.");
                        result_Ta.setText(dao.read());
                    } else {
                        JOptionPane.showMessageDialog(null, "정렬 오류 발생", "정렬 에러 ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            Rank_btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (dao.sortDesc_score()) {
                        JOptionPane.showMessageDialog(null, "정상적으로 정렬되었습니다.");
                        result_Ta.setText(dao.read());
                    } else {
                        JOptionPane.showMessageDialog(null, "정렬 오류 발생", "정렬 에러 ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            name_btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (dao.sortAsc_name()) {
                        JOptionPane.showMessageDialog(null, "정상적으로 정렬되었습니다.");
                        result_Ta.setText(dao.read());
                    } else {
                        JOptionPane.showMessageDialog(null, "정렬 오류 발생", "정렬 에러 ", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            name_btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (dao.sortDesc_name()) {
                        JOptionPane.showMessageDialog(null, "정상적으로 정렬되었습니다.");
                        result_Ta.setText(dao.read());
                    } else {
                        JOptionPane.showMessageDialog(null, "정렬 오류 발생", "정렬 에러 ", JOptionPane.ERROR_MESSAGE);
                    }

                }
            });
            exit_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JOptionPane.showMessageDialog(null, "종료 하시겠습니까?", "종료", JOptionPane.ERROR_MESSAGE);
                    sort_Dialog.setVisible(false);
                }
            });

        }

    }

    //색변경 다이얼 로그
    class changeDialog extends javax.swing.JDialog {

        private javax.swing.JButton default_theme;
        private javax.swing.JButton dark_theme;
        private javax.swing.JButton orange_Theme;
        private javax.swing.JButton color_cancel;
        private javax.swing.JPanel jPanel1;

        /**
         * Creates new form changeDialog
         */
        public changeDialog() {
            setTitle("테마 색 변경 다이얼로그");
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            formDesign();
            theme_eventHandler();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void formDesign() {

            jPanel1 = new javax.swing.JPanel();
            dark_theme = new javax.swing.JButton();
            default_theme = new javax.swing.JButton();
            orange_Theme = new javax.swing.JButton();
            color_cancel = new javax.swing.JButton();


            dark_theme.setBackground(new java.awt.Color(51, 51, 51));
            dark_theme.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            dark_theme.setForeground(new java.awt.Color(255, 255, 255));
            dark_theme.setText("Dark Theme");

            default_theme.setBackground(new java.awt.Color(102, 0, 255));
            default_theme.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            default_theme.setForeground(new java.awt.Color(255, 255, 255));
            default_theme.setText("Default Theme");

            orange_Theme.setBackground(new java.awt.Color(255, 153, 51));
            orange_Theme.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            orange_Theme.setForeground(new java.awt.Color(255, 255, 255));
            orange_Theme.setText("Orange Theme");

            color_cancel.setBackground(new java.awt.Color(255, 255, 51));
            color_cancel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
            color_cancel.setForeground(new java.awt.Color(0, 51, 204));
            color_cancel.setText("취소");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(color_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(default_theme, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, 0)
                                                    .addComponent(dark_theme, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, 0)
                                                    .addComponent(orange_Theme, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(default_theme, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dark_theme, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(orange_Theme, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(color_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(49, 49, 49))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            pack();
        }

        private void theme_eventHandler() {
            default_theme.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nowColor = 0;
                    sideIn_P1.setBackground(new java.awt.Color(54, 34, 89));
                    sideIn_P2.setBackground(new java.awt.Color(54, 34, 89));
                    create_P.setBackground(new java.awt.Color(54, 34, 89));
                    search_P.setBackground(new java.awt.Color(54, 34, 89));
                    update_P.setBackground(new java.awt.Color(54, 34, 89));
                    delete_P.setBackground(new java.awt.Color(54, 34, 89));
                    exit_P.setBackground(new java.awt.Color(54, 34, 89));
                    save_P.setBackground(new java.awt.Color(54, 34, 89));
                    load_P.setBackground(new java.awt.Color(54, 34, 89));
                    change_P.setBackground(new java.awt.Color(54, 34, 89));
                    numeric_P.setBackground(new java.awt.Color(54, 34, 89));
                    input_P.setBackground(new java.awt.Color(204, 204, 255));
                    result_Ta.setBackground(new java.awt.Color(204, 204, 255));

                }
            });
            dark_theme.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nowColor = 1;
                    sideIn_P1.setBackground(new java.awt.Color(51, 51, 51));
                    sideIn_P2.setBackground(new java.awt.Color(51, 51, 51));
                    create_P.setBackground(new java.awt.Color(51, 51, 51));
                    search_P.setBackground(new java.awt.Color(51, 51, 51));
                    update_P.setBackground(new java.awt.Color(51, 51, 51));
                    delete_P.setBackground(new java.awt.Color(51, 51, 51));
                    save_P.setBackground(new java.awt.Color(51, 51, 51));
                    load_P.setBackground(new java.awt.Color(51, 51, 51));
                    exit_P.setBackground(new java.awt.Color(51, 51, 51));
                    change_P.setBackground(new java.awt.Color(51, 51, 51));
                    numeric_P.setBackground(new java.awt.Color(51, 51, 51));
                    input_P.setBackground(new java.awt.Color(102, 102, 102));
                    result_Ta.setBackground(new java.awt.Color(102, 102, 102));


                }
            });
            orange_Theme.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nowColor = 2;
                    sideIn_P1.setBackground(new java.awt.Color(255, 153, 51));
                    sideIn_P2.setBackground(new java.awt.Color(255, 153, 51));
                    create_P.setBackground(new java.awt.Color(255, 153, 51));
                    search_P.setBackground(new java.awt.Color(255, 153, 51));
                    update_P.setBackground(new java.awt.Color(255, 153, 51));
                    delete_P.setBackground(new java.awt.Color(255, 153, 51));
                    save_P.setBackground(new java.awt.Color(255, 153, 51));
                    load_P.setBackground(new java.awt.Color(255, 153, 51));
                    exit_P.setBackground(new java.awt.Color(255, 153, 51));
                    change_P.setBackground(new java.awt.Color(255, 153, 51));
                    numeric_P.setBackground(new java.awt.Color(255, 153, 51));
                    input_P.setBackground(new java.awt.Color(255, 204, 0));
                    result_Ta.setBackground(new java.awt.Color(255, 204, 0));

                }
            });
            color_cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    changeDialog.setVisible(false);
                }
            });
        }


    }


}

