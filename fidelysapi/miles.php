<?php

include "bd.php";
$id=$_POST['client'];
$type=$_POST['type'];
$quantite=(int)$_POST['quantite'];
$today=date("Y-m-d");

if ($type=='prime')
	{
 		$update = "UPDATE mouvement set milesprime=milesprime+'$quantite' where client='$id' "; 
		$res=$bd->exec($update);  
	}
else if ($type=='statut')
	{
 		$update = "UPDATE mouvement set milesstatut=milesstatut+'$quantite' where client='$id' "; 
		$res=$bd->exec($update);  
	}
$transition = "insert into transaction (`credit`,`client`,`date`) values ('$quantite','$id','$today');";
$re=$bd->exec($transition); 
?>