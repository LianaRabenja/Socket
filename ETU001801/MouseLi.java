package listener;

import java.awt.event.*;
import java.util.Vector;

import pt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import affiche.Affichage;
import lecture.Lecture;
import matri.Matrice;

public class MouseLi implements MouseListener {

    Affichage af;
    Matrice m;
    JLabel[][] l;
    int id;
    int jeu;
    Vector<Coordo> vc;
    Lecture lec;

    public MouseLi(Affichage af) {
        this.af = af;
        m = af.getM();
        // m.placer(new Coordo(2, 2), 3);
        vc = new Vector<Coordo>();
        lec = new Lecture();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            id = 1;
            //int tour=0;
//            if (tour % 2 == 0) {
//                id=2;
            //tour++;
//            }
//            else {
//                id=1;
//            }

            m.Checkwinner(id);
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
            id = 2;
           // int tour=0;
//            if (tour % 2 != 0) {
//                id=1;
            //tour++;
//            }
//            else {
//                id=2;
//            }
            m.Checkwinner(id);
        }
        System.out.println("x=" + ((JLabel) e.getSource()).getX());
        System.out.println("y=" + ((JLabel) e.getSource()).getY());

        Coordo c = new Coordo(((JLabel) e.getSource()).getX() / 50, ((JLabel) e.getSource()).getY() / 50);
        vc.add(c);
        lec.Ecrire(vc, id);
        Vector<String> vs = lec.lire();
        // System.out.println(vc.size());
        for (int k = 0; k < vs.size(); k++) {
            m.placer(new Coordo(
                    Integer.parseInt(vs.get(k).split("//")[0].split(",")[0]),
                    Integer.parseInt(vs.get(k).split("//")[0].split(",")[1])),
                    Integer.parseInt(vs.get(k).split("//")[1]));
        }
        m.setting();

        m.Afficher();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public Affichage getAf() {
        return af;
    }

    public void setAf(Affichage af) {
        this.af = af;
    }

    public Matrice getM() {
        return m;
    }

    public void setM(Matrice m) {
        this.m = m;
    }

    public JLabel[][] getL() {
        return l;
    }

    public void setL(JLabel[][] l) {
        this.l = l;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJeu() {
        return jeu;
    }

    public void setJeu(int jeu) {
        this.jeu = jeu;
    }

    public Vector<Coordo> getVc() {
        return vc;
    }

    public void setVc(Vector<Coordo> vc) {
        this.vc = vc;
    }

}
