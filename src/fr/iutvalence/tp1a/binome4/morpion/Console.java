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

    /** Affiche l'état actuel du morpion. */
    public void afficherPlateau(final String plateau) {
        System.out.println(plateau);
    }

    public void afficherDebutTour(final Joueur joueur) {
        System.out.printf("C'est à %s de jouer (%s) :%n", joueur.nom(), joueur.pion());
    }

    public void afficherErreurSaisie() {
        System.err.println("La case est déjà occupée !");
    }

    /** Saisie du numero de ligne et de colonne où placer le pion. */
    public int[] saisirCoordonnees() {
        int numLigne = 4;
        while ((numLigne < 0) || (numLigne > 2)) {
            System.out.println("Entrez le numéro de ligne :");
            numLigne = m_scanner.nextInt() - 1;
            if ((numLigne < 0) || (numLigne > 2)) {
                System.err.println("Hors tableau !");
            }
        }
        int numColonne = 4;
        while ((numColonne < 0) || (numColonne > 2)) {
            System.out.println("Entrez le numéro de colonne :");
            numColonne = m_scanner.nextInt() - 1;
            if ((numColonne < 0) || (numColonne > 2)) {
                System.err.println("Hors tableau !");
            }
        }

        return new int[]{numLigne, numColonne};
    }

    public void afficherVainqueur(final Joueur joueur) {
        System.out.printf("*************** %s (%s) GAGNE ***************%n", joueur.nom(), joueur.pion());
    }

    public void afficherMatchNul() {
        System.out.printf("*************** EGALITE ***************%n");
    }

    public void afficherStatistiques(final Joueur[] joueurs, final Score score) {
        System.out.printf("%s = %d%n", joueurs[0].nom(), score.getScore(joueurs[0].nom()));
        System.out.printf("%s = %d%n", joueurs[1].nom(), score.getScore(joueurs[1].nom()));
        System.out.printf("Nul = %d%n", score.getNul());
    }

    @Override
    public String toString() {
        return String.format("Saisir{m_scanner=%s}", m_scanner);
    }
}
