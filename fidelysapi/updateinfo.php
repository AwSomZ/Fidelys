<?php
if ($_SERVER['REQUEST_METHOD']=='POST')
{
	include "bd.php";
    $id=$_POST['id'];
	$nom=$_POST['nom'];
    $prenom=$_POST['prenom'];
    $sexe=$_POST['sexe'];
	$datenaiss=$_POST['datenaiss'];
	$sql="UPDATE client SET nom='$nom', prenom='$prenom', sexe='$sexe', datenaiss='$datenaiss' where id='$id'";
	$res=$bd->exec($sql);

}

?>