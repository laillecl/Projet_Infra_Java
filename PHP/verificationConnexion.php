<?php


	
	// Connexion, sélection de la base de données - POSTGRESQL
	//$bdd = new PDO('mysql:host=localhost;dbname=projet_infra;charset=utf8', 'root', '');

	// Connexion, sélection de la base de données - MYSQL
	$bdd = new PDO('mysql:host=localhost;dbname=projet_infra;charset=utf8', 'root', '');

	// On récupère tout le contenu de la table utilisateurs
	$reponse = $bdd->query('SELECT * FROM utilisateur');
	$marqueur = 0;

	// On regarde les entrées une à une
	while ($donnees = $reponse->fetch())
	{
		//On regarde si les login et mots de passe sont bons
		if ($donnees['user_name'] == $_POST['login'] and password_verify($_POST['motdepasse'], $donnees['password'])){
			// L'utilisateur est connu et peut accéder à l'application des jeux
			$compt = 1;
			echo ('Votre score est actuellement de ' . $donnees['score'] );

			//TODO - Bouton
			$urla = "telechargement.php";
			$textea = "<br> Telechargement de l'application";
			echo '<a href = "'.$urla.'">'.$textea.'</a>';

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