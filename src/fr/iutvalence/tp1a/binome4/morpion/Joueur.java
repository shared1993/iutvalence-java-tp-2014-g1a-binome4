package fr.iutvalence.tp1a.binome4.morpion;

/**
 * Joueur : nom et pion.
 *
 * @author Prinsac & Culty
 * @version 2.0.0
 */
public final class Joueur {
    /** Nom. */
    private final String m_nom;
    /** Pion. */
    private final Pion m_pion;

    /** Constructeur du joueur avec le nom et le pion */
    public Joueur(final String nom, final Pion pion) {
        m_nom = nom;
        m_pion = pion;
    }

    /** Accesseur pour le nom du joueur */
    public String nom() {
        return m_nom;
    }

    /** Accesseur pour le pion du joueur */
    public Pion pion() {
        return m_pion;
    }

    @Override
    public String toString() {
        return String.format("Joueur{m_nom='%s', m_pion=%s}", m_nom, m_pion);
    }
}
