<?php
	include "bd.php";
	$id=$_POST['id'];
	$pin=$_POST['pin'];
	$query=$bd->prepare("select * from client where id='$id' and pin='$pin';");
	$query->execute();
	if($query->rowCount()>0)
		{
			$data=$query->fetchAll(PDO::FETCH_ASSOC);
			$date = $data[0]['datenaiss'];
			$q=$bd->prepare("select * from mouvement where client='$id' ;");
			$q->execute();
			if($q->rowCount()>0)
				{
					$datas=$q->fetchAll(PDO::FETCH_ASSOC);
					$plafond = $datas[0]['plafond'];
				}
			$age= date_diff(date_create('today'),date_create($date))->y;
			if ($age>24)
				{
					if($plafond==13000)
						{
							$plafond=15000;	
						} 
					else if ($plafond==25000)
						{
							$plafond=30000;	
						}
				}

			else 
				{
					if($plafond==15000)
						{
							$plafond=13000;	
						} 
					else if ($plafond==30000)
						{
							$plafond=25000;	
						}
				}
			$update = "UPDATE mouvement set plafond='$plafond' where client='$id' "; 
			$res=$bd->exec($update); 
			echo json_encode($data[0]);
		}
?>