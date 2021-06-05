<?php
	include'bd.php';
	$cin=$_POST['cin'];
	$query=$bd->prepare("select * from user where id='$cin' ");
	$query->execute();
	if($query->rowCount()>0)
		{
			$q=$bd->prepare("select * from user_verification where user='$cin' ");
			$q->execute();
			$d=$q->fetchAll(PDO::FETCH_ASSOC);
			$token=$d[0]['token'];
			$subject = "Email Verification";
            $message="Le Code Pour Activer Votre Compte Est : $token";
            $headers= "From: noreply@fidelys.tn";
            $headers .="MIME-Version:1.0"."\r\n";
            $headers .="Content-type:text/html;charset=UTF-8"."\r\n";
            mail($to,$subject,$message,$headers);
            $data=$query->fetchAll(PDO::FETCH_ASSOC);
            echo json_encode($data[0]);
		}
?>