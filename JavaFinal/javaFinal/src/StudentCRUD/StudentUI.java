package StudentCRUD;


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author kimdohun
 */
public class StudentUI extends javax.swing.JFrame {

    private javax.swing.JPanel input_P, south_P, side_P, sideIn_P1, sideIn_P2;
    private javax.swing.JPanel create_P, search_P, update_P, save_P, load_P, numeric_P, exit_P;
    private javax.swing.JLabel title_L;
    private javax.swing.JSeparator title_Separator; //구분선
    private javax.swing.JLabel create_imgL, create_L;
    private javax.swing.JLabel search_L, search_imgL;
    private javax.swing.JLabel update_imgL, update_L;
    private javax.swing.JLabel save_imgL, save_L;

    private javax.swing.JLabel load_imgL, load_L;
    private javax.swing.JLabel numeric_imgL, numeric_L;
    private javax.swing.JLabel exit_imgL, exit_L;

    //input_P inner>
    private javax.swing.JLabel school_L;

    private javax.swing.JLabel user_id_L, name_L, score_L;
    //입력 창 
    private javax.swing.JTextField user_id_TF, name_TF, score_TF;

    private javax.swing.JButton create_B;

    //south_P inner>
    private javax.swing.JTextArea result_Ta;
    private javax.swing.JScrollPane jScrollPane1;


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
        exit_P = new javax.swing.JPanel();
        exit_imgL = new javax.swing.JLabel();
        exit_L = new javax.swing.JLabel();
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
        javax.swing.GroupLayout sideIn_P2Layout = new javax.swing.GroupLayout(sideIn_P2);
        sideIn_P2.setLayout(sideIn_P2Layout);
        sideIn_P2Layout.setHorizontalGroup(
                sideIn_P2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(create_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(load_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numeric_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit_P, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(save_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(load_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(numeric_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(exit_P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGap(0, 339, Short.MAX_VALUE))
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

        //sideIn_P2 > save_P
        save_P.setBackground(new java.awt.Color(54, 34, 89));
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

        //sideIn_P2 > exit_P
        exit_P.setBackground(new java.awt.Color(54, 34, 89));
        exit_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(MouseEvent e) {

                exit_P_mouseEntered(e);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {

                exit_P_mouseExited(e);
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

        pack();
    }// </editor-fold>

    private void eventHandler() {
    }

    private void create_P_mouseEntered(java.awt.event.MouseEvent e) {
        create_P.setBackground(new java.awt.Color(153, 153, 255));
    }

    private void create_P_mouseExited(java.awt.event.MouseEvent e) {
        create_P.setBackground(new java.awt.Color(54, 34, 89));
    }

    private void exit_P_mouseEntered(java.awt.event.MouseEvent e) {
        exit_P.setBackground(new java.awt.Color(153, 153, 255));
    }

    private void exit_P_mouseExited(java.awt.event.MouseEvent e) {
        exit_P.setBackground(new java.awt.Color(54, 34, 89));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

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


}

