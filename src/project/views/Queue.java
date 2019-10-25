package project.views;

import project.App;
import project.ProcStach;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.sound.midi.SysexMessage;
import javax.swing.*;

public class Queue {

    public enum QueueType { MM1, MMS, MM1K};

    public JPanel mainJPanel;
    private JTextField lambdaJTextField;
    private JTextField muJTextField;
    private JTextField rhoJTextField;
    private JTextField nbServerJTextField;
    private JTextField nbMaxQueueJTextField;
    private JPanel mm1JPanel;
    private JLabel lambdaJLabel;
    private JLabel muJLabel;
    private JLabel nbServerJLabel;
    private JLabel nbMaxQueueJLabel;
    private JLabel q0JLabel;
    private JLabel qiJLabel;
    private JLabel lJLabel;
    private JLabel lqJLabel;
    private JLabel wJLabel;
    private JLabel wqJLabel;
    private JTextField qiJTextField;
    private JTextField wqJTextField;
    private JTextField lqJTextField;
    private JComboBox typeComboBox;
    private JLabel errorMessage;
    private JLabel rhoJLabel;
    private JLabel PqtJLabel;
    private JTextField PqtJTextField;
    private JLabel Pqt0JLabel;
    private JTextField PtJTextField;
    private JLabel PtJLabel;
    private JLabel descriptionW;
    private JLabel descriptionWq;
    private JLabel descriptionPt;
    private JLabel descriptionPq0;
    private JLabel descriptionPqt;
    private JLabel nameW;
    private JLabel nameWq;
    private JLabel namePt;
    private JLabel namePqt0;
    private JLabel namePqtt;
    private JPanel mm1kJPanel;
    private JPanel mmsJPanel;

    private ProcStach procStach;

