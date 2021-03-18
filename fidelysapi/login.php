<?php

	include'bd.php';
	$id=$_POST['id'];
	$pin=$_POST['pin'];
	
$query=$bd->prepare("select * from client where id='$id' and pin='$pin';");
$query->execute();

if($query->rowCount()>0)
{
            $data=$query->fetchAll(PDO::FETCH_ASSOC);
            
            echo json_encode($data[0]);
}
	

	


?>