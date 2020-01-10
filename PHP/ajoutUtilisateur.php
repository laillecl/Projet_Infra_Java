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
	
	// On ajoute une entrée dans la table utilisateurs
	$mdpChiffre = password_hash($_POST['motdepasse'], PASSWORD_DEFAULT); 
	$req = $bdd->prepare('INSERT INTO utilisateur(user_name, password, email, score) VALUES(?, ?, ?, ?)');
	$req->execute(array($_POST['login'], $mdpChiffre,  $_POST['email'], 0));	
	
	echo "succeed";
?> 