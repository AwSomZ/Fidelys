<?php
//pour la connection
$servername="localhost";
$dbname="fidelys";
$username="root";
$password="";

try{
	$bd= new PDO("mysql:host=$servername;dbname=$dbname",$username,$password);
}
catch(PDOexeption $e)
{
	echo "not connected" +$e->getMessage();
	die();
}
?>

