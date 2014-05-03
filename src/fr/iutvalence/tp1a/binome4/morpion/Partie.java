package fr.iutvalence.tp1a.binome4.morpion;


import java.util.Arrays;

/**
 * @author Prinsac & Culty
 * @version 1.0.0
 */
public final class Partie {
    /** Plateau de la partie. */
    private final Plateau  m_plateau;
    /** Joueurs. */
    private final Joueur[] m_joueurs;
    /** Gestionnaire de score */
    private final Score    m_score;
    /** Indice du joueur courant. */
    private       int      m_tour;
    /** IHM. */
    private final Console  m_console;

    /**
     * Initialisation du tableau et du tour.
     */
    public Partie(final Joueur joueur1, final Joueur joueur2, final Score gestionnaireScore) {
        m_joueurs = new Joueur[]{joueur1, joueur2};
        m_score = gestionnaireScore;
        m_plateau = new Plateau();
        m_console = new Console();
        m_tour = 0;
    }

    /** Gére une partie. */
    public void jouer() {
        m_console.afficherPlateau(m_plateau.toString());
        while (!m_plateau.victoire() && !m_plateau.estPlein()) {
            m_console.afficherDebutTour(m_joueurs[m_tour]);
            int[] saisie;
            while(true) {
                saisie = m_console.saisirCoordonnees();
                if (m_plateau.estLibre(saisie[0], saisie[1])) {
                    break;
                }
                m_console.afficherErreurSaisie();
            }
            m_plateau.poserPion(saisie[0], saisie[1], m_joueurs[m_tour].pion());
            m_console.afficherPlateau(m_plateau.toString());
            m_tour = (m_tour + 1) % 2;
        }
        if (m_plateau.victoire()) {
            final Joueur vainqueur = m_joueurs[(m_tour + 1) % 2];
            m_console.afficherVainqueur(vainqueur);
            m_score.gagne(vainqueur.nom());
        }
        else {
            m_console.afficherMatchNul();
            m_score.nul();
        }
        m_console.afficherStatistiques(m_joueurs, m_score);
    }

    /** Affichage graphique en Ascii-Art. */
    @Override
    public String toString() {
        return String.format("Partie{m_plateau=%s, m_joueurs=%s, m_score=%s, m_tour=%d, m_console=%s}", m_plateau, Arrays.toString(m_joueurs), m_score, m_tour, m_console);
    }
}
