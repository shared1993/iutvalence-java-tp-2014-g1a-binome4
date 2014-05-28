package fr.iutvalence.tp1a.binome4.morpion;

/**
 * Gestionnaire de scores.
 *
 * @author Prinsac & Culty
 * @version 1.1
 */

public final class Score {
    /** Joueur 1. */
    private final Joueur m_joueur1;

    /** Joueur 2. */
    private final Joueur m_joueur2;

    /** Score du joueur 1. */
    private int m_scoreJ1;

    /** Score du joueur 2. */
    private int m_scoreJ2;

    /** Score Nul. */
    private int m_scoreNul;

    /** Constructeur de Score avec les 2 noms des joueurs. */
    public void Score(final Joueur joueur1, final Joueur joueur2) {
        m_joueur1 = joueur1;
        m_joueur2 = joueur2;
        m_scoreJ1 = m_scoreJ2 = m_scoreNul = 0;
    }

    /** Incremente le score des joueurs. */
    public void gagne(final String joueur) {
        if (joueur.equals(m_joueur1.nom())) { m_scoreJ1++; }
        if (joueur.equals(m_joueur2.nom())) { m_scoreJ2++; }
    }

    /** Incremente le score des joueurs. */
    public void nul() {
        m_scoreNul++;
    }

    /** Donne le score de Nul. */
    public int getNul() {
        return m_scoreNul;
    }

    /** Donne le score des joueurs. */
    public int getScore(final String joueur) {
        if (joueur.equals(m_joueur1.nom())) { return m_scoreJ1; }
        if (joueur.equals(m_joueur2.nom())) { return m_scoreJ2; }
        return -1;
    }

    @Override
    public String toString() {
        return String.format("Score{m_joueur1=%s, m_joueur2=%s, m_scoreJ1=%d, m_scoreJ2=%d, m_scoreNul=%d}", m_joueur1, m_joueur2, m_scoreJ1, m_scoreJ2, m_scoreNul);
    }
}
