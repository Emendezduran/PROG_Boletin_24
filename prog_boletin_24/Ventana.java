package prog_boletin_24;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame implements ActionListener {

    JFrame marco;
    JPanel panelPrincipal, panelArriba, panelAbajo;
    JTextField liTexto1;
    JPasswordField liTexto2;
    JLabel etiqueta1, etiqueta2;
    JButton boton1, boton2, boton3;
    String ciclos[] = {"1ro ASIR",
        "2do ASIR ", "1ro DAM", "2do DAM"};
    JTextArea aTexto;
    JList cfgs;

    public void crearVentana() {
        marco = new JFrame("Boletín 24"); //titulo de la ventana
        marco.setSize(600, 600); //tamaño de la ventana
        panelPrincipal = new JPanel();
        panelPrincipal.setSize(800, 600); //tamaño del panel prinicpal
        panelPrincipal.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white)); //creamos los bordes
        panelArriba = new JPanel();
        panelArriba.setLayout(null);
        panelArriba.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
        panelAbajo = new JPanel();
        panelAbajo.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
        liTexto1 = new JTextField(20);
        liTexto1.setBounds(250, 80, 165, 25);
        liTexto2 = new JPasswordField(20);
        liTexto2.setBounds(250, 140, 165, 25);
        etiqueta1 = new JLabel();
        etiqueta1.setText("NOME");
        etiqueta1.setBounds(150, 80, 80, 25);
        etiqueta2 = new JLabel();
        etiqueta2.setText("PASSWORD");
        etiqueta2.setBounds(150, 140, 80, 25);
        boton1 = new JButton("PREMER");
        boton1.setBounds(150, 220, 100, 25);
        boton2 = new JButton("LIMPAR");
        boton2.setBounds(340, 220, 100, 25);
        boton2.addActionListener(this); 
        panelArriba.add(etiqueta1);
        panelArriba.add(etiqueta2);
        panelArriba.add(liTexto1);
        panelArriba.add(liTexto2);
        panelArriba.add(boton1);
        panelArriba.add(boton2);
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.add(panelArriba);
        panelPrincipal.add(panelAbajo);
        panelAbajo.setLayout(null);
        cfgs = new JList(ciclos);
        cfgs.setBounds(40, 70, 120, 120);
        cfgs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        boton3 = new JButton("BOTON");
        boton3.setBounds(230, 100, 100, 25);
        boton3.addActionListener(this);
        aTexto = new JTextArea(100, 100);
        aTexto.setBounds(400, 70, 130, 100);
        panelAbajo.add(cfgs);
        panelAbajo.add(boton3);
        panelAbajo.add(aTexto);
        marco.add(panelPrincipal);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == boton3) {
            if(cfgs.isSelectionEmpty() == true) {
                aTexto.setText(liTexto1.getText() + "\nCurso sin seleccionar");
            } else {
                aTexto.setText(liTexto1.getText() + "\n" + (String) cfgs.getSelectedValue());
            }
        } else if (ae.getSource() == boton2) {
            liTexto1.setText("");
            liTexto2.setText("");
            aTexto.setText("");
            cfgs.clearSelection();
        }
    }

}