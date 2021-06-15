<?php
	if ($_SERVER['REQUEST_METHOD']=='POST')
	{   
		include "bd.php";
		$id=$_POST['client'];
		$query=$bd->prepare("select * from  billet  where client='$id' order by dateachat desc ");
		$query->execute();
		if ($query->rowCount()>0)
		{
			$data=$query->fetchAll(PDO::FETCH_ASSOC);
			echo json_encode($data);
		}
	}
?>