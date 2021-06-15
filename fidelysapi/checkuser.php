<?php
	if ($_SERVER['REQUEST_METHOD']=='POST')
	{   
		include "bd.php";
		$cin=$_POST['cin'];
		$query=$bd->prepare("select * from user where id='$cin' ");
		$query->execute();
		if($query->rowCount()>0)
		{
			$data=$query->fetchAll(PDO::FETCH_ASSOC);
			$q=$bd->prepare("select * from user_verification where user='$cin' ");
			$q->execute();
			$d=$q->fetchAll(PDO::FETCH_ASSOC);
			$to=$data[0]['email'];
			$token=$d[0]['token'];
			$subject = "Email Verification";
			$message="Le Code Pour Activer Votre Compte Est : $token";
			$headers= "From: noreply@fidelys.tn";
			$headers .="MIME-Version:1.0"."\r\n";
			$headers .="Content-type:text/html;charset=UTF-8"."\r\n";
			mail($to,$subject,$message,$headers);
			echo json_encode($data[0]);
		}
	}
?>