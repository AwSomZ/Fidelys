<?php

	include "bd.php";
 	$id=$_POST['client'];

$query=$bd->prepare("select * from  reclamation  where client='$id' and etat='resolu' order by datecreation desc ");
$query->execute();
if ($query->rowCount()>0)
{
	$data=$query->fetchAll(PDO::FETCH_ASSOC);
	echo json_encode($data);
}



?>