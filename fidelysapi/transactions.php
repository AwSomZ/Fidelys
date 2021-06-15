<?php
	if ($_SERVER['REQUEST_METHOD']=='POST')
	{   
		include "bd.php";
		$id=$_POST['client'];
		$query=$bd->prepare("select * from  transaction  where client='$id' order by  date desc ");
		$query->execute();
		if ($query->rowCount()>0)
		{
			$data=$query->fetchAll(PDO::FETCH_ASSOC);
			echo json_encode($data);
		}
	}
?>