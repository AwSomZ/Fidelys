<?php

	include "bd.php";
 	$id=$_POST['client'];

$query=$bd->prepare("select * from  mouvement   where client='$id' ");
$query->execute();
if ($query->rowCount()>0)
{
	$data=$query->fetchAll(PDO::FETCH_ASSOC);
	echo json_encode($data[0]);
}



?>