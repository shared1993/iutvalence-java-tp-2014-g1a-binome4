package fr.iutvalence.tp1a.binome4.morpion;

/**
 * Pion.
 *
 * @author Prinsac & Culty
 * @version 1.0.0
 */
@SuppressWarnings("HardCodedStringLiteral")
public enum Pion {
    /** Valeur des cases par défaut. */
    LIBRE("  "),
    /** Valeur des cases du joueur 1. */
    JOUEUR1("X "),
    /** Valeur des cases du joueur 2. */
    JOUEUR2("O ");

    private final String m_representation;

    Pion(final String representation) {
        m_representation = representation;
    }

    @Override
    public String toString() {
        return m_representation;
    }
}
