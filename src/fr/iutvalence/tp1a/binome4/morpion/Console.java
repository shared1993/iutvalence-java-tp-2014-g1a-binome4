package fr.iutvalence.tp1a.binome4.morpion;

import java.util.Scanner;

/**
 * TODO.
 *
 * @author Prinsac & Culty
 * @version 2.0.0
 */
@SuppressWarnings("HardCodedStringLiteral")
public final class Console {
    /** Scanner utilisé pour les saisies. */
    private final Scanner m_scanner;

    public Console() {
        m_scanner = new Scanner(System.in, "UTF-8");
    }

    /** Saisie du numero de ligne et de colonne où placer le pion. */
    public int[] saisirCoordonnees() {
        int numLigne = 4;
        while ((numLigne < 0) || (numLigne > 2)) {
            System.out.println("Entrez le numéro de ligne :");
            numLigne = m_scanner.nextInt() - 1;
            if ((numLigne < 0) || (numLigne > 2)) {
                System.out.println("Hors tableau !");
            }
        }
        int numColonne = 4;
        while ((numColonne < 0) || (numColonne > 2)) {
            System.out.println("Entrez le numéro de colonne :");
            numColonne = m_scanner.nextInt() - 1;
            if ((numColonne < 0) || (numColonne > 2)) {
                System.out.println("Hors tableau !");
            }
        }

        return new int[]{numLigne, numColonne};
    }

    @Override
    public String toString() {
        return String.format("Saisir{m_scanner=%s}", m_scanner);
    }
}
