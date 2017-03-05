
public class TpGr10 {
	public static void main(String[] args) {

		char choix = ' ';
		char sexe = ' ';
		int groupeAge = ' ';
		int saison = ' ';
		int couleur = ' ';
		int totalSexeMasc = 0;
		int totalSexeFem = 0;
		int printempsMasc = 0;
		int eteMasc = 0;
		int automneMasc = 0;
		int hiverMasc = 0;
		int rougeMasc = 0;
		int jauneMasc = 0;
		int bleuMasc = 0;
		int printempsFem = 0;
		int eteFem = 0;
		int automneFem = 0;
		int hiverFem = 0;
		int rougeFem = 0;
		int jauneFem = 0;
		int bleuFem = 0;
		int saisonGru1Pri = 0;
		int saisonGru1Ete = 0;
		int saisonGru1Aut = 0;
		int saisonGru1Hiv = 0;
		int couleurGru1Rou = 0;
		int couleurGru1Jau = 0;
		int couleurGru1Ble = 0;
		int saisonGru2Pri = 0;
		int saisonGru2Ete = 0;
		int saisonGru2Aut = 0;
		int saisonGru2Hiv = 0;
		int couleurGru2Rou = 0;
		int couleurGru2Jau = 0;
		int couleurGru2Ble = 0;
		int saisonGru3Pri = 0;
		int saisonGru3Ete = 0;
		int saisonGru3Aut = 0;
		int saisonGru3Hiv = 0;
		int couleurGru3Rou = 0;
		int couleurGru3Jau = 0;
		int couleurGru3Ble = 0;
		int saisonGru4Pri = 0;
		int saisonGru4Ete = 0;
		int saisonGru4Aut = 0;
		int saisonGru4Hiv = 0;
		int couleurGru4Rou = 0;
		int couleurGru4Jau = 0;
		int couleurGru4Ble = 0;
		int saisonGru5Pri = 0;
		int saisonGru5Ete = 0;
		int saisonGru5Aut = 0;
		int saisonGru5Hiv = 0;
		int couleurGru5Rou = 0;
		int couleurGru5Jau = 0;
		int couleurGru5Ble = 0;

		// message de presentation du logiciel

		System.out.println(" Bonjour! ");
		System.out.println(" Bienvenu(e) a notre programme de collecte de données statistiques ");
		System.out.println(" Le système collecte et calcule le statistique de tout les utilisatuers ");
		System.out.println();

		System.out.print(" Vous désirez entrer des informations aux fins de recherche et de statistique? (O,o,N,n): ");
		choix = Clavier.lireCharLn();

		while ((choix != 'O' && choix != 'o') && (choix != 'N' && choix != 'n')) {
			System.out.println(" Erreur! Choix invalide!");
			System.out.print(" Entrez une options valide (O,o,N,n) : ");
			choix = Clavier.lireCharLn();
		}

		if (choix == 'N' || choix == 'n') {
			System.out.println(" !! Aucunt traitement. Au revoir !! ");
		}

		// boucle principale

		while (choix == 'O' || choix == 'o') {
			System.out.println(" Quel est votre sexe (m,M,f,F)?  ");
			sexe = Clavier.lireCharLn();

			while (sexe != 'M' && sexe != 'm' && sexe != 'F' && sexe != 'f') {
				System.out.println(" Erreur! Choix invalide! ");
				System.out.print(" Entrez une options valide (M,m,F,f) : ");
				sexe = Clavier.lireCharLn();
			}

			if (sexe == 'M' || sexe == 'm') {
				totalSexeMasc = totalSexeMasc + 1;
			} else {
				totalSexeFem = totalSexeFem + 1;
			}

			// choisir le groupe d'age

			System.out.println(" Quel est votre groupe d'age? ");
			System.out.println(" 1 - 5 à 12 ans ");
			System.out.println(" 2 - 13 à 18 ans ");
			System.out.println(" 3 - 19 à 30 ans ");
			System.out.println(" 4 - 31 à 45 ans ");
			System.out.println(" 5 - 46 ans et plus ");
			groupeAge = Clavier.lireInt();
			System.out.println();

			while (groupeAge < 1 || groupeAge > 5) {
				System.out.println(" Erreur! Choix invalide! ");
				System.out.print(" Entrez une options valide (1,2,3,4 ou 5) : ");
				groupeAge = Clavier.lireInt();
			}

			// choisir la saison pefere

			System.out.println(" Quel est votre saison preféree? ");
			System.out.println(" 1 - printemps ");
			System.out.println(" 2 - ete ");
			System.out.println(" 3 - automne ");
			System.out.println(" 4 - hiver ");
			saison = Clavier.lireInt();
			System.out.println();

			while (saison < 1 || saison > 4) {
				System.out.println(" Erreur! Choix invalide! ");
				System.out.print(" Entrez une options valide (1,2,3 ou 4) : ");
				saison = Clavier.lireInt();
			}

			// actualiser les valeurs de la saison par sexe

			if ((sexe == 'M' || sexe == 'm') && saison == 1) {
				printempsMasc = printempsMasc + 1;
			} else if ((sexe == 'M' || sexe == 'm') && saison == 2) {
				eteMasc = eteMasc + 1;
			} else if ((sexe == 'M' || sexe == 'm') && saison == 3) {
				automneMasc = automneMasc + 1;
			} else if ((sexe == 'M' || sexe == 'm') && saison == 4) {
				hiverMasc = hiverMasc + 1;
			}

			if ((sexe == 'F' || sexe == 'f') && saison == 1) {
				printempsFem = printempsFem + 1;
			} else if ((sexe == 'F' || sexe == 'f') && saison == 2) {
				eteFem = eteFem + 1;
			} else if ((sexe == 'F' || sexe == 'f') && saison == 3) {
				automneFem = automneFem + 1;
			} else if ((sexe == 'F' || sexe == 'f') && saison == 4) {
				hiverFem = hiverFem + 1;
			}

			// actualiser les valuers de la saison par groupe'age

			if (groupeAge == 1 && saison == 1) {
				saisonGru1Pri = saisonGru1Pri + 1;
			} else if (groupeAge == 1 && saison == 2) {
				saisonGru1Ete = saisonGru1Ete + 1;
			} else if (groupeAge == 1 && saison == 3) {
				saisonGru1Aut = saisonGru1Aut + 1;
			} else if (groupeAge == 1 && saison == 4) {
				saisonGru1Hiv = saisonGru1Hiv + 1;
			} else if (groupeAge == 2 && saison == 1) {
				saisonGru2Pri = saisonGru2Pri + 1;
			} else if (groupeAge == 2 && saison == 2) {
				saisonGru2Ete = saisonGru2Ete + 1;
			} else if (groupeAge == 2 && saison == 3) {
				saisonGru2Aut = saisonGru2Aut + 1;
			} else if (groupeAge == 2 && saison == 4) {
				saisonGru2Hiv = saisonGru2Hiv + 1;
			} else if (groupeAge == 3 && saison == 1) {
				saisonGru3Pri = saisonGru3Pri + 1;
			} else if (groupeAge == 3 && saison == 2) {
				saisonGru3Ete = saisonGru3Ete + 1;
			} else if (groupeAge == 3 && saison == 3) {
				saisonGru3Aut = saisonGru3Aut + 1;
			} else if (groupeAge == 3 && saison == 4) {
				saisonGru3Hiv = saisonGru3Hiv + 1;
			} else if (groupeAge == 4 && saison == 1) {
				saisonGru4Pri = saisonGru4Pri + 1;
			} else if (groupeAge == 4 && saison == 2) {
				saisonGru4Ete = saisonGru4Ete + 1;
			} else if (groupeAge == 4 && saison == 3) {
				saisonGru4Aut = saisonGru4Aut + 1;
			} else if (groupeAge == 4 && saison == 4) {
				saisonGru4Hiv = saisonGru4Hiv + 1;
			} else if (groupeAge == 5 && saison == 1) {
				saisonGru5Pri = saisonGru5Pri + 1;
			} else if (groupeAge == 5 && saison == 2) {
				saisonGru5Ete = saisonGru5Ete + 1;
			} else if (groupeAge == 5 && saison == 3) {
				saisonGru5Aut = saisonGru5Aut + 1;
			} else if (groupeAge == 5 && saison == 4) {
				saisonGru5Hiv = saisonGru5Hiv + 1;
			}

			// choix de la couleur primaire

			System.out.println(" Quel est votre couleur primaire préférée? ");
			System.out.println(" 1 - rouge ");
			System.out.println(" 2 - jaune ");
			System.out.println(" 3 - bleu ");
			couleur = Clavier.lireIntLn();
			System.out.println();

			while (couleur < 1 || couleur > 3) {
				System.out.println(" Erreur! Choix invalide! ");
				System.out.print(" Entrez une options valide (1,2 ou 3) : ");
				couleur = Clavier.lireInt();
			}

			// actualiser les valuers des couleurs par sexe

			if (sexe == 'M' || sexe == 'm' && couleur == 1) {
				rougeMasc = rougeMasc + 1;
			} else if (sexe == 'M' || sexe == 'm' && couleur == 2) {
				jauneMasc = jauneMasc + 1;
			} else if (sexe == 'M' || sexe == 'm' && couleur == 3) {
				bleuMasc = bleuMasc + 1;
			}

			if ((sexe == 'F' || sexe == 'f') && couleur == 1) {
				rougeFem = rougeFem + 1;
			} else if ((sexe == 'F' || sexe == 'f') && couleur == 2) {
				jauneFem = jauneFem + 1;
			} else if ((sexe == 'F' || sexe == 'f') && couleur == 3) {
				bleuFem = bleuFem + 1;
			}

			// actualiser les valeurs des groupes d'age

			if (groupeAge == 1 && couleur == 1) {
				couleurGru1Rou = couleurGru1Rou + 1;
			} else if (groupeAge == 1 && couleur == 2) {
				couleurGru1Jau = couleurGru1Jau + 1;
			} else if (groupeAge == 1 && couleur == 3) {
				couleurGru1Ble = couleurGru1Ble + 1;
			} else if (groupeAge == 2 && couleur == 1) {
				couleurGru2Rou = couleurGru2Rou + 1;
			} else if (groupeAge == 2 && couleur == 2) {
				couleurGru2Jau = couleurGru2Jau + 1;
			} else if (groupeAge == 2 && couleur == 3) {
				couleurGru2Ble = couleurGru2Ble + 1;
			} else if (groupeAge == 3 && couleur == 1) {
				couleurGru3Rou = couleurGru3Rou + 1;
			} else if (groupeAge == 3 && couleur == 2) {
				couleurGru3Jau = couleurGru3Jau + 1;
			} else if (groupeAge == 3 && couleur == 3) {
				couleurGru3Ble = couleurGru3Ble + 1;
			} else if (groupeAge == 4 && couleur == 1) {
				couleurGru4Rou = couleurGru4Rou + 1;
			} else if (groupeAge == 4 && couleur == 2) {
				couleurGru4Jau = couleurGru4Jau + 1;
			} else if (groupeAge == 4 && couleur == 3) {
				couleurGru4Ble = couleurGru4Ble + 1;
			} else if (groupeAge == 5 && couleur == 1) {
				couleurGru5Rou = couleurGru5Rou + 1;
			} else if (groupeAge == 5 && couleur == 2) {
				couleurGru5Jau = couleurGru5Jau + 1;
			} else if (groupeAge == 5 && couleur == 3) {
				couleurGru5Ble = couleurGru5Ble + 1;
			}

			// option pour saisir la sondage a nouveau

			System.out.println(
					" Vous désirez entrer des informations aux fins de recherche et de statistique? (O,o,N,n): ");
			choix = Clavier.lireCharLn();

			while (choix != 'O' && choix != 'o' && choix != 'N' && choix != 'n') {
				System.out.println(" Erreur! Choix invalide! ");
				System.out.print(" Entrez une options valide (O,o,N,n) : ");
				choix = Clavier.lireCharLn();
			}

			if (choix == 'N' || choix == 'n') {

				// affichage des statistiques

				System.out.println("STATISTIQUES");
				System.out.println("Total répondants : " + (totalSexeMasc + totalSexeFem));
				System.out.println("Total hommes : " + totalSexeMasc);
				System.out.println("Total femmes : " + totalSexeFem + "\n\n");

				System.out.print("Appuyez sur ENTER pour continuer : ");
				Clavier.lireFinLigne();

				System.out.print("SAISONS");
				System.out.println();
				System.out.print("PRINTEMPS");
				System.out.println();
				int total = printempsMasc + printempsFem;

				if(total != 0){
					System.out.println("Pourcentage hommes : " + (printempsMasc / (total)) * 100 + " %");
					System.out.println("Pourcentage femmes : " + (printempsFem / (total)) * 100 + " %");
				}	else{
					System.out.println("Pourcentage hommes : 0% ");
					System.out.println("Pourcentage femmes : 0% ");
				}
				
				System.out.println();
				System.out.print("ETE");
				System.out.println();
				if (eteMasc == 0) {
					System.out.println("Pourcentage hommes : 0% ");
				} else {
					System.out.println("Pourcentage hommes :" + (eteMasc / (eteMasc + eteFem)) * 100 + " %");
				}

				if (eteFem == 0) {
					System.out.println("Pourcentage femmes : 0% ");
				} else {
					System.out.println("Pourcentage femmes :" + (eteFem / (eteMasc + eteFem)) * 100 + " %");
				}
				System.out.println();
				System.out.print("AUTOMNE");
				System.out.println();
				if (automneMasc == 0) {
					System.out.println("Pourcentage hommes : 0% ");
				} else {
					System.out
							.println("Pourcentage hommes : " + (automneMasc / (automneMasc + automneFem)) * 100 + " %");
				}

				if (automneFem == 0) {
					System.out.println("Pourcentage femmes : 0% ");
				} else {
					System.out
							.println("Pourcentage femmes : " + (automneFem / (automneMasc + automneFem)) * 100 + " %");
				}
				System.out.println();
				System.out.print("Hiver");
				System.out.println();
				if (hiverMasc == 0) {
					System.out.println("Pourcentage hommes : 0% ");
				} else {
					System.out.println("Pourcentage hommes : " + (hiverMasc / (hiverMasc + hiverFem)) * 100 + " %");
				}

				if (hiverFem == 0) {
					System.out.println("Pourcentage femmes : 0% ");
				} else {
					System.out.println("Pourcentage femmes : " + (hiverFem / (hiverMasc + hiverFem)) * 100 + " %");
				}
				System.out.println();
				System.out.println();

				System.out.print("Appuyez sur ENTER pour continuer : ");
				Clavier.lireFinLigne();

				System.out.print("COULEUR");
				System.out.println();
				System.out.print("ROUGE");
				System.out.println();
				if (rougeMasc == 0) {
					System.out.println("Pourcentage hommes : 0% ");
				} else {
					System.out.println("Pourcentage hommes :" + (rougeMasc / (rougeMasc + rougeFem)) * 100 + " %");
				}

				if (rougeFem == 0) {
					System.out.println("Pourcentage femmes : 0% ");
				} else {
					System.out.println("Pourcentage femmes :" + (rougeFem / (rougeMasc + rougeFem)) * 100 + " %");
				}
				System.out.println();
				System.out.print("JAUNE");
				System.out.println();
				if (jauneMasc == 0) {
					System.out.println("Pourcentage hommes : 0% ");
				} else {
					System.out.print("Pourcentage hommes : " + (jauneMasc / (jauneMasc + jauneFem)) * 100 + " %");
				}

				if (jauneFem == 0) {
					System.out.println("Pourcentage femmes : 0% ");
				} else {
					System.out.print("Pourcentage femmes : " + (jauneFem / (jauneMasc + jauneFem)) * 100 + " %");
				}
				System.out.println();
				System.out.print("BLEU");
				System.out.println();
				if (bleuMasc == 0) {
					System.out.println("Pourcentage hommes : 0% ");
				} else {
					System.out.print("Pourcentage hommes : " + (bleuMasc / (bleuMasc + bleuFem)) * 100 + " %");
				}

				if (bleuFem == 0) {
					System.out.println("Pourcentage femmes : 0% ");
				} else {
					System.out.print("Pourcentage femmes : " + (bleuFem / (bleuMasc + bleuFem) * 100 + " %"));
				}
				System.out.println();
				System.out.println();

				System.out.print("Appuyez sur ENTER pour continuer : ");
				Clavier.lireFinLigne();
				System.out.print("GROUPE D'AGE 1");
				System.out.println();
				total = saisonGru1Pri + saisonGru1Ete + saisonGru1Aut + saisonGru1Hiv;
				int r  = 0;
				System.out.println();

				if (total != 0) {
					r = saisonGru1Pri / total;
				}
				System.out.println("Printemps : " + (r) * 100 + " %");
				System.out.println("Ete : " + (r) * 100 + " %");
				System.out.println("Automne : " + (r) * 100 + " %");
				System.out.println("Hiver : " + (r) * 100 + " %");
				
				System.out.println();

				System.out.print("Appuyez sur ENTER pour continuer : ");
				Clavier.lireFinLigne();
				System.out.print("GROUPE D'AGE 2");
				System.out.println();
				total = saisonGru2Pri + saisonGru2Ete + saisonGru2Aut + saisonGru2Hiv;
				r  = 0;
				System.out.println();

				if (total != 0) {
					r = saisonGru1Pri / total;
				}
				System.out.println("Printemps : " + (r) * 100 + " %");
				System.out.println("Ete : " + (r) * 100 + " %");
				System.out.println("Automne : " + (r) * 100 + " %");
				System.out.println("Hiver : " + (r) * 100 + " %");

				System.out.println();

				System.out.print("Appuyez sur ENTER pour continuer : ");
				Clavier.lireFinLigne();
				System.out.print("GROUPE D'AGE 3");
				System.out.println();
				total = saisonGru3Pri + saisonGru3Ete + saisonGru3Aut + saisonGru3Hiv;
				r  = 0;
				System.out.println();

				if (total != 0) {
					r = saisonGru1Pri / total;
				}
				System.out.println("Printemps : " + (r) * 100 + " %");
				System.out.println("Ete : " + (r) * 100 + " %");
				System.out.println("Automne : " + (r) * 100 + " %");
				System.out.println("Hiver : " + (r) * 100 + " %");

				System.out.println();

				System.out.print("Appuyez sur ENTER pour continuer : ");
				Clavier.lireFinLigne();
				System.out.print("GROUPE D'AGE 4");
				System.out.println();
				total = saisonGru4Pri + saisonGru4Ete + saisonGru4Aut + saisonGru4Hiv;
				r  = 0;
				System.out.println();

				if (total != 0) {
					r = saisonGru1Pri / total;
				}
				System.out.println("Printemps : " + (r) * 100 + " %");
				System.out.println("Ete : " + (r) * 100 + " %");
				System.out.println("Automne : " + (r) * 100 + " %");
				System.out.println("Hiver : " + (r) * 100 + " %");

				System.out.println();

				
				System.out.print("Appuyez sur ENTER pour continuer : ");
				Clavier.lireFinLigne();
				System.out.print("GROUPE D'AGE 5");
				System.out.println();
				total = saisonGru5Pri + saisonGru5Ete + saisonGru5Aut + saisonGru5Hiv;
				r  = 0;
				System.out.println();

				if (total != 0) {
					r = saisonGru1Pri / total;
				}
				System.out.println("Printemps : " + (r) * 100 + " %");
				System.out.println("Ete : " + (r) * 100 + " %");
				System.out.println("Automne : " + (r) * 100 + " %");
				System.out.println("Hiver : " + (r) * 100 + " %");

				System.out.println();
			}

		}
		System.out.println("EOF");
	}
}// TpGr10