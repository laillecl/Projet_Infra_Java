<?php
try
{
	// On se connecte à MySQL
	$bdd = new PDO('mysql:host=localhost;dbname=projet_infra;charset=utf8', 'root', '');
}
catch(Exception $e)
{
	// En cas d'erreur, on affiche un message et on arrête tout
        die('Erreur : '.$e->getMessage());
}
	
	// On récupère tout le contenu de la table utilisateurs
	$reponse = $bdd->query('SELECT * FROM utilisateur');
	$marqueur = 0;

	// On regarde les entrées une à une
	while ($donnees = $reponse->fetch())
	{
		//On regarde si les login et mots de passe sont bons
		if ($donnees['user_name'] == $_POST['login'] and $donnees['password'] == $_POST['motdepasse']){

			// L'utilisateur est connu et peut accéder à l'application des jeux
			//TODO - Lancer l'application des jeux sur le serveur
			//echo exec('java -classpath testappli.jar LanceurJeux.Menu ', $output);
			echo 'ok l utilisateur est connu';
			?>



			<?php

			$marqueur = 1;

		}
	}

	$reponse->closeCursor(); // Termine le traitement de la requête
	
	if($marqueur != 1){
		//Retour à la page de connexion
		$urla = "connexionMiniJeux.html";
		echo "Login ou mot de passe eronné";
		$textea = "<br> retour à la page de connexion";
		echo '<a href = "'.$urla.'">'.$textea.'</a>';
	}

?>