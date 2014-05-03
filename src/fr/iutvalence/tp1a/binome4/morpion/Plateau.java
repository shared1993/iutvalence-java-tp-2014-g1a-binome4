package fr.iutvalence.tp1a.binome4.morpion;


import java.util.Arrays;

/**
 * @author Prinsac & Culty
 * @version 2.0.0
 */
public final class Plateau {
    /** Déclaration du tableau du jeu. */
    private final Pion[][] m_tableau;
    /** Compteur du nombre de tour. */
    private       int      m_nbTours;

    /**
     * Initialisation du tableau et du tour.
     */
    public Plateau() {
        m_tableau = new Pion[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(m_tableau[i], Pion.LIBRE);
        }
        m_nbTours = 0;
    }

    public boolean estPlein() {
        return m_nbTours >= 9;
    }

    /** Retourne vrai si la case est libre, et faux si la case est occupée. */
    public boolean estLibre(final int ligne, final int colonne) {
        return m_tableau[ligne][colonne] == Pion.LIBRE;
    }

    /** Pose le pion, change le joueur, et incremente le compteur de tour. */
    public void poserPion(final int ligne, final int colonne, final Pion pion) {
        m_tableau[ligne][colonne] = pion;
        m_nbTours++;
    }

    /** Retourne vrai si il y a une victoire, faux sinon. */
    public boolean victoire() {
        return ((m_tableau[0][0] == m_tableau[0][1]) && (m_tableau[0][0] == m_tableau[0][2]) && (m_tableau[0][0] != Pion.LIBRE)) || (((m_tableau[1][0] == m_tableau[1][1]) && (m_tableau[1][0] == m_tableau[1][2])) && (m_tableau[1][0] != Pion.LIBRE)) || (((m_tableau[2][0] == m_tableau[2][1]) && (m_tableau[2][0] == m_tableau[2][2])) && (m_tableau[2][0] != Pion.LIBRE)) || (((m_tableau[0][0] == m_tableau[1][0]) && (m_tableau[0][0] == m_tableau[2][0])) && (m_tableau[0][0] != Pion.LIBRE)) || (((m_tableau[0][1] == m_tableau[1][1]) && (m_tableau[0][1] == m_tableau[2][1])) && (m_tableau[0][1] != Pion.LIBRE)) || (((m_tableau[0][2] == m_tableau[1][2]) && (m_tableau[0][2] == m_tableau[2][2])) && (m_tableau[0][2] != Pion.LIBRE)) || (((m_tableau[0][0] == m_tableau[1][1]) && (m_tableau[0][0] == m_tableau[2][2])) && (m_tableau[0][0] != Pion.LIBRE)) || (((m_tableau[0][2] == m_tableau[1][1]) && (m_tableau[0][2] == m_tableau[2][0])) && (m_tableau[0][2] != Pion.LIBRE));
    }

    /** Affichage graphique en Ascii-Art. */
    public String toString() {
        final StringBuilder morpionAsciiArt = new StringBuilder(100);
        for (int numeroDeLigne = 0; numeroDeLigne < 3; numeroDeLigne++) {
            morpionAsciiArt.append("------------- \n");
            for (int numeroDeColonne = 0; numeroDeColonne < 3; numeroDeColonne++) {
                morpionAsciiArt.append("| ").append(m_tableau[numeroDeLigne][numeroDeColonne]);
            }
            morpionAsciiArt.append("|\n");
        }
        morpionAsciiArt.append("------------- \n");
        return morpionAsciiArt.toString();
    }

}