    public Queue() {
        procStach = new ProcStach();

        setContent(getType());

        lambdaJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    procStach.setLambda(Double.valueOf(lambdaJTextField.getText()));
                } catch (NumberFormatException ee) {
                    System.out.println(ee);
                }
                setResults();
            }
        });
        muJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    procStach.setMu(Double.valueOf(muJTextField.getText()));
                } catch (NumberFormatException ee) {
                    System.out.println(ee);
                }
                setResults();
            }
        });
        nbServerJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    procStach.setNbServer(Double.valueOf(nbServerJTextField.getText()));
                } catch (NumberFormatException ee) {
                    System.out.println(ee);
                }
                setResults();
            }
        });
        nbMaxQueueJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    procStach.setMaxQueue(Double.valueOf(nbMaxQueueJTextField.getText()));
                } catch (NumberFormatException ee) {
                    System.out.println(ee);
                }
                setResults();
            }
        });
        qiJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    procStach.setQ_i(Double.valueOf(qiJTextField.getText()));
                } catch (NumberFormatException ee) {
                    System.out.println(ee);
                }
                setResults();
            }
        });
        PtJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    procStach.setPt(Double.valueOf(PtJTextField.getText()));
                } catch (NumberFormatException ee) {
                    System.out.println(ee);
                }
                setResults();
            }
        });
        PqtJTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    procStach.setPqt(Double.valueOf(PqtJTextField.getText()));
                } catch (NumberFormatException ee) {
                    System.out.println(ee);
                }
                setResults();
            }
        });
        typeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setContent(getType());
            }
        });
    }

    private QueueType getType() {
        switch ((String) typeComboBox.getSelectedItem()) {
            case "MM1":
                return QueueType.MM1;
            case "MMS":
                return QueueType.MMS;
            case "MM1K":
                return QueueType.MM1K;
        }
        return QueueType.MM1;
    }

    private void setContent(QueueType type)
    {
        procStach.setType(type);

        switch(type){
            case MM1:
                mm1JPanel.setVisible(true);
                nbServerJLabel.setVisible(false);
                nbServerJTextField.setVisible(false);
                nbMaxQueueJLabel.setVisible(false);
                nbMaxQueueJTextField.setVisible(false);
                wJLabel.setVisible(true);
                wqJLabel.setVisible(true);
                Pqt0JLabel.setVisible(false);
                PqtJLabel.setVisible(false);
                PqtJTextField.setVisible(false);
                PtJLabel.setVisible(false);
                PtJTextField.setVisible(false);
                descriptionW.setVisible(true);
                descriptionWq.setVisible(true);
                descriptionPt.setVisible(false);
                descriptionPq0.setVisible(false);
                descriptionPqt.setVisible(false);
                nameW.setVisible(true);
                nameWq.setVisible(true);
                namePt.setVisible(false);
                namePqt0.setVisible(false);
                namePqtt.setVisible(false);
                break;
            case MMS:
                mm1JPanel.setVisible(true);
                nbServerJLabel.setVisible(true);
                nbServerJTextField.setVisible(true);
                nbMaxQueueJLabel.setVisible(false);
                nbMaxQueueJTextField.setVisible(false);
                wJLabel.setVisible(true);
                wqJLabel.setVisible(true);
                Pqt0JLabel.setVisible(true);
                PqtJLabel.setVisible(true);
                PqtJTextField.setVisible(true);
                PtJLabel.setVisible(true);
                PtJTextField.setVisible(true);
                descriptionW.setVisible(true);
                descriptionWq.setVisible(true);
                descriptionPt.setVisible(true);
                descriptionPq0.setVisible(true);
                descriptionPqt.setVisible(true);
                nameW.setVisible(true);
                nameWq.setVisible(true);
                namePt.setVisible(true);
                namePqt0.setVisible(true);
                namePqtt.setVisible(true);
                break;
            case MM1K:
                mm1JPanel.setVisible(true);
                nbServerJLabel.setVisible(false);
                nbServerJTextField.setVisible(false);
                nbMaxQueueJLabel.setVisible(true);
                nbMaxQueueJTextField.setVisible(true);
                wJLabel.setVisible(false);
                wqJLabel.setVisible(false);
                Pqt0JLabel.setVisible(false);
                PqtJLabel.setVisible(false);
                PqtJTextField.setVisible(false);
                PtJLabel.setVisible(false);
                PtJTextField.setVisible(false);
                descriptionW.setVisible(false);
                descriptionWq.setVisible(false);
                descriptionPt.setVisible(false);
                descriptionPq0.setVisible(false);
                descriptionPqt.setVisible(false);
                nameW.setVisible(false);
                nameWq.setVisible(false);
                namePt.setVisible(false);
                namePqt0.setVisible(false);
                namePqtt.setVisible(false);
                break;
        }

        Initialization();

        App.refreshJFrame();
    }

    private void Initialization()
    {
        try {
            procStach.setLambda(Double.valueOf(lambdaJTextField.getText()));
        } catch (NumberFormatException e) {
            System.out.println(e);
        } ;

        try {
            procStach.setMu(Double.valueOf(muJTextField.getText()));
        } catch (NumberFormatException e) {
            System.out.println(e);
        } ;

        try {
            procStach.setNbServer(Double.valueOf(nbServerJTextField.getText()));
        } catch (NumberFormatException e) {
            System.out.println(e);
        } ;

        try {
            procStach.setMaxQueue(Double.valueOf(nbMaxQueueJTextField.getText()));
        } catch (NumberFormatException e) {
            System.out.println(e);
        } ;

        try {
            procStach.setQ_i(Double.valueOf(qiJTextField.getText()));
        } catch (NumberFormatException e) {
            System.out.println(e);
        } ;

        setResults();
    }

    private void setResults() {
        checkRho();

        try {
            if(procStach.rho() != -1 && !(procStach.rho() != procStach.rho()))
                rhoJLabel.setText(String.valueOf(procStach.rho()));
            else
                rhoJLabel.setText("Error");
        } catch (Error e) {
            rhoJLabel.setText("Error");
        }
        try {
            if(procStach.q0() != -1 && !(procStach.q0() != procStach.q0()))
                q0JLabel.setText(String.valueOf(procStach.q0()));
            else
                q0JLabel.setText("Error");
        } catch (Error e) {
            q0JLabel.setText("Error");
        }
        try {
            if(procStach.qi() != -1 && !(procStach.qi() != procStach.qi()))
                qiJLabel.setText(String.valueOf(procStach.qi()));
            else
                qiJLabel.setText("Error");
        } catch (Error e) {
            qiJLabel.setText("Error");
        }
        try {
            if(procStach.L() != -1 && !(procStach.L() != procStach.L()))
                lJLabel.setText(String.valueOf(procStach.L()));
            else
                lJLabel.setText("Error");
        } catch (Error e) {
            lJLabel.setText("Error");
        }
        try {
            if(procStach.Lq() != -1 && !(procStach.Lq() != procStach.Lq()))
                lqJLabel.setText(String.valueOf(procStach.Lq()));
            else
                lqJLabel.setText("Error");
        } catch (Error e) {
            lqJLabel.setText("Error");
        }
        try {
            if(procStach.W() != -1 && !(procStach.W() != procStach.W()))
                wJLabel.setText(String.valueOf(procStach.W()));
            else
                wJLabel.setText("Error");
        } catch (Error e) {
            wJLabel.setText("Error");
        }
        try {
            if(procStach.Wq() != -1 && !(procStach.Wq() != procStach.Wq()))
                wqJLabel.setText(String.valueOf(procStach.Wq()));
            else
                wqJLabel.setText("Error");
        } catch (Error e) {
            wqJLabel.setText("Error");
        }
        try {
            if(procStach.Ptq0() != -1 && !(procStach.Ptq0() != procStach.Ptq0()))
                PqtJLabel.setText(String.valueOf(procStach.Ptq0()));
            else
                PqtJLabel.setText("Error");
        } catch (Error e) {
            PqtJLabel.setText("Error");
        }
        try {
            if(procStach.Pt() != -1 && !(procStach.Pt() != procStach.Pt()))
                PtJLabel.setText(String.valueOf(procStach.Pt()));
            else
                PtJLabel.setText("Error");
        } catch (Error e) {
            PtJLabel.setText("Error");
        }
        try {
            if(procStach.Ptq0() != -1 && !(procStach.Ptq0() != procStach.Ptq0()))
                Pqt0JLabel.setText(String.valueOf(procStach.Ptq0()));
            else
                Pqt0JLabel.setText("Error");
        } catch (Error e) {
            Pqt0JLabel.setText("Error");
        }
        try {
            if(procStach.Ptqt() != -1 && !(procStach.Ptqt() != procStach.Ptqt()))
                PqtJLabel.setText(String.valueOf(procStach.Ptqt()));
            else
                PqtJLabel.setText("Error");
        } catch (Error e) {
            PqtJLabel.setText("Error");
        }

        App.refreshJFrame();
    }

    private void checkRho() {
        if(procStach.rho() >= 1 && getType() == QueueType.MM1)
            errorMessage.setText(" /!\\ Rho doit être strictement inférieur à 1 /!\\ ");
        else
            errorMessage.setText("");
    }
}
