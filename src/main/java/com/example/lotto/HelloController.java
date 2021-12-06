package com.example.lotto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class HelloController {
    @FXML
    public Label eppenSzamol, elso, masodik, harmadik, negyedik, otodik;
    @FXML
    private Button btnSorsol;
    @FXML
    public ArrayList<Integer> szamok = new ArrayList<>();


    private Random r;
    private Integer szamlalo1, szamlalo2, szam;
    private String sorsoltSz;

    @FXML
    public void initialize(){
        r= new Random();
        eppenSzamol.setText("");
        elso.setText("");
        masodik.setText("");
        harmadik.setText("");
        negyedik.setText("");
        otodik.setText("");
        szamlalo1=0;
        szamlalo2=1;
        szam=0;
        sorsoltSz="";
    }

    private void gombCsereSorsolRendez() {
        if (btnSorsol.getText()=="Rendez") {
            btnSorsol.setText("Sorsol");
        }else {
            btnSorsol.setText("Rendez");
        }
    }
    private void szamGeneralo(){
        while(szamlalo1!=szamlalo2){
            szam=r.nextInt(90)+1;
            eppenSzamol.setText(Integer.toString(szam));
            if(!szamok.contains(szam)){
                szamok.add(szam);
                sorsoltSz= Integer.toString(szam);
                szamlalo1++;
            }
        }
    }

    @FXML
    public void onSorsolClick(ActionEvent actionEvent) {
        if (szamok.size()<5){
            szamGeneralo();
            szamlalo2++;
            switch (szamok.size()){
                case 1: elso.setText(sorsoltSz); break;
                case 2: masodik.setText(sorsoltSz); break;
                case 3: harmadik.setText(sorsoltSz); break;
                case 4: negyedik.setText(sorsoltSz); break;
                case 5: otodik.setText(sorsoltSz);
                    gombCsereSorsolRendez(); break;
            }
        }else if (szamok.size()==5){
            szamok.sort(Comparator.naturalOrder());
            elso.setText(Integer.toString(szamok.get(0)));
            masodik.setText(Integer.toString(szamok.get(1)));
            harmadik.setText(Integer.toString(szamok.get(2)));
            negyedik.setText(Integer.toString(szamok.get(3)));
            otodik.setText(Integer.toString(szamok.get(4)));
            gombCsereSorsolRendez();
            szamok.add(0);
        }else{
            eppenSzamol.setText("");
            elso.setText("");
            masodik.setText("");
            harmadik.setText("");
            negyedik.setText("");
            otodik.setText("");
            szamok.clear();
            szamlalo1=0;
            szamlalo2=1;
        }

    }
}