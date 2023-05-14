import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {
    JButton boutonRecommencer = new JButton();
    JLabel lblTicTacToe = new JLabel();
    JPanel titrePanel = new JPanel();
    JFrame frame = new JFrame();
    JPanel boutonPanel = new JPanel();
    JButton[] boutons = new JButton[9];
    boolean tourJoueur;

    // Question à l'utilisateur (prénoms des joueurs)
    String prenomJoueur1 = JOptionPane.showInputDialog(null,
            "Entrez le prénom du premier joueur :");
    Joueur joueur1 = new Joueur(prenomJoueur1);
    String prenomJoueur2 = JOptionPane.showInputDialog(null,
            "Entrez le prénom du deuxième joueur :");
    Joueur joueur2 = new Joueur(prenomJoueur2);

    // Affichage du jeu de Tic Tac Toe
    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Tic Tac Toe");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        lblTicTacToe.setFont(new Font("Arial", Font.BOLD, 50));
        lblTicTacToe.setHorizontalAlignment(JLabel.CENTER);
        lblTicTacToe.setForeground(Color.white);
        lblTicTacToe.setText("Tic Tac Toe");

        titrePanel.setBackground(Color.black);

        boutonPanel.setLayout(new GridLayout(3, 3));
        boutonPanel.setBackground(Color.white);

        for (int i = 0; i < 9; i++) {
            boutons[i] = new JButton();
            boutonPanel.add(boutons[i]);
            boutons[i].setFont(new Font("Arial", Font.BOLD, 100));
            boutons[i].setBackground(Color.white);
            boutons[i].setFocusable(false);
            boutons[i].addActionListener(this);
        }

        titrePanel.add(lblTicTacToe);
        frame.add(titrePanel, BorderLayout.NORTH);
        frame.add(boutonPanel);

        frame.add(boutonRecommencer, BorderLayout.SOUTH);
        boutonRecommencer.setFont(new Font("Arial", Font.ITALIC, 20));
        boutonRecommencer.setForeground(Color.white);
        boutonRecommencer.setBackground(Color.black);
        boutonRecommencer.setText("Recommencer");
        boutonRecommencer.setFocusable(false);
        boutonRecommencer.addActionListener(this);

        // Bouton de confirmation pour recommencer
        boutonRecommencer.addActionListener(e -> {

            int confirmation = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment recommencer ?", "Tic Tac Toe", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirmation == JOptionPane.NO_OPTION) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } else {
                for (int i = 0; i < 9; i++) {
                    boutons[i].setText("");
                    boutons[i].setFont(new Font("Arial", Font.BOLD, 100));
                    boutons[i].setBackground(Color.white);
                    boutons[i].setFocusable(false);
                    boutons[i].setEnabled(true);
                }
            }
        });
    }

    // Permet de déterminer le tour du joueur
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == boutons[i]) {
                if (tourJoueur) {
                    if (boutons[i].getText().equals("")) {
                        boutons[i].setForeground(new Color(0, 0, 0));
                        boutons[i].setText("O");
                        tourJoueur = false;
                        lblTicTacToe.setText("Tour du joueur O");
                        verification();
                    }
                } else {
                    if (boutons[i].getText().equals("")) {
                        boutons[i].setForeground(new Color(0, 150, 255));
                        boutons[i].setText("X");
                        tourJoueur = true;
                        lblTicTacToe.setText("Tour du joueur X");
                        verification();
                    }
                }
            }
        }
    }

    // Vérification du gagnant
    public void verification() {
        // Pour le joueur X
        // Lignes diagonales
        if ((boutons[0].getText().equals("X")) && (boutons[1].getText().equals("X")) && (boutons[2].getText().equals("X"))) {
            gagnantX(0, 1, 2);
        } else if ((boutons[3].getText().equals("X")) && (boutons[4].getText().equals("X")) && (boutons[5].getText().equals("X"))) {
            gagnantX(3, 4, 5);
        } else if ((boutons[6].getText().equals("X")) && (boutons[7].getText().equals("X")) && (boutons[8].getText().equals("X"))) {
            gagnantX(6, 7, 8);
        }
        // Lignes verticales
        else if ((boutons[0].getText().equals("X")) && (boutons[3].getText().equals("X")) && (boutons[6].getText().equals("X"))) {
            gagnantX(0, 3, 6);
        } else if ((boutons[1].getText().equals("X")) && (boutons[4].getText().equals("X")) && (boutons[7].getText().equals("X"))) {
            gagnantX(1, 4, 7);
        } else if ((boutons[2].getText().equals("X")) && (boutons[5].getText().equals("X")) && (boutons[8].getText().equals("X"))) {
            gagnantX(2, 5, 8);
        }
        // Lignes diagonales
        else if ((boutons[0].getText().equals("X")) && (boutons[4].getText().equals("X")) && (boutons[8].getText().equals("X"))) {
            gagnantX(0, 4, 8);
        } else if ((boutons[2].getText().equals("X")) && (boutons[4].getText().equals("X")) && (boutons[6].getText().equals("X"))) {
            gagnantX(2, 4, 6);
        }
        // Pour le joueur O
        // Lignes horizontales
        else if ((boutons[0].getText().equals("O")) && (boutons[1].getText().equals("O")) && (boutons[2].getText().equals("O"))) {
            gagnantO(0, 1, 2);
        } else if ((boutons[3].getText().equals("O")) && (boutons[4].getText().equals("O")) && (boutons[5].getText().equals("O"))) {
            gagnantO(3, 4, 5);
        } else if ((boutons[6].getText().equals("O")) && (boutons[7].getText().equals("O")) && (boutons[8].getText().equals("O"))) {
            gagnantO(6, 7, 8);
        }
        // Lignes verticales
        else if ((boutons[0].getText().equals("O")) && (boutons[3].getText().equals("O")) && (boutons[6].getText().equals("O"))) {
            gagnantO(0, 3, 6);
        } else if ((boutons[1].getText().equals("O")) && (boutons[4].getText().equals("O")) && (boutons[7].getText().equals("O"))) {
            gagnantO(1, 4, 7);
        } else if ((boutons[2].getText().equals("O")) && (boutons[5].getText().equals("O")) && (boutons[8].getText().equals("O"))) {
            gagnantO(2, 5, 8);
        }
        // Lignes diagonales
        else if ((boutons[0].getText().equals("O")) && (boutons[4].getText().equals("O")) && (boutons[8].getText().equals("O"))) {
            gagnantO(0, 4, 8);
        } else if ((boutons[2].getText().equals("O")) && (boutons[4].getText().equals("O")) && (boutons[6].getText().equals("O"))) {
            gagnantO(2, 4, 6);
        }
    }

    // Affichage du joueur gagnant
    public void gagnantX(int a, int b, int c) {
        boutons[a].setBackground(Color.green);
        boutons[b].setBackground(Color.green);
        boutons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            boutons[i].setEnabled(false);
        }
        // Affiche un message de victoire au joueur X
        JOptionPane.showMessageDialog(frame, "Le joueur " + joueur1.getNom() + " est gagnant!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
        lblTicTacToe.setText("Tic Tac Toe");
    }

    public void gagnantO(int a, int b, int c) {
        boutons[a].setBackground(Color.green);
        boutons[b].setBackground(Color.green);
        boutons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            boutons[i].setEnabled(false);
        }
        // Affiche un message de victoire au joueur O
        JOptionPane.showMessageDialog(frame, "Le joueur " + joueur2.getNom() + " est gagnant!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
        lblTicTacToe.setText("Tic Tac Toe");
    }
}